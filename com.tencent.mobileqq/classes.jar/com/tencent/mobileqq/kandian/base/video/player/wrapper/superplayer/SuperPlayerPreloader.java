package com.tencent.mobileqq.kandian.base.video.player.wrapper.superplayer;

import com.tencent.mobileqq.kandian.base.video.player.wrapper.IPlayerPreloader;
import com.tencent.mobileqq.kandian.base.video.player.wrapper.IPlayerPreloader.Listener;
import com.tencent.mobileqq.kandian.base.video.player.wrapper.PlayerVideoInfo;
import com.tencent.mobileqq.kandian.base.video.player.wrapper.PlayerVideoInfoKtKt;
import com.tencent.superplayer.api.ISPlayerPreDownloader;
import com.tencent.superplayer.api.ISPlayerPreDownloader.Listener;
import com.tencent.superplayer.api.SuperPlayerDownOption;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/mobileqq/kandian/base/video/player/wrapper/superplayer/SuperPlayerPreloader;", "Lcom/tencent/mobileqq/kandian/base/video/player/wrapper/IPlayerPreloader;", "Lcom/tencent/superplayer/api/ISPlayerPreDownloader$Listener;", "preloader", "Lcom/tencent/superplayer/api/ISPlayerPreDownloader;", "(Lcom/tencent/superplayer/api/ISPlayerPreDownloader;)V", "listener", "Lcom/tencent/mobileqq/kandian/base/video/player/wrapper/IPlayerPreloader$Listener;", "destory", "", "isVideoCached", "", "videoInfo", "Lcom/tencent/mobileqq/kandian/base/video/player/wrapper/PlayerVideoInfo;", "onPrepareDownloadProgressUpdate", "p0", "p1", "p2", "p3", "", "p4", "onPrepareError", "onPrepareSuccess", "setPreDownloadListener", "startPreDownload", "videoDurationMs", "preloadDurationMs", "superPlayerDownOption", "Lcom/tencent/superplayer/api/SuperPlayerDownOption;", "stopPreDownload", "kandian_feature_impl_release"}, k=1, mv={1, 1, 16})
public final class SuperPlayerPreloader
  implements IPlayerPreloader, ISPlayerPreDownloader.Listener
{
  private IPlayerPreloader.Listener jdField_a_of_type_ComTencentMobileqqKandianBaseVideoPlayerWrapperIPlayerPreloader$Listener;
  private final ISPlayerPreDownloader jdField_a_of_type_ComTencentSuperplayerApiISPlayerPreDownloader;
  
  public SuperPlayerPreloader(@Nullable ISPlayerPreDownloader paramISPlayerPreDownloader)
  {
    this.jdField_a_of_type_ComTencentSuperplayerApiISPlayerPreDownloader = paramISPlayerPreDownloader;
  }
  
  public int a(@NotNull PlayerVideoInfo paramPlayerVideoInfo)
  {
    Intrinsics.checkParameterIsNotNull(paramPlayerVideoInfo, "videoInfo");
    return 0;
  }
  
  public void a()
  {
    ISPlayerPreDownloader localISPlayerPreDownloader = this.jdField_a_of_type_ComTencentSuperplayerApiISPlayerPreDownloader;
    if (localISPlayerPreDownloader != null) {
      localISPlayerPreDownloader.stopAllPreDownload();
    }
  }
  
  public void a(@Nullable IPlayerPreloader.Listener paramListener)
  {
    this.jdField_a_of_type_ComTencentMobileqqKandianBaseVideoPlayerWrapperIPlayerPreloader$Listener = paramListener;
    paramListener = this.jdField_a_of_type_ComTencentSuperplayerApiISPlayerPreDownloader;
    if (paramListener != null) {
      paramListener.setOnPreDownloadListener((ISPlayerPreDownloader.Listener)this);
    }
  }
  
  public void a(@NotNull PlayerVideoInfo paramPlayerVideoInfo, long paramLong1, long paramLong2, @NotNull SuperPlayerDownOption paramSuperPlayerDownOption)
  {
    Intrinsics.checkParameterIsNotNull(paramPlayerVideoInfo, "videoInfo");
    Intrinsics.checkParameterIsNotNull(paramSuperPlayerDownOption, "superPlayerDownOption");
    ISPlayerPreDownloader localISPlayerPreDownloader = this.jdField_a_of_type_ComTencentSuperplayerApiISPlayerPreDownloader;
    if (localISPlayerPreDownloader != null) {
      localISPlayerPreDownloader.startPreDownload(PlayerVideoInfoKtKt.a(paramPlayerVideoInfo), paramLong1, paramLong2, paramSuperPlayerDownOption);
    }
  }
  
  public void b()
  {
    ISPlayerPreDownloader localISPlayerPreDownloader = this.jdField_a_of_type_ComTencentSuperplayerApiISPlayerPreDownloader;
    if (localISPlayerPreDownloader != null) {
      localISPlayerPreDownloader.destory();
    }
  }
  
  public void onPrepareDownloadProgressUpdate(int paramInt1, int paramInt2, int paramInt3, long paramLong1, long paramLong2) {}
  
  public void onPrepareError(int paramInt)
  {
    IPlayerPreloader.Listener localListener = this.jdField_a_of_type_ComTencentMobileqqKandianBaseVideoPlayerWrapperIPlayerPreloader$Listener;
    if (localListener != null) {
      localListener.b();
    }
  }
  
  public void onPrepareSuccess(int paramInt)
  {
    IPlayerPreloader.Listener localListener = this.jdField_a_of_type_ComTencentMobileqqKandianBaseVideoPlayerWrapperIPlayerPreloader$Listener;
    if (localListener != null) {
      localListener.a();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.base.video.player.wrapper.superplayer.SuperPlayerPreloader
 * JD-Core Version:    0.7.0.1
 */