package com.tencent.mobileqq.tritonaudio.inneraudio;

import android.content.Context;
import android.media.AudioManager;
import android.text.TextUtils;
import android.webkit.URLUtil;
import com.tencent.mobileqq.triton.filesystem.GameDataFileSystem;
import com.tencent.mobileqq.triton.utils.Downloader;
import com.tencent.mobileqq.triton.utils.LogDelegate;
import com.tencent.mobileqq.triton.utils.LogDelegate.DefaultImpls;
import com.tencent.mobileqq.triton.utils.LogDelegate.Level;
import java.io.File;
import java.util.Collection;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.Metadata;
import kotlin.TypeCastException;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/mobileqq/tritonaudio/inneraudio/AudioPlayerManager;", "", "context", "Landroid/content/Context;", "dataFileSystem", "Lcom/tencent/mobileqq/triton/filesystem/GameDataFileSystem;", "downloader", "Lcom/tencent/mobileqq/triton/utils/Downloader;", "logger", "Lcom/tencent/mobileqq/triton/utils/LogDelegate;", "(Landroid/content/Context;Lcom/tencent/mobileqq/triton/filesystem/GameDataFileSystem;Lcom/tencent/mobileqq/triton/utils/Downloader;Lcom/tencent/mobileqq/triton/utils/LogDelegate;)V", "getDataFileSystem", "()Lcom/tencent/mobileqq/triton/filesystem/GameDataFileSystem;", "getDownloader", "()Lcom/tencent/mobileqq/triton/utils/Downloader;", "getLogger", "()Lcom/tencent/mobileqq/triton/utils/LogDelegate;", "mIdleQueue", "Ljava/util/concurrent/ConcurrentLinkedQueue;", "Lcom/tencent/mobileqq/tritonaudio/inneraudio/IAudioPlayer;", "mIsDestoryed", "", "mIsMute", "mIsPause", "Ljava/util/concurrent/atomic/AtomicBoolean;", "mLock", "mMaxVolume", "", "mPlayerMap", "Ljava/util/concurrent/ConcurrentHashMap;", "mSavedVolume", "mStateChangeHandlerMap", "Lcom/tencent/mobileqq/tritonaudio/inneraudio/AudioPlayerManager$InnerAudioStateChangeHandler;", "sw", "musicSwitch", "getMusicSwitch", "()Z", "setMusicSwitch", "(Z)V", "totalErrorCount", "getTotalErrorCount", "()I", "setTotalErrorCount", "(I)V", "createAudioContext", "", "audioId", "listener", "Lcom/tencent/mobileqq/tritonaudio/inneraudio/IAudioStateChangeListener;", "destroyAudioContext", "execAudioFocus", "findAudioPlayer", "getAutoplay", "getBuffered", "", "getCurPosition", "getDuration", "getLoop", "getPaused", "getStartTime", "", "handleFocusGain", "handleFocusLoss", "muteAll", "onDestroy", "pauseMusic", "playMusic", "restoreVolume", "resumeMusic", "seekTo", "pos", "setAutoplay", "autoplay", "setLoop", "loop", "setMusicPath", "musicPath", "", "setStartTime", "startTime", "setVolume", "volume", "stopMusic", "Companion", "InnerAudioStateChangeHandler", "TritonAudio_release"}, k=1, mv={1, 1, 16})
public final class AudioPlayerManager
{
  public static final AudioPlayerManager.Companion Companion = new AudioPlayerManager.Companion(null);
  public static final int MAX_TOTAL_ERROR_COUNT = 10;
  @NotNull
  public static final String TAG = "[audio] AudioPlayerManager";
  private final Context context;
  @NotNull
  private final GameDataFileSystem dataFileSystem;
  @NotNull
  private final Downloader downloader;
  @Nullable
  private final LogDelegate logger;
  private final ConcurrentLinkedQueue<IAudioPlayer> mIdleQueue;
  private boolean mIsDestoryed;
  private volatile boolean mIsMute;
  private final AtomicBoolean mIsPause;
  private final Object mLock;
  private volatile int mMaxVolume;
  private final ConcurrentHashMap<Integer, IAudioPlayer> mPlayerMap;
  private volatile int mSavedVolume;
  private final ConcurrentHashMap<Integer, AudioPlayerManager.InnerAudioStateChangeHandler> mStateChangeHandlerMap;
  private volatile int totalErrorCount;
  
  public AudioPlayerManager(@NotNull Context paramContext, @NotNull GameDataFileSystem paramGameDataFileSystem, @NotNull Downloader paramDownloader, @Nullable LogDelegate paramLogDelegate)
  {
    this.context = paramContext;
    this.dataFileSystem = paramGameDataFileSystem;
    this.downloader = paramDownloader;
    this.logger = paramLogDelegate;
    this.mLock = new Object();
    this.mIsPause = new AtomicBoolean(false);
    this.mPlayerMap = new ConcurrentHashMap();
    this.mStateChangeHandlerMap = new ConcurrentHashMap();
    this.mIdleQueue = new ConcurrentLinkedQueue();
    this.mSavedVolume = 1;
    this.mMaxVolume = 1;
  }
  
  private final IAudioPlayer findAudioPlayer(int paramInt)
  {
    return (IAudioPlayer)this.mPlayerMap.get(Integer.valueOf(paramInt));
  }
  
  private final void muteAll()
  {
    try
    {
      Object localObject1 = this.logger;
      if (localObject1 != null) {
        LogDelegate.DefaultImpls.printLog$default((LogDelegate)localObject1, LogDelegate.Level.INFO, "[audio] AudioPlayerManager", "muteAll", null, 8, null);
      }
      localObject1 = this.mPlayerMap.values().iterator();
      Object localObject2;
      while (((Iterator)localObject1).hasNext())
      {
        localObject2 = (IAudioPlayer)((Iterator)localObject1).next();
        Intrinsics.checkExpressionValueIsNotNull(localObject2, "player");
        ((IAudioPlayer)localObject2).setVolume(0.0F);
      }
      return;
    }
    catch (Throwable localThrowable)
    {
      localObject2 = this.logger;
      if (localObject2 != null) {
        ((LogDelegate)localObject2).printLog(LogDelegate.Level.ERROR, "[audio] AudioPlayerManager", "catching exception :muteAll error:", localThrowable);
      }
    }
  }
  
  private final void restoreVolume()
  {
    try
    {
      int i = this.mMaxVolume;
      float f = 1.0F;
      if (i > 0) {
        f = this.mSavedVolume * 1.0F / this.mMaxVolume;
      }
      Object localObject1 = this.logger;
      Object localObject2;
      Object localObject3;
      if (localObject1 != null)
      {
        localObject2 = LogDelegate.Level.INFO;
        localObject3 = new StringBuilder();
        ((StringBuilder)localObject3).append("restoreVolume volume=");
        ((StringBuilder)localObject3).append(f);
        LogDelegate.DefaultImpls.printLog$default((LogDelegate)localObject1, (LogDelegate.Level)localObject2, "[audio] AudioPlayerManager", ((StringBuilder)localObject3).toString(), null, 8, null);
      }
      localObject1 = this.mPlayerMap.values().iterator();
      while (((Iterator)localObject1).hasNext())
      {
        localObject2 = (IAudioPlayer)((Iterator)localObject1).next();
        try
        {
          Intrinsics.checkExpressionValueIsNotNull(localObject2, "player");
          ((IAudioPlayer)localObject2).setVolume(f);
        }
        catch (Throwable localThrowable2)
        {
          localObject3 = this.logger;
        }
        if (localObject3 != null) {
          ((LogDelegate)localObject3).printLog(LogDelegate.Level.ERROR, "[audio] AudioPlayerManager", "mute error:", localThrowable2);
        }
      }
      LogDelegate localLogDelegate;
      return;
    }
    catch (Throwable localThrowable1)
    {
      localLogDelegate = this.logger;
      if (localLogDelegate != null) {
        localLogDelegate.printLog(LogDelegate.Level.ERROR, "[audio] AudioPlayerManager", "catching exception :pauseMusic error:", localThrowable1);
      }
    }
  }
  
  public final void createAudioContext(int paramInt, @NotNull IAudioStateChangeListener paramIAudioStateChangeListener)
  {
    Intrinsics.checkParameterIsNotNull(paramIAudioStateChangeListener, "listener");
    Object localObject = (IAudioPlayer)this.mIdleQueue.poll();
    paramIAudioStateChangeListener = new AudioPlayerManager.InnerAudioStateChangeHandler(this, this, paramInt, paramIAudioStateChangeListener);
    ((Map)this.mStateChangeHandlerMap).put(Integer.valueOf(paramInt), paramIAudioStateChangeListener);
    StringBuilder localStringBuilder;
    if (localObject == null)
    {
      localObject = (IAudioPlayer)new InnerAudioPlayer(this.logger);
      ((IAudioPlayer)localObject).setAudioId(paramInt);
      ((IAudioPlayer)localObject).setStateChangeListener((IAudioStateChangeListener)paramIAudioStateChangeListener);
      ((Map)this.mPlayerMap).put(Integer.valueOf(paramInt), localObject);
      paramIAudioStateChangeListener = this.logger;
      if (paramIAudioStateChangeListener != null)
      {
        localObject = LogDelegate.Level.INFO;
        localStringBuilder = new StringBuilder();
        localStringBuilder.append("createAudioContext. audioId=");
        localStringBuilder.append(paramInt);
        localStringBuilder.append(" total=");
        localStringBuilder.append(this.mPlayerMap.size());
        LogDelegate.DefaultImpls.printLog$default(paramIAudioStateChangeListener, (LogDelegate.Level)localObject, "[audio] AudioPlayerManager", localStringBuilder.toString(), null, 8, null);
      }
    }
    else
    {
      ((IAudioPlayer)localObject).release();
      ((IAudioPlayer)localObject).setAudioId(paramInt);
      ((IAudioPlayer)localObject).setStateChangeListener((IAudioStateChangeListener)paramIAudioStateChangeListener);
      ((Map)this.mPlayerMap).put(Integer.valueOf(paramInt), localObject);
      paramIAudioStateChangeListener = this.logger;
      if (paramIAudioStateChangeListener != null)
      {
        localObject = LogDelegate.Level.INFO;
        localStringBuilder = new StringBuilder();
        localStringBuilder.append("createAudioContext reuse. audioId=");
        localStringBuilder.append(paramInt);
        localStringBuilder.append(" total=");
        localStringBuilder.append(this.mPlayerMap.size());
        LogDelegate.DefaultImpls.printLog$default(paramIAudioStateChangeListener, (LogDelegate.Level)localObject, "[audio] AudioPlayerManager", localStringBuilder.toString(), null, 8, null);
      }
    }
  }
  
  public final void destroyAudioContext(int paramInt)
  {
    IAudioPlayer localIAudioPlayer = (IAudioPlayer)this.mPlayerMap.remove(Integer.valueOf(paramInt));
    if (localIAudioPlayer != null)
    {
      localIAudioPlayer.release();
      this.mIdleQueue.add(localIAudioPlayer);
    }
  }
  
  public final boolean execAudioFocus()
  {
    boolean bool2 = this.mIsMute;
    boolean bool1 = false;
    if (bool2)
    {
      this.mIsMute = false;
      restoreVolume();
      bool1 = true;
    }
    return bool1;
  }
  
  public final boolean getAutoplay(int paramInt)
  {
    IAudioPlayer localIAudioPlayer = findAudioPlayer(paramInt);
    if (localIAudioPlayer != null) {
      return localIAudioPlayer.getAutoPlay();
    }
    return false;
  }
  
  public final double getBuffered(int paramInt)
  {
    IAudioPlayer localIAudioPlayer = findAudioPlayer(paramInt);
    if (localIAudioPlayer != null) {
      return localIAudioPlayer.getBufferedTime();
    }
    return 0.0D;
  }
  
  public final double getCurPosition(int paramInt)
  {
    IAudioPlayer localIAudioPlayer = findAudioPlayer(paramInt);
    if (localIAudioPlayer != null) {
      return localIAudioPlayer.getCurrentPosition();
    }
    return 0.0D;
  }
  
  @NotNull
  public final GameDataFileSystem getDataFileSystem()
  {
    return this.dataFileSystem;
  }
  
  @NotNull
  public final Downloader getDownloader()
  {
    return this.downloader;
  }
  
  public final double getDuration(int paramInt)
  {
    IAudioPlayer localIAudioPlayer = findAudioPlayer(paramInt);
    if (localIAudioPlayer != null) {
      return localIAudioPlayer.getDuration();
    }
    return 0.0D;
  }
  
  @Nullable
  public final LogDelegate getLogger()
  {
    return this.logger;
  }
  
  public final boolean getLoop(int paramInt)
  {
    IAudioPlayer localIAudioPlayer = findAudioPlayer(paramInt);
    if (localIAudioPlayer != null) {
      return localIAudioPlayer.getLoop();
    }
    return false;
  }
  
  public final boolean getMusicSwitch()
  {
    return false;
  }
  
  public final boolean getPaused(int paramInt)
  {
    IAudioPlayer localIAudioPlayer = findAudioPlayer(paramInt);
    return (localIAudioPlayer != null) && (localIAudioPlayer.isPaused());
  }
  
  public final float getStartTime(int paramInt)
  {
    IAudioPlayer localIAudioPlayer = findAudioPlayer(paramInt);
    if (localIAudioPlayer != null) {
      return localIAudioPlayer.getStartTime();
    }
    return 0.0F;
  }
  
  public final int getTotalErrorCount()
  {
    return this.totalErrorCount;
  }
  
  public final void handleFocusGain()
  {
    if (this.mIsMute)
    {
      restoreVolume();
      this.mIsMute = false;
    }
  }
  
  public final void handleFocusLoss()
  {
    Object localObject = this.context.getSystemService("audio");
    if (localObject != null)
    {
      localObject = (AudioManager)localObject;
      this.mSavedVolume = ((AudioManager)localObject).getStreamVolume(3);
      this.mMaxVolume = ((AudioManager)localObject).getStreamMaxVolume(3);
      this.mIsMute = true;
      muteAll();
      return;
    }
    throw new TypeCastException("null cannot be cast to non-null type android.media.AudioManager");
  }
  
  public final void onDestroy()
  {
    if (!this.mIsPause.get()) {
      this.mIsPause.set(false);
    }
    synchronized (this.mLock)
    {
      this.mIsDestoryed = true;
      Object localObject2 = this.mPlayerMap.values().iterator();
      while (((Iterator)localObject2).hasNext()) {
        ((IAudioPlayer)((Iterator)localObject2).next()).release();
      }
      this.mPlayerMap.clear();
      this.mIdleQueue.clear();
      localObject2 = Unit.INSTANCE;
      ??? = this.logger;
      if (??? != null) {
        LogDelegate.DefaultImpls.printLog$default((LogDelegate)???, LogDelegate.Level.INFO, "[audio] AudioPlayerManager", "onDestroy", null, 8, null);
      }
      return;
    }
    for (;;)
    {
      throw localObject3;
    }
  }
  
  public final void pauseMusic()
  {
    try
    {
      Object localObject = this.logger;
      if (localObject != null) {
        LogDelegate.DefaultImpls.printLog$default((LogDelegate)localObject, LogDelegate.Level.INFO, "[audio] AudioPlayerManager", "pauseMusic all", null, 8, null);
      }
      this.mIsPause.set(true);
      localObject = this.mPlayerMap.values().iterator();
      while (((Iterator)localObject).hasNext())
      {
        IAudioPlayer localIAudioPlayer = (IAudioPlayer)((Iterator)localObject).next();
        LogDelegate localLogDelegate2;
        try
        {
          Intrinsics.checkExpressionValueIsNotNull(localIAudioPlayer, "player");
          if (localIAudioPlayer.isPlaying()) {
            localIAudioPlayer.setNeedResume(true);
          }
          localIAudioPlayer.pause();
        }
        catch (Throwable localThrowable2)
        {
          localLogDelegate2 = this.logger;
        }
        if (localLogDelegate2 != null) {
          localLogDelegate2.printLog(LogDelegate.Level.ERROR, "[audio] AudioPlayerManager", "pause error:", localThrowable2);
        }
      }
      LogDelegate localLogDelegate1;
      return;
    }
    catch (Throwable localThrowable1)
    {
      localLogDelegate1 = this.logger;
      if (localLogDelegate1 != null) {
        localLogDelegate1.printLog(LogDelegate.Level.ERROR, "[audio] AudioPlayerManager", "catching exception :pauseMusic error:", localThrowable1);
      }
    }
  }
  
  public final void pauseMusic(int paramInt)
  {
    try
    {
      IAudioPlayer localIAudioPlayer = findAudioPlayer(paramInt);
      if (localIAudioPlayer != null)
      {
        localIAudioPlayer.setNeedResume(false);
        localIAudioPlayer.pause();
        return;
      }
    }
    catch (Throwable localThrowable)
    {
      LogDelegate localLogDelegate = this.logger;
      if (localLogDelegate != null) {
        localLogDelegate.printLog(LogDelegate.Level.ERROR, "[audio] AudioPlayerManager", "pauseMusic fail!", localThrowable);
      }
    }
  }
  
  public final void playMusic(int paramInt)
  {
    Object localObject = (AudioPlayerManager.InnerAudioStateChangeHandler)this.mStateChangeHandlerMap.get(Integer.valueOf(paramInt));
    if (localObject != null) {
      ((AudioPlayerManager.InnerAudioStateChangeHandler)localObject).setCallPlay(true);
    }
    localObject = (IAudioPlayer)this.mPlayerMap.get(Integer.valueOf(paramInt));
    if (localObject != null) {
      ((IAudioPlayer)localObject).play();
    }
  }
  
  public final void resumeMusic()
  {
    Object localObject = this.logger;
    if (localObject != null) {
      LogDelegate.DefaultImpls.printLog$default((LogDelegate)localObject, LogDelegate.Level.INFO, "[audio] AudioPlayerManager", "resumeMusic all", null, 8, null);
    }
    this.mIsPause.set(false);
    localObject = this.mPlayerMap.values().iterator();
    while (((Iterator)localObject).hasNext())
    {
      IAudioPlayer localIAudioPlayer = (IAudioPlayer)((Iterator)localObject).next();
      LogDelegate localLogDelegate;
      try
      {
        Intrinsics.checkExpressionValueIsNotNull(localIAudioPlayer, "player");
        if (!localIAudioPlayer.isNeedResume()) {
          continue;
        }
        localIAudioPlayer.resume();
      }
      catch (Throwable localThrowable)
      {
        localLogDelegate = this.logger;
      }
      if (localLogDelegate != null) {
        localLogDelegate.printLog(LogDelegate.Level.ERROR, "[audio] AudioPlayerManager", "resumeMusic error:", localThrowable);
      }
    }
    this.totalErrorCount = 0;
  }
  
  public final void seekTo(int paramInt, float paramFloat)
  {
    IAudioPlayer localIAudioPlayer = findAudioPlayer(paramInt);
    if (localIAudioPlayer != null) {
      localIAudioPlayer.seekTo(paramFloat);
    }
  }
  
  public final void setAutoplay(int paramInt, boolean paramBoolean)
  {
    IAudioPlayer localIAudioPlayer = findAudioPlayer(paramInt);
    if (localIAudioPlayer != null) {
      localIAudioPlayer.setAutoPlay(paramBoolean);
    }
  }
  
  public final void setLoop(int paramInt, boolean paramBoolean)
  {
    IAudioPlayer localIAudioPlayer = findAudioPlayer(paramInt);
    if (localIAudioPlayer != null) {
      localIAudioPlayer.setLoop(paramBoolean);
    }
  }
  
  public final int setMusicPath(int paramInt, @Nullable String paramString)
  {
    Object localObject1 = null;
    Object localObject2 = (String)null;
    try
    {
      if (URLUtil.isNetworkUrl(paramString))
      {
        localObject1 = paramString;
      }
      else
      {
        if (!TextUtils.isEmpty((CharSequence)paramString))
        {
          localObject1 = this.dataFileSystem;
          if (paramString == null) {
            Intrinsics.throwNpe();
          }
          localObject1 = ((GameDataFileSystem)localObject1).getFile(paramString).getAbsolutePath();
        }
        if (!TextUtils.isEmpty((CharSequence)localObject1))
        {
          localObject1 = new File((String)localObject1);
          if (((File)localObject1).exists())
          {
            localObject1 = ((File)localObject1).getPath();
            break label174;
          }
        }
        else
        {
          localObject3 = this.logger;
          if (localObject3 != null)
          {
            localObject4 = LogDelegate.Level.ERROR;
            StringBuilder localStringBuilder = new StringBuilder();
            localStringBuilder.append("setMusicPath musicPath:");
            localStringBuilder.append(paramString);
            localStringBuilder.append(", localPath:");
            localStringBuilder.append((String)localObject1);
            localStringBuilder.append(" file path empty error");
            LogDelegate.DefaultImpls.printLog$default((LogDelegate)localObject3, (LogDelegate.Level)localObject4, "[audio] AudioPlayerManager", localStringBuilder.toString(), null, 8, null);
          }
        }
        localObject1 = localObject2;
      }
      label174:
      localObject2 = (AudioPlayerManager.InnerAudioStateChangeHandler)this.mStateChangeHandlerMap.get(Integer.valueOf(paramInt));
      if (localObject2 != null) {
        ((AudioPlayerManager.InnerAudioStateChangeHandler)localObject2).setPath(paramString, (String)localObject1);
      }
      paramString = (IAudioPlayer)this.mPlayerMap.get(Integer.valueOf(paramInt));
      if (paramString != null) {
        paramString.setAudioPath((String)localObject1);
      }
      return 0;
    }
    catch (Throwable localThrowable)
    {
      Object localObject3;
      Object localObject4;
      localObject2 = this.logger;
      if (localObject2 != null)
      {
        localObject3 = LogDelegate.Level.ERROR;
        localObject4 = new StringBuilder();
        ((StringBuilder)localObject4).append("setMusicPath ");
        ((StringBuilder)localObject4).append(paramString);
        ((StringBuilder)localObject4).append(" error ");
        ((LogDelegate)localObject2).printLog((LogDelegate.Level)localObject3, "[audio] AudioPlayerManager", ((StringBuilder)localObject4).toString(), localThrowable);
      }
    }
    return -1;
  }
  
  public final void setMusicSwitch(boolean paramBoolean) {}
  
  public final void setStartTime(int paramInt, float paramFloat)
  {
    IAudioPlayer localIAudioPlayer = findAudioPlayer(paramInt);
    if (localIAudioPlayer != null) {
      localIAudioPlayer.setStartTime(paramFloat);
    }
  }
  
  public final void setTotalErrorCount(int paramInt)
  {
    this.totalErrorCount = paramInt;
  }
  
  public final void setVolume(int paramInt, float paramFloat)
  {
    IAudioPlayer localIAudioPlayer = findAudioPlayer(paramInt);
    if (localIAudioPlayer != null)
    {
      if (this.mIsMute) {
        paramFloat = 0.0F;
      }
      localIAudioPlayer.setVolume(paramFloat);
    }
  }
  
  public final void stopMusic(int paramInt)
  {
    IAudioPlayer localIAudioPlayer = findAudioPlayer(paramInt);
    if (localIAudioPlayer != null) {
      localIAudioPlayer.stop();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.tritonaudio.inneraudio.AudioPlayerManager
 * JD-Core Version:    0.7.0.1
 */