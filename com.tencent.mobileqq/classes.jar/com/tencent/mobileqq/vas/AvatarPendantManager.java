package com.tencent.mobileqq.vas;

import android.content.Context;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import mqq.manager.Manager;

public class AvatarPendantManager
  implements Manager
{
  public static volatile boolean d;
  public static volatile boolean h;
  public static int i;
  public static volatile long j;
  protected AppInterface a;
  public boolean b;
  public long c = -1L;
  protected AvatarPendantManager.PendantInfoLruCache e = null;
  List<AvatarPendantShopSeriesInfo> f = new ArrayList();
  List<AvatarInPendantHeadportraitInfo> g;
  
  public AvatarPendantManager(AppInterface paramAppInterface)
  {
    this.a = paramAppInterface;
    this.e = new AvatarPendantManager.PendantInfoLruCache(this, 10);
    this.b = false;
  }
  
  public PendantInfo a(long paramLong)
  {
    synchronized (this.e)
    {
      PendantInfo localPendantInfo = (PendantInfo)this.e.get(Long.valueOf(paramLong));
      Object localObject1;
      if (localPendantInfo != null)
      {
        localObject1 = localPendantInfo;
        if (QLog.isColorLevel())
        {
          localObject1 = new StringBuilder();
          ((StringBuilder)localObject1).append("getPendantInfo pendantId=");
          ((StringBuilder)localObject1).append(paramLong);
          ((StringBuilder)localObject1).append(" from cache");
          QLog.d("AvatarPendantManager", 2, ((StringBuilder)localObject1).toString());
          localObject1 = localPendantInfo;
        }
      }
      else
      {
        localObject1 = new PendantInfo(paramLong);
        this.e.put(Long.valueOf(paramLong), localObject1);
      }
      ((PendantInfo)localObject1).a(this.b);
      return localObject1;
    }
  }
  
  public void a()
  {
    this.b = true;
    synchronized (this.e)
    {
      Iterator localIterator = this.e.values().iterator();
      while (localIterator.hasNext()) {
        ((PendantInfo)localIterator.next()).a(true);
      }
      return;
    }
    for (;;)
    {
      throw localObject;
    }
  }
  
  public void a(List<AvatarInPendantHeadportraitInfo> paramList)
  {
    this.g = paramList;
  }
  
  public void b()
  {
    this.b = false;
    synchronized (this.e)
    {
      Iterator localIterator = this.e.values().iterator();
      while (localIterator.hasNext()) {
        ((PendantInfo)localIterator.next()).a(false);
      }
      return;
    }
    for (;;)
    {
      throw localObject;
    }
  }
  
  public boolean b(long paramLong)
  {
    return this.c != paramLong;
  }
  
  public void c()
  {
    synchronized (this.e)
    {
      Iterator localIterator = this.e.values().iterator();
      while (localIterator.hasNext()) {
        ((PendantInfo)localIterator.next()).d();
      }
      this.e.clear();
      return;
    }
    for (;;)
    {
      throw localObject;
    }
  }
  
  public File d()
  {
    File localFile = new File(this.a.getApp().getApplicationContext().getFilesDir(), "pendant_info");
    if (!localFile.exists()) {
      localFile.mkdirs();
    }
    return localFile;
  }
  
  public File e()
  {
    File localFile = new File(AppConstants.SDCARD_PENDANT_ROOT);
    if (!localFile.exists()) {
      localFile.mkdirs();
    }
    return localFile;
  }
  
  public List<AvatarPendantShopSeriesInfo> f()
  {
    return this.f;
  }
  
  public List<AvatarInPendantHeadportraitInfo> g()
  {
    return this.g;
  }
  
  public void onDestroy()
  {
    synchronized (this.e)
    {
      this.e.clear();
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.vas.AvatarPendantManager
 * JD-Core Version:    0.7.0.1
 */