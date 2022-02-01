package com.tencent.mobileqq.ocr;

import android.text.Layout;
import android.text.Spannable;
import android.text.style.ClickableSpan;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import android.widget.EditText;
import com.tencent.mobileqq.statistics.ReportController;

class OCRResultFragmentNew$5
  implements View.OnTouchListener
{
  OCRResultFragmentNew$5(OCRResultFragmentNew paramOCRResultFragmentNew) {}
  
  public boolean onTouch(View paramView, MotionEvent paramMotionEvent)
  {
    paramView = (EditText)paramView;
    int k = paramMotionEvent.getAction();
    int j = 0;
    int i = j;
    if (k == 1)
    {
      Object localObject = paramView.getText();
      i = (int)paramMotionEvent.getX();
      int i1 = (int)paramMotionEvent.getY();
      int m = paramView.getTotalPaddingLeft();
      int i2 = paramView.getTotalPaddingTop();
      int n = paramView.getScrollX();
      int i3 = paramView.getScrollY();
      Layout localLayout = paramView.getLayout();
      i1 = localLayout.getLineForVertical(i1 - i2 + i3);
      float f1 = localLayout.getLineWidth(i1);
      float f2 = i - m + n;
      i = j;
      if (f2 <= f1)
      {
        i = localLayout.getOffsetForHorizontal(i1, f2);
        localObject = (ClickableSpan[])((Spannable)localObject).getSpans(i, i, ClickableSpan.class);
        i = j;
        if (localObject.length != 0)
        {
          localObject[0].onClick(paramView);
          ReportController.b(null, "dc00898", "", "", "0X80082E3", "0X80082E3", 0, 0, "", "", "", "");
          i = 1;
        }
      }
    }
    if (i != 0) {
      return true;
    }
    if ((k == 1) && (!paramView.isFocused())) {
      ReportController.b(null, "dc00898", "", "", "0X80082E2", "0X80082E2", 0, 0, "", "", "", "");
    }
    return paramView.onTouchEvent(paramMotionEvent);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.ocr.OCRResultFragmentNew.5
 * JD-Core Version:    0.7.0.1
 */