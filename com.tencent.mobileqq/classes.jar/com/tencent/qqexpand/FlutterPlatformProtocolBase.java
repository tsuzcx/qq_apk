package com.tencent.qqexpand;

import android.util.Log;
import androidx.annotation.NonNull;
import io.flutter.plugin.common.BinaryMessenger;
import io.flutter.plugin.common.MethodCall;
import io.flutter.plugin.common.MethodChannel.MethodCallHandler;
import io.flutter.plugin.common.MethodChannel.Result;
import java.util.HashMap;

public abstract class FlutterPlatformProtocolBase
  implements MethodChannel.MethodCallHandler
{
  public static final String TAG = "FlutterProtocolBase";
  protected IBaseApiDelegate mBaseApiDelegate;
  protected String mChannelName;
  
  public FlutterPlatformProtocolBase(BinaryMessenger paramBinaryMessenger)
  {
    onInit(paramBinaryMessenger);
  }
  
  private void onMethodCallBegin(String paramString1, String paramString2, String paramString3)
  {
    HashMap localHashMap = new HashMap();
    localHashMap.put("channel_name", paramString1);
    localHashMap.put("function", paramString2);
    localHashMap.put("type", paramString3);
    localHashMap.put("action", "call");
    if (this.mBaseApiDelegate != null) {
      this.mBaseApiDelegate.doReport("expand_quality#succ_rate#channel", localHashMap);
    }
  }
  
  protected abstract void doOnMethodCall(@NonNull MethodCall paramMethodCall, @NonNull FlutterPlatformProtocolBase.MethodChannelResultWrapper paramMethodChannelResultWrapper);
  
  public String getChannelName()
  {
    return this.mChannelName;
  }
  
  public abstract void onDestroy();
  
  public abstract void onInit(BinaryMessenger paramBinaryMessenger);
  
  public void onMethodCall(MethodCall paramMethodCall, MethodChannel.Result paramResult)
  {
    String str = paramMethodCall.method;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("[onMethodCall] method=");
    localStringBuilder.append(str);
    Log.i("FlutterProtocolBase", localStringBuilder.toString());
    onMethodCallBegin(getChannelName(), paramMethodCall.method, "method");
    doOnMethodCall(paramMethodCall, new FlutterPlatformProtocolBase.MethodChannelResultWrapper(this.mBaseApiDelegate, getChannelName(), str, paramResult));
  }
  
  public void setApiDelegate(IBaseApiDelegate paramIBaseApiDelegate)
  {
    this.mBaseApiDelegate = paramIBaseApiDelegate;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.qqexpand.FlutterPlatformProtocolBase
 * JD-Core Version:    0.7.0.1
 */