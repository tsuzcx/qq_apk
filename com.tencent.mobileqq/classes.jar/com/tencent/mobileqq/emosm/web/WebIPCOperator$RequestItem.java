package com.tencent.mobileqq.emosm.web;

import android.os.Bundle;

class WebIPCOperator$RequestItem
{
  int jdField_a_of_type_Int;
  Bundle jdField_a_of_type_AndroidOsBundle;
  Runnable jdField_a_of_type_JavaLangRunnable;
  
  public WebIPCOperator$RequestItem(int paramInt, Bundle paramBundle)
  {
    this.jdField_a_of_type_Int = paramInt;
    paramBundle.putInt("seq", paramInt);
    this.jdField_a_of_type_AndroidOsBundle = paramBundle;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.emosm.web.WebIPCOperator.RequestItem
 * JD-Core Version:    0.7.0.1
 */