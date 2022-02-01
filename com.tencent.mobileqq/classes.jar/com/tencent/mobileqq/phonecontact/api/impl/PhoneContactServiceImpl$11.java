package com.tencent.mobileqq.phonecontact.api.impl;

import com.tencent.mobileqq.phonecontact.listener.IPhoneContactListener;
import java.util.Iterator;
import java.util.LinkedList;

class PhoneContactServiceImpl$11
  implements Runnable
{
  PhoneContactServiceImpl$11(PhoneContactServiceImpl paramPhoneContactServiceImpl, boolean paramBoolean, int paramInt) {}
  
  public void run()
  {
    synchronized (PhoneContactServiceImpl.access$3100(this.this$0))
    {
      Iterator localIterator = PhoneContactServiceImpl.access$3100(this.this$0).iterator();
      while (localIterator.hasNext()) {
        ((IPhoneContactListener)localIterator.next()).a(this.jdField_a_of_type_Boolean, this.jdField_a_of_type_Int);
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
 * Qualified Name:     com.tencent.mobileqq.phonecontact.api.impl.PhoneContactServiceImpl.11
 * JD-Core Version:    0.7.0.1
 */