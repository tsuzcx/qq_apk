package com.tencent.mobileqq.intervideo.groupvideo.pluginimpl;

import android.os.Bundle;
import com.tencent.mobileqq.soso.location.LbsManagerServiceOnLocationChangeListener;
import com.tencent.mobileqq.soso.location.data.SosoLbsInfo;
import com.tencent.mobileqq.soso.location.data.SosoLocation;
import com.tencent.qphone.base.util.QLog;
import java.util.concurrent.CountDownLatch;

class IVCommonInterfaceImpl$1$1
  extends LbsManagerServiceOnLocationChangeListener
{
  IVCommonInterfaceImpl$1$1(IVCommonInterfaceImpl.1 param1, String paramString, Bundle[] paramArrayOfBundle, CountDownLatch paramCountDownLatch)
  {
    super(paramString);
  }
  
  public void onLocationFinish(int paramInt, SosoLbsInfo paramSosoLbsInfo)
  {
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("onLocationFinish code : ");
      localStringBuilder.append(paramInt);
      localStringBuilder.append(" info : ");
      if (paramSosoLbsInfo == null) {
        localObject = null;
      } else {
        localObject = paramSosoLbsInfo.mLocation;
      }
      localStringBuilder.append(localObject);
      QLog.i("IVCommonInterfaceImpl", 2, localStringBuilder.toString());
    }
    Object localObject = new Bundle();
    if ((paramSosoLbsInfo != null) && (paramSosoLbsInfo.mLocation != null))
    {
      ((Bundle)localObject).putDouble("lat", paramSosoLbsInfo.mLocation.mLat02);
      ((Bundle)localObject).putDouble("lon", paramSosoLbsInfo.mLocation.mLon02);
      ((Bundle)localObject).putString("nation", IVCommonInterfaceImpl.access$000(this.this$1.this$0, paramSosoLbsInfo.mLocation.nation));
      ((Bundle)localObject).putString("province", IVCommonInterfaceImpl.access$000(this.this$1.this$0, paramSosoLbsInfo.mLocation.province));
      ((Bundle)localObject).putString("city", IVCommonInterfaceImpl.access$000(this.this$1.this$0, paramSosoLbsInfo.mLocation.city));
    }
    ((Bundle)localObject).putInt("code", paramInt);
    this.val$result[0] = localObject;
    this.val$latch.countDown();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.tencent.mobileqq.intervideo.groupvideo.pluginimpl.IVCommonInterfaceImpl.1.1
 * JD-Core Version:    0.7.0.1
 */