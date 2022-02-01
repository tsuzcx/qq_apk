package com.tencent.mobileqq.troop.activity;

import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.soso.location.SosoInterfaceOnLocationListener;
import com.tencent.mobileqq.soso.location.data.SosoLbsInfo;
import com.tencent.mobileqq.soso.location.data.SosoLocation;
import com.tencent.mobileqq.troop.utils.HttpWebCgiAsyncTask.Callback;
import com.tencent.qphone.base.util.QLog;

class AbsPublishActivity$13
  extends SosoInterfaceOnLocationListener
{
  AbsPublishActivity$13(AbsPublishActivity paramAbsPublishActivity, int paramInt, boolean paramBoolean1, boolean paramBoolean2, long paramLong, boolean paramBoolean3, boolean paramBoolean4, String paramString, BaseActivity paramBaseActivity, HttpWebCgiAsyncTask.Callback paramCallback)
  {
    super(paramInt, paramBoolean1, paramBoolean2, paramLong, paramBoolean3, paramBoolean4, paramString);
  }
  
  public void onLocationFinish(int paramInt, SosoLbsInfo paramSosoLbsInfo)
  {
    if (QLog.isColorLevel()) {
      QLog.d("IphoneTitleBarActivity", 2, "onLocationFinish() errCode=" + paramInt);
    }
    if ((paramInt == 0) && (paramSosoLbsInfo != null) && (paramSosoLbsInfo.mLocation != null))
    {
      double d1 = paramSosoLbsInfo.mLocation.mLat02;
      double d2 = paramSosoLbsInfo.mLocation.mLon02;
      TroopBarPublishLocationSelectActivity.a(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity, (int)(d1 * 1000000.0D), (int)(d2 * 1000000.0D), 0, true, this.jdField_a_of_type_ComTencentMobileqqTroopUtilsHttpWebCgiAsyncTask$Callback);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.troop.activity.AbsPublishActivity.13
 * JD-Core Version:    0.7.0.1
 */