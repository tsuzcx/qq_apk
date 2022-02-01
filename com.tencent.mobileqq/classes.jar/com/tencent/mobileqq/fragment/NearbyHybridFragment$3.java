package com.tencent.mobileqq.fragment;

import android.os.Handler;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.nearby.api.INearbyAppInterface;
import com.tencent.mobileqq.nearby.api.INearbySPUtil;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.soso.location.SosoInterfaceOnLocationListener;
import com.tencent.mobileqq.soso.location.data.SosoLbsInfo;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;

class NearbyHybridFragment$3
  extends SosoInterfaceOnLocationListener
{
  NearbyHybridFragment$3(NearbyHybridFragment paramNearbyHybridFragment, int paramInt, boolean paramBoolean1, boolean paramBoolean2, long paramLong1, boolean paramBoolean3, boolean paramBoolean4, String paramString, long paramLong2)
  {
    super(paramInt, paramBoolean1, paramBoolean2, paramLong1, paramBoolean3, paramBoolean4, paramString);
  }
  
  public void onLocationFinish(int paramInt, SosoLbsInfo paramSosoLbsInfo)
  {
    long l = System.currentTimeMillis() - this.jdField_a_of_type_Long;
    this.jdField_a_of_type_ComTencentMobileqqFragmentNearbyHybridFragment.jdField_a_of_type_AndroidOsHandler.removeMessages(7);
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("onLocationFinish, errCode=");
    localStringBuilder.append(paramInt);
    localStringBuilder.append(", timeCost=");
    localStringBuilder.append(l);
    localStringBuilder.append(", info==null?");
    boolean bool;
    if (paramSosoLbsInfo == null) {
      bool = true;
    } else {
      bool = false;
    }
    localStringBuilder.append(bool);
    localStringBuilder.append(", isTimeOut=");
    localStringBuilder.append(this.jdField_a_of_type_ComTencentMobileqqFragmentNearbyHybridFragment.j);
    QLog.d("nearby.NearbyHybridFragment.webloading", 1, localStringBuilder.toString());
    if ((paramInt == 0) && (paramSosoLbsInfo != null))
    {
      NearbyHybridFragment.jdField_a_of_type_Long = System.currentTimeMillis();
      NearbyHybridFragment.jdField_a_of_type_ComTencentMobileqqSosoLocationDataSosoLbsInfo = paramSosoLbsInfo;
      ((INearbySPUtil)QRoute.api(INearbySPUtil.class)).setNearbyLastLocation(this.jdField_a_of_type_ComTencentMobileqqFragmentNearbyHybridFragment.jdField_a_of_type_ComTencentMobileqqNearbyApiINearbyAppInterface.getCurrentAccountUin(), paramSosoLbsInfo);
      if (!this.jdField_a_of_type_ComTencentMobileqqFragmentNearbyHybridFragment.j) {
        this.jdField_a_of_type_ComTencentMobileqqFragmentNearbyHybridFragment.c();
      } else {
        this.jdField_a_of_type_ComTencentMobileqqFragmentNearbyHybridFragment.a(paramSosoLbsInfo);
      }
      this.jdField_a_of_type_ComTencentMobileqqFragmentNearbyHybridFragment.a(true, paramInt, l);
      return;
    }
    this.jdField_a_of_type_ComTencentMobileqqFragmentNearbyHybridFragment.a(false, paramInt, l);
    if (this.jdField_a_of_type_ComTencentMobileqqFragmentNearbyHybridFragment.j) {
      return;
    }
    if (NetworkUtil.isNetworkAvailable(BaseApplicationImpl.getContext())) {
      QQToast.a(this.jdField_a_of_type_ComTencentMobileqqFragmentNearbyHybridFragment.jdField_a_of_type_ComTencentMobileqqAppIphoneTitleBarActivity, 1, HardCodeUtil.a(2131707225), 1).a();
    }
    this.jdField_a_of_type_ComTencentMobileqqFragmentNearbyHybridFragment.jdField_a_of_type_AndroidOsHandler.removeMessages(3);
    paramSosoLbsInfo = this.jdField_a_of_type_ComTencentMobileqqFragmentNearbyHybridFragment;
    paramSosoLbsInfo.c = 1;
    paramSosoLbsInfo.jdField_a_of_type_AndroidOsHandler.sendEmptyMessage(5);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.tencent.mobileqq.fragment.NearbyHybridFragment.3
 * JD-Core Version:    0.7.0.1
 */