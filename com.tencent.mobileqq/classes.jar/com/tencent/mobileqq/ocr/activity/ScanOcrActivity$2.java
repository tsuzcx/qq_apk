package com.tencent.mobileqq.ocr.activity;

import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;

class ScanOcrActivity$2
  implements View.OnTouchListener
{
  ScanOcrActivity$2(ScanOcrActivity paramScanOcrActivity) {}
  
  public boolean onTouch(View paramView, MotionEvent paramMotionEvent)
  {
    int i = paramMotionEvent.getAction();
    if (i != 0)
    {
      if ((i == 1) || (i == 3)) {
        paramView.setAlpha(1.0F);
      }
    }
    else if (paramView == ScanOcrActivity.a(this.a)) {
      paramView.setAlpha(0.7F);
    } else {
      paramView.setAlpha(0.5F);
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.ocr.activity.ScanOcrActivity.2
 * JD-Core Version:    0.7.0.1
 */