package com.tencent.mobileqq.richstatus;

import java.util.Iterator;
import java.util.LinkedList;

class StatusManager$3$2$1
  implements Runnable
{
  StatusManager$3$2$1(StatusManager.3.2 param2) {}
  
  public void run()
  {
    if (StatusManager.b(this.a.jdField_a_of_type_ComTencentMobileqqRichstatusStatusManager$3.a) != null)
    {
      Iterator localIterator = StatusManager.b(this.a.jdField_a_of_type_ComTencentMobileqqRichstatusStatusManager$3.a).iterator();
      if (localIterator.hasNext())
      {
        IStatusListener localIStatusListener = (IStatusListener)localIterator.next();
        if (this.a.jdField_a_of_type_Boolean) {}
        for (int i = 100;; i = -1)
        {
          localIStatusListener.a(i, RichStatus.getEmptyStatus(), null);
          break;
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.richstatus.StatusManager.3.2.1
 * JD-Core Version:    0.7.0.1
 */