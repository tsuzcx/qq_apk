package com.tencent.mobileqq.richstatus;

import avcn;
import avev;
import avey;
import java.util.Iterator;
import java.util.LinkedList;

class StatusManager$3$2$1
  implements Runnable
{
  StatusManager$3$2$1(StatusManager.3.2 param2) {}
  
  public void run()
  {
    if (avev.b(this.a.jdField_a_of_type_Avey.a) != null)
    {
      Iterator localIterator = avev.b(this.a.jdField_a_of_type_Avey.a).iterator();
      if (localIterator.hasNext())
      {
        avcn localavcn = (avcn)localIterator.next();
        if (this.a.jdField_a_of_type_Boolean) {}
        for (int i = 100;; i = -1)
        {
          localavcn.a(i, RichStatus.getEmptyStatus(), null);
          break;
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.richstatus.StatusManager.3.2.1
 * JD-Core Version:    0.7.0.1
 */