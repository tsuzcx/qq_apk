package com.tencent.mobileqq.ocr;

import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.RelativeLayout;
import avvv;
import azqs;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.ocr.data.OcrRecogResult;
import com.tencent.mobileqq.widget.QQToast;

public class OCRResultActivity$11$1
  implements Runnable
{
  public OCRResultActivity$11$1(avvv paramavvv, int paramInt, OcrRecogResult paramOcrRecogResult) {}
  
  public void run()
  {
    OCRResultActivity.e(this.jdField_a_of_type_Avvv.a, false);
    OCRResultActivity.e(this.jdField_a_of_type_Avvv.a);
    OCRResultActivity.f(this.jdField_a_of_type_Avvv.a);
    if ((this.jdField_a_of_type_Int == 0) && (this.jdField_a_of_type_ComTencentMobileqqOcrDataOcrRecogResult != null) && (!this.jdField_a_of_type_ComTencentMobileqqOcrDataOcrRecogResult.isEmpty()))
    {
      OCRResultActivity.a(this.jdField_a_of_type_Avvv.a, this.jdField_a_of_type_ComTencentMobileqqOcrDataOcrRecogResult);
      if (OCRResultActivity.b(this.jdField_a_of_type_Avvv.a))
      {
        Animation localAnimation = AnimationUtils.loadAnimation(this.jdField_a_of_type_Avvv.a, 2130771997);
        this.jdField_a_of_type_Avvv.a.a.startAnimation(localAnimation);
      }
      if ((OCRResultActivity.c(this.jdField_a_of_type_Avvv.a) == 0) || (OCRResultActivity.c(this.jdField_a_of_type_Avvv.a) == 6)) {
        azqs.b(null, "dc00898", "", "", "0X800A9CF", "0X800A9CF", 0, 0, "", "0", "0", "");
      }
    }
    for (;;)
    {
      OCRResultActivity.c(this.jdField_a_of_type_Avvv.a, false);
      return;
      QQToast.a(BaseApplicationImpl.getContext(), 1, 2131699603, 0).a();
      if (OCRResultActivity.b(this.jdField_a_of_type_Avvv.a)) {
        this.jdField_a_of_type_Avvv.a.finish();
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.ocr.OCRResultActivity.11.1
 * JD-Core Version:    0.7.0.1
 */