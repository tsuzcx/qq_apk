package com.tencent.mobileqq.nearby;

import amxd;
import awjy;
import awjz;
import bjmo;
import java.util.ArrayList;

public class NearbyReportManager$1
  implements Runnable
{
  public NearbyReportManager$1(awjy paramawjy, bjmo parambjmo, amxd paramamxd, boolean paramBoolean) {}
  
  public void run()
  {
    ArrayList localArrayList = new ArrayList();
    int i = 0;
    while (i < this.jdField_a_of_type_Bjmo.a())
    {
      localArrayList.add((awjz)this.jdField_a_of_type_Bjmo.a(i));
      i += 1;
    }
    this.jdField_a_of_type_Amxd.a(localArrayList, this.jdField_a_of_type_Boolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.nearby.NearbyReportManager.1
 * JD-Core Version:    0.7.0.1
 */