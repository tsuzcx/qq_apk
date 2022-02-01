package com.tencent.mobileqq.util;

import android.os.Bundle;
import android.os.Handler.Callback;
import android.os.Message;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.avatar.api.IQQAvatarHandlerService;
import com.tencent.mobileqq.data.Setting;
import com.tencent.mobileqq.nearby.ipc.ConnectNearbyProcService;
import com.tencent.mobileqq.persistence.EntityManager;
import com.tencent.mobileqq.persistence.EntityTransaction;
import com.tencent.mobileqq.persistence.QQEntityManagerFactoryProxy;
import com.tencent.util.MqqWeakReferenceHandler;
import java.util.ArrayList;
import mqq.os.MqqHandler;

public class IPCFaceHelper
  implements Handler.Callback
{
  QQAppInterface jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
  MqqHandler jdField_a_of_type_MqqOsMqqHandler;
  
  public IPCFaceHelper(QQAppInterface paramQQAppInterface)
  {
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
    this.jdField_a_of_type_MqqOsMqqHandler = new MqqWeakReferenceHandler(ThreadManager.getFileThreadLooper(), this);
  }
  
  public Setting a(String paramString)
  {
    return this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getFaceSetting(paramString);
  }
  
  public String a()
  {
    return ((IQQAvatarHandlerService)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getRuntimeService(IQQAvatarHandlerService.class, "")).getChoosedIP();
  }
  
  public void a(int paramInt1, String paramString, int paramInt2)
  {
    Message localMessage = this.jdField_a_of_type_MqqOsMqqHandler.obtainMessage();
    localMessage.what = 1;
    Bundle localBundle = new Bundle();
    localBundle.putInt("headType", paramInt1);
    localBundle.putString("id", paramString);
    localBundle.putInt("idType", paramInt2);
    localMessage.setData(localBundle);
    localMessage.sendToTarget();
  }
  
  public void a(Setting paramSetting)
  {
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.updateSettingTableCache(paramSetting);
    EntityManager localEntityManager = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getEntityManagerFactory().createEntityManager();
    localEntityManager.persistOrReplace(paramSetting);
    localEntityManager.close();
  }
  
  public void a(ArrayList<String> paramArrayList, long paramLong)
  {
    if (paramLong <= 0L) {
      return;
    }
    EntityManager localEntityManager = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getEntityManagerFactory().createEntityManager();
    EntityTransaction localEntityTransaction = localEntityManager.getTransaction();
    localEntityTransaction.begin();
    int i = 0;
    try
    {
      while (i < paramArrayList.size())
      {
        Setting localSetting = (Setting)localEntityManager.find(Setting.class, (String)paramArrayList.get(i));
        if (localSetting != null)
        {
          localSetting.updateTimestamp = paramLong;
          this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.updateSettingTableCache(localSetting);
          localEntityManager.update(localSetting);
        }
        i += 1;
      }
      return;
    }
    catch (Exception paramArrayList)
    {
      paramArrayList.printStackTrace();
      localEntityTransaction.commit();
      localEntityTransaction.end();
    }
  }
  
  public String b()
  {
    return ((IQQAvatarHandlerService)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getRuntimeService(IQQAvatarHandlerService.class, "")).getChoosedStrangerGroupIP();
  }
  
  public boolean handleMessage(Message paramMessage)
  {
    switch (paramMessage.what)
    {
    }
    for (;;)
    {
      return false;
      paramMessage.what = 4139;
      ConnectNearbyProcService.a(paramMessage);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.util.IPCFaceHelper
 * JD-Core Version:    0.7.0.1
 */