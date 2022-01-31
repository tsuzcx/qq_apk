package com.tencent.mobileqq.transfile;

import baps;
import baqy;
import baqz;
import basj;
import com.tencent.qphone.base.util.QLog;
import java.util.concurrent.atomic.AtomicBoolean;

public class OldHttpEngine$OldHttpCommunicatorListner$1
  implements Runnable
{
  public OldHttpEngine$OldHttpCommunicatorListner$1(baqz parambaqz, baps parambaps) {}
  
  public void run()
  {
    boolean bool = true;
    int i;
    if ((QLog.isColorLevel()) && (this.jdField_a_of_type_Baps != null))
    {
      i = this.jdField_a_of_type_Baps.g;
      if (this.jdField_a_of_type_Baps.a != 1) {
        break label94;
      }
    }
    for (;;)
    {
      basj.a(i, bool, this.jdField_a_of_type_Baps.f, this.jdField_a_of_type_Baps.e, "scheduleRetry", "mIsCancelled:" + this.jdField_a_of_type_Baqz.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean);
      if (!this.jdField_a_of_type_Baqz.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean.get()) {
        break;
      }
      return;
      label94:
      bool = false;
    }
    this.jdField_a_of_type_Baqz.jdField_a_of_type_Baqy.c(this.jdField_a_of_type_Baqz.jdField_a_of_type_Baps);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.transfile.OldHttpEngine.OldHttpCommunicatorListner.1
 * JD-Core Version:    0.7.0.1
 */