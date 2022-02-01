package com.tencent.tkd.topicsdk.entry.square;

import android.widget.RelativeLayout;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"<anonymous>", "", "invoke"}, k=3, mv={1, 1, 16})
final class SquareEntryView$getProgressLayoutAnimation$1
  extends Lambda
  implements Function0<Unit>
{
  SquareEntryView$getProgressLayoutAnimation$1(SquareEntryView paramSquareEntryView, Function0 paramFunction0)
  {
    super(0);
  }
  
  public final void invoke()
  {
    SquareEntryView.a(this.this$0).setVisibility(8);
    Object localObject = this.$animationCallback;
    if (localObject != null) {
      localObject = (Unit)((Function0)localObject).invoke();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.tkd.topicsdk.entry.square.SquareEntryView.getProgressLayoutAnimation.1
 * JD-Core Version:    0.7.0.1
 */