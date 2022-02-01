package com.tencent.mobileqq.utils.drag_n_drop;

public abstract interface DragAndDropDetector$DragSource
{
  public abstract DragAndDropDetector.Draggable findDraggableByPos(float paramFloat1, float paramFloat2);
  
  public abstract boolean onDrag(DragAndDropDetector.Draggable paramDraggable, float paramFloat1, float paramFloat2);
  
  public abstract void onDrop(DragAndDropDetector.DropTarget paramDropTarget, DragAndDropDetector.Draggable paramDraggable, float paramFloat1, float paramFloat2);
  
  public abstract void onMove(DragAndDropDetector.Draggable paramDraggable, float paramFloat1, float paramFloat2);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.utils.drag_n_drop.DragAndDropDetector.DragSource
 * JD-Core Version:    0.7.0.1
 */