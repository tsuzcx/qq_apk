package com.tencent.timi.game.databasecore.impl;

import android.text.TextUtils;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.persistence.Entity;
import com.tencent.mobileqq.persistence.EntityManager;
import com.tencent.mobileqq.persistence.EntityManagerFactory;
import com.tencent.timi.game.databasecore.impl.base.BaseTimiDatabaseTableHandler;
import com.tencent.timi.game.databasecore.impl.base.BaseTimiGameEntity;
import com.tencent.timi.game.databasecore.impl.base.TimiGameEntityConstructor;
import com.tencent.timi.game.utils.Logger;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;

public class YesDataBaseHelper
{
  private static volatile YesDataBaseHelper a;
  private static ConcurrentHashMap<Class, TimiGameEntityConstructor> e = new ConcurrentHashMap();
  private YesEntityManagerFactory b;
  private EntityManager c;
  private Object d = new Object();
  
  public static YesDataBaseHelper a()
  {
    if (a == null) {
      try
      {
        if (a == null) {
          a = new YesDataBaseHelper();
        }
      }
      finally {}
    }
    return a;
  }
  
  public static void a(BaseTimiGameEntity paramBaseTimiGameEntity, BaseTimiDatabaseTableHandler paramBaseTimiDatabaseTableHandler)
  {
    try
    {
      e.put(paramBaseTimiGameEntity.getClass(), new TimiGameEntityConstructor(paramBaseTimiGameEntity, paramBaseTimiDatabaseTableHandler));
      return;
    }
    finally
    {
      paramBaseTimiGameEntity = finally;
      throw paramBaseTimiGameEntity;
    }
  }
  
  private EntityManagerFactory b(String paramString)
  {
    if (!TextUtils.isEmpty(paramString))
    {
      ??? = this.b;
      if ((??? != null) && (this.c != null)) {
        return ???;
      }
      synchronized (this.d)
      {
        if ((this.b == null) || (this.c == null))
        {
          this.b = new YesEntityManagerFactory(paramString);
          this.c = this.b.createEntityManager();
          paramString = new StringBuilder();
          paramString.append("mEntityManager:");
          paramString.append(this.c);
          Logger.a("YesDataBaseHelper", paramString.toString());
          ThreadManagerV2.excute(new YesDataBaseHelper.1(this), 32, null, true);
        }
        return this.b;
      }
    }
    throw new IllegalStateException("Can not create a entity factory, the account is null.");
  }
  
  public static void b()
  {
    Logger.c("YesDataBaseHelper", "destroy");
    try
    {
      if (a != null)
      {
        a.c();
        a = null;
      }
      return;
    }
    finally {}
  }
  
  public static ConcurrentHashMap<Class, TimiGameEntityConstructor> d()
  {
    return e;
  }
  
  public List<? extends Entity> a(Class<? extends Entity> paramClass)
  {
    try
    {
      paramClass = a(paramClass, false, "", null, null, null, null, null);
      return paramClass;
    }
    finally
    {
      paramClass = finally;
      throw paramClass;
    }
  }
  
  public List<? extends Entity> a(Class<? extends Entity> paramClass, boolean paramBoolean, String paramString1, String[] paramArrayOfString, String paramString2, String paramString3, String paramString4, String paramString5)
  {
    try
    {
      if (this.c == null)
      {
        Logger.c("YesDataBaseHelper", "has not inited! queryEntity");
        return null;
      }
      paramClass = this.c.query(paramClass, paramBoolean, paramString1, paramArrayOfString, paramString2, paramString3, paramString4, paramString5);
      return paramClass;
    }
    finally {}
  }
  
  public void a(String paramString)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("init with uin - ");
    localStringBuilder.append(this.b);
    localStringBuilder.append(" - ");
    localStringBuilder.append(this.c);
    Logger.a("YesDataBaseHelper", localStringBuilder.toString());
    b(paramString);
  }
  
  public boolean a(Entity paramEntity)
  {
    try
    {
      EntityManager localEntityManager = this.c;
      boolean bool = false;
      if (localEntityManager == null)
      {
        Logger.c("YesDataBaseHelper", "has not inited! insertOrUpdateEntity");
        return false;
      }
      int i;
      if (paramEntity.getStatus() == 1000)
      {
        this.c.persistOrReplace(paramEntity);
        i = paramEntity.getStatus();
        if (i == 1001) {
          bool = true;
        }
        return bool;
      }
      if (paramEntity.getStatus() != 1001)
      {
        i = paramEntity.getStatus();
        if (i != 1002) {
          return false;
        }
      }
      bool = this.c.update(paramEntity);
      return bool;
    }
    finally {}
  }
  
  public boolean b(Entity paramEntity)
  {
    try
    {
      if (this.c == null)
      {
        Logger.c("YesDataBaseHelper", "has not inited! removeEntity");
        return false;
      }
      if (paramEntity != null)
      {
        boolean bool = this.c.remove(paramEntity);
        return bool;
      }
      return false;
    }
    finally {}
  }
  
  public void c()
  {
    Logger.c("YesDataBaseHelper", "destroyInternal");
    Object localObject = this.c;
    if (localObject != null)
    {
      ((EntityManager)localObject).close();
      this.c = null;
    }
    localObject = this.b;
    if (localObject != null)
    {
      ((YesEntityManagerFactory)localObject).close();
      this.b = null;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.timi.game.databasecore.impl.YesDataBaseHelper
 * JD-Core Version:    0.7.0.1
 */