package com.tencent.mobileqq.flutter.channel.expand;

import androidx.annotation.NonNull;
import com.tencent.TMG.utils.QLog;
import com.tencent.mobileqq.extendfriend.ipc.ExpandFlutterIPCClient;
import com.tencent.mobileqq.extendfriend.ipc.IExpandIpcFlutterNotifyListener.ExpandIpcFlutterNotifyListener;
import io.flutter.plugin.common.BinaryMessenger;
import io.flutter.plugin.common.EventChannel;
import io.flutter.plugin.common.EventChannel.EventSink;
import io.flutter.plugin.common.EventChannel.StreamHandler;
import io.flutter.plugin.common.MethodCall;
import io.flutter.plugin.common.MethodCodec;
import io.flutter.plugin.common.StandardMethodCodec;
import java.util.HashMap;
import java.util.Map;

public class ExpandPushChannel
  extends ExpandBaseChannel
  implements EventChannel.StreamHandler
{
  private IExpandIpcFlutterNotifyListener.ExpandIpcFlutterNotifyListener jdField_a_of_type_ComTencentMobileqqExtendfriendIpcIExpandIpcFlutterNotifyListener$ExpandIpcFlutterNotifyListener = new ExpandPushChannel.1(this);
  private EventChannel.EventSink jdField_a_of_type_IoFlutterPluginCommonEventChannel$EventSink;
  
  public ExpandPushChannel(BinaryMessenger paramBinaryMessenger)
  {
    new EventChannel(paramBinaryMessenger, "com.tencent.qflutter/expand/event.expand_push.onPushEvent", StandardMethodCodec.INSTANCE).setStreamHandler(this);
    ExpandFlutterIPCClient.a().a(this.jdField_a_of_type_ComTencentMobileqqExtendfriendIpcIExpandIpcFlutterNotifyListener$ExpandIpcFlutterNotifyListener);
  }
  
  public MethodCodec a()
  {
    return StandardMethodCodec.INSTANCE;
  }
  
  public void a()
  {
    super.a();
    this.jdField_a_of_type_IoFlutterPluginCommonEventChannel$EventSink = null;
    ExpandFlutterIPCClient.a().b(this.jdField_a_of_type_ComTencentMobileqqExtendfriendIpcIExpandIpcFlutterNotifyListener$ExpandIpcFlutterNotifyListener);
    QLog.i("expand.ExpandPushChannel", 1, "channel destroy");
  }
  
  public void a(long paramLong, byte[] paramArrayOfByte)
  {
    if (this.jdField_a_of_type_IoFlutterPluginCommonEventChannel$EventSink != null)
    {
      HashMap localHashMap = new HashMap();
      localHashMap.put("pushType", Long.valueOf(paramLong));
      localHashMap.put("pushData", paramArrayOfByte);
      this.jdField_a_of_type_IoFlutterPluginCommonEventChannel$EventSink.success(localHashMap);
      QLog.d("expand.ExpandPushChannel", 1, "sendContendToFlutter pushType:" + paramLong);
      return;
    }
    QLog.w("expand.ExpandPushChannel", 1, "event sink is null pushType:" + paramLong);
  }
  
  protected void a(@NonNull MethodCall paramMethodCall, @NonNull ExpandBaseChannel.MethodChannelResultWrapper paramMethodChannelResultWrapper)
  {
    String str = paramMethodCall.method;
    if ("registerPushType".equals(str))
    {
      paramMethodCall = paramMethodCall.argument("pushType");
      if ((paramMethodCall instanceof Integer))
      {
        paramMethodCall = (Integer)paramMethodCall;
        paramMethodChannelResultWrapper.success("");
        return;
      }
      QLog.w("expand.ExpandPushChannel", 1, "[onMethodCall] param error " + paramMethodCall);
      return;
    }
    if ("unregisterPushType".equals(str))
    {
      paramMethodCall = paramMethodCall.argument("pushType");
      if ((paramMethodCall instanceof Integer))
      {
        paramMethodCall = (Integer)paramMethodCall;
        paramMethodChannelResultWrapper.success("");
        return;
      }
      QLog.w("expand.ExpandPushChannel", 1, "[onMethodCall] param error " + paramMethodCall);
      return;
    }
    paramMethodChannelResultWrapper.notImplemented();
  }
  
  protected String c()
  {
    return "method.expand_push";
  }
  
  public void onCancel(Object paramObject)
  {
    if (!(paramObject instanceof String)) {}
    do
    {
      return;
      paramObject = (String)paramObject;
      QLog.d("expand.ExpandPushChannel", 1, "onCancel " + paramObject);
    } while (!"onPushEvent".equals(paramObject));
    this.jdField_a_of_type_IoFlutterPluginCommonEventChannel$EventSink = null;
  }
  
  public void onListen(Object paramObject, EventChannel.EventSink paramEventSink)
  {
    if (!(paramObject instanceof String)) {}
    do
    {
      return;
      paramObject = (String)paramObject;
      QLog.d("expand.ExpandPushChannel", 1, "onListen " + paramObject);
    } while (!"onPushEvent".equals(paramObject));
    this.jdField_a_of_type_IoFlutterPluginCommonEventChannel$EventSink = paramEventSink;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.flutter.channel.expand.ExpandPushChannel
 * JD-Core Version:    0.7.0.1
 */