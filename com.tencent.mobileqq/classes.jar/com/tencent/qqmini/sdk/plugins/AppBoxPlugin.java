package com.tencent.qqmini.sdk.plugins;

import android.app.Activity;
import android.text.TextUtils;
import com.tencent.qqmini.sdk.annotation.JsEvent;
import com.tencent.qqmini.sdk.annotation.JsPlugin;
import com.tencent.qqmini.sdk.launcher.core.IJsService;
import com.tencent.qqmini.sdk.launcher.core.IMiniAppContext;
import com.tencent.qqmini.sdk.launcher.core.model.ApkgInfo;
import com.tencent.qqmini.sdk.launcher.core.model.RequestEvent;
import com.tencent.qqmini.sdk.launcher.core.plugins.BaseJsPlugin;
import com.tencent.qqmini.sdk.launcher.core.utils.ApiUtil;
import com.tencent.qqmini.sdk.launcher.log.QMLog;
import com.tencent.qqmini.sdk.utils.MiniSDKConst.AdConst;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import org.json.JSONObject;

@JsPlugin
public class AppBoxPlugin
  extends BaseJsPlugin
{
  public static final String API_OPERATE_APP_BOX = "operateAppBox";
  public static final String API_OPERATE_DESTROY = "destroy";
  public static final String API_OPERATE_LOAD = "load";
  public static final String API_OPERATE_SHOW = "show";
  private static final String ERRCODE = "errCode";
  private static final String ERRMSG = "errMsg";
  public static final String EVENT_APP_BOX_CLOSE = "onAppBoxClose";
  public static final String KEY_REF_ID = "biz_src_miniapp";
  public static final HashMap<Integer, String> S_CODE_MSG_MAP = MiniSDKConst.AdConst.CODE_MSG_MAP;
  private static final String TAG = "AppBoxPlugin";
  private Map<Integer, AppBoxPlugin.MiniAppBox> mAppBoxMap = new HashMap();
  
  static boolean isAdUnitIdValid(String paramString)
  {
    return !TextUtils.isEmpty(paramString);
  }
  
  AppBoxPlugin.MiniAppBox getMiniAppBox(int paramInt, String paramString, RequestEvent paramRequestEvent)
  {
    Object localObject2 = null;
    Object localObject1;
    if (this.mAppBoxMap.containsKey(Integer.valueOf(paramInt)))
    {
      paramString = (AppBoxPlugin.MiniAppBox)this.mAppBoxMap.get(Integer.valueOf(paramInt));
      if (paramString != null)
      {
        localObject1 = localObject2;
        if (this.mMiniAppContext != null) {
          localObject1 = this.mMiniAppContext.getAttachedActivity();
        }
        paramString.setJsService(paramRequestEvent.jsService);
        paramString.setActivity((Activity)localObject1);
      }
      return paramString;
    }
    if ((this.mMiniAppContext != null) && (this.mApkgInfo != null))
    {
      localObject1 = this.mApkgInfo.appId;
      label101:
      if (this.mMiniAppContext == null) {
        break label163;
      }
    }
    label163:
    for (Activity localActivity = this.mMiniAppContext.getAttachedActivity();; localActivity = null)
    {
      paramString = new AppBoxPlugin.MiniAppBox(this, localActivity, paramInt, paramString, (String)localObject1, paramRequestEvent.jsService);
      this.mAppBoxMap.put(Integer.valueOf(paramInt), paramString);
      break;
      localObject1 = "";
      break label101;
    }
  }
  
  public void onDestroy()
  {
    super.onDestroy();
    Iterator localIterator = this.mAppBoxMap.entrySet().iterator();
    while (localIterator.hasNext())
    {
      AppBoxPlugin.MiniAppBox localMiniAppBox = (AppBoxPlugin.MiniAppBox)((Map.Entry)localIterator.next()).getValue();
      if (localMiniAppBox != null) {
        localMiniAppBox.destroy();
      }
    }
  }
  
  @JsEvent({"operateAppBox"})
  public String operateAppBox(RequestEvent paramRequestEvent)
  {
    try
    {
      QMLog.e("AppBoxPlugin", "operateAppBox, jsonParams = " + paramRequestEvent.jsonParams);
      JSONObject localJSONObject1 = new JSONObject(paramRequestEvent.jsonParams);
      int i = localJSONObject1.optInt("id", -1);
      Object localObject = localJSONObject1.optString("adUnitId", null);
      if (!isAdUnitIdValid((String)localObject))
      {
        localJSONObject1 = ApiUtil.wrapCallbackFail(paramRequestEvent.event, localJSONObject1);
        localJSONObject1.put("errCode", 1002);
        localObject = localJSONObject1.toString();
        paramRequestEvent.fail(localJSONObject1, "广告单元无效");
        return localObject;
      }
      localObject = getMiniAppBox(i, (String)localObject, paramRequestEvent);
      String str = localJSONObject1.optString("type");
      int j = localJSONObject1.optInt("compId", -1);
      if ("load".equals(str)) {
        if (!((AppBoxPlugin.MiniAppBox)localObject).load(j, paramRequestEvent.callbackId))
        {
          localJSONObject1 = ApiUtil.wrapCallbackFail(paramRequestEvent.event, localJSONObject1);
          localJSONObject1.put("errCode", 1003);
          paramRequestEvent.fail(localJSONObject1, "内部错误");
        }
      }
      for (;;)
      {
        return "";
        if ("show".equals(str))
        {
          if ((this.mMiniAppContext != null) && (this.mMiniAppContext.getAttachedActivity() != null) && (((AppBoxPlugin.MiniAppBox)localObject).show(j, paramRequestEvent.callbackId))) {
            continue;
          }
          localJSONObject1 = ApiUtil.wrapCallbackFail(paramRequestEvent.event, localJSONObject1);
          localJSONObject1.put("errCode", 1003);
          paramRequestEvent.fail(localJSONObject1, "内部错误");
          continue;
        }
        try
        {
          localJSONObject2.put("errCode", 1003);
          paramRequestEvent.fail(localJSONObject2, "内部错误");
          return localJSONObject2.toString();
          if (!"destroy".equals(str)) {
            continue;
          }
          if (((AppBoxPlugin.MiniAppBox)localObject).destroy()) {}
          for (JSONObject localJSONObject2 = ApiUtil.wrapCallbackOk(paramRequestEvent.event, localJSONObject2);; localJSONObject2 = ApiUtil.wrapCallbackFail(paramRequestEvent.event, localJSONObject2, "内部错误").put("errCode", 1003).put("errMsg", "内部错误"))
          {
            paramRequestEvent.jsService.evaluateCallbackJs(paramRequestEvent.callbackId, localJSONObject2.toString());
            this.mAppBoxMap.remove(Integer.valueOf(i));
            break;
          }
        }
        catch (Throwable paramRequestEvent)
        {
          break label311;
        }
      }
    }
    catch (Throwable localThrowable)
    {
      QMLog.e("AppBoxPlugin", "operateAppBoxfailed e:", localThrowable);
      localJSONObject2 = ApiUtil.wrapCallbackFail(paramRequestEvent.event, null);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.qqmini.sdk.plugins.AppBoxPlugin
 * JD-Core Version:    0.7.0.1
 */