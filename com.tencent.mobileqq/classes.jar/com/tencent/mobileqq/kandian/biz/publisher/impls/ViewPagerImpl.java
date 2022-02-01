package com.tencent.mobileqq.kandian.biz.publisher.impls;

import android.content.Context;
import android.view.View;
import androidx.viewpager.widget.PagerAdapter;
import androidx.viewpager.widget.ViewPager.OnPageChangeListener;
import com.tencent.tkd.topicsdk.framework.PagerAdapterProxy;
import com.tencent.tkd.topicsdk.interfaces.IViewPager;
import com.tencent.tkd.topicsdk.interfaces.OnPageChangeListenerProxy;
import java.util.HashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/mobileqq/kandian/biz/publisher/impls/ViewPagerImpl;", "Lcom/tencent/tkd/topicsdk/interfaces/IViewPager;", "()V", "value", "Lcom/tencent/tkd/topicsdk/framework/PagerAdapterProxy;", "adapter", "getAdapter", "()Lcom/tencent/tkd/topicsdk/framework/PagerAdapterProxy;", "setAdapter", "(Lcom/tencent/tkd/topicsdk/framework/PagerAdapterProxy;)V", "", "isScrollEnabled", "()Z", "setScrollEnabled", "(Z)V", "pageChangeListenerMap", "Ljava/util/HashMap;", "Lcom/tencent/tkd/topicsdk/interfaces/OnPageChangeListenerProxy;", "Landroidx/viewpager/widget/ViewPager$OnPageChangeListener;", "Lkotlin/collections/HashMap;", "viewPager", "Lcom/tencent/mobileqq/kandian/biz/publisher/impls/ViewPagerImpl$SubViewPager;", "addOnPageChangeListener", "", "listener", "clearOnPageChangeListeners", "getCurrentItem", "", "makeViewPager", "Landroid/view/View;", "context", "Landroid/content/Context;", "onRelease", "removeOnPageChangeListener", "setCurrentItem", "item", "smoothScroll", "setOffscreenPageLimit", "limit", "PagerAdapterImpl", "RealPagerAdapter", "SubViewPager", "kandian_feature_impl_release"}, k=1, mv={1, 1, 16})
public final class ViewPagerImpl
  implements IViewPager
{
  private ViewPagerImpl.SubViewPager a;
  private final HashMap<OnPageChangeListenerProxy, ViewPager.OnPageChangeListener> b = new HashMap();
  @Nullable
  private PagerAdapterProxy c;
  
  @NotNull
  public View a(@NotNull Context paramContext)
  {
    Intrinsics.checkParameterIsNotNull(paramContext, "context");
    paramContext = new ViewPagerImpl.SubViewPager(paramContext);
    this.a = paramContext;
    return (View)paramContext;
  }
  
  public void a()
  {
    this.a = ((ViewPagerImpl.SubViewPager)null);
  }
  
  public void a(int paramInt)
  {
    ViewPagerImpl.SubViewPager localSubViewPager = this.a;
    if (localSubViewPager != null) {
      localSubViewPager.setCurrentItem(paramInt);
    }
  }
  
  public void a(int paramInt, boolean paramBoolean)
  {
    ViewPagerImpl.SubViewPager localSubViewPager = this.a;
    if (localSubViewPager != null) {
      localSubViewPager.setCurrentItem(paramInt, paramBoolean);
    }
  }
  
  public void a(@Nullable PagerAdapterProxy paramPagerAdapterProxy)
  {
    this.c = paramPagerAdapterProxy;
    paramPagerAdapterProxy = b();
    if (paramPagerAdapterProxy != null)
    {
      paramPagerAdapterProxy = new ViewPagerImpl.RealPagerAdapter(paramPagerAdapterProxy);
      ViewPagerImpl.SubViewPager localSubViewPager = this.a;
      if (localSubViewPager != null) {
        localSubViewPager.setAdapter((PagerAdapter)paramPagerAdapterProxy);
      }
    }
  }
  
  public void a(@NotNull OnPageChangeListenerProxy paramOnPageChangeListenerProxy)
  {
    Intrinsics.checkParameterIsNotNull(paramOnPageChangeListenerProxy, "listener");
    ViewPagerImpl.addOnPageChangeListener.pageChangeListener.1 local1 = new ViewPagerImpl.addOnPageChangeListener.pageChangeListener.1(paramOnPageChangeListenerProxy);
    ((Map)this.b).put(paramOnPageChangeListenerProxy, local1);
    paramOnPageChangeListenerProxy = this.a;
    if (paramOnPageChangeListenerProxy != null) {
      paramOnPageChangeListenerProxy.addOnPageChangeListener((ViewPager.OnPageChangeListener)local1);
    }
  }
  
  public void a(boolean paramBoolean)
  {
    ViewPagerImpl.SubViewPager localSubViewPager = this.a;
    if (localSubViewPager != null) {
      localSubViewPager.a(paramBoolean);
    }
  }
  
  @Nullable
  public PagerAdapterProxy b()
  {
    return this.c;
  }
  
  public int c()
  {
    ViewPagerImpl.SubViewPager localSubViewPager = this.a;
    if (localSubViewPager != null) {
      return localSubViewPager.getCurrentItem();
    }
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.publisher.impls.ViewPagerImpl
 * JD-Core Version:    0.7.0.1
 */