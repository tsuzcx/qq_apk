package com.tencent.widget.itemtouchhelper;

import android.support.v4.view.ViewCompat;
import android.support.v7.widget.RecyclerView;
import bidr;

public class ItemTouchHelper$1
  implements Runnable
{
  public ItemTouchHelper$1(bidr parambidr) {}
  
  public void run()
  {
    if ((this.this$0.mSelected != null) && (this.this$0.scrollIfNecessary()))
    {
      if (this.this$0.mSelected != null) {
        this.this$0.moveIfNecessary(this.this$0.mSelected);
      }
      this.this$0.mRecyclerView.removeCallbacks(this.this$0.mScrollRunnable);
      ViewCompat.postOnAnimation(this.this$0.mRecyclerView, this);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.widget.itemtouchhelper.ItemTouchHelper.1
 * JD-Core Version:    0.7.0.1
 */