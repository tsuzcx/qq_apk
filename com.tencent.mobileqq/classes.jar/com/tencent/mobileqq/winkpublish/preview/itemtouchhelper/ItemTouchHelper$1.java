package com.tencent.mobileqq.winkpublish.preview.itemtouchhelper;

import androidx.core.view.ViewCompat;
import androidx.recyclerview.widget.RecyclerView;

class ItemTouchHelper$1
  implements Runnable
{
  public void run()
  {
    if ((this.this$0.b != null) && (this.this$0.b()))
    {
      if (this.this$0.b != null)
      {
        ItemTouchHelper localItemTouchHelper = this.this$0;
        localItemTouchHelper.a(localItemTouchHelper.b);
      }
      this.this$0.p.removeCallbacks(this.this$0.q);
      ViewCompat.postOnAnimation(this.this$0.p, this);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.tencent.mobileqq.winkpublish.preview.itemtouchhelper.ItemTouchHelper.1
 * JD-Core Version:    0.7.0.1
 */