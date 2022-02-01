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
    long l = System.currentTimeMillis() - this.a;
    this.b.l.removeMessages(7);
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
    localStringBuilder.append(this.b.L);
    QLog.d("nearby.NearbyHybridFragment.webloading", 1, localStringBuilder.toString());
    if ((paramInt == 0) && (paramSosoLbsInfo != null))
    {
      NearbyHybridFragment.h = System.currentTimeMillis();
      NearbyHybridFragment.g = paramSosoLbsInfo;
      ((INearbySPUtil)QRoute.api(INearbySPUtil.class)).setNearbyLastLocation(this.b.k.getCurrentAccountUin(), paramSosoLbsInfo);
      if (!this.b.L) {
        this.b.d();
      } else {
        this.b.a(paramSosoLbsInfo);
      }
      this.b.a(true, paramInt, l);
      return;
    }
    this.b.a(false, paramInt, l);
    if (this.b.L) {
      return;
    }
    if (NetworkUtil.isNetworkAvailable(BaseApplicationImpl.getContext())) {
      QQToast.makeText(this.b.ag, 1, HardCodeUtil.a(2131905056), 1).show();
    }
    this.b.l.removeMessages(3);
    paramSosoLbsInfo = this.b;
    paramSosoLbsInfo.I = 1;
    paramSosoLbsInfo.l.sendEmptyMessage(5);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.mobileqq.fragment.NearbyHybridFragment.3
 * JD-Core Version:    0.7.0.1
 */