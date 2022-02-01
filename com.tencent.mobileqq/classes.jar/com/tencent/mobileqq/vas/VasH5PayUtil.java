package com.tencent.mobileqq.vas;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.qroute.route.ActivityURIRequest;
import com.tencent.mobileqq.vas.pay.api.IVasH5PayAdapter;
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
    localStringBuilder.append(paramString1);
    localStringBuilder.append("|");
    localStringBuilder.append(paramInt1);
    localStringBuilder.append("|");
    localStringBuilder.append(paramInt2);
    localStringBuilder.append("|");
    localStringBuilder.append(paramInt3);
    localStringBuilder.append("|");
    localStringBuilder.append(paramString2);
    if (QLog.isColorLevel())
    {
      paramString1 = new StringBuilder();
      paramString1.append("getOpenVipParam result = ");
      paramString1.append(localStringBuilder.toString());
      QLog.d("VasH5PayUtil", 2, paramString1.toString());
    }
    return localStringBuilder.toString();
  }
  
  private static StringBuilder a(String paramString1, String paramString2, int paramInt, boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3)
  {
    if ("SVHHZLH".equals(paramString2))
    {
      long l = 16781315L;
      if (paramBoolean3) {
        l = 0x1001003 | ((IVasH5PayAdapter)QRoute.api(IVasH5PayAdapter.class)).getWebViewTransparentConstants();
      }
      paramString2 = "0";
      localObject = "https://h5.qzone.qq.com/vip/payBigDialog/{openUin}/{openMonth}?_wv={wv}&_wwv=13&_proxy=1&aid={aid}".replace("{openUin}", "0");
      if (paramInt > 0) {
        paramString2 = String.valueOf(paramInt);
      }
      return new StringBuilder(((String)localObject).replace("{openMonth}", paramString2).replace("{aid}", paramString1).replace("{wv}", String.valueOf(l)));
    }
    Object localObject = new StringBuilder("https://h5.vip.qq.com/p/pay/index?_wv=524289&_fv=0&aid=");
    ((StringBuilder)localObject).append(paramString1);
    if ("CJCLUBT".equals(paramString2))
    {
      if (paramBoolean2) {
        ((StringBuilder)localObject).append("&type=!svip");
      } else {
        ((StringBuilder)localObject).append("&type=svip");
      }
    }
    else if ("LTMCLUB".equals(paramString2)) {
      ((StringBuilder)localObject).append("&type=vip");
    }
    if (paramInt > 0) {
      if (paramBoolean1)
      {
        paramString1 = new StringBuilder();
        paramString1.append("&month=!");
        paramString1.append(paramInt);
        ((StringBuilder)localObject).append(paramString1.toString());
      }
      else
      {
        paramString1 = new StringBuilder();
        paramString1.append("&month=");
        paramString1.append(paramInt);
        ((StringBuilder)localObject).append(paramString1.toString());
      }
    }
    return localObject;
  }
  
  private static StringBuilder a(String paramString1, String paramString2, String paramString3)
  {
    StringBuilder localStringBuilder = new StringBuilder("https://h5.vip.qq.com/p/pay/index?_wv=524289&_fv=0&aid=");
    localStringBuilder.append(paramString1);
    paramString1 = new StringBuilder();
    paramString1.append("&type=");
    paramString1.append(paramString2);
    localStringBuilder.append(paramString1.toString());
    paramString1 = new StringBuilder();
    paramString1.append("&month=");
    paramString1.append(paramString3);
    localStringBuilder.append(paramString1.toString());
    return localStringBuilder;
  }
  
  public static void a(Activity paramActivity, String paramString, int paramInt)
  {
    ActivityURIRequest localActivityURIRequest = new ActivityURIRequest(paramActivity, "/vas/h5pay");
    localActivityURIRequest.setRequestCode(paramInt);
    localActivityURIRequest.extra().putString("url", paramString);
    if (!(paramActivity instanceof Activity)) {
      localActivityURIRequest.setFlags(268435456);
    }
    QRoute.startUri(localActivityURIRequest, null);
  }
  
  public static void a(Activity paramActivity, String paramString1, String paramString2, int paramInt1, boolean paramBoolean1, boolean paramBoolean2, int paramInt2)
  {
    if (System.currentTimeMillis() - jdField_a_of_type_JavaLangLong.longValue() > 1000L)
    {
      jdField_a_of_type_JavaLangLong = Long.valueOf(System.currentTimeMillis());
      paramString1 = a(paramString1, paramString2, paramInt1, paramBoolean1, paramBoolean2, false);
      paramActivity = new ActivityURIRequest(paramActivity, "/vas/h5pay");
      paramActivity.setRequestCode(paramInt2);
      paramActivity.extra().putString("url", paramString1.toString());
      QRoute.startUri(paramActivity, null);
    }
  }
  
  public static void a(Activity paramActivity, String paramString1, String paramString2, String paramString3, int paramInt)
  {
    if (System.currentTimeMillis() - jdField_a_of_type_JavaLangLong.longValue() > 1000L)
    {
      jdField_a_of_type_JavaLangLong = Long.valueOf(System.currentTimeMillis());
      paramString1 = a(paramString1, paramString2, paramString3);
      paramActivity = new ActivityURIRequest(paramActivity, "/vas/h5pay");
      paramActivity.setRequestCode(paramInt);
      paramActivity.extra().putString("url", paramString1.toString());
      QRoute.startUri(paramActivity, null);
    }
  }
  
  public static void a(Context paramContext, Bundle paramBundle)
  {
    if (paramContext != null)
    {
      if (paramBundle == null) {
        return;
      }
      String str1 = paramBundle.getString(c);
      String str2 = paramBundle.getString(g);
      int j = paramBundle.getInt(b);
      String str3 = paramBundle.getString(jdField_a_of_type_JavaLangString);
      paramBundle.getString(d);
      paramBundle.getString(e);
      paramBundle.getString(f);
      paramBundle.getString(h);
      a(paramContext, str1, str2, j, str3, paramBundle.getString(i));
    }
  }
  
  public static void a(Context paramContext, String paramString)
  {
    ActivityURIRequest localActivityURIRequest = new ActivityURIRequest(paramContext, "/vas/h5pay");
    localActivityURIRequest.extra().putString("url", paramString);
    if (!(paramContext instanceof Activity)) {
      localActivityURIRequest.setFlags(268435456);
    }
    QRoute.startUri(localActivityURIRequest, null);
  }
  
  public static void a(Context paramContext, String paramString1, int paramInt, String paramString2, String paramString3, String paramString4, String paramString5)
  {
    paramString2 = ((IVasH5PayAdapter)QRoute.api(IVasH5PayAdapter.class)).getSvipCallbackSN();
    paramString4 = ((IVasH5PayAdapter)QRoute.api(IVasH5PayAdapter.class)).getDiyCardH5Pay();
    if (!TextUtils.isEmpty(paramString5))
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append(paramString2);
      localStringBuilder.append(paramString4);
      if (!paramString5.equals(localStringBuilder.toString()))
      {
        localStringBuilder = new StringBuilder();
        localStringBuilder.append(paramString2);
        localStringBuilder.append(paramString4);
        if (!paramString5.equals(localStringBuilder.toString())) {}
      }
      else
      {
        a(paramContext, paramString1, paramString3, paramInt, false, false, "hfpay");
        return;
      }
    }
    a(paramContext, paramString1, paramString3, paramInt, false, false);
  }
  
  public static void a(Context paramContext, String paramString1, int paramInt, String paramString2, String paramString3, String paramString4, String paramString5, boolean paramBoolean1, boolean paramBoolean2)
  {
    a(paramContext, paramString1, paramString3, paramInt, paramBoolean1, paramBoolean2);
  }
  
  private static void a(Context paramContext, String paramString1, String paramString2, int paramInt, String paramString3, String paramString4)
  {
    if (System.currentTimeMillis() - jdField_a_of_type_JavaLangLong.longValue() > 1000L)
    {
      jdField_a_of_type_JavaLangLong = Long.valueOf(System.currentTimeMillis());
      StringBuilder localStringBuilder = new StringBuilder();
      if (TextUtils.isEmpty(paramString4))
      {
        localStringBuilder.append("https://h5.vip.qq.com/p/pay/index?_wv=524289&_fv=0&aid=");
        if (!TextUtils.isEmpty(paramString1)) {
          localStringBuilder.append(paramString1);
        }
      }
      else
      {
        localStringBuilder.append(paramString4);
        if ((!TextUtils.isEmpty(paramString1)) && (!paramString4.contains("aid="))) {
          if (paramString4.contains("?"))
          {
            paramString4 = new StringBuilder();
            paramString4.append("&aid=");
            paramString4.append(paramString1);
            localStringBuilder.append(paramString4.toString());
          }
          else
          {
            paramString4 = new StringBuilder();
            paramString4.append("?aid=");
            paramString4.append(paramString1);
            localStringBuilder.append(paramString4.toString());
          }
        }
      }
      if (!TextUtils.isEmpty(paramString2))
      {
        paramString1 = new StringBuilder();
        paramString1.append("&type=");
        paramString1.append(paramString2);
        localStringBuilder.append(paramString1.toString());
      }
      if (!TextUtils.isEmpty(paramString3))
      {
        paramString1 = new StringBuilder();
        paramString1.append("&provideUin=");
        paramString1.append(paramString3);
        localStringBuilder.append(paramString1.toString());
      }
      if (paramInt > 0)
      {
        paramString1 = new StringBuilder();
        paramString1.append("&month=");
        paramString1.append(paramInt);
        localStringBuilder.append(paramString1.toString());
      }
      localStringBuilder.append("&isSend=1");
      paramContext = new ActivityURIRequest(paramContext, "/vas/h5pay");
      paramContext.extra().putString("url", localStringBuilder.toString());
      QRoute.startUri(paramContext, null);
    }
  }
  
  public static void a(Context paramContext, String paramString1, String paramString2, int paramInt, boolean paramBoolean1, boolean paramBoolean2)
  {
    a(paramContext, paramString1, paramString2, paramInt, paramBoolean1, paramBoolean2, "");
  }
  
  public static void a(Context paramContext, String paramString1, String paramString2, int paramInt, boolean paramBoolean1, boolean paramBoolean2, String paramString3)
  {
    a(paramContext, paramString1, paramString2, paramInt, paramBoolean1, paramBoolean2, paramString3, "", false, false);
  }
  
  public static void a(Context paramContext, String paramString1, String paramString2, int paramInt, boolean paramBoolean1, boolean paramBoolean2, String paramString3, String paramString4, boolean paramBoolean3, boolean paramBoolean4)
  {
    if (System.currentTimeMillis() - jdField_a_of_type_JavaLangLong.longValue() > 1000L)
    {
      jdField_a_of_type_JavaLangLong = Long.valueOf(System.currentTimeMillis());
      paramString1 = a(paramString1, paramString2, paramInt, paramBoolean1, paramBoolean2, paramBoolean4);
      if (!TextUtils.isEmpty(paramString3))
      {
        paramString2 = new StringBuilder();
        paramString2.append("&disableChannel=");
        paramString2.append(paramString3);
        paramString1.append(paramString2.toString());
      }
      if (paramBoolean3) {
        paramString1.append("&disableMobile=1");
      }
      if (!TextUtils.isEmpty(paramString4))
      {
        if (QLog.isColorLevel())
        {
          paramString2 = new StringBuilder();
          paramString2.append("openH5Pay callback = ");
          paramString2.append(paramString4);
          QLog.d("VasH5PayUtil", 2, paramString2.toString());
        }
        paramString2 = new StringBuilder();
        paramString2.append("&return_url=");
        paramString2.append(paramString4);
        paramString1.append(paramString2.toString());
      }
      paramContext = new ActivityURIRequest(paramContext, "/vas/h5pay");
      paramContext.extra().putString("url", paramString1.toString());
      QRoute.startUri(paramContext, null);
    }
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
      paramString = new StringBuilder();
      paramString.append("openClubPayWithParam param not correct: ");
      paramString.append(localObject);
      QLog.e("VasH5PayUtil", 2, paramString.toString());
      return;
    }
    String str2 = localObject[0];
    paramString = localObject[1];
    CharSequence localCharSequence = localObject[2];
    String str1 = localObject[3];
    localObject = localObject[4];
    boolean bool1;
    if (paramString.equals("1"))
    {
      bool1 = true;
    }
    else
    {
      if (!paramString.equals("0")) {
        break label256;
      }
      bool1 = false;
    }
    boolean bool2;
    if (str1.equals("1"))
    {
      bool2 = true;
    }
    else
    {
      if (!str1.equals("0")) {
        break label222;
      }
      bool2 = false;
    }
    if (!TextUtils.isDigitsOnly(localCharSequence))
    {
      paramString = new StringBuilder();
      paramString.append("openClubPayWithParam param openMonth not correct: ");
      paramString.append(localCharSequence);
      QLog.e("VasH5PayUtil", 2, paramString.toString());
      return;
    }
    a(paramContext, (String)localObject, str2, Integer.parseInt(localCharSequence), bool2, bool1);
    return;
    label222:
    paramString = new StringBuilder();
    paramString.append("openClubPayWithParam param hardMonth not correct: ");
    paramString.append(str1);
    QLog.e("VasH5PayUtil", 2, paramString.toString());
    return;
    label256:
    paramContext = new StringBuilder();
    paramContext.append("openClubPayWithParam param hardType not correct: ");
    paramContext.append(paramString);
    QLog.e("VasH5PayUtil", 2, paramContext.toString());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.vas.VasH5PayUtil
 * JD-Core Version:    0.7.0.1
 */