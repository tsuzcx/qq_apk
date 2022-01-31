package com.tencent.mobileqq.richstatus;

import awcg;
import aweo;
import awer;
import java.util.Iterator;
import java.util.LinkedList;

class StatusManager$3$2$1
  implements Runnable
{
  StatusManager$3$2$1(StatusManager.3.2 param2) {}
  
  public void run()
  {
    if (aweo.b(this.a.jdField_a_of_type_Awer.a) != null)
    {
      Iterator localIterator = aweo.b(this.a.jdField_a_of_type_Awer.a).iterator();
      if (localIterator.hasNext())
      {
        awcg localawcg = (awcg)localIterator.next();
        if (this.a.jdField_a_of_type_Boolean) {}
        for (int i = 100;; i = -1)
        {
          localawcg.a(i, RichStatus.getEmptyStatus(), null);
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