package com.tencent.mobileqq.ocr.ui;

import android.app.Activity;
import android.text.Editable;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;

class OCRTextSearchActivity$3
  implements BaseOCRTextSearchFragment.SearchActivityInterface
{
  OCRTextSearchActivity$3(OCRTextSearchActivity paramOCRTextSearchActivity) {}
  
  public Activity a()
  {
    return this.a;
  }
  
  public void a(View paramView)
  {
    if (paramView == null) {
      this.a.p.hideSoftInputFromWindow(this.a.c.getWindowToken(), 0);
    } else {
      this.a.p.hideSoftInputFromWindow(paramView.getWindowToken(), 0);
    }
    this.a.c.clearFocus();
    this.a.c.setCursorVisible(false);
    a(this.a.c.getText().toString().trim());
    this.a.c.setSelection(this.a.c.getText().length());
  }
  
  public void a(String paramString)
  {
    this.a.a(paramString);
  }
  
  public void a(boolean paramBoolean)
  {
    this.a.a.a(paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.ocr.ui.OCRTextSearchActivity.3
 * JD-Core Version:    0.7.0.1
 */