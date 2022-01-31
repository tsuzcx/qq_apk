package com.tencent.qgplayer.rtmpsdk;

import android.media.MediaCodecInfo;
import android.media.MediaCodecList;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.view.Surface;
import com.tencent.qgplayer.rtmpsdk.c.b;
import com.tencent.qgplayer.rtmpsdk.c.c;
import com.tencent.qgplayer.rtmpsdk.c.e;
import java.lang.ref.WeakReference;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class QGPlayerNativeManager
{
  private static final String TAG = "QGPlayer.QGPlayerNativeManager";
  private static HashMap<String, WeakReference<a>> mediaDataReceiveListeners;
  private static boolean nativeCodecInited = false;
  private static HashMap<String, WeakReference<IQGPlayListener>> playListeners;
  private static Map<String, Boolean> videoCodecSupportMap = new HashMap(2);
  
  static
  {
    try
    {
      System.loadLibrary("qgplayer-lib");
      mediaDataReceiveListeners = new HashMap();
      playListeners = new HashMap();
      return;
    }
    catch (Throwable localThrowable)
    {
      for (;;)
      {
        QGLog.e("QGPlayer.QGPlayerNativeManager", "load library qgplayer failure");
        localThrowable.printStackTrace();
      }
    }
  }
  
  static void addMediaDataListener(String paramString, a parama)
  {
    mediaDataReceiveListeners.put(paramString, new WeakReference(parama));
  }
  
  static void addPlayListener(String paramString, IQGPlayListener paramIQGPlayListener)
  {
    playListeners.put(paramString, new WeakReference(paramIQGPlayListener));
  }
  
  public static boolean couldNativeVideoDecode()
  {
    if (!nativeCodecInited) {
      init();
    }
    return (e.a >= 21) && (nativeCodecInited);
  }
  
  public static void dispatchPlayEvent(String paramString, int paramInt, Bundle paramBundle)
  {
    if (c.a(paramString)) {}
    do
    {
      return;
      paramString = getQGPlayListener(paramString);
    } while (paramString == null);
    paramString.onPlayEvent(paramInt, paramBundle);
  }
  
  public static void dispatchPlayerStatus(String paramString, int paramInt, Bundle paramBundle)
  {
    if (c.a(paramString)) {}
    do
    {
      return;
      paramString = getQGPlayListener(paramString);
    } while (paramString == null);
    paramString.onPlayerStatus(paramInt, paramBundle);
  }
  
  private static a getMediaDataListener(String paramString)
  {
    if (mediaDataReceiveListeners.containsKey(paramString))
    {
      paramString = (WeakReference)mediaDataReceiveListeners.get(paramString);
      if (paramString != null)
      {
        paramString = (a)paramString.get();
        if (paramString != null) {
          return paramString;
        }
      }
    }
    return null;
  }
  
  private static IQGPlayListener getQGPlayListener(String paramString)
  {
    if (playListeners.containsKey(paramString))
    {
      paramString = (WeakReference)playListeners.get(paramString);
      if (paramString != null)
      {
        paramString = (IQGPlayListener)paramString.get();
        if (paramString != null) {
          return paramString;
        }
      }
    }
    return null;
  }
  
  public static void init()
  {
    if (e.a >= 21) {
      nativeCodecInited = nativeInit();
    }
  }
  
  public static boolean isSupportSpecifiedDecode(String paramString)
  {
    QGLog.i("QGPlayer.QGPlayerNativeManager", "isSupportSpecifiedDecode decodeType : " + paramString);
    if (c.a(paramString)) {
      return false;
    }
    if (videoCodecSupportMap.containsKey(paramString)) {
      return ((Boolean)videoCodecSupportMap.get(paramString)).booleanValue();
    }
    if (Build.VERSION.SDK_INT >= 21)
    {
      MediaCodecInfo[] arrayOfMediaCodecInfo = new MediaCodecList(1).getCodecInfos();
      int k = arrayOfMediaCodecInfo.length;
      int i = 0;
      boolean bool1 = false;
      for (;;)
      {
        bool2 = bool1;
        if (i >= k) {
          break;
        }
        MediaCodecInfo localMediaCodecInfo = arrayOfMediaCodecInfo[i];
        String[] arrayOfString = localMediaCodecInfo.getSupportedTypes();
        int m = arrayOfString.length;
        int j = 0;
        while (j < m)
        {
          if (arrayOfString[j].contains(paramString))
          {
            QGLog.i("QGPlayer.QGPlayerNativeManager", "find " + paramString + " , MediaCodecInfo: " + localMediaCodecInfo.getName());
            bool1 = true;
          }
          j += 1;
        }
        i += 1;
      }
    }
    boolean bool2 = false;
    videoCodecSupportMap.put(paramString, Boolean.valueOf(bool2));
    QGLog.i("QGPlayer.QGPlayerNativeManager", "isSupportSpecifiedDecode decodeType : " + paramString + " , result : " + bool2);
    return bool2;
  }
  
  public static native void nativeFrameUpdate(String paramString);
  
  public static native long nativeGetAudioData(String paramString, ByteBuffer paramByteBuffer);
  
  public static native int nativeGetCurrentTime(String paramString);
  
  public static native float nativeGetDownloadAvgSpeed(String paramString);
  
  public static native QGAVDownloadProfile nativeGetDownloadProfile(String paramString);
  
  public static native int nativeGetDuration(String paramString);
  
  public static native ArrayList<QGMediaStream> nativeGetMediaStreams(String paramString);
  
  public static native boolean nativeInit();
  
  public static native boolean nativeIsPlaying(String paramString);
  
  public static native void nativePause(String paramString);
  
  public static native void nativeRenderEosTexture(String paramString);
  
  public static native void nativeResume(String paramString);
  
  public static native boolean nativeSeek(String paramString, int paramInt);
  
  public static native void nativeSetBufferConfig(String paramString, float paramFloat1, boolean paramBoolean, float paramFloat2, float paramFloat3, float paramFloat4, float paramFloat5, float paramFloat6, float paramFloat7);
  
  public static native void nativeSetBufferConfigRealTime(String paramString, float paramFloat1, boolean paramBoolean, float paramFloat2, float paramFloat3, float paramFloat4, float paramFloat5, float paramFloat6, float paramFloat7);
  
  public static native void nativeSetCodecDecodeSurface(String paramString, Surface paramSurface);
  
  public static native void nativeSetCookie(String paramString1, String paramString2);
  
  public static native void nativeSetEnableVideoFrameExtraData(String paramString, boolean paramBoolean);
  
  public static native void nativeSetMute(String paramString, boolean paramBoolean);
  
  public static native void nativeSetPlayPts(String paramString, long paramLong);
  
  public static native void nativeSetSurface(String paramString, Surface paramSurface, int paramInt1, int paramInt2);
  
  public static native void nativeSetSurfaceSize(String paramString, int paramInt1, int paramInt2, boolean paramBoolean);
  
  public static native void nativeSetVideoSize(String paramString, int paramInt1, int paramInt2);
  
  public static native void nativeSetVolume(String paramString, float paramFloat);
  
  public static native void nativeStartPlay(String paramString1, int paramInt1, int paramInt2, int paramInt3, boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3, String paramString2);
  
  public static native void nativeStartPlay(QGMediaStream[] paramArrayOfQGMediaStream, int paramInt1, int paramInt2, int paramInt3, boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3);
  
  public static native void nativeStop(String paramString);
  
  public static native boolean nativeSwitchToClarify(String paramString, int paramInt, boolean paramBoolean);
  
  private static void onConfigAudioPlayer(String paramString, int paramInt1, int paramInt2, int paramInt3)
  {
    try
    {
      a locala = getMediaDataListener(paramString);
      if (locala != null) {
        locala.a(paramString, paramInt1, paramInt2, paramInt3);
      }
      return;
    }
    catch (Exception paramString)
    {
      QGLog.e("QGPlayer.QGPlayerNativeManager", "onConfigAudioPlayer error :" + paramString.toString());
    }
  }
  
  private static void onEosTextureAvailable(String paramString, int paramInt)
  {
    try
    {
      a locala = getMediaDataListener(paramString);
      if (locala != null) {
        locala.a(paramString, paramInt);
      }
      return;
    }
    catch (Exception paramString)
    {
      QGLog.e("QGPlayer.QGPlayerNativeManager", "onEosTextureAvailable error :" + paramString.toString());
    }
  }
  
  public static void onGLError(String paramString, int paramInt1, int paramInt2, int paramInt3)
  {
    if (c.a(paramString)) {}
    Bundle localBundle;
    do
    {
      do
      {
        do
        {
          return;
          QGLog.i("QGPlayer.QGPlayerNativeManager", "onTextureGLError , renderType : " + paramInt1 + " , GLError : " + paramInt2 + ", h26xType : " + paramInt3);
          localBundle = new Bundle();
          localBundle.putInt("event_param1", paramInt2);
          localBundle.putInt("event_param2", paramInt3);
          if (paramInt1 != 0) {
            break;
          }
          localBundle.putString("event_description", "native OES texture GL render error");
          if (paramInt3 == 0)
          {
            dispatchPlayEvent(paramString, 2301, localBundle);
            return;
          }
        } while (paramInt3 != 1);
        dispatchPlayEvent(paramString, 2302, localBundle);
        return;
      } while (paramInt1 != 1);
      localBundle.putString("event_description", "native yuv texture GL render error");
      if (paramInt3 == 0)
      {
        dispatchPlayEvent(paramString, 2304, localBundle);
        return;
      }
    } while (paramInt3 != 1);
    dispatchPlayEvent(paramString, 2305, localBundle);
  }
  
  public static void onLogCallback(int paramInt, String paramString1, String paramString2)
  {
    if (SimpleQGPlayer.logListener != null) {
      SimpleQGPlayer.logListener.onLog(paramInt, paramString1, paramString2);
    }
  }
  
  private static void onPlayEvent(String paramString, int paramInt, long paramLong1, long paramLong2, byte[] paramArrayOfByte)
  {
    if (c.a(paramString)) {
      return;
    }
    Bundle localBundle = new Bundle();
    String str = "";
    switch (paramInt)
    {
    default: 
      paramArrayOfByte = str;
    }
    for (;;)
    {
      localBundle.putString("event_description", paramArrayOfByte);
      dispatchPlayEvent(paramString, paramInt, localBundle);
      return;
      paramArrayOfByte = "begin to adjust cache time";
      localBundle.putFloat("ADJUST_CACHE_TIME_OLD", (float)paramLong1 / 1000.0F);
      localBundle.putFloat("ADJUST_CACHE_TIME_NEW", (float)paramLong2 / 1000.0F);
      continue;
      paramArrayOfByte = "network connect success";
      continue;
      paramArrayOfByte = "begin to loading";
      continue;
      paramArrayOfByte = "update time";
      localBundle.putLong("update_time_progress", paramLong1);
      localBundle.putLong("update_time_duration", paramLong2);
      continue;
      paramArrayOfByte = "receive first I Frame, prepared to play";
      continue;
      paramArrayOfByte = "begin to play";
      continue;
      str = "receive video frame extra data";
      localBundle.putByteArray("video_frame_extra_data", paramArrayOfByte);
      paramArrayOfByte = str;
      continue;
      paramArrayOfByte = "libhevc switch avc";
    }
  }
  
  public static void onPlayerStatus(String paramString, int paramInt1, int paramInt2, QGStatusError paramQGStatusError)
  {
    if (c.a(paramString))
    {
      QGLog.e("QGPlayer.QGPlayerNativeManager", "onPlayerStatus playUrl is empty");
      return;
    }
    Bundle localBundle = new Bundle();
    localBundle.putInt("player_status_error_type", paramInt2);
    localBundle.putSerializable("player_status_error_info", paramQGStatusError);
    dispatchPlayerStatus(paramString, paramInt1, localBundle);
  }
  
  private static void onReceiveAACData(String paramString, byte[] paramArrayOfByte, int paramInt1, int paramInt2, long paramLong)
  {
    try
    {
      a locala = getMediaDataListener(paramString);
      if (locala != null) {
        locala.a(paramString, paramArrayOfByte, paramInt1, paramInt2, paramLong);
      }
      return;
    }
    catch (Exception paramString)
    {
      QGLog.e("QGPlayer.QGPlayerNativeManager", "onReceiveAACData error :" + paramString.toString());
    }
  }
  
  private static void onRecievePCMData(String paramString, byte[] paramArrayOfByte, int paramInt1, int paramInt2, long paramLong)
  {
    try
    {
      a locala = getMediaDataListener(paramString);
      if (locala != null) {
        locala.b(paramString, paramArrayOfByte, paramInt1, paramInt2, paramLong);
      }
      return;
    }
    catch (Exception paramString)
    {
      QGLog.e("QGPlayer.QGPlayerNativeManager", "onRecievePCMData error :" + paramString.toString());
    }
  }
  
  private static void onRecieveVideoData(String paramString, byte[] paramArrayOfByte, long paramLong, boolean paramBoolean, int paramInt)
  {
    try
    {
      a locala = getMediaDataListener(paramString);
      if (locala != null) {
        locala.a(paramString, paramArrayOfByte, paramLong, paramBoolean, paramInt);
      }
      return;
    }
    catch (Exception paramString)
    {
      QGLog.e("QGPlayer.QGPlayerNativeManager", "onRecieveVideoData error :" + paramString.toString());
    }
  }
  
  private static void onReportVideoProfileData(String paramString, QGAVProfile paramQGAVProfile)
  {
    try
    {
      paramString = getQGPlayListener(paramString);
      if (paramString != null) {
        paramString.onStatusChanged(paramQGAVProfile);
      }
      return;
    }
    catch (Exception paramString)
    {
      QGLog.e("QGPlayer.QGPlayerNativeManager", "onReportVideoProfileData error :" + paramString.toString());
    }
  }
  
  private static void onSetSurfaceInRenderThread(String paramString, int paramInt1, int paramInt2)
  {
    try
    {
      a locala = getMediaDataListener(paramString);
      if (locala != null) {
        locala.a(paramString, paramInt1, paramInt2);
      }
      return;
    }
    catch (Exception paramString)
    {
      QGLog.e("QGPlayer.QGPlayerNativeManager", "onSetSurfaceInRenderThread error :" + paramString.toString());
    }
  }
  
  public static void onSoftDecoderVideoException(String paramString, int paramInt1, int paramInt2)
  {
    if (c.a(paramString)) {}
    Bundle localBundle;
    do
    {
      return;
      String str = b.b(paramInt2);
      QGLog.i("QGPlayer.QGPlayerNativeManager", "onSoftDecoderVideoException, h26XType : " + paramInt1 + " , exception : " + str);
      localBundle = new Bundle();
      localBundle.putString("event_description", str);
      if (paramInt1 == 0)
      {
        dispatchPlayEvent(paramString, 2304, localBundle);
        return;
      }
    } while (paramInt1 != 1);
    dispatchPlayEvent(paramString, 2305, localBundle);
  }
  
  public static void onThrowMediaCodecException(String paramString, int paramInt1, int paramInt2)
  {
    if (c.a(paramString)) {}
    Bundle localBundle;
    do
    {
      return;
      String str = b.a(paramInt2);
      QGLog.i("QGPlayer.QGPlayerNativeManager", "onThrowMediaCodecException, h26XType : " + paramInt1 + " , exception : " + str);
      localBundle = new Bundle();
      localBundle.putString("event_description", str);
      if (paramInt1 == 0)
      {
        dispatchPlayEvent(paramString, 2301, localBundle);
        return;
      }
    } while (paramInt1 != 1);
    dispatchPlayEvent(paramString, 2302, localBundle);
  }
  
  private static void onVideoSizeChanged(String paramString, int paramInt1, int paramInt2)
  {
    try
    {
      a locala = getMediaDataListener(paramString);
      if (locala != null) {
        locala.b(paramString, paramInt1, paramInt2);
      }
      dispatchPlayEvent(paramString, 4003, new Bundle());
      return;
    }
    catch (Exception paramString)
    {
      QGLog.e("QGPlayer.QGPlayerNativeManager", "onVideoSizeChanged error :" + paramString.toString());
    }
  }
  
  static void removeMediaDataListener(String paramString)
  {
    if (mediaDataReceiveListeners.containsKey(paramString)) {
      mediaDataReceiveListeners.remove(paramString);
    }
  }
  
  static void removePlayListener(String paramString)
  {
    if (playListeners.containsKey(paramString)) {
      playListeners.remove(paramString);
    }
  }
  
  private static void seekToPts(String paramString, long paramLong)
  {
    try
    {
      a locala = getMediaDataListener(paramString);
      if (locala != null) {
        locala.a(paramString, paramLong);
      }
      return;
    }
    catch (Exception paramString)
    {
      QGLog.e("QGPlayer.QGPlayerNativeManager", "seekToPts error :" + paramString.toString());
    }
  }
  
  public static abstract interface a
  {
    public abstract void a(String paramString, int paramInt);
    
    public abstract void a(String paramString, int paramInt1, int paramInt2);
    
    public abstract void a(String paramString, int paramInt1, int paramInt2, int paramInt3);
    
    public abstract void a(String paramString, long paramLong);
    
    public abstract void a(String paramString, byte[] paramArrayOfByte, int paramInt1, int paramInt2, long paramLong);
    
    public abstract void a(String paramString, byte[] paramArrayOfByte, long paramLong, boolean paramBoolean, int paramInt);
    
    public abstract void b(String paramString, int paramInt1, int paramInt2);
    
    public abstract void b(String paramString, byte[] paramArrayOfByte, int paramInt1, int paramInt2, long paramLong);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.qgplayer.rtmpsdk.QGPlayerNativeManager
 * JD-Core Version:    0.7.0.1
 */