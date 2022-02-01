package io.flutter.plugin.common;

import androidx.annotation.UiThread;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicReference;

final class EventChannel$IncomingStreamRequestHandler$EventSinkImplementation
  implements EventChannel.EventSink
{
  final AtomicBoolean hasEnded = new AtomicBoolean(false);
  
  private EventChannel$IncomingStreamRequestHandler$EventSinkImplementation(EventChannel.IncomingStreamRequestHandler paramIncomingStreamRequestHandler) {}
  
  @UiThread
  public void endOfStream()
  {
    if (!this.hasEnded.getAndSet(true))
    {
      if (EventChannel.IncomingStreamRequestHandler.access$300(this.this$1).get() != this) {
        return;
      }
      EventChannel.access$400(this.this$1.this$0).send(EventChannel.access$200(this.this$1.this$0), null);
    }
  }
  
  @UiThread
  public void error(String paramString1, String paramString2, Object paramObject)
  {
    if (!this.hasEnded.get())
    {
      if (EventChannel.IncomingStreamRequestHandler.access$300(this.this$1).get() != this) {
        return;
      }
      EventChannel.access$400(this.this$1.this$0).send(EventChannel.access$200(this.this$1.this$0), EventChannel.access$000(this.this$1.this$0).encodeErrorEnvelope(paramString1, paramString2, paramObject));
    }
  }
  
  @UiThread
  public void success(Object paramObject)
  {
    if (!this.hasEnded.get())
    {
      if (EventChannel.IncomingStreamRequestHandler.access$300(this.this$1).get() != this) {
        return;
      }
      EventChannel.access$400(this.this$1.this$0).send(EventChannel.access$200(this.this$1.this$0), EventChannel.access$000(this.this$1.this$0).encodeSuccessEnvelope(paramObject));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     io.flutter.plugin.common.EventChannel.IncomingStreamRequestHandler.EventSinkImplementation
 * JD-Core Version:    0.7.0.1
 */