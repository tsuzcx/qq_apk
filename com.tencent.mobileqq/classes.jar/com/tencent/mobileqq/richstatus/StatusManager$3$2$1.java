package com.tencent.mobileqq.richstatus;

import bbtg;
import bbvn;
import bbvq;
import java.util.Iterator;
import java.util.LinkedList;

class StatusManager$3$2$1
  implements Runnable
{
  StatusManager$3$2$1(StatusManager.3.2 param2) {}
  
  public void run()
  {
    if (bbvn.b(this.a.jdField_a_of_type_Bbvq.a) != null)
    {
      Iterator localIterator = bbvn.b(this.a.jdField_a_of_type_Bbvq.a).iterator();
      if (localIterator.hasNext())
      {
        bbtg localbbtg = (bbtg)localIterator.next();
        if (this.a.jdField_a_of_type_Boolean) {}
        for (int i = 100;; i = -1)
        {
          localbbtg.a(i, RichStatus.getEmptyStatus(), null);
          break;
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.richstatus.StatusManager.3.2.1
 * JD-Core Version:    0.7.0.1
 */