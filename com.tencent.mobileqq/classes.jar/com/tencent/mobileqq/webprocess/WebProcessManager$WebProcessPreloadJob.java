package com.tencent.mobileqq.webprocess;

import bdzz;
import java.lang.ref.WeakReference;
import java.util.concurrent.atomic.AtomicBoolean;

class WebProcessManager$WebProcessPreloadJob
  implements Runnable
{
  int jdField_a_of_type_Int;
  WeakReference<bdzz> jdField_a_of_type_JavaLangRefWeakReference;
  
  WebProcessManager$WebProcessPreloadJob(int paramInt, bdzz parambdzz)
  {
    this.jdField_a_of_type_Int = paramInt;
    this.jdField_a_of_type_JavaLangRefWeakReference = new WeakReference(parambdzz);
  }
  
  public void run()
  {
    bdzz localbdzz = (bdzz)this.jdField_a_of_type_JavaLangRefWeakReference.get();
    if (!WebProcessManager.c())
    {
      WebProcessManager.b(true);
      WebProcessManager.a(false);
      WebProcessManager.b(this.jdField_a_of_type_Int);
      if (localbdzz != null) {
        localbdzz.a(true);
      }
    }
    for (;;)
    {
      WebProcessManager.a().set(false);
      return;
      if (localbdzz != null) {
        localbdzz.a(false);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.webprocess.WebProcessManager.WebProcessPreloadJob
 * JD-Core Version:    0.7.0.1
 */