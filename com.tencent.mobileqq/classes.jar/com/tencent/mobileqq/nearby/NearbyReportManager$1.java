package com.tencent.mobileqq.nearby;

import anqv;
import axdx;
import axdy;
import bkfu;
import java.util.ArrayList;

public class NearbyReportManager$1
  implements Runnable
{
  public NearbyReportManager$1(axdx paramaxdx, bkfu parambkfu, anqv paramanqv, boolean paramBoolean) {}
  
  public void run()
  {
    ArrayList localArrayList = new ArrayList();
    int i = 0;
    while (i < this.jdField_a_of_type_Bkfu.a())
    {
      localArrayList.add((axdy)this.jdField_a_of_type_Bkfu.a(i));
      i += 1;
    }
    this.jdField_a_of_type_Anqv.a(localArrayList, this.jdField_a_of_type_Boolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.nearby.NearbyReportManager.1
 * JD-Core Version:    0.7.0.1
 */