package com.tencent.mobileqq.qcall;

import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.proxy.ProxyManager;
import com.tencent.mobileqq.persistence.EntityManager;
import com.tencent.mobileqq.persistence.QQEntityManagerFactoryProxy;
import com.tencent.qphone.base.util.QLog;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import mqq.manager.Manager;

public class QCallCardManager
  implements QCallCardConstants, Manager
{
  private QQAppInterface a;
  private ProxyManager b;
  private EntityManager c;
  private Object d = new Object();
  private ConcurrentHashMap<String, QCallCardInfo> e = new ConcurrentHashMap();
  
  public QCallCardManager(QQAppInterface paramQQAppInterface)
  {
    this.a = paramQQAppInterface;
    this.b = paramQQAppInterface.getProxyManager();
  }
  
  private EntityManager a()
  {
    ??? = this.c;
    if ((??? == null) || (!((EntityManager)???).isOpen())) {}
    synchronized (this.d)
    {
      if ((this.c == null) || (!this.c.isOpen())) {
        this.c = this.a.getEntityManagerFactory().createEntityManager();
      }
      return this.c;
    }
  }
  
  private void b()
  {
    EntityManager localEntityManager = this.c;
    if ((localEntityManager != null) && (localEntityManager.isOpen())) {
      this.c.close();
    }
  }
  
  public QCallCardInfo a(String paramString)
  {
    if (this.e.containsKey(paramString)) {
      return (QCallCardInfo)this.e.get(paramString);
    }
    paramString = a().query(QCallCardInfo.class, false, "uin = ?", new String[] { paramString }, null, null, null, null);
    if (paramString != null) {
      return (QCallCardInfo)paramString.get(0);
    }
    return null;
  }
  
  public void a(QCallCardInfo paramQCallCardInfo)
  {
    if (paramQCallCardInfo == null)
    {
      if (QLog.isColorLevel()) {
        QLog.d("QCallCardManager", 2, "saveQcallCard null ");
      }
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.d("QCallCardManager", 2, "CardManager saveQcallCard");
    }
    b(paramQCallCardInfo);
    this.b.addMsgQueueAndNotify(paramQCallCardInfo.uin, 0, paramQCallCardInfo.getTableName(), paramQCallCardInfo, 3, null);
  }
  
  public void b(QCallCardInfo paramQCallCardInfo)
  {
    if (paramQCallCardInfo == null) {
      return;
    }
    try
    {
      if (this.e.containsKey(paramQCallCardInfo.uin)) {
        this.e.replace(paramQCallCardInfo.uin, paramQCallCardInfo);
      } else {
        this.e.put(paramQCallCardInfo.uin, paramQCallCardInfo);
      }
      return;
    }
    finally {}
  }
  
  public void onDestroy()
  {
    b();
    this.e.clear();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.qcall.QCallCardManager
 * JD-Core Version:    0.7.0.1
 */