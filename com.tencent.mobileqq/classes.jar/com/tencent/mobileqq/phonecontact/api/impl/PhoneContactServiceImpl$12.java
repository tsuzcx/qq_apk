package com.tencent.mobileqq.phonecontact.api.impl;

import com.tencent.mobileqq.phonecontact.listener.IPhoneContactListener;
import java.util.Iterator;
import java.util.LinkedList;

class PhoneContactServiceImpl$12
  implements Runnable
{
  PhoneContactServiceImpl$12(PhoneContactServiceImpl paramPhoneContactServiceImpl, long paramLong) {}
  
  public void run()
  {
    synchronized (PhoneContactServiceImpl.access$3100(this.this$0))
    {
      Iterator localIterator = PhoneContactServiceImpl.access$3100(this.this$0).iterator();
      while (localIterator.hasNext()) {
        ((IPhoneContactListener)localIterator.next()).a(this.a);
      }
      return;
    }
    for (;;)
    {
      throw localObject;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.phonecontact.api.impl.PhoneContactServiceImpl.12
 * JD-Core Version:    0.7.0.1
 */