package com.tencent.mobileqq.phonecontact.api.impl;

import com.tencent.mobileqq.data.PhoneContact;
import com.tencent.mobileqq.persistence.EntityManager;
import com.tencent.mobileqq.persistence.EntityTransaction;
import com.tencent.mobileqq.phonecontact.data.ContactBinded;
import java.util.Collection;
import java.util.Iterator;
import java.util.concurrent.ConcurrentHashMap;

class PhoneContactServiceImpl$8
  implements Runnable
{
  PhoneContactServiceImpl$8(PhoneContactServiceImpl paramPhoneContactServiceImpl) {}
  
  public void run()
  {
    Object localObject1 = PhoneContactServiceImpl.access$3200(this.this$0).getTransaction();
    ((EntityTransaction)localObject1).begin();
    try
    {
      Iterator localIterator = PhoneContactServiceImpl.access$1700(this.this$0).values().iterator();
      while (localIterator.hasNext())
      {
        PhoneContact localPhoneContact = (PhoneContact)localIterator.next();
        if (localPhoneContact.isNewRecommend)
        {
          localPhoneContact.isNewRecommend = false;
          PhoneContactServiceImpl.access$3200(this.this$0).update(localPhoneContact);
        }
      }
      ((EntityTransaction)localObject1).commit();
      ((EntityTransaction)localObject1).end();
      localObject1 = PhoneContactServiceImpl.access$3300(this.this$0);
      if (localObject1 != null) {
        ((ContactBinded)localObject1).isReaded = true;
      }
      PhoneContactServiceImpl.access$3400(this.this$0, false);
      return;
    }
    finally
    {
      ((EntityTransaction)localObject1).end();
    }
    for (;;)
    {
      throw localObject2;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.phonecontact.api.impl.PhoneContactServiceImpl.8
 * JD-Core Version:    0.7.0.1
 */