package com.tencent.qqmini.sdk.core.plugins;

import android.text.TextUtils;
import bdcz;
import bdfz;
import bdgh;
import bdit;
import bdnw;
import bdzd;
import com.tencent.qqmini.sdk.core.proxy.MiniAppProxy;
import com.tencent.qqmini.sdk.core.proxy.ProxyManager;
import org.json.JSONObject;

public class MapJsPlugin
  extends BaseJsPlugin
{
  public static final String LOCATION_TYPE_02 = "gcj02";
  public static final String LOCATION_TYPE_84 = "wgs84";
  private static final String TAG = "MapJsPlugin";
  
  public void chooseLocation(bdfz parambdfz)
  {
    if (!((MiniAppProxy)ProxyManager.get(MiniAppProxy.class)).chooseLocation(this.mMiniAppContext.a(), new MapJsPlugin.2(this, parambdfz)))
    {
      bdit.a(this.mMiniAppContext.a(), 0, "暂不支持在" + bdzd.a(this.mContext) + "中选择定位", 1);
      parambdfz.a("app not implement");
      return;
    }
    parambdfz.a();
  }
  
  public void getLocation(bdfz parambdfz)
  {
    try
    {
      JSONObject localJSONObject = new JSONObject(parambdfz.b);
      getLocationJsonObject(parambdfz, localJSONObject.optString("type"), localJSONObject.optString("altitude"), new MapJsPlugin.1(this, parambdfz));
      return;
    }
    catch (Exception localException)
    {
      bdnw.d("MapJsPlugin", parambdfz.a + " error, ", localException);
      parambdfz.b();
    }
  }
  
  public void getLocationJsonObject(bdfz parambdfz, String paramString1, String paramString2, bdgh parambdgh)
  {
    if ((!"gcj02".equals(paramString1)) && (!"wgs84".equals(paramString1)))
    {
      bdnw.d("MapJsPlugin", "getLocationJsonObject type is not support.");
      parambdfz.a("invalid data,type error");
    }
    for (;;)
    {
      return;
      if (!TextUtils.isEmpty(paramString2)) {}
      for (boolean bool = true; !((MiniAppProxy)ProxyManager.get(MiniAppProxy.class)).getLocation(paramString1, bool, new MapJsPlugin.3(this, parambdgh, parambdfz)); bool = false)
      {
        bdit.a(this.mMiniAppContext.a(), 0, "暂不支持在" + bdzd.a(this.mContext) + "中定位", 1);
        parambdfz.a("app not implement");
        return;
      }
    }
  }
  
  public void openLocation(bdfz parambdfz)
  {
    try
    {
      Object localObject = new JSONObject(parambdfz.b);
      double d1 = ((JSONObject)localObject).optDouble("latitude");
      double d2 = ((JSONObject)localObject).optDouble("longitude");
      int i = ((JSONObject)localObject).optInt("scale", 18);
      String str = ((JSONObject)localObject).optString("name");
      localObject = ((JSONObject)localObject).optString("address");
      if (!((MiniAppProxy)ProxyManager.get(MiniAppProxy.class)).openLocation(this.mMiniAppContext.a(), d1, d2, i, str, (String)localObject))
      {
        bdit.a(this.mMiniAppContext.a(), 0, "暂不支持在" + bdzd.a(this.mContext) + "中打开地图", 1);
        parambdfz.a("app not implement");
        return;
      }
      parambdfz.a();
      return;
    }
    catch (Exception localException)
    {
      bdnw.d("MapJsPlugin", parambdfz.a + " error, ", localException);
      parambdfz.b();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.qqmini.sdk.core.plugins.MapJsPlugin
 * JD-Core Version:    0.7.0.1
 */