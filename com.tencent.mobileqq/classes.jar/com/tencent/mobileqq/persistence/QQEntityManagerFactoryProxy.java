package com.tencent.mobileqq.persistence;

import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.SQLiteOpenHelper;
import com.tencent.mobileqq.data.QQEntityManagerFactory;
import com.tencent.mobileqq.data.QQEntityManagerFactory.Builder;
import com.tencent.mobileqq.data.entitymanager.upgrade.IOnDBUpgradeListener;
import com.tencent.mobileqq.persistence.bridge.DefaultOnDBUpgradeCallback;
import com.tencent.util.DBBuildUtil;

public final class QQEntityManagerFactoryProxy
  extends QQEntityManagerFactory
{
  private EntityManagerFactory jdField_a_of_type_ComTencentMobileqqPersistenceEntityManagerFactory;
  private DefaultOnDBUpgradeCallback jdField_a_of_type_ComTencentMobileqqPersistenceBridgeDefaultOnDBUpgradeCallback;
  
  private QQEntityManagerFactoryProxy(String paramString)
  {
    super(paramString, 0);
  }
  
  public static EntityManager a(QQAppInterface paramQQAppInterface)
  {
    return paramQQAppInterface.getEntityManagerFactory().createEntityManager();
  }
  
  public static EntityManager a(EntityManagerFactory paramEntityManagerFactory)
  {
    if (paramEntityManagerFactory.closed) {
      throw new IllegalStateException("The EntityManagerFactory has been already closed");
    }
    MessageRecordEntityManager localMessageRecordEntityManager = new MessageRecordEntityManager(paramEntityManagerFactory.dbHelper, paramEntityManagerFactory.mName);
    paramEntityManagerFactory.closed = false;
    return localMessageRecordEntityManager;
  }
  
  public static QQEntityManagerFactoryProxy a(String paramString)
  {
    QQEntityManagerFactoryProxy localQQEntityManagerFactoryProxy = new QQEntityManagerFactoryProxy(paramString);
    localQQEntityManagerFactoryProxy.jdField_a_of_type_ComTencentMobileqqPersistenceBridgeDefaultOnDBUpgradeCallback = new DefaultOnDBUpgradeCallback();
    localQQEntityManagerFactoryProxy.jdField_a_of_type_ComTencentMobileqqPersistenceEntityManagerFactory = DBBuildUtil.getDefaultEntityManagerFactoryBuilder(paramString).onDBUpgradeListener(localQQEntityManagerFactoryProxy.jdField_a_of_type_ComTencentMobileqqPersistenceBridgeDefaultOnDBUpgradeCallback).build();
    return localQQEntityManagerFactoryProxy;
  }
  
  public static QQEntityManagerFactoryProxy a(String paramString, EntityManagerFactory paramEntityManagerFactory)
  {
    paramString = new QQEntityManagerFactoryProxy(paramString);
    if ((paramEntityManagerFactory instanceof QQEntityManagerFactory))
    {
      IOnDBUpgradeListener localIOnDBUpgradeListener = ((QQEntityManagerFactory)paramEntityManagerFactory).getOnDBUpgradeListener();
      if ((localIOnDBUpgradeListener instanceof DefaultOnDBUpgradeCallback)) {
        paramString.jdField_a_of_type_ComTencentMobileqqPersistenceBridgeDefaultOnDBUpgradeCallback = ((DefaultOnDBUpgradeCallback)localIOnDBUpgradeListener);
      }
    }
    paramString.jdField_a_of_type_ComTencentMobileqqPersistenceEntityManagerFactory = paramEntityManagerFactory;
    return paramString;
  }
  
  public EntityManager a()
  {
    return a(this.jdField_a_of_type_ComTencentMobileqqPersistenceEntityManagerFactory);
  }
  
  public boolean a()
  {
    return (this.jdField_a_of_type_ComTencentMobileqqPersistenceBridgeDefaultOnDBUpgradeCallback != null) && (this.jdField_a_of_type_ComTencentMobileqqPersistenceBridgeDefaultOnDBUpgradeCallback.a());
  }
  
  public SQLiteOpenHelper build(String paramString)
  {
    return this.jdField_a_of_type_ComTencentMobileqqPersistenceEntityManagerFactory.build(paramString);
  }
  
  public void close()
  {
    this.jdField_a_of_type_ComTencentMobileqqPersistenceEntityManagerFactory.close();
  }
  
  public EntityManager createEntityManager()
  {
    return this.jdField_a_of_type_ComTencentMobileqqPersistenceEntityManagerFactory.createEntityManager();
  }
  
  public boolean isOpen()
  {
    return this.jdField_a_of_type_ComTencentMobileqqPersistenceEntityManagerFactory.isOpen();
  }
  
  public boolean verifyAuthentication()
  {
    return this.jdField_a_of_type_ComTencentMobileqqPersistenceEntityManagerFactory.verifyAuthentication();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.mobileqq.persistence.QQEntityManagerFactoryProxy
 * JD-Core Version:    0.7.0.1
 */