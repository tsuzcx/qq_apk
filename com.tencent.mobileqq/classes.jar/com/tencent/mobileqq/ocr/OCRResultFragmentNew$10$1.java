package com.tencent.mobileqq.ocr;

import atvt;
import atvx;
import axlj;
import axmc;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.tfm.metrics.api.Metrics;
import com.tencent.tfm.metrics.api.MetricsApi;
import com.tencent.tfm.metrics.api.SuccessRateMeasure;
import java.util.ArrayList;

public class OCRResultFragmentNew$10$1
  implements Runnable
{
  public OCRResultFragmentNew$10$1(axmc paramaxmc, boolean paramBoolean, atvx paramatvx) {}
  
  public void run()
  {
    if ((this.jdField_a_of_type_Boolean) && (this.jdField_a_of_type_Atvx.jdField_a_of_type_JavaUtilArrayList != null) && (!this.jdField_a_of_type_Atvx.jdField_a_of_type_JavaUtilArrayList.isEmpty()))
    {
      ((SuccessRateMeasure)MetricsApi.getDefault().get(OCRPerformFragment.a, SuccessRateMeasure.class)).recordSuccess(new String[] { OCRPerformFragment.b, "success" });
      axlj.b(axlj.a(this.jdField_a_of_type_Atvx.jdField_a_of_type_JavaUtilArrayList));
      axlj.a(axlj.a.a, this.jdField_a_of_type_Atvx.b, this.jdField_a_of_type_Atvx.jdField_a_of_type_JavaUtilHashMap);
      OCRResultFragmentNew.a(this.jdField_a_of_type_Axmc.a, 0);
      return;
    }
    ((SuccessRateMeasure)MetricsApi.getDefault().get(OCRPerformFragment.a, SuccessRateMeasure.class)).recordFail(new String[] { OCRPerformFragment.b, "failure" });
    QQToast.a(OCRResultFragmentNew.a(this.jdField_a_of_type_Axmc.a), 1, 2131698398, 0).a();
    axlj.a("0X800AD1B", 0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.ocr.OCRResultFragmentNew.10.1
 * JD-Core Version:    0.7.0.1
 */