import com.tencent.aladdin.config.Aladdin;
import com.tencent.aladdin.config.AladdinConfig;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/biz/pubaccount/readinjoy/ugc/config/RIJVideoPublishConfig;", "", "()V", "UGC_VIDEO_PUBLISH_ENABLE_ADD_ADDRESS", "", "UGC_VIDEO_PUBLISH_ENABLE_AT_PERSON", "UGC_VIDEO_PUBLISH_ENABLE_TOPIC_IN_TITLE", "UGC_VIDEO_PUBLISH_REPRODUCE_DEFAULT", "UGC_VIDEO_PUBLISH_SHOW_REPRODUCE", "enablePublishVideoWithAddAddress", "", "enablePublishVideoWithAtPerson", "enablePublishVideoWithTopicInTitle", "getPublishVideoConfig", "Lcom/tencent/aladdin/config/AladdinConfig;", "getPublishVideoReproduceDefault", "getPublishVideoReproduceVisibility", "", "AQQLiteApp_release"}, k=1, mv={1, 1, 16})
public final class rwg
{
  public static final rwg a = new rwg();
  
  @JvmStatic
  public static final int a()
  {
    if (a.a().getIntegerFromString("ugc_video_publish_show_reproduce", 0) == 1) {
      return 0;
    }
    return 8;
  }
  
  private final AladdinConfig a()
  {
    AladdinConfig localAladdinConfig = Aladdin.getConfig(281);
    Intrinsics.checkExpressionValueIsNotNull(localAladdinConfig, "Aladdin.getConfig(QQAlad…CONFIG_UGC_PUBLISH_VIDEO)");
    return localAladdinConfig;
  }
  
  @JvmStatic
  public static final boolean a()
  {
    return a.a().getIntegerFromString("ugc_video_publish_reproduce_default", 1) != 0;
  }
  
  @JvmStatic
  public static final boolean b()
  {
    boolean bool = false;
    if (a.a().getIntegerFromString("ugc_video_publish_show_topic", 0) != 0) {
      bool = true;
    }
    return bool;
  }
  
  @JvmStatic
  public static final boolean c()
  {
    return a.a().getIntegerFromString("ugc_video_publish_show_at", 1) != 0;
  }
  
  @JvmStatic
  public static final boolean d()
  {
    return a.a().getIntegerFromString("ugc_video_publish_show_location", 1) != 0;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     rwg
 * JD-Core Version:    0.7.0.1
 */