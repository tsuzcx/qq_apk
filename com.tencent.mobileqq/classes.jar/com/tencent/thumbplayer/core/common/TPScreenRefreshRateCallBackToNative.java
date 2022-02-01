package com.tencent.thumbplayer.core.common;

public class TPScreenRefreshRateCallBackToNative
  implements TPScreenRefreshRateDetector.ScreenRefreshRateChangedListener
{
  private static final String TAG = "TPScreenRefreshRateCallBack";
  private long mNativeContext;
  
  private TPScreenRefreshRateCallBackToNative(long paramLong)
  {
    this.mNativeContext = paramLong;
  }
  
  private native void _onScreenRefreshRateChanged(float paramFloat);
  
  @TPMethodCalledByNative
  private long getNativeContext()
  {
    return this.mNativeContext;
  }
  
  @TPMethodCalledByNative
  private void registerCallback()
  {
    TPScreenRefreshRateDetector.addListener(this);
  }
  
  @TPMethodCalledByNative
  private void unregisterCallback()
  {
    TPScreenRefreshRateDetector.removeListener(this);
  }
  
  public void onScreenRefreshRateChanged(float paramFloat)
  {
    TPNativeLog.printLog(2, "TPScreenRefreshRateCallBack", "onScreenRefreshRateChanged refreshRate:" + paramFloat);
    _onScreenRefreshRateChanged(paramFloat);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.thumbplayer.core.common.TPScreenRefreshRateCallBackToNative
 * JD-Core Version:    0.7.0.1
 */