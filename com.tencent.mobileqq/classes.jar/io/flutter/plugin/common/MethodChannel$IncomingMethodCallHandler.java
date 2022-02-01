package io.flutter.plugin.common;

import android.util.Log;
import androidx.annotation.UiThread;
import java.nio.ByteBuffer;

final class MethodChannel$IncomingMethodCallHandler
  implements BinaryMessenger.BinaryMessageHandler
{
  private final MethodChannel.MethodCallHandler handler;
  
  MethodChannel$IncomingMethodCallHandler(MethodChannel paramMethodChannel, MethodChannel.MethodCallHandler paramMethodCallHandler)
  {
    this.handler = paramMethodCallHandler;
  }
  
  @UiThread
  public void onMessage(ByteBuffer paramByteBuffer, BinaryMessenger.BinaryReply paramBinaryReply)
  {
    paramByteBuffer = MethodChannel.access$000(this.this$0).decodeMethodCall(paramByteBuffer);
    try
    {
      this.handler.onMethodCall(paramByteBuffer, new MethodChannel.IncomingMethodCallHandler.1(this, paramBinaryReply));
      return;
    }
    catch (RuntimeException paramByteBuffer)
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("MethodChannel#");
      localStringBuilder.append(MethodChannel.access$100(this.this$0));
      Log.e(localStringBuilder.toString(), "Failed to handle method call", paramByteBuffer);
      paramBinaryReply.reply(MethodChannel.access$000(this.this$0).encodeErrorEnvelope("error", paramByteBuffer.getMessage(), null));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     io.flutter.plugin.common.MethodChannel.IncomingMethodCallHandler
 * JD-Core Version:    0.7.0.1
 */