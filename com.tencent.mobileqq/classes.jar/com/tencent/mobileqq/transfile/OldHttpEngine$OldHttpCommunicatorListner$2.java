package com.tencent.mobileqq.transfile;

import bdvs;
import bdww;
import bdxz;
import bgux;
import com.tencent.qphone.base.util.QLog;
import java.util.TimerTask;
import java.util.concurrent.atomic.AtomicBoolean;

public class OldHttpEngine$OldHttpCommunicatorListner$2
  extends TimerTask
{
  public OldHttpEngine$OldHttpCommunicatorListner$2(bdww parambdww, bdvs parambdvs) {}
  
  public void run()
  {
    boolean bool = true;
    int i;
    if ((QLog.isColorLevel()) && (this.jdField_a_of_type_Bdvs != null))
    {
      i = this.jdField_a_of_type_Bdvs.f;
      if (this.jdField_a_of_type_Bdvs.a != 1) {
        break label94;
      }
    }
    for (;;)
    {
      bdxz.a(i, bool, this.jdField_a_of_type_Bdvs.jdField_e_of_type_Int, this.jdField_a_of_type_Bdvs.jdField_e_of_type_JavaLangString, "scheduleRetry", "mIsCancelled:" + this.jdField_a_of_type_Bdww.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean);
      if (!this.jdField_a_of_type_Bdww.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean.get()) {
        break;
      }
      return;
      label94:
      bool = false;
    }
    this.jdField_a_of_type_Bdww.jdField_a_of_type_Bgux.a(9004, -1, "nonetwork");
    this.jdField_a_of_type_Bdww.b(this.jdField_a_of_type_Bdww.jdField_a_of_type_Bgux, this.jdField_a_of_type_Bdww.jdField_a_of_type_Bgux);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.transfile.OldHttpEngine.OldHttpCommunicatorListner.2
 * JD-Core Version:    0.7.0.1
 */