package com.tencent.thumbplayer.core.player;

import android.content.Context;
import android.view.Surface;
import com.tencent.thumbplayer.core.common.TPFieldCalledByNative;
import com.tencent.thumbplayer.core.common.TPHeadsetPluginDetector;
import com.tencent.thumbplayer.core.common.TPMediaTrackInfo;
import com.tencent.thumbplayer.core.common.TPNativeLibraryLoader;
import com.tencent.thumbplayer.core.common.TPNativeLog;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.Vector;

public class TPNativePlayer
{
  private Context mContext = null;
  @TPFieldCalledByNative
  private long mNativeContext;
  private int m_playerID = -1;
  
  public TPNativePlayer(Context paramContext)
  {
    this.mContext = paramContext.getApplicationContext();
    TPNativeLibraryLoader.loadLibIfNeeded(paramContext);
    try
    {
      this.m_playerID = _createPlayer();
      TPHeadsetPluginDetector.init(this.mContext);
      return;
    }
    catch (Throwable paramContext)
    {
      TPNativeLog.printLog(4, "Failed to create native player:" + paramContext.getMessage());
      throw new UnsupportedOperationException("Failed to create native player");
    }
  }
  
  private native int _addAudioTrackSource(String paramString1, String paramString2);
  
  private native int _addInitConfigQueueInt(int paramInt1, int paramInt2);
  
  private native int _addInitConfigQueueString(int paramInt, String paramString);
  
  private native int _addSubtitleTrackSource(String paramString1, String paramString2);
  
  private native int _applyInitConfig();
  
  private native int _createPlayer();
  
  private native int _deselectTrackAsync(int paramInt, long paramLong);
  
  private native long _getBufferedDurationMs();
  
  private native long _getBufferedSize();
  
  private native long _getCurrentPositionMs();
  
  private native long _getDurationMs();
  
  private native int _getPlayerID();
  
  private native long _getPropertyLong(int paramInt);
  
  private native String _getPropertyString(int paramInt);
  
  private native int _getTrackCount();
  
  private native boolean _getTrackIsExclusive(int paramInt);
  
  private native boolean _getTrackIsInternal(int paramInt);
  
  private native boolean _getTrackIsSelected(int paramInt);
  
  private native String _getTrackName(int paramInt);
  
  private native int _getTrackType(int paramInt);
  
  private native int _getVideoHeight();
  
  private native int _getVideoWidth();
  
  private native int _pause();
  
  private native int _prepare();
  
  private native int _prepareAsync();
  
  private native int _release();
  
  private native int _reset();
  
  private native int _resetInitConfig();
  
  private native int _resume();
  
  private native int _seekToAsync(int paramInt1, int paramInt2, long paramLong);
  
  private native int _selectTrackAsync(int paramInt, long paramLong);
  
  private native int _setAudioFrameCallback(Object paramObject);
  
  private native int _setAudioMute(boolean paramBoolean);
  
  private native int _setAudioVolume(float paramFloat);
  
  private native int _setDataSource(String paramString);
  
  private native int _setDataSourceFd(int paramInt);
  
  private native void _setHeadphonePlugIn(boolean paramBoolean);
  
  private native int _setInitConfigBool(int paramInt, boolean paramBoolean);
  
  private native int _setInitConfigInt(int paramInt1, int paramInt2);
  
  private native int _setInitConfigLong(int paramInt, long paramLong);
  
  private native int _setLoopback(boolean paramBoolean, long paramLong1, long paramLong2);
  
  private native int _setMessageCallback(Object paramObject);
  
  private native int _setOptionLong(int paramInt, long paramLong1, long paramLong2);
  
  private native int _setOptionObject(int paramInt, Object paramObject);
  
  private native int _setPlaybackRate(float paramFloat);
  
  private native int _setVideoFrameCallback(Object paramObject);
  
  private native int _setVideoSurface(Surface paramSurface);
  
  private native int _start();
  
  private native int _stop();
  
  private native int _switchDefinitionAsync(String paramString, long paramLong);
  
  public int addAudioTrackSource(String paramString1, String paramString2)
  {
    try
    {
      int i = _addAudioTrackSource(paramString1, paramString2);
      return i;
    }
    catch (Throwable paramString1)
    {
      TPNativeLog.printLog(4, paramString1.getMessage());
    }
    return 1000001;
  }
  
  public int addSubtitleTrackSource(String paramString1, String paramString2)
  {
    try
    {
      int i = _addSubtitleTrackSource(paramString1, paramString2);
      return i;
    }
    catch (Throwable paramString1)
    {
      TPNativeLog.printLog(4, paramString1.getMessage());
    }
    return 1000001;
  }
  
  public int deselectTrackAsync(int paramInt, long paramLong)
  {
    try
    {
      paramInt = _deselectTrackAsync(paramInt, paramLong);
      return paramInt;
    }
    catch (Throwable localThrowable)
    {
      TPNativeLog.printLog(4, localThrowable.getMessage());
    }
    return 1000001;
  }
  
  public long getBufferedDurationMs()
  {
    try
    {
      long l = _getBufferedDurationMs();
      return l;
    }
    catch (Throwable localThrowable)
    {
      TPNativeLog.printLog(4, localThrowable.getMessage());
    }
    return 0L;
  }
  
  public long getBufferedSize()
  {
    try
    {
      long l = _getBufferedSize();
      return l;
    }
    catch (Throwable localThrowable)
    {
      TPNativeLog.printLog(4, localThrowable.getMessage());
    }
    return 0L;
  }
  
  public long getCurrentPositionMs()
  {
    try
    {
      long l = _getCurrentPositionMs();
      return l;
    }
    catch (Throwable localThrowable)
    {
      TPNativeLog.printLog(4, localThrowable.getMessage());
    }
    return 0L;
  }
  
  public long getDurationMs()
  {
    try
    {
      long l = _getDurationMs();
      return l;
    }
    catch (Throwable localThrowable)
    {
      TPNativeLog.printLog(4, localThrowable.getMessage());
    }
    return 0L;
  }
  
  public int getPlayerID()
  {
    try
    {
      int i = _getPlayerID();
      return i;
    }
    catch (Throwable localThrowable)
    {
      TPNativeLog.printLog(4, localThrowable.getMessage());
    }
    return 0;
  }
  
  public TPNativePlayerProgramInfo[] getProgramInfo()
  {
    return null;
  }
  
  public long getPropertyLong(int paramInt)
  {
    try
    {
      long l = _getPropertyLong(paramInt);
      return l;
    }
    catch (Throwable localThrowable)
    {
      TPNativeLog.printLog(4, localThrowable.getMessage());
    }
    return 0L;
  }
  
  public String getPropertyString(int paramInt)
  {
    try
    {
      String str = _getPropertyString(paramInt);
      return str;
    }
    catch (Throwable localThrowable)
    {
      TPNativeLog.printLog(4, localThrowable.getMessage());
    }
    return "";
  }
  
  public TPMediaTrackInfo[] getTrackInfo()
  {
    try
    {
      int j = _getTrackCount();
      if (j > 0)
      {
        TPMediaTrackInfo[] arrayOfTPMediaTrackInfo3 = new TPMediaTrackInfo[j];
        int i = 0;
        for (;;)
        {
          TPMediaTrackInfo[] arrayOfTPMediaTrackInfo1 = arrayOfTPMediaTrackInfo3;
          if (i >= j) {
            break;
          }
          arrayOfTPMediaTrackInfo3[i] = new TPMediaTrackInfo();
          arrayOfTPMediaTrackInfo3[i].trackType = _getTrackType(i);
          arrayOfTPMediaTrackInfo3[i].trackName = _getTrackName(i);
          arrayOfTPMediaTrackInfo3[i].isSelected = _getTrackIsSelected(i);
          arrayOfTPMediaTrackInfo3[i].isExclusive = _getTrackIsExclusive(i);
          arrayOfTPMediaTrackInfo3[i].isInternal = _getTrackIsInternal(i);
          i += 1;
        }
      }
      TPMediaTrackInfo[] arrayOfTPMediaTrackInfo2;
      return null;
    }
    catch (Throwable localThrowable)
    {
      TPNativeLog.printLog(4, localThrowable.getMessage());
      arrayOfTPMediaTrackInfo2 = null;
      return arrayOfTPMediaTrackInfo2;
    }
  }
  
  public int getVideoHeight()
  {
    try
    {
      int i = _getVideoHeight();
      return i;
    }
    catch (Throwable localThrowable)
    {
      TPNativeLog.printLog(4, localThrowable.getMessage());
    }
    return 0;
  }
  
  public int getVideoWidth()
  {
    try
    {
      int i = _getVideoWidth();
      return i;
    }
    catch (Throwable localThrowable)
    {
      TPNativeLog.printLog(4, localThrowable.getMessage());
    }
    return 0;
  }
  
  public int pause()
  {
    try
    {
      int i = _pause();
      return i;
    }
    catch (Throwable localThrowable)
    {
      TPNativeLog.printLog(4, localThrowable.getMessage());
    }
    return 1000001;
  }
  
  public int prepare()
  {
    try
    {
      int i = _prepare();
      return i;
    }
    catch (Throwable localThrowable)
    {
      TPNativeLog.printLog(4, localThrowable.getMessage());
    }
    return 1000001;
  }
  
  public int prepareAsync()
  {
    try
    {
      int i = _prepareAsync();
      return i;
    }
    catch (Throwable localThrowable)
    {
      TPNativeLog.printLog(4, localThrowable.getMessage());
    }
    return 1000001;
  }
  
  public void release()
  {
    try
    {
      _release();
      return;
    }
    catch (Throwable localThrowable)
    {
      TPNativeLog.printLog(4, localThrowable.getMessage());
    }
  }
  
  public void reset()
  {
    try
    {
      _reset();
      return;
    }
    catch (Throwable localThrowable)
    {
      TPNativeLog.printLog(4, localThrowable.getMessage());
    }
  }
  
  public int seekToAsync(int paramInt1, int paramInt2, long paramLong)
  {
    try
    {
      paramInt1 = _seekToAsync(paramInt1, paramInt2, paramLong);
      return paramInt1;
    }
    catch (Throwable localThrowable)
    {
      TPNativeLog.printLog(4, localThrowable.getMessage());
    }
    return 1000001;
  }
  
  public int selectProgramAsync(int paramInt, long paramLong)
  {
    return 0;
  }
  
  public int selectTrackAsync(int paramInt, long paramLong)
  {
    try
    {
      paramInt = _selectTrackAsync(paramInt, paramLong);
      return paramInt;
    }
    catch (Throwable localThrowable)
    {
      TPNativeLog.printLog(4, localThrowable.getMessage());
    }
    return 1000001;
  }
  
  public int setAudioFrameCallback(ITPNativePlayerAudioFrameCallback paramITPNativePlayerAudioFrameCallback)
  {
    try
    {
      int i = _setAudioFrameCallback(paramITPNativePlayerAudioFrameCallback);
      return i;
    }
    catch (Throwable paramITPNativePlayerAudioFrameCallback)
    {
      TPNativeLog.printLog(4, paramITPNativePlayerAudioFrameCallback.getMessage());
    }
    return 1000001;
  }
  
  public int setAudioMute(boolean paramBoolean)
  {
    try
    {
      int i = _setAudioMute(paramBoolean);
      return i;
    }
    catch (Throwable localThrowable)
    {
      TPNativeLog.printLog(4, localThrowable.getMessage());
    }
    return 1000001;
  }
  
  public int setAudioVolume(float paramFloat)
  {
    try
    {
      int i = _setAudioVolume(paramFloat);
      return i;
    }
    catch (Throwable localThrowable)
    {
      TPNativeLog.printLog(4, localThrowable.getMessage());
    }
    return 1000001;
  }
  
  public int setDataSource(int paramInt)
  {
    try
    {
      paramInt = _setDataSourceFd(paramInt);
      return paramInt;
    }
    catch (Throwable localThrowable)
    {
      TPNativeLog.printLog(4, localThrowable.getMessage());
    }
    return 1000001;
  }
  
  public int setDataSource(String paramString)
  {
    try
    {
      int i = _setDataSource(paramString);
      return i;
    }
    catch (Throwable paramString)
    {
      TPNativeLog.printLog(4, paramString.getMessage());
    }
    return 1000001;
  }
  
  public int setDataSource(String paramString, Map<String, String> paramMap)
  {
    return 0;
  }
  
  public void setHeadphonePlugIn(boolean paramBoolean)
  {
    try
    {
      _setHeadphonePlugIn(paramBoolean);
      return;
    }
    catch (Throwable localThrowable)
    {
      TPNativeLog.printLog(4, localThrowable.getMessage());
    }
  }
  
  public void setInitConfig(TPNativePlayerInitConfig paramTPNativePlayerInitConfig)
  {
    Object localObject4;
    Object localObject3;
    try
    {
      _resetInitConfig();
      localObject4 = paramTPNativePlayerInitConfig.getIntMap();
      localObject3 = paramTPNativePlayerInitConfig.getLongMap();
      localObject2 = paramTPNativePlayerInitConfig.getBoolMap();
      localObject1 = paramTPNativePlayerInitConfig.getQueueIntMap();
      localObject4 = ((HashMap)localObject4).entrySet().iterator();
      while (((Iterator)localObject4).hasNext())
      {
        Map.Entry localEntry = (Map.Entry)((Iterator)localObject4).next();
        _setInitConfigInt(((Integer)localEntry.getKey()).intValue(), ((Integer)localEntry.getValue()).intValue());
      }
      localObject3 = ((HashMap)localObject3).entrySet().iterator();
    }
    catch (Throwable paramTPNativePlayerInitConfig)
    {
      TPNativeLog.printLog(4, paramTPNativePlayerInitConfig.getMessage());
      return;
    }
    while (((Iterator)localObject3).hasNext())
    {
      localObject4 = (Map.Entry)((Iterator)localObject3).next();
      _setInitConfigLong(((Integer)((Map.Entry)localObject4).getKey()).intValue(), ((Long)((Map.Entry)localObject4).getValue()).longValue());
    }
    Object localObject2 = ((HashMap)localObject2).entrySet().iterator();
    while (((Iterator)localObject2).hasNext())
    {
      localObject3 = (Map.Entry)((Iterator)localObject2).next();
      _setInitConfigBool(((Integer)((Map.Entry)localObject3).getKey()).intValue(), ((Boolean)((Map.Entry)localObject3).getValue()).booleanValue());
    }
    Object localObject1 = ((HashMap)localObject1).entrySet().iterator();
    while (((Iterator)localObject1).hasNext())
    {
      localObject2 = (Map.Entry)((Iterator)localObject1).next();
      localObject3 = (Vector)((Map.Entry)localObject2).getValue();
      if (localObject3 != null)
      {
        localObject3 = ((Vector)localObject3).iterator();
        while (((Iterator)localObject3).hasNext())
        {
          int i = ((Integer)((Iterator)localObject3).next()).intValue();
          _addInitConfigQueueInt(((Integer)((Map.Entry)localObject2).getKey()).intValue(), i);
        }
      }
    }
    paramTPNativePlayerInitConfig = paramTPNativePlayerInitConfig.getQueueStringMap().entrySet().iterator();
    while (paramTPNativePlayerInitConfig.hasNext())
    {
      localObject1 = (Map.Entry)paramTPNativePlayerInitConfig.next();
      localObject2 = (Vector)((Map.Entry)localObject1).getValue();
      if (localObject2 != null)
      {
        localObject2 = ((Vector)localObject2).iterator();
        while (((Iterator)localObject2).hasNext())
        {
          localObject3 = (String)((Iterator)localObject2).next();
          _addInitConfigQueueString(((Integer)((Map.Entry)localObject1).getKey()).intValue(), (String)localObject3);
        }
      }
    }
    _applyInitConfig();
  }
  
  public int setLoopback(boolean paramBoolean, long paramLong1, long paramLong2)
  {
    try
    {
      int i = _setLoopback(paramBoolean, paramLong1, paramLong2);
      return i;
    }
    catch (Throwable localThrowable)
    {
      TPNativeLog.printLog(4, localThrowable.getMessage());
    }
    return 1000001;
  }
  
  public int setMessageCallback(ITPNativePlayerMessageCallback paramITPNativePlayerMessageCallback)
  {
    try
    {
      int i = _setMessageCallback(paramITPNativePlayerMessageCallback);
      return i;
    }
    catch (Throwable paramITPNativePlayerMessageCallback)
    {
      TPNativeLog.printLog(4, paramITPNativePlayerMessageCallback.getMessage());
    }
    return 1000001;
  }
  
  public int setOptionLong(int paramInt, long paramLong1, long paramLong2)
  {
    try
    {
      paramInt = _setOptionLong(paramInt, paramLong1, paramLong2);
      return paramInt;
    }
    catch (Throwable localThrowable)
    {
      TPNativeLog.printLog(4, localThrowable.getMessage());
    }
    return 1000001;
  }
  
  public int setOptionObject(int paramInt, Object paramObject)
  {
    try
    {
      paramInt = _setOptionObject(paramInt, paramObject);
      return paramInt;
    }
    catch (Throwable paramObject)
    {
      TPNativeLog.printLog(4, paramObject.getMessage());
    }
    return 1000001;
  }
  
  public int setPlaybackRate(float paramFloat)
  {
    try
    {
      int i = _setPlaybackRate(paramFloat);
      return i;
    }
    catch (Throwable localThrowable)
    {
      TPNativeLog.printLog(4, localThrowable.getMessage());
    }
    return 1000001;
  }
  
  public int setVideoFrameCallback(ITPNativePlayerVideoFrameCallback paramITPNativePlayerVideoFrameCallback)
  {
    try
    {
      int i = _setVideoFrameCallback(paramITPNativePlayerVideoFrameCallback);
      return i;
    }
    catch (Throwable paramITPNativePlayerVideoFrameCallback)
    {
      TPNativeLog.printLog(4, paramITPNativePlayerVideoFrameCallback.getMessage());
    }
    return 1000001;
  }
  
  public int setVideoSurface(Surface paramSurface)
  {
    try
    {
      int i = _setVideoSurface(paramSurface);
      return i;
    }
    catch (Throwable paramSurface)
    {
      TPNativeLog.printLog(4, paramSurface.getMessage());
    }
    return 1000001;
  }
  
  public int start()
  {
    try
    {
      int i = _start();
      return i;
    }
    catch (Throwable localThrowable)
    {
      TPNativeLog.printLog(4, localThrowable.getMessage());
    }
    return 1000001;
  }
  
  public int stop()
  {
    try
    {
      int i = _stop();
      return i;
    }
    catch (Throwable localThrowable)
    {
      TPNativeLog.printLog(4, localThrowable.getMessage());
    }
    return 1000001;
  }
  
  public int switchDefinitionAsync(String paramString, long paramLong)
  {
    try
    {
      int i = _switchDefinitionAsync(paramString, paramLong);
      return i;
    }
    catch (Throwable paramString)
    {
      TPNativeLog.printLog(4, paramString.getMessage());
    }
    return 1000001;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.thumbplayer.core.player.TPNativePlayer
 * JD-Core Version:    0.7.0.1
 */