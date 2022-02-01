package com.tencent.mobileqq.statistics;

import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Bundle;
import android.os.Handler.Callback;
import android.os.Message;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.bridge.ReportControllerServiceHolder;
import com.tencent.mobileqq.bridge.report.service.IProxyManager;
import com.tencent.mobileqq.bridge.report.service.IReportDataProviderService;
import com.tencent.mobileqq.msf.sdk.AppNetConnInfo;
import com.tencent.mobileqq.persistence.Entity;
import com.tencent.mobileqq.persistence.EntityManager;
import com.tencent.mobileqq.persistence.EntityManagerFactory;
import com.tencent.mobileqq.persistence.EntityTransaction;
import com.tencent.mobileqq.servlet.ReportServlet;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.util.MqqWeakReferenceHandler;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Random;
import java.util.Set;
import mqq.app.AppRuntime;
import mqq.app.NewIntent;
import mqq.manager.ServerConfigManager.ConfigType;
import mqq.observer.BusinessObserver;

public class ReportControllerImpl
  extends ReportController
  implements Handler.Callback, BusinessObserver
{
  private int jdField_a_of_type_Int;
  private long jdField_a_of_type_Long;
  private IProxyManager jdField_a_of_type_ComTencentMobileqqBridgeReportServiceIProxyManager;
  private MqqWeakReferenceHandler jdField_a_of_type_ComTencentUtilMqqWeakReferenceHandler;
  private volatile Boolean jdField_a_of_type_JavaLangBoolean;
  private AppRuntime jdField_a_of_type_MqqAppAppRuntime;
  private final HashMap<String, Reporting> b = new HashMap();
  
  private ReportControllerImpl(AppRuntime paramAppRuntime)
  {
    this.jdField_a_of_type_MqqAppAppRuntime = paramAppRuntime;
    Object localObject;
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("Create:");
      ((StringBuilder)localObject).append(paramAppRuntime);
      QLog.d("ReportController", 2, ((StringBuilder)localObject).toString());
    }
    this.jdField_a_of_type_ComTencentUtilMqqWeakReferenceHandler = new MqqWeakReferenceHandler(ThreadManager.getSubThreadLooper(), this);
    try
    {
      localObject = ReportControllerServiceHolder.a();
      if (localObject == null) {
        break label142;
      }
      paramAppRuntime = ((IReportDataProviderService)localObject).a(paramAppRuntime, ServerConfigManager.ConfigType.common, "ActionReportInterval");
    }
    catch (Exception paramAppRuntime)
    {
      for (;;)
      {
        continue;
        paramAppRuntime = "";
      }
    }
    if ((paramAppRuntime != null) && (paramAppRuntime.length() > 0)) {
      this.jdField_a_of_type_Long = (Long.parseLong(paramAppRuntime) * 1000L);
    }
    if (this.jdField_a_of_type_Long <= 1000L) {
      this.jdField_a_of_type_Long = 86400000L;
    }
  }
  
  private int a()
  {
    try
    {
      if (this.jdField_a_of_type_Int <= 0) {
        this.jdField_a_of_type_Int = (new Random().nextInt(1000000) + 100);
      } else if (this.jdField_a_of_type_Int >= 1000100) {
        this.jdField_a_of_type_Int = 100;
      } else {
        this.jdField_a_of_type_Int += 1;
      }
      int i = this.jdField_a_of_type_Int;
      return i;
    }
    finally {}
  }
  
  public static ReportController a(AppRuntime paramAppRuntime)
  {
    return new ReportControllerImpl(paramAppRuntime);
  }
  
  private boolean a()
  {
    if (!AppNetConnInfo.isNetSupport()) {
      return false;
    }
    if (QLog.isColorLevel())
    {
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append("doReportClickEvent:");
      ((StringBuilder)localObject1).append(this.jdField_a_of_type_MqqAppAppRuntime);
      QLog.d("ReportController", 2, ((StringBuilder)localObject1).toString());
    }
    int m = this.b.size();
    Object localObject2 = new ArrayList(20);
    Object localObject1 = new ArrayList(20);
    int j = a();
    Iterator localIterator = this.b.keySet().iterator();
    int k = 0;
    while (localIterator.hasNext())
    {
      Object localObject3 = (String)localIterator.next();
      Reporting localReporting = (Reporting)this.b.get(localObject3);
      int i;
      int n;
      Object localObject4;
      if ((localReporting.mDetailHashCode != 0) && (localReporting.mDetail.hashCode() != localReporting.mDetailHashCode))
      {
        i = m - 1;
        localIterator.remove();
        this.jdField_a_of_type_ComTencentMobileqqBridgeReportServiceIProxyManager.a("", 0, "Reporting", localReporting, 5);
        n = k;
      }
      else if (b(localReporting.mTag))
      {
        localObject3 = a(localReporting.mTag);
        if (localObject3 != null) {
          ((ReportController.BusinessDataReporter)localObject3).a(localReporting);
        }
        i = m - 1;
        localIterator.remove();
        this.jdField_a_of_type_ComTencentMobileqqBridgeReportServiceIProxyManager.a("", 0, "Reporting", localReporting, 5);
        n = k;
      }
      else
      {
        ((ArrayList)localObject2).add(localReporting.mTag);
        localObject4 = localReporting.mDetail.replace("${count_unknown}", String.valueOf(localReporting.mCount));
        localObject3 = localObject4;
        if (((String)localObject4).startsWith("${report_seq_prefix}")) {
          localObject3 = ((String)localObject4).substring(((String)localObject4).indexOf("|") + 1);
        }
        ((ArrayList)localObject1).add(localObject3);
        localIterator.remove();
        this.jdField_a_of_type_ComTencentMobileqqBridgeReportServiceIProxyManager.a("", 0, "Reporting", localReporting, 5);
        if (QLog.isColorLevel())
        {
          localObject4 = new StringBuilder();
          ((StringBuilder)localObject4).append("Report: ");
          ((StringBuilder)localObject4).append(localReporting.mTag);
          ((StringBuilder)localObject4).append(", ");
          ((StringBuilder)localObject4).append((String)localObject3);
          ((StringBuilder)localObject4).append(", ");
          ((StringBuilder)localObject4).append(j);
          QLog.d("ReportController", 2, ((StringBuilder)localObject4).toString());
        }
        n = k + 1;
        i = m;
      }
      if (n % 20 != 0)
      {
        m = i;
        k = n;
        if (n < i) {}
      }
      else
      {
        localObject3 = new NewIntent(this.jdField_a_of_type_MqqAppAppRuntime.getApplication(), ReportServlet.class);
        ((NewIntent)localObject3).putExtra("sendType", 10);
        ((NewIntent)localObject3).putExtra("seqKey", j);
        ((NewIntent)localObject3).putExtra("tags", (Serializable)localObject2);
        ((NewIntent)localObject3).putExtra("retryTime", 0);
        ((NewIntent)localObject3).putExtra("contents", (Serializable)localObject1);
        ((NewIntent)localObject3).setObserver(this);
        this.jdField_a_of_type_MqqAppAppRuntime.startServlet((NewIntent)localObject3);
        localObject3 = new ArrayList(20);
        localObject4 = new ArrayList(20);
        m = i;
        localObject2 = localObject3;
        localObject1 = localObject4;
        k = n;
        if (n < i)
        {
          j = a();
          m = i;
          localObject2 = localObject3;
          localObject1 = localObject4;
          k = n;
        }
      }
    }
    a();
    return true;
  }
  
  private void b(String paramString1, String paramString2, int paramInt)
  {
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("addReporting:");
      ((StringBuilder)localObject).append(paramString2);
      ((StringBuilder)localObject).append(", ");
      ((StringBuilder)localObject).append(paramInt);
      QLog.d("ReportController", 2, ((StringBuilder)localObject).toString());
    }
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append(paramString1);
    ((StringBuilder)localObject).append(":");
    ((StringBuilder)localObject).append(paramString2);
    String str = ((StringBuilder)localObject).toString();
    localObject = (Reporting)this.b.get(str);
    if (localObject == null)
    {
      localObject = new Reporting();
      ((Reporting)localObject).mTag = paramString1;
      ((Reporting)localObject).mDetail = paramString2;
      ((Reporting)localObject).mCount = paramInt;
      ((Reporting)localObject).mDetailHashCode = ((Reporting)localObject).mDetail.hashCode();
      this.b.put(str, localObject);
      if ((this.jdField_a_of_type_JavaLangBoolean != null) && (this.jdField_a_of_type_JavaLangBoolean.booleanValue())) {
        this.jdField_a_of_type_ComTencentMobileqqBridgeReportServiceIProxyManager.a("", 0, "Reporting", (Entity)localObject, 3);
      }
      paramString1 = (String)localObject;
      if (QLog.isColorLevel())
      {
        paramString1 = new StringBuilder();
        paramString1.append("handleAddReporting:r.mTag=");
        paramString1.append(((Reporting)localObject).mTag);
        paramString1.append(", r.mDetail=");
        paramString1.append(((Reporting)localObject).mDetail);
        paramString1.append(", r.mDetailHashCode=");
        paramString1.append(((Reporting)localObject).mDetailHashCode);
        QLog.d("ReportController", 2, paramString1.toString());
        paramString1 = (String)localObject;
      }
    }
    else
    {
      ((Reporting)localObject).mCount += paramInt;
      if ((this.jdField_a_of_type_JavaLangBoolean != null) && (this.jdField_a_of_type_JavaLangBoolean.booleanValue())) {
        this.jdField_a_of_type_ComTencentMobileqqBridgeReportServiceIProxyManager.a("", 0, "Reporting", ((Reporting)localObject).clone(), 4);
      }
      paramString1 = (String)localObject;
      if (QLog.isColorLevel())
      {
        paramString1 = new StringBuilder();
        paramString1.append("handleAddReporting:r.mTag=");
        paramString1.append(((Reporting)localObject).mTag);
        paramString1.append(", r.mDetail=");
        paramString1.append(((Reporting)localObject).mDetail);
        paramString1.append(", r.mDetailHashCode=");
        paramString1.append(((Reporting)localObject).mDetailHashCode);
        QLog.d("ReportController", 2, paramString1.toString());
        paramString1 = (String)localObject;
      }
    }
    if (this.jdField_a_of_type_JavaLangBoolean != null) {
      if (this.jdField_a_of_type_JavaLangBoolean.booleanValue())
      {
        if (this.b.size() >= 40)
        {
          d();
          if (QLog.isColorLevel())
          {
            paramString2 = new StringBuilder();
            paramString2.append("handleAddReporting: handleReport r.mTag=");
            paramString2.append(paramString1.mTag);
            paramString2.append(", r.mDetail=");
            paramString2.append(paramString1.mDetail);
            paramString2.append(", r.mDetailHashCode=");
            paramString2.append(paramString1.mDetailHashCode);
            QLog.d("ReportController", 2, paramString2.toString());
          }
        }
      }
      else if (!this.jdField_a_of_type_ComTencentUtilMqqWeakReferenceHandler.hasMessages(9528))
      {
        this.jdField_a_of_type_ComTencentUtilMqqWeakReferenceHandler.sendEmptyMessage(9528);
        if (QLog.isColorLevel())
        {
          paramString2 = new StringBuilder();
          paramString2.append("handleAddReporting: savedata r.mTag=");
          paramString2.append(paramString1.mTag);
          paramString2.append(", r.mDetail=");
          paramString2.append(paramString1.mDetail);
          paramString2.append(", r.mDetailHashCode=");
          paramString2.append(paramString1.mDetailHashCode);
          QLog.d("ReportController", 2, paramString2.toString());
        }
      }
    }
  }
  
  private void b(AppRuntime paramAppRuntime)
  {
    Object localObject1;
    if (QLog.isColorLevel())
    {
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append("saveReportData:");
      ((StringBuilder)localObject1).append(paramAppRuntime);
      QLog.d("ReportController", 2, ((StringBuilder)localObject1).toString());
    }
    Object localObject2 = this.b.values();
    if ((localObject2 != null) && (((Collection)localObject2).size() > 0)) {}
    label133:
    try
    {
      paramAppRuntime = paramAppRuntime.getEntityManagerFactory().createEntityManager();
      localObject1 = paramAppRuntime.getTransaction();
      ((EntityTransaction)localObject1).begin();
    }
    catch (Throwable paramAppRuntime)
    {
      label83:
      return;
    }
    try
    {
      localObject2 = ((Collection)localObject2).iterator();
      if (((Iterator)localObject2).hasNext())
      {
        Reporting localReporting = (Reporting)((Iterator)localObject2).next();
        if (localReporting.getStatus() == 1000)
        {
          paramAppRuntime.persistOrReplace(localReporting);
          break label83;
        }
        paramAppRuntime.update(localReporting);
        break label83;
      }
    }
    catch (Throwable localThrowable)
    {
      break label133;
    }
    ((EntityTransaction)localObject1).commit();
    ((EntityTransaction)localObject1).end();
    paramAppRuntime.close();
  }
  
  private void c()
  {
    if (QLog.isColorLevel())
    {
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append("handleInit:");
      ((StringBuilder)localObject1).append(this.jdField_a_of_type_MqqAppAppRuntime);
      QLog.d("ReportController", 2, ((StringBuilder)localObject1).toString());
    }
    Object localObject1 = this.jdField_a_of_type_MqqAppAppRuntime.getEntityManagerFactory().createEntityManager().query(Reporting.class);
    if (localObject1 != null)
    {
      localObject1 = ((List)localObject1).iterator();
      while (((Iterator)localObject1).hasNext())
      {
        Reporting localReporting1 = (Reporting)((Iterator)localObject1).next();
        Object localObject2 = new StringBuilder();
        ((StringBuilder)localObject2).append(localReporting1.mTag);
        ((StringBuilder)localObject2).append(":");
        ((StringBuilder)localObject2).append(localReporting1.mDetail);
        localObject2 = ((StringBuilder)localObject2).toString();
        Reporting localReporting2 = (Reporting)this.b.get(localObject2);
        if (localReporting2 != null) {
          localReporting1.mCount += localReporting2.mCount;
        }
        this.b.put(localObject2, localReporting1);
      }
    }
  }
  
  private void d()
  {
    this.jdField_a_of_type_ComTencentUtilMqqWeakReferenceHandler.removeMessages(9527);
    try
    {
      a();
    }
    catch (Exception localException)
    {
      if (QLog.isDevelopLevel())
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("report exception:");
        localStringBuilder.append(localException);
        QLog.d("ReportController", 4, localStringBuilder.toString());
      }
    }
    Object localObject = BaseApplication.getContext().getSharedPreferences(this.jdField_a_of_type_MqqAppAppRuntime.getAccount(), 0);
    long l = System.currentTimeMillis();
    localObject = ((SharedPreferences)localObject).edit();
    ((SharedPreferences.Editor)localObject).putLong("pre_report_time", l);
    ((SharedPreferences.Editor)localObject).commit();
    this.jdField_a_of_type_ComTencentUtilMqqWeakReferenceHandler.sendEmptyMessageDelayed(9527, this.jdField_a_of_type_Long);
  }
  
  protected void a(String paramString1, String paramString2, int paramInt)
  {
    ReportControllerImpl.ReportingBridge localReportingBridge = new ReportControllerImpl.ReportingBridge();
    localReportingBridge.jdField_a_of_type_JavaLangString = paramString1;
    localReportingBridge.b = paramString2;
    localReportingBridge.jdField_a_of_type_Int = paramInt;
    this.jdField_a_of_type_ComTencentUtilMqqWeakReferenceHandler.obtainMessage(9529, localReportingBridge).sendToTarget();
  }
  
  protected void a(AppRuntime paramAppRuntime, IProxyManager paramIProxyManager)
  {
    this.jdField_a_of_type_MqqAppAppRuntime = paramAppRuntime;
    this.jdField_a_of_type_ComTencentMobileqqBridgeReportServiceIProxyManager = paramIProxyManager;
    this.jdField_a_of_type_JavaLangBoolean = Boolean.valueOf(true);
    if (QLog.isColorLevel())
    {
      paramIProxyManager = new StringBuilder();
      paramIProxyManager.append("Init:");
      paramIProxyManager.append(paramAppRuntime);
      QLog.d("ReportController", 2, paramIProxyManager.toString());
    }
    this.jdField_a_of_type_ComTencentUtilMqqWeakReferenceHandler.sendEmptyMessage(9530);
  }
  
  protected void a(boolean paramBoolean)
  {
    if (paramBoolean)
    {
      BaseApplication localBaseApplication = BaseApplication.getContext();
      if (this.jdField_a_of_type_MqqAppAppRuntime.getAccount() != null) {
        localObject = this.jdField_a_of_type_MqqAppAppRuntime.getAccount();
      } else {
        localObject = "10000";
      }
      Object localObject = localBaseApplication.getSharedPreferences((String)localObject, 0);
      long l = System.currentTimeMillis();
      if (Math.abs(l - ((SharedPreferences)localObject).getLong("pre_report_time", l)) < this.jdField_a_of_type_Long) {
        return;
      }
    }
    if (!this.jdField_a_of_type_ComTencentUtilMqqWeakReferenceHandler.hasMessages(9527)) {
      this.jdField_a_of_type_ComTencentUtilMqqWeakReferenceHandler.sendEmptyMessage(9527);
    }
  }
  
  protected void b()
  {
    this.jdField_a_of_type_ComTencentUtilMqqWeakReferenceHandler.removeMessages(9527);
  }
  
  protected void b(AppRuntime paramAppRuntime, IProxyManager paramIProxyManager)
  {
    this.jdField_a_of_type_JavaLangBoolean = Boolean.valueOf(false);
    if (QLog.isColorLevel())
    {
      paramIProxyManager = new StringBuilder();
      paramIProxyManager.append("Destory:");
      paramIProxyManager.append(paramAppRuntime);
      QLog.d("ReportController", 2, paramIProxyManager.toString());
    }
    this.jdField_a_of_type_ComTencentUtilMqqWeakReferenceHandler.sendEmptyMessage(9528);
  }
  
  public boolean handleMessage(Message paramMessage)
  {
    if (paramMessage.what == 9529)
    {
      paramMessage = (ReportControllerImpl.ReportingBridge)paramMessage.obj;
      b(paramMessage.jdField_a_of_type_JavaLangString, paramMessage.b, paramMessage.jdField_a_of_type_Int);
    }
    else if (paramMessage.what == 9527)
    {
      d();
    }
    else if (paramMessage.what == 9528)
    {
      b(this.jdField_a_of_type_MqqAppAppRuntime);
    }
    else if (paramMessage.what == 9530)
    {
      c();
    }
    return true;
  }
  
  public void onReceive(int paramInt, boolean paramBoolean, Bundle paramBundle)
  {
    if (paramInt == 10)
    {
      int i = paramBundle.getInt("seqKey");
      paramInt = 0;
      if (QLog.isColorLevel())
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("OnReceive: isSuccess-");
        ((StringBuilder)localObject).append(paramBoolean);
        ((StringBuilder)localObject).append(", seqKey = ");
        ((StringBuilder)localObject).append(i);
        QLog.d("ReportController", 2, ((StringBuilder)localObject).toString());
      }
      if (!paramBoolean) {
        paramInt = paramBundle.getInt("retryTime");
      }
      Object localObject = this.jdField_a_of_type_MqqAppAppRuntime;
      if ((!paramBoolean) && (paramInt < 2) && (localObject != null))
      {
        NewIntent localNewIntent = new NewIntent(BaseApplication.getContext(), ReportServlet.class);
        localNewIntent.putExtra("sendType", 10);
        localNewIntent.putExtra("seqKey", i);
        localNewIntent.putExtra("tags", paramBundle.getStringArrayList("tags"));
        localNewIntent.putExtra("contents", paramBundle.getStringArrayList("contents"));
        localNewIntent.putExtra("retryTime", paramInt + 1);
        localNewIntent.setObserver(this);
        ((AppRuntime)localObject).startServlet(localNewIntent);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.statistics.ReportControllerImpl
 * JD-Core Version:    0.7.0.1
 */