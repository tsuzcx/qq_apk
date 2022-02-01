package com.tencent.mobileqq.ocr;

import android.graphics.Rect;
import android.text.Spannable;
import android.text.style.ClickableSpan;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewTreeObserver.OnGlobalLayoutListener;
import android.widget.EditText;
import android.widget.FrameLayout.LayoutParams;
import com.tencent.mobileqq.app.QBaseActivity;
import com.tencent.mobileqq.ar.utils.UniformUtils;
import com.tencent.qphone.base.util.QLog;

class OCRResultFragmentNew$4
  implements ViewTreeObserver.OnGlobalLayoutListener
{
  OCRResultFragmentNew$4(OCRResultFragmentNew paramOCRResultFragmentNew, EditText paramEditText) {}
  
  public void onGlobalLayout()
  {
    Object localObject1 = new FrameLayout.LayoutParams(-1, -1);
    OCRResultFragmentNew.a(this.jdField_a_of_type_ComTencentMobileqqOcrOCRResultFragmentNew).findViewById(2131367211).setLayoutParams((ViewGroup.LayoutParams)localObject1);
    localObject1 = new Rect();
    this.jdField_a_of_type_ComTencentMobileqqOcrOCRResultFragmentNew.a.getWindowVisibleDisplayFrame((Rect)localObject1);
    int i = this.jdField_a_of_type_ComTencentMobileqqOcrOCRResultFragmentNew.a.getRootView().getHeight();
    int j = i - ((Rect)localObject1).bottom;
    if (j != OCRResultFragmentNew.a(this.jdField_a_of_type_ComTencentMobileqqOcrOCRResultFragmentNew))
    {
      OCRResultFragmentNew.a(this.jdField_a_of_type_ComTencentMobileqqOcrOCRResultFragmentNew, j);
      double d1 = j;
      double d2 = i;
      Double.isNaN(d2);
      d2 *= 0.15D;
      boolean bool = true;
      Object localObject2;
      if (d1 > d2)
      {
        this.jdField_a_of_type_ComTencentMobileqqOcrOCRResultFragmentNew.c.setVisibility(8);
        try
        {
          localObject1 = this.jdField_a_of_type_AndroidWidgetEditText.getText();
          Object localObject3 = (ClickableSpan[])((Spannable)localObject1).getSpans(0, ((Spannable)localObject1).length(), ClickableSpan.class);
          if ((localObject3 == null) || (localObject3.length <= 0)) {
            break label319;
          }
          j = localObject3.length;
          i = 0;
          while (i < j)
          {
            ((Spannable)localObject1).removeSpan(localObject3[i]);
            i += 1;
          }
          this.jdField_a_of_type_ComTencentMobileqqOcrOCRResultFragmentNew.c.setVisibility(0);
        }
        catch (Exception localException)
        {
          localObject3 = this.jdField_a_of_type_AndroidWidgetEditText;
          ((EditText)localObject3).setText(OCRResultFragmentNew.a(this.jdField_a_of_type_ComTencentMobileqqOcrOCRResultFragmentNew, ((EditText)localObject3).getText(), true));
          localException.printStackTrace();
        }
      }
      else
      {
        UniformUtils.a(OCRResultFragmentNew.a(this.jdField_a_of_type_ComTencentMobileqqOcrOCRResultFragmentNew), this.jdField_a_of_type_ComTencentMobileqqOcrOCRResultFragmentNew.c, false, 0);
        if (this.jdField_a_of_type_AndroidWidgetEditText.hasSelection()) {
          this.jdField_a_of_type_AndroidWidgetEditText.clearFocus();
        }
        localObject2 = this.jdField_a_of_type_AndroidWidgetEditText;
        ((EditText)localObject2).setText(OCRResultFragmentNew.a(this.jdField_a_of_type_ComTencentMobileqqOcrOCRResultFragmentNew, ((EditText)localObject2).getText(), true));
      }
      label319:
      if (QLog.isColorLevel())
      {
        localObject2 = new StringBuilder();
        ((StringBuilder)localObject2).append("OnGlobalLayoutListener showKeyboard:");
        if (d1 <= d2) {
          bool = false;
        }
        ((StringBuilder)localObject2).append(bool);
        QLog.d("OCRResultFragmentNew", 2, ((StringBuilder)localObject2).toString());
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.ocr.OCRResultFragmentNew.4
 * JD-Core Version:    0.7.0.1
 */