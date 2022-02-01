package com.tencent.mobileqq.kandian.biz.viola.api.impl;

import android.content.Context;
import com.tencent.mobileqq.kandian.biz.viola.api.IViolaBaseView;
import com.tencent.mobileqq.kandian.biz.viola.api.IViolaBaseViewFactory;
import com.tencent.mobileqq.kandian.glue.viola.view.ViolaBaseView;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/mobileqq/kandian/biz/viola/api/impl/ViolaBaseViewFactoryImpl;", "Lcom/tencent/mobileqq/kandian/biz/viola/api/IViolaBaseViewFactory;", "()V", "createViolaBaseView", "Lcom/tencent/mobileqq/kandian/biz/viola/api/IViolaBaseView;", "context", "Landroid/content/Context;", "kandian_feature_impl_release"}, k=1, mv={1, 1, 16})
public final class ViolaBaseViewFactoryImpl
  implements IViolaBaseViewFactory
{
  @NotNull
  public IViolaBaseView createViolaBaseView(@NotNull Context paramContext)
  {
    Intrinsics.checkParameterIsNotNull(paramContext, "context");
    return (IViolaBaseView)new ViolaBaseView(paramContext);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.viola.api.impl.ViolaBaseViewFactoryImpl
 * JD-Core Version:    0.7.0.1
 */