package com.tencent.mobileqq.ocr;

import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.widget.PopupWindow.OnDismissListener;
import android.widget.TextView;
import java.util.List;

class OCRPerformFragment$10
  implements PopupWindow.OnDismissListener
{
  OCRPerformFragment$10(OCRPerformFragment paramOCRPerformFragment, OCRPerformUtil.OCRLanHolder paramOCRLanHolder) {}
  
  public void onDismiss()
  {
    OCRPerformFragment.b(this.b, null);
    if ((this.a.g != null) && (this.a.g.size() > 1))
    {
      Drawable localDrawable = this.b.getResources().getDrawable(2130847828);
      OCRPerformFragment.l(this.b).setCompoundDrawablesWithIntrinsicBounds(null, null, null, localDrawable);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.ocr.OCRPerformFragment.10
 * JD-Core Version:    0.7.0.1
 */