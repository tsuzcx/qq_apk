package com.tencent.mobileqq.richstatus;

import axxl;
import axzt;
import axzw;
import java.util.Iterator;
import java.util.LinkedList;

class StatusManager$3$2$1
  implements Runnable
{
  StatusManager$3$2$1(StatusManager.3.2 param2) {}
  
  public void run()
  {
    if (axzt.b(this.a.jdField_a_of_type_Axzw.a) != null)
    {
      Iterator localIterator = axzt.b(this.a.jdField_a_of_type_Axzw.a).iterator();
      if (localIterator.hasNext())
      {
        axxl localaxxl = (axxl)localIterator.next();
        if (this.a.jdField_a_of_type_Boolean) {}
        for (int i = 100;; i = -1)
        {
          localaxxl.a(i, RichStatus.getEmptyStatus(), null);
          break;
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.richstatus.StatusManager.3.2.1
 * JD-Core Version:    0.7.0.1
 */