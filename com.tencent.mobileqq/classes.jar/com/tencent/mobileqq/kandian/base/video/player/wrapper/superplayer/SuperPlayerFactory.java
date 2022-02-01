package com.tencent.mobileqq.kandian.base.video.player.wrapper.superplayer;

import android.content.Context;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.kandian.base.video.player.api.IPlayer;
import com.tencent.mobileqq.kandian.base.video.player.api.IVideoView;
import com.tencent.mobileqq.kandian.base.video.player.wrapper.IPlayerFactory;
import com.tencent.mobileqq.kandian.base.video.player.wrapper.IPlayerPreloader;
import com.tencent.mobileqq.qqvideoplatform.api.QQVideoPlaySDKManager;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/mobileqq/kandian/base/video/player/wrapper/superplayer/SuperPlayerFactory;", "Lcom/tencent/mobileqq/kandian/base/video/player/wrapper/IPlayerFactory;", "()V", "createMediaPlayer", "Lcom/tencent/mobileqq/kandian/base/video/player/api/IPlayer;", "videoView", "Lcom/tencent/mobileqq/kandian/base/video/player/api/IVideoView;", "createPlayerVideoView", "context", "Landroid/content/Context;", "isUseTextureView", "", "createPreloader", "Lcom/tencent/mobileqq/kandian/base/video/player/wrapper/IPlayerPreloader;", "obtainMediaPlayer", "token", "", "kandian_feature_impl_release"}, k=1, mv={1, 1, 16})
public final class SuperPlayerFactory
  implements IPlayerFactory
{
  public static final SuperPlayerFactory a = new SuperPlayerFactory();
  
  @NotNull
  public IPlayer a(@Nullable IVideoView paramIVideoView)
  {
    if (QQVideoPlaySDKManager.a()) {
      return (IPlayer)new SuperPlayer(com.tencent.superplayer.api.SuperPlayerFactory.createMediaPlayer((Context)BaseApplicationImpl.getContext(), 104, null));
    }
    return (IPlayer)new SuperPlayer(null);
  }
  
  @Nullable
  public IPlayer a(@NotNull String paramString)
  {
    Intrinsics.checkParameterIsNotNull(paramString, "token");
    paramString = com.tencent.superplayer.api.SuperPlayerFactory.obtainMediaPlayer(paramString);
    if (paramString != null) {
      return (IPlayer)new SuperPlayer(paramString);
    }
    return null;
  }
  
  @NotNull
  public IVideoView a(@NotNull Context paramContext, boolean paramBoolean)
  {
    Intrinsics.checkParameterIsNotNull(paramContext, "context");
    if (QQVideoPlaySDKManager.a()) {
      return (IVideoView)new SuperPlayerVideoView(com.tencent.superplayer.api.SuperPlayerFactory.createPlayerVideoView(paramContext));
    }
    return (IVideoView)new SuperPlayerVideoView(null);
  }
  
  @NotNull
  public IPlayerPreloader a()
  {
    if (QQVideoPlaySDKManager.a()) {
      return (IPlayerPreloader)new SuperPlayerPreloader(com.tencent.superplayer.api.SuperPlayerFactory.createPreDownloader((Context)BaseApplicationImpl.getContext(), 104));
    }
    return (IPlayerPreloader)new SuperPlayerPreloader(null);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.base.video.player.wrapper.superplayer.SuperPlayerFactory
 * JD-Core Version:    0.7.0.1
 */