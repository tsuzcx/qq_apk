package com.tencent.mobileqq.kandian.biz.video;

import com.tencent.mobileqq.kandian.base.video.player.api.IVideoPlayerWrapper;
import com.tencent.superplayer.seamless.SPSeamlessHelper.SeamlessCallback;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"com/tencent/mobileqq/kandian/biz/video/VideoColumnBannerManager$jumpToColumnPlay$1$1", "Lcom/tencent/superplayer/seamless/SPSeamlessHelper$SeamlessCallback;", "onSeamlessExitEnd", "", "enterToken", "", "exitToken", "map", "", "", "onSeamlessJump", "s", "kandian_feature_impl_release"}, k=1, mv={1, 1, 16})
public final class VideoColumnBannerManager$jumpToColumnPlay$1$1
  implements SPSeamlessHelper.SeamlessCallback
{
  VideoColumnBannerManager$jumpToColumnPlay$1$1(IVideoPlayerWrapper paramIVideoPlayerWrapper) {}
  
  public void onSeamlessExitEnd(@NotNull String paramString1, @NotNull String paramString2, @NotNull Map<String, ? extends Object> paramMap)
  {
    Intrinsics.checkParameterIsNotNull(paramString1, "enterToken");
    Intrinsics.checkParameterIsNotNull(paramString2, "exitToken");
    Intrinsics.checkParameterIsNotNull(paramMap, "map");
    paramString2 = this.a;
    if (paramString2 != null) {
      paramString2.c(paramString1);
    }
  }
  
  public void onSeamlessJump(@NotNull String paramString)
  {
    Intrinsics.checkParameterIsNotNull(paramString, "s");
    paramString = this.a;
    if (paramString != null) {
      paramString.W();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.video.VideoColumnBannerManager.jumpToColumnPlay.1.1
 * JD-Core Version:    0.7.0.1
 */