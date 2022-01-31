package com.tencent.mobileqq.transfile;

import axro;
import axst;
import axub;
import bakw;
import com.tencent.qphone.base.util.QLog;
import java.util.TimerTask;
import java.util.concurrent.atomic.AtomicBoolean;

public class OldHttpEngine$OldHttpCommunicatorListner$2
  extends TimerTask
{
  public OldHttpEngine$OldHttpCommunicatorListner$2(axst paramaxst, axro paramaxro) {}
  
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
    this.jdField_a_of_type_Axst.jdField_a_of_type_Bakw.a(9004, -1, "nonetwork");
    this.jdField_a_of_type_Axst.b(this.jdField_a_of_type_Axst.jdField_a_of_type_Bakw, this.jdField_a_of_type_Axst.jdField_a_of_type_Bakw);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.transfile.OldHttpEngine.OldHttpCommunicatorListner.2
 * JD-Core Version:    0.7.0.1
 */