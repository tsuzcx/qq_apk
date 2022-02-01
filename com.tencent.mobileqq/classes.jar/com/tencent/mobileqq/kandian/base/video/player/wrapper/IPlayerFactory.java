package com.tencent.mobileqq.kandian.base.video.player.wrapper;

import android.content.Context;
import com.tencent.mobileqq.kandian.base.video.player.api.IPlayer;
import com.tencent.mobileqq.kandian.base.video.player.api.IVideoView;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/mobileqq/kandian/base/video/player/wrapper/IPlayerFactory;", "", "createMediaPlayer", "Lcom/tencent/mobileqq/kandian/base/video/player/api/IPlayer;", "videoView", "Lcom/tencent/mobileqq/kandian/base/video/player/api/IVideoView;", "createPlayerVideoView", "context", "Landroid/content/Context;", "isUseTextureView", "", "createPreloader", "Lcom/tencent/mobileqq/kandian/base/video/player/wrapper/IPlayerPreloader;", "obtainMediaPlayer", "token", "", "kandian_feature_impl_release"}, k=1, mv={1, 1, 16})
public abstract interface IPlayerFactory
{
  @NotNull
  public abstract IPlayer a(@Nullable IVideoView paramIVideoView);
  
  @Nullable
  public abstract IPlayer a(@NotNull String paramString);
  
  @NotNull
  public abstract IVideoView a(@NotNull Context paramContext, boolean paramBoolean);
  
  @NotNull
  public abstract IPlayerPreloader a();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.base.video.player.wrapper.IPlayerFactory
 * JD-Core Version:    0.7.0.1
 */