package com.tencent.mobileqq.ocr;

import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.RelativeLayout;
import atdu;
import bbmy;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.ocr.data.OcrRecogResult;

public class OCRResultActivity$11$1
  implements Runnable
{
  public OCRResultActivity$11$1(atdu paramatdu, int paramInt, OcrRecogResult paramOcrRecogResult) {}
  
  public void run()
  {
    OCRResultActivity.e(this.jdField_a_of_type_Atdu.a, false);
    OCRResultActivity.e(this.jdField_a_of_type_Atdu.a);
    OCRResultActivity.f(this.jdField_a_of_type_Atdu.a);
    if ((this.jdField_a_of_type_Int == 0) && (this.jdField_a_of_type_ComTencentMobileqqOcrDataOcrRecogResult != null) && (!this.jdField_a_of_type_ComTencentMobileqqOcrDataOcrRecogResult.isEmpty()))
    {
      OCRResultActivity.a(this.jdField_a_of_type_Atdu.a, this.jdField_a_of_type_ComTencentMobileqqOcrDataOcrRecogResult);
      if (OCRResultActivity.b(this.jdField_a_of_type_Atdu.a))
      {
        Animation localAnimation = AnimationUtils.loadAnimation(this.jdField_a_of_type_Atdu.a, 2130771997);
        this.jdField_a_of_type_Atdu.a.a.startAnimation(localAnimation);
      }
    }
    for (;;)
    {
      OCRResultActivity.c(this.jdField_a_of_type_Atdu.a, false);
      return;
      bbmy.a(BaseApplicationImpl.getContext(), 1, 2131633481, 0).a();
      if (OCRResultActivity.b(this.jdField_a_of_type_Atdu.a)) {
        this.jdField_a_of_type_Atdu.a.finish();
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.ocr.OCRResultActivity.11.1
 * JD-Core Version:    0.7.0.1
 */