package com.tencent.mobileqq.magicface.model;

import avls;
import avlt;

public class MagicfaceDecoder$1
  implements Runnable
{
  public MagicfaceDecoder$1(avls paramavls) {}
  
  public void run()
  {
    int i = Thread.currentThread().getPriority();
    Thread.currentThread().setPriority(10);
    this.this$0.jdField_a_of_type_Boolean = true;
    if (this.this$0.jdField_a_of_type_Avlt != null) {
      this.this$0.jdField_a_of_type_Avlt.a();
    }
    this.this$0.a();
    this.this$0.jdField_a_of_type_Boolean = false;
    if (this.this$0.jdField_a_of_type_Avlt != null) {
      this.this$0.jdField_a_of_type_Avlt.b();
    }
    Thread.currentThread().setPriority(i);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.magicface.model.MagicfaceDecoder.1
 * JD-Core Version:    0.7.0.1
 */