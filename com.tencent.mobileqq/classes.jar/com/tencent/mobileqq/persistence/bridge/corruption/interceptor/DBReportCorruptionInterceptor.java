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
    Object localObject1 = a();
    if (localObject1 == null) {
      return null;
    }
    Object localObject3 = ((AppRuntime)localObject1).getApplication().getSharedPreferences(DBFixManager.d, 0);
    Object localObject2 = ((AppRuntime)localObject1).getApplication();
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(((AppRuntime)localObject1).getAccount());
    localStringBuilder.append(".db");
    localObject2 = ((MobileQQ)localObject2).getDatabasePath(localStringBuilder.toString());
    localStringBuilder = new StringBuilder();
    localStringBuilder.append(((AppRuntime)localObject1).getAccount());
    localStringBuilder.append(DBFixManager.n);
    if (!((SharedPreferences)localObject3).contains(localStringBuilder.toString()))
    {
      localObject3 = ((SharedPreferences)localObject3).edit();
      localStringBuilder = new StringBuilder();
      localStringBuilder.append(((AppRuntime)localObject1).getAccount());
      localStringBuilder.append(DBFixManager.n);
      ((SharedPreferences.Editor)localObject3).putBoolean(localStringBuilder.toString(), true).apply();
      EntityManagerFactory.corruptedTime = System.currentTimeMillis();
      boolean bool = localObject1 instanceof QQAppInterface;
      long l3 = 0L;
      long l1;
      if (bool)
      {
        l2 = ((File)localObject2).length();
        l1 = l2;
        if (((File)localObject2).exists())
        {
          l1 = l2;
          if (((File)localObject2).length() > 0L)
          {
            l1 = l2;
            if (SystemUtil.a())
            {
              l1 = l2;
              if (SystemUtil.b() > ((File)localObject2).length())
              {
                localObject1 = new StringBuilder();
                ((StringBuilder)localObject1).append(Environment.getExternalStorageDirectory().getPath());
                ((StringBuilder)localObject1).append("/tencent/msflogs/corruptInfo");
                localObject1 = new File(((StringBuilder)localObject1).toString());
                l1 = l2;
                if (!((File)localObject1).exists())
                {
                  bool = FileUtils.copyFile((File)localObject2, (File)localObject1);
                  l3 = ((File)localObject1).length();
                  l1 = l2;
                  l2 = l3;
                  break label335;
                }
              }
            }
          }
        }
      }
      else
      {
        l1 = 0L;
      }
      bool = false;
      long l2 = l3;
      label335:
      localObject1 = EntityManagerFactory.getSqliteLibraryVersion();
      localObject2 = new HashMap();
      ((HashMap)localObject2).put("param_ROM", DeviceInfoUtil.v());
      ((HashMap)localObject2).put("isCopySucc", String.valueOf(bool));
      ((HashMap)localObject2).put("totalLen", String.valueOf(l1));
      ((HashMap)localObject2).put("copyLen", String.valueOf(l2));
      ((HashMap)localObject2).put("sqliteVer", localObject1);
      QLog.i("DataReportCorruptionHandler", 1, String.format(Locale.getDefault(), "db corrupt, totalLen:%d, clen:%d, sqliteVer:%s", new Object[] { Long.valueOf(l1), Long.valueOf(l2), localObject1 }));
      a((HashMap)localObject2);
    }
    return (Void)paramChain.proceed();
  }
  
  void a(HashMap<String, String> paramHashMap)
  {
    StatisticCollector.getInstance(BaseApplication.getContext()).collectPerformance(null, "actSqliteDatabaseCorrupt", true, -1L, 0L, paramHashMap, null, false);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.persistence.bridge.corruption.interceptor.DBReportCorruptionInterceptor
 * JD-Core Version:    0.7.0.1
 */