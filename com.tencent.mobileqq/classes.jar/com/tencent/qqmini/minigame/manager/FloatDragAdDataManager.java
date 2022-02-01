package com.tencent.qqmini.minigame.manager;

import android.app.Activity;
import android.content.Context;
import android.os.Handler;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.qqmini.sdk.core.manager.ThreadManager;
import com.tencent.qqmini.sdk.core.proxy.ProxyManager;
import com.tencent.qqmini.sdk.launcher.core.IMiniAppContext;
import com.tencent.qqmini.sdk.launcher.core.model.FloatDragAdInfo;
import com.tencent.qqmini.sdk.launcher.core.model.FloatDragAdInfo.Builder;
import com.tencent.qqmini.sdk.launcher.core.proxy.ChannelProxy;
import com.tencent.qqmini.sdk.launcher.log.QMLog;
import cooperation.vip.pb.TianShuAccess.AdItem;
import cooperation.vip.pb.TianShuAccess.AdPlacementInfo;
import cooperation.vip.pb.TianShuAccess.GetAdsRsp;
import cooperation.vip.pb.TianShuAccess.MapEntry;
import cooperation.vip.pb.TianShuAccess.RspEntry;
import java.util.Iterator;
import java.util.List;
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
  
  private static FloatDragAdInfo handleTianShuResponse(String paramString, int paramInt, JSONObject paramJSONObject)
  {
    for (;;)
    {
      try
      {
        paramJSONObject = (TianShuAccess.GetAdsRsp)paramJSONObject.get("response");
        if ((paramJSONObject == null) || (paramJSONObject.mapAds.isEmpty()))
        {
          QMLog.e("FloatDragAdDataManager", "handleTianShuResponse mapAds is empty");
          return null;
        }
        paramJSONObject = (TianShuAccess.RspEntry)paramJSONObject.mapAds.get(0);
        if ((paramJSONObject == null) || (paramJSONObject.value == null) || (paramJSONObject.value.lst == null) || (paramJSONObject.value.lst.isEmpty()))
        {
          QMLog.e("FloatDragAdDataManager", "handleTianShuResponse rspEntry is empty");
          return null;
        }
        TianShuAccess.AdItem localAdItem = (TianShuAccess.AdItem)paramJSONObject.value.lst.get(0);
        if ((localAdItem == null) || (localAdItem.argList == null) || (localAdItem.argList.isEmpty()))
        {
          QMLog.e("FloatDragAdDataManager", "handleTianShuResponse adItem is empty");
          return null;
        }
        Iterator localIterator = localAdItem.argList.get().iterator();
        paramJSONObject = null;
        localObject2 = null;
        localObject1 = null;
        if (localIterator.hasNext())
        {
          localObject3 = (TianShuAccess.MapEntry)localIterator.next();
          if ("type".equals(((TianShuAccess.MapEntry)localObject3).key.get()))
          {
            localObject3 = ((TianShuAccess.MapEntry)localObject3).value.get();
            localObject1 = localObject2;
            localObject2 = localObject3;
            break label396;
          }
          if ("url".equals(((TianShuAccess.MapEntry)localObject3).key.get()))
          {
            localObject3 = ((TianShuAccess.MapEntry)localObject3).value.get();
            localObject2 = localObject1;
            localObject1 = localObject3;
            break label396;
          }
          if ("pic".equals(((TianShuAccess.MapEntry)localObject3).key.get()))
          {
            paramJSONObject = ((TianShuAccess.MapEntry)localObject3).value.get();
            localObject3 = localObject1;
            localObject1 = localObject2;
            localObject2 = localObject3;
            break label396;
          }
        }
        else
        {
          QMLog.i("FloatDragAdDataManager", "handleTianShuResponse type:" + localObject1 + ", jumpUrl:" + localObject2 + ", pictureUrl:" + paramJSONObject);
          paramString = new FloatDragAdInfo.Builder().adItem(localAdItem).type(localObject1).pictureUrl(paramJSONObject).jumpUrl(localObject2).appId(paramString).scene(paramInt).build();
          return paramString;
        }
      }
      catch (JSONException paramString)
      {
        QMLog.e("FloatDragAdDataManager", "parse Ad Data Exception ", paramString);
        return null;
      }
      Object localObject3 = localObject1;
      Object localObject1 = localObject2;
      Object localObject2 = localObject3;
      label396:
      localObject3 = localObject2;
      localObject2 = localObject1;
      localObject1 = localObject3;
    }
  }
  
  public static void requestAd(Activity paramActivity, IMiniAppContext paramIMiniAppContext, String paramString, int paramInt)
  {
    ThreadManager.getSubThreadHandler().post(new FloatDragAdDataManager.1(paramActivity, paramIMiniAppContext, paramString, paramInt));
  }
  
  private static void requestTianShu(Context paramContext, IMiniAppContext paramIMiniAppContext, String paramString, int paramInt)
  {
    if (paramString == null) {}
    do
    {
      return;
      QMLog.i("FloatDragAdDataManager", "requestTianShu with appId=" + paramString + " scene=" + paramInt);
    } while (((ChannelProxy)ProxyManager.get(ChannelProxy.class)).tianshuRequestAdv(paramContext, paramString, paramInt, 473, 1, new FloatDragAdDataManager.2(paramString, paramInt, paramIMiniAppContext)));
    QMLog.e("FloatDragAdDataManager", "requestTianShu isImpl=false");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.qqmini.minigame.manager.FloatDragAdDataManager
 * JD-Core Version:    0.7.0.1
 */