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
  public static String d = "dbfix";
  public static String e = "dbfix_config";
  public static String f = "dbfix_flag";
  public static String g = "dbfix_count";
  public static int h = 5;
  public static long i = -1L;
  public static boolean j = false;
  public static int k = 0;
  public static int l = 5;
  public static String m = "key_dbfixso_load_count";
  public static String n = "dbcorrupt_flag";
  public static String o = "dbcorrupt_report_fix_zero";
  public static String p = "dbcorrupt_report_fix_succ";
  public static String q = "dbcorrupt_report_fix_fail";
  public static String r = "dbcorrupt_report_fix_other";
  public static String s = "fix_fail_reason";
  public static int t = 1;
  public static int u = 2;
  public static int v = 3;
  public static String w = "dbcorrupt_report_nodb";
  public static String x = "dbcorrupt_report_copy_fail";
  public static String y = "dbcorrupt_report_fix";
  private static String z = "DBFix";
  QQAppInterface a;
  Context b;
  String c;
  
  public DBFixManager(QQAppInterface paramQQAppInterface)
  {
    this.a = paramQQAppInterface;
    this.b = this.a.getApp();
    this.c = this.a.getCurrentAccountUin();
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
      QLog.e(z, 1, "clearAllMsgSyncFlags");
    }
  }
  
  public void a(int paramInt)
  {
    Intent localIntent = new Intent(this.b, DBFixDialogActivity.class);
    localIntent.addFlags(268435456);
    localIntent.addFlags(536870912);
    localIntent.addFlags(67108864);
    localIntent.addFlags(131072);
    localIntent.putExtra(g, paramInt);
    this.b.startActivity(localIntent);
  }
  
  public void a(Context paramContext)
  {
    ThreadManager.postImmediately(new DBFixManager.1(this), null, true);
  }
  
  public void a(Context paramContext, boolean paramBoolean)
  {
    Object localObject1 = this.a.getApplication().getSharedPreferences(d, 0);
    String str = this.a.getCurrentAccountUin();
    Object localObject2 = new StringBuilder();
    ((StringBuilder)localObject2).append(str);
    ((StringBuilder)localObject2).append(f);
    boolean bool = ((SharedPreferences)localObject1).getBoolean(((StringBuilder)localObject2).toString(), false);
    if ((paramBoolean) && (bool)) {
      return;
    }
    if (e())
    {
      if (QLog.isColorLevel()) {
        QLog.d(z, 2, "onCorruptionInstant, db fixing");
      }
      return;
    }
    localObject2 = this.b;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(this.c);
    localStringBuilder.append(".db");
    localObject2 = ((Context)localObject2).getDatabasePath(localStringBuilder.toString());
    if ((((File)localObject2).exists()) && (((File)localObject2).length() != 0L))
    {
      localObject2 = ((SharedPreferences)localObject1).edit();
      if ((!TextUtils.isEmpty(str)) && (!bool))
      {
        localStringBuilder = new StringBuilder();
        localStringBuilder.append(str);
        localStringBuilder.append(f);
        ((SharedPreferences.Editor)localObject2).putBoolean(localStringBuilder.toString(), true);
      }
      localStringBuilder = new StringBuilder();
      localStringBuilder.append(str);
      localStringBuilder.append(g);
      int i1 = ((SharedPreferences)localObject1).getInt(localStringBuilder.toString(), 0);
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append(str);
      ((StringBuilder)localObject1).append(g);
      str = ((StringBuilder)localObject1).toString();
      i1 += 1;
      ((SharedPreferences.Editor)localObject2).putInt(str, i1);
      ((SharedPreferences.Editor)localObject2).commit();
      QLog.d(z, 1, new Object[] { "onCorruptionInstant, start activity and write sp ", Integer.valueOf(i1), " onCorrupt: ", Boolean.valueOf(paramBoolean) });
      if (paramBoolean)
      {
        a(i1);
        return;
      }
      new DBFixDialogUI(paramContext, this.a).a(i1);
      return;
    }
    QLog.d(z, 1, new Object[] { "onCorruptionInstant, db not exists, ", Boolean.valueOf(((File)localObject2).exists()) });
    paramContext = ((SharedPreferences)localObject1).edit();
    localObject2 = new StringBuilder();
    ((StringBuilder)localObject2).append(str);
    ((StringBuilder)localObject2).append(n);
    paramContext.remove(((StringBuilder)localObject2).toString()).commit();
    if (bool)
    {
      paramContext = ((SharedPreferences)localObject1).edit();
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append(str);
      ((StringBuilder)localObject1).append(f);
      paramContext.remove(((StringBuilder)localObject1).toString());
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append(str);
      ((StringBuilder)localObject1).append(g);
      paramContext.remove(((StringBuilder)localObject1).toString());
      paramContext.commit();
    }
  }
  
  public void a(boolean paramBoolean)
  {
    if (paramBoolean)
    {
      ((IOnlineStatusService)this.a.getRuntimeService(IOnlineStatusService.class)).sendOnlineStatus(AppRuntime.Status.offline, false, 0L, false);
      Object localObject = new StringBuilder();
      ((StringBuilder)localObject).append("mqq.intent.action.EXIT");
      ((StringBuilder)localObject).append(this.b.getPackageName());
      localObject = new Intent(((StringBuilder)localObject).toString());
      this.b.sendBroadcast((Intent)localObject);
      return;
    }
    this.a.sendRegisterPush();
  }
  
  public void b(boolean paramBoolean)
  {
    Object localObject1 = this.b;
    Object localObject2 = new StringBuilder();
    ((StringBuilder)localObject2).append(this.c);
    ((StringBuilder)localObject2).append(".db");
    localObject1 = ((Context)localObject1).getDatabasePath(((StringBuilder)localObject2).toString());
    long l1 = ((File)localObject1).length();
    FileUtils.deleteFile(((File)localObject1).getPath());
    localObject1 = this.b;
    localObject2 = new StringBuilder();
    ((StringBuilder)localObject2).append(this.c);
    ((StringBuilder)localObject2).append(".db-journal");
    FileUtils.deleteFile(((Context)localObject1).getDatabasePath(((StringBuilder)localObject2).toString()).getPath());
    localObject1 = this.b;
    localObject2 = new StringBuilder();
    ((StringBuilder)localObject2).append(this.c);
    ((StringBuilder)localObject2).append(".db-wal");
    localObject1 = ((Context)localObject1).getDatabasePath(((StringBuilder)localObject2).toString());
    localObject2 = ((File)localObject1).getAbsolutePath();
    boolean bool1 = ((File)localObject1).exists();
    boolean bool2 = FileUtils.deleteFile((String)localObject2);
    QLog.d(z, 1, new Object[] { "deleteDbFile walDeleteResult:", Boolean.valueOf(bool2), ", file exist: ", Boolean.valueOf(bool1), ", walPath: ", localObject2 });
    localObject1 = this.b;
    localObject2 = new StringBuilder();
    ((StringBuilder)localObject2).append(this.c);
    ((StringBuilder)localObject2).append(".db-shm");
    localObject1 = ((Context)localObject1).getDatabasePath(((StringBuilder)localObject2).toString());
    localObject2 = ((File)localObject1).getAbsolutePath();
    bool1 = ((File)localObject1).exists();
    bool2 = FileUtils.deleteFile((String)localObject2);
    QLog.d(z, 1, new Object[] { "deleteDbFile shmDeleteResult:", Boolean.valueOf(bool2), ", file exist: ", Boolean.valueOf(bool1), ", shmPath: ", localObject2 });
    if (!paramBoolean)
    {
      localObject1 = this.a.getApplication().getSharedPreferences(d, 0);
      localObject2 = ((SharedPreferences)localObject1).edit();
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append(this.c);
      localStringBuilder.append(n);
      ((SharedPreferences.Editor)localObject2).remove(localStringBuilder.toString()).commit();
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append(this.c);
      ((StringBuilder)localObject2).append(s);
      localObject1 = ((SharedPreferences)localObject1).getString(((StringBuilder)localObject2).toString(), "");
      localObject2 = new HashMap();
      ((HashMap)localObject2).put("failReason", localObject1);
      ((HashMap)localObject2).put("dblen", String.valueOf(l1));
      StatisticCollector.getInstance(BaseApplication.getContext()).collectPerformance(null, q, true, -1L, 0L, (HashMap)localObject2, null, false);
      QLog.d(z, 1, new Object[] { "onCorruptionInstant, deleteDbFile, isSuc: ", Boolean.valueOf(paramBoolean), " failReason: ", localObject1 });
    }
  }
  
  public boolean b()
  {
    Object localObject;
    StringBuilder localStringBuilder;
    if ((!j) && (k == 0))
    {
      localObject = this.a.getApplication().getSharedPreferences(d, 0);
      localStringBuilder = new StringBuilder();
      localStringBuilder.append(this.c);
      localStringBuilder.append(m);
      k = ((SharedPreferences)localObject).getInt(localStringBuilder.toString(), 0);
    }
    if ((!j) && (k <= l))
    {
      if (Build.VERSION.SDK_INT < 18)
      {
        boolean bool;
        if ((SoLoadUtilNew.loadSoByName(BaseApplicationImpl.getContext(), "sqlite_qq")) && (SoLoadUtilNew.loadSoByName(BaseApplicationImpl.getContext(), "DBFix"))) {
          bool = true;
        } else {
          bool = false;
        }
        j = bool;
      }
      else
      {
        j = SoLoadUtilNew.loadSoByName(BaseApplicationImpl.getContext(), "DBFix");
      }
      if (!j)
      {
        k += 1;
        QLog.e(z, 1, new Object[] { "db fix so load failed, ", Integer.valueOf(k) });
      }
      else
      {
        k = 0;
      }
      localObject = this.a.getApplication().getSharedPreferences(d, 0).edit();
      localStringBuilder = new StringBuilder();
      localStringBuilder.append(this.c);
      localStringBuilder.append(m);
      ((SharedPreferences.Editor)localObject).putInt(localStringBuilder.toString(), k);
      ((SharedPreferences.Editor)localObject).commit();
    }
    return j;
  }
  
  public void c()
  {
    Object localObject1 = this.a.getCurrentAccountUin();
    if (!TextUtils.isEmpty((CharSequence)localObject1))
    {
      QLog.d(z, 1, "clearLocalSPFlag, remove sp");
      localObject2 = this.a.getApplication().getSharedPreferences(d, 0).edit();
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append((String)localObject1);
      localStringBuilder.append(f);
      ((SharedPreferences.Editor)localObject2).remove(localStringBuilder.toString());
      localStringBuilder = new StringBuilder();
      localStringBuilder.append((String)localObject1);
      localStringBuilder.append(g);
      ((SharedPreferences.Editor)localObject2).remove(localStringBuilder.toString());
      ((SharedPreferences.Editor)localObject2).commit();
    }
    a();
    localObject1 = this.a.getApp();
    Object localObject2 = new StringBuilder();
    ((StringBuilder)localObject2).append("acc_info");
    ((StringBuilder)localObject2).append(this.a.getAccount());
    ((BaseApplication)localObject1).getSharedPreferences(((StringBuilder)localObject2).toString(), 0).edit().putBoolean("isFriendlistok", false).commit();
    QLog.d(z, 1, "cleared friendlist flag");
  }
  
  public void d()
  {
    QLog.d(z, 1, "exitQQMainProcess");
    a(false);
    QLog.flushLog();
    if (QQPlayerService.b())
    {
      Intent localIntent = new Intent();
      localIntent.setAction("qqplayer_exit_action");
      this.b.sendBroadcast(localIntent);
    }
    QQMusicPlayService.b(z);
    this.a.exit(false);
  }
  
  public boolean e()
  {
    return DBFixDialogUI.d != null;
  }
  
  public void onDestroy() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.database.corrupt.DBFixManager
 * JD-Core Version:    0.7.0.1
 */