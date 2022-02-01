package com.tencent.mobileqq.ocr;

import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.widget.PopupWindow.OnDismissListener;
import android.widget.TextView;
import java.util.List;

class OCRResultActivity$7
  implements PopupWindow.OnDismissListener
{
  OCRResultActivity$7(OCRResultActivity paramOCRResultActivity) {}
  
  public void onDismiss()
  {
    this.a.a = null;
    if ((OCRResultActivity.c(this.a) != null) && (OCRResultActivity.c(this.a).size() > 1))
    {
      Drawable localDrawable = this.a.getResources().getDrawable(2130845921);
      this.a.b.setCompoundDrawablesWithIntrinsicBounds(null, null, null, localDrawable);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.ocr.OCRResultActivity.7
 * JD-Core Version:    0.7.0.1
 */