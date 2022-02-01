package com.tencent.mobileqq.ocr;

import avat;
import avaw;
import ayrt;
import aysl;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.tfm.metrics.api.Metrics;
import com.tencent.tfm.metrics.api.MetricsApi;
import com.tencent.tfm.metrics.api.SuccessRateMeasure;
import java.util.ArrayList;

public class OCRResultFragmentNew$10$1
  implements Runnable
{
  public OCRResultFragmentNew$10$1(aysl paramaysl, boolean paramBoolean, avaw paramavaw) {}
  
  public void run()
  {
    if ((this.jdField_a_of_type_Boolean) && (this.jdField_a_of_type_Avaw.jdField_a_of_type_JavaUtilArrayList != null) && (!this.jdField_a_of_type_Avaw.jdField_a_of_type_JavaUtilArrayList.isEmpty()))
    {
      ((SuccessRateMeasure)MetricsApi.getDefault().get("OCR_REQUEST", SuccessRateMeasure.class)).recordSuccess(new String[] { "requestOcr", "success" });
      ayrt.jdField_b_of_type_JavaLangCharSequence = ayrt.a(this.jdField_a_of_type_Avaw.jdField_a_of_type_JavaUtilArrayList);
      ayrt.jdField_b_of_type_Ayru = ayrt.a(ayrt.jdField_b_of_type_Ayru, ayrt.a.a, this.jdField_a_of_type_Avaw.b, this.jdField_a_of_type_Avaw.jdField_a_of_type_JavaUtilHashMap);
      OCRResultFragmentNew.a(this.jdField_a_of_type_Aysl.a, 0);
      return;
    }
    ((SuccessRateMeasure)MetricsApi.getDefault().get("OCR_REQUEST", SuccessRateMeasure.class)).recordFail(new String[] { "requestOcr", "failure" });
    QQToast.a(OCRResultFragmentNew.a(this.jdField_a_of_type_Aysl.a), 1, 2131698694, 0).a();
    ayrt.a("0X800AD1B", 0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.ocr.OCRResultFragmentNew.10.1
 * JD-Core Version:    0.7.0.1
 */