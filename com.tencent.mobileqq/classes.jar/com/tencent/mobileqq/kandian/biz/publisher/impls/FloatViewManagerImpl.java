package com.tencent.mobileqq.kandian.biz.publisher.impls;

import android.view.View;
import android.widget.FrameLayout.LayoutParams;
import com.tencent.tkd.topicsdk.interfaces.IFloatViewManager;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/mobileqq/kandian/biz/publisher/impls/FloatViewManagerImpl;", "Lcom/tencent/tkd/topicsdk/interfaces/IFloatViewManager;", "()V", "addView", "", "p0", "Landroid/view/View;", "p1", "Landroid/widget/FrameLayout$LayoutParams;", "removeView", "kandian_feature_impl_release"}, k=1, mv={1, 1, 16})
public final class FloatViewManagerImpl
  implements IFloatViewManager
{
  public void a(@NotNull View paramView)
  {
    Intrinsics.checkParameterIsNotNull(paramView, "p0");
  }
  
  public void a(@NotNull View paramView, @NotNull FrameLayout.LayoutParams paramLayoutParams)
  {
    Intrinsics.checkParameterIsNotNull(paramView, "p0");
    Intrinsics.checkParameterIsNotNull(paramLayoutParams, "p1");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.publisher.impls.FloatViewManagerImpl
 * JD-Core Version:    0.7.0.1
 */