package com.tencent.mobileqq.ocr;

import android.content.res.Resources;
import android.text.TextUtils;
import ayti;
import com.tencent.mobileqq.ocr.data.TranslateResult;
import com.tencent.mobileqq.widget.QQToast;

public class TranslateFragment$1$1
  implements Runnable
{
  public TranslateFragment$1$1(ayti paramayti, boolean paramBoolean, TranslateResult paramTranslateResult) {}
  
  public void run()
  {
    TranslateFragment.a(this.jdField_a_of_type_Ayti.a, false);
    TranslateFragment.a(this.jdField_a_of_type_Ayti.a);
    if ((this.jdField_a_of_type_Boolean) && (this.jdField_a_of_type_ComTencentMobileqqOcrDataTranslateResult != null) && (this.jdField_a_of_type_ComTencentMobileqqOcrDataTranslateResult.b()) && (!this.jdField_a_of_type_ComTencentMobileqqOcrDataTranslateResult.a()))
    {
      TranslateFragment.a(this.jdField_a_of_type_Ayti.a, this.jdField_a_of_type_ComTencentMobileqqOcrDataTranslateResult);
      TranslateFragment.a(this.jdField_a_of_type_Ayti.a, 2, this.jdField_a_of_type_ComTencentMobileqqOcrDataTranslateResult);
      return;
    }
    String str2 = this.jdField_a_of_type_Ayti.a.getResources().getString(2131698707);
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
      QQToast.a(TranslateFragment.a(this.jdField_a_of_type_Ayti.a), 1, str1, 0).a();
      return;
      label154:
      str1 = str2;
      if (this.jdField_a_of_type_ComTencentMobileqqOcrDataTranslateResult.a()) {
        str1 = this.jdField_a_of_type_Ayti.a.getResources().getString(2131698694);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.ocr.TranslateFragment.1.1
 * JD-Core Version:    0.7.0.1
 */