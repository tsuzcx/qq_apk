package com.tencent.qqmini.sdk.runtime.util;

import bgls;
import bglv;
import bgmc;
import bhgo;
import com.tencent.qqmini.sdk.log.QMLog;
import com.tencent.qqmini.sdk.runtime.core.page.AppBrandPage;
import com.tencent.qqmini.sdk.runtime.core.page.AppBrandPageContainer;

public class ToastMessage
  implements bgmc<Boolean>
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
  
  public Boolean a(bgls parambgls)
  {
    parambgls = parambgls.a();
    if ((parambgls instanceof AppBrandPageContainer))
    {
      parambgls = ((AppBrandPageContainer)parambgls).a();
      if (parambgls != null)
      {
        if (this.jdField_a_of_type_ComTencentQqminiSdkRuntimeUtilToastMessage$Action == ToastMessage.Action.SHOW)
        {
          parambgls.a(this.jdField_a_of_type_Int, this.jdField_a_of_type_JavaLangString, this.jdField_b_of_type_JavaLangString, this.c, this.jdField_b_of_type_Int, this.jdField_a_of_type_Boolean);
          return Boolean.valueOf(true);
        }
        if (this.jdField_a_of_type_ComTencentQqminiSdkRuntimeUtilToastMessage$Action == ToastMessage.Action.UPDATE)
        {
          parambgls.b(this.c);
          return Boolean.valueOf(true);
        }
        if (this.jdField_a_of_type_ComTencentQqminiSdkRuntimeUtilToastMessage$Action == ToastMessage.Action.HIDE)
        {
          parambgls.c();
          return Boolean.valueOf(true);
        }
        if (this.jdField_a_of_type_ComTencentQqminiSdkRuntimeUtilToastMessage$Action == ToastMessage.Action.IS_SHOWING) {
          return Boolean.valueOf(parambgls.d());
        }
        QMLog.d("ToastMessage", "unknown action");
      }
    }
    for (;;)
    {
      return Boolean.valueOf(false);
      if ((parambgls instanceof bhgo))
      {
        parambgls = (bhgo)parambgls;
        if (parambgls != null)
        {
          if (this.jdField_a_of_type_ComTencentQqminiSdkRuntimeUtilToastMessage$Action == ToastMessage.Action.SHOW)
          {
            parambgls.a(this.jdField_a_of_type_Int, this.jdField_a_of_type_JavaLangString, this.jdField_b_of_type_JavaLangString, this.c, this.jdField_b_of_type_Int, this.jdField_a_of_type_Boolean);
            return Boolean.valueOf(true);
          }
          if (this.jdField_a_of_type_ComTencentQqminiSdkRuntimeUtilToastMessage$Action == ToastMessage.Action.UPDATE)
          {
            parambgls.b(this.c);
            return Boolean.valueOf(true);
          }
          if (this.jdField_a_of_type_ComTencentQqminiSdkRuntimeUtilToastMessage$Action == ToastMessage.Action.HIDE)
          {
            parambgls.d();
            return Boolean.valueOf(true);
          }
          if (this.jdField_a_of_type_ComTencentQqminiSdkRuntimeUtilToastMessage$Action == ToastMessage.Action.IS_SHOWING) {
            return Boolean.valueOf(parambgls.c());
          }
          QMLog.d("ToastMessage", "unknown action");
        }
      }
    }
  }
  
  public boolean a(bglv parambglv)
  {
    this.jdField_a_of_type_ComTencentQqminiSdkRuntimeUtilToastMessage$Action = ToastMessage.Action.SHOW;
    return ((Boolean)parambglv.a(this)).booleanValue();
  }
  
  public boolean b(bglv parambglv)
  {
    this.jdField_a_of_type_ComTencentQqminiSdkRuntimeUtilToastMessage$Action = ToastMessage.Action.HIDE;
    return ((Boolean)parambglv.a(this)).booleanValue();
  }
  
  public boolean c(bglv parambglv)
  {
    this.jdField_a_of_type_ComTencentQqminiSdkRuntimeUtilToastMessage$Action = ToastMessage.Action.IS_SHOWING;
    return ((Boolean)parambglv.a(this)).booleanValue();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.qqmini.sdk.runtime.util.ToastMessage
 * JD-Core Version:    0.7.0.1
 */