package com.tencent.qqmini.sdk.plugins;

import android.text.TextUtils;
import com.tencent.qqmini.sdk.annotation.JsEvent;
import com.tencent.qqmini.sdk.annotation.JsPlugin;
import com.tencent.qqmini.sdk.core.proxy.ProxyManager;
import com.tencent.qqmini.sdk.launcher.core.BaseRuntime;
import com.tencent.qqmini.sdk.launcher.core.IMiniAppContext;
import com.tencent.qqmini.sdk.launcher.core.model.RequestEvent;
import com.tencent.qqmini.sdk.launcher.core.plugins.BaseJsPlugin;
import com.tencent.qqmini.sdk.launcher.core.proxy.MiniAppProxy;
import com.tencent.qqmini.sdk.launcher.core.utils.ApiUtil.OnLocationFinish;
import com.tencent.qqmini.sdk.launcher.log.QMLog;
import com.tencent.qqmini.sdk.utils.QUAUtil;
import com.tencent.qqmini.sdk.widget.MiniToast;
import org.json.JSONObject;

@JsPlugin
public class MapJsPlugin
  extends BaseJsPlugin
{
  public static final String LOCATION_TYPE_02 = "gcj02";
  public static final String LOCATION_TYPE_84 = "wgs84";
  private static final String TAG = "MapJsPlugin";
  
  @JsEvent({"chooseLocation"})
  public void chooseLocation(RequestEvent paramRequestEvent)
  {
    if (!((MiniAppProxy)ProxyManager.get(MiniAppProxy.class)).chooseLocation(this.mMiniAppContext.getAttachedActivity(), new MapJsPlugin.2(this, paramRequestEvent)))
    {
      MiniToast.makeText(this.mMiniAppContext.getAttachedActivity(), 0, "暂不支持在" + QUAUtil.getApplicationName(this.mContext) + "中选择定位", 1);
      paramRequestEvent.fail("app not implement");
    }
  }
  
  @JsEvent({"getLocation"})
  public void getLocation(RequestEvent paramRequestEvent)
  {
    try
    {
      JSONObject localJSONObject = new JSONObject(paramRequestEvent.jsonParams);
      getLocationJsonObject(paramRequestEvent, localJSONObject.optString("type"), localJSONObject.optString("altitude"), new MapJsPlugin.1(this, paramRequestEvent));
      return;
    }
    catch (Exception localException)
    {
      QMLog.e("MapJsPlugin", paramRequestEvent.event + " error, ", localException);
      paramRequestEvent.fail();
    }
  }
  
  public void getLocationJsonObject(RequestEvent paramRequestEvent, String paramString1, String paramString2, ApiUtil.OnLocationFinish paramOnLocationFinish)
  {
    if ((!"gcj02".equals(paramString1)) && (!"wgs84".equals(paramString1)))
    {
      QMLog.e("MapJsPlugin", "getLocationJsonObject type is not support.");
      paramRequestEvent.fail("invalid data,type error");
    }
    for (;;)
    {
      return;
      if (((this.mMiniAppContext instanceof BaseRuntime)) && (!((BaseRuntime)this.mMiniAppContext).isForground()))
      {
        paramRequestEvent.fail("app is not in the forground.");
        return;
      }
      if (!TextUtils.isEmpty(paramString2)) {}
      for (boolean bool = true; !((MiniAppProxy)ProxyManager.get(MiniAppProxy.class)).getLocation(this.mMiniAppContext.getAttachedActivity(), paramString1, bool, new MapJsPlugin.3(this, paramOnLocationFinish, paramRequestEvent)); bool = false)
      {
        MiniToast.makeText(this.mMiniAppContext.getAttachedActivity(), 0, "暂不支持在" + QUAUtil.getApplicationName(this.mContext) + "中定位", 1);
        paramRequestEvent.fail("app not implement");
        return;
      }
    }
  }
  
  @JsEvent({"openLocation"})
  public void openLocation(RequestEvent paramRequestEvent)
  {
    try
    {
      Object localObject = new JSONObject(paramRequestEvent.jsonParams);
      double d1 = ((JSONObject)localObject).optDouble("latitude");
      double d2 = ((JSONObject)localObject).optDouble("longitude");
      int i = ((JSONObject)localObject).optInt("scale", 18);
      String str = ((JSONObject)localObject).optString("name");
      localObject = ((JSONObject)localObject).optString("address");
      if (!((MiniAppProxy)ProxyManager.get(MiniAppProxy.class)).openLocation(this.mMiniAppContext.getAttachedActivity(), d1, d2, i, str, (String)localObject))
      {
        MiniToast.makeText(this.mMiniAppContext.getAttachedActivity(), 0, "暂不支持在" + QUAUtil.getApplicationName(this.mContext) + "中打开地图", 1);
        paramRequestEvent.fail("app not implement");
        return;
      }
      paramRequestEvent.ok();
      return;
    }
    catch (Exception localException)
    {
      QMLog.e("MapJsPlugin", paramRequestEvent.event + " error, ", localException);
      paramRequestEvent.fail();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.qqmini.sdk.plugins.MapJsPlugin
 * JD-Core Version:    0.7.0.1
 */