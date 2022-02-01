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
    ((NearbyHandler)this.this$0.jdField_a_of_type_ComTencentMobileqqNearbyApiINearbyAppInterface.getBusinessHandler(NearbyConstants.a)).a((float)NearbyHybridFragment.jdField_a_of_type_ComTencentMobileqqSosoLocationDataSosoLbsInfo.mLocation.mLon02, (float)NearbyHybridFragment.jdField_a_of_type_ComTencentMobileqqSosoLocationDataSosoLbsInfo.mLocation.mLat02, 5);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.tencent.mobileqq.fragment.NearbyHybridFragment.7
 * JD-Core Version:    0.7.0.1
 */