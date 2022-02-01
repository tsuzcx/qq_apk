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
import com.tencent.biz.pubaccount.CustomWebView;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.app.BrowserAppInterface;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.emosm.DataFactory;
import com.tencent.mobileqq.emosm.OnRemoteRespObserver;
import com.tencent.mobileqq.utils.Base64Util;
import com.tencent.mobileqq.utils.DialogUtil;
import com.tencent.mobileqq.utils.ImageUtil;
import com.tencent.mobileqq.utils.QQCustomDialogThreeBtns;
import com.tencent.mobileqq.webview.swift.JsBridgeListener;
import com.tencent.mobileqq.webview.swift.WebViewPlugin;
import com.tencent.mobileqq.webview.swift.WebViewPlugin.PluginRuntime;
import com.tencent.mobileqq.webview.swift.WebViewPluginEngine;
import com.tencent.mobileqq.webviewplugin.WebUiUtils.WebTitleBarInterface;
import com.tencent.mobileqq.webviewplugin.WebUiUtils.WebViewProviderInterface;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.ActionSheet;
import com.tencent.widget.ActionSheetHelper;
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
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("getNumberPic: ");
      ((StringBuilder)localObject).append(paramJSONObject);
      QLog.i("AvatarPendantJsPlugin", 2, ((StringBuilder)localObject).toString());
    }
    Object localObject = new Bundle();
    ((Bundle)localObject).putString("params", paramJSONObject.toString());
    super.sendRemoteReq(DataFactory.a("getPendantNumberPic", paramString, this.mOnRemoteResp.key, (Bundle)localObject), false, false);
  }
  
  private Bitmap getRoundFaceBitmap(String paramString)
  {
    Object localObject;
    if (new File(paramString).exists()) {
      localObject = ImageUtil.a(new BitmapFactory.Options(), paramString, 200);
    }
    try
    {
      paramString = BitmapFactory.decodeFile(paramString, (BitmapFactory.Options)localObject);
      int i = paramString.getWidth();
      int j = paramString.getHeight();
      localObject = ImageUtil.a(paramString, i, i, j);
      paramString = (String)localObject;
      if (localObject == null) {
        break label96;
      }
      paramString = (String)localObject;
      if (((Bitmap)localObject).getWidth() <= 200) {
        break label96;
      }
      paramString = ImageUtil.a((Bitmap)localObject, 200);
      return paramString;
    }
    catch (OutOfMemoryError paramString)
    {
      label90:
      label96:
      break label90;
    }
    return null;
    paramString = ImageUtil.f();
    return paramString;
  }
  
  private void showDiyGuide(JSONObject paramJSONObject, String paramString)
  {
    Object localObject1 = this.browserApp.getApp();
    Object localObject2 = new StringBuilder();
    ((StringBuilder)localObject2).append("PendantSpName_");
    ((StringBuilder)localObject2).append(this.browserApp.getCurrentAccountUin());
    localObject2 = ((BaseApplication)localObject1).getSharedPreferences(((StringBuilder)localObject2).toString(), 0);
    localObject1 = new JSONObject();
    try
    {
      ((JSONObject)localObject1).put("result", 0);
      boolean bool = paramJSONObject.has("shown");
      if (bool)
      {
        bool = paramJSONObject.optBoolean("shown", false);
        ((SharedPreferences)localObject2).edit().putBoolean("PendantDiyGuideShown", bool).apply();
      }
      else
      {
        ((JSONObject)localObject1).put("shown", ((SharedPreferences)localObject2).getBoolean("PendantDiyGuideShown", false));
      }
    }
    catch (JSONException paramJSONObject)
    {
      QLog.e("AvatarPendantJsPlugin", 1, new Object[] { "showDiyGuide error", paramJSONObject.getMessage() });
    }
    callJs(paramString, new String[] { ((JSONObject)localObject1).toString() });
  }
  
  public void changeFace(JSONObject paramJSONObject, String paramString)
  {
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("changeFace: ");
      localStringBuilder.append(paramJSONObject);
      QLog.i("AvatarPendantJsPlugin", 2, localStringBuilder.toString());
    }
    paramJSONObject = (ActionSheet)ActionSheetHelper.a(this.mRuntime.a(), null);
    paramJSONObject.addButton(HardCodeUtil.a(2131701103));
    paramJSONObject.addButton(HardCodeUtil.a(2131701105));
    paramJSONObject.addCancelButton(HardCodeUtil.a(2131701086));
    paramJSONObject.setOnButtonClickListener(new AvatarPendantJsPlugin.5(this, paramString, paramJSONObject));
    paramJSONObject.setOnDismissListener(new AvatarPendantJsPlugin.6(this, paramString));
    paramJSONObject.show();
  }
  
  public void getFaceAddon(JSONObject paramJSONObject, String paramString)
  {
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("getFaceAddon: ");
      localStringBuilder.append(paramJSONObject);
      QLog.i("AvatarPendantJsPlugin", 2, localStringBuilder.toString());
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
  
  public long getWebViewEventByNameSpace(String paramString)
  {
    return 128L;
  }
  
  protected boolean handleEvent(String paramString, long paramLong, Map<String, Object> paramMap)
  {
    if (paramLong == 128L)
    {
      Object localObject = paramMap.get("intent");
      if ((localObject != null) && ((localObject instanceof Intent)))
      {
        Intent localIntent = (Intent)localObject;
        if (localIntent.getBooleanExtra("keyFromPendantPhoto", false))
        {
          localObject = this.mRuntime;
          WebViewPluginEngine localWebViewPluginEngine = null;
          if (localObject != null) {
            localObject = this.mRuntime.a();
          } else {
            localObject = null;
          }
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
    return super.handleEvent(paramString, paramLong, paramMap);
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
      QLog.d("AvatarPendantJsPlugin", 2, paramJsBridgeListener.toString());
    }
    if ((paramString1 != null) && ("faceAddon".equals(paramString2)))
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
        QLog.d("AvatarPendantJsPlugin", 2, paramString1.toString());
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
      if (QLog.isColorLevel())
      {
        paramJsBridgeListener = new StringBuilder();
        paramJsBridgeListener.append("NOT support method ");
        paramJsBridgeListener.append(paramString3);
        paramJsBridgeListener.append(" yet!!");
        QLog.w("AvatarPendantJsPlugin", 2, paramJsBridgeListener.toString());
      }
    }
    return false;
  }
  
  protected void onCreate()
  {
    super.onCreate();
    AppInterface localAppInterface = this.mRuntime.a();
    if ((localAppInterface instanceof BrowserAppInterface))
    {
      this.browserApp = ((BrowserAppInterface)localAppInterface);
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.e("AvatarPendantJsPlugin", 2, "ERROR!!! Pendant market is not running in web process!");
    }
  }
  
  protected void onResponse(Bundle paramBundle)
  {
    if (paramBundle == null) {
      return;
    }
    if (paramBundle.getInt("respkey", 0) == this.mOnRemoteResp.key)
    {
      String str1 = paramBundle.getString("cmd");
      try
      {
        localObject1 = paramBundle.getString("callbackid");
        Object localObject2 = paramBundle.getBundle("request");
        Object localObject3 = paramBundle.getBundle("response");
        paramBundle = new JSONObject();
        boolean bool = "changeAvatar".equals(str1);
        if (bool)
        {
          if (((Bundle)localObject3).getBoolean("updateResult"))
          {
            localObject2 = getRoundFaceBitmap(((Bundle)localObject2).getString("path"));
            if (localObject2 == null)
            {
              paramBundle.put("result", 1002);
            }
            else
            {
              localObject3 = new ByteArrayOutputStream();
              ((Bitmap)localObject2).compress(Bitmap.CompressFormat.PNG, 100, (OutputStream)localObject3);
              String str2 = Base64Util.encodeToString(((ByteArrayOutputStream)localObject3).toByteArray(), 2);
              paramBundle.put("result", 1);
              StringBuilder localStringBuilder = new StringBuilder();
              localStringBuilder.append("data:image/png;base64,");
              localStringBuilder.append(str2);
              paramBundle.put("file", localStringBuilder.toString());
              paramBundle.put("size", ((Bitmap)localObject2).getWidth());
              ((ByteArrayOutputStream)localObject3).close();
            }
          }
          else
          {
            localObject2 = this.mRuntime.a();
            if ((localObject2 != null) && (((WebUiUtils.WebViewProviderInterface)localObject2).getWebTitleBarInterface() != null)) {
              QQToast.a(this.mRuntime.a(), 2131718781, 0).b(((WebUiUtils.WebViewProviderInterface)localObject2).getWebTitleBarInterface().a());
            }
            paramBundle.put("result", 1001);
          }
        }
        else if ("updatePendantId".equals(str1))
        {
          if (((Bundle)localObject3).getBoolean("updateResult", false)) {
            paramBundle.put("result", 0);
          } else {
            paramBundle.put("result", -1);
          }
        }
        else if ("getPendantNumberPic".equals(str1))
        {
          if (((Bundle)localObject3).getBoolean("updateResult", false))
          {
            paramBundle.put("result", 0);
            paramBundle.put("file", ((Bundle)localObject3).getString("file"));
          }
          else
          {
            paramBundle.put("result", -1);
            paramBundle.put("errMsg", ((Bundle)localObject3).getString("errMsg"));
          }
          if (!this.mNumPicRequests.isEmpty())
          {
            localObject2 = (JSONObject)this.mNumPicRequests.remove(0);
            getNumberPic((JSONObject)localObject2, ((JSONObject)localObject2).optString("callback"));
          }
        }
        localObject2 = new StringBuilder();
        ((StringBuilder)localObject2).append((String)localObject1);
        ((StringBuilder)localObject2).append("(");
        ((StringBuilder)localObject2).append(paramBundle.toString());
        ((StringBuilder)localObject2).append(");");
        super.callJs(((StringBuilder)localObject2).toString());
        return;
      }
      catch (Exception paramBundle)
      {
        Object localObject1;
        if (QLog.isColorLevel())
        {
          localObject1 = new StringBuilder();
          ((StringBuilder)localObject1).append("Failed to handle cmd ");
          ((StringBuilder)localObject1).append(str1);
          ((StringBuilder)localObject1).append(", exception: ");
          ((StringBuilder)localObject1).append(paramBundle.getMessage());
          QLog.e("AvatarPendantJsPlugin", 2, ((StringBuilder)localObject1).toString());
        }
      }
    }
  }
  
  public void showMsgBox(JSONObject paramJSONObject, String paramString)
  {
    Object localObject;
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("showMsgBox: ");
      ((StringBuilder)localObject).append(paramJSONObject);
      QLog.i("AvatarPendantJsPlugin", 2, ((StringBuilder)localObject).toString());
    }
    try
    {
      localObject = paramJSONObject.getString("msg");
      String str = paramJSONObject.getString("title");
      paramJSONObject = paramJSONObject.getJSONArray("button");
      if (paramJSONObject.length() >= 1)
      {
        QQCustomDialogThreeBtns localQQCustomDialogThreeBtns = DialogUtil.a(this.mRuntime.a(), 230);
        localQQCustomDialogThreeBtns.a(str);
        localQQCustomDialogThreeBtns.b((String)localObject);
        localQQCustomDialogThreeBtns.a(paramJSONObject.getString(0), new AvatarPendantJsPlugin.2(this, paramString));
        if (paramJSONObject.length() >= 2) {
          localQQCustomDialogThreeBtns.b(paramJSONObject.getString(1), new AvatarPendantJsPlugin.3(this, paramString));
        }
        if (paramJSONObject.length() >= 3) {
          localQQCustomDialogThreeBtns.c(paramJSONObject.getString(2), new AvatarPendantJsPlugin.4(this, paramString));
        }
        localQQCustomDialogThreeBtns.show();
        paramJSONObject = new JSONObject();
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append(paramString);
        ((StringBuilder)localObject).append("(");
        ((StringBuilder)localObject).append(paramJSONObject.toString());
        ((StringBuilder)localObject).append(");");
        super.callJs(((StringBuilder)localObject).toString());
        return;
      }
      boolean bool = QLog.isColorLevel();
      if (bool) {
        QLog.e("AvatarPendantJsPlugin", 2, "no button message");
      }
      throw new Exception("no button message");
    }
    catch (Exception paramJSONObject)
    {
      if (QLog.isColorLevel())
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("showMsgBox failed: ");
        ((StringBuilder)localObject).append(paramJSONObject.getMessage());
        QLog.e("AvatarPendantJsPlugin", 2, ((StringBuilder)localObject).toString());
      }
      super.callJsOnError(paramString, paramJSONObject.getMessage());
    }
  }
  
  public void updateFaceAddon(JSONObject paramJSONObject, String paramString)
  {
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("updateFaceAddon: ");
      ((StringBuilder)localObject).append(paramJSONObject);
      QLog.i("AvatarPendantJsPlugin", 2, ((StringBuilder)localObject).toString());
    }
    try
    {
      long l = paramJSONObject.getLong("id");
      localObject = new Bundle();
      ((Bundle)localObject).putString("uin", this.browserApp.getAccount());
      ((Bundle)localObject).putLong("pendantId", l);
    }
    catch (JSONException paramJSONObject)
    {
      label97:
      label115:
      if (QLog.isColorLevel())
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("updateFaceAddon failed: ");
        ((StringBuilder)localObject).append(paramJSONObject.getMessage());
        QLog.e("AvatarPendantJsPlugin", 2, ((StringBuilder)localObject).toString());
      }
      super.callJsOnError(paramString, paramJSONObject.getMessage());
      return;
    }
    try
    {
      paramJSONObject.getLong("t");
      bool = true;
    }
    catch (Exception paramJSONObject)
    {
      break label97;
      bool = false;
      break label115;
    }
    if (QLog.isColorLevel())
    {
      QLog.i("AvatarPendantJsPlugin", 2, "updateFaceAddon: isDiyPendant = false");
      break label208;
      ((Bundle)localObject).putBoolean("is_diypendant", bool);
      super.sendRemoteReq(DataFactory.a("updatePendantId", paramString, this.mOnRemoteResp.key, (Bundle)localObject), false, false);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.vaswebviewplugin.AvatarPendantJsPlugin
 * JD-Core Version:    0.7.0.1
 */