package org.java_websocket.drafts;

import java.math.BigInteger;
import java.nio.ByteBuffer;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Locale;
import java.util.Random;
import java.util.TimeZone;
import org.java_websocket.WebSocketImpl;
import org.java_websocket.WebSocketListener;
import org.java_websocket.enums.CloseHandshakeType;
import org.java_websocket.enums.HandshakeState;
import org.java_websocket.enums.Opcode;
import org.java_websocket.enums.ReadyState;
import org.java_websocket.enums.Role;
import org.java_websocket.exceptions.IncompleteException;
import org.java_websocket.exceptions.InvalidDataException;
import org.java_websocket.exceptions.InvalidFrameException;
import org.java_websocket.exceptions.InvalidHandshakeException;
import org.java_websocket.exceptions.LimitExceededException;
import org.java_websocket.exceptions.NotSendableException;
import org.java_websocket.extensions.DefaultExtension;
import org.java_websocket.extensions.IExtension;
import org.java_websocket.framing.BinaryFrame;
import org.java_websocket.framing.CloseFrame;
import org.java_websocket.framing.Framedata;
import org.java_websocket.framing.FramedataImpl1;
import org.java_websocket.framing.TextFrame;
import org.java_websocket.handshake.ClientHandshake;
import org.java_websocket.handshake.ClientHandshakeBuilder;
import org.java_websocket.handshake.HandshakeBuilder;
import org.java_websocket.handshake.ServerHandshake;
import org.java_websocket.handshake.ServerHandshakeBuilder;
import org.java_websocket.protocols.IProtocol;
import org.java_websocket.protocols.Protocol;
import org.java_websocket.util.Base64;
import org.java_websocket.util.Charsetfunctions;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Draft_6455
  extends Draft
{
  private static final String CONNECTION = "Connection";
  private static final String SEC_WEB_SOCKET_ACCEPT = "Sec-WebSocket-Accept";
  private static final String SEC_WEB_SOCKET_EXTENSIONS = "Sec-WebSocket-Extensions";
  private static final String SEC_WEB_SOCKET_KEY = "Sec-WebSocket-Key";
  private static final String SEC_WEB_SOCKET_PROTOCOL = "Sec-WebSocket-Protocol";
  private static final String UPGRADE = "Upgrade";
  private static final Logger log = LoggerFactory.getLogger(Draft_6455.class);
  private final List<ByteBuffer> byteBufferList;
  private Framedata currentContinuousFrame;
  private IExtension extension = new DefaultExtension();
  private ByteBuffer incompleteframe;
  private List<IExtension> knownExtensions;
  private List<IProtocol> knownProtocols;
  private int maxFrameSize;
  private IProtocol protocol;
  private final Random reuseableRandom = new Random();
  
  public Draft_6455()
  {
    this(Collections.emptyList());
  }
  
  public Draft_6455(List<IExtension> paramList)
  {
    this(paramList, Collections.singletonList(new Protocol("")));
  }
  
  public Draft_6455(List<IExtension> paramList, int paramInt)
  {
    this(paramList, Collections.singletonList(new Protocol("")), paramInt);
  }
  
  public Draft_6455(List<IExtension> paramList, List<IProtocol> paramList1)
  {
    this(paramList, paramList1, 2147483647);
  }
  
  public Draft_6455(List<IExtension> paramList, List<IProtocol> paramList1, int paramInt)
  {
    if ((paramList != null) && (paramList1 != null) && (paramInt >= 1))
    {
      this.knownExtensions = new ArrayList(paramList.size());
      this.knownProtocols = new ArrayList(paramList1.size());
      int i = 0;
      this.byteBufferList = new ArrayList();
      Iterator localIterator = paramList.iterator();
      while (localIterator.hasNext()) {
        if (((IExtension)localIterator.next()).getClass().equals(DefaultExtension.class)) {
          i = 1;
        }
      }
      this.knownExtensions.addAll(paramList);
      if (i == 0)
      {
        paramList = this.knownExtensions;
        paramList.add(paramList.size(), this.extension);
      }
      this.knownProtocols.addAll(paramList1);
      this.maxFrameSize = paramInt;
      return;
    }
    paramList = new IllegalArgumentException();
    for (;;)
    {
      throw paramList;
    }
  }
  
  public Draft_6455(IExtension paramIExtension)
  {
    this(Collections.singletonList(paramIExtension));
  }
  
  private void addToBufferList(ByteBuffer paramByteBuffer)
  {
    synchronized (this.byteBufferList)
    {
      this.byteBufferList.add(paramByteBuffer);
      return;
    }
  }
  
  private void checkBufferLimit()
  {
    long l = getByteBufferListSize();
    if (l <= this.maxFrameSize) {
      return;
    }
    clearBufferList();
    log.trace("Payload limit reached. Allowed: {} Current: {}", Integer.valueOf(this.maxFrameSize), Long.valueOf(l));
    throw new LimitExceededException(this.maxFrameSize);
  }
  
  private void clearBufferList()
  {
    synchronized (this.byteBufferList)
    {
      this.byteBufferList.clear();
      return;
    }
  }
  
  private HandshakeState containsRequestedProtocol(String paramString)
  {
    Iterator localIterator = this.knownProtocols.iterator();
    while (localIterator.hasNext())
    {
      IProtocol localIProtocol = (IProtocol)localIterator.next();
      if (localIProtocol.acceptProvidedProtocol(paramString))
      {
        this.protocol = localIProtocol;
        log.trace("acceptHandshake - Matching protocol found: {}", this.protocol);
        return HandshakeState.MATCHED;
      }
    }
    return HandshakeState.NOT_MATCHED;
  }
  
  private ByteBuffer createByteBufferFromFramedata(Framedata paramFramedata)
  {
    ByteBuffer localByteBuffer = paramFramedata.getPayloadData();
    Object localObject = this.role;
    Role localRole = Role.CLIENT;
    int k = 0;
    boolean bool;
    if (localObject == localRole) {
      bool = true;
    } else {
      bool = false;
    }
    int m = getSizeBytes(localByteBuffer);
    int i;
    if (m > 1) {
      i = m + 1;
    } else {
      i = m;
    }
    if (bool) {
      j = 4;
    } else {
      j = 0;
    }
    localObject = ByteBuffer.allocate(i + 1 + j + localByteBuffer.remaining());
    int j = fromOpcode(paramFramedata.getOpcode());
    if (paramFramedata.isFin()) {
      i = -128;
    } else {
      i = 0;
    }
    ((ByteBuffer)localObject).put((byte)((byte)i | j));
    paramFramedata = toByteArray(localByteBuffer.remaining(), m);
    if (m == 1)
    {
      ((ByteBuffer)localObject).put((byte)(paramFramedata[0] | getMaskByte(bool)));
    }
    else if (m == 2)
    {
      ((ByteBuffer)localObject).put((byte)(getMaskByte(bool) | 0x7E));
      ((ByteBuffer)localObject).put(paramFramedata);
    }
    else
    {
      if (m != 8) {
        break label324;
      }
      ((ByteBuffer)localObject).put((byte)(getMaskByte(bool) | 0x7F));
      ((ByteBuffer)localObject).put(paramFramedata);
    }
    if (bool)
    {
      paramFramedata = ByteBuffer.allocate(4);
      paramFramedata.putInt(this.reuseableRandom.nextInt());
      ((ByteBuffer)localObject).put(paramFramedata.array());
      i = k;
      while (localByteBuffer.hasRemaining())
      {
        ((ByteBuffer)localObject).put((byte)(localByteBuffer.get() ^ paramFramedata.get(i % 4)));
        i += 1;
      }
    }
    ((ByteBuffer)localObject).put(localByteBuffer);
    localByteBuffer.flip();
    ((ByteBuffer)localObject).flip();
    return localObject;
    label324:
    paramFramedata = new IllegalStateException("Size representation not supported/specified");
    for (;;)
    {
      throw paramFramedata;
    }
  }
  
  private byte fromOpcode(Opcode paramOpcode)
  {
    if (paramOpcode == Opcode.CONTINUOUS) {
      return 0;
    }
    if (paramOpcode == Opcode.TEXT) {
      return 1;
    }
    if (paramOpcode == Opcode.BINARY) {
      return 2;
    }
    if (paramOpcode == Opcode.CLOSING) {
      return 8;
    }
    if (paramOpcode == Opcode.PING) {
      return 9;
    }
    if (paramOpcode == Opcode.PONG) {
      return 10;
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("Don't know how to handle ");
    localStringBuilder.append(paramOpcode.toString());
    throw new IllegalArgumentException(localStringBuilder.toString());
  }
  
  private String generateFinalKey(String paramString)
  {
    paramString = paramString.trim();
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append(paramString);
    ((StringBuilder)localObject).append("258EAFA5-E914-47DA-95CA-C5AB0DC85B11");
    paramString = ((StringBuilder)localObject).toString();
    try
    {
      localObject = MessageDigest.getInstance("SHA1");
      return Base64.encodeBytes(((MessageDigest)localObject).digest(paramString.getBytes()));
    }
    catch (NoSuchAlgorithmException paramString)
    {
      throw new IllegalStateException(paramString);
    }
  }
  
  private long getByteBufferListSize()
  {
    synchronized (this.byteBufferList)
    {
      Iterator localIterator = this.byteBufferList.iterator();
      for (long l = 0L; localIterator.hasNext(); l += ((ByteBuffer)localIterator.next()).limit()) {}
      return l;
    }
    for (;;)
    {
      throw localObject;
    }
  }
  
  private byte getMaskByte(boolean paramBoolean)
  {
    if (paramBoolean) {
      return -128;
    }
    return 0;
  }
  
  private ByteBuffer getPayloadFromByteBufferList()
  {
    synchronized (this.byteBufferList)
    {
      Object localObject1 = this.byteBufferList.iterator();
      for (long l = 0L; ((Iterator)localObject1).hasNext(); l += ((ByteBuffer)((Iterator)localObject1).next()).limit()) {}
      checkBufferLimit();
      localObject1 = ByteBuffer.allocate((int)l);
      Iterator localIterator = this.byteBufferList.iterator();
      while (localIterator.hasNext()) {
        ((ByteBuffer)localObject1).put((ByteBuffer)localIterator.next());
      }
      ((ByteBuffer)localObject1).flip();
      return localObject1;
    }
    for (;;)
    {
      throw localObject2;
    }
  }
  
  private String getServerTime()
  {
    Calendar localCalendar = Calendar.getInstance();
    SimpleDateFormat localSimpleDateFormat = new SimpleDateFormat("EEE, dd MMM yyyy HH:mm:ss z", Locale.US);
    localSimpleDateFormat.setTimeZone(TimeZone.getTimeZone("GMT"));
    return localSimpleDateFormat.format(localCalendar.getTime());
  }
  
  private int getSizeBytes(ByteBuffer paramByteBuffer)
  {
    if (paramByteBuffer.remaining() <= 125) {
      return 1;
    }
    if (paramByteBuffer.remaining() <= 65535) {
      return 2;
    }
    return 8;
  }
  
  private void logRuntimeException(WebSocketImpl paramWebSocketImpl, RuntimeException paramRuntimeException)
  {
    log.error("Runtime exception during onWebsocketMessage", paramRuntimeException);
    paramWebSocketImpl.getWebSocketListener().onWebsocketError(paramWebSocketImpl, paramRuntimeException);
  }
  
  private void processFrameBinary(WebSocketImpl paramWebSocketImpl, Framedata paramFramedata)
  {
    try
    {
      paramWebSocketImpl.getWebSocketListener().onWebsocketMessage(paramWebSocketImpl, paramFramedata.getPayloadData());
      return;
    }
    catch (RuntimeException paramFramedata)
    {
      logRuntimeException(paramWebSocketImpl, paramFramedata);
    }
  }
  
  private void processFrameClosing(WebSocketImpl paramWebSocketImpl, Framedata paramFramedata)
  {
    int i;
    if ((paramFramedata instanceof CloseFrame))
    {
      paramFramedata = (CloseFrame)paramFramedata;
      i = paramFramedata.getCloseCode();
      paramFramedata = paramFramedata.getMessage();
    }
    else
    {
      i = 1005;
      paramFramedata = "";
    }
    if (paramWebSocketImpl.getReadyState() == ReadyState.CLOSING)
    {
      paramWebSocketImpl.closeConnection(i, paramFramedata, true);
      return;
    }
    if (getCloseHandshakeType() == CloseHandshakeType.TWOWAY)
    {
      paramWebSocketImpl.close(i, paramFramedata, true);
      return;
    }
    paramWebSocketImpl.flushAndClose(i, paramFramedata, false);
  }
  
  private void processFrameContinuousAndNonFin(WebSocketImpl paramWebSocketImpl, Framedata paramFramedata, Opcode paramOpcode)
  {
    if (paramOpcode != Opcode.CONTINUOUS) {
      processFrameIsNotFin(paramFramedata);
    } else if (paramFramedata.isFin()) {
      processFrameIsFin(paramWebSocketImpl, paramFramedata);
    } else {
      if (this.currentContinuousFrame == null) {
        break label109;
      }
    }
    if ((paramOpcode == Opcode.TEXT) && (!Charsetfunctions.isValidUTF8(paramFramedata.getPayloadData())))
    {
      log.error("Protocol error: Payload is not UTF8");
      throw new InvalidDataException(1007);
    }
    if ((paramOpcode == Opcode.CONTINUOUS) && (this.currentContinuousFrame != null)) {
      addToBufferList(paramFramedata.getPayloadData());
    }
    return;
    label109:
    log.error("Protocol error: Continuous frame sequence was not started.");
    throw new InvalidDataException(1002, "Continuous frame sequence was not started.");
  }
  
  private void processFrameIsFin(WebSocketImpl paramWebSocketImpl, Framedata paramFramedata)
  {
    if (this.currentContinuousFrame != null)
    {
      addToBufferList(paramFramedata.getPayloadData());
      checkBufferLimit();
      if (this.currentContinuousFrame.getOpcode() == Opcode.TEXT)
      {
        ((FramedataImpl1)this.currentContinuousFrame).setPayload(getPayloadFromByteBufferList());
        ((FramedataImpl1)this.currentContinuousFrame).isValid();
        try
        {
          paramWebSocketImpl.getWebSocketListener().onWebsocketMessage(paramWebSocketImpl, Charsetfunctions.stringUtf8(this.currentContinuousFrame.getPayloadData()));
        }
        catch (RuntimeException paramFramedata)
        {
          logRuntimeException(paramWebSocketImpl, paramFramedata);
        }
      }
      else if (this.currentContinuousFrame.getOpcode() == Opcode.BINARY)
      {
        ((FramedataImpl1)this.currentContinuousFrame).setPayload(getPayloadFromByteBufferList());
        ((FramedataImpl1)this.currentContinuousFrame).isValid();
        try
        {
          paramWebSocketImpl.getWebSocketListener().onWebsocketMessage(paramWebSocketImpl, this.currentContinuousFrame.getPayloadData());
        }
        catch (RuntimeException paramFramedata)
        {
          logRuntimeException(paramWebSocketImpl, paramFramedata);
        }
      }
      this.currentContinuousFrame = null;
      clearBufferList();
      return;
    }
    log.trace("Protocol error: Previous continuous frame sequence not completed.");
    throw new InvalidDataException(1002, "Continuous frame sequence was not started.");
  }
  
  private void processFrameIsNotFin(Framedata paramFramedata)
  {
    if (this.currentContinuousFrame == null)
    {
      this.currentContinuousFrame = paramFramedata;
      addToBufferList(paramFramedata.getPayloadData());
      checkBufferLimit();
      return;
    }
    log.trace("Protocol error: Previous continuous frame sequence not completed.");
    throw new InvalidDataException(1002, "Previous continuous frame sequence not completed.");
  }
  
  private void processFrameText(WebSocketImpl paramWebSocketImpl, Framedata paramFramedata)
  {
    try
    {
      paramWebSocketImpl.getWebSocketListener().onWebsocketMessage(paramWebSocketImpl, Charsetfunctions.stringUtf8(paramFramedata.getPayloadData()));
      return;
    }
    catch (RuntimeException paramFramedata)
    {
      logRuntimeException(paramWebSocketImpl, paramFramedata);
    }
  }
  
  private byte[] toByteArray(long paramLong, int paramInt)
  {
    byte[] arrayOfByte = new byte[paramInt];
    int i = 0;
    while (i < paramInt)
    {
      arrayOfByte[i] = ((byte)(int)(paramLong >>> paramInt * 8 - 8 - i * 8));
      i += 1;
    }
    return arrayOfByte;
  }
  
  private Opcode toOpcode(byte paramByte)
  {
    if (paramByte != 0)
    {
      if (paramByte != 1)
      {
        if (paramByte != 2)
        {
          switch (paramByte)
          {
          default: 
            StringBuilder localStringBuilder = new StringBuilder();
            localStringBuilder.append("Unknown opcode ");
            localStringBuilder.append((short)paramByte);
            throw new InvalidFrameException(localStringBuilder.toString());
          case 10: 
            return Opcode.PONG;
          case 9: 
            return Opcode.PING;
          }
          return Opcode.CLOSING;
        }
        return Opcode.BINARY;
      }
      return Opcode.TEXT;
    }
    return Opcode.CONTINUOUS;
  }
  
  private Framedata translateSingleFrame(ByteBuffer paramByteBuffer)
  {
    if (paramByteBuffer != null)
    {
      int i1 = paramByteBuffer.remaining();
      int k = 2;
      translateSingleFrameCheckPacketSize(i1, 2);
      int j = paramByteBuffer.get();
      int n = 0;
      boolean bool1;
      if (j >> 8 != 0) {
        bool1 = true;
      } else {
        bool1 = false;
      }
      boolean bool2;
      if ((j & 0x40) != 0) {
        bool2 = true;
      } else {
        bool2 = false;
      }
      boolean bool3;
      if ((j & 0x20) != 0) {
        bool3 = true;
      } else {
        bool3 = false;
      }
      boolean bool4;
      if ((j & 0x10) != 0) {
        bool4 = true;
      } else {
        bool4 = false;
      }
      int m = paramByteBuffer.get();
      int i;
      if ((m & 0xFFFFFF80) != 0) {
        i = 1;
      } else {
        i = 0;
      }
      m = (byte)(m & 0x7F);
      Object localObject1 = toOpcode((byte)(j & 0xF));
      if (m >= 0)
      {
        j = m;
        if (m <= 125) {}
      }
      else
      {
        localObject2 = translateSingleFramePayloadLength(paramByteBuffer, (Opcode)localObject1, m, i1, 2);
        j = Draft_6455.TranslatedPayloadMetaData.access$000((Draft_6455.TranslatedPayloadMetaData)localObject2);
        k = Draft_6455.TranslatedPayloadMetaData.access$100((Draft_6455.TranslatedPayloadMetaData)localObject2);
      }
      translateSingleFrameCheckLengthLimit(j);
      if (i != 0) {
        m = 4;
      } else {
        m = 0;
      }
      translateSingleFrameCheckPacketSize(i1, k + m + j);
      Object localObject2 = ByteBuffer.allocate(checkAlloc(j));
      if (i != 0)
      {
        byte[] arrayOfByte = new byte[4];
        paramByteBuffer.get(arrayOfByte);
        i = n;
        while (i < j)
        {
          ((ByteBuffer)localObject2).put((byte)(paramByteBuffer.get() ^ arrayOfByte[(i % 4)]));
          i += 1;
        }
      }
      ((ByteBuffer)localObject2).put(paramByteBuffer.array(), paramByteBuffer.position(), ((ByteBuffer)localObject2).limit());
      paramByteBuffer.position(paramByteBuffer.position() + ((ByteBuffer)localObject2).limit());
      localObject1 = FramedataImpl1.get((Opcode)localObject1);
      ((FramedataImpl1)localObject1).setFin(bool1);
      ((FramedataImpl1)localObject1).setRSV1(bool2);
      ((FramedataImpl1)localObject1).setRSV2(bool3);
      ((FramedataImpl1)localObject1).setRSV3(bool4);
      ((ByteBuffer)localObject2).flip();
      ((FramedataImpl1)localObject1).setPayload((ByteBuffer)localObject2);
      getExtension().isFrameValid((Framedata)localObject1);
      getExtension().decodeFrame((Framedata)localObject1);
      if (log.isTraceEnabled())
      {
        localObject2 = log;
        i = ((FramedataImpl1)localObject1).getPayloadData().remaining();
        if (((FramedataImpl1)localObject1).getPayloadData().remaining() > 1000) {
          paramByteBuffer = "too big to display";
        } else {
          paramByteBuffer = new String(((FramedataImpl1)localObject1).getPayloadData().array());
        }
        ((Logger)localObject2).trace("afterDecoding({}): {}", Integer.valueOf(i), paramByteBuffer);
      }
      ((FramedataImpl1)localObject1).isValid();
      return localObject1;
    }
    paramByteBuffer = new IllegalArgumentException();
    for (;;)
    {
      throw paramByteBuffer;
    }
  }
  
  private void translateSingleFrameCheckLengthLimit(long paramLong)
  {
    if (paramLong <= 2147483647L)
    {
      int i = this.maxFrameSize;
      if (paramLong <= i)
      {
        if (paramLong >= 0L) {
          return;
        }
        log.trace("Limit underflow: Payloadsize is to little...");
        throw new LimitExceededException("Payloadsize is to little...");
      }
      log.trace("Payload limit reached. Allowed: {} Current: {}", Integer.valueOf(i), Long.valueOf(paramLong));
      throw new LimitExceededException("Payload limit reached.", this.maxFrameSize);
    }
    log.trace("Limit exedeed: Payloadsize is to big...");
    throw new LimitExceededException("Payloadsize is to big...");
  }
  
  private void translateSingleFrameCheckPacketSize(int paramInt1, int paramInt2)
  {
    if (paramInt1 >= paramInt2) {
      return;
    }
    log.trace("Incomplete frame: maxpacketsize < realpacketsize");
    throw new IncompleteException(paramInt2);
  }
  
  private Draft_6455.TranslatedPayloadMetaData translateSingleFramePayloadLength(ByteBuffer paramByteBuffer, Opcode paramOpcode, int paramInt1, int paramInt2, int paramInt3)
  {
    if ((paramOpcode != Opcode.PING) && (paramOpcode != Opcode.PONG) && (paramOpcode != Opcode.CLOSING))
    {
      if (paramInt1 == 126)
      {
        paramInt3 += 2;
        translateSingleFrameCheckPacketSize(paramInt2, paramInt3);
        paramOpcode = new byte[3];
        paramOpcode[1] = paramByteBuffer.get();
        paramOpcode[2] = paramByteBuffer.get();
        paramInt1 = new BigInteger(paramOpcode).intValue();
        paramInt2 = paramInt3;
      }
      else
      {
        paramInt3 += 8;
        translateSingleFrameCheckPacketSize(paramInt2, paramInt3);
        paramOpcode = new byte[8];
        paramInt1 = 0;
        while (paramInt1 < 8)
        {
          paramOpcode[paramInt1] = paramByteBuffer.get();
          paramInt1 += 1;
        }
        long l = new BigInteger(paramOpcode).longValue();
        translateSingleFrameCheckLengthLimit(l);
        paramInt1 = (int)l;
        paramInt2 = paramInt3;
      }
      return new Draft_6455.TranslatedPayloadMetaData(this, paramInt1, paramInt2);
    }
    log.trace("Invalid frame: more than 125 octets");
    paramByteBuffer = new InvalidFrameException("more than 125 octets");
    for (;;)
    {
      throw paramByteBuffer;
    }
  }
  
  public HandshakeState acceptHandshakeAsClient(ClientHandshake paramClientHandshake, ServerHandshake paramServerHandshake)
  {
    if (!basicAccept(paramServerHandshake))
    {
      log.trace("acceptHandshakeAsClient - Missing/wrong upgrade or connection in handshake.");
      return HandshakeState.NOT_MATCHED;
    }
    if ((paramClientHandshake.hasFieldValue("Sec-WebSocket-Key")) && (paramServerHandshake.hasFieldValue("Sec-WebSocket-Accept")))
    {
      Object localObject = paramServerHandshake.getFieldValue("Sec-WebSocket-Accept");
      if (!generateFinalKey(paramClientHandshake.getFieldValue("Sec-WebSocket-Key")).equals(localObject))
      {
        log.trace("acceptHandshakeAsClient - Wrong key for Sec-WebSocket-Key.");
        return HandshakeState.NOT_MATCHED;
      }
      localObject = HandshakeState.NOT_MATCHED;
      String str = paramServerHandshake.getFieldValue("Sec-WebSocket-Extensions");
      Iterator localIterator = this.knownExtensions.iterator();
      do
      {
        paramClientHandshake = (ClientHandshake)localObject;
        if (!localIterator.hasNext()) {
          break;
        }
        paramClientHandshake = (IExtension)localIterator.next();
      } while (!paramClientHandshake.acceptProvidedExtensionAsClient(str));
      this.extension = paramClientHandshake;
      paramClientHandshake = HandshakeState.MATCHED;
      log.trace("acceptHandshakeAsClient - Matching extension found: {}", this.extension);
      if ((containsRequestedProtocol(paramServerHandshake.getFieldValue("Sec-WebSocket-Protocol")) == HandshakeState.MATCHED) && (paramClientHandshake == HandshakeState.MATCHED)) {
        return HandshakeState.MATCHED;
      }
      log.trace("acceptHandshakeAsClient - No matching extension or protocol found.");
      return HandshakeState.NOT_MATCHED;
    }
    log.trace("acceptHandshakeAsClient - Missing Sec-WebSocket-Key or Sec-WebSocket-Accept");
    return HandshakeState.NOT_MATCHED;
  }
  
  public HandshakeState acceptHandshakeAsServer(ClientHandshake paramClientHandshake)
  {
    if (readVersion(paramClientHandshake) != 13)
    {
      log.trace("acceptHandshakeAsServer - Wrong websocket version.");
      return HandshakeState.NOT_MATCHED;
    }
    HandshakeState localHandshakeState = HandshakeState.NOT_MATCHED;
    String str = paramClientHandshake.getFieldValue("Sec-WebSocket-Extensions");
    Iterator localIterator = this.knownExtensions.iterator();
    do
    {
      localObject = localHandshakeState;
      if (!localIterator.hasNext()) {
        break;
      }
      localObject = (IExtension)localIterator.next();
    } while (!((IExtension)localObject).acceptProvidedExtensionAsServer(str));
    this.extension = ((IExtension)localObject);
    Object localObject = HandshakeState.MATCHED;
    log.trace("acceptHandshakeAsServer - Matching extension found: {}", this.extension);
    if ((containsRequestedProtocol(paramClientHandshake.getFieldValue("Sec-WebSocket-Protocol")) == HandshakeState.MATCHED) && (localObject == HandshakeState.MATCHED)) {
      return HandshakeState.MATCHED;
    }
    log.trace("acceptHandshakeAsServer - No matching extension or protocol found.");
    return HandshakeState.NOT_MATCHED;
  }
  
  public Draft copyInstance()
  {
    ArrayList localArrayList = new ArrayList();
    Object localObject = getKnownExtensions().iterator();
    while (((Iterator)localObject).hasNext()) {
      localArrayList.add(((IExtension)((Iterator)localObject).next()).copyInstance());
    }
    localObject = new ArrayList();
    Iterator localIterator = getKnownProtocols().iterator();
    while (localIterator.hasNext()) {
      ((ArrayList)localObject).add(((IProtocol)localIterator.next()).copyInstance());
    }
    return new Draft_6455(localArrayList, (List)localObject, this.maxFrameSize);
  }
  
  public ByteBuffer createBinaryFrame(Framedata paramFramedata)
  {
    getExtension().encodeFrame(paramFramedata);
    if (log.isTraceEnabled())
    {
      Logger localLogger = log;
      int i = paramFramedata.getPayloadData().remaining();
      String str;
      if (paramFramedata.getPayloadData().remaining() > 1000) {
        str = "too big to display";
      } else {
        str = new String(paramFramedata.getPayloadData().array());
      }
      localLogger.trace("afterEnconding({}): {}", Integer.valueOf(i), str);
    }
    return createByteBufferFromFramedata(paramFramedata);
  }
  
  public List<Framedata> createFrames(String paramString, boolean paramBoolean)
  {
    TextFrame localTextFrame = new TextFrame();
    localTextFrame.setPayload(ByteBuffer.wrap(Charsetfunctions.utf8Bytes(paramString)));
    localTextFrame.setTransferemasked(paramBoolean);
    try
    {
      localTextFrame.isValid();
      return Collections.singletonList(localTextFrame);
    }
    catch (InvalidDataException paramString)
    {
      throw new NotSendableException(paramString);
    }
  }
  
  public List<Framedata> createFrames(ByteBuffer paramByteBuffer, boolean paramBoolean)
  {
    BinaryFrame localBinaryFrame = new BinaryFrame();
    localBinaryFrame.setPayload(paramByteBuffer);
    localBinaryFrame.setTransferemasked(paramBoolean);
    try
    {
      localBinaryFrame.isValid();
      return Collections.singletonList(localBinaryFrame);
    }
    catch (InvalidDataException paramByteBuffer)
    {
      throw new NotSendableException(paramByteBuffer);
    }
  }
  
  public boolean equals(Object paramObject)
  {
    if (this == paramObject) {
      return true;
    }
    if (paramObject != null)
    {
      if (getClass() != paramObject.getClass()) {
        return false;
      }
      paramObject = (Draft_6455)paramObject;
      if (this.maxFrameSize != paramObject.getMaxFrameSize()) {
        return false;
      }
      Object localObject = this.extension;
      if (localObject != null)
      {
        if (!localObject.equals(paramObject.getExtension())) {
          return false;
        }
      }
      else if (paramObject.getExtension() != null) {
        return false;
      }
      localObject = this.protocol;
      if (localObject != null) {
        return localObject.equals(paramObject.getProtocol());
      }
      return paramObject.getProtocol() == null;
    }
    return false;
  }
  
  public CloseHandshakeType getCloseHandshakeType()
  {
    return CloseHandshakeType.TWOWAY;
  }
  
  public IExtension getExtension()
  {
    return this.extension;
  }
  
  public List<IExtension> getKnownExtensions()
  {
    return this.knownExtensions;
  }
  
  public List<IProtocol> getKnownProtocols()
  {
    return this.knownProtocols;
  }
  
  public int getMaxFrameSize()
  {
    return this.maxFrameSize;
  }
  
  public IProtocol getProtocol()
  {
    return this.protocol;
  }
  
  public int hashCode()
  {
    Object localObject = this.extension;
    int j = 0;
    int i;
    if (localObject != null) {
      i = localObject.hashCode();
    } else {
      i = 0;
    }
    localObject = this.protocol;
    if (localObject != null) {
      j = localObject.hashCode();
    }
    int k = this.maxFrameSize;
    return (i * 31 + j) * 31 + (k ^ k >>> 32);
  }
  
  public ClientHandshakeBuilder postProcessHandshakeRequestAsClient(ClientHandshakeBuilder paramClientHandshakeBuilder)
  {
    paramClientHandshakeBuilder.put("Upgrade", "websocket");
    paramClientHandshakeBuilder.put("Connection", "Upgrade");
    Object localObject1 = new byte[16];
    this.reuseableRandom.nextBytes((byte[])localObject1);
    paramClientHandshakeBuilder.put("Sec-WebSocket-Key", Base64.encodeBytes((byte[])localObject1));
    paramClientHandshakeBuilder.put("Sec-WebSocket-Version", "13");
    localObject1 = new StringBuilder();
    Iterator localIterator = this.knownExtensions.iterator();
    Object localObject2;
    while (localIterator.hasNext())
    {
      localObject2 = (IExtension)localIterator.next();
      if ((((IExtension)localObject2).getProvidedExtensionAsClient() != null) && (((IExtension)localObject2).getProvidedExtensionAsClient().length() != 0))
      {
        if (((StringBuilder)localObject1).length() > 0) {
          ((StringBuilder)localObject1).append(", ");
        }
        ((StringBuilder)localObject1).append(((IExtension)localObject2).getProvidedExtensionAsClient());
      }
    }
    if (((StringBuilder)localObject1).length() != 0) {
      paramClientHandshakeBuilder.put("Sec-WebSocket-Extensions", ((StringBuilder)localObject1).toString());
    }
    localObject1 = new StringBuilder();
    localIterator = this.knownProtocols.iterator();
    while (localIterator.hasNext())
    {
      localObject2 = (IProtocol)localIterator.next();
      if (((IProtocol)localObject2).getProvidedProtocol().length() != 0)
      {
        if (((StringBuilder)localObject1).length() > 0) {
          ((StringBuilder)localObject1).append(", ");
        }
        ((StringBuilder)localObject1).append(((IProtocol)localObject2).getProvidedProtocol());
      }
    }
    if (((StringBuilder)localObject1).length() != 0) {
      paramClientHandshakeBuilder.put("Sec-WebSocket-Protocol", ((StringBuilder)localObject1).toString());
    }
    return paramClientHandshakeBuilder;
  }
  
  public HandshakeBuilder postProcessHandshakeResponseAsServer(ClientHandshake paramClientHandshake, ServerHandshakeBuilder paramServerHandshakeBuilder)
  {
    paramServerHandshakeBuilder.put("Upgrade", "websocket");
    paramServerHandshakeBuilder.put("Connection", paramClientHandshake.getFieldValue("Connection"));
    paramClientHandshake = paramClientHandshake.getFieldValue("Sec-WebSocket-Key");
    if (paramClientHandshake != null)
    {
      paramServerHandshakeBuilder.put("Sec-WebSocket-Accept", generateFinalKey(paramClientHandshake));
      if (getExtension().getProvidedExtensionAsServer().length() != 0) {
        paramServerHandshakeBuilder.put("Sec-WebSocket-Extensions", getExtension().getProvidedExtensionAsServer());
      }
      if ((getProtocol() != null) && (getProtocol().getProvidedProtocol().length() != 0)) {
        paramServerHandshakeBuilder.put("Sec-WebSocket-Protocol", getProtocol().getProvidedProtocol());
      }
      paramServerHandshakeBuilder.setHttpStatusMessage("Web Socket Protocol Handshake");
      paramServerHandshakeBuilder.put("Server", "TooTallNate Java-WebSocket");
      paramServerHandshakeBuilder.put("Date", getServerTime());
      return paramServerHandshakeBuilder;
    }
    throw new InvalidHandshakeException("missing Sec-WebSocket-Key");
  }
  
  public void processFrame(WebSocketImpl paramWebSocketImpl, Framedata paramFramedata)
  {
    Opcode localOpcode = paramFramedata.getOpcode();
    if (localOpcode == Opcode.CLOSING)
    {
      processFrameClosing(paramWebSocketImpl, paramFramedata);
      return;
    }
    if (localOpcode == Opcode.PING)
    {
      paramWebSocketImpl.getWebSocketListener().onWebsocketPing(paramWebSocketImpl, paramFramedata);
      return;
    }
    if (localOpcode == Opcode.PONG)
    {
      paramWebSocketImpl.updateLastPong();
      paramWebSocketImpl.getWebSocketListener().onWebsocketPong(paramWebSocketImpl, paramFramedata);
      return;
    }
    if ((paramFramedata.isFin()) && (localOpcode != Opcode.CONTINUOUS))
    {
      if (this.currentContinuousFrame == null)
      {
        if (localOpcode == Opcode.TEXT)
        {
          processFrameText(paramWebSocketImpl, paramFramedata);
          return;
        }
        if (localOpcode == Opcode.BINARY)
        {
          processFrameBinary(paramWebSocketImpl, paramFramedata);
          return;
        }
        log.error("non control or continious frame expected");
        throw new InvalidDataException(1002, "non control or continious frame expected");
      }
      log.error("Protocol error: Continuous frame sequence not completed.");
      throw new InvalidDataException(1002, "Continuous frame sequence not completed.");
    }
    processFrameContinuousAndNonFin(paramWebSocketImpl, paramFramedata, localOpcode);
  }
  
  public void reset()
  {
    this.incompleteframe = null;
    IExtension localIExtension = this.extension;
    if (localIExtension != null) {
      localIExtension.reset();
    }
    this.extension = new DefaultExtension();
    this.protocol = null;
  }
  
  public String toString()
  {
    Object localObject2 = super.toString();
    Object localObject1 = localObject2;
    if (getExtension() != null)
    {
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append((String)localObject2);
      ((StringBuilder)localObject1).append(" extension: ");
      ((StringBuilder)localObject1).append(getExtension().toString());
      localObject1 = ((StringBuilder)localObject1).toString();
    }
    localObject2 = localObject1;
    if (getProtocol() != null)
    {
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append((String)localObject1);
      ((StringBuilder)localObject2).append(" protocol: ");
      ((StringBuilder)localObject2).append(getProtocol().toString());
      localObject2 = ((StringBuilder)localObject2).toString();
    }
    localObject1 = new StringBuilder();
    ((StringBuilder)localObject1).append((String)localObject2);
    ((StringBuilder)localObject1).append(" max frame size: ");
    ((StringBuilder)localObject1).append(this.maxFrameSize);
    return ((StringBuilder)localObject1).toString();
  }
  
  public List<Framedata> translateFrame(ByteBuffer paramByteBuffer)
  {
    ByteBuffer localByteBuffer;
    for (;;)
    {
      LinkedList localLinkedList = new LinkedList();
      if (this.incompleteframe == null) {
        break;
      }
      try
      {
        paramByteBuffer.mark();
        int i = paramByteBuffer.remaining();
        int j = this.incompleteframe.remaining();
        if (j > i)
        {
          this.incompleteframe.put(paramByteBuffer.array(), paramByteBuffer.position(), i);
          paramByteBuffer.position(paramByteBuffer.position() + i);
          return Collections.emptyList();
        }
        this.incompleteframe.put(paramByteBuffer.array(), paramByteBuffer.position(), j);
        paramByteBuffer.position(paramByteBuffer.position() + j);
        localLinkedList.add(translateSingleFrame((ByteBuffer)this.incompleteframe.duplicate().position(0)));
        this.incompleteframe = null;
      }
      catch (IncompleteException localIncompleteException1)
      {
        localByteBuffer = ByteBuffer.allocate(checkAlloc(localIncompleteException1.getPreferredSize()));
        this.incompleteframe.rewind();
        localByteBuffer.put(this.incompleteframe);
        this.incompleteframe = localByteBuffer;
      }
    }
    while (paramByteBuffer.hasRemaining())
    {
      paramByteBuffer.mark();
      try
      {
        localByteBuffer.add(translateSingleFrame(paramByteBuffer));
      }
      catch (IncompleteException localIncompleteException2)
      {
        paramByteBuffer.reset();
        this.incompleteframe = ByteBuffer.allocate(checkAlloc(localIncompleteException2.getPreferredSize()));
        this.incompleteframe.put(paramByteBuffer);
      }
    }
    return localByteBuffer;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes20.jar
 * Qualified Name:     org.java_websocket.drafts.Draft_6455
 * JD-Core Version:    0.7.0.1
 */