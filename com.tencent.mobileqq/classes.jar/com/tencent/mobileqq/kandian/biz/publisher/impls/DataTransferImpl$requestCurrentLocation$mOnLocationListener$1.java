package com.tencent.mobileqq.kandian.biz.publisher.impls;

import com.tencent.mobileqq.soso.location.SosoInterfaceOnLocationListener;
import com.tencent.mobileqq.soso.location.data.SosoLbsInfo;
import com.tencent.mobileqq.soso.location.data.SosoLocation;
import com.tencent.qphone.base.util.QLog;
import com.tencent.tkd.topicsdk.bean.LocationInfo;
import kotlin.Metadata;
import org.jetbrains.annotations.Nullable;
import org.json.JSONException;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"com/tencent/mobileqq/kandian/biz/publisher/impls/DataTransferImpl$requestCurrentLocation$mOnLocationListener$1", "Lcom/tencent/mobileqq/soso/location/SosoInterfaceOnLocationListener;", "onLocationFinish", "", "errCode", "", "info", "Lcom/tencent/mobileqq/soso/location/data/SosoLbsInfo;", "kandian_feature_impl_release"}, k=1, mv={1, 1, 16})
public final class DataTransferImpl$requestCurrentLocation$mOnLocationListener$1
  extends SosoInterfaceOnLocationListener
{
  DataTransferImpl$requestCurrentLocation$mOnLocationListener$1(LocationInfo paramLocationInfo, int paramInt, boolean paramBoolean1, boolean paramBoolean2, long paramLong, boolean paramBoolean3, boolean paramBoolean4, String paramString)
  {
    super(paramInt, paramBoolean1, paramBoolean2, paramLong, paramBoolean3, paramBoolean4, paramString);
  }
  
  public void onLocationFinish(int paramInt, @Nullable SosoLbsInfo paramSosoLbsInfo)
  {
    if ((paramSosoLbsInfo == null) || (this.a == null)) {}
    do
    {
      return;
      if (QLog.isColorLevel()) {
        QLog.d("TKP.DataTransferImpl", 2, "onLocationFinish() errCode=" + paramInt);
      }
    } while ((paramInt != 0) || (paramSosoLbsInfo.mLocation == null));
    try
    {
      LocationInfo localLocationInfo = this.a;
      localLocationInfo.setLatitude((paramSosoLbsInfo.mLocation.mLat02 * 1000000.0D));
      localLocationInfo.setLongitude((paramSosoLbsInfo.mLocation.mLon02 * 1000000.0D));
      localLocationInfo.setUserSelect(0);
      return;
    }
    catch (JSONException paramSosoLbsInfo)
    {
      paramSosoLbsInfo.printStackTrace();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.publisher.impls.DataTransferImpl.requestCurrentLocation.mOnLocationListener.1
 * JD-Core Version:    0.7.0.1
 */