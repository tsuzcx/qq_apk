package com.tencent.mobileqq.phonecontact.api.impl;

import com.tencent.mobileqq.phonecontact.listener.IPhoneContactListener;
import java.util.Iterator;
import java.util.LinkedList;

class PhoneContactServiceImpl$6
  implements Runnable
{
  PhoneContactServiceImpl$6(PhoneContactServiceImpl paramPhoneContactServiceImpl, int paramInt) {}
  
  public void run()
  {
    synchronized (PhoneContactServiceImpl.access$3100(this.this$0))
    {
      Iterator localIterator = PhoneContactServiceImpl.access$3100(this.this$0).iterator();
      while (localIterator.hasNext()) {
        ((IPhoneContactListener)localIterator.next()).c(this.a);
      }
      return;
    }
    for (;;)
    {
      throw localObject;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.phonecontact.api.impl.PhoneContactServiceImpl.6
 * JD-Core Version:    0.7.0.1
 */