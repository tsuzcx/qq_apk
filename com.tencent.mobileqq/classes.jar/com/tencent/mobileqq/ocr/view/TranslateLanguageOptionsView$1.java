package com.tencent.mobileqq.ocr.view;

import android.widget.RadioButton;
import com.tencent.mobileqq.widget.BounceScrollView;
import com.tencent.qphone.base.util.QLog;

final class TranslateLanguageOptionsView$1
  implements Runnable
{
  TranslateLanguageOptionsView$1(RadioButton paramRadioButton, BounceScrollView paramBounceScrollView) {}
  
  public void run()
  {
    int i = this.a.getBottom() + this.a.getPaddingBottom() - this.b.getHeight();
    if (i > 0)
    {
      this.b.scrollBy(0, i);
      if (QLog.isColorLevel()) {
        QLog.d("TranslateLanguageOptionsView", 2, new Object[] { "compute detail, bottom:", Integer.valueOf(this.a.getBottom()), " padding:", Integer.valueOf(this.a.getPaddingBottom()), " viewHeight:", Integer.valueOf(this.b.getHeight()), " scrollHeight:", Integer.valueOf(i) });
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.ocr.view.TranslateLanguageOptionsView.1
 * JD-Core Version:    0.7.0.1
 */