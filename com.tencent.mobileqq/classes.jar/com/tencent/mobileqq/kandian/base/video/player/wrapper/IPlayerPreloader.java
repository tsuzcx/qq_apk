package com.tencent.mobileqq.kandian.base.video.player.wrapper;

import com.tencent.superplayer.api.SuperPlayerDownOption;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/mobileqq/kandian/base/video/player/wrapper/IPlayerPreloader;", "", "destory", "", "isVideoCached", "", "videoInfo", "Lcom/tencent/mobileqq/kandian/base/video/player/wrapper/PlayerVideoInfo;", "setPreDownloadListener", "listener", "Lcom/tencent/mobileqq/kandian/base/video/player/wrapper/IPlayerPreloader$Listener;", "startPreDownload", "videoDurationMs", "", "preloadDurationMs", "superPlayerDownOption", "Lcom/tencent/superplayer/api/SuperPlayerDownOption;", "stopPreDownload", "Companion", "Listener", "kandian_feature_impl_release"}, k=1, mv={1, 1, 16})
public abstract interface IPlayerPreloader
{
  public static final IPlayerPreloader.Companion a = IPlayerPreloader.Companion.a;
  
  public abstract int a(@NotNull PlayerVideoInfo paramPlayerVideoInfo);
  
  public abstract void a();
  
  public abstract void a(@Nullable IPlayerPreloader.Listener paramListener);
  
  public abstract void a(@NotNull PlayerVideoInfo paramPlayerVideoInfo, long paramLong1, long paramLong2, @NotNull SuperPlayerDownOption paramSuperPlayerDownOption);
  
  public abstract void b();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.base.video.player.wrapper.IPlayerPreloader
 * JD-Core Version:    0.7.0.1
 */