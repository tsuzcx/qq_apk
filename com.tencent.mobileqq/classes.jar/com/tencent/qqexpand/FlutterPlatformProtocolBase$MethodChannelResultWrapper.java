package com.tencent.qqexpand;

import androidx.annotation.Nullable;
import io.flutter.plugin.common.MethodChannel.Result;
import java.lang.ref.WeakReference;
import java.util.HashMap;

public class FlutterPlatformProtocolBase$MethodChannelResultWrapper
  implements MethodChannel.Result
{
  private String mChannelName;
  private WeakReference<IBaseApiDelegate> mDelegateRef;
  private String mMethod;
  private MethodChannel.Result mResult;
  
  public FlutterPlatformProtocolBase$MethodChannelResultWrapper(IBaseApiDelegate paramIBaseApiDelegate, String paramString1, String paramString2, MethodChannel.Result paramResult)
  {
    this.mDelegateRef = new WeakReference(paramIBaseApiDelegate);
    this.mResult = paramResult;
    this.mChannelName = paramString1;
    this.mMethod = paramString2;
  }
  
  private void onMethodCallEnd(String paramString1, String paramString2, String paramString3)
  {
    HashMap localHashMap = new HashMap();
    localHashMap.put("channel_name", paramString1);
    localHashMap.put("function", paramString2);
    localHashMap.put("type", paramString3);
    localHashMap.put("action", "response");
    if (this.mDelegateRef.get() != null) {
      ((IBaseApiDelegate)this.mDelegateRef.get()).doReport("expand_quality#succ_rate#channel", localHashMap);
    }
  }
  
  public void error(String paramString1, @Nullable String paramString2, @Nullable Object paramObject)
  {
    this.mResult.error(paramString1, paramString2, paramObject);
    onMethodCallEnd(this.mChannelName, this.mMethod, "method");
  }
  
  public void notImplemented()
  {
    this.mResult.notImplemented();
  }
  
  public void success(@Nullable Object paramObject)
  {
    this.mResult.success(paramObject);
    onMethodCallEnd(this.mChannelName, this.mMethod, "method");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.qqexpand.FlutterPlatformProtocolBase.MethodChannelResultWrapper
 * JD-Core Version:    0.7.0.1
 */