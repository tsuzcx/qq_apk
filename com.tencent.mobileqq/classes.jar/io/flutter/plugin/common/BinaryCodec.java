package io.flutter.plugin.common;

import java.nio.ByteBuffer;

public final class BinaryCodec
  implements MessageCodec<ByteBuffer>
{
  public static final BinaryCodec INSTANCE = new BinaryCodec();
  
  public ByteBuffer decodeMessage(ByteBuffer paramByteBuffer)
  {
    return paramByteBuffer;
  }
  
  public ByteBuffer encodeMessage(ByteBuffer paramByteBuffer)
  {
    return paramByteBuffer;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     io.flutter.plugin.common.BinaryCodec
 * JD-Core Version:    0.7.0.1
 */