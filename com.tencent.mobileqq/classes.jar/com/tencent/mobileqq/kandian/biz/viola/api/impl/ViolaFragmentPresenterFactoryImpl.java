package com.tencent.mobileqq.kandian.biz.viola.api.impl;

import com.tencent.mobileqq.kandian.biz.viola.api.IViolaFragmentPresenter;
import com.tencent.mobileqq.kandian.biz.viola.api.IViolaFragmentPresenterFactory;
import com.tencent.mobileqq.kandian.biz.viola.api.IViolaFragmentView;
import com.tencent.mobileqq.kandian.biz.viola.presenter.ViolaFragmentPresenter;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/mobileqq/kandian/biz/viola/api/impl/ViolaFragmentPresenterFactoryImpl;", "Lcom/tencent/mobileqq/kandian/biz/viola/api/IViolaFragmentPresenterFactory;", "()V", "createViolaFragmentPresenter", "Lcom/tencent/mobileqq/kandian/biz/viola/api/IViolaFragmentPresenter;", "view", "Lcom/tencent/mobileqq/kandian/biz/viola/api/IViolaFragmentView;", "kandian_feature_impl_release"}, k=1, mv={1, 1, 16})
public final class ViolaFragmentPresenterFactoryImpl
  implements IViolaFragmentPresenterFactory
{
  @NotNull
  public IViolaFragmentPresenter createViolaFragmentPresenter(@NotNull IViolaFragmentView paramIViolaFragmentView)
  {
    Intrinsics.checkParameterIsNotNull(paramIViolaFragmentView, "view");
    return (IViolaFragmentPresenter)new ViolaFragmentPresenter(paramIViolaFragmentView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.viola.api.impl.ViolaFragmentPresenterFactoryImpl
 * JD-Core Version:    0.7.0.1
 */