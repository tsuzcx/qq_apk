package com.tencent.mobileqq.troop.api.utils;

import android.text.TextUtils;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.data.troop.TroopInfo;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.mobileqq.troop.api.ITroopInfoService;
import com.tencent.mobileqq.troop.api.observer.TroopObserver;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentLinkedQueue;
import mqq.app.AppRuntime;
import tencent.im.oidb.cmd0x899.oidb_0x899.memberlist;

public class TroopNameHelper
{
  TroopObserver a;
  protected TroopNameHelper.Task a;
  protected ConcurrentHashMap<String, Long> a;
  protected ConcurrentLinkedQueue<TroopNameHelper.Task> a;
  protected AppRuntime a;
  protected ConcurrentHashMap<String, TroopNameHelper.GenTroopNameTask> b = new ConcurrentHashMap();
  
  public TroopNameHelper(AppRuntime paramAppRuntime)
  {
    this.jdField_a_of_type_JavaUtilConcurrentConcurrentLinkedQueue = new ConcurrentLinkedQueue();
    this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap = new ConcurrentHashMap();
    this.jdField_a_of_type_ComTencentMobileqqTroopApiObserverTroopObserver = new TroopNameHelper.1(this);
    this.jdField_a_of_type_MqqAppAppRuntime = paramAppRuntime;
    if ((paramAppRuntime instanceof AppInterface)) {
      ((AppInterface)paramAppRuntime).addObserver(this.jdField_a_of_type_ComTencentMobileqqTroopApiObserverTroopObserver);
    }
  }
  
  private void b()
  {
    try
    {
      if ((this.jdField_a_of_type_ComTencentMobileqqTroopApiUtilsTroopNameHelper$Task == null) || (!this.jdField_a_of_type_ComTencentMobileqqTroopApiUtilsTroopNameHelper$Task.a))
      {
        this.jdField_a_of_type_ComTencentMobileqqTroopApiUtilsTroopNameHelper$Task = null;
        this.jdField_a_of_type_ComTencentMobileqqTroopApiUtilsTroopNameHelper$Task = ((TroopNameHelper.Task)this.jdField_a_of_type_JavaUtilConcurrentConcurrentLinkedQueue.poll());
        if (this.jdField_a_of_type_ComTencentMobileqqTroopApiUtilsTroopNameHelper$Task != null)
        {
          this.jdField_a_of_type_ComTencentMobileqqTroopApiUtilsTroopNameHelper$Task.a = true;
          ThreadManager.post(this.jdField_a_of_type_ComTencentMobileqqTroopApiUtilsTroopNameHelper$Task, 8, null, false);
        }
      }
      return;
    }
    finally {}
  }
  
  public String a(ArrayList<String> paramArrayList)
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
  
  public void a()
  {
    if ((this.jdField_a_of_type_MqqAppAppRuntime instanceof AppInterface)) {
      ((AppInterface)this.jdField_a_of_type_MqqAppAppRuntime).removeObserver(this.jdField_a_of_type_ComTencentMobileqqTroopApiObserverTroopObserver);
    }
    this.jdField_a_of_type_JavaUtilConcurrentConcurrentLinkedQueue.clear();
    this.b.clear();
  }
  
  public void a(TroopNameHelper.Task paramTask)
  {
    if ((!this.jdField_a_of_type_JavaUtilConcurrentConcurrentLinkedQueue.contains(paramTask)) && (!paramTask.a)) {
      this.jdField_a_of_type_JavaUtilConcurrentConcurrentLinkedQueue.add(paramTask);
    }
    b();
  }
  
  public void a(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {}
    TroopInfo localTroopInfo;
    do
    {
      return;
      localTroopInfo = ((ITroopInfoService)this.jdField_a_of_type_MqqAppAppRuntime.getRuntimeService(ITroopInfoService.class, "")).getTroopInfo(paramString);
    } while ((localTroopInfo == null) || (localTroopInfo.hasSetTroopName()));
    a(paramString, null);
  }
  
  protected void a(String paramString, long paramLong)
  {
    this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.put(paramString, Long.valueOf(paramLong));
    TroopNameHelper.GenTroopNameTask localGenTroopNameTask = (TroopNameHelper.GenTroopNameTask)this.b.get(paramString);
    if (localGenTroopNameTask != null)
    {
      a(localGenTroopNameTask);
      this.b.remove(paramString);
    }
  }
  
  public void a(String paramString, TroopNameHelper.GenTroopNameCallback paramGenTroopNameCallback)
  {
    a(new TroopNameHelper.GenTroopNameTask(this, paramString, paramGenTroopNameCallback));
  }
  
  public void a(String paramString, boolean paramBoolean)
  {
    TroopNameHelper.GenTroopNameTask localGenTroopNameTask = (TroopNameHelper.GenTroopNameTask)this.b.get(paramString);
    if (localGenTroopNameTask != null)
    {
      a(localGenTroopNameTask);
      this.b.remove(paramString);
    }
    while (!paramBoolean) {
      return;
    }
    a(paramString);
  }
  
  protected void a(boolean paramBoolean, long paramLong, int paramInt, List<oidb_0x899.memberlist> paramList, String paramString)
  {
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder(150);
      ((StringBuilder)localObject).append("onOIDB0X899_0_Ret").append("| isSuccess = ").append(paramBoolean).append("| troopuin = ").append(paramLong).append("| nFlag = ").append(paramInt).append("| strErorMsg = ").append(paramString);
      QLog.i("TroopNameHelper", 2, ((StringBuilder)localObject).toString());
    }
    paramString = String.valueOf(paramLong);
    Object localObject = (ITroopInfoService)this.jdField_a_of_type_MqqAppAppRuntime.getRuntimeService(ITroopInfoService.class, "");
    TroopInfo localTroopInfo;
    if ((paramInt == 1) && (paramBoolean) && (this.b.containsKey(paramString)))
    {
      localTroopInfo = ((ITroopInfoService)localObject).findTroopInfo(paramString);
      if (localTroopInfo != null) {}
    }
    else
    {
      return;
    }
    if (paramList == null) {}
    for (paramInt = 0;; paramInt = paramList.size())
    {
      if (paramInt == 1)
      {
        paramList = (oidb_0x899.memberlist)paramList.get(0);
        if ((paramList == null) || (!paramList.uint64_member_uin.has())) {
          break;
        }
        paramList = String.valueOf(paramList.uint64_member_uin.get());
        if ((paramList != null) && (!"".equals(paramList.trim()))) {
          localTroopInfo.troopowneruin = paramList.trim();
        }
      }
      ((ITroopInfoService)localObject).saveTroopInfo(localTroopInfo);
      paramList = (TroopNameHelper.GenTroopNameTask)this.b.get(paramString);
      if ((paramList == null) || (paramList.a)) {
        break;
      }
      a(paramList);
      return;
    }
  }
  
  public boolean a(String paramString)
  {
    return this.b.containsKey(paramString);
  }
  
  public void b(String paramString)
  {
    a(new TroopNameHelper.FriendNameChanedTask(this, paramString));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.mobileqq.troop.api.utils.TroopNameHelper
 * JD-Core Version:    0.7.0.1
 */