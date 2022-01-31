package com.tencent.qqmini.sdk.runtime.util;

import bghl;
import bgho;
import bghv;
import bhch;
import com.tencent.qqmini.sdk.log.QMLog;
import com.tencent.qqmini.sdk.runtime.core.page.AppBrandPage;
import com.tencent.qqmini.sdk.runtime.core.page.AppBrandPageContainer;

public class ToastMessage
  implements bghv<Boolean>
{
  public int a;
  public ToastMessage.Action a;
  public String a;
  public boolean a;
  public int b;
  public String b;
  public String c;
  
  public static ToastMessage a()
  {
    return new ToastMessage();
  }
  
  public Boolean a(bghl parambghl)
  {
    parambghl = parambghl.a();
    if ((parambghl instanceof AppBrandPageContainer))
    {
      parambghl = ((AppBrandPageContainer)parambghl).a();
      if (parambghl != null)
      {
        if (this.jdField_a_of_type_ComTencentQqminiSdkRuntimeUtilToastMessage$Action == ToastMessage.Action.SHOW)
        {
          parambghl.a(this.jdField_a_of_type_Int, this.jdField_a_of_type_JavaLangString, this.jdField_b_of_type_JavaLangString, this.c, this.jdField_b_of_type_Int, this.jdField_a_of_type_Boolean);
          return Boolean.valueOf(true);
        }
        if (this.jdField_a_of_type_ComTencentQqminiSdkRuntimeUtilToastMessage$Action == ToastMessage.Action.UPDATE)
        {
          parambghl.b(this.c);
          return Boolean.valueOf(true);
        }
        if (this.jdField_a_of_type_ComTencentQqminiSdkRuntimeUtilToastMessage$Action == ToastMessage.Action.HIDE)
        {
          parambghl.c();
          return Boolean.valueOf(true);
        }
        if (this.jdField_a_of_type_ComTencentQqminiSdkRuntimeUtilToastMessage$Action == ToastMessage.Action.IS_SHOWING) {
          return Boolean.valueOf(parambghl.d());
        }
        QMLog.d("ToastMessage", "unknown action");
      }
    }
    for (;;)
    {
      return Boolean.valueOf(false);
      if ((parambghl instanceof bhch))
      {
        parambghl = (bhch)parambghl;
        if (parambghl != null)
        {
          if (this.jdField_a_of_type_ComTencentQqminiSdkRuntimeUtilToastMessage$Action == ToastMessage.Action.SHOW)
          {
            parambghl.a(this.jdField_a_of_type_Int, this.jdField_a_of_type_JavaLangString, this.jdField_b_of_type_JavaLangString, this.c, this.jdField_b_of_type_Int, this.jdField_a_of_type_Boolean);
            return Boolean.valueOf(true);
          }
          if (this.jdField_a_of_type_ComTencentQqminiSdkRuntimeUtilToastMessage$Action == ToastMessage.Action.UPDATE)
          {
            parambghl.b(this.c);
            return Boolean.valueOf(true);
          }
          if (this.jdField_a_of_type_ComTencentQqminiSdkRuntimeUtilToastMessage$Action == ToastMessage.Action.HIDE)
          {
            parambghl.d();
            return Boolean.valueOf(true);
          }
          if (this.jdField_a_of_type_ComTencentQqminiSdkRuntimeUtilToastMessage$Action == ToastMessage.Action.IS_SHOWING) {
            return Boolean.valueOf(parambghl.c());
          }
          QMLog.d("ToastMessage", "unknown action");
        }
      }
    }
  }
  
  public boolean a(bgho parambgho)
  {
    this.jdField_a_of_type_ComTencentQqminiSdkRuntimeUtilToastMessage$Action = ToastMessage.Action.SHOW;
    return ((Boolean)parambgho.a(this)).booleanValue();
  }
  
  public boolean b(bgho parambgho)
  {
    this.jdField_a_of_type_ComTencentQqminiSdkRuntimeUtilToastMessage$Action = ToastMessage.Action.HIDE;
    return ((Boolean)parambgho.a(this)).booleanValue();
  }
  
  public boolean c(bgho parambgho)
  {
    this.jdField_a_of_type_ComTencentQqminiSdkRuntimeUtilToastMessage$Action = ToastMessage.Action.IS_SHOWING;
    return ((Boolean)parambgho.a(this)).booleanValue();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.qqmini.sdk.runtime.util.ToastMessage
 * JD-Core Version:    0.7.0.1
 */