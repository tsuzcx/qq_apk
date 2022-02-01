package com.tencent.mobileqq.ocr;

import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.RelativeLayout;
import ayrx;
import bdla;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.ocr.data.OcrRecogResult;
import com.tencent.mobileqq.widget.QQToast;

public class OCRResultActivity$11$1
  implements Runnable
{
  public OCRResultActivity$11$1(ayrx paramayrx, int paramInt, OcrRecogResult paramOcrRecogResult) {}
  
  public void run()
  {
    OCRResultActivity.e(this.jdField_a_of_type_Ayrx.a, false);
    OCRResultActivity.e(this.jdField_a_of_type_Ayrx.a);
    OCRResultActivity.f(this.jdField_a_of_type_Ayrx.a);
    if ((this.jdField_a_of_type_Int == 0) && (this.jdField_a_of_type_ComTencentMobileqqOcrDataOcrRecogResult != null) && (!this.jdField_a_of_type_ComTencentMobileqqOcrDataOcrRecogResult.isEmpty()))
    {
      OCRResultActivity.a(this.jdField_a_of_type_Ayrx.a, this.jdField_a_of_type_ComTencentMobileqqOcrDataOcrRecogResult);
      if (OCRResultActivity.b(this.jdField_a_of_type_Ayrx.a))
      {
        Animation localAnimation = AnimationUtils.loadAnimation(this.jdField_a_of_type_Ayrx.a, 2130771997);
        this.jdField_a_of_type_Ayrx.a.a.startAnimation(localAnimation);
      }
      if ((OCRResultActivity.c(this.jdField_a_of_type_Ayrx.a) == 0) || (OCRResultActivity.c(this.jdField_a_of_type_Ayrx.a) == 6)) {
        bdla.b(null, "dc00898", "", "", "0X800A9CF", "0X800A9CF", 0, 0, "", "0", "0", "");
      }
    }
    for (;;)
    {
      OCRResultActivity.c(this.jdField_a_of_type_Ayrx.a, false);
      return;
      QQToast.a(BaseApplicationImpl.getContext(), 1, 2131698694, 0).a();
      if (OCRResultActivity.b(this.jdField_a_of_type_Ayrx.a)) {
        this.jdField_a_of_type_Ayrx.a.finish();
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.ocr.OCRResultActivity.11.1
 * JD-Core Version:    0.7.0.1
 */