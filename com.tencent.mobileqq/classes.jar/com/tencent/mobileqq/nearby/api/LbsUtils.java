package com.tencent.mobileqq.nearby.api;

import NearbyGroup.Attr;
import NearbyGroup.Cell;
import NearbyGroup.GPS;
import NearbyGroup.LBSInfo;
import NearbyGroup.Wifi;
import appoint.define.appoint_define.Cell;
import appoint.define.appoint_define.GPS;
import appoint.define.appoint_define.LBSInfo;
import appoint.define.appoint_define.Wifi;
import com.tencent.mobileqq.nearby.NearbyUtils;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.soso.location.api.ILbsManagerServiceApi;
import com.tencent.mobileqq.soso.location.api.ISosoInterfaceApi;
import com.tencent.mobileqq.soso.location.data.SosoAttribute;
import com.tencent.mobileqq.soso.location.data.SosoCell;
import com.tencent.mobileqq.soso.location.data.SosoLbsInfo;
import com.tencent.mobileqq.soso.location.data.SosoLocation;
import com.tencent.mobileqq.soso.location.data.SosoWifi;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Iterator;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class LbsUtils
{
  public static LBSInfo a()
  {
    return a(false, ((ILbsManagerServiceApi)QRoute.api(ILbsManagerServiceApi.class)).getCachedLbsInfo("NearbyProtocolCoder.Encounter"));
  }
  
  public static LBSInfo a(boolean paramBoolean, SosoLbsInfo paramSosoLbsInfo)
  {
    Attr localAttr = null;
    if (paramSosoLbsInfo == null) {
      return null;
    }
    ArrayList localArrayList = new ArrayList();
    if (paramSosoLbsInfo.mCells != null)
    {
      localObject1 = paramSosoLbsInfo.mCells.iterator();
      while (((Iterator)localObject1).hasNext())
      {
        localObject2 = (SosoCell)((Iterator)localObject1).next();
        localArrayList.add(new Cell((short)((SosoCell)localObject2).mMcc, (short)((SosoCell)localObject2).mMnc, ((SosoCell)localObject2).mLac, ((SosoCell)localObject2).mCellId, (short)((SosoCell)localObject2).mRss));
      }
    }
    try
    {
      if (paramSosoLbsInfo.mLocation != null) {
        if (paramBoolean) {
          localObject1 = new GPS((int)(paramSosoLbsInfo.mLocation.mLat02 * 1000000.0D), (int)(paramSosoLbsInfo.mLocation.mLon02 * 1000000.0D), -1, 1);
        } else {
          localObject1 = new GPS((int)(paramSosoLbsInfo.mLocation.mLat84 * 1000000.0D), (int)(paramSosoLbsInfo.mLocation.mLon84 * 1000000.0D), -1, 0);
        }
      }
    }
    catch (Exception localException)
    {
      label181:
      Iterator localIterator;
      break label181;
    }
    Object localObject1 = null;
    Object localObject2 = new ArrayList();
    if (paramSosoLbsInfo.mWifis != null)
    {
      localIterator = paramSosoLbsInfo.mWifis.iterator();
      while (localIterator.hasNext())
      {
        SosoWifi localSosoWifi = (SosoWifi)localIterator.next();
        if (localSosoWifi != null) {
          ((ArrayList)localObject2).add(new Wifi(localSosoWifi.mMac, (short)localSosoWifi.mRssi));
        }
      }
    }
    if (paramSosoLbsInfo.mAttr != null) {
      localAttr = new Attr(paramSosoLbsInfo.mAttr.mImei, paramSosoLbsInfo.mAttr.mImsi, paramSosoLbsInfo.mAttr.mPhoneNum);
    }
    return new LBSInfo((GPS)localObject1, (ArrayList)localObject2, localArrayList, localAttr);
  }
  
  public static appoint_define.LBSInfo a(String paramString)
  {
    Object localObject2 = ((ILbsManagerServiceApi)QRoute.api(ILbsManagerServiceApi.class)).getCachedLbsInfo("NearbyProtocolCoder.Encounter");
    Object localObject1;
    if ((localObject2 != null) && (((SosoLbsInfo)localObject2).mLocation != null) && (((SosoLbsInfo)localObject2).mLocation.mLat02 != 0.0D))
    {
      localObject1 = localObject2;
      if (((SosoLbsInfo)localObject2).mLocation.mLon02 != 0.0D) {}
    }
    else
    {
      ((ISosoInterfaceApi)QRoute.api(ISosoInterfaceApi.class)).reqRawLbsData(60000L, paramString);
      localObject1 = ((ILbsManagerServiceApi)QRoute.api(ILbsManagerServiceApi.class)).getCachedLbsInfo("NearbyProtocolCoder.Encounter");
    }
    if (localObject1 != null)
    {
      localObject2 = new appoint_define.LBSInfo();
      Object localObject3;
      Object localObject4;
      if (((SosoLbsInfo)localObject1).mWifis != null)
      {
        paramString = ((SosoLbsInfo)localObject1).mWifis.iterator();
        while (paramString.hasNext())
        {
          localObject3 = (SosoWifi)paramString.next();
          if (localObject3 != null)
          {
            localObject4 = new appoint_define.Wifi();
            ((appoint_define.Wifi)localObject4).uint64_mac.set(((SosoWifi)localObject3).mMac);
            ((appoint_define.Wifi)localObject4).int32_rssi.set(((SosoWifi)localObject3).mRssi);
            ((appoint_define.LBSInfo)localObject2).rpt_msg_wifis.add((MessageMicro)localObject4);
          }
        }
      }
      if (((SosoLbsInfo)localObject1).mCells != null)
      {
        paramString = ((SosoLbsInfo)localObject1).mCells.iterator();
        while (paramString.hasNext())
        {
          localObject3 = (SosoCell)paramString.next();
          if (localObject3 != null)
          {
            localObject4 = new appoint_define.Cell();
            ((appoint_define.Cell)localObject4).int32_cellid.set(((SosoCell)localObject3).mCellId);
            ((appoint_define.Cell)localObject4).int32_lac.set(((SosoCell)localObject3).mLac);
            ((appoint_define.Cell)localObject4).int32_rssi.set(((SosoCell)localObject3).mRss);
            ((appoint_define.Cell)localObject4).int32_mcc.set(((SosoCell)localObject3).mMcc);
            ((appoint_define.Cell)localObject4).int32_mnc.set(((SosoCell)localObject3).mMnc);
            ((appoint_define.LBSInfo)localObject2).rpt_msg_cells.add((MessageMicro)localObject4);
          }
        }
      }
      paramString = (String)localObject2;
      if (((SosoLbsInfo)localObject1).mLocation != null)
      {
        paramString = new appoint_define.GPS();
        paramString.int32_lon.set((int)(((SosoLbsInfo)localObject1).mLocation.mLon84 * 1000000.0D));
        paramString.int32_lat.set((int)(((SosoLbsInfo)localObject1).mLocation.mLat84 * 1000000.0D));
        paramString.int32_type.set(0);
        ((appoint_define.LBSInfo)localObject2).msg_gps.set(paramString);
        return localObject2;
      }
    }
    else
    {
      NearbyUtils.a("getLbsInfo", new Object[] { "lbs is null" });
      paramString = null;
    }
    return paramString;
  }
  
  public static String a(SosoLbsInfo paramSosoLbsInfo)
  {
    if (paramSosoLbsInfo == null) {
      return null;
    }
    JSONObject localJSONObject = new JSONObject();
    try
    {
      localJSONObject.put("lat", (int)(paramSosoLbsInfo.mLocation.mLat02 * 1000000.0D));
      localJSONObject.put("lon", (int)(paramSosoLbsInfo.mLocation.mLon02 * 1000000.0D));
      JSONArray localJSONArray = new JSONArray();
      Object localObject = paramSosoLbsInfo.mWifis.iterator();
      for (;;)
      {
        boolean bool = ((Iterator)localObject).hasNext();
        if (!bool) {
          break;
        }
        SosoWifi localSosoWifi = (SosoWifi)((Iterator)localObject).next();
        localJSONArray.put(new JSONObject().put("mac", localSosoWifi.mMac).put("rssi", localSosoWifi.mRssi));
      }
      localJSONObject.put("wifis", localJSONArray);
      localJSONArray = new JSONArray();
      paramSosoLbsInfo = paramSosoLbsInfo.mCells.iterator();
      while (paramSosoLbsInfo.hasNext())
      {
        localObject = (SosoCell)paramSosoLbsInfo.next();
        localJSONArray.put(new JSONObject().put("mcc", ((SosoCell)localObject).mMcc).put("mnc", ((SosoCell)localObject).mMnc).put("lac", ((SosoCell)localObject).mLac).put("cellid", ((SosoCell)localObject).mCellId).put("rssi", ((SosoCell)localObject).mRss));
      }
      localJSONObject.put("cells", localJSONArray);
    }
    catch (JSONException paramSosoLbsInfo)
    {
      if (QLog.isColorLevel()) {
        QLog.d("LbsUtils", 2, "lbsInfo to json exception", paramSosoLbsInfo);
      }
    }
    return localJSONObject.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.mobileqq.nearby.api.LbsUtils
 * JD-Core Version:    0.7.0.1
 */