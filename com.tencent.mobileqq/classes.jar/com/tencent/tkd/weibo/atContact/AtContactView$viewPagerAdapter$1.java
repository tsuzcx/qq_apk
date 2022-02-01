package com.tencent.tkd.weibo.atContact;

import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import androidx.viewpager.widget.PagerAdapter;
import com.tencent.tkd.weibo.framework.mvp.BaseListView;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"com/tencent/tkd/weibo/atContact/AtContactView$viewPagerAdapter$1", "Landroidx/viewpager/widget/PagerAdapter;", "getCount", "", "instantiateItem", "", "container", "Landroid/view/ViewGroup;", "position", "isViewFromObject", "", "view", "Landroid/view/View;", "object", "tkd-weibo-component_release"}, k=1, mv={1, 1, 16})
public final class AtContactView$viewPagerAdapter$1
  extends PagerAdapter
{
  public int getCount()
  {
    return 2;
  }
  
  @NotNull
  public Object instantiateItem(@NotNull ViewGroup paramViewGroup, int paramInt)
  {
    Intrinsics.checkParameterIsNotNull(paramViewGroup, "container");
    if (paramInt == 0)
    {
      paramViewGroup.addView((View)AtContactView.a(this.a), new ViewGroup.LayoutParams(-1, -1));
      return (BaseListView)AtContactView.a(this.a);
    }
    paramViewGroup.addView((View)AtContactView.a(this.a), new ViewGroup.LayoutParams(-1, -1));
    return (BaseListView)AtContactView.a(this.a);
  }
  
  public boolean isViewFromObject(@NotNull View paramView, @NotNull Object paramObject)
  {
    Intrinsics.checkParameterIsNotNull(paramView, "view");
    Intrinsics.checkParameterIsNotNull(paramObject, "object");
    return Intrinsics.areEqual(paramView, paramObject);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.tkd.weibo.atContact.AtContactView.viewPagerAdapter.1
 * JD-Core Version:    0.7.0.1
 */