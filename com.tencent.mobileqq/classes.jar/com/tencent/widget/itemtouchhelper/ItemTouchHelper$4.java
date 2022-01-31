package com.tencent.widget.itemtouchhelper;

import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.ItemAnimator;
import android.support.v7.widget.RecyclerView.ViewHolder;
import beqc;
import beqg;
import beqk;

public class ItemTouchHelper$4
  implements Runnable
{
  public ItemTouchHelper$4(beqc parambeqc, beqk parambeqk, int paramInt) {}
  
  public void run()
  {
    if ((this.this$0.mRecyclerView != null) && (this.this$0.mRecyclerView.isAttachedToWindow()) && (!this.jdField_a_of_type_Beqk.jdField_b_of_type_Boolean) && (this.jdField_a_of_type_Beqk.jdField_b_of_type_AndroidSupportV7WidgetRecyclerView$ViewHolder.getAdapterPosition() != -1))
    {
      RecyclerView.ItemAnimator localItemAnimator = this.this$0.mRecyclerView.getItemAnimator();
      if (((localItemAnimator == null) || (!localItemAnimator.isRunning(null))) && (!this.this$0.hasRunningRecoverAnim())) {
        this.this$0.mCallback.onSwiped(this.jdField_a_of_type_Beqk.jdField_b_of_type_AndroidSupportV7WidgetRecyclerView$ViewHolder, this.jdField_a_of_type_Int);
      }
    }
    else
    {
      return;
    }
    this.this$0.mRecyclerView.post(this);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.widget.itemtouchhelper.ItemTouchHelper.4
 * JD-Core Version:    0.7.0.1
 */