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
  private EntityManagerFactory a;
  private DefaultOnDBUpgradeCallback b;
  
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
    if (!paramEntityManagerFactory.closed)
    {
      MessageRecordEntityManager localMessageRecordEntityManager = new MessageRecordEntityManager(paramEntityManagerFactory.dbHelper, paramEntityManagerFactory.mName);
      paramEntityManagerFactory.closed = false;
      return localMessageRecordEntityManager;
    }
    throw new IllegalStateException("The EntityManagerFactory has been already closed");
  }
  
  public static QQEntityManagerFactoryProxy a(String paramString)
  {
    QQEntityManagerFactoryProxy localQQEntityManagerFactoryProxy = new QQEntityManagerFactoryProxy(paramString);
    localQQEntityManagerFactoryProxy.b = new DefaultOnDBUpgradeCallback();
    localQQEntityManagerFactoryProxy.a = DBBuildUtil.getDefaultEntityManagerFactoryBuilder(paramString).onDBUpgradeListener(localQQEntityManagerFactoryProxy.b).build();
    return localQQEntityManagerFactoryProxy;
  }
  
  public static QQEntityManagerFactoryProxy a(String paramString, EntityManagerFactory paramEntityManagerFactory)
  {
    paramString = new QQEntityManagerFactoryProxy(paramString);
    if ((paramEntityManagerFactory instanceof QQEntityManagerFactory))
    {
      IOnDBUpgradeListener localIOnDBUpgradeListener = ((QQEntityManagerFactory)paramEntityManagerFactory).getOnDBUpgradeListener();
      if ((localIOnDBUpgradeListener instanceof DefaultOnDBUpgradeCallback)) {
        paramString.b = ((DefaultOnDBUpgradeCallback)localIOnDBUpgradeListener);
      }
    }
    paramString.a = paramEntityManagerFactory;
    return paramString;
  }
  
  public boolean a()
  {
    DefaultOnDBUpgradeCallback localDefaultOnDBUpgradeCallback = this.b;
    return (localDefaultOnDBUpgradeCallback != null) && (localDefaultOnDBUpgradeCallback.a());
  }
  
  public EntityManager b()
  {
    return a(this.a);
  }
  
  public SQLiteOpenHelper build(String paramString)
  {
    return this.a.build(paramString);
  }
  
  public void close()
  {
    this.a.close();
  }
  
  public EntityManager createEntityManager()
  {
    return this.a.createEntityManager();
  }
  
  public boolean isOpen()
  {
    return this.a.isOpen();
  }
  
  public boolean verifyAuthentication()
  {
    return this.a.verifyAuthentication();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.persistence.QQEntityManagerFactoryProxy
 * JD-Core Version:    0.7.0.1
 */