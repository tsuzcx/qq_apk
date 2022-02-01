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
  QzoneLbsServiceApiImpl$1(QzoneLbsServiceApiImpl paramQzoneLbsServiceApiImpl, String paramString, boolean paramBoolean, int paramInt1, ArrayList paramArrayList, long paramLong, int paramInt2, int paramInt3, Map paramMap)
  {
    super(paramString, paramBoolean);
  }
  
  public void onLocationFinish(int paramInt, SosoLbsInfo paramSosoLbsInfo)
  {
    if (QLog.isColorLevel()) {
      QLog.i("QcircleLbsService", 1, "getBatchPoiFromServer");
    }
    if ((this.a == 2) && (paramSosoLbsInfo == null))
    {
      localObject1 = this.b;
      if ((localObject1 == null) || (((ArrayList)localObject1).size() == 0))
      {
        QLog.e("QcircleLbsService", 1, "getBatchPoiFromServer error, info == null && (gpsList == null || gpsList.size() == 0)");
        return;
      }
    }
    Object localObject1 = QzoneLbsServiceApiImpl.access$000(this.g);
    if (localObject1 == null)
    {
      QLog.e("QcircleLbsService", 1, "getBatchPoiFromServer app == null");
      return;
    }
    System.currentTimeMillis();
    long l = this.c;
    Object localObject2 = new ArrayList();
    if (paramSosoLbsInfo != null) {
      ((ArrayList)localObject2).add(((ISosoUtils)QRoute.api(ISosoUtils.class)).convertFromSoso(paramSosoLbsInfo.mLocation));
    }
    paramSosoLbsInfo = this.b;
    if (paramSosoLbsInfo != null)
    {
      paramInt = this.d;
      if (paramInt == 1) {
        ((ArrayList)localObject2).add(LbsUtils.a((GpsInfo4LocalImage)paramSosoLbsInfo.get(0)));
      } else if (paramInt == 2) {
        ((ArrayList)localObject2).addAll(LbsUtils.a(paramSosoLbsInfo));
      }
    }
    paramSosoLbsInfo = new GetBatchPoiRequest((ArrayList)localObject2, this.e, this.f, this.a);
    localObject2 = new QzoneCommonIntent(((QQAppInterface)localObject1).getApplication(), QZoneCommonServlet.class);
    ((QzoneCommonIntent)localObject2).setRequest(paramSosoLbsInfo);
    ((QzoneCommonIntent)localObject2).setObserver(this.g);
    ((QQAppInterface)localObject1).startServlet((NewIntent)localObject2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.qzonehub.api.impl.QzoneLbsServiceApiImpl.1
 * JD-Core Version:    0.7.0.1
 */