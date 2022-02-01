package com.tencent.mobileqq.enterpriseqq;

import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.soso.location.api.ISosoInterfaceApi;
import java.util.ArrayList;
import java.util.Iterator;

class EnterpriseQQManager$1
  implements Runnable
{
  EnterpriseQQManager$1(EnterpriseQQManager paramEnterpriseQQManager) {}
  
  public void run()
  {
    if ((EnterpriseQQManager.a(this.this$0) != null) && (EnterpriseQQManager.a(this.this$0) != null))
    {
      ((ISosoInterfaceApi)QRoute.api(ISosoInterfaceApi.class)).startLocation(this.this$0.a);
      return;
    }
    synchronized (EnterpriseQQManager.a())
    {
      if ((EnterpriseQQManager.a(this.this$0) != null) && (EnterpriseQQManager.a(this.this$0).size() > 0))
      {
        Iterator localIterator = EnterpriseQQManager.a(this.this$0).iterator();
        while (localIterator.hasNext())
        {
          EnterpriseQQManager.EventRequest localEventRequest = (EnterpriseQQManager.EventRequest)localIterator.next();
          if (localEventRequest != null) {
            this.this$0.a(EnterpriseQQManager.a(this.this$0), EnterpriseQQManager.a(this.this$0), localEventRequest.a, localEventRequest.b, false, 0.0D, 0.0D);
          }
        }
        EnterpriseQQManager.a(this.this$0).clear();
      }
      EnterpriseQQManager.a(this.this$0, null);
      EnterpriseQQManager.a(this.this$0, null);
      return;
    }
    for (;;)
    {
      throw localObject;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.enterpriseqq.EnterpriseQQManager.1
 * JD-Core Version:    0.7.0.1
 */