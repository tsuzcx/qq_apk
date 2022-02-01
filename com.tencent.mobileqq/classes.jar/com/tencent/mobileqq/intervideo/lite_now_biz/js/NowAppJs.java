package com.tencent.mobileqq.intervideo.lite_now_biz.js;

import android.content.Context;
import android.text.TextUtils;
import androidx.core.app.ActivityCompat;
import com.tencent.biz.pubaccount.CustomWebView;
import com.tencent.falco.base.libapi.log.LogInterface;
import com.tencent.ilive.audiencepages.room.AudienceRoomActivity;
import com.tencent.ilive.base.event.ModuleEvent;
import com.tencent.ilive.litepages.room.webmodule.event.LiteShowLuxuryAnimationEvent;
import com.tencent.ilive.litepages.room.webmodule.js.AppJavascriptInterface;
import com.tencent.ilive.litepages.room.webmodule.jsmodule.JsBizAdapter;
import com.tencent.ilive.litepages.room.webmodule.jsmodule.NewJavascriptInterface;
import com.tencent.mobileqq.intervideo.lite_now_biz.event.ChangeMicrophoneEvent;
import com.tencent.mobileqq.intervideo.lite_now_biz.now_live.floatwindow.FloatWindowHelper;
import com.tencent.mobileqq.intervideo.lite_now_biz.permission.RequestPermission;
import com.tencent.mobileqq.litelivesdk.api.business.BusinessConfig;
import com.tencent.mobileqq.litelivesdk.framework.businessmgr.BusinessManager;
import com.tencent.qphone.base.util.QLog;
import com.tencent.smtt.sdk.WebView;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class NowAppJs
  extends AppJavascriptInterface
{
  private static final String TAG = "NowAppJs";
  private Context context;
  private CustomWebView customWebView;
  private FloatWindowHelper floatWindowHelper;
  private boolean hasPermission;
  private NowUIJs nowUIJs;
  
  public NowAppJs(WebView paramWebView, Context paramContext, JsBizAdapter paramJsBizAdapter)
  {
    super(paramContext, paramWebView, paramJsBizAdapter);
    if ((paramWebView instanceof CustomWebView)) {
      this.customWebView = ((CustomWebView)paramWebView);
    }
    this.context = paramContext;
    this.nowUIJs = new NowUIJs(this.customWebView, paramContext, paramJsBizAdapter);
    this.floatWindowHelper = new FloatWindowHelper();
  }
  
  private LiteShowLuxuryAnimationEvent createShowLuxuryAnimationEvent(String paramString)
  {
    LiteShowLuxuryAnimationEvent localLiteShowLuxuryAnimationEvent = new LiteShowLuxuryAnimationEvent();
    localLiteShowLuxuryAnimationEvent.playUin = 0L;
    localLiteShowLuxuryAnimationEvent.uName = "";
    try
    {
      paramString = new JSONObject(paramString);
      JSONObject localJSONObject = paramString.getJSONObject("customjson");
      localLiteShowLuxuryAnimationEvent.playName = localJSONObject.optString("senderNickName", "");
      localLiteShowLuxuryAnimationEvent.headUrl = localJSONObject.optString("senderHeadUrl", "");
      localLiteShowLuxuryAnimationEvent.comboEffectWording = localJSONObject.optString("comment", "");
      paramString = paramString.getJSONObject("giftInfo");
      localLiteShowLuxuryAnimationEvent.giftid = paramString.getInt("giftId");
      localLiteShowLuxuryAnimationEvent.giftType = paramString.getInt("giftType");
      localLiteShowLuxuryAnimationEvent.giftName = paramString.optString("giftName", "");
      paramString = paramString.optJSONArray("clickEffectList");
      if ((paramString != null) && (paramString.length() >= 1))
      {
        paramString = paramString.getJSONObject(0);
        localLiteShowLuxuryAnimationEvent.effectId = paramString.optString("effectId", "");
        localLiteShowLuxuryAnimationEvent.effectNum = paramString.getInt("effectNum");
        localLiteShowLuxuryAnimationEvent.effectType = paramString.getInt("effectType");
      }
      return localLiteShowLuxuryAnimationEvent;
    }
    catch (JSONException paramString)
    {
      getJsBizAdapter().getLogger().e("NowAppJs", "解析礼物的json信息出错：" + paramString.toString(), new Object[0]);
    }
    return null;
  }
  
  private void requestPermission(Map<String, String> paramMap)
  {
    new RequestPermission().a(new String[] { "android.permission.RECORD_AUDIO" }).a(12).a(new NowAppJs.2(this, paramMap)).a((AudienceRoomActivity)this.context);
  }
  
  @NewJavascriptInterface
  public void changeMicrophone(Map<String, String> paramMap)
  {
    if (ActivityCompat.checkSelfPermission(this.context, "android.permission.RECORD_AUDIO") != 0)
    {
      requestPermission(paramMap);
      return;
    }
    String str = (String)paramMap.get("param");
    paramMap = (String)paramMap.get("callback");
    for (;;)
    {
      try
      {
        i = new JSONObject(str).getInt("enable");
        this.customWebView.callJs(paramMap, new String[] { new JSONObject().toString() });
        if (i == 0)
        {
          i = 0;
          getJsBizAdapter().getModuleEvent().post(new ChangeMicrophoneEvent(i));
          return;
        }
      }
      catch (JSONException paramMap)
      {
        QLog.e("NowAppJs", 1, "changeMicrophone error: " + paramMap);
        return;
      }
      int i = 1;
    }
  }
  
  @NewJavascriptInterface
  public void getClientScreenMode(Map<String, String> paramMap) {}
  
  @NewJavascriptInterface
  public void getClientState(Map<String, String> paramMap) {}
  
  @NewJavascriptInterface
  public void getClientVideoRateConfig(Map<String, String> paramMap) {}
  
  @NewJavascriptInterface
  public void getStateAudioStatus(Map<String, String> paramMap) {}
  
  @NewJavascriptInterface
  public void loadInputViewPlaceholder(Map<String, String> paramMap)
  {
    paramMap = (String)paramMap.get("param");
  }
  
  @NewJavascriptInterface
  public void openUrl(Map<String, String> paramMap)
  {
    String str1 = (String)paramMap.get("url");
    String str2 = BusinessManager.a.a().a;
    if ((!TextUtils.isEmpty(str1)) && (str1.contains("https://now.qq.com/h5/pay.html?")) && ("live".equals(str2)))
    {
      this.floatWindowHelper.a(this.context, new NowAppJs.1(this, paramMap));
      return;
    }
    this.nowUIJs.openUrl(paramMap);
  }
  
  @NewJavascriptInterface
  public void playAni(Map<String, String> paramMap)
  {
    String str = (String)paramMap.get("callback");
    this.customWebView.callJs(str, new String[] { new JSONObject().toString() });
    paramMap = createShowLuxuryAnimationEvent((String)paramMap.get("param"));
    if (paramMap != null) {
      getJsBizAdapter().getModuleEvent().post(paramMap);
    }
  }
  
  @NewJavascriptInterface
  public void preloadDynamicEffectResource(Map<String, String> paramMap)
  {
    paramMap = (String)paramMap.get("param");
  }
  
  @NewJavascriptInterface
  public void refreshRtmp(Map<String, String> paramMap)
  {
    paramMap = (String)paramMap.get("callback");
    this.customWebView.callJs(paramMap, new String[] { new JSONObject().toString() });
  }
  
  @NewJavascriptInterface
  public void setStatusBarStyle(Map<String, String> paramMap) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.intervideo.lite_now_biz.js.NowAppJs
 * JD-Core Version:    0.7.0.1
 */