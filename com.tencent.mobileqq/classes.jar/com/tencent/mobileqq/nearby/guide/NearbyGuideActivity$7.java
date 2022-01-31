package com.tencent.mobileqq.nearby.guide;

import android.os.Bundle;
import ausy;
import com.tencent.mobileqq.nearby.picbrowser.PicInfo;
import java.util.ArrayList;
import java.util.Iterator;

class NearbyGuideActivity$7
  implements Runnable
{
  NearbyGuideActivity$7(NearbyGuideActivity paramNearbyGuideActivity, ArrayList paramArrayList, ausy paramausy, Bundle paramBundle) {}
  
  public void run()
  {
    ArrayList localArrayList = new ArrayList();
    if ((this.jdField_a_of_type_JavaUtilArrayList != null) && (this.jdField_a_of_type_JavaUtilArrayList.size() > 0))
    {
      Iterator localIterator = this.jdField_a_of_type_JavaUtilArrayList.iterator();
      while (localIterator.hasNext())
      {
        Integer localInteger = (Integer)localIterator.next();
        PicInfo localPicInfo = new PicInfo();
        localPicInfo.a = localInteger.intValue();
        localArrayList.add(localPicInfo);
      }
    }
    this.jdField_a_of_type_Ausy.a(this.jdField_a_of_type_AndroidOsBundle, localArrayList, null, true, true, true, false);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.nearby.guide.NearbyGuideActivity.7
 * JD-Core Version:    0.7.0.1
 */