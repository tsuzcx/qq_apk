package com.tencent.mobileqq.ocr;

import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.widget.PopupWindow.OnDismissListener;
import android.widget.TextView;
import java.util.List;

class TranslateFragment$5
  implements PopupWindow.OnDismissListener
{
  TranslateFragment$5(TranslateFragment paramTranslateFragment, OCRPerformUtil.OCRLanHolder paramOCRLanHolder) {}
  
  public void onDismiss()
  {
    TranslateFragment.b(this.jdField_a_of_type_ComTencentMobileqqOcrTranslateFragment, null);
    if ((this.jdField_a_of_type_ComTencentMobileqqOcrOCRPerformUtil$OCRLanHolder.c != null) && (this.jdField_a_of_type_ComTencentMobileqqOcrOCRPerformUtil$OCRLanHolder.c.size() > 1))
    {
      Drawable localDrawable = this.jdField_a_of_type_ComTencentMobileqqOcrTranslateFragment.getResources().getDrawable(2130846474);
      TranslateFragment.b(this.jdField_a_of_type_ComTencentMobileqqOcrTranslateFragment).setCompoundDrawablesWithIntrinsicBounds(null, null, null, localDrawable);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.ocr.TranslateFragment.5
 * JD-Core Version:    0.7.0.1
 */