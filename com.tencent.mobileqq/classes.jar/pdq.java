import kotlin.Metadata;
import kotlin.jvm.JvmStatic;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/biz/pubaccount/readinjoy/config/handlers/ViolaVideoFeedsConfigHandler$Companion;", "", "()V", "KEY_FROM_SOURCE", "", "TAG", "detectConfigInDebug", "", "isViolaVideoFeeds", "videoFromType", "", "AQQLiteApp_release"}, k=1, mv={1, 1, 16})
public final class pdq
{
  @JvmStatic
  public final boolean a(int paramInt)
  {
    if ("all".equals((String)bkwm.a("viola_video_feeds_config", ""))) {
      return true;
    }
    return bkwm.b(paramInt, "\\|", "viola_video_feeds_config");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     pdq
 * JD-Core Version:    0.7.0.1
 */