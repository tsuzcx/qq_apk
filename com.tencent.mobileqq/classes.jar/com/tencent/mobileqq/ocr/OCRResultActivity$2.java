package com.tencent.mobileqq.ocr;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class OCRResultActivity$2
  implements View.OnClickListener
{
  OCRResultActivity$2(OCRResultActivity paramOCRResultActivity) {}
  
  public void onClick(View paramView)
  {
    this.a.doOnBackPressed();
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.ocr.OCRResultActivity.2
 * JD-Core Version:    0.7.0.1
 */