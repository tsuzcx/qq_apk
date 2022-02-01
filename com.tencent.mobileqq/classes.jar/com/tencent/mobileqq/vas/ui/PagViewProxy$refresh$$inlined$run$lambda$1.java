package com.tencent.mobileqq.vas.ui;

import android.view.View;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"<anonymous>", "", "run", "com/tencent/mobileqq/vas/ui/PagViewProxy$refresh$1$1"}, k=3, mv={1, 1, 16})
final class PagViewProxy$refresh$$inlined$run$lambda$1
  implements Runnable
{
  PagViewProxy$refresh$$inlined$run$lambda$1(View paramView, PagViewProxy paramPagViewProxy) {}
  
  public final void run()
  {
    this.this$0.getStateChangeListener().invoke(this.a);
    PagViewProxy.a(this.this$0, this.a);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.vas.ui.PagViewProxy.refresh..inlined.run.lambda.1
 * JD-Core Version:    0.7.0.1
 */