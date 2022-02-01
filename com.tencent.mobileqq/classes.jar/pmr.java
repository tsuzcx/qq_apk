import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.text.StringsKt;
import org.jetbrains.annotations.NotNull;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/biz/pubaccount/readinjoy/config/handlers/ViolaVideoFeedsConfigHandler$Companion;", "", "()V", "KEY_FROM_SOURCE", "", "KEY_VIDEO_FEEDS_VERSION", "NEW_STYLE_BID", "NEW_STYLE_BUNDLE_NAME", "OLD_STYLE_BID", "OLD_STYLE_BUNDLE_NAME", "TAG", "detectConfigInDebug", "", "getVideoFeedsDebugUrl", "getVideoFeedsReleaseUrl", "isNewVideoFeedsStyle", "isViolaVideoFeeds", "videoFromType", "", "AQQLiteApp_release"}, k=1, mv={1, 1, 16})
public final class pmr
{
  private final boolean a()
  {
    return "0".equals(bmhv.a("viola_video_feeds_version", "0"));
  }
  
  @JvmStatic
  @NotNull
  public final String a()
  {
    if (((pmr)this).a()) {
      return "https://viola.qq.com/js/VShortVideo.js?_rij_violaUrl=1&v_tid=15&v_bundleName=VShortVideo&hideNav=1&v_nav_immer=1&statusColor=1&v_bid=3811&statusBarStyle=1&_cache_bunle=1&v_bg_color=000000&v_content_full=1&statusColor=1&supportNV=1&supportColorBall=1&v_present_title_alpha=1&v_present_gray_float=1&v_present_top=123";
    }
    return StringsKt.replace$default(StringsKt.replace$default("https://viola.qq.com/js/VShortVideo.js?_rij_violaUrl=1&v_tid=15&v_bundleName=VShortVideo&hideNav=1&v_nav_immer=1&statusColor=1&v_bid=3811&statusBarStyle=1&_cache_bunle=1&v_bg_color=000000&v_content_full=1&statusColor=1&supportNV=1&supportColorBall=1&v_present_title_alpha=1&v_present_gray_float=1&v_present_top=123", "3811", "3192", false, 4, null), "VShortVideo", "OriginalVideoFeeds", false, 4, null);
  }
  
  @JvmStatic
  public final boolean a(int paramInt)
  {
    if ("all".equals((String)bmhv.a("viola_video_feeds_config", ""))) {
      return true;
    }
    return bmhv.b(paramInt, "\\|", "viola_video_feeds_config");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     pmr
 * JD-Core Version:    0.7.0.1
 */