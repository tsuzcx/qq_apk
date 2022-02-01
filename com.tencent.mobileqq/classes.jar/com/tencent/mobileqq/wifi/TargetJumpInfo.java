package com.tencent.mobileqq.wifi;

import android.content.Context;
import android.text.TextUtils;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.util.BaseApplication;

public class TargetJumpInfo
{
  public int a = 4;
  public String b = "";
  
  public static TargetJumpInfo a(QQAppInterface paramQQAppInterface)
  {
    TargetJumpInfo localTargetJumpInfo = new TargetJumpInfo();
    BaseApplication localBaseApplication = paramQQAppInterface.getApp();
    paramQQAppInterface = paramQQAppInterface.getCurrentAccountUin();
    int i = WifiSdkSharedPreUtils.b(localBaseApplication, paramQQAppInterface);
    if (i == 1)
    {
      localTargetJumpInfo.a = 1;
      localTargetJumpInfo.b = a(localBaseApplication, paramQQAppInterface);
      return localTargetJumpInfo;
    }
    if (i == 2)
    {
      localTargetJumpInfo.a = 2;
      return localTargetJumpInfo;
    }
    if ((WifiSdkUtil.c(localBaseApplication)) && (WifiSdkUtil.d(localBaseApplication)) && (WifiSdkUtil.e(localBaseApplication)))
    {
      localTargetJumpInfo.a = 4;
      return localTargetJumpInfo;
    }
    if (i == 3)
    {
      localTargetJumpInfo.a = 3;
      localTargetJumpInfo.b = a(localBaseApplication, paramQQAppInterface);
      return localTargetJumpInfo;
    }
    localTargetJumpInfo.a = 5;
    return localTargetJumpInfo;
  }
  
  public static String a(Context paramContext, String paramString)
  {
    paramString = WifiSdkSharedPreUtils.c(paramContext, paramString);
    paramContext = paramString;
    if (TextUtils.isEmpty(paramString)) {
      paramContext = "https://sdi.3g.qq.com/v/2018082711463211194";
    }
    return paramContext;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.tencent.mobileqq.wifi.TargetJumpInfo
 * JD-Core Version:    0.7.0.1
 */