package com.tencent.qqexpand;

import android.util.Log;
import androidx.annotation.NonNull;
import io.flutter.plugin.common.BinaryMessenger;
import io.flutter.plugin.common.EventChannel;
import io.flutter.plugin.common.EventChannel.EventSink;
import io.flutter.plugin.common.EventChannel.StreamHandler;
import io.flutter.plugin.common.MethodCall;
import io.flutter.plugin.common.MethodChannel;
import io.flutter.plugin.common.MethodCodec;
import io.flutter.plugin.common.StandardMethodCodec;

public class FlutterPushModuleProtocol
  extends FlutterPlatformProtocolBase
  implements EventChannel.StreamHandler
{
  public static final MethodCodec EVENT_CHANNEL_CODEC = StandardMethodCodec.INSTANCE;
  public static final String EVENT_CHANNEL_NAME = "com.tencent.qflutter/expand/event.expand_push.onPushEvent";
  public static final String EVENT_ON_PUSH_EVENT = "onPushEvent";
  public static final MethodCodec METHOD_CHANNEL_CODEC = StandardMethodCodec.INSTANCE;
  public static final String METHOD_CHANNEL_NAME = "com.tencent.qflutter/expand/method.expand_push";
  public static final String TAG = "Expand.PushModulePro";
  private FlutterPushModuleProtocol.PushModuleDelegate mDelegate;
  private EventChannel mEventChannel;
  private EventChannel.EventSink mEventSink;
  private MethodChannel mMethodChannel;
  
  public FlutterPushModuleProtocol(BinaryMessenger paramBinaryMessenger)
  {
    super(paramBinaryMessenger);
    this.mChannelName = "com.tencent.qflutter/expand/method.expand_push";
  }
  
  protected void doOnMethodCall(@NonNull MethodCall paramMethodCall, @NonNull FlutterPlatformProtocolBase.MethodChannelResultWrapper paramMethodChannelResultWrapper)
  {
    String str = paramMethodCall.method;
    int i;
    if ("registerPushType".equals(str))
    {
      paramMethodCall = paramMethodCall.argument("pushType");
      if ((paramMethodCall instanceof Integer))
      {
        i = ((Integer)paramMethodCall).intValue();
        if (this.mDelegate != null) {
          this.mDelegate.registerPushTypeWithPushType(i, paramMethodChannelResultWrapper);
        }
      }
    }
    do
    {
      return;
      paramMethodChannelResultWrapper = new StringBuilder();
      paramMethodChannelResultWrapper.append("[onMethodCall] param error ");
      paramMethodChannelResultWrapper.append(paramMethodCall);
      Log.w("Expand.PushModulePro", paramMethodChannelResultWrapper.toString());
      return;
      if (!"unregisterPushType".equals(str)) {
        break label174;
      }
      paramMethodCall = paramMethodCall.argument("pushType");
      if (!(paramMethodCall instanceof Integer)) {
        break;
      }
      i = ((Integer)paramMethodCall).intValue();
    } while (this.mDelegate == null);
    this.mDelegate.unregisterPushTypeWithPushType(i, paramMethodChannelResultWrapper);
    return;
    paramMethodChannelResultWrapper = new StringBuilder();
    paramMethodChannelResultWrapper.append("[onMethodCall] param error ");
    paramMethodChannelResultWrapper.append(paramMethodCall);
    Log.w("Expand.PushModulePro", paramMethodChannelResultWrapper.toString());
    return;
    label174:
    paramMethodChannelResultWrapper.notImplemented();
  }
  
  public void onCancel(Object paramObject)
  {
    if (!(paramObject instanceof String)) {}
    do
    {
      do
      {
        return;
        paramObject = (String)paramObject;
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("onCancel ");
        localStringBuilder.append(paramObject);
        Log.d("Expand.PushModulePro", localStringBuilder.toString());
      } while (!"onPushEvent".equals(paramObject));
      this.mEventSink = null;
    } while (this.mDelegate == null);
    this.mDelegate.cancel_onPushEvent();
  }
  
  public void onDestroy()
  {
    Log.i("Expand.PushModulePro", "onDestroy");
    this.mMethodChannel.setMethodCallHandler(null);
    this.mEventChannel.setStreamHandler(null);
    this.mDelegate = null;
  }
  
  public void onInit(BinaryMessenger paramBinaryMessenger)
  {
    this.mMethodChannel = new MethodChannel(paramBinaryMessenger, "com.tencent.qflutter/expand/method.expand_push", METHOD_CHANNEL_CODEC);
    this.mMethodChannel.setMethodCallHandler(this);
    this.mEventChannel = new EventChannel(paramBinaryMessenger, "com.tencent.qflutter/expand/event.expand_push.onPushEvent", EVENT_CHANNEL_CODEC);
    this.mEventChannel.setStreamHandler(this);
  }
  
  public void onListen(Object paramObject, EventChannel.EventSink paramEventSink)
  {
    if (!(paramObject instanceof String)) {}
    do
    {
      do
      {
        return;
        paramObject = (String)paramObject;
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("onListen ");
        localStringBuilder.append(paramObject);
        Log.d("Expand.PushModulePro", localStringBuilder.toString());
      } while (!"onPushEvent".equals(paramObject));
      this.mEventSink = paramEventSink;
    } while (this.mDelegate == null);
    this.mDelegate.listen_onPushEvent(paramEventSink);
  }
  
  public void setPushModuleDelegate(FlutterPushModuleProtocol.PushModuleDelegate paramPushModuleDelegate)
  {
    Log.d("Expand.PushModulePro", "setPushModuleDelegate");
    setApiDelegate(paramPushModuleDelegate);
    this.mDelegate = paramPushModuleDelegate;
    if (this.mEventSink != null) {
      this.mDelegate.listen_onPushEvent(this.mEventSink);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.qqexpand.FlutterPushModuleProtocol
 * JD-Core Version:    0.7.0.1
 */