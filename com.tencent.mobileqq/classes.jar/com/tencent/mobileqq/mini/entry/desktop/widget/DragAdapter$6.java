package com.tencent.mobileqq.mini.entry.desktop.widget;

import ajjy;
import amda;
import bbmy;
import java.util.List;

class DragAdapter$6
  implements Runnable
{
  DragAdapter$6(DragAdapter paramDragAdapter, int paramInt) {}
  
  public void run()
  {
    bbmy.a(DragAdapter.access$600(this.this$0), ajjy.a(2131637728) + amda.c() + ajjy.a(2131637727), 0).a();
    if (this.val$overTopTargetIndex != -1)
    {
      this.this$0.mData.remove(this.val$overTopTargetIndex);
      this.this$0.notifyItemRemoved(this.val$overTopTargetIndex);
      this.this$0.notifyItemRangeChanged(this.val$overTopTargetIndex, this.this$0.getItemCount());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.mini.entry.desktop.widget.DragAdapter.6
 * JD-Core Version:    0.7.0.1
 */