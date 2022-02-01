package com.tencent.mobileqq.ocr;

import android.text.Editable;
import android.text.TextWatcher;
import com.tencent.mobileqq.widget.OCRBottomTabView;

class OCRResultFragmentNew$2
  implements TextWatcher
{
  OCRResultFragmentNew$2(OCRResultFragmentNew paramOCRResultFragmentNew) {}
  
  public void afterTextChanged(Editable paramEditable)
  {
    if (paramEditable.toString().trim().length() == 0)
    {
      this.a.d.setEnabled(false);
      this.a.c.setEnabled(false);
      return;
    }
    this.a.d.setEnabled(true);
    this.a.c.setEnabled(true);
  }
  
  public void beforeTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3) {}
  
  public void onTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.ocr.OCRResultFragmentNew.2
 * JD-Core Version:    0.7.0.1
 */