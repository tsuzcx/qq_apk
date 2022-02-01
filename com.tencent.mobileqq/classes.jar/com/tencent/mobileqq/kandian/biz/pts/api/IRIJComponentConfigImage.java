package com.tencent.mobileqq.kandian.biz.pts.api;

import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.core.ViewBase;
import com.tencent.mobileqq.kandian.repo.feeds.entity.AbsBaseArticleInfo;
import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;
import kotlin.Metadata;
import org.jetbrains.annotations.Nullable;

@QAPI(process={"all"})
@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/mobileqq/kandian/biz/pts/api/IRIJComponentConfigImage;", "Lcom/tencent/mobileqq/qroute/QRouteApi;", "showOrHideFreeNetFlowHint", "", "isShow", "", "parant", "Lcom/tencent/biz/pubaccount/readinjoy/view/proteus/virtualview/core/ViewBase;", "module", "", "tryToShowFreeNetFlowHint", "articleInfo", "Lcom/tencent/mobileqq/kandian/repo/feeds/entity/AbsBaseArticleInfo;", "kandian-api_release"}, k=1, mv={1, 1, 16})
public abstract interface IRIJComponentConfigImage
  extends QRouteApi
{
  public abstract void showOrHideFreeNetFlowHint(boolean paramBoolean, @Nullable ViewBase paramViewBase, @Nullable Object paramObject);
  
  public abstract void tryToShowFreeNetFlowHint(@Nullable ViewBase paramViewBase, @Nullable AbsBaseArticleInfo paramAbsBaseArticleInfo);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.pts.api.IRIJComponentConfigImage
 * JD-Core Version:    0.7.0.1
 */