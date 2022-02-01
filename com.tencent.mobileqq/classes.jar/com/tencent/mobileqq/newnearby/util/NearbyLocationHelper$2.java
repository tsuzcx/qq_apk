package com.tencent.mobileqq.newnearby.util;

import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.activity.NearbyActivity;
import com.tencent.mobileqq.app.QBaseActivity;
import com.tencent.mobileqq.nearby.api.INearbySPUtil;
import com.tencent.mobileqq.newnearby.hippy.NearbyHippyCallback;
import com.tencent.mobileqq.newnearby.impl.NearbyReportHelperImpl;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.soso.location.SosoInterfaceOnLocationListener;
import com.tencent.mobileqq.soso.location.data.SosoLbsInfo;
import com.tencent.mtt.hippy.modules.Promise;
import com.tencent.qphone.base.util.QLog;

final class NearbyLocationHelper$2
  extends SosoInterfaceOnLocationListener
{
  NearbyLocationHelper$2(int paramInt, boolean paramBoolean1, boolean paramBoolean2, long paramLong, boolean paramBoolean3, boolean paramBoolean4, String paramString, Promise paramPromise)
  {
    super(paramInt, paramBoolean1, paramBoolean2, paramLong, paramBoolean3, paramBoolean4, paramString);
  }
  
  public void onLocationFinish(int paramInt, SosoLbsInfo paramSosoLbsInfo)
  {
    if ((paramInt == 0) && (paramSosoLbsInfo != null))
    {
      NearbyLocationHelper.a(paramSosoLbsInfo);
      ((INearbySPUtil)QRoute.api(INearbySPUtil.class)).setNearbyLastLocation(NearbyLocationHelper.a().getCurrentAccountUin(), paramSosoLbsInfo);
      if (NearbyLocationHelper.b().mLocation != null)
      {
        NearbyHippyCallback.a(this.a, NearbyLocationHelper.b());
        paramSosoLbsInfo = QBaseActivity.sTopActivity;
        if ((paramSosoLbsInfo instanceof NearbyActivity)) {
          NearbyReportHelperImpl.reportRequestLocation((NearbyActivity)paramSosoLbsInfo, true, true);
        }
      }
      else
      {
        QLog.d("NearbyLocationImpl", 2, "requestLBS: location info is null");
        this.a.reject("location info is null");
      }
    }
    else
    {
      QLog.d("NearbyLocationImpl", 2, "ISosoInterfaceApi location fail");
      this.a.reject("ISosoInterfaceApi location fail");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.mobileqq.newnearby.util.NearbyLocationHelper.2
 * JD-Core Version:    0.7.0.1
 */