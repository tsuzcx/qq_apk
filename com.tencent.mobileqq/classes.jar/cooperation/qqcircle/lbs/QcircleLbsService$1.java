package cooperation.qqcircle.lbs;

import arvg;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.soso.LbsManagerService.OnLocationChangeListener;
import com.tencent.mobileqq.app.soso.SosoInterface.SosoLbsInfo;
import com.tencent.mobileqq.data.QzoneCommonIntent;
import com.tencent.qphone.base.util.QLog;
import cooperation.qqcircle.lbs.protocol.GetBatchPoiRequest;
import cooperation.qqcircle.lbs.util.LbsUtils;
import cooperation.qzone.LbsDataV2;
import cooperation.qzone.model.GpsInfo4LocalImage;
import java.util.ArrayList;
import java.util.Map;
import mqq.app.NewIntent;

class QcircleLbsService$1
  extends LbsManagerService.OnLocationChangeListener
{
  QcircleLbsService$1(QcircleLbsService paramQcircleLbsService, String paramString, boolean paramBoolean, ArrayList paramArrayList, long paramLong, int paramInt1, int paramInt2, Map paramMap)
  {
    super(paramString, paramBoolean);
  }
  
  public void onLocationFinish(int paramInt, SosoInterface.SosoLbsInfo paramSosoLbsInfo)
  {
    if (QLog.isColorLevel()) {
      QLog.i("QcircleLbsService", 1, "getBatchPoiFromServer");
    }
    if ((paramSosoLbsInfo == null) && ((this.val$gpsList == null) || (this.val$gpsList.size() == 0)))
    {
      QLog.e("QcircleLbsService", 1, "getBatchPoiFromServer error, info == null && (gpsList == null || gpsList.size() == 0)");
      return;
    }
    QQAppInterface localQQAppInterface = this.this$0.getApp();
    if (localQQAppInterface == null)
    {
      QLog.e("QcircleLbsService", 1, "getBatchPoiFromServer app == null");
      return;
    }
    System.currentTimeMillis();
    long l = this.val$mLocationStartTime;
    Object localObject = new ArrayList();
    if (paramSosoLbsInfo != null) {
      ((ArrayList)localObject).add(LbsDataV2.convertFromSoso(paramSosoLbsInfo.mLocation));
    }
    if (this.val$gpsList != null)
    {
      if (this.val$type != 1) {
        break label195;
      }
      ((ArrayList)localObject).add(LbsUtils.gpsInfoToGpsInfo((GpsInfo4LocalImage)this.val$gpsList.get(0)));
    }
    for (;;)
    {
      paramSosoLbsInfo = new GetBatchPoiRequest((ArrayList)localObject, this.val$appID, this.val$mapExt, 0);
      localObject = new QzoneCommonIntent(localQQAppInterface.getApplication(), arvg.class);
      ((QzoneCommonIntent)localObject).setRequest(paramSosoLbsInfo);
      ((QzoneCommonIntent)localObject).setObserver(this.this$0);
      localQQAppInterface.startServlet((NewIntent)localObject);
      return;
      label195:
      if (this.val$type == 2) {
        ((ArrayList)localObject).addAll(LbsUtils.gpsInfoToGpsInfoList(this.val$gpsList));
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     cooperation.qqcircle.lbs.QcircleLbsService.1
 * JD-Core Version:    0.7.0.1
 */