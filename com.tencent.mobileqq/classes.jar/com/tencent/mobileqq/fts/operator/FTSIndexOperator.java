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
  protected int a;
  protected long a;
  protected FTSDatabase a;
  protected FTSSyncHandler a;
  protected FTSUpgrader a;
  protected FTSDatatbase a;
  protected AppRuntime a;
  protected boolean a;
  protected int b;
  protected boolean b;
  protected int c;
  protected boolean c;
  private boolean d = false;
  
  public FTSIndexOperator(AppRuntime paramAppRuntime, FTSSyncHandler paramFTSSyncHandler)
  {
    this.jdField_a_of_type_Int = -1;
    this.jdField_b_of_type_Int = -1;
    this.jdField_a_of_type_Boolean = false;
    this.jdField_b_of_type_Boolean = false;
    this.jdField_c_of_type_Boolean = false;
    this.jdField_a_of_type_MqqAppAppRuntime = paramAppRuntime;
    this.jdField_a_of_type_ComTencentMobileqqFtsOperatorFTSSyncHandler = paramFTSSyncHandler;
  }
  
  public long a(AppRuntime paramAppRuntime)
  {
    SharedPreferences localSharedPreferences = paramAppRuntime.getApp().getSharedPreferences("fts_sp_file", 0);
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(b());
    localStringBuilder.append(paramAppRuntime.getAccount());
    long l = localSharedPreferences.getLong(localStringBuilder.toString(), 0L);
    if (QLog.isColorLevel()) {
      QLog.d("Q.fts", 2, new Object[] { "getLastMergeCommandTime ", b(), " time:", Long.valueOf(l) });
    }
    return l;
  }
  
  public String a()
  {
    StringBuilder localStringBuilder = new StringBuilder(50);
    localStringBuilder.append(" ");
    localStringBuilder.append(getClass().getSimpleName());
    localStringBuilder.append(" transCount:");
    localStringBuilder.append(this.jdField_c_of_type_Int);
    localStringBuilder.append(" transCost:");
    localStringBuilder.append(this.jdField_a_of_type_Long);
    localStringBuilder.append(" transAvg:");
    int i = this.jdField_c_of_type_Int;
    float f;
    if (i != 0) {
      f = (float)this.jdField_a_of_type_Long * 1.0F / i;
    } else {
      f = 0.0F;
    }
    localStringBuilder.append(f);
    this.jdField_a_of_type_Long = 0L;
    this.jdField_c_of_type_Int = 0;
    return localStringBuilder.toString();
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
    localStringBuilder.append(b());
    localStringBuilder.append(paramAppRuntime.getAccount());
    localEditor.putLong(localStringBuilder.toString(), paramLong).commit();
    if (QLog.isColorLevel()) {
      QLog.d("Q.fts", 2, new Object[] { "setLastMergeCommandTime ", b(), " time:", Long.valueOf(paramLong) });
    }
  }
  
  public boolean a()
  {
    if (FTSUtils.b(this.jdField_a_of_type_MqqAppAppRuntime) != 1) {
      return false;
    }
    FTSUpgrader localFTSUpgrader = this.jdField_a_of_type_ComTencentMobileqqFtsOperatorFTSUpgrader;
    if (localFTSUpgrader != null) {
      return localFTSUpgrader.a();
    }
    return false;
  }
  
  public boolean a(FTSDatatbase paramFTSDatatbase, FTSDatabase paramFTSDatabase)
  {
    this.jdField_a_of_type_ComTencentMobileqqPersistenceFtsFTSDatatbase = paramFTSDatatbase;
    this.jdField_a_of_type_ComTencentMobileqqFtsFTSDatabase = paramFTSDatabase;
    return true;
  }
  
  public abstract String b();
  
  public void b()
  {
    if (a()) {
      b();
    }
  }
  
  public void b(Observer paramObserver)
  {
    if (paramObserver != null) {
      deleteObserver(paramObserver);
    }
  }
  
  public boolean b()
  {
    FTSUpgrader localFTSUpgrader = this.jdField_a_of_type_ComTencentMobileqqFtsOperatorFTSUpgrader;
    if (localFTSUpgrader != null) {
      return localFTSUpgrader.b();
    }
    return true;
  }
  
  public void c()
  {
    this.jdField_a_of_type_ComTencentMobileqqFtsOperatorFTSSyncHandler.obtainMessage(2, this).sendToTarget();
  }
  
  public boolean c()
  {
    return true;
  }
  
  public void d()
  {
    this.jdField_c_of_type_Boolean = true;
    FTSUpgrader localFTSUpgrader = this.jdField_a_of_type_ComTencentMobileqqFtsOperatorFTSUpgrader;
    if (localFTSUpgrader != null) {
      localFTSUpgrader.a();
    }
  }
  
  protected boolean d()
  {
    boolean bool3 = this.d;
    boolean bool2 = false;
    boolean bool1 = true;
    if (!bool3)
    {
      int i;
      if (this.jdField_a_of_type_MqqAppAppRuntime != null) {
        i = ((IAutomatorApi)QRoute.api(IAutomatorApi.class)).getInActionLoginB();
      } else {
        i = 0;
      }
      if (i == 0)
      {
        this.d = true;
        bool1 = false;
      }
      else
      {
        bool1 = true;
      }
      if (i == 1) {
        this.d = true;
      }
    }
    if ((bool1) && (e()) && (!this.jdField_a_of_type_MqqAppAppRuntime.isBackgroundStop)) {
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
  
  public void e()
  {
    setChanged();
    notifyObservers();
  }
  
  protected boolean e()
  {
    return false;
  }
  
  public abstract void f();
  
  public boolean f()
  {
    return false;
  }
  
  public void g()
  {
    if (this.jdField_a_of_type_MqqAppAppRuntime == null) {
      return;
    }
    long l = System.currentTimeMillis();
    int i = this.jdField_a_of_type_ComTencentMobileqqFtsFTSDatabase.a(b(), 200, 8);
    if (i == 101) {
      a(this.jdField_a_of_type_MqqAppAppRuntime, System.currentTimeMillis());
    }
    l = System.currentTimeMillis() - l;
    if (QLog.isColorLevel()) {
      QLog.d("Q.fts", 2, new Object[] { "mergeCommand ", b(), " cost:", Long.valueOf(l) });
    }
    HashMap localHashMap = new HashMap();
    localHashMap.put("table_name", b());
    localHashMap.put("merge_ret", String.valueOf(i));
    localHashMap.put("merge_cost", String.valueOf(l));
    StatisticCollector.getInstance(BaseApplication.getContext()).collectPerformance(null, "actFTSMerge", true, l, 0L, localHashMap, null, false);
  }
  
  public boolean g()
  {
    Object localObject = this.jdField_a_of_type_MqqAppAppRuntime;
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
    if (System.currentTimeMillis() - a(this.jdField_a_of_type_MqqAppAppRuntime) > 21600000L) {
      bool = true;
    } else {
      bool = false;
    }
    if (QLog.isColorLevel()) {
      QLog.d("Q.fts", 2, new Object[] { "needRunMergeCommand ", b(), " need:", Boolean.valueOf(bool) });
    }
    return bool;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.fts.operator.FTSIndexOperator
 * JD-Core Version:    0.7.0.1
 */