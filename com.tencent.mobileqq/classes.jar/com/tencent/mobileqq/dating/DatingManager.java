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
  private byte jdField_a_of_type_Byte;
  private int jdField_a_of_type_Int;
  protected INearbyAppInterface a;
  protected EntityManager a;
  private String jdField_a_of_type_JavaLangString;
  public long d = 0L;
  
  public DatingManager(INearbyAppInterface paramINearbyAppInterface)
  {
    this.jdField_a_of_type_ComTencentMobileqqNearbyApiINearbyAppInterface = paramINearbyAppInterface;
    this.jdField_a_of_type_ComTencentMobileqqPersistenceEntityManager = paramINearbyAppInterface.getEntityManagerFactory().createEntityManager();
    this.jdField_a_of_type_Byte = 0;
    this.jdField_a_of_type_JavaLangString = null;
    this.jdField_a_of_type_Int = -2147483648;
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
    jdField_a_of_type_Long = paramLong1;
    b = paramLong2;
    c = paramLong3;
  }
  
  public void onDestroy()
  {
    EntityManager localEntityManager = this.jdField_a_of_type_ComTencentMobileqqPersistenceEntityManager;
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.dating.DatingManager
 * JD-Core Version:    0.7.0.1
 */