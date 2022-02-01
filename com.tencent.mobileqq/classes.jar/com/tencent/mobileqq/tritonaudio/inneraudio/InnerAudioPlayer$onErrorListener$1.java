package com.tencent.mobileqq.tritonaudio.inneraudio;

import android.media.MediaPlayer;
import android.media.MediaPlayer.OnErrorListener;
import com.tencent.mobileqq.triton.utils.LogDelegate.DefaultImpls;
import com.tencent.mobileqq.triton.utils.LogDelegate.Level;
import java.util.Arrays;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.StringCompanionObject;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"<anonymous>", "", "<anonymous parameter 0>", "Landroid/media/MediaPlayer;", "kotlin.jvm.PlatformType", "what", "", "extra", "onError"}, k=3, mv={1, 1, 16})
final class InnerAudioPlayer$onErrorListener$1
  implements MediaPlayer.OnErrorListener
{
  InnerAudioPlayer$onErrorListener$1(InnerAudioPlayer paramInnerAudioPlayer) {}
  
  public final boolean onError(MediaPlayer paramMediaPlayer, int paramInt1, int paramInt2)
  {
    paramMediaPlayer = InnerAudioPlayer.access$getLogger$p(this.this$0);
    if (paramMediaPlayer != null)
    {
      LogDelegate.Level localLevel = LogDelegate.Level.ERROR;
      String str = InnerAudioPlayer.access$getTAG$cp();
      Object localObject = StringCompanionObject.INSTANCE;
      localObject = new Object[4];
      localObject[0] = Integer.valueOf(this.this$0.getAudioId());
      localObject[1] = this.this$0.getAudioPath();
      localObject[2] = Integer.valueOf(paramInt1);
      localObject[3] = Integer.valueOf(paramInt2);
      localObject = String.format("onError audioId=%d path=%s errCode=%d extra=%d", Arrays.copyOf((Object[])localObject, localObject.length));
      Intrinsics.checkExpressionValueIsNotNull(localObject, "java.lang.String.format(format, *args)");
      LogDelegate.DefaultImpls.printLog$default(paramMediaPlayer, localLevel, str, (String)localObject, null, 8, null);
    }
    this.this$0.reset();
    InnerAudioPlayer.access$setMIsPrepared$p(this.this$0, false);
    paramMediaPlayer = this.this$0.getStateChangeListener();
    if (paramMediaPlayer != null) {
      paramMediaPlayer.onError(paramInt1);
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.tritonaudio.inneraudio.InnerAudioPlayer.onErrorListener.1
 * JD-Core Version:    0.7.0.1
 */