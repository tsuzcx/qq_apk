package com.tencent.mobileqq.ocr.ui;

import android.text.Editable;
import android.view.KeyEvent;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.TextView.OnEditorActionListener;

class OCRTextSearchActivity$2
  implements TextView.OnEditorActionListener
{
  OCRTextSearchActivity$2(OCRTextSearchActivity paramOCRTextSearchActivity) {}
  
  public boolean onEditorAction(TextView paramTextView, int paramInt, KeyEvent paramKeyEvent)
  {
    if ((paramInt == 3) || ((paramKeyEvent != null) && (paramKeyEvent.getKeyCode() == 66)))
    {
      OCRTextSearchActivity.a(this.a);
      this.a.a.setSelection(this.a.a.getText().length());
      return true;
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.ocr.ui.OCRTextSearchActivity.2
 * JD-Core Version:    0.7.0.1
 */