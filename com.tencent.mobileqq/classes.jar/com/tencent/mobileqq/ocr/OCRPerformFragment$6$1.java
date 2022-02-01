package com.tencent.mobileqq.ocr;

import android.widget.LinearLayout;
import com.tencent.mobileqq.gallery.picocr.PicOcrRspResult;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.tfm.metrics.api.Metrics;
import com.tencent.tfm.metrics.api.MetricsApi;
import com.tencent.tfm.metrics.api.SuccessRateMeasure;
import java.util.ArrayList;
import mqq.app.MobileQQ;

class OCRPerformFragment$6$1
  implements Runnable
{
  OCRPerformFragment$6$1(OCRPerformFragment.6 param6, boolean paramBoolean, PicOcrRspResult paramPicOcrRspResult) {}
  
  public void run()
  {
    int i;
    if ((this.a) && (this.b.f != null) && (!this.b.f.isEmpty())) {
      i = 1;
    } else {
      i = 0;
    }
    OCRPerformFragment.h(this.c.a).setVisibility(0);
    OCRPerformFragment.h(this.c.a).bringToFront();
    this.c.a.a();
    if (i != 0) {
      ((SuccessRateMeasure)MetricsApi.getDefault().get("OCR_REQUEST", SuccessRateMeasure.class)).recordSuccess(new String[] { "requestOcr", "success" });
    } else {
      ((SuccessRateMeasure)MetricsApi.getDefault().get("OCR_REQUEST", SuccessRateMeasure.class)).recordFail(new String[] { "requestOcr", "failure" });
    }
    if (i != 0)
    {
      OCRPerformFragment.a(this.c.a, System.currentTimeMillis() - OCRPerformFragment.i(this.c.a));
      if (OCRPerformFragment.i(this.c.a) > 0L) {
        OCRPerformUtil.a("0X800AD16", (int)OCRPerformFragment.i(this.c.a));
      }
      OCRPerformFragment.a(this.c.a, 0);
      OCRPerformFragment.b(this.c.a, OCRPerformFragment.i(this.c.a));
      if (OCRPerformFragment.j(this.c.a) <= 1) {
        OCRPerformUtil.a("0X800AD17", 0);
      }
      OCRPerformFragment.a(this.c.a, this.b, true);
      return;
    }
    QQToast.makeText(MobileQQ.sMobileQQ, 1, 2131897084, 0).show();
    OCRPerformUtil.a("0X800AD18", 0);
    this.c.a.onBackEvent();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.ocr.OCRPerformFragment.6.1
 * JD-Core Version:    0.7.0.1
 */