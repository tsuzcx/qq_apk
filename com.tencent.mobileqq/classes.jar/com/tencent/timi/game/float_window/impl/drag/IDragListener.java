package com.tencent.timi.game.float_window.impl.drag;

import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/timi/game/float_window/impl/drag/IDragListener;", "", "onAnimationEnd", "", "onAnimationStart", "onDrag", "draggableView", "Lcom/tencent/timi/game/float_window/impl/drag/IDraggableView;", "nowCenterX", "", "nowCenterY", "onDragEnd", "onDragStart", "onDragUp", "timi-game-impl_release"}, k=1, mv={1, 1, 16})
public abstract interface IDragListener
{
  public abstract void a();
  
  public abstract void a(@NotNull IDraggableView paramIDraggableView);
  
  public abstract void a(@NotNull IDraggableView paramIDraggableView, int paramInt1, int paramInt2);
  
  public abstract void b();
  
  public abstract void b(@NotNull IDraggableView paramIDraggableView);
  
  public abstract void c(@NotNull IDraggableView paramIDraggableView);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.timi.game.float_window.impl.drag.IDragListener
 * JD-Core Version:    0.7.0.1
 */