package com.tencent.mobileqq.kandian.biz.viola.api;

import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;

@QAPI(process={"all"})
@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/mobileqq/kandian/biz/viola/api/IViolaFragmentPresenterFactory;", "Lcom/tencent/mobileqq/qroute/QRouteApi;", "createViolaFragmentPresenter", "Lcom/tencent/mobileqq/kandian/biz/viola/api/IViolaFragmentPresenter;", "view", "Lcom/tencent/mobileqq/kandian/biz/viola/api/IViolaFragmentView;", "kandian-api_release"}, k=1, mv={1, 1, 16})
public abstract interface IViolaFragmentPresenterFactory
  extends QRouteApi
{
  @NotNull
  public abstract IViolaFragmentPresenter createViolaFragmentPresenter(@NotNull IViolaFragmentView paramIViolaFragmentView);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.viola.api.IViolaFragmentPresenterFactory
 * JD-Core Version:    0.7.0.1
 */