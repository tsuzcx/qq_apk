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
  public static int a;
  public static volatile long b;
  public static volatile boolean b;
  public static volatile boolean c;
  public long a;
  protected AppInterface a;
  protected AvatarPendantManager.PendantInfoLruCache a;
  List<AvatarPendantShopSeriesInfo> a;
  public boolean a;
  List<AvatarInPendantHeadportraitInfo> b;
  
  public AvatarPendantManager(AppInterface paramAppInterface)
  {
    this.jdField_a_of_type_Long = -1L;
    this.jdField_a_of_type_ComTencentMobileqqVasAvatarPendantManager$PendantInfoLruCache = null;
    this.jdField_a_of_type_JavaUtilList = new ArrayList();
    this.jdField_a_of_type_ComTencentCommonAppAppInterface = paramAppInterface;
    this.jdField_a_of_type_ComTencentMobileqqVasAvatarPendantManager$PendantInfoLruCache = new AvatarPendantManager.PendantInfoLruCache(this, 10);
    this.jdField_a_of_type_Boolean = false;
  }
  
  public PendantInfo a(long paramLong)
  {
    synchronized (this.jdField_a_of_type_ComTencentMobileqqVasAvatarPendantManager$PendantInfoLruCache)
    {
      PendantInfo localPendantInfo = (PendantInfo)this.jdField_a_of_type_ComTencentMobileqqVasAvatarPendantManager$PendantInfoLruCache.get(Long.valueOf(paramLong));
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
        this.jdField_a_of_type_ComTencentMobileqqVasAvatarPendantManager$PendantInfoLruCache.put(Long.valueOf(paramLong), localObject1);
      }
      ((PendantInfo)localObject1).a(this.jdField_a_of_type_Boolean);
      return localObject1;
    }
  }
  
  public File a()
  {
    File localFile = new File(this.jdField_a_of_type_ComTencentCommonAppAppInterface.getApp().getApplicationContext().getFilesDir(), "pendant_info");
    if (!localFile.exists()) {
      localFile.mkdirs();
    }
    return localFile;
  }
  
  public List<AvatarPendantShopSeriesInfo> a()
  {
    return this.jdField_a_of_type_JavaUtilList;
  }
  
  public void a()
  {
    this.jdField_a_of_type_Boolean = true;
    synchronized (this.jdField_a_of_type_ComTencentMobileqqVasAvatarPendantManager$PendantInfoLruCache)
    {
      Iterator localIterator = this.jdField_a_of_type_ComTencentMobileqqVasAvatarPendantManager$PendantInfoLruCache.values().iterator();
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
    this.b = paramList;
  }
  
  public boolean a(long paramLong)
  {
    return this.jdField_a_of_type_Long != paramLong;
  }
  
  public File b()
  {
    File localFile = new File(AppConstants.SDCARD_PENDANT_ROOT);
    if (!localFile.exists()) {
      localFile.mkdirs();
    }
    return localFile;
  }
  
  public List<AvatarInPendantHeadportraitInfo> b()
  {
    return this.b;
  }
  
  public void b()
  {
    this.jdField_a_of_type_Boolean = false;
    synchronized (this.jdField_a_of_type_ComTencentMobileqqVasAvatarPendantManager$PendantInfoLruCache)
    {
      Iterator localIterator = this.jdField_a_of_type_ComTencentMobileqqVasAvatarPendantManager$PendantInfoLruCache.values().iterator();
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
  
  public void c()
  {
    synchronized (this.jdField_a_of_type_ComTencentMobileqqVasAvatarPendantManager$PendantInfoLruCache)
    {
      Iterator localIterator = this.jdField_a_of_type_ComTencentMobileqqVasAvatarPendantManager$PendantInfoLruCache.values().iterator();
      while (localIterator.hasNext()) {
        ((PendantInfo)localIterator.next()).c();
      }
      this.jdField_a_of_type_ComTencentMobileqqVasAvatarPendantManager$PendantInfoLruCache.clear();
      return;
    }
    for (;;)
    {
      throw localObject;
    }
  }
  
  public void onDestroy()
  {
    synchronized (this.jdField_a_of_type_ComTencentMobileqqVasAvatarPendantManager$PendantInfoLruCache)
    {
      this.jdField_a_of_type_ComTencentMobileqqVasAvatarPendantManager$PendantInfoLruCache.clear();
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.vas.AvatarPendantManager
 * JD-Core Version:    0.7.0.1
 */