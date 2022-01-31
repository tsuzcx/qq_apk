package com.tencent.mobileqq.mini.appbrand.jsapi.plugins;

import com.tencent.mobileqq.mini.appbrand.jsapi.AdFrequencyLimit;
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

public class InterstitialAdPlugin
  extends BaseJsPlugin
{
  public static final String API_OPERATE_DESTROY = "destroy";
  public static final String API_OPERATE_INTERSTITIAL_AD = "operateInterstitialAd";
  public static final String API_OPERATE_LOAD = "load";
  public static final String API_OPERATE_SHOW = "show";
  private static final String ERRCODE = "errCode";
  private static final String ERRMSG = "errMsg";
  public static final String EVENT_INTERSTITIAL_CLOSE = "onInterstitialAdClose";
  public static final HashMap<Integer, String> S_CodeMsg_Map = PluginConst.AdConst.CodeMsgMap;
  private static final Set<String> S_EVENT_MAP = new InterstitialAdPlugin.1();
  private static final String TAG = "[minigame] InterstitialAdPlugin";
  private Map<Integer, InterstitialAdPlugin.MiniInterstitialAd> mInterstitialMap = new HashMap();
  
  InterstitialAdPlugin.MiniInterstitialAd getMiniInterstitialAd(int paramInt, String paramString, BaseJsPluginEngine paramBaseJsPluginEngine, JsRuntime paramJsRuntime)
  {
    if (this.mInterstitialMap.containsKey(Integer.valueOf(paramInt))) {
      return (InterstitialAdPlugin.MiniInterstitialAd)this.mInterstitialMap.get(Integer.valueOf(paramInt));
    }
    paramString = new InterstitialAdPlugin.MiniInterstitialAd(paramInt, paramString, paramBaseJsPluginEngine, paramJsRuntime);
    this.mInterstitialMap.put(Integer.valueOf(paramInt), paramString);
    return paramString;
  }
  
  public String handleNativeRequest(String paramString1, String paramString2, JsRuntime paramJsRuntime, int paramInt)
  {
    QLog.i("[minigame] InterstitialAdPlugin", 1, "handleNativeRequest jsonParams : " + paramString2 + " event:" + paramString1);
    if ("operateInterstitialAd".equals(paramString1)) {}
    try
    {
      JSONObject localJSONObject = new JSONObject(paramString2);
      int j = localJSONObject.optInt("id", -1);
      Object localObject = localJSONObject.optString("adUnitId", null);
      if (!InterstitialAdPlugin.MiniInterstitialAd.isAdUnitIdValid((String)localObject))
      {
        paramString2 = ApiUtil.wrapCallbackFail(paramString1, localJSONObject, PluginConst.AdConst.ERROR_MSG_INVALID_ADUNITID);
        paramString2.put("errCode", 1002);
        paramString2 = paramString2.toString();
        paramJsRuntime.evaluateCallbackJs(paramInt, paramString2);
        return paramString2;
      }
      localObject = getMiniInterstitialAd(j, (String)localObject, this.jsPluginEngine, paramJsRuntime);
      String str = localJSONObject.optString("type");
      int i = localJSONObject.optInt("compId", -1);
      if ("load".equals(str)) {
        if (!((InterstitialAdPlugin.MiniInterstitialAd)localObject).load(i, paramInt))
        {
          localJSONObject = ApiUtil.wrapCallbackFail(paramString1, localJSONObject, PluginConst.AdConst.ERROR_MSG_INNER_ERROR);
          localJSONObject.put("errCode", 1003);
          paramJsRuntime.evaluateCallbackJs(paramInt, localJSONObject.toString());
        }
      }
      for (;;)
      {
        return super.handleNativeRequest(paramString1, paramString2, paramJsRuntime, paramInt);
        if ("show".equals(str))
        {
          j = AdFrequencyLimit.canShowInterstitialAdNow();
          if (j != 0)
          {
            paramString2 = ApiUtil.wrapCallbackFail(paramString1, localJSONObject, PluginConst.AdConst.ERROR_MSG_INNER_ERROR);
            paramString2.put("errCode", j);
            paramJsRuntime.evaluateCallbackJs(paramInt, paramString2.toString());
            QLog.i("[minigame] InterstitialAdPlugin", 1, "show error, code = " + j);
            return paramString2.toString();
          }
          if (((InterstitialAdPlugin.MiniInterstitialAd)localObject).show(i, paramInt)) {
            continue;
          }
          localJSONObject = ApiUtil.wrapCallbackFail(paramString1, localJSONObject, PluginConst.AdConst.ERROR_MSG_INNER_ERROR);
          localJSONObject.put("errCode", 1003);
          paramJsRuntime.evaluateCallbackJs(paramInt, localJSONObject.toString());
          continue;
        }
        try
        {
          paramString1.put("errCode", 1003);
          paramJsRuntime.evaluateCallbackJs(paramInt, paramString1.toString());
          return paramString1.toString();
          if (!"destroy".equals(str)) {
            continue;
          }
          if (((InterstitialAdPlugin.MiniInterstitialAd)localObject).destroy()) {}
          for (localJSONObject = ApiUtil.wrapCallbackOk(paramString1, localJSONObject);; localJSONObject = ApiUtil.wrapCallbackFail(paramString1, localJSONObject, PluginConst.AdConst.ERROR_MSG_INNER_ERROR).put("errCode", 1003).put("errMsg", PluginConst.AdConst.ERROR_MSG_INNER_ERROR))
          {
            paramJsRuntime.evaluateCallbackJs(paramInt, localJSONObject.toString());
            this.mInterstitialMap.remove(Integer.valueOf(j));
            break;
          }
        }
        catch (Throwable paramString2)
        {
          break label391;
        }
      }
    }
    catch (Throwable paramString2)
    {
      QLog.e("[minigame] InterstitialAdPlugin", 1, "operateInterstitialAdfailed e:", paramString2);
      paramString1 = ApiUtil.wrapCallbackFail(paramString1, null, PluginConst.AdConst.ERROR_MSG_INNER_ERROR);
    }
  }
  
  public void onDestroy()
  {
    super.onDestroy();
    Iterator localIterator = this.mInterstitialMap.entrySet().iterator();
    while (localIterator.hasNext())
    {
      InterstitialAdPlugin.MiniInterstitialAd localMiniInterstitialAd = (InterstitialAdPlugin.MiniInterstitialAd)((Map.Entry)localIterator.next()).getValue();
      if (localMiniInterstitialAd != null) {
        localMiniInterstitialAd.destroy();
      }
    }
  }
  
  public Set<String> supportedEvents()
  {
    return S_EVENT_MAP;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.mini.appbrand.jsapi.plugins.InterstitialAdPlugin
 * JD-Core Version:    0.7.0.1
 */