package com.tencent.mobileqq.ocr;

import android.content.res.Resources;
import android.text.TextUtils;
import com.tencent.mobileqq.ocr.data.TranslateResult;
import com.tencent.mobileqq.widget.QQToast;

class OCRPerformFragment$11$1
  implements Runnable
{
  OCRPerformFragment$11$1(OCRPerformFragment.11 param11, boolean paramBoolean, TranslateResult paramTranslateResult) {}
  
  public void run()
  {
    OCRPerformFragment.b(this.c.a, true);
    if (this.a)
    {
      localObject = this.b;
      if ((localObject != null) && (((TranslateResult)localObject).g()) && (!this.b.f()))
      {
        OCRPerformUtil.h = this.b;
        OCRPerformFragment.a(this.c.a, this.b);
        return;
      }
    }
    String str = this.c.a.getResources().getString(2131897097);
    TranslateResult localTranslateResult = this.b;
    Object localObject = str;
    if (localTranslateResult != null) {
      if (!TextUtils.isEmpty(localTranslateResult.i))
      {
        localObject = this.b.i;
      }
      else
      {
        localObject = str;
        if (this.b.f()) {
          localObject = this.c.a.getResources().getString(2131897084);
        }
      }
    }
    QQToast.makeText(OCRPerformFragment.a(this.c.a), 1, (CharSequence)localObject, 0).show();
    OCRPerformUtil.a("0X800B558", 0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.ocr.OCRPerformFragment.11.1
 * JD-Core Version:    0.7.0.1
 */