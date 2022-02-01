package com.tencent.mobileqq.flutter.channel.expand.redpoint;

import com.tencent.biz.expand.utils.LogUtils;
import com.tencent.mobileqq.flutter.channel.expand.ExpandChannelReportUtil;
import com.tencent.qphone.base.util.QLog;
import io.flutter.plugin.common.EventChannel.EventSink;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"<anonymous>", "", "run"}, k=3, mv={1, 1, 16})
final class ExpandRedPointApiChannel$OnRedDotChangeStreamHandler$dispatchRedPoint$1
  implements Runnable
{
  ExpandRedPointApiChannel$OnRedDotChangeStreamHandler$dispatchRedPoint$1(ExpandRedPointApiChannel.OnRedDotChangeStreamHandler paramOnRedDotChangeStreamHandler, long paramLong) {}
  
  public final void run()
  {
    Object localObject1 = (Iterable)this.this$0.a();
    int i = 0;
    localObject1 = ((Iterable)localObject1).iterator();
    for (;;)
    {
      if (((Iterator)localObject1).hasNext())
      {
        Object localObject2 = ((Iterator)localObject1).next();
        if (i < 0) {
          CollectionsKt.throwIndexOverflow();
        }
        localObject2 = (EventChannel.EventSink)localObject2;
        LogUtils localLogUtils = LogUtils.a;
        if (QLog.isColorLevel()) {
          QLog.d("ExpandRedPointApiChannel", 2, '[' + i + "] onRedDotChange callback from native! value=" + this.a);
        }
        ExpandChannelReportUtil.a("com.tencent.qflutter/expand/event.expand_red_dot.onRedDotChange", "OnRedDotChange", "event");
        try
        {
          ((EventChannel.EventSink)localObject2).success(Long.valueOf(this.a));
          ExpandChannelReportUtil.b("com.tencent.qflutter/expand/event.expand_red_dot.onRedDotChange", "OnRedDotChange", "event");
          i += 1;
        }
        catch (Exception localException)
        {
          for (;;)
          {
            localLogUtils = LogUtils.a;
            QLog.e("ExpandRedPointApiChannel", 1, '[' + i + "] onRedDotChange callback from native! value=" + this.a + " with error!", (Throwable)localException);
          }
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.flutter.channel.expand.redpoint.ExpandRedPointApiChannel.OnRedDotChangeStreamHandler.dispatchRedPoint.1
 * JD-Core Version:    0.7.0.1
 */