package com.tencent.mobileqq.intervideo.lite_now_biz.js;

import android.content.Context;
import android.net.Uri;
import android.text.TextUtils;
import com.tencent.biz.ProtoServlet;
import com.tencent.biz.pubaccount.CustomWebView;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.ilive.litepages.room.webmodule.js.AppJavascriptInterface;
import com.tencent.ilive.litepages.room.webmodule.jsmodule.JsBizAdapter;
import com.tencent.ilive.litepages.room.webmodule.jsmodule.NewJavascriptInterface;
import com.tencent.mobileqq.WebSsoBody.WebSsoRequestBody;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.qphone.base.util.QLog;
import com.tencent.smtt.sdk.WebView;
import java.util.Map;
import mqq.app.AppRuntime;
import mqq.app.NewIntent;
import org.json.JSONObject;

public class SsoJavascriptInterface
  extends AppJavascriptInterface
{
  private static final String CMD_NAME = "sso";
  private static final String TAG = "SsoJavascriptInterface";
  private Context context;
  private CustomWebView customWebView;
  private boolean isJsCreate = false;
  private boolean isJsDestroy = false;
  private final AppRuntime mAppRuntime = BaseApplicationImpl.getApplication().getRuntime();
  private int maxSize = 204800;
  private int minDuration = 5;
  private long preTime = 0L;
  
  public SsoJavascriptInterface(WebView paramWebView, Context paramContext, JsBizAdapter paramJsBizAdapter)
  {
    super(paramContext, paramWebView, paramJsBizAdapter);
    if ((paramWebView instanceof CustomWebView)) {
      this.customWebView = ((CustomWebView)paramWebView);
    }
    this.context = paramContext.getApplicationContext();
  }
  
  private void callJs(String paramString1, String paramString2)
  {
    if ((this.customWebView == null) || (TextUtils.isEmpty(paramString1))) {
      return;
    }
    this.customWebView.callJs(paramString1, new String[] { paramString2 });
  }
  
  private void sendRequest(String paramString1, String paramString2)
  {
    if ((TextUtils.isEmpty(paramString1)) || (TextUtils.isEmpty(paramString2))) {
      return;
    }
    String[] arrayOfString;
    String str3;
    String str4;
    String str2;
    try
    {
      arrayOfString = Uri.parse(paramString2).getHost().split("\\.");
      paramString1 = new JSONObject(paramString1);
      str3 = paramString1.getString("data");
      str4 = paramString1.getString("cmd");
      str2 = paramString1.getString("callback");
      if (this.preTime == 0L) {
        break label189;
      }
      if (System.currentTimeMillis() - this.preTime < this.minDuration * 1000)
      {
        paramString1 = new JSONObject();
        paramString1.put("cret", 1);
        callJs(str2, paramString1.toString());
        return;
      }
    }
    catch (Exception paramString1)
    {
      QLog.e("SsoJavascriptInterface", 2, "send request error :" + paramString1.getMessage());
      return;
    }
    if (str3.getBytes().length > this.maxSize)
    {
      paramString1 = new JSONObject();
      paramString1.put("cret", 2);
      callJs(str2, paramString1.toString());
      return;
      label189:
      this.preTime = System.currentTimeMillis();
    }
    int i = arrayOfString.length;
    paramString1 = "";
    i -= 1;
    for (;;)
    {
      if (i >= 0)
      {
        String str1 = paramString1 + arrayOfString[i];
        paramString1 = str1;
        if (i != 0) {
          paramString1 = str1 + "_";
        }
      }
      else
      {
        if (str3.contains("GetUserInfoByFields")) {
          QLog.e("SsoJavascriptInterface", 1, ">>>>>>>>>>>>>> " + str2);
        }
        QLog.d("SsoJavascriptInterface", 1, "cmd:" + str4 + ", cmdExt:" + paramString1 + ", data:" + str3);
        QLog.d("SsoJavascriptInterface", 1, "cmd:" + paramString2);
        sendRequest(str4, paramString1, str3, str2);
        return;
      }
      i -= 1;
    }
  }
  
  private void sendRequest(String paramString1, String paramString2, String paramString3, String paramString4)
  {
    NewIntent localNewIntent = new NewIntent(this.context, ProtoServlet.class);
    localNewIntent.putExtra("cmd", "MQUpdateSvc_" + paramString2 + ".web." + paramString1);
    paramString2 = new WebSsoBody.WebSsoRequestBody();
    paramString2.type.set(0);
    paramString2.data.set(paramString3);
    localNewIntent.putExtra("data", paramString2.toByteArray());
    localNewIntent.setObserver(new SsoJavascriptInterface.1(this, paramString4, paramString1));
    if (this.mAppRuntime != null) {
      this.mAppRuntime.startServlet(localNewIntent);
    }
  }
  
  public String getName()
  {
    return "sso";
  }
  
  public void onJsCreate()
  {
    this.isJsCreate = true;
  }
  
  public void onJsDestroy()
  {
    this.isJsDestroy = true;
  }
  
  @NewJavascriptInterface
  public void sendRequest(Map<String, String> paramMap)
  {
    if ((!this.isJsCreate) || (this.isJsDestroy) || (paramMap == null)) {
      return;
    }
    sendRequest((String)paramMap.get("p"), this.customWebView.getUrl());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.intervideo.lite_now_biz.js.SsoJavascriptInterface
 * JD-Core Version:    0.7.0.1
 */