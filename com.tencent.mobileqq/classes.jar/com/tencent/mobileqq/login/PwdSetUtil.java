package com.tencent.mobileqq.login;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Build;
import android.os.Build.VERSION;
import androidx.collection.ArrayMap;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.phonelogin.PhoneNumLoginImpl;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.utils.DialogUtil;
import com.tencent.mobileqq.utils.QQCustomDialog;
import com.tencent.mobileqq.vas.webview.util.VasWebviewUtil;
import com.tencent.qphone.base.util.QLog;
import java.net.URLEncoder;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;

public class PwdSetUtil
{
  private static ArrayMap<String, Long> a = new ArrayMap();
  
  public static void a(String paramString, Activity paramActivity, AppInterface paramAppInterface)
  {
    a("https://accounts.qq.com/cn2/change_psw/mobile/mobile_change_psw_reg_input_psw", paramString, paramActivity, paramAppInterface);
  }
  
  public static void a(String paramString1, String paramString2, Activity paramActivity, AppInterface paramAppInterface)
  {
    if (paramActivity == null)
    {
      QLog.e("PwdSetUtil", 1, "gotoPwdSetWebsite: activity is null");
      return;
    }
    if (paramString1.contains("?"))
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append(paramString1);
      ((StringBuilder)localObject).append("&");
      paramString1 = ((StringBuilder)localObject).toString();
    }
    else
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append(paramString1);
      ((StringBuilder)localObject).append("?");
      paramString1 = ((StringBuilder)localObject).toString();
    }
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append(paramString1);
    ((StringBuilder)localObject).append("uin=");
    ((StringBuilder)localObject).append(paramString2);
    ((StringBuilder)localObject).append("&plat=1&app=1&version=");
    ((StringBuilder)localObject).append("8.8.17.5770");
    ((StringBuilder)localObject).append("&device=");
    ((StringBuilder)localObject).append(URLEncoder.encode(Build.DEVICE));
    ((StringBuilder)localObject).append("&system=");
    ((StringBuilder)localObject).append(Build.VERSION.RELEASE);
    ((StringBuilder)localObject).append("&systemInt=");
    ((StringBuilder)localObject).append(Build.VERSION.SDK_INT);
    paramString1 = ((StringBuilder)localObject).toString();
    localObject = new Intent();
    ((Intent)localObject).putExtra("url", paramString1);
    ((Intent)localObject).putExtra("portraitOnly", true);
    ((Intent)localObject).putExtra("uin", paramString2);
    ((Intent)localObject).putExtra("hide_operation_bar", true);
    ((Intent)localObject).putExtra("hide_more_button", true);
    VasWebviewUtil.a(paramActivity, paramString1, 32768L, (Intent)localObject, false, -1);
    ReportController.b(paramAppInterface, "CliOper", "", "", "Mobile_signup", "Setiing_pw_tips", 0, 0, "", "", "", "");
  }
  
  public static boolean a(AppInterface paramAppInterface, Activity paramActivity)
  {
    String str = paramAppInterface.getCurrentAccountUin();
    if (PhoneNumLoginImpl.a().a(paramAppInterface, str)) {
      return false;
    }
    QLog.d("PwdSetUtil", 1, "checkHasSetPwd: not set");
    if (paramActivity == null)
    {
      QLog.e("PwdSetUtil", 1, "gotoPwdSetWebsite: activity is null");
      return false;
    }
    QQCustomDialog localQQCustomDialog = DialogUtil.a(paramActivity, 230);
    localQQCustomDialog.setTitle(2131914105);
    localQQCustomDialog.setMessage(2131914104);
    paramAppInterface = new PwdSetUtil.1(str, paramActivity, paramAppInterface);
    paramActivity = new PwdSetUtil.2();
    localQQCustomDialog.setPositiveButton(2131914103, paramAppInterface);
    localQQCustomDialog.setNegativeButton(2131887648, paramActivity);
    localQQCustomDialog.show();
    return true;
  }
  
  public static boolean a(AppRuntime paramAppRuntime)
  {
    if (paramAppRuntime == null) {
      return false;
    }
    MobileQQ localMobileQQ = paramAppRuntime.getApplication();
    if (localMobileQQ == null) {
      return false;
    }
    String str = paramAppRuntime.getCurrentAccountUin();
    if (PhoneNumLoginImpl.a().a(paramAppRuntime, str))
    {
      QLog.d("PwdSetUtil", 1, "shouldShowSetPwdBanner: current account hasSetPwd");
      return false;
    }
    Object localObject = (Long)a.get(str);
    if (localObject != null)
    {
      paramAppRuntime = (AppRuntime)localObject;
      if (((Long)localObject).longValue() != 0L) {}
    }
    else
    {
      paramAppRuntime = localMobileQQ.getSharedPreferences("pwd_sharedpref", 0);
      if (paramAppRuntime == null) {
        return false;
      }
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("pwd_ts_key");
      ((StringBuilder)localObject).append(str);
      paramAppRuntime = Long.valueOf(paramAppRuntime.getLong(((StringBuilder)localObject).toString(), 0L));
      a.put(str, paramAppRuntime);
    }
    if (System.currentTimeMillis() - paramAppRuntime.longValue() > 86400000L)
    {
      QLog.d("PwdSetUtil", 1, "shouldShowSetPwdBanner: interval larger than one day");
      return true;
    }
    return false;
  }
  
  public static void b(AppRuntime paramAppRuntime)
  {
    if (paramAppRuntime == null) {
      return;
    }
    Object localObject = paramAppRuntime.getApplication();
    if (localObject == null) {
      return;
    }
    paramAppRuntime = paramAppRuntime.getCurrentAccountUin();
    long l = System.currentTimeMillis();
    a.put(paramAppRuntime, Long.valueOf(l));
    localObject = ((MobileQQ)localObject).getSharedPreferences("pwd_sharedpref", 0);
    if (localObject == null) {
      return;
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("pwd_ts_key");
    localStringBuilder.append(paramAppRuntime);
    paramAppRuntime = localStringBuilder.toString();
    ((SharedPreferences)localObject).edit().putLong(paramAppRuntime, l).apply();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.login.PwdSetUtil
 * JD-Core Version:    0.7.0.1
 */