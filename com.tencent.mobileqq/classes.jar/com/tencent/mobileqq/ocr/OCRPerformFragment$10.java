package com.tencent.mobileqq.ocr;

import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.widget.PopupWindow.OnDismissListener;
import android.widget.TextView;
import java.util.List;

class OCRPerformFragment$10
  implements PopupWindow.OnDismissListener
{
  OCRPerformFragment$10(OCRPerformFragment paramOCRPerformFragment, OCRPerformUtil.OCRLanHolder paramOCRLanHolder) {}
  
  public void onDismiss()
  {
    OCRPerformFragment.b(this.jdField_a_of_type_ComTencentMobileqqOcrOCRPerformFragment, null);
    if ((this.jdField_a_of_type_ComTencentMobileqqOcrOCRPerformUtil$OCRLanHolder.c != null) && (this.jdField_a_of_type_ComTencentMobileqqOcrOCRPerformUtil$OCRLanHolder.c.size() > 1))
    {
      Drawable localDrawable = this.jdField_a_of_type_ComTencentMobileqqOcrOCRPerformFragment.getResources().getDrawable(2130846355);
      OCRPerformFragment.b(this.jdField_a_of_type_ComTencentMobileqqOcrOCRPerformFragment).setCompoundDrawablesWithIntrinsicBounds(null, null, null, localDrawable);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.ocr.OCRPerformFragment.10
 * JD-Core Version:    0.7.0.1
 */