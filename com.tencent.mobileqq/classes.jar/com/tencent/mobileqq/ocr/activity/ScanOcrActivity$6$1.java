package com.tencent.mobileqq.ocr.activity;

import android.widget.TextView;
import ayhg;
import com.tencent.mobileqq.ocr.view.MaskView;
import com.tencent.mobileqq.ocr.view.ScanOcrView;

public class ScanOcrActivity$6$1
  implements Runnable
{
  public ScanOcrActivity$6$1(ayhg paramayhg, int paramInt) {}
  
  public void run()
  {
    if (this.jdField_a_of_type_Int != 0)
    {
      ScanOcrActivity.a(this.jdField_a_of_type_Ayhg.a).setVisibility(0);
      ScanOcrActivity.a(this.jdField_a_of_type_Ayhg.a).setText(2131689865);
      if (this.jdField_a_of_type_Ayhg.a.jdField_a_of_type_Int == 1) {
        this.jdField_a_of_type_Ayhg.a.jdField_a_of_type_ComTencentMobileqqOcrViewMaskView.setVisibility(0);
      }
      return;
    }
    if (this.jdField_a_of_type_Ayhg.a.jdField_a_of_type_Int != 1) {
      if (!ScanOcrActivity.a(this.jdField_a_of_type_Ayhg.a).a())
      {
        ScanOcrActivity.a(this.jdField_a_of_type_Ayhg.a).setVisibility(0);
        ScanOcrActivity.a(this.jdField_a_of_type_Ayhg.a).postDelayed(new ScanOcrActivity.6.1.1(this), 500L);
      }
    }
    for (;;)
    {
      ScanOcrActivity.a(this.jdField_a_of_type_Ayhg.a).setVisibility(0);
      ScanOcrActivity.a(this.jdField_a_of_type_Ayhg.a).setText(ScanOcrActivity.a(this.jdField_a_of_type_Ayhg.a));
      return;
      this.jdField_a_of_type_Ayhg.a.jdField_a_of_type_ComTencentMobileqqOcrViewMaskView.setVisibility(0);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.ocr.activity.ScanOcrActivity.6.1
 * JD-Core Version:    0.7.0.1
 */