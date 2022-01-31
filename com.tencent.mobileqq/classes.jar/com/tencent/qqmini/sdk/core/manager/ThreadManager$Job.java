package com.tencent.qqmini.sdk.core.manager;

import bgjs;

public class ThreadManager$Job
  implements Runnable
{
  private bgjs jdField_a_of_type_Bgjs;
  private Runnable jdField_a_of_type_JavaLangRunnable;
  
  public ThreadManager$Job(Runnable paramRunnable, bgjs parambgjs)
  {
    this.jdField_a_of_type_JavaLangRunnable = paramRunnable;
    this.jdField_a_of_type_Bgjs = parambgjs;
  }
  
  public void run()
  {
    if (this.jdField_a_of_type_Bgjs != null) {
      this.jdField_a_of_type_Bgjs.a();
    }
    if (this.jdField_a_of_type_JavaLangRunnable != null) {
      this.jdField_a_of_type_JavaLangRunnable.run();
    }
    if (this.jdField_a_of_type_Bgjs != null) {
      this.jdField_a_of_type_Bgjs.b();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.qqmini.sdk.core.manager.ThreadManager.Job
 * JD-Core Version:    0.7.0.1
 */