package com.tencent.mobileqq.ocr.activity;

import android.widget.TextView;
import ayzz;
import com.tencent.mobileqq.ocr.view.MaskView;
import com.tencent.mobileqq.ocr.view.ScanOcrView;

public class ScanOcrActivity$6$1
  implements Runnable
{
  public ScanOcrActivity$6$1(ayzz paramayzz, int paramInt) {}
  
  public void run()
  {
    if (this.jdField_a_of_type_Int != 0)
    {
      ScanOcrActivity.a(this.jdField_a_of_type_Ayzz.a).setVisibility(0);
      ScanOcrActivity.a(this.jdField_a_of_type_Ayzz.a).setText(2131689870);
      if (this.jdField_a_of_type_Ayzz.a.jdField_a_of_type_Int == 1) {
        this.jdField_a_of_type_Ayzz.a.jdField_a_of_type_ComTencentMobileqqOcrViewMaskView.setVisibility(0);
      }
      return;
    }
    if (this.jdField_a_of_type_Ayzz.a.jdField_a_of_type_Int != 1) {
      if (!ScanOcrActivity.a(this.jdField_a_of_type_Ayzz.a).a())
      {
        ScanOcrActivity.a(this.jdField_a_of_type_Ayzz.a).setVisibility(0);
        ScanOcrActivity.a(this.jdField_a_of_type_Ayzz.a).postDelayed(new ScanOcrActivity.6.1.1(this), 500L);
      }
    }
    for (;;)
    {
      ScanOcrActivity.a(this.jdField_a_of_type_Ayzz.a).setVisibility(0);
      ScanOcrActivity.a(this.jdField_a_of_type_Ayzz.a).setText(ScanOcrActivity.a(this.jdField_a_of_type_Ayzz.a));
      return;
      this.jdField_a_of_type_Ayzz.a.jdField_a_of_type_ComTencentMobileqqOcrViewMaskView.setVisibility(0);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.ocr.activity.ScanOcrActivity.6.1
 * JD-Core Version:    0.7.0.1
 */