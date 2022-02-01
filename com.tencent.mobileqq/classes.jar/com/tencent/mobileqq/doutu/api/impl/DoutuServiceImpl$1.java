package com.tencent.mobileqq.doutu.api.impl;

import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.widget.HorizontalListView.OnScrollStateChangedListener;

class DoutuServiceImpl$1
  implements HorizontalListView.OnScrollStateChangedListener
{
  DoutuServiceImpl$1(DoutuServiceImpl paramDoutuServiceImpl) {}
  
  public void onScrollStateChanged(int paramInt)
  {
    if (paramInt == 4097) {
      ReportController.b(DoutuServiceImpl.access$000(this.a), "dc00898", "", "", "0X8007FAA", "0X8007FAA", 0, 0, "", "", "", "");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.doutu.api.impl.DoutuServiceImpl.1
 * JD-Core Version:    0.7.0.1
 */