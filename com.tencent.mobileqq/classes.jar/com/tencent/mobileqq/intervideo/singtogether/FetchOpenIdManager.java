package com.tencent.mobileqq.intervideo.singtogether;

import android.text.TextUtils;
import com.tencent.mobileqq.app.FriendListObserver;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.persistence.Entity;
import com.tencent.mobileqq.persistence.EntityManager;
import com.tencent.mobileqq.persistence.QQEntityManagerFactoryProxy;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import mqq.manager.Manager;

public class FetchOpenIdManager
  implements Manager
{
  private QQAppInterface a;
  private HashMap<Long, HashMap<Long, String>> b;
  private int c = -1;
  private List<OpenIdItem> d;
  private FetchOpenIdObserver e = new FetchOpenIdManager.2(this);
  private FriendListObserver f = new FetchOpenIdManager.3(this);
  
  public FetchOpenIdManager(QQAppInterface paramQQAppInterface)
  {
    this.a = paramQQAppInterface;
    this.b = new HashMap();
    this.d = new ArrayList();
    this.a.registObserver(this.e);
    this.a.addObserver(this.f);
    a(paramQQAppInterface);
  }
  
  private OpenIdItem a(OpenIdItem paramOpenIdItem, boolean paramBoolean)
  {
    try
    {
      Iterator localIterator = this.d.iterator();
      while (localIterator.hasNext())
      {
        OpenIdItem localOpenIdItem = (OpenIdItem)localIterator.next();
        if ((localOpenIdItem.uin == paramOpenIdItem.uin) && (localOpenIdItem.appId == paramOpenIdItem.appId))
        {
          if (paramBoolean) {
            localOpenIdItem.openId = paramOpenIdItem.openId;
          }
          if (QLog.isColorLevel())
          {
            paramOpenIdItem = new StringBuilder();
            paramOpenIdItem.append(" exist uin=");
            paramOpenIdItem.append(localOpenIdItem.uin);
            paramOpenIdItem.append(" appid=");
            paramOpenIdItem.append(localOpenIdItem.appId);
            paramOpenIdItem.append(" openId=");
            paramOpenIdItem.append(localOpenIdItem.openId);
            paramOpenIdItem.append(" needUpdate=");
            paramOpenIdItem.append(paramBoolean);
            QLog.d("FetchOpenIdManager", 2, paramOpenIdItem.toString());
          }
          return localOpenIdItem;
        }
      }
      this.d.add(paramOpenIdItem);
      return paramOpenIdItem;
    }
    finally {}
    for (;;)
    {
      throw paramOpenIdItem;
    }
  }
  
  private void a(QQAppInterface paramQQAppInterface)
  {
    try
    {
      if (this.c == -1)
      {
        this.c = 0;
        ThreadManagerV2.excute(new FetchOpenIdManager.1(this, paramQQAppInterface), 16, null, true);
      }
      return;
    }
    finally
    {
      paramQQAppInterface = finally;
      throw paramQQAppInterface;
    }
  }
  
  private void b(long paramLong1, long paramLong2, String paramString)
  {
    try
    {
      HashMap localHashMap2 = (HashMap)this.b.get(Long.valueOf(paramLong1));
      HashMap localHashMap1 = localHashMap2;
      if (localHashMap2 == null)
      {
        localHashMap1 = new HashMap();
        this.b.put(Long.valueOf(paramLong1), localHashMap1);
      }
      localHashMap1.put(Long.valueOf(paramLong2), paramString);
      return;
    }
    finally {}
  }
  
  public String a(long paramLong1, long paramLong2, boolean paramBoolean)
  {
    try
    {
      Object localObject2 = (HashMap)this.b.get(Long.valueOf(paramLong2));
      String str = "";
      if (localObject2 != null) {
        str = (String)((HashMap)localObject2).get(Long.valueOf(paramLong1));
      }
      if (QLog.isColorLevel())
      {
        localObject2 = new StringBuilder();
        ((StringBuilder)localObject2).append(" getOpenId openId=");
        ((StringBuilder)localObject2).append(str);
        ((StringBuilder)localObject2).append(" uin=");
        ((StringBuilder)localObject2).append(paramLong1);
        ((StringBuilder)localObject2).append(" state= ");
        ((StringBuilder)localObject2).append(this.c);
        QLog.d("FetchOpenIdManager", 2, ((StringBuilder)localObject2).toString());
      }
      boolean bool = TextUtils.isEmpty(str);
      if (!bool) {
        return str;
      }
      int i = this.c;
      if (i == 0) {
        return str;
      }
      if (paramBoolean) {
        FetchOpenIdServlet.a(paramLong1, paramLong2, this.a);
      }
      return str;
    }
    finally {}
  }
  
  public void a(long paramLong1, long paramLong2, String paramString)
  {
    try
    {
      if (QLog.isColorLevel())
      {
        localObject1 = new StringBuilder();
        ((StringBuilder)localObject1).append(" saveOpenIdEntry appId=");
        ((StringBuilder)localObject1).append(paramLong1);
        ((StringBuilder)localObject1).append(" uin=");
        ((StringBuilder)localObject1).append(paramLong2);
        ((StringBuilder)localObject1).append(" openId");
        ((StringBuilder)localObject1).append(paramString);
        QLog.d("FetchOpenIdManager", 2, ((StringBuilder)localObject1).toString());
      }
      Object localObject2 = (HashMap)this.b.get(Long.valueOf(paramLong1));
      Object localObject1 = localObject2;
      if (localObject2 == null)
      {
        localObject1 = new HashMap();
        this.b.put(Long.valueOf(paramLong1), localObject1);
      }
      localObject2 = this.a.getEntityManagerFactory().createEntityManager();
      ((HashMap)localObject1).put(Long.valueOf(paramLong2), paramString);
      localObject1 = new OpenIdItem();
      ((OpenIdItem)localObject1).appId = paramLong1;
      ((OpenIdItem)localObject1).openId = paramString;
      ((OpenIdItem)localObject1).uin = paramLong2;
      paramString = a((OpenIdItem)localObject1, true);
      if (paramString.getStatus() == 1000) {
        ((EntityManager)localObject2).persist(paramString);
      } else {
        ((EntityManager)localObject2).update(paramString);
      }
      ((EntityManager)localObject2).close();
      return;
    }
    finally {}
  }
  
  public boolean a(long paramLong1, long paramLong2)
  {
    try
    {
      localObject1 = (HashMap)this.b.get(Long.valueOf(paramLong1));
      boolean bool2 = false;
      bool1 = bool2;
      if (localObject1 != null)
      {
        if (!TextUtils.isEmpty((String)((HashMap)localObject1).remove(Long.valueOf(paramLong2)))) {
          break label251;
        }
        bool1 = bool2;
      }
    }
    finally
    {
      for (;;)
      {
        Object localObject1;
        Object localObject3;
        for (;;)
        {
          throw localObject2;
        }
        label251:
        boolean bool1 = true;
      }
    }
    localObject3 = this.d.iterator();
    while (((Iterator)localObject3).hasNext())
    {
      localObject1 = (OpenIdItem)((Iterator)localObject3).next();
      if ((((OpenIdItem)localObject1).uin == paramLong2) && (((OpenIdItem)localObject1).appId == paramLong1))
      {
        if (QLog.isColorLevel())
        {
          localObject3 = new StringBuilder();
          ((StringBuilder)localObject3).append(" exist uin=");
          ((StringBuilder)localObject3).append(((OpenIdItem)localObject1).uin);
          ((StringBuilder)localObject3).append(" appid=");
          ((StringBuilder)localObject3).append(((OpenIdItem)localObject1).appId);
          ((StringBuilder)localObject3).append(" openId=");
          ((StringBuilder)localObject3).append(((OpenIdItem)localObject1).openId);
          QLog.d("FetchOpenIdManager", 2, ((StringBuilder)localObject3).toString());
        }
        this.d.remove(localObject1);
        localObject3 = this.a.getEntityManagerFactory().createEntityManager();
        ((EntityManager)localObject3).remove((Entity)localObject1);
        ((EntityManager)localObject3).close();
        return bool1;
      }
    }
    return bool1;
  }
  
  public void onDestroy()
  {
    try
    {
      this.b.clear();
      this.d.clear();
      this.a.unRegistObserver(this.e);
      this.a.removeObserver(this.f);
      this.c = -1;
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.intervideo.singtogether.FetchOpenIdManager
 * JD-Core Version:    0.7.0.1
 */