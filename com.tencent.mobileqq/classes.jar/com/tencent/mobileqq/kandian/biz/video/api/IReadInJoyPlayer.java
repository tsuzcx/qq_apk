package com.tencent.mobileqq.kandian.biz.video.api;

import android.view.ViewGroup;
import com.tencent.mobileqq.kandian.base.video.player.PlayerStatusListener;
import java.util.Map;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/mobileqq/kandian/biz/video/api/IReadInJoyPlayer;", "", "addVideoStatusListener", "", "listener", "Lcom/tencent/mobileqq/kandian/base/video/player/PlayerStatusListener;", "attach", "parent", "Landroid/view/ViewGroup;", "callOnVideoPrepared", "detachVideoPlayer", "endHotSwap", "getCurrentPosition", "", "getCurrentState", "", "getDuration", "getPlayFeedbackParamsWithVideoScene", "", "", "getToken", "getVideoHeight", "getVideoWidth", "isBuffering", "", "isCompleted", "isError", "isIdle", "isMute", "isPause", "isPlaying", "isPreload", "isPrepared", "isPreparing", "isReady", "isResumeable", "onDestroy", "onInstallComplete", "success", "onPause", "onResume", "onSeamlessPlayReady", "vid", "url", "openByBusiType", "busiType", "videoUrl", "position", "duration", "pause", "replay", "restart", "seamlessAttachVideoView", "seekTo", "pos", "setKeepLastFrame", "isKeep", "setLoopback", "isLoop", "setMute", "mute", "setProgressRefreshTime", "time", "setReportContentId", "rowkey", "setSpeedRatio", "speed", "", "setVideoPreDownloadMgr", "mgr", "Lcom/tencent/mobileqq/kandian/biz/video/api/IVideoPreDownloadMgr;", "setXYaxis", "xyAxis", "showDebugInfo", "extraInfo", "start", "startHotSwap", "startPreload", "coverFrame", "stop", "kandian-api_release"}, k=1, mv={1, 1, 16})
public abstract interface IReadInJoyPlayer
{
  public abstract int a();
  
  public abstract long a();
  
  @Nullable
  public abstract String a();
  
  @Nullable
  public abstract Map<String, String> a();
  
  public abstract void a();
  
  public abstract void a(float paramFloat);
  
  public abstract void a(int paramInt);
  
  public abstract void a(int paramInt1, @Nullable String paramString1, @Nullable String paramString2, long paramLong, int paramInt2);
  
  public abstract void a(@NotNull ViewGroup paramViewGroup);
  
  public abstract void a(@Nullable PlayerStatusListener paramPlayerStatusListener);
  
  public abstract void a(@Nullable IVideoPreDownloadMgr paramIVideoPreDownloadMgr);
  
  public abstract void a(@Nullable String paramString);
  
  public abstract void a(@NotNull String paramString1, @Nullable String paramString2);
  
  public abstract boolean a();
  
  public abstract int b();
  
  public abstract long b();
  
  public abstract void b();
  
  public abstract void b(int paramInt);
  
  public abstract void b(@Nullable String paramString);
  
  public abstract void b(boolean paramBoolean);
  
  public abstract boolean b();
  
  public abstract int c();
  
  public abstract void c();
  
  public abstract void c(int paramInt);
  
  public abstract void c(boolean paramBoolean);
  
  public abstract void d();
  
  public abstract void d(boolean paramBoolean);
  
  public abstract boolean d();
  
  public abstract void e(boolean paramBoolean);
  
  public abstract boolean e();
  
  public abstract void f();
  
  public abstract void g();
  
  public abstract boolean g();
  
  public abstract void h();
  
  public abstract boolean h();
  
  public abstract void i();
  
  public abstract boolean i();
  
  public abstract void j();
  
  public abstract void k();
  
  public abstract void l();
  
  public abstract void m();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.video.api.IReadInJoyPlayer
 * JD-Core Version:    0.7.0.1
 */