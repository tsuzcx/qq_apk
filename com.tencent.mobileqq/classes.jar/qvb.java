import com.tencent.biz.pubaccount.readinjoy.struct.BaseArticleInfo;
import com.tencent.biz.pubaccount.readinjoy.struct.SocializeFeedsInfo;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/biz/pubaccount/readinjoy/srtUtils/longcontentinfoupdater/LongContentInfoUpdater$Companion;", "", "()V", "mapping", "", "", "Lcom/tencent/biz/pubaccount/readinjoy/srtUtils/longcontentinfoupdater/LongContentInfoUpdater;", "getUpdater", "articleInfo", "Lcom/tencent/biz/pubaccount/readinjoy/struct/BaseArticleInfo;", "AQQLiteApp_release"}, k=1, mv={1, 1, 16})
public final class qvb
{
  @JvmStatic
  @Nullable
  public final qva a(@NotNull BaseArticleInfo paramBaseArticleInfo)
  {
    Intrinsics.checkParameterIsNotNull(paramBaseArticleInfo, "articleInfo");
    Map localMap = qva.a();
    paramBaseArticleInfo = paramBaseArticleInfo.mSocialFeedInfo;
    if (paramBaseArticleInfo != null)
    {
      paramBaseArticleInfo = paramBaseArticleInfo.a;
      if (paramBaseArticleInfo == null) {}
    }
    for (paramBaseArticleInfo = Integer.valueOf(paramBaseArticleInfo.a);; paramBaseArticleInfo = null) {
      return (qva)localMap.get(paramBaseArticleInfo);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     qvb
 * JD-Core Version:    0.7.0.1
 */