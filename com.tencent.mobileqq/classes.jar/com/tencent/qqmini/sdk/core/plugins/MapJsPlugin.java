package com.tencent.qqmini.sdk.core.plugins;

import android.text.TextUtils;
import behq;
import bekr;
import beky;
import benn;
import betc;
import bfhk;
import com.tencent.qqmini.sdk.core.proxy.MiniAppProxy;
import com.tencent.qqmini.sdk.core.proxy.ProxyManager;
import org.json.JSONObject;

public class MapJsPlugin
  extends BaseJsPlugin
{
  public static final String LOCATION_TYPE_02 = "gcj02";
  public static final String LOCATION_TYPE_84 = "wgs84";
  private static final String TAG = "MapJsPlugin";
  
  public void chooseLocation(bekr parambekr)
  {
    if (!((MiniAppProxy)ProxyManager.get(MiniAppProxy.class)).chooseLocation(this.mMiniAppContext.a(), new MapJsPlugin.2(this, parambekr)))
    {
      benn.a(this.mMiniAppContext.a(), 0, "暂不支持在" + bfhk.a(this.mContext) + "中选择定位", 1);
      parambekr.a("app not implement");
      return;
    }
    parambekr.a();
  }
  
  public void getLocation(bekr parambekr)
  {
    try
    {
      JSONObject localJSONObject = new JSONObject(parambekr.b);
      getLocationJsonObject(parambekr, localJSONObject.optString("type"), localJSONObject.optString("altitude"), new MapJsPlugin.1(this, parambekr));
      return;
    }
    catch (Exception localException)
    {
      betc.d("MapJsPlugin", parambekr.a + " error, ", localException);
      parambekr.b();
    }
  }
  
  public void getLocationJsonObject(bekr parambekr, String paramString1, String paramString2, beky parambeky)
  {
    if ((!"gcj02".equals(paramString1)) && (!"wgs84".equals(paramString1)))
    {
      betc.d("MapJsPlugin", "getLocationJsonObject type is not support.");
      parambekr.a("invalid data,type error");
    }
    for (;;)
    {
      return;
      if (!TextUtils.isEmpty(paramString2)) {}
      for (boolean bool = true; !((MiniAppProxy)ProxyManager.get(MiniAppProxy.class)).getLocation(this.mMiniAppContext.a(), paramString1, bool, new MapJsPlugin.3(this, parambeky, parambekr)); bool = false)
      {
        benn.a(this.mMiniAppContext.a(), 0, "暂不支持在" + bfhk.a(this.mContext) + "中定位", 1);
        parambekr.a("app not implement");
        return;
      }
    }
  }
  
  public void openLocation(bekr parambekr)
  {
    try
    {
      Object localObject = new JSONObject(parambekr.b);
      double d1 = ((JSONObject)localObject).optDouble("latitude");
      double d2 = ((JSONObject)localObject).optDouble("longitude");
      int i = ((JSONObject)localObject).optInt("scale", 18);
      String str = ((JSONObject)localObject).optString("name");
      localObject = ((JSONObject)localObject).optString("address");
      if (!((MiniAppProxy)ProxyManager.get(MiniAppProxy.class)).openLocation(this.mMiniAppContext.a(), d1, d2, i, str, (String)localObject))
      {
        benn.a(this.mMiniAppContext.a(), 0, "暂不支持在" + bfhk.a(this.mContext) + "中打开地图", 1);
        parambekr.a("app not implement");
        return;
      }
      parambekr.a();
      return;
    }
    catch (Exception localException)
    {
      betc.d("MapJsPlugin", parambekr.a + " error, ", localException);
      parambekr.b();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.qqmini.sdk.core.plugins.MapJsPlugin
 * JD-Core Version:    0.7.0.1
 */