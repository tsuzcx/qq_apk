package com.tencent.mobileqq.enterpriseqq;

import com.tencent.mobileqq.soso.location.SosoInterfaceOnLocationListener;
import com.tencent.mobileqq.soso.location.data.SosoLbsInfo;
import com.tencent.mobileqq.soso.location.data.SosoLocation;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Iterator;

class EnterpriseQQManager$2
  extends SosoInterfaceOnLocationListener
{
  EnterpriseQQManager$2(EnterpriseQQManager paramEnterpriseQQManager, int paramInt, boolean paramBoolean1, boolean paramBoolean2, long paramLong, boolean paramBoolean3, boolean paramBoolean4, String paramString)
  {
    super(paramInt, paramBoolean1, paramBoolean2, paramLong, paramBoolean3, paramBoolean4, paramString);
  }
  
  public void onLocationFinish(int paramInt, SosoLbsInfo arg2)
  {
    Object localObject1;
    if (QLog.isColorLevel())
    {
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append("onLocationFinish() errCode=");
      ((StringBuilder)localObject1).append(paramInt);
      QLog.d("EnterpriseQQManager", 2, ((StringBuilder)localObject1).toString());
    }
    if (paramInt == 0) {
      paramInt = 1;
    } else {
      paramInt = 0;
    }
    EnterpriseQQManager.EventRequest localEventRequest;
    if (paramInt != 0)
    {
      ??? = ???.mLocation;
      double d1 = ???.mLat02;
      double d2 = ???.mLon02;
      EnterpriseQQManager.a(this.a, d1);
      EnterpriseQQManager.b(this.a, d2);
      EnterpriseQQManager.a(this.a, System.currentTimeMillis());
      synchronized (EnterpriseQQManager.a())
      {
        if ((EnterpriseQQManager.a(this.a) != null) && (EnterpriseQQManager.a(this.a).size() > 0))
        {
          localObject1 = EnterpriseQQManager.a(this.a).iterator();
          while (((Iterator)localObject1).hasNext())
          {
            localEventRequest = (EnterpriseQQManager.EventRequest)((Iterator)localObject1).next();
            if (localEventRequest != null) {
              this.a.a(EnterpriseQQManager.a(this.a), EnterpriseQQManager.a(this.a), localEventRequest.a, localEventRequest.b, true, d1, d2);
            }
          }
          EnterpriseQQManager.a(this.a).clear();
        }
      }
    }
    synchronized (EnterpriseQQManager.a())
    {
      if ((EnterpriseQQManager.a(this.a) != null) && (EnterpriseQQManager.a(this.a).size() > 0))
      {
        Iterator localIterator = EnterpriseQQManager.a(this.a).iterator();
        while (localIterator.hasNext())
        {
          localEventRequest = (EnterpriseQQManager.EventRequest)localIterator.next();
          if (localEventRequest != null) {
            this.a.a(EnterpriseQQManager.a(this.a), EnterpriseQQManager.a(this.a), localEventRequest.a, localEventRequest.b, false, 0.0D, 0.0D);
          }
        }
        EnterpriseQQManager.a(this.a).clear();
      }
      EnterpriseQQManager.a(this.a, null);
      EnterpriseQQManager.a(this.a, null);
      return;
    }
    for (;;)
    {
      throw localObject3;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.enterpriseqq.EnterpriseQQManager.2
 * JD-Core Version:    0.7.0.1
 */