package com.tencent.mobileqq.richstatus;

import bamr;
import baoy;
import bapb;
import java.util.Iterator;
import java.util.LinkedList;

class StatusManager$3$2$1
  implements Runnable
{
  StatusManager$3$2$1(StatusManager.3.2 param2) {}
  
  public void run()
  {
    if (baoy.b(this.a.jdField_a_of_type_Bapb.a) != null)
    {
      Iterator localIterator = baoy.b(this.a.jdField_a_of_type_Bapb.a).iterator();
      if (localIterator.hasNext())
      {
        bamr localbamr = (bamr)localIterator.next();
        if (this.a.jdField_a_of_type_Boolean) {}
        for (int i = 100;; i = -1)
        {
          localbamr.a(i, RichStatus.getEmptyStatus(), null);
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