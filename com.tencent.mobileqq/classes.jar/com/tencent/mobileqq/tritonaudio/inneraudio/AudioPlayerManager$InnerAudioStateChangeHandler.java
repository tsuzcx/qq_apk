package com.tencent.mobileqq.tritonaudio.inneraudio;

import android.text.TextUtils;
import android.webkit.URLUtil;
import com.tencent.mobileqq.triton.filesystem.GameDataFileSystem;
import com.tencent.mobileqq.triton.filesystem.GameDataFileSystem.DefaultImpls;
import com.tencent.mobileqq.triton.filesystem.TemporaryFile;
import com.tencent.mobileqq.triton.utils.Downloader;
import com.tencent.mobileqq.triton.utils.Downloader.Listener;
import com.tencent.mobileqq.triton.utils.LogDelegate;
import com.tencent.mobileqq.triton.utils.LogDelegate.DefaultImpls;
import com.tencent.mobileqq.triton.utils.LogDelegate.Level;
import java.io.File;
import java.lang.ref.WeakReference;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/mobileqq/tritonaudio/inneraudio/AudioPlayerManager$InnerAudioStateChangeHandler;", "Lcom/tencent/mobileqq/tritonaudio/inneraudio/IAudioStateChangeListener;", "manager", "Lcom/tencent/mobileqq/tritonaudio/inneraudio/AudioPlayerManager;", "audioId", "", "callback", "(Lcom/tencent/mobileqq/tritonaudio/inneraudio/AudioPlayerManager;Lcom/tencent/mobileqq/tritonaudio/inneraudio/AudioPlayerManager;ILcom/tencent/mobileqq/tritonaudio/inneraudio/IAudioStateChangeListener;)V", "callPlay", "", "localPath", "", "managerReference", "Ljava/lang/ref/WeakReference;", "maxRetryCount", "rawPath", "retryCount", "src", "downloadAndPlayAudio", "", "hasCallPlay", "isFileExists", "path", "onCanPlay", "onEnded", "onError", "errCode", "onPause", "onPlay", "onSeeked", "onSeeking", "onStop", "onTimeUpdate", "onWaiting", "prepareAndPlayLocalAudio", "needPlay", "setCallPlay", "setPath", "TritonAudio_release"}, k=1, mv={1, 1, 16})
public final class AudioPlayerManager$InnerAudioStateChangeHandler
  implements IAudioStateChangeListener
{
  private int audioId;
  private volatile boolean callPlay;
  private final IAudioStateChangeListener callback;
  private volatile String localPath;
  private WeakReference<AudioPlayerManager> managerReference;
  private final int maxRetryCount;
  private volatile String rawPath;
  private volatile int retryCount;
  private String src;
  
  public AudioPlayerManager$InnerAudioStateChangeHandler(AudioPlayerManager paramAudioPlayerManager, @NotNull int paramInt, IAudioStateChangeListener paramIAudioStateChangeListener)
  {
    this.audioId = paramIAudioStateChangeListener;
    Object localObject;
    this.callback = localObject;
    this.maxRetryCount = 1;
    this.managerReference = new WeakReference(paramInt);
    this.retryCount = 0;
  }
  
  private final void downloadAndPlayAudio()
  {
    String str = this.rawPath;
    if (TextUtils.isEmpty((CharSequence)str)) {}
    Object localObject;
    do
    {
      return;
      localObject = GameDataFileSystem.DefaultImpls.newTempFile$default(this.this$0.getDataFileSystem(), str, null, 2, null);
      Downloader localDownloader = this.this$0.getDownloader();
      if (str == null) {
        Intrinsics.throwNpe();
      }
      localDownloader.download(str, ((TemporaryFile)localObject).getFile(), (Downloader.Listener)new AudioPlayerManager.InnerAudioStateChangeHandler.downloadAndPlayAudio.1(this, (TemporaryFile)localObject, str));
      localObject = this.this$0.getLogger();
    } while (localObject == null);
    LogDelegate.DefaultImpls.printLog$default((LogDelegate)localObject, LogDelegate.Level.INFO, "[audio] AudioPlayerManager", "downloadAndPlayAudio rawPath:" + str, null, 8, null);
  }
  
  private final boolean isFileExists(String paramString)
  {
    return (!TextUtils.isEmpty((CharSequence)paramString)) && (new File(paramString).exists());
  }
  
  private final void prepareAndPlayLocalAudio(boolean paramBoolean)
  {
    Object localObject1;
    if (this.localPath != null)
    {
      localObject1 = this.this$0.getDataFileSystem();
      Object localObject2 = this.localPath;
      if (localObject2 == null) {
        Intrinsics.throwNpe();
      }
      if (((GameDataFileSystem)localObject1).getFile((String)localObject2).exists())
      {
        localObject1 = this.managerReference;
        if (localObject1 != null)
        {
          localObject1 = (AudioPlayerManager)((WeakReference)localObject1).get();
          localObject2 = this.this$0.getLogger();
          if (localObject2 != null) {
            LogDelegate.DefaultImpls.printLog$default((LogDelegate)localObject2, LogDelegate.Level.INFO, "[audio] AudioPlayerManager", "audioId:" + this.audioId + ", playLocalAudio localPath:" + this.localPath, null, 8, null);
          }
          if (localObject1 != null) {
            ((AudioPlayerManager)localObject1).setMusicPath(this.audioId, this.localPath);
          }
          if ((paramBoolean) && (localObject1 != null)) {
            ((AudioPlayerManager)localObject1).playMusic(this.audioId);
          }
        }
      }
    }
    do
    {
      return;
      localObject1 = null;
      break;
      localObject1 = this.this$0.getLogger();
    } while (localObject1 == null);
    LogDelegate.DefaultImpls.printLog$default((LogDelegate)localObject1, LogDelegate.Level.ERROR, "[audio] AudioPlayerManager", "playLocalAudio localPath:" + this.localPath + " not exists", null, 8, null);
  }
  
  public final boolean hasCallPlay()
  {
    return this.callPlay;
  }
  
  public void onCanPlay()
  {
    IAudioStateChangeListener localIAudioStateChangeListener = this.callback;
    if (localIAudioStateChangeListener != null) {
      localIAudioStateChangeListener.onCanPlay();
    }
  }
  
  public void onEnded()
  {
    IAudioStateChangeListener localIAudioStateChangeListener = this.callback;
    if (localIAudioStateChangeListener != null) {
      localIAudioStateChangeListener.onEnded();
    }
  }
  
  public void onError(int paramInt)
  {
    Object localObject = this.managerReference;
    if (localObject != null)
    {
      localObject = (AudioPlayerManager)((WeakReference)localObject).get();
      if (localObject == null) {
        break label202;
      }
    }
    label202:
    for (int i = ((AudioPlayerManager)localObject).getTotalErrorCount();; i = 10)
    {
      LogDelegate localLogDelegate = this.this$0.getLogger();
      if (localLogDelegate != null) {
        LogDelegate.DefaultImpls.printLog$default(localLogDelegate, LogDelegate.Level.ERROR, "[audio] AudioPlayerManager", toString() + " onError retryCount:" + this.retryCount + ", audioId:" + this.audioId + " totalErrorCount:" + i, null, 8, null);
      }
      if ((URLUtil.isNetworkUrl(this.rawPath)) && (this.retryCount < this.maxRetryCount) && (i < 10))
      {
        this.retryCount += 1;
        if (localObject != null) {
          ((AudioPlayerManager)localObject).setTotalErrorCount(((AudioPlayerManager)localObject).getTotalErrorCount() + 1);
        }
        if (isFileExists(this.localPath)) {
          prepareAndPlayLocalAudio(hasCallPlay());
        }
      }
      do
      {
        return;
        localObject = null;
        break;
        downloadAndPlayAudio();
        return;
        localObject = this.callback;
      } while (localObject == null);
      ((IAudioStateChangeListener)localObject).onError(paramInt);
      return;
    }
  }
  
  public void onPause()
  {
    IAudioStateChangeListener localIAudioStateChangeListener = this.callback;
    if (localIAudioStateChangeListener != null) {
      localIAudioStateChangeListener.onPause();
    }
  }
  
  public void onPlay()
  {
    IAudioStateChangeListener localIAudioStateChangeListener = this.callback;
    if (localIAudioStateChangeListener != null) {
      localIAudioStateChangeListener.onPlay();
    }
  }
  
  public void onSeeked()
  {
    IAudioStateChangeListener localIAudioStateChangeListener = this.callback;
    if (localIAudioStateChangeListener != null) {
      localIAudioStateChangeListener.onSeeked();
    }
  }
  
  public void onSeeking()
  {
    IAudioStateChangeListener localIAudioStateChangeListener = this.callback;
    if (localIAudioStateChangeListener != null) {
      localIAudioStateChangeListener.onSeeking();
    }
  }
  
  public void onStop()
  {
    IAudioStateChangeListener localIAudioStateChangeListener = this.callback;
    if (localIAudioStateChangeListener != null) {
      localIAudioStateChangeListener.onStop();
    }
  }
  
  public void onTimeUpdate()
  {
    IAudioStateChangeListener localIAudioStateChangeListener = this.callback;
    if (localIAudioStateChangeListener != null) {
      localIAudioStateChangeListener.onTimeUpdate();
    }
  }
  
  public void onWaiting()
  {
    IAudioStateChangeListener localIAudioStateChangeListener = this.callback;
    if (localIAudioStateChangeListener != null) {
      localIAudioStateChangeListener.onWaiting();
    }
  }
  
  public final void setCallPlay(boolean paramBoolean)
  {
    this.callPlay = paramBoolean;
  }
  
  public final void setPath(@Nullable String paramString1, @Nullable String paramString2)
  {
    this.src = paramString1;
    this.rawPath = paramString2;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.tritonaudio.inneraudio.AudioPlayerManager.InnerAudioStateChangeHandler
 * JD-Core Version:    0.7.0.1
 */