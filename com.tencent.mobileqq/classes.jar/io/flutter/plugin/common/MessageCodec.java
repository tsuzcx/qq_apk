package io.flutter.plugin.common;

import androidx.annotation.Nullable;
import java.nio.ByteBuffer;

public abstract interface MessageCodec<T>
{
  @Nullable
  public abstract T decodeMessage(@Nullable ByteBuffer paramByteBuffer);
  
  @Nullable
  public abstract ByteBuffer encodeMessage(@Nullable T paramT);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     io.flutter.plugin.common.MessageCodec
 * JD-Core Version:    0.7.0.1
 */