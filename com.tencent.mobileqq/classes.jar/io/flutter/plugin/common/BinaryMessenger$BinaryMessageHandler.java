package io.flutter.plugin.common;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.annotation.UiThread;
import java.nio.ByteBuffer;

public abstract interface BinaryMessenger$BinaryMessageHandler
{
  @UiThread
  public abstract void onMessage(@Nullable ByteBuffer paramByteBuffer, @NonNull BinaryMessenger.BinaryReply paramBinaryReply);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     io.flutter.plugin.common.BinaryMessenger.BinaryMessageHandler
 * JD-Core Version:    0.7.0.1
 */