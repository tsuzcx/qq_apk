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
    int i = 1;
    if (QLog.isColorLevel()) {
      QLog.d("EnterpriseQQManager", 2, "onLocationFinish() errCode=" + paramInt);
    }
    if (paramInt == 0) {
      paramInt = i;
    }
    EnterpriseQQManager.EventRequest localEventRequest;
    label219:
    while (paramInt != 0)
    {
      ??? = ???.mLocation;
      double d1 = ???.mLat02;
      double d2 = ???.mLon02;
      EnterpriseQQManager.a(this.a, d1);
      EnterpriseQQManager.b(this.a, d2);
      EnterpriseQQManager.a(this.a, System.currentTimeMillis());
      synchronized (EnterpriseQQManager.a())
      {
        if ((EnterpriseQQManager.a(this.a) == null) || (EnterpriseQQManager.a(this.a).size() <= 0)) {
          break label219;
        }
        Iterator localIterator1 = EnterpriseQQManager.a(this.a).iterator();
        do
        {
          if (!localIterator1.hasNext()) {
            break;
          }
          localEventRequest = (EnterpriseQQManager.EventRequest)localIterator1.next();
        } while (localEventRequest == null);
        this.a.a(EnterpriseQQManager.a(this.a), EnterpriseQQManager.a(this.a), localEventRequest.a, localEventRequest.b, true, d1, d2);
      }
      paramInt = 0;
      continue;
      EnterpriseQQManager.a(this.a).clear();
    }
    label362:
    for (;;)
    {
      EnterpriseQQManager.a(this.a, null);
      EnterpriseQQManager.a(this.a, null);
      return;
      synchronized (EnterpriseQQManager.a())
      {
        if ((EnterpriseQQManager.a(this.a) == null) || (EnterpriseQQManager.a(this.a).size() <= 0)) {
          break label362;
        }
        Iterator localIterator2 = EnterpriseQQManager.a(this.a).iterator();
        while (localIterator2.hasNext())
        {
          localEventRequest = (EnterpriseQQManager.EventRequest)localIterator2.next();
          if (localEventRequest != null) {
            this.a.a(EnterpriseQQManager.a(this.a), EnterpriseQQManager.a(this.a), localEventRequest.a, localEventRequest.b, false, 0.0D, 0.0D);
          }
        }
      }
      EnterpriseQQManager.a(this.a).clear();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.enterpriseqq.EnterpriseQQManager.2
 * JD-Core Version:    0.7.0.1
 */