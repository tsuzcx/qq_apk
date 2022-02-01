package org.java_websocket.drafts;

import java.nio.ByteBuffer;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import org.java_websocket.WebSocketImpl;
import org.java_websocket.enums.CloseHandshakeType;
import org.java_websocket.enums.HandshakeState;
import org.java_websocket.enums.Opcode;
import org.java_websocket.enums.Role;
import org.java_websocket.exceptions.IncompleteHandshakeException;
import org.java_websocket.exceptions.InvalidDataException;
import org.java_websocket.exceptions.InvalidHandshakeException;
import org.java_websocket.framing.BinaryFrame;
import org.java_websocket.framing.ContinuousFrame;
import org.java_websocket.framing.DataFrame;
import org.java_websocket.framing.Framedata;
import org.java_websocket.framing.TextFrame;
import org.java_websocket.handshake.ClientHandshake;
import org.java_websocket.handshake.ClientHandshakeBuilder;
import org.java_websocket.handshake.HandshakeBuilder;
import org.java_websocket.handshake.HandshakeImpl1Client;
import org.java_websocket.handshake.HandshakeImpl1Server;
import org.java_websocket.handshake.Handshakedata;
import org.java_websocket.handshake.ServerHandshake;
import org.java_websocket.handshake.ServerHandshakeBuilder;
import org.java_websocket.util.Charsetfunctions;

public abstract class Draft
{
  protected Opcode continuousFrameType = null;
  protected Role role = null;
  
  public static ByteBuffer readLine(ByteBuffer paramByteBuffer)
  {
    ByteBuffer localByteBuffer = ByteBuffer.allocate(paramByteBuffer.remaining());
    byte b;
    for (int i = 48;; i = b) {
      if (paramByteBuffer.hasRemaining())
      {
        b = paramByteBuffer.get();
        localByteBuffer.put(b);
        if ((i == 13) && (b == 10))
        {
          localByteBuffer.limit(localByteBuffer.position() - 2);
          localByteBuffer.position(0);
          return localByteBuffer;
        }
      }
      else
      {
        paramByteBuffer.position(paramByteBuffer.position() - localByteBuffer.position());
        return null;
      }
    }
  }
  
  public static String readStringLine(ByteBuffer paramByteBuffer)
  {
    paramByteBuffer = readLine(paramByteBuffer);
    if (paramByteBuffer == null) {
      return null;
    }
    return Charsetfunctions.stringAscii(paramByteBuffer.array(), 0, paramByteBuffer.limit());
  }
  
  public static HandshakeBuilder translateHandshakeHttp(ByteBuffer paramByteBuffer, Role paramRole)
  {
    Object localObject = readStringLine(paramByteBuffer);
    if (localObject == null) {
      throw new IncompleteHandshakeException(paramByteBuffer.capacity() + 128);
    }
    String[] arrayOfString = ((String)localObject).split(" ", 3);
    if (arrayOfString.length != 3) {
      throw new InvalidHandshakeException();
    }
    if (paramRole == Role.CLIENT) {}
    for (paramRole = translateHandshakeHttpClient(arrayOfString, (String)localObject);; paramRole = translateHandshakeHttpServer(arrayOfString, (String)localObject))
    {
      localObject = readStringLine(paramByteBuffer);
      if ((localObject == null) || (((String)localObject).length() <= 0)) {
        break label200;
      }
      localObject = ((String)localObject).split(":", 2);
      if (localObject.length == 2) {
        break;
      }
      throw new InvalidHandshakeException("not an http header");
    }
    if (paramRole.hasFieldValue(localObject[0])) {
      paramRole.put(localObject[0], paramRole.getFieldValue(localObject[0]) + "; " + localObject[1].replaceFirst("^ +", ""));
    }
    for (;;)
    {
      localObject = readStringLine(paramByteBuffer);
      break;
      paramRole.put(localObject[0], localObject[1].replaceFirst("^ +", ""));
    }
    label200:
    if (localObject == null) {
      throw new IncompleteHandshakeException();
    }
    return paramRole;
  }
  
  private static HandshakeBuilder translateHandshakeHttpClient(String[] paramArrayOfString, String paramString)
  {
    if (!"101".equals(paramArrayOfString[1])) {
      throw new InvalidHandshakeException(String.format("Invalid status code received: %s Status line: %s", new Object[] { paramArrayOfString[1], paramString }));
    }
    if (!"HTTP/1.1".equalsIgnoreCase(paramArrayOfString[0])) {
      throw new InvalidHandshakeException(String.format("Invalid status line received: %s Status line: %s", new Object[] { paramArrayOfString[0], paramString }));
    }
    paramString = new HandshakeImpl1Server();
    ServerHandshakeBuilder localServerHandshakeBuilder = (ServerHandshakeBuilder)paramString;
    localServerHandshakeBuilder.setHttpStatus(Short.parseShort(paramArrayOfString[1]));
    localServerHandshakeBuilder.setHttpStatusMessage(paramArrayOfString[2]);
    return paramString;
  }
  
  private static HandshakeBuilder translateHandshakeHttpServer(String[] paramArrayOfString, String paramString)
  {
    if (!"GET".equalsIgnoreCase(paramArrayOfString[0])) {
      throw new InvalidHandshakeException(String.format("Invalid request method received: %s Status line: %s", new Object[] { paramArrayOfString[0], paramString }));
    }
    if (!"HTTP/1.1".equalsIgnoreCase(paramArrayOfString[2])) {
      throw new InvalidHandshakeException(String.format("Invalid status line received: %s Status line: %s", new Object[] { paramArrayOfString[2], paramString }));
    }
    paramString = new HandshakeImpl1Client();
    paramString.setResourceDescriptor(paramArrayOfString[1]);
    return paramString;
  }
  
  public abstract HandshakeState acceptHandshakeAsClient(ClientHandshake paramClientHandshake, ServerHandshake paramServerHandshake);
  
  public abstract HandshakeState acceptHandshakeAsServer(ClientHandshake paramClientHandshake);
  
  protected boolean basicAccept(Handshakedata paramHandshakedata)
  {
    return (paramHandshakedata.getFieldValue("Upgrade").equalsIgnoreCase("websocket")) && (paramHandshakedata.getFieldValue("Connection").toLowerCase(Locale.ENGLISH).contains("upgrade"));
  }
  
  public int checkAlloc(int paramInt)
  {
    if (paramInt < 0) {
      throw new InvalidDataException(1002, "Negative count");
    }
    return paramInt;
  }
  
  public List<Framedata> continuousFrame(Opcode paramOpcode, ByteBuffer paramByteBuffer, boolean paramBoolean)
  {
    if ((paramOpcode != Opcode.BINARY) && (paramOpcode != Opcode.TEXT)) {
      throw new IllegalArgumentException("Only Opcode.BINARY or  Opcode.TEXT are allowed");
    }
    Object localObject;
    if (this.continuousFrameType != null) {
      localObject = new ContinuousFrame();
    }
    for (;;)
    {
      ((DataFrame)localObject).setPayload(paramByteBuffer);
      ((DataFrame)localObject).setFin(paramBoolean);
      for (;;)
      {
        try
        {
          ((DataFrame)localObject).isValid();
          if (!paramBoolean) {
            break label125;
          }
          this.continuousFrameType = null;
          return Collections.singletonList(localObject);
        }
        catch (InvalidDataException paramOpcode)
        {
          throw new IllegalArgumentException(paramOpcode);
        }
        this.continuousFrameType = paramOpcode;
        if (paramOpcode == Opcode.BINARY)
        {
          localObject = new BinaryFrame();
          break;
        }
        if (paramOpcode != Opcode.TEXT) {
          break label133;
        }
        localObject = new TextFrame();
        break;
        label125:
        this.continuousFrameType = paramOpcode;
      }
      label133:
      localObject = null;
    }
  }
  
  public abstract Draft copyInstance();
  
  public abstract ByteBuffer createBinaryFrame(Framedata paramFramedata);
  
  public abstract List<Framedata> createFrames(String paramString, boolean paramBoolean);
  
  public abstract List<Framedata> createFrames(ByteBuffer paramByteBuffer, boolean paramBoolean);
  
  public List<ByteBuffer> createHandshake(Handshakedata paramHandshakedata)
  {
    return createHandshake(paramHandshakedata, true);
  }
  
  @Deprecated
  public List<ByteBuffer> createHandshake(Handshakedata paramHandshakedata, Role paramRole)
  {
    return createHandshake(paramHandshakedata);
  }
  
  @Deprecated
  public List<ByteBuffer> createHandshake(Handshakedata paramHandshakedata, Role paramRole, boolean paramBoolean)
  {
    return createHandshake(paramHandshakedata, paramBoolean);
  }
  
  public List<ByteBuffer> createHandshake(Handshakedata paramHandshakedata, boolean paramBoolean)
  {
    Object localObject1 = new StringBuilder(100);
    if ((paramHandshakedata instanceof ClientHandshake)) {
      ((StringBuilder)localObject1).append("GET ").append(((ClientHandshake)paramHandshakedata).getResourceDescriptor()).append(" HTTP/1.1");
    }
    Object localObject2;
    for (;;)
    {
      ((StringBuilder)localObject1).append("\r\n");
      localObject2 = paramHandshakedata.iterateHttpFields();
      while (((Iterator)localObject2).hasNext())
      {
        String str1 = (String)((Iterator)localObject2).next();
        String str2 = paramHandshakedata.getFieldValue(str1);
        ((StringBuilder)localObject1).append(str1);
        ((StringBuilder)localObject1).append(": ");
        ((StringBuilder)localObject1).append(str2);
        ((StringBuilder)localObject1).append("\r\n");
      }
      if (!(paramHandshakedata instanceof ServerHandshake)) {
        break;
      }
      ((StringBuilder)localObject1).append("HTTP/1.1 101 ").append(((ServerHandshake)paramHandshakedata).getHttpStatusMessage());
    }
    throw new IllegalArgumentException("unknown role");
    ((StringBuilder)localObject1).append("\r\n");
    localObject1 = Charsetfunctions.asciiBytes(((StringBuilder)localObject1).toString());
    if (paramBoolean)
    {
      paramHandshakedata = paramHandshakedata.getContent();
      if (paramHandshakedata != null) {
        break label255;
      }
    }
    label255:
    for (int i = 0;; i = paramHandshakedata.length)
    {
      localObject2 = ByteBuffer.allocate(i + localObject1.length);
      ((ByteBuffer)localObject2).put((byte[])localObject1);
      if (paramHandshakedata != null) {
        ((ByteBuffer)localObject2).put(paramHandshakedata);
      }
      ((ByteBuffer)localObject2).flip();
      return Collections.singletonList(localObject2);
      paramHandshakedata = null;
      break;
    }
  }
  
  public abstract CloseHandshakeType getCloseHandshakeType();
  
  public Role getRole()
  {
    return this.role;
  }
  
  public abstract ClientHandshakeBuilder postProcessHandshakeRequestAsClient(ClientHandshakeBuilder paramClientHandshakeBuilder);
  
  public abstract HandshakeBuilder postProcessHandshakeResponseAsServer(ClientHandshake paramClientHandshake, ServerHandshakeBuilder paramServerHandshakeBuilder);
  
  public abstract void processFrame(WebSocketImpl paramWebSocketImpl, Framedata paramFramedata);
  
  int readVersion(Handshakedata paramHandshakedata)
  {
    int i = -1;
    paramHandshakedata = paramHandshakedata.getFieldValue("Sec-WebSocket-Version");
    if (paramHandshakedata.length() > 0) {}
    try
    {
      i = new Integer(paramHandshakedata.trim()).intValue();
      return i;
    }
    catch (NumberFormatException paramHandshakedata) {}
    return -1;
  }
  
  public abstract void reset();
  
  public void setParseMode(Role paramRole)
  {
    this.role = paramRole;
  }
  
  public String toString()
  {
    return getClass().getSimpleName();
  }
  
  public abstract List<Framedata> translateFrame(ByteBuffer paramByteBuffer);
  
  public Handshakedata translateHandshake(ByteBuffer paramByteBuffer)
  {
    return translateHandshakeHttp(paramByteBuffer, this.role);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     org.java_websocket.drafts.Draft
 * JD-Core Version:    0.7.0.1
 */