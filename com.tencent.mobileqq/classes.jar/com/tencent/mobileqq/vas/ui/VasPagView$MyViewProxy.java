package com.tencent.mobileqq.vas.ui;

import android.os.Looper;
import android.view.View;
import android.widget.FrameLayout;
import com.tencent.mobileqq.app.ThreadManagerV2;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.libpag.PAGView;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/mobileqq/vas/ui/VasPagView$MyViewProxy;", "Lcom/tencent/mobileqq/vas/ui/AbsAsyncLoadProxy;", "Landroid/view/View;", "container", "Lcom/tencent/mobileqq/vas/ui/VasPagView;", "(Lcom/tencent/mobileqq/vas/ui/VasPagView;)V", "getContainer", "()Lcom/tencent/mobileqq/vas/ui/VasPagView;", "failedBuilder", "Lkotlin/Function0;", "Landroid/widget/FrameLayout;", "getFailedBuilder", "()Lkotlin/jvm/functions/Function0;", "sucessedBuilder", "Lorg/libpag/PAGView;", "getSucessedBuilder", "onCurrentObjectChanged", "", "onPostLoaderTask", "block", "update", "view", "AQQLiteApp_release"}, k=1, mv={1, 1, 16})
public final class VasPagView$MyViewProxy
  extends AbsAsyncLoadProxy<View>
{
  @NotNull
  private final VasPagView jdField_a_of_type_ComTencentMobileqqVasUiVasPagView;
  @NotNull
  private final Function0<FrameLayout> jdField_a_of_type_KotlinJvmFunctionsFunction0;
  @NotNull
  private final Function0<PAGView> b;
  
  public VasPagView$MyViewProxy(@NotNull VasPagView paramVasPagView)
  {
    this.jdField_a_of_type_ComTencentMobileqqVasUiVasPagView = paramVasPagView;
    this.jdField_a_of_type_KotlinJvmFunctionsFunction0 = ((Function0)new VasPagView.MyViewProxy.failedBuilder.1(this));
    this.b = ((Function0)new VasPagView.MyViewProxy.sucessedBuilder.1(this));
  }
  
  private final void a(View paramView)
  {
    if (paramView == null)
    {
      this.jdField_a_of_type_ComTencentMobileqqVasUiVasPagView.removeAllViews();
      return;
    }
    this.jdField_a_of_type_ComTencentMobileqqVasUiVasPagView.removeAllViews();
    this.jdField_a_of_type_ComTencentMobileqqVasUiVasPagView.addView(paramView);
    this.jdField_a_of_type_ComTencentMobileqqVasUiVasPagView.a().invoke(paramView);
    VasPagView.a(this.jdField_a_of_type_ComTencentMobileqqVasUiVasPagView, paramView);
  }
  
  @NotNull
  public final VasPagView a()
  {
    return this.jdField_a_of_type_ComTencentMobileqqVasUiVasPagView;
  }
  
  @NotNull
  public Function0<FrameLayout> a()
  {
    return this.jdField_a_of_type_KotlinJvmFunctionsFunction0;
  }
  
  protected void a()
  {
    this.jdField_a_of_type_ComTencentMobileqqVasUiVasPagView.setCurrentView((View)a());
    if (Intrinsics.areEqual(Looper.getMainLooper(), Looper.myLooper()))
    {
      a((View)a());
      return;
    }
    this.jdField_a_of_type_ComTencentMobileqqVasUiVasPagView.post((Runnable)new VasPagView.MyViewProxy.onCurrentObjectChanged.1(this));
  }
  
  protected void a(@NotNull Function0<Unit> paramFunction0)
  {
    Intrinsics.checkParameterIsNotNull(paramFunction0, "block");
    ThreadManagerV2.executeOnSubThread((Runnable)new VasPagView.MyViewProxy.onPostLoaderTask.1(paramFunction0));
  }
  
  @NotNull
  public Function0<PAGView> b()
  {
    return this.b;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.vas.ui.VasPagView.MyViewProxy
 * JD-Core Version:    0.7.0.1
 */