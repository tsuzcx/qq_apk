package io.flutter.plugin.common;

import android.support.annotation.Nullable;
import android.support.annotation.UiThread;
import java.nio.ByteBuffer;

public abstract interface BinaryMessenger$BinaryReply
{
  @UiThread
  public abstract void reply(@Nullable ByteBuffer paramByteBuffer);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     io.flutter.plugin.common.BinaryMessenger.BinaryReply
 * JD-Core Version:    0.7.0.1
 */