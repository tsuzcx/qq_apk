package com.tencent.mobileqq.vaswebviewplugin;

import android.app.Activity;
import android.content.ActivityNotFoundException;
import android.content.Intent;
import android.os.Build;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.Handler;
import android.text.TextUtils;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.emosm.DataFactory;
import com.tencent.mobileqq.emosm.EmosmUtils;
import com.tencent.mobileqq.emosm.OnRemoteRespObserver;
import com.tencent.mobileqq.qipc.QIPCClientHelper;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.qroute.route.ActivityURIRequest;
import com.tencent.mobileqq.utils.DialogUtil;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.utils.QQCustomDialogThreeBtns;
import com.tencent.mobileqq.vas.webview.util.VasWebviewUtil;
import com.tencent.mobileqq.webview.swift.JsBridgeListener;
import com.tencent.mobileqq.webview.swift.WebViewPlugin;
import com.tencent.mobileqq.webview.swift.WebViewPlugin.PluginRuntime;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.util.ArrayList;
import java.util.List;
import mqq.app.AppActivity;
import mqq.app.AppRuntime;
import org.json.JSONException;
import org.json.JSONObject;

public class ThemeAndBubbleCommonJsPlugin
  extends VasWebviewJsPlugin
{
  public static final String BUSINESS_NAME = "common";
  private static final int SAVEIMG = 1;
  public static final List<ThemeAndBubbleCommonJsPlugin.HYDIYFontJsHandler> SJS_PLUGINS = new ArrayList();
  public static final String TAG = "CommonJsHandler";
  public Handler handler = new ThemeAndBubbleCommonJsPlugin.7(this);
  private String mSaveCallbackId;
  
  static
  {
    SJS_PLUGINS.add(new ThemeAndBubbleCommonJsPlugin.HYDIYFontJsHandler());
  }
  
  public ThemeAndBubbleCommonJsPlugin()
  {
    this.mPluginNameSpace = "common";
  }
  
  public void closePage(JSONObject paramJSONObject, String paramString)
  {
    try
    {
      this.mRuntime.d().finish();
      return;
    }
    catch (Exception paramJSONObject)
    {
      super.callJsOnError(paramString, paramJSONObject.getMessage());
    }
  }
  
  public void getNetwork(JSONObject paramJSONObject, String paramString)
  {
    int i = NetworkUtil.getSystemNetwork(this.mRuntime.d());
    try
    {
      Object localObject = new JSONObject();
      ((JSONObject)localObject).put("status", i);
      paramJSONObject = new JSONObject();
      paramJSONObject.put("result", 0);
      paramJSONObject.put("message", "ok");
      paramJSONObject.put("data", localObject);
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append(paramString);
      ((StringBuilder)localObject).append("(");
      ((StringBuilder)localObject).append(paramJSONObject.toString());
      ((StringBuilder)localObject).append(");");
      super.callJs(((StringBuilder)localObject).toString());
      return;
    }
    catch (Exception paramJSONObject)
    {
      super.callJsOnError(paramString, paramJSONObject.getMessage());
    }
  }
  
  public long getWebViewSchemaByNameSpace(String paramString)
  {
    return 32L;
  }
  
  protected boolean handleJsRequest(JsBridgeListener paramJsBridgeListener, String paramString1, String paramString2, String paramString3, String... paramVarArgs)
  {
    if (QLog.isColorLevel())
    {
      paramJsBridgeListener = new StringBuilder();
      paramJsBridgeListener.append("handleJsRequest, url=");
      paramJsBridgeListener.append(paramString1);
      paramJsBridgeListener.append(", pkgName=");
      paramJsBridgeListener.append(paramString2);
      paramJsBridgeListener.append(", methodName=");
      paramJsBridgeListener.append(paramString3);
      QLog.d("CommonJsHandler", 2, paramJsBridgeListener.toString());
    }
    if ((paramString1 != null) && ("common".equals(paramString2)))
    {
      if (paramString3 == null) {
        return false;
      }
      paramJsBridgeListener = WebViewPlugin.getJsonFromJSBridge(paramString1);
      if (paramJsBridgeListener == null) {
        return true;
      }
      if (QLog.isColorLevel())
      {
        paramString1 = new StringBuilder();
        paramString1.append("handleJsRequest JSON = ");
        paramString1.append(paramJsBridgeListener.toString());
        QLog.d("CommonJsHandler", 2, paramString1.toString());
      }
      paramString1 = paramJsBridgeListener.optString("callback");
      if (TextUtils.isEmpty(paramString1))
      {
        QLog.e("CommonJsHandler", 1, "callback id is null, so return");
        return true;
      }
      int i = 0;
      while (i < SJS_PLUGINS.size())
      {
        if (((ThemeAndBubbleCommonJsPlugin.HYDIYFontJsHandler)SJS_PLUGINS.get(i)).handler(paramString3, paramJsBridgeListener, paramString1, this)) {
          return true;
        }
        i += 1;
      }
      if ("getNetwork".equals(paramString3))
      {
        getNetwork(paramJsBridgeListener, paramString1);
        return true;
      }
      if ("showMsgBox".equals(paramString3))
      {
        showMsgBox(paramJsBridgeListener, paramString1);
        return true;
      }
      if ("closePage".equals(paramString3))
      {
        closePage(paramJsBridgeListener, paramString1);
        return true;
      }
      if ("openPage".equals(paramString3))
      {
        openPage(paramJsBridgeListener, paramString1);
        return true;
      }
      if ("openWebView".equals(paramString3))
      {
        openWebView(paramJsBridgeListener, paramString1);
        return true;
      }
      if ("saveImage".equals(paramString3))
      {
        saveImage(paramJsBridgeListener, paramString1);
        return true;
      }
      if ("showMyImage".equals(paramString3))
      {
        showMyEmotion(paramString1);
        return true;
      }
      if ("popup".equals(paramString3))
      {
        this.mRuntime.d().finish();
        return true;
      }
      if ("openSettings".equals(paramString3))
      {
        paramString2 = new Bundle();
        paramString2.putString("jumpTo", paramJsBridgeListener.optString("jumpto"));
        super.sendRemoteReq(DataFactory.a("ipc_open_settings", paramString1, this.mOnRemoteResp.key, paramString2), false, true);
        return true;
      }
      if ("isWhiteName".equals(paramString3))
      {
        isWhiteName(paramJsBridgeListener, paramString1);
        return true;
      }
      if (QLog.isColorLevel())
      {
        paramJsBridgeListener = new StringBuilder();
        paramJsBridgeListener.append("NOT support method ");
        paramJsBridgeListener.append(paramString3);
        paramJsBridgeListener.append(" yet!!");
        QLog.w("CommonJsHandler", 2, paramJsBridgeListener.toString());
      }
    }
    return false;
  }
  
  protected boolean handleSchemaRequest(String paramString1, String paramString2)
  {
    return handleThemeAndBubbleSchemaRequest(paramString1, paramString2, "common");
  }
  
  public void isWhiteName(JSONObject paramJSONObject, String paramString)
  {
    Bundle localBundle = new Bundle();
    localBundle.putInt("managerId", paramJSONObject.optInt("id"));
    paramJSONObject = new ThemeAndBubbleCommonJsPlugin.6(this, paramString);
    QIPCClientHelper.getInstance().callServer("VasCommonIPCModule", "is_white_name", localBundle, paramJSONObject);
  }
  
  public void openPage(JSONObject paramJSONObject, String paramString)
  {
    try
    {
      Object localObject1 = paramJSONObject.getString("pageUrl");
      paramJSONObject = paramJSONObject.getString("pageTitle");
      if (QLog.isColorLevel())
      {
        localObject2 = new StringBuilder();
        ((StringBuilder)localObject2).append("CommonJsHandler openWebView pageUrl=");
        ((StringBuilder)localObject2).append((String)localObject1);
        ((StringBuilder)localObject2).append(",pageTitle=");
        ((StringBuilder)localObject2).append(paramJSONObject);
        QLog.i("CommonJsHandler", 2, ((StringBuilder)localObject2).toString());
      }
      Object localObject2 = new Intent();
      ((Intent)localObject2).putExtra("pageTitle", paramJSONObject);
      ((Intent)localObject2).putExtra("startOpenPageTime", System.currentTimeMillis());
      VasWebviewUtil.b(this.mRuntime.d(), (String)localObject1, this.mRuntime.d().getIntent().getIntExtra("business", 0), (Intent)localObject2, false, -1);
      paramJSONObject = new JSONObject();
      paramJSONObject.put("result", 0);
      paramJSONObject.put("message", "ok");
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append(paramString);
      ((StringBuilder)localObject1).append("(");
      ((StringBuilder)localObject1).append(paramJSONObject.toString());
      ((StringBuilder)localObject1).append(");");
      super.callJs(((StringBuilder)localObject1).toString());
      return;
    }
    catch (Exception paramJSONObject)
    {
      super.callJsOnError(paramString, paramJSONObject.getMessage());
    }
  }
  
  public void openWebView(JSONObject paramJSONObject, String paramString)
  {
    try
    {
      Object localObject = paramJSONObject.getString("pageUrl");
      String str = paramJSONObject.getString("pageTitle");
      paramJSONObject = paramJSONObject.getString("pageType");
      if (QLog.isColorLevel())
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("CommonJsHandler openWebView pageUrl=");
        localStringBuilder.append((String)localObject);
        localStringBuilder.append(",pageTitle=");
        localStringBuilder.append(str);
        localStringBuilder.append(",pageType=");
        localStringBuilder.append(paramJSONObject);
        QLog.i("CommonJsHandler", 2, localStringBuilder.toString());
      }
      paramJSONObject = new Intent();
      paramJSONObject.putExtra("pageUrl", (String)localObject);
      paramJSONObject.putExtra("url", (String)localObject);
      paramJSONObject.putExtra("pageTitle", str);
      paramJSONObject.putExtra("startOpenPageTime", System.currentTimeMillis());
      paramJSONObject.setClass(this.mRuntime.d(), QQBrowserActivity.class);
      this.mRuntime.d().startActivity(paramJSONObject);
      paramJSONObject = new JSONObject();
      paramJSONObject.put("result", 0);
      paramJSONObject.put("message", "ok");
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append(paramString);
      ((StringBuilder)localObject).append("(");
      ((StringBuilder)localObject).append(paramJSONObject.toString());
      ((StringBuilder)localObject).append(");");
      super.callJs(((StringBuilder)localObject).toString());
      return;
    }
    catch (Exception paramJSONObject) {}catch (ActivityNotFoundException paramJSONObject)
    {
      break label266;
    }
    catch (JSONException paramJSONObject)
    {
      break label276;
    }
    super.callJsOnError(paramString, paramJSONObject.getMessage());
    return;
    label266:
    super.callJsOnError(paramString, paramJSONObject.getMessage());
    return;
    label276:
    super.callJsOnError(paramString, paramJSONObject.getMessage());
  }
  
  public void saveImage(JSONObject paramJSONObject, String paramString)
  {
    try
    {
      String str = paramJSONObject.getString("url");
      this.mSaveCallbackId = paramString;
      paramJSONObject = new StringBuilder();
      paramJSONObject.append(str);
      paramJSONObject.append("?client=androidQQ");
      paramJSONObject.append("&version=8.8.17.5770");
      paramString = new StringBuilder();
      paramString.append("&system=");
      paramString.append(Build.VERSION.RELEASE);
      paramJSONObject.append(paramString.toString());
      paramString = new StringBuilder();
      paramString.append("&device=");
      paramString.append(Build.DEVICE);
      paramJSONObject.append(paramString.toString());
      paramString = new StringBuilder();
      paramString.append("&uin=");
      paramString.append(((AppActivity)this.mRuntime.d()).getAppRuntime().getAccount());
      paramJSONObject.append(paramString.toString());
      paramJSONObject = EmosmUtils.a("VIP_xingying", paramJSONObject.toString());
      if (QLog.isColorLevel())
      {
        paramString = new StringBuilder();
        paramString.append("CommonJsHandler saveImage imageUrl=");
        paramString.append(paramJSONObject);
        QLog.i("CommonJsHandler", 2, paramString.toString());
      }
      paramString = new StringBuilder();
      paramString.append(System.currentTimeMillis());
      paramString.append(".jpg");
      paramString = paramString.toString();
      ThreadManager.executeOnNetWorkThread(new ThemeAndBubbleCommonJsPlugin.5(this, paramJSONObject, new File(AppConstants.SDCARD_IMG_SAVE, paramString)));
      return;
    }
    catch (Exception paramJSONObject)
    {
      paramJSONObject.printStackTrace();
    }
  }
  
  public void showMsgBox(JSONObject paramJSONObject, String paramString)
  {
    try
    {
      Object localObject = paramJSONObject.getString("prompt");
      String str = paramJSONObject.getString("title");
      paramJSONObject = paramJSONObject.getString("button");
      String[] arrayOfString = paramJSONObject.split("\t");
      if (QLog.isColorLevel())
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("CommonJsHandler showMsgBox prompt=");
        localStringBuilder.append((String)localObject);
        localStringBuilder.append(",title=");
        localStringBuilder.append(str);
        localStringBuilder.append(",button=");
        localStringBuilder.append(paramJSONObject);
        QLog.i("CommonJsHandler", 2, localStringBuilder.toString());
      }
      if (arrayOfString.length >= 1)
      {
        paramJSONObject = DialogUtil.c(this.mRuntime.d(), 230);
        paramJSONObject.a(str);
        paramJSONObject.b((String)localObject);
        paramJSONObject.a(arrayOfString[0], new ThemeAndBubbleCommonJsPlugin.1(this, paramString));
        if (arrayOfString.length >= 2) {
          paramJSONObject.b(arrayOfString[1], new ThemeAndBubbleCommonJsPlugin.2(this, paramString));
        }
        if (arrayOfString.length >= 3) {
          paramJSONObject.c(arrayOfString[2], new ThemeAndBubbleCommonJsPlugin.3(this, paramString));
        }
        paramJSONObject.setCanceledOnTouchOutside(false);
        paramJSONObject.setOnKeyListener(new ThemeAndBubbleCommonJsPlugin.4(this, paramJSONObject, paramString));
        paramJSONObject.show();
        return;
      }
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("Button no found - ");
      ((StringBuilder)localObject).append(paramJSONObject);
      super.callJsOnError(paramString, ((StringBuilder)localObject).toString());
      return;
    }
    catch (Exception paramJSONObject)
    {
      super.callJsOnError(paramString, paramJSONObject.getMessage());
    }
  }
  
  public void showMyEmotion(String paramString)
  {
    QRoute.startUri(new ActivityURIRequest(this.mRuntime.d(), "/base/activity/EmosmActivity"));
    try
    {
      JSONObject localJSONObject = new JSONObject();
      localJSONObject.put("result", 0);
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append(paramString);
      localStringBuilder.append("(");
      localStringBuilder.append(localJSONObject.toString());
      localStringBuilder.append(");");
      super.callJs(localStringBuilder.toString());
      return;
    }
    catch (Exception localException)
    {
      super.callJsOnError(paramString, localException.getMessage());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.vaswebviewplugin.ThemeAndBubbleCommonJsPlugin
 * JD-Core Version:    0.7.0.1
 */