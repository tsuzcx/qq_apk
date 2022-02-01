package com.tencent.mobileqq.gamecenter.message;

import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.text.TextUtils;
import android.util.Pair;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.app.asyncdb.DBDelayManager;
import com.tencent.mobileqq.app.asyncdb.FullCache;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.mobileqq.persistence.Entity;
import com.tencent.mobileqq.persistence.EntityManager;
import com.tencent.mobileqq.persistence.EntityManagerFactory;
import com.tencent.qphone.base.util.QLog;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import mqq.app.MobileQQ;

public class TinyIdCache
  extends FullCache
{
  private long b = 0L;
  private ConcurrentHashMap<String, Pair<String, String>> c = new ConcurrentHashMap();
  private AppInterface d;
  
  public TinyIdCache(AppInterface paramAppInterface, DBDelayManager paramDBDelayManager)
  {
    super(paramAppInterface, paramDBDelayManager, UinToTinyId.class);
    this.d = paramAppInterface;
    c();
  }
  
  private String a(String paramString1, String paramString2, String paramString3)
  {
    if (TextUtils.isEmpty(paramString3)) {
      return null;
    }
    UinToTinyId localUinToTinyId = c(paramString3);
    if (localUinToTinyId != null)
    {
      if (QLog.isColorLevel())
      {
        paramString3 = new StringBuilder();
        paramString3.append("findUinWithTinyId UIN = ");
        paramString3.append(localUinToTinyId.friendUin);
        paramString3.append(",  fromTinyId = ");
        paramString3.append(paramString1);
        paramString3.append(", toTinyId = ");
        paramString3.append(paramString2);
        QLog.d("Q.tiny_msg.TinyIdCache", 2, paramString3.toString());
      }
      return localUinToTinyId.friendUin;
    }
    localUinToTinyId = new UinToTinyId();
    long l = this.b - 1L;
    this.b = l;
    localUinToTinyId.friendUin = String.valueOf(l);
    localUinToTinyId.tinyId = paramString3;
    localUinToTinyId.fromTinyId = paramString1;
    localUinToTinyId.toTinyId = paramString2;
    addCache(localUinToTinyId);
    d();
    if (QLog.isColorLevel())
    {
      paramString3 = new StringBuilder();
      paramString3.append("findUinWithTinyId NULL UIN = ");
      paramString3.append(localUinToTinyId.friendUin);
      paramString3.append(",  fromTinyId = ");
      paramString3.append(paramString1);
      paramString3.append(", toTinyId = ");
      paramString3.append(paramString2);
      paramString3.append(", time = ");
      paramString3.append(NetConnInfoCenter.getServerTime());
      QLog.d("Q.tiny_msg.TinyIdCache", 2, paramString3.toString());
    }
    return localUinToTinyId.friendUin;
  }
  
  private UinToTinyId c(String paramString)
  {
    return (UinToTinyId)findCache(paramString);
  }
  
  private void c()
  {
    try
    {
      this.c.clear();
      this.cacheMap.clear();
      Object localObject1 = this.d.getEntityManagerFactory().createEntityManager();
      Object localObject2 = ((EntityManager)localObject1).query(UinToTinyId.class);
      ((EntityManager)localObject1).close();
      if (localObject2 != null)
      {
        b();
        localObject1 = ((List)localObject2).iterator();
        while (((Iterator)localObject1).hasNext())
        {
          localObject2 = (UinToTinyId)((Iterator)localObject1).next();
          this.cacheMap.put(((UinToTinyId)localObject2).tinyId, localObject2);
        }
      }
      localObject1 = this.d.getApplication().getSharedPreferences("sp_name_tinyid_uin_mapping", 0);
      localObject2 = this.d.getCurrentAccountUin();
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("key_last_uin_consume_");
      localStringBuilder.append((String)localObject2);
      this.b = ((SharedPreferences)localObject1).getLong(localStringBuilder.toString(), 9223372036854775807L);
      if (QLog.isColorLevel())
      {
        localObject1 = new StringBuilder();
        ((StringBuilder)localObject1).append("doInit size = ");
        ((StringBuilder)localObject1).append(this.cacheMap.size());
        ((StringBuilder)localObject1).append(", lastUinConsume = ");
        ((StringBuilder)localObject1).append(this.b);
        QLog.d("Q.tiny_msg.TinyIdCache", 2, ((StringBuilder)localObject1).toString());
        return;
      }
    }
    catch (Exception localException)
    {
      QLog.d("Q.tiny_msg.TinyIdCache", 1, "doInit occur error", localException);
    }
  }
  
  private void d()
  {
    Object localObject2 = this.d.getApplication().getSharedPreferences("sp_name_tinyid_uin_mapping", 0);
    Object localObject1 = this.d.getCurrentAccountUin();
    localObject2 = ((SharedPreferences)localObject2).edit();
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("key_last_uin_consume_");
    localStringBuilder.append((String)localObject1);
    ((SharedPreferences.Editor)localObject2).putLong(localStringBuilder.toString(), this.b).apply();
    if (QLog.isColorLevel())
    {
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append("persistLastConsumeId lastUinConsume = ");
      ((StringBuilder)localObject1).append(this.b);
      QLog.d("Q.tiny_msg.TinyIdCache", 2, ((StringBuilder)localObject1).toString());
    }
  }
  
  public String a(String paramString)
  {
    paramString = b(paramString);
    if (paramString != null) {
      return (String)paramString.first;
    }
    return "";
  }
  
  public String a(String paramString1, String paramString2)
  {
    try
    {
      if ((!TextUtils.isEmpty(paramString1)) && (!TextUtils.isEmpty(paramString2)))
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append(paramString1);
        localStringBuilder.append(paramString2);
        paramString1 = a(paramString1, paramString2, localStringBuilder.toString());
        return paramString1;
      }
      return null;
    }
    finally {}
  }
  
  public void a()
  {
    destroy();
  }
  
  public Pair<String, String> b(String paramString)
  {
    Object localObject;
    if (this.c.containsKey(paramString))
    {
      paramString = (Pair)this.c.get(paramString);
    }
    else
    {
      localObject = this.cacheMap.values().iterator();
      while (((Iterator)localObject).hasNext())
      {
        UinToTinyId localUinToTinyId = (UinToTinyId)((Iterator)localObject).next();
        if (TextUtils.equals(localUinToTinyId.friendUin, paramString))
        {
          localObject = new Pair(localUinToTinyId.fromTinyId, localUinToTinyId.toTinyId);
          this.c.put(paramString, localObject);
          paramString = (String)localObject;
          break label105;
        }
      }
      paramString = null;
    }
    label105:
    if ((QLog.isColorLevel()) && (paramString != null))
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("findTinyId  from cache fromTinyId = ");
      ((StringBuilder)localObject).append((String)paramString.first);
      ((StringBuilder)localObject).append(", toTinyId = ");
      ((StringBuilder)localObject).append((String)paramString.second);
      QLog.d("Q.tiny_msg.TinyIdCache", 2, ((StringBuilder)localObject).toString());
    }
    return paramString;
  }
  
  public void b()
  {
    this.cacheMap.clear();
    this.c.clear();
  }
  
  protected void destroy()
  {
    b();
  }
  
  protected String getKey(Entity paramEntity)
  {
    return ((UinToTinyId)paramEntity).tinyId;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.gamecenter.message.TinyIdCache
 * JD-Core Version:    0.7.0.1
 */