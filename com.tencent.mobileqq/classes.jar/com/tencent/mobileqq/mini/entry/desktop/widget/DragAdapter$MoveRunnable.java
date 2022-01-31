package com.tencent.mobileqq.mini.entry.desktop.widget;

public class DragAdapter$MoveRunnable
  implements Runnable
{
  private int mMoveLeft = -1;
  private int mMoveTop = -1;
  
  public DragAdapter$MoveRunnable(DragAdapter paramDragAdapter) {}
  
  public void reset()
  {
    this.mMoveLeft = -1;
    this.mMoveTop = -1;
  }
  
  public void run()
  {
    this.this$0.doDragMove(this.mMoveLeft, this.mMoveTop);
  }
  
  public void setMoveAction(int paramInt1, int paramInt2)
  {
    this.mMoveLeft = paramInt1;
    this.mMoveTop = paramInt2;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.mini.entry.desktop.widget.DragAdapter.MoveRunnable
 * JD-Core Version:    0.7.0.1
 */