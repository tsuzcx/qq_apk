package com.tencent.mobileqq.magicface.model;

import awft;
import awfu;

public class MagicfaceDecoder$1
  implements Runnable
{
  public MagicfaceDecoder$1(awft paramawft) {}
  
  public void run()
  {
    int i = Thread.currentThread().getPriority();
    Thread.currentThread().setPriority(10);
    this.this$0.jdField_a_of_type_Boolean = true;
    if (this.this$0.jdField_a_of_type_Awfu != null) {
      this.this$0.jdField_a_of_type_Awfu.a();
    }
    this.this$0.a();
    this.this$0.jdField_a_of_type_Boolean = false;
    if (this.this$0.jdField_a_of_type_Awfu != null) {
      this.this$0.jdField_a_of_type_Awfu.b();
    }
    Thread.currentThread().setPriority(i);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.magicface.model.MagicfaceDecoder.1
 * JD-Core Version:    0.7.0.1
 */