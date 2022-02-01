package com.tencent.tkd.topicsdk.interfaces;

import android.content.Context;
import android.view.View;
import com.tencent.tkd.topicsdk.framework.PagerAdapterProxy;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/tkd/topicsdk/interfaces/IViewPager;", "Lcom/tencent/tkd/topicsdk/interfaces/Releasable;", "adapter", "Lcom/tencent/tkd/topicsdk/framework/PagerAdapterProxy;", "getAdapter", "()Lcom/tencent/tkd/topicsdk/framework/PagerAdapterProxy;", "setAdapter", "(Lcom/tencent/tkd/topicsdk/framework/PagerAdapterProxy;)V", "isScrollEnabled", "", "()Z", "setScrollEnabled", "(Z)V", "addOnPageChangeListener", "", "listener", "Lcom/tencent/tkd/topicsdk/interfaces/OnPageChangeListenerProxy;", "clearOnPageChangeListeners", "getCurrentItem", "", "makeViewPager", "Landroid/view/View;", "context", "Landroid/content/Context;", "removeOnPageChangeListener", "setCurrentItem", "item", "smoothScroll", "setOffscreenPageLimit", "limit", "topicsdk-framework_release"}, k=1, mv={1, 1, 16})
public abstract interface IViewPager
  extends Releasable
{
  public abstract int a();
  
  @NotNull
  public abstract View a(@NotNull Context paramContext);
  
  public abstract void a(int paramInt);
  
  public abstract void a(int paramInt, boolean paramBoolean);
  
  public abstract void a(@Nullable PagerAdapterProxy paramPagerAdapterProxy);
  
  public abstract void a(@NotNull OnPageChangeListenerProxy paramOnPageChangeListenerProxy);
  
  public abstract void a(boolean paramBoolean);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.tkd.topicsdk.interfaces.IViewPager
 * JD-Core Version:    0.7.0.1
 */