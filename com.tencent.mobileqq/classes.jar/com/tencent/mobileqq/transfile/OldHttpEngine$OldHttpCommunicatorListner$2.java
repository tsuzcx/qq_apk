package com.tencent.mobileqq.transfile;

import beum;
import bevp;
import bews;
import bhva;
import com.tencent.qphone.base.util.QLog;
import java.util.TimerTask;
import java.util.concurrent.atomic.AtomicBoolean;

public class OldHttpEngine$OldHttpCommunicatorListner$2
  extends TimerTask
{
  public OldHttpEngine$OldHttpCommunicatorListner$2(bevp parambevp, beum parambeum) {}
  
  public void run()
  {
    boolean bool = true;
    int i;
    if ((QLog.isColorLevel()) && (this.jdField_a_of_type_Beum != null))
    {
      i = this.jdField_a_of_type_Beum.f;
      if (this.jdField_a_of_type_Beum.a != 1) {
        break label94;
      }
    }
    for (;;)
    {
      bews.a(i, bool, this.jdField_a_of_type_Beum.jdField_e_of_type_Int, this.jdField_a_of_type_Beum.jdField_e_of_type_JavaLangString, "scheduleRetry", "mIsCancelled:" + this.jdField_a_of_type_Bevp.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean);
      if (!this.jdField_a_of_type_Bevp.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean.get()) {
        break;
      }
      return;
      label94:
      bool = false;
    }
    this.jdField_a_of_type_Bevp.jdField_a_of_type_Bhva.a(9004, -1, "nonetwork");
    this.jdField_a_of_type_Bevp.b(this.jdField_a_of_type_Bevp.jdField_a_of_type_Bhva, this.jdField_a_of_type_Bevp.jdField_a_of_type_Bhva);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.transfile.OldHttpEngine.OldHttpCommunicatorListner.2
 * JD-Core Version:    0.7.0.1
 */