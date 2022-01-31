package com.tencent.mobileqq.transfile;

import baub;
import bavi;
import baws;
import bdpx;
import com.tencent.qphone.base.util.QLog;
import java.util.TimerTask;
import java.util.concurrent.atomic.AtomicBoolean;

public class OldHttpEngine$OldHttpCommunicatorListner$2
  extends TimerTask
{
  public OldHttpEngine$OldHttpCommunicatorListner$2(bavi parambavi, baub parambaub) {}
  
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
    this.jdField_a_of_type_Bavi.jdField_a_of_type_Bdpx.a(9004, -1, "nonetwork");
    this.jdField_a_of_type_Bavi.b(this.jdField_a_of_type_Bavi.jdField_a_of_type_Bdpx, this.jdField_a_of_type_Bavi.jdField_a_of_type_Bdpx);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.transfile.OldHttpEngine.OldHttpCommunicatorListner.2
 * JD-Core Version:    0.7.0.1
 */