package com.tencent.timi.game.float_window.impl.drag;

import kotlin.Metadata;
import kotlin.Pair;
import org.jetbrains.annotations.NotNull;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/timi/game/float_window/impl/drag/IDraggableView;", "", "bringToTop", "", "curCenterPoint", "Lkotlin/Pair;", "", "curExtraPadding", "getOuterHeight", "getOuterWidth", "getView", "Landroid/view/View;", "recoverPos", "setOnDragListener", "onDragListener", "Lcom/tencent/timi/game/float_window/impl/drag/IDragListener;", "timi-game-impl_release"}, k=1, mv={1, 1, 16})
public abstract interface IDraggableView
{
  @NotNull
  public abstract Pair<Integer, Integer> a();
  
  public abstract void b();
  
  public abstract int getOuterHeight();
  
  public abstract int getOuterWidth();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.timi.game.float_window.impl.drag.IDraggableView
 * JD-Core Version:    0.7.0.1
 */