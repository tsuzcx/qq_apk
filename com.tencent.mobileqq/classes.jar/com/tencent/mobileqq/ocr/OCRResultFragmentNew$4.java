package com.tencent.mobileqq.ocr;

import android.graphics.Rect;
import android.text.Spannable;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewTreeObserver.OnGlobalLayoutListener;
import android.widget.EditText;
import android.widget.FrameLayout.LayoutParams;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.ar.utils.UniformUtils;
import com.tencent.mobileqq.text.style.LinkSpan;
import com.tencent.qphone.base.util.QLog;

class OCRResultFragmentNew$4
  implements ViewTreeObserver.OnGlobalLayoutListener
{
  OCRResultFragmentNew$4(OCRResultFragmentNew paramOCRResultFragmentNew, EditText paramEditText) {}
  
  public void onGlobalLayout()
  {
    Object localObject = new FrameLayout.LayoutParams(-1, -1);
    OCRResultFragmentNew.a(this.jdField_a_of_type_ComTencentMobileqqOcrOCRResultFragmentNew).findViewById(2131367430).setLayoutParams((ViewGroup.LayoutParams)localObject);
    localObject = new Rect();
    this.jdField_a_of_type_ComTencentMobileqqOcrOCRResultFragmentNew.a.getWindowVisibleDisplayFrame((Rect)localObject);
    int j = this.jdField_a_of_type_ComTencentMobileqqOcrOCRResultFragmentNew.a.getRootView().getHeight();
    int k = j - ((Rect)localObject).bottom;
    StringBuilder localStringBuilder;
    if (k != OCRResultFragmentNew.a(this.jdField_a_of_type_ComTencentMobileqqOcrOCRResultFragmentNew))
    {
      OCRResultFragmentNew.a(this.jdField_a_of_type_ComTencentMobileqqOcrOCRResultFragmentNew, k);
      if (k <= j * 0.15D) {
        break label269;
      }
      this.jdField_a_of_type_ComTencentMobileqqOcrOCRResultFragmentNew.c.setVisibility(8);
      try
      {
        localObject = this.jdField_a_of_type_AndroidWidgetEditText.getText();
        LinkSpan[] arrayOfLinkSpan = (LinkSpan[])((Spannable)localObject).getSpans(0, ((Spannable)localObject).length(), LinkSpan.class);
        if ((arrayOfLinkSpan != null) && (arrayOfLinkSpan.length > 0))
        {
          int m = arrayOfLinkSpan.length;
          int i = 0;
          while (i < m)
          {
            ((Spannable)localObject).removeSpan(arrayOfLinkSpan[i]);
            i += 1;
          }
        }
        if (!QLog.isColorLevel()) {
          break label268;
        }
      }
      catch (Exception localException)
      {
        this.jdField_a_of_type_AndroidWidgetEditText.setText(OCRResultFragmentNew.a(this.jdField_a_of_type_ComTencentMobileqqOcrOCRResultFragmentNew, this.jdField_a_of_type_AndroidWidgetEditText.getText(), true));
        localException.printStackTrace();
      }
      localStringBuilder = new StringBuilder().append("OnGlobalLayoutListener showKeyboard:");
      if (k <= j * 0.15D) {
        break label341;
      }
    }
    label268:
    label269:
    label341:
    for (boolean bool = true;; bool = false)
    {
      QLog.d("OCRResultFragmentNew", 2, bool);
      return;
      this.jdField_a_of_type_ComTencentMobileqqOcrOCRResultFragmentNew.c.setVisibility(0);
      UniformUtils.a(OCRResultFragmentNew.a(this.jdField_a_of_type_ComTencentMobileqqOcrOCRResultFragmentNew), this.jdField_a_of_type_ComTencentMobileqqOcrOCRResultFragmentNew.c, false, 0);
      if (this.jdField_a_of_type_AndroidWidgetEditText.hasSelection()) {
        this.jdField_a_of_type_AndroidWidgetEditText.clearFocus();
      }
      this.jdField_a_of_type_AndroidWidgetEditText.setText(OCRResultFragmentNew.a(this.jdField_a_of_type_ComTencentMobileqqOcrOCRResultFragmentNew, this.jdField_a_of_type_AndroidWidgetEditText.getText(), true));
      break;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.ocr.OCRResultFragmentNew.4
 * JD-Core Version:    0.7.0.1
 */