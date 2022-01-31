package com.tencent.mobileqq.transfile;

import ayrx;
import aytc;
import ayuk;
import bbmu;
import com.tencent.qphone.base.util.QLog;
import java.util.TimerTask;
import java.util.concurrent.atomic.AtomicBoolean;

public class OldHttpEngine$OldHttpCommunicatorListner$2
  extends TimerTask
{
  public OldHttpEngine$OldHttpCommunicatorListner$2(aytc paramaytc, ayrx paramayrx) {}
  
  public void run()
  {
    boolean bool = true;
    int i;
    if ((QLog.isColorLevel()) && (this.jdField_a_of_type_Ayrx != null))
    {
      i = this.jdField_a_of_type_Ayrx.g;
      if (this.jdField_a_of_type_Ayrx.a != 1) {
        break label94;
      }
    }
    for (;;)
    {
      ayuk.a(i, bool, this.jdField_a_of_type_Ayrx.f, this.jdField_a_of_type_Ayrx.e, "scheduleRetry", "mIsCancelled:" + this.jdField_a_of_type_Aytc.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean);
      if (!this.jdField_a_of_type_Aytc.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean.get()) {
        break;
      }
      return;
      label94:
      bool = false;
    }
    this.jdField_a_of_type_Aytc.jdField_a_of_type_Bbmu.a(9004, -1, "nonetwork");
    this.jdField_a_of_type_Aytc.b(this.jdField_a_of_type_Aytc.jdField_a_of_type_Bbmu, this.jdField_a_of_type_Aytc.jdField_a_of_type_Bbmu);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.transfile.OldHttpEngine.OldHttpCommunicatorListner.2
 * JD-Core Version:    0.7.0.1
 */