package com.tencent.mobileqq.ocr.activity;

import android.widget.TextView;
import com.tencent.mobileqq.ocr.view.MaskView;
import com.tencent.mobileqq.ocr.view.ScanOcrView;

class ScanOcrActivity$6$2
  implements Runnable
{
  ScanOcrActivity$6$2(ScanOcrActivity.6 param6) {}
  
  public void run()
  {
    ScanOcrActivity.i(this.a.a).setVisibility(0);
    ScanOcrActivity.i(this.a.a).setText(ScanOcrActivity.j(this.a.a));
    if (this.a.a.k != 1)
    {
      if (!ScanOcrActivity.b(this.a.a).b())
      {
        ScanOcrActivity.b(this.a.a).setVisibility(0);
        ScanOcrActivity.b(this.a.a).postDelayed(new ScanOcrActivity.6.2.1(this), 500L);
      }
    }
    else {
      this.a.a.j.setVisibility(0);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.ocr.activity.ScanOcrActivity.6.2
 * JD-Core Version:    0.7.0.1
 */