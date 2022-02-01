package com.tencent.mobileqq.transfile;

import beum;
import bevo;
import bevp;
import bews;
import com.tencent.qphone.base.util.QLog;
import java.util.concurrent.atomic.AtomicBoolean;

public class OldHttpEngine$OldHttpCommunicatorListner$1
  implements Runnable
{
  public OldHttpEngine$OldHttpCommunicatorListner$1(bevp parambevp, beum parambeum) {}
  
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
    this.jdField_a_of_type_Bevp.jdField_a_of_type_Bevo.a(this.jdField_a_of_type_Bevp.jdField_a_of_type_Beum, false);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.transfile.OldHttpEngine.OldHttpCommunicatorListner.1
 * JD-Core Version:    0.7.0.1
 */