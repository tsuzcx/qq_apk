package com.tencent.rtmp.sharp.jni;

import android.content.Context;
import com.tencent.liteav.audio.impl.TXCAudioEngineJNI;
import com.tencent.liteav.basic.log.TXCLog;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

public class AudioSessionDuplicate
{
  private static final String TAG = "AudioSessionDuplicate";
  private static TraeAudioSession _as;
  private static boolean _preDone;
  private static Condition _precon;
  private static ReentrantLock _prelock = new ReentrantLock();
  private static String[] mDeviceList = null;
  private static int playoutDeviceType = 0;
  private static boolean usingJava;
  
  static
  {
    _precon = _prelock.newCondition();
    _preDone = false;
    usingJava = true;
  }
  
  public static void DeleteAudioSessionDuplicate()
  {
    TXCLog.i("AudioSessionDuplicate", " DeleteAudioSessionDuplicate...");
    TraeAudioSession localTraeAudioSession = _as;
    if (localTraeAudioSession != null)
    {
      localTraeAudioSession.voiceCallPostprocess();
      _as.release();
      _as = null;
    }
  }
  
  public static void NewAudioSessionDuplicate(Context paramContext)
  {
    TXCLog.i("AudioSessionDuplicate", " NewAudioSessionDuplicate...");
    if (_as == null) {
      _as = new TraeAudioSession(paramContext, new AudioSessionDuplicate.1());
    }
  }
  
  private static void onOutputChanage(String paramString)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("device: ");
    localStringBuilder.append(paramString);
    TXCLog.i("AudioSessionDuplicate", localStringBuilder.toString());
    if (paramString.equals("DEVICE_EARPHONE")) {
      playoutDeviceType = 1;
    } else if (paramString.equals("DEVICE_SPEAKERPHONE")) {
      playoutDeviceType = 2;
    } else if (paramString.equals("DEVICE_WIREDHEADSET")) {
      playoutDeviceType = 3;
    } else if (paramString.equals("DEVICE_BLUETOOTHHEADSET")) {
      playoutDeviceType = 4;
    } else {
      playoutDeviceType = 0;
    }
    TXCAudioEngineJNI.nativeSetPlayoutDevice(playoutDeviceType);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.rtmp.sharp.jni.AudioSessionDuplicate
 * JD-Core Version:    0.7.0.1
 */