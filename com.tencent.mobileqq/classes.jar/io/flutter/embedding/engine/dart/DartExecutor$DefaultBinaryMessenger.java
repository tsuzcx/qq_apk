package io.flutter.embedding.engine.dart;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.UiThread;
import io.flutter.plugin.common.BinaryMessenger;
import io.flutter.plugin.common.BinaryMessenger.BinaryMessageHandler;
import io.flutter.plugin.common.BinaryMessenger.BinaryReply;
import java.nio.ByteBuffer;

class DartExecutor$DefaultBinaryMessenger
  implements BinaryMessenger
{
  private final DartMessenger messenger;
  
  private DartExecutor$DefaultBinaryMessenger(@NonNull DartMessenger paramDartMessenger)
  {
    this.messenger = paramDartMessenger;
  }
  
  @UiThread
  public void send(@NonNull String paramString, @Nullable ByteBuffer paramByteBuffer)
  {
    this.messenger.send(paramString, paramByteBuffer, null);
  }
  
  @UiThread
  public void send(@NonNull String paramString, @Nullable ByteBuffer paramByteBuffer, @Nullable BinaryMessenger.BinaryReply paramBinaryReply)
  {
    this.messenger.send(paramString, paramByteBuffer, paramBinaryReply);
  }
  
  @UiThread
  public void setMessageHandler(@NonNull String paramString, @Nullable BinaryMessenger.BinaryMessageHandler paramBinaryMessageHandler)
  {
    this.messenger.setMessageHandler(paramString, paramBinaryMessageHandler);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     io.flutter.embedding.engine.dart.DartExecutor.DefaultBinaryMessenger
 * JD-Core Version:    0.7.0.1
 */