package com.tencent.mobileqq.ocr;

import android.view.View;
import com.tencent.widget.ActionSheet;
import com.tencent.widget.ActionSheet.OnButtonClickListener;
import java.util.List;

class OCRResultActivity$3
  implements ActionSheet.OnButtonClickListener
{
  OCRResultActivity$3(OCRResultActivity paramOCRResultActivity) {}
  
  public void OnClick(View paramView, int paramInt)
  {
    if ((OCRResultActivity.a(this.a) != null) && (paramInt < OCRResultActivity.a(this.a).size()))
    {
      paramView = (String)OCRResultActivity.a(this.a).get(paramInt);
      OCRResultActivity.a(this.a, OCRResultActivity.a(this.a), paramView, false, true);
    }
    if ((OCRResultActivity.a(this.a) != null) && (OCRResultActivity.a(this.a).isShowing())) {
      OCRResultActivity.a(this.a).dismiss();
    }
    OCRResultActivity.a(this.a, null);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.ocr.OCRResultActivity.3
 * JD-Core Version:    0.7.0.1
 */