package com.tencent.mobileqq.persistence.bridge.corruption.interceptor;

import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.database.DefaultDatabaseErrorHandler;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.data.entitymanager.CorruptionInterceptorChain;
import com.tencent.mobileqq.data.entitymanager.Interceptor.Chain;
import com.tencent.mobileqq.database.corrupt.DBFixManager;
import com.tencent.mobileqq.msf.sdk.MsfSdkUtils;
import com.tencent.mobileqq.statistics.StatisticCollector;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.util.HashMap;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;

public class DBFixCorruptionInterceptor
  extends CorruptionInterceptor
{
  private void a(int paramInt, boolean paramBoolean, String paramString1, String paramString2)
  {
    int i = paramInt;
    if (paramInt == 0) {
      if (paramBoolean) {
        i = DBFixManager.e;
      } else {
        i = DBFixManager.d;
      }
    }
    HashMap localHashMap = new HashMap();
    localHashMap.put("reasonCode", String.valueOf(i));
    localHashMap.put("dDName", paramString1);
    if (paramString2 != null) {
      localHashMap.put("errorStack", paramString2);
    }
    StatisticCollector.getInstance(BaseApplication.getContext()).collectPerformance(null, DBFixManager.k, true, -1L, 0L, localHashMap, null, false);
  }
  
  public Void a(Interceptor.Chain<Void> paramChain)
  {
    AppRuntime localAppRuntime = a();
    if (localAppRuntime == null) {
      return null;
    }
    CorruptionInterceptorChain localCorruptionInterceptorChain = (CorruptionInterceptorChain)paramChain;
    SQLiteDatabase localSQLiteDatabase = localCorruptionInterceptorChain.database;
    SharedPreferences localSharedPreferences = localAppRuntime.getApplication().getSharedPreferences(DBFixManager.b, 0);
    String str2 = new File(localSQLiteDatabase.getPath()).getName();
    paramChain = new StringBuilder();
    paramChain.append(localAppRuntime.getAccount());
    paramChain.append(".db");
    boolean bool2 = str2.equals(paramChain.toString());
    try
    {
      paramChain = (DBFixManager)localAppRuntime.getManager(QQManagerFactory.DB_FIX_MANAGER);
      try
      {
        bool1 = paramChain.a();
        Interceptor.Chain<Void> localChain = paramChain;
        i = 0;
        paramChain = null;
      }
      catch (Throwable localThrowable1) {}
      QLog.e("DBFixCorruptionHandler", 1, "on corrupt", localThrowable2);
    }
    catch (Throwable localThrowable2)
    {
      paramChain = null;
    }
    int i = DBFixManager.jdField_f_of_type_Int;
    String str1 = MsfSdkUtils.getStackTraceString(localThrowable2);
    boolean bool1 = false;
    Object localObject = paramChain;
    paramChain = str1;
    if ((bool1) && (bool2))
    {
      try
      {
        localSQLiteDatabase.close();
      }
      catch (SQLiteException paramChain)
      {
        QLog.e("DBFixCorruptionHandler", 1, "db oncorrupt and close fail ", paramChain);
      }
      ((DBFixManager)localObject).a(null, true);
      return null;
    }
    localObject = new StringBuilder();
    ((StringBuilder)localObject).append(localAppRuntime.getAccount());
    ((StringBuilder)localObject).append(DBFixManager.jdField_f_of_type_JavaLangString);
    int j = localSharedPreferences.getInt(((StringBuilder)localObject).toString(), 0);
    QLog.d("DBFixCorruptionHandler", 1, new Object[] { "db oncorrup, dbobj fileName: ", str2, ", isUinDb: ", Boolean.valueOf(bool2), ", soFailCount", Integer.valueOf(j) });
    if ((j < DBFixManager.c) && (bool2)) {
      return null;
    }
    a(localCorruptionInterceptorChain, localSQLiteDatabase, localSharedPreferences);
    a(i, bool2, str2, paramChain);
    return null;
  }
  
  void a(CorruptionInterceptorChain paramCorruptionInterceptorChain, SQLiteDatabase paramSQLiteDatabase, SharedPreferences paramSharedPreferences)
  {
    paramCorruptionInterceptorChain.defaultErrorHandler.onCorruption(paramSQLiteDatabase);
    paramSharedPreferences.edit().remove(DBFixManager.g).apply();
    DBFixManager.a();
    paramSharedPreferences.edit().putBoolean("isFriendlistok", false).apply();
    QLog.d("DBFixCorruptionHandler", 1, "cleared friendlist flag");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.persistence.bridge.corruption.interceptor.DBFixCorruptionInterceptor
 * JD-Core Version:    0.7.0.1
 */