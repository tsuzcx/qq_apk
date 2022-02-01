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
import tencent.im.oidb.cmd0x68b.oidb_cmd0x68b.RspChannelArticle;
import tencent.im.oidb.cmd0x68b.oidb_cmd0x68b.RspGetFollowTabFeeds;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/biz/pubaccount/readinjoy/model/ArticleInfoModuleUtils$FollowChannelDataHandler;", "", "()V", "handleFollowedTopicData", "", "topicData", "Lcom/tencent/mobileqq/pb/PBUInt32Field;", "handleLastReadIndex", "lastReadIndex", "articleList", "", "Lcom/tencent/biz/pubaccount/readinjoy/struct/ArticleInfo;", "handleRefreshCookie", "cookie", "Lcom/tencent/mobileqq/pb/PBBytesField;", "handleTopicRedNumUpdate", "redNum", "handleTopicUpdateInfo", "needRefreshTopicInfo", "topicUpdateInfo", "Ltencent/im/oidb/articlesummary/articlesummary$TopicRecommendFeedsInfo;", "parseArticleList", "model", "Lcom/tencent/biz/pubaccount/readinjoy/model/ArticleInfoModule;", "rspChannel", "Ltencent/im/oidb/cmd0x68b/oidb_cmd0x68b$RspChannelArticle;", "pbData", "Lcom/tencent/mobileqq/pb/PBRepeatMessageField;", "Ltencent/im/oidb/cmd0x68b/oidb_cmd0x68b$RspGetFollowTabFeeds;", "AQQLiteApp_release"}, k=1, mv={1, 1, 16})
public final class qet
{
  public static final qet a = new qet();
  
  @Nullable
  public final List<ArticleInfo> a(@NotNull qep paramqep, @NotNull oidb_cmd0x68b.RspChannelArticle paramRspChannelArticle, @NotNull PBRepeatMessageField<oidb_cmd0x68b.RspGetFollowTabFeeds> paramPBRepeatMessageField)
  {
    Intrinsics.checkParameterIsNotNull(paramqep, "model");
    Intrinsics.checkParameterIsNotNull(paramRspChannelArticle, "rspChannel");
    Intrinsics.checkParameterIsNotNull(paramPBRepeatMessageField, "pbData");
    List localList = (List)null;
    if (!paramPBRepeatMessageField.has()) {
      paramqep = localList;
    }
    do
    {
      return paramqep;
      paramRspChannelArticle = (List)qxm.a(paramRspChannelArticle, paramPBRepeatMessageField.get());
      paramqep.a().a(paramRspChannelArticle, 70);
      paramqep = paramRspChannelArticle;
    } while (!pju.a());
    pju.a().a(70, paramPBRepeatMessageField.get(), paramRspChannelArticle);
    return paramRspChannelArticle;
  }
  
  public final void a(@NotNull PBBytesField paramPBBytesField)
  {
    Intrinsics.checkParameterIsNotNull(paramPBBytesField, "cookie");
    if ((paramPBBytesField.has()) && (paramPBBytesField.get() != null))
    {
      paramPBBytesField = bhcu.encodeToString(qxl.a(paramPBBytesField), 0);
      pvj.a().f(paramPBBytesField);
      QLog.d("ArticleInfoModule", 2, "getFollowTabData : lastRefreshCookie " + paramPBBytesField);
    }
  }
  
  public final void a(@NotNull PBUInt32Field paramPBUInt32Field)
  {
    boolean bool = true;
    Intrinsics.checkParameterIsNotNull(paramPBUInt32Field, "topicData");
    pvj localpvj;
    if (paramPBUInt32Field.has())
    {
      localpvj = pvj.a();
      if (paramPBUInt32Field.get() != 1) {
        break label33;
      }
    }
    for (;;)
    {
      localpvj.d(bool);
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
    if (qxl.a(paramPBUInt32Field, 0) == 1) {}
    for (;;)
    {
      if (i != 0)
      {
        if ((!paramTopicRecommendFeedsInfo.has()) || (paramTopicRecommendFeedsInfo.get() == null)) {
          break;
        }
        paramPBUInt32Field = paramTopicRecommendFeedsInfo.get();
        Intrinsics.checkExpressionValueIsNotNull(paramPBUInt32Field, "topicUpdateInfo.get()");
        paramPBUInt32Field = rsh.a((articlesummary.TopicRecommendFeedsInfo)paramPBUInt32Field);
        pvj.a().a(paramPBUInt32Field);
      }
      return;
      i = 0;
    }
    pvj.a().a(null);
  }
  
  public final void b(@NotNull PBUInt32Field paramPBUInt32Field)
  {
    Intrinsics.checkParameterIsNotNull(paramPBUInt32Field, "redNum");
    if (paramPBUInt32Field.has()) {
      pvj.a().f(paramPBUInt32Field.get());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     qet
 * JD-Core Version:    0.7.0.1
 */