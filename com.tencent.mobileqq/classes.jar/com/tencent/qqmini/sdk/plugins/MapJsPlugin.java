package com.tencent.qqmini.sdk.plugins;

import android.app.Activity;
import android.content.Context;
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
      Activity localActivity = this.mMiniAppContext.getAttachedActivity();
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("暂不支持在");
      localStringBuilder.append(QUAUtil.getApplicationName(this.mContext));
      localStringBuilder.append("中选择定位");
      MiniToast.makeText(localActivity, 0, localStringBuilder.toString(), 1);
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
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append(paramRequestEvent.event);
      localStringBuilder.append(" error, ");
      QMLog.e("MapJsPlugin", localStringBuilder.toString(), localException);
      paramRequestEvent.fail();
    }
  }
  
  public void getLocationJsonObject(RequestEvent paramRequestEvent, String paramString1, String paramString2, ApiUtil.OnLocationFinish paramOnLocationFinish)
  {
    if ((!"gcj02".equals(paramString1)) && (!"wgs84".equals(paramString1)))
    {
      QMLog.e("MapJsPlugin", "getLocationJsonObject type is not support.");
      paramRequestEvent.fail("invalid data,type error");
      return;
    }
    if (((this.mMiniAppContext instanceof BaseRuntime)) && (!((BaseRuntime)this.mMiniAppContext).isForground()))
    {
      paramRequestEvent.fail("app is not in the forground.");
      return;
    }
    boolean bool = TextUtils.isEmpty(paramString2);
    if (!((MiniAppProxy)ProxyManager.get(MiniAppProxy.class)).getLocation(this.mMiniAppContext.getAttachedActivity(), paramString1, bool ^ true, new MapJsPlugin.3(this, paramOnLocationFinish, paramRequestEvent)))
    {
      paramString1 = this.mMiniAppContext.getAttachedActivity();
      paramString2 = new StringBuilder();
      paramString2.append("暂不支持在");
      paramString2.append(QUAUtil.getApplicationName(this.mContext));
      paramString2.append("中定位");
      MiniToast.makeText(paramString1, 0, paramString2.toString(), 1);
      paramRequestEvent.fail("app not implement");
    }
  }
  
  @JsEvent({"openLocation"})
  public void openLocation(RequestEvent paramRequestEvent)
  {
    try
    {
      localObject2 = new JSONObject(paramRequestEvent.jsonParams);
      double d1 = ((JSONObject)localObject2).optDouble("latitude");
      double d2 = ((JSONObject)localObject2).optDouble("longitude");
      int i = ((JSONObject)localObject2).optInt("scale", 18);
      Object localObject1 = ((JSONObject)localObject2).optString("name");
      localObject2 = ((JSONObject)localObject2).optString("address");
      if (!((MiniAppProxy)ProxyManager.get(MiniAppProxy.class)).openLocation(this.mMiniAppContext.getAttachedActivity(), d1, d2, i, (String)localObject1, (String)localObject2))
      {
        localObject1 = this.mMiniAppContext.getAttachedActivity();
        localObject2 = new StringBuilder();
        ((StringBuilder)localObject2).append("暂不支持在");
        ((StringBuilder)localObject2).append(QUAUtil.getApplicationName(this.mContext));
        ((StringBuilder)localObject2).append("中打开地图");
        MiniToast.makeText((Context)localObject1, 0, ((StringBuilder)localObject2).toString(), 1);
        paramRequestEvent.fail("app not implement");
        return;
      }
      paramRequestEvent.ok();
      return;
    }
    catch (Exception localException)
    {
      Object localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append(paramRequestEvent.event);
      ((StringBuilder)localObject2).append(" error, ");
      QMLog.e("MapJsPlugin", ((StringBuilder)localObject2).toString(), localException);
      paramRequestEvent.fail();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.qqmini.sdk.plugins.MapJsPlugin
 * JD-Core Version:    0.7.0.1
 */