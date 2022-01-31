package com.tencent.mobileqq.ocr;

import android.content.res.Resources;
import android.text.TextUtils;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.RelativeLayout;
import avwh;
import azqs;
import com.tencent.mobileqq.ocr.data.TranslateResult;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;

public class OCRResultActivity$9$1
  implements Runnable
{
  public OCRResultActivity$9$1(avwh paramavwh, boolean paramBoolean, int paramInt, TranslateResult paramTranslateResult) {}
  
  public void run()
  {
    if (QLog.isColorLevel()) {
      QLog.d("OCRResultActivity", 2, String.format("onGetTranslateResult isSuccess:%s, type:%s, result:%s", new Object[] { Boolean.valueOf(this.jdField_a_of_type_Boolean), Integer.valueOf(this.jdField_a_of_type_Int), this.jdField_a_of_type_ComTencentMobileqqOcrDataTranslateResult }));
    }
    if ((this.jdField_a_of_type_Int == 2) && (this.jdField_a_of_type_ComTencentMobileqqOcrDataTranslateResult != null) && (!this.jdField_a_of_type_ComTencentMobileqqOcrDataTranslateResult.a(OCRResultActivity.a(this.jdField_a_of_type_Avwh.a)))) {
      return;
    }
    OCRResultActivity.e(this.jdField_a_of_type_Avwh.a);
    OCRResultActivity.f(this.jdField_a_of_type_Avwh.a);
    OCRResultActivity.b(this.jdField_a_of_type_Avwh.a, false);
    OCRResultActivity.b(this.jdField_a_of_type_Avwh.a);
    if ((this.jdField_a_of_type_Boolean) && (this.jdField_a_of_type_ComTencentMobileqqOcrDataTranslateResult != null) && (this.jdField_a_of_type_ComTencentMobileqqOcrDataTranslateResult.b()) && (!this.jdField_a_of_type_ComTencentMobileqqOcrDataTranslateResult.a()))
    {
      OCRResultActivity.a(this.jdField_a_of_type_Avwh.a, this.jdField_a_of_type_ComTencentMobileqqOcrDataTranslateResult);
      if (OCRResultActivity.b(this.jdField_a_of_type_Avwh.a))
      {
        localObject = AnimationUtils.loadAnimation(this.jdField_a_of_type_Avwh.a, 2130771997);
        this.jdField_a_of_type_Avwh.a.a.startAnimation((Animation)localObject);
      }
      if (OCRResultActivity.b(this.jdField_a_of_type_Avwh.a) == 1) {
        azqs.b(null, "dc00898", "", "", "0X8009C81", "0X8009C81", 0, 0, "", "0", "0", "");
      }
      for (;;)
      {
        OCRResultActivity.c(this.jdField_a_of_type_Avwh.a, false);
        return;
        azqs.b(null, "dc00898", "", "", "0X8009C8A", "0X8009C8A", 0, 0, "", "0", "0", "");
      }
    }
    String str = this.jdField_a_of_type_Avwh.a.getResources().getString(2131699624);
    Object localObject = str;
    if (this.jdField_a_of_type_ComTencentMobileqqOcrDataTranslateResult != null)
    {
      if (TextUtils.isEmpty(this.jdField_a_of_type_ComTencentMobileqqOcrDataTranslateResult.e)) {
        break label381;
      }
      localObject = this.jdField_a_of_type_ComTencentMobileqqOcrDataTranslateResult.e;
    }
    for (;;)
    {
      QQToast.a(this.jdField_a_of_type_Avwh.a, 1, (CharSequence)localObject, 0).a();
      if (!OCRResultActivity.b(this.jdField_a_of_type_Avwh.a)) {
        break;
      }
      this.jdField_a_of_type_Avwh.a.finish();
      break;
      label381:
      localObject = str;
      if (this.jdField_a_of_type_ComTencentMobileqqOcrDataTranslateResult.a()) {
        localObject = this.jdField_a_of_type_Avwh.a.getResources().getString(2131699603);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.ocr.OCRResultActivity.9.1
 * JD-Core Version:    0.7.0.1
 */