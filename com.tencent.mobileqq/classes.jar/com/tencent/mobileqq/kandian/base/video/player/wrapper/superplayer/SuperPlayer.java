package com.tencent.mobileqq.kandian.base.video.player.wrapper.superplayer;

import android.content.Context;
import android.graphics.Bitmap;
import android.view.View;
import com.tencent.mobileqq.kandian.base.video.player.api.IEventListener;
import com.tencent.mobileqq.kandian.base.video.player.api.IPlayer;
import com.tencent.mobileqq.kandian.base.video.player.api.IVideoView;
import com.tencent.mobileqq.kandian.base.video.player.wrapper.PlayerVideoInfo;
import com.tencent.mobileqq.kandian.base.video.player.wrapper.PlayerVideoInfoKtKt;
import com.tencent.superplayer.api.ISuperPlayer;
import com.tencent.superplayer.api.ISuperPlayer.OnCaptureImageListener;
import com.tencent.superplayer.api.ISuperPlayer.OnCompletionListener;
import com.tencent.superplayer.api.ISuperPlayer.OnErrorListener;
import com.tencent.superplayer.api.ISuperPlayer.OnInfoListener;
import com.tencent.superplayer.api.ISuperPlayer.OnSeekCompleteListener;
import com.tencent.superplayer.api.ISuperPlayer.OnVideoPreparedListener;
import com.tencent.superplayer.api.SuperPlayerOption;
import com.tencent.superplayer.view.ISPlayerVideoView;
import com.tencent.thumbplayer.api.TPPlayerMsg.TPDownLoadProgressInfo;
import java.util.Map;
import kotlin.Metadata;
import kotlin.TypeCastException;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/mobileqq/kandian/base/video/player/wrapper/superplayer/SuperPlayer;", "Lcom/tencent/mobileqq/kandian/base/video/player/api/IPlayer;", "Lcom/tencent/superplayer/api/ISuperPlayer$OnVideoPreparedListener;", "Lcom/tencent/superplayer/api/ISuperPlayer$OnCompletionListener;", "Lcom/tencent/superplayer/api/ISuperPlayer$OnErrorListener;", "Lcom/tencent/superplayer/api/ISuperPlayer$OnInfoListener;", "Lcom/tencent/superplayer/api/ISuperPlayer$OnCaptureImageListener;", "Lcom/tencent/superplayer/api/ISuperPlayer$OnSeekCompleteListener;", "videoPlayer", "Lcom/tencent/superplayer/api/ISuperPlayer;", "(Lcom/tencent/superplayer/api/ISuperPlayer;)V", "currentPositionMs", "", "getCurrentPositionMs", "()J", "currentVideoView", "Lcom/tencent/mobileqq/kandian/base/video/player/api/IVideoView;", "durationMs", "getDurationMs", "isBuffering", "", "()Z", "value", "isLoopBack", "setLoopBack", "(Z)V", "isPauseing", "isPlaying", "isPrepared", "isPrepareing", "listener", "Lcom/tencent/mobileqq/kandian/base/video/player/api/IEventListener;", "outputMute", "getOutputMute", "setOutputMute", "", "speedRatio", "getSpeedRatio", "()F", "setSpeedRatio", "(F)V", "videoHeight", "", "getVideoHeight", "()I", "videoWidth", "getVideoWidth", "addExtReportData", "", "data", "", "", "getStreamDumpInfo", "getToken", "getVideoView", "onCaptureImageFailed", "p0", "id", "errorCode", "onCaptureImageSucceed", "width", "height", "bitmap", "Landroid/graphics/Bitmap;", "onCompletion", "onError", "tvkPlayer", "module", "errorType", "extraInfo", "onInfo", "what", "arg1", "arg2", "extra", "", "onSeekComplete", "onVideoPrepared", "openMediaPlayer", "context", "Landroid/content/Context;", "videoInfo", "Lcom/tencent/mobileqq/kandian/base/video/player/wrapper/PlayerVideoInfo;", "startPositionMilsec", "playerOption", "Lcom/tencent/superplayer/api/SuperPlayerOption;", "pause", "pauseDownload", "prePlayViewShow", "release", "resumeDownload", "seekTo", "positionMilsec", "mode", "setEventListener", "setHttpBufferRange", "emergencyTime", "safePlayTime", "preloadDuration", "setLoopback", "isLoopback", "setPlayerActive", "setReportContentId", "rowkey", "setXYaxis", "type", "start", "stop", "updatePlayerVideoView", "videoView", "kandian_feature_impl_release"}, k=1, mv={1, 1, 16})
public final class SuperPlayer
  implements IPlayer, ISuperPlayer.OnCaptureImageListener, ISuperPlayer.OnCompletionListener, ISuperPlayer.OnErrorListener, ISuperPlayer.OnInfoListener, ISuperPlayer.OnSeekCompleteListener, ISuperPlayer.OnVideoPreparedListener
{
  private IEventListener b;
  private IVideoView c;
  private float d;
  private final ISuperPlayer e;
  
  public SuperPlayer(@Nullable ISuperPlayer paramISuperPlayer)
  {
    this.e = paramISuperPlayer;
    this.d = 1.0F;
  }
  
  public float a()
  {
    return this.d;
  }
  
  public void a(float paramFloat)
  {
    this.d = paramFloat;
    ISuperPlayer localISuperPlayer = this.e;
    if (localISuperPlayer != null) {
      localISuperPlayer.setPlaySpeedRatio(this.d);
    }
  }
  
  public void a(int paramInt)
  {
    int j = 0;
    int i = j;
    if (paramInt != 0) {
      if (paramInt != 1)
      {
        if (paramInt != 2)
        {
          if (paramInt != 3) {
            i = j;
          } else {
            i = 3;
          }
        }
        else {
          i = 2;
        }
      }
      else {
        i = 1;
      }
    }
    ISuperPlayer localISuperPlayer = this.e;
    if (localISuperPlayer != null) {
      localISuperPlayer.setXYaxis(i);
    }
  }
  
  public void a(int paramInt1, int paramInt2)
  {
    int j = 1;
    int i = j;
    if (paramInt2 != 1) {
      if (paramInt2 != 2)
      {
        if (paramInt2 != 3) {
          i = j;
        } else {
          i = 3;
        }
      }
      else {
        i = 2;
      }
    }
    ISuperPlayer localISuperPlayer = this.e;
    if (localISuperPlayer != null) {
      localISuperPlayer.seekTo(paramInt1, i);
    }
  }
  
  public void a(int paramInt1, int paramInt2, int paramInt3)
  {
    ISuperPlayer localISuperPlayer = this.e;
    if (localISuperPlayer != null) {
      localISuperPlayer.setBusinessDownloadStrategy(paramInt1, paramInt2, paramInt3, paramInt3);
    }
  }
  
  public void a(@Nullable Context paramContext, @NotNull PlayerVideoInfo paramPlayerVideoInfo, long paramLong, @NotNull SuperPlayerOption paramSuperPlayerOption)
  {
    Intrinsics.checkParameterIsNotNull(paramPlayerVideoInfo, "videoInfo");
    Intrinsics.checkParameterIsNotNull(paramSuperPlayerOption, "playerOption");
    ISuperPlayer localISuperPlayer = this.e;
    if (localISuperPlayer != null)
    {
      if (paramContext != null) {
        paramContext = paramContext.getApplicationContext();
      } else {
        paramContext = null;
      }
      localISuperPlayer.openMediaPlayer(paramContext, PlayerVideoInfoKtKt.a(paramPlayerVideoInfo), paramLong, paramSuperPlayerOption);
    }
  }
  
  public void a(@Nullable IEventListener paramIEventListener)
  {
    this.b = paramIEventListener;
    paramIEventListener = this.e;
    if (paramIEventListener != null) {
      paramIEventListener.setOnVideoPreparedListener((ISuperPlayer.OnVideoPreparedListener)this);
    }
    paramIEventListener = this.e;
    if (paramIEventListener != null) {
      paramIEventListener.setOnCompletionListener((ISuperPlayer.OnCompletionListener)this);
    }
    paramIEventListener = this.e;
    if (paramIEventListener != null) {
      paramIEventListener.setOnErrorListener((ISuperPlayer.OnErrorListener)this);
    }
    paramIEventListener = this.e;
    if (paramIEventListener != null) {
      paramIEventListener.setOnInfoListener((ISuperPlayer.OnInfoListener)this);
    }
    paramIEventListener = this.e;
    if (paramIEventListener != null) {
      paramIEventListener.setOnCaptureImageListener((ISuperPlayer.OnCaptureImageListener)this);
    }
    paramIEventListener = this.e;
    if (paramIEventListener != null) {
      paramIEventListener.setOnSeekCompleteListener((ISuperPlayer.OnSeekCompleteListener)this);
    }
  }
  
  public void a(@Nullable IVideoView paramIVideoView)
  {
    this.c = paramIVideoView;
    ISuperPlayer localISuperPlayer = this.e;
    if (localISuperPlayer != null)
    {
      if (paramIVideoView != null) {
        paramIVideoView = paramIVideoView.a();
      } else {
        paramIVideoView = null;
      }
      IVideoView localIVideoView = paramIVideoView;
      if (!(paramIVideoView instanceof ISPlayerVideoView)) {
        localIVideoView = null;
      }
      localISuperPlayer.updatePlayerVideoView((ISPlayerVideoView)localIVideoView);
    }
  }
  
  public void a(@Nullable String paramString)
  {
    ISuperPlayer localISuperPlayer = this.e;
    if (localISuperPlayer != null) {
      localISuperPlayer.setReportContentId(paramString);
    }
  }
  
  public void a(@NotNull Map<String, String> paramMap)
  {
    Intrinsics.checkParameterIsNotNull(paramMap, "data");
    ISuperPlayer localISuperPlayer = this.e;
    if (localISuperPlayer != null) {
      localISuperPlayer.addExtReportData(paramMap);
    }
  }
  
  public void a(boolean paramBoolean)
  {
    ISuperPlayer localISuperPlayer = this.e;
    if (localISuperPlayer != null) {
      localISuperPlayer.setOutputMute(paramBoolean);
    }
  }
  
  public void b(boolean paramBoolean)
  {
    ISuperPlayer localISuperPlayer = this.e;
    if (localISuperPlayer != null) {
      localISuperPlayer.setLoopback(paramBoolean);
    }
  }
  
  public boolean b()
  {
    ISuperPlayer localISuperPlayer = this.e;
    return (localISuperPlayer != null) && (localISuperPlayer.isOutputMute() == true);
  }
  
  public void c(boolean paramBoolean)
  {
    ISuperPlayer localISuperPlayer = this.e;
    if (localISuperPlayer != null) {
      localISuperPlayer.setLoopback(paramBoolean);
    }
  }
  
  public boolean c()
  {
    ISuperPlayer localISuperPlayer = this.e;
    return (localISuperPlayer != null) && (localISuperPlayer.isPlaying() == true);
  }
  
  public boolean d()
  {
    ISuperPlayer localISuperPlayer = this.e;
    return (localISuperPlayer != null) && (localISuperPlayer.isBuffering() == true);
  }
  
  public boolean e()
  {
    Object localObject = this.e;
    if (localObject != null) {
      localObject = Integer.valueOf(((ISuperPlayer)localObject).getCurrentPlayerState());
    } else {
      localObject = null;
    }
    boolean bool2 = true;
    boolean bool1;
    if (localObject != null)
    {
      bool1 = bool2;
      if (((Integer)localObject).intValue() == 3) {}
    }
    else if (localObject != null)
    {
      bool1 = bool2;
      if (((Integer)localObject).intValue() == 1) {}
    }
    else
    {
      if ((localObject != null) && (((Integer)localObject).intValue() == 2)) {
        return true;
      }
      bool1 = false;
    }
    return bool1;
  }
  
  public boolean f()
  {
    ISuperPlayer localISuperPlayer = this.e;
    return (localISuperPlayer != null) && (localISuperPlayer.getCurrentPlayerState() == 4);
  }
  
  public void g()
  {
    ISuperPlayer localISuperPlayer = this.e;
    if (localISuperPlayer != null) {
      localISuperPlayer.start();
    }
  }
  
  public void h()
  {
    ISuperPlayer localISuperPlayer = this.e;
    if (localISuperPlayer != null) {
      localISuperPlayer.pause();
    }
  }
  
  public void i()
  {
    Object localObject = this.e;
    if (localObject != null) {
      ((ISuperPlayer)localObject).reset();
    }
    localObject = this.c;
    if (localObject != null)
    {
      ISuperPlayer localISuperPlayer = this.e;
      if (localISuperPlayer != null)
      {
        View localView = ((IVideoView)localObject).a();
        localObject = localView;
        if (!(localView instanceof ISPlayerVideoView)) {
          localObject = null;
        }
        localISuperPlayer.updatePlayerVideoView((ISPlayerVideoView)localObject);
      }
    }
  }
  
  public boolean j()
  {
    ISuperPlayer localISuperPlayer = this.e;
    return (localISuperPlayer != null) && (localISuperPlayer.isPausing() == true);
  }
  
  public void k()
  {
    ISuperPlayer localISuperPlayer = this.e;
    if (localISuperPlayer != null) {
      localISuperPlayer.stop();
    }
    localISuperPlayer = this.e;
    if (localISuperPlayer != null) {
      localISuperPlayer.release();
    }
  }
  
  public void l()
  {
    ISuperPlayer localISuperPlayer = this.e;
    if (localISuperPlayer != null) {
      localISuperPlayer.pauseDownload();
    }
  }
  
  public void m()
  {
    ISuperPlayer localISuperPlayer = this.e;
    if (localISuperPlayer != null) {
      localISuperPlayer.resumeDownload();
    }
  }
  
  public long n()
  {
    ISuperPlayer localISuperPlayer = this.e;
    if (localISuperPlayer != null) {
      return localISuperPlayer.getDurationMs();
    }
    return 0L;
  }
  
  public long o()
  {
    ISuperPlayer localISuperPlayer = this.e;
    if (localISuperPlayer != null) {
      return localISuperPlayer.getCurrentPositionMs();
    }
    return 0L;
  }
  
  public void onCaptureImageFailed(@Nullable ISuperPlayer paramISuperPlayer, int paramInt1, int paramInt2)
  {
    paramISuperPlayer = this.b;
    if (paramISuperPlayer != null) {
      paramISuperPlayer.a((IPlayer)this, paramInt1, paramInt2);
    }
  }
  
  public void onCaptureImageSucceed(@Nullable ISuperPlayer paramISuperPlayer, int paramInt1, int paramInt2, int paramInt3, @Nullable Bitmap paramBitmap)
  {
    paramISuperPlayer = this.b;
    if (paramISuperPlayer != null) {
      paramISuperPlayer.a((IPlayer)this, paramInt1, paramInt2, paramInt3, paramBitmap);
    }
  }
  
  public void onCompletion(@Nullable ISuperPlayer paramISuperPlayer)
  {
    paramISuperPlayer = this.b;
    if (paramISuperPlayer != null) {
      paramISuperPlayer.b((IPlayer)this);
    }
  }
  
  public boolean onError(@Nullable ISuperPlayer paramISuperPlayer, int paramInt1, int paramInt2, int paramInt3, @Nullable String paramString)
  {
    paramISuperPlayer = this.b;
    return (paramISuperPlayer != null) && (paramISuperPlayer.a((IPlayer)this, paramInt1, paramInt2, paramInt3, paramString) == true);
  }
  
  public boolean onInfo(@Nullable ISuperPlayer paramISuperPlayer, int paramInt, long paramLong1, long paramLong2, @Nullable Object paramObject)
  {
    int i = 113;
    if (paramInt != 105)
    {
      if (paramInt != 108)
      {
        if (paramInt != 112)
        {
          if (paramInt != 113) {
            i = paramInt;
          }
        }
        else {
          i = 112;
        }
      }
      else {
        i = 108;
      }
    }
    else {
      i = 105;
    }
    if (i == 209) {
      paramISuperPlayer = Long.valueOf(paramLong1);
    } else {
      paramISuperPlayer = paramObject;
    }
    if (paramInt == 207)
    {
      if (paramObject != null)
      {
        paramISuperPlayer = (TPPlayerMsg.TPDownLoadProgressInfo)paramObject;
        paramObject = this.b;
        if (paramObject != null) {
          paramObject.a(paramISuperPlayer.currentDownloadSize, paramISuperPlayer.totalFileSize, paramISuperPlayer.extraInfo);
        }
        return true;
      }
      throw new TypeCastException("null cannot be cast to non-null type com.tencent.thumbplayer.api.TPPlayerMsg.TPDownLoadProgressInfo");
    }
    paramObject = this.b;
    return (paramObject != null) && (paramObject.a((IPlayer)this, i, paramISuperPlayer) == true);
  }
  
  public void onSeekComplete(@Nullable ISuperPlayer paramISuperPlayer)
  {
    paramISuperPlayer = this.b;
    if (paramISuperPlayer != null) {
      paramISuperPlayer.c((IPlayer)this);
    }
  }
  
  public void onVideoPrepared(@Nullable ISuperPlayer paramISuperPlayer)
  {
    paramISuperPlayer = this.b;
    if (paramISuperPlayer != null) {
      paramISuperPlayer.a((IPlayer)this);
    }
  }
  
  public int p()
  {
    ISuperPlayer localISuperPlayer = this.e;
    if (localISuperPlayer != null) {
      return localISuperPlayer.getVideoWidth();
    }
    return 0;
  }
  
  public int q()
  {
    ISuperPlayer localISuperPlayer = this.e;
    if (localISuperPlayer != null) {
      return localISuperPlayer.getVideoHeight();
    }
    return 0;
  }
  
  @Nullable
  public String r()
  {
    ISuperPlayer localISuperPlayer = this.e;
    if (localISuperPlayer != null) {
      return localISuperPlayer.getStreamDumpInfo();
    }
    return null;
  }
  
  public void s()
  {
    ISuperPlayer localISuperPlayer = this.e;
    if (localISuperPlayer != null) {
      localISuperPlayer.onPrePlayViewShow();
    }
  }
  
  @NotNull
  public String t()
  {
    Object localObject = this.e;
    if (localObject != null)
    {
      localObject = ((ISuperPlayer)localObject).getToken();
      if (localObject != null) {
        return localObject;
      }
    }
    return "";
  }
  
  @Nullable
  public IVideoView u()
  {
    Object localObject = this.e;
    if (localObject != null)
    {
      localObject = ((ISuperPlayer)localObject).getVideoView();
      if (localObject != null) {
        return (IVideoView)new SuperPlayerVideoView((ISPlayerVideoView)localObject);
      }
    }
    return null;
  }
  
  public void v()
  {
    ISuperPlayer localISuperPlayer = this.e;
    if (localISuperPlayer != null) {
      localISuperPlayer.setPlayerActive();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.base.video.player.wrapper.superplayer.SuperPlayer
 * JD-Core Version:    0.7.0.1
 */