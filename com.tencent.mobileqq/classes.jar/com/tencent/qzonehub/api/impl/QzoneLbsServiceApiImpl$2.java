package com.tencent.qzonehub.api.impl;

import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.qzone.api.impl.util.Soso;
import com.tencent.mobileqq.soso.location.LbsManagerServiceOnLocationChangeListener;
import com.tencent.mobileqq.soso.location.data.SosoLbsInfo;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qzonehub.api.ISosoUtils;
import cooperation.qzone.LbsDataV2.GeoInfo;
import cooperation.qzone.LbsDataV2.GpsInfo;
import java.util.ArrayList;

class QzoneLbsServiceApiImpl$2
  extends LbsManagerServiceOnLocationChangeListener
{
  QzoneLbsServiceApiImpl$2(QzoneLbsServiceApiImpl paramQzoneLbsServiceApiImpl, String paramString, boolean paramBoolean, long paramLong, int paramInt1, int paramInt2, ArrayList paramArrayList)
  {
    super(paramString, paramBoolean);
  }
  
  public void onLocationFinish(int paramInt, SosoLbsInfo paramSosoLbsInfo)
  {
    QLog.i("QcircleLbsService.NewLbsInterface", 1, "[QZ_LBS_MODULE]----refreshPoiList2");
    System.currentTimeMillis();
    long l = this.jdField_a_of_type_Long;
    if (paramSosoLbsInfo == null)
    {
      QLog.e("QcircleLbsService", 1, "refreshPoiList error, info == null");
      return;
    }
    LbsDataV2.GpsInfo localGpsInfo = ((ISosoUtils)QRoute.api(ISosoUtils.class)).convertFromSoso(paramSosoLbsInfo.mLocation);
    ArrayList localArrayList = Soso.b(paramSosoLbsInfo.mCells);
    paramSosoLbsInfo = Soso.a(paramSosoLbsInfo.mWifis);
    LbsDataV2.GeoInfo localGeoInfo = QzoneLbsServiceApiImpl.access$100(localArrayList);
    QzoneLbsServiceApiImpl.access$200(this.jdField_a_of_type_ComTencentQzonehubApiImplQzoneLbsServiceApiImpl, localGpsInfo, localGeoInfo, localArrayList, paramSosoLbsInfo, 0, this.jdField_a_of_type_Int, this.b, 3, this.jdField_a_of_type_JavaUtilArrayList);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.qzonehub.api.impl.QzoneLbsServiceApiImpl.2
 * JD-Core Version:    0.7.0.1
 */