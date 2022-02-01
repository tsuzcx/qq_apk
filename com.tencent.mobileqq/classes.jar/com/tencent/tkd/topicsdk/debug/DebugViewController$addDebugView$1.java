package com.tencent.tkd.topicsdk.debug;

import android.view.View;
import android.widget.FrameLayout.LayoutParams;
import com.tencent.tkd.topicsdk.interfaces.IFloatViewManager;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"<anonymous>", "", "invoke"}, k=3, mv={1, 1, 16})
final class DebugViewController$addDebugView$1
  extends Lambda
  implements Function0<Unit>
{
  DebugViewController$addDebugView$1(DebugViewController paramDebugViewController)
  {
    super(0);
  }
  
  public final void invoke()
  {
    if (DebugViewController.a(this.this$0) == null)
    {
      DebugViewController.a(this.this$0, new DebugView(DebugViewController.a(this.this$0)));
      localObject = new FrameLayout.LayoutParams(-2, -2);
      ((FrameLayout.LayoutParams)localObject).gravity = 8388659;
      DebugView localDebugView = DebugViewController.a(this.this$0);
      if (localDebugView != null) {
        DebugViewController.a(this.this$0).a((View)localDebugView, (FrameLayout.LayoutParams)localObject);
      }
    }
    Object localObject = DebugViewController.a(this.this$0);
    if (localObject != null) {
      ((DebugView)localObject).setVisibility(0);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.tkd.topicsdk.debug.DebugViewController.addDebugView.1
 * JD-Core Version:    0.7.0.1
 */