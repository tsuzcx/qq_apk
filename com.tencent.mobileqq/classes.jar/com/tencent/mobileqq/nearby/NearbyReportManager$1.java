package com.tencent.mobileqq.nearby;

import anzr;
import axqa;
import axqb;
import bkyb;
import java.util.ArrayList;

public class NearbyReportManager$1
  implements Runnable
{
  public NearbyReportManager$1(axqa paramaxqa, bkyb parambkyb, anzr paramanzr, boolean paramBoolean) {}
  
  public void run()
  {
    ArrayList localArrayList = new ArrayList();
    int i = 0;
    while (i < this.jdField_a_of_type_Bkyb.a())
    {
      localArrayList.add((axqb)this.jdField_a_of_type_Bkyb.a(i));
      i += 1;
    }
    this.jdField_a_of_type_Anzr.a(localArrayList, this.jdField_a_of_type_Boolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.nearby.NearbyReportManager.1
 * JD-Core Version:    0.7.0.1
 */