package com.tencent.mobileqq.kandian.biz.comment.util.api;

import android.view.View;
import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;

@QAPI(process={"all"})
@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/mobileqq/kandian/biz/comment/util/api/IRIJCommentTopicUtil;", "Lcom/tencent/mobileqq/qroute/QRouteApi;", "onTopicClick", "", "vTarget", "Landroid/view/View;", "url", "", "kandian-api_release"}, k=1, mv={1, 1, 16})
public abstract interface IRIJCommentTopicUtil
  extends QRouteApi
{
  public abstract void onTopicClick(@NotNull View paramView, @NotNull String paramString);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.comment.util.api.IRIJCommentTopicUtil
 * JD-Core Version:    0.7.0.1
 */