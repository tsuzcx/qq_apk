package com.tencent.mobileqq.ocr.ui;

import android.text.Editable;
import android.text.TextWatcher;
import android.widget.EditText;

class OCRTextSearchActivity$SearchTextWatcher
  implements TextWatcher
{
  private OCRTextSearchActivity$SearchTextWatcher(OCRTextSearchActivity paramOCRTextSearchActivity) {}
  
  public void afterTextChanged(Editable paramEditable)
  {
    paramEditable = this.a.a.getText().toString();
    this.a.b(paramEditable);
  }
  
  public void beforeTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3) {}
  
  public void onTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.ocr.ui.OCRTextSearchActivity.SearchTextWatcher
 * JD-Core Version:    0.7.0.1
 */