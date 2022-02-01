package com.tencent.mobileqq.fragment;

import android.os.Handler;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.nearby.NearbyAppInterface;
import com.tencent.mobileqq.nearby.NearbySPUtil;
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
    StringBuilder localStringBuilder = new StringBuilder().append("onLocationFinish, errCode=").append(paramInt).append(", timeCost=").append(l).append(", info==null?");
    if (paramSosoLbsInfo == null) {}
    for (boolean bool = true;; bool = false)
    {
      QLog.d("nearby.NearbyHybridFragment.webloading", 1, bool + ", isTimeOut=" + this.jdField_a_of_type_ComTencentMobileqqFragmentNearbyHybridFragment.m);
      if ((paramInt == 0) && (paramSosoLbsInfo != null)) {
        break label188;
      }
      this.jdField_a_of_type_ComTencentMobileqqFragmentNearbyHybridFragment.a(false, paramInt, l);
      if (!this.jdField_a_of_type_ComTencentMobileqqFragmentNearbyHybridFragment.m) {
        break;
      }
      return;
    }
    if (NetworkUtil.g(BaseApplicationImpl.getContext())) {
      QQToast.a(this.jdField_a_of_type_ComTencentMobileqqFragmentNearbyHybridFragment.jdField_a_of_type_ComTencentMobileqqAppIphoneTitleBarActivity, 1, HardCodeUtil.a(2131707200), 1).a();
    }
    this.jdField_a_of_type_ComTencentMobileqqFragmentNearbyHybridFragment.jdField_a_of_type_AndroidOsHandler.removeMessages(3);
    this.jdField_a_of_type_ComTencentMobileqqFragmentNearbyHybridFragment.d = 1;
    this.jdField_a_of_type_ComTencentMobileqqFragmentNearbyHybridFragment.jdField_a_of_type_AndroidOsHandler.sendEmptyMessage(5);
    return;
    label188:
    NearbyHybridFragment.jdField_a_of_type_Long = System.currentTimeMillis();
    NearbyHybridFragment.jdField_a_of_type_ComTencentMobileqqSosoLocationDataSosoLbsInfo = paramSosoLbsInfo;
    NearbySPUtil.a(this.jdField_a_of_type_ComTencentMobileqqFragmentNearbyHybridFragment.jdField_a_of_type_ComTencentMobileqqNearbyNearbyAppInterface.getCurrentAccountUin(), paramSosoLbsInfo);
    if (!this.jdField_a_of_type_ComTencentMobileqqFragmentNearbyHybridFragment.m) {
      this.jdField_a_of_type_ComTencentMobileqqFragmentNearbyHybridFragment.e();
    }
    for (;;)
    {
      this.jdField_a_of_type_ComTencentMobileqqFragmentNearbyHybridFragment.a(true, paramInt, l);
      return;
      this.jdField_a_of_type_ComTencentMobileqqFragmentNearbyHybridFragment.a(paramSosoLbsInfo);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.fragment.NearbyHybridFragment.3
 * JD-Core Version:    0.7.0.1
 */