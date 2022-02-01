package com.tencent.mobileqq.teamwork;

import android.text.TextUtils;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.teamwork.api.IGetExternalInterface;
import com.tencent.mobileqq.teamwork.bean.TeamWorkFileImportInfo;
import com.tencent.qphone.base.util.QLog;
import java.util.Collection;
import java.util.Random;
import mqq.app.MobileQQ;

public class CommonUtils
{
  public static String a = "tencentdoc_url_config";
  public static String b = "tencentdoc_pre_img_url_doc";
  public static String c = "tencentdoc_pre_img_url_sheet";
  public static String d = "tencentdoc_pre_img_url_miniproj_doc";
  public static String e = "tencentdoc_pre_img_url_miniproj_sheet";
  public static String f = "tencentdoc_olc_pref";
  
  public static Long a()
  {
    return Long.valueOf((int)(System.currentTimeMillis() / 1000L) << 32 | Math.abs(new Random().nextInt()));
  }
  
  public static String a(TeamWorkFileImportInfo paramTeamWorkFileImportInfo)
  {
    if (paramTeamWorkFileImportInfo.a == 1) {
      return paramTeamWorkFileImportInfo.d;
    }
    return paramTeamWorkFileImportInfo.o;
  }
  
  public static String a(String paramString)
  {
    String str = paramString;
    if (paramString != null)
    {
      str = paramString;
      if (paramString.length() > 0)
      {
        int i = paramString.lastIndexOf('.');
        str = paramString;
        if (i > -1)
        {
          str = paramString;
          if (i < paramString.length()) {
            str = paramString.substring(0, i);
          }
        }
      }
    }
    return str;
  }
  
  public static void a(AppInterface paramAppInterface)
  {
    if (paramAppInterface == null)
    {
      if (QLog.isColorLevel()) {
        QLog.d("CommonUtils", 2, "voice input helper preInit invalid app");
      }
      return;
    }
    if ((paramAppInterface instanceof AppInterface))
    {
      paramAppInterface = paramAppInterface.getApplication();
      if (paramAppInterface != null)
      {
        paramAppInterface = paramAppInterface.getApplicationContext();
        ((IGetExternalInterface)QRoute.api(IGetExternalInterface.class)).soLibraryCheckerExecute(paramAppInterface);
        if (QLog.isColorLevel()) {
          QLog.d("CommonUtils", 2, "voice input helper preInit doing");
        }
      }
      else if (QLog.isColorLevel())
      {
        QLog.d("CommonUtils", 2, "voice input helper preInit app.getApplication() is empty");
      }
    }
    else if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("voice input helper preInit app isn't QQAppInterface, app=");
      localStringBuilder.append(paramAppInterface);
      QLog.d("CommonUtils", 2, localStringBuilder.toString());
    }
  }
  
  public static boolean a(Collection paramCollection)
  {
    return (paramCollection != null) && (!paramCollection.isEmpty());
  }
  
  public static String b(String paramString)
  {
    if (!TextUtils.isEmpty(paramString))
    {
      int i = paramString.indexOf(":");
      if (i > 0) {
        return paramString.substring(0, i).toLowerCase();
      }
    }
    return "";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\tmp\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.teamwork.CommonUtils
 * JD-Core Version:    0.7.0.1
 */