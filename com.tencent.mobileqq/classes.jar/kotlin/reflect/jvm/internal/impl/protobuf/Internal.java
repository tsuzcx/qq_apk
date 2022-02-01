package kotlin.reflect.jvm.internal.impl.protobuf;

import java.io.UnsupportedEncodingException;
import java.nio.ByteBuffer;

public class Internal
{
  public static final byte[] EMPTY_BYTE_ARRAY = new byte[0];
  public static final ByteBuffer EMPTY_BYTE_BUFFER = ByteBuffer.wrap(EMPTY_BYTE_ARRAY);
  
  public static boolean isValidUtf8(byte[] paramArrayOfByte)
  {
    return Utf8.isValidUtf8(paramArrayOfByte);
  }
  
  public static String toStringUtf8(byte[] paramArrayOfByte)
  {
    try
    {
      paramArrayOfByte = new String(paramArrayOfByte, "UTF-8");
      return paramArrayOfByte;
    }
    catch (UnsupportedEncodingException paramArrayOfByte)
    {
      throw new RuntimeException("UTF-8 not supported?", paramArrayOfByte);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes20.jar
 * Qualified Name:     kotlin.reflect.jvm.internal.impl.protobuf.Internal
 * JD-Core Version:    0.7.0.1
 */