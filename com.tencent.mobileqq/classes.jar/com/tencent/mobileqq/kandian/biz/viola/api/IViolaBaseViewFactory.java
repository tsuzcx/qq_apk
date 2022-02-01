package com.tencent.mobileqq.kandian.biz.viola.api;

import android.content.Context;
import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;

@QAPI(process={"all"})
@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/mobileqq/kandian/biz/viola/api/IViolaBaseViewFactory;", "Lcom/tencent/mobileqq/qroute/QRouteApi;", "createViolaBaseView", "Lcom/tencent/mobileqq/kandian/biz/viola/api/IViolaBaseView;", "context", "Landroid/content/Context;", "kandian-api_release"}, k=1, mv={1, 1, 16})
public abstract interface IViolaBaseViewFactory
  extends QRouteApi
{
  @NotNull
  public abstract IViolaBaseView createViolaBaseView(@NotNull Context paramContext);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.viola.api.IViolaBaseViewFactory
 * JD-Core Version:    0.7.0.1
 */