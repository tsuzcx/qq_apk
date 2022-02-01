package com.tencent.mobileqq.ocr;

import android.widget.LinearLayout;
import avaw;
import ayrp;
import ayrt;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.tfm.metrics.api.Metrics;
import com.tencent.tfm.metrics.api.MetricsApi;
import com.tencent.tfm.metrics.api.SuccessRateMeasure;
import java.util.ArrayList;

public class OCRPerformFragment$6$1
  implements Runnable
{
  public OCRPerformFragment$6$1(ayrp paramayrp, boolean paramBoolean, avaw paramavaw) {}
  
  public void run()
  {
    int i;
    if ((this.jdField_a_of_type_Boolean) && (this.jdField_a_of_type_Avaw.a != null) && (!this.jdField_a_of_type_Avaw.a.isEmpty()))
    {
      i = 1;
      OCRPerformFragment.a(this.jdField_a_of_type_Ayrp.a).setVisibility(0);
      OCRPerformFragment.a(this.jdField_a_of_type_Ayrp.a).bringToFront();
      this.jdField_a_of_type_Ayrp.a.a();
      if (i == 0) {
        break label208;
      }
      ((SuccessRateMeasure)MetricsApi.getDefault().get("OCR_REQUEST", SuccessRateMeasure.class)).recordSuccess(new String[] { "requestOcr", "success" });
    }
    for (;;)
    {
      if (i == 0) {
        break label245;
      }
      OCRPerformFragment.a(this.jdField_a_of_type_Ayrp.a, System.currentTimeMillis() - OCRPerformFragment.a(this.jdField_a_of_type_Ayrp.a));
      if (OCRPerformFragment.a(this.jdField_a_of_type_Ayrp.a) > 0L) {
        ayrt.a("0X800AD16", (int)OCRPerformFragment.a(this.jdField_a_of_type_Ayrp.a));
      }
      if (OCRPerformFragment.a(this.jdField_a_of_type_Ayrp.a) <= 1) {
        ayrt.a("0X800AD17", 0);
      }
      OCRPerformFragment.a(this.jdField_a_of_type_Ayrp.a, this.jdField_a_of_type_Avaw, true);
      return;
      i = 0;
      break;
      label208:
      ((SuccessRateMeasure)MetricsApi.getDefault().get("OCR_REQUEST", SuccessRateMeasure.class)).recordFail(new String[] { "requestOcr", "failure" });
    }
    label245:
    QQToast.a(BaseApplicationImpl.getContext(), 1, 2131698694, 0).a();
    ayrt.a("0X800AD18", 0);
    this.jdField_a_of_type_Ayrp.a.onBackEvent();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.ocr.OCRPerformFragment.6.1
 * JD-Core Version:    0.7.0.1
 */