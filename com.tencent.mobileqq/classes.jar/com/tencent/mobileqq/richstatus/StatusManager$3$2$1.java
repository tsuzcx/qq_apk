package com.tencent.mobileqq.richstatus;

import aybu;
import ayec;
import ayef;
import java.util.Iterator;
import java.util.LinkedList;

class StatusManager$3$2$1
  implements Runnable
{
  StatusManager$3$2$1(StatusManager.3.2 param2) {}
  
  public void run()
  {
    if (ayec.b(this.a.jdField_a_of_type_Ayef.a) != null)
    {
      Iterator localIterator = ayec.b(this.a.jdField_a_of_type_Ayef.a).iterator();
      if (localIterator.hasNext())
      {
        aybu localaybu = (aybu)localIterator.next();
        if (this.a.jdField_a_of_type_Boolean) {}
        for (int i = 100;; i = -1)
        {
          localaybu.a(i, RichStatus.getEmptyStatus(), null);
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