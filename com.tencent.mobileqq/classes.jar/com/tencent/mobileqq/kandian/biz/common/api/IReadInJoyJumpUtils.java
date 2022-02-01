package com.tencent.mobileqq.kandian.biz.common.api;

import android.content.Context;
import android.content.Intent;
import com.tencent.mobileqq.kandian.repo.feeds.entity.AbsBaseArticleInfo;
import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;
import kotlin.Metadata;
import org.jetbrains.annotations.Nullable;

@QAPI(process={"all"})
@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/mobileqq/kandian/biz/common/api/IReadInJoyJumpUtils;", "Lcom/tencent/mobileqq/qroute/QRouteApi;", "configLockScreenJumpInfo", "", "intent", "Landroid/content/Intent;", "getJumpArticleDetailPageIntent", "context", "Landroid/content/Context;", "articleInfo", "Lcom/tencent/mobileqq/kandian/repo/feeds/entity/AbsBaseArticleInfo;", "kandian-api_release"}, k=1, mv={1, 1, 16})
public abstract interface IReadInJoyJumpUtils
  extends QRouteApi
{
  public abstract void configLockScreenJumpInfo(@Nullable Intent paramIntent);
  
  @Nullable
  public abstract Intent getJumpArticleDetailPageIntent(@Nullable Context paramContext, @Nullable AbsBaseArticleInfo paramAbsBaseArticleInfo);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.common.api.IReadInJoyJumpUtils
 * JD-Core Version:    0.7.0.1
 */