package com.tencent.mobileqq.troop.utils;

import bfos;
import bfot;
import bfzc;

public class AIOAnimationControlManager$10$1
  implements Runnable
{
  public AIOAnimationControlManager$10$1(bfot parambfot) {}
  
  public void run()
  {
    try
    {
      if (this.a.jdField_a_of_type_Bfos.jdField_a_of_type_Bfzc != null) {
        this.a.jdField_a_of_type_Bfos.jdField_a_of_type_Bfzc.b();
      }
      label26:
      this.a.jdField_a_of_type_Bfos.jdField_a_of_type_Int = 1;
      this.a.jdField_a_of_type_Bfos.a(this.a.jdField_a_of_type_Boolean);
      return;
    }
    catch (Throwable localThrowable)
    {
      break label26;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.troop.utils.AIOAnimationControlManager.10.1
 * JD-Core Version:    0.7.0.1
 */