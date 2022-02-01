package com.tencent.mobileqq.persistence.bridge.corruption.interceptor;

import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Environment;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.entitymanager.Interceptor.Chain;
import com.tencent.mobileqq.database.corrupt.DBFixManager;
import com.tencent.mobileqq.persistence.EntityManagerFactory;
import com.tencent.mobileqq.statistics.StatisticCollector;
import com.tencent.mobileqq.util.SystemUtil;
import com.tencent.mobileqq.utils.DeviceInfoUtil;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.util.HashMap;
import java.util.Locale;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;

public class DBReportCorruptionInterceptor
  extends CorruptionInterceptor
{
  public Void a(Interceptor.Chain<Void> paramChain)
  {
    long l1 = 0L;
    Object localObject2 = a();
    if (localObject2 == null) {
      return null;
    }
    SharedPreferences localSharedPreferences = ((AppRuntime)localObject2).getApplication().getSharedPreferences(DBFixManager.b, 0);
    Object localObject1 = ((AppRuntime)localObject2).getApplication().getDatabasePath(((AppRuntime)localObject2).getAccount() + ".db");
    long l2;
    boolean bool;
    if (!localSharedPreferences.contains(((AppRuntime)localObject2).getAccount() + DBFixManager.g))
    {
      localSharedPreferences.edit().putBoolean(((AppRuntime)localObject2).getAccount() + DBFixManager.g, true).apply();
      EntityManagerFactory.corruptedTime = System.currentTimeMillis();
      if (!(localObject2 instanceof QQAppInterface)) {
        break label384;
      }
      l2 = ((File)localObject1).length();
      if ((!((File)localObject1).exists()) || (((File)localObject1).length() <= 0L) || (!SystemUtil.a()) || (SystemUtil.a() <= ((File)localObject1).length())) {
        break label378;
      }
      localObject2 = new File(Environment.getExternalStorageDirectory().getPath() + "/tencent/msflogs/corruptInfo");
      if (((File)localObject2).exists()) {
        break label378;
      }
      bool = FileUtils.a((File)localObject1, (File)localObject2);
      l1 = ((File)localObject2).length();
    }
    for (;;)
    {
      localObject1 = EntityManagerFactory.getSqliteLibraryVersion();
      localObject2 = new HashMap();
      ((HashMap)localObject2).put("param_ROM", DeviceInfoUtil.j());
      ((HashMap)localObject2).put("isCopySucc", String.valueOf(bool));
      ((HashMap)localObject2).put("totalLen", String.valueOf(l2));
      ((HashMap)localObject2).put("copyLen", String.valueOf(l1));
      ((HashMap)localObject2).put("sqliteVer", localObject1);
      QLog.i("DataReportCorruptionHandler", 1, String.format(Locale.getDefault(), "db corrupt, totalLen:%d, clen:%d, sqliteVer:%s", new Object[] { Long.valueOf(l2), Long.valueOf(l1), localObject1 }));
      a((HashMap)localObject2);
      return (Void)paramChain.proceed();
      label378:
      bool = false;
      continue;
      label384:
      l2 = 0L;
      bool = false;
    }
  }
  
  void a(HashMap<String, String> paramHashMap)
  {
    StatisticCollector.getInstance(BaseApplication.getContext()).collectPerformance(null, "actSqliteDatabaseCorrupt", true, -1L, 0L, paramHashMap, null, false);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.persistence.bridge.corruption.interceptor.DBReportCorruptionInterceptor
 * JD-Core Version:    0.7.0.1
 */