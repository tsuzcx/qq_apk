package com.tencent.mobileqq.webprocess;

import bcay;
import java.lang.ref.WeakReference;
import java.util.concurrent.atomic.AtomicBoolean;

class WebProcessManager$WebProcessPreloadJob
  implements Runnable
{
  int jdField_a_of_type_Int;
  WeakReference<bcay> jdField_a_of_type_JavaLangRefWeakReference;
  
  WebProcessManager$WebProcessPreloadJob(int paramInt, bcay parambcay)
  {
    this.jdField_a_of_type_Int = paramInt;
    this.jdField_a_of_type_JavaLangRefWeakReference = new WeakReference(parambcay);
  }
  
  public void run()
  {
    bcay localbcay = (bcay)this.jdField_a_of_type_JavaLangRefWeakReference.get();
    if (!WebProcessManager.c())
    {
      WebProcessManager.b(true);
      WebProcessManager.a(false);
      WebProcessManager.b(this.jdField_a_of_type_Int);
      if (localbcay != null) {
        localbcay.a(true);
      }
    }
    for (;;)
    {
      WebProcessManager.a().set(false);
      return;
      if (localbcay != null) {
        localbcay.a(false);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.mobileqq.webprocess.WebProcessManager.WebProcessPreloadJob
 * JD-Core Version:    0.7.0.1
 */