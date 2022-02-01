package com.tencent.qzonehub.api.impl;

import LBS_V2_PROTOCOL.Cell_V2;
import LBS_V2_PROTOCOL.GetBatchPoiRsp_V2;
import LBS_V2_PROTOCOL.GetLbsCombinRsp_V2;
import LBS_V2_PROTOCOL.GetPoiInfoRsp_V2;
import LBS_V2_PROTOCOL.PoiInfoCell_V2;
import LBS_V2_PROTOCOL.PoiInfo_V2;
import LBS_V2_PROTOCOL.Wifi_V2;
import android.os.Bundle;
import android.text.TextUtils;
import com.qq.taf.jce.JceStruct;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.QZoneCommonServlet;
import com.tencent.mobileqq.data.QzoneCommonIntent;
import com.tencent.mobileqq.qcircle.api.IQCirclePoiCallback;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.soso.location.api.ILbsManagerServiceApi;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qzonehub.api.IQzoneLbsServiceApi;
import com.tencent.qzonehub.api.protocol.GetCombinInfoRequest;
import cooperation.qzone.LbsDataV2;
import cooperation.qzone.LbsDataV2.CellInfo;
import cooperation.qzone.LbsDataV2.GeoInfo;
import cooperation.qzone.LbsDataV2.GetGeoInfoRsp;
import cooperation.qzone.LbsDataV2.GpsInfo;
import cooperation.qzone.LbsDataV2.PoiInfo;
import cooperation.qzone.LbsDataV2.PoiList;
import cooperation.qzone.model.GpsInfo4LocalImage;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;
import mqq.observer.BusinessObserver;

public class QzoneLbsServiceApiImpl
  implements IQzoneLbsServiceApi, BusinessObserver
{
  private static final String BUSINESSID = "qzone_address_select";
  public static final int MASK_MODE_GEO = 1;
  public static final int MASK_MODE_POI = 2;
  private static final String TAG = "QcircleLbsService";
  private static final int TYPE_GET_BATCHPOI = 0;
  private static final int TYPE_GET_BATCHPOI_TESTA = 2;
  private static final int TYPE_GET_BATCH_POI_FOR_QCIRCLE = 1;
  private static final int TYPE_GET_GEO = 1;
  private static final int TYPE_SEARCH_BATCH_POI_FOR_QCIRCLE = 2;
  private static final int mAppId = 100203;
  
  private QQAppInterface getApp()
  {
    AppRuntime localAppRuntime = MobileQQ.sMobileQQ.waitAppRuntime(null);
    if ((localAppRuntime instanceof QQAppInterface)) {
      return (QQAppInterface)localAppRuntime;
    }
    return null;
  }
  
  private static LbsDataV2.GeoInfo getGeoCacheByCell(LbsDataV2.CellInfo paramCellInfo)
  {
    return null;
  }
  
  private static LbsDataV2.GeoInfo getGeoCacheByCell(ArrayList<Cell_V2> paramArrayList)
  {
    if ((paramArrayList != null) && (paramArrayList.size() != 0)) {
      return getGeoCacheByCell(LbsDataV2.covertToCellInfo((Cell_V2)paramArrayList.get(0)));
    }
    return null;
  }
  
  private void getLbsCombinInfo(LbsDataV2.GpsInfo paramGpsInfo, LbsDataV2.GeoInfo paramGeoInfo, ArrayList<Cell_V2> paramArrayList, ArrayList<Wifi_V2> paramArrayList1, int paramInt1, int paramInt2, int paramInt3, int paramInt4, ArrayList<String> paramArrayList2)
  {
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("getLbsCombinInfo gps param=");
      localStringBuilder.append(paramGpsInfo);
      localStringBuilder.append(",wifilist=");
      if ((paramArrayList1 != null) && (paramArrayList1.size() > 4)) {
        localObject = paramArrayList1.subList(0, 3);
      } else {
        localObject = paramArrayList1;
      }
      localStringBuilder.append(localObject);
      localStringBuilder.append(",celllist=");
      localStringBuilder.append(paramArrayList);
      localStringBuilder.append(".");
      QLog.i("QcircleLbsService", 2, localStringBuilder.toString());
    }
    Object localObject = getApp();
    if (localObject == null)
    {
      QLog.e("QcircleLbsService", 1, "getLbsCombinInfo app == null");
      return;
    }
    paramGpsInfo = new GetCombinInfoRequest(paramGpsInfo, paramGeoInfo, paramArrayList, paramArrayList1, paramInt1, paramInt2, 100203, paramInt4, paramArrayList2, 1);
    paramGeoInfo = new QzoneCommonIntent(((QQAppInterface)localObject).getApplication(), QZoneCommonServlet.class);
    paramGeoInfo.setRequest(paramGpsInfo);
    paramGeoInfo.setObserver(this);
    ((QQAppInterface)localObject).startServlet(paramGeoInfo);
  }
  
  private LbsDataV2.PoiList getRecommPoiList(ArrayList<PoiInfoCell_V2> paramArrayList, int paramInt)
  {
    if (paramArrayList == null) {
      return null;
    }
    LbsDataV2.PoiList localPoiList = new LbsDataV2.PoiList();
    ArrayList localArrayList = new ArrayList(paramArrayList.size());
    int i = 0;
    if (((PoiInfoCell_V2)paramArrayList.get(0)).vPoiList != null)
    {
      if ((paramInt == 0) && (!TextUtils.isEmpty(((PoiInfoCell_V2)paramArrayList.get(0)).stCityName)))
      {
        localObject = new LbsDataV2.PoiInfo();
        ((LbsDataV2.PoiInfo)localObject).poiId = "local_city_id";
        ((LbsDataV2.PoiInfo)localObject).poiName = ((PoiInfoCell_V2)paramArrayList.get(0)).stCityName;
        ((LbsDataV2.PoiInfo)localObject).gpsInfo = LbsDataV2.convertToGpsInfo(((PoiInfoCell_V2)paramArrayList.get(0)).stGps);
        localArrayList.add(localObject);
        QLog.d("QcircleLbsService", 1, new Object[] { "getRecommPoiList... cityname:", ((PoiInfoCell_V2)paramArrayList.get(0)).stCityName });
      }
      Object localObject = ((PoiInfoCell_V2)paramArrayList.get(0)).vPoiList.iterator();
      while (((Iterator)localObject).hasNext()) {
        localArrayList.add(LbsDataV2.convertToPoiInfo((PoiInfo_V2)((Iterator)localObject).next()));
      }
    }
    if ((paramArrayList.size() > 1) && (((PoiInfoCell_V2)paramArrayList.get(1)).vPoiList != null))
    {
      paramInt = i;
      while ((paramInt < 5) && (paramInt < ((PoiInfoCell_V2)paramArrayList.get(1)).vPoiList.size()))
      {
        if (!localArrayList.contains(LbsDataV2.convertToPoiInfo((PoiInfo_V2)((PoiInfoCell_V2)paramArrayList.get(1)).vPoiList.get(paramInt)))) {
          localArrayList.add(1, LbsDataV2.convertToPoiInfo((PoiInfo_V2)((PoiInfoCell_V2)paramArrayList.get(1)).vPoiList.get(paramInt)));
        }
        paramInt += 1;
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
          paramJceStruct = getRecommPoiList(paramJceStruct, paramInt);
          ((IQCirclePoiCallback)QRoute.api(IQCirclePoiCallback.class)).onPoiResultBack(paramJceStruct);
          return;
        }
        QLog.e("QcircleLbsService", 1, "onGetBatchPoi error poiInfoList == null");
      }
    }
    else
    {
      QLog.e("QcircleLbsService", 1, "onGetBatchPoi error jceStruct not instanceof GetBatchPoiRsp_V2");
    }
  }
  
  private void onGetLbsCombinFinish(int paramInt, JceStruct paramJceStruct)
  {
    if ((paramJceStruct instanceof GetLbsCombinRsp_V2))
    {
      Object localObject2 = (GetLbsCombinRsp_V2)paramJceStruct;
      Object localObject1 = null;
      LbsDataV2.PoiList localPoiList = new LbsDataV2.PoiList();
      paramInt = ((GetLbsCombinRsp_V2)localObject2).iMood;
      paramJceStruct = new StringBuilder();
      paramJceStruct.append("onGetLbsCombinFinish mode = ");
      paramJceStruct.append(paramInt);
      QLog.i("QcircleLbsService", 1, paramJceStruct.toString());
      paramJceStruct = (JceStruct)localObject1;
      if ((paramInt & 0x1) > 0)
      {
        paramJceStruct = (JceStruct)localObject1;
        if (((GetLbsCombinRsp_V2)localObject2).stGeoInfo != null)
        {
          paramJceStruct = new LbsDataV2.GetGeoInfoRsp();
          paramJceStruct.stGps = LbsDataV2.convertToGpsInfo(((GetLbsCombinRsp_V2)localObject2).stGps);
          paramJceStruct.stGeoInfo = LbsDataV2.convertToGeoInfo(((GetLbsCombinRsp_V2)localObject2).stGeoInfo);
          QLog.i("QcircleLbsService", 1, "onGetLbsCombinFinish will saveCurrentGeoInfo.");
        }
      }
      if (((paramInt & 0x2) > 0) && (((GetLbsCombinRsp_V2)localObject2).stPoiInfo != null) && (((GetLbsCombinRsp_V2)localObject2).stPoiInfo.vPoiList != null))
      {
        localObject1 = new ArrayList();
        paramInt = 0;
        while (paramInt < ((GetLbsCombinRsp_V2)localObject2).stPoiInfo.vPoiList.size())
        {
          ((ArrayList)localObject1).add(LbsDataV2.convertToPoiInfo((PoiInfo_V2)((GetLbsCombinRsp_V2)localObject2).stPoiInfo.vPoiList.get(paramInt)));
          paramInt += 1;
        }
        if (((ArrayList)localObject1).size() > 0)
        {
          localPoiList.poiInfos.addAll((Collection)localObject1);
          localObject2 = (LbsDataV2.PoiInfo)((ArrayList)localObject1).get(0);
          localObject1 = paramJceStruct;
          if (paramJceStruct == null)
          {
            localObject1 = new LbsDataV2.GetGeoInfoRsp();
            ((LbsDataV2.GetGeoInfoRsp)localObject1).stGps = ((LbsDataV2.PoiInfo)localObject2).gpsInfo;
            ((LbsDataV2.GetGeoInfoRsp)localObject1).stGeoInfo = new LbsDataV2.GeoInfo();
            ((LbsDataV2.GetGeoInfoRsp)localObject1).stGeoInfo.iDistrictCode = ((LbsDataV2.PoiInfo)localObject2).districtCode;
            ((LbsDataV2.GetGeoInfoRsp)localObject1).stGeoInfo.strCountry = ((LbsDataV2.PoiInfo)localObject2).country;
            ((LbsDataV2.GetGeoInfoRsp)localObject1).stGeoInfo.strProvince = ((LbsDataV2.PoiInfo)localObject2).province;
            ((LbsDataV2.GetGeoInfoRsp)localObject1).stGeoInfo.strCity = ((LbsDataV2.PoiInfo)localObject2).city;
            ((LbsDataV2.GetGeoInfoRsp)localObject1).stGeoInfo.strDefaultName = ((LbsDataV2.PoiInfo)localObject2).poiDefaultName;
          }
          localPoiList.geoInfo = LbsDataV2.GetGeoInfoRsp.convertTo((LbsDataV2.GetGeoInfoRsp)localObject1);
          ((IQCirclePoiCallback)QRoute.api(IQCirclePoiCallback.class)).onPoiResultBack(localPoiList);
          return;
        }
        QLog.e("QcircleLbsService", 1, "poiList.size() == 0");
        return;
      }
      QLog.e("QcircleLbsService", 1, "resp.stPoiInfo.vPoiList == null");
      return;
    }
    QLog.e("QcircleLbsService", 1, "onGetLbsCombinFinish error jceStruct not instanceof GetLbsCombinRsp_V2");
  }
  
  public void getBatchPoiFromServer(ArrayList<GpsInfo4LocalImage> paramArrayList, int paramInt1, Map<String, String> paramMap, int paramInt2, int paramInt3)
  {
    long l = System.currentTimeMillis();
    ((ILbsManagerServiceApi)QRoute.api(ILbsManagerServiceApi.class)).startLocation(new QzoneLbsServiceApiImpl.1(this, "qzone_address_select", false, paramInt3, paramArrayList, l, paramInt2, paramInt1, paramMap));
  }
  
  public void getBatchPoiFromServer(ArrayList<GpsInfo4LocalImage> paramArrayList, boolean paramBoolean)
  {
    HashMap localHashMap = new HashMap();
    localHashMap.put("source", "QqCircle");
    int i;
    if (paramBoolean) {
      i = 0;
    } else {
      i = 2;
    }
    getBatchPoiFromServer(paramArrayList, 100203, localHashMap, 1, i);
  }
  
  public void onReceive(int paramInt, boolean paramBoolean, Bundle paramBundle)
  {
    JceStruct localJceStruct = (JceStruct)paramBundle.getSerializable("key_response");
    int i = paramBundle.getInt("key_response_code");
    String str = paramBundle.getString("key_response_msg");
    if (!paramBoolean) {
      QLog.e("QcircleLbsService", 1, String.format("type :%d, success:%b, code:%d, msg:%s, bundle:%s", new Object[] { Integer.valueOf(paramInt), Boolean.valueOf(paramBoolean), Integer.valueOf(i), str, paramBundle.toString() }));
    } else if (QLog.isColorLevel()) {
      QLog.i("QcircleLbsService", 2, String.format("type :%d, success:%b, code:%d, msg:%s, bundle:%s", new Object[] { Integer.valueOf(paramInt), Boolean.valueOf(paramBoolean), Integer.valueOf(i), str, paramBundle.toString() }));
    }
    if (getApp() == null)
    {
      QLog.e("QcircleLbsService", 1, "onReceive app == null");
      return;
    }
    if (paramInt != 0) {
      if (paramInt != 1)
      {
        if (paramInt == 2) {}
      }
      else
      {
        onGetLbsCombinFinish(paramInt, localJceStruct);
        return;
      }
    }
    onGetBatchPoi(paramInt, localJceStruct);
  }
  
  public void refreshPoiList()
  {
    refreshPoiList(null, 0, 100203, true, null);
  }
  
  public void refreshPoiList(String paramString, int paramInt1, int paramInt2, boolean paramBoolean, ArrayList<String> paramArrayList)
  {
    paramString = new StringBuilder();
    paramString.append("[QZ_LBS_MODULE]refreshPoiList forceRefresh:");
    paramString.append(paramBoolean);
    QLog.i("QcircleLbsService", 1, paramString.toString());
    long l = System.currentTimeMillis();
    ((ILbsManagerServiceApi)QRoute.api(ILbsManagerServiceApi.class)).startLocation(new QzoneLbsServiceApiImpl.2(this, "qzone_address_select", false, l, paramInt1, paramInt2, paramArrayList));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.qzonehub.api.impl.QzoneLbsServiceApiImpl
 * JD-Core Version:    0.7.0.1
 */