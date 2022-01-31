package com.tencent.mobileqq.troop.utils;

import ajqb;
import ajqc;
import ajqe;
import android.text.TextUtils;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.FriendsManager;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.app.TroopHandler;
import com.tencent.mobileqq.app.TroopManager;
import com.tencent.mobileqq.app.TroopObserver;
import com.tencent.mobileqq.data.TroopInfo;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentLinkedQueue;

public class TroopNameHelper
{
  ajqe jdField_a_of_type_Ajqe;
  public FriendsManager a;
  public QQAppInterface a;
  public TroopHandler a;
  public TroopManager a;
  TroopObserver jdField_a_of_type_ComTencentMobileqqAppTroopObserver = new ajqb(this);
  public ConcurrentHashMap a;
  public ConcurrentLinkedQueue a;
  public ConcurrentHashMap b = new ConcurrentHashMap();
  
  public TroopNameHelper()
  {
    this.jdField_a_of_type_JavaUtilConcurrentConcurrentLinkedQueue = new ConcurrentLinkedQueue();
    this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap = new ConcurrentHashMap();
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = ((QQAppInterface)BaseApplicationImpl.getApplication().getRuntime());
    this.jdField_a_of_type_ComTencentMobileqqAppTroopManager = ((TroopManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(51));
    this.jdField_a_of_type_ComTencentMobileqqAppFriendsManager = ((FriendsManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(50));
    this.jdField_a_of_type_ComTencentMobileqqAppTroopHandler = ((TroopHandler)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(20));
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.addObserver(this.jdField_a_of_type_ComTencentMobileqqAppTroopObserver);
  }
  
  public static String a(ArrayList paramArrayList)
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
  
  private void a(ajqe paramajqe)
  {
    if ((!this.jdField_a_of_type_JavaUtilConcurrentConcurrentLinkedQueue.contains(paramajqe)) && (!paramajqe.a)) {
      this.jdField_a_of_type_JavaUtilConcurrentConcurrentLinkedQueue.add(paramajqe);
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
      localObject = (TroopManager)((QQAppInterface)BaseApplicationImpl.getApplication().getRuntime()).getManager(51);
      localTroopNameHelper = ((TroopManager)localObject).a();
      localObject = ((TroopManager)localObject).b(paramString);
    } while ((localObject == null) || (((TroopInfo)localObject).hasSetTroopName()));
    localTroopNameHelper.a(paramString, null);
  }
  
  public static void a(String paramString, boolean paramBoolean)
  {
    if ((BaseApplicationImpl.getApplication().getRuntime() instanceof QQAppInterface))
    {
      TroopNameHelper localTroopNameHelper = ((TroopManager)((QQAppInterface)BaseApplicationImpl.getApplication().getRuntime()).getManager(51)).a();
      ajqc localajqc = (ajqc)localTroopNameHelper.b.get(paramString);
      if (localajqc == null) {
        break label64;
      }
      localTroopNameHelper.a(localajqc);
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
      if ((this.jdField_a_of_type_Ajqe == null) || (!this.jdField_a_of_type_Ajqe.a))
      {
        this.jdField_a_of_type_Ajqe = null;
        this.jdField_a_of_type_Ajqe = ((ajqe)this.jdField_a_of_type_JavaUtilConcurrentConcurrentLinkedQueue.poll());
        if (this.jdField_a_of_type_Ajqe != null) {
          ThreadManager.post(this.jdField_a_of_type_Ajqe, 8, null, false);
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
      TroopNameHelper localTroopNameHelper = ((TroopManager)((QQAppInterface)BaseApplicationImpl.getApplication().getRuntime()).getManager(51)).a();
      localTroopNameHelper.getClass();
      localTroopNameHelper.a(new TroopNameHelper.FriendNameChanedTask(localTroopNameHelper, paramString));
    }
  }
  
  public void a()
  {
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.removeObserver(this.jdField_a_of_type_ComTencentMobileqqAppTroopObserver);
    this.jdField_a_of_type_JavaUtilConcurrentConcurrentLinkedQueue.clear();
    this.b.clear();
  }
  
  public void a(String paramString, TroopNameHelper.GenTroopNameCallback paramGenTroopNameCallback)
  {
    a(new ajqc(this, paramString, paramGenTroopNameCallback));
  }
  
  public boolean a(String paramString)
  {
    return this.b.containsKey(paramString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\tmp\aaa.jar
 * Qualified Name:     com.tencent.mobileqq.troop.utils.TroopNameHelper
 * JD-Core Version:    0.7.0.1
 */