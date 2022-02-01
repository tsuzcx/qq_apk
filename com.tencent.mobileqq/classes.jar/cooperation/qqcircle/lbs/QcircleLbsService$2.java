package cooperation.qqcircle.lbs;

import com.tencent.mobileqq.app.soso.LbsManagerService.OnLocationChangeListener;
import com.tencent.mobileqq.app.soso.SosoInterface.SosoLbsInfo;
import com.tencent.qphone.base.util.QLog;
import cooperation.qqcircle.lbs.util.Soso;
import cooperation.qzone.LbsDataV2;
import cooperation.qzone.LbsDataV2.GeoInfo;
import cooperation.qzone.LbsDataV2.GpsInfo;
import java.util.ArrayList;

class QcircleLbsService$2
  extends LbsManagerService.OnLocationChangeListener
{
  QcircleLbsService$2(QcircleLbsService paramQcircleLbsService, String paramString, boolean paramBoolean, long paramLong, int paramInt1, int paramInt2, ArrayList paramArrayList)
  {
    super(paramString, paramBoolean);
  }
  
  public void onLocationFinish(int paramInt, SosoInterface.SosoLbsInfo paramSosoLbsInfo)
  {
    QLog.i("QcircleLbsService.NewLbsInterface", 1, "[QZ_LBS_MODULE]----refreshPoiList2");
    System.currentTimeMillis();
    long l = this.val$mLocationStartTime;
    if (paramSosoLbsInfo == null)
    {
      QLog.e("QcircleLbsService", 1, "refreshPoiList error, info == null");
      return;
    }
    LbsDataV2.GpsInfo localGpsInfo = LbsDataV2.convertFromSoso(paramSosoLbsInfo.mLocation);
    ArrayList localArrayList = Soso.fromCellList(paramSosoLbsInfo.mCells);
    paramSosoLbsInfo = Soso.fromWifiList(paramSosoLbsInfo.mWifis);
    LbsDataV2.GeoInfo localGeoInfo = QcircleLbsService.access$000(localArrayList);
    QcircleLbsService.access$100(this.this$0, localGpsInfo, localGeoInfo, localArrayList, paramSosoLbsInfo, 0, this.val$eventId, this.val$appId, 3, this.val$aiTextLabel);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     cooperation.qqcircle.lbs.QcircleLbsService.2
 * JD-Core Version:    0.7.0.1
 */