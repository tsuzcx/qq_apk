package com.tencent.tkd.topicsdk.debug;

import android.view.View;
import android.view.View.OnClickListener;
import android.widget.TextView;
import com.tencent.tkd.topicsdk.framework.StorageManager;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"}, k=3, mv={1, 1, 16})
final class DebugView$10
  implements View.OnClickListener
{
  DebugView$10(DebugView paramDebugView, TextView paramTextView) {}
  
  public final void onClick(View paramView)
  {
    if (StorageManager.a.a("useDebugCircleIdView", false)) {
      StorageManager.a.a("useDebugCircleIdView", false);
    }
    for (;;)
    {
      paramView = this.jdField_a_of_type_ComTencentTkdTopicsdkDebugDebugView;
      TextView localTextView = this.jdField_a_of_type_AndroidWidgetTextView;
      Intrinsics.checkExpressionValueIsNotNull(localTextView, "useDebugCircleIdView");
      paramView.d(localTextView);
      return;
      StorageManager.a.a("useDebugCircleIdView", true);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.tkd.topicsdk.debug.DebugView.10
 * JD-Core Version:    0.7.0.1
 */