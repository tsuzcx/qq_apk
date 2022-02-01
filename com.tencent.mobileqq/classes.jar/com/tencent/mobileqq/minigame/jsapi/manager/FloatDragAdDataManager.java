package com.tencent.mobileqq.minigame.jsapi.manager;

import blbu;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.mini.manager.MiniTianShuManager;
import com.tencent.mobileqq.minigame.data.FloatDragAdInfo;
import com.tencent.mobileqq.minigame.data.FloatDragAdInfo.Builder;
import com.tencent.mobileqq.minigame.utils.GameLog;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import cooperation.vip.pb.TianShuAccess.AdItem;
import cooperation.vip.pb.TianShuAccess.AdPlacementInfo;
import cooperation.vip.pb.TianShuAccess.GetAdsRsp;
import cooperation.vip.pb.TianShuAccess.MapEntry;
import cooperation.vip.pb.TianShuAccess.RspEntry;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class FloatDragAdDataManager
{
  private static final int AD_COUNT = 1;
  private static final String AD_JUMP_URL = "url";
  private static final String AD_PICTURE_URL = "pic";
  private static final int AD_POS_ID = 473;
  private static final String AD_TYPE = "type";
  public static final String TAG = "FloatDragAdDataManager";
  
  private static FloatDragAdInfo handleTianShuResponse(String paramString, int paramInt, TianShuAccess.GetAdsRsp paramGetAdsRsp)
  {
    Object localObject3 = null;
    if ((paramGetAdsRsp == null) || (paramGetAdsRsp.mapAds.isEmpty()))
    {
      GameLog.getInstance().e("FloatDragAdDataManager", "handleTianShuResponse mapAds is empty");
      return null;
    }
    paramGetAdsRsp = (TianShuAccess.RspEntry)paramGetAdsRsp.mapAds.get(0);
    if ((paramGetAdsRsp == null) || (paramGetAdsRsp.value == null) || (paramGetAdsRsp.value.lst == null) || (paramGetAdsRsp.value.lst.isEmpty()))
    {
      GameLog.getInstance().e("FloatDragAdDataManager", "handleTianShuResponse rspEntry is empty");
      return null;
    }
    TianShuAccess.AdItem localAdItem = (TianShuAccess.AdItem)paramGetAdsRsp.value.lst.get(0);
    if ((localAdItem == null) || (localAdItem.argList == null) || (localAdItem.argList.isEmpty()))
    {
      GameLog.getInstance().e("FloatDragAdDataManager", "handleTianShuResponse adItem is empty");
      return null;
    }
    Iterator localIterator = localAdItem.argList.get().iterator();
    Object localObject2 = null;
    Object localObject1 = null;
    paramGetAdsRsp = (TianShuAccess.GetAdsRsp)localObject3;
    if (localIterator.hasNext())
    {
      localObject3 = (TianShuAccess.MapEntry)localIterator.next();
      if ("type".equals(((TianShuAccess.MapEntry)localObject3).key.get()))
      {
        localObject3 = ((TianShuAccess.MapEntry)localObject3).value.get();
        localObject1 = localObject2;
        localObject2 = localObject3;
      }
    }
    for (;;)
    {
      localObject3 = localObject2;
      localObject2 = localObject1;
      localObject1 = localObject3;
      break;
      if ("url".equals(((TianShuAccess.MapEntry)localObject3).key.get()))
      {
        localObject3 = ((TianShuAccess.MapEntry)localObject3).value.get();
        localObject2 = localObject1;
        localObject1 = localObject3;
      }
      else if ("pic".equals(((TianShuAccess.MapEntry)localObject3).key.get()))
      {
        paramGetAdsRsp = ((TianShuAccess.MapEntry)localObject3).value.get();
        localObject3 = localObject1;
        localObject1 = localObject2;
        localObject2 = localObject3;
        continue;
        GameLog.getInstance().i("FloatDragAdDataManager", "handleTianShuResponse type:" + localObject1 + ", jumpUrl:" + localObject2 + ", pictureUrl:" + paramGetAdsRsp);
        return new FloatDragAdInfo.Builder().adItem(localAdItem).type(localObject1).pictureUrl(paramGetAdsRsp).jumpUrl(localObject2).appId(paramString).scene(paramInt).build();
      }
      else
      {
        localObject3 = localObject1;
        localObject1 = localObject2;
        localObject2 = localObject3;
      }
    }
  }
  
  public static void requestAd(FloatDragAdDataManager.DragAdListener paramDragAdListener, String paramString, int paramInt)
  {
    ThreadManagerV2.executeOnSubThread(new FloatDragAdDataManager.1(paramDragAdListener, paramString, paramInt));
  }
  
  private static void requestTianShu(FloatDragAdDataManager.DragAdListener paramDragAdListener, String paramString, int paramInt)
  {
    if (paramString == null) {
      return;
    }
    GameLog.getInstance().i("FloatDragAdDataManager", "requestTianShu with appId=" + paramString + " scene=" + paramInt);
    blbu localblbu = new blbu();
    localblbu.jdField_a_of_type_Int = 473;
    localblbu.b = 1;
    localblbu.jdField_a_of_type_JavaUtilHashMap = new HashMap();
    JSONObject localJSONObject = new JSONObject();
    JSONArray localJSONArray1 = new JSONArray();
    localJSONArray1.put(paramString);
    JSONArray localJSONArray2 = new JSONArray();
    localJSONArray2.put(String.valueOf(paramInt));
    try
    {
      localJSONObject.put("Appid", localJSONArray1);
      localJSONObject.put("Refer", localJSONArray2);
      localblbu.jdField_a_of_type_JavaUtilHashMap.put("FilterInfo", localJSONObject.toString());
      MiniTianShuManager.requestAdv(Collections.singletonList(localblbu), new FloatDragAdDataManager.2(paramString, paramInt, paramDragAdListener));
      return;
    }
    catch (JSONException localJSONException)
    {
      for (;;)
      {
        GameLog.getInstance().e("FloatDragAdDataManager", "put extra data exception", localJSONException);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.minigame.jsapi.manager.FloatDragAdDataManager
 * JD-Core Version:    0.7.0.1
 */