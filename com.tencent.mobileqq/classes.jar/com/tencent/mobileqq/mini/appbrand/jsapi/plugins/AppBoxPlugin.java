package com.tencent.mobileqq.mini.appbrand.jsapi.plugins;

import com.tencent.mobileqq.mini.appbrand.jsapi.PluginConst.AdConst;
import com.tencent.mobileqq.mini.util.ApiUtil;
import com.tencent.mobileqq.mini.webview.JsRuntime;
import com.tencent.qphone.base.util.QLog;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import org.json.JSONObject;

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
  public static final HashMap<Integer, String> S_CodeMsg_Map = PluginConst.AdConst.CodeMsgMap;
  private static final Set<String> S_EVENT_MAP = new AppBoxPlugin.1();
  private static final String TAG = "[minigame] AppBoxPlugin";
  private Map<Integer, AppBoxPlugin.MiniAppBox> mAppBoxMap = new HashMap();
  
  AppBoxPlugin.MiniAppBox getMiniAppBox(int paramInt, String paramString, BaseJsPluginEngine paramBaseJsPluginEngine, JsRuntime paramJsRuntime)
  {
    if (this.mAppBoxMap.containsKey(Integer.valueOf(paramInt))) {
      return (AppBoxPlugin.MiniAppBox)this.mAppBoxMap.get(Integer.valueOf(paramInt));
    }
    paramString = new AppBoxPlugin.MiniAppBox(paramInt, paramString, paramBaseJsPluginEngine, paramJsRuntime);
    this.mAppBoxMap.put(Integer.valueOf(paramInt), paramString);
    return paramString;
  }
  
  public String handleNativeRequest(String paramString1, String paramString2, JsRuntime paramJsRuntime, int paramInt)
  {
    QLog.i("[minigame] AppBoxPlugin", 1, "handleNativeRequest jsonParams : " + paramString2 + " event:" + paramString1);
    if ("operateAppBox".equals(paramString1)) {}
    try
    {
      JSONObject localJSONObject = new JSONObject(paramString2);
      int i = localJSONObject.optInt("id", -1);
      Object localObject = localJSONObject.optString("adUnitId", null);
      if (!AppBoxPlugin.MiniAppBox.isAdUnitIdValid((String)localObject))
      {
        paramString2 = ApiUtil.wrapCallbackFail(paramString1, localJSONObject, PluginConst.AdConst.ERROR_MSG_INVALID_ADUNITID);
        paramString2.put("errCode", 1002);
        paramString2.put("errMsg", PluginConst.AdConst.ERROR_MSG_INVALID_ADUNITID);
        paramString2 = paramString2.toString();
        paramJsRuntime.evaluateCallbackJs(paramInt, paramString2);
        return paramString2;
      }
      localObject = getMiniAppBox(i, (String)localObject, this.jsPluginEngine, paramJsRuntime);
      String str = localJSONObject.optString("type");
      int j = localJSONObject.optInt("compId", -1);
      if ("load".equals(str)) {
        if (!((AppBoxPlugin.MiniAppBox)localObject).load(j, paramInt))
        {
          localJSONObject = ApiUtil.wrapCallbackFail(paramString1, localJSONObject, PluginConst.AdConst.ERROR_MSG_INNER_ERROR);
          localJSONObject.put("errCode", 1003);
          localJSONObject.put("errMsg", PluginConst.AdConst.ERROR_MSG_INNER_ERROR);
          paramJsRuntime.evaluateCallbackJs(paramInt, localJSONObject.toString());
        }
      }
      for (;;)
      {
        return super.handleNativeRequest(paramString1, paramString2, paramJsRuntime, paramInt);
        if ("show".equals(str))
        {
          if (((AppBoxPlugin.MiniAppBox)localObject).show(j, paramInt)) {
            continue;
          }
          localJSONObject = ApiUtil.wrapCallbackFail(paramString1, localJSONObject, PluginConst.AdConst.ERROR_MSG_INNER_ERROR);
          localJSONObject.put("errCode", 1003);
          localJSONObject.put("errMsg", PluginConst.AdConst.ERROR_MSG_INNER_ERROR);
          paramJsRuntime.evaluateCallbackJs(paramInt, localJSONObject.toString());
          continue;
        }
        try
        {
          paramString1.put("errCode", 1003);
          paramString1.put("errMsg", PluginConst.AdConst.ERROR_MSG_INNER_ERROR);
          paramJsRuntime.evaluateCallbackJs(paramInt, paramString1.toString());
          return paramString1.toString();
          if (!"destroy".equals(str)) {
            continue;
          }
          if (((AppBoxPlugin.MiniAppBox)localObject).destroy()) {}
          for (localJSONObject = ApiUtil.wrapCallbackOk(paramString1, localJSONObject);; localJSONObject = ApiUtil.wrapCallbackFail(paramString1, localJSONObject, PluginConst.AdConst.ERROR_MSG_INNER_ERROR).put("errCode", 1003).put("errMsg", PluginConst.AdConst.ERROR_MSG_INNER_ERROR))
          {
            paramJsRuntime.evaluateCallbackJs(paramInt, localJSONObject.toString());
            this.mAppBoxMap.remove(Integer.valueOf(i));
            break;
          }
        }
        catch (Throwable paramString2)
        {
          break label361;
        }
      }
    }
    catch (Throwable paramString2)
    {
      QLog.e("[minigame] AppBoxPlugin", 1, "operateAppBoxfailed e:", paramString2);
      paramString1 = ApiUtil.wrapCallbackFail(paramString1, null, PluginConst.AdConst.ERROR_MSG_INNER_ERROR);
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
  
  public Set<String> supportedEvents()
  {
    return S_EVENT_MAP;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.mini.appbrand.jsapi.plugins.AppBoxPlugin
 * JD-Core Version:    0.7.0.1
 */