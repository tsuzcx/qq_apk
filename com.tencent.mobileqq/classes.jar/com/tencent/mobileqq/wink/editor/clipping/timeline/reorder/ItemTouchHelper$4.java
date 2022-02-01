package com.tencent.mobileqq.wink.editor.clipping.timeline.reorder;

import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.RecyclerView.ItemAnimator;
import androidx.recyclerview.widget.RecyclerView.ViewHolder;

class ItemTouchHelper$4
  implements Runnable
{
  ItemTouchHelper$4(ItemTouchHelper paramItemTouchHelper, ItemTouchHelper.RecoverAnimation paramRecoverAnimation, int paramInt) {}
  
  public void run()
  {
    if ((this.this$0.p != null) && (this.this$0.p.isAttachedToWindow()) && (!this.a.n) && (this.a.h.getAdapterPosition() != -1))
    {
      RecyclerView.ItemAnimator localItemAnimator = this.this$0.p.getItemAnimator();
      if (((localItemAnimator == null) || (!localItemAnimator.isRunning(null))) && (!this.this$0.a()))
      {
        this.this$0.l.a(this.a.h, this.b);
        return;
      }
      this.this$0.p.post(this);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.tencent.mobileqq.wink.editor.clipping.timeline.reorder.ItemTouchHelper.4
 * JD-Core Version:    0.7.0.1
 */