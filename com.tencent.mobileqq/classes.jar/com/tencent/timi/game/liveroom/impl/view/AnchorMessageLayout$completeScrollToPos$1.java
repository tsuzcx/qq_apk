package com.tencent.timi.game.liveroom.impl.view;

import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.RecyclerView.LayoutManager;
import kotlin.Metadata;
import kotlin.TypeCastException;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"<anonymous>", "", "run"}, k=3, mv={1, 1, 16})
final class AnchorMessageLayout$completeScrollToPos$1
  implements Runnable
{
  AnchorMessageLayout$completeScrollToPos$1(AnchorMessageLayout paramAnchorMessageLayout, RecyclerView paramRecyclerView, boolean paramBoolean, int paramInt) {}
  
  public final void run()
  {
    this.a.stopScroll();
    if (this.b)
    {
      this.a.scrollToPosition(this.c);
    }
    else
    {
      RecyclerView.LayoutManager localLayoutManager = this.a.getLayoutManager();
      if (localLayoutManager == null) {
        break label60;
      }
      ((LinearLayoutManager)localLayoutManager).scrollToPositionWithOffset(this.c, 0);
    }
    AnchorMessageLayout.j(this.this$0);
    return;
    label60:
    throw new TypeCastException("null cannot be cast to non-null type androidx.recyclerview.widget.LinearLayoutManager");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.timi.game.liveroom.impl.view.AnchorMessageLayout.completeScrollToPos.1
 * JD-Core Version:    0.7.0.1
 */