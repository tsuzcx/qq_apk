package com.tencent.mobileqq.ocr;

import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.widget.PopupWindow.OnDismissListener;
import android.widget.TextView;
import java.util.List;

class TranslateFragment$3
  implements PopupWindow.OnDismissListener
{
  TranslateFragment$3(TranslateFragment paramTranslateFragment, OCRPerformUtil.OCRLanHolder paramOCRLanHolder) {}
  
  public void onDismiss()
  {
    TranslateFragment.a(this.jdField_a_of_type_ComTencentMobileqqOcrTranslateFragment, null);
    if ((this.jdField_a_of_type_ComTencentMobileqqOcrOCRPerformUtil$OCRLanHolder.b != null) && (this.jdField_a_of_type_ComTencentMobileqqOcrOCRPerformUtil$OCRLanHolder.b.size() > 1))
    {
      Drawable localDrawable = this.jdField_a_of_type_ComTencentMobileqqOcrTranslateFragment.getResources().getDrawable(2130846474);
      TranslateFragment.a(this.jdField_a_of_type_ComTencentMobileqqOcrTranslateFragment).setCompoundDrawablesWithIntrinsicBounds(null, null, null, localDrawable);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.ocr.TranslateFragment.3
 * JD-Core Version:    0.7.0.1
 */