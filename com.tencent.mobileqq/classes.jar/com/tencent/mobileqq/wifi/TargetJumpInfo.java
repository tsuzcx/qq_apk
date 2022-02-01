package com.tencent.mobileqq.wifi;

import android.content.Context;
import android.text.TextUtils;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.util.BaseApplication;

public class TargetJumpInfo
{
  public int a;
  public String a;
  
  public TargetJumpInfo()
  {
    this.jdField_a_of_type_Int = 4;
    this.jdField_a_of_type_JavaLangString = "";
  }
  
  public static TargetJumpInfo a(QQAppInterface paramQQAppInterface)
  {
    TargetJumpInfo localTargetJumpInfo = new TargetJumpInfo();
    BaseApplication localBaseApplication = paramQQAppInterface.getApp();
    paramQQAppInterface = paramQQAppInterface.getCurrentAccountUin();
    int i = WifiSdkSharedPreUtils.a(localBaseApplication, paramQQAppInterface);
    if (i == 1)
    {
      localTargetJumpInfo.jdField_a_of_type_Int = 1;
      localTargetJumpInfo.jdField_a_of_type_JavaLangString = a(localBaseApplication, paramQQAppInterface);
      return localTargetJumpInfo;
    }
    if (i == 2)
    {
      localTargetJumpInfo.jdField_a_of_type_Int = 2;
      return localTargetJumpInfo;
    }
    if ((WifiSdkUtil.a(localBaseApplication)) && (WifiSdkUtil.b(localBaseApplication)) && (WifiSdkUtil.c(localBaseApplication)))
    {
      localTargetJumpInfo.jdField_a_of_type_Int = 4;
      return localTargetJumpInfo;
    }
    if (i == 3)
    {
      localTargetJumpInfo.jdField_a_of_type_Int = 3;
      localTargetJumpInfo.jdField_a_of_type_JavaLangString = a(localBaseApplication, paramQQAppInterface);
      return localTargetJumpInfo;
    }
    localTargetJumpInfo.jdField_a_of_type_Int = 5;
    return localTargetJumpInfo;
  }
  
  public static String a(Context paramContext, String paramString)
  {
    paramString = WifiSdkSharedPreUtils.b(paramContext, paramString);
    paramContext = paramString;
    if (TextUtils.isEmpty(paramString)) {
      paramContext = "https://sdi.3g.qq.com/v/2018082711463211194";
    }
    return paramContext;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.wifi.TargetJumpInfo
 * JD-Core Version:    0.7.0.1
 */