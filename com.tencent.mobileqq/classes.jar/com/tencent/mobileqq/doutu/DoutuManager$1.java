package com.tencent.mobileqq.doutu;

import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.widget.HorizontalListView.OnScrollStateChangedListener;

class DoutuManager$1
  implements HorizontalListView.OnScrollStateChangedListener
{
  DoutuManager$1(DoutuManager paramDoutuManager) {}
  
  public void onScrollStateChanged(int paramInt)
  {
    if (paramInt == 4097) {
      ReportController.b(DoutuManager.a(this.a), "dc00898", "", "", "0X8007FAA", "0X8007FAA", 0, 0, "", "", "", "");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.doutu.DoutuManager.1
 * JD-Core Version:    0.7.0.1
 */