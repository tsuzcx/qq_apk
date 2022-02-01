package com.tencent.mobileqq.kandian.biz.publisher.impls;

import android.view.View;
import android.view.ViewGroup;
import androidx.viewpager.widget.PagerAdapter;
import com.tencent.tkd.topicsdk.framework.PagerAdapterProxy;
import com.tencent.tkd.topicsdk.interfaces.IPagerAdapter;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/mobileqq/kandian/biz/publisher/impls/ViewPagerImpl$RealPagerAdapter;", "Landroidx/viewpager/widget/PagerAdapter;", "proxy", "Lcom/tencent/tkd/topicsdk/framework/PagerAdapterProxy;", "(Lcom/tencent/tkd/topicsdk/framework/PagerAdapterProxy;)V", "getProxy", "()Lcom/tencent/tkd/topicsdk/framework/PagerAdapterProxy;", "destroyItem", "", "container", "Landroid/view/ViewGroup;", "position", "", "obj", "", "getCount", "getItemPosition", "instantiateItem", "isViewFromObject", "", "view", "Landroid/view/View;", "setPrimaryItem", "kandian_feature_impl_release"}, k=1, mv={1, 1, 16})
final class ViewPagerImpl$RealPagerAdapter
  extends PagerAdapter
{
  @NotNull
  private final PagerAdapterProxy a;
  
  public ViewPagerImpl$RealPagerAdapter(@NotNull PagerAdapterProxy paramPagerAdapterProxy)
  {
    this.a = paramPagerAdapterProxy;
    this.a.a((IPagerAdapter)new ViewPagerImpl.PagerAdapterImpl((PagerAdapter)this));
  }
  
  public void destroyItem(@NotNull ViewGroup paramViewGroup, int paramInt, @NotNull Object paramObject)
  {
    Intrinsics.checkParameterIsNotNull(paramViewGroup, "container");
    Intrinsics.checkParameterIsNotNull(paramObject, "obj");
    this.a.a(paramViewGroup, paramInt, paramObject);
  }
  
  public int getCount()
  {
    return this.a.a();
  }
  
  public int getItemPosition(@NotNull Object paramObject)
  {
    Intrinsics.checkParameterIsNotNull(paramObject, "obj");
    return this.a.a(paramObject);
  }
  
  @NotNull
  public Object instantiateItem(@NotNull ViewGroup paramViewGroup, int paramInt)
  {
    Intrinsics.checkParameterIsNotNull(paramViewGroup, "container");
    return this.a.a(paramViewGroup, paramInt);
  }
  
  public boolean isViewFromObject(@NotNull View paramView, @NotNull Object paramObject)
  {
    Intrinsics.checkParameterIsNotNull(paramView, "view");
    Intrinsics.checkParameterIsNotNull(paramObject, "obj");
    return this.a.a(paramView, paramObject);
  }
  
  public void setPrimaryItem(@NotNull ViewGroup paramViewGroup, int paramInt, @NotNull Object paramObject)
  {
    Intrinsics.checkParameterIsNotNull(paramViewGroup, "container");
    Intrinsics.checkParameterIsNotNull(paramObject, "obj");
    this.a.b(paramViewGroup, paramInt, paramObject);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.publisher.impls.ViewPagerImpl.RealPagerAdapter
 * JD-Core Version:    0.7.0.1
 */