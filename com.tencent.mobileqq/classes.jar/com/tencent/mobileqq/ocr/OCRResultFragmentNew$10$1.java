package com.tencent.mobileqq.ocr;

import com.tencent.mobileqq.gallery.picocr.PicOcrRspResult;
import com.tencent.mobileqq.ocr.req.OCRReqContext;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.tfm.metrics.api.Metrics;
import com.tencent.tfm.metrics.api.MetricsApi;
import com.tencent.tfm.metrics.api.SuccessRateMeasure;
import java.util.ArrayList;

class OCRResultFragmentNew$10$1
  implements Runnable
{
  OCRResultFragmentNew$10$1(OCRResultFragmentNew.10 param10, boolean paramBoolean, PicOcrRspResult paramPicOcrRspResult) {}
  
  public void run()
  {
    if ((this.jdField_a_of_type_Boolean) && (this.jdField_a_of_type_ComTencentMobileqqGalleryPicocrPicOcrRspResult.jdField_a_of_type_JavaUtilArrayList != null) && (!this.jdField_a_of_type_ComTencentMobileqqGalleryPicocrPicOcrRspResult.jdField_a_of_type_JavaUtilArrayList.isEmpty()))
    {
      ((SuccessRateMeasure)MetricsApi.getDefault().get("OCR_REQUEST", SuccessRateMeasure.class)).recordSuccess(new String[] { "requestOcr", "success" });
      OCRPerformUtil.jdField_b_of_type_JavaLangCharSequence = OCRPerformUtil.a(this.jdField_a_of_type_ComTencentMobileqqGalleryPicocrPicOcrRspResult.jdField_a_of_type_JavaUtilArrayList);
      OCRPerformUtil.jdField_b_of_type_ComTencentMobileqqOcrOCRPerformUtil$OCRLanHolder = OCRPerformUtil.a(OCRPerformUtil.jdField_b_of_type_ComTencentMobileqqOcrOCRPerformUtil$OCRLanHolder, OCRPerformUtil.a.a, this.jdField_a_of_type_ComTencentMobileqqGalleryPicocrPicOcrRspResult.b, this.jdField_a_of_type_ComTencentMobileqqGalleryPicocrPicOcrRspResult.jdField_a_of_type_JavaUtilHashMap);
      OCRResultFragmentNew.a(this.jdField_a_of_type_ComTencentMobileqqOcrOCRResultFragmentNew$10.a, 0);
      return;
    }
    ((SuccessRateMeasure)MetricsApi.getDefault().get("OCR_REQUEST", SuccessRateMeasure.class)).recordFail(new String[] { "requestOcr", "failure" });
    QQToast.a(OCRResultFragmentNew.a(this.jdField_a_of_type_ComTencentMobileqqOcrOCRResultFragmentNew$10.a), 1, 2131699075, 0).a();
    OCRPerformUtil.a("0X800AD1B", 0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.ocr.OCRResultFragmentNew.10.1
 * JD-Core Version:    0.7.0.1
 */