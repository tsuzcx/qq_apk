import com.tencent.biz.pubaccount.readinjoy.struct.ArticleInfo;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.qphone.base.util.QLog;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tencent.im.oidb.articlesummary.articlesummary.TopicRecommendFeedsInfo;
import tencent.im.oidb.cmd0x68b.oidb_cmd0x68b.RspGetFollowTabFeeds;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/biz/pubaccount/readinjoy/model/AritcleInfoModuleUtils$FollowChannelDataHandler;", "", "()V", "handleFollowedTopicData", "", "topicData", "Lcom/tencent/mobileqq/pb/PBUInt32Field;", "handleLastReadIndex", "lastReadIndex", "articleList", "", "Lcom/tencent/biz/pubaccount/readinjoy/struct/ArticleInfo;", "handleRefreshCookie", "cookie", "Lcom/tencent/mobileqq/pb/PBBytesField;", "handleTopicRedNumUpdate", "redNum", "handleTopicUpdateInfo", "needRefreshTopicInfo", "topicUpdateInfo", "Ltencent/im/oidb/articlesummary/articlesummary$TopicRecommendFeedsInfo;", "parseArticleList", "model", "Lcom/tencent/biz/pubaccount/readinjoy/model/ArticleInfoModule;", "pbData", "Lcom/tencent/mobileqq/pb/PBRepeatMessageField;", "Ltencent/im/oidb/cmd0x68b/oidb_cmd0x68b$RspGetFollowTabFeeds;", "AQQLiteApp_release"}, k=1, mv={1, 1, 16})
public final class pwa
{
  public static final pwa a = new pwa();
  
  @Nullable
  public final List<ArticleInfo> a(@NotNull pwb parampwb, @NotNull PBRepeatMessageField<oidb_cmd0x68b.RspGetFollowTabFeeds> paramPBRepeatMessageField)
  {
    Intrinsics.checkParameterIsNotNull(parampwb, "model");
    Intrinsics.checkParameterIsNotNull(paramPBRepeatMessageField, "pbData");
    List localList = (List)null;
    if (!paramPBRepeatMessageField.has()) {
      parampwb = localList;
    }
    do
    {
      return parampwb;
      localList = (List)qnc.a(paramPBRepeatMessageField.get());
      parampwb.a(localList, 70);
      parampwb = localList;
    } while (!pgn.a());
    pgn.a().a(70, paramPBRepeatMessageField.get(), localList);
    return localList;
  }
  
  public final void a(@NotNull PBBytesField paramPBBytesField)
  {
    Intrinsics.checkParameterIsNotNull(paramPBBytesField, "cookie");
    if ((paramPBBytesField.has()) && (paramPBBytesField.get() != null))
    {
      paramPBBytesField = bgku.encodeToString(qnb.a(paramPBBytesField), 0);
      pmh.a().f(paramPBBytesField);
      QLog.d("ArticleInfoModule", 2, "getFollowTabData : lastRefreshCookie " + paramPBBytesField);
    }
  }
  
  public final void a(@NotNull PBUInt32Field paramPBUInt32Field)
  {
    boolean bool = true;
    Intrinsics.checkParameterIsNotNull(paramPBUInt32Field, "topicData");
    pmh localpmh;
    if (paramPBUInt32Field.has())
    {
      localpmh = pmh.a();
      if (paramPBUInt32Field.get() != 1) {
        break label33;
      }
    }
    for (;;)
    {
      localpmh.d(bool);
      return;
      label33:
      bool = false;
    }
  }
  
  public final void a(@NotNull PBUInt32Field paramPBUInt32Field, @Nullable List<? extends ArticleInfo> paramList)
  {
    Intrinsics.checkParameterIsNotNull(paramPBUInt32Field, "lastReadIndex");
    if (paramList == null) {}
    while (!paramPBUInt32Field.has()) {
      return;
    }
    int i = paramPBUInt32Field.get() - 1;
    if ((i > 0) && (i < paramList.size())) {
      ((ArticleInfo)paramList.get(i)).hintFlag = true;
    }
    QLog.d("ArticleInfoModule", 2, "getFollowTabData : hint " + i);
  }
  
  public final void a(@NotNull PBUInt32Field paramPBUInt32Field, @NotNull articlesummary.TopicRecommendFeedsInfo paramTopicRecommendFeedsInfo)
  {
    int i = 1;
    Intrinsics.checkParameterIsNotNull(paramPBUInt32Field, "needRefreshTopicInfo");
    Intrinsics.checkParameterIsNotNull(paramTopicRecommendFeedsInfo, "topicUpdateInfo");
    if (qnb.a(paramPBUInt32Field, 0) == 1) {}
    for (;;)
    {
      if (i != 0)
      {
        if ((!paramTopicRecommendFeedsInfo.has()) || (paramTopicRecommendFeedsInfo.get() == null)) {
          break;
        }
        paramPBUInt32Field = paramTopicRecommendFeedsInfo.get();
        Intrinsics.checkExpressionValueIsNotNull(paramPBUInt32Field, "topicUpdateInfo.get()");
        paramPBUInt32Field = rii.a((articlesummary.TopicRecommendFeedsInfo)paramPBUInt32Field);
        pmh.a().a(paramPBUInt32Field);
      }
      return;
      i = 0;
    }
    pmh.a().a(null);
  }
  
  public final void b(@NotNull PBUInt32Field paramPBUInt32Field)
  {
    Intrinsics.checkParameterIsNotNull(paramPBUInt32Field, "redNum");
    if (paramPBUInt32Field.has()) {
      pmh.a().f(paramPBUInt32Field.get());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     pwa
 * JD-Core Version:    0.7.0.1
 */