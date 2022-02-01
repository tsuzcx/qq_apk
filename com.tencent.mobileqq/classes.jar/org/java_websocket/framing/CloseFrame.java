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
  
  /* Error */
  private void validateUtf8(ByteBuffer paramByteBuffer, int paramInt)
  {
    // Byte code:
    //   0: aload_1
    //   1: aload_1
    //   2: invokevirtual 112	java/nio/ByteBuffer:position	()I
    //   5: iconst_2
    //   6: iadd
    //   7: invokevirtual 90	java/nio/ByteBuffer:position	(I)Ljava/nio/Buffer;
    //   10: pop
    //   11: aload_0
    //   12: aload_1
    //   13: invokestatic 116	org/java_websocket/util/Charsetfunctions:stringUtf8	(Ljava/nio/ByteBuffer;)Ljava/lang/String;
    //   16: putfield 69	org/java_websocket/framing/CloseFrame:reason	Ljava/lang/String;
    //   19: aload_1
    //   20: iload_2
    //   21: invokevirtual 90	java/nio/ByteBuffer:position	(I)Ljava/nio/Buffer;
    //   24: pop
    //   25: return
    //   26: astore_3
    //   27: goto +14 -> 41
    //   30: new 118	org/java_websocket/exceptions/InvalidDataException
    //   33: dup
    //   34: sipush 1007
    //   37: invokespecial 120	org/java_websocket/exceptions/InvalidDataException:<init>	(I)V
    //   40: athrow
    //   41: aload_1
    //   42: iload_2
    //   43: invokevirtual 90	java/nio/ByteBuffer:position	(I)Ljava/nio/Buffer;
    //   46: pop
    //   47: aload_3
    //   48: athrow
    //   49: astore_3
    //   50: goto -20 -> 30
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	53	0	this	CloseFrame
    //   0	53	1	paramByteBuffer	ByteBuffer
    //   0	53	2	paramInt	int
    //   26	22	3	localObject	Object
    //   49	1	3	localIllegalArgumentException	java.lang.IllegalArgumentException
    // Exception table:
    //   from	to	target	type
    //   0	19	26	finally
    //   30	41	26	finally
    //   0	19	49	java/lang/IllegalArgumentException
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
      if (!super.equals(paramObject)) {
        return false;
      }
      paramObject = (CloseFrame)paramObject;
      if (this.code != paramObject.code) {
        return false;
      }
      String str = this.reason;
      if (str != null) {
        return str.equals(paramObject.reason);
      }
      return paramObject.reason == null;
    }
    return false;
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
    String str = this.reason;
    int i;
    if (str != null) {
      i = str.hashCode();
    } else {
      i = 0;
    }
    return (j * 31 + k) * 31 + i;
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
    int i = this.code;
    if ((i > 1015) && (i < 3000)) {
      throw new InvalidDataException(1002, "Trying to send an illegal close code!");
    }
    i = this.code;
    if ((i != 1006) && (i != 1015) && (i != 1005) && (i <= 4999) && (i >= 1000) && (i != 1004)) {
      return;
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("closecode must not be sent over the wire: ");
    localStringBuilder.append(this.code);
    throw new InvalidFrameException(localStringBuilder.toString());
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
      label106:
      break label106;
    }
    this.code = 1007;
    this.reason = null;
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
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(super.toString());
    localStringBuilder.append("code: ");
    localStringBuilder.append(this.code);
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes20.jar
 * Qualified Name:     org.java_websocket.framing.CloseFrame
 * JD-Core Version:    0.7.0.1
 */