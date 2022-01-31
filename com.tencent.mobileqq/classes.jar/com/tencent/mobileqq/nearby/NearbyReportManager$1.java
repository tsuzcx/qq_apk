package com.tencent.mobileqq.nearby;

import akbm;
import atbe;
import atbf;
import bfms;
import java.util.ArrayList;

public class NearbyReportManager$1
  implements Runnable
{
  public NearbyReportManager$1(atbe paramatbe, bfms parambfms, akbm paramakbm, boolean paramBoolean) {}
  
  public void run()
  {
    ArrayList localArrayList = new ArrayList();
    int i = 0;
    while (i < this.jdField_a_of_type_Bfms.a())
    {
      localArrayList.add((atbf)this.jdField_a_of_type_Bfms.a(i));
      i += 1;
    }
    this.jdField_a_of_type_Akbm.a(localArrayList, this.jdField_a_of_type_Boolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.nearby.NearbyReportManager.1
 * JD-Core Version:    0.7.0.1
 */