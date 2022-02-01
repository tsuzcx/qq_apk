package com.tencent.mobileqq.flutter.channel.expand;

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
    QLog.d("expand.ExpandChannelMethodPushModelImpl", 4, "cancel_onPushEvent" + hashCode());
    if (this.a != null)
    {
      this.a.endOfStream();
      this.a = null;
    }
  }
  
  public void doReport(String paramString, Map<String, String> paramMap)
  {
    ExpandChannelReportUtil.a(paramString, paramMap);
  }
  
  public void listen_onPushEvent(EventChannel.EventSink paramEventSink)
  {
    QLog.d("expand.ExpandChannelMethodPushModelImpl", 4, "listen_onPushEvent " + paramEventSink + " " + hashCode());
    this.a = paramEventSink;
  }
  
  public void registerPushTypeWithPushType(long paramLong, MethodChannel.Result paramResult)
  {
    QLog.d("expand.ExpandChannelMethodPushModelImpl", 4, "registerPushTypeWithPushType " + paramLong);
    paramResult.success("");
  }
  
  public void unregisterPushTypeWithPushType(long paramLong, MethodChannel.Result paramResult)
  {
    QLog.d("expand.ExpandChannelMethodPushModelImpl", 4, "unregisterPushTypeWithPushType " + paramLong);
    paramResult.success("");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.flutter.channel.expand.ExpandChannelMethodPushModelImpl
 * JD-Core Version:    0.7.0.1
 */