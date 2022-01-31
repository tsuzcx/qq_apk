package com.tencent.mobileqq.nearby;

import alta;
import ausf;
import ausg;
import bhod;
import java.util.ArrayList;

public class NearbyReportManager$1
  implements Runnable
{
  public NearbyReportManager$1(ausf paramausf, bhod parambhod, alta paramalta, boolean paramBoolean) {}
  
  public void run()
  {
    ArrayList localArrayList = new ArrayList();
    int i = 0;
    while (i < this.jdField_a_of_type_Bhod.a())
    {
      localArrayList.add((ausg)this.jdField_a_of_type_Bhod.a(i));
      i += 1;
    }
    this.jdField_a_of_type_Alta.a(localArrayList, this.jdField_a_of_type_Boolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.nearby.NearbyReportManager.1
 * JD-Core Version:    0.7.0.1
 */