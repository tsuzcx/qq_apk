package com.tencent.rtmp.sharp.jni;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

final class AudioSessionDuplicate$1
  implements TraeAudioSession.ITraeAudioCallback
{
  public void onAudioRouteSwitchEnd(String paramString, long paramLong) {}
  
  public void onAudioRouteSwitchStart(String paramString1, String paramString2) {}
  
  public void onConnectDeviceRes(int paramInt, String paramString, boolean paramBoolean) {}
  
  public void onDeviceChangabledUpdate(boolean paramBoolean) {}
  
  public void onDeviceListUpdate(String[] paramArrayOfString, String paramString1, String paramString2, String paramString3)
  {
    AudioSessionDuplicate.access$302(paramArrayOfString);
    if (AudioSessionDuplicate.access$400()) {
      AudioSessionDuplicate.access$500(paramString1);
    }
  }
  
  public void onGetConnectedDeviceRes(int paramInt, String paramString)
  {
    if (paramInt == 0) {
      AudioSessionDuplicate.access$500(paramString);
    }
  }
  
  public void onGetConnectingDeviceRes(int paramInt, String paramString) {}
  
  public void onGetDeviceListRes(int paramInt, String[] paramArrayOfString, String paramString1, String paramString2, String paramString3)
  {
    AudioSessionDuplicate.access$302(paramArrayOfString);
  }
  
  public void onGetStreamTypeRes(int paramInt1, int paramInt2) {}
  
  public void onIsDeviceChangabledRes(int paramInt, boolean paramBoolean) {}
  
  public void onRingCompletion(int paramInt, String paramString) {}
  
  public void onServiceStateUpdate(boolean paramBoolean)
  {
    if (!paramBoolean) {}
    try
    {
      AudioSessionDuplicate.access$000().lock();
      AudioSessionDuplicate.access$102(true);
      if (QLog.isColorLevel()) {
        QLog.e("TRAE", 2, "onServiceStateUpdate signalAll");
      }
      AudioSessionDuplicate.access$200().signalAll();
      AudioSessionDuplicate.access$000().unlock();
      return;
    }
    catch (Exception localException) {}
  }
  
  public void onStreamTypeUpdate(int paramInt) {}
  
  public void onVoicecallPreprocessRes(int paramInt)
  {
    try
    {
      AudioSessionDuplicate.access$000().lock();
      AudioSessionDuplicate.access$102(true);
      if (QLog.isColorLevel()) {
        QLog.e("TRAE", 2, "onVoicecallPreprocessRes signalAll");
      }
      AudioSessionDuplicate.access$200().signalAll();
      AudioSessionDuplicate.access$000().unlock();
      return;
    }
    catch (Exception localException) {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     com.tencent.rtmp.sharp.jni.AudioSessionDuplicate.1
 * JD-Core Version:    0.7.0.1
 */