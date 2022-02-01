package com.tencent.mobileqq.ocr;

import avin;
import avir;
import ayyb;
import ayyu;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.tfm.metrics.api.Metrics;
import com.tencent.tfm.metrics.api.MetricsApi;
import com.tencent.tfm.metrics.api.SuccessRateMeasure;
import java.util.ArrayList;

public class OCRResultFragmentNew$10$1
  implements Runnable
{
  public OCRResultFragmentNew$10$1(ayyu paramayyu, boolean paramBoolean, avir paramavir) {}
  
  public void run()
  {
    if ((this.jdField_a_of_type_Boolean) && (this.jdField_a_of_type_Avir.jdField_a_of_type_JavaUtilArrayList != null) && (!this.jdField_a_of_type_Avir.jdField_a_of_type_JavaUtilArrayList.isEmpty()))
    {
      ((SuccessRateMeasure)MetricsApi.getDefault().get(OCRPerformFragment.a, SuccessRateMeasure.class)).recordSuccess(new String[] { OCRPerformFragment.b, "success" });
      ayyb.b(ayyb.a(this.jdField_a_of_type_Avir.jdField_a_of_type_JavaUtilArrayList));
      ayyb.a(ayyb.a.a, this.jdField_a_of_type_Avir.b, this.jdField_a_of_type_Avir.jdField_a_of_type_JavaUtilHashMap);
      OCRResultFragmentNew.a(this.jdField_a_of_type_Ayyu.a, 0);
      return;
    }
    ((SuccessRateMeasure)MetricsApi.getDefault().get(OCRPerformFragment.a, SuccessRateMeasure.class)).recordFail(new String[] { OCRPerformFragment.b, "failure" });
    QQToast.a(OCRResultFragmentNew.a(this.jdField_a_of_type_Ayyu.a), 1, 2131698233, 0).a();
    ayyb.a("0X800AD1B", 0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.ocr.OCRResultFragmentNew.10.1
 * JD-Core Version:    0.7.0.1
 */