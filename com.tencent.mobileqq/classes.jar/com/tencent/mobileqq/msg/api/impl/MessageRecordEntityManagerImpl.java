package com.tencent.mobileqq.msg.api.impl;

import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.msg.api.IMessageRecordEntityManager;
import com.tencent.mobileqq.persistence.EntityManager;
import com.tencent.mobileqq.persistence.MessageRecordEntityManager;
import com.tencent.mobileqq.persistence.QQEntityManagerFactoryProxy;
import java.util.List;
import mqq.app.AppRuntime;

public class MessageRecordEntityManagerImpl
  implements IMessageRecordEntityManager
{
  AppRuntime mAppRuntime;
  
  public EntityManager createMessageRecordEntityManager()
  {
    AppRuntime localAppRuntime = this.mAppRuntime;
    if ((localAppRuntime instanceof QQAppInterface)) {
      return ((QQAppInterface)localAppRuntime).getEntityManagerFactory().b();
    }
    return null;
  }
  
  public void onCreate(AppRuntime paramAppRuntime)
  {
    this.mAppRuntime = paramAppRuntime;
  }
  
  public void onDestroy() {}
  
  public List rawQuery(String paramString, String[] paramArrayOfString)
  {
    MessageRecordEntityManager localMessageRecordEntityManager = (MessageRecordEntityManager)createMessageRecordEntityManager();
    if (localMessageRecordEntityManager != null) {
      return localMessageRecordEntityManager.a(paramString, paramArrayOfString);
    }
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.msg.api.impl.MessageRecordEntityManagerImpl
 * JD-Core Version:    0.7.0.1
 */