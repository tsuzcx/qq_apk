package com.tencent.mobileqq.database.corrupt;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Build.VERSION;
import android.text.TextUtils;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.commonsdk.soload.SoLoadUtilNew;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.listentogether.player.QQMusicPlayService;
import com.tencent.mobileqq.music.QQPlayerService;
import com.tencent.mobileqq.onlinestatus.api.IOnlineStatusService;
import com.tencent.mobileqq.statistics.StatisticCollector;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import mqq.app.AppRuntime.Status;
import mqq.app.MobileQQ;
import mqq.manager.Manager;

public class DBFixManager
  implements Manager
{
  public static int a = 5;
  public static long a = -1L;
  public static boolean a = false;
  public static int b = 0;
  public static String b = "dbfix";
  public static int c = 5;
  public static String c = "dbfix_config";
  public static int d = 1;
  public static String d = "dbfix_flag";
  public static int e = 2;
  public static String e = "dbfix_count";
  public static int f = 3;
  public static String f = "key_dbfixso_load_count";
  public static String g = "dbcorrupt_flag";
  public static String h = "dbcorrupt_report_fix_zero";
  public static String i = "dbcorrupt_report_fix_succ";
  public static String j = "dbcorrupt_report_fix_fail";
  public static String k = "dbcorrupt_report_fix_other";
  public static String l = "fix_fail_reason";
  public static String m = "dbcorrupt_report_nodb";
  public static String n = "dbcorrupt_report_copy_fail";
  public static String o = "dbcorrupt_report_fix";
  private static String p = "DBFix";
  Context jdField_a_of_type_AndroidContentContext;
  QQAppInterface jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
  String jdField_a_of_type_JavaLangString;
  
  public DBFixManager(QQAppInterface paramQQAppInterface)
  {
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
    this.jdField_a_of_type_AndroidContentContext = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp();
    this.jdField_a_of_type_JavaLangString = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin();
  }
  
  public static void a()
  {
    Object localObject1 = BaseApplicationImpl.getApplication().getRuntime();
    if ((localObject1 != null) && ((localObject1 instanceof QQAppInterface)))
    {
      localObject1 = (QQAppInterface)localObject1;
      Object localObject2 = ((QQAppInterface)localObject1).getApp().getSharedPreferences(((QQAppInterface)localObject1).getCurrentAccountUin(), 0);
      localObject1 = ((SharedPreferences)localObject2).edit();
      ((SharedPreferences.Editor)localObject1).remove("getMsgV4_vSyncCookie");
      ((SharedPreferences.Editor)localObject1).remove("getlastMessageTime");
      ((SharedPreferences.Editor)localObject1).remove("getMsgV4_vPubAccountCookie");
      ((SharedPreferences.Editor)localObject1).remove("getTroopDiscMsgLastTime");
      localObject2 = ((SharedPreferences)localObject2).getAll().entrySet().iterator();
      while (((Iterator)localObject2).hasNext())
      {
        String str = (String)((Map.Entry)((Iterator)localObject2).next()).getKey();
        if ((!TextUtils.isEmpty(str)) && ((str.startsWith("getTroopLastMessageTime")) || (str.startsWith("getDiscussionLastMessageTime")))) {
          ((SharedPreferences.Editor)localObject1).remove(str);
        }
      }
      ((SharedPreferences.Editor)localObject1).commit();
      QLog.e(p, 1, "clearAllMsgSyncFlags");
    }
  }
  
  public void a(Context paramContext)
  {
    ThreadManager.postImmediately(new DBFixManager.1(this), null, true);
  }
  
  public void a(Context paramContext, boolean paramBoolean)
  {
    Object localObject1 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApplication().getSharedPreferences(jdField_b_of_type_JavaLangString, 0);
    String str = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin();
    Object localObject2 = new StringBuilder();
    ((StringBuilder)localObject2).append(str);
    ((StringBuilder)localObject2).append(d);
    boolean bool = ((SharedPreferences)localObject1).getBoolean(((StringBuilder)localObject2).toString(), false);
    if ((paramBoolean) && (bool)) {
      return;
    }
    if (b())
    {
      if (QLog.isColorLevel()) {
        QLog.d(p, 2, "onCorruptionInstant, db fixing");
      }
      return;
    }
    localObject2 = this.jdField_a_of_type_AndroidContentContext;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(this.jdField_a_of_type_JavaLangString);
    localStringBuilder.append(".db");
    localObject2 = ((Context)localObject2).getDatabasePath(localStringBuilder.toString());
    if ((((File)localObject2).exists()) && (((File)localObject2).length() != 0L))
    {
      if (paramBoolean) {
        b();
      } else {
        new DBFixDialogUI(paramContext, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface).b();
      }
      paramContext = ((SharedPreferences)localObject1).edit();
      if ((!TextUtils.isEmpty(str)) && (!bool))
      {
        localObject2 = new StringBuilder();
        ((StringBuilder)localObject2).append(str);
        ((StringBuilder)localObject2).append(d);
        paramContext.putBoolean(((StringBuilder)localObject2).toString(), true);
      }
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append(str);
      ((StringBuilder)localObject2).append(e);
      int i1 = ((SharedPreferences)localObject1).getInt(((StringBuilder)localObject2).toString(), 0);
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append(str);
      ((StringBuilder)localObject1).append(e);
      str = ((StringBuilder)localObject1).toString();
      i1 += 1;
      paramContext.putInt(str, i1);
      paramContext.commit();
      QLog.d(p, 1, new Object[] { "onCorruptionInstant, start activity and write sp ", Integer.valueOf(i1), " onCorrupt: ", Boolean.valueOf(paramBoolean) });
      return;
    }
    QLog.d(p, 1, new Object[] { "onCorruptionInstant, db not exists, ", Boolean.valueOf(((File)localObject2).exists()) });
    paramContext = ((SharedPreferences)localObject1).edit();
    localObject2 = new StringBuilder();
    ((StringBuilder)localObject2).append(str);
    ((StringBuilder)localObject2).append(g);
    paramContext.remove(((StringBuilder)localObject2).toString()).commit();
    if (bool)
    {
      paramContext = ((SharedPreferences)localObject1).edit();
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append(str);
      ((StringBuilder)localObject1).append(d);
      paramContext.remove(((StringBuilder)localObject1).toString());
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append(str);
      ((StringBuilder)localObject1).append(e);
      paramContext.remove(((StringBuilder)localObject1).toString());
      paramContext.commit();
    }
  }
  
  public void a(boolean paramBoolean)
  {
    if (paramBoolean)
    {
      ((IOnlineStatusService)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getRuntimeService(IOnlineStatusService.class)).sendOnlineStatus(AppRuntime.Status.offline, false, 0L, false);
      Object localObject = new StringBuilder();
      ((StringBuilder)localObject).append("mqq.intent.action.EXIT");
      ((StringBuilder)localObject).append(this.jdField_a_of_type_AndroidContentContext.getPackageName());
      localObject = new Intent(((StringBuilder)localObject).toString());
      this.jdField_a_of_type_AndroidContentContext.sendBroadcast((Intent)localObject);
      return;
    }
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.sendRegisterPush();
  }
  
  public boolean a()
  {
    Object localObject;
    StringBuilder localStringBuilder;
    if ((!jdField_a_of_type_Boolean) && (jdField_b_of_type_Int == 0))
    {
      localObject = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApplication().getSharedPreferences(jdField_b_of_type_JavaLangString, 0);
      localStringBuilder = new StringBuilder();
      localStringBuilder.append(this.jdField_a_of_type_JavaLangString);
      localStringBuilder.append(f);
      jdField_b_of_type_Int = ((SharedPreferences)localObject).getInt(localStringBuilder.toString(), 0);
    }
    if ((!jdField_a_of_type_Boolean) && (jdField_b_of_type_Int <= c))
    {
      if (Build.VERSION.SDK_INT < 18)
      {
        boolean bool;
        if ((SoLoadUtilNew.loadSoByName(BaseApplicationImpl.getContext(), "sqlite_qq")) && (SoLoadUtilNew.loadSoByName(BaseApplicationImpl.getContext(), "DBFix"))) {
          bool = true;
        } else {
          bool = false;
        }
        jdField_a_of_type_Boolean = bool;
      }
      else
      {
        jdField_a_of_type_Boolean = SoLoadUtilNew.loadSoByName(BaseApplicationImpl.getContext(), "DBFix");
      }
      if (!jdField_a_of_type_Boolean)
      {
        jdField_b_of_type_Int += 1;
        QLog.e(p, 1, new Object[] { "db fix so load failed, ", Integer.valueOf(jdField_b_of_type_Int) });
      }
      else
      {
        jdField_b_of_type_Int = 0;
      }
      localObject = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApplication().getSharedPreferences(jdField_b_of_type_JavaLangString, 0).edit();
      localStringBuilder = new StringBuilder();
      localStringBuilder.append(this.jdField_a_of_type_JavaLangString);
      localStringBuilder.append(f);
      ((SharedPreferences.Editor)localObject).putInt(localStringBuilder.toString(), jdField_b_of_type_Int);
      ((SharedPreferences.Editor)localObject).commit();
    }
    return jdField_a_of_type_Boolean;
  }
  
  public void b()
  {
    Intent localIntent = new Intent(this.jdField_a_of_type_AndroidContentContext, DBFixDialogActivity.class);
    localIntent.addFlags(268435456);
    localIntent.addFlags(536870912);
    localIntent.addFlags(67108864);
    localIntent.addFlags(131072);
    this.jdField_a_of_type_AndroidContentContext.startActivity(localIntent);
  }
  
  public void b(boolean paramBoolean)
  {
    Object localObject1 = this.jdField_a_of_type_AndroidContentContext;
    Object localObject2 = new StringBuilder();
    ((StringBuilder)localObject2).append(this.jdField_a_of_type_JavaLangString);
    ((StringBuilder)localObject2).append(".db");
    localObject1 = ((Context)localObject1).getDatabasePath(((StringBuilder)localObject2).toString());
    long l1 = ((File)localObject1).length();
    FileUtils.deleteFile(((File)localObject1).getPath());
    localObject1 = this.jdField_a_of_type_AndroidContentContext;
    localObject2 = new StringBuilder();
    ((StringBuilder)localObject2).append(this.jdField_a_of_type_JavaLangString);
    ((StringBuilder)localObject2).append(".db-journal");
    FileUtils.deleteFile(((Context)localObject1).getDatabasePath(((StringBuilder)localObject2).toString()).getPath());
    localObject1 = this.jdField_a_of_type_AndroidContentContext;
    localObject2 = new StringBuilder();
    ((StringBuilder)localObject2).append(this.jdField_a_of_type_JavaLangString);
    ((StringBuilder)localObject2).append("-wal");
    FileUtils.deleteFile(((Context)localObject1).getDatabasePath(((StringBuilder)localObject2).toString()).getPath());
    localObject1 = this.jdField_a_of_type_AndroidContentContext;
    localObject2 = new StringBuilder();
    ((StringBuilder)localObject2).append(this.jdField_a_of_type_JavaLangString);
    ((StringBuilder)localObject2).append("-shm");
    FileUtils.deleteFile(((Context)localObject1).getDatabasePath(((StringBuilder)localObject2).toString()).getPath());
    if (!paramBoolean)
    {
      localObject1 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApplication().getSharedPreferences(jdField_b_of_type_JavaLangString, 0);
      localObject2 = ((SharedPreferences)localObject1).edit();
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append(this.jdField_a_of_type_JavaLangString);
      localStringBuilder.append(g);
      ((SharedPreferences.Editor)localObject2).remove(localStringBuilder.toString()).commit();
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append(this.jdField_a_of_type_JavaLangString);
      ((StringBuilder)localObject2).append(l);
      localObject1 = ((SharedPreferences)localObject1).getString(((StringBuilder)localObject2).toString(), "");
      localObject2 = new HashMap();
      ((HashMap)localObject2).put("failReason", localObject1);
      ((HashMap)localObject2).put("dblen", String.valueOf(l1));
      StatisticCollector.getInstance(BaseApplication.getContext()).collectPerformance(null, j, true, -1L, 0L, (HashMap)localObject2, null, false);
      QLog.d(p, 1, new Object[] { "onCorruptionInstant, deleteDbFile, isSuc: ", Boolean.valueOf(paramBoolean), " failReason: ", localObject1 });
    }
  }
  
  public boolean b()
  {
    return DBFixDialogUI.a != null;
  }
  
  public void c()
  {
    Object localObject1 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin();
    if (!TextUtils.isEmpty((CharSequence)localObject1))
    {
      QLog.d(p, 1, "clearLocalSPFlag, remove sp");
      localObject2 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApplication().getSharedPreferences(jdField_b_of_type_JavaLangString, 0).edit();
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append((String)localObject1);
      localStringBuilder.append(d);
      ((SharedPreferences.Editor)localObject2).remove(localStringBuilder.toString());
      localStringBuilder = new StringBuilder();
      localStringBuilder.append((String)localObject1);
      localStringBuilder.append(e);
      ((SharedPreferences.Editor)localObject2).remove(localStringBuilder.toString());
      ((SharedPreferences.Editor)localObject2).commit();
    }
    a();
    localObject1 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp();
    Object localObject2 = new StringBuilder();
    ((StringBuilder)localObject2).append("acc_info");
    ((StringBuilder)localObject2).append(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getAccount());
    ((BaseApplication)localObject1).getSharedPreferences(((StringBuilder)localObject2).toString(), 0).edit().putBoolean("isFriendlistok", false).commit();
    QLog.d(p, 1, "cleared friendlist flag");
  }
  
  public void d()
  {
    QLog.d(p, 1, "exitQQMainProcess");
    a(false);
    QLog.flushLog();
    if (QQPlayerService.a())
    {
      Intent localIntent = new Intent();
      localIntent.setAction("qqplayer_exit_action");
      this.jdField_a_of_type_AndroidContentContext.sendBroadcast(localIntent);
    }
    QQMusicPlayService.b(p);
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.exit(false);
  }
  
  public native boolean dbfixRepair(String paramString1, String paramString2, DBFixResult paramDBFixResult);
  
  public native boolean dumpRepair(String paramString1, String paramString2, DBFixResult paramDBFixResult);
  
  public void onDestroy() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.database.corrupt.DBFixManager
 * JD-Core Version:    0.7.0.1
 */