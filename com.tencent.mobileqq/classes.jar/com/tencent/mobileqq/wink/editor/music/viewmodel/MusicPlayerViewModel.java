package com.tencent.mobileqq.wink.editor.music.viewmodel;

import android.media.AudioAttributes;
import android.media.AudioAttributes.Builder;
import android.media.AudioManager;
import android.media.MediaPlayer;
import android.media.MediaPlayer.OnPreparedListener;
import android.os.Build.VERSION;
import android.util.Log;
import androidx.annotation.RequiresApi;
import com.tencent.mobileqq.wink.editor.music.vo.MusicInfoWrapper;
import com.tencent.qqlive.module.videoreport.dtreport.audio.playback.ReportMediaPlayer;
import java.util.Timer;
import java.util.TimerTask;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/mobileqq/wink/editor/music/viewmodel/MusicPlayerViewModel;", "Lcom/tencent/mobileqq/wink/editor/music/viewmodel/AbsWinkMusicPlayerViewModel;", "am", "Landroid/media/AudioManager;", "(Landroid/media/AudioManager;)V", "getAm", "()Landroid/media/AudioManager;", "curMusicEntity", "Lcom/tencent/mobileqq/wink/editor/music/vo/MusicInfoWrapper;", "mediaPlayer", "Landroid/media/MediaPlayer;", "playInterval", "Lcom/tencent/mobileqq/wink/editor/music/viewmodel/MusicPlayerViewModel$Range;", "timer", "Ljava/util/Timer;", "cancelProgressUpdate", "", "clearMusic", "isSourceIdentical", "", "newEntity", "onCleared", "produceMediaPlayer", "releaseMediaPlayer", "scheduleProgressUpdate", "updateInterval", "", "seekToPosition", "position", "", "setDefaultPlayInterval", "startInternal", "startPlayer", "stopInternal", "stopPlayer", "updateBgmSource", "source", "updateMusic", "musicInfoWrapper", "updatePlayInterval", "start", "end", "updateVolume", "newValue", "", "waitToPlay", "musicEntity", "Companion", "Range", "qq-wink-impl_release"}, k=1, mv={1, 1, 16})
public final class MusicPlayerViewModel
  extends AbsWinkMusicPlayerViewModel
{
  public static final MusicPlayerViewModel.Companion a = new MusicPlayerViewModel.Companion(null);
  private static final String g = MusicPlayerViewModel.class.getSimpleName();
  private MediaPlayer b;
  private MusicInfoWrapper c;
  private Timer d;
  private final MusicPlayerViewModel.Range e;
  @NotNull
  private final AudioManager f;
  
  public MusicPlayerViewModel(@NotNull AudioManager paramAudioManager)
  {
    this.f = paramAudioManager;
    this.e = new MusicPlayerViewModel.Range(this, 0, 0, 3, null);
  }
  
  private final void a(int paramInt1, int paramInt2)
  {
    try
    {
      this.e.a(paramInt1);
      this.e.b(paramInt2);
      MediaPlayer localMediaPlayer = this.b;
      if (localMediaPlayer != null) {
        localMediaPlayer.seekTo(paramInt1);
      }
      return;
    }
    catch (IllegalStateException localIllegalStateException) {}
  }
  
  private final void a(long paramLong)
  {
    this.d = new Timer();
    Timer localTimer = this.d;
    if (localTimer != null) {
      localTimer.schedule((TimerTask)new MusicPlayerViewModel.scheduleProgressUpdate.1(this), 0L, paramLong);
    }
  }
  
  private final boolean b(MusicInfoWrapper paramMusicInfoWrapper)
  {
    String str = paramMusicInfoWrapper.c();
    Object localObject = this.c;
    if (localObject != null) {
      localObject = ((MusicInfoWrapper)localObject).c();
    } else {
      localObject = null;
    }
    if (Intrinsics.areEqual(str, localObject))
    {
      int i = paramMusicInfoWrapper.d();
      localObject = this.c;
      if ((localObject != null) && (i == ((MusicInfoWrapper)localObject).d()))
      {
        i = paramMusicInfoWrapper.e();
        paramMusicInfoWrapper = this.c;
        if ((paramMusicInfoWrapper != null) && (i == paramMusicInfoWrapper.e())) {
          return true;
        }
      }
    }
    return false;
  }
  
  @RequiresApi(21)
  private final void c(MusicInfoWrapper paramMusicInfoWrapper)
  {
    MediaPlayer localMediaPlayer = this.b;
    if (localMediaPlayer != null) {
      localMediaPlayer.reset();
    }
    this.e.a();
    if (!d(paramMusicInfoWrapper)) {
      return;
    }
    a(paramMusicInfoWrapper.d(), paramMusicInfoWrapper.d() + paramMusicInfoWrapper.e());
    f();
  }
  
  @RequiresApi(21)
  private final boolean d(MusicInfoWrapper paramMusicInfoWrapper)
  {
    if (paramMusicInfoWrapper == null) {}
    try
    {
      j();
      return false;
    }
    catch (Exception paramMusicInfoWrapper)
    {
      AudioAttributes localAudioAttributes;
      int i;
      MediaPlayer localMediaPlayer;
      Log.e(g, paramMusicInfoWrapper.toString());
    }
    if (this.b == null) {
      this.b = h();
    }
    localAudioAttributes = new AudioAttributes.Builder().build();
    i = this.f.generateAudioSessionId();
    localMediaPlayer = this.b;
    if (localMediaPlayer != null)
    {
      localMediaPlayer.setAudioAttributes(localAudioAttributes);
      localMediaPlayer.setAudioSessionId(i);
      localMediaPlayer.setDataSource(paramMusicInfoWrapper.c());
      localMediaPlayer.setLooping(true);
      localMediaPlayer.prepare();
      localMediaPlayer.seekTo(paramMusicInfoWrapper.d());
    }
    return true;
    return false;
  }
  
  @RequiresApi(21)
  private final void f()
  {
    try
    {
      MediaPlayer localMediaPlayer = this.b;
      if (localMediaPlayer != null) {
        localMediaPlayer.start();
      }
      localMediaPlayer = this.b;
      if (localMediaPlayer != null) {
        localMediaPlayer.seekTo(this.e.b());
      }
      a(100L);
      return;
    }
    catch (IllegalStateException localIllegalStateException) {}
  }
  
  private final void g()
  {
    try
    {
      MediaPlayer localMediaPlayer = this.b;
      if (localMediaPlayer != null) {
        localMediaPlayer.stop();
      }
    }
    catch (Exception localException)
    {
      label13:
      break label13;
    }
    i();
  }
  
  private final MediaPlayer h()
  {
    ReportMediaPlayer localReportMediaPlayer = new ReportMediaPlayer();
    localReportMediaPlayer.setOnPreparedListener((MediaPlayer.OnPreparedListener)MusicPlayerViewModel.produceMediaPlayer.1.a);
    return localReportMediaPlayer;
  }
  
  private final void i()
  {
    Timer localTimer = this.d;
    if (localTimer != null) {
      localTimer.cancel();
    }
    this.d = ((Timer)null);
  }
  
  private final void j()
  {
    g();
    MediaPlayer localMediaPlayer = this.b;
    if (localMediaPlayer != null) {
      localMediaPlayer.release();
    }
    this.b = ((MediaPlayer)null);
  }
  
  public void a(float paramFloat)
  {
    MediaPlayer localMediaPlayer = this.b;
    if (localMediaPlayer != null) {
      localMediaPlayer.setVolume(paramFloat, paramFloat);
    }
  }
  
  public void a(int paramInt)
  {
    MediaPlayer localMediaPlayer = this.b;
    if (localMediaPlayer != null) {
      localMediaPlayer.seekTo(paramInt);
    }
  }
  
  public void a(@NotNull MusicInfoWrapper paramMusicInfoWrapper)
  {
    Intrinsics.checkParameterIsNotNull(paramMusicInfoWrapper, "musicInfoWrapper");
    if (!b(paramMusicInfoWrapper))
    {
      this.c = paramMusicInfoWrapper;
      if (Build.VERSION.SDK_INT >= 21) {
        c(paramMusicInfoWrapper);
      }
    }
  }
  
  public void c()
  {
    if ((Build.VERSION.SDK_INT >= 21) && (d(this.c)))
    {
      MediaPlayer localMediaPlayer = this.b;
      if (localMediaPlayer != null) {
        localMediaPlayer.start();
      }
    }
  }
  
  public void d()
  {
    j();
  }
  
  protected void onCleared()
  {
    super.onCleared();
    j();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.tencent.mobileqq.wink.editor.music.viewmodel.MusicPlayerViewModel
 * JD-Core Version:    0.7.0.1
 */