package com.tencent.mobileqq.miniapp;

import com.tencent.mobileqq.miniapp.ui.MiniAppActivity;

public abstract class IApp
{
  public MiniAppInfo a;
  public MiniAppActivity a;
  
  public IApp(MiniAppActivity paramMiniAppActivity, String paramString, int paramInt)
  {
    this.jdField_a_of_type_ComTencentMobileqqMiniappUiMiniAppActivity = paramMiniAppActivity;
  }
  
  public abstract void a();
  
  public void a(MiniAppInfo paramMiniAppInfo)
  {
    this.jdField_a_of_type_ComTencentMobileqqMiniappMiniAppInfo = paramMiniAppInfo;
    MiniAppActivity localMiniAppActivity = this.jdField_a_of_type_ComTencentMobileqqMiniappUiMiniAppActivity;
    if (localMiniAppActivity != null) {
      localMiniAppActivity.jdField_a_of_type_ComTencentMobileqqMiniappMiniAppInfo = paramMiniAppInfo;
    }
  }
  
  public abstract boolean a();
  
  public abstract void b();
  
  public void c()
  {
    this.jdField_a_of_type_ComTencentMobileqqMiniappUiMiniAppActivity = null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.miniapp.IApp
 * JD-Core Version:    0.7.0.1
 */