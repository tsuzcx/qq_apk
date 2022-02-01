package com.tencent.qzonehub.api.impl;

import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.QZoneCommonServlet;
import com.tencent.mobileqq.data.QzoneCommonIntent;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.soso.location.LbsManagerServiceOnLocationChangeListener;
import com.tencent.mobileqq.soso.location.data.SosoLbsInfo;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qzonehub.api.ISosoUtils;
import com.tencent.qzonehub.api.protocol.GetBatchPoiRequest;
import com.tencent.qzonehub.api.utils.impl.LbsUtils;
import cooperation.qzone.model.GpsInfo4LocalImage;
import java.util.ArrayList;
import java.util.Map;
import mqq.app.NewIntent;

class QzoneLbsServiceApiImpl$1
  extends LbsManagerServiceOnLocationChangeListener
{
  QzoneLbsServiceApiImpl$1(QzoneLbsServiceApiImpl paramQzoneLbsServiceApiImpl, String paramString, boolean paramBoolean, ArrayList paramArrayList, long paramLong, int paramInt1, int paramInt2, Map paramMap)
  {
    super(paramString, paramBoolean);
  }
  
  public void onLocationFinish(int paramInt, SosoLbsInfo paramSosoLbsInfo)
  {
    if (QLog.isColorLevel()) {
      QLog.i("QcircleLbsService", 1, "getBatchPoiFromServer");
    }
    if ((paramSosoLbsInfo == null) && ((this.jdField_a_of_type_JavaUtilArrayList == null) || (this.jdField_a_of_type_JavaUtilArrayList.size() == 0)))
    {
      QLog.e("QcircleLbsService", 1, "getBatchPoiFromServer error, info == null && (gpsList == null || gpsList.size() == 0)");
      return;
    }
    QQAppInterface localQQAppInterface = QzoneLbsServiceApiImpl.access$000(this.jdField_a_of_type_ComTencentQzonehubApiImplQzoneLbsServiceApiImpl);
    if (localQQAppInterface == null)
    {
      QLog.e("QcircleLbsService", 1, "getBatchPoiFromServer app == null");
      return;
    }
    System.currentTimeMillis();
    long l = this.jdField_a_of_type_Long;
    Object localObject = new ArrayList();
    if (paramSosoLbsInfo != null) {
      ((ArrayList)localObject).add(((ISosoUtils)QRoute.api(ISosoUtils.class)).convertFromSoso(paramSosoLbsInfo.mLocation));
    }
    if (this.jdField_a_of_type_JavaUtilArrayList != null)
    {
      if (this.jdField_a_of_type_Int != 1) {
        break label205;
      }
      ((ArrayList)localObject).add(LbsUtils.a((GpsInfo4LocalImage)this.jdField_a_of_type_JavaUtilArrayList.get(0)));
    }
    for (;;)
    {
      paramSosoLbsInfo = new GetBatchPoiRequest((ArrayList)localObject, this.b, this.jdField_a_of_type_JavaUtilMap, 0);
      localObject = new QzoneCommonIntent(localQQAppInterface.getApplication(), QZoneCommonServlet.class);
      ((QzoneCommonIntent)localObject).setRequest(paramSosoLbsInfo);
      ((QzoneCommonIntent)localObject).setObserver(this.jdField_a_of_type_ComTencentQzonehubApiImplQzoneLbsServiceApiImpl);
      localQQAppInterface.startServlet((NewIntent)localObject);
      return;
      label205:
      if (this.jdField_a_of_type_Int == 2) {
        ((ArrayList)localObject).addAll(LbsUtils.a(this.jdField_a_of_type_JavaUtilArrayList));
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.qzonehub.api.impl.QzoneLbsServiceApiImpl.1
 * JD-Core Version:    0.7.0.1
 */