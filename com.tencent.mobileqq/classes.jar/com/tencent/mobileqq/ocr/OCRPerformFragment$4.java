package com.tencent.mobileqq.ocr;

import android.view.View;
import com.tencent.mobileqq.screendetect.ScreenShotHelper;
import com.tencent.widget.ActionSheet;
import com.tencent.widget.ActionSheet.OnButtonClickListener;

class OCRPerformFragment$4
  implements ActionSheet.OnButtonClickListener
{
  OCRPerformFragment$4(OCRPerformFragment paramOCRPerformFragment) {}
  
  public void OnClick(View paramView, int paramInt)
  {
    if (paramInt == 0)
    {
      OCRPerformUtil.a(OCRPerformFragment.a(this.a), String.valueOf(OCRPerformFragment.a(this.a)));
      if (OCRPerformUtil.a)
      {
        paramView = "0X800B55F";
        OCRPerformUtil.a(paramView, 0);
      }
    }
    else if (paramInt == 1)
    {
      if (!OCRPerformUtil.a) {
        break label120;
      }
      OCRPerformUtil.a(OCRPerformFragment.a(this.a), OCRPerformFragment.a(this.a));
      label66:
      if (!OCRPerformUtil.a) {
        break label141;
      }
    }
    label141:
    for (paramView = "0X800B560";; paramView = "0X800AAEA")
    {
      OCRPerformUtil.a(paramView, 0);
      if ((OCRPerformFragment.a(this.a) != null) && (OCRPerformFragment.a(this.a).isShowing())) {
        OCRPerformFragment.a(this.a).dismiss();
      }
      return;
      paramView = "0X800AAE9";
      break;
      label120:
      ScreenShotHelper.a(OCRPerformFragment.a(this.a), OCRPerformFragment.a(this.a), false);
      break label66;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.ocr.OCRPerformFragment.4
 * JD-Core Version:    0.7.0.1
 */