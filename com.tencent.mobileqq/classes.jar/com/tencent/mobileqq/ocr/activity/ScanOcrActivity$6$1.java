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
    if (this.jdField_a_of_type_Int != 0)
    {
      ScanOcrActivity.a(this.jdField_a_of_type_ComTencentMobileqqOcrActivityScanOcrActivity$6.a).setVisibility(0);
      ScanOcrActivity.a(this.jdField_a_of_type_ComTencentMobileqqOcrActivityScanOcrActivity$6.a).setText(2131689868);
      if (this.jdField_a_of_type_ComTencentMobileqqOcrActivityScanOcrActivity$6.a.jdField_a_of_type_Int == 1) {
        this.jdField_a_of_type_ComTencentMobileqqOcrActivityScanOcrActivity$6.a.jdField_a_of_type_ComTencentMobileqqOcrViewMaskView.setVisibility(0);
      }
    }
    else
    {
      if (this.jdField_a_of_type_ComTencentMobileqqOcrActivityScanOcrActivity$6.a.jdField_a_of_type_Int != 1)
      {
        if (!ScanOcrActivity.a(this.jdField_a_of_type_ComTencentMobileqqOcrActivityScanOcrActivity$6.a).a())
        {
          ScanOcrActivity.a(this.jdField_a_of_type_ComTencentMobileqqOcrActivityScanOcrActivity$6.a).setVisibility(0);
          ScanOcrActivity.a(this.jdField_a_of_type_ComTencentMobileqqOcrActivityScanOcrActivity$6.a).postDelayed(new ScanOcrActivity.6.1.1(this), 500L);
        }
      }
      else {
        this.jdField_a_of_type_ComTencentMobileqqOcrActivityScanOcrActivity$6.a.jdField_a_of_type_ComTencentMobileqqOcrViewMaskView.setVisibility(0);
      }
      ScanOcrActivity.a(this.jdField_a_of_type_ComTencentMobileqqOcrActivityScanOcrActivity$6.a).setVisibility(0);
      ScanOcrActivity.a(this.jdField_a_of_type_ComTencentMobileqqOcrActivityScanOcrActivity$6.a).setText(ScanOcrActivity.a(this.jdField_a_of_type_ComTencentMobileqqOcrActivityScanOcrActivity$6.a));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.ocr.activity.ScanOcrActivity.6.1
 * JD-Core Version:    0.7.0.1
 */