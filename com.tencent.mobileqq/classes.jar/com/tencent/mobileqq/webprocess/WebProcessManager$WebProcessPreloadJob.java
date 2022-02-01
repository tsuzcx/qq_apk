package com.tencent.mobileqq.webprocess;

import bimf;
import java.lang.ref.WeakReference;
import java.util.concurrent.atomic.AtomicBoolean;

class WebProcessManager$WebProcessPreloadJob
  implements Runnable
{
  int jdField_a_of_type_Int;
  WeakReference<bimf> jdField_a_of_type_JavaLangRefWeakReference;
  
  WebProcessManager$WebProcessPreloadJob(int paramInt, bimf parambimf)
  {
    this.jdField_a_of_type_Int = paramInt;
    this.jdField_a_of_type_JavaLangRefWeakReference = new WeakReference(parambimf);
  }
  
  public void run()
  {
    bimf localbimf = (bimf)this.jdField_a_of_type_JavaLangRefWeakReference.get();
    if (!WebProcessManager.c())
    {
      WebProcessManager.b(true);
      WebProcessManager.a(false);
      WebProcessManager.b(this.jdField_a_of_type_Int);
      if (localbimf != null) {
        localbimf.a(true);
      }
    }
    for (;;)
    {
      WebProcessManager.a().set(false);
      return;
      if (localbimf != null) {
        localbimf.a(false);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.webprocess.WebProcessManager.WebProcessPreloadJob
 * JD-Core Version:    0.7.0.1
 */