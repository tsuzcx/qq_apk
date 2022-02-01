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
    for (int i = 48; paramByteBuffer.hasRemaining(); i = b)
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
    paramByteBuffer.position(paramByteBuffer.position() - localByteBuffer.position());
    return null;
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
    if (localObject != null)
    {
      String[] arrayOfString = ((String)localObject).split(" ", 3);
      if (arrayOfString.length == 3)
      {
        if (paramRole == Role.CLIENT) {
          paramRole = translateHandshakeHttpClient(arrayOfString, (String)localObject);
        } else {
          paramRole = translateHandshakeHttpServer(arrayOfString, (String)localObject);
        }
        localObject = readStringLine(paramByteBuffer);
        while ((localObject != null) && (((String)localObject).length() > 0))
        {
          localObject = ((String)localObject).split(":", 2);
          if (localObject.length == 2)
          {
            if (paramRole.hasFieldValue(localObject[0]))
            {
              arrayOfString = localObject[0];
              StringBuilder localStringBuilder = new StringBuilder();
              localStringBuilder.append(paramRole.getFieldValue(localObject[0]));
              localStringBuilder.append("; ");
              localStringBuilder.append(localObject[1].replaceFirst("^ +", ""));
              paramRole.put(arrayOfString, localStringBuilder.toString());
            }
            else
            {
              paramRole.put(localObject[0], localObject[1].replaceFirst("^ +", ""));
            }
            localObject = readStringLine(paramByteBuffer);
          }
          else
          {
            throw new InvalidHandshakeException("not an http header");
          }
        }
        if (localObject != null) {
          return paramRole;
        }
        throw new IncompleteHandshakeException();
      }
      throw new InvalidHandshakeException();
    }
    paramByteBuffer = new IncompleteHandshakeException(paramByteBuffer.capacity() + 128);
    for (;;)
    {
      throw paramByteBuffer;
    }
  }
  
  private static HandshakeBuilder translateHandshakeHttpClient(String[] paramArrayOfString, String paramString)
  {
    if ("101".equals(paramArrayOfString[1]))
    {
      if ("HTTP/1.1".equalsIgnoreCase(paramArrayOfString[0]))
      {
        paramString = new HandshakeImpl1Server();
        ServerHandshakeBuilder localServerHandshakeBuilder = (ServerHandshakeBuilder)paramString;
        localServerHandshakeBuilder.setHttpStatus(Short.parseShort(paramArrayOfString[1]));
        localServerHandshakeBuilder.setHttpStatusMessage(paramArrayOfString[2]);
        return paramString;
      }
      throw new InvalidHandshakeException(String.format("Invalid status line received: %s Status line: %s", new Object[] { paramArrayOfString[0], paramString }));
    }
    throw new InvalidHandshakeException(String.format("Invalid status code received: %s Status line: %s", new Object[] { paramArrayOfString[1], paramString }));
  }
  
  private static HandshakeBuilder translateHandshakeHttpServer(String[] paramArrayOfString, String paramString)
  {
    if ("GET".equalsIgnoreCase(paramArrayOfString[0]))
    {
      if ("HTTP/1.1".equalsIgnoreCase(paramArrayOfString[2]))
      {
        paramString = new HandshakeImpl1Client();
        paramString.setResourceDescriptor(paramArrayOfString[1]);
        return paramString;
      }
      throw new InvalidHandshakeException(String.format("Invalid status line received: %s Status line: %s", new Object[] { paramArrayOfString[2], paramString }));
    }
    throw new InvalidHandshakeException(String.format("Invalid request method received: %s Status line: %s", new Object[] { paramArrayOfString[0], paramString }));
  }
  
  public abstract HandshakeState acceptHandshakeAsClient(ClientHandshake paramClientHandshake, ServerHandshake paramServerHandshake);
  
  public abstract HandshakeState acceptHandshakeAsServer(ClientHandshake paramClientHandshake);
  
  protected boolean basicAccept(Handshakedata paramHandshakedata)
  {
    return (paramHandshakedata.getFieldValue("Upgrade").equalsIgnoreCase("websocket")) && (paramHandshakedata.getFieldValue("Connection").toLowerCase(Locale.ENGLISH).contains("upgrade"));
  }
  
  public int checkAlloc(int paramInt)
  {
    if (paramInt >= 0) {
      return paramInt;
    }
    throw new InvalidDataException(1002, "Negative count");
  }
  
  public List<Framedata> continuousFrame(Opcode paramOpcode, ByteBuffer paramByteBuffer, boolean paramBoolean)
  {
    if ((paramOpcode != Opcode.BINARY) && (paramOpcode != Opcode.TEXT)) {
      throw new IllegalArgumentException("Only Opcode.BINARY or  Opcode.TEXT are allowed");
    }
    Object localObject;
    if (this.continuousFrameType != null)
    {
      localObject = new ContinuousFrame();
    }
    else
    {
      this.continuousFrameType = paramOpcode;
      if (paramOpcode == Opcode.BINARY) {
        localObject = new BinaryFrame();
      } else if (paramOpcode == Opcode.TEXT) {
        localObject = new TextFrame();
      } else {
        localObject = null;
      }
    }
    ((DataFrame)localObject).setPayload(paramByteBuffer);
    ((DataFrame)localObject).setFin(paramBoolean);
    try
    {
      ((DataFrame)localObject).isValid();
      if (paramBoolean) {
        this.continuousFrameType = null;
      } else {
        this.continuousFrameType = paramOpcode;
      }
      return Collections.singletonList(localObject);
    }
    catch (InvalidDataException paramOpcode)
    {
      throw new IllegalArgumentException(paramOpcode);
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
    if ((paramHandshakedata instanceof ClientHandshake))
    {
      ((StringBuilder)localObject1).append("GET ");
      ((StringBuilder)localObject1).append(((ClientHandshake)paramHandshakedata).getResourceDescriptor());
      ((StringBuilder)localObject1).append(" HTTP/1.1");
    }
    else
    {
      if (!(paramHandshakedata instanceof ServerHandshake)) {
        break label259;
      }
      ((StringBuilder)localObject1).append("HTTP/1.1 101 ");
      ((StringBuilder)localObject1).append(((ServerHandshake)paramHandshakedata).getHttpStatusMessage());
    }
    ((StringBuilder)localObject1).append("\r\n");
    Object localObject2 = paramHandshakedata.iterateHttpFields();
    while (((Iterator)localObject2).hasNext())
    {
      String str1 = (String)((Iterator)localObject2).next();
      String str2 = paramHandshakedata.getFieldValue(str1);
      ((StringBuilder)localObject1).append(str1);
      ((StringBuilder)localObject1).append(": ");
      ((StringBuilder)localObject1).append(str2);
      ((StringBuilder)localObject1).append("\r\n");
    }
    ((StringBuilder)localObject1).append("\r\n");
    localObject1 = Charsetfunctions.asciiBytes(((StringBuilder)localObject1).toString());
    if (paramBoolean) {
      paramHandshakedata = paramHandshakedata.getContent();
    } else {
      paramHandshakedata = null;
    }
    int i;
    if (paramHandshakedata == null) {
      i = 0;
    } else {
      i = paramHandshakedata.length;
    }
    localObject2 = ByteBuffer.allocate(i + localObject1.length);
    ((ByteBuffer)localObject2).put((byte[])localObject1);
    if (paramHandshakedata != null) {
      ((ByteBuffer)localObject2).put(paramHandshakedata);
    }
    ((ByteBuffer)localObject2).flip();
    return Collections.singletonList(localObject2);
    label259:
    paramHandshakedata = new IllegalArgumentException("unknown role");
    for (;;)
    {
      throw paramHandshakedata;
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
    paramHandshakedata = paramHandshakedata.getFieldValue("Sec-WebSocket-Version");
    if (paramHandshakedata.length() > 0) {}
    try
    {
      int i = new Integer(paramHandshakedata.trim()).intValue();
      return i;
    }
    catch (NumberFormatException paramHandshakedata) {}
    return -1;
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     org.java_websocket.drafts.Draft
 * JD-Core Version:    0.7.0.1
 */