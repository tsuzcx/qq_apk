package com.tencent.thumbplayer.core.common;

import android.media.AudioDeviceCallback;
import android.media.AudioDeviceInfo;

final class TPHeadsetPluginDetector$1
  extends AudioDeviceCallback
{
  public void onAudioDevicesAdded(AudioDeviceInfo[] paramArrayOfAudioDeviceInfo)
  {
    TPNativeLog.printLog(2, "TPHeadsetPluginDetector", "onAudioDevicesAdded!");
    TPHeadsetPluginDetector.access$200(TPHeadsetPluginDetector.access$000(), TPHeadsetPluginDetector.access$100());
  }
  
  public void onAudioDevicesRemoved(AudioDeviceInfo[] paramArrayOfAudioDeviceInfo)
  {
    TPNativeLog.printLog(2, "TPHeadsetPluginDetector", "onAudioDevicesRemoved!");
    TPHeadsetPluginDetector.access$200(TPHeadsetPluginDetector.access$000(), TPHeadsetPluginDetector.access$100());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.thumbplayer.core.common.TPHeadsetPluginDetector.1
 * JD-Core Version:    0.7.0.1
 */