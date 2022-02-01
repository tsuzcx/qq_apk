package com.tencent.timi.game.liveroom.impl.view.message;

import androidx.recyclerview.widget.RecyclerView.RecycledViewPool;
import kotlin.Metadata;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/timi/game/liveroom/impl/view/message/MsgRecyclerViewPool;", "Landroidx/recyclerview/widget/RecyclerView$RecycledViewPool;", "()V", "timi-game-impl_release"}, k=1, mv={1, 1, 16})
public final class MsgRecyclerViewPool
  extends RecyclerView.RecycledViewPool
{
  public MsgRecyclerViewPool()
  {
    setMaxRecycledViews(1, 20);
    setMaxRecycledViews(1, 20);
    setMaxRecycledViews(2, 20);
    setMaxRecycledViews(4, 5);
    setMaxRecycledViews(3, 10);
    setMaxRecycledViews(5, 20);
    setMaxRecycledViews(100, 20);
    setMaxRecycledViews(102, 5);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.timi.game.liveroom.impl.view.message.MsgRecyclerViewPool
 * JD-Core Version:    0.7.0.1
 */