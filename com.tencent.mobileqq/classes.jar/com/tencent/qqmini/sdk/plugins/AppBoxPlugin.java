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
    return TextUtils.isEmpty(paramString) ^ true;
  }
  
  AppBoxPlugin.MiniAppBox getMiniAppBox(int paramInt, String paramString, RequestEvent paramRequestEvent)
  {
    boolean bool = this.mAppBoxMap.containsKey(Integer.valueOf(paramInt));
    Object localObject2 = null;
    Object localObject1;
    if (bool)
    {
      paramString = (AppBoxPlugin.MiniAppBox)this.mAppBoxMap.get(Integer.valueOf(paramInt));
    }
    else
    {
      if ((this.mMiniAppContext != null) && (this.mApkgInfo != null)) {
        localObject1 = this.mApkgInfo.appId;
      } else {
        localObject1 = "";
      }
      Activity localActivity;
      if (this.mMiniAppContext != null) {
        localActivity = this.mMiniAppContext.getAttachedActivity();
      } else {
        localActivity = null;
      }
      paramString = new AppBoxPlugin.MiniAppBox(this, localActivity, paramInt, paramString, (String)localObject1, paramRequestEvent.jsService);
      this.mAppBoxMap.put(Integer.valueOf(paramInt), paramString);
    }
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
    JSONObject localJSONObject;
    try
    {
      Object localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append("operateAppBox, jsonParams = ");
      ((StringBuilder)localObject1).append(paramRequestEvent.jsonParams);
      QMLog.e("AppBoxPlugin", ((StringBuilder)localObject1).toString());
      localObject1 = new JSONObject(paramRequestEvent.jsonParams);
      int i = ((JSONObject)localObject1).optInt("id", -1);
      Object localObject2 = ((JSONObject)localObject1).optString("adUnitId", null);
      if (!isAdUnitIdValid((String)localObject2))
      {
        localObject1 = ApiUtil.wrapCallbackFail(paramRequestEvent.event, (JSONObject)localObject1);
        ((JSONObject)localObject1).put("errCode", 1002);
        localObject2 = ((JSONObject)localObject1).toString();
        paramRequestEvent.fail((JSONObject)localObject1, "广告单元无效");
        return localObject2;
      }
      localObject2 = getMiniAppBox(i, (String)localObject2, paramRequestEvent);
      String str = ((JSONObject)localObject1).optString("type");
      int j = ((JSONObject)localObject1).optInt("compId", -1);
      if ("load".equals(str))
      {
        if (!((AppBoxPlugin.MiniAppBox)localObject2).load(j, paramRequestEvent.callbackId))
        {
          localObject1 = ApiUtil.wrapCallbackFail(paramRequestEvent.event, (JSONObject)localObject1);
          ((JSONObject)localObject1).put("errCode", 1003);
          paramRequestEvent.fail((JSONObject)localObject1, "内部错误");
        }
      }
      else if ("show".equals(str))
      {
        if ((this.mMiniAppContext == null) || (this.mMiniAppContext.getAttachedActivity() == null) || (!((AppBoxPlugin.MiniAppBox)localObject2).show(j, paramRequestEvent.callbackId)))
        {
          localObject1 = ApiUtil.wrapCallbackFail(paramRequestEvent.event, (JSONObject)localObject1);
          ((JSONObject)localObject1).put("errCode", 1003);
          paramRequestEvent.fail((JSONObject)localObject1, "内部错误");
        }
      }
      else if ("destroy".equals(str))
      {
        if (((AppBoxPlugin.MiniAppBox)localObject2).destroy()) {
          localObject1 = ApiUtil.wrapCallbackOk(paramRequestEvent.event, (JSONObject)localObject1);
        } else {
          localObject1 = ApiUtil.wrapCallbackFail(paramRequestEvent.event, (JSONObject)localObject1, "内部错误").put("errCode", 1003).put("errMsg", "内部错误");
        }
        paramRequestEvent.jsService.evaluateCallbackJs(paramRequestEvent.callbackId, ((JSONObject)localObject1).toString());
        this.mAppBoxMap.remove(Integer.valueOf(i));
      }
      return "";
    }
    catch (Throwable localThrowable)
    {
      QMLog.e("AppBoxPlugin", "operateAppBoxfailed e:", localThrowable);
      localJSONObject = ApiUtil.wrapCallbackFail(paramRequestEvent.event, null);
    }
    try
    {
      localJSONObject.put("errCode", 1003);
      paramRequestEvent.fail(localJSONObject, "内部错误");
      label416:
      return localJSONObject.toString();
    }
    catch (Throwable paramRequestEvent)
    {
      break label416;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     com.tencent.qqmini.sdk.plugins.AppBoxPlugin
 * JD-Core Version:    0.7.0.1
 */