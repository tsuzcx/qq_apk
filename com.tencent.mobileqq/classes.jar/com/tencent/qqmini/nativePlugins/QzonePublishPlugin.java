package com.tencent.qqmini.nativePlugins;

import android.text.TextUtils;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqmini.sdk.annotation.JsEvent;
import com.tencent.qqmini.sdk.annotation.JsPlugin;
import com.tencent.qqmini.sdk.launcher.core.IMiniAppContext;
import com.tencent.qqmini.sdk.launcher.core.model.RequestEvent;
import com.tencent.qqmini.sdk.launcher.core.plugins.BaseJsPlugin;
import com.tencent.qqmini.sdk.launcher.shell.IMiniAppFileManager;
import cooperation.qzone.LbsDataV2.PoiInfo;
import cooperation.qzone.QZoneHelper;
import cooperation.qzone.QZoneHelper.UserInfo;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

@JsPlugin(secondary=true)
public class QzonePublishPlugin
  extends BaseJsPlugin
{
  private JSONObject a(RequestEvent paramRequestEvent)
  {
    try
    {
      localObject = new JSONObject(paramRequestEvent.jsonParams);
      return localObject;
    }
    catch (JSONException localJSONException)
    {
      Object localObject;
      label14:
      break label14;
    }
    localObject = new StringBuilder();
    ((StringBuilder)localObject).append("Failed to parse jsonParams=");
    ((StringBuilder)localObject).append(paramRequestEvent.jsonParams);
    QLog.e("[mini] QzonePublishPlugin", 1, ((StringBuilder)localObject).toString());
    return null;
  }
  
  @JsEvent({"checkin_qzoneUploadAndPublish"})
  public void checkinQzoneUploadAndPublish(RequestEvent paramRequestEvent)
  {
    int i = 0;
    Object localObject3 = null;
    Object localObject1;
    try
    {
      localObject1 = a(paramRequestEvent).optJSONObject("data");
    }
    catch (Throwable localThrowable)
    {
      QLog.e("[mini] QzonePublishPlugin", 1, localThrowable, new Object[0]);
      localObject1 = null;
    }
    if (localObject1 != null) {}
    for (;;)
    {
      try
      {
        String str2 = (String)((JSONObject)localObject1).opt("uin");
        String str3 = (String)((JSONObject)localObject1).opt("content");
        String str1 = (String)((JSONObject)localObject1).opt("filePath");
        if (TextUtils.isEmpty(str1)) {
          break label550;
        }
        str1 = ((IMiniAppFileManager)this.mMiniAppContext.getManager(IMiniAppFileManager.class)).getAbsolutePath(str1);
        int j = ((JSONObject)localObject1).optInt("issynctoweibo");
        localObject2 = ((JSONObject)localObject1).getJSONObject("lbsinfo");
        LbsDataV2.PoiInfo localPoiInfo = new LbsDataV2.PoiInfo();
        if (localObject2 != null)
        {
          double d1 = ((JSONObject)localObject2).optDouble("lbs_x");
          double d2 = ((JSONObject)localObject2).optDouble("lbs_y");
          ((JSONObject)localObject2).optInt("lbs_type");
          localObject2 = ((JSONObject)localObject2).optString("lbs_nm");
          localPoiInfo.gpsInfo.lon = ((int)(d1 * 1000000.0D));
          localPoiInfo.gpsInfo.lat = ((int)(d2 * 1000000.0D));
          localPoiInfo.poiName = ((String)localObject2);
        }
        localObject2 = ((JSONObject)localObject1).getJSONObject("source");
        if (localObject2 == null) {
          break label553;
        }
        localObject2 = ((JSONObject)localObject2).optString("subtype");
        HashMap localHashMap = new HashMap();
        Object localObject4 = ((JSONObject)localObject1).getJSONObject("extend_info");
        if (localObject4 != null)
        {
          localObject5 = ((JSONObject)localObject4).keys();
          if (((Iterator)localObject5).hasNext())
          {
            localObject6 = (String)((Iterator)localObject5).next();
            localHashMap.put(localObject6, ((JSONObject)localObject4).optString((String)localObject6));
            continue;
          }
        }
        Object localObject5 = new ArrayList();
        Object localObject6 = ((JSONObject)localObject1).getJSONObject("right_info");
        if (localObject6 != null)
        {
          localObject4 = ((JSONObject)localObject6).optString("ugc_right");
          localObject6 = ((JSONObject)localObject6).optJSONArray("allow_uins");
          localObject3 = localObject4;
          if (localObject6 != null)
          {
            localObject3 = localObject4;
            if (i < ((JSONArray)localObject6).length())
            {
              ((ArrayList)localObject5).add((String)((JSONArray)localObject6).get(i));
              i += 1;
              continue;
            }
          }
        }
        localObject4 = new HashMap();
        localObject1 = ((JSONObject)localObject1).getJSONObject("stored_extend_info");
        if (localObject1 != null)
        {
          localObject6 = ((JSONObject)localObject1).keys();
          if (((Iterator)localObject6).hasNext())
          {
            String str4 = (String)((Iterator)localObject6).next();
            ((HashMap)localObject4).put(str4, ((JSONObject)localObject1).optString(str4));
            continue;
          }
        }
        localObject1 = new ArrayList();
        ((ArrayList)localObject1).add(str1);
        QZoneHelper.UserInfo.getInstance().qzone_uin = str2;
        QZoneHelper.publishPictureMoodSilently(str3, (ArrayList)localObject1, j, localPoiInfo, (String)localObject2, localObject3, (ArrayList)localObject5, (HashMap)localObject4, localHashMap, "value.videoSign", 2);
        paramRequestEvent.ok();
        return;
      }
      catch (Exception paramRequestEvent)
      {
        if (!QLog.isColorLevel()) {
          break label549;
        }
      }
      QLog.e("[mini] QzonePublishPlugin", 2, "QzonePublishPlugin onInvoke error:", paramRequestEvent);
      return;
      paramRequestEvent.fail("data == null");
      label549:
      return;
      label550:
      continue;
      label553:
      Object localObject2 = null;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.qqmini.nativePlugins.QzonePublishPlugin
 * JD-Core Version:    0.7.0.1
 */