package io.flutter.plugin.common;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.UiThread;
import java.nio.ByteBuffer;

public abstract interface BinaryMessenger
{
  @UiThread
  public abstract void send(@NonNull String paramString, @Nullable ByteBuffer paramByteBuffer);
  
  @UiThread
  public abstract void send(@NonNull String paramString, @Nullable ByteBuffer paramByteBuffer, @Nullable BinaryMessenger.BinaryReply paramBinaryReply);
  
  @UiThread
  public abstract void setMessageHandler(@NonNull String paramString, @Nullable BinaryMessenger.BinaryMessageHandler paramBinaryMessageHandler);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     io.flutter.plugin.common.BinaryMessenger
 * JD-Core Version:    0.7.0.1
 */