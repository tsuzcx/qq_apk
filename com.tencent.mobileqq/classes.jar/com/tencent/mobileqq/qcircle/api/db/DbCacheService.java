package com.tencent.mobileqq.qcircle.api.db;

import android.content.Context;
import android.text.TextUtils;
import com.tencent.biz.richframework.delegate.impl.RFApplication;
import com.tencent.biz.richframework.delegate.impl.RFLog;
import com.tencent.qcircle.cooperation.config.QCircleConfigHelper;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map.Entry;
import java.util.Set;

public class DbCacheService
{
  public static int a = 0;
  private static DbCacheService jdField_a_of_type_ComTencentMobileqqQcircleApiDbDbCacheService;
  public static int b = 1;
  public static int c = -1;
  public static int d = 2;
  private Context jdField_a_of_type_AndroidContentContext;
  private IDBManagerWrapper.OnCloseListener jdField_a_of_type_ComTencentMobileqqQcircleApiDbIDBManagerWrapper$OnCloseListener = new DbCacheService.1(this);
  private final HashMap<String, DbCacheManager> jdField_a_of_type_JavaUtilHashMap = new HashMap();
  private int e = -1;
  
  private DbCacheService(Context paramContext)
  {
    this.jdField_a_of_type_AndroidContentContext = paramContext.getApplicationContext();
  }
  
  public static DbCacheService a()
  {
    DbCacheService localDbCacheService = jdField_a_of_type_ComTencentMobileqqQcircleApiDbDbCacheService;
    if (localDbCacheService != null) {
      return localDbCacheService;
    }
    try
    {
      if (jdField_a_of_type_ComTencentMobileqqQcircleApiDbDbCacheService == null)
      {
        jdField_a_of_type_ComTencentMobileqqQcircleApiDbDbCacheService = new DbCacheService(RFApplication.getApplication());
        DbCacheExceptionHandler.a().a(RFApplication.getApplication());
      }
      localDbCacheService = jdField_a_of_type_ComTencentMobileqqQcircleApiDbDbCacheService;
      return localDbCacheService;
    }
    finally {}
  }
  
  public int a()
  {
    int i = QCircleConfigHelper.a("QZoneSetting", "DbOptiSync", Integer.valueOf(1)).intValue();
    int j = RFLog.USR;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("dbOptiSync=");
    localStringBuilder.append(i);
    RFLog.w("QCircleDbCacheDatabase.DbCacheService", j, localStringBuilder.toString());
    return i;
  }
  
  public DbCacheManager a(Class<? extends IDBCacheDataWrapper> paramClass, long paramLong, int paramInt1, int paramInt2, String paramString)
  {
    throw new Runtime("d2j fail translate: java.lang.RuntimeException: fail exe a12 = a9\r\n\tat com.googlecode.dex2jar.ir.ts.an.BaseAnalyze.exec(BaseAnalyze.java:92)\r\n\tat com.googlecode.dex2jar.ir.ts.an.BaseAnalyze.exec(BaseAnalyze.java:1)\r\n\tat com.googlecode.dex2jar.ir.ts.Cfg.dfs(Cfg.java:255)\r\n\tat com.googlecode.dex2jar.ir.ts.an.BaseAnalyze.analyze0(BaseAnalyze.java:75)\r\n\tat com.googlecode.dex2jar.ir.ts.an.BaseAnalyze.analyze(BaseAnalyze.java:69)\r\n\tat com.googlecode.dex2jar.ir.ts.UnSSATransformer.transform(UnSSATransformer.java:274)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.optimize(Dex2jar.java:163)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertCode(Dex2Asm.java:414)\r\n\tat com.googlecode.d2j.dex.ExDex2Asm.convertCode(ExDex2Asm.java:42)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.convertCode(Dex2jar.java:128)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertMethod(Dex2Asm.java:509)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertClass(Dex2Asm.java:406)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertDex(Dex2Asm.java:422)\r\n\tat com.googlecode.d2j.dex.Dex2jar.doTranslate(Dex2jar.java:172)\r\n\tat com.googlecode.d2j.dex.Dex2jar.to(Dex2jar.java:272)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.doCommandLine(Dex2jarCmd.java:108)\r\n\tat com.googlecode.dex2jar.tools.BaseCmd.doMain(BaseCmd.java:288)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.main(Dex2jarCmd.java:32)\r\nCaused by: java.lang.NullPointerException\r\n\tat com.googlecode.dex2jar.ir.ts.UnSSATransformer$LiveA.onUseLocal(UnSSATransformer.java:552)\r\n\tat com.googlecode.dex2jar.ir.ts.UnSSATransformer$LiveA.onUseLocal(UnSSATransformer.java:1)\r\n\tat com.googlecode.dex2jar.ir.ts.an.BaseAnalyze.onUse(BaseAnalyze.java:166)\r\n\tat com.googlecode.dex2jar.ir.ts.an.BaseAnalyze.onUse(BaseAnalyze.java:1)\r\n\tat com.googlecode.dex2jar.ir.ts.Cfg.travel(Cfg.java:331)\r\n\tat com.googlecode.dex2jar.ir.ts.Cfg.travel(Cfg.java:387)\r\n\tat com.googlecode.dex2jar.ir.ts.an.BaseAnalyze.exec(BaseAnalyze.java:90)\r\n\t... 17 more\r\n");
  }
  
  public DbCacheManager a(Class<? extends IDBCacheDataWrapper> paramClass, long paramLong, String paramString)
  {
    if (paramLong == -1L) {
      return a(paramClass, paramString);
    }
    return a(paramClass, paramLong, jdField_a_of_type_Int, 117, paramString);
  }
  
  public DbCacheManager a(Class<? extends IDBCacheDataWrapper> paramClass, String paramString)
  {
    return a(paramClass, -1L, b, 1, paramString);
  }
  
  public void a()
  {
    try
    {
      synchronized (this.jdField_a_of_type_JavaUtilHashMap)
      {
        Iterator localIterator = this.jdField_a_of_type_JavaUtilHashMap.values().iterator();
        while (localIterator.hasNext())
        {
          DbCacheManager localDbCacheManager = (DbCacheManager)localIterator.next();
          if (localDbCacheManager != null)
          {
            localDbCacheManager.a(this.jdField_a_of_type_ComTencentMobileqqQcircleApiDbIDBManagerWrapper$OnCloseListener);
            localDbCacheManager.close();
          }
        }
        this.jdField_a_of_type_JavaUtilHashMap.clear();
        return;
      }
      return;
    }
    catch (Exception localException)
    {
      RFLog.e("QCircleDbCacheDatabase.DbCacheService", RFLog.USR, new Object[] { localException });
    }
  }
  
  public void a(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return;
    }
    try
    {
      synchronized (this.jdField_a_of_type_JavaUtilHashMap)
      {
        Iterator localIterator = this.jdField_a_of_type_JavaUtilHashMap.entrySet().iterator();
        while (localIterator.hasNext())
        {
          Object localObject = (Map.Entry)localIterator.next();
          if (localObject != null)
          {
            localObject = (DbCacheManager)((Map.Entry)localObject).getValue();
            if (localObject != null)
            {
              if (paramString.equals(((DbCacheManager)localObject).a()))
              {
                ((DbCacheManager)localObject).a(this.jdField_a_of_type_ComTencentMobileqqQcircleApiDbIDBManagerWrapper$OnCloseListener);
                ((DbCacheManager)localObject).close();
                localIterator.remove();
              }
            }
            else {
              localIterator.remove();
            }
          }
          else
          {
            localIterator.remove();
          }
        }
        return;
      }
      return;
    }
    catch (Exception paramString)
    {
      RFLog.e("QCircleDbCacheDatabase.DbCacheService", RFLog.USR, new Object[] { paramString });
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.qcircle.api.db.DbCacheService
 * JD-Core Version:    0.7.0.1
 */