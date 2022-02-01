package com.tencent.timi.game.liveroom.impl.view.operation;

import com.tencent.timi.game.liveroom.impl.widget.ChildViewPager;
import java.util.List;
import kotlin.Metadata;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"<anonymous>", "", "run"}, k=3, mv={1, 1, 16})
final class AnchorOperationView$mLoopTask$1
  implements Runnable
{
  AnchorOperationView$mLoopTask$1(AnchorOperationView paramAnchorOperationView) {}
  
  public final void run()
  {
    if (AnchorOperationView.c(this.this$0).b().isEmpty()) {
      return;
    }
    int i = AnchorOperationView.a(this.this$0);
    boolean bool = true;
    i = (i + 1) % AnchorOperationView.c(this.this$0).b().size();
    ChildViewPager localChildViewPager = (ChildViewPager)this.this$0.a(2131439657);
    if (i == 0) {
      bool = false;
    }
    localChildViewPager.setCurrentItem(i, bool);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.timi.game.liveroom.impl.view.operation.AnchorOperationView.mLoopTask.1
 * JD-Core Version:    0.7.0.1
 */