package io.flutter.plugin.common;

import android.util.Log;
import java.nio.ByteBuffer;
import java.util.concurrent.atomic.AtomicReference;

final class EventChannel$IncomingStreamRequestHandler
  implements BinaryMessenger.BinaryMessageHandler
{
  private final AtomicReference<EventChannel.EventSink> activeSink = new AtomicReference(null);
  private final EventChannel.StreamHandler handler;
  
  EventChannel$IncomingStreamRequestHandler(EventChannel paramEventChannel, EventChannel.StreamHandler paramStreamHandler)
  {
    this.handler = paramStreamHandler;
  }
  
  private void onCancel(Object paramObject, BinaryMessenger.BinaryReply paramBinaryReply)
  {
    if ((EventChannel.EventSink)this.activeSink.getAndSet(null) != null) {
      try
      {
        this.handler.onCancel(paramObject);
        paramBinaryReply.reply(EventChannel.access$000(this.this$0).encodeSuccessEnvelope(null));
        return;
      }
      catch (RuntimeException paramObject)
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("EventChannel#");
        localStringBuilder.append(EventChannel.access$200(this.this$0));
        Log.e(localStringBuilder.toString(), "Failed to close event stream", paramObject);
        paramObject = EventChannel.access$000(this.this$0).encodeErrorEnvelope("error", paramObject.getMessage(), null);
      }
    } else {
      paramObject = EventChannel.access$000(this.this$0).encodeErrorEnvelope("error", "No active stream to cancel", null);
    }
    paramBinaryReply.reply(paramObject);
  }
  
  private void onListen(Object paramObject, BinaryMessenger.BinaryReply paramBinaryReply)
  {
    Object localObject = new EventChannel.IncomingStreamRequestHandler.EventSinkImplementation(this, null);
    if ((EventChannel.EventSink)this.activeSink.getAndSet(localObject) != null) {
      try
      {
        this.handler.onCancel(null);
      }
      catch (RuntimeException localRuntimeException)
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("EventChannel#");
        localStringBuilder.append(EventChannel.access$200(this.this$0));
        Log.e(localStringBuilder.toString(), "Failed to close existing event stream", localRuntimeException);
      }
    }
    try
    {
      this.handler.onListen(paramObject, (EventChannel.EventSink)localObject);
      paramBinaryReply.reply(EventChannel.access$000(this.this$0).encodeSuccessEnvelope(null));
      return;
    }
    catch (RuntimeException paramObject)
    {
      this.activeSink.set(null);
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("EventChannel#");
      ((StringBuilder)localObject).append(EventChannel.access$200(this.this$0));
      Log.e(((StringBuilder)localObject).toString(), "Failed to open event stream", paramObject);
      paramBinaryReply.reply(EventChannel.access$000(this.this$0).encodeErrorEnvelope("error", paramObject.getMessage(), null));
    }
  }
  
  public void onMessage(ByteBuffer paramByteBuffer, BinaryMessenger.BinaryReply paramBinaryReply)
  {
    paramByteBuffer = EventChannel.access$000(this.this$0).decodeMethodCall(paramByteBuffer);
    if (paramByteBuffer.method.equals("listen"))
    {
      onListen(paramByteBuffer.arguments, paramBinaryReply);
      return;
    }
    if (paramByteBuffer.method.equals("cancel"))
    {
      onCancel(paramByteBuffer.arguments, paramBinaryReply);
      return;
    }
    paramBinaryReply.reply(null);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     io.flutter.plugin.common.EventChannel.IncomingStreamRequestHandler
 * JD-Core Version:    0.7.0.1
 */