package com.tencent.tkd.topicsdk.coverselect;

import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import com.tencent.tkd.topicsdk.framework.PagerAdapterProxy;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"com/tencent/tkd/topicsdk/coverselect/CoverSelectPage$mAdapter$1", "Lcom/tencent/tkd/topicsdk/framework/PagerAdapterProxy;", "getCount", "", "instantiateItem", "", "container", "Landroid/view/ViewGroup;", "position", "isViewFromObject", "", "view", "Landroid/view/View;", "obj", "topicsdk_release"}, k=1, mv={1, 1, 16})
public final class CoverSelectPage$mAdapter$1
  extends PagerAdapterProxy
{
  public int a()
  {
    return 2;
  }
  
  @NotNull
  public Object a(@NotNull ViewGroup paramViewGroup, int paramInt)
  {
    Intrinsics.checkParameterIsNotNull(paramViewGroup, "container");
    if (paramInt == 0)
    {
      paramViewGroup.addView((View)CoverSelectPage.b(this.a));
      return (LinearLayout)CoverSelectPage.b(this.a);
    }
    paramViewGroup.addView((View)CoverSelectPage.a(this.a));
    return (LinearLayout)CoverSelectPage.a(this.a);
  }
  
  public boolean a(@NotNull View paramView, @NotNull Object paramObject)
  {
    Intrinsics.checkParameterIsNotNull(paramView, "view");
    Intrinsics.checkParameterIsNotNull(paramObject, "obj");
    return paramView == paramObject;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.tkd.topicsdk.coverselect.CoverSelectPage.mAdapter.1
 * JD-Core Version:    0.7.0.1
 */