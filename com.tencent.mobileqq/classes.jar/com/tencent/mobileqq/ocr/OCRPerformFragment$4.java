package com.tencent.mobileqq.ocr;

import android.view.View;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.share.api.IShareActivityStartup;
import com.tencent.widget.ActionSheet;
import com.tencent.widget.ActionSheet.OnButtonClickListener;

class OCRPerformFragment$4
  implements ActionSheet.OnButtonClickListener
{
  OCRPerformFragment$4(OCRPerformFragment paramOCRPerformFragment) {}
  
  public void onClick(View paramView, int paramInt)
  {
    if (paramInt == 0)
    {
      OCRPerformUtil.a(OCRPerformFragment.a(this.a), String.valueOf(OCRPerformFragment.e(this.a)));
      if (OCRPerformUtil.a) {
        paramView = "0X800B55F";
      } else {
        paramView = "0X800AAE9";
      }
      OCRPerformUtil.a(paramView, 0);
    }
    if (paramInt == 1)
    {
      if (OCRPerformUtil.a) {
        OCRPerformUtil.a(OCRPerformFragment.a(this.a), OCRPerformFragment.d(this.a));
      } else {
        ((IShareActivityStartup)QRoute.api(IShareActivityStartup.class)).gotoShareActivity(OCRPerformFragment.a(this.a), OCRPerformFragment.b(this.a));
      }
      if (OCRPerformUtil.a) {
        paramView = "0X800B560";
      } else {
        paramView = "0X800AAEA";
      }
      OCRPerformUtil.a(paramView, 0);
    }
    if ((OCRPerformFragment.f(this.a) != null) && (OCRPerformFragment.f(this.a).isShowing())) {
      OCRPerformFragment.f(this.a).dismiss();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.ocr.OCRPerformFragment.4
 * JD-Core Version:    0.7.0.1
 */