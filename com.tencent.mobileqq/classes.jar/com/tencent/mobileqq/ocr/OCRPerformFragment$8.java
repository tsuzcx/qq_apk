package com.tencent.mobileqq.ocr;

import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.widget.PopupWindow.OnDismissListener;
import android.widget.TextView;
import java.util.List;

class OCRPerformFragment$8
  implements PopupWindow.OnDismissListener
{
  OCRPerformFragment$8(OCRPerformFragment paramOCRPerformFragment, OCRPerformUtil.OCRLanHolder paramOCRLanHolder) {}
  
  public void onDismiss()
  {
    OCRPerformFragment.a(this.b, null);
    if ((this.a.f != null) && (this.a.f.size() > 1))
    {
      Drawable localDrawable = this.b.getResources().getDrawable(2130847828);
      OCRPerformFragment.k(this.b).setCompoundDrawablesWithIntrinsicBounds(null, null, null, localDrawable);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.ocr.OCRPerformFragment.8
 * JD-Core Version:    0.7.0.1
 */