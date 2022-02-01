package com.tencent.mobileqq.qqexpand.flutter.channel.redpoint;

import com.tencent.mobileqq.qqexpand.flutter.channel.ExpandChannelReportUtil;
import com.tencent.mobileqq.qqexpand.utils.ILog;
import com.tencent.mobileqq.qqexpand.utils.LogUtils;
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
    Iterator localIterator = ((Iterable)this.this$0.a()).iterator();
    int i = 0;
    while (localIterator.hasNext())
    {
      Object localObject1 = localIterator.next();
      if (i < 0) {
        CollectionsKt.throwIndexOverflow();
      }
      localObject1 = (EventChannel.EventSink)localObject1;
      Object localObject2 = LogUtils.a;
      StringBuilder localStringBuilder;
      if (QLog.isColorLevel())
      {
        localObject2 = ((LogUtils)localObject2).a();
        localStringBuilder = new StringBuilder();
        localStringBuilder.append('[');
        localStringBuilder.append(i);
        localStringBuilder.append("] onRedDotChange callback from native! value=");
        localStringBuilder.append(this.a);
        ((ILog)localObject2).a("ExpandRedPointApiChannel", 2, localStringBuilder.toString());
      }
      ExpandChannelReportUtil.a("com.tencent.qflutter/expand/event.expand_red_dot.onRedDotChange", "OnRedDotChange", "event");
      try
      {
        ((EventChannel.EventSink)localObject1).success(Long.valueOf(this.a));
        ExpandChannelReportUtil.b("com.tencent.qflutter/expand/event.expand_red_dot.onRedDotChange", "OnRedDotChange", "event");
      }
      catch (Exception localException)
      {
        localObject2 = LogUtils.a.a();
        localStringBuilder = new StringBuilder();
        localStringBuilder.append('[');
        localStringBuilder.append(i);
        localStringBuilder.append("] onRedDotChange callback from native! value=");
        localStringBuilder.append(this.a);
        localStringBuilder.append(" with error!");
        ((ILog)localObject2).a("ExpandRedPointApiChannel", 1, localStringBuilder.toString(), (Throwable)localException);
      }
      i += 1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.mobileqq.qqexpand.flutter.channel.redpoint.ExpandRedPointApiChannel.OnRedDotChangeStreamHandler.dispatchRedPoint.1
 * JD-Core Version:    0.7.0.1
 */