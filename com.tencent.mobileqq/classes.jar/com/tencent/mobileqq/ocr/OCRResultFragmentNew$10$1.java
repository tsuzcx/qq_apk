package com.tencent.mobileqq.ocr;

import auqn;
import auqr;
import ayfi;
import aygb;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.tfm.metrics.api.Metrics;
import com.tencent.tfm.metrics.api.MetricsApi;
import com.tencent.tfm.metrics.api.SuccessRateMeasure;
import java.util.ArrayList;

public class OCRResultFragmentNew$10$1
  implements Runnable
{
  public OCRResultFragmentNew$10$1(aygb paramaygb, boolean paramBoolean, auqr paramauqr) {}
  
  public void run()
  {
    if ((this.jdField_a_of_type_Boolean) && (this.jdField_a_of_type_Auqr.jdField_a_of_type_JavaUtilArrayList != null) && (!this.jdField_a_of_type_Auqr.jdField_a_of_type_JavaUtilArrayList.isEmpty()))
    {
      ((SuccessRateMeasure)MetricsApi.getDefault().get(OCRPerformFragment.a, SuccessRateMeasure.class)).recordSuccess(new String[] { OCRPerformFragment.b, "success" });
      ayfi.b(ayfi.a(this.jdField_a_of_type_Auqr.jdField_a_of_type_JavaUtilArrayList));
      ayfi.a(ayfi.a.a, this.jdField_a_of_type_Auqr.b, this.jdField_a_of_type_Auqr.jdField_a_of_type_JavaUtilHashMap);
      OCRResultFragmentNew.a(this.jdField_a_of_type_Aygb.a, 0);
      return;
    }
    ((SuccessRateMeasure)MetricsApi.getDefault().get(OCRPerformFragment.a, SuccessRateMeasure.class)).recordFail(new String[] { OCRPerformFragment.b, "failure" });
    QQToast.a(OCRResultFragmentNew.a(this.jdField_a_of_type_Aygb.a), 1, 2131698132, 0).a();
    ayfi.a("0X800AD1B", 0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.ocr.OCRResultFragmentNew.10.1
 * JD-Core Version:    0.7.0.1
 */