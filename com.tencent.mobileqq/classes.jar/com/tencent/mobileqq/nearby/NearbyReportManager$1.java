package com.tencent.mobileqq.nearby;

import com.tencent.mobileqq.app.NearbyHandler;
import com.tencent.util.LongSparseArray;
import java.util.ArrayList;

class NearbyReportManager$1
  implements Runnable
{
  NearbyReportManager$1(NearbyReportManager paramNearbyReportManager, LongSparseArray paramLongSparseArray, NearbyHandler paramNearbyHandler, boolean paramBoolean) {}
  
  public void run()
  {
    ArrayList localArrayList = new ArrayList();
    int i = 0;
    while (i < this.jdField_a_of_type_ComTencentUtilLongSparseArray.a())
    {
      localArrayList.add((ReportRecord)this.jdField_a_of_type_ComTencentUtilLongSparseArray.a(i));
      i += 1;
    }
    this.jdField_a_of_type_ComTencentMobileqqAppNearbyHandler.a(localArrayList, this.jdField_a_of_type_Boolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.mobileqq.nearby.NearbyReportManager.1
 * JD-Core Version:    0.7.0.1
 */