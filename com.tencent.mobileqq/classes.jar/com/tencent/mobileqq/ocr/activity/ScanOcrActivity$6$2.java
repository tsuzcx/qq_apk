package com.tencent.mobileqq.ocr.activity;

import android.widget.TextView;
import avxo;
import com.tencent.mobileqq.ocr.view.MaskView;
import com.tencent.mobileqq.ocr.view.ScanOcrView;

public class ScanOcrActivity$6$2
  implements Runnable
{
  public ScanOcrActivity$6$2(avxo paramavxo) {}
  
  public void run()
  {
    ScanOcrActivity.a(this.a.a).setVisibility(0);
    ScanOcrActivity.a(this.a.a).setText(ScanOcrActivity.a(this.a.a));
    if (this.a.a.jdField_a_of_type_Int != 1)
    {
      if (!ScanOcrActivity.a(this.a.a).a())
      {
        ScanOcrActivity.a(this.a.a).setVisibility(0);
        ScanOcrActivity.a(this.a.a).postDelayed(new ScanOcrActivity.6.2.1(this), 500L);
      }
      return;
    }
    this.a.a.jdField_a_of_type_ComTencentMobileqqOcrViewMaskView.setVisibility(0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.ocr.activity.ScanOcrActivity.6.2
 * JD-Core Version:    0.7.0.1
 */