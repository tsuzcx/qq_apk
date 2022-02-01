package com.tencent.mobileqq.kandian.glue.msf.api;

import com.tencent.mobileqq.kandian.biz.ad.IRIJAdvertisementRequestProxy;
import com.tencent.mobileqq.kandian.repo.account.api.IUserOperationModule;
import com.tencent.mobileqq.kandian.repo.dislike.DislikeParam;
import com.tencent.mobileqq.kandian.repo.feeds.entity.AbsBaseArticleInfo;
import com.tencent.mobileqq.kandian.repo.handler.BiuInfo;
import com.tencent.mobileqq.kandian.repo.report.ReportInfo;
import com.tencent.mobileqq.persistence.EntityManagerFactory;
import java.util.List;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/mobileqq/kandian/glue/msf/api/IReadInJoyLogicEngine;", "", "deleteChannelArticle", "", "channelID", "", "articleInfo", "Lcom/tencent/mobileqq/kandian/repo/feeds/entity/AbsBaseArticleInfo;", "getAdvertisementInfoModule", "getAdvertisementRequestProxy", "Lcom/tencent/mobileqq/kandian/biz/ad/IRIJAdvertisementRequestProxy;", "getArticleInfo", "articleSeq", "", "getArticleInfoList", "", "channelId", "getCommentInfoModule", "getEntityManagerFactory", "Lcom/tencent/mobileqq/persistence/EntityManagerFactory;", "getKingMomentInfo", "url", "", "uin", "getReadInJoyUserInfoModule", "getUserOperationModule", "Lcom/tencent/mobileqq/kandian/repo/account/api/IUserOperationModule;", "loadAllChannelListFromCache", "refreshChannelAdvertisementFormServer", "adPosType", "adPosStart", "adPosEnd", "adRequestData", "refreshChannelListFromServer", "source", "important", "refreshRecommendAnMyCoverListFromServer", "refreshSubscriptionFeedList", "requestIndividualArticlesFormServer", "requestMultiBiu", "feedID", "biuInfo", "Lcom/tencent/mobileqq/kandian/repo/handler/BiuInfo;", "masterUin", "comments", "articleId", "src", "innerUniqueID", "feedsType", "requestUpdateSocialFeedInfo", "feedsid", "feedstype", "sendShieldArticle", "dislikeParam", "Lcom/tencent/mobileqq/kandian/repo/dislike/DislikeParam;", "dislikeParams", "setRecommendTopicFollowType", "", "topicId", "followType", "setSmallVideodTopicFollowType", "updateArticleFollowStatusByAccount", "publishUin", "followStatus", "isFromWeb", "updateArticleReadInfo", "articleID", "lastReadTime", "updateFollowingStatus", "userOperationReport", "list", "Lcom/tencent/mobileqq/kandian/repo/report/ReportInfo;", "kandian-api_release"}, k=1, mv={1, 1, 16})
public abstract interface IReadInJoyLogicEngine
{
  @NotNull
  public abstract IRIJAdvertisementRequestProxy a();
  
  @Nullable
  public abstract IUserOperationModule a();
  
  @Nullable
  public abstract AbsBaseArticleInfo a(int paramInt, long paramLong);
  
  @Nullable
  public abstract EntityManagerFactory a();
  
  @Nullable
  public abstract Object a();
  
  public abstract void a(int paramInt1, int paramInt2);
  
  public abstract void a(int paramInt1, int paramInt2, int paramInt3, int paramInt4, @Nullable Object paramObject);
  
  public abstract void a(int paramInt, @Nullable AbsBaseArticleInfo paramAbsBaseArticleInfo);
  
  public abstract void a(long paramLong);
  
  public abstract void a(long paramLong, int paramInt, boolean paramBoolean);
  
  public abstract void a(long paramLong1, long paramLong2);
  
  public abstract void a(long paramLong1, long paramLong2, @Nullable BiuInfo paramBiuInfo, long paramLong3, @Nullable String paramString1, long paramLong4, long paramLong5, int paramInt1, @Nullable String paramString2, int paramInt2, @Nullable AbsBaseArticleInfo paramAbsBaseArticleInfo);
  
  public abstract void a(long paramLong, @Nullable DislikeParam paramDislikeParam);
  
  public abstract void a(@Nullable String paramString, int paramInt);
  
  public abstract void a(@Nullable String paramString1, @Nullable String paramString2);
  
  public abstract void a(@Nullable List<? extends ReportInfo> paramList);
  
  public abstract boolean a(int paramInt1, int paramInt2);
  
  public abstract int b();
  
  @Nullable
  public abstract Object b();
  
  public abstract void b(long paramLong, int paramInt);
  
  @Nullable
  public abstract Object c();
  
  public abstract void c(long paramLong, int paramInt);
  
  public abstract void d(int paramInt1, int paramInt2);
  
  public abstract void e();
  
  public abstract void l();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.glue.msf.api.IReadInJoyLogicEngine
 * JD-Core Version:    0.7.0.1
 */