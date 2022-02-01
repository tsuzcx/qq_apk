package org.java_websocket.util;

import java.nio.ByteBuffer;

public class ByteBufferUtils
{
  public static ByteBuffer getEmptyByteBuffer()
  {
    return ByteBuffer.allocate(0);
  }
  
  public static int transferByteBuffer(ByteBuffer paramByteBuffer1, ByteBuffer paramByteBuffer2)
  {
    if ((paramByteBuffer1 == null) || (paramByteBuffer2 == null)) {
      throw new IllegalArgumentException();
    }
    int i = paramByteBuffer1.remaining();
    int j = paramByteBuffer2.remaining();
    if (i > j)
    {
      i = Math.min(i, j);
      paramByteBuffer1.limit(i);
      paramByteBuffer2.put(paramByteBuffer1);
      return i;
    }
    paramByteBuffer2.put(paramByteBuffer1);
    return i;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     org.java_websocket.util.ByteBufferUtils
 * JD-Core Version:    0.7.0.1
 */