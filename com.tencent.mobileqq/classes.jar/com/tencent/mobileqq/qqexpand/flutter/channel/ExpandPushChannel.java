package com.tencent.mobileqq.qqexpand.flutter.channel;

import androidx.annotation.NonNull;
import com.tencent.TMG.utils.QLog;
import com.tencent.mobileqq.qqexpand.ipc.ExpandFlutterIPCClient;
import com.tencent.mobileqq.qqexpand.ipc.IExpandIpcFlutterNotifyListener.ExpandIpcFlutterNotifyListener;
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
  private EventChannel.EventSink d;
  private final IExpandIpcFlutterNotifyListener.ExpandIpcFlutterNotifyListener e = new ExpandPushChannel.1(this);
  
  public ExpandPushChannel(BinaryMessenger paramBinaryMessenger)
  {
    new EventChannel(paramBinaryMessenger, "com.tencent.qflutter/expand/event.expand_push.onPushEvent", StandardMethodCodec.INSTANCE).setStreamHandler(this);
    ExpandFlutterIPCClient.a().a(this.e);
  }
  
  public static void a(@NonNull MethodCall paramMethodCall, IExpandChannelCallback paramIExpandChannelCallback)
  {
    String str = paramMethodCall.method;
    if ("registerPushType".equals(str))
    {
      paramMethodCall = paramMethodCall.argument("pushType");
      if ((paramMethodCall instanceof Integer))
      {
        paramIExpandChannelCallback.success("");
        return;
      }
      paramIExpandChannelCallback = new StringBuilder();
      paramIExpandChannelCallback.append("[onMethodCall] param error ");
      paramIExpandChannelCallback.append(paramMethodCall);
      QLog.w("expand.ExpandPushChannel", 1, paramIExpandChannelCallback.toString());
      return;
    }
    if ("unregisterPushType".equals(str))
    {
      paramMethodCall = paramMethodCall.argument("pushType");
      if ((paramMethodCall instanceof Integer))
      {
        paramIExpandChannelCallback.success("");
        return;
      }
      paramIExpandChannelCallback = new StringBuilder();
      paramIExpandChannelCallback.append("[onMethodCall] param error ");
      paramIExpandChannelCallback.append(paramMethodCall);
      QLog.w("expand.ExpandPushChannel", 1, paramIExpandChannelCallback.toString());
      return;
    }
    paramIExpandChannelCallback.notImplemented();
  }
  
  public void a(long paramLong, byte[] paramArrayOfByte)
  {
    if (this.d != null)
    {
      HashMap localHashMap = new HashMap();
      localHashMap.put("pushType", Long.valueOf(paramLong));
      localHashMap.put("pushData", paramArrayOfByte);
      this.d.success(localHashMap);
      paramArrayOfByte = new StringBuilder();
      paramArrayOfByte.append("sendContendToFlutter pushType:");
      paramArrayOfByte.append(paramLong);
      QLog.d("expand.ExpandPushChannel", 1, paramArrayOfByte.toString());
      return;
    }
    paramArrayOfByte = new StringBuilder();
    paramArrayOfByte.append("event sink is null pushType:");
    paramArrayOfByte.append(paramLong);
    QLog.w("expand.ExpandPushChannel", 1, paramArrayOfByte.toString());
  }
  
  protected void a(@NonNull MethodCall paramMethodCall, @NonNull ExpandBaseChannel.MethodChannelResultWrapper paramMethodChannelResultWrapper)
  {
    a(paramMethodCall, new ExpandPushChannel.2(this, paramMethodChannelResultWrapper));
  }
  
  public MethodCodec b()
  {
    return StandardMethodCodec.INSTANCE;
  }
  
  public void f()
  {
    super.f();
    this.d = null;
    ExpandFlutterIPCClient.a().b(this.e);
    QLog.i("expand.ExpandPushChannel", 1, "channel destroy");
  }
  
  protected String g()
  {
    return "method.expand_push";
  }
  
  public void onCancel(Object paramObject)
  {
    if (!(paramObject instanceof String)) {
      return;
    }
    paramObject = (String)paramObject;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("onCancel ");
    localStringBuilder.append(paramObject);
    QLog.d("expand.ExpandPushChannel", 1, localStringBuilder.toString());
    if ("onPushEvent".equals(paramObject)) {
      this.d = null;
    }
  }
  
  public void onListen(Object paramObject, EventChannel.EventSink paramEventSink)
  {
    if (!(paramObject instanceof String)) {
      return;
    }
    paramObject = (String)paramObject;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("onListen ");
    localStringBuilder.append(paramObject);
    QLog.d("expand.ExpandPushChannel", 1, localStringBuilder.toString());
    if ("onPushEvent".equals(paramObject)) {
      this.d = paramEventSink;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.mobileqq.qqexpand.flutter.channel.ExpandPushChannel
 * JD-Core Version:    0.7.0.1
 */