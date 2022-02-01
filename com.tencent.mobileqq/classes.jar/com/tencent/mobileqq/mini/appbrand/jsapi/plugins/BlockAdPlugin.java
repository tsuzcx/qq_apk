package com.tencent.mobileqq.mini.appbrand.jsapi.plugins;

import NS_MINI_AD.MiniAppAd.StGetAdReq;
import android.app.Activity;
import android.text.TextUtils;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.mini.appbrand.BaseAppBrandRuntime;
import com.tencent.mobileqq.mini.appbrand.jsapi.PluginConst.AdConst;
import com.tencent.mobileqq.mini.appbrand.utils.AppBrandTask;
import com.tencent.mobileqq.mini.reuse.MiniAppCmdUtil;
import com.tencent.mobileqq.mini.util.AdUtils;
import com.tencent.mobileqq.mini.webview.JsRuntime;
import com.tencent.mobileqq.minigame.data.BlockAdInfo;
import com.tencent.mobileqq.minigame.manager.BlockAdManager;
import com.tencent.mobileqq.minigame.ui.GameActivity;
import com.tencent.qphone.base.util.QLog;
import java.util.HashMap;
import java.util.Set;
import org.json.JSONException;
import org.json.JSONObject;

public class BlockAdPlugin
  extends BaseJsPlugin
{
  private static final HashMap<Integer, String> AD_ERROR_MSG = PluginConst.AdConst.CodeMsgMap;
  public static final String API_AD_CREATE_BLOCK_AD = "createBlockAd";
  public static final String API_AD_OPERATE_BLOCK_AD = "operateBlockAd";
  public static final String API_AD_UPDATE_BLOCK_AD = "updateBlockAdSize";
  public static final String EVENT_BLOCK_AD_SHOW_DONE = "onBlockAdShowDone";
  public static final String EVENT_BLOCK_AD_STATE_CHANGE = "onBlockAdStateChange";
  private static final Set<String> S_EVENT_MAP = new BlockAdPlugin.1();
  private static final String TAG = "[minigame] BlockAdPlugin";
  
  private void blockErrorStateCallback(JsRuntime paramJsRuntime, int paramInt1, String paramString, int paramInt2)
  {
    if (paramJsRuntime == null) {
      return;
    }
    JSONObject localJSONObject = new JSONObject();
    try
    {
      localJSONObject.put("state", "error");
      localJSONObject.put("compId", paramInt2);
      localJSONObject.put("errMsg", paramString);
      localJSONObject.put("errCode", paramInt1);
      informJs(paramJsRuntime, localJSONObject, "onBlockAdStateChange");
      return;
    }
    catch (JSONException paramJsRuntime)
    {
      QLog.e("[minigame] BlockAdPlugin", 1, "BlockErrorStateCallback error", paramJsRuntime);
    }
  }
  
  private void informJs(JsRuntime paramJsRuntime, JSONObject paramJSONObject, String paramString)
  {
    if (paramJsRuntime != null) {
      paramJsRuntime.evaluateSubcribeJS(paramString, paramJSONObject.toString(), 0);
    }
  }
  
  private void initAdParam(JsRuntime paramJsRuntime, MiniAppAd.StGetAdReq paramStGetAdReq, BlockAdInfo paramBlockAdInfo)
  {
    MiniAppCmdUtil.getInstance().getRewardedVideoADInfo(paramStGetAdReq, new BlockAdPlugin.6(this, paramJsRuntime, paramBlockAdInfo));
  }
  
  private void updateBlockSize(JsRuntime paramJsRuntime, String paramString)
  {
    int m = 1;
    int n = 1;
    int k = 1;
    int i1;
    int i;
    int j;
    for (;;)
    {
      try
      {
        paramString = new JSONObject(paramString);
        i1 = paramString.getInt("compId");
        if (paramString.has("left"))
        {
          i = paramString.getInt("left");
          j = 1;
          if ((j == -1) || (!(this.jsPluginEngine.activityContext instanceof GameActivity))) {
            break label264;
          }
          paramString = BlockAdManager.getInstance().getBlockAdInfo(i1);
          if (paramString == null) {
            break label264;
          }
        }
        switch (j)
        {
        case 1: 
          label100:
          if (j != 0) {
            break label225;
          }
          if (!QLog.isColorLevel()) {
            break label264;
          }
          QLog.i("[minigame] BlockAdPlugin", 1, "updateBlockAd no need to resize");
          return;
          if (!paramString.has("top")) {
            break label249;
          }
          i = paramString.getInt("top");
          j = 2;
          continue;
          if (paramString.getLeft() != i)
          {
            k = m;
            j = k;
            if (k == 0) {
              continue;
            }
            paramString.setLeft(i);
            j = k;
            continue;
          }
          k = 0;
        }
      }
      catch (JSONException paramJsRuntime)
      {
        QLog.e("[minigame] BlockAdPlugin", 2, "handle updateBlockAdSize parse json error", paramJsRuntime);
        return;
      }
      continue;
      if (paramString.getTop() == i) {
        break label265;
      }
    }
    label264:
    label265:
    for (k = n;; k = 0)
    {
      j = k;
      if (k == 0) {
        break label100;
      }
      paramString.setTop(i);
      j = k;
      break label100;
      label225:
      AppBrandTask.runTaskOnUiThread(new BlockAdPlugin.5(this, i1, paramString, paramJsRuntime, paramString.getLeft(), paramString.getTop()));
      return;
      label249:
      i = -1;
      j = -1;
      break;
      j = k;
      break label100;
      return;
    }
  }
  
  public String handleNativeRequest(String paramString1, String paramString2, JsRuntime paramJsRuntime, int paramInt)
  {
    QLog.i("[minigame] BlockAdPlugin", 2, "handleNativeRequest jsonParams : " + paramString2 + " event:" + paramString1);
    Object localObject2 = this.jsPluginEngine.appBrandRuntime.activity;
    int i;
    Object localObject1;
    String str1;
    if ("createBlockAd".equals(paramString1))
    {
      QLog.i("[minigame] BlockAdPlugin", 2, "receive createBlockAd event");
      if ((this.jsPluginEngine == null) || (TextUtils.isEmpty(paramString2)))
      {
        QLog.i("[minigame] BlockAdPlugin", 2, "handle createBlockAd event, jsPluginEngine == null");
        return "";
      }
      try
      {
        i = new JSONObject(paramString2).getInt("compId");
        localObject1 = BlockAdManager.getInstance().parseBlockAdInfoFromJson(paramString2);
        if (localObject1 == null)
        {
          blockErrorStateCallback(paramJsRuntime, 1001, (String)AD_ERROR_MSG.get(Integer.valueOf(1001)), i);
          return "";
        }
      }
      catch (JSONException localJSONException1)
      {
        for (;;)
        {
          QLog.i("[minigame] BlockAdPlugin", 2, "handle createBlockAd,", localJSONException1);
          i = -1;
        }
        str1 = "";
        i = 0;
        if (!(this.jsPluginEngine.activityContext instanceof GameActivity)) {
          break label226;
        }
      }
      str1 = ((GameActivity)this.jsPluginEngine.activityContext).getMiniGameAppId();
      if (((GameActivity)this.jsPluginEngine.activityContext).getIsOrientationLandscape())
      {
        i = 90;
        BlockAdManager.getInstance().initActivitySize((Activity)localObject2);
        label226:
        localObject2 = this.jsPluginEngine.activityContext.getCurrentAccountUin();
        String str2 = AdUtils.getSpAdGdtCookie(13);
        initAdParam(paramJsRuntime, AdUtils.createAdRequest(this.jsPluginEngine.activityContext, Long.valueOf((String)localObject2).longValue(), ((BlockAdInfo)localObject1).getAdUnitId(), str1, 53, 13, i, str2, "", "", "", "", ((BlockAdInfo)localObject1).getSize()), (BlockAdInfo)localObject1);
      }
    }
    for (;;)
    {
      return super.handleNativeRequest(paramString1, paramString2, paramJsRuntime, paramInt);
      i = 0;
      break;
      if ("operateBlockAd".equals(paramString1))
      {
        if (QLog.isColorLevel()) {
          QLog.i("[minigame] BlockAdPlugin", 2, "receive operateBlockAd event");
        }
        if (this.jsPluginEngine == null)
        {
          QLog.i("[minigame] BlockAdPlugin", 2, "handle operateBlockAd event, jsPluginEngine == null");
          return "";
        }
        try
        {
          localObject1 = new JSONObject(paramString2);
          str1 = ((JSONObject)localObject1).getString("type");
          i = ((JSONObject)localObject1).getInt("compId");
          QLog.i("[minigame] BlockAdPlugin", 2, "handle operateBlockAd type = " + str1);
          localObject1 = BlockAdManager.getInstance().getBlockAdInfo(i);
          if (!"show".equals(str1)) {
            break label485;
          }
          if (!(this.jsPluginEngine.activityContext instanceof GameActivity)) {
            continue;
          }
          AppBrandTask.runTaskOnUiThreadDelay(new BlockAdPlugin.2(this, (BlockAdInfo)localObject1, i, paramJsRuntime), 300L);
        }
        catch (JSONException localJSONException2)
        {
          QLog.i("[minigame] BlockAdPlugin", 2, "handle operateBlockAd parse json error", localJSONException2);
        }
        continue;
        label485:
        if ("hide".equals(localJSONException2))
        {
          if ((this.jsPluginEngine.activityContext instanceof GameActivity)) {
            AppBrandTask.runTaskOnUiThreadDelay(new BlockAdPlugin.3(this, (BlockAdInfo)localObject1), 300L);
          }
        }
        else if ("destroy".equals(localJSONException2))
        {
          if ((this.jsPluginEngine.activityContext instanceof GameActivity)) {
            AppBrandTask.runTaskOnUiThreadDelay(new BlockAdPlugin.4(this, (BlockAdInfo)localObject1), 300L);
          }
        }
        else {
          QLog.i("[minigame] BlockAdPlugin", 2, "handle operateBlockAd not define type = " + localJSONException2);
        }
      }
      else if ("updateBlockAdSize".equals(paramString1))
      {
        QLog.i("[minigame] BlockAdPlugin", 2, "updateBlockAdSize " + paramString2);
        if ((this.jsPluginEngine == null) || (this.jsPluginEngine.activityContext == null) || (paramJsRuntime == null))
        {
          QLog.i("[minigame] BlockAdPlugin", 2, "handle updateBlockAdSize event, jsPluginEngine == null");
          return "";
        }
        updateBlockSize(paramJsRuntime, paramString2);
      }
    }
  }
  
  public Set<String> supportedEvents()
  {
    return S_EVENT_MAP;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.mini.appbrand.jsapi.plugins.BlockAdPlugin
 * JD-Core Version:    0.7.0.1
 */