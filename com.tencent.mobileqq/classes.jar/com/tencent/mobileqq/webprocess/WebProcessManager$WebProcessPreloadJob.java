package com.tencent.mobileqq.webprocess;

import bide;
import java.lang.ref.WeakReference;
import java.util.concurrent.atomic.AtomicBoolean;

class WebProcessManager$WebProcessPreloadJob
  implements Runnable
{
  int jdField_a_of_type_Int;
  WeakReference<bide> jdField_a_of_type_JavaLangRefWeakReference;
  
  WebProcessManager$WebProcessPreloadJob(int paramInt, bide parambide)
  {
    this.jdField_a_of_type_Int = paramInt;
    this.jdField_a_of_type_JavaLangRefWeakReference = new WeakReference(parambide);
  }
  
  public void run()
  {
    bide localbide = (bide)this.jdField_a_of_type_JavaLangRefWeakReference.get();
    if (!WebProcessManager.c())
    {
      WebProcessManager.b(true);
      WebProcessManager.a(false);
      WebProcessManager.b(this.jdField_a_of_type_Int);
      if (localbide != null) {
        localbide.onResult(true);
      }
    }
    for (;;)
    {
      WebProcessManager.a().set(false);
      return;
      if (localbide != null) {
        localbide.onResult(false);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.webprocess.WebProcessManager.WebProcessPreloadJob
 * JD-Core Version:    0.7.0.1
 */