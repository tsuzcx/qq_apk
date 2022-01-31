package com.tencent.mobileqq.database.corrupt;

import abwh;
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
import com.tencent.mobileqq.music.QQPlayerService;
import com.tencent.mobileqq.service.message.MessageCache;
import com.tencent.mobileqq.statistics.StatisticCollector;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.util.HashMap;
import mqq.app.AppRuntime.Status;
import mqq.app.MobileQQ;
import mqq.manager.Manager;

public class DBFixManager
  implements Manager
{
  public static int a;
  public static long a;
  public static boolean a;
  public static int b;
  public static String b;
  public static int c;
  public static String c;
  public static int d;
  public static String d;
  public static int e;
  public static String e;
  public static int f;
  public static String f;
  public static String g;
  public static String h;
  public static String i;
  public static String j;
  public static String k;
  public static String l = "dbcorrupt_report_nodb";
  public static String m = "dbcorrupt_report_copy_fail";
  public static String n = "dbcorrupt_report_fix";
  private static String o = "DBFix";
  Context jdField_a_of_type_AndroidContentContext;
  public QQAppInterface a;
  String jdField_a_of_type_JavaLangString;
  
  static
  {
    jdField_b_of_type_JavaLangString = "dbfix";
    jdField_c_of_type_JavaLangString = "dbfix_config";
    jdField_d_of_type_JavaLangString = "dbfix_flag";
    jdField_e_of_type_JavaLangString = "dbfix_count";
    jdField_a_of_type_Int = 5;
    jdField_a_of_type_Long = -1L;
    jdField_c_of_type_Int = 5;
    jdField_f_of_type_JavaLangString = "key_dbfixso_load_count";
    g = "dbcorrupt_flag";
    h = "dbcorrupt_report_fix_succ";
    i = "dbcorrupt_report_fix_fail";
    j = "dbcorrupt_report_fix_other";
    k = "fix_fail_reason";
    jdField_d_of_type_Int = 1;
    jdField_e_of_type_Int = 2;
    jdField_f_of_type_Int = 3;
  }
  
  public DBFixManager(QQAppInterface paramQQAppInterface)
  {
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
    this.jdField_a_of_type_AndroidContentContext = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp();
    this.jdField_a_of_type_JavaLangString = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin();
  }
  
  public void a()
  {
    Intent localIntent = new Intent(this.jdField_a_of_type_AndroidContentContext, DBFixDialogActivity.class);
    localIntent.addFlags(268435456);
    localIntent.addFlags(536870912);
    localIntent.addFlags(67108864);
    localIntent.addFlags(131072);
    this.jdField_a_of_type_AndroidContentContext.startActivity(localIntent);
  }
  
  public void a(Context paramContext)
  {
    ThreadManager.postImmediately(new abwh(this), null, true);
  }
  
  public void a(Context paramContext, boolean paramBoolean)
  {
    SharedPreferences localSharedPreferences = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApplication().getSharedPreferences(jdField_b_of_type_JavaLangString, 0);
    String str = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin();
    boolean bool = localSharedPreferences.getBoolean(str + jdField_d_of_type_JavaLangString, false);
    if ((paramBoolean) && (bool)) {}
    do
    {
      do
      {
        return;
        if (!b()) {
          break;
        }
      } while (!QLog.isColorLevel());
      QLog.d(o, 2, "onCorruptionInstant, db fixing");
      return;
      File localFile = this.jdField_a_of_type_AndroidContentContext.getDatabasePath(this.jdField_a_of_type_JavaLangString + ".db");
      if ((localFile.exists()) && (localFile.length() != 0L)) {
        break;
      }
      QLog.d(o, 1, new Object[] { "onCorruptionInstant, db not exists, ", Boolean.valueOf(localFile.exists()) });
      localSharedPreferences.edit().remove(str + g).commit();
    } while (!bool);
    paramContext = localSharedPreferences.edit();
    paramContext.remove(str + jdField_d_of_type_JavaLangString);
    paramContext.remove(str + jdField_e_of_type_JavaLangString);
    paramContext.commit();
    return;
    if (paramBoolean) {
      a();
    }
    for (;;)
    {
      paramContext = localSharedPreferences.edit();
      if ((!TextUtils.isEmpty(str)) && (!bool)) {
        paramContext.putBoolean(str + jdField_d_of_type_JavaLangString, true);
      }
      int i1 = localSharedPreferences.getInt(str + jdField_e_of_type_JavaLangString, 0);
      str = str + jdField_e_of_type_JavaLangString;
      i1 += 1;
      paramContext.putInt(str, i1);
      paramContext.commit();
      QLog.d(o, 1, new Object[] { "onCorruptionInstant, start activity and write sp ", Integer.valueOf(i1), " onCorrupt: ", Boolean.valueOf(paramBoolean) });
      return;
      new DBFixDialogUI(paramContext, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface).b();
    }
  }
  
  public void a(boolean paramBoolean)
  {
    if (paramBoolean)
    {
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.sendOnlineStatus(AppRuntime.Status.offline, false, 0L);
      Intent localIntent = new Intent("mqq.intent.action.EXIT" + this.jdField_a_of_type_AndroidContentContext.getPackageName());
      this.jdField_a_of_type_AndroidContentContext.sendBroadcast(localIntent);
      return;
    }
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.l();
  }
  
  public boolean a()
  {
    if ((!jdField_a_of_type_Boolean) && (jdField_b_of_type_Int == 0)) {
      jdField_b_of_type_Int = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApplication().getSharedPreferences(jdField_b_of_type_JavaLangString, 0).getInt(this.jdField_a_of_type_JavaLangString + jdField_f_of_type_JavaLangString, 0);
    }
    boolean bool;
    if ((!jdField_a_of_type_Boolean) && (jdField_b_of_type_Int <= jdField_c_of_type_Int))
    {
      if (Build.VERSION.SDK_INT >= 18) {
        break label219;
      }
      if ((!SoLoadUtilNew.loadSoByName(BaseApplicationImpl.getContext(), "sqlite_qq")) || (!SoLoadUtilNew.loadSoByName(BaseApplicationImpl.getContext(), "DBFix"))) {
        break label214;
      }
      bool = true;
      jdField_a_of_type_Boolean = bool;
      label110:
      if (jdField_a_of_type_Boolean) {
        break label233;
      }
      jdField_b_of_type_Int += 1;
      QLog.e(o, 1, new Object[] { "db fix so load failed, ", Integer.valueOf(jdField_b_of_type_Int) });
    }
    for (;;)
    {
      SharedPreferences.Editor localEditor = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApplication().getSharedPreferences(jdField_b_of_type_JavaLangString, 0).edit();
      localEditor.putInt(this.jdField_a_of_type_JavaLangString + jdField_f_of_type_JavaLangString, jdField_b_of_type_Int);
      localEditor.commit();
      return jdField_a_of_type_Boolean;
      label214:
      bool = false;
      break;
      label219:
      jdField_a_of_type_Boolean = SoLoadUtilNew.loadSoByName(BaseApplicationImpl.getContext(), "DBFix");
      break label110;
      label233:
      jdField_b_of_type_Int = 0;
    }
  }
  
  public void b()
  {
    String str = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin();
    if (!TextUtils.isEmpty(str))
    {
      QLog.d(o, 1, "clearLocalSPFlag, remove sp");
      SharedPreferences.Editor localEditor = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApplication().getSharedPreferences(jdField_b_of_type_JavaLangString, 0).edit();
      localEditor.remove(str + jdField_d_of_type_JavaLangString);
      localEditor.remove(str + jdField_e_of_type_JavaLangString);
      localEditor.commit();
    }
    MessageCache.j();
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp().getSharedPreferences("acc_info" + this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getAccount(), 0).edit().putBoolean("isFriendlistok", false).commit();
    QLog.d(o, 1, "cleared friendlist flag");
  }
  
  public void b(boolean paramBoolean)
  {
    Object localObject = this.jdField_a_of_type_AndroidContentContext.getDatabasePath(this.jdField_a_of_type_JavaLangString + ".db");
    long l1 = ((File)localObject).length();
    FileUtils.d(((File)localObject).getPath());
    FileUtils.d(this.jdField_a_of_type_AndroidContentContext.getDatabasePath(this.jdField_a_of_type_JavaLangString + ".db-journal").getPath());
    FileUtils.d(this.jdField_a_of_type_AndroidContentContext.getDatabasePath(this.jdField_a_of_type_JavaLangString + "-wal").getPath());
    FileUtils.d(this.jdField_a_of_type_AndroidContentContext.getDatabasePath(this.jdField_a_of_type_JavaLangString + "-shm").getPath());
    if (!paramBoolean)
    {
      localObject = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApplication().getSharedPreferences(jdField_b_of_type_JavaLangString, 0);
      ((SharedPreferences)localObject).edit().remove(this.jdField_a_of_type_JavaLangString + g).commit();
      localObject = ((SharedPreferences)localObject).getString(this.jdField_a_of_type_JavaLangString + k, "");
      HashMap localHashMap = new HashMap();
      localHashMap.put("failReason", localObject);
      localHashMap.put("dblen", String.valueOf(l1));
      StatisticCollector.a(BaseApplication.getContext()).a(null, i, true, -1L, 0L, localHashMap, null, false);
      QLog.d(o, 1, new Object[] { "onCorruptionInstant, deleteDbFile, isSuc: ", Boolean.valueOf(paramBoolean), " failReason: ", localObject });
    }
  }
  
  public boolean b()
  {
    return DBFixDialogUI.a != null;
  }
  
  public void c()
  {
    QLog.d(o, 1, "exitQQMainProcess");
    a(false);
    QLog.flushLog();
    if (QQPlayerService.a())
    {
      Intent localIntent = new Intent();
      localIntent.setAction("qqplayer_exit_action");
      this.jdField_a_of_type_AndroidContentContext.sendBroadcast(localIntent);
    }
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.b(false);
  }
  
  public native boolean dbfixRepair(String paramString1, String paramString2, DBFixResult paramDBFixResult);
  
  public native boolean dumpRepair(String paramString1, String paramString2, DBFixResult paramDBFixResult);
  
  public void onDestroy() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.mobileqq.database.corrupt.DBFixManager
 * JD-Core Version:    0.7.0.1
 */