package com.tencent.mobileqq.transfile;

import axro;
import axss;
import axst;
import axub;
import com.tencent.qphone.base.util.QLog;
import java.util.concurrent.atomic.AtomicBoolean;

public class OldHttpEngine$OldHttpCommunicatorListner$1
  implements Runnable
{
  public OldHttpEngine$OldHttpCommunicatorListner$1(axst paramaxst, axro paramaxro) {}
  
  public void run()
  {
    boolean bool = true;
    int i;
    if ((QLog.isColorLevel()) && (this.jdField_a_of_type_Axro != null))
    {
      i = this.jdField_a_of_type_Axro.g;
      if (this.jdField_a_of_type_Axro.a != 1) {
        break label94;
      }
    }
    for (;;)
    {
      axub.a(i, bool, this.jdField_a_of_type_Axro.f, this.jdField_a_of_type_Axro.e, "scheduleRetry", "mIsCancelled:" + this.jdField_a_of_type_Axst.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean);
      if (!this.jdField_a_of_type_Axst.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean.get()) {
        break;
      }
      return;
      label94:
      bool = false;
    }
    this.jdField_a_of_type_Axst.jdField_a_of_type_Axss.c(this.jdField_a_of_type_Axst.jdField_a_of_type_Axro);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.transfile.OldHttpEngine.OldHttpCommunicatorListner.1
 * JD-Core Version:    0.7.0.1
 */