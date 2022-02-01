package com.tencent.mobileqq.ocr;

import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.widget.PopupWindow.OnDismissListener;
import android.widget.TextView;
import java.util.List;

class TranslateFragment$3
  implements PopupWindow.OnDismissListener
{
  TranslateFragment$3(TranslateFragment paramTranslateFragment, OCRPerformUtil.OCRLanHolder paramOCRLanHolder) {}
  
  public void onDismiss()
  {
    TranslateFragment.a(this.b, null);
    if ((this.a.f != null) && (this.a.f.size() > 1))
    {
      Drawable localDrawable = this.b.getResources().getDrawable(2130847827);
      TranslateFragment.d(this.b).setCompoundDrawablesWithIntrinsicBounds(null, null, null, localDrawable);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.ocr.TranslateFragment.3
 * JD-Core Version:    0.7.0.1
 */