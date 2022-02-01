package com.tencent.mobileqq.ecshop.view.adcard;

import android.view.View;
import android.view.ViewGroup;
import androidx.viewpager.widget.PagerAdapter;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/mobileqq/ecshop/view/adcard/AdCardPageAdapter;", "Landroidx/viewpager/widget/PagerAdapter;", "mAdCardList", "", "Landroid/view/View;", "(Ljava/util/List;)V", "destroyItem", "", "container", "Landroid/view/ViewGroup;", "position", "", "obj", "", "getCount", "getItemPosition", "object", "instantiateItem", "isViewFromObject", "", "view", "qqshop-feature-impl_release"}, k=1, mv={1, 1, 16})
public final class AdCardPageAdapter
  extends PagerAdapter
{
  private final List<View> a;
  
  public void destroyItem(@NotNull ViewGroup paramViewGroup, int paramInt, @NotNull Object paramObject)
  {
    Intrinsics.checkParameterIsNotNull(paramViewGroup, "container");
    Intrinsics.checkParameterIsNotNull(paramObject, "obj");
    paramViewGroup.removeView((View)paramObject);
  }
  
  public int getCount()
  {
    return this.a.size();
  }
  
  public int getItemPosition(@NotNull Object paramObject)
  {
    Intrinsics.checkParameterIsNotNull(paramObject, "object");
    return -2;
  }
  
  @NotNull
  public Object instantiateItem(@NotNull ViewGroup paramViewGroup, int paramInt)
  {
    Intrinsics.checkParameterIsNotNull(paramViewGroup, "container");
    View localView = (View)this.a.get(paramInt);
    paramViewGroup.addView(localView);
    return localView;
  }
  
  public boolean isViewFromObject(@NotNull View paramView, @NotNull Object paramObject)
  {
    Intrinsics.checkParameterIsNotNull(paramView, "view");
    Intrinsics.checkParameterIsNotNull(paramObject, "obj");
    return Intrinsics.areEqual(paramView, paramObject);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.ecshop.view.adcard.AdCardPageAdapter
 * JD-Core Version:    0.7.0.1
 */