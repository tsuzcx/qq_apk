package com.tencent.mobileqq.intervideo.singtogether;

import arjv;
import aukn;
import auko;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.util.QLog;
import java.util.Iterator;
import java.util.List;

public class FetchOpenIdManager$1
  implements Runnable
{
  public FetchOpenIdManager$1(arjv paramarjv, QQAppInterface paramQQAppInterface) {}
  
  public void run()
  {
    aukn localaukn = this.a.getEntityManagerFactory().createEntityManager();
    Object localObject = localaukn.a(OpenIdItem.class, false, null, null, null, null, null, null);
    if ((localObject != null) && (((List)localObject).size() > 0)) {
      localObject = ((List)localObject).iterator();
    }
    while (((Iterator)localObject).hasNext())
    {
      OpenIdItem localOpenIdItem = (OpenIdItem)((Iterator)localObject).next();
      arjv.a(this.this$0, localOpenIdItem.appId, localOpenIdItem.uin, localOpenIdItem.openId);
      arjv.a(this.this$0, localOpenIdItem, false);
      continue;
      if (QLog.isColorLevel()) {
        QLog.d("FetchOpenIdManager", 2, "initOpenIdFromDB size is 0");
      }
    }
    arjv.a(this.this$0, 1);
    localaukn.a();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.intervideo.singtogether.FetchOpenIdManager.1
 * JD-Core Version:    0.7.0.1
 */