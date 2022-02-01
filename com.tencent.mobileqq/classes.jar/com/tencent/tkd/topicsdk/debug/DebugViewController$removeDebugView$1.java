package com.tencent.tkd.topicsdk.debug;

import android.view.View;
import com.tencent.tkd.topicsdk.interfaces.IFloatViewManager;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"<anonymous>", "", "invoke"}, k=3, mv={1, 1, 16})
final class DebugViewController$removeDebugView$1
  extends Lambda
  implements Function0<Unit>
{
  DebugViewController$removeDebugView$1(DebugViewController paramDebugViewController)
  {
    super(0);
  }
  
  public final void invoke()
  {
    DebugView localDebugView = DebugViewController.a(this.this$0);
    if (localDebugView != null) {
      DebugViewController.a(this.this$0).a((View)localDebugView);
    }
    DebugViewController.a(this.this$0, (DebugView)null);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.tkd.topicsdk.debug.DebugViewController.removeDebugView.1
 * JD-Core Version:    0.7.0.1
 */