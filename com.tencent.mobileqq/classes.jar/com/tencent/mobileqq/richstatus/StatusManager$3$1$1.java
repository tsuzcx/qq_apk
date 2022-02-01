package com.tencent.mobileqq.richstatus;

import java.util.Iterator;
import java.util.LinkedList;

class StatusManager$3$1$1
  implements Runnable
{
  StatusManager$3$1$1(StatusManager.3.1 param1, int paramInt, RichStatus paramRichStatus, TipsInfo paramTipsInfo) {}
  
  public void run()
  {
    if (StatusManager.b(this.jdField_a_of_type_ComTencentMobileqqRichstatusStatusManager$3$1.a.a) != null)
    {
      Iterator localIterator = StatusManager.b(this.jdField_a_of_type_ComTencentMobileqqRichstatusStatusManager$3$1.a.a).iterator();
      while (localIterator.hasNext()) {
        ((IStatusListener)localIterator.next()).a(this.jdField_a_of_type_Int, this.jdField_a_of_type_ComTencentMobileqqRichstatusRichStatus, this.jdField_a_of_type_ComTencentMobileqqRichstatusTipsInfo);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.richstatus.StatusManager.3.1.1
 * JD-Core Version:    0.7.0.1
 */