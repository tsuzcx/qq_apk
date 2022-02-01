package com.tencent.mobileqq.ocr.activity;

import android.widget.TextView;
import com.tencent.mobileqq.ocr.view.MaskView;
import com.tencent.mobileqq.ocr.view.ScanOcrView;

class ScanOcrActivity$6$1
  implements Runnable
{
  ScanOcrActivity$6$1(ScanOcrActivity.6 param6, int paramInt) {}
  
  public void run()
  {
    if (this.a != 0)
    {
      ScanOcrActivity.i(this.b.a).setVisibility(0);
      ScanOcrActivity.i(this.b.a).setText(2131886509);
      if (this.b.a.k == 1) {
        this.b.a.j.setVisibility(0);
      }
    }
    else
    {
      if (this.b.a.k != 1)
      {
        if (!ScanOcrActivity.b(this.b.a).b())
        {
          ScanOcrActivity.b(this.b.a).setVisibility(0);
          ScanOcrActivity.b(this.b.a).postDelayed(new ScanOcrActivity.6.1.1(this), 500L);
        }
      }
      else {
        this.b.a.j.setVisibility(0);
      }
      ScanOcrActivity.i(this.b.a).setVisibility(0);
      ScanOcrActivity.i(this.b.a).setText(ScanOcrActivity.j(this.b.a));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.ocr.activity.ScanOcrActivity.6.1
 * JD-Core Version:    0.7.0.1
 */