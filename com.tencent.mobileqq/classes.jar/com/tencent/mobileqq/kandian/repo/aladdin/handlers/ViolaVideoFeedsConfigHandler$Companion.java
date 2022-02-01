package com.tencent.mobileqq.kandian.repo.aladdin.handlers;

import com.tencent.mobileqq.kandian.base.utils.RIJSPUtils;
import com.tencent.mobileqq.kandian.repo.aladdin.sp.RIJMultiVideoConfigSp;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.text.StringsKt;
import org.jetbrains.annotations.NotNull;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/mobileqq/kandian/repo/aladdin/handlers/ViolaVideoFeedsConfigHandler$Companion;", "", "()V", "KEY_FROM_SOURCE", "", "KEY_VIDEO_FEEDS_VERSION", "KEY_VIDEO_IGNORE_NATIVE", "NEW_STYLE_BID", "NEW_STYLE_BUNDLE_NAME", "NEW_STYLE_HOST_NAME", "OLD_STYLE_BID", "OLD_STYLE_BUNDLE_NAME", "OLD_STYLE_HOST_NAME", "TAG", "detectConfigInDebug", "", "getVideoFeedsDebugUrl", "getVideoFeedsReleaseUrl", "isNewVideoFeedsStyle", "isViolaVideoFeeds", "videoFromType", "", "notIgnoreNative", "kandian_feature_impl_release"}, k=1, mv={1, 1, 16})
public final class ViolaVideoFeedsConfigHandler$Companion
{
  private final boolean c()
  {
    return "0".equals(RIJSPUtils.b("viola_video_feeds_version", "0"));
  }
  
  @JvmStatic
  public final boolean a()
  {
    return "1".equals(RIJSPUtils.b("viola_video_ingore_native", "0")) ^ true;
  }
  
  @JvmStatic
  public final boolean a(int paramInt)
  {
    if ("all".equals((String)RIJSPUtils.b("viola_video_feeds_config", ""))) {
      return true;
    }
    return RIJMultiVideoConfigSp.b(paramInt, "\\|", "viola_video_feeds_config");
  }
  
  @JvmStatic
  @NotNull
  public final String b()
  {
    if (((Companion)this).c()) {
      return "https://viola.qq.com/js/VShortVideo.js?_rij_violaUrl=1&v_tid=15&v_bundleName=VShortVideo&hideNav=1&v_nav_immer=1&statusColor=1&v_bid=3811&statusBarStyle=1&_cache_bunle=1&v_bg_color=000000&v_content_full=1&statusColor=1&supportNV=1&supportColorBall=1&v_present_title_alpha=1&v_present_gray_float=1&v_present_top=123&cycle_loading=1";
    }
    return StringsKt.replace$default(StringsKt.replace$default(StringsKt.replace$default("https://viola.qq.com/js/VShortVideo.js?_rij_violaUrl=1&v_tid=15&v_bundleName=VShortVideo&hideNav=1&v_nav_immer=1&statusColor=1&v_bid=3811&statusBarStyle=1&_cache_bunle=1&v_bg_color=000000&v_content_full=1&statusColor=1&supportNV=1&supportColorBall=1&v_present_title_alpha=1&v_present_gray_float=1&v_present_top=123&cycle_loading=1", "3811", "3192", false, 4, null), "VShortVideo", "OriginalVideoFeeds", false, 4, null), "viola.qq.com", "sqimg.qq.com", false, 4, null);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.repo.aladdin.handlers.ViolaVideoFeedsConfigHandler.Companion
 * JD-Core Version:    0.7.0.1
 */