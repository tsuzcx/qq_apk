package org.java_websocket.framing;

import java.nio.ByteBuffer;
import org.java_websocket.enums.Opcode;
import org.java_websocket.exceptions.InvalidDataException;
import org.java_websocket.exceptions.InvalidFrameException;
import org.java_websocket.util.ByteBufferUtils;
import org.java_websocket.util.Charsetfunctions;

public class CloseFrame
  extends ControlFrame
{
  public static final int ABNORMAL_CLOSE = 1006;
  public static final int BAD_GATEWAY = 1014;
  public static final int BUGGYCLOSE = -2;
  public static final int EXTENSION = 1010;
  public static final int FLASHPOLICY = -3;
  public static final int GOING_AWAY = 1001;
  public static final int NEVER_CONNECTED = -1;
  public static final int NOCODE = 1005;
  public static final int NORMAL = 1000;
  public static final int NO_UTF8 = 1007;
  public static final int POLICY_VALIDATION = 1008;
  public static final int PROTOCOL_ERROR = 1002;
  public static final int REFUSE = 1003;
  public static final int SERVICE_RESTART = 1012;
  public static final int TLS_ERROR = 1015;
  public static final int TOOBIG = 1009;
  public static final int TRY_AGAIN_LATER = 1013;
  public static final int UNEXPECTED_CONDITION = 1011;
  private int code;
  private String reason;
  
  public CloseFrame()
  {
    super(Opcode.CLOSING);
    setReason("");
    setCode(1000);
  }
  
  private void updatePayload()
  {
    byte[] arrayOfByte = Charsetfunctions.utf8Bytes(this.reason);
    ByteBuffer localByteBuffer1 = ByteBuffer.allocate(4);
    localByteBuffer1.putInt(this.code);
    localByteBuffer1.position(2);
    ByteBuffer localByteBuffer2 = ByteBuffer.allocate(arrayOfByte.length + 2);
    localByteBuffer2.put(localByteBuffer1);
    localByteBuffer2.put(arrayOfByte);
    localByteBuffer2.rewind();
    super.setPayload(localByteBuffer2);
  }
  
  private void validateUtf8(ByteBuffer paramByteBuffer, int paramInt)
  {
    try
    {
      paramByteBuffer.position(paramByteBuffer.position() + 2);
      this.reason = Charsetfunctions.stringUtf8(paramByteBuffer);
      return;
    }
    catch (IllegalArgumentException localIllegalArgumentException)
    {
      throw new InvalidDataException(1007);
    }
    finally
    {
      paramByteBuffer.position(paramInt);
    }
  }
  
  public boolean equals(Object paramObject)
  {
    boolean bool2 = true;
    boolean bool3 = false;
    boolean bool1;
    if (this == paramObject) {
      bool1 = true;
    }
    do
    {
      do
      {
        do
        {
          do
          {
            return bool1;
            bool1 = bool3;
          } while (paramObject == null);
          bool1 = bool3;
        } while (getClass() != paramObject.getClass());
        bool1 = bool3;
      } while (!super.equals(paramObject));
      paramObject = (CloseFrame)paramObject;
      bool1 = bool3;
    } while (this.code != paramObject.code);
    if (this.reason != null) {
      bool1 = this.reason.equals(paramObject.reason);
    }
    for (;;)
    {
      return bool1;
      bool1 = bool2;
      if (paramObject.reason != null) {
        bool1 = false;
      }
    }
  }
  
  public int getCloseCode()
  {
    return this.code;
  }
  
  public String getMessage()
  {
    return this.reason;
  }
  
  public ByteBuffer getPayloadData()
  {
    if (this.code == 1005) {
      return ByteBufferUtils.getEmptyByteBuffer();
    }
    return super.getPayloadData();
  }
  
  public int hashCode()
  {
    int j = super.hashCode();
    int k = this.code;
    if (this.reason != null) {}
    for (int i = this.reason.hashCode();; i = 0) {
      return i + (j * 31 + k) * 31;
    }
  }
  
  public void isValid()
  {
    super.isValid();
    if ((this.code == 1007) && (this.reason.isEmpty())) {
      throw new InvalidDataException(1007, "Received text is no valid utf8 string!");
    }
    if ((this.code == 1005) && (this.reason.length() > 0)) {
      throw new InvalidDataException(1002, "A close frame must have a closecode if it has a reason");
    }
    if ((this.code > 1015) && (this.code < 3000)) {
      throw new InvalidDataException(1002, "Trying to send an illegal close code!");
    }
    if ((this.code == 1006) || (this.code == 1015) || (this.code == 1005) || (this.code > 4999) || (this.code < 1000) || (this.code == 1004)) {
      throw new InvalidFrameException("closecode must not be sent over the wire: " + this.code);
    }
  }
  
  public void setCode(int paramInt)
  {
    this.code = paramInt;
    if (paramInt == 1015)
    {
      this.code = 1005;
      this.reason = "";
    }
    updatePayload();
  }
  
  public void setPayload(ByteBuffer paramByteBuffer)
  {
    this.code = 1005;
    this.reason = "";
    paramByteBuffer.mark();
    if (paramByteBuffer.remaining() == 0)
    {
      this.code = 1000;
      return;
    }
    if (paramByteBuffer.remaining() == 1)
    {
      this.code = 1002;
      return;
    }
    if (paramByteBuffer.remaining() >= 2)
    {
      ByteBuffer localByteBuffer = ByteBuffer.allocate(4);
      localByteBuffer.position(2);
      localByteBuffer.putShort(paramByteBuffer.getShort());
      localByteBuffer.position(0);
      this.code = localByteBuffer.getInt();
    }
    paramByteBuffer.reset();
    try
    {
      validateUtf8(paramByteBuffer, paramByteBuffer.position());
      return;
    }
    catch (InvalidDataException paramByteBuffer)
    {
      this.code = 1007;
      this.reason = null;
    }
  }
  
  public void setReason(String paramString)
  {
    String str = paramString;
    if (paramString == null) {
      str = "";
    }
    this.reason = str;
    updatePayload();
  }
  
  public String toString()
  {
    return super.toString() + "code: " + this.code;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     org.java_websocket.framing.CloseFrame
 * JD-Core Version:    0.7.0.1
 */