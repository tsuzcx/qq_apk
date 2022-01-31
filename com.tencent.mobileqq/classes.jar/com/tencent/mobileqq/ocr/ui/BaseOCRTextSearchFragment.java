package com.tencent.mobileqq.ocr.ui;

import android.app.Activity;
import android.support.v4.app.Fragment;
import android.view.View.OnTouchListener;
import avtr;
import avts;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;

public class BaseOCRTextSearchFragment
  extends Fragment
{
  public View.OnTouchListener a;
  public avts a;
  public QQAppInterface a;
  
  public BaseOCRTextSearchFragment()
  {
    this.jdField_a_of_type_AndroidViewView$OnTouchListener = new avtr(this);
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = ((QQAppInterface)BaseApplicationImpl.getApplication().getRuntime());
  }
  
  public void onAttach(Activity paramActivity)
  {
    super.onAttach(paramActivity);
    if ((paramActivity instanceof OCRTextSearchActivity)) {
      this.jdField_a_of_type_Avts = ((OCRTextSearchActivity)paramActivity).jdField_a_of_type_Avts;
    }
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = ((QQAppInterface)BaseApplicationImpl.getApplication().getRuntime());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.ocr.ui.BaseOCRTextSearchFragment
 * JD-Core Version:    0.7.0.1
 */