package com.tencent.mobileqq.dating;

import azmj;
import java.util.Iterator;
import java.util.LinkedList;

class CarrierHelper$1
  implements Runnable
{
  CarrierHelper$1(CarrierHelper paramCarrierHelper, LinkedList paramLinkedList) {}
  
  public void run()
  {
    if ((CarrierHelper.a(this.this$0)) || (this.a.isEmpty())) {
      return;
    }
    Iterator localIterator = this.a.iterator();
    while (localIterator.hasNext())
    {
      Integer localInteger = (Integer)localIterator.next();
      if (5 == localInteger.intValue()) {
        azmj.b(CarrierHelper.a(this.this$0), "CliOper", "", "", "0X80052A4", "0X80052A4", CarrierHelper.a(this.this$0), 0, "", "", "", "");
      } else if ((CarrierHelper.a(this.this$0) == 2) || (CarrierHelper.a(this.this$0) == 1)) {
        azmj.b(CarrierHelper.a(this.this$0), "CliOper", "", "", "0X80050D0", "0X80050D0", CarrierHelper.a(this.this$0), 0, String.valueOf(localInteger), "", "", "");
      }
    }
    CarrierHelper.a(this.this$0, true);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.dating.CarrierHelper.1
 * JD-Core Version:    0.7.0.1
 */