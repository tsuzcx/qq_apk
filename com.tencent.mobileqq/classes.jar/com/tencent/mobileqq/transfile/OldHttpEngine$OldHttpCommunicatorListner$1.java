package com.tencent.mobileqq.transfile;

import baub;
import bavh;
import bavi;
import baws;
import com.tencent.qphone.base.util.QLog;
import java.util.concurrent.atomic.AtomicBoolean;

public class OldHttpEngine$OldHttpCommunicatorListner$1
  implements Runnable
{
  public OldHttpEngine$OldHttpCommunicatorListner$1(bavi parambavi, baub parambaub) {}
  
  public void run()
  {
    boolean bool = true;
    int i;
    if ((QLog.isColorLevel()) && (this.jdField_a_of_type_Baub != null))
    {
      i = this.jdField_a_of_type_Baub.g;
      if (this.jdField_a_of_type_Baub.a != 1) {
        break label94;
      }
    }
    for (;;)
    {
      baws.a(i, bool, this.jdField_a_of_type_Baub.f, this.jdField_a_of_type_Baub.e, "scheduleRetry", "mIsCancelled:" + this.jdField_a_of_type_Bavi.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean);
      if (!this.jdField_a_of_type_Bavi.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean.get()) {
        break;
      }
      return;
      label94:
      bool = false;
    }
    this.jdField_a_of_type_Bavi.jdField_a_of_type_Bavh.c(this.jdField_a_of_type_Bavi.jdField_a_of_type_Baub);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.transfile.OldHttpEngine.OldHttpCommunicatorListner.1
 * JD-Core Version:    0.7.0.1
 */