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

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/mobileqq/vas/ui/PagViewProxy;", "Landroid/widget/FrameLayout;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "actionRecord", "Ljava/util/ArrayList;", "Lkotlin/Function1;", "Lorg/libpag/PAGView;", "", "Lkotlin/collections/ArrayList;", "currentView", "Landroid/view/View;", "getCurrentView", "()Landroid/view/View;", "setCurrentView", "(Landroid/view/View;)V", "<set-?>", "", "isBuild", "()Z", "stateChangeListener", "getStateChangeListener", "()Lkotlin/jvm/functions/Function1;", "setStateChangeListener", "(Lkotlin/jvm/functions/Function1;)V", "viewProxy", "Lcom/tencent/mobileqq/vas/ui/PagViewProxy$MyViewProxy;", "build", "doActionAfterStateChange", "pagView", "postAction", "block", "refresh", "Companion", "MyViewProxy", "vas-temp-api_release"}, k=1, mv={1, 1, 16})
public class PagViewProxy
  extends FrameLayout
{
  @NotNull
  private static final AbsAsyncLoadProxy.Loader jdField_a_of_type_ComTencentMobileqqVasUiAbsAsyncLoadProxy$Loader = (AbsAsyncLoadProxy.Loader)new PagLoaderImpl();
  public static final PagViewProxy.Companion a;
  @NotNull
  private static final String jdField_a_of_type_JavaLangString = "VasPagView";
  @Nullable
  private View jdField_a_of_type_AndroidViewView;
  private final PagViewProxy.MyViewProxy jdField_a_of_type_ComTencentMobileqqVasUiPagViewProxy$MyViewProxy = new PagViewProxy.MyViewProxy(this);
  private final ArrayList<Function1<PAGView, Unit>> jdField_a_of_type_JavaUtilArrayList = new ArrayList();
  @NotNull
  private Function1<? super View, Unit> jdField_a_of_type_KotlinJvmFunctionsFunction1 = (Function1)PagViewProxy.stateChangeListener.1.INSTANCE;
  private boolean jdField_a_of_type_Boolean;
  
  static
  {
    jdField_a_of_type_ComTencentMobileqqVasUiPagViewProxy$Companion = new PagViewProxy.Companion(null);
    jdField_a_of_type_JavaLangString = "VasPagView";
  }
  
  public PagViewProxy(@NotNull Context paramContext)
  {
    this(paramContext, null);
  }
  
  public PagViewProxy(@NotNull Context paramContext, @Nullable AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
  }
  
  public PagViewProxy(@NotNull Context paramContext, @Nullable AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
  }
  
  private final void b(View paramView)
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
  protected final View a()
  {
    return this.jdField_a_of_type_AndroidViewView;
  }
  
  @NotNull
  protected final Function1<View, Unit> a()
  {
    return this.jdField_a_of_type_KotlinJvmFunctionsFunction1;
  }
  
  protected final void a(@Nullable View paramView)
  {
    this.jdField_a_of_type_AndroidViewView = paramView;
  }
  
  protected final void a(@NotNull Function1<? super View, Unit> paramFunction1)
  {
    Intrinsics.checkParameterIsNotNull(paramFunction1, "<set-?>");
    this.jdField_a_of_type_KotlinJvmFunctionsFunction1 = paramFunction1;
  }
  
  public final boolean a()
  {
    return this.jdField_a_of_type_Boolean;
  }
  
  protected final void b()
  {
    this.jdField_a_of_type_Boolean = true;
    this.jdField_a_of_type_ComTencentMobileqqVasUiPagViewProxy$MyViewProxy.a(jdField_a_of_type_ComTencentMobileqqVasUiAbsAsyncLoadProxy$Loader);
  }
  
  @UiThread
  protected final void b(@NotNull Function1<? super PAGView, Unit> paramFunction1)
  {
    Intrinsics.checkParameterIsNotNull(paramFunction1, "block");
    this.jdField_a_of_type_JavaUtilArrayList.add(paramFunction1);
    b(this.jdField_a_of_type_AndroidViewView);
  }
  
  protected final void c()
  {
    View localView = this.jdField_a_of_type_AndroidViewView;
    if (localView != null)
    {
      if (Intrinsics.areEqual(Looper.getMainLooper(), Looper.myLooper()))
      {
        this.jdField_a_of_type_KotlinJvmFunctionsFunction1.invoke(localView);
        b(localView);
        return;
      }
      localView.post((Runnable)new PagViewProxy.refresh..inlined.run.lambda.1(localView, this));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.vas.ui.PagViewProxy
 * JD-Core Version:    0.7.0.1
 */