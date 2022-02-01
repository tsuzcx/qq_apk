package com.tencent.mobileqq.ocr;

import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.widget.PopupWindow.OnDismissListener;
import android.widget.TextView;
import java.util.List;

class TranslateFragment$5
  implements PopupWindow.OnDismissListener
{
  TranslateFragment$5(TranslateFragment paramTranslateFragment, OCRPerformUtil.OCRLanHolder paramOCRLanHolder) {}
  
  public void onDismiss()
  {
    TranslateFragment.b(this.b, null);
    if ((this.a.g != null) && (this.a.g.size() > 1))
    {
      Drawable localDrawable = this.b.getResources().getDrawable(2130847827);
      TranslateFragment.e(this.b).setCompoundDrawablesWithIntrinsicBounds(null, null, null, localDrawable);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.ocr.TranslateFragment.5
 * JD-Core Version:    0.7.0.1
 */