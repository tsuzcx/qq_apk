package com.tencent.mobileqq.vaswebviewplugin;

import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.graphics.Bitmap;
import android.graphics.Bitmap.CompressFormat;
import android.graphics.BitmapFactory;
import android.graphics.BitmapFactory.Options;
import android.os.Bundle;
import android.text.TextUtils;
import anzj;
import aser;
import asev;
import bhkv;
import bhlq;
import bhmq;
import bhpr;
import bioy;
import bitr;
import blir;
import blji;
import com.tencent.biz.pubaccount.CustomWebView;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.app.BrowserAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.webview.swift.JsBridgeListener;
import com.tencent.mobileqq.webview.swift.WebViewPlugin;
import com.tencent.mobileqq.webview.swift.WebViewPluginEngine;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.OutputStream;
import java.util.HashMap;
import java.util.Map;
import java.util.Vector;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class AvatarPendantJsPlugin
  extends VasWebviewJsPlugin
{
  public static final String BUSINESS_NAME = "faceAddon";
  private static final String JS_REQUEST_SCHEME = "jsbridge";
  public static final String KEY_FORM_PENDANT_PHOTO = "keyFromPendantPhoto";
  public static final int MENU_ITEM_SELECT_PHOTO = 1;
  public static final int MENU_ITEM_TAKE_PHOTO = 0;
  public static final String PENDANT_SP_KEY_DIY_GUIDE_SHOW = "PendantDiyGuideShown";
  public static final String PENDANT_SP_NAME = "PendantSpName_";
  static final String TAG = "AvatarPendantJsPlugin";
  public BrowserAppInterface browserApp;
  Vector<JSONObject> mNumPicRequests = new Vector();
  
  public AvatarPendantJsPlugin()
  {
    this.mPluginNameSpace = "faceAddon";
  }
  
  private void getNumberPic(JSONObject paramJSONObject, String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.i("AvatarPendantJsPlugin", 2, "getNumberPic: " + paramJSONObject);
    }
    Bundle localBundle = new Bundle();
    localBundle.putString("params", paramJSONObject.toString());
    super.sendRemoteReq(asev.a("getPendantNumberPic", paramString, this.mOnRemoteResp.key, localBundle), false, false);
  }
  
  private Bitmap getRoundFaceBitmap(String paramString)
  {
    if (new File(paramString).exists())
    {
      Object localObject = bhmq.a(new BitmapFactory.Options(), paramString, 200);
      try
      {
        paramString = BitmapFactory.decodeFile(paramString, (BitmapFactory.Options)localObject);
        int i = paramString.getWidth();
        int j = paramString.getHeight();
        localObject = bhmq.a(paramString, i, i, j);
        paramString = (String)localObject;
        if (localObject != null)
        {
          paramString = (String)localObject;
          if (((Bitmap)localObject).getWidth() > 200) {
            paramString = bhmq.a((Bitmap)localObject, 200);
          }
        }
        return paramString;
      }
      catch (OutOfMemoryError paramString)
      {
        return null;
      }
    }
    return bhmq.a();
  }
  
  private void showDiyGuide(JSONObject paramJSONObject, String paramString)
  {
    SharedPreferences localSharedPreferences = this.browserApp.getApp().getSharedPreferences("PendantSpName_" + this.browserApp.getCurrentAccountUin(), 0);
    JSONObject localJSONObject = new JSONObject();
    try
    {
      localJSONObject.put("result", 0);
      if (paramJSONObject.has("shown"))
      {
        boolean bool = paramJSONObject.optBoolean("shown", false);
        localSharedPreferences.edit().putBoolean("PendantDiyGuideShown", bool).apply();
      }
      for (;;)
      {
        callJs(paramString, new String[] { localJSONObject.toString() });
        return;
        localJSONObject.put("shown", localSharedPreferences.getBoolean("PendantDiyGuideShown", false));
      }
    }
    catch (JSONException paramJSONObject)
    {
      for (;;)
      {
        QLog.e("AvatarPendantJsPlugin", 1, new Object[] { "showDiyGuide error", paramJSONObject.getMessage() });
      }
    }
  }
  
  public void changeFace(JSONObject paramJSONObject, String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.i("AvatarPendantJsPlugin", 2, "changeFace: " + paramJSONObject);
    }
    paramJSONObject = (blir)blji.a(this.mRuntime.a(), null);
    paramJSONObject.c(anzj.a(2131699796));
    paramJSONObject.c(anzj.a(2131699798));
    paramJSONObject.d(anzj.a(2131699779));
    paramJSONObject.a(new AvatarPendantJsPlugin.5(this, paramString, paramJSONObject));
    paramJSONObject.a(new AvatarPendantJsPlugin.6(this, paramString));
    paramJSONObject.show();
  }
  
  public void getFaceAddon(JSONObject paramJSONObject, String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.i("AvatarPendantJsPlugin", 2, "getFaceAddon: " + paramJSONObject);
    }
    ThreadManager.post(new AvatarPendantJsPlugin.1(this, paramString), 8, null, false);
  }
  
  public int getIPCResponseKey()
  {
    return this.mOnRemoteResp.key;
  }
  
  protected long getPluginBusiness()
  {
    return 2147484160L;
  }
  
  public boolean handleEvent(String paramString, long paramLong, Map<String, Object> paramMap)
  {
    WebViewPluginEngine localWebViewPluginEngine = null;
    if (paramLong == 128L)
    {
      Object localObject = paramMap.get("intent");
      if ((localObject != null) && ((localObject instanceof Intent)))
      {
        Intent localIntent = (Intent)localObject;
        if (localIntent.getBooleanExtra("keyFromPendantPhoto", false))
        {
          if (this.mRuntime != null) {}
          for (localObject = this.mRuntime.a();; localObject = null)
          {
            if (localObject != null) {
              localWebViewPluginEngine = ((CustomWebView)localObject).getPluginEngine();
            }
            if (localWebViewPluginEngine != null)
            {
              new HashMap().put("intent", localIntent);
              localWebViewPluginEngine.a(paramString, 8589934605L, paramMap);
            }
            return true;
          }
        }
      }
    }
    return super.handleEvent(paramString, paramLong, paramMap);
  }
  
  public boolean handleJsRequest(JsBridgeListener paramJsBridgeListener, String paramString1, String paramString2, String paramString3, String... paramVarArgs)
  {
    boolean bool = true;
    if (QLog.isColorLevel()) {
      QLog.d("AvatarPendantJsPlugin", 2, "handleJsRequest, url=" + paramString1 + ", pkgName=" + paramString2 + ", methodName=" + paramString3);
    }
    if ((paramString1 == null) || (!"faceAddon".equals(paramString2)) || (paramString3 == null)) {
      bool = false;
    }
    do
    {
      return bool;
      paramJsBridgeListener = WebViewPlugin.getJsonFromJSBridge(paramString1);
    } while (paramJsBridgeListener == null);
    if (QLog.isColorLevel()) {
      QLog.d("AvatarPendantJsPlugin", 2, "handleJsRequest JSON = " + paramJsBridgeListener.toString());
    }
    paramString1 = paramJsBridgeListener.optString("callback");
    if (TextUtils.isEmpty(paramString1))
    {
      QLog.e("AvatarPendantJsPlugin", 1, "callback id is null, so return");
      return true;
    }
    if ("getFaceAddon".equals(paramString3))
    {
      getFaceAddon(paramJsBridgeListener, paramString1);
      return true;
    }
    if ("updateFaceAddon".equals(paramString3))
    {
      updateFaceAddon(paramJsBridgeListener, paramString1);
      return true;
    }
    if ("showMsgBox".equals(paramString3))
    {
      showMsgBox(paramJsBridgeListener, paramString1);
      return true;
    }
    if ("changeFace".equals(paramString3))
    {
      changeFace(paramJsBridgeListener, paramString1);
      return true;
    }
    if ("showDiyGuide".equals(paramString3))
    {
      showDiyGuide(paramJsBridgeListener, paramString1);
      return true;
    }
    if ("getNumberPic".equals(paramString3))
    {
      if (this.mNumPicRequests.isEmpty())
      {
        getNumberPic(paramJsBridgeListener, paramString1);
        return true;
      }
      this.mNumPicRequests.add(paramJsBridgeListener);
      return true;
    }
    if (QLog.isColorLevel()) {
      QLog.w("AvatarPendantJsPlugin", 2, "NOT support method " + paramString3 + " yet!!");
    }
    return false;
  }
  
  public void onCreate()
  {
    super.onCreate();
    AppInterface localAppInterface = this.mRuntime.a();
    if ((localAppInterface instanceof BrowserAppInterface)) {
      this.browserApp = ((BrowserAppInterface)localAppInterface);
    }
    while (!QLog.isColorLevel()) {
      return;
    }
    QLog.e("AvatarPendantJsPlugin", 2, "ERROR!!! Pendant market is not running in web process!");
  }
  
  protected void onResponse(Bundle paramBundle)
  {
    if (paramBundle == null) {
      break label4;
    }
    label4:
    while (paramBundle.getInt("respkey", 0) != this.mOnRemoteResp.key) {
      return;
    }
    String str1 = paramBundle.getString("cmd");
    label515:
    for (;;)
    {
      try
      {
        String str2 = paramBundle.getString("callbackid");
        localObject1 = paramBundle.getBundle("request");
        localObject2 = paramBundle.getBundle("response");
        paramBundle = new JSONObject();
        if (!"changeAvatar".equals(str1)) {
          break label361;
        }
        if (!((Bundle)localObject2).getBoolean("updateResult")) {
          break label291;
        }
        localObject1 = getRoundFaceBitmap(((Bundle)localObject1).getString("path"));
        if (localObject1 != null) {
          break label200;
        }
        paramBundle.put("result", 1002);
        super.callJs(str2 + "(" + paramBundle.toString() + ");");
        return;
      }
      catch (Exception paramBundle) {}
      if (!QLog.isColorLevel()) {
        break;
      }
      QLog.e("AvatarPendantJsPlugin", 2, "Failed to handle cmd " + str1 + ", exception: " + paramBundle.getMessage());
      return;
      label200:
      Object localObject2 = new ByteArrayOutputStream();
      ((Bitmap)localObject1).compress(Bitmap.CompressFormat.PNG, 100, (OutputStream)localObject2);
      String str3 = bhkv.encodeToString(((ByteArrayOutputStream)localObject2).toByteArray(), 2);
      paramBundle.put("result", 1);
      paramBundle.put("file", "data:image/png;base64," + str3);
      paramBundle.put("size", ((Bitmap)localObject1).getWidth());
      ((ByteArrayOutputStream)localObject2).close();
      continue;
      label291:
      Object localObject1 = this.mRuntime.a(this.mRuntime.a());
      if ((localObject1 != null) && ((localObject1 instanceof bitr))) {
        QQToast.a(this.mRuntime.a(), 2131717917, 0).b(((bitr)localObject1).getTitleBarHeight());
      }
      paramBundle.put("result", 1001);
      continue;
      label361:
      if ("updatePendantId".equals(str1))
      {
        if (((Bundle)localObject2).getBoolean("updateResult", false)) {
          paramBundle.put("result", 0);
        } else {
          paramBundle.put("result", -1);
        }
      }
      else if ("getPendantNumberPic".equals(str1))
      {
        if (((Bundle)localObject2).getBoolean("updateResult", false))
        {
          paramBundle.put("result", 0);
          paramBundle.put("file", ((Bundle)localObject2).getString("file"));
        }
        for (;;)
        {
          if (this.mNumPicRequests.isEmpty()) {
            break label515;
          }
          localObject1 = (JSONObject)this.mNumPicRequests.remove(0);
          getNumberPic((JSONObject)localObject1, ((JSONObject)localObject1).optString("callback"));
          break;
          paramBundle.put("result", -1);
          paramBundle.put("errMsg", ((Bundle)localObject2).getString("errMsg"));
        }
      }
    }
  }
  
  public void showMsgBox(JSONObject paramJSONObject, String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.i("AvatarPendantJsPlugin", 2, "showMsgBox: " + paramJSONObject);
    }
    try
    {
      String str1 = paramJSONObject.getString("msg");
      String str2 = paramJSONObject.getString("title");
      paramJSONObject = paramJSONObject.getJSONArray("button");
      if (paramJSONObject.length() >= 1)
      {
        bhpr localbhpr = bhlq.a(this.mRuntime.a(), 230);
        localbhpr.a(str2);
        localbhpr.b(str1);
        localbhpr.a(paramJSONObject.getString(0), new AvatarPendantJsPlugin.2(this, paramString));
        if (paramJSONObject.length() >= 2) {
          localbhpr.b(paramJSONObject.getString(1), new AvatarPendantJsPlugin.3(this, paramString));
        }
        if (paramJSONObject.length() >= 3) {
          localbhpr.c(paramJSONObject.getString(2), new AvatarPendantJsPlugin.4(this, paramString));
        }
        localbhpr.show();
        paramJSONObject = new JSONObject();
        super.callJs(paramString + "(" + paramJSONObject.toString() + ");");
        return;
      }
      if (QLog.isColorLevel()) {
        QLog.e("AvatarPendantJsPlugin", 2, "no button message");
      }
      throw new Exception("no button message");
    }
    catch (Exception paramJSONObject)
    {
      if (QLog.isColorLevel()) {
        QLog.e("AvatarPendantJsPlugin", 2, "showMsgBox failed: " + paramJSONObject.getMessage());
      }
      super.callJsOnError(paramString, paramJSONObject.getMessage());
    }
  }
  
  public void updateFaceAddon(JSONObject paramJSONObject, String paramString)
  {
    boolean bool2 = false;
    if (QLog.isColorLevel()) {
      QLog.i("AvatarPendantJsPlugin", 2, "updateFaceAddon: " + paramJSONObject);
    }
    try
    {
      long l = paramJSONObject.getLong("id");
      Bundle localBundle = new Bundle();
      localBundle.putString("uin", this.browserApp.getAccount());
      localBundle.putLong("pendantId", l);
      try
      {
        paramJSONObject.getLong("t");
        bool1 = true;
      }
      catch (Exception paramJSONObject)
      {
        for (;;)
        {
          boolean bool1 = bool2;
          if (QLog.isColorLevel())
          {
            QLog.i("AvatarPendantJsPlugin", 2, "updateFaceAddon: isDiyPendant = false");
            bool1 = bool2;
          }
        }
      }
      localBundle.putBoolean("is_diypendant", bool1);
      super.sendRemoteReq(asev.a("updatePendantId", paramString, this.mOnRemoteResp.key, localBundle), false, false);
      return;
    }
    catch (JSONException paramJSONObject)
    {
      if (QLog.isColorLevel()) {
        QLog.e("AvatarPendantJsPlugin", 2, "updateFaceAddon failed: " + paramJSONObject.getMessage());
      }
      super.callJsOnError(paramString, paramJSONObject.getMessage());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.vaswebviewplugin.AvatarPendantJsPlugin
 * JD-Core Version:    0.7.0.1
 */