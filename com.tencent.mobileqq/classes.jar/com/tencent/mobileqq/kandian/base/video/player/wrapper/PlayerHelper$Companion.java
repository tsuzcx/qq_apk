package com.tencent.mobileqq.kandian.base.video.player.wrapper;

import com.tencent.mobileqq.kandian.base.video.player.wrapper.superplayer.SuperPlayerFactory;
import com.tencent.mobileqq.kandian.base.video.player.wrapper.superplayer.SuperPlayerSDKMgr;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/mobileqq/kandian/base/video/player/wrapper/PlayerHelper$Companion;", "", "()V", "TAG", "", "superPlayerFlag", "", "useSuperPlayer", "", "getUseSuperPlayer", "()Z", "selectPlayerFactory", "Lcom/tencent/mobileqq/kandian/base/video/player/wrapper/IPlayerFactory;", "selectPlayerSDKMgr", "Lcom/tencent/mobileqq/kandian/base/video/player/wrapper/IPlayerSDKMgr;", "kandian_feature_impl_release"}, k=1, mv={1, 1, 16})
public final class PlayerHelper$Companion
{
  public final boolean a()
  {
    return true;
  }
  
  @NotNull
  public final IPlayerFactory b()
  {
    return (IPlayerFactory)SuperPlayerFactory.a;
  }
  
  @NotNull
  public final IPlayerSDKMgr c()
  {
    return (IPlayerSDKMgr)SuperPlayerSDKMgr.a;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.base.video.player.wrapper.PlayerHelper.Companion
 * JD-Core Version:    0.7.0.1
 */