package com.tencent.mobileqq.kandian.biz.playfeeds;

import android.support.v4.view.accessibility.AccessibilityEventCompat;
import android.support.v4.view.accessibility.AccessibilityNodeInfoCompat;
import android.support.v4.view.accessibility.AccessibilityRecordCompat;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerViewAccessibilityDelegate;
import android.view.View;
import android.view.accessibility.AccessibilityEvent;
import com.tencent.mobileqq.app.HardCodeUtil;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/mobileqq/kandian/biz/playfeeds/VideoFeedsAccessibilityHelper$VideoFeedsRVAccessibilityDelegate;", "Landroid/support/v7/widget/RecyclerViewAccessibilityDelegate;", "recyclerView", "Landroid/support/v7/widget/RecyclerView;", "(Landroid/support/v7/widget/RecyclerView;)V", "onInitializeAccessibilityEvent", "", "host", "Landroid/view/View;", "event", "Landroid/view/accessibility/AccessibilityEvent;", "onInitializeAccessibilityNodeInfo", "info", "Landroid/support/v4/view/accessibility/AccessibilityNodeInfoCompat;", "kandian_feature_impl_release"}, k=1, mv={1, 1, 16})
public final class VideoFeedsAccessibilityHelper$VideoFeedsRVAccessibilityDelegate
  extends RecyclerViewAccessibilityDelegate
{
  public VideoFeedsAccessibilityHelper$VideoFeedsRVAccessibilityDelegate(@Nullable RecyclerView paramRecyclerView)
  {
    super(paramRecyclerView);
  }
  
  public void onInitializeAccessibilityEvent(@NotNull View paramView, @NotNull AccessibilityEvent paramAccessibilityEvent)
  {
    Intrinsics.checkParameterIsNotNull(paramView, "host");
    Intrinsics.checkParameterIsNotNull(paramAccessibilityEvent, "event");
    super.onInitializeAccessibilityEvent(paramView, paramAccessibilityEvent);
    paramAccessibilityEvent = AccessibilityEventCompat.asRecord(paramAccessibilityEvent);
    Intrinsics.checkExpressionValueIsNotNull(paramAccessibilityEvent, "record");
    paramAccessibilityEvent.setItemCount(0);
    paramView.setContentDescription((CharSequence)HardCodeUtil.a(2131913392));
  }
  
  public void onInitializeAccessibilityNodeInfo(@NotNull View paramView, @NotNull AccessibilityNodeInfoCompat paramAccessibilityNodeInfoCompat)
  {
    Intrinsics.checkParameterIsNotNull(paramView, "host");
    Intrinsics.checkParameterIsNotNull(paramAccessibilityNodeInfoCompat, "info");
    super.onInitializeAccessibilityNodeInfo(paramView, paramAccessibilityNodeInfoCompat);
    paramAccessibilityNodeInfoCompat.setScrollable(false);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.playfeeds.VideoFeedsAccessibilityHelper.VideoFeedsRVAccessibilityDelegate
 * JD-Core Version:    0.7.0.1
 */