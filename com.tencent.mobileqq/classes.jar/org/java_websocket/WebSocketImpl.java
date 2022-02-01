package org.java_websocket;

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
  private static final Logger log;
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
  
  static
  {
    if (!WebSocketImpl.class.desiredAssertionStatus()) {}
    for (boolean bool = true;; bool = false)
    {
      $assertionsDisabled = bool;
      log = LoggerFactory.getLogger(WebSocketImpl.class);
      return;
    }
  }
  
  public WebSocketImpl(WebSocketListener paramWebSocketListener, List<Draft> paramList)
  {
    this(paramWebSocketListener, (Draft)null);
    this.role = Role.SERVER;
    if ((paramList == null) || (paramList.isEmpty()))
    {
      this.knownDrafts = new ArrayList();
      this.knownDrafts.add(new Draft_6455());
      return;
    }
    this.knownDrafts = paramList;
  }
  
  public WebSocketImpl(WebSocketListener paramWebSocketListener, Draft paramDraft)
  {
    if ((paramWebSocketListener == null) || ((paramDraft == null) && (this.role == Role.SERVER))) {
      throw new IllegalArgumentException("parameters must not be null");
    }
    this.outQueue = new LinkedBlockingQueue();
    this.inQueue = new LinkedBlockingQueue();
    this.wsl = paramWebSocketListener;
    this.role = Role.CLIENT;
    if (paramDraft != null) {
      this.draft = paramDraft.copyInstance();
    }
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
    catch (LimitExceededException paramByteBuffer)
    {
      if (paramByteBuffer.getLimit() == 2147483647)
      {
        log.error("Closing due to invalid size of frame", paramByteBuffer);
        this.wsl.onWebsocketError(this, paramByteBuffer);
      }
      close(paramByteBuffer);
      return;
    }
    catch (InvalidDataException paramByteBuffer)
    {
      log.error("Closing due to invalid data in frame", paramByteBuffer);
      this.wsl.onWebsocketError(this, paramByteBuffer);
      close(paramByteBuffer);
    }
  }
  
  private boolean decodeHandshake(ByteBuffer paramByteBuffer)
  {
    ByteBuffer localByteBuffer;
    if (this.tmpHandshakeBytes.capacity() == 0) {
      localByteBuffer = paramByteBuffer;
    }
    for (;;)
    {
      localByteBuffer.mark();
      try
      {
        label47:
        Draft localDraft;
        if (this.role == Role.SERVER) {
          if (this.draft == null)
          {
            localObject1 = this.knownDrafts.iterator();
            if (((Iterator)localObject1).hasNext()) {
              localDraft = ((Draft)((Iterator)localObject1).next()).copyInstance();
            }
          }
        }
        Object localObject2;
        try
        {
          localDraft.setParseMode(this.role);
          localByteBuffer.reset();
          localObject2 = localDraft.translateHandshake(localByteBuffer);
          if (!(localObject2 instanceof ClientHandshake))
          {
            log.trace("Closing due to wrong handshake");
            closeConnectionDueToWrongHandshake(new InvalidDataException(1002, "wrong http function"));
            return false;
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
            continue;
          }
          localObject2 = (ClientHandshake)localObject2;
          if (localDraft.acceptHandshakeAsServer((ClientHandshake)localObject2) != HandshakeState.MATCHED) {
            break label47;
          }
          this.resourceDescriptor = ((ClientHandshake)localObject2).getResourceDescriptor();
          try
          {
            ServerHandshakeBuilder localServerHandshakeBuilder = this.wsl.onWebsocketHandshakeReceivedAsServer(this, localDraft, (ClientHandshake)localObject2);
            write(localDraft.createHandshake(localDraft.postProcessHandshakeResponseAsServer((ClientHandshake)localObject2, localServerHandshakeBuilder)));
            this.draft = localDraft;
            open((Handshakedata)localObject2);
            return true;
          }
          catch (InvalidDataException localInvalidDataException2)
          {
            log.trace("Closing due to wrong handshake. Possible handshake rejection", localInvalidDataException2);
            closeConnectionDueToWrongHandshake(localInvalidDataException2);
            return false;
          }
          catch (RuntimeException localRuntimeException2)
          {
            log.error("Closing due to internal server error", localRuntimeException2);
            this.wsl.onWebsocketError(this, localRuntimeException2);
            closeConnectionDueToInternalServerError(localRuntimeException2);
            return false;
          }
          if (this.draft != null) {
            break label883;
          }
          log.trace("Closing due to protocol error: no draft matches");
          closeConnectionDueToWrongHandshake(new InvalidDataException(1002, "no draft matches"));
        }
        catch (InvalidHandshakeException localInvalidHandshakeException2) {}
        Object localObject1 = this.draft.translateHandshake(localByteBuffer);
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
          HandshakeState localHandshakeState = this.draft.acceptHandshakeAsClient(this.handshakerequest, (ServerHandshake)localObject1);
          localObject2 = HandshakeState.MATCHED;
          if (localHandshakeState == localObject2) {
            try
            {
              this.wsl.onWebsocketHandshakeReceivedAsClient(this, this.handshakerequest, (ServerHandshake)localObject1);
              open((Handshakedata)localObject1);
              return true;
            }
            catch (InvalidDataException localInvalidDataException1)
            {
              log.trace("Closing due to invalid data exception. Possible handshake rejection", localInvalidDataException1);
              flushAndClose(localInvalidDataException1.getCloseCode(), localInvalidDataException1.getMessage(), false);
              return false;
            }
            catch (RuntimeException localRuntimeException1)
            {
              log.error("Closing since client was never connected", localRuntimeException1);
              this.wsl.onWebsocketError(this, localRuntimeException1);
              flushAndClose(-1, localRuntimeException1.getMessage(), false);
              return false;
            }
          }
          log.trace("Closing due to protocol error: draft {} refuses handshake", this.draft);
          close(1002, "draft " + this.draft + " refuses handshake");
        }
        return false;
      }
      catch (InvalidHandshakeException localInvalidHandshakeException1)
      {
        for (;;)
        {
          log.trace("Closing due to invalid handshake", localInvalidHandshakeException1);
          close(localInvalidHandshakeException1);
        }
      }
      catch (IncompleteHandshakeException localIncompleteHandshakeException)
      {
        for (;;)
        {
          if (this.tmpHandshakeBytes.capacity() == 0)
          {
            localByteBuffer.reset();
            int j = localIncompleteHandshakeException.getPreferredSize();
            int i;
            if (j == 0) {
              i = localByteBuffer.capacity() + 16;
            }
            do
            {
              do
              {
                this.tmpHandshakeBytes = ByteBuffer.allocate(i);
                this.tmpHandshakeBytes.put(paramByteBuffer);
                break;
                i = j;
              } while ($assertionsDisabled);
              i = j;
            } while (localIncompleteHandshakeException.getPreferredSize() >= localByteBuffer.remaining());
            throw new AssertionError();
          }
          this.tmpHandshakeBytes.position(this.tmpHandshakeBytes.limit());
          this.tmpHandshakeBytes.limit(this.tmpHandshakeBytes.capacity());
        }
      }
    }
    label883:
    return false;
  }
  
  private ByteBuffer generateHttpResponseDueToError(int paramInt)
  {
    switch (paramInt)
    {
    }
    for (String str = "500 Internal Server Error";; str = "404 WebSocket Upgrade Failure") {
      return ByteBuffer.wrap(Charsetfunctions.asciiBytes("HTTP/1.1 " + str + "\r\nContent-Type: text/html\nServer: TooTallNate Java-WebSocket\r\nContent-Length: " + (str.length() + 48) + "\r\n\r\n<html><head></head><body><h1>" + str + "</h1></body></html>"));
    }
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
    if (!isOpen()) {
      throw new WebsocketNotConnectedException();
    }
    if (paramCollection == null) {
      throw new IllegalArgumentException();
    }
    ArrayList localArrayList = new ArrayList();
    paramCollection = paramCollection.iterator();
    while (paramCollection.hasNext())
    {
      Framedata localFramedata = (Framedata)paramCollection.next();
      log.trace("send frame: {}", localFramedata);
      localArrayList.add(this.draft.createBinaryFrame(localFramedata));
    }
    write(localArrayList);
  }
  
  private void write(ByteBuffer paramByteBuffer)
  {
    Logger localLogger = log;
    int i = paramByteBuffer.remaining();
    if (paramByteBuffer.remaining() > 1000) {}
    for (String str = "too big to display";; str = new String(paramByteBuffer.array()))
    {
      localLogger.trace("write({}): {}", Integer.valueOf(i), str);
      this.outQueue.add(paramByteBuffer);
      this.wsl.onWriteDemand(this);
      return;
    }
  }
  
  private void write(List<ByteBuffer> paramList)
  {
    synchronized (this.synchronizeWriteObject)
    {
      paramList = paramList.iterator();
      if (paramList.hasNext()) {
        write((ByteBuffer)paramList.next());
      }
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
      if ((this.readyState == ReadyState.CLOSING) || (this.readyState == ReadyState.CLOSED)) {
        break label76;
      }
      if (this.readyState != ReadyState.OPEN) {
        break label235;
      }
      if (paramInt != 1006) {
        break label79;
      }
      if ((!$assertionsDisabled) && (paramBoolean)) {
        throw new AssertionError();
      }
    }
    finally {}
    this.readyState = ReadyState.CLOSING;
    flushAndClose(paramInt, paramString, false);
    label76:
    return;
    label79:
    Object localObject = this.draft.getCloseHandshakeType();
    CloseHandshakeType localCloseHandshakeType = CloseHandshakeType.NONE;
    if ((localObject == localCloseHandshakeType) || (!paramBoolean)) {}
    for (;;)
    {
      try
      {
        this.wsl.onWebsocketCloseInitiated(this, paramInt, paramString);
        if (isOpen())
        {
          localObject = new CloseFrame();
          ((CloseFrame)localObject).setReason(paramString);
          ((CloseFrame)localObject).setCode(paramInt);
          ((CloseFrame)localObject).isValid();
          sendFrame((Framedata)localObject);
        }
        flushAndClose(paramInt, paramString, paramBoolean);
        this.readyState = ReadyState.CLOSING;
        this.tmpHandshakeBytes = null;
      }
      catch (RuntimeException localRuntimeException)
      {
        this.wsl.onWebsocketError(this, localRuntimeException);
        continue;
      }
      catch (InvalidDataException localInvalidDataException)
      {
        log.error("generated frame is invalid", localInvalidDataException);
        this.wsl.onWebsocketError(this, localInvalidDataException);
        flushAndClose(1006, "generated frame is invalid", false);
        continue;
      }
      label235:
      if (paramInt == -3)
      {
        assert (paramBoolean);
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
    }
  }
  
  public void close(InvalidDataException paramInvalidDataException)
  {
    close(paramInvalidDataException.getCloseCode(), paramInvalidDataException.getMessage(), false);
  }
  
  public void closeConnection()
  {
    if (this.closedremotely == null) {
      throw new IllegalStateException("this method must be used in conjunction with flushAndClose");
    }
    closeConnection(this.closecode.intValue(), this.closemessage, this.closedremotely.booleanValue());
  }
  
  public void closeConnection(int paramInt, String paramString)
  {
    closeConnection(paramInt, paramString, false);
  }
  
  /* Error */
  public void closeConnection(int paramInt, String paramString, boolean paramBoolean)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield 120	org/java_websocket/WebSocketImpl:readyState	Lorg/java_websocket/enums/ReadyState;
    //   6: astore 4
    //   8: getstatic 505	org/java_websocket/enums/ReadyState:CLOSED	Lorg/java_websocket/enums/ReadyState;
    //   11: astore 5
    //   13: aload 4
    //   15: aload 5
    //   17: if_acmpne +6 -> 23
    //   20: aload_0
    //   21: monitorexit
    //   22: return
    //   23: aload_0
    //   24: getfield 120	org/java_websocket/WebSocketImpl:readyState	Lorg/java_websocket/enums/ReadyState;
    //   27: getstatic 440	org/java_websocket/enums/ReadyState:OPEN	Lorg/java_websocket/enums/ReadyState;
    //   30: if_acmpne +17 -> 47
    //   33: iload_1
    //   34: sipush 1006
    //   37: if_icmpne +10 -> 47
    //   40: aload_0
    //   41: getstatic 502	org/java_websocket/enums/ReadyState:CLOSING	Lorg/java_websocket/enums/ReadyState;
    //   44: putfield 120	org/java_websocket/WebSocketImpl:readyState	Lorg/java_websocket/enums/ReadyState;
    //   47: aload_0
    //   48: getfield 557	org/java_websocket/WebSocketImpl:key	Ljava/nio/channels/SelectionKey;
    //   51: ifnull +10 -> 61
    //   54: aload_0
    //   55: getfield 557	org/java_websocket/WebSocketImpl:key	Ljava/nio/channels/SelectionKey;
    //   58: invokevirtual 562	java/nio/channels/SelectionKey:cancel	()V
    //   61: aload_0
    //   62: getfield 564	org/java_websocket/WebSocketImpl:channel	Ljava/nio/channels/ByteChannel;
    //   65: astore 4
    //   67: aload 4
    //   69: ifnull +12 -> 81
    //   72: aload_0
    //   73: getfield 564	org/java_websocket/WebSocketImpl:channel	Ljava/nio/channels/ByteChannel;
    //   76: invokeinterface 568 1 0
    //   81: aload_0
    //   82: getfield 166	org/java_websocket/WebSocketImpl:wsl	Lorg/java_websocket/WebSocketListener;
    //   85: aload_0
    //   86: iload_1
    //   87: aload_2
    //   88: iload_3
    //   89: invokeinterface 572 5 0
    //   94: aload_0
    //   95: getfield 122	org/java_websocket/WebSocketImpl:draft	Lorg/java_websocket/drafts/Draft;
    //   98: ifnull +10 -> 108
    //   101: aload_0
    //   102: getfield 122	org/java_websocket/WebSocketImpl:draft	Lorg/java_websocket/drafts/Draft;
    //   105: invokevirtual 574	org/java_websocket/drafts/Draft:reset	()V
    //   108: aload_0
    //   109: aconst_null
    //   110: putfield 132	org/java_websocket/WebSocketImpl:handshakerequest	Lorg/java_websocket/handshake/ClientHandshake;
    //   113: aload_0
    //   114: getstatic 505	org/java_websocket/enums/ReadyState:CLOSED	Lorg/java_websocket/enums/ReadyState;
    //   117: putfield 120	org/java_websocket/WebSocketImpl:readyState	Lorg/java_websocket/enums/ReadyState;
    //   120: goto -100 -> 20
    //   123: astore_2
    //   124: aload_0
    //   125: monitorexit
    //   126: aload_2
    //   127: athrow
    //   128: astore 4
    //   130: aload 4
    //   132: invokevirtual 575	java/io/IOException:getMessage	()Ljava/lang/String;
    //   135: ldc_w 577
    //   138: invokevirtual 580	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   141: ifeq +19 -> 160
    //   144: getstatic 75	org/java_websocket/WebSocketImpl:log	Lorg/slf4j/Logger;
    //   147: ldc_w 582
    //   150: aload 4
    //   152: invokeinterface 339 3 0
    //   157: goto -76 -> 81
    //   160: getstatic 75	org/java_websocket/WebSocketImpl:log	Lorg/slf4j/Logger;
    //   163: ldc_w 584
    //   166: aload 4
    //   168: invokeinterface 245 3 0
    //   173: aload_0
    //   174: getfield 166	org/java_websocket/WebSocketImpl:wsl	Lorg/java_websocket/WebSocketListener;
    //   177: aload_0
    //   178: aload 4
    //   180: invokeinterface 251 3 0
    //   185: goto -104 -> 81
    //   188: astore_2
    //   189: aload_0
    //   190: getfield 166	org/java_websocket/WebSocketImpl:wsl	Lorg/java_websocket/WebSocketListener;
    //   193: aload_0
    //   194: aload_2
    //   195: invokeinterface 251 3 0
    //   200: goto -106 -> 94
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	203	0	this	WebSocketImpl
    //   0	203	1	paramInt	int
    //   0	203	2	paramString	String
    //   0	203	3	paramBoolean	boolean
    //   6	62	4	localObject	Object
    //   128	51	4	localIOException	java.io.IOException
    //   11	5	5	localReadyState	ReadyState
    // Exception table:
    //   from	to	target	type
    //   2	13	123	finally
    //   23	33	123	finally
    //   40	47	123	finally
    //   47	61	123	finally
    //   61	67	123	finally
    //   72	81	123	finally
    //   81	94	123	finally
    //   94	108	123	finally
    //   108	120	123	finally
    //   130	157	123	finally
    //   160	185	123	finally
    //   189	200	123	finally
    //   72	81	128	java/io/IOException
    //   81	94	188	java/lang/RuntimeException
  }
  
  protected void closeConnection(int paramInt, boolean paramBoolean)
  {
    closeConnection(paramInt, "", paramBoolean);
  }
  
  public void decode(ByteBuffer paramByteBuffer)
  {
    assert (paramByteBuffer.hasRemaining());
    Logger localLogger = log;
    int i = paramByteBuffer.remaining();
    String str;
    if (paramByteBuffer.remaining() > 1000)
    {
      str = "too big to display";
      localLogger.trace("process({}): ({})", Integer.valueOf(i), str);
      if (this.readyState == ReadyState.NOT_YET_CONNECTED) {
        break label109;
      }
      if (this.readyState == ReadyState.OPEN) {
        decodeFrames(paramByteBuffer);
      }
    }
    label109:
    do
    {
      do
      {
        return;
        str = new String(paramByteBuffer.array(), paramByteBuffer.position(), paramByteBuffer.remaining());
        break;
      } while ((!decodeHandshake(paramByteBuffer)) || (isClosing()) || (isClosed()));
      assert ((this.tmpHandshakeBytes.hasRemaining() != paramByteBuffer.hasRemaining()) || (!paramByteBuffer.hasRemaining()));
      if (paramByteBuffer.hasRemaining())
      {
        decodeFrames(paramByteBuffer);
        return;
      }
    } while (!this.tmpHandshakeBytes.hasRemaining());
    decodeFrames(this.tmpHandshakeBytes);
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
  
  /* Error */
  public void flushAndClose(int paramInt, String paramString, boolean paramBoolean)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield 113	org/java_websocket/WebSocketImpl:flushandclosestate	Z
    //   6: istore 4
    //   8: iload 4
    //   10: ifeq +6 -> 16
    //   13: aload_0
    //   14: monitorexit
    //   15: return
    //   16: aload_0
    //   17: iload_1
    //   18: invokestatic 474	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   21: putfield 136	org/java_websocket/WebSocketImpl:closecode	Ljava/lang/Integer;
    //   24: aload_0
    //   25: aload_2
    //   26: putfield 134	org/java_websocket/WebSocketImpl:closemessage	Ljava/lang/String;
    //   29: aload_0
    //   30: iload_3
    //   31: invokestatic 615	java/lang/Boolean:valueOf	(Z)Ljava/lang/Boolean;
    //   34: putfield 138	org/java_websocket/WebSocketImpl:closedremotely	Ljava/lang/Boolean;
    //   37: aload_0
    //   38: iconst_1
    //   39: putfield 113	org/java_websocket/WebSocketImpl:flushandclosestate	Z
    //   42: aload_0
    //   43: getfield 166	org/java_websocket/WebSocketImpl:wsl	Lorg/java_websocket/WebSocketListener;
    //   46: aload_0
    //   47: invokeinterface 484 2 0
    //   52: aload_0
    //   53: getfield 166	org/java_websocket/WebSocketImpl:wsl	Lorg/java_websocket/WebSocketListener;
    //   56: aload_0
    //   57: iload_1
    //   58: aload_2
    //   59: iload_3
    //   60: invokeinterface 618 5 0
    //   65: aload_0
    //   66: getfield 122	org/java_websocket/WebSocketImpl:draft	Lorg/java_websocket/drafts/Draft;
    //   69: ifnull +10 -> 79
    //   72: aload_0
    //   73: getfield 122	org/java_websocket/WebSocketImpl:draft	Lorg/java_websocket/drafts/Draft;
    //   76: invokevirtual 574	org/java_websocket/drafts/Draft:reset	()V
    //   79: aload_0
    //   80: aconst_null
    //   81: putfield 132	org/java_websocket/WebSocketImpl:handshakerequest	Lorg/java_websocket/handshake/ClientHandshake;
    //   84: goto -71 -> 13
    //   87: astore_2
    //   88: aload_0
    //   89: monitorexit
    //   90: aload_2
    //   91: athrow
    //   92: astore_2
    //   93: getstatic 75	org/java_websocket/WebSocketImpl:log	Lorg/slf4j/Logger;
    //   96: ldc_w 620
    //   99: aload_2
    //   100: invokeinterface 245 3 0
    //   105: aload_0
    //   106: getfield 166	org/java_websocket/WebSocketImpl:wsl	Lorg/java_websocket/WebSocketListener;
    //   109: aload_0
    //   110: aload_2
    //   111: invokeinterface 251 3 0
    //   116: goto -51 -> 65
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	119	0	this	WebSocketImpl
    //   0	119	1	paramInt	int
    //   0	119	2	paramString	String
    //   0	119	3	paramBoolean	boolean
    //   6	3	4	bool	boolean
    // Exception table:
    //   from	to	target	type
    //   2	8	87	finally
    //   16	52	87	finally
    //   52	65	87	finally
    //   65	79	87	finally
    //   79	84	87	finally
    //   93	116	87	finally
    //   52	65	92	java/lang/RuntimeException
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
    return !this.outQueue.isEmpty();
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
    if (paramString == null) {
      throw new IllegalArgumentException("Cannot send 'null' data to a WebSocketImpl.");
    }
    Draft localDraft = this.draft;
    if (this.role == Role.CLIENT) {}
    for (boolean bool = true;; bool = false)
    {
      send(localDraft.createFrames(paramString, bool));
      return;
    }
  }
  
  public void send(ByteBuffer paramByteBuffer)
  {
    if (paramByteBuffer == null) {
      throw new IllegalArgumentException("Cannot send 'null' data to a WebSocketImpl.");
    }
    Draft localDraft = this.draft;
    if (this.role == Role.CLIENT) {}
    for (boolean bool = true;; bool = false)
    {
      send(localDraft.createFrames(paramByteBuffer, bool));
      return;
    }
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
    assert (this.resourceDescriptor != null);
    try
    {
      this.wsl.onWebsocketHandshakeSentAsClient(this, this.handshakerequest);
      write(this.draft.createHandshake(this.handshakerequest));
      return;
    }
    catch (InvalidDataException paramClientHandshakeBuilder)
    {
      throw new InvalidHandshakeException("Handshake data rejected by client.");
    }
    catch (RuntimeException paramClientHandshakeBuilder)
    {
      log.error("Exception in startHandshake", paramClientHandshakeBuilder);
      this.wsl.onWebsocketError(this, paramClientHandshakeBuilder);
      throw new InvalidHandshakeException("rejected because of " + paramClientHandshakeBuilder);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     org.java_websocket.WebSocketImpl
 * JD-Core Version:    0.7.0.1
 */