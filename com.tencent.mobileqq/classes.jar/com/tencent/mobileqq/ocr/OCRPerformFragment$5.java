package com.tencent.mobileqq.ocr;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class OCRPerformFragment$5
  implements View.OnClickListener
{
  OCRPerformFragment$5(OCRPerformFragment paramOCRPerformFragment) {}
  
  public void onClick(View paramView)
  {
    OCRPerformUtil.a("0X800AADF", 0);
    this.a.onBackEvent();
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.ocr.OCRPerformFragment.5
 * JD-Core Version:    0.7.0.1
 */