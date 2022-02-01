package com.tencent.mobileqq.kandian.base.video.player.api;

import android.content.Context;
import com.tencent.mobileqq.kandian.base.video.player.wrapper.PlayerVideoInfo;
import com.tencent.superplayer.api.SuperPlayerOption;
import java.util.Map;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/mobileqq/kandian/base/video/player/api/IPlayer;", "", "currentPositionMs", "", "getCurrentPositionMs", "()J", "durationMs", "getDurationMs", "isBuffering", "", "()Z", "isLoopBack", "setLoopBack", "(Z)V", "isPauseing", "isPlaying", "isPrepared", "isPrepareing", "outputMute", "getOutputMute", "setOutputMute", "speedRatio", "", "getSpeedRatio", "()F", "setSpeedRatio", "(F)V", "videoHeight", "", "getVideoHeight", "()I", "videoWidth", "getVideoWidth", "addExtReportData", "", "data", "", "", "getStreamDumpInfo", "getToken", "getVideoView", "Lcom/tencent/mobileqq/kandian/base/video/player/api/IVideoView;", "openMediaPlayer", "context", "Landroid/content/Context;", "videoInfo", "Lcom/tencent/mobileqq/kandian/base/video/player/wrapper/PlayerVideoInfo;", "startPositionMilsec", "playerOption", "Lcom/tencent/superplayer/api/SuperPlayerOption;", "pause", "pauseDownload", "prePlayViewShow", "release", "resumeDownload", "seekTo", "positionMilsec", "mode", "setEventListener", "listener", "Lcom/tencent/mobileqq/kandian/base/video/player/api/IEventListener;", "setHttpBufferRange", "emergencyTime", "safePlayTime", "preloadDuration", "setLoopback", "isLoopback", "setPlayerActive", "setReportContentId", "rowkey", "setXYaxis", "type", "start", "stop", "updatePlayerVideoView", "videoView", "Companion", "kandian-api_release"}, k=1, mv={1, 1, 16})
public abstract interface IPlayer
{
  public static final IPlayer.Companion a = IPlayer.Companion.a;
  
  public abstract float a();
  
  public abstract int a();
  
  public abstract long a();
  
  @Nullable
  public abstract IVideoView a();
  
  @Nullable
  public abstract String a();
  
  public abstract void a();
  
  public abstract void a(float paramFloat);
  
  public abstract void a(int paramInt);
  
  public abstract void a(int paramInt1, int paramInt2);
  
  public abstract void a(int paramInt1, int paramInt2, int paramInt3);
  
  public abstract void a(@Nullable Context paramContext, @NotNull PlayerVideoInfo paramPlayerVideoInfo, long paramLong, @NotNull SuperPlayerOption paramSuperPlayerOption);
  
  public abstract void a(@Nullable IEventListener paramIEventListener);
  
  public abstract void a(@Nullable IVideoView paramIVideoView);
  
  public abstract void a(@Nullable String paramString);
  
  public abstract void a(@NotNull Map<String, String> paramMap);
  
  public abstract void a(boolean paramBoolean);
  
  public abstract boolean a();
  
  public abstract int b();
  
  public abstract long b();
  
  @NotNull
  public abstract String b();
  
  public abstract void b();
  
  public abstract void b(boolean paramBoolean);
  
  public abstract boolean b();
  
  public abstract void c();
  
  public abstract void c(boolean paramBoolean);
  
  public abstract boolean c();
  
  public abstract void d();
  
  public abstract boolean d();
  
  public abstract void e();
  
  public abstract boolean e();
  
  public abstract void f();
  
  public abstract boolean f();
  
  public abstract void g();
  
  public abstract void h();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.base.video.player.api.IPlayer
 * JD-Core Version:    0.7.0.1
 */