package com.tencent.mobileqq.vas.ui;

import android.content.Context;
import android.os.Looper;
import android.util.AttributeSet;
import android.view.View;
import android.widget.FrameLayout;
import androidx.annotation.UiThread;
import java.util.ArrayList;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.libpag.PAGView;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/mobileqq/vas/ui/VasPagView;", "Landroid/widget/FrameLayout;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "actionRecord", "Ljava/util/ArrayList;", "Lkotlin/Function1;", "Lorg/libpag/PAGView;", "", "Lkotlin/collections/ArrayList;", "currentView", "Landroid/view/View;", "getCurrentView", "()Landroid/view/View;", "setCurrentView", "(Landroid/view/View;)V", "<set-?>", "", "isBuild", "()Z", "stateChangeListener", "getStateChangeListener", "()Lkotlin/jvm/functions/Function1;", "setStateChangeListener", "(Lkotlin/jvm/functions/Function1;)V", "viewProxy", "Lcom/tencent/mobileqq/vas/ui/VasPagView$MyViewProxy;", "build", "doActionAfterStateChange", "pagView", "postAction", "block", "refresh", "Companion", "MyLoader", "MyViewProxy", "AQQLiteApp_release"}, k=1, mv={1, 1, 16})
public class VasPagView
  extends FrameLayout
{
  public static final VasPagView.Companion a;
  @NotNull
  private static final VasPagView.MyLoader jdField_a_of_type_ComTencentMobileqqVasUiVasPagView$MyLoader = new VasPagView.MyLoader();
  private static final String jdField_a_of_type_JavaLangString = "VasPagView";
  @Nullable
  private View jdField_a_of_type_AndroidViewView;
  private final VasPagView.MyViewProxy jdField_a_of_type_ComTencentMobileqqVasUiVasPagView$MyViewProxy = new VasPagView.MyViewProxy(this);
  private final ArrayList<Function1<PAGView, Unit>> jdField_a_of_type_JavaUtilArrayList = new ArrayList();
  @NotNull
  private Function1<? super View, Unit> jdField_a_of_type_KotlinJvmFunctionsFunction1 = (Function1)VasPagView.stateChangeListener.1.INSTANCE;
  private boolean jdField_a_of_type_Boolean;
  
  static
  {
    jdField_a_of_type_ComTencentMobileqqVasUiVasPagView$Companion = new VasPagView.Companion(null);
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
  }
  
  private final void a(View paramView)
  {
    if ((paramView instanceof PAGView))
    {
      Iterator localIterator = this.jdField_a_of_type_JavaUtilArrayList.iterator();
      while (localIterator.hasNext()) {
        ((Function1)localIterator.next()).invoke(paramView);
      }
      this.jdField_a_of_type_JavaUtilArrayList.clear();
    }
  }
  
  @Nullable
  public final View a()
  {
    return this.jdField_a_of_type_AndroidViewView;
  }
  
  @NotNull
  public Function1<View, Unit> a()
  {
    return this.jdField_a_of_type_KotlinJvmFunctionsFunction1;
  }
  
  @UiThread
  public final void a(@NotNull Function1<? super PAGView, Unit> paramFunction1)
  {
    Intrinsics.checkParameterIsNotNull(paramFunction1, "block");
    this.jdField_a_of_type_JavaUtilArrayList.add(paramFunction1);
    a(this.jdField_a_of_type_AndroidViewView);
  }
  
  public final boolean a()
  {
    return this.jdField_a_of_type_Boolean;
  }
  
  public final void b()
  {
    this.jdField_a_of_type_Boolean = true;
    this.jdField_a_of_type_ComTencentMobileqqVasUiVasPagView$MyViewProxy.a((AbsAsyncLoadProxy.Loader)jdField_a_of_type_ComTencentMobileqqVasUiVasPagView$MyLoader);
  }
  
  public final void c()
  {
    View localView = this.jdField_a_of_type_AndroidViewView;
    if (localView != null)
    {
      if (!Intrinsics.areEqual(Looper.getMainLooper(), Looper.myLooper())) {
        break label38;
      }
      a().invoke(localView);
      a(localView);
    }
    for (;;)
    {
      return;
      label38:
      localView.post((Runnable)new VasPagView.refresh..inlined.run.lambda.1(localView, this));
    }
  }
  
  public final void setCurrentView(@Nullable View paramView)
  {
    this.jdField_a_of_type_AndroidViewView = paramView;
  }
  
  public void setStateChangeListener(@NotNull Function1<? super View, Unit> paramFunction1)
  {
    Intrinsics.checkParameterIsNotNull(paramFunction1, "<set-?>");
    this.jdField_a_of_type_KotlinJvmFunctionsFunction1 = paramFunction1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.vas.ui.VasPagView
 * JD-Core Version:    0.7.0.1
 */