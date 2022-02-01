import com.tencent.biz.pubaccount.VideoInfo;
import com.tencent.biz.pubaccount.VideoInfo.RichTitleInfo;
import java.util.ArrayList;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/biz/pubaccount/readinjoy/video/VideoFeedsReporter;", "", "()V", "doRichTitleExposureReport", "", "videoInfo", "Lcom/tencent/biz/pubaccount/VideoInfo;", "doTopicClickReport", "topicId", "", "doTopicExposureReport", "AQQLiteApp_release"}, k=1, mv={1, 1, 16})
public final class rsq
{
  public static final rsq a = new rsq();
  
  public final void a(@NotNull VideoInfo paramVideoInfo)
  {
    Intrinsics.checkParameterIsNotNull(paramVideoInfo, "videoInfo");
    if ((paramVideoInfo.d != null) && (paramVideoInfo.d.size() > 0))
    {
      Iterator localIterator = paramVideoInfo.d.iterator();
      label111:
      while (localIterator.hasNext())
      {
        Object localObject = (VideoInfo.RichTitleInfo)localIterator.next();
        String str = ((VideoInfo.RichTitleInfo)localObject).b;
        Intrinsics.checkExpressionValueIsNotNull(str, "info.topicId");
        if (((CharSequence)str).length() > 0) {}
        for (int i = 1;; i = 0)
        {
          if (i == 0) {
            break label111;
          }
          localObject = ((VideoInfo.RichTitleInfo)localObject).b;
          Intrinsics.checkExpressionValueIsNotNull(localObject, "info.topicId");
          a(paramVideoInfo, (String)localObject);
          break;
        }
      }
    }
  }
  
  public final void a(@NotNull VideoInfo paramVideoInfo, @NotNull String paramString)
  {
    Intrinsics.checkParameterIsNotNull(paramVideoInfo, "videoInfo");
    Intrinsics.checkParameterIsNotNull(paramString, "topicId");
    ocd.a(null, "", "0X800B2A3", "0X800B2A3", 0, 0, "3", "", "", new sbg("", paramVideoInfo.j, paramVideoInfo.a, paramVideoInfo.g).i(paramVideoInfo.g).g(paramString).ac(1).a().a(), false);
  }
  
  public final void b(@NotNull VideoInfo paramVideoInfo, @NotNull String paramString)
  {
    Intrinsics.checkParameterIsNotNull(paramVideoInfo, "videoInfo");
    Intrinsics.checkParameterIsNotNull(paramString, "topicId");
    ocd.a(null, "", "0X800B2A4", "0X800B2A4", 0, 0, "3", "", "", new sbg("", paramVideoInfo.j, paramVideoInfo.a, paramVideoInfo.g).i(paramVideoInfo.g).g(paramString).ac(1).a().a(), false);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     rsq
 * JD-Core Version:    0.7.0.1
 */