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

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/mobileqq/vas/ui/PagViewProxy$MyViewProxy;", "Lcom/tencent/mobileqq/vas/ui/AbsAsyncLoadProxy;", "Landroid/view/View;", "container", "Lcom/tencent/mobileqq/vas/ui/PagViewProxy;", "(Lcom/tencent/mobileqq/vas/ui/PagViewProxy;)V", "getContainer", "()Lcom/tencent/mobileqq/vas/ui/PagViewProxy;", "failedBuilder", "Lkotlin/Function0;", "Landroid/widget/FrameLayout;", "getFailedBuilder", "()Lkotlin/jvm/functions/Function0;", "sucessedBuilder", "Lorg/libpag/PAGView;", "getSucessedBuilder", "onCurrentObjectChanged", "", "onPostLoaderTask", "block", "update", "view", "vas-temp-api_release"}, k=1, mv={1, 1, 16})
public final class PagViewProxy$MyViewProxy
  extends AbsAsyncLoadProxy<View>
{
  @NotNull
  private final Function0<FrameLayout> a;
  @NotNull
  private final Function0<PAGView> b;
  @NotNull
  private final PagViewProxy c;
  
  public PagViewProxy$MyViewProxy(@NotNull PagViewProxy paramPagViewProxy)
  {
    this.c = paramPagViewProxy;
    this.a = ((Function0)new PagViewProxy.MyViewProxy.failedBuilder.1(this));
    this.b = ((Function0)new PagViewProxy.MyViewProxy.sucessedBuilder.1(this));
  }
  
  private final void a(View paramView)
  {
    if (paramView == null)
    {
      this.c.removeAllViews();
      return;
    }
    this.c.removeAllViews();
    this.c.addView(paramView);
    this.c.getStateChangeListener().invoke(paramView);
    PagViewProxy.a(this.c, paramView);
  }
  
  protected void a()
  {
    this.c.setCurrentView((View)b());
    if (Intrinsics.areEqual(Looper.getMainLooper(), Looper.myLooper()))
    {
      a((View)b());
      return;
    }
    this.c.post((Runnable)new PagViewProxy.MyViewProxy.onCurrentObjectChanged.1(this));
  }
  
  protected void a(@NotNull Function0<Unit> paramFunction0)
  {
    Intrinsics.checkParameterIsNotNull(paramFunction0, "block");
    ThreadManagerV2.executeOnSubThread((Runnable)new PagViewProxy.MyViewProxy.onPostLoaderTask.1(paramFunction0));
  }
  
  @NotNull
  public Function0<FrameLayout> c()
  {
    return this.a;
  }
  
  @NotNull
  public Function0<PAGView> d()
  {
    return this.b;
  }
  
  @NotNull
  public final PagViewProxy g()
  {
    return this.c;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.vas.ui.PagViewProxy.MyViewProxy
 * JD-Core Version:    0.7.0.1
 */