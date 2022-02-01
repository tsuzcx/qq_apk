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
    if (this.customWebView != null)
    {
      if (TextUtils.isEmpty(paramString1)) {
        return;
      }
      this.customWebView.callJs(paramString1, new String[] { paramString2 });
    }
  }
  
  private void sendRequest(String paramString1, String paramString2)
  {
    if (!TextUtils.isEmpty(paramString1)) {
      if (TextUtils.isEmpty(paramString2)) {
        return;
      }
    }
    for (;;)
    {
      int i;
      try
      {
        String[] arrayOfString = Uri.parse(paramString2).getHost().split("\\.");
        paramString1 = new JSONObject(paramString1);
        String str2 = paramString1.getString("data");
        String str3 = paramString1.getString("cmd");
        String str1 = paramString1.getString("callback");
        if (this.preTime != 0L)
        {
          long l1 = System.currentTimeMillis();
          long l2 = this.preTime;
          i = this.minDuration;
          if (l1 - l2 < i * 1000)
          {
            paramString1 = new JSONObject();
            paramString1.put("cret", 1);
            callJs(str1, paramString1.toString());
            return;
          }
          if (str2.getBytes().length > this.maxSize)
          {
            paramString1 = new JSONObject();
            paramString1.put("cret", 2);
            callJs(str1, paramString1.toString());
          }
        }
        else
        {
          this.preTime = System.currentTimeMillis();
        }
        paramString1 = "";
        i = arrayOfString.length - 1;
        if (i >= 0)
        {
          localObject = new StringBuilder();
          ((StringBuilder)localObject).append(paramString1);
          ((StringBuilder)localObject).append(arrayOfString[i]);
          localObject = ((StringBuilder)localObject).toString();
          paramString1 = (String)localObject;
          if (i == 0) {
            break label455;
          }
          paramString1 = new StringBuilder();
          paramString1.append((String)localObject);
          paramString1.append("_");
          paramString1 = paramString1.toString();
          break label455;
        }
        if (str2.contains("GetUserInfoByFields"))
        {
          localObject = new StringBuilder();
          ((StringBuilder)localObject).append(">>>>>>>>>>>>>> ");
          ((StringBuilder)localObject).append(str1);
          QLog.e("SsoJavascriptInterface", 1, ((StringBuilder)localObject).toString());
        }
        Object localObject = new StringBuilder();
        ((StringBuilder)localObject).append("cmd:");
        ((StringBuilder)localObject).append(str3);
        ((StringBuilder)localObject).append(", cmdExt:");
        ((StringBuilder)localObject).append(paramString1);
        ((StringBuilder)localObject).append(", data:");
        ((StringBuilder)localObject).append(str2);
        QLog.d("SsoJavascriptInterface", 1, ((StringBuilder)localObject).toString());
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("cmd:");
        ((StringBuilder)localObject).append(paramString2);
        QLog.d("SsoJavascriptInterface", 1, ((StringBuilder)localObject).toString());
        sendRequest(str3, paramString1, str2, str1);
        return;
      }
      catch (Exception paramString1)
      {
        paramString2 = new StringBuilder();
        paramString2.append("send request error :");
        paramString2.append(paramString1.getMessage());
        QLog.e("SsoJavascriptInterface", 2, paramString2.toString());
      }
      return;
      label455:
      i -= 1;
    }
  }
  
  private void sendRequest(String paramString1, String paramString2, String paramString3, String paramString4)
  {
    NewIntent localNewIntent = new NewIntent(this.context, ProtoServlet.class);
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("MQUpdateSvc_");
    localStringBuilder.append(paramString2);
    localStringBuilder.append(".web.");
    localStringBuilder.append(paramString1);
    localNewIntent.putExtra("cmd", localStringBuilder.toString());
    paramString2 = new WebSsoBody.WebSsoRequestBody();
    paramString2.type.set(0);
    paramString2.data.set(paramString3);
    localNewIntent.putExtra("data", paramString2.toByteArray());
    localNewIntent.setObserver(new SsoJavascriptInterface.1(this, paramString4, paramString1));
    paramString1 = this.mAppRuntime;
    if (paramString1 != null) {
      paramString1.startServlet(localNewIntent);
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
    if ((this.isJsCreate) && (!this.isJsDestroy))
    {
      if (paramMap == null) {
        return;
      }
      sendRequest((String)paramMap.get("p"), this.customWebView.getUrl());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.tencent.mobileqq.intervideo.lite_now_biz.js.SsoJavascriptInterface
 * JD-Core Version:    0.7.0.1
 */