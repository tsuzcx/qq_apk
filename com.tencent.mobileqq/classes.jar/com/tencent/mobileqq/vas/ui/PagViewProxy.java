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
  public static final PagViewProxy.Companion d = new PagViewProxy.Companion(null);
  @NotNull
  private static final String g = "VasPagView";
  @NotNull
  private static final AbsAsyncLoadProxy.Loader h = (AbsAsyncLoadProxy.Loader)new PagLoaderImpl();
  @Nullable
  private View a;
  @NotNull
  private Function1<? super View, Unit> b = (Function1)PagViewProxy.stateChangeListener.1.INSTANCE;
  private boolean c;
  private final PagViewProxy.MyViewProxy e = new PagViewProxy.MyViewProxy(this);
  private final ArrayList<Function1<PAGView, Unit>> f = new ArrayList();
  
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
  
  private final void a(View paramView)
  {
    if ((paramView instanceof PAGView))
    {
      Iterator localIterator = this.f.iterator();
      while (localIterator.hasNext()) {
        ((Function1)localIterator.next()).invoke(paramView);
      }
      this.f.clear();
    }
  }
  
  @UiThread
  protected final void a(@NotNull Function1<? super PAGView, Unit> paramFunction1)
  {
    Intrinsics.checkParameterIsNotNull(paramFunction1, "block");
    this.f.add(paramFunction1);
    a(this.a);
  }
  
  public final boolean b()
  {
    return this.c;
  }
  
  protected final void c()
  {
    this.c = true;
    this.e.a(h);
  }
  
  protected final void d()
  {
    View localView = this.a;
    if (localView != null)
    {
      if (Intrinsics.areEqual(Looper.getMainLooper(), Looper.myLooper()))
      {
        this.b.invoke(localView);
        a(localView);
        return;
      }
      localView.post((Runnable)new PagViewProxy.refresh..inlined.run.lambda.1(localView, this));
    }
  }
  
  @Nullable
  protected final View getCurrentView()
  {
    return this.a;
  }
  
  @NotNull
  protected final Function1<View, Unit> getStateChangeListener()
  {
    return this.b;
  }
  
  protected final void setCurrentView(@Nullable View paramView)
  {
    this.a = paramView;
  }
  
  protected final void setStateChangeListener(@NotNull Function1<? super View, Unit> paramFunction1)
  {
    Intrinsics.checkParameterIsNotNull(paramFunction1, "<set-?>");
    this.b = paramFunction1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.vas.ui.PagViewProxy
 * JD-Core Version:    0.7.0.1
 */