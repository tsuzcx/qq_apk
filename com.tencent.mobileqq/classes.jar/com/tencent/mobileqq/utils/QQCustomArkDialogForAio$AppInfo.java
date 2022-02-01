package com.tencent.mobileqq.utils;

import android.os.Bundle;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.activity.aio.item.ArkAppContainer;

public class QQCustomArkDialogForAio$AppInfo
{
  public float a;
  public SessionInfo a;
  public ArkAppContainer a;
  public String a;
  public boolean a;
  public String b;
  public String c;
  public String d;
  public String e = "";
  
  public QQCustomArkDialogForAio$AppInfo(Bundle paramBundle)
  {
    this.jdField_a_of_type_ComTencentMobileqqActivityAioItemArkAppContainer = null;
    this.jdField_a_of_type_Boolean = false;
    this.jdField_a_of_type_JavaLangString = paramBundle.getString("appName");
    this.b = paramBundle.getString("appView");
    this.c = paramBundle.getString("appMinVersion");
    this.d = paramBundle.getString("metaData");
    this.jdField_a_of_type_Float = paramBundle.getFloat("scale", 1.0F);
    this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo = new SessionInfo();
    paramBundle = paramBundle.getString("troopUin");
    if (paramBundle != null)
    {
      SessionInfo localSessionInfo = this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo;
      localSessionInfo.jdField_a_of_type_Int = 1;
      localSessionInfo.jdField_a_of_type_JavaLangString = paramBundle;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.utils.QQCustomArkDialogForAio.AppInfo
 * JD-Core Version:    0.7.0.1
 */