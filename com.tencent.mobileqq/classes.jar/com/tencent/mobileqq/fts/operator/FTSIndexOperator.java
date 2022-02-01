package com.tencent.mobileqq.fts.operator;

import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Message;
import com.tencent.mobileqq.automator.api.IAutomatorApi;
import com.tencent.mobileqq.fts.FTSConstants;
import com.tencent.mobileqq.fts.FTSDatabase;
import com.tencent.mobileqq.fts.api.IFTSDBRuntimeService;
import com.tencent.mobileqq.fts.api.impl.FTSDBRuntimeServiceImpl;
import com.tencent.mobileqq.fts.interfaces.IFTSConfig;
import com.tencent.mobileqq.fts.interfaces.IFTSOperator;
import com.tencent.mobileqq.fts.utils.FTSUtils;
import com.tencent.mobileqq.persistence.fts.FTSDatatbase;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.statistics.StatisticCollector;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.util.HashMap;
import java.util.Observable;
import java.util.Observer;
import mqq.app.AppRuntime;

public abstract class FTSIndexOperator
  extends Observable
  implements FTSConstants, IFTSOperator
{
  protected AppRuntime a;
  protected FTSDatatbase b;
  protected FTSDatabase c;
  protected FTSSyncHandler d;
  protected FTSUpgrader e;
  protected int f = -1;
  protected int g = -1;
  protected boolean h = false;
  protected boolean i = false;
  protected boolean j = false;
  protected int k;
  protected long l;
  private boolean m = false;
  
  public FTSIndexOperator(AppRuntime paramAppRuntime, FTSSyncHandler paramFTSSyncHandler)
  {
    this.a = paramAppRuntime;
    this.d = paramFTSSyncHandler;
  }
  
  public long a(AppRuntime paramAppRuntime)
  {
    SharedPreferences localSharedPreferences = paramAppRuntime.getApp().getSharedPreferences("fts_sp_file", 0);
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(n());
    localStringBuilder.append(paramAppRuntime.getAccount());
    long l1 = localSharedPreferences.getLong(localStringBuilder.toString(), 0L);
    if (QLog.isColorLevel()) {
      QLog.d("Q.fts", 2, new Object[] { "getLastMergeCommandTime ", n(), " time:", Long.valueOf(l1) });
    }
    return l1;
  }
  
  public void a(Observer paramObserver)
  {
    if (paramObserver != null) {
      addObserver(paramObserver);
    }
  }
  
  public void a(AppRuntime paramAppRuntime, long paramLong)
  {
    SharedPreferences.Editor localEditor = paramAppRuntime.getApp().getSharedPreferences("fts_sp_file", 0).edit();
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(n());
    localStringBuilder.append(paramAppRuntime.getAccount());
    localEditor.putLong(localStringBuilder.toString(), paramLong).commit();
    if (QLog.isColorLevel()) {
      QLog.d("Q.fts", 2, new Object[] { "setLastMergeCommandTime ", n(), " time:", Long.valueOf(paramLong) });
    }
  }
  
  public boolean a(FTSDatatbase paramFTSDatatbase, FTSDatabase paramFTSDatabase)
  {
    this.b = paramFTSDatatbase;
    this.c = paramFTSDatabase;
    return true;
  }
  
  public void b()
  {
    if (e()) {
      f();
    }
  }
  
  public void b(Observer paramObserver)
  {
    if (paramObserver != null) {
      deleteObserver(paramObserver);
    }
  }
  
  public void c()
  {
    this.d.obtainMessage(2, this).sendToTarget();
  }
  
  public void d()
  {
    this.j = true;
    FTSUpgrader localFTSUpgrader = this.e;
    if (localFTSUpgrader != null) {
      localFTSUpgrader.c();
    }
  }
  
  public boolean e()
  {
    if (FTSUtils.b(this.a) != 1) {
      return false;
    }
    FTSUpgrader localFTSUpgrader = this.e;
    if (localFTSUpgrader != null) {
      return localFTSUpgrader.a();
    }
    return false;
  }
  
  public boolean f()
  {
    FTSUpgrader localFTSUpgrader = this.e;
    if (localFTSUpgrader != null) {
      return localFTSUpgrader.b();
    }
    return true;
  }
  
  public boolean g()
  {
    return true;
  }
  
  public void h()
  {
    setChanged();
    notifyObservers();
  }
  
  protected boolean i()
  {
    boolean bool3 = this.m;
    boolean bool2 = false;
    boolean bool1 = true;
    if (!bool3)
    {
      int n;
      if (this.a != null) {
        n = ((IAutomatorApi)QRoute.api(IAutomatorApi.class)).getInActionLoginB();
      } else {
        n = 0;
      }
      if (n == 0)
      {
        this.m = true;
        bool1 = false;
      }
      else
      {
        bool1 = true;
      }
      if (n == 1) {
        this.m = true;
      }
    }
    if ((bool1) && (j()) && (!this.a.isBackgroundStop)) {
      bool1 = bool2;
    }
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("isSaveDBAtOnce unActionLoginB atOnce:");
      localStringBuilder.append(bool1);
      QLog.d("Q.fts.sync_worker", 2, localStringBuilder.toString());
    }
    return bool1;
  }
  
  protected boolean j()
  {
    return false;
  }
  
  public abstract void k();
  
  public String l()
  {
    StringBuilder localStringBuilder = new StringBuilder(50);
    localStringBuilder.append(" ");
    localStringBuilder.append(getClass().getSimpleName());
    localStringBuilder.append(" transCount:");
    localStringBuilder.append(this.k);
    localStringBuilder.append(" transCost:");
    localStringBuilder.append(this.l);
    localStringBuilder.append(" transAvg:");
    int n = this.k;
    float f1;
    if (n != 0) {
      f1 = (float)this.l * 1.0F / n;
    } else {
      f1 = 0.0F;
    }
    localStringBuilder.append(f1);
    this.l = 0L;
    this.k = 0;
    return localStringBuilder.toString();
  }
  
  public boolean m()
  {
    return false;
  }
  
  public abstract String n();
  
  public boolean o()
  {
    Object localObject = this.a;
    if (localObject == null) {
      return false;
    }
    localObject = ((FTSDBRuntimeServiceImpl)((AppRuntime)localObject).getRuntimeService(IFTSDBRuntimeService.class, "")).getIFTSConfig();
    if ((localObject != null) && (((IFTSConfig)localObject).a() == 0))
    {
      if (QLog.isColorLevel()) {
        QLog.d("Q.fts", 2, "needRunMergeCommand disableFTSMerge ");
      }
      return false;
    }
    boolean bool;
    if (System.currentTimeMillis() - a(this.a) > 21600000L) {
      bool = true;
    } else {
      bool = false;
    }
    if (QLog.isColorLevel()) {
      QLog.d("Q.fts", 2, new Object[] { "needRunMergeCommand ", n(), " need:", Boolean.valueOf(bool) });
    }
    return bool;
  }
  
  public void p()
  {
    if (this.a == null) {
      return;
    }
    long l1 = System.currentTimeMillis();
    int n = this.c.a(n(), 200, 8);
    if (n == 101) {
      a(this.a, System.currentTimeMillis());
    }
    l1 = System.currentTimeMillis() - l1;
    if (QLog.isColorLevel()) {
      QLog.d("Q.fts", 2, new Object[] { "mergeCommand ", n(), " cost:", Long.valueOf(l1) });
    }
    HashMap localHashMap = new HashMap();
    localHashMap.put("table_name", n());
    localHashMap.put("merge_ret", String.valueOf(n));
    localHashMap.put("merge_cost", String.valueOf(l1));
    StatisticCollector.getInstance(BaseApplication.getContext()).collectPerformance(null, "actFTSMerge", true, l1, 0L, localHashMap, null, false);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.fts.operator.FTSIndexOperator
 * JD-Core Version:    0.7.0.1
 */