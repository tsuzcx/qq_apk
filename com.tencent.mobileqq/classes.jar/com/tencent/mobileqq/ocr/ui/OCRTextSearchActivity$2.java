package com.tencent.mobileqq.ocr.ui;

import android.text.Editable;
import android.view.KeyEvent;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.TextView.OnEditorActionListener;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class OCRTextSearchActivity$2
  implements TextView.OnEditorActionListener
{
  OCRTextSearchActivity$2(OCRTextSearchActivity paramOCRTextSearchActivity) {}
  
  public boolean onEditorAction(TextView paramTextView, int paramInt, KeyEvent paramKeyEvent)
  {
    boolean bool;
    if ((paramInt != 3) && ((paramKeyEvent == null) || (paramKeyEvent.getKeyCode() != 66)))
    {
      bool = false;
    }
    else
    {
      OCRTextSearchActivity.a(this.a);
      this.a.c.setSelection(this.a.c.getText().length());
      bool = true;
    }
    EventCollector.getInstance().onEditorAction(paramTextView, paramInt, paramKeyEvent);
    return bool;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.ocr.ui.OCRTextSearchActivity.2
 * JD-Core Version:    0.7.0.1
 */