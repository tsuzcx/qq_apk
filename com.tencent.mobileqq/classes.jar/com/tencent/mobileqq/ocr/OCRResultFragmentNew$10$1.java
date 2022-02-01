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
    if ((this.a) && (this.b.f != null) && (!this.b.f.isEmpty()))
    {
      ((SuccessRateMeasure)MetricsApi.getDefault().get("OCR_REQUEST", SuccessRateMeasure.class)).recordSuccess(new String[] { "requestOcr", "success" });
      OCRPerformUtil.f = OCRPerformUtil.a(this.b.f);
      OCRPerformUtil.d = OCRPerformUtil.a(OCRPerformUtil.d, OCRPerformUtil.b.a, this.b.g, this.b.h);
      OCRResultFragmentNew.b(this.c.a, 0);
      return;
    }
    ((SuccessRateMeasure)MetricsApi.getDefault().get("OCR_REQUEST", SuccessRateMeasure.class)).recordFail(new String[] { "requestOcr", "failure" });
    QQToast.makeText(OCRResultFragmentNew.a(this.c.a), 1, 2131897084, 0).show();
    OCRPerformUtil.a("0X800AD1B", 0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.ocr.OCRResultFragmentNew.10.1
 * JD-Core Version:    0.7.0.1
 */