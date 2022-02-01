package com.tencent.mobileqq.troop.utils;

import bggl;
import bggm;
import bgrg;

public class AIOAnimationControlManager$10$1
  implements Runnable
{
  public AIOAnimationControlManager$10$1(bggm parambggm) {}
  
  public void run()
  {
    try
    {
      if (this.a.jdField_a_of_type_Bggl.jdField_a_of_type_Bgrg != null) {
        this.a.jdField_a_of_type_Bggl.jdField_a_of_type_Bgrg.b();
      }
      label26:
      this.a.jdField_a_of_type_Bggl.jdField_a_of_type_Int = 1;
      this.a.jdField_a_of_type_Bggl.a(this.a.jdField_a_of_type_Boolean);
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