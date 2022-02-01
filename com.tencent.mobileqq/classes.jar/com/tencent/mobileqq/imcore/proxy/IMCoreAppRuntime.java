package com.tencent.mobileqq.imcore.proxy;

import com.tencent.mobileqq.activity.recent.config.RecentConfig;
import com.tencent.mobileqq.app.SQLiteDatabase;
import com.tencent.mobileqq.app.asyncdb.BaseCacheManager;
import com.tencent.mobileqq.app.proxy.BaseProxyManager;
import com.tencent.mobileqq.imcore.message.QQMessageFacadeStub;
import com.tencent.mobileqq.persistence.EntityManagerFactory;
import mqq.app.AppRuntime;

public abstract class IMCoreAppRuntime
  extends AppRuntime
{
  public BaseCacheManager getCacheManager()
  {
    return null;
  }
  
  public EntityManagerFactory getEntityManagerFactory()
  {
    return null;
  }
  
  public abstract EntityManagerFactory getEntityManagerFactory(String paramString);
  
  public QQMessageFacadeStub getMessageFacade()
  {
    return null;
  }
  
  public BaseProxyManager getProxyManager()
  {
    return null;
  }
  
  public RecentConfig getRecentConfig()
  {
    return new RecentConfig();
  }
  
  public SQLiteDatabase getWritableDatabase()
  {
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.mobileqq.imcore.proxy.IMCoreAppRuntime
 * JD-Core Version:    0.7.0.1
 */