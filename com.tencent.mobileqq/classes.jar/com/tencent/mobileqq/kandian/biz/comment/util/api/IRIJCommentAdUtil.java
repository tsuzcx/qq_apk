package com.tencent.mobileqq.kandian.biz.comment.util.api;

import android.content.Context;
import com.tencent.mobileqq.kandian.repo.feeds.entity.AbsBaseArticleInfo;
import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;
import kotlin.Metadata;
import org.jetbrains.annotations.Nullable;

@QAPI(process={"all"})
@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/mobileqq/kandian/biz/comment/util/api/IRIJCommentAdUtil;", "Lcom/tencent/mobileqq/qroute/QRouteApi;", "jumpToLandingPage", "", "context", "Landroid/content/Context;", "videoStartPosition", "", "advertisementInfo", "Lcom/tencent/mobileqq/kandian/repo/feeds/entity/AbsBaseArticleInfo;", "kandian-api_release"}, k=1, mv={1, 1, 16})
public abstract interface IRIJCommentAdUtil
  extends QRouteApi
{
  public abstract void jumpToLandingPage(@Nullable Context paramContext, long paramLong, @Nullable AbsBaseArticleInfo paramAbsBaseArticleInfo);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.comment.util.api.IRIJCommentAdUtil
 * JD-Core Version:    0.7.0.1
 */