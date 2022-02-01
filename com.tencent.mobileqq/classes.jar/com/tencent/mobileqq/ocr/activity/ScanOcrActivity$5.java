package com.tencent.mobileqq.ocr.activity;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.ocr.OcrControl;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class ScanOcrActivity$5
  implements View.OnClickListener
{
  ScanOcrActivity$5(ScanOcrActivity paramScanOcrActivity) {}
  
  public void onClick(View paramView)
  {
    if ((ScanOcrActivity.a(this.a) == 1) && ((ScanOcrActivity.b(this.a) == 0) || (ScanOcrActivity.b(this.a) == 4)))
    {
      ScanOcrActivity.a(this.a).a();
      ScanOcrActivity.a(this.a, false);
      ScanOcrActivity.b(this.a);
    }
    else
    {
      this.a.finish();
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.ocr.activity.ScanOcrActivity.5
 * JD-Core Version:    0.7.0.1
 */