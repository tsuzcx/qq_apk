package com.tencent.mobileqq.ocr;

import com.tencent.mobileqq.app.QBaseActivity;
import com.tencent.mobileqq.ocr.data.TranslateResult;
import com.tencent.mobileqq.statistics.StatisticCollector;
import com.tencent.qphone.base.util.QLog;
import java.util.HashMap;

class TranslateFragment$1
  extends OCRObserver
{
  TranslateFragment$1(TranslateFragment paramTranslateFragment) {}
  
  public void a(boolean paramBoolean, int paramInt, TranslateResult paramTranslateResult)
  {
    if (!TranslateFragment.a(this.a)) {
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.d("TranslateFragment", 2, String.format("onGetTranslateResult isSuccess:%s, type:%s, result:%s", new Object[] { Boolean.valueOf(paramBoolean), Integer.valueOf(paramInt), paramTranslateResult }));
    }
    TranslateFragment.a(this.a).runOnUiThread(new TranslateFragment.1.1(this, paramBoolean, paramTranslateResult));
    HashMap localHashMap = new HashMap();
    int i;
    if (paramTranslateResult != null) {
      i = paramTranslateResult.b;
    } else {
      i = 2000;
    }
    localHashMap.put("errCode", String.valueOf(i));
    localHashMap.put("type", String.valueOf(paramInt));
    StatisticCollector.getInstance(TranslateFragment.a(this.a)).collectPerformance("", "SCAN_TRANSLATE_RESULT", paramBoolean, 0L, 0L, localHashMap, "", false);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.ocr.TranslateFragment.1
 * JD-Core Version:    0.7.0.1
 */