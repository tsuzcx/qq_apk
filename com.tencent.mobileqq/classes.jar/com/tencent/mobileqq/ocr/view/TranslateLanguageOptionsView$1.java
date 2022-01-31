package com.tencent.mobileqq.ocr.view;

import android.widget.RadioButton;
import com.tencent.mobileqq.widget.BounceScrollView;
import com.tencent.qphone.base.util.QLog;

public final class TranslateLanguageOptionsView$1
  implements Runnable
{
  public TranslateLanguageOptionsView$1(RadioButton paramRadioButton, BounceScrollView paramBounceScrollView) {}
  
  public void run()
  {
    int i = this.jdField_a_of_type_AndroidWidgetRadioButton.getBottom() + this.jdField_a_of_type_AndroidWidgetRadioButton.getPaddingBottom() - this.jdField_a_of_type_ComTencentMobileqqWidgetBounceScrollView.getHeight();
    if (i > 0)
    {
      this.jdField_a_of_type_ComTencentMobileqqWidgetBounceScrollView.scrollBy(0, i);
      if (QLog.isColorLevel()) {
        QLog.d("TranslateLanguageOptionsView", 2, new Object[] { "compute detail, bottom:", Integer.valueOf(this.jdField_a_of_type_AndroidWidgetRadioButton.getBottom()), " padding:", Integer.valueOf(this.jdField_a_of_type_AndroidWidgetRadioButton.getPaddingBottom()), " viewHeight:", Integer.valueOf(this.jdField_a_of_type_ComTencentMobileqqWidgetBounceScrollView.getHeight()), " scrollHeight:", Integer.valueOf(i) });
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.ocr.view.TranslateLanguageOptionsView.1
 * JD-Core Version:    0.7.0.1
 */