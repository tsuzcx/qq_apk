package com.tencent.mobileqq.vas.ui;

import android.view.View;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.libpag.PAGView;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/mobileqq/vas/ui/IVasPagViewApi;", "", "build", "getCurrentView", "Landroid/view/View;", "isBuild", "", "postAction", "block", "Lkotlin/Function1;", "Lorg/libpag/PAGView;", "", "refresh", "setStateChangeListener", "vas-temp-api_release"}, k=1, mv={1, 1, 16})
public abstract interface IVasPagViewApi
{
  @NotNull
  public abstract IVasPagViewApi a();
  
  @NotNull
  public abstract IVasPagViewApi a(@NotNull Function1<? super PAGView, Unit> paramFunction1);
  
  @NotNull
  public abstract IVasPagViewApi b();
  
  @NotNull
  public abstract IVasPagViewApi b(@NotNull Function1<? super View, Unit> paramFunction1);
  
  @Nullable
  public abstract View c();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.vas.ui.IVasPagViewApi
 * JD-Core Version:    0.7.0.1
 */