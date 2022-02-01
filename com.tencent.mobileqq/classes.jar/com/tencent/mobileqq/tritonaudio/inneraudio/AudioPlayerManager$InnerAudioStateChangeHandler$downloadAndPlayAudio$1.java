package com.tencent.mobileqq.tritonaudio.inneraudio;

import com.tencent.mobileqq.triton.filesystem.TemporaryFile;
import com.tencent.mobileqq.triton.utils.Downloader.Listener;
import com.tencent.mobileqq.triton.utils.LogDelegate;
import com.tencent.mobileqq.triton.utils.LogDelegate.DefaultImpls;
import com.tencent.mobileqq.triton.utils.LogDelegate.Level;
import com.tencent.mobileqq.tritonaudio.TritonAudioThreadPool;
import java.util.concurrent.ExecutorService;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"com/tencent/mobileqq/tritonaudio/inneraudio/AudioPlayerManager$InnerAudioStateChangeHandler$downloadAndPlayAudio$1", "Lcom/tencent/mobileqq/triton/utils/Downloader$Listener;", "onFail", "", "errorMsg", "", "onProgress", "total", "", "current", "onSuccess", "TritonAudio_release"}, k=1, mv={1, 1, 16})
public final class AudioPlayerManager$InnerAudioStateChangeHandler$downloadAndPlayAudio$1
  implements Downloader.Listener
{
  AudioPlayerManager$InnerAudioStateChangeHandler$downloadAndPlayAudio$1(TemporaryFile paramTemporaryFile, String paramString) {}
  
  public void onFail(@NotNull String arg1)
  {
    Intrinsics.checkParameterIsNotNull(???, "errorMsg");
    synchronized (AudioPlayerManager.access$getMLock$p(this.this$0.this$0))
    {
      if (!AudioPlayerManager.access$getMIsDestoryed$p(this.this$0.this$0))
      {
        localObject1 = AudioPlayerManager.InnerAudioStateChangeHandler.access$getCallback$p(this.this$0);
        if (localObject1 != null) {
          ((IAudioStateChangeListener)localObject1).onError(10002);
        }
      }
      Object localObject1 = Unit.INSTANCE;
      return;
    }
  }
  
  public void onProgress(long paramLong1, long paramLong2) {}
  
  public void onSuccess()
  {
    synchronized (AudioPlayerManager.access$getMLock$p(this.this$0.this$0))
    {
      if (!AudioPlayerManager.access$getMIsDestoryed$p(this.this$0.this$0))
      {
        AudioPlayerManager.InnerAudioStateChangeHandler.access$setLocalPath$p(this.this$0, this.$temp.getPathInGame());
        localObject2 = this.this$0.this$0.getLogger();
        if (localObject2 != null)
        {
          LogDelegate.Level localLevel = LogDelegate.Level.INFO;
          StringBuilder localStringBuilder = new StringBuilder();
          localStringBuilder.append("download rawPath:");
          localStringBuilder.append(this.$rawPathTemp);
          localStringBuilder.append(" success, localPath:");
          localStringBuilder.append(AudioPlayerManager.InnerAudioStateChangeHandler.access$getLocalPath$p(this.this$0));
          LogDelegate.DefaultImpls.printLog$default((LogDelegate)localObject2, localLevel, "[audio] AudioPlayerManager", localStringBuilder.toString(), null, 8, null);
        }
        TritonAudioThreadPool.getAudioExecutorService().execute((Runnable)new AudioPlayerManager.InnerAudioStateChangeHandler.downloadAndPlayAudio.1.onSuccess..inlined.synchronized.lambda.1(this));
      }
      Object localObject2 = Unit.INSTANCE;
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.tritonaudio.inneraudio.AudioPlayerManager.InnerAudioStateChangeHandler.downloadAndPlayAudio.1
 * JD-Core Version:    0.7.0.1
 */