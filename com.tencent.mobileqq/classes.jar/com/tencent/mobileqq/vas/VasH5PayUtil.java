package com.tencent.mobileqq.vas;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.mobileqq.activity.QQVasH5PayBrowserActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.util.QLog;

public class VasH5PayUtil
{
  private static Long a;
  public static String a;
  public static String b = "openMonth";
  public static String c = "aid";
  public static String d = "offerId";
  public static String e = "serviceName";
  public static String f = "serviceCode";
  public static String g = "type";
  public static String h = "callbacksn";
  public static String i = "payUrl";
  
  static
  {
    jdField_a_of_type_JavaLangLong = Long.valueOf(0L);
    jdField_a_of_type_JavaLangString = "sendUin";
  }
  
  public static String a(String paramString1, int paramInt1, int paramInt2, int paramInt3, String paramString2)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(paramString1).append("|").append(paramInt1).append("|").append(paramInt2).append("|").append(paramInt3).append("|").append(paramString2);
    if (QLog.isColorLevel()) {
      QLog.d("VasH5PayUtil", 2, "getOpenVipParam result = " + localStringBuilder.toString());
    }
    return localStringBuilder.toString();
  }
  
  private static void a(Context paramContext, String paramString1, String paramString2, int paramInt, String paramString3, String paramString4)
  {
    StringBuilder localStringBuilder;
    if (System.currentTimeMillis() - jdField_a_of_type_JavaLangLong.longValue() > 1000L)
    {
      jdField_a_of_type_JavaLangLong = Long.valueOf(System.currentTimeMillis());
      localStringBuilder = new StringBuilder();
      if (!TextUtils.isEmpty(paramString4)) {
        break label189;
      }
      localStringBuilder.append("http://imgcache.qq.com/club/platform/lib/pay/wv_proxy.html?_wv=524289&_fv=0&aid=");
      if (!TextUtils.isEmpty(paramString1)) {
        localStringBuilder.append(paramString1);
      }
    }
    for (;;)
    {
      if (!TextUtils.isEmpty(paramString2)) {
        localStringBuilder.append("&type=" + paramString2);
      }
      if (!TextUtils.isEmpty(paramString3)) {
        localStringBuilder.append("&sendServiceUin=" + paramString3);
      }
      if (paramInt > 0) {
        localStringBuilder.append("&month=" + paramInt);
      }
      paramString1 = new Intent(paramContext, QQVasH5PayBrowserActivity.class);
      paramString1.putExtra("url", localStringBuilder.toString());
      paramContext.startActivity(paramString1);
      return;
      label189:
      localStringBuilder.append(paramString4);
      if ((!TextUtils.isEmpty(paramString1)) && (!paramString4.contains("aid="))) {
        if (paramString4.contains("?")) {
          localStringBuilder.append("&aid=" + paramString1);
        } else {
          localStringBuilder.append("?aid=" + paramString1);
        }
      }
    }
  }
  
  public static void a(Context paramContext, String paramString1, String paramString2, int paramInt, boolean paramBoolean1, boolean paramBoolean2)
  {
    a(paramContext, paramString1, paramString2, paramInt, paramBoolean1, paramBoolean2, "");
  }
  
  public static void a(Context paramContext, String paramString1, String paramString2, int paramInt, boolean paramBoolean1, boolean paramBoolean2, String paramString3)
  {
    StringBuilder localStringBuilder;
    if (System.currentTimeMillis() - jdField_a_of_type_JavaLangLong.longValue() > 1000L)
    {
      jdField_a_of_type_JavaLangLong = Long.valueOf(System.currentTimeMillis());
      localStringBuilder = new StringBuilder("http://imgcache.qq.com/club/platform/lib/pay/wv_proxy.html?_wv=524289&_fv=0&aid=");
      localStringBuilder.append(paramString1);
      if (!"CJCLUBT".equals(paramString2)) {
        break label174;
      }
      if (!paramBoolean2) {
        break label163;
      }
      localStringBuilder.append("&type=!svip");
      if (paramInt > 0)
      {
        if (!paramBoolean1) {
          break label194;
        }
        localStringBuilder.append("&month=!" + paramInt);
      }
    }
    for (;;)
    {
      if (!TextUtils.isEmpty(paramString3)) {
        localStringBuilder.append("&disableChannel=" + paramString3);
      }
      paramString1 = new Intent(paramContext, QQVasH5PayBrowserActivity.class);
      paramString1.putExtra("url", localStringBuilder.toString());
      paramContext.startActivity(paramString1);
      return;
      label163:
      localStringBuilder.append("&type=svip");
      break;
      label174:
      if (!"LTMCLUB".equals(paramString2)) {
        break;
      }
      localStringBuilder.append("&type=vip");
      break;
      label194:
      localStringBuilder.append("&month=" + paramInt);
    }
  }
  
  public static void a(QQAppInterface paramQQAppInterface, Context paramContext, Bundle paramBundle)
  {
    if ((paramQQAppInterface == null) || (paramContext == null) || (paramBundle == null)) {
      return;
    }
    paramQQAppInterface = paramBundle.getString(c);
    String str1 = paramBundle.getString(g);
    int j = paramBundle.getInt(b);
    String str2 = paramBundle.getString(jdField_a_of_type_JavaLangString);
    paramBundle.getString(d);
    paramBundle.getString(e);
    paramBundle.getString(f);
    paramBundle.getString(h);
    a(paramContext, paramQQAppInterface, str1, j, str2, paramBundle.getString(i));
  }
  
  public static void a(QQAppInterface paramQQAppInterface, Context paramContext, String paramString1, int paramInt, String paramString2, String paramString3, String paramString4, String paramString5)
  {
    if ((!TextUtils.isEmpty(paramString5)) && ((paramString5.equals("svipdiyCardH5Pay")) || (paramString5.equals("vipdiyCardH5Pay"))))
    {
      a(paramContext, paramString1, paramString3, paramInt, false, false, "hfpay");
      return;
    }
    a(paramContext, paramString1, paramString3, paramInt, false, false);
  }
  
  public static void a(QQAppInterface paramQQAppInterface, Context paramContext, String paramString1, int paramInt, String paramString2, String paramString3, String paramString4, String paramString5, boolean paramBoolean1, boolean paramBoolean2)
  {
    a(paramContext, paramString1, paramString3, paramInt, paramBoolean1, paramBoolean2);
  }
  
  public static void a(String paramString, Context paramContext)
  {
    if (TextUtils.isEmpty(paramString))
    {
      QLog.e("VasH5PayUtil", 2, "openClubPayWithParam param is empty");
      return;
    }
    if (paramContext == null)
    {
      QLog.e("VasH5PayUtil", 2, "openClubPayWithParam context is null");
      return;
    }
    Object localObject = paramString.split("\\|");
    if (localObject.length != 5)
    {
      QLog.e("VasH5PayUtil", 2, "openClubPayWithParam param not correct: " + localObject);
      return;
    }
    paramString = localObject[0];
    String str1 = localObject[1];
    CharSequence localCharSequence = localObject[2];
    String str2 = localObject[3];
    localObject = localObject[4];
    boolean bool1;
    boolean bool2;
    if (str1.equals("1"))
    {
      bool1 = true;
      if (!str2.equals("1")) {
        break label201;
      }
      bool2 = true;
    }
    for (;;)
    {
      if (!TextUtils.isDigitsOnly(localCharSequence))
      {
        QLog.e("VasH5PayUtil", 2, "openClubPayWithParam param openMonth not correct: " + localCharSequence);
        return;
        if (str1.equals("0"))
        {
          bool1 = false;
          break;
        }
        QLog.e("VasH5PayUtil", 2, "openClubPayWithParam param hardType not correct: " + str1);
        return;
        label201:
        if (str2.equals("0"))
        {
          bool2 = false;
        }
        else
        {
          QLog.e("VasH5PayUtil", 2, "openClubPayWithParam param hardMonth not correct: " + str2);
          return;
        }
      }
    }
    a(paramContext, (String)localObject, paramString, Integer.parseInt(localCharSequence), bool2, bool1);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\b.jar
 * Qualified Name:     com.tencent.mobileqq.vas.VasH5PayUtil
 * JD-Core Version:    0.7.0.1
 */