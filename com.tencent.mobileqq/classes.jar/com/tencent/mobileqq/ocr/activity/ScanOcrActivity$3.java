package com.tencent.mobileqq.ocr.activity;

import android.graphics.drawable.ColorDrawable;
import android.widget.ImageView;
import com.tencent.mobileqq.ocr.view.ScanOcrView;

class ScanOcrActivity$3
  implements Runnable
{
  ScanOcrActivity$3(ScanOcrActivity paramScanOcrActivity) {}
  
  public void run()
  {
    ScanOcrActivity.a(this.this$0).e();
    ScanOcrActivity.b(this.this$0).setImageDrawable(new ColorDrawable(-16777216));
    ScanOcrActivity.b(this.this$0).setVisibility(0);
    ScanOcrActivity.b(this.this$0).postDelayed(new ScanOcrActivity.3.1(this), 200L);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.ocr.activity.ScanOcrActivity.3
 * JD-Core Version:    0.7.0.1
 */