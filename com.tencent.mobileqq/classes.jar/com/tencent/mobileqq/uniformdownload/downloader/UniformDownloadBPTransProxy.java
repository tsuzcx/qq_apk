package com.tencent.mobileqq.uniformdownload.downloader;

import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.app.proxy.BaseProxyManager;
import com.tencent.mobileqq.app.proxy.ProxyListener;
import com.tencent.mobileqq.persistence.EntityManager;
import com.tencent.mobileqq.persistence.EntityManagerFactory;
import com.tencent.mobileqq.uniformdownload.core.UniformDownloadMgr;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import mqq.app.AppRuntime;

public class UniformDownloadBPTransProxy
  extends BaseProxyManager
{
  private static UniformDownloadBPTransProxy jdField_a_of_type_ComTencentMobileqqUniformdownloadDownloaderUniformDownloadBPTransProxy = null;
  private List<UniformDownloadBPTransEntity> jdField_a_of_type_JavaUtilList = null;
  private AppRuntime jdField_a_of_type_MqqAppAppRuntime;
  
  public UniformDownloadBPTransProxy(AppRuntime paramAppRuntime)
  {
    super(paramAppRuntime);
    this.jdField_a_of_type_MqqAppAppRuntime = paramAppRuntime;
  }
  
  public static UniformDownloadBPTransProxy a()
  {
    try
    {
      if ((jdField_a_of_type_ComTencentMobileqqUniformdownloadDownloaderUniformDownloadBPTransProxy == null) && (UniformDownloadMgr.a().a() != null)) {
        jdField_a_of_type_ComTencentMobileqqUniformdownloadDownloaderUniformDownloadBPTransProxy = new UniformDownloadBPTransProxy(UniformDownloadMgr.a().a());
      }
      UniformDownloadBPTransProxy localUniformDownloadBPTransProxy = jdField_a_of_type_ComTencentMobileqqUniformdownloadDownloaderUniformDownloadBPTransProxy;
      return localUniformDownloadBPTransProxy;
    }
    finally {}
  }
  
  private void a()
  {
    if (this.jdField_a_of_type_JavaUtilList != null) {
      return;
    }
    Object localObject = "select * from ( select * from " + UniformDownloadBPTransEntity.tableName() + " order by _id desc limit " + 30 + ") order by _id desc";
    EntityManager localEntityManager = this.jdField_a_of_type_MqqAppAppRuntime.getEntityManagerFactory().createEntityManager();
    this.jdField_a_of_type_JavaUtilList = localEntityManager.rawQuery(UniformDownloadBPTransEntity.class, (String)localObject, null);
    if (this.jdField_a_of_type_JavaUtilList == null) {
      this.jdField_a_of_type_JavaUtilList = new ArrayList();
    }
    localObject = this.jdField_a_of_type_JavaUtilList.iterator();
    while (((Iterator)localObject).hasNext())
    {
      UniformDownloadBPTransEntity localUniformDownloadBPTransEntity = (UniformDownloadBPTransEntity)((Iterator)localObject).next();
      QLog.i("UniformDownloadBPTransProxy", 1, "[UniformDL]. >>>init cache:[ " + localUniformDownloadBPTransEntity.toString() + " ]");
    }
    localEntityManager.close();
  }
  
  private void a(UniformDownloadBPTransEntity paramUniformDownloadBPTransEntity, ProxyListener paramProxyListener)
  {
    paramProxyListener = this.jdField_a_of_type_MqqAppAppRuntime.getEntityManagerFactory().createEntityManager();
    if (paramProxyListener == null)
    {
      QLog.e("UniformDownloadBPTransProxy", 1, "[UniformDL]. addEntityToDB. EntityManager. create failed!!");
      return;
    }
    UniformDownloadBPTransEntity localUniformDownloadBPTransEntity = new UniformDownloadBPTransEntity();
    localUniformDownloadBPTransEntity.copyFrom(paramUniformDownloadBPTransEntity);
    if (localUniformDownloadBPTransEntity.getStatus() == 1000) {
      paramProxyListener.persist(localUniformDownloadBPTransEntity);
    }
    for (;;)
    {
      paramProxyListener.close();
      return;
      if (localUniformDownloadBPTransEntity.getStatus() == 1001) {
        paramProxyListener.update(localUniformDownloadBPTransEntity);
      } else {
        QLog.e("UniformDownloadBPTransProxy", 1, "[UniformDL]. addEntityToDB. error status of entity");
      }
    }
  }
  
  private boolean a(int paramInt)
  {
    if (this.jdField_a_of_type_JavaUtilList == null)
    {
      QLog.e("UniformDownloadBPTransProxy", 1, "[UniformDL].>>>getMore. no cache");
      return false;
    }
    if (this.jdField_a_of_type_JavaUtilList.size() == 0) {}
    for (long l = 9223372036854775807L;; l = ((UniformDownloadBPTransEntity)this.jdField_a_of_type_JavaUtilList.get(this.jdField_a_of_type_JavaUtilList.size() - 1)).getId())
    {
      localObject = "select * from ( select * from " + UniformDownloadBPTransEntity.tableName() + " where _id < " + String.valueOf(l) + " order by _id desc limit " + paramInt + ") order by _id desc";
      localObject = this.jdField_a_of_type_MqqAppAppRuntime.getEntityManagerFactory().createEntityManager().rawQuery(UniformDownloadBPTransEntity.class, (String)localObject, null);
      if ((localObject != null) && ((localObject == null) || (((List)localObject).size() != 0))) {
        break;
      }
      QLog.i("UniformDownloadBPTransProxy", 1, "[UniformDL].>>>getMore. no more. ");
      return false;
    }
    Object localObject = ((List)localObject).iterator();
    while (((Iterator)localObject).hasNext()) {
      b((UniformDownloadBPTransEntity)((Iterator)localObject).next());
    }
    return true;
  }
  
  private boolean a(String paramString, boolean paramBoolean)
  {
    if (paramString == null)
    {
      QLog.e("UniformDownloadBPTransProxy", 1, "[UniformDL]. delEntityFromDB. url=null");
      return false;
    }
    a(UniformDownloadBPTransEntity.tableName(), "mUrl = ?", new String[] { paramString }, null);
    if (paramBoolean)
    {
      QLog.i("UniformDownloadBPTransProxy", 1, "[UniformDL]. delEntityFromDB. bImUpdateDB = true");
      transSaveToDatabase();
    }
    return true;
  }
  
  private UniformDownloadBPTransEntity b(String paramString)
  {
    Object localObject = "select * from " + UniformDownloadBPTransEntity.tableName() + " where mUrl = " + paramString;
    EntityManager localEntityManager = this.jdField_a_of_type_MqqAppAppRuntime.getEntityManagerFactory().createEntityManager();
    if (localEntityManager == null)
    {
      QLog.e("UniformDownloadBPTransProxy", 1, "[UniformDL]. queryEntityFromDByUrl. EntityManager. create failed!!");
      return null;
    }
    localObject = localEntityManager.rawQuery(UniformDownloadBPTransEntity.class, (String)localObject, null);
    if (localObject == null)
    {
      localEntityManager.close();
      return null;
    }
    if (((List)localObject).size() > 1) {
      QLog.w("UniformDownloadBPTransProxy", 1, "[UniformDL]. count of DB  is over 1 when query url:" + paramString);
    }
    paramString = (UniformDownloadBPTransEntity)((List)localObject).get(0);
    localEntityManager.close();
    return paramString;
  }
  
  private void b(UniformDownloadBPTransEntity paramUniformDownloadBPTransEntity)
  {
    if (paramUniformDownloadBPTransEntity == null) {}
    for (;;)
    {
      try
      {
        QLog.e("UniformDownloadBPTransProxy", 1, "[UniformDL]. addToCacheEntityList. entiy=null");
        return;
      }
      finally {}
      if (this.jdField_a_of_type_JavaUtilList.contains(paramUniformDownloadBPTransEntity))
      {
        QLog.i("UniformDownloadBPTransProxy", 1, "[UniformDL]. addToCacheEntityList. entiy is existed 1. url:" + paramUniformDownloadBPTransEntity.mUrl);
      }
      else
      {
        Iterator localIterator = this.jdField_a_of_type_JavaUtilList.iterator();
        for (;;)
        {
          if (localIterator.hasNext())
          {
            UniformDownloadBPTransEntity localUniformDownloadBPTransEntity = (UniformDownloadBPTransEntity)localIterator.next();
            if ((localUniformDownloadBPTransEntity != null) && (localUniformDownloadBPTransEntity.mUrl.equalsIgnoreCase(paramUniformDownloadBPTransEntity.mUrl)))
            {
              QLog.i("UniformDownloadBPTransProxy", 1, "[UniformDL]. addToCacheEntityList. entiy is existed 2. url:" + paramUniformDownloadBPTransEntity.mUrl);
              break;
            }
          }
        }
        QLog.i("UniformDownloadBPTransProxy", 1, "[UniformDL].>>>addToCacheEntityList. add it. url:" + paramUniformDownloadBPTransEntity.mUrl);
        this.jdField_a_of_type_JavaUtilList.add(0, paramUniformDownloadBPTransEntity);
        if (this.jdField_a_of_type_JavaUtilList.size() > 30) {
          this.jdField_a_of_type_JavaUtilList.remove(this.jdField_a_of_type_JavaUtilList.size() - 1);
        }
      }
    }
  }
  
  private void b(String paramString)
  {
    if (paramString == null) {
      return;
    }
    StringBuilder localStringBuilder = null;
    for (;;)
    {
      Object localObject;
      try
      {
        Iterator localIterator = this.jdField_a_of_type_JavaUtilList.iterator();
        localObject = localStringBuilder;
        if (localIterator.hasNext())
        {
          localObject = (UniformDownloadBPTransEntity)localIterator.next();
          if ((localObject == null) || (!paramString.equalsIgnoreCase(((UniformDownloadBPTransEntity)localObject).mUrl))) {
            continue;
          }
        }
        localStringBuilder = new StringBuilder().append("[UniformDL].>>>removFromCacheEntityList. remove it. url:");
        if (localObject == null)
        {
          paramString = "null";
          QLog.i("UniformDownloadBPTransProxy", 1, paramString);
          this.jdField_a_of_type_JavaUtilList.remove(localObject);
          break;
        }
      }
      finally {}
      paramString = ((UniformDownloadBPTransEntity)localObject).mUrl;
    }
  }
  
  private UniformDownloadBPTransEntity c(String paramString)
  {
    UniformDownloadBPTransEntity localUniformDownloadBPTransEntity = null;
    if (paramString == null)
    {
      paramString = localUniformDownloadBPTransEntity;
      return paramString;
    }
    for (;;)
    {
      try
      {
        Iterator localIterator = this.jdField_a_of_type_JavaUtilList.iterator();
        if (localIterator.hasNext())
        {
          localUniformDownloadBPTransEntity = (UniformDownloadBPTransEntity)localIterator.next();
          if (localUniformDownloadBPTransEntity == null) {
            continue;
          }
          boolean bool = paramString.equalsIgnoreCase(localUniformDownloadBPTransEntity.mUrl);
          if (!bool) {
            continue;
          }
          paramString = localUniformDownloadBPTransEntity;
          break;
        }
      }
      finally {}
      paramString = null;
    }
  }
  
  public UniformDownloadBPTransEntity a(String paramString)
  {
    a();
    UniformDownloadBPTransEntity localUniformDownloadBPTransEntity = c(paramString);
    if (localUniformDownloadBPTransEntity != null) {
      return localUniformDownloadBPTransEntity;
    }
    return b(paramString);
  }
  
  public void a(UniformDownloadBPTransEntity paramUniformDownloadBPTransEntity)
  {
    QLog.i("UniformDownloadBPTransProxy", 1, "[UniformDL]. >>>addEntity. url[" + paramUniformDownloadBPTransEntity.mUrl + "]");
    a();
    b(paramUniformDownloadBPTransEntity);
    ThreadManager.executeOnSubThread(new UniformDownloadBPTransProxy.1(this, paramUniformDownloadBPTransEntity));
  }
  
  public void a(String paramString)
  {
    QLog.i("UniformDownloadBPTransProxy", 1, "[UniformDL]. >>>deleteEntity. url[" + paramString + "]");
    a();
    b(paramString);
    a(paramString, false);
    a(1);
  }
  
  protected void a(String paramString1, String paramString2, String[] paramArrayOfString, ProxyListener paramProxyListener)
  {
    addMsgQueue(String.valueOf(0), 0, paramString1, paramString2, paramArrayOfString, 2, paramProxyListener);
  }
  
  public void init() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.uniformdownload.downloader.UniformDownloadBPTransProxy
 * JD-Core Version:    0.7.0.1
 */