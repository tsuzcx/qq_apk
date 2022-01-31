package com.tencent.mobileqq.intervideo.singtogether;

import arjx;
import aukp;
import aukq;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.util.QLog;
import java.util.Iterator;
import java.util.List;

public class FetchOpenIdManager$1
  implements Runnable
{
  public FetchOpenIdManager$1(arjx paramarjx, QQAppInterface paramQQAppInterface) {}
  
  public void run()
  {
    aukp localaukp = this.a.getEntityManagerFactory().createEntityManager();
    Object localObject = localaukp.a(OpenIdItem.class, false, null, null, null, null, null, null);
    if ((localObject != null) && (((List)localObject).size() > 0)) {
      localObject = ((List)localObject).iterator();
    }
    while (((Iterator)localObject).hasNext())
    {
      OpenIdItem localOpenIdItem = (OpenIdItem)((Iterator)localObject).next();
      arjx.a(this.this$0, localOpenIdItem.appId, localOpenIdItem.uin, localOpenIdItem.openId);
      arjx.a(this.this$0, localOpenIdItem, false);
      continue;
      if (QLog.isColorLevel()) {
        QLog.d("FetchOpenIdManager", 2, "initOpenIdFromDB size is 0");
      }
    }
    arjx.a(this.this$0, 1);
    localaukp.a();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.intervideo.singtogether.FetchOpenIdManager.1
 * JD-Core Version:    0.7.0.1
 */