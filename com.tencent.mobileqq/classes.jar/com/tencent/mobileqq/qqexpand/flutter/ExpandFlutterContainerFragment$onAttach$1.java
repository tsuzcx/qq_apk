package com.tencent.mobileqq.qqexpand.flutter;

import android.view.View;
import com.tencent.mobileqq.flutter.container.QFlutterContainerDelegate;
import com.tencent.mobileqq.utils.NetworkUtil;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"<anonymous>", "", "run"}, k=3, mv={1, 1, 16})
final class ExpandFlutterContainerFragment$onAttach$1
  implements Runnable
{
  ExpandFlutterContainerFragment$onAttach$1(ExpandFlutterContainerFragment paramExpandFlutterContainerFragment) {}
  
  public final void run()
  {
    if (ExpandFlutterContainerFragment.a(this.this$0) != null)
    {
      QFlutterContainerDelegate localQFlutterContainerDelegate = ExpandFlutterContainerFragment.a(this.this$0);
      Intrinsics.checkExpressionValueIsNotNull(localQFlutterContainerDelegate, "mDelegate");
      if ((!localQFlutterContainerDelegate.b()) && (!NetworkUtil.isNetSupport(this.this$0.getContext()))) {
        ExpandFlutterContainerFragment.a(this.this$0).setVisibility(0);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.mobileqq.qqexpand.flutter.ExpandFlutterContainerFragment.onAttach.1
 * JD-Core Version:    0.7.0.1
 */