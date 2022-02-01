package com.tencent.mobileqq.troop.api.impl;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.soso.location.SosoInterfaceOnLocationListener;
import com.tencent.mobileqq.soso.location.data.SosoLbsInfo;
import com.tencent.mobileqq.soso.location.data.SosoLocation;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import tencent.im.oidb.cmd0x935.oidb_0x935.GPS;

class RecommendTroopServiceImpl$1
  extends SosoInterfaceOnLocationListener
{
  RecommendTroopServiceImpl$1(RecommendTroopServiceImpl paramRecommendTroopServiceImpl, int paramInt, boolean paramBoolean1, boolean paramBoolean2, long paramLong, boolean paramBoolean3, boolean paramBoolean4, String paramString)
  {
    super(paramInt, paramBoolean1, paramBoolean2, paramLong, paramBoolean3, paramBoolean4, paramString);
  }
  
  public void onLocationFinish(int paramInt, SosoLbsInfo paramSosoLbsInfo)
  {
    Object localObject1;
    if (QLog.isColorLevel())
    {
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append("onLocationFinish errCode: ");
      ((StringBuilder)localObject1).append(paramInt);
      ((StringBuilder)localObject1).append(", info: ");
      ((StringBuilder)localObject1).append(paramSosoLbsInfo);
      QLog.d("RecommendTroopServiceImpl", 2, ((StringBuilder)localObject1).toString());
    }
    if (!NetworkUtil.isNetSupport(BaseApplication.getContext())) {
      return;
    }
    if (paramInt != 0)
    {
      this.a.getNotificationRecommendTroopFromServer(2L, null, 22);
      return;
    }
    double d1;
    int i;
    String str;
    int j;
    double d2;
    float f;
    Object localObject2;
    if ((paramSosoLbsInfo != null) && (paramSosoLbsInfo.mLocation != null))
    {
      d3 = paramSosoLbsInfo.mLocation.mLon02;
      d4 = paramSosoLbsInfo.mLocation.mLat02;
      d1 = paramSosoLbsInfo.mLocation.altitude;
      i = (int)paramSosoLbsInfo.mLocation.accuracy;
      localObject1 = paramSosoLbsInfo.mLocation.mProviderSource;
      str = paramSosoLbsInfo.mLocation.mVerifyKey;
      j = paramSosoLbsInfo.mLocation.fakeReason;
      d2 = paramSosoLbsInfo.mLocation.locationTime;
      f = paramSosoLbsInfo.mLocation.speed;
      localObject2 = paramSosoLbsInfo.mLocation.cityCode;
    }
    try
    {
      paramInt = Integer.parseInt((String)localObject2);
    }
    catch (Exception localException)
    {
      label195:
      break label195;
    }
    QLog.e("RecommendTroopServiceImpl", 1, "parse cityCode error");
    paramInt = 0;
    if (QLog.isColorLevel())
    {
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append("onLocationFinish longitude=");
      ((StringBuilder)localObject2).append(d3);
      ((StringBuilder)localObject2).append(", latitude=");
      ((StringBuilder)localObject2).append(d4);
      ((StringBuilder)localObject2).append(", accuracy=");
      ((StringBuilder)localObject2).append(i);
      ((StringBuilder)localObject2).append(", verifyKey=");
      ((StringBuilder)localObject2).append(str);
      ((StringBuilder)localObject2).append(", source=");
      ((StringBuilder)localObject2).append((String)localObject1);
      ((StringBuilder)localObject2).append(", fakeReason=");
      ((StringBuilder)localObject2).append(j);
      ((StringBuilder)localObject2).append(", speed=");
      ((StringBuilder)localObject2).append(f);
      ((StringBuilder)localObject2).append(", locationTime=");
      ((StringBuilder)localObject2).append(d2);
      QLog.d("RecommendTroopServiceImpl", 2, ((StringBuilder)localObject2).toString());
    }
    double d3 = Double.valueOf(paramSosoLbsInfo.mLocation.mLat02 * 1000000.0D).intValue();
    double d4 = Double.valueOf(paramSosoLbsInfo.mLocation.mLon02 * 1000000.0D).intValue();
    paramSosoLbsInfo = new oidb_0x935.GPS();
    paramSosoLbsInfo.uint32_latitude.set((int)d3);
    paramSosoLbsInfo.uint32_longitude.set((int)d4);
    paramSosoLbsInfo.uint32_altitude.set((int)d1);
    paramSosoLbsInfo.uint32_accuracy.set(i);
    paramSosoLbsInfo.uint32_time.set((int)d2);
    paramSosoLbsInfo.uint32_cityid.set(paramInt);
    paramSosoLbsInfo.bytes_client_version.set(ByteStringMicro.copyFromUtf8("8.7.0"));
    paramSosoLbsInfo.uint32_client.set(2);
    this.a.getNotificationRecommendTroopFromServer(2L, paramSosoLbsInfo, 22);
    return;
    this.a.getNotificationRecommendTroopFromServer(2L, null, 22);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\tmp\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.troop.api.impl.RecommendTroopServiceImpl.1
 * JD-Core Version:    0.7.0.1
 */