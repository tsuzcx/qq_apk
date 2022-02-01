package com.tencent.mobileqq.kandian.repo.feeds.entity.api;

import com.tencent.mobileqq.kandian.glue.msf.api.IReadInJoyUserInfoModule.RefreshUserInfoCallBack;
import com.tencent.mobileqq.kandian.repo.feeds.entity.AbsBaseArticleInfo;
import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;
import kotlin.Metadata;
import org.jetbrains.annotations.Nullable;

@QAPI(process={"all"})
@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/mobileqq/kandian/repo/feeds/entity/api/IArticleViewModelUtil;", "Lcom/tencent/mobileqq/qroute/QRouteApi;", "convertBiuTime", "", "info", "Lcom/tencent/mobileqq/kandian/repo/feeds/entity/AbsBaseArticleInfo;", "makeBiuComment", "article", "callBack", "Lcom/tencent/mobileqq/kandian/glue/msf/api/IReadInJoyUserInfoModule$RefreshUserInfoCallBack;", "linkTextColor", "", "makeNonBiuComment", "articleInfo", "makeSummaryText", "kandian-api_release"}, k=1, mv={1, 1, 16})
public abstract interface IArticleViewModelUtil
  extends QRouteApi
{
  @Nullable
  public abstract CharSequence convertBiuTime(@Nullable AbsBaseArticleInfo paramAbsBaseArticleInfo);
  
  @Nullable
  public abstract CharSequence makeBiuComment(int paramInt, @Nullable AbsBaseArticleInfo paramAbsBaseArticleInfo, @Nullable IReadInJoyUserInfoModule.RefreshUserInfoCallBack paramRefreshUserInfoCallBack);
  
  @Nullable
  public abstract CharSequence makeBiuComment(@Nullable AbsBaseArticleInfo paramAbsBaseArticleInfo, @Nullable IReadInJoyUserInfoModule.RefreshUserInfoCallBack paramRefreshUserInfoCallBack);
  
  @Nullable
  public abstract CharSequence makeNonBiuComment(@Nullable AbsBaseArticleInfo paramAbsBaseArticleInfo, @Nullable IReadInJoyUserInfoModule.RefreshUserInfoCallBack paramRefreshUserInfoCallBack);
  
  @Nullable
  public abstract CharSequence makeSummaryText(int paramInt, @Nullable AbsBaseArticleInfo paramAbsBaseArticleInfo, @Nullable IReadInJoyUserInfoModule.RefreshUserInfoCallBack paramRefreshUserInfoCallBack);
  
  @Nullable
  public abstract CharSequence makeSummaryText(@Nullable AbsBaseArticleInfo paramAbsBaseArticleInfo, @Nullable IReadInJoyUserInfoModule.RefreshUserInfoCallBack paramRefreshUserInfoCallBack);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.repo.feeds.entity.api.IArticleViewModelUtil
 * JD-Core Version:    0.7.0.1
 */