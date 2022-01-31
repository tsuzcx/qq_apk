package com.tencent.mobileqq.statistics;

import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Bundle;
import android.os.Handler.Callback;
import android.os.Message;
import atmp;
import atmq;
import atmr;
import awdl;
import awqx;
import awra;
import badq;
import beez;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.app.proxy.ProxyManager;
import com.tencent.qphone.base.util.QLog;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Random;
import java.util.Set;
import mqq.app.NewIntent;
import mqq.manager.ServerConfigManager.ConfigType;
import mqq.observer.BusinessObserver;

public class ReportControllerImpl
  extends awqx
  implements Handler.Callback, BusinessObserver
{
  private int jdField_a_of_type_Int;
  private long jdField_a_of_type_Long;
  private beez jdField_a_of_type_Beez;
  private QQAppInterface jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
  private ProxyManager jdField_a_of_type_ComTencentMobileqqAppProxyProxyManager;
  private volatile Boolean jdField_a_of_type_JavaLangBoolean;
  private final HashMap<String, Reporting> jdField_a_of_type_JavaUtilHashMap = new HashMap();
  
  private ReportControllerImpl(QQAppInterface paramQQAppInterface)
  {
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
    if (QLog.isColorLevel()) {
      QLog.d("ReportController", 2, "Create:" + paramQQAppInterface);
    }
    this.jdField_a_of_type_Beez = new beez(ThreadManager.getSubThreadLooper(), this);
    try
    {
      paramQQAppInterface = paramQQAppInterface.a(ServerConfigManager.ConfigType.common, "ActionReportInterval");
      if ((paramQQAppInterface != null) && (paramQQAppInterface.length() > 0)) {
        this.jdField_a_of_type_Long = (Long.parseLong(paramQQAppInterface) * 1000L);
      }
    }
    catch (Exception paramQQAppInterface)
    {
      label99:
      break label99;
    }
    if (this.jdField_a_of_type_Long <= 1000L) {
      this.jdField_a_of_type_Long = 86400000L;
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
  
  public static awqx a(QQAppInterface paramQQAppInterface)
  {
    return new ReportControllerImpl(paramQQAppInterface);
  }
  
  private boolean a()
  {
    if (!badq.d(BaseApplicationImpl.sApplication)) {
      return false;
    }
    if (QLog.isColorLevel()) {
      QLog.d("ReportController", 2, "doReportClickEvent:" + this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
    }
    int j = this.jdField_a_of_type_JavaUtilHashMap.size();
    Object localObject1 = new ArrayList(20);
    Object localObject2 = new ArrayList(20);
    int i = a();
    Iterator localIterator = this.jdField_a_of_type_JavaUtilHashMap.keySet().iterator();
    int k = 0;
    Object localObject3;
    Reporting localReporting;
    while (localIterator.hasNext())
    {
      localObject3 = (String)localIterator.next();
      localReporting = (Reporting)this.jdField_a_of_type_JavaUtilHashMap.get(localObject3);
      if ((localReporting.mDetailHashCode != 0) && (localReporting.mDetail.hashCode() != localReporting.mDetailHashCode))
      {
        localIterator.remove();
        this.jdField_a_of_type_ComTencentMobileqqAppProxyProxyManager.a("", 0, "Reporting", localReporting, 5, null);
        j -= 1;
        if ((k % 20 != 0) && (k < j)) {
          break label480;
        }
        localObject3 = new NewIntent(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApplication(), awdl.class);
        ((NewIntent)localObject3).putExtra("sendType", 10);
        ((NewIntent)localObject3).putExtra("seqKey", i);
        ((NewIntent)localObject3).putExtra("tags", (Serializable)localObject1);
        ((NewIntent)localObject3).putExtra("retryTime", 0);
        ((NewIntent)localObject3).putExtra("contents", (Serializable)localObject2);
        ((NewIntent)localObject3).setObserver(this);
        this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.startServlet((NewIntent)localObject3);
        localObject2 = new ArrayList(20);
        localObject1 = new ArrayList(20);
        if (k >= j) {
          break label477;
        }
        i = a();
        label308:
        localObject3 = localObject2;
        localObject2 = localObject1;
        localObject1 = localObject3;
      }
      else
      {
        ((ArrayList)localObject1).add(localReporting.mTag);
        localObject3 = localReporting.mDetail.replace("${count_unknown}", String.valueOf(localReporting.mCount));
        if (!((String)localObject3).startsWith("${report_seq_prefix}")) {
          break label495;
        }
        localObject3 = ((String)localObject3).substring(((String)localObject3).indexOf("|") + 1);
      }
    }
    label477:
    label480:
    label495:
    for (;;)
    {
      ((ArrayList)localObject2).add(localObject3);
      localIterator.remove();
      this.jdField_a_of_type_ComTencentMobileqqAppProxyProxyManager.a("", 0, "Reporting", localReporting, 5, null);
      if (QLog.isColorLevel()) {
        QLog.d("ReportController", 2, "Report: " + localReporting.mTag + ", " + (String)localObject3 + ", " + i);
      }
      k += 1;
      break;
      return true;
      break label308;
      localObject3 = localObject1;
      localObject1 = localObject2;
      localObject2 = localObject3;
      break label308;
    }
  }
  
  private void b()
  {
    if (QLog.isColorLevel()) {
      QLog.d("ReportController", 2, "handleInit:" + this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
    }
    Object localObject = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getEntityManagerFactory().createEntityManager().a(Reporting.class);
    if (localObject != null)
    {
      localObject = ((List)localObject).iterator();
      while (((Iterator)localObject).hasNext())
      {
        Reporting localReporting1 = (Reporting)((Iterator)localObject).next();
        String str = localReporting1.mTag + ":" + localReporting1.mDetail;
        Reporting localReporting2 = (Reporting)this.jdField_a_of_type_JavaUtilHashMap.get(str);
        if (localReporting2 != null)
        {
          int i = localReporting1.mCount;
          localReporting2.mCount += i;
        }
        this.jdField_a_of_type_JavaUtilHashMap.put(str, localReporting1);
      }
    }
  }
  
  private void b(QQAppInterface paramQQAppInterface)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ReportController", 2, "saveReportData:" + paramQQAppInterface);
    }
    Object localObject = this.jdField_a_of_type_JavaUtilHashMap.values();
    if ((localObject != null) && (((Collection)localObject).size() > 0)) {}
    try
    {
      paramQQAppInterface = paramQQAppInterface.getEntityManagerFactory().createEntityManager();
      atmr localatmr = paramQQAppInterface.a();
      localatmr.a();
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
              paramQQAppInterface.b(localReporting);
            }
          }
          else
          {
            return;
          }
        }
        catch (Throwable localThrowable)
        {
          localatmr.c();
          localatmr.b();
          paramQQAppInterface.a();
        }
        paramQQAppInterface.a(localReporting);
      }
      return;
    }
    catch (Throwable paramQQAppInterface) {}
  }
  
  private void b(String paramString1, String paramString2, int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ReportController", 2, "addReporting:" + paramString2 + ", " + paramInt);
    }
    String str = paramString1 + ":" + paramString2;
    Reporting localReporting = (Reporting)this.jdField_a_of_type_JavaUtilHashMap.get(str);
    if (localReporting == null)
    {
      localReporting = new Reporting();
      localReporting.mTag = paramString1;
      localReporting.mDetail = paramString2;
      localReporting.mCount = paramInt;
      localReporting.mDetailHashCode = localReporting.mDetail.hashCode();
      this.jdField_a_of_type_JavaUtilHashMap.put(str, localReporting);
      if ((this.jdField_a_of_type_JavaLangBoolean != null) && (this.jdField_a_of_type_JavaLangBoolean.booleanValue())) {
        this.jdField_a_of_type_ComTencentMobileqqAppProxyProxyManager.a("", 0, "Reporting", localReporting, 3, null);
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
          break label455;
        }
        if (this.jdField_a_of_type_JavaUtilHashMap.size() >= 40)
        {
          c();
          if (QLog.isColorLevel()) {
            QLog.d("ReportController", 2, "handleAddReporting: handleReport r.mTag=" + paramString1.mTag + ", r.mDetail=" + paramString1.mDetail + ", r.mDetailHashCode=" + paramString1.mDetailHashCode);
          }
        }
      }
    }
    label455:
    do
    {
      do
      {
        return;
        localReporting.mCount += paramInt;
        if ((this.jdField_a_of_type_JavaLangBoolean != null) && (this.jdField_a_of_type_JavaLangBoolean.booleanValue())) {
          this.jdField_a_of_type_ComTencentMobileqqAppProxyProxyManager.a("", 0, "Reporting", localReporting.clone(), 4, null);
        }
        if (QLog.isColorLevel()) {
          QLog.d("ReportController", 2, "handleAddReporting:r.mTag=" + localReporting.mTag + ", r.mDetail=" + localReporting.mDetail + ", r.mDetailHashCode=" + localReporting.mDetailHashCode);
        }
        paramString1 = localReporting;
        break;
      } while (this.jdField_a_of_type_Beez.hasMessages(9528));
      this.jdField_a_of_type_Beez.sendEmptyMessage(9528);
    } while (!QLog.isColorLevel());
    QLog.d("ReportController", 2, "handleAddReporting: savedata r.mTag=" + paramString1.mTag + ", r.mDetail=" + paramString1.mDetail + ", r.mDetailHashCode=" + paramString1.mDetailHashCode);
  }
  
  private void c()
  {
    this.jdField_a_of_type_Beez.removeMessages(9527);
    try
    {
      a();
      Object localObject = BaseApplicationImpl.sApplication.getSharedPreferences(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getAccount(), 0);
      long l = System.currentTimeMillis();
      localObject = ((SharedPreferences)localObject).edit();
      ((SharedPreferences.Editor)localObject).putLong("pre_report_time", l);
      ((SharedPreferences.Editor)localObject).commit();
      this.jdField_a_of_type_Beez.sendEmptyMessageDelayed(9527, this.jdField_a_of_type_Long);
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
  
  public void a()
  {
    this.jdField_a_of_type_Beez.removeMessages(9527);
  }
  
  public void a(QQAppInterface paramQQAppInterface, ProxyManager paramProxyManager)
  {
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
    this.jdField_a_of_type_ComTencentMobileqqAppProxyProxyManager = paramProxyManager;
    this.jdField_a_of_type_JavaLangBoolean = Boolean.valueOf(true);
    if (QLog.isColorLevel()) {
      QLog.d("ReportController", 2, "Init:" + paramQQAppInterface);
    }
    this.jdField_a_of_type_Beez.sendEmptyMessage(9530);
  }
  
  public void a(String paramString1, String paramString2, int paramInt)
  {
    awra localawra = new awra();
    localawra.jdField_a_of_type_JavaLangString = paramString1;
    localawra.b = paramString2;
    localawra.jdField_a_of_type_Int = paramInt;
    this.jdField_a_of_type_Beez.obtainMessage(9529, localawra).sendToTarget();
  }
  
  public void a(boolean paramBoolean)
  {
    Object localObject;
    if (paramBoolean)
    {
      BaseApplicationImpl localBaseApplicationImpl = BaseApplicationImpl.sApplication;
      if (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getAccount() != null)
      {
        localObject = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getAccount();
        localObject = localBaseApplicationImpl.getSharedPreferences((String)localObject, 0);
        long l = System.currentTimeMillis();
        if (Math.abs(l - ((SharedPreferences)localObject).getLong("pre_report_time", l)) >= this.jdField_a_of_type_Long) {
          break label75;
        }
      }
    }
    label75:
    while (this.jdField_a_of_type_Beez.hasMessages(9527))
    {
      return;
      localObject = "10000";
      break;
    }
    this.jdField_a_of_type_Beez.sendEmptyMessage(9527);
  }
  
  public void b(QQAppInterface paramQQAppInterface, ProxyManager paramProxyManager)
  {
    this.jdField_a_of_type_JavaLangBoolean = Boolean.valueOf(false);
    if (QLog.isColorLevel()) {
      QLog.d("ReportController", 2, "Destory:" + paramQQAppInterface);
    }
    this.jdField_a_of_type_Beez.sendEmptyMessage(9528);
  }
  
  public boolean handleMessage(Message paramMessage)
  {
    if (paramMessage.what == 9529)
    {
      paramMessage = (awra)paramMessage.obj;
      b(paramMessage.jdField_a_of_type_JavaLangString, paramMessage.b, paramMessage.jdField_a_of_type_Int);
    }
    for (;;)
    {
      return true;
      if (paramMessage.what == 9527) {
        c();
      } else if (paramMessage.what == 9528) {
        b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
      } else if (paramMessage.what == 9530) {
        b();
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
      QQAppInterface localQQAppInterface = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
      if ((!paramBoolean) && (paramInt < 2) && (localQQAppInterface != null))
      {
        NewIntent localNewIntent = new NewIntent(localQQAppInterface.getApp(), awdl.class);
        localNewIntent.putExtra("sendType", 10);
        localNewIntent.putExtra("seqKey", i);
        localNewIntent.putExtra("tags", paramBundle.getStringArrayList("tags"));
        localNewIntent.putExtra("contents", paramBundle.getStringArrayList("contents"));
        localNewIntent.putExtra("retryTime", paramInt + 1);
        localNewIntent.setObserver(this);
        localQQAppInterface.startServlet(localNewIntent);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.mobileqq.statistics.ReportControllerImpl
 * JD-Core Version:    0.7.0.1
 */