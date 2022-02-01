package com.tencent.mobileqq.troop.utils;

import android.text.TextUtils;
import anvk;
import aoep;
import aofu;
import bgli;
import bglj;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.BusinessHandlerFactory;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.app.TroopManager;
import com.tencent.mobileqq.data.troop.TroopInfo;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentLinkedQueue;

public class TroopNameHelper
{
  anvk jdField_a_of_type_Anvk = (anvk)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.FRIENDS_MANAGER);
  aoep jdField_a_of_type_Aoep = (aoep)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getBusinessHandler(BusinessHandlerFactory.TROOP_HANDLER);
  aofu jdField_a_of_type_Aofu = new bgli(this);
  QQAppInterface jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = (QQAppInterface)BaseApplicationImpl.getApplication().getRuntime();
  public TroopManager a;
  TroopNameHelper.Task jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopNameHelper$Task;
  public ConcurrentHashMap<String, Long> a;
  ConcurrentLinkedQueue<TroopNameHelper.Task> jdField_a_of_type_JavaUtilConcurrentConcurrentLinkedQueue = new ConcurrentLinkedQueue();
  public ConcurrentHashMap<String, TroopNameHelper.GenTroopNameTask> b = new ConcurrentHashMap();
  
  public TroopNameHelper()
  {
    this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap = new ConcurrentHashMap();
    this.jdField_a_of_type_ComTencentMobileqqAppTroopManager = ((TroopManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.TROOP_MANAGER));
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.addObserver(this.jdField_a_of_type_Aofu);
  }
  
  public static String a(ArrayList<String> paramArrayList)
  {
    StringBuffer localStringBuffer = new StringBuffer();
    int i = 0;
    for (;;)
    {
      if (i < paramArrayList.size()) {
        localStringBuffer.append((String)paramArrayList.get(i)).append("、");
      }
      try
      {
        int j = localStringBuffer.toString().getBytes("utf-8").length;
        if (j > 48)
        {
          if (localStringBuffer.toString().endsWith("、")) {
            localStringBuffer.delete(localStringBuffer.length() - 1, localStringBuffer.length());
          }
          return localStringBuffer.toString();
        }
      }
      catch (Exception localException)
      {
        QLog.e("TroopNameHelper", 1, "get length failed!", localException);
        i += 1;
      }
    }
  }
  
  private void a(TroopNameHelper.Task paramTask)
  {
    if ((!this.jdField_a_of_type_JavaUtilConcurrentConcurrentLinkedQueue.contains(paramTask)) && (!paramTask.a)) {
      this.jdField_a_of_type_JavaUtilConcurrentConcurrentLinkedQueue.add(paramTask);
    }
    b();
  }
  
  public static void a(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {}
    Object localObject;
    TroopNameHelper localTroopNameHelper;
    do
    {
      do
      {
        return;
      } while (!(BaseApplicationImpl.getApplication().getRuntime() instanceof QQAppInterface));
      localObject = (TroopManager)((QQAppInterface)BaseApplicationImpl.getApplication().getRuntime()).getManager(QQManagerFactory.TROOP_MANAGER);
      localTroopNameHelper = ((TroopManager)localObject).a();
      localObject = ((TroopManager)localObject).c(paramString);
    } while ((localObject == null) || (((TroopInfo)localObject).hasSetTroopName()));
    localTroopNameHelper.a(paramString, null);
  }
  
  public static void a(String paramString, boolean paramBoolean)
  {
    if ((BaseApplicationImpl.getApplication().getRuntime() instanceof QQAppInterface))
    {
      TroopNameHelper localTroopNameHelper = ((TroopManager)((QQAppInterface)BaseApplicationImpl.getApplication().getRuntime()).getManager(QQManagerFactory.TROOP_MANAGER)).a();
      TroopNameHelper.GenTroopNameTask localGenTroopNameTask = (TroopNameHelper.GenTroopNameTask)localTroopNameHelper.b.get(paramString);
      if (localGenTroopNameTask == null) {
        break label65;
      }
      localTroopNameHelper.a(localGenTroopNameTask);
      localTroopNameHelper.b.remove(paramString);
    }
    label65:
    while (!paramBoolean) {
      return;
    }
    a(paramString);
  }
  
  private void b()
  {
    try
    {
      if ((this.jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopNameHelper$Task == null) || (!this.jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopNameHelper$Task.a))
      {
        this.jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopNameHelper$Task = null;
        this.jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopNameHelper$Task = ((TroopNameHelper.Task)this.jdField_a_of_type_JavaUtilConcurrentConcurrentLinkedQueue.poll());
        if (this.jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopNameHelper$Task != null)
        {
          this.jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopNameHelper$Task.a = true;
          ThreadManager.post(this.jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopNameHelper$Task, 8, null, false);
        }
      }
      return;
    }
    finally {}
  }
  
  public static void b(String paramString)
  {
    if ((BaseApplicationImpl.getApplication().getRuntime() instanceof QQAppInterface))
    {
      if (QLog.isColorLevel()) {
        QLog.d("TroopNameHelper", 2, "onFriendNameChaned uin = " + paramString);
      }
      TroopNameHelper localTroopNameHelper = ((TroopManager)((QQAppInterface)BaseApplicationImpl.getApplication().getRuntime()).getManager(QQManagerFactory.TROOP_MANAGER)).a();
      localTroopNameHelper.getClass();
      localTroopNameHelper.a(new TroopNameHelper.FriendNameChanedTask(localTroopNameHelper, paramString));
    }
  }
  
  public void a()
  {
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.removeObserver(this.jdField_a_of_type_Aofu);
    this.jdField_a_of_type_JavaUtilConcurrentConcurrentLinkedQueue.clear();
    this.b.clear();
  }
  
  public void a(String paramString, bglj parambglj)
  {
    a(new TroopNameHelper.GenTroopNameTask(this, paramString, parambglj));
  }
  
  public boolean a(String paramString)
  {
    return this.b.containsKey(paramString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.troop.utils.TroopNameHelper
 * JD-Core Version:    0.7.0.1
 */