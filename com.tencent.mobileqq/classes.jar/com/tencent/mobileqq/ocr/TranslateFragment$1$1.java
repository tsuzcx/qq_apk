package com.tencent.mobileqq.ocr;

import android.content.res.Resources;
import android.text.TextUtils;
import com.tencent.mobileqq.ocr.data.TranslateResult;
import com.tencent.mobileqq.widget.QQToast;

class TranslateFragment$1$1
  implements Runnable
{
  TranslateFragment$1$1(TranslateFragment.1 param1, boolean paramBoolean, TranslateResult paramTranslateResult) {}
  
  public void run()
  {
    TranslateFragment.a(this.c.a, false);
    TranslateFragment.b(this.c.a);
    if (this.a)
    {
      localObject = this.b;
      if ((localObject != null) && (((TranslateResult)localObject).g()) && (!this.b.f()))
      {
        TranslateFragment.a(this.c.a, this.b);
        TranslateFragment.a(this.c.a, 2, this.b);
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
    QQToast.makeText(TranslateFragment.c(this.c.a), 1, (CharSequence)localObject, 0).show();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.ocr.TranslateFragment.1.1
 * JD-Core Version:    0.7.0.1
 */