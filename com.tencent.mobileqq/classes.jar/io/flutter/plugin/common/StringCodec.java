package io.flutter.plugin.common;

import java.nio.ByteBuffer;
import java.nio.charset.Charset;

public final class StringCodec
  implements MessageCodec<String>
{
  public static final StringCodec INSTANCE = new StringCodec();
  private static final Charset UTF8 = Charset.forName("UTF8");
  
  public String decodeMessage(ByteBuffer paramByteBuffer)
  {
    if (paramByteBuffer == null) {
      return null;
    }
    int j = paramByteBuffer.remaining();
    byte[] arrayOfByte;
    int i;
    if (paramByteBuffer.hasArray())
    {
      arrayOfByte = paramByteBuffer.array();
      i = paramByteBuffer.arrayOffset();
    }
    for (paramByteBuffer = arrayOfByte;; paramByteBuffer = arrayOfByte)
    {
      return new String(paramByteBuffer, i, j, UTF8);
      arrayOfByte = new byte[j];
      paramByteBuffer.get(arrayOfByte);
      i = 0;
    }
  }
  
  public ByteBuffer encodeMessage(String paramString)
  {
    if (paramString == null) {
      return null;
    }
    paramString = paramString.getBytes(UTF8);
    ByteBuffer localByteBuffer = ByteBuffer.allocateDirect(paramString.length);
    localByteBuffer.put(paramString);
    return localByteBuffer;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     io.flutter.plugin.common.StringCodec
 * JD-Core Version:    0.7.0.1
 */