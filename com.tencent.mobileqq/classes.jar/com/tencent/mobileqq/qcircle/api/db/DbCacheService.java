package com.tencent.mobileqq.qcircle.api.db;

import android.content.Context;
import android.text.TextUtils;
import com.tencent.biz.richframework.delegate.impl.RFApplication;
import com.tencent.qcircle.cooperation.config.QCircleConfigHelper;
import com.tencent.qphone.base.util.QLog;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map.Entry;
import java.util.Set;

public class DbCacheService
{
  public static int a = 0;
  public static int b = 1;
  public static int c = -1;
  public static int d = 2;
  private static volatile DbCacheService i;
  private Context e;
  private final HashMap<String, DbCacheManager> f = new HashMap();
  private int g = -1;
  private IDBManagerWrapper.OnCloseListener h = new DbCacheService.1(this);
  
  private DbCacheService(Context paramContext)
  {
    this.e = paramContext.getApplicationContext();
  }
  
  public static DbCacheService c()
  {
    if (i != null) {
      return i;
    }
    try
    {
      if (i == null)
      {
        i = new DbCacheService(RFApplication.getApplication());
        DbCacheExceptionHandler.a().a(RFApplication.getApplication());
      }
      DbCacheService localDbCacheService = i;
      return localDbCacheService;
    }
    finally {}
  }
  
  public int a()
  {
    int j = QCircleConfigHelper.a("QZoneSetting", "DbOptiSync", Integer.valueOf(1)).intValue();
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("dbOptiSync=");
    localStringBuilder.append(j);
    QLog.w("QCircleDbCacheDatabase.DbCacheService", 1, localStringBuilder.toString());
    return j;
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
    return a(paramClass, paramLong, a, 117, paramString);
  }
  
  public DbCacheManager a(Class<? extends IDBCacheDataWrapper> paramClass, String paramString)
  {
    return a(paramClass, -1L, b, 1, paramString);
  }
  
  public void a(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return;
    }
    try
    {
      synchronized (this.f)
      {
        Iterator localIterator = this.f.entrySet().iterator();
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
                ((DbCacheManager)localObject).a(this.h);
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
      QLog.e("QCircleDbCacheDatabase.DbCacheService", 1, paramString, new Object[0]);
    }
  }
  
  public void b()
  {
    try
    {
      synchronized (this.f)
      {
        Iterator localIterator = this.f.values().iterator();
        while (localIterator.hasNext())
        {
          DbCacheManager localDbCacheManager = (DbCacheManager)localIterator.next();
          if (localDbCacheManager != null)
          {
            localDbCacheManager.a(this.h);
            localDbCacheManager.close();
          }
        }
        this.f.clear();
        return;
      }
      return;
    }
    catch (Exception localException)
    {
      QLog.e("QCircleDbCacheDatabase.DbCacheService", 1, localException, new Object[0]);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.qcircle.api.db.DbCacheService
 * JD-Core Version:    0.7.0.1
 */