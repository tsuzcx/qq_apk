package com.tencent.mobileqq.ocr.ui;

import android.app.Activity;
import android.view.View.OnTouchListener;
import com.tencent.mobileqq.app.QBaseFragment;

public class BaseOCRTextSearchFragment
  extends QBaseFragment
{
  public BaseOCRTextSearchFragment.SearchActivityInterface a;
  public View.OnTouchListener b = new BaseOCRTextSearchFragment.1(this);
  
  public void onAttach(Activity paramActivity)
  {
    super.onAttach(paramActivity);
    if ((paramActivity instanceof OCRTextSearchActivity)) {
      this.a = ((OCRTextSearchActivity)paramActivity).q;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.ocr.ui.BaseOCRTextSearchFragment
 * JD-Core Version:    0.7.0.1
 */