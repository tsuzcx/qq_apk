package com.tencent.qqmini.sdk.core.manager;

import bgnz;

public class ThreadManager$Job
  implements Runnable
{
  private bgnz jdField_a_of_type_Bgnz;
  private Runnable jdField_a_of_type_JavaLangRunnable;
  
  public ThreadManager$Job(Runnable paramRunnable, bgnz parambgnz)
  {
    this.jdField_a_of_type_JavaLangRunnable = paramRunnable;
    this.jdField_a_of_type_Bgnz = parambgnz;
  }
  
  public void run()
  {
    if (this.jdField_a_of_type_Bgnz != null) {
      this.jdField_a_of_type_Bgnz.a();
    }
    if (this.jdField_a_of_type_JavaLangRunnable != null) {
      this.jdField_a_of_type_JavaLangRunnable.run();
    }
    if (this.jdField_a_of_type_Bgnz != null) {
      this.jdField_a_of_type_Bgnz.b();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.qqmini.sdk.core.manager.ThreadManager.Job
 * JD-Core Version:    0.7.0.1
 */