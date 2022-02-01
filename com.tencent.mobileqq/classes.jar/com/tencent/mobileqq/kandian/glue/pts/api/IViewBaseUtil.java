package com.tencent.mobileqq.kandian.glue.pts.api;

import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.core.ViewBase;
import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;

@QAPI(process={"all"})
@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/mobileqq/kandian/glue/pts/api/IViewBaseUtil;", "Lcom/tencent/mobileqq/qroute/QRouteApi;", "isReadInJoyBiuButton", "", "v", "Lcom/tencent/biz/pubaccount/readinjoy/view/proteus/virtualview/core/ViewBase;", "isReadInJoyLikeButton", "kandian-api_release"}, k=1, mv={1, 1, 16})
public abstract interface IViewBaseUtil
  extends QRouteApi
{
  public abstract boolean isReadInJoyBiuButton(@NotNull ViewBase paramViewBase);
  
  public abstract boolean isReadInJoyLikeButton(@NotNull ViewBase paramViewBase);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.glue.pts.api.IViewBaseUtil
 * JD-Core Version:    0.7.0.1
 */