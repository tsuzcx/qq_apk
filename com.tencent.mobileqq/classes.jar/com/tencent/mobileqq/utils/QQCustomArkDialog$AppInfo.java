package com.tencent.mobileqq.utils;

import android.os.Bundle;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.activity.aio.item.ArkAppContainer;

public class QQCustomArkDialog$AppInfo
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
  
  public QQCustomArkDialog$AppInfo(Bundle paramBundle)
  {
    this.jdField_a_of_type_JavaLangString = paramBundle.getString("appName");
    this.b = paramBundle.getString("appView");
    this.c = paramBundle.getString("appMinVersion");
    this.d = paramBundle.getString("metaData");
    this.jdField_a_of_type_Float = paramBundle.getFloat("scale", 1.0F);
    this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo = new SessionInfo();
    paramBundle = paramBundle.getString("troopUin");
    if (paramBundle != null)
    {
      this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int = 1;
      this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString = paramBundle;
    }
  }
  
  public static Bundle a(String paramString1, String paramString2, String paramString3, String paramString4, float paramFloat, String paramString5, Bundle paramBundle)
  {
    Bundle localBundle = paramBundle;
    if (paramBundle == null) {
      localBundle = new Bundle();
    }
    localBundle.putString("appName", paramString1);
    localBundle.putString("appMinVersion", paramString3);
    localBundle.putString("appView", paramString2);
    localBundle.putString("metaData", paramString4);
    localBundle.putFloat("scale", paramFloat);
    localBundle.putString("troopUin", paramString5);
    return localBundle;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.utils.QQCustomArkDialog.AppInfo
 * JD-Core Version:    0.7.0.1
 */