package com.tencent.mobileqq.troop.utils;

import ajxn;
import akhq;
import akim;
import android.text.TextUtils;
import balm;
import baln;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.app.TroopManager;
import com.tencent.mobileqq.data.TroopInfo;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentLinkedQueue;

public class TroopNameHelper
{
  ajxn jdField_a_of_type_Ajxn = (ajxn)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(51);
  akhq jdField_a_of_type_Akhq = (akhq)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(20);
  akim jdField_a_of_type_Akim = new balm(this);
  QQAppInterface jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = (QQAppInterface)BaseApplicationImpl.getApplication().getRuntime();
  public TroopManager a;
  TroopNameHelper.Task jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopNameHelper$Task;
  public ConcurrentHashMap<String, Long> a;
  ConcurrentLinkedQueue<TroopNameHelper.Task> jdField_a_of_type_JavaUtilConcurrentConcurrentLinkedQueue = new ConcurrentLinkedQueue();
  public ConcurrentHashMap<String, TroopNameHelper.GenTroopNameTask> b = new ConcurrentHashMap();
  
  public TroopNameHelper()
  {
    this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap = new ConcurrentHashMap();
    this.jdField_a_of_type_ComTencentMobileqqAppTroopManager = ((TroopManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(52));
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.addObserver(this.jdField_a_of_type_Akim);
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
      localObject = (TroopManager)((QQAppInterface)BaseApplicationImpl.getApplication().getRuntime()).getManager(52);
      localTroopNameHelper = ((TroopManager)localObject).a();
      localObject = ((TroopManager)localObject).c(paramString);
    } while ((localObject == null) || (((TroopInfo)localObject).hasSetTroopName()));
    localTroopNameHelper.a(paramString, null);
  }
  
  public static void a(String paramString, boolean paramBoolean)
  {
    if ((BaseApplicationImpl.getApplication().getRuntime() instanceof QQAppInterface))
    {
      TroopNameHelper localTroopNameHelper = ((TroopManager)((QQAppInterface)BaseApplicationImpl.getApplication().getRuntime()).getManager(52)).a();
      TroopNameHelper.GenTroopNameTask localGenTroopNameTask = (TroopNameHelper.GenTroopNameTask)localTroopNameHelper.b.get(paramString);
      if (localGenTroopNameTask == null) {
        break label64;
      }
      localTroopNameHelper.a(localGenTroopNameTask);
      localTroopNameHelper.b.remove(paramString);
    }
    label64:
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
      TroopNameHelper localTroopNameHelper = ((TroopManager)((QQAppInterface)BaseApplicationImpl.getApplication().getRuntime()).getManager(52)).a();
      localTroopNameHelper.getClass();
      localTroopNameHelper.a(new TroopNameHelper.FriendNameChanedTask(localTroopNameHelper, paramString));
    }
  }
  
  public void a()
  {
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.removeObserver(this.jdField_a_of_type_Akim);
    this.jdField_a_of_type_JavaUtilConcurrentConcurrentLinkedQueue.clear();
    this.b.clear();
  }
  
  public void a(String paramString, baln parambaln)
  {
    a(new TroopNameHelper.GenTroopNameTask(this, paramString, parambaln));
  }
  
  public boolean a(String paramString)
  {
    return this.b.containsKey(paramString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.troop.utils.TroopNameHelper
 * JD-Core Version:    0.7.0.1
 */