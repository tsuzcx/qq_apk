package com.tencent.mobileqq.vaswebviewplugin;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Rect;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.view.Window;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.activity.photo.PhotoUtils;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.BrowserAppInterface;
import com.tencent.mobileqq.emosm.Client.onRemoteRespObserver;
import com.tencent.mobileqq.emosm.DataFactory;
import com.tencent.mobileqq.model.ChatBackgroundManager;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.vas.IndividuationUrlHelper;
import com.tencent.mobileqq.webview.swift.JsBridgeListener;
import com.tencent.mobileqq.webview.swift.WebViewPlugin;
import com.tencent.mobileqq.webview.swift.WebViewPlugin.PluginRuntime;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

public class ChatBackgroundJsPlugin
  extends VasWebviewJsPlugin
{
  public static final String BUSINESS_NAME = "chatBg";
  public static final String FROM_CHATBACKGROUNDJS = "fromChatBackgroundJsPlugin";
  public static final String ISFROMPHOTO = "isFromPhoto";
  private static final String TAG = "ChatBackgroundJsPlugin";
  private BrowserAppInterface browserApp;
  String mId;
  private Bundle mReqBundle;
  String mUrl;
  
  public ChatBackgroundJsPlugin()
  {
    this.mPluginNameSpace = "chatBg";
  }
  
  private void custom(String paramString)
  {
    Object localObject = this.mRuntime.a().getIntent();
    String str = AppConstants.aJ + this.browserApp.getAccount() + "/" + "custom_background/";
    str = str + System.currentTimeMillis() + ".jpg";
    Rect localRect = new Rect();
    this.mRuntime.a().getWindow().getDecorView().getWindowVisibleDisplayFrame(localRect);
    ((Intent)localObject).putExtra("PhotoConst.PHOTO_LIST_SHOW_PREVIEW", true);
    ((Intent)localObject).putExtra("isFromPhoto", true);
    ((Intent)localObject).putExtra("fromChatBackgroundJsPlugin", true);
    ((Intent)localObject).putExtra("onNewIntentReDoStateMachine", false);
    PhotoUtils.a((Intent)localObject, this.mRuntime.a(), QQBrowserActivity.class.getName(), localRect.width() / 5 * 4, localRect.height() / 5 * 4, localRect.width(), localRect.height(), str);
    localObject = new JSONObject();
    try
    {
      ((JSONObject)localObject).put("result", 0);
      super.callJs(paramString, new String[] { ((JSONObject)localObject).toString() });
      return;
    }
    catch (JSONException localJSONException)
    {
      localJSONException.printStackTrace();
      callJsOnError(paramString, localJSONException.getMessage());
    }
  }
  
  private void handleCustomPic(Intent paramIntent)
  {
    if (paramIntent == null) {
      QLog.d("ChatBackgroundJsPlugin", 2, "handleCustomPic intent = null");
    }
    boolean bool;
    String str;
    do
    {
      return;
      bool = paramIntent.getBooleanExtra("isFromPhoto", false);
      str = paramIntent.getStringExtra("PhotoConst.SINGLE_PHOTO_PATH");
      paramIntent = paramIntent.getStringExtra("chatbg_intent_frinedUin");
    } while ((!bool) || (str == null) || (this.browserApp == null));
    Intent localIntent = new Intent();
    localIntent.setAction("chatbgBroadcast");
    localIntent.setPackage(this.browserApp.getApp().getPackageName());
    localIntent.putExtra("friendUin", paramIntent);
    localIntent.putExtra("PhotoConst.SINGLE_PHOTO_PATH", str);
    this.browserApp.getApp().sendBroadcast(localIntent);
    QQToast.a(this.mRuntime.a(), 2131434994, 0).a();
    ReportController.b(null, "CliOper", "", "", "chatbackground", "BjIDShezhi", 0, 0, "1", "", "", "");
  }
  
  protected long getPluginBusiness()
  {
    return 2181038080L;
  }
  
  protected boolean handleEvent(String paramString, long paramLong, Map paramMap)
  {
    if (paramLong == 128L)
    {
      Object localObject = paramMap.get("intent");
      if ((localObject != null) && ((localObject instanceof Intent)))
      {
        localObject = (Intent)localObject;
        if (((Intent)localObject).getBooleanExtra("fromChatBackgroundJsPlugin", false))
        {
          handleCustomPic((Intent)localObject);
          return true;
        }
      }
    }
    return super.handleEvent(paramString, paramLong, paramMap);
  }
  
  protected boolean handleJsRequest(JsBridgeListener paramJsBridgeListener, String paramString1, String paramString2, String paramString3, String... paramVarArgs)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ChatBackgroundJsPlugin", 2, "handleJsRequest, url=" + paramString1 + ", pkgName=" + paramString2 + ", methodName=" + paramString3);
    }
    if ((paramString1 == null) || (!"chatBg".equals(paramString2)) || (paramString3 == null)) {
      return false;
    }
    Object localObject = WebViewPlugin.getJsonFromJSBridge(paramString1);
    if (localObject == null) {
      return true;
    }
    if (QLog.isColorLevel()) {
      QLog.d("ChatBackgroundJsPlugin", 2, "handleJsRequest JSON = " + ((JSONObject)localObject).toString());
    }
    paramVarArgs = ((JSONObject)localObject).optString("callback");
    if (TextUtils.isEmpty(paramVarArgs))
    {
      QLog.e("ChatBackgroundJsPlugin", 1, "callback id is null, so return");
      return true;
    }
    if ("getCurrentChatBgId".equals(paramString3))
    {
      paramString1 = this.mRuntime.a().getIntent().getStringExtra("chatbg_intent_frinedUin");
      paramJsBridgeListener = paramString1;
      if (paramString1 == null) {
        paramJsBridgeListener = "none";
      }
      this.mReqBundle.clear();
      this.mReqBundle.putString("friendUin", paramJsBridgeListener);
      paramJsBridgeListener = "chatbackground_getCurrentId";
    }
    for (;;)
    {
      super.sendRemoteReq(DataFactory.a(paramJsBridgeListener, paramVarArgs, this.mOnRemoteResp.key, this.mReqBundle), false, true);
      return true;
      if ("startDownload".equals(paramString3)) {}
      try
      {
        paramString1 = ((JSONObject)localObject).getString("id");
        paramString2 = ((JSONObject)localObject).getString("url");
        this.mId = paramString1;
        this.mUrl = paramString2;
        paramString3 = ((JSONObject)localObject).getString("name");
        localObject = ((JSONObject)localObject).getString("thumbUrl");
        paramJsBridgeListener = "chatbackground_startDownload";
        try
        {
          this.mReqBundle.clear();
          this.mReqBundle.putString("id", paramString1);
          this.mReqBundle.putString("url", paramString2);
          this.mReqBundle.putString("name", paramString3);
          this.mReqBundle.putString("thumbUrl", (String)localObject);
        }
        catch (JSONException paramString1) {}
      }
      catch (JSONException paramString1)
      {
        for (;;)
        {
          paramJsBridgeListener = "";
        }
      }
      paramString1.printStackTrace();
      continue;
      if ("stopDownload".equals(paramString3)) {}
      try
      {
        paramString1 = ((JSONObject)localObject).getString("id");
        paramString2 = ((JSONObject)localObject).getString("url");
        paramJsBridgeListener = "chatbackground_stopdownload";
        try
        {
          this.mReqBundle.clear();
          this.mReqBundle.putString("id", paramString1);
          this.mReqBundle.putString("url", paramString2);
        }
        catch (JSONException paramString1) {}
      }
      catch (JSONException paramString1)
      {
        for (;;)
        {
          paramJsBridgeListener = "";
        }
      }
      paramString1.printStackTrace();
      continue;
      if ("queryInfo".equals(paramString3)) {}
      try
      {
        paramString1 = ((JSONObject)localObject).getString("id");
        paramString2 = ((JSONObject)localObject).getString("url");
        paramJsBridgeListener = "chatbackground_querinfo";
        try
        {
          this.mReqBundle.clear();
          this.mReqBundle.putString("id", paramString1);
          this.mReqBundle.putString("url", paramString2);
        }
        catch (JSONException paramString1) {}
      }
      catch (JSONException paramString1)
      {
        for (;;)
        {
          int j;
          int i;
          paramJsBridgeListener = "";
        }
      }
      paramString1.printStackTrace();
      continue;
      if ("setChatBg".equals(paramString3))
      {
        paramString3 = "chatbackground_setbg";
        for (;;)
        {
          String str;
          try
          {
            str = ((JSONObject)localObject).getString("id");
            if (!str.startsWith("theme")) {
              break label751;
            }
            paramString1 = "null";
            Intent localIntent = this.mRuntime.a().getIntent();
            if (!((JSONObject)localObject).has("friendUin")) {
              break label761;
            }
            paramJsBridgeListener = ((JSONObject)localObject).getString("friendUin");
            paramString2 = paramJsBridgeListener;
            if ("none".equals(paramJsBridgeListener)) {
              paramString2 = null;
            }
            paramJsBridgeListener = ((JSONObject)localObject).optString("name");
            localObject = ((JSONObject)localObject).optString("feeType");
            this.mReqBundle.clear();
            this.mReqBundle.putString("path", paramString1);
            this.mReqBundle.putString("friendUin", paramString2);
            this.mReqBundle.putString("from", "chatbgJs");
            this.mReqBundle.putString("name", paramJsBridgeListener);
            this.mReqBundle.putString("feeType", (String)localObject);
            this.mReqBundle.putString("id", str);
            if ((!TextUtils.isEmpty(this.mId)) && (this.mId.equals(str))) {
              this.mReqBundle.putString("url", this.mUrl);
            }
            this.mReqBundle.putParcelable("intent", localIntent);
            paramJsBridgeListener = paramString3;
          }
          catch (JSONException paramJsBridgeListener)
          {
            paramJsBridgeListener.printStackTrace();
            paramJsBridgeListener = paramString3;
          }
          break;
          label751:
          paramString1 = ChatBackgroundManager.a(true, str);
          continue;
          label761:
          paramJsBridgeListener = "none";
        }
      }
      if ("custom".equals(paramString3))
      {
        custom(paramVarArgs);
        return true;
      }
      if ("openPage".equals(paramString3)) {
        try
        {
          paramJsBridgeListener = new Intent();
          paramJsBridgeListener.putExtra("bg_replace_entrance", 8);
          paramJsBridgeListener.putExtra("selfSet_leftViewText", this.mRuntime.a().getString(2131433698));
          paramJsBridgeListener.putExtra("hide_left_button", false);
          paramJsBridgeListener.putExtra("show_right_close_button", false);
          paramJsBridgeListener.putExtra("startOpenPageTime", System.currentTimeMillis());
          VasWebviewUtil.openQQBrowserWithoutAD(this.mRuntime.a(), IndividuationUrlHelper.a(this.mRuntime.a(), "background", ""), 33554432L, paramJsBridgeListener, false, -1);
          paramJsBridgeListener = new JSONObject();
          paramJsBridgeListener.put("result", 0);
          super.callJs(paramVarArgs, new String[] { paramJsBridgeListener.toString() });
          return true;
        }
        catch (Exception paramJsBridgeListener)
        {
          for (;;)
          {
            paramJsBridgeListener.printStackTrace();
            super.callJs(paramVarArgs, new String[] { paramJsBridgeListener.getMessage() });
          }
        }
      }
      if ("isSupportDynamic".equals(paramString3))
      {
        j = ChatBackgroundManager.a();
        if ((j & 0x1) != 0)
        {
          i = 1;
          label983:
          if ((j & 0x2) == 0) {
            break label1172;
          }
        }
        for (j = 1;; j = 0)
        {
          try
          {
            paramJsBridgeListener = new JSONObject();
            paramJsBridgeListener.put("result", 0);
            paramJsBridgeListener.put("isDeviceEnable", i);
            paramJsBridgeListener.put("isWebviewEnable", j);
            if (QLog.isColorLevel()) {
              QLog.i("ChatBackgroundJsPlugin", 2, "isSupportDynamic deviceEnable:" + i + ", webViewEnable:" + j);
            }
            localObject = new JSONObject();
            ((JSONObject)localObject).put("result", 0);
            ((JSONObject)localObject).put("message", "isSupportDynamic return deviceEnable:" + i + ", webViewEnable:" + j);
            ((JSONObject)localObject).put("data", paramJsBridgeListener);
            super.callJs(paramVarArgs, new String[] { ((JSONObject)localObject).toString() });
            paramJsBridgeListener = "";
          }
          catch (JSONException paramJsBridgeListener)
          {
            label1172:
            QLog.e("ChatBackgroundJsPlugin", 1, "handleJsRequest exception url=" + paramString1 + ", pkgName=" + paramString2 + ", methodName=" + paramString3, paramJsBridgeListener);
          }
          i = 0;
          break label983;
        }
      }
      paramJsBridgeListener = "";
    }
  }
  
  protected void onCreate()
  {
    super.onCreate();
    this.mReqBundle = new Bundle();
    AppInterface localAppInterface = this.mRuntime.a();
    if ((localAppInterface instanceof BrowserAppInterface)) {
      this.browserApp = ((BrowserAppInterface)localAppInterface);
    }
    while (!QLog.isColorLevel()) {
      return;
    }
    QLog.e("ChatBackgroundJsPlugin", 2, "ERROR!!! chatbg market is not running in web process!");
  }
  
  void onPushMsg(Bundle paramBundle)
  {
    if (QLog.isColorLevel()) {
      QLog.i("ChatBackgroundJsPlugin", 2, "onPushMsg=" + paramBundle);
    }
    int i = paramBundle.getInt("id");
    int j = paramBundle.getInt("result");
    paramBundle = paramBundle.getString("callbackId");
    JSONObject localJSONObject = new JSONObject();
    try
    {
      localJSONObject.put("id", i);
      localJSONObject.put("result", j);
      label83:
      super.callJs(paramBundle, new String[] { localJSONObject.toString() });
      return;
    }
    catch (JSONException localJSONException)
    {
      break label83;
    }
  }
  
  protected void onResponse(Bundle paramBundle)
  {
    if (paramBundle == null) {}
    String str1;
    String str2;
    JSONObject localJSONObject;
    do
    {
      do
      {
        do
        {
          return;
        } while (paramBundle.getInt("respkey", 0) != this.mOnRemoteResp.key);
        str1 = paramBundle.getString("cmd");
        try
        {
          str2 = paramBundle.getString("callbackid");
          paramBundle = paramBundle.getBundle("response");
          localJSONObject = new JSONObject();
          if (!"chatbackground_getCurrentId".equals(str1)) {
            break;
          }
          localJSONObject.put("id", paramBundle.getString("id"));
          localJSONObject.put("result", paramBundle.getInt("result"));
          localJSONObject.put("friendUin", paramBundle.getString("friendUin"));
          localJSONObject.put("themeId", paramBundle.getString("themeId"));
          localJSONObject.put("url", paramBundle.getString("url"));
          localJSONObject.put("isDIYTheme", paramBundle.getString("isDIYTheme"));
          super.callJs(str2, new String[] { localJSONObject.toString() });
          return;
        }
        catch (Exception paramBundle) {}
      } while (!QLog.isColorLevel());
      QLog.e("ChatBackgroundJsPlugin", 2, "Failed to handle cmd " + str1 + ", exception: " + paramBundle.getMessage());
      return;
      if ("chatbackground_setbg".equals(str1))
      {
        localJSONObject.put("result", paramBundle.getInt("result"));
        super.callJs(str2, new String[] { localJSONObject.toString() });
        return;
      }
      if ("chatbackground_querinfo".equals(str1))
      {
        localJSONObject.put("status", paramBundle.getInt("status"));
        localJSONObject.put("id", paramBundle.getString("id"));
        localJSONObject.put("message", paramBundle.getString("message"));
        localJSONObject.put("result", paramBundle.getInt("result"));
        localJSONObject.put("progress", paramBundle.getInt("progress"));
        super.callJs(str2, new String[] { localJSONObject.toString() });
        return;
      }
    } while (!"chatbackground_stopdownload".equals(str1));
    localJSONObject.put("id", paramBundle.getString("id"));
    localJSONObject.put("result", 0);
    super.callJs(str2, new String[] { localJSONObject.toString() });
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\tmp\aaa.jar
 * Qualified Name:     com.tencent.mobileqq.vaswebviewplugin.ChatBackgroundJsPlugin
 * JD-Core Version:    0.7.0.1
 */