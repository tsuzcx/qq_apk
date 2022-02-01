package com.tencent.mobileqq.dating;

import android.text.TextUtils;
import com.tencent.mobileqq.nearby.NearbyUtils;
import com.tencent.mobileqq.nearby.api.INearbyAppInterface;
import com.tencent.mobileqq.nearby.api.INearbySPUtil;
import com.tencent.mobileqq.persistence.EntityManager;
import com.tencent.mobileqq.persistence.EntityManagerFactory;
import com.tencent.mobileqq.qroute.QRoute;
import mqq.manager.Manager;

public class DatingManager
  implements Manager
{
  public static long a;
  public static long b;
  public static long c;
  protected INearbyAppInterface d;
  protected EntityManager e;
  public long f = 0L;
  private byte g;
  private String h;
  private int i;
  
  public DatingManager(INearbyAppInterface paramINearbyAppInterface)
  {
    this.d = paramINearbyAppInterface;
    this.e = paramINearbyAppInterface.getEntityManagerFactory().createEntityManager();
    this.g = 0;
    this.h = null;
    this.i = -2147483648;
  }
  
  public static void a(String paramString, long paramLong1, long paramLong2, long paramLong3)
  {
    if (TextUtils.isEmpty(paramString)) {
      return;
    }
    if (!NearbyUtils.c())
    {
      ((INearbySPUtil)QRoute.api(INearbySPUtil.class)).setValue(paramString, "DatingManager.maplng", Long.valueOf(paramLong1));
      ((INearbySPUtil)QRoute.api(INearbySPUtil.class)).setValue(paramString, "DatingManager.maplat", Long.valueOf(paramLong2));
      ((INearbySPUtil)QRoute.api(INearbySPUtil.class)).setValue(paramString, "DatingManager.timestamp", Long.valueOf(paramLong3));
      return;
    }
    a = paramLong1;
    b = paramLong2;
    c = paramLong3;
  }
  
  public void onDestroy()
  {
    EntityManager localEntityManager = this.e;
    if (localEntityManager != null) {
      try
      {
        localEntityManager.close();
        return;
      }
      catch (Exception localException)
      {
        localException.printStackTrace();
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.dating.DatingManager
 * JD-Core Version:    0.7.0.1
 */