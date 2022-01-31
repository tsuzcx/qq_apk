package com.tencent.qqmini.sdk.core.plugins;

import android.text.TextUtils;
import begz;
import beka;
import bekh;
import bemw;
import besl;
import bfgt;
import com.tencent.qqmini.sdk.core.proxy.MiniAppProxy;
import com.tencent.qqmini.sdk.core.proxy.ProxyManager;
import org.json.JSONObject;

public class MapJsPlugin
  extends BaseJsPlugin
{
  public static final String LOCATION_TYPE_02 = "gcj02";
  public static final String LOCATION_TYPE_84 = "wgs84";
  private static final String TAG = "MapJsPlugin";
  
  public void chooseLocation(beka parambeka)
  {
    if (!((MiniAppProxy)ProxyManager.get(MiniAppProxy.class)).chooseLocation(this.mMiniAppContext.a(), new MapJsPlugin.2(this, parambeka)))
    {
      bemw.a(this.mMiniAppContext.a(), 0, "暂不支持在" + bfgt.a(this.mContext) + "中选择定位", 1);
      parambeka.a("app not implement");
      return;
    }
    parambeka.a();
  }
  
  public void getLocation(beka parambeka)
  {
    try
    {
      JSONObject localJSONObject = new JSONObject(parambeka.b);
      getLocationJsonObject(parambeka, localJSONObject.optString("type"), localJSONObject.optString("altitude"), new MapJsPlugin.1(this, parambeka));
      return;
    }
    catch (Exception localException)
    {
      besl.d("MapJsPlugin", parambeka.a + " error, ", localException);
      parambeka.b();
    }
  }
  
  public void getLocationJsonObject(beka parambeka, String paramString1, String paramString2, bekh parambekh)
  {
    if ((!"gcj02".equals(paramString1)) && (!"wgs84".equals(paramString1)))
    {
      besl.d("MapJsPlugin", "getLocationJsonObject type is not support.");
      parambeka.a("invalid data,type error");
    }
    for (;;)
    {
      return;
      if (!TextUtils.isEmpty(paramString2)) {}
      for (boolean bool = true; !((MiniAppProxy)ProxyManager.get(MiniAppProxy.class)).getLocation(this.mMiniAppContext.a(), paramString1, bool, new MapJsPlugin.3(this, parambekh, parambeka)); bool = false)
      {
        bemw.a(this.mMiniAppContext.a(), 0, "暂不支持在" + bfgt.a(this.mContext) + "中定位", 1);
        parambeka.a("app not implement");
        return;
      }
    }
  }
  
  public void openLocation(beka parambeka)
  {
    try
    {
      Object localObject = new JSONObject(parambeka.b);
      double d1 = ((JSONObject)localObject).optDouble("latitude");
      double d2 = ((JSONObject)localObject).optDouble("longitude");
      int i = ((JSONObject)localObject).optInt("scale", 18);
      String str = ((JSONObject)localObject).optString("name");
      localObject = ((JSONObject)localObject).optString("address");
      if (!((MiniAppProxy)ProxyManager.get(MiniAppProxy.class)).openLocation(this.mMiniAppContext.a(), d1, d2, i, str, (String)localObject))
      {
        bemw.a(this.mMiniAppContext.a(), 0, "暂不支持在" + bfgt.a(this.mContext) + "中打开地图", 1);
        parambeka.a("app not implement");
        return;
      }
      parambeka.a();
      return;
    }
    catch (Exception localException)
    {
      besl.d("MapJsPlugin", parambeka.a + " error, ", localException);
      parambeka.b();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.qqmini.sdk.core.plugins.MapJsPlugin
 * JD-Core Version:    0.7.0.1
 */