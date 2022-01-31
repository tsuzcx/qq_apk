package com.tencent.mobileqq.troop.utils;

import bcfr;
import bcfs;
import bcqi;

public class AIOAnimationControlManager$10$1
  implements Runnable
{
  public AIOAnimationControlManager$10$1(bcfs parambcfs) {}
  
  public void run()
  {
    try
    {
      if (this.a.jdField_a_of_type_Bcfr.jdField_a_of_type_Bcqi != null) {
        this.a.jdField_a_of_type_Bcfr.jdField_a_of_type_Bcqi.b();
      }
      label26:
      this.a.jdField_a_of_type_Bcfr.jdField_a_of_type_Int = 1;
      this.a.jdField_a_of_type_Bcfr.a(this.a.jdField_a_of_type_Boolean);
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