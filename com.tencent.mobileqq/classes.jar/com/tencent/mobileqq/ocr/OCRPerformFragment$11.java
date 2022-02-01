package com.tencent.mobileqq.ocr;

import com.tencent.mobileqq.app.QBaseActivity;
import com.tencent.mobileqq.ocr.data.TranslateResult;
import com.tencent.mobileqq.statistics.StatisticCollector;
import com.tencent.qphone.base.util.QLog;
import java.util.HashMap;
import mqq.app.MobileQQ;

class OCRPerformFragment$11
  extends OCRObserver
{
  OCRPerformFragment$11(OCRPerformFragment paramOCRPerformFragment) {}
  
  public void a(boolean paramBoolean, int paramInt, TranslateResult paramTranslateResult)
  {
    if (!OCRPerformFragment.g(this.a)) {
      return;
    }
    OCRPerformFragment.a(this.a, false);
    if (QLog.isColorLevel()) {
      QLog.d("OCRPerformFragment", 2, String.format("onGetTranslateResult isSuccess:%s, type:%s, result:%s", new Object[] { Boolean.valueOf(paramBoolean), Integer.valueOf(paramInt), paramTranslateResult }));
    }
    OCRPerformFragment.a(this.a).runOnUiThread(new OCRPerformFragment.11.1(this, paramBoolean, paramTranslateResult));
    HashMap localHashMap = new HashMap();
    int i;
    if (paramTranslateResult != null) {
      i = paramTranslateResult.h;
    } else {
      i = 2000;
    }
    localHashMap.put("errCode", String.valueOf(i));
    localHashMap.put("type", String.valueOf(paramInt));
    StatisticCollector.getInstance(MobileQQ.sMobileQQ).collectPerformance("", "SCAN_TRANSLATE_RESULT", paramBoolean, 0L, 0L, localHashMap, "", false);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.ocr.OCRPerformFragment.11
 * JD-Core Version:    0.7.0.1
 */