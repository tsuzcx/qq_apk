package com.tencent.mobileqq.fragment;

import com.tencent.biz.ui.RefreshView;
import com.tencent.biz.ui.RefreshView.OnRefreshListener;
import com.tencent.mobileqq.app.NearbyHandler;
import com.tencent.mobileqq.nearby.NearbyConstants;
import com.tencent.mobileqq.nearby.api.INearbyAppInterface;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.soso.location.api.ISosoInterfaceApi;
import com.tencent.mobileqq.soso.location.data.SosoLbsInfo;
import com.tencent.mobileqq.soso.location.data.SosoLocation;
import com.tencent.qphone.base.util.QLog;

class NearbyHybridFragment$8
  implements RefreshView.OnRefreshListener
{
  NearbyHybridFragment$8(NearbyHybridFragment paramNearbyHybridFragment) {}
  
  public void a()
  {
    if (QLog.isColorLevel()) {
      QLog.d("nearby.NearbyHybridFragment", 2, "onRefresh");
    }
    this.a.f();
    SosoLbsInfo localSosoLbsInfo2 = NearbyHybridFragment.jdField_a_of_type_ComTencentMobileqqSosoLocationDataSosoLbsInfo;
    SosoLbsInfo localSosoLbsInfo1 = localSosoLbsInfo2;
    if (localSosoLbsInfo2 == null) {
      localSosoLbsInfo1 = ((ISosoInterfaceApi)QRoute.api(ISosoInterfaceApi.class)).getSosoInfo();
    }
    if (localSosoLbsInfo1 != null) {
      ((NearbyHandler)this.a.jdField_a_of_type_ComTencentMobileqqNearbyApiINearbyAppInterface.getBusinessHandler(NearbyConstants.a)).a((float)localSosoLbsInfo1.mLocation.mLon02, (float)localSosoLbsInfo1.mLocation.mLat02, 5);
    }
    this.a.jdField_a_of_type_ComTencentBizUiRefreshView.b();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.tencent.mobileqq.fragment.NearbyHybridFragment.8
 * JD-Core Version:    0.7.0.1
 */