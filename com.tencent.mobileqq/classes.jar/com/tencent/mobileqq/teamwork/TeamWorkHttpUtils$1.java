package com.tencent.mobileqq.teamwork;

import bece;
import java.util.TimerTask;

public final class TeamWorkHttpUtils$1
  extends TimerTask
{
  public TeamWorkHttpUtils$1(int[] paramArrayOfInt, bece parambece) {}
  
  public void run()
  {
    if (this.jdField_a_of_type_ArrayOfInt[0] >= 99)
    {
      this.jdField_a_of_type_Bece.notifyUI(4, true, new Object[] { Integer.valueOf(99) });
      return;
    }
    int[] arrayOfInt = this.jdField_a_of_type_ArrayOfInt;
    arrayOfInt[0] += 2;
    this.jdField_a_of_type_Bece.notifyUI(4, true, new Object[] { Integer.valueOf(this.jdField_a_of_type_ArrayOfInt[0]) });
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.teamwork.TeamWorkHttpUtils.1
 * JD-Core Version:    0.7.0.1
 */