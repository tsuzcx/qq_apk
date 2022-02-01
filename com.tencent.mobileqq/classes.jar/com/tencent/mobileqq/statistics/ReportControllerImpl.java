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
    if (QLog.isColorLevel()) {
      QLog.d("ReportController", 2, "Create:" + paramAppRuntime);
    }
    this.jdField_a_of_type_ComTencentUtilMqqWeakReferenceHandler = new MqqWeakReferenceHandler(ThreadManager.getSubThreadLooper(), this);
    for (;;)
    {
      try
      {
        IReportDataProviderService localIReportDataProviderService = ReportControllerServiceHolder.a();
        if (localIReportDataProviderService == null) {
          continue;
        }
        paramAppRuntime = localIReportDataProviderService.a(paramAppRuntime, ServerConfigManager.ConfigType.common, "ActionReportInterval");
        if ((paramAppRuntime != null) && (paramAppRuntime.length() > 0)) {
          this.jdField_a_of_type_Long = (Long.parseLong(paramAppRuntime) * 1000L);
        }
      }
      catch (Exception paramAppRuntime)
      {
        continue;
      }
      if (this.jdField_a_of_type_Long <= 1000L) {
        this.jdField_a_of_type_Long = 86400000L;
      }
      return;
      paramAppRuntime = "";
    }
  }
  
  private int a()
  {
    for (;;)
    {
      try
      {
        if (this.jdField_a_of_type_Int <= 0)
        {
          this.jdField_a_of_type_Int = (new Random().nextInt(1000000) + 100);
          int i = this.jdField_a_of_type_Int;
          return i;
        }
        if (this.jdField_a_of_type_Int >= 1000100) {
          this.jdField_a_of_type_Int = 100;
        } else {
          this.jdField_a_of_type_Int += 1;
        }
      }
      finally {}
    }
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
    if (QLog.isColorLevel()) {
      QLog.d("ReportController", 2, "doReportClickEvent:" + this.jdField_a_of_type_MqqAppAppRuntime);
    }
    int k = this.b.size();
    Object localObject1 = new ArrayList(20);
    Object localObject2 = new ArrayList(20);
    int i = a();
    Iterator localIterator = this.b.keySet().iterator();
    int j = 0;
    Object localObject3;
    Reporting localReporting;
    if (localIterator.hasNext())
    {
      localObject3 = (String)localIterator.next();
      localReporting = (Reporting)this.b.get(localObject3);
      if ((localReporting.mDetailHashCode != 0) && (localReporting.mDetail.hashCode() != localReporting.mDetailHashCode))
      {
        localIterator.remove();
        this.jdField_a_of_type_ComTencentMobileqqBridgeReportServiceIProxyManager.a("", 0, "Reporting", localReporting, 5);
        k -= 1;
      }
      for (;;)
      {
        if ((j % 20 == 0) || (j >= k))
        {
          localObject3 = new NewIntent(this.jdField_a_of_type_MqqAppAppRuntime.getApplication(), ReportServlet.class);
          ((NewIntent)localObject3).putExtra("sendType", 10);
          ((NewIntent)localObject3).putExtra("seqKey", i);
          ((NewIntent)localObject3).putExtra("tags", (Serializable)localObject1);
          ((NewIntent)localObject3).putExtra("retryTime", 0);
          ((NewIntent)localObject3).putExtra("contents", (Serializable)localObject2);
          ((NewIntent)localObject3).setObserver(this);
          this.jdField_a_of_type_MqqAppAppRuntime.startServlet((NewIntent)localObject3);
          localObject2 = new ArrayList(20);
          localObject1 = new ArrayList(20);
          if (j < k)
          {
            i = a();
            label306:
            localObject3 = localObject2;
            localObject2 = localObject1;
            localObject1 = localObject3;
            break;
            if (b(localReporting.mTag))
            {
              localObject3 = a(localReporting.mTag);
              if (localObject3 != null) {
                ((ReportController.BusinessDataReporter)localObject3).a(localReporting);
              }
              localIterator.remove();
              this.jdField_a_of_type_ComTencentMobileqqBridgeReportServiceIProxyManager.a("", 0, "Reporting", localReporting, 5);
              k -= 1;
              continue;
            }
            ((ArrayList)localObject1).add(localReporting.mTag);
            localObject3 = localReporting.mDetail.replace("${count_unknown}", String.valueOf(localReporting.mCount));
            if (!((String)localObject3).startsWith("${report_seq_prefix}")) {
              break label568;
            }
            localObject3 = ((String)localObject3).substring(((String)localObject3).indexOf("|") + 1);
          }
        }
      }
    }
    label568:
    for (;;)
    {
      ((ArrayList)localObject2).add(localObject3);
      localIterator.remove();
      this.jdField_a_of_type_ComTencentMobileqqBridgeReportServiceIProxyManager.a("", 0, "Reporting", localReporting, 5);
      if (QLog.isColorLevel()) {
        QLog.d("ReportController", 2, "Report: " + localReporting.mTag + ", " + (String)localObject3 + ", " + i);
      }
      j += 1;
      break;
      a();
      return true;
      break label306;
      localObject3 = localObject1;
      localObject1 = localObject2;
      localObject2 = localObject3;
      break label306;
    }
  }
  
  private void b(String paramString1, String paramString2, int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ReportController", 2, "addReporting:" + paramString2 + ", " + paramInt);
    }
    String str = paramString1 + ":" + paramString2;
    Reporting localReporting = (Reporting)this.b.get(str);
    if (localReporting == null)
    {
      localReporting = new Reporting();
      localReporting.mTag = paramString1;
      localReporting.mDetail = paramString2;
      localReporting.mCount = paramInt;
      localReporting.mDetailHashCode = localReporting.mDetail.hashCode();
      this.b.put(str, localReporting);
      if ((this.jdField_a_of_type_JavaLangBoolean != null) && (this.jdField_a_of_type_JavaLangBoolean.booleanValue())) {
        this.jdField_a_of_type_ComTencentMobileqqBridgeReportServiceIProxyManager.a("", 0, "Reporting", localReporting, 3);
      }
      paramString1 = localReporting;
      if (QLog.isColorLevel())
      {
        QLog.d("ReportController", 2, "handleAddReporting:r.mTag=" + localReporting.mTag + ", r.mDetail=" + localReporting.mDetail + ", r.mDetailHashCode=" + localReporting.mDetailHashCode);
        paramString1 = localReporting;
      }
      if (this.jdField_a_of_type_JavaLangBoolean != null)
      {
        if (!this.jdField_a_of_type_JavaLangBoolean.booleanValue()) {
          break label457;
        }
        if (this.b.size() >= 40)
        {
          d();
          if (QLog.isColorLevel()) {
            QLog.d("ReportController", 2, "handleAddReporting: handleReport r.mTag=" + paramString1.mTag + ", r.mDetail=" + paramString1.mDetail + ", r.mDetailHashCode=" + paramString1.mDetailHashCode);
          }
        }
      }
    }
    label457:
    do
    {
      do
      {
        return;
        localReporting.mCount += paramInt;
        if ((this.jdField_a_of_type_JavaLangBoolean != null) && (this.jdField_a_of_type_JavaLangBoolean.booleanValue())) {
          this.jdField_a_of_type_ComTencentMobileqqBridgeReportServiceIProxyManager.a("", 0, "Reporting", localReporting.clone(), 4);
        }
        if (QLog.isColorLevel()) {
          QLog.d("ReportController", 2, "handleAddReporting:r.mTag=" + localReporting.mTag + ", r.mDetail=" + localReporting.mDetail + ", r.mDetailHashCode=" + localReporting.mDetailHashCode);
        }
        paramString1 = localReporting;
        break;
      } while (this.jdField_a_of_type_ComTencentUtilMqqWeakReferenceHandler.hasMessages(9528));
      this.jdField_a_of_type_ComTencentUtilMqqWeakReferenceHandler.sendEmptyMessage(9528);
    } while (!QLog.isColorLevel());
    QLog.d("ReportController", 2, "handleAddReporting: savedata r.mTag=" + paramString1.mTag + ", r.mDetail=" + paramString1.mDetail + ", r.mDetailHashCode=" + paramString1.mDetailHashCode);
  }
  
  private void b(AppRuntime paramAppRuntime)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ReportController", 2, "saveReportData:" + paramAppRuntime);
    }
    Object localObject = this.b.values();
    if ((localObject != null) && (((Collection)localObject).size() > 0)) {}
    try
    {
      paramAppRuntime = paramAppRuntime.getEntityManagerFactory().createEntityManager();
      EntityTransaction localEntityTransaction = paramAppRuntime.getTransaction();
      localEntityTransaction.begin();
      for (;;)
      {
        Reporting localReporting;
        try
        {
          localObject = ((Collection)localObject).iterator();
          if (((Iterator)localObject).hasNext())
          {
            localReporting = (Reporting)((Iterator)localObject).next();
            if (localReporting.getStatus() == 1000) {
              paramAppRuntime.persistOrReplace(localReporting);
            }
          }
          else
          {
            return;
          }
        }
        catch (Throwable localThrowable)
        {
          localEntityTransaction.commit();
          localEntityTransaction.end();
          paramAppRuntime.close();
        }
        paramAppRuntime.update(localReporting);
      }
      return;
    }
    catch (Throwable paramAppRuntime) {}
  }
  
  private void c()
  {
    if (QLog.isColorLevel()) {
      QLog.d("ReportController", 2, "handleInit:" + this.jdField_a_of_type_MqqAppAppRuntime);
    }
    Object localObject = this.jdField_a_of_type_MqqAppAppRuntime.getEntityManagerFactory().createEntityManager().query(Reporting.class);
    if (localObject != null)
    {
      localObject = ((List)localObject).iterator();
      while (((Iterator)localObject).hasNext())
      {
        Reporting localReporting1 = (Reporting)((Iterator)localObject).next();
        String str = localReporting1.mTag + ":" + localReporting1.mDetail;
        Reporting localReporting2 = (Reporting)this.b.get(str);
        if (localReporting2 != null)
        {
          int i = localReporting1.mCount;
          localReporting2.mCount += i;
        }
        this.b.put(str, localReporting1);
      }
    }
  }
  
  private void d()
  {
    this.jdField_a_of_type_ComTencentUtilMqqWeakReferenceHandler.removeMessages(9527);
    try
    {
      a();
      Object localObject = BaseApplication.getContext().getSharedPreferences(this.jdField_a_of_type_MqqAppAppRuntime.getAccount(), 0);
      long l = System.currentTimeMillis();
      localObject = ((SharedPreferences)localObject).edit();
      ((SharedPreferences.Editor)localObject).putLong("pre_report_time", l);
      ((SharedPreferences.Editor)localObject).commit();
      this.jdField_a_of_type_ComTencentUtilMqqWeakReferenceHandler.sendEmptyMessageDelayed(9527, this.jdField_a_of_type_Long);
      return;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        if (QLog.isDevelopLevel()) {
          QLog.d("ReportController", 4, "report exception:" + localException);
        }
      }
    }
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
    if (QLog.isColorLevel()) {
      QLog.d("ReportController", 2, "Init:" + paramAppRuntime);
    }
    this.jdField_a_of_type_ComTencentUtilMqqWeakReferenceHandler.sendEmptyMessage(9530);
  }
  
  protected void a(boolean paramBoolean)
  {
    Object localObject;
    if (paramBoolean)
    {
      BaseApplication localBaseApplication = BaseApplication.getContext();
      if (this.jdField_a_of_type_MqqAppAppRuntime.getAccount() != null)
      {
        localObject = this.jdField_a_of_type_MqqAppAppRuntime.getAccount();
        localObject = localBaseApplication.getSharedPreferences((String)localObject, 0);
        long l = System.currentTimeMillis();
        if (Math.abs(l - ((SharedPreferences)localObject).getLong("pre_report_time", l)) >= this.jdField_a_of_type_Long) {
          break label75;
        }
      }
    }
    label75:
    while (this.jdField_a_of_type_ComTencentUtilMqqWeakReferenceHandler.hasMessages(9527))
    {
      return;
      localObject = "10000";
      break;
    }
    this.jdField_a_of_type_ComTencentUtilMqqWeakReferenceHandler.sendEmptyMessage(9527);
  }
  
  protected void b()
  {
    this.jdField_a_of_type_ComTencentUtilMqqWeakReferenceHandler.removeMessages(9527);
  }
  
  protected void b(AppRuntime paramAppRuntime, IProxyManager paramIProxyManager)
  {
    this.jdField_a_of_type_JavaLangBoolean = Boolean.valueOf(false);
    if (QLog.isColorLevel()) {
      QLog.d("ReportController", 2, "Destory:" + paramAppRuntime);
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
    for (;;)
    {
      return true;
      if (paramMessage.what == 9527) {
        d();
      } else if (paramMessage.what == 9528) {
        b(this.jdField_a_of_type_MqqAppAppRuntime);
      } else if (paramMessage.what == 9530) {
        c();
      }
    }
  }
  
  public void onReceive(int paramInt, boolean paramBoolean, Bundle paramBundle)
  {
    if (paramInt == 10)
    {
      int i = paramBundle.getInt("seqKey");
      paramInt = 0;
      if (QLog.isColorLevel()) {
        QLog.d("ReportController", 2, "OnReceive: isSuccess-" + paramBoolean + ", seqKey = " + i);
      }
      if (!paramBoolean) {
        paramInt = paramBundle.getInt("retryTime");
      }
      AppRuntime localAppRuntime = this.jdField_a_of_type_MqqAppAppRuntime;
      if ((!paramBoolean) && (paramInt < 2) && (localAppRuntime != null))
      {
        NewIntent localNewIntent = new NewIntent(BaseApplication.getContext(), ReportServlet.class);
        localNewIntent.putExtra("sendType", 10);
        localNewIntent.putExtra("seqKey", i);
        localNewIntent.putExtra("tags", paramBundle.getStringArrayList("tags"));
        localNewIntent.putExtra("contents", paramBundle.getStringArrayList("contents"));
        localNewIntent.putExtra("retryTime", paramInt + 1);
        localNewIntent.setObserver(this);
        localAppRuntime.startServlet(localNewIntent);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.mobileqq.statistics.ReportControllerImpl
 * JD-Core Version:    0.7.0.1
 */