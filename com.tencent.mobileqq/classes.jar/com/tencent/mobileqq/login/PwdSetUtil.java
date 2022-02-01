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
import com.tencent.mobileqq.vaswebviewplugin.VasWebviewUtil;
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
    if (paramString1.contains("?")) {}
    for (paramString1 = paramString1 + "&";; paramString1 = paramString1 + "?")
    {
      paramString1 = paramString1 + "uin=" + paramString2 + "&plat=1&app=1&version=" + "8.5.5.5105" + "&device=" + URLEncoder.encode(Build.DEVICE) + "&system=" + Build.VERSION.RELEASE + "&systemInt=" + Build.VERSION.SDK_INT;
      Intent localIntent = new Intent();
      localIntent.putExtra("url", paramString1);
      localIntent.putExtra("portraitOnly", true);
      localIntent.putExtra("uin", paramString2);
      localIntent.putExtra("hide_operation_bar", true);
      localIntent.putExtra("hide_more_button", true);
      VasWebviewUtil.openQQBrowserActivity(paramActivity, paramString1, 32768L, localIntent, false, -1);
      ReportController.b(paramAppInterface, "CliOper", "", "", "Mobile_signup", "Setiing_pw_tips", 0, 0, "", "", "", "");
      return;
    }
  }
  
  public static void a(AppRuntime paramAppRuntime)
  {
    if (paramAppRuntime == null) {}
    Object localObject;
    long l;
    do
    {
      do
      {
        return;
        localObject = paramAppRuntime.getApplication();
      } while (localObject == null);
      paramAppRuntime = paramAppRuntime.getCurrentAccountUin();
      l = System.currentTimeMillis();
      a.put(paramAppRuntime, Long.valueOf(l));
      localObject = ((MobileQQ)localObject).getSharedPreferences("pwd_sharedpref", 0);
    } while (localObject == null);
    paramAppRuntime = "pwd_ts_key" + paramAppRuntime;
    ((SharedPreferences)localObject).edit().putLong(paramAppRuntime, l).apply();
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
    localQQCustomDialog.setTitle(2131716989);
    localQQCustomDialog.setMessage(2131716988);
    paramAppInterface = new PwdSetUtil.1(str, paramActivity, paramAppInterface);
    paramActivity = new PwdSetUtil.2();
    localQQCustomDialog.setPositiveButton(2131716987, paramAppInterface);
    localQQCustomDialog.setNegativeButton(2131690800, paramActivity);
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
    Long localLong = (Long)a.get(str);
    if (localLong != null)
    {
      paramAppRuntime = localLong;
      if (localLong.longValue() != 0L) {}
    }
    else
    {
      paramAppRuntime = localMobileQQ.getSharedPreferences("pwd_sharedpref", 0);
      if (paramAppRuntime == null) {
        return false;
      }
      paramAppRuntime = Long.valueOf(paramAppRuntime.getLong("pwd_ts_key" + str, 0L));
      a.put(str, paramAppRuntime);
    }
    if (System.currentTimeMillis() - paramAppRuntime.longValue() > 86400000L)
    {
      QLog.d("PwdSetUtil", 1, "shouldShowSetPwdBanner: interval larger than one day");
      return true;
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.login.PwdSetUtil
 * JD-Core Version:    0.7.0.1
 */