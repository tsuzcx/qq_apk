package com.tencent.mobileqq.ocr;

import android.widget.LinearLayout;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.gallery.picocr.PicOcrRspResult;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.tfm.metrics.api.Metrics;
import com.tencent.tfm.metrics.api.MetricsApi;
import com.tencent.tfm.metrics.api.SuccessRateMeasure;
import java.util.ArrayList;

class OCRPerformFragment$6$1
  implements Runnable
{
  OCRPerformFragment$6$1(OCRPerformFragment.6 param6, boolean paramBoolean, PicOcrRspResult paramPicOcrRspResult) {}
  
  public void run()
  {
    int i;
    if ((this.jdField_a_of_type_Boolean) && (this.jdField_a_of_type_ComTencentMobileqqGalleryPicocrPicOcrRspResult.a != null) && (!this.jdField_a_of_type_ComTencentMobileqqGalleryPicocrPicOcrRspResult.a.isEmpty()))
    {
      i = 1;
      OCRPerformFragment.a(this.jdField_a_of_type_ComTencentMobileqqOcrOCRPerformFragment$6.a).setVisibility(0);
      OCRPerformFragment.a(this.jdField_a_of_type_ComTencentMobileqqOcrOCRPerformFragment$6.a).bringToFront();
      this.jdField_a_of_type_ComTencentMobileqqOcrOCRPerformFragment$6.a.a();
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
      OCRPerformFragment.a(this.jdField_a_of_type_ComTencentMobileqqOcrOCRPerformFragment$6.a, System.currentTimeMillis() - OCRPerformFragment.a(this.jdField_a_of_type_ComTencentMobileqqOcrOCRPerformFragment$6.a));
      if (OCRPerformFragment.a(this.jdField_a_of_type_ComTencentMobileqqOcrOCRPerformFragment$6.a) > 0L) {
        OCRPerformUtil.a("0X800AD16", (int)OCRPerformFragment.a(this.jdField_a_of_type_ComTencentMobileqqOcrOCRPerformFragment$6.a));
      }
      if (OCRPerformFragment.a(this.jdField_a_of_type_ComTencentMobileqqOcrOCRPerformFragment$6.a) <= 1) {
        OCRPerformUtil.a("0X800AD17", 0);
      }
      OCRPerformFragment.a(this.jdField_a_of_type_ComTencentMobileqqOcrOCRPerformFragment$6.a, this.jdField_a_of_type_ComTencentMobileqqGalleryPicocrPicOcrRspResult, true);
      return;
      i = 0;
      break;
      label208:
      ((SuccessRateMeasure)MetricsApi.getDefault().get("OCR_REQUEST", SuccessRateMeasure.class)).recordFail(new String[] { "requestOcr", "failure" });
    }
    label245:
    QQToast.a(BaseApplicationImpl.getContext(), 1, 2131698997, 0).a();
    OCRPerformUtil.a("0X800AD18", 0);
    this.jdField_a_of_type_ComTencentMobileqqOcrOCRPerformFragment$6.a.onBackEvent();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.ocr.OCRPerformFragment.6.1
 * JD-Core Version:    0.7.0.1
 */