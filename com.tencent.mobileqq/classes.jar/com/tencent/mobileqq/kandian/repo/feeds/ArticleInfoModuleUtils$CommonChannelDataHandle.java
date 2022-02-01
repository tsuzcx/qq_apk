package com.tencent.mobileqq.kandian.repo.feeds;

import android.text.TextUtils;
import com.tencent.mobileqq.kandian.base.utils.RIJPBFieldUtils;
import com.tencent.mobileqq.kandian.base.utils.RIJSPUtils;
import com.tencent.mobileqq.kandian.biz.common.api.impl.PublicAccountReportUtils;
import com.tencent.mobileqq.kandian.glue.businesshandler.engine.ReadInJoyLogicEngine;
import com.tencent.mobileqq.kandian.glue.msf.ReadInJoyMSFHandlerUtils;
import com.tencent.mobileqq.kandian.glue.report.RIJTransMergeKanDianReport;
import com.tencent.mobileqq.kandian.glue.report.RIJTransMergeKanDianReport.ReportR5Builder;
import com.tencent.mobileqq.kandian.repo.aladdin.handlers.DailyModeConfigHandler;
import com.tencent.mobileqq.kandian.repo.feeds.entity.AbsBaseArticleInfo;
import com.tencent.mobileqq.kandian.repo.feeds.pts.ReadInJoyProteusFamilyUtil;
import com.tencent.mobileqq.kandian.repo.ugc.srt.BackOffInfoWithArticleInfo;
import com.tencent.mobileqq.kandian.repo.ugc.srtutils.ReadInJoySrtHandler;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.qphone.base.remote.ToServiceMsg;
import com.tencent.qphone.base.util.QLog;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.StringCompanionObject;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tencent.im.oidb.articlesummary.articlesummary.ArticleSummary;
import tencent.im.oidb.cmd0x68b.oidb_cmd0x68b.BackOffGroupInfo;
import tencent.im.oidb.cmd0x68b.oidb_cmd0x68b.RspChannelArticle;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/mobileqq/kandian/repo/feeds/ArticleInfoModuleUtils$CommonChannelDataHandle;", "", "()V", "handleNearbyCookie", "", "cookie", "Lcom/tencent/mobileqq/pb/PBBytesField;", "handleUGBackoffGroupInfos", "articleList", "", "Lcom/tencent/mobileqq/kandian/repo/feeds/entity/AbsBaseArticleInfo;", "rulesData", "Lcom/tencent/mobileqq/pb/PBRepeatMessageField;", "Ltencent/im/oidb/cmd0x68b/oidb_cmd0x68b$BackOffGroupInfo;", "channelID", "", "parseArticleList", "req", "Lcom/tencent/qphone/base/remote/ToServiceMsg;", "refreshType", "recommendFlag", "rspChannel", "Ltencent/im/oidb/cmd0x68b/oidb_cmd0x68b$RspChannelArticle;", "pbData", "Ltencent/im/oidb/articlesummary/articlesummary$ArticleSummary;", "kandian_feature_impl_release"}, k=1, mv={1, 1, 16})
public final class ArticleInfoModuleUtils$CommonChannelDataHandle
{
  public static final CommonChannelDataHandle a = new CommonChannelDataHandle();
  
  @Nullable
  public final List<AbsBaseArticleInfo> a(@NotNull ToServiceMsg paramToServiceMsg, int paramInt1, int paramInt2, int paramInt3, @NotNull oidb_cmd0x68b.RspChannelArticle paramRspChannelArticle, @NotNull PBRepeatMessageField<articlesummary.ArticleSummary> paramPBRepeatMessageField)
  {
    Intrinsics.checkParameterIsNotNull(paramToServiceMsg, "req");
    Intrinsics.checkParameterIsNotNull(paramRspChannelArticle, "rspChannel");
    Intrinsics.checkParameterIsNotNull(paramPBRepeatMessageField, "pbData");
    if (paramPBRepeatMessageField.has())
    {
      if (paramPBRepeatMessageField.get() == null) {
        return null;
      }
      List localList = ReadInJoyMSFHandlerUtils.a(paramRspChannelArticle, paramPBRepeatMessageField.get(), paramInt1, paramInt2, paramInt3);
      if (ReadInJoyProteusFamilyUtil.e()) {
        ReadInJoyProteusFamilyUtil.c().a(paramPBRepeatMessageField.get(), localList, paramInt1);
      }
      paramToServiceMsg = paramToServiceMsg.getAttributes().get("SubscriptionArticles");
      if ((paramToServiceMsg instanceof List))
      {
        paramToServiceMsg = (List)paramToServiceMsg;
        if (paramToServiceMsg.size() > 0)
        {
          if (localList != null) {
            paramInt1 = localList.size();
          } else {
            paramInt1 = 0;
          }
          if (paramInt1 > 0)
          {
            paramRspChannelArticle = StringCompanionObject.INSTANCE;
            paramRspChannelArticle = new Object[2];
            paramRspChannelArticle[0] = paramToServiceMsg.get(0);
            paramRspChannelArticle[1] = Long.valueOf(((AbsBaseArticleInfo)localList.get(0)).mArticleID);
            paramRspChannelArticle = String.format("red point article (%d)  server's first article(%d)", Arrays.copyOf(paramRspChannelArticle, paramRspChannelArticle.length));
            Intrinsics.checkExpressionValueIsNotNull(paramRspChannelArticle, "java.lang.String.format(format, *args)");
            QLog.d("ArticleInfoModule", 1, paramRspChannelArticle);
            if ((Intrinsics.areEqual(paramToServiceMsg.get(0), Long.valueOf(((AbsBaseArticleInfo)localList.get(0)).mArticleID)) ^ true))
            {
              paramPBRepeatMessageField = RIJTransMergeKanDianReport.g();
              paramRspChannelArticle = paramToServiceMsg.get(0);
              paramToServiceMsg = paramRspChannelArticle;
              if (!(paramRspChannelArticle instanceof Long)) {
                paramToServiceMsg = null;
              }
              paramToServiceMsg = (Long)paramToServiceMsg;
              long l;
              if (paramToServiceMsg != null) {
                l = paramToServiceMsg.longValue();
              } else {
                l = -1L;
              }
              paramPBRepeatMessageField.addStringNotThrow("red_article", l);
              paramPBRepeatMessageField.addStringNotThrow("feed_first_article", ((AbsBaseArticleInfo)localList.get(0)).mArticleID);
              PublicAccountReportUtils.a(null, "0X8009650", "0X8009650", "", 0, 0, "", "", "", paramPBRepeatMessageField.toString(), false);
            }
          }
        }
      }
      return localList;
    }
    return null;
  }
  
  public final void a(@NotNull PBBytesField paramPBBytesField)
  {
    Intrinsics.checkParameterIsNotNull(paramPBBytesField, "cookie");
    paramPBBytesField = RIJPBFieldUtils.a(paramPBBytesField);
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("nearby cookie = ");
    localStringBuilder.append(paramPBBytesField);
    QLog.d("ArticleInfoModule", 1, localStringBuilder.toString());
    if (!TextUtils.isEmpty((CharSequence)paramPBBytesField))
    {
      RIJSPUtils.a("sp_key_daily_dynamic_header_data", paramPBBytesField);
      ReadInJoyLogicEngine.a().h(paramPBBytesField);
      RIJSPUtils.a("readinjoy_nearby_people_last_refresh_cookie_sp_key", paramPBBytesField);
      DailyModeConfigHandler.a(paramPBBytesField);
    }
  }
  
  public final void a(@Nullable List<? extends AbsBaseArticleInfo> paramList, @NotNull PBRepeatMessageField<oidb_cmd0x68b.BackOffGroupInfo> paramPBRepeatMessageField, int paramInt)
  {
    Intrinsics.checkParameterIsNotNull(paramPBRepeatMessageField, "rulesData");
    if ((paramPBRepeatMessageField.has()) && (paramPBRepeatMessageField.get() != null))
    {
      BackOffInfoWithArticleInfo localBackOffInfoWithArticleInfo = new BackOffInfoWithArticleInfo();
      localBackOffInfoWithArticleInfo.b = paramList;
      localBackOffInfoWithArticleInfo.a = paramPBRepeatMessageField.get();
      localBackOffInfoWithArticleInfo.c = paramInt;
      ReadInJoySrtHandler.a().a(localBackOffInfoWithArticleInfo, ReadInJoySrtHandler.a);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.repo.feeds.ArticleInfoModuleUtils.CommonChannelDataHandle
 * JD-Core Version:    0.7.0.1
 */