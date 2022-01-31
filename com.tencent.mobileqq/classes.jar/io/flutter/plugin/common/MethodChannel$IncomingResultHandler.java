package io.flutter.plugin.common;

import android.support.annotation.UiThread;
import android.util.Log;
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
    for (;;)
    {
      try
      {
        this.callback.notImplemented();
        return;
      }
      catch (RuntimeException paramByteBuffer)
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("MethodChannel#");
        localStringBuilder.append(MethodChannel.access$100(this.this$0));
        Log.e(localStringBuilder.toString(), "Failed to handle method call result", paramByteBuffer);
      }
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
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     io.flutter.plugin.common.MethodChannel.IncomingResultHandler
 * JD-Core Version:    0.7.0.1
 */