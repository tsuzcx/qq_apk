package com.tencent.mobileqq.ocr;

import android.content.res.Resources;
import android.text.TextUtils;
import com.tencent.mobileqq.ocr.data.TranslateResult;
import com.tencent.mobileqq.widget.QQToast;

class TranslateFragment$1$1
  implements Runnable
{
  TranslateFragment$1$1(TranslateFragment.1 param1, boolean paramBoolean, TranslateResult paramTranslateResult) {}
  
  public void run()
  {
    TranslateFragment.a(this.jdField_a_of_type_ComTencentMobileqqOcrTranslateFragment$1.a, false);
    TranslateFragment.a(this.jdField_a_of_type_ComTencentMobileqqOcrTranslateFragment$1.a);
    if ((this.jdField_a_of_type_Boolean) && (this.jdField_a_of_type_ComTencentMobileqqOcrDataTranslateResult != null) && (this.jdField_a_of_type_ComTencentMobileqqOcrDataTranslateResult.b()) && (!this.jdField_a_of_type_ComTencentMobileqqOcrDataTranslateResult.a()))
    {
      TranslateFragment.a(this.jdField_a_of_type_ComTencentMobileqqOcrTranslateFragment$1.a, this.jdField_a_of_type_ComTencentMobileqqOcrDataTranslateResult);
      TranslateFragment.a(this.jdField_a_of_type_ComTencentMobileqqOcrTranslateFragment$1.a, 2, this.jdField_a_of_type_ComTencentMobileqqOcrDataTranslateResult);
      return;
    }
    String str2 = this.jdField_a_of_type_ComTencentMobileqqOcrTranslateFragment$1.a.getResources().getString(2131699010);
    String str1 = str2;
    if (this.jdField_a_of_type_ComTencentMobileqqOcrDataTranslateResult != null)
    {
      if (TextUtils.isEmpty(this.jdField_a_of_type_ComTencentMobileqqOcrDataTranslateResult.e)) {
        break label154;
      }
      str1 = this.jdField_a_of_type_ComTencentMobileqqOcrDataTranslateResult.e;
    }
    for (;;)
    {
      QQToast.a(TranslateFragment.a(this.jdField_a_of_type_ComTencentMobileqqOcrTranslateFragment$1.a), 1, str1, 0).a();
      return;
      label154:
      str1 = str2;
      if (this.jdField_a_of_type_ComTencentMobileqqOcrDataTranslateResult.a()) {
        str1 = this.jdField_a_of_type_ComTencentMobileqqOcrTranslateFragment$1.a.getResources().getString(2131698997);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.ocr.TranslateFragment.1.1
 * JD-Core Version:    0.7.0.1
 */