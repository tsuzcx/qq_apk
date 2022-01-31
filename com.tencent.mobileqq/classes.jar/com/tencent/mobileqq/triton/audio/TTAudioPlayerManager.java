package com.tencent.mobileqq.triton.audio;

import android.content.Context;
import android.media.AudioManager;
import android.media.AudioManager.OnAudioFocusChangeListener;
import android.media.MediaMetadataRetriever;
import android.text.TextUtils;
import android.webkit.URLUtil;
import com.tencent.mobileqq.triton.engine.TTEngine;
import com.tencent.mobileqq.triton.engine.TTLog;
import com.tencent.mobileqq.triton.sdk.IQQEnv;
import com.tencent.mobileqq.triton.sdk.audio.IAudioPlayer;
import com.tencent.mobileqq.triton.sdk.audio.IAudioPlayerBuilder;
import com.tencent.mobileqq.triton.sdk.audio.IAudioStateChangeListener;
import com.tencent.mobileqq.triton.sdk.bridge.ITTJSRuntime;
import com.tencent.mobileqq.triton.sdk.game.MiniGameInfo;
import java.io.File;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.atomic.AtomicBoolean;

public class TTAudioPlayerManager
{
  public static final String TAG = "[audio] TTAudioPlayerManager";
  private ConcurrentLinkedQueue<IAudioPlayer> idleQueue = new ConcurrentLinkedQueue();
  private volatile boolean isMute;
  private AtomicBoolean isPause = new AtomicBoolean(false);
  private AudioManager mAudioManager;
  private IAudioPlayerBuilder mInnerPlayerBuilder;
  private final Object mLock = new Object();
  private IAudioPlayerBuilder mPlayerBuilder;
  private TTEngine mTritonEngine;
  private volatile int maxVolume = 1;
  private volatile boolean mixWithOther = true;
  private AudioManager.OnAudioFocusChangeListener onAudioFocusChangeListener;
  private ConcurrentHashMap<Integer, IAudioPlayer> playerMap = new ConcurrentHashMap();
  private volatile int savedVolume = 1;
  private ConcurrentHashMap<Integer, TTAudioPlayerManager.InnerAudioStateChangeHandler> stateChangeHandlerMap = new ConcurrentHashMap();
  
  public TTAudioPlayerManager(TTEngine paramTTEngine)
  {
    this.mTritonEngine = paramTTEngine;
  }
  
  private int execAudioFocus(boolean paramBoolean)
  {
    TTLog.i("[audio] TTAudioPlayerManager", "execAudioFocus focus=" + paramBoolean);
    int i;
    if (this.mAudioManager == null) {
      i = -1;
    }
    int j;
    do
    {
      do
      {
        do
        {
          return i;
          if (!paramBoolean) {
            break;
          }
          j = this.mAudioManager.requestAudioFocus(this.onAudioFocusChangeListener, 3, 1);
          i = j;
        } while (j != 1);
        i = j;
      } while (!this.isMute);
      this.isMute = false;
      restoreVolume();
      i = j;
    } while (this.mTritonEngine.getJsRuntime(1) == null);
    this.mTritonEngine.getJsRuntime(1).evaluateSubscribeJs("onAudioInterruptionEnd", null);
    return j;
    return this.mAudioManager.abandonAudioFocus(this.onAudioFocusChangeListener);
  }
  
  private IAudioPlayer findAudioPlayer(int paramInt)
  {
    if (this.playerMap != null) {
      return (IAudioPlayer)this.playerMap.get(Integer.valueOf(paramInt));
    }
    return null;
  }
  
  private IAudioPlayer genNewAudioPlayer()
  {
    if (getPlayerBuilder() != null) {
      return getPlayerBuilder().build();
    }
    if (getInnerAudioPlayerBuilder() != null) {
      return getInnerAudioPlayerBuilder().build();
    }
    return null;
  }
  
  private IAudioPlayerBuilder getInnerAudioPlayerBuilder()
  {
    if (this.mInnerPlayerBuilder == null) {
      this.mInnerPlayerBuilder = new InnerAudioPlayerBuilder();
    }
    return this.mInnerPlayerBuilder;
  }
  
  private String getMediaDuration(String paramString)
  {
    Object localObject1 = null;
    if (TextUtils.isEmpty(paramString)) {
      return null;
    }
    long l = System.currentTimeMillis();
    localMediaMetadataRetriever = new MediaMetadataRetriever();
    try
    {
      Object localObject2 = new HashMap();
      ((HashMap)localObject2).put("User-Agent", "Mozilla/5.0 (Linux; U; Android 4.4.2; zh-CN; MW-KW-001 Build/JRO03C) AppleWebKit/533.1 (KHTML, like Gecko) Version/4.0 UCBrowser/1.0.0.001 U4/0.8.0 Mobile Safari/533.1");
      localMediaMetadataRetriever.setDataSource(paramString, (Map)localObject2);
      localObject2 = localMediaMetadataRetriever.extractMetadata(9);
      localObject1 = localObject2;
    }
    catch (Throwable localThrowable)
    {
      for (;;)
      {
        TTLog.e("[audio] TTAudioPlayerManager", "getMediaDuration exception:", localThrowable);
        localMediaMetadataRetriever.release();
      }
    }
    finally
    {
      localMediaMetadataRetriever.release();
    }
    TTLog.e("[audio] TTAudioPlayerManager", "getMediaDuration duration:" + localObject1 + ", costTime:" + (System.currentTimeMillis() - l) + ", path:" + paramString);
    return localObject1;
  }
  
  private IAudioPlayerBuilder getPlayerBuilder()
  {
    return this.mPlayerBuilder;
  }
  
  private void muteAll()
  {
    try
    {
      TTLog.i("[audio] TTAudioPlayerManager", "muteAll");
      Iterator localIterator = this.playerMap.values().iterator();
      while (localIterator.hasNext())
      {
        IAudioPlayer localIAudioPlayer = (IAudioPlayer)localIterator.next();
        if (localIAudioPlayer != null) {
          localIAudioPlayer.setVolume(0.0F);
        }
      }
      return;
    }
    catch (Throwable localThrowable)
    {
      TTLog.e("[audio] TTAudioPlayerManager", "catching exception :muteAll error:", localThrowable);
    }
  }
  
  private void printActiveAudioContext()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("active InnerAudioContext:");
    localStringBuilder.append("total:").append(this.playerMap.size()).append(" [");
    Iterator localIterator = this.playerMap.keySet().iterator();
    while (localIterator.hasNext())
    {
      Integer localInteger = (Integer)localIterator.next();
      IAudioPlayer localIAudioPlayer = (IAudioPlayer)this.playerMap.get(localInteger);
      if (localIAudioPlayer != null) {
        localStringBuilder.append("{").append(localInteger).append(":").append(localIAudioPlayer.getAudioPath()).append("},");
      }
    }
    localStringBuilder.append("]");
    TTLog.i("[audio] TTAudioPlayerManager", localStringBuilder.toString());
  }
  
  private void restoreVolume()
  {
    for (;;)
    {
      try
      {
        if (this.maxVolume > 0)
        {
          f = 1.0F * this.savedVolume / this.maxVolume;
          TTLog.i("[audio] TTAudioPlayerManager", "restoreVolume volume=" + f);
          Iterator localIterator = this.playerMap.values().iterator();
          if (localIterator.hasNext())
          {
            IAudioPlayer localIAudioPlayer = (IAudioPlayer)localIterator.next();
            if (localIAudioPlayer == null) {
              continue;
            }
            try
            {
              localIAudioPlayer.setVolume(f);
            }
            catch (Throwable localThrowable2)
            {
              TTLog.e("[audio] TTAudioPlayerManager", "mute error:", localThrowable2);
            }
            continue;
          }
          return;
        }
      }
      catch (Throwable localThrowable1)
      {
        TTLog.e("[audio] TTAudioPlayerManager", "catching exception :pauseMusic error:", localThrowable1);
      }
      float f = 1.0F;
    }
  }
  
  public void createAudioContext(int paramInt, IAudioStateChangeListener paramIAudioStateChangeListener)
  {
    IAudioPlayer localIAudioPlayer = (IAudioPlayer)this.idleQueue.poll();
    paramIAudioStateChangeListener = new TTAudioPlayerManager.InnerAudioStateChangeHandler(this, this, paramInt, paramIAudioStateChangeListener);
    this.stateChangeHandlerMap.put(Integer.valueOf(paramInt), paramIAudioStateChangeListener);
    if (localIAudioPlayer == null)
    {
      localIAudioPlayer = genNewAudioPlayer();
      if (localIAudioPlayer != null)
      {
        localIAudioPlayer.setAudioId(paramInt);
        localIAudioPlayer.setStateChangeListener(paramIAudioStateChangeListener);
        this.playerMap.put(Integer.valueOf(paramInt), localIAudioPlayer);
        TTLog.i("[audio] TTAudioPlayerManager", String.format("createAudioContext. audioId=%d total=%d", new Object[] { Integer.valueOf(paramInt), Integer.valueOf(this.playerMap.size()) }));
        return;
      }
      TTLog.e("[audio] TTAudioPlayerManager", String.format("createAudioContext error. audioId=%d total=%d", new Object[] { Integer.valueOf(paramInt), Integer.valueOf(this.playerMap.size()) }));
      return;
    }
    localIAudioPlayer.release();
    localIAudioPlayer.setAudioId(paramInt);
    localIAudioPlayer.setStateChangeListener(paramIAudioStateChangeListener);
    this.playerMap.put(Integer.valueOf(paramInt), localIAudioPlayer);
    TTLog.i("[audio] TTAudioPlayerManager", String.format("createAudioContext reuse. audioId=%d total=%d", new Object[] { Integer.valueOf(paramInt), Integer.valueOf(this.playerMap.size()) }));
  }
  
  public void destroyAudioContext(int paramInt)
  {
    IAudioPlayer localIAudioPlayer = (IAudioPlayer)this.playerMap.remove(Integer.valueOf(paramInt));
    if (localIAudioPlayer != null)
    {
      localIAudioPlayer.release();
      this.idleQueue.add(localIAudioPlayer);
    }
  }
  
  public boolean getAutoplay(int paramInt)
  {
    IAudioPlayer localIAudioPlayer = findAudioPlayer(paramInt);
    if (localIAudioPlayer != null) {
      return localIAudioPlayer.getAutoPlay();
    }
    return false;
  }
  
  public double getBuffered(int paramInt)
  {
    IAudioPlayer localIAudioPlayer = findAudioPlayer(paramInt);
    if (localIAudioPlayer != null) {
      return localIAudioPlayer.getBufferedTime();
    }
    return 0.0D;
  }
  
  public double getCurPosition(int paramInt)
  {
    IAudioPlayer localIAudioPlayer = findAudioPlayer(paramInt);
    if (localIAudioPlayer != null) {
      return localIAudioPlayer.getCurrentPosition();
    }
    return 0.0D;
  }
  
  public double getDuration(int paramInt)
  {
    IAudioPlayer localIAudioPlayer = findAudioPlayer(paramInt);
    if (localIAudioPlayer != null) {
      return localIAudioPlayer.getDuration();
    }
    return 0.0D;
  }
  
  public boolean getLoop(int paramInt)
  {
    IAudioPlayer localIAudioPlayer = findAudioPlayer(paramInt);
    if (localIAudioPlayer != null) {
      return localIAudioPlayer.getLoop();
    }
    return false;
  }
  
  public boolean getMusicSwitch()
  {
    return false;
  }
  
  public boolean getPaused(int paramInt)
  {
    IAudioPlayer localIAudioPlayer = findAudioPlayer(paramInt);
    if (localIAudioPlayer != null) {
      return localIAudioPlayer.isPaused();
    }
    return false;
  }
  
  public float getStartTime(int paramInt)
  {
    IAudioPlayer localIAudioPlayer = findAudioPlayer(paramInt);
    if (localIAudioPlayer != null) {
      return localIAudioPlayer.getStartTime();
    }
    return 0.0F;
  }
  
  public void handleFocusGain()
  {
    if (this.isMute)
    {
      restoreVolume();
      this.isMute = false;
    }
    if (this.mTritonEngine.getJsRuntime(1) != null) {
      this.mTritonEngine.getJsRuntime(1).evaluateSubscribeJs("onAudioInterruptionEnd", null);
    }
  }
  
  public void handleFocusLoss()
  {
    if (this.mAudioManager != null)
    {
      this.savedVolume = this.mAudioManager.getStreamVolume(3);
      this.maxVolume = this.mAudioManager.getStreamMaxVolume(3);
    }
    this.isMute = true;
    muteAll();
    if (this.mTritonEngine.getJsRuntime(1) != null) {
      this.mTritonEngine.getJsRuntime(1).evaluateSubscribeJs("onAudioInterruptionBegin", null);
    }
  }
  
  public void init(Context paramContext)
  {
    this.mAudioManager = ((AudioManager)paramContext.getSystemService("audio"));
    this.onAudioFocusChangeListener = new TTAudioPlayerManager.1(this);
  }
  
  public void onDestroy()
  {
    execAudioFocus(false);
    if (!this.isPause.get()) {
      this.isPause.set(false);
    }
    synchronized (this.mLock)
    {
      Iterator localIterator = this.playerMap.values().iterator();
      while (localIterator.hasNext())
      {
        IAudioPlayer localIAudioPlayer = (IAudioPlayer)localIterator.next();
        if (localIAudioPlayer != null) {
          localIAudioPlayer.release();
        }
      }
    }
    this.playerMap.clear();
    this.idleQueue.clear();
    TTLog.i("[audio] TTAudioPlayerManager", "onDestroy");
  }
  
  public void pauseMusic()
  {
    try
    {
      TTLog.i("[audio] TTAudioPlayerManager", "pauseMusic all");
      this.isPause.set(true);
      execAudioFocus(false);
      Iterator localIterator = this.playerMap.values().iterator();
      while (localIterator.hasNext())
      {
        IAudioPlayer localIAudioPlayer = (IAudioPlayer)localIterator.next();
        if (localIAudioPlayer != null) {
          try
          {
            if (localIAudioPlayer.isPlaying()) {
              localIAudioPlayer.setNeedResume(true);
            }
            localIAudioPlayer.pause();
          }
          catch (Throwable localThrowable2)
          {
            TTLog.e("[audio] TTAudioPlayerManager", "pause error:", localThrowable2);
          }
        }
      }
      return;
    }
    catch (Throwable localThrowable1)
    {
      TTLog.e("[audio] TTAudioPlayerManager", "catching exception :pauseMusic error:", localThrowable1);
    }
  }
  
  public void pauseMusic(int paramInt)
  {
    try
    {
      IAudioPlayer localIAudioPlayer = findAudioPlayer(paramInt);
      if (localIAudioPlayer != null)
      {
        localIAudioPlayer.setNeedResume(false);
        localIAudioPlayer.pause();
      }
      return;
    }
    catch (Throwable localThrowable)
    {
      TTLog.e("[audio] TTAudioPlayerManager", "pauseMusic fail!", localThrowable);
    }
  }
  
  public void playMusic(int paramInt)
  {
    Object localObject = (TTAudioPlayerManager.InnerAudioStateChangeHandler)this.stateChangeHandlerMap.get(Integer.valueOf(paramInt));
    if (localObject != null) {
      ((TTAudioPlayerManager.InnerAudioStateChangeHandler)localObject).setCallPlay(true);
    }
    localObject = (IAudioPlayer)this.playerMap.get(Integer.valueOf(paramInt));
    if (localObject != null)
    {
      ((IAudioPlayer)localObject).play();
      if (!this.mixWithOther) {
        execAudioFocus(true);
      }
    }
  }
  
  public void resumeMusic()
  {
    TTLog.i("[audio] TTAudioPlayerManager", "resumeMusic all");
    this.isPause.set(false);
    if (!this.mixWithOther) {
      execAudioFocus(true);
    }
    Iterator localIterator = this.playerMap.values().iterator();
    while (localIterator.hasNext())
    {
      IAudioPlayer localIAudioPlayer = (IAudioPlayer)localIterator.next();
      if (localIAudioPlayer != null) {
        try
        {
          if (localIAudioPlayer.isNeedResume()) {
            localIAudioPlayer.resume();
          }
        }
        catch (Throwable localThrowable)
        {
          TTLog.e("[audio] TTAudioPlayerManager", "resumeMusic error:", localThrowable);
        }
      }
    }
  }
  
  public void resumeMusic(int paramInt)
  {
    IAudioPlayer localIAudioPlayer = findAudioPlayer(paramInt);
    if (localIAudioPlayer != null)
    {
      if (!this.mixWithOther) {
        execAudioFocus(true);
      }
      localIAudioPlayer.resume();
    }
  }
  
  public void seekTo(int paramInt, float paramFloat)
  {
    IAudioPlayer localIAudioPlayer = findAudioPlayer(paramInt);
    if (localIAudioPlayer != null) {
      localIAudioPlayer.seekTo(paramFloat);
    }
  }
  
  public void setAudioPlayerBuilder(IAudioPlayerBuilder paramIAudioPlayerBuilder)
  {
    this.mPlayerBuilder = paramIAudioPlayerBuilder;
  }
  
  public void setAutoplay(int paramInt, boolean paramBoolean)
  {
    IAudioPlayer localIAudioPlayer = findAudioPlayer(paramInt);
    if (localIAudioPlayer != null) {
      localIAudioPlayer.setAutoPlay(paramBoolean);
    }
  }
  
  public void setLoop(int paramInt, boolean paramBoolean)
  {
    IAudioPlayer localIAudioPlayer = findAudioPlayer(paramInt);
    if (localIAudioPlayer != null) {
      localIAudioPlayer.setLoop(paramBoolean);
    }
  }
  
  public void setMixWithOther(boolean paramBoolean)
  {
    this.mixWithOther = paramBoolean;
    if (!paramBoolean) {}
    for (paramBoolean = true;; paramBoolean = false)
    {
      execAudioFocus(paramBoolean);
      return;
    }
  }
  
  public int setMusicPath(MiniGameInfo paramMiniGameInfo, int paramInt, String paramString)
  {
    try
    {
      boolean bool = URLUtil.isNetworkUrl(paramString);
      if (bool) {
        paramMiniGameInfo = paramString;
      }
      for (;;)
      {
        Object localObject = (TTAudioPlayerManager.InnerAudioStateChangeHandler)this.stateChangeHandlerMap.get(Integer.valueOf(paramInt));
        if (localObject != null) {
          ((TTAudioPlayerManager.InnerAudioStateChangeHandler)localObject).setPath(paramString, paramMiniGameInfo);
        }
        paramString = (IAudioPlayer)this.playerMap.get(Integer.valueOf(paramInt));
        if (paramString != null) {
          paramString.setAudioPath(paramMiniGameInfo);
        }
        return 0;
        paramMiniGameInfo = this.mTritonEngine.getQQEnv().getResPath(paramString, "", paramMiniGameInfo);
        if (!TextUtils.isEmpty(paramMiniGameInfo))
        {
          localObject = new File(paramMiniGameInfo);
          if (((File)localObject).exists())
          {
            paramMiniGameInfo = ((File)localObject).getPath();
          }
          else
          {
            TTLog.e("[audio] TTAudioPlayerManager", "setMusicPath musicPath:" + paramString + ", localPath:" + paramMiniGameInfo + ", file not found");
            paramMiniGameInfo = null;
          }
        }
        else
        {
          TTLog.e("[audio] TTAudioPlayerManager", "setMusicPath musicPath:" + paramString + ", localPath:" + paramMiniGameInfo + " file path empty error");
          paramMiniGameInfo = null;
        }
      }
      return -1;
    }
    catch (Throwable paramMiniGameInfo)
    {
      TTLog.e("[audio] TTAudioPlayerManager", "setMusicPath " + paramString + " error ", paramMiniGameInfo);
    }
  }
  
  public void setMusicSwitch(boolean paramBoolean) {}
  
  public void setStartTime(int paramInt, float paramFloat)
  {
    IAudioPlayer localIAudioPlayer = findAudioPlayer(paramInt);
    if (localIAudioPlayer != null) {
      localIAudioPlayer.setStartTime(paramFloat);
    }
  }
  
  public void setVolume(int paramInt, float paramFloat)
  {
    IAudioPlayer localIAudioPlayer = findAudioPlayer(paramInt);
    if (localIAudioPlayer != null)
    {
      if (this.isMute) {
        paramFloat = 0.0F;
      }
      localIAudioPlayer.setVolume(paramFloat);
    }
  }
  
  public void stopMusic(int paramInt)
  {
    IAudioPlayer localIAudioPlayer = findAudioPlayer(paramInt);
    if (localIAudioPlayer != null) {
      localIAudioPlayer.stop();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.triton.audio.TTAudioPlayerManager
 * JD-Core Version:    0.7.0.1
 */