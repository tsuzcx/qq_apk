package io.flutter.plugin.common;

import android.util.Log;
import androidx.annotation.UiThread;
import java.nio.ByteBuffer;

final class MethodChannel$IncomingResultHandler
  implements BinaryMessenger.BinaryReply
{
  private final MethodChannel.Result callback;
  
  MethodChannel$IncomingResultHandler(MethodChannel paramMethodChannel, MethodChannel.Result paramResult)
  {
    this.callback = paramResult;
  }
  
  @UiThread
  public void reply(ByteBuffer paramByteBuffer)
  {
    if (paramByteBuffer == null) {}
    try
    {
      this.callback.notImplemented();
      return;
    }
    catch (RuntimeException paramByteBuffer)
    {
      try
      {
        this.callback.success(MethodChannel.access$000(this.this$0).decodeEnvelope(paramByteBuffer));
        return;
      }
      catch (FlutterException paramByteBuffer)
      {
        this.callback.error(paramByteBuffer.code, paramByteBuffer.getMessage(), paramByteBuffer.details);
        return;
      }
      paramByteBuffer = paramByteBuffer;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("MethodChannel#");
      localStringBuilder.append(MethodChannel.access$100(this.this$0));
      Log.e(localStringBuilder.toString(), "Failed to handle method call result", paramByteBuffer);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     io.flutter.plugin.common.MethodChannel.IncomingResultHandler
 * JD-Core Version:    0.7.0.1
 */