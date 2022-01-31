package com.tencent.mobileqq.qcall;

import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.proxy.ProxyManager;
import com.tencent.mobileqq.persistence.EntityManager;
import com.tencent.mobileqq.persistence.EntityManagerFactory;
import com.tencent.qphone.base.util.QLog;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import mqq.manager.Manager;

public class QCallCardManager
  implements QCallCardConstants, Manager
{
  private QQAppInterface jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
  private ProxyManager jdField_a_of_type_ComTencentMobileqqAppProxyProxyManager;
  private EntityManager jdField_a_of_type_ComTencentMobileqqPersistenceEntityManager;
  private Object jdField_a_of_type_JavaLangObject = new Object();
  private ConcurrentHashMap jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap = new ConcurrentHashMap();
  
  public QCallCardManager(QQAppInterface paramQQAppInterface)
  {
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
    this.jdField_a_of_type_ComTencentMobileqqAppProxyProxyManager = paramQQAppInterface.a();
  }
  
  private EntityManager a()
  {
    if ((this.jdField_a_of_type_ComTencentMobileqqPersistenceEntityManager == null) || (!this.jdField_a_of_type_ComTencentMobileqqPersistenceEntityManager.a())) {}
    synchronized (this.jdField_a_of_type_JavaLangObject)
    {
      if ((this.jdField_a_of_type_ComTencentMobileqqPersistenceEntityManager == null) || (!this.jdField_a_of_type_ComTencentMobileqqPersistenceEntityManager.a())) {
        this.jdField_a_of_type_ComTencentMobileqqPersistenceEntityManager = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getEntityManagerFactory().createEntityManager();
      }
      return this.jdField_a_of_type_ComTencentMobileqqPersistenceEntityManager;
    }
  }
  
  private void a()
  {
    if ((this.jdField_a_of_type_ComTencentMobileqqPersistenceEntityManager != null) && (this.jdField_a_of_type_ComTencentMobileqqPersistenceEntityManager.a())) {
      this.jdField_a_of_type_ComTencentMobileqqPersistenceEntityManager.a();
    }
  }
  
  public QCallCardInfo a(String paramString)
  {
    if (this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.containsKey(paramString)) {
      return (QCallCardInfo)this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.get(paramString);
    }
    paramString = a().a(QCallCardInfo.class, false, "uin = ?", new String[] { paramString }, null, null, null, null);
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
    this.jdField_a_of_type_ComTencentMobileqqAppProxyProxyManager.b(paramQCallCardInfo.uin, 0, paramQCallCardInfo.getTableName(), paramQCallCardInfo, 3, null);
  }
  
  public void b(QCallCardInfo paramQCallCardInfo)
  {
    if (paramQCallCardInfo == null) {}
    for (;;)
    {
      return;
      try
      {
        if (this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.containsKey(paramQCallCardInfo.uin))
        {
          this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.replace(paramQCallCardInfo.uin, paramQCallCardInfo);
          continue;
        }
      }
      finally {}
      this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.put(paramQCallCardInfo.uin, paramQCallCardInfo);
    }
  }
  
  public void onDestroy()
  {
    a();
    this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.clear();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.mobileqq.qcall.QCallCardManager
 * JD-Core Version:    0.7.0.1
 */