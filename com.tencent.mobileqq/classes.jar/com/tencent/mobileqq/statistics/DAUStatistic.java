package com.tencent.mobileqq.statistics;

import android.os.Handler.Callback;
import android.os.Message;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.data.ActivityDAUInfo;
import com.tencent.mobileqq.persistence.EntityManager;
import com.tencent.mobileqq.persistence.EntityManagerFactory;
import com.tencent.mobileqq.persistence.EntityTransaction;
import com.tencent.mobileqq.utils.CustomHandler;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Set;
import mqq.manager.Manager;
import mqq.os.MqqHandler;

public class DAUStatistic
  implements Handler.Callback, UEC.IReporter, Manager
{
  public static boolean a;
  private QQAppInterface jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
  private EntityManager jdField_a_of_type_ComTencentMobileqqPersistenceEntityManager;
  private HashMap jdField_a_of_type_JavaUtilHashMap;
  private MqqHandler jdField_a_of_type_MqqOsMqqHandler;
  
  public DAUStatistic(QQAppInterface paramQQAppInterface)
  {
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
    this.jdField_a_of_type_JavaUtilHashMap = new HashMap(4);
    this.jdField_a_of_type_MqqOsMqqHandler = new CustomHandler(ThreadManager.getSubThreadLooper(), this);
    a();
  }
  
  public static void a(String paramString1, String paramString2) {}
  
  public String a(String paramString1, String paramString2)
  {
    try
    {
      arrayOfString = paramString2.split("\\|");
      if (arrayOfString == null) {
        return paramString1;
      }
      i = 0;
    }
    catch (Exception localException1)
    {
      try
      {
        String[] arrayOfString;
        int i;
        if (i >= arrayOfString.length) {
          break label165;
        }
        String str1 = arrayOfString[i];
        int j = str1.indexOf("+");
        int k = str1.indexOf(":");
        paramString2 = paramString1;
        if (j > 0)
        {
          paramString2 = paramString1;
          if (k > 0)
          {
            paramString2 = str1.substring(0, j);
            String str2 = str1.substring(j + 1, k);
            str1 = str1.substring(k + 1);
            paramString2 = UEC.a(paramString1, paramString2, Integer.valueOf(str2).intValue(), Integer.valueOf(str1).intValue());
          }
        }
        i += 1;
        paramString1 = paramString2;
      }
      catch (Exception localException2)
      {
        label129:
        break label129;
      }
      localException1 = localException1;
      paramString2 = paramString1;
      if (!QLog.isColorLevel()) {
        break label165;
      }
      QLog.d("Q.activity_dau", 2, "saveToDB|preActivityList error:" + localException1);
      paramString2 = paramString1;
    }
    paramString2 = paramString1;
    label165:
    return paramString2;
    return paramString1;
  }
  
  public void a()
  {
    try
    {
      String str = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.c();
      if (Long.valueOf(str).longValue() / 1000L % 1000L < 10L) {
        jdField_a_of_type_Boolean = true;
      }
      if (QLog.isColorLevel()) {
        QLog.d("UEC", 2, "dau uin=" + str + " result=" + jdField_a_of_type_Boolean);
      }
      return;
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
    }
  }
  
  public void a(ArrayList paramArrayList)
  {
    if (jdField_a_of_type_Boolean)
    {
      Message localMessage = new Message();
      localMessage.what = 0;
      localMessage.obj = paramArrayList;
      this.jdField_a_of_type_MqqOsMqqHandler.sendMessage(localMessage);
    }
  }
  
  public boolean handleMessage(Message paramMessage)
  {
    Object localObject2;
    Object localObject3;
    if (paramMessage.what == 0)
    {
      paramMessage = (ArrayList)paramMessage.obj;
      if (paramMessage != null)
      {
        paramMessage = paramMessage.iterator();
        label363:
        while (paramMessage.hasNext())
        {
          localObject2 = (UEC.UECItem)paramMessage.next();
          localObject1 = ((UEC.UECItem)localObject2).jdField_a_of_type_JavaLangString;
          if (this.jdField_a_of_type_JavaUtilHashMap.containsKey(localObject1))
          {
            localObject3 = (ActivityDAUInfo)this.jdField_a_of_type_JavaUtilHashMap.get(localObject1);
            ((ActivityDAUInfo)localObject3).count += 1;
            ((ActivityDAUInfo)localObject3).showTime += ((UEC.UECItem)localObject2).jdField_a_of_type_Long;
            ((ActivityDAUInfo)localObject3).displayCount += ((UEC.UECItem)localObject2).jdField_b_of_type_Int;
            ((ActivityDAUInfo)localObject3).preActivityList = a(((ActivityDAUInfo)localObject3).preActivityList, ((UEC.UECItem)localObject2).jdField_b_of_type_JavaLangString);
            ((ActivityDAUInfo)localObject3).webTitle = ((UEC.UECItem)localObject2).c;
            ((ActivityDAUInfo)localObject3).domain = ((UEC.UECItem)localObject2).d;
            ((ActivityDAUInfo)localObject3).reportVersion = ((UEC.UECItem)localObject2).e;
            ((ActivityDAUInfo)localObject3).pageName = ((UEC.UECItem)localObject2).f;
          }
          for (;;)
          {
            if (!QLog.isColorLevel()) {
              break label363;
            }
            localObject2 = (ActivityDAUInfo)this.jdField_a_of_type_JavaUtilHashMap.get(localObject1);
            if (localObject2 == null) {
              break;
            }
            QLog.d("Q.activity_dau", 2, "reportInternal|activityName:" + (String)localObject1 + " count:" + ((ActivityDAUInfo)localObject2).count + " time:" + ((ActivityDAUInfo)localObject2).showTime + " v:" + ((ActivityDAUInfo)localObject2).reportVersion + " page:" + ((ActivityDAUInfo)localObject2).pageName);
            break;
            localObject3 = new ActivityDAUInfo();
            ((ActivityDAUInfo)localObject3).count = 1;
            ((ActivityDAUInfo)localObject3).activityName = ((String)localObject1);
            ((ActivityDAUInfo)localObject3).showTime = ((UEC.UECItem)localObject2).jdField_a_of_type_Long;
            ((ActivityDAUInfo)localObject3).displayCount = ((UEC.UECItem)localObject2).jdField_b_of_type_Int;
            ((ActivityDAUInfo)localObject3).preActivityList = ((UEC.UECItem)localObject2).jdField_b_of_type_JavaLangString;
            ((ActivityDAUInfo)localObject3).webTitle = ((UEC.UECItem)localObject2).c;
            ((ActivityDAUInfo)localObject3).domain = ((UEC.UECItem)localObject2).d;
            ((ActivityDAUInfo)localObject3).reportVersion = ((UEC.UECItem)localObject2).e;
            ((ActivityDAUInfo)localObject3).pageName = ((UEC.UECItem)localObject2).f;
            this.jdField_a_of_type_JavaUtilHashMap.put(localObject1, localObject3);
          }
        }
      }
      if (this.jdField_a_of_type_JavaUtilHashMap.size() >= 4)
      {
        this.jdField_a_of_type_MqqOsMqqHandler.removeMessages(1);
        this.jdField_a_of_type_MqqOsMqqHandler.sendEmptyMessage(1);
      }
    }
    while (paramMessage.what != 1)
    {
      do
      {
        return false;
      } while (this.jdField_a_of_type_MqqOsMqqHandler.hasMessages(1));
      this.jdField_a_of_type_MqqOsMqqHandler.sendEmptyMessageDelayed(1, 120000L);
      return false;
    }
    try
    {
      if (this.jdField_a_of_type_ComTencentMobileqqPersistenceEntityManager != null) {
        break label473;
      }
      if (!this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.isLogin()) {
        return false;
      }
    }
    finally {}
    this.jdField_a_of_type_ComTencentMobileqqPersistenceEntityManager = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getEntityManagerFactory().createEntityManager();
    label473:
    paramMessage = this.jdField_a_of_type_JavaUtilHashMap.keySet();
    Object localObject1 = this.jdField_a_of_type_ComTencentMobileqqPersistenceEntityManager.a();
    try
    {
      ((EntityTransaction)localObject1).a();
      localObject2 = paramMessage.iterator();
      if (!((Iterator)localObject2).hasNext()) {
        break label902;
      }
      localObject3 = (String)((Iterator)localObject2).next();
      localActivityDAUInfo = (ActivityDAUInfo)this.jdField_a_of_type_JavaUtilHashMap.get(localObject3);
      paramMessage = (ActivityDAUInfo)this.jdField_a_of_type_ComTencentMobileqqPersistenceEntityManager.a(ActivityDAUInfo.class, (String)localObject3);
      if (paramMessage != null) {
        break label801;
      }
      paramMessage = new ActivityDAUInfo();
      paramMessage.activityName = ((String)localObject3);
      paramMessage.count = localActivityDAUInfo.count;
      paramMessage.showTime = localActivityDAUInfo.showTime;
      paramMessage.displayCount = localActivityDAUInfo.displayCount;
      paramMessage.preActivityList = localActivityDAUInfo.preActivityList;
    }
    catch (Exception paramMessage)
    {
      for (;;)
      {
        ActivityDAUInfo localActivityDAUInfo;
        paramMessage.printStackTrace();
        ((EntityTransaction)localObject1).b();
        if (QLog.isColorLevel()) {
          QLog.d("Q.activity_dau", 2, "saveToDB|cache size:" + this.jdField_a_of_type_JavaUtilHashMap.size());
        }
        this.jdField_a_of_type_JavaUtilHashMap.clear();
        return false;
        paramMessage.count += localActivityDAUInfo.count;
        paramMessage.showTime += localActivityDAUInfo.showTime;
        paramMessage.displayCount += localActivityDAUInfo.displayCount;
        paramMessage.preActivityList = a(paramMessage.preActivityList, localActivityDAUInfo.preActivityList);
      }
    }
    finally
    {
      ((EntityTransaction)localObject1).b();
    }
    paramMessage.webTitle = localActivityDAUInfo.webTitle;
    paramMessage.domain = localActivityDAUInfo.domain;
    paramMessage.reportVersion = localActivityDAUInfo.reportVersion;
    paramMessage.pageName = localActivityDAUInfo.pageName;
    if (paramMessage.getStatus() == 1000) {
      this.jdField_a_of_type_ComTencentMobileqqPersistenceEntityManager.b(paramMessage);
    }
    label902:
    label911:
    for (;;)
    {
      label657:
      if (QLog.isColorLevel())
      {
        QLog.d("Q.activity_dau", 2, "MSG_SAVE_TO_DB|activityName:" + (String)localObject3 + " count:" + paramMessage.count + " time:" + paramMessage.showTime + " v:" + paramMessage.reportVersion + " page:" + paramMessage.pageName);
        break;
      }
      for (;;)
      {
        label801:
        if ((paramMessage.getStatus() != 1001) && (paramMessage.getStatus() != 1002)) {
          break label911;
        }
        this.jdField_a_of_type_ComTencentMobileqqPersistenceEntityManager.a(paramMessage);
        break label657;
        break;
        ((EntityTransaction)localObject1).c();
        ((EntityTransaction)localObject1).b();
      }
    }
  }
  
  public void onDestroy()
  {
    jdField_a_of_type_Boolean = false;
    if (this.jdField_a_of_type_ComTencentMobileqqPersistenceEntityManager != null) {}
    try
    {
      this.jdField_a_of_type_ComTencentMobileqqPersistenceEntityManager.a();
      return;
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.mobileqq.statistics.DAUStatistic
 * JD-Core Version:    0.7.0.1
 */