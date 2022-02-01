package com.tencent.mobileqq.kandian.repo.feeds;

import com.tencent.mobileqq.kandian.base.utils.RIJPBFieldUtils;
import com.tencent.mobileqq.kandian.glue.businesshandler.engine.ReadInJoyLogicEngine;
import com.tencent.mobileqq.kandian.glue.msf.ReadInJoyMSFHandlerUtils;
import com.tencent.mobileqq.kandian.repo.feeds.entity.AbsBaseArticleInfo;
import com.tencent.mobileqq.kandian.repo.feeds.entity.TopicRecommendFeedsInfo;
import com.tencent.mobileqq.kandian.repo.feeds.pts.ReadInJoyProteusFamilyUtil;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.utils.Base64Util;
import com.tencent.qphone.base.util.QLog;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tencent.im.oidb.articlesummary.articlesummary.TopicRecommendFeedsInfo;
import tencent.im.oidb.cmd0x68b.oidb_cmd0x68b.RspChannelArticle;
import tencent.im.oidb.cmd0x68b.oidb_cmd0x68b.RspGetFollowTabFeeds;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/mobileqq/kandian/repo/feeds/ArticleInfoModuleUtils$FollowChannelDataHandler;", "", "()V", "handleFollowedTopicData", "", "topicData", "Lcom/tencent/mobileqq/pb/PBUInt32Field;", "handleLastReadIndex", "lastReadIndex", "articleList", "", "Lcom/tencent/mobileqq/kandian/repo/feeds/entity/AbsBaseArticleInfo;", "handleRefreshCookie", "cookie", "Lcom/tencent/mobileqq/pb/PBBytesField;", "handleTopicRedNumUpdate", "redNum", "handleTopicUpdateInfo", "needRefreshTopicInfo", "topicUpdateInfo", "Ltencent/im/oidb/articlesummary/articlesummary$TopicRecommendFeedsInfo;", "parseArticleList", "model", "Lcom/tencent/mobileqq/kandian/repo/feeds/ArticleInfoModule;", "rspChannel", "Ltencent/im/oidb/cmd0x68b/oidb_cmd0x68b$RspChannelArticle;", "pbData", "Lcom/tencent/mobileqq/pb/PBRepeatMessageField;", "Ltencent/im/oidb/cmd0x68b/oidb_cmd0x68b$RspGetFollowTabFeeds;", "kandian_feature_impl_release"}, k=1, mv={1, 1, 16})
public final class ArticleInfoModuleUtils$FollowChannelDataHandler
{
  public static final FollowChannelDataHandler a = new FollowChannelDataHandler();
  
  @Nullable
  public final List<AbsBaseArticleInfo> a(@NotNull ArticleInfoModule paramArticleInfoModule, @NotNull oidb_cmd0x68b.RspChannelArticle paramRspChannelArticle, @NotNull PBRepeatMessageField<oidb_cmd0x68b.RspGetFollowTabFeeds> paramPBRepeatMessageField)
  {
    Intrinsics.checkParameterIsNotNull(paramArticleInfoModule, "model");
    Intrinsics.checkParameterIsNotNull(paramRspChannelArticle, "rspChannel");
    Intrinsics.checkParameterIsNotNull(paramPBRepeatMessageField, "pbData");
    List localList = (List)null;
    if (!paramPBRepeatMessageField.has()) {
      return localList;
    }
    paramRspChannelArticle = (List)ReadInJoyMSFHandlerUtils.a(paramRspChannelArticle, paramPBRepeatMessageField.get());
    paramArticleInfoModule.i().a(paramRspChannelArticle, 70);
    if (ReadInJoyProteusFamilyUtil.e()) {
      ReadInJoyProteusFamilyUtil.c().a(70, paramPBRepeatMessageField.get(), paramRspChannelArticle);
    }
    return paramRspChannelArticle;
  }
  
  public final void a(@NotNull PBBytesField paramPBBytesField)
  {
    Intrinsics.checkParameterIsNotNull(paramPBBytesField, "cookie");
    if ((paramPBBytesField.has()) && (paramPBBytesField.get() != null))
    {
      paramPBBytesField = Base64Util.encodeToString(RIJPBFieldUtils.b(paramPBBytesField), 0);
      ReadInJoyLogicEngine.a().e(paramPBBytesField);
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("getFollowTabData : lastRefreshCookie ");
      localStringBuilder.append(paramPBBytesField);
      QLog.d("ArticleInfoModule", 2, localStringBuilder.toString());
    }
  }
  
  public final void a(@NotNull PBUInt32Field paramPBUInt32Field)
  {
    Intrinsics.checkParameterIsNotNull(paramPBUInt32Field, "topicData");
    if (paramPBUInt32Field.has())
    {
      ReadInJoyLogicEngine localReadInJoyLogicEngine = ReadInJoyLogicEngine.a();
      int i = paramPBUInt32Field.get();
      boolean bool = true;
      if (i != 1) {
        bool = false;
      }
      localReadInJoyLogicEngine.d(bool);
    }
  }
  
  public final void a(@NotNull PBUInt32Field paramPBUInt32Field, @Nullable List<? extends AbsBaseArticleInfo> paramList)
  {
    Intrinsics.checkParameterIsNotNull(paramPBUInt32Field, "lastReadIndex");
    if (paramList == null) {
      return;
    }
    if (paramPBUInt32Field.has())
    {
      int i = paramPBUInt32Field.get() - 1;
      if ((i > 0) && (i < paramList.size())) {
        ((AbsBaseArticleInfo)paramList.get(i)).hintFlag = true;
      }
      paramPBUInt32Field = new StringBuilder();
      paramPBUInt32Field.append("getFollowTabData : hint ");
      paramPBUInt32Field.append(i);
      QLog.d("ArticleInfoModule", 2, paramPBUInt32Field.toString());
    }
  }
  
  public final void a(@NotNull PBUInt32Field paramPBUInt32Field, @NotNull articlesummary.TopicRecommendFeedsInfo paramTopicRecommendFeedsInfo)
  {
    Intrinsics.checkParameterIsNotNull(paramPBUInt32Field, "needRefreshTopicInfo");
    Intrinsics.checkParameterIsNotNull(paramTopicRecommendFeedsInfo, "topicUpdateInfo");
    int i = 0;
    if (RIJPBFieldUtils.a(paramPBUInt32Field, 0) == 1) {
      i = 1;
    }
    if (i != 0)
    {
      if ((paramTopicRecommendFeedsInfo.has()) && (paramTopicRecommendFeedsInfo.get() != null))
      {
        paramPBUInt32Field = paramTopicRecommendFeedsInfo.get();
        Intrinsics.checkExpressionValueIsNotNull(paramPBUInt32Field, "topicUpdateInfo.get()");
        paramPBUInt32Field = TopicRecommendFeedsInfo.a((articlesummary.TopicRecommendFeedsInfo)paramPBUInt32Field);
        ReadInJoyLogicEngine.a().a(paramPBUInt32Field);
        return;
      }
      ReadInJoyLogicEngine.a().a(null);
    }
  }
  
  public final void b(@NotNull PBUInt32Field paramPBUInt32Field)
  {
    Intrinsics.checkParameterIsNotNull(paramPBUInt32Field, "redNum");
    if (paramPBUInt32Field.has()) {
      ReadInJoyLogicEngine.a().k(paramPBUInt32Field.get());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.repo.feeds.ArticleInfoModuleUtils.FollowChannelDataHandler
 * JD-Core Version:    0.7.0.1
 */