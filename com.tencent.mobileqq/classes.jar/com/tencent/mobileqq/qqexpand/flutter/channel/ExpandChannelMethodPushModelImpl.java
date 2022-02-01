package com.tencent.mobileqq.qqexpand.flutter.channel;

import com.tencent.qphone.base.util.QLog;
import com.tencent.qqexpand.FlutterPushModuleProtocol.PushModuleDelegate;
import io.flutter.plugin.common.EventChannel.EventSink;
import io.flutter.plugin.common.MethodChannel.Result;
import java.util.Map;

public class ExpandChannelMethodPushModelImpl
  implements FlutterPushModuleProtocol.PushModuleDelegate
{
  private EventChannel.EventSink a;
  
  public void cancel_onPushEvent()
  {
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("cancel_onPushEvent");
    ((StringBuilder)localObject).append(hashCode());
    QLog.d("expand.ExpandChannelMethodPushModelImpl", 4, ((StringBuilder)localObject).toString());
    localObject = this.a;
    if (localObject != null)
    {
      ((EventChannel.EventSink)localObject).endOfStream();
      this.a = null;
    }
  }
  
  public void doReport(String paramString, Map<String, String> paramMap)
  {
    ExpandChannelReportUtil.a(paramString, paramMap);
  }
  
  public void listen_onPushEvent(EventChannel.EventSink paramEventSink)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("listen_onPushEvent ");
    localStringBuilder.append(paramEventSink);
    localStringBuilder.append(" ");
    localStringBuilder.append(hashCode());
    QLog.d("expand.ExpandChannelMethodPushModelImpl", 4, localStringBuilder.toString());
    this.a = paramEventSink;
  }
  
  public void registerPushTypeWithPushType(long paramLong, MethodChannel.Result paramResult)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("registerPushTypeWithPushType ");
    localStringBuilder.append(paramLong);
    QLog.d("expand.ExpandChannelMethodPushModelImpl", 4, localStringBuilder.toString());
    paramResult.success("");
  }
  
  public void unregisterPushTypeWithPushType(long paramLong, MethodChannel.Result paramResult)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("unregisterPushTypeWithPushType ");
    localStringBuilder.append(paramLong);
    QLog.d("expand.ExpandChannelMethodPushModelImpl", 4, localStringBuilder.toString());
    paramResult.success("");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.mobileqq.qqexpand.flutter.channel.ExpandChannelMethodPushModelImpl
 * JD-Core Version:    0.7.0.1
 */