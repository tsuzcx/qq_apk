package com.tencent.mobileqq.kandian.biz.viola.api.impl;

import androidx.fragment.app.Fragment;
import com.tencent.mobileqq.kandian.biz.viola.api.IViolaUiDelegate;
import com.tencent.mobileqq.kandian.biz.viola.api.IViolaUiDelegateFactory;
import com.tencent.mobileqq.kandian.glue.viola.delegate.ViolaUiDelegate;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/mobileqq/kandian/biz/viola/api/impl/ViolaUiDelegateFactoryImpl;", "Lcom/tencent/mobileqq/kandian/biz/viola/api/IViolaUiDelegateFactory;", "()V", "create", "Lcom/tencent/mobileqq/kandian/biz/viola/api/IViolaUiDelegate;", "fragment", "Landroidx/fragment/app/Fragment;", "kandian_feature_impl_release"}, k=1, mv={1, 1, 16})
public final class ViolaUiDelegateFactoryImpl
  implements IViolaUiDelegateFactory
{
  @NotNull
  public IViolaUiDelegate create(@NotNull Fragment paramFragment)
  {
    Intrinsics.checkParameterIsNotNull(paramFragment, "fragment");
    return (IViolaUiDelegate)new ViolaUiDelegate(paramFragment);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.viola.api.impl.ViolaUiDelegateFactoryImpl
 * JD-Core Version:    0.7.0.1
 */