package com.tencent.mobileqq.fragment;

import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.soso.location.SosoInterfaceOnLocationListener;
import com.tencent.mobileqq.soso.location.data.SosoLbsInfo;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;

class CommonTabFragment$1
  extends SosoInterfaceOnLocationListener
{
  CommonTabFragment$1(CommonTabFragment paramCommonTabFragment, int paramInt, boolean paramBoolean1, boolean paramBoolean2, long paramLong, boolean paramBoolean3, boolean paramBoolean4, String paramString)
  {
    super(paramInt, paramBoolean1, paramBoolean2, paramLong, paramBoolean3, paramBoolean4, paramString);
  }
  
  public void onLocationFinish(int paramInt, SosoLbsInfo paramSosoLbsInfo)
  {
    if (QLog.isColorLevel()) {
      QLog.d("CommonTabFragment", 2, "startLocation finish" + System.currentTimeMillis());
    }
    if (paramInt != 0)
    {
      QQToast.a(this.a.a, 1, HardCodeUtil.a(2131702302), 1).a();
      this.a.e();
      return;
    }
    this.a.a(paramSosoLbsInfo);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.fragment.CommonTabFragment.1
 * JD-Core Version:    0.7.0.1
 */