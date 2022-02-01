package com.tencent.open.downloadnew;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.text.TextUtils;
import com.tencent.open.adapter.CommonDataAdapter;
import com.tencent.open.base.LogUtility;
import com.tencent.open.business.base.AppUtil;
import com.tencent.open.business.base.OpenConfig;
import com.tencent.qqmini.sdk.launcher.utils.OSUtils;
import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class ControlPolicyUtil
{
  public static String a(int paramInt, String paramString)
  {
    boolean bool = "biz_src_zf_games".equals(paramString);
    String str = "Common_InstallYYB_Install_Words";
    if (bool)
    {
      if (paramInt != 1)
      {
        if (paramInt == 2) {
          break label52;
        }
        if (paramInt == 3) {
          break label46;
        }
        if (paramInt == 4) {}
      }
      else
      {
        paramString = "Common_GC_InstallYYB_Install_Words";
        break label136;
      }
      paramString = "Common_GC_UpdateYYB_Update_Words";
      break label136;
      label46:
      paramString = "Common_GC_UpdateYYB_Install_Words";
      break label136;
      label52:
      paramString = "Common_GC_InstallYYB_Update_Words";
    }
    else if ("biz_src_jc_update".equals(paramString))
    {
      if (paramInt != 1)
      {
        if (paramInt != 3) {
          paramString = null;
        } else {
          paramString = "Common_QQUpdate_UpdateYYB_Update_Words";
        }
      }
      else {
        paramString = "Common_QQUpdate_InstallYYB_Update_Words";
      }
    }
    else
    {
      paramString = str;
      if (paramInt != 1) {
        if (paramInt != 2)
        {
          if (paramInt != 3)
          {
            if (paramInt != 4) {
              paramString = str;
            } else {
              paramString = "Common_UpdateYYB_Update_Words";
            }
          }
          else {
            paramString = "Common_UpdateYYB_Install_Words";
          }
        }
        else {
          paramString = "Common_InstallYYB_Update_Words";
        }
      }
    }
    label136:
    return OpenConfig.a(CommonDataAdapter.a().b(), null).c(paramString);
  }
  
  public static boolean a()
  {
    return true;
  }
  
  public static boolean a(long paramLong)
  {
    SharedPreferences localSharedPreferences = CommonDataAdapter.a().b().getSharedPreferences("share_myAppApi", 0);
    SharedPreferences.Editor localEditor = localSharedPreferences.edit();
    long l = localSharedPreferences.getLong("SP_Lastest_require_time", paramLong);
    if (paramLong - l >= f())
    {
      localEditor.putLong("SP_Lastest_require_time", paramLong);
      localEditor.commit();
      return true;
    }
    return paramLong == l;
  }
  
  public static void b(long paramLong)
  {
    SharedPreferences.Editor localEditor = CommonDataAdapter.a().b().getSharedPreferences("share_myAppApi", 0).edit();
    localEditor.putLong("SP_Lastest_require_time", paramLong);
    localEditor.commit();
  }
  
  public static boolean b()
  {
    Object localObject = DownloadManager.b().d("1101070898");
    if (localObject != null) {
      localObject = ((DownloadInfo)localObject).q;
    } else {
      localObject = "";
    }
    return (TextUtils.isEmpty((CharSequence)localObject)) || (!new File((String)localObject).exists());
  }
  
  public static String c()
  {
    return OpenConfig.a(CommonDataAdapter.a().b(), null).c("Common_myapp_download_url");
  }
  
  public static boolean c(long paramLong)
  {
    Calendar localCalendar1 = Calendar.getInstance();
    localCalendar1.setTime(new Date(System.currentTimeMillis()));
    Calendar localCalendar2 = Calendar.getInstance();
    localCalendar2.setTime(new Date(paramLong));
    return (localCalendar2.get(1) == localCalendar1.get(1)) && (localCalendar2.get(6) - localCalendar1.get(6) == 0);
  }
  
  public static boolean d()
  {
    return OpenConfig.a(CommonDataAdapter.a().b(), null).d("Common_root_autoinstall_flag") <= 0;
  }
  
  public static long e()
  {
    return OpenConfig.a(CommonDataAdapter.a().b(), null).e("Common_tips_dialog_interval");
  }
  
  public static long f()
  {
    return OpenConfig.a(CommonDataAdapter.a().b(), null).e("Common_require_root_interval");
  }
  
  public static boolean g()
  {
    return (AppUtil.d("com.tencent.android.qqdownloader") > 4001126) && (OpenConfig.a(CommonDataAdapter.a().b(), null).g("Common_QQ_CARRY_IDENTITY"));
  }
  
  public static boolean h()
  {
    Object localObject = OpenConfig.a(CommonDataAdapter.a().b(), null).c("Common_Release_Control").trim();
    if (TextUtils.isEmpty((CharSequence)localObject)) {
      return true;
    }
    if (((String)localObject).equals("-1")) {
      return true;
    }
    if (((String)localObject).equals("-2")) {
      return false;
    }
    localObject = ((String)localObject).split(";");
    if (localObject == null) {
      return true;
    }
    String str1 = String.valueOf(CommonDataAdapter.a().c());
    if (str1 == null) {
      return false;
    }
    int j = localObject.length;
    int i = 0;
    while (i < j)
    {
      String str2 = localObject[i];
      if ((str2.length() == 2) && (str1.endsWith(str2))) {
        return true;
      }
      i += 1;
    }
    return false;
  }
  
  public static boolean i()
  {
    if (!OpenConfig.a(CommonDataAdapter.a().b(), null).g("Common_Show_Dialog_Flag")) {
      return false;
    }
    Object localObject = CommonDataAdapter.a().b().getSharedPreferences("share_myAppApi", 0);
    boolean bool = ((SharedPreferences)localObject).getBoolean("SP_Has_shown_Dialog", false);
    if (OpenConfig.a(CommonDataAdapter.a().b(), null).f("Common_Dialog_Only_Once_Flag")) {
      return !bool;
    }
    int i = OpenConfig.a(CommonDataAdapter.a().b(), null).d("Common_Max_Count");
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(" maxCount = ");
    localStringBuilder.append(i);
    LogUtility.c("OpenConfig-MyAppApi", localStringBuilder.toString());
    if (i != -1)
    {
      if (i == 0) {
        return true;
      }
      int j = ((SharedPreferences)localObject).getInt("SP_Show_Dialog_Count", 0);
      localObject = ((SharedPreferences)localObject).getString("SP_Show_Dialog_Date", "");
      if (new SimpleDateFormat("yyyy年MM月dd日").format(new Date(System.currentTimeMillis())).equals(localObject)) {
        return j < i;
      }
    }
    return true;
  }
  
  public static void j()
  {
    if (!OpenConfig.a(CommonDataAdapter.a().b(), null).g("Common_Show_Dialog_Flag")) {
      return;
    }
    Object localObject = CommonDataAdapter.a().b().getSharedPreferences("share_myAppApi", 0);
    SharedPreferences.Editor localEditor = ((SharedPreferences)localObject).edit();
    boolean bool = OpenConfig.a(CommonDataAdapter.a().b(), null).f("Common_Dialog_Only_Once_Flag");
    int i = 1;
    if (bool)
    {
      localEditor.putBoolean("SP_Has_shown_Dialog", true);
      localEditor.commit();
      return;
    }
    int j = OpenConfig.a(CommonDataAdapter.a().b(), null).d("Common_Max_Count");
    if (j != -1)
    {
      if (j == 0) {
        return;
      }
      j = ((SharedPreferences)localObject).getInt("SP_Show_Dialog_Count", 0);
      localObject = ((SharedPreferences)localObject).getString("SP_Show_Dialog_Date", "");
      String str = new SimpleDateFormat("yyyy年MM月dd日").format(new Date(System.currentTimeMillis()));
      if (str.equals(localObject)) {
        i = 1 + j;
      }
      localEditor.putInt("SP_Show_Dialog_Count", i);
      localEditor.putString("SP_Show_Dialog_Date", str);
      localEditor.commit();
    }
  }
  
  public static boolean k()
  {
    return OpenConfig.a(CommonDataAdapter.a().b(), null).g("Common_MyAppDownload_Flag");
  }
  
  public static boolean l()
  {
    return OpenConfig.a(CommonDataAdapter.a().b(), null).g("Common_Detail_Page");
  }
  
  public static boolean m()
  {
    boolean bool = OpenConfig.a(CommonDataAdapter.a().b(), null).h("Common_tmast_wake");
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(">>allowTmastWake allowWake = ");
    localStringBuilder.append(bool);
    LogUtility.c("TAMST_WAKE", localStringBuilder.toString());
    return (bool) && (n());
  }
  
  public static boolean n()
  {
    long l1 = OpenConfig.a(CommonDataAdapter.a().b(), null).e("Common_wake_limite");
    long l2 = OpenConfig.a(CommonDataAdapter.a().b(), null).e("Common_wake_interval") * 1000L;
    Object localObject = CommonDataAdapter.a().b();
    boolean bool2 = false;
    localObject = ((Context)localObject).getSharedPreferences("share_myAppApi", 0);
    int i = ((SharedPreferences)localObject).getInt("tmast_wake_times", 0);
    long l3 = ((SharedPreferences)localObject).getLong("tmast_wake_last_time", 0L);
    boolean bool3 = c(l3);
    if (!bool3) {
      i = 0;
    }
    localObject = new StringBuilder();
    ((StringBuilder)localObject).append(">>allowTmastWake  wakeLimit = ");
    ((StringBuilder)localObject).append(l1);
    ((StringBuilder)localObject).append(" wakeInterval = ");
    ((StringBuilder)localObject).append(l2);
    ((StringBuilder)localObject).append(" wakeTimes = ");
    ((StringBuilder)localObject).append(i);
    ((StringBuilder)localObject).append(" isToday = ");
    ((StringBuilder)localObject).append(bool3);
    LogUtility.c("TAMST_WAKE", ((StringBuilder)localObject).toString());
    boolean bool1 = bool2;
    if (i < l1) {
      if (System.currentTimeMillis() - l3 <= l2)
      {
        bool1 = bool2;
        if (bool3) {}
      }
      else
      {
        bool1 = true;
      }
    }
    return bool1;
  }
  
  public static void o()
  {
    OpenConfig.a(CommonDataAdapter.a().b(), null);
  }
  
  public static boolean p()
  {
    boolean bool1 = t();
    boolean bool2 = false;
    if (!bool1) {
      return false;
    }
    bool1 = bool2;
    if (OpenConfig.a(CommonDataAdapter.a().b(), null).h("Common_YYB_Wake"))
    {
      bool1 = bool2;
      if (n()) {
        bool1 = true;
      }
    }
    return bool1;
  }
  
  public static boolean q()
  {
    return OpenConfig.a(CommonDataAdapter.a().b(), null).h("Common_YYB_InstWake");
  }
  
  public static boolean r()
  {
    return OpenConfig.a(CommonDataAdapter.a().b(), null).h("Common_YYB_TmastWake_870");
  }
  
  public static boolean s()
  {
    return OpenConfig.a(CommonDataAdapter.a().b(), null).h("Common_YYB_BgWake");
  }
  
  public static boolean t()
  {
    if (!u()) {
      return true;
    }
    return OpenConfig.a(CommonDataAdapter.a().b(), null).h("Common_YYB_MiUi12Wake");
  }
  
  public static boolean u()
  {
    String str = OSUtils.getMIUIVersion();
    if (TextUtils.isEmpty(str)) {
      return false;
    }
    try
    {
      int i = Integer.parseInt(str.substring(1));
      if (i >= 12) {
        return true;
      }
    }
    catch (Throwable localThrowable)
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("parseInt error:");
      localStringBuilder.append(localThrowable.getMessage());
      LogUtility.e("ControlPolicyUtil", localStringBuilder.toString());
    }
    return false;
  }
  
  public static void v()
  {
    Object localObject = CommonDataAdapter.a().b();
    int i = 0;
    localObject = ((Context)localObject).getSharedPreferences("share_myAppApi", 0);
    SharedPreferences.Editor localEditor = ((SharedPreferences)localObject).edit();
    int j = ((SharedPreferences)localObject).getInt("tmast_wake_times", 0);
    if (c(((SharedPreferences)localObject).getLong("tmast_wake_last_time", 0L))) {
      i = j;
    }
    localEditor.putInt("tmast_wake_times", i + 1);
    localEditor.putLong("tmast_wake_last_time", System.currentTimeMillis());
    localEditor.commit();
  }
  
  public static boolean w()
  {
    return OpenConfig.a(CommonDataAdapter.a().b(), null).g("Common_yyb_wifi_download_Switch");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.tencent.open.downloadnew.ControlPolicyUtil
 * JD-Core Version:    0.7.0.1
 */