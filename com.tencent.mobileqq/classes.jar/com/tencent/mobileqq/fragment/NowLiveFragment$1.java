package com.tencent.mobileqq.fragment;

import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.soso.location.SosoInterfaceOnLocationListener;
import com.tencent.mobileqq.soso.location.data.SosoLbsInfo;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;

class NowLiveFragment$1
  extends SosoInterfaceOnLocationListener
{
  NowLiveFragment$1(NowLiveFragment paramNowLiveFragment, int paramInt, boolean paramBoolean1, boolean paramBoolean2, long paramLong, boolean paramBoolean3, boolean paramBoolean4, String paramString)
  {
    super(paramInt, paramBoolean1, paramBoolean2, paramLong, paramBoolean3, paramBoolean4, paramString);
  }
  
  public void onLocationFinish(int paramInt, SosoLbsInfo paramSosoLbsInfo)
  {
    if (paramInt != 0)
    {
      QQToast.makeText(this.a.ag, 1, HardCodeUtil.a(2131905487), 1).show();
      this.a.h();
    }
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("startLocation finish");
      localStringBuilder.append(System.currentTimeMillis());
      QLog.d("NowLiveFragment", 2, localStringBuilder.toString());
    }
    this.a.a(paramSosoLbsInfo);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.mobileqq.fragment.NowLiveFragment.1
 * JD-Core Version:    0.7.0.1
 */