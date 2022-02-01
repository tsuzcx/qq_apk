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
    if (this.jdField_a_of_type_Boolean)
    {
      localObject = this.jdField_a_of_type_ComTencentMobileqqOcrDataTranslateResult;
      if ((localObject != null) && (((TranslateResult)localObject).b()) && (!this.jdField_a_of_type_ComTencentMobileqqOcrDataTranslateResult.a()))
      {
        TranslateFragment.a(this.jdField_a_of_type_ComTencentMobileqqOcrTranslateFragment$1.a, this.jdField_a_of_type_ComTencentMobileqqOcrDataTranslateResult);
        TranslateFragment.a(this.jdField_a_of_type_ComTencentMobileqqOcrTranslateFragment$1.a, 2, this.jdField_a_of_type_ComTencentMobileqqOcrDataTranslateResult);
        return;
      }
    }
    String str = this.jdField_a_of_type_ComTencentMobileqqOcrTranslateFragment$1.a.getResources().getString(2131699088);
    TranslateResult localTranslateResult = this.jdField_a_of_type_ComTencentMobileqqOcrDataTranslateResult;
    Object localObject = str;
    if (localTranslateResult != null) {
      if (!TextUtils.isEmpty(localTranslateResult.e))
      {
        localObject = this.jdField_a_of_type_ComTencentMobileqqOcrDataTranslateResult.e;
      }
      else
      {
        localObject = str;
        if (this.jdField_a_of_type_ComTencentMobileqqOcrDataTranslateResult.a()) {
          localObject = this.jdField_a_of_type_ComTencentMobileqqOcrTranslateFragment$1.a.getResources().getString(2131699075);
        }
      }
    }
    QQToast.a(TranslateFragment.a(this.jdField_a_of_type_ComTencentMobileqqOcrTranslateFragment$1.a), 1, (CharSequence)localObject, 0).a();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.ocr.TranslateFragment.1.1
 * JD-Core Version:    0.7.0.1
 */