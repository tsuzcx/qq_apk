package com.tencent.mobileqq.ocr.ui;

import android.app.Activity;
import android.view.View.OnTouchListener;
import com.tencent.mobileqq.app.QBaseFragment;

public class BaseOCRTextSearchFragment
  extends QBaseFragment
{
  public View.OnTouchListener a;
  public BaseOCRTextSearchFragment.SearchActivityInterface a;
  
  public BaseOCRTextSearchFragment()
  {
    this.jdField_a_of_type_AndroidViewView$OnTouchListener = new BaseOCRTextSearchFragment.1(this);
  }
  
  public void onAttach(Activity paramActivity)
  {
    super.onAttach(paramActivity);
    if ((paramActivity instanceof OCRTextSearchActivity)) {
      this.jdField_a_of_type_ComTencentMobileqqOcrUiBaseOCRTextSearchFragment$SearchActivityInterface = ((OCRTextSearchActivity)paramActivity).jdField_a_of_type_ComTencentMobileqqOcrUiBaseOCRTextSearchFragment$SearchActivityInterface;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.ocr.ui.BaseOCRTextSearchFragment
 * JD-Core Version:    0.7.0.1
 */