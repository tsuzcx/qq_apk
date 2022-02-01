package com.tencent.tkd.topicsdk.entry.circle;

import android.widget.FrameLayout;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"<anonymous>", "", "invoke"}, k=3, mv={1, 1, 16})
final class CircleEntryView$fold$2
  extends Lambda
  implements Function0<Unit>
{
  CircleEntryView$fold$2(CircleEntryView paramCircleEntryView, Function0 paramFunction0)
  {
    super(0);
  }
  
  public final void invoke()
  {
    this.this$0.setFold(true);
    CircleEntryView.a(this.this$0).setBackgroundColor(0);
    Object localObject = this.$callback;
    if (localObject != null) {
      localObject = (Unit)((Function0)localObject).invoke();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.tkd.topicsdk.entry.circle.CircleEntryView.fold.2
 * JD-Core Version:    0.7.0.1
 */