package com.tencent.mobileqq.mini.out.nativePlugins;

import android.text.TextUtils;
import com.tencent.mobileqq.mini.appbrand.utils.MiniAppFileManager;
import com.tencent.mobileqq.mini.out.nativePlugins.foundation.JSContext;
import com.tencent.mobileqq.mini.out.nativePlugins.foundation.NativePlugin;
import com.tencent.qphone.base.util.QLog;
import cooperation.qzone.LbsDataV2.PoiInfo;
import cooperation.qzone.QZoneHelper;
import cooperation.qzone.QZoneHelper.UserInfo;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import org.json.JSONArray;
import org.json.JSONObject;

public class QzonePublishPlugin
  implements NativePlugin
{
  public static final String API_NAVIGATE_TO_PUBLISH_PROGRAM = "checkin_qzoneUploadAndPublish";
  private static final String TAG = "[mini] QzonePublishPlugin";
  
  public void onDestroy() {}
  
  public void onInvoke(JSONObject paramJSONObject, JSContext paramJSContext)
  {
    Object localObject1;
    try
    {
      localObject1 = paramJSONObject.optJSONObject("data");
    }
    catch (Throwable paramJSONObject)
    {
      QLog.e("[mini] QzonePublishPlugin", 1, paramJSONObject, new Object[0]);
      localObject1 = null;
    }
    if (localObject1 != null) {}
    for (;;)
    {
      try
      {
        String str1 = (String)((JSONObject)localObject1).opt("uin");
        String str2 = (String)((JSONObject)localObject1).opt("content");
        localObject2 = (String)((JSONObject)localObject1).opt("filePath");
        paramJSONObject = (JSONObject)localObject2;
        if (!TextUtils.isEmpty((CharSequence)localObject2)) {
          paramJSONObject = MiniAppFileManager.getInstance().getAbsolutePath((String)localObject2);
        }
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
          break label534;
        }
        localObject2 = ((JSONObject)localObject2).optString("subtype");
        HashMap localHashMap = new HashMap();
        localObject3 = ((JSONObject)localObject1).getJSONObject("extend_info");
        if (localObject3 != null)
        {
          localObject4 = ((JSONObject)localObject3).keys();
          if (((Iterator)localObject4).hasNext())
          {
            localObject5 = (String)((Iterator)localObject4).next();
            localHashMap.put(localObject5, ((JSONObject)localObject3).optString((String)localObject5));
            continue;
          }
        }
        Object localObject5 = new ArrayList();
        localObject3 = ((JSONObject)localObject1).getJSONObject("right_info");
        if (localObject3 == null) {
          break label540;
        }
        Object localObject4 = ((JSONObject)localObject3).optString("ugc_right");
        Object localObject6 = ((JSONObject)localObject3).optJSONArray("allow_uins");
        localObject3 = localObject4;
        if (localObject6 != null)
        {
          int i = 0;
          localObject3 = localObject4;
          if (i < ((JSONArray)localObject6).length())
          {
            ((ArrayList)localObject5).add((String)((JSONArray)localObject6).get(i));
            i += 1;
            continue;
          }
        }
        localObject4 = new HashMap();
        localObject6 = ((JSONObject)localObject1).getJSONObject("stored_extend_info");
        if (localObject6 != null)
        {
          localObject1 = ((JSONObject)localObject6).keys();
          if (((Iterator)localObject1).hasNext())
          {
            String str3 = (String)((Iterator)localObject1).next();
            ((HashMap)localObject4).put(str3, ((JSONObject)localObject6).optString(str3));
            continue;
          }
        }
        localObject1 = new ArrayList();
        ((ArrayList)localObject1).add(paramJSONObject);
        QZoneHelper.UserInfo.getInstance().qzone_uin = str1;
        QZoneHelper.publishPictureMoodSilently(str2, (ArrayList)localObject1, j, localPoiInfo, (String)localObject2, (String)localObject3, (ArrayList)localObject5, (HashMap)localObject4, localHashMap, "value.videoSign", 2);
        paramJSContext.evaluateCallback(true, null, "");
        return;
      }
      catch (Exception paramJSONObject)
      {
        if (!QLog.isColorLevel()) {
          break label533;
        }
      }
      QLog.e("[mini] QzonePublishPlugin", 2, "QzonePublishPlugin onInvoke error:", paramJSONObject);
      return;
      paramJSContext.evaluateCallback(false, null, "data == null");
      label533:
      return;
      label534:
      Object localObject2 = null;
      continue;
      label540:
      Object localObject3 = "";
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.mobileqq.mini.out.nativePlugins.QzonePublishPlugin
 * JD-Core Version:    0.7.0.1
 */