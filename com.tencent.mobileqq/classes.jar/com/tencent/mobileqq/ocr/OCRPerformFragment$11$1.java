package com.tencent.mobileqq.ocr;

import android.content.res.Resources;
import android.text.TextUtils;
import ayrl;
import ayrt;
import com.tencent.mobileqq.ocr.data.TranslateResult;
import com.tencent.mobileqq.widget.QQToast;

public class OCRPerformFragment$11$1
  implements Runnable
{
  public OCRPerformFragment$11$1(ayrl paramayrl, boolean paramBoolean, TranslateResult paramTranslateResult) {}
  
  public void run()
  {
    OCRPerformFragment.a(this.jdField_a_of_type_Ayrl.a, true);
    if ((this.jdField_a_of_type_Boolean) && (this.jdField_a_of_type_ComTencentMobileqqOcrDataTranslateResult != null) && (this.jdField_a_of_type_ComTencentMobileqqOcrDataTranslateResult.b()) && (!this.jdField_a_of_type_ComTencentMobileqqOcrDataTranslateResult.a()))
    {
      ayrt.jdField_a_of_type_ComTencentMobileqqOcrDataTranslateResult = this.jdField_a_of_type_ComTencentMobileqqOcrDataTranslateResult;
      OCRPerformFragment.a(this.jdField_a_of_type_Ayrl.a, this.jdField_a_of_type_ComTencentMobileqqOcrDataTranslateResult);
      return;
    }
    String str2 = this.jdField_a_of_type_Ayrl.a.getResources().getString(2131698707);
    String str1 = str2;
    if (this.jdField_a_of_type_ComTencentMobileqqOcrDataTranslateResult != null)
    {
      if (TextUtils.isEmpty(this.jdField_a_of_type_ComTencentMobileqqOcrDataTranslateResult.e)) {
        break label140;
      }
      str1 = this.jdField_a_of_type_ComTencentMobileqqOcrDataTranslateResult.e;
    }
    for (;;)
    {
      QQToast.a(OCRPerformFragment.a(this.jdField_a_of_type_Ayrl.a), 1, str1, 0).a();
      ayrt.a("0X800B558", 0);
      return;
      label140:
      str1 = str2;
      if (this.jdField_a_of_type_ComTencentMobileqqOcrDataTranslateResult.a()) {
        str1 = this.jdField_a_of_type_Ayrl.a.getResources().getString(2131698694);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.ocr.OCRPerformFragment.11.1
 * JD-Core Version:    0.7.0.1
 */