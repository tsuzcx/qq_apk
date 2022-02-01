package com.tencent.mobileqq.ocr;

import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.widget.PopupWindow.OnDismissListener;
import android.widget.TextView;
import java.util.List;

class OCRResultActivity$5
  implements PopupWindow.OnDismissListener
{
  OCRResultActivity$5(OCRResultActivity paramOCRResultActivity) {}
  
  public void onDismiss()
  {
    this.a.b = null;
    if ((OCRResultActivity.b(this.a) != null) && (OCRResultActivity.b(this.a).size() > 1))
    {
      Drawable localDrawable = this.a.getResources().getDrawable(2130845921);
      this.a.a.setCompoundDrawablesWithIntrinsicBounds(null, null, null, localDrawable);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.ocr.OCRResultActivity.5
 * JD-Core Version:    0.7.0.1
 */