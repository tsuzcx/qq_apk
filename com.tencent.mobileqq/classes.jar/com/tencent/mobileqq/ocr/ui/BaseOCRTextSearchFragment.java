package com.tencent.mobileqq.ocr.ui;

import agcz;
import android.app.Activity;
import android.support.v4.app.Fragment;
import android.view.View.OnTouchListener;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;

public class BaseOCRTextSearchFragment
  extends Fragment
{
  public View.OnTouchListener a;
  public QQAppInterface a;
  public BaseOCRTextSearchFragment.SearchActivityInterface a;
  
  public BaseOCRTextSearchFragment()
  {
    this.jdField_a_of_type_AndroidViewView$OnTouchListener = new agcz(this);
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = ((QQAppInterface)BaseApplicationImpl.getApplication().getRuntime());
  }
  
  public void onAttach(Activity paramActivity)
  {
    super.onAttach(paramActivity);
    if ((paramActivity instanceof OCRTextSearchActivity)) {
      this.jdField_a_of_type_ComTencentMobileqqOcrUiBaseOCRTextSearchFragment$SearchActivityInterface = ((OCRTextSearchActivity)paramActivity).jdField_a_of_type_ComTencentMobileqqOcrUiBaseOCRTextSearchFragment$SearchActivityInterface;
    }
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = ((QQAppInterface)BaseApplicationImpl.getApplication().getRuntime());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.ocr.ui.BaseOCRTextSearchFragment
 * JD-Core Version:    0.7.0.1
 */