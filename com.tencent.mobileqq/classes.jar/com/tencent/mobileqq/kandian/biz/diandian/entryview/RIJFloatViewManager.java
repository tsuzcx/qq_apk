package com.tencent.mobileqq.kandian.biz.diandian.entryview;

import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.widget.FrameLayout.LayoutParams;
import com.tencent.tkd.topicsdk.interfaces.IFloatViewManager;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/mobileqq/kandian/biz/diandian/entryview/RIJFloatViewManager;", "Lcom/tencent/tkd/topicsdk/interfaces/IFloatViewManager;", "parent", "Landroid/view/ViewGroup;", "(Landroid/view/ViewGroup;)V", "getParent", "()Landroid/view/ViewGroup;", "setParent", "addView", "", "entryView", "Landroid/view/View;", "layoutParams", "Landroid/widget/FrameLayout$LayoutParams;", "removeView", "kandian_feature_impl_release"}, k=1, mv={1, 1, 16})
public final class RIJFloatViewManager
  implements IFloatViewManager
{
  @NotNull
  private ViewGroup a;
  
  public RIJFloatViewManager(@NotNull ViewGroup paramViewGroup)
  {
    this.a = paramViewGroup;
  }
  
  public void a(@NotNull View paramView)
  {
    Intrinsics.checkParameterIsNotNull(paramView, "entryView");
    if (this.a.indexOfChild(paramView) >= 0) {
      this.a.removeView(paramView);
    }
  }
  
  public void a(@NotNull View paramView, @NotNull FrameLayout.LayoutParams paramLayoutParams)
  {
    Intrinsics.checkParameterIsNotNull(paramView, "entryView");
    Intrinsics.checkParameterIsNotNull(paramLayoutParams, "layoutParams");
    this.a.addView(paramView, (ViewGroup.LayoutParams)paramLayoutParams);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.diandian.entryview.RIJFloatViewManager
 * JD-Core Version:    0.7.0.1
 */