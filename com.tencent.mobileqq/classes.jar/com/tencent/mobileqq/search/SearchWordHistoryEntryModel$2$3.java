package com.tencent.mobileqq.search;

import android.view.View;
import android.widget.RelativeLayout;

class SearchWordHistoryEntryModel$2$3
  implements Runnable
{
  SearchWordHistoryEntryModel$2$3(SearchWordHistoryEntryModel.2 param2, int[] paramArrayOfInt1, View paramView, int[] paramArrayOfInt2) {}
  
  public void run()
  {
    this.d.c.g.getLocationOnScreen(this.a);
    this.b.getLocationOnScreen(this.c);
    if (this.a[1] > this.c[1])
    {
      View localView1 = this.b.findViewById(2131428795);
      View localView2 = this.b.findViewById(2131428782);
      localView1.setVisibility(8);
      localView2.setVisibility(0);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.search.SearchWordHistoryEntryModel.2.3
 * JD-Core Version:    0.7.0.1
 */