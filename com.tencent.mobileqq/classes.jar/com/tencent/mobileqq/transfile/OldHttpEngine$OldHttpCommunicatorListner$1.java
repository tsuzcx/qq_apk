package com.tencent.mobileqq.transfile;

import ayrv;
import aysz;
import ayta;
import ayui;
import com.tencent.qphone.base.util.QLog;
import java.util.concurrent.atomic.AtomicBoolean;

public class OldHttpEngine$OldHttpCommunicatorListner$1
  implements Runnable
{
  public OldHttpEngine$OldHttpCommunicatorListner$1(ayta paramayta, ayrv paramayrv) {}
  
  public void run()
  {
    boolean bool = true;
    int i;
    if ((QLog.isColorLevel()) && (this.jdField_a_of_type_Ayrv != null))
    {
      i = this.jdField_a_of_type_Ayrv.g;
      if (this.jdField_a_of_type_Ayrv.a != 1) {
        break label94;
      }
    }
    for (;;)
    {
      ayui.a(i, bool, this.jdField_a_of_type_Ayrv.f, this.jdField_a_of_type_Ayrv.e, "scheduleRetry", "mIsCancelled:" + this.jdField_a_of_type_Ayta.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean);
      if (!this.jdField_a_of_type_Ayta.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean.get()) {
        break;
      }
      return;
      label94:
      bool = false;
    }
    this.jdField_a_of_type_Ayta.jdField_a_of_type_Aysz.c(this.jdField_a_of_type_Ayta.jdField_a_of_type_Ayrv);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.transfile.OldHttpEngine.OldHttpCommunicatorListner.1
 * JD-Core Version:    0.7.0.1
 */