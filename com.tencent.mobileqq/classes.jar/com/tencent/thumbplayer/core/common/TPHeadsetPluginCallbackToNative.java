package com.tencent.thumbplayer.core.common;

import java.util.Set;

public class TPHeadsetPluginCallbackToNative
  implements TPHeadsetPluginDetector.HeadsetPluginListener
{
  private static final String TAG = "TPHeadsetPluginCallback";
  private long mNativeContext;
  
  private TPHeadsetPluginCallbackToNative(long paramLong)
  {
    this.mNativeContext = paramLong;
  }
  
  private native void _onAudioRouteChanged(Set<Integer> paramSet1, Set<Integer> paramSet2);
  
  @TPMethodCalledByNative
  private long getNativeContext()
  {
    return this.mNativeContext;
  }
  
  @TPMethodCalledByNative
  private void registerCallback()
  {
    TPHeadsetPluginDetector.addHeadsetPluginListener(this);
  }
  
  @TPMethodCalledByNative
  private void unregisterCallback()
  {
    TPHeadsetPluginDetector.removeHeadsetPluginListener(this);
  }
  
  public void onHeadsetPlugin(Set<Integer> paramSet1, Set<Integer> paramSet2)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("onHeadsetPlugin: oldOutputs: ");
    localStringBuilder.append(paramSet1);
    localStringBuilder.append(", newOutputs: ");
    localStringBuilder.append(paramSet2);
    TPNativeLog.printLog(2, "TPHeadsetPluginCallback", localStringBuilder.toString());
    _onAudioRouteChanged(paramSet1, paramSet2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.thumbplayer.core.common.TPHeadsetPluginCallbackToNative
 * JD-Core Version:    0.7.0.1
 */