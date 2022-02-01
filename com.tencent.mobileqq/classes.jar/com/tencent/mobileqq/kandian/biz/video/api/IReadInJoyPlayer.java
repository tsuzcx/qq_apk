package com.tencent.mobileqq.kandian.biz.video.api;

import android.view.ViewGroup;
import com.tencent.mobileqq.kandian.base.video.player.PlayerStatusListener;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/mobileqq/kandian/biz/video/api/IReadInJoyPlayer;", "", "addVideoStatusListener", "", "listener", "Lcom/tencent/mobileqq/kandian/base/video/player/PlayerStatusListener;", "attach", "parent", "Landroid/view/ViewGroup;", "callOnVideoPrepared", "detachVideoPlayer", "endHotSwap", "getCurrentPosition", "", "getCurrentState", "", "getDuration", "getPlayFeedbackParamsWithVideoScene", "", "", "getToken", "getVideoHeight", "getVideoWidth", "isBuffering", "", "isCompleted", "isError", "isIdle", "isMute", "isPause", "isPlaying", "isPreload", "isPrepared", "isPreparing", "isReady", "isResumeable", "onDestroy", "onInstallComplete", "success", "onPause", "onResume", "onSeamlessPlayReady", "vid", "url", "openByBusiType", "busiType", "videoUrl", "position", "duration", "pause", "replay", "restart", "seamlessAttachVideoView", "seekTo", "pos", "setKeepLastFrame", "isKeep", "setLoopback", "isLoop", "setMute", "mute", "setProgressRefreshTime", "time", "setReportContentId", "rowkey", "setSpeedRatio", "speed", "", "setVideoPreDownloadMgr", "mgr", "Lcom/tencent/mobileqq/kandian/biz/video/api/IVideoPreDownloadMgr;", "setXYaxis", "xyAxis", "showDebugInfo", "extraInfo", "start", "startHotSwap", "startPreload", "coverFrame", "stop", "kandian-api_release"}, k=1, mv={1, 1, 16})
public abstract interface IReadInJoyPlayer
{
  public abstract void C();
  
  public abstract void D();
  
  public abstract void F();
  
  public abstract void a(int paramInt);
  
  public abstract void a(int paramInt1, @Nullable String paramString1, @Nullable String paramString2, long paramLong, int paramInt2);
  
  public abstract void a(@NotNull ViewGroup paramViewGroup);
  
  public abstract void a(@Nullable PlayerStatusListener paramPlayerStatusListener);
  
  public abstract void a(@Nullable IVideoPreDownloadMgr paramIVideoPreDownloadMgr);
  
  public abstract void b(int paramInt);
  
  public abstract void b(boolean paramBoolean);
  
  public abstract boolean b();
  
  public abstract void c(int paramInt);
  
  public abstract void c(boolean paramBoolean);
  
  public abstract void d(boolean paramBoolean);
  
  public abstract void e();
  
  public abstract void e(boolean paramBoolean);
  
  public abstract void f();
  
  public abstract void h();
  
  public abstract long j();
  
  public abstract long k();
  
  public abstract int l();
  
  public abstract void m();
  
  public abstract void n();
  
  public abstract boolean o();
  
  public abstract boolean t();
  
  public abstract boolean u();
  
  public abstract int w();
  
  public abstract int x();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.video.api.IReadInJoyPlayer
 * JD-Core Version:    0.7.0.1
 */