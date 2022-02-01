package io.flutter.plugin.common;

import android.util.Log;
import androidx.annotation.UiThread;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.nio.ByteBuffer;

final class MethodChannel$IncomingMethodCallHandler
  implements BinaryMessenger.BinaryMessageHandler
{
  private final MethodChannel.MethodCallHandler handler;
  
  MethodChannel$IncomingMethodCallHandler(MethodChannel paramMethodChannel, MethodChannel.MethodCallHandler paramMethodCallHandler)
  {
    this.handler = paramMethodCallHandler;
  }
  
  private String getStackTrace(Exception paramException)
  {
    StringWriter localStringWriter = new StringWriter();
    paramException.printStackTrace(new PrintWriter(localStringWriter));
    return localStringWriter.toString();
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
      paramBinaryReply.reply(MethodChannel.access$000(this.this$0).encodeErrorEnvelopeWithStacktrace("error", paramByteBuffer.getMessage(), null, getStackTrace(paramByteBuffer)));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     io.flutter.plugin.common.MethodChannel.IncomingMethodCallHandler
 * JD-Core Version:    0.7.0.1
 */