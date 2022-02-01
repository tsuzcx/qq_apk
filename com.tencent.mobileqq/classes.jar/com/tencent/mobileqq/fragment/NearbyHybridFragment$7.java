package com.tencent.mobileqq.fragment;

import com.tencent.mobileqq.app.NearbyHandler;
import com.tencent.mobileqq.nearby.NearbyConstants;
import com.tencent.mobileqq.nearby.api.INearbyAppInterface;
import com.tencent.mobileqq.soso.location.data.SosoLbsInfo;
import com.tencent.mobileqq.soso.location.data.SosoLocation;

class NearbyHybridFragment$7
  implements Runnable
{
  NearbyHybridFragment$7(NearbyHybridFragment paramNearbyHybridFragment) {}
  
  public void run()
  {
    ((NearbyHandler)this.this$0.k.getBusinessHandler(NearbyConstants.a)).a((float)NearbyHybridFragment.g.mLocation.mLon02, (float)NearbyHybridFragment.g.mLocation.mLat02, 5);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.mobileqq.fragment.NearbyHybridFragment.7
 * JD-Core Version:    0.7.0.1
 */