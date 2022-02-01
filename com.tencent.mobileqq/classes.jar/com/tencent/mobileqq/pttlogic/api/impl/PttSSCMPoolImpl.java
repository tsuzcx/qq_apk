package com.tencent.mobileqq.pttlogic.api.impl;

import android.os.SystemClock;
import com.tencent.mobileqq.ptt.PttSSCM;
import com.tencent.mobileqq.pttlogic.api.IPttSSCMPool;
import com.tencent.qphone.base.util.QLog;
import com.tencent.wstt.SSCM.SSCM;
import java.util.ArrayList;
import java.util.Iterator;

public class PttSSCMPoolImpl
  implements IPttSSCMPool
{
  private static String TAG = "PttSSCMPoolImpl";
  private long expiredTime = 60000L;
  private int maxObjects = 5;
  private ArrayList<PttSSCMPoolImpl.PooledSSCM> sscms;
  
  private SSCM findFreeObject()
  {
    Object localObject1 = this.sscms;
    if (localObject1 == null) {
      return null;
    }
    Object localObject2 = ((ArrayList)localObject1).iterator();
    while (((Iterator)localObject2).hasNext())
    {
      localObject1 = (PttSSCMPoolImpl.PooledSSCM)((Iterator)localObject2).next();
      if (!((PttSSCMPoolImpl.PooledSSCM)localObject1).jdField_a_of_type_Boolean)
      {
        localObject2 = ((PttSSCMPoolImpl.PooledSSCM)localObject1).jdField_a_of_type_ComTencentWsttSSCMSSCM;
        ((PttSSCMPoolImpl.PooledSSCM)localObject1).jdField_a_of_type_Boolean = true;
        long l = SystemClock.elapsedRealtime();
        if (QLog.isColorLevel())
        {
          String str = TAG;
          StringBuilder localStringBuilder = new StringBuilder();
          localStringBuilder.append("query for sscm, get one expired:");
          localStringBuilder.append(l - ((PttSSCMPoolImpl.PooledSSCM)localObject1).jdField_a_of_type_Long);
          QLog.d(str, 2, localStringBuilder.toString());
        }
        if (l - ((PttSSCMPoolImpl.PooledSSCM)localObject1).jdField_a_of_type_Long > this.expiredTime) {
          ((PttSSCMPoolImpl.PooledSSCM)localObject1).jdField_a_of_type_ComTencentWsttSSCMSSCM.a();
        }
        return localObject2;
      }
    }
    return null;
  }
  
  public void clear()
  {
    try
    {
      this.sscms = null;
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public SSCM getSSCM()
  {
    try
    {
      if (this.sscms == null) {
        this.sscms = new ArrayList();
      }
      Object localObject3 = findFreeObject();
      Object localObject1 = localObject3;
      if (localObject3 == null)
      {
        localObject3 = new PttSSCM();
        ((SSCM)localObject3).a();
        this.sscms.add(new PttSSCMPoolImpl.PooledSSCM((SSCM)localObject3));
        localObject1 = localObject3;
        if (QLog.isColorLevel())
        {
          localObject1 = TAG;
          StringBuilder localStringBuilder = new StringBuilder();
          localStringBuilder.append("can't find sscm object, add new one, size= ");
          localStringBuilder.append(this.sscms.size());
          QLog.d((String)localObject1, 2, localStringBuilder.toString());
          localObject1 = localObject3;
        }
      }
      return localObject1;
    }
    finally {}
  }
  
  public void returnObject(SSCM paramSSCM)
  {
    try
    {
      Object localObject = this.sscms;
      if (localObject == null) {
        return;
      }
      localObject = this.sscms.iterator();
      while (((Iterator)localObject).hasNext())
      {
        PttSSCMPoolImpl.PooledSSCM localPooledSSCM = (PttSSCMPoolImpl.PooledSSCM)((Iterator)localObject).next();
        if (paramSSCM == localPooledSSCM.jdField_a_of_type_ComTencentWsttSSCMSSCM)
        {
          if (QLog.isColorLevel())
          {
            paramSSCM = TAG;
            StringBuilder localStringBuilder = new StringBuilder();
            localStringBuilder.append("return sscm, current size=");
            localStringBuilder.append(this.sscms.size());
            QLog.d(paramSSCM, 2, localStringBuilder.toString());
          }
          if (this.sscms.size() > this.maxObjects)
          {
            ((Iterator)localObject).remove();
          }
          else
          {
            localPooledSSCM.jdField_a_of_type_Boolean = false;
            localPooledSSCM.jdField_a_of_type_Long = SystemClock.elapsedRealtime();
          }
        }
      }
      return;
    }
    finally {}
    for (;;)
    {
      throw paramSSCM;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.pttlogic.api.impl.PttSSCMPoolImpl
 * JD-Core Version:    0.7.0.1
 */