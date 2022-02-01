package com.tencent.tkd.topicsdk.framework;

import android.content.Context;
import android.view.View;
import com.tencent.tkd.topicsdk.interfaces.IViewPager;
import com.tencent.tkd.topicsdk.interfaces.OnPageChangeListenerProxy;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/tkd/topicsdk/framework/ViewPagerProxy;", "", "context", "Landroid/content/Context;", "viewPagerImpl", "Lcom/tencent/tkd/topicsdk/interfaces/IViewPager;", "(Landroid/content/Context;Lcom/tencent/tkd/topicsdk/interfaces/IViewPager;)V", "value", "Lcom/tencent/tkd/topicsdk/framework/PagerAdapterProxy;", "adapter", "getAdapter", "()Lcom/tencent/tkd/topicsdk/framework/PagerAdapterProxy;", "setAdapter", "(Lcom/tencent/tkd/topicsdk/framework/PagerAdapterProxy;)V", "getContext", "()Landroid/content/Context;", "", "isScrollEnabled", "()Z", "setScrollEnabled", "(Z)V", "viewPager", "Landroid/view/View;", "getViewPager", "()Landroid/view/View;", "setViewPager", "(Landroid/view/View;)V", "addOnPageChangeListener", "", "listener", "Lcom/tencent/tkd/topicsdk/interfaces/OnPageChangeListenerProxy;", "clearOnPageChangeListeners", "getCurrentItem", "", "onViewDetached", "removeOnPageChangeListener", "setCurrentItem", "item", "smoothScroll", "setOffscreenPageLimit", "limit", "topicsdk-framework_release"}, k=1, mv={1, 1, 16})
public final class ViewPagerProxy
{
  @Nullable
  private View a;
  private boolean b;
  @Nullable
  private PagerAdapterProxy c;
  @NotNull
  private final Context d;
  private final IViewPager e;
  
  public ViewPagerProxy(@NotNull Context paramContext, @NotNull IViewPager paramIViewPager)
  {
    this.d = paramContext;
    this.e = paramIViewPager;
    this.a = this.e.a(this.d);
    this.b = true;
  }
  
  @Nullable
  public final View a()
  {
    return this.a;
  }
  
  public final void a(int paramInt)
  {
    this.e.a(paramInt);
  }
  
  public final void a(int paramInt, boolean paramBoolean)
  {
    this.e.a(paramInt, paramBoolean);
  }
  
  public final void a(@Nullable PagerAdapterProxy paramPagerAdapterProxy)
  {
    this.e.a(paramPagerAdapterProxy);
    this.c = paramPagerAdapterProxy;
  }
  
  public final void a(@NotNull OnPageChangeListenerProxy paramOnPageChangeListenerProxy)
  {
    Intrinsics.checkParameterIsNotNull(paramOnPageChangeListenerProxy, "listener");
    this.e.a(paramOnPageChangeListenerProxy);
  }
  
  public final void a(boolean paramBoolean)
  {
    this.b = paramBoolean;
    this.e.a(paramBoolean);
  }
  
  public final int b()
  {
    return this.e.c();
  }
  
  public final void c()
  {
    this.a = ((View)null);
    this.e.a();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.tkd.topicsdk.framework.ViewPagerProxy
 * JD-Core Version:    0.7.0.1
 */