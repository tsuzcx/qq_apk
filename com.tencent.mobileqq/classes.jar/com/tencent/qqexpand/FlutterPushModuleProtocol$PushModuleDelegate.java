package com.tencent.qqexpand;

import io.flutter.plugin.common.EventChannel.EventSink;
import io.flutter.plugin.common.MethodChannel.Result;

public abstract interface FlutterPushModuleProtocol$PushModuleDelegate
  extends IBaseApiDelegate
{
  public abstract void cancel_onPushEvent();
  
  public abstract void listen_onPushEvent(EventChannel.EventSink paramEventSink);
  
  public abstract void registerPushTypeWithPushType(long paramLong, MethodChannel.Result paramResult);
  
  public abstract void unregisterPushTypeWithPushType(long paramLong, MethodChannel.Result paramResult);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.tencent.qqexpand.FlutterPushModuleProtocol.PushModuleDelegate
 * JD-Core Version:    0.7.0.1
 */