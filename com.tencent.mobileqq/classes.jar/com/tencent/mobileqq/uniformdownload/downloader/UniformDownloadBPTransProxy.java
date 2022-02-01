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
  private static UniformDownloadBPTransProxy a;
  private List<UniformDownloadBPTransEntity> b = null;
  private AppRuntime c;
  
  public UniformDownloadBPTransProxy(AppRuntime paramAppRuntime)
  {
    super(paramAppRuntime);
    this.c = paramAppRuntime;
  }
  
  public static UniformDownloadBPTransProxy a()
  {
    try
    {
      if ((a == null) && (UniformDownloadMgr.a().b() != null)) {
        a = new UniformDownloadBPTransProxy(UniformDownloadMgr.a().b());
      }
      UniformDownloadBPTransProxy localUniformDownloadBPTransProxy = a;
      return localUniformDownloadBPTransProxy;
    }
    finally {}
  }
  
  private void a(UniformDownloadBPTransEntity paramUniformDownloadBPTransEntity, ProxyListener paramProxyListener)
  {
    paramProxyListener = this.c.getEntityManagerFactory().createEntityManager();
    if (paramProxyListener == null)
    {
      QLog.e("UniformDownloadBPTransProxy", 1, "[UniformDL]. addEntityToDB. EntityManager. create failed!!");
      return;
    }
    UniformDownloadBPTransEntity localUniformDownloadBPTransEntity = new UniformDownloadBPTransEntity();
    localUniformDownloadBPTransEntity.copyFrom(paramUniformDownloadBPTransEntity);
    if (localUniformDownloadBPTransEntity.getStatus() == 1000) {
      paramProxyListener.persist(localUniformDownloadBPTransEntity);
    } else if (localUniformDownloadBPTransEntity.getStatus() == 1001) {
      paramProxyListener.update(localUniformDownloadBPTransEntity);
    } else {
      QLog.e("UniformDownloadBPTransProxy", 1, "[UniformDL]. addEntityToDB. error status of entity");
    }
    paramProxyListener.close();
  }
  
  private boolean a(int paramInt)
  {
    Object localObject = this.b;
    if (localObject == null)
    {
      QLog.e("UniformDownloadBPTransProxy", 1, "[UniformDL].>>>getMore. no cache");
      return false;
    }
    long l;
    if (((List)localObject).size() == 0)
    {
      l = 9223372036854775807L;
    }
    else
    {
      localObject = this.b;
      l = ((UniformDownloadBPTransEntity)((List)localObject).get(((List)localObject).size() - 1)).getId();
    }
    localObject = new StringBuilder();
    ((StringBuilder)localObject).append("select * from ( select * from ");
    ((StringBuilder)localObject).append(UniformDownloadBPTransEntity.tableName());
    ((StringBuilder)localObject).append(" where _id < ");
    ((StringBuilder)localObject).append(String.valueOf(l));
    ((StringBuilder)localObject).append(" order by _id desc limit ");
    ((StringBuilder)localObject).append(paramInt);
    ((StringBuilder)localObject).append(") order by _id desc");
    localObject = ((StringBuilder)localObject).toString();
    localObject = this.c.getEntityManagerFactory().createEntityManager().rawQuery(UniformDownloadBPTransEntity.class, (String)localObject, null);
    if ((localObject != null) && ((localObject == null) || (((List)localObject).size() != 0)))
    {
      localObject = ((List)localObject).iterator();
      while (((Iterator)localObject).hasNext()) {
        b((UniformDownloadBPTransEntity)((Iterator)localObject).next());
      }
      return true;
    }
    QLog.i("UniformDownloadBPTransProxy", 1, "[UniformDL].>>>getMore. no more. ");
    return false;
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
  
  private void b()
  {
    if (this.b != null) {
      return;
    }
    Object localObject1 = new StringBuilder();
    ((StringBuilder)localObject1).append("select * from ( select * from ");
    ((StringBuilder)localObject1).append(UniformDownloadBPTransEntity.tableName());
    ((StringBuilder)localObject1).append(" order by _id desc limit ");
    ((StringBuilder)localObject1).append(30);
    ((StringBuilder)localObject1).append(") order by _id desc");
    Object localObject2 = ((StringBuilder)localObject1).toString();
    localObject1 = this.c.getEntityManagerFactory().createEntityManager();
    this.b = ((EntityManager)localObject1).rawQuery(UniformDownloadBPTransEntity.class, (String)localObject2, null);
    if (this.b == null) {
      this.b = new ArrayList();
    }
    localObject2 = this.b.iterator();
    while (((Iterator)localObject2).hasNext())
    {
      UniformDownloadBPTransEntity localUniformDownloadBPTransEntity = (UniformDownloadBPTransEntity)((Iterator)localObject2).next();
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("[UniformDL]. >>>init cache:[ ");
      localStringBuilder.append(localUniformDownloadBPTransEntity.toString());
      localStringBuilder.append(" ]");
      QLog.i("UniformDownloadBPTransProxy", 1, localStringBuilder.toString());
    }
    ((EntityManager)localObject1).close();
  }
  
  private void b(UniformDownloadBPTransEntity paramUniformDownloadBPTransEntity)
  {
    if (paramUniformDownloadBPTransEntity == null) {}
    try
    {
      QLog.e("UniformDownloadBPTransProxy", 1, "[UniformDL]. addToCacheEntityList. entiy=null");
      return;
    }
    finally
    {
      Object localObject;
      break label242;
    }
    if (this.b.contains(paramUniformDownloadBPTransEntity))
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("[UniformDL]. addToCacheEntityList. entiy is existed 1. url:");
      ((StringBuilder)localObject).append(paramUniformDownloadBPTransEntity.mUrl);
      QLog.i("UniformDownloadBPTransProxy", 1, ((StringBuilder)localObject).toString());
      return;
    }
    localObject = this.b.iterator();
    while (((Iterator)localObject).hasNext())
    {
      UniformDownloadBPTransEntity localUniformDownloadBPTransEntity = (UniformDownloadBPTransEntity)((Iterator)localObject).next();
      if ((localUniformDownloadBPTransEntity != null) && (localUniformDownloadBPTransEntity.mUrl.equalsIgnoreCase(paramUniformDownloadBPTransEntity.mUrl)))
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("[UniformDL]. addToCacheEntityList. entiy is existed 2. url:");
        ((StringBuilder)localObject).append(paramUniformDownloadBPTransEntity.mUrl);
        QLog.i("UniformDownloadBPTransProxy", 1, ((StringBuilder)localObject).toString());
        return;
      }
    }
    localObject = new StringBuilder();
    ((StringBuilder)localObject).append("[UniformDL].>>>addToCacheEntityList. add it. url:");
    ((StringBuilder)localObject).append(paramUniformDownloadBPTransEntity.mUrl);
    QLog.i("UniformDownloadBPTransProxy", 1, ((StringBuilder)localObject).toString());
    this.b.add(0, paramUniformDownloadBPTransEntity);
    if (this.b.size() > 30) {
      this.b.remove(this.b.size() - 1);
    }
    return;
    label242:
    for (;;)
    {
      throw paramUniformDownloadBPTransEntity;
    }
  }
  
  private UniformDownloadBPTransEntity c(String paramString)
  {
    Object localObject1 = new StringBuilder();
    ((StringBuilder)localObject1).append("select * from ");
    ((StringBuilder)localObject1).append(UniformDownloadBPTransEntity.tableName());
    ((StringBuilder)localObject1).append(" where mUrl = ");
    ((StringBuilder)localObject1).append(paramString);
    Object localObject2 = ((StringBuilder)localObject1).toString();
    localObject1 = this.c.getEntityManagerFactory().createEntityManager();
    if (localObject1 == null)
    {
      QLog.e("UniformDownloadBPTransProxy", 1, "[UniformDL]. queryEntityFromDByUrl. EntityManager. create failed!!");
      return null;
    }
    localObject2 = ((EntityManager)localObject1).rawQuery(UniformDownloadBPTransEntity.class, (String)localObject2, null);
    if (localObject2 == null)
    {
      ((EntityManager)localObject1).close();
      return null;
    }
    if (((List)localObject2).size() > 1)
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("[UniformDL]. count of DB  is over 1 when query url:");
      localStringBuilder.append(paramString);
      QLog.w("UniformDownloadBPTransProxy", 1, localStringBuilder.toString());
    }
    paramString = (UniformDownloadBPTransEntity)((List)localObject2).get(0);
    ((EntityManager)localObject1).close();
    return paramString;
  }
  
  private void d(String paramString)
  {
    if (paramString == null) {
      return;
    }
    StringBuilder localStringBuilder = null;
    try
    {
      Iterator localIterator = this.b.iterator();
      Object localObject;
      do
      {
        localObject = localStringBuilder;
        if (!localIterator.hasNext()) {
          break;
        }
        localObject = (UniformDownloadBPTransEntity)localIterator.next();
      } while ((localObject == null) || (!paramString.equalsIgnoreCase(((UniformDownloadBPTransEntity)localObject).mUrl)));
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("[UniformDL].>>>removFromCacheEntityList. remove it. url:");
      if (localObject == null) {
        paramString = "null";
      } else {
        paramString = ((UniformDownloadBPTransEntity)localObject).mUrl;
      }
      localStringBuilder.append(paramString);
      QLog.i("UniformDownloadBPTransProxy", 1, localStringBuilder.toString());
      this.b.remove(localObject);
      return;
    }
    finally {}
    for (;;)
    {
      throw paramString;
    }
  }
  
  private UniformDownloadBPTransEntity e(String paramString)
  {
    Object localObject2 = null;
    if (paramString == null) {
      return null;
    }
    try
    {
      Iterator localIterator = this.b.iterator();
      Object localObject1;
      boolean bool;
      do
      {
        do
        {
          localObject1 = localObject2;
          if (!localIterator.hasNext()) {
            break;
          }
          localObject1 = (UniformDownloadBPTransEntity)localIterator.next();
        } while (localObject1 == null);
        bool = paramString.equalsIgnoreCase(((UniformDownloadBPTransEntity)localObject1).mUrl);
      } while (!bool);
      return localObject1;
    }
    finally {}
    for (;;)
    {
      throw paramString;
    }
  }
  
  public UniformDownloadBPTransEntity a(String paramString)
  {
    b();
    UniformDownloadBPTransEntity localUniformDownloadBPTransEntity = e(paramString);
    if (localUniformDownloadBPTransEntity != null) {
      return localUniformDownloadBPTransEntity;
    }
    return c(paramString);
  }
  
  public void a(UniformDownloadBPTransEntity paramUniformDownloadBPTransEntity)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("[UniformDL]. >>>addEntity. url[");
    localStringBuilder.append(paramUniformDownloadBPTransEntity.mUrl);
    localStringBuilder.append("]");
    QLog.i("UniformDownloadBPTransProxy", 1, localStringBuilder.toString());
    b();
    b(paramUniformDownloadBPTransEntity);
    ThreadManager.executeOnSubThread(new UniformDownloadBPTransProxy.1(this, paramUniformDownloadBPTransEntity));
  }
  
  protected void a(String paramString1, String paramString2, String[] paramArrayOfString, ProxyListener paramProxyListener)
  {
    addMsgQueue(String.valueOf(0), 0, paramString1, paramString2, paramArrayOfString, 2, paramProxyListener);
  }
  
  public void b(String paramString)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("[UniformDL]. >>>deleteEntity. url[");
    localStringBuilder.append(paramString);
    localStringBuilder.append("]");
    QLog.i("UniformDownloadBPTransProxy", 1, localStringBuilder.toString());
    b();
    d(paramString);
    a(paramString, false);
    a(1);
  }
  
  protected void init() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.uniformdownload.downloader.UniformDownloadBPTransProxy
 * JD-Core Version:    0.7.0.1
 */