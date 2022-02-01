package cooperation.qqcircle.lbs;

import LBS_V2_PROTOCOL.Cell_V2;
import LBS_V2_PROTOCOL.GetBatchPoiRsp_V2;
import LBS_V2_PROTOCOL.GetLbsCombinRsp_V2;
import LBS_V2_PROTOCOL.GetPoiInfoRsp_V2;
import LBS_V2_PROTOCOL.PoiInfoCell_V2;
import LBS_V2_PROTOCOL.PoiInfo_V2;
import LBS_V2_PROTOCOL.Wifi_V2;
import android.os.Bundle;
import arvg;
import com.qq.taf.jce.JceStruct;
import com.tencent.biz.richframework.eventbus.SimpleEventBus;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.soso.LbsManagerService;
import com.tencent.mobileqq.data.QzoneCommonIntent;
import com.tencent.qphone.base.util.QLog;
import common.config.service.QzoneConfig;
import cooperation.qqcircle.events.QcircleLbsEvent;
import cooperation.qqcircle.lbs.protocol.GetCombinInfoRequest;
import cooperation.qzone.LbsDataV2;
import cooperation.qzone.LbsDataV2.CellInfo;
import cooperation.qzone.LbsDataV2.GeoInfo;
import cooperation.qzone.LbsDataV2.GetGeoInfoRsp;
import cooperation.qzone.LbsDataV2.GpsInfo;
import cooperation.qzone.LbsDataV2.PoiInfo;
import cooperation.qzone.LbsDataV2.PoiList;
import cooperation.qzone.model.GpsInfo4LocalImage;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import mqq.manager.Manager;
import mqq.observer.BusinessObserver;

public class QcircleLbsService
  implements Manager, BusinessObserver
{
  private static final String BUSINESSID = "qzone_address_select";
  public static final int MASK_MODE_GEO = 1;
  public static final int MASK_MODE_POI = 2;
  private static final String TAG = "QcircleLbsService";
  private static final int TYPE_GET_BATCHPOI = 0;
  private static final int TYPE_GET_BATCH_POI_FOR_QCIRCLE = 1;
  private static final int TYPE_GET_GEO = 1;
  private static final int TYPE_SEARCH_BATCH_POI_FOR_QCIRCLE = 2;
  private static final int mAppId = 100203;
  private WeakReference<QQAppInterface> mAppRef;
  
  public QcircleLbsService(QQAppInterface paramQQAppInterface)
  {
    this.mAppRef = new WeakReference(paramQQAppInterface);
  }
  
  private static LbsDataV2.GeoInfo getGeoCacheByCell(LbsDataV2.CellInfo paramCellInfo)
  {
    if (paramCellInfo != null) {}
    return null;
  }
  
  private static LbsDataV2.GeoInfo getGeoCacheByCell(ArrayList<Cell_V2> paramArrayList)
  {
    if ((paramArrayList == null) || (paramArrayList.size() == 0)) {
      return null;
    }
    return getGeoCacheByCell(LbsDataV2.covertToCellInfo((Cell_V2)paramArrayList.get(0)));
  }
  
  private void getLbsCombinInfo(LbsDataV2.GpsInfo paramGpsInfo, LbsDataV2.GeoInfo paramGeoInfo, ArrayList<Cell_V2> paramArrayList, ArrayList<Wifi_V2> paramArrayList1, int paramInt1, int paramInt2, int paramInt3, int paramInt4, ArrayList<String> paramArrayList2)
  {
    StringBuilder localStringBuilder;
    if (QLog.isColorLevel())
    {
      localStringBuilder = new StringBuilder().append("getLbsCombinInfo gps param=").append(paramGpsInfo).append(",wifilist=");
      if ((paramArrayList1 == null) || (paramArrayList1.size() <= 4)) {
        break label102;
      }
    }
    label102:
    for (Object localObject = paramArrayList1.subList(0, 3);; localObject = paramArrayList1)
    {
      QLog.i("QcircleLbsService", 2, localObject + ",celllist=" + paramArrayList + ".");
      localObject = getApp();
      if (localObject != null) {
        break;
      }
      QLog.e("QcircleLbsService", 1, "getLbsCombinInfo app == null");
      return;
    }
    paramGpsInfo = new GetCombinInfoRequest(paramGpsInfo, paramGeoInfo, paramArrayList, paramArrayList1, paramInt1, paramInt2, 100203, paramInt4, paramArrayList2, 1);
    paramGeoInfo = new QzoneCommonIntent(((QQAppInterface)localObject).getApplication(), arvg.class);
    paramGeoInfo.setRequest(paramGpsInfo);
    paramGeoInfo.setObserver(this);
    ((QQAppInterface)localObject).startServlet(paramGeoInfo);
  }
  
  private LbsDataV2.PoiList getRecommPoiList(ArrayList<PoiInfoCell_V2> paramArrayList)
  {
    int i = 0;
    if (paramArrayList == null) {
      return null;
    }
    LbsDataV2.PoiList localPoiList = new LbsDataV2.PoiList();
    ArrayList localArrayList = new ArrayList(paramArrayList.size());
    if (((PoiInfoCell_V2)paramArrayList.get(0)).vPoiList != null)
    {
      Iterator localIterator = ((PoiInfoCell_V2)paramArrayList.get(0)).vPoiList.iterator();
      while (localIterator.hasNext()) {
        localArrayList.add(LbsDataV2.convertToPoiInfo((PoiInfo_V2)localIterator.next()));
      }
    }
    if ((paramArrayList.size() > 1) && (((PoiInfoCell_V2)paramArrayList.get(1)).vPoiList != null)) {
      while ((i < 5) && (i < ((PoiInfoCell_V2)paramArrayList.get(1)).vPoiList.size()))
      {
        if (!localArrayList.contains(LbsDataV2.convertToPoiInfo((PoiInfo_V2)((PoiInfoCell_V2)paramArrayList.get(1)).vPoiList.get(i)))) {
          localArrayList.add(1, LbsDataV2.convertToPoiInfo((PoiInfo_V2)((PoiInfoCell_V2)paramArrayList.get(1)).vPoiList.get(i)));
        }
        i += 1;
      }
    }
    localPoiList.poiInfos = localArrayList;
    return localPoiList;
  }
  
  private void onGetBatchPoi(int paramInt, JceStruct paramJceStruct)
  {
    if ((paramJceStruct instanceof GetBatchPoiRsp_V2))
    {
      paramJceStruct = (GetBatchPoiRsp_V2)paramJceStruct;
      if (paramJceStruct != null)
      {
        paramJceStruct = paramJceStruct.vecPoiInfoCell;
        if (paramJceStruct != null)
        {
          paramJceStruct = getRecommPoiList(paramJceStruct);
          SimpleEventBus.getInstance().dispatchEvent(new QcircleLbsEvent(paramJceStruct));
        }
      }
      else
      {
        return;
      }
      QLog.e("QcircleLbsService", 1, "onGetBatchPoi error poiInfoList == null");
      return;
    }
    QLog.e("QcircleLbsService", 1, "onGetBatchPoi error jceStruct not instanceof GetBatchPoiRsp_V2");
  }
  
  private void onGetLbsCombinFinish(int paramInt, JceStruct paramJceStruct)
  {
    LbsDataV2.PoiList localPoiList;
    if ((paramJceStruct instanceof GetLbsCombinRsp_V2))
    {
      GetLbsCombinRsp_V2 localGetLbsCombinRsp_V2 = (GetLbsCombinRsp_V2)paramJceStruct;
      Object localObject = null;
      localPoiList = new LbsDataV2.PoiList();
      paramInt = localGetLbsCombinRsp_V2.iMood;
      if (QzoneConfig.getInstance().getConfig("QZoneSetting", "LbsSpecialLogicOn", 1) == 1) {}
      QzoneConfig.getInstance().getConfig("QZoneSetting", "LbsSpecialLogicMaxRetryCount", 2);
      QLog.i("QcircleLbsService", 1, "onGetLbsCombinFinish mode = " + paramInt);
      paramJceStruct = (JceStruct)localObject;
      if ((paramInt & 0x1) > 0)
      {
        paramJceStruct = (JceStruct)localObject;
        if (localGetLbsCombinRsp_V2.stGeoInfo != null)
        {
          paramJceStruct = new LbsDataV2.GetGeoInfoRsp();
          paramJceStruct.stGps = LbsDataV2.convertToGpsInfo(localGetLbsCombinRsp_V2.stGps);
          paramJceStruct.stGeoInfo = LbsDataV2.convertToGeoInfo(localGetLbsCombinRsp_V2.stGeoInfo);
          QLog.i("QcircleLbsService", 1, "onGetLbsCombinFinish will saveCurrentGeoInfo.");
        }
      }
      if (((paramInt & 0x2) > 0) && (localGetLbsCombinRsp_V2.stPoiInfo != null) && (localGetLbsCombinRsp_V2.stPoiInfo.vPoiList != null))
      {
        localObject = new ArrayList();
        paramInt = 0;
        while (paramInt < localGetLbsCombinRsp_V2.stPoiInfo.vPoiList.size())
        {
          ((ArrayList)localObject).add(LbsDataV2.convertToPoiInfo((PoiInfo_V2)localGetLbsCombinRsp_V2.stPoiInfo.vPoiList.get(paramInt)));
          paramInt += 1;
        }
        if (((ArrayList)localObject).size() > 0)
        {
          localPoiList.poiInfos.addAll((Collection)localObject);
          localObject = (LbsDataV2.PoiInfo)((ArrayList)localObject).get(0);
          if (paramJceStruct != null) {
            break label388;
          }
          paramJceStruct = new LbsDataV2.GetGeoInfoRsp();
          paramJceStruct.stGps = ((LbsDataV2.PoiInfo)localObject).gpsInfo;
          paramJceStruct.stGeoInfo = new LbsDataV2.GeoInfo();
          paramJceStruct.stGeoInfo.iDistrictCode = ((LbsDataV2.PoiInfo)localObject).districtCode;
          paramJceStruct.stGeoInfo.strCountry = ((LbsDataV2.PoiInfo)localObject).country;
          paramJceStruct.stGeoInfo.strProvince = ((LbsDataV2.PoiInfo)localObject).province;
          paramJceStruct.stGeoInfo.strCity = ((LbsDataV2.PoiInfo)localObject).city;
          paramJceStruct.stGeoInfo.strDefaultName = ((LbsDataV2.PoiInfo)localObject).poiDefaultName;
        }
      }
    }
    label388:
    for (;;)
    {
      localPoiList.geoInfo = LbsDataV2.GetGeoInfoRsp.convertTo(paramJceStruct);
      SimpleEventBus.getInstance().dispatchEvent(new QcircleLbsEvent(localPoiList));
      return;
      QLog.e("QcircleLbsService", 1, "poiList.size() == 0");
      return;
      QLog.e("QcircleLbsService", 1, "resp.stPoiInfo.vPoiList == null");
      return;
      QLog.e("QcircleLbsService", 1, "onGetLbsCombinFinish error jceStruct not instanceof GetLbsCombinRsp_V2");
      return;
    }
  }
  
  public QQAppInterface getApp()
  {
    if (this.mAppRef != null) {
      return (QQAppInterface)this.mAppRef.get();
    }
    return null;
  }
  
  public void getBatchPoiFromServer(ArrayList<GpsInfo4LocalImage> paramArrayList)
  {
    HashMap localHashMap = new HashMap();
    localHashMap.put("source", "QqCircle");
    getBatchPoiFromServer(paramArrayList, 100203, localHashMap, 1);
  }
  
  public void getBatchPoiFromServer(ArrayList<GpsInfo4LocalImage> paramArrayList, int paramInt1, Map<String, String> paramMap, int paramInt2)
  {
    LbsManagerService.startLocation(new QcircleLbsService.1(this, "qzone_address_select", false, paramArrayList, System.currentTimeMillis(), paramInt2, paramInt1, paramMap));
  }
  
  public void onDestroy() {}
  
  public void onReceive(int paramInt, boolean paramBoolean, Bundle paramBundle)
  {
    JceStruct localJceStruct = (JceStruct)paramBundle.getSerializable("key_response");
    int i = paramBundle.getInt("key_response_code");
    String str = paramBundle.getString("key_response_msg");
    if (!paramBoolean) {
      QLog.e("QcircleLbsService", 1, String.format("type :%d, success:%b, code:%d, msg:%s, bundle:%s", new Object[] { Integer.valueOf(paramInt), Boolean.valueOf(paramBoolean), Integer.valueOf(i), str, paramBundle.toString() }));
    }
    while (getApp() == null)
    {
      QLog.e("QcircleLbsService", 1, "onReceive app == null");
      return;
      if (QLog.isColorLevel()) {
        QLog.i("QcircleLbsService", 2, String.format("type :%d, success:%b, code:%d, msg:%s, bundle:%s", new Object[] { Integer.valueOf(paramInt), Boolean.valueOf(paramBoolean), Integer.valueOf(i), str, paramBundle.toString() }));
      }
    }
    switch (paramInt)
    {
    default: 
      return;
    case 0: 
      onGetBatchPoi(paramInt, localJceStruct);
      return;
    }
    onGetLbsCombinFinish(paramInt, localJceStruct);
  }
  
  public void refreshPoiList()
  {
    refreshPoiList(null, 0, 100203, true, null);
  }
  
  public void refreshPoiList(String paramString, int paramInt1, int paramInt2, boolean paramBoolean, ArrayList<String> paramArrayList)
  {
    QLog.i("QcircleLbsService", 1, "[QZ_LBS_MODULE]refreshPoiList forceRefresh:" + paramBoolean);
    LbsManagerService.startLocation(new QcircleLbsService.2(this, "qzone_address_select", false, System.currentTimeMillis(), paramInt1, paramInt2, paramArrayList));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     cooperation.qqcircle.lbs.QcircleLbsService
 * JD-Core Version:    0.7.0.1
 */