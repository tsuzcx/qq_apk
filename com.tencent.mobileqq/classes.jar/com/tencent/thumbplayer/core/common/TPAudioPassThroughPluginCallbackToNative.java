package com.tencent.thumbplayer.core.common;

public class TPAudioPassThroughPluginCallbackToNative
  implements TPAudioPassThroughPluginDetector.AudioPassThroughPluginListener
{
  private static final String TAG = "TPAudioPassThroughPluginCallback";
  private long mNativeContext;
  
  private TPAudioPassThroughPluginCallbackToNative(long paramLong)
  {
    this.mNativeContext = paramLong;
  }
  
  private native void _onAudioPassThroughStateChanged(boolean paramBoolean);
  
  @TPMethodCalledByNative
  private long getNativeContext()
  {
    return this.mNativeContext;
  }
  
  @TPMethodCalledByNative
  private void registerCallback()
  {
    TPAudioPassThroughPluginDetector.addListener(this);
  }
  
  @TPMethodCalledByNative
  private void unregisterCallback()
  {
    TPAudioPassThroughPluginDetector.removeListener(this);
  }
  
  public void onAudioPassThroughPlugin(boolean paramBoolean)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("onAudioPassThroughPlugin bPlugin:");
    localStringBuilder.append(paramBoolean);
    TPNativeLog.printLog(2, "TPAudioPassThroughPluginCallback", localStringBuilder.toString());
    _onAudioPassThroughStateChanged(paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.thumbplayer.core.common.TPAudioPassThroughPluginCallbackToNative
 * JD-Core Version:    0.7.0.1
 */