package com.tencent.mobileqq.vas.ui;

import android.content.Context;
import android.os.Looper;
import android.util.AttributeSet;
import android.view.View;
import android.widget.FrameLayout;
import bhty;
import bhue;
import bhuf;
import bhui;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/mobileqq/vas/ui/VasPagView;", "Landroid/widget/FrameLayout;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "currentView", "Landroid/view/View;", "getCurrentView", "()Landroid/view/View;", "setCurrentView", "(Landroid/view/View;)V", "<set-?>", "", "isBuild", "()Z", "stateChangeListener", "Lkotlin/Function1;", "", "getStateChangeListener", "()Lkotlin/jvm/functions/Function1;", "setStateChangeListener", "(Lkotlin/jvm/functions/Function1;)V", "viewProxy", "Lcom/tencent/mobileqq/vas/ui/VasPagView$MyViewProxy;", "getViewProxy$AQQLiteApp_release", "()Lcom/tencent/mobileqq/vas/ui/VasPagView$MyViewProxy;", "build", "refresh", "Companion", "MyLoader", "MyViewProxy", "AQQLiteApp_release"}, k=1, mv={1, 1, 16})
public final class VasPagView
  extends FrameLayout
{
  public static final bhue a;
  @NotNull
  private static final bhuf jdField_a_of_type_Bhuf = new bhuf();
  private static final String jdField_a_of_type_JavaLangString = "VasPagView";
  @Nullable
  private View jdField_a_of_type_AndroidViewView;
  @NotNull
  private final bhui jdField_a_of_type_Bhui;
  @NotNull
  private Function1<? super View, Unit> jdField_a_of_type_KotlinJvmFunctionsFunction1 = (Function1)VasPagView.stateChangeListener.1.INSTANCE;
  private boolean jdField_a_of_type_Boolean;
  
  static
  {
    jdField_a_of_type_Bhue = new bhue(null);
    jdField_a_of_type_JavaLangString = "VasPagView";
  }
  
  public VasPagView(@NotNull Context paramContext)
  {
    this(paramContext, null);
  }
  
  public VasPagView(@NotNull Context paramContext, @Nullable AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
  }
  
  public VasPagView(@NotNull Context paramContext, @Nullable AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    paramAttributeSet = new bhui(this);
    paramAttributeSet.b((Function0)new VasPagView..special..inlined.apply.lambda.1(paramContext));
    paramAttributeSet.c((Function0)new VasPagView..special..inlined.apply.lambda.2(paramContext));
    this.jdField_a_of_type_Bhui = paramAttributeSet;
  }
  
  @NotNull
  public final Function1<View, Unit> a()
  {
    return this.jdField_a_of_type_KotlinJvmFunctionsFunction1;
  }
  
  public final void a()
  {
    this.jdField_a_of_type_Boolean = true;
    this.jdField_a_of_type_Bhui.a((bhty)jdField_a_of_type_Bhuf);
  }
  
  public final boolean a()
  {
    return this.jdField_a_of_type_Boolean;
  }
  
  public final void b()
  {
    View localView = this.jdField_a_of_type_AndroidViewView;
    if (localView != null)
    {
      if (!Intrinsics.areEqual(Looper.getMainLooper(), Looper.myLooper())) {
        break label33;
      }
      this.jdField_a_of_type_KotlinJvmFunctionsFunction1.invoke(localView);
    }
    for (;;)
    {
      return;
      label33:
      localView.post((Runnable)new VasPagView.refresh..inlined.run.lambda.1(localView, this));
    }
  }
  
  public final void setCurrentView(@Nullable View paramView)
  {
    this.jdField_a_of_type_AndroidViewView = paramView;
  }
  
  public final void setStateChangeListener(@NotNull Function1<? super View, Unit> paramFunction1)
  {
    Intrinsics.checkParameterIsNotNull(paramFunction1, "<set-?>");
    this.jdField_a_of_type_KotlinJvmFunctionsFunction1 = paramFunction1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.vas.ui.VasPagView
 * JD-Core Version:    0.7.0.1
 */