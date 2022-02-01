package com.tencent.mobileqq.nearby;

import aodb;
import axwq;
import axwr;
import blgz;
import java.util.ArrayList;

public class NearbyReportManager$1
  implements Runnable
{
  public NearbyReportManager$1(axwq paramaxwq, blgz paramblgz, aodb paramaodb, boolean paramBoolean) {}
  
  public void run()
  {
    ArrayList localArrayList = new ArrayList();
    int i = 0;
    while (i < this.jdField_a_of_type_Blgz.a())
    {
      localArrayList.add((axwr)this.jdField_a_of_type_Blgz.a(i));
      i += 1;
    }
    this.jdField_a_of_type_Aodb.a(localArrayList, this.jdField_a_of_type_Boolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.nearby.NearbyReportManager.1
 * JD-Core Version:    0.7.0.1
 */