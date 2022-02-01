package com.tencent.mobileqq.nearby.guide;

import android.os.Bundle;
import com.tencent.mobileqq.nearby.business.INearbyCardHandler;
import com.tencent.mobileqq.picbrowser.PicInfo;
import java.util.ArrayList;
import java.util.Iterator;

class NearbyGuideActivity$7
  implements Runnable
{
  NearbyGuideActivity$7(NearbyGuideActivity paramNearbyGuideActivity, ArrayList paramArrayList, INearbyCardHandler paramINearbyCardHandler, Bundle paramBundle) {}
  
  public void run()
  {
    ArrayList localArrayList = new ArrayList();
    Object localObject = this.a;
    if ((localObject != null) && (((ArrayList)localObject).size() > 0))
    {
      localObject = this.a.iterator();
      while (((Iterator)localObject).hasNext())
      {
        Integer localInteger = (Integer)((Iterator)localObject).next();
        PicInfo localPicInfo = new PicInfo();
        localPicInfo.a = localInteger.intValue();
        localArrayList.add(localPicInfo);
      }
    }
    this.b.a(this.c, localArrayList, null, true, true, true, false);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.mobileqq.nearby.guide.NearbyGuideActivity.7
 * JD-Core Version:    0.7.0.1
 */