import com.tencent.biz.pubaccount.VideoInfo;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/biz/pubaccount/readinjoy/video/VideoFeedsReporter$Companion;", "", "()V", "TAG", "", "doAtClickReport", "", "videoInfo", "Lcom/tencent/biz/pubaccount/VideoInfo;", "doAtExposureReport", "doTopicClickReport", "topicId", "doTopicExposureReport", "AQQLiteApp_release"}, k=1, mv={1, 1, 16})
public final class slz
{
  public final void a(@NotNull VideoInfo paramVideoInfo)
  {
    Intrinsics.checkParameterIsNotNull(paramVideoInfo, "videoInfo");
    olh.a(null, "", "0X800B4DA", "0X800B4DA", 0, 0, "", "", "", new suu("", paramVideoInfo.j, paramVideoInfo.a, paramVideoInfo.g).i(paramVideoInfo.g).a().a(), false);
  }
  
  public final void a(@NotNull VideoInfo paramVideoInfo, @NotNull String paramString)
  {
    Intrinsics.checkParameterIsNotNull(paramVideoInfo, "videoInfo");
    Intrinsics.checkParameterIsNotNull(paramString, "topicId");
    olh.a(null, "", "0X800B2A4", "0X800B2A4", 0, 0, "3", "", "", new suu("", paramVideoInfo.j, paramVideoInfo.a, paramVideoInfo.g).i(paramVideoInfo.g).g(paramString).ad(1).a().a(), false);
  }
  
  public final void b(@NotNull VideoInfo paramVideoInfo)
  {
    Intrinsics.checkParameterIsNotNull(paramVideoInfo, "videoInfo");
    olh.a(null, "", "0X800B4DC", "0X800B4DC", 0, 0, "", "", "", new suu("", paramVideoInfo.j, paramVideoInfo.a, paramVideoInfo.g).i(paramVideoInfo.g).a().a(), false);
  }
  
  public final void b(@NotNull VideoInfo paramVideoInfo, @NotNull String paramString)
  {
    Intrinsics.checkParameterIsNotNull(paramVideoInfo, "videoInfo");
    Intrinsics.checkParameterIsNotNull(paramString, "topicId");
    olh.a(null, "", "0X800B2A3", "0X800B2A3", 0, 0, "3", "", "", new suu("", paramVideoInfo.j, paramVideoInfo.a, paramVideoInfo.g).i(paramVideoInfo.g).g(paramString).ad(1).a().a(), false);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     slz
 * JD-Core Version:    0.7.0.1
 */