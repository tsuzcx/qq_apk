package com.tencent.qqmini.sdk.core.plugins;

import android.text.TextUtils;
import bgho;
import bgkd;
import bgkj;
import bgnf;
import com.tencent.qqmini.sdk.core.proxy.MiniAppProxy;
import com.tencent.qqmini.sdk.core.proxy.ProxyManager;
import com.tencent.qqmini.sdk.log.QMLog;
import com.tencent.qqmini.sdk.utils.QUAUtil;
import org.json.JSONObject;

public class MapJsPlugin
  extends BaseJsPlugin
{
  public static final String LOCATION_TYPE_02 = "gcj02";
  public static final String LOCATION_TYPE_84 = "wgs84";
  private static final String TAG = "MapJsPlugin";
  
  public void chooseLocation(bgkd parambgkd)
  {
    if (!((MiniAppProxy)ProxyManager.get(MiniAppProxy.class)).chooseLocation(this.mMiniAppContext.a(), new MapJsPlugin.2(this, parambgkd)))
    {
      bgnf.a(this.mMiniAppContext.a(), 0, "暂不支持在" + QUAUtil.getApplicationName(this.mContext) + "中选择定位", 1);
      parambgkd.a("app not implement");
      return;
    }
    parambgkd.a();
  }
  
  public void getLocation(bgkd parambgkd)
  {
    try
    {
      JSONObject localJSONObject = new JSONObject(parambgkd.b);
      getLocationJsonObject(parambgkd, localJSONObject.optString("type"), localJSONObject.optString("altitude"), new MapJsPlugin.1(this, parambgkd));
      return;
    }
    catch (Exception localException)
    {
      QMLog.e("MapJsPlugin", parambgkd.a + " error, ", localException);
      parambgkd.b();
    }
  }
  
  public void getLocationJsonObject(bgkd parambgkd, String paramString1, String paramString2, bgkj parambgkj)
  {
    if ((!"gcj02".equals(paramString1)) && (!"wgs84".equals(paramString1)))
    {
      QMLog.e("MapJsPlugin", "getLocationJsonObject type is not support.");
      parambgkd.a("invalid data,type error");
    }
    for (;;)
    {
      return;
      if (!TextUtils.isEmpty(paramString2)) {}
      for (boolean bool = true; !((MiniAppProxy)ProxyManager.get(MiniAppProxy.class)).getLocation(this.mMiniAppContext.a(), paramString1, bool, new MapJsPlugin.3(this, parambgkj, parambgkd)); bool = false)
      {
        bgnf.a(this.mMiniAppContext.a(), 0, "暂不支持在" + QUAUtil.getApplicationName(this.mContext) + "中定位", 1);
        parambgkd.a("app not implement");
        return;
      }
    }
  }
  
  public void openLocation(bgkd parambgkd)
  {
    try
    {
      Object localObject = new JSONObject(parambgkd.b);
      double d1 = ((JSONObject)localObject).optDouble("latitude");
      double d2 = ((JSONObject)localObject).optDouble("longitude");
      int i = ((JSONObject)localObject).optInt("scale", 18);
      String str = ((JSONObject)localObject).optString("name");
      localObject = ((JSONObject)localObject).optString("address");
      if (!((MiniAppProxy)ProxyManager.get(MiniAppProxy.class)).openLocation(this.mMiniAppContext.a(), d1, d2, i, str, (String)localObject))
      {
        bgnf.a(this.mMiniAppContext.a(), 0, "暂不支持在" + QUAUtil.getApplicationName(this.mContext) + "中打开地图", 1);
        parambgkd.a("app not implement");
        return;
      }
      parambgkd.a();
      return;
    }
    catch (Exception localException)
    {
      QMLog.e("MapJsPlugin", parambgkd.a + " error, ", localException);
      parambgkd.b();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.qqmini.sdk.core.plugins.MapJsPlugin
 * JD-Core Version:    0.7.0.1
 */