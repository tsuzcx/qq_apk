package com.tencent.mobileqq.troop.utils;

import bahf;
import bahg;
import baro;

public class AIOAnimationControlManager$10$1
  implements Runnable
{
  public AIOAnimationControlManager$10$1(bahg parambahg) {}
  
  public void run()
  {
    try
    {
      if (this.a.jdField_a_of_type_Bahf.jdField_a_of_type_Baro != null) {
        this.a.jdField_a_of_type_Bahf.jdField_a_of_type_Baro.b();
      }
      label26:
      this.a.jdField_a_of_type_Bahf.jdField_a_of_type_Int = 1;
      this.a.jdField_a_of_type_Bahf.a(this.a.jdField_a_of_type_Boolean);
      return;
    }
    catch (Throwable localThrowable)
    {
      break label26;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.troop.utils.AIOAnimationControlManager.10.1
 * JD-Core Version:    0.7.0.1
 */