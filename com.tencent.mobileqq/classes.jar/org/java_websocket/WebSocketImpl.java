package org.java_websocket;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.ByteChannel;
import java.nio.channels.SelectionKey;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;
import org.java_websocket.drafts.Draft;
import org.java_websocket.drafts.Draft_6455;
import org.java_websocket.enums.CloseHandshakeType;
import org.java_websocket.enums.HandshakeState;
import org.java_websocket.enums.Opcode;
import org.java_websocket.enums.ReadyState;
import org.java_websocket.enums.Role;
import org.java_websocket.exceptions.IncompleteHandshakeException;
import org.java_websocket.exceptions.InvalidDataException;
import org.java_websocket.exceptions.InvalidHandshakeException;
import org.java_websocket.exceptions.LimitExceededException;
import org.java_websocket.exceptions.WebsocketNotConnectedException;
import org.java_websocket.framing.CloseFrame;
import org.java_websocket.framing.Framedata;
import org.java_websocket.framing.PingFrame;
import org.java_websocket.handshake.ClientHandshake;
import org.java_websocket.handshake.ClientHandshakeBuilder;
import org.java_websocket.handshake.Handshakedata;
import org.java_websocket.handshake.ServerHandshake;
import org.java_websocket.handshake.ServerHandshakeBuilder;
import org.java_websocket.server.WebSocketServer.WebSocketWorker;
import org.java_websocket.util.Charsetfunctions;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class WebSocketImpl
  implements WebSocket
{
  public static final int DEFAULT_PORT = 80;
  public static final int DEFAULT_WSS_PORT = 443;
  public static final int RCVBUF = 16384;
  private static final Logger log = LoggerFactory.getLogger(WebSocketImpl.class);
  private Object attachment;
  private ByteChannel channel;
  private Integer closecode = null;
  private Boolean closedremotely = null;
  private String closemessage = null;
  private Draft draft = null;
  private boolean flushandclosestate = false;
  private ClientHandshake handshakerequest = null;
  public final BlockingQueue<ByteBuffer> inQueue;
  private SelectionKey key;
  private List<Draft> knownDrafts;
  private long lastPong = System.currentTimeMillis();
  public final BlockingQueue<ByteBuffer> outQueue;
  private PingFrame pingFrame;
  private volatile ReadyState readyState = ReadyState.NOT_YET_CONNECTED;
  private String resourceDescriptor = null;
  private Role role;
  private final Object synchronizeWriteObject = new Object();
  private ByteBuffer tmpHandshakeBytes = ByteBuffer.allocate(0);
  private WebSocketServer.WebSocketWorker workerThread;
  private final WebSocketListener wsl;
  
  public WebSocketImpl(WebSocketListener paramWebSocketListener, List<Draft> paramList)
  {
    this(paramWebSocketListener, (Draft)null);
    this.role = Role.SERVER;
    if ((paramList != null) && (!paramList.isEmpty()))
    {
      this.knownDrafts = paramList;
      return;
    }
    this.knownDrafts = new ArrayList();
    this.knownDrafts.add(new Draft_6455());
  }
  
  public WebSocketImpl(WebSocketListener paramWebSocketListener, Draft paramDraft)
  {
    if ((paramWebSocketListener != null) && ((paramDraft != null) || (this.role != Role.SERVER)))
    {
      this.outQueue = new LinkedBlockingQueue();
      this.inQueue = new LinkedBlockingQueue();
      this.wsl = paramWebSocketListener;
      this.role = Role.CLIENT;
      if (paramDraft != null) {
        this.draft = paramDraft.copyInstance();
      }
      return;
    }
    throw new IllegalArgumentException("parameters must not be null");
  }
  
  private void closeConnectionDueToInternalServerError(RuntimeException paramRuntimeException)
  {
    write(generateHttpResponseDueToError(500));
    flushAndClose(-1, paramRuntimeException.getMessage(), false);
  }
  
  private void closeConnectionDueToWrongHandshake(InvalidDataException paramInvalidDataException)
  {
    write(generateHttpResponseDueToError(404));
    flushAndClose(paramInvalidDataException.getCloseCode(), paramInvalidDataException.getMessage(), false);
  }
  
  private void decodeFrames(ByteBuffer paramByteBuffer)
  {
    try
    {
      paramByteBuffer = this.draft.translateFrame(paramByteBuffer).iterator();
      while (paramByteBuffer.hasNext())
      {
        Framedata localFramedata = (Framedata)paramByteBuffer.next();
        log.trace("matched frame: {}", localFramedata);
        this.draft.processFrame(this, localFramedata);
      }
      return;
    }
    catch (InvalidDataException paramByteBuffer)
    {
      log.error("Closing due to invalid data in frame", paramByteBuffer);
      this.wsl.onWebsocketError(this, paramByteBuffer);
      close(paramByteBuffer);
      return;
    }
    catch (LimitExceededException paramByteBuffer)
    {
      if (paramByteBuffer.getLimit() == 2147483647)
      {
        log.error("Closing due to invalid size of frame", paramByteBuffer);
        this.wsl.onWebsocketError(this, paramByteBuffer);
      }
      close(paramByteBuffer);
    }
  }
  
  private boolean decodeHandshake(ByteBuffer paramByteBuffer)
  {
    ByteBuffer localByteBuffer;
    if (this.tmpHandshakeBytes.capacity() == 0)
    {
      localByteBuffer = paramByteBuffer;
    }
    else
    {
      if (this.tmpHandshakeBytes.remaining() < paramByteBuffer.remaining())
      {
        localByteBuffer = ByteBuffer.allocate(this.tmpHandshakeBytes.capacity() + paramByteBuffer.remaining());
        this.tmpHandshakeBytes.flip();
        localByteBuffer.put(this.tmpHandshakeBytes);
        this.tmpHandshakeBytes = localByteBuffer;
      }
      this.tmpHandshakeBytes.put(paramByteBuffer);
      this.tmpHandshakeBytes.flip();
      localByteBuffer = this.tmpHandshakeBytes;
    }
    localByteBuffer.mark();
    for (;;)
    {
      try
      {
        localObject1 = this.role;
        localObject2 = Role.SERVER;
        if (localObject1 == localObject2) {
          if (this.draft == null)
          {
            localObject1 = this.knownDrafts.iterator();
            if (((Iterator)localObject1).hasNext()) {
              localObject2 = ((Draft)((Iterator)localObject1).next()).copyInstance();
            }
          }
        }
      }
      catch (IncompleteHandshakeException localIncompleteHandshakeException) {}catch (InvalidHandshakeException localInvalidHandshakeException1)
      {
        Object localObject1;
        Object localObject2;
        Object localObject3;
        HandshakeState localHandshakeState;
        StringBuilder localStringBuilder;
        log.trace("Closing due to invalid handshake", localInvalidHandshakeException1);
        close(localInvalidHandshakeException1);
        return false;
      }
      try
      {
        ((Draft)localObject2).setParseMode(this.role);
        localByteBuffer.reset();
        localObject3 = ((Draft)localObject2).translateHandshake(localByteBuffer);
        if (!(localObject3 instanceof ClientHandshake))
        {
          log.trace("Closing due to wrong handshake");
          closeConnectionDueToWrongHandshake(new InvalidDataException(1002, "wrong http function"));
          return false;
        }
        localObject3 = (ClientHandshake)localObject3;
        if (((Draft)localObject2).acceptHandshakeAsServer((ClientHandshake)localObject3) != HandshakeState.MATCHED) {
          continue;
        }
        this.resourceDescriptor = ((ClientHandshake)localObject3).getResourceDescriptor();
        try
        {
          ServerHandshakeBuilder localServerHandshakeBuilder = this.wsl.onWebsocketHandshakeReceivedAsServer(this, (Draft)localObject2, (ClientHandshake)localObject3);
          write(((Draft)localObject2).createHandshake(((Draft)localObject2).postProcessHandshakeResponseAsServer((ClientHandshake)localObject3, localServerHandshakeBuilder)));
          this.draft = ((Draft)localObject2);
          open((Handshakedata)localObject3);
          return true;
        }
        catch (RuntimeException localRuntimeException2)
        {
          log.error("Closing due to internal server error", localRuntimeException2);
          this.wsl.onWebsocketError(this, localRuntimeException2);
          closeConnectionDueToInternalServerError(localRuntimeException2);
          return false;
        }
        catch (InvalidDataException localInvalidDataException2)
        {
          log.trace("Closing due to wrong handshake. Possible handshake rejection", localInvalidDataException2);
          closeConnectionDueToWrongHandshake(localInvalidDataException2);
          return false;
        }
        if (this.draft != null) {
          break;
        }
        log.trace("Closing due to protocol error: no draft matches");
        closeConnectionDueToWrongHandshake(new InvalidDataException(1002, "no draft matches"));
        return false;
      }
      catch (InvalidHandshakeException localInvalidHandshakeException2) {}
      localObject1 = this.draft.translateHandshake(localByteBuffer);
      if (!(localObject1 instanceof ClientHandshake))
      {
        log.trace("Closing due to protocol error: wrong http function");
        flushAndClose(1002, "wrong http function", false);
        return false;
      }
      localObject1 = (ClientHandshake)localObject1;
      if (this.draft.acceptHandshakeAsServer((ClientHandshake)localObject1) == HandshakeState.MATCHED)
      {
        open((Handshakedata)localObject1);
        return true;
      }
      log.trace("Closing due to protocol error: the handshake did finally not match");
      close(1002, "the handshake did finally not match");
      return false;
      if (this.role == Role.CLIENT)
      {
        this.draft.setParseMode(this.role);
        localObject1 = this.draft.translateHandshake(localByteBuffer);
        if (!(localObject1 instanceof ServerHandshake))
        {
          log.trace("Closing due to protocol error: wrong http function");
          flushAndClose(1002, "wrong http function", false);
          return false;
        }
        localObject1 = (ServerHandshake)localObject1;
        localHandshakeState = this.draft.acceptHandshakeAsClient(this.handshakerequest, (ServerHandshake)localObject1);
        localObject3 = HandshakeState.MATCHED;
        if (localHandshakeState == localObject3) {
          try
          {
            this.wsl.onWebsocketHandshakeReceivedAsClient(this, this.handshakerequest, (ServerHandshake)localObject1);
            open((Handshakedata)localObject1);
            return true;
          }
          catch (RuntimeException localRuntimeException1)
          {
            log.error("Closing since client was never connected", localRuntimeException1);
            this.wsl.onWebsocketError(this, localRuntimeException1);
            flushAndClose(-1, localRuntimeException1.getMessage(), false);
            return false;
          }
          catch (InvalidDataException localInvalidDataException1)
          {
            log.trace("Closing due to invalid data exception. Possible handshake rejection", localInvalidDataException1);
            flushAndClose(localInvalidDataException1.getCloseCode(), localInvalidDataException1.getMessage(), false);
            return false;
          }
        }
        log.trace("Closing due to protocol error: draft {} refuses handshake", this.draft);
        localStringBuilder = new StringBuilder();
        localStringBuilder.append("draft ");
        localStringBuilder.append(this.draft);
        localStringBuilder.append(" refuses handshake");
        close(1002, localStringBuilder.toString());
        return false;
        if (this.tmpHandshakeBytes.capacity() == 0)
        {
          localByteBuffer.reset();
          int j = localInvalidHandshakeException1.getPreferredSize();
          int i = j;
          if (j == 0) {
            i = localByteBuffer.capacity() + 16;
          }
          this.tmpHandshakeBytes = ByteBuffer.allocate(i);
          this.tmpHandshakeBytes.put(paramByteBuffer);
          return false;
        }
        paramByteBuffer = this.tmpHandshakeBytes;
        paramByteBuffer.position(paramByteBuffer.limit());
        paramByteBuffer = this.tmpHandshakeBytes;
        paramByteBuffer.limit(paramByteBuffer.capacity());
      }
      return false;
    }
    return false;
  }
  
  private ByteBuffer generateHttpResponseDueToError(int paramInt)
  {
    String str;
    if (paramInt != 404) {
      str = "500 Internal Server Error";
    } else {
      str = "404 WebSocket Upgrade Failure";
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("HTTP/1.1 ");
    localStringBuilder.append(str);
    localStringBuilder.append("\r\nContent-Type: text/html\nServer: TooTallNate Java-WebSocket\r\nContent-Length: ");
    localStringBuilder.append(str.length() + 48);
    localStringBuilder.append("\r\n\r\n<html><head></head><body><h1>");
    localStringBuilder.append(str);
    localStringBuilder.append("</h1></body></html>");
    return ByteBuffer.wrap(Charsetfunctions.asciiBytes(localStringBuilder.toString()));
  }
  
  private void open(Handshakedata paramHandshakedata)
  {
    log.trace("open using draft: {}", this.draft);
    this.readyState = ReadyState.OPEN;
    try
    {
      this.wsl.onWebsocketOpen(this, paramHandshakedata);
      return;
    }
    catch (RuntimeException paramHandshakedata)
    {
      this.wsl.onWebsocketError(this, paramHandshakedata);
    }
  }
  
  private void send(Collection<Framedata> paramCollection)
  {
    if (isOpen())
    {
      if (paramCollection != null)
      {
        ArrayList localArrayList = new ArrayList();
        paramCollection = paramCollection.iterator();
        while (paramCollection.hasNext())
        {
          Framedata localFramedata = (Framedata)paramCollection.next();
          log.trace("send frame: {}", localFramedata);
          localArrayList.add(this.draft.createBinaryFrame(localFramedata));
        }
        write(localArrayList);
        return;
      }
      throw new IllegalArgumentException();
    }
    paramCollection = new WebsocketNotConnectedException();
    for (;;)
    {
      throw paramCollection;
    }
  }
  
  private void write(ByteBuffer paramByteBuffer)
  {
    Logger localLogger = log;
    int i = paramByteBuffer.remaining();
    String str;
    if (paramByteBuffer.remaining() > 1000) {
      str = "too big to display";
    } else {
      str = new String(paramByteBuffer.array());
    }
    localLogger.trace("write({}): {}", Integer.valueOf(i), str);
    this.outQueue.add(paramByteBuffer);
    this.wsl.onWriteDemand(this);
  }
  
  private void write(List<ByteBuffer> paramList)
  {
    synchronized (this.synchronizeWriteObject)
    {
      paramList = paramList.iterator();
      while (paramList.hasNext()) {
        write((ByteBuffer)paramList.next());
      }
      return;
    }
    for (;;)
    {
      throw paramList;
    }
  }
  
  public void close()
  {
    close(1000);
  }
  
  public void close(int paramInt)
  {
    close(paramInt, "", false);
  }
  
  public void close(int paramInt, String paramString)
  {
    close(paramInt, paramString, false);
  }
  
  public void close(int paramInt, String paramString, boolean paramBoolean)
  {
    try
    {
      if ((this.readyState != ReadyState.CLOSING) && (this.readyState != ReadyState.CLOSED))
      {
        if (this.readyState == ReadyState.OPEN)
        {
          if (paramInt == 1006)
          {
            this.readyState = ReadyState.CLOSING;
            flushAndClose(paramInt, paramString, false);
            return;
          }
          CloseHandshakeType localCloseHandshakeType1 = this.draft.getCloseHandshakeType();
          CloseHandshakeType localCloseHandshakeType2 = CloseHandshakeType.NONE;
          if (localCloseHandshakeType1 != localCloseHandshakeType2)
          {
            if (!paramBoolean) {}
            try
            {
              try
              {
                this.wsl.onWebsocketCloseInitiated(this, paramInt, paramString);
              }
              catch (RuntimeException localRuntimeException)
              {
                this.wsl.onWebsocketError(this, localRuntimeException);
              }
              if (isOpen())
              {
                CloseFrame localCloseFrame = new CloseFrame();
                localCloseFrame.setReason(paramString);
                localCloseFrame.setCode(paramInt);
                localCloseFrame.isValid();
                sendFrame(localCloseFrame);
              }
            }
            catch (InvalidDataException localInvalidDataException)
            {
              log.error("generated frame is invalid", localInvalidDataException);
              this.wsl.onWebsocketError(this, localInvalidDataException);
              flushAndClose(1006, "generated frame is invalid", false);
            }
          }
          flushAndClose(paramInt, paramString, paramBoolean);
        }
        else if (paramInt == -3)
        {
          flushAndClose(-3, paramString, true);
        }
        else if (paramInt == 1002)
        {
          flushAndClose(paramInt, paramString, paramBoolean);
        }
        else
        {
          flushAndClose(-1, paramString, false);
        }
        this.readyState = ReadyState.CLOSING;
        this.tmpHandshakeBytes = null;
        return;
      }
      return;
    }
    finally {}
  }
  
  public void close(InvalidDataException paramInvalidDataException)
  {
    close(paramInvalidDataException.getCloseCode(), paramInvalidDataException.getMessage(), false);
  }
  
  public void closeConnection()
  {
    if (this.closedremotely != null)
    {
      closeConnection(this.closecode.intValue(), this.closemessage, this.closedremotely.booleanValue());
      return;
    }
    throw new IllegalStateException("this method must be used in conjunction with flushAndClose");
  }
  
  public void closeConnection(int paramInt, String paramString)
  {
    closeConnection(paramInt, paramString, false);
  }
  
  public void closeConnection(int paramInt, String paramString, boolean paramBoolean)
  {
    try
    {
      Object localObject = this.readyState;
      ReadyState localReadyState = ReadyState.CLOSED;
      if (localObject == localReadyState) {
        return;
      }
      if ((this.readyState == ReadyState.OPEN) && (paramInt == 1006)) {
        this.readyState = ReadyState.CLOSING;
      }
      if (this.key != null) {
        this.key.cancel();
      }
      localObject = this.channel;
      if (localObject != null) {
        try
        {
          this.channel.close();
        }
        catch (IOException localIOException)
        {
          if (localIOException.getMessage().equals("Broken pipe"))
          {
            log.trace("Caught IOException: Broken pipe during closeConnection()", localIOException);
          }
          else
          {
            log.error("Exception during channel.close()", localIOException);
            this.wsl.onWebsocketError(this, localIOException);
          }
        }
      }
      try
      {
        this.wsl.onWebsocketClose(this, paramInt, paramString, paramBoolean);
      }
      catch (RuntimeException paramString)
      {
        this.wsl.onWebsocketError(this, paramString);
      }
      if (this.draft != null) {
        this.draft.reset();
      }
      this.handshakerequest = null;
      this.readyState = ReadyState.CLOSED;
      return;
    }
    finally {}
  }
  
  protected void closeConnection(int paramInt, boolean paramBoolean)
  {
    closeConnection(paramInt, "", paramBoolean);
  }
  
  public void decode(ByteBuffer paramByteBuffer)
  {
    Logger localLogger = log;
    int i = paramByteBuffer.remaining();
    String str;
    if (paramByteBuffer.remaining() > 1000) {
      str = "too big to display";
    } else {
      str = new String(paramByteBuffer.array(), paramByteBuffer.position(), paramByteBuffer.remaining());
    }
    localLogger.trace("process({}): ({})", Integer.valueOf(i), str);
    if (this.readyState != ReadyState.NOT_YET_CONNECTED)
    {
      if (this.readyState == ReadyState.OPEN) {
        decodeFrames(paramByteBuffer);
      }
    }
    else if ((decodeHandshake(paramByteBuffer)) && (!isClosing()) && (!isClosed()))
    {
      if (paramByteBuffer.hasRemaining())
      {
        decodeFrames(paramByteBuffer);
        return;
      }
      if (this.tmpHandshakeBytes.hasRemaining()) {
        decodeFrames(this.tmpHandshakeBytes);
      }
    }
  }
  
  public void eot()
  {
    if (this.readyState == ReadyState.NOT_YET_CONNECTED)
    {
      closeConnection(-1, true);
      return;
    }
    if (this.flushandclosestate)
    {
      closeConnection(this.closecode.intValue(), this.closemessage, this.closedremotely.booleanValue());
      return;
    }
    if (this.draft.getCloseHandshakeType() == CloseHandshakeType.NONE)
    {
      closeConnection(1000, true);
      return;
    }
    if (this.draft.getCloseHandshakeType() == CloseHandshakeType.ONEWAY)
    {
      if (this.role == Role.SERVER)
      {
        closeConnection(1006, true);
        return;
      }
      closeConnection(1000, true);
      return;
    }
    closeConnection(1006, true);
  }
  
  public void flushAndClose(int paramInt, String paramString, boolean paramBoolean)
  {
    try
    {
      boolean bool = this.flushandclosestate;
      if (bool) {
        return;
      }
      this.closecode = Integer.valueOf(paramInt);
      this.closemessage = paramString;
      this.closedremotely = Boolean.valueOf(paramBoolean);
      this.flushandclosestate = true;
      this.wsl.onWriteDemand(this);
      try
      {
        this.wsl.onWebsocketClosing(this, paramInt, paramString, paramBoolean);
      }
      catch (RuntimeException paramString)
      {
        log.error("Exception in onWebsocketClosing", paramString);
        this.wsl.onWebsocketError(this, paramString);
      }
      if (this.draft != null) {
        this.draft.reset();
      }
      this.handshakerequest = null;
      return;
    }
    finally {}
  }
  
  public <T> T getAttachment()
  {
    return this.attachment;
  }
  
  public ByteChannel getChannel()
  {
    return this.channel;
  }
  
  public Draft getDraft()
  {
    return this.draft;
  }
  
  long getLastPong()
  {
    return this.lastPong;
  }
  
  public InetSocketAddress getLocalSocketAddress()
  {
    return this.wsl.getLocalSocketAddress(this);
  }
  
  public ReadyState getReadyState()
  {
    return this.readyState;
  }
  
  public InetSocketAddress getRemoteSocketAddress()
  {
    return this.wsl.getRemoteSocketAddress(this);
  }
  
  public String getResourceDescriptor()
  {
    return this.resourceDescriptor;
  }
  
  public SelectionKey getSelectionKey()
  {
    return this.key;
  }
  
  public WebSocketListener getWebSocketListener()
  {
    return this.wsl;
  }
  
  public WebSocketServer.WebSocketWorker getWorkerThread()
  {
    return this.workerThread;
  }
  
  public boolean hasBufferedData()
  {
    return this.outQueue.isEmpty() ^ true;
  }
  
  public boolean isClosed()
  {
    return this.readyState == ReadyState.CLOSED;
  }
  
  public boolean isClosing()
  {
    return this.readyState == ReadyState.CLOSING;
  }
  
  public boolean isFlushAndClose()
  {
    return this.flushandclosestate;
  }
  
  public boolean isOpen()
  {
    return this.readyState == ReadyState.OPEN;
  }
  
  public void send(String paramString)
  {
    if (paramString != null)
    {
      Draft localDraft = this.draft;
      boolean bool;
      if (this.role == Role.CLIENT) {
        bool = true;
      } else {
        bool = false;
      }
      send(localDraft.createFrames(paramString, bool));
      return;
    }
    throw new IllegalArgumentException("Cannot send 'null' data to a WebSocketImpl.");
  }
  
  public void send(ByteBuffer paramByteBuffer)
  {
    if (paramByteBuffer != null)
    {
      Draft localDraft = this.draft;
      boolean bool;
      if (this.role == Role.CLIENT) {
        bool = true;
      } else {
        bool = false;
      }
      send(localDraft.createFrames(paramByteBuffer, bool));
      return;
    }
    throw new IllegalArgumentException("Cannot send 'null' data to a WebSocketImpl.");
  }
  
  public void send(byte[] paramArrayOfByte)
  {
    send(ByteBuffer.wrap(paramArrayOfByte));
  }
  
  public void sendFragmentedFrame(Opcode paramOpcode, ByteBuffer paramByteBuffer, boolean paramBoolean)
  {
    send(this.draft.continuousFrame(paramOpcode, paramByteBuffer, paramBoolean));
  }
  
  public void sendFrame(Collection<Framedata> paramCollection)
  {
    send(paramCollection);
  }
  
  public void sendFrame(Framedata paramFramedata)
  {
    send(Collections.singletonList(paramFramedata));
  }
  
  public void sendPing()
  {
    if (this.pingFrame == null) {
      this.pingFrame = new PingFrame();
    }
    sendFrame(this.pingFrame);
  }
  
  public <T> void setAttachment(T paramT)
  {
    this.attachment = paramT;
  }
  
  public void setChannel(ByteChannel paramByteChannel)
  {
    this.channel = paramByteChannel;
  }
  
  public void setSelectionKey(SelectionKey paramSelectionKey)
  {
    this.key = paramSelectionKey;
  }
  
  public void setWorkerThread(WebSocketServer.WebSocketWorker paramWebSocketWorker)
  {
    this.workerThread = paramWebSocketWorker;
  }
  
  public void startHandshake(ClientHandshakeBuilder paramClientHandshakeBuilder)
  {
    this.handshakerequest = this.draft.postProcessHandshakeRequestAsClient(paramClientHandshakeBuilder);
    this.resourceDescriptor = paramClientHandshakeBuilder.getResourceDescriptor();
    try
    {
      this.wsl.onWebsocketHandshakeSentAsClient(this, this.handshakerequest);
      write(this.draft.createHandshake(this.handshakerequest));
      return;
    }
    catch (RuntimeException paramClientHandshakeBuilder)
    {
      log.error("Exception in startHandshake", paramClientHandshakeBuilder);
      this.wsl.onWebsocketError(this, paramClientHandshakeBuilder);
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("rejected because of ");
      localStringBuilder.append(paramClientHandshakeBuilder);
      throw new InvalidHandshakeException(localStringBuilder.toString());
      throw new InvalidHandshakeException("Handshake data rejected by client.");
    }
    catch (InvalidDataException paramClientHandshakeBuilder)
    {
      label110:
      break label110;
    }
  }
  
  public String toString()
  {
    return super.toString();
  }
  
  public void updateLastPong()
  {
    this.lastPong = System.currentTimeMillis();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes20.jar
 * Qualified Name:     org.java_websocket.WebSocketImpl
 * JD-Core Version:    0.7.0.1
 */