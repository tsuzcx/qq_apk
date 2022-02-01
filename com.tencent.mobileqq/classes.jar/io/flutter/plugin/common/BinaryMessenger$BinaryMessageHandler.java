package io.flutter.plugin.common;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.UiThread;
import java.nio.ByteBuffer;

public abstract interface BinaryMessenger$BinaryMessageHandler
{
  @UiThread
  public abstract void onMessage(@Nullable ByteBuffer paramByteBuffer, @NonNull BinaryMessenger.BinaryReply paramBinaryReply);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     io.flutter.plugin.common.BinaryMessenger.BinaryMessageHandler
 * JD-Core Version:    0.7.0.1
 */