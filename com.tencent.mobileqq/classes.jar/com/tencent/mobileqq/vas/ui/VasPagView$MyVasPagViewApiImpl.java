package com.tencent.mobileqq.vas.ui;

import android.view.View;
import androidx.annotation.UiThread;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.libpag.PAGView;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/mobileqq/vas/ui/VasPagView$MyVasPagViewApiImpl;", "Lcom/tencent/mobileqq/vas/ui/IVasPagViewApi;", "vasPagView", "Lcom/tencent/mobileqq/vas/ui/VasPagView;", "(Lcom/tencent/mobileqq/vas/ui/VasPagView;)V", "getVasPagView", "()Lcom/tencent/mobileqq/vas/ui/VasPagView;", "build", "getCurrentView", "Landroid/view/View;", "isBuild", "", "postAction", "block", "Lkotlin/Function1;", "Lorg/libpag/PAGView;", "", "refresh", "setStateChangeListener", "vas-temp-api_release"}, k=1, mv={1, 1, 16})
final class VasPagView$MyVasPagViewApiImpl
  implements IVasPagViewApi
{
  @NotNull
  private final VasPagView a;
  
  public VasPagView$MyVasPagViewApiImpl(@NotNull VasPagView paramVasPagView)
  {
    this.a = paramVasPagView;
  }
  
  @NotNull
  public IVasPagViewApi a()
  {
    this.a.c();
    return (IVasPagViewApi)this;
  }
  
  @UiThread
  @NotNull
  public IVasPagViewApi a(@NotNull Function1<? super PAGView, Unit> paramFunction1)
  {
    Intrinsics.checkParameterIsNotNull(paramFunction1, "block");
    this.a.a(paramFunction1);
    return (IVasPagViewApi)this;
  }
  
  @NotNull
  public IVasPagViewApi b()
  {
    this.a.d();
    return (IVasPagViewApi)this;
  }
  
  @NotNull
  public IVasPagViewApi b(@NotNull Function1<? super View, Unit> paramFunction1)
  {
    Intrinsics.checkParameterIsNotNull(paramFunction1, "block");
    this.a.setStateChangeListener(paramFunction1);
    return (IVasPagViewApi)this;
  }
  
  @Nullable
  public View c()
  {
    return this.a.getCurrentView();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.vas.ui.VasPagView.MyVasPagViewApiImpl
 * JD-Core Version:    0.7.0.1
 */