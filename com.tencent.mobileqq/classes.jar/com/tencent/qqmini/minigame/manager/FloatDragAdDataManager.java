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
  
  private static FloatDragAdInfo getFloatDragAdInfo(String paramString, int paramInt, TianShuAccess.AdItem paramAdItem)
  {
    Object localObject = paramAdItem.argList.get().iterator();
    String str3 = null;
    String str2 = null;
    String str1 = str2;
    while (((Iterator)localObject).hasNext())
    {
      TianShuAccess.MapEntry localMapEntry = (TianShuAccess.MapEntry)((Iterator)localObject).next();
      if ("type".equals(localMapEntry.key.get())) {
        str3 = localMapEntry.value.get();
      } else if ("url".equals(localMapEntry.key.get())) {
        str2 = localMapEntry.value.get();
      } else if ("pic".equals(localMapEntry.key.get())) {
        str1 = localMapEntry.value.get();
      }
    }
    localObject = new StringBuilder();
    ((StringBuilder)localObject).append("handleTianShuResponse type:");
    ((StringBuilder)localObject).append(str3);
    ((StringBuilder)localObject).append(", jumpUrl:");
    ((StringBuilder)localObject).append(str2);
    ((StringBuilder)localObject).append(", pictureUrl:");
    ((StringBuilder)localObject).append(str1);
    QMLog.i("FloatDragAdDataManager", ((StringBuilder)localObject).toString());
    return new FloatDragAdInfo.Builder().adItem(paramAdItem).type(str3).pictureUrl(str1).jumpUrl(str2).appId(paramString).scene(paramInt).build();
  }
  
  private static FloatDragAdInfo handleTianShuResponse(String paramString, int paramInt, JSONObject paramJSONObject)
  {
    try
    {
      paramJSONObject = (TianShuAccess.GetAdsRsp)paramJSONObject.get("response");
      if ((paramJSONObject != null) && (!paramJSONObject.mapAds.isEmpty()))
      {
        paramJSONObject = (TianShuAccess.RspEntry)paramJSONObject.mapAds.get(0);
        if ((paramJSONObject != null) && (paramJSONObject.value != null) && (paramJSONObject.value.lst != null) && (!paramJSONObject.value.lst.isEmpty()))
        {
          paramJSONObject = (TianShuAccess.AdItem)paramJSONObject.value.lst.get(0);
          if ((paramJSONObject != null) && (paramJSONObject.argList != null) && (!paramJSONObject.argList.isEmpty())) {
            return getFloatDragAdInfo(paramString, paramInt, paramJSONObject);
          }
          QMLog.e("FloatDragAdDataManager", "handleTianShuResponse adItem is empty");
          return null;
        }
        QMLog.e("FloatDragAdDataManager", "handleTianShuResponse rspEntry is empty");
        return null;
      }
      QMLog.e("FloatDragAdDataManager", "handleTianShuResponse mapAds is empty");
      return null;
    }
    catch (JSONException paramString)
    {
      QMLog.e("FloatDragAdDataManager", "parse Ad Data Exception ", paramString);
    }
    return null;
  }
  
  public static void requestAd(Activity paramActivity, IMiniAppContext paramIMiniAppContext, String paramString, int paramInt)
  {
    ThreadManager.getSubThreadHandler().post(new FloatDragAdDataManager.1(paramActivity, paramIMiniAppContext, paramString, paramInt));
  }
  
  private static void requestTianShu(Context paramContext, IMiniAppContext paramIMiniAppContext, String paramString, int paramInt)
  {
    if (paramString == null) {
      return;
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("requestTianShu with appId=");
    localStringBuilder.append(paramString);
    localStringBuilder.append(" scene=");
    localStringBuilder.append(paramInt);
    QMLog.i("FloatDragAdDataManager", localStringBuilder.toString());
    if (!((ChannelProxy)ProxyManager.get(ChannelProxy.class)).tianshuRequestAdv(paramContext, paramString, paramInt, 473, 1, new FloatDragAdDataManager.2(paramString, paramInt, paramIMiniAppContext))) {
      QMLog.e("FloatDragAdDataManager", "requestTianShu isImpl=false");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     com.tencent.qqmini.minigame.manager.FloatDragAdDataManager
 * JD-Core Version:    0.7.0.1
 */