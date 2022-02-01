package com.tencent.mobileqq.intervideo.lite_now_biz.js;

import android.app.Activity;
import android.content.Context;
import android.text.TextUtils;
import androidx.core.app.ActivityCompat;
import com.tencent.biz.pubaccount.CustomWebView;
import com.tencent.falco.base.floatwindow.permission.FWPermission;
import com.tencent.falco.base.libapi.log.LogInterface;
import com.tencent.ilive.audiencepages.room.AudienceRoomActivity;
import com.tencent.ilive.base.event.ModuleEvent;
import com.tencent.ilive.litepages.room.webmodule.event.LiteShowLuxuryAnimationEvent;
import com.tencent.ilive.litepages.room.webmodule.js.AppJavascriptInterface;
import com.tencent.ilive.litepages.room.webmodule.jsmodule.JsBizAdapter;
import com.tencent.ilive.litepages.room.webmodule.jsmodule.NewJavascriptInterface;
import com.tencent.mobileqq.intervideo.lite_now_biz.event.ChangeMicrophoneEvent;
import com.tencent.mobileqq.intervideo.lite_now_biz.event.WebPageEvent;
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
  
  private void callJsOnFloatingWindowResult(String paramString, int paramInt)
  {
    JSONObject localJSONObject = new JSONObject();
    try
    {
      localJSONObject.put("result", paramInt);
    }
    catch (JSONException localJSONException)
    {
      LogInterface localLogInterface = getJsBizAdapter().getLogger();
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("构造悬浮窗的回调json内容出错：");
      localStringBuilder.append(localJSONException.toString());
      localLogInterface.e("NowAppJs", localStringBuilder.toString(), new Object[0]);
    }
    this.customWebView.callJs(paramString, new String[] { localJSONObject.toString() });
  }
  
  private LiteShowLuxuryAnimationEvent createShowLuxuryAnimationEvent(String paramString)
  {
    Object localObject1 = new LiteShowLuxuryAnimationEvent();
    ((LiteShowLuxuryAnimationEvent)localObject1).playUin = 0L;
    ((LiteShowLuxuryAnimationEvent)localObject1).uName = "";
    try
    {
      paramString = new JSONObject(paramString);
      localObject2 = paramString.getJSONObject("customjson");
      ((LiteShowLuxuryAnimationEvent)localObject1).playName = ((JSONObject)localObject2).optString("senderNickName", "");
      ((LiteShowLuxuryAnimationEvent)localObject1).headUrl = ((JSONObject)localObject2).optString("senderHeadUrl", "");
      ((LiteShowLuxuryAnimationEvent)localObject1).comboEffectWording = ((JSONObject)localObject2).optString("comment", "");
      paramString = paramString.getJSONObject("giftInfo");
      ((LiteShowLuxuryAnimationEvent)localObject1).giftid = paramString.getInt("giftId");
      ((LiteShowLuxuryAnimationEvent)localObject1).giftType = paramString.getInt("giftType");
      ((LiteShowLuxuryAnimationEvent)localObject1).giftName = paramString.optString("giftName", "");
      paramString = paramString.optJSONArray("clickEffectList");
      if ((paramString != null) && (paramString.length() >= 1))
      {
        paramString = paramString.getJSONObject(0);
        ((LiteShowLuxuryAnimationEvent)localObject1).effectId = paramString.optString("effectId", "");
        ((LiteShowLuxuryAnimationEvent)localObject1).effectNum = paramString.getInt("effectNum");
        ((LiteShowLuxuryAnimationEvent)localObject1).effectType = paramString.getInt("effectType");
      }
      return localObject1;
    }
    catch (JSONException paramString)
    {
      localObject1 = getJsBizAdapter().getLogger();
      Object localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append("解析礼物的json信息出错：");
      ((StringBuilder)localObject2).append(paramString.toString());
      ((LogInterface)localObject1).e("NowAppJs", ((StringBuilder)localObject2).toString(), new Object[0]);
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
    Object localObject = (String)paramMap.get("param");
    paramMap = (String)paramMap.get("callback");
    int i = 1;
    try
    {
      int j = new JSONObject((String)localObject).getInt("enable");
      this.customWebView.callJs(paramMap, new String[] { new JSONObject().toString() });
      if (j == 0) {
        i = 0;
      }
      getJsBizAdapter().getModuleEvent().post(new ChangeMicrophoneEvent(i));
      return;
    }
    catch (JSONException paramMap)
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("changeMicrophone error: ");
      ((StringBuilder)localObject).append(paramMap);
      QLog.e("NowAppJs", 1, ((StringBuilder)localObject).toString());
    }
  }
  
  @NewJavascriptInterface
  public void disableFloatingWindow(Map<String, String> paramMap)
  {
    getJsBizAdapter().getModuleEvent().post(new WebPageEvent(1));
  }
  
  @NewJavascriptInterface
  public void getClientScreenMode(Map<String, String> paramMap) {}
  
  @NewJavascriptInterface
  public void getClientState(Map<String, String> paramMap) {}
  
  @NewJavascriptInterface
  public void getClientVideoRateConfig(Map<String, String> paramMap) {}
  
  @NewJavascriptInterface
  public void getFloatingWindow(Map<String, String> paramMap)
  {
    throw new Runtime("d2j fail translate: java.lang.RuntimeException: can not merge I and Z\r\n\tat com.googlecode.dex2jar.ir.TypeClass.merge(TypeClass.java:100)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeRef.updateTypeClass(TypeTransformer.java:174)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.provideAs(TypeTransformer.java:780)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.enexpr(TypeTransformer.java:659)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:719)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:703)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.enexpr(TypeTransformer.java:698)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:719)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:703)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.s1stmt(TypeTransformer.java:810)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.sxStmt(TypeTransformer.java:840)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.analyze(TypeTransformer.java:206)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer.transform(TypeTransformer.java:44)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.optimize(Dex2jar.java:162)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertCode(Dex2Asm.java:414)\r\n\tat com.googlecode.d2j.dex.ExDex2Asm.convertCode(ExDex2Asm.java:42)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.convertCode(Dex2jar.java:128)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertMethod(Dex2Asm.java:509)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertClass(Dex2Asm.java:406)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertDex(Dex2Asm.java:422)\r\n\tat com.googlecode.d2j.dex.Dex2jar.doTranslate(Dex2jar.java:172)\r\n\tat com.googlecode.d2j.dex.Dex2jar.to(Dex2jar.java:272)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.doCommandLine(Dex2jarCmd.java:108)\r\n\tat com.googlecode.dex2jar.tools.BaseCmd.doMain(BaseCmd.java:288)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.main(Dex2jarCmd.java:32)\r\n");
  }
  
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
    String str2 = BusinessManager.a.b().a;
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
  public void setFloatingWindow(Map<String, String> paramMap)
  {
    paramMap = (String)paramMap.get("callback");
    if (FWPermission.hasPermission(this.context))
    {
      callJsOnFloatingWindowResult(paramMap, 1);
      return;
    }
    Context localContext = this.context;
    if (!(localContext instanceof Activity))
    {
      callJsOnFloatingWindowResult(paramMap, 0);
      return;
    }
    FWPermission.requestPermission((Activity)localContext, new NowAppJs.3(this, paramMap));
  }
  
  @NewJavascriptInterface
  public void setStatusBarStyle(Map<String, String> paramMap) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.mobileqq.intervideo.lite_now_biz.js.NowAppJs
 * JD-Core Version:    0.7.0.1
 */