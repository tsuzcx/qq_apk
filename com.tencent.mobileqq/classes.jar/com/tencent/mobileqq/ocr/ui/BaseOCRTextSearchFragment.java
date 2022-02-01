package com.tencent.mobileqq.ocr.ui;

import android.app.Activity;
import android.support.v4.app.Fragment;
import android.view.View.OnTouchListener;
import azal;
import azam;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qqlive.module.videoreport.inject.fragment.ReportV4Fragment;

public class BaseOCRTextSearchFragment
  extends ReportV4Fragment
{
  public View.OnTouchListener a;
  public azam a;
  public QQAppInterface a;
  
  public BaseOCRTextSearchFragment()
  {
    this.jdField_a_of_type_AndroidViewView$OnTouchListener = new azal(this);
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = ((QQAppInterface)BaseApplicationImpl.getApplication().getRuntime());
  }
  
  public void onAttach(Activity paramActivity)
  {
    super.onAttach(paramActivity);
    if ((paramActivity instanceof OCRTextSearchActivity)) {
      this.jdField_a_of_type_Azam = ((OCRTextSearchActivity)paramActivity).jdField_a_of_type_Azam;
    }
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = ((QQAppInterface)BaseApplicationImpl.getApplication().getRuntime());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.ocr.ui.BaseOCRTextSearchFragment
 * JD-Core Version:    0.7.0.1
 */