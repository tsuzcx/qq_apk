package com.tencent.mobileqq.phonecontact.api.impl;

import com.tencent.mobileqq.phonecontact.listener.IPhoneContactListener;
import java.util.Iterator;
import java.util.LinkedList;

class PhoneContactServiceImpl$9
  implements Runnable
{
  PhoneContactServiceImpl$9(PhoneContactServiceImpl paramPhoneContactServiceImpl) {}
  
  public void run()
  {
    try
    {
      synchronized (PhoneContactServiceImpl.access$3100(this.this$0))
      {
        Iterator localIterator = PhoneContactServiceImpl.access$3100(this.this$0).iterator();
        if (localIterator.hasNext()) {
          ((IPhoneContactListener)localIterator.next()).a(PhoneContactServiceImpl.access$1400(this.this$0));
        }
      }
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
      return;
    }
    for (;;)
    {
      throw localException;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.phonecontact.api.impl.PhoneContactServiceImpl.9
 * JD-Core Version:    0.7.0.1
 */