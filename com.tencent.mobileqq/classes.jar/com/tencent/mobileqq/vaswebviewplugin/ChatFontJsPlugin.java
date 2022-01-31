package com.tencent.mobileqq.vaswebviewplugin;

import android.app.Activity;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.graphics.Bitmap;
import android.graphics.Bitmap.CompressFormat;
import android.graphics.Bitmap.Config;
import android.graphics.Paint.FontMetrics;
import android.os.Bundle;
import android.text.TextUtils;
import com.etrump.mixlayout.ETEngine;
import com.etrump.mixlayout.ETFont;
import com.etrump.mixlayout.FontManager;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.app.BrowserAppInterface;
import com.tencent.mobileqq.app.DeviceProfileManager;
import com.tencent.mobileqq.app.DeviceProfileManager.DpcNames;
import com.tencent.mobileqq.data.ExtensionInfo;
import com.tencent.mobileqq.emosm.Client.onRemoteRespObserver;
import com.tencent.mobileqq.emosm.DataFactory;
import com.tencent.mobileqq.persistence.EntityManager;
import com.tencent.mobileqq.persistence.EntityManagerFactory;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.utils.Base64Util;
import com.tencent.mobileqq.utils.DialogUtil;
import com.tencent.mobileqq.utils.QQCustomDialog;
import com.tencent.mobileqq.utils.VasUtils;
import com.tencent.mobileqq.webview.swift.JsBridgeListener;
import com.tencent.mobileqq.webview.swift.WebViewPlugin;
import com.tencent.mobileqq.webview.swift.WebViewPlugin.PluginRuntime;
import com.tencent.mobileqq.webviewplugin.WebUiUtils.WebTitleBarInterface;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.atomic.AtomicBoolean;
import mqq.app.MobileQQ;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class ChatFontJsPlugin
  extends VasWebviewJsPlugin
{
  public static final String BUSINESS_NAME = "font";
  private static final String TAG = "ChatFontJsPlugin";
  private BrowserAppInterface browserApp;
  private boolean isUseFont;
  private HashMap mFontSize;
  private Bundle mReqBundle;
  
  public ChatFontJsPlugin()
  {
    this.mPluginNameSpace = "font";
  }
  
  private ChatFontJsPlugin.FontPadding calculateFontPadding(ETFont paramETFont)
  {
    Object localObject = new Paint.FontMetrics();
    ETEngine.getInstance().native_getFontMetrics((Paint.FontMetrics)localObject, paramETFont);
    float f = Math.abs(((Paint.FontMetrics)localObject).ascent);
    f = ((Paint.FontMetrics)localObject).descent + f;
    localObject = new ChatFontJsPlugin.FontPadding();
    if (f > paramETFont.getSize())
    {
      ((ChatFontJsPlugin.FontPadding)localObject).paddingType = 1;
      ((ChatFontJsPlugin.FontPadding)localObject).fontSize = (paramETFont.getSize() * paramETFont.getSize() / f);
      ((ChatFontJsPlugin.FontPadding)localObject).padding = ((paramETFont.getSize() - ((ChatFontJsPlugin.FontPadding)localObject).fontSize) / 2.0F);
      return localObject;
    }
    ((ChatFontJsPlugin.FontPadding)localObject).paddingType = 2;
    ((ChatFontJsPlugin.FontPadding)localObject).fontSize = paramETFont.getSize();
    ((ChatFontJsPlugin.FontPadding)localObject).padding = ((paramETFont.getSize() - f) / 2.0F);
    return localObject;
  }
  
  private void checkDiyFontText(int paramInt1, int paramInt2, String paramString1, String paramString2)
  {
    if (TextUtils.isEmpty(paramString1))
    {
      if (QLog.isColorLevel()) {
        QLog.d("ChatFontJsPlugin", 2, "checkDiyFontText fail text is empty");
      }
      super.callJs(paramString2, new String[] { "{\"ret\":-2}" });
      return;
    }
    if (!ETEngine.getInstance().isEngineReady.get())
    {
      if (QLog.isColorLevel()) {
        QLog.d("ChatFontJsPlugin", 2, "checkDiyFontText fail engine not ready");
      }
      super.callJs(paramString2, new String[] { "{\"ret\":-2}" });
      return;
    }
    if (!FontManager.a(paramInt1, paramInt2))
    {
      if (QLog.isColorLevel()) {
        QLog.d("ChatFontJsPlugin", 2, "checkDiyFontText fail font not exists id = " + paramInt1);
      }
      super.callJs(paramString2, new String[] { "{\"ret\":-2}" });
      return;
    }
    ETFont localETFont = new ETFont(paramInt1, FontManager.a(paramInt1, paramInt2), 16.0F);
    if (!ETEngine.getInstance().native_diyFontIsDIYFont(localETFont))
    {
      if (QLog.isColorLevel()) {
        QLog.d("ChatFontJsPlugin", 2, "checkDiyFontText fail font is not diy font id = " + paramInt1);
      }
      super.callJs(paramString2, new String[] { "{\"ret\":-2}" });
      return;
    }
    Object localObject1 = "";
    paramInt1 = 0;
    while (paramInt1 < paramString1.length())
    {
      paramInt2 = paramString1.charAt(paramInt1);
      Object localObject2;
      if ((paramInt2 >= 19968) && (paramInt2 <= 40869))
      {
        localObject2 = localObject1;
        if (ETEngine.getInstance().native_diyFontGetCharIndex(paramString1.charAt(paramInt1), localETFont) != 0) {}
      }
      else
      {
        localObject2 = (String)localObject1 + paramString1.charAt(paramInt1);
      }
      paramInt1 += 1;
      localObject1 = localObject2;
    }
    if (TextUtils.isEmpty((CharSequence)localObject1))
    {
      if (QLog.isColorLevel()) {
        QLog.d("ChatFontJsPlugin", 2, "checkDiyFontText all text valid");
      }
      super.callJs(paramString2, new String[] { "{\"ret\":0}" });
      return;
    }
    paramString1 = "{\"ret\":-1,\"data\":{\"invalidText\":\"" + (String)localObject1 + "\"}}";
    if (QLog.isColorLevel()) {
      QLog.d("ChatFontJsPlugin", 2, "checkDiyFontText result = " + paramString1);
    }
    super.callJs(paramString2, new String[] { paramString1 });
  }
  
  private void getDiyFontInfo(int paramInt1, int paramInt2, String paramString)
  {
    if (!ETEngine.getInstance().isEngineReady.get())
    {
      if (QLog.isColorLevel()) {
        QLog.d("ChatFontJsPlugin", 2, "getDiyFontInfo fail engine not ready");
      }
      super.callJs(paramString, new String[] { "{\"ret\":-1}" });
    }
    for (;;)
    {
      return;
      if (!FontManager.a(paramInt1, paramInt2))
      {
        if (QLog.isColorLevel()) {
          QLog.d("ChatFontJsPlugin", 2, "getDiyFontInfo fail font not exists id = " + paramInt1);
        }
        super.callJs(paramString, new String[] { "{\"ret\":-1}" });
        return;
      }
      Object localObject1 = new ETFont(paramInt1, FontManager.a(paramInt1, paramInt2), 16.0F);
      if (!ETEngine.getInstance().native_diyFontIsDIYFont((ETFont)localObject1))
      {
        if (QLog.isColorLevel()) {
          QLog.d("ChatFontJsPlugin", 2, "getDiyFontInfo fail font is not diy font id = " + paramInt1);
        }
        super.callJs(paramString, new String[] { "{\"ret\":-1}" });
        return;
      }
      paramInt2 = ETEngine.getInstance().native_diyFontGetUPEM((ETFont)localObject1);
      if (paramInt2 <= 0)
      {
        if (QLog.isColorLevel()) {
          QLog.d("ChatFontJsPlugin", 2, "getDiyFontInfo get upem fail fontid = " + paramInt1 + " upem = " + paramInt2);
        }
        super.callJs(paramString, new String[] { "{\"ret\":-1}" });
        return;
      }
      ((ETFont)localObject1).setSize(paramInt2);
      Object localObject2 = new Paint.FontMetrics();
      ETEngine.getInstance().native_getFontMetrics((Paint.FontMetrics)localObject2, (ETFont)localObject1);
      paramInt1 = (int)(Math.abs(((Paint.FontMetrics)localObject2).ascent) + ((Paint.FontMetrics)localObject2).descent);
      localObject1 = new JSONObject();
      try
      {
        ((JSONObject)localObject1).put("ret", 0);
        localObject2 = new JSONObject();
        ((JSONObject)localObject2).put("upem", paramInt2);
        ((JSONObject)localObject2).put("height", paramInt1);
        ((JSONObject)localObject1).put("data", localObject2);
        super.callJs(paramString, new String[] { ((JSONObject)localObject1).toString() });
        if (QLog.isColorLevel())
        {
          QLog.d("ChatFontJsPlugin", 2, "getDiyFontInfo result = " + ((JSONObject)localObject1).toString());
          return;
        }
      }
      catch (Exception localException)
      {
        QLog.e("ChatFontJsPlugin", 2, "getDiyFontInfo error: ", localException);
        super.callJs(paramString, new String[] { "{\"ret\":-1}" });
      }
    }
  }
  
  private void searchFontInDir(File paramFile, JSONArray paramJSONArray)
  {
    if ((paramFile.exists()) && (paramFile.isDirectory())) {
      paramFile.listFiles(new ChatFontJsPlugin.1(this, paramJSONArray));
    }
  }
  
  private void setFontSwitch(JSONObject paramJSONObject, String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ChatFontJsPlugin", 2, "setFontSwitch:" + paramJSONObject);
    }
    try
    {
      int i = paramJSONObject.getInt("action");
      this.mReqBundle.clear();
      this.mReqBundle.putInt("action", i);
      super.sendRemoteReq(DataFactory.a("setFontSwtich", paramString, this.mOnRemoteResp.key, this.mReqBundle), false, true);
      return;
    }
    catch (JSONException paramJSONObject)
    {
      paramJSONObject.printStackTrace();
      super.callJs(paramString, new String[] { paramJSONObject.getMessage() });
    }
  }
  
  void diyPreview(String paramString1, int paramInt1, int paramInt2, String paramString2, String paramString3, int paramInt3)
  {
    if (!ETEngine.getInstance().isEngineReady.get())
    {
      if (QLog.isColorLevel()) {
        QLog.d("ChatFontJsPlugin", 2, "diyPreview engine not ready");
      }
      tryInitHYEngine("0");
      super.callJs(paramString1, new String[] { "{\"ret\":-1}" });
    }
    do
    {
      return;
      if ((!TextUtils.isEmpty(paramString2)) && (paramInt3 > 0)) {
        break;
      }
      super.callJs(paramString1, new String[] { "{\"ret\":-1}" });
    } while (!QLog.isColorLevel());
    QLog.d("ChatFontJsPlugin", 2, "diyPreview text = " + paramString2 + " fontsize = " + paramInt3);
    return;
    if (!FontManager.a(paramInt1, paramInt2))
    {
      if (QLog.isColorLevel()) {
        QLog.d("ChatFontJsPlugin", 2, "diyPreview font not exists");
      }
      super.callJs(paramString1, new String[] { "{\"ret\":-1}" });
      startDownloadFont(paramInt1, paramInt2, "0");
      return;
    }
    if (!ETEngine.getInstance().native_isFontLoaded(paramInt1)) {
      ETEngine.getInstance().native_loadFont(FontManager.a(paramInt1, paramInt2), paramInt1, false);
    }
    ETFont localETFont = new ETFont(paramInt1, FontManager.a(paramInt1, paramInt2), paramInt3 * 2);
    if (!ETEngine.getInstance().native_diyFontIsDIYFont(localETFont))
    {
      if (QLog.isColorLevel()) {
        QLog.d("ChatFontJsPlugin", 2, "checkDiyFontText fail font is not diy font id = " + paramInt1);
      }
      super.callJs(paramString1, new String[] { "{\"ret\":-1}" });
      return;
    }
    Object localObject = calculateFontPadding(localETFont);
    localETFont.setSize(((ChatFontJsPlugin.FontPadding)localObject).fontSize);
    localETFont.parseDIYJsonString(paramString3);
    int k = paramString2.length();
    try
    {
      paramString3 = Bitmap.createBitmap(paramInt3 * 2 * k, paramInt3 * 2, Bitmap.Config.ARGB_8888);
      paramInt1 = 0;
      if (paramInt1 < k)
      {
        int j = paramInt3 * 2 * paramInt1;
        int i = 0;
        if (((ChatFontJsPlugin.FontPadding)localObject).paddingType == 1) {
          paramInt2 = (int)(j + ((ChatFontJsPlugin.FontPadding)localObject).padding);
        }
        for (;;)
        {
          ETEngine.getInstance().native_drawText(paramString2.substring(paramInt1, paramInt1 + 1), paramString3, paramInt2, i, localETFont);
          paramInt1 += 1;
          break;
          paramInt2 = j;
          if (((ChatFontJsPlugin.FontPadding)localObject).paddingType == 2)
          {
            i = (int)(0 + ((ChatFontJsPlugin.FontPadding)localObject).padding);
            paramInt2 = j;
          }
        }
      }
      paramString2 = new ByteArrayOutputStream();
      paramString3.compress(Bitmap.CompressFormat.PNG, 100, paramString2);
      paramString2 = Base64Util.encodeToString(paramString2.toByteArray(), 2);
      localObject = new JSONObject();
      JSONObject localJSONObject = new JSONObject();
      localJSONObject.put("img", paramString2);
      localJSONObject.put("width", paramString3.getWidth());
      localJSONObject.put("height", paramString3.getHeight());
      ((JSONObject)localObject).put("data", localJSONObject);
      ((JSONObject)localObject).put("ret", 0);
      super.callJs(paramString1, new String[] { ((JSONObject)localObject).toString() });
      if (QLog.isColorLevel()) {
        QLog.d("ChatFontJsPlugin", 2, "diyPreview result = " + ((JSONObject)localObject).toString());
      }
      paramString3.recycle();
    }
    catch (OutOfMemoryError paramString2)
    {
      for (;;)
      {
        QLog.e("ChatFontJsPlugin", 1, "diyPreview createBitmap OOM");
        super.callJs(paramString1, new String[] { "{\"ret\":-1}" });
      }
    }
    catch (Exception paramString2)
    {
      for (;;)
      {
        QLog.e("ChatFontJsPlugin", 1, "diyPreview createBitmap OOM");
        super.callJs(paramString1, new String[] { "{\"ret\":-1}" });
      }
    }
    ETEngine.getInstance().native_diyFontDeleteNativeConfig(localETFont.m_diyHandle);
  }
  
  protected long getPluginBusiness()
  {
    return 2147487744L;
  }
  
  protected boolean handleJsRequest(JsBridgeListener paramJsBridgeListener, String paramString1, String paramString2, String paramString3, String... paramVarArgs)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ChatFontJsPlugin", 2, "handleJsRequest, url=" + paramString1 + ", pkgName=" + paramString2 + ", methodName=" + paramString3);
    }
    if ((paramString1 == null) || (!"font".equals(paramString2)) || (paramString3 == null)) {
      return false;
    }
    paramString2 = WebViewPlugin.getJsonFromJSBridge(paramString1);
    if (paramString2 == null) {
      return true;
    }
    if (QLog.isColorLevel()) {
      QLog.d("ChatFontJsPlugin", 2, "handleJsRequest JSON = " + paramString2.toString());
    }
    int i = paramString2.optInt("id");
    int j = paramString2.optInt("type");
    paramString1 = paramString2.optString("callback");
    if (TextUtils.isEmpty(paramString1))
    {
      QLog.e("ChatFontJsPlugin", 1, "callback id is null, so return");
      return true;
    }
    this.mReqBundle.clear();
    if ("queryLocal".equals(paramString3))
    {
      queryLocal(paramString2, paramString1);
      return true;
    }
    if ("setSize".equals(paramString3))
    {
      setSize(paramString2, paramString1);
      return true;
    }
    if ((!"queryInfo".equals(paramString3)) || (i == 0)) {}
    try
    {
      paramJsBridgeListener = new JSONObject();
      paramString2 = new JSONObject();
      paramString2.put("status", 3);
      paramString2.put("progress", 100);
      paramJsBridgeListener.put("result", 0);
      paramJsBridgeListener.put("message", "本地已存在");
      super.callJs(paramString1, new String[] { paramJsBridgeListener.toString() });
      label295:
      paramJsBridgeListener = "queryFontInfo";
      for (;;)
      {
        this.mReqBundle.putInt("id", i);
        this.mReqBundle.putInt("type", j);
        super.sendRemoteReq(DataFactory.a(paramJsBridgeListener, paramString1, this.mOnRemoteResp.key, this.mReqBundle), false, true);
        return true;
        if ("setup".equals(paramString3))
        {
          paramJsBridgeListener = "setupChatFont";
        }
        else
        {
          if ("startDownload".equals(paramString3))
          {
            startDownloadFont(i, j, paramString1);
            return true;
          }
          if ("stopDownload".equals(paramString3))
          {
            paramJsBridgeListener = "font_StopDownLoad";
          }
          else
          {
            if ("showBlackMsgBox".equals(paramString3))
            {
              paramJsBridgeListener = new JSONObject();
              try
              {
                paramString2 = paramString2.getString("msg");
                paramString3 = this.mRuntime.a(this.mRuntime.a());
                if ((paramString3 != null) && ((paramString3 instanceof WebUiUtils.WebTitleBarInterface))) {
                  QQToast.a(this.mRuntime.a(), paramString2, 0).b(((WebUiUtils.WebTitleBarInterface)paramString3).b());
                }
              }
              catch (JSONException paramString2)
              {
                for (;;)
                {
                  if (QLog.isColorLevel()) {
                    QLog.e("ChatFontJsPlugin", 2, "showBlackMsgBox failed: " + paramString2.getMessage());
                  }
                }
              }
              super.callJs(paramString1, new String[] { paramJsBridgeListener.toString() });
              return true;
            }
            if ("isUseFont".equals(paramString3))
            {
              isUseFont(paramString1);
              return true;
            }
            if ("setFontSwitch".equals(paramString3))
            {
              setFontSwitch(paramString2, paramString1);
              return true;
            }
            int k;
            if ("setMagicFont".equals(paramString3))
            {
              paramJsBridgeListener = "setupMagicFont";
              k = paramString2.optInt("setup");
              this.mReqBundle.putInt("magic_setup", k);
            }
            else if ("isSupportFounderColorFont".equals(paramString3))
            {
              paramJsBridgeListener = "isSupportFounderColorFont";
            }
            else
            {
              if ("initEngine".equals(paramString3))
              {
                tryInitHYEngine(paramString1);
                return true;
              }
              if ("diyPreview".equals(paramString3))
              {
                diyPreview(paramString1, i, 1, paramString2.optString("char"), paramString2.optString("config"), paramString2.optInt("fontSize"));
                return true;
              }
              if ("checkText".equals(paramString3))
              {
                checkDiyFontText(i, j, paramString2.optString("text"), paramString1);
                return true;
              }
              if ("getFontInfo".equals(paramString3))
              {
                getDiyFontInfo(i, j, paramString1);
                return true;
              }
              if ("setMagicFontType".equals(paramString3))
              {
                paramJsBridgeListener = "setupFontEffect";
                k = paramString2.optInt("id");
                if (QLog.isColorLevel()) {
                  QLog.i("ChatFontJsPlugin", 2, "fontEffectId: " + k);
                }
                this.mReqBundle.putInt("fontEffectId", k);
              }
              else
              {
                if (!"paymentNotice".equals(paramString3)) {
                  break;
                }
                paramJsBridgeListener = "ipc_hiboom_payment_notice";
              }
            }
          }
        }
      }
      if (QLog.isColorLevel()) {
        QLog.w("ChatFontJsPlugin", 2, "NOT support method " + paramString3 + " yet!!");
      }
      return false;
    }
    catch (JSONException paramJsBridgeListener)
    {
      break label295;
    }
  }
  
  void initHYEngine(String paramString)
  {
    int j = -1;
    int k = VasUtils.a(VasUtils.a(), "libvipfont765.so");
    if (QLog.isColorLevel()) {
      QLog.d("ChatFontJsPlugin", 2, "initHYEngine result = " + k);
    }
    int i = j;
    switch (k)
    {
    default: 
      i = j;
    }
    for (;;)
    {
      if ((!TextUtils.isEmpty(paramString)) && (!"0".equals(paramString))) {
        super.callJs(paramString, new String[] { "{\"ret\":" + i + "}" });
      }
      return;
      i = 0;
      continue;
      ETEngine.isSOLoaded.set(true);
      try
      {
        bool = ETEngine.getInstance().initEngine(20, 8388608);
        i = j;
        if (!bool) {
          continue;
        }
        ETEngine.getInstance().isEngineReady.set(true);
        i = 0;
      }
      catch (Exception localException)
      {
        for (;;)
        {
          QLog.e("ChatFontJsPlugin", 1, "initHYEngine fail");
          boolean bool = false;
        }
      }
    }
  }
  
  public void isUseFont(String paramString)
  {
    boolean bool1 = this.mRuntime.a().getSharedPreferences("font_open_switch", 4).getBoolean("isUserOpenFontSwitch_" + this.mRuntime.a().getAccount(), false);
    boolean bool2 = DeviceProfileManager.a().a(DeviceProfileManager.DpcNames.chat_font.name());
    if ((bool1) || (bool2)) {}
    JSONObject localJSONObject;
    for (bool1 = true;; bool1 = false)
    {
      this.isUseFont = bool1;
      localJSONObject = new JSONObject();
      if (this.isUseFont) {
        break;
      }
      QQCustomDialog localQQCustomDialog = DialogUtil.a(this.mRuntime.a(), 230).setTitle(this.mRuntime.a().getString(2131433279)).setMessage(this.mRuntime.a().getString(2131433631)).setPositiveButton(this.mRuntime.a().getString(2131433632), new ChatFontJsPlugin.3(this, localJSONObject, paramString)).setNegativeButton(this.mRuntime.a().getString(2131433633), new ChatFontJsPlugin.2(this, localJSONObject, paramString));
      localQQCustomDialog.show();
      localQQCustomDialog.setOnCancelListener(new ChatFontJsPlugin.4(this, localJSONObject, paramString));
      return;
    }
    try
    {
      localJSONObject.put("isUse", 1);
      callJs(paramString, new String[] { localJSONObject.toString() });
      return;
    }
    catch (JSONException localJSONException)
    {
      localJSONException.printStackTrace();
      callJs(paramString, new String[] { localJSONException.getMessage() });
    }
  }
  
  protected void onCreate()
  {
    super.onCreate();
    AppInterface localAppInterface = this.mRuntime.a();
    if ((localAppInterface instanceof BrowserAppInterface)) {
      this.browserApp = ((BrowserAppInterface)localAppInterface);
    }
    for (;;)
    {
      this.mReqBundle = new Bundle();
      this.mFontSize = new HashMap(4);
      this.mFontSize.put("small", Integer.valueOf(0));
      this.mFontSize.put("middle", Integer.valueOf(1));
      this.mFontSize.put("big", Integer.valueOf(2));
      this.mFontSize.put("bigger", Integer.valueOf(3));
      return;
      if (QLog.isColorLevel()) {
        QLog.e("ChatFontJsPlugin", 2, "ERROR!!! ChatFont market is not running in web process!");
      }
    }
  }
  
  public void onPushMsg(Bundle paramBundle)
  {
    if (QLog.isColorLevel()) {
      QLog.i("ChatFontJsPlugin", 2, "onPushMsg=" + paramBundle);
    }
    int i = paramBundle.getInt("srcType");
    int j;
    JSONObject localJSONObject;
    if (i == 2)
    {
      i = paramBundle.getInt("id");
      j = paramBundle.getInt("result");
      paramBundle = paramBundle.getString("callbackId");
      if (QLog.isColorLevel()) {
        QLog.d("ChatFontJsPlugin", 2, "onPushMsg DOWNLOAD_FONT_PKG id = " + i + " result = " + j + " callbackId = " + paramBundle);
      }
      localJSONObject = new JSONObject();
    }
    try
    {
      localJSONObject.put("id", i);
      localJSONObject.put("result", j);
      label150:
      super.callJs(paramBundle, new String[] { localJSONObject.toString() });
      do
      {
        do
        {
          return;
        } while (i != 9);
        i = paramBundle.getInt("result");
        paramBundle = paramBundle.getString("callbackId");
        initHYEngine(paramBundle);
      } while (!QLog.isColorLevel());
      QLog.d("ChatFontJsPlugin", 2, "onPushMsg DOWN_HY_SO result = " + i + " callbackId = " + paramBundle);
      return;
    }
    catch (JSONException localJSONException)
    {
      break label150;
    }
  }
  
  protected void onResponse(Bundle paramBundle)
  {
    if (paramBundle == null) {}
    label4:
    String str1;
    JSONObject localJSONObject;
    label214:
    do
    {
      String str2;
      Bundle localBundle;
      do
      {
        do
        {
          do
          {
            do
            {
              do
              {
                do
                {
                  do
                  {
                    break label4;
                    break label4;
                    break label4;
                    break label4;
                    break label4;
                    break label4;
                    for (;;)
                    {
                      return;
                      if (paramBundle.getInt("respkey", 0) == this.mOnRemoteResp.key)
                      {
                        str1 = paramBundle.getString("cmd");
                        try
                        {
                          str2 = paramBundle.getString("callbackid");
                          localBundle = paramBundle.getBundle("response");
                          localJSONObject = new JSONObject();
                          if (!"setupChatFont".equals(str1)) {
                            break label214;
                          }
                          localJSONObject.put("result", localBundle.getInt("result"));
                          localJSONObject.put("message", localBundle.getString("message"));
                          super.callJs(str2, new String[] { localJSONObject.toString() });
                          if (QLog.isColorLevel())
                          {
                            QLog.d("ChatFontJsPlugin", 2, "onResponse cmd = " + str1 + " Result = " + localJSONObject.toString());
                            return;
                          }
                        }
                        catch (Exception paramBundle) {}
                      }
                    }
                  } while (!QLog.isColorLevel());
                  QLog.e("ChatFontJsPlugin", 2, "Failed to handle cmd " + str1 + ", exception: " + paramBundle.getMessage());
                  return;
                  if (!"queryFontInfo".equals(str1)) {
                    break;
                  }
                  paramBundle = localBundle.getString("result");
                  super.callJs(str2, new String[] { paramBundle });
                } while (!QLog.isColorLevel());
                QLog.d("ChatFontJsPlugin", 2, "onResponse cmd = " + str1 + " Result = " + paramBundle);
                return;
                if (!"font_StopDownLoad".equals(str1)) {
                  break;
                }
                localJSONObject.put("result", 0);
                super.callJs(str2, new String[] { localJSONObject.toString() });
              } while (!QLog.isColorLevel());
              QLog.d("ChatFontJsPlugin", 2, "onResponse cmd = " + str1 + " Result = " + localJSONObject.toString());
              return;
              if (!"setFontSwtich".equals(str1)) {
                break;
              }
              localJSONObject.put("result", 0);
              super.callJs(str2, new String[] { localJSONObject.toString() });
            } while (!QLog.isColorLevel());
            QLog.d("ChatFontJsPlugin", 2, "onResponse cmd = " + str1 + " Result = " + localJSONObject.toString());
            return;
            if (!"setupMagicFont".equals(str1)) {
              break;
            }
            localJSONObject.put("result", 0);
            super.callJs(str2, new String[] { localJSONObject.toString() });
          } while (!QLog.isColorLevel());
          QLog.d("ChatFontJsPlugin", 2, "onResponse cmd = " + str1 + " Result = " + localJSONObject.toString());
          return;
          if (!"setupFontEffect".equals(str1)) {
            break;
          }
          localJSONObject.put("ret", paramBundle.getInt("ret"));
          localJSONObject.put("msg", paramBundle.getString("msg"));
          super.callJs(str2, new String[] { localJSONObject.toString() });
        } while (!QLog.isColorLevel());
        QLog.d("ChatFontJsPlugin", 2, "onResponse cmd = " + str1 + " Result = " + localJSONObject.toString());
        return;
      } while (!"isSupportFounderColorFont".equals(str1));
      int i = localBundle.getInt("result", 0);
      paramBundle = new JSONObject();
      paramBundle.put("isSupport", i);
      localJSONObject.put("result", 0);
      localJSONObject.put("data", paramBundle);
      super.callJs(str2, new String[] { localJSONObject.toString() });
    } while (!QLog.isColorLevel());
    QLog.d("ChatFontJsPlugin", 2, "onResponse cmd = " + str1 + " result = " + localJSONObject.toString());
  }
  
  public void queryLocal(JSONObject paramJSONObject, String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.i("ChatFontJsPlugin", 2, "queryLocal:" + paramJSONObject);
    }
    JSONObject localJSONObject;
    Object localObject;
    int i;
    try
    {
      localJSONObject = new JSONObject();
      paramJSONObject = this.browserApp.getEntityManagerFactory(null).createEntityManager();
      localObject = (ExtensionInfo)paramJSONObject.a(ExtensionInfo.class, this.browserApp.getAccount());
      paramJSONObject.a();
      localJSONObject.put("result", 0);
      if (localObject == null) {
        localJSONObject.put("currentId", 0L);
      }
      for (;;)
      {
        i = MobileQQ.getContext().getSharedPreferences("setting_text_size", 4).getInt("chat_text_size_type", 0);
        paramJSONObject = "small";
        Iterator localIterator = this.mFontSize.keySet().iterator();
        if (!localIterator.hasNext()) {
          break;
        }
        localObject = (String)localIterator.next();
        if (((Integer)this.mFontSize.get(localObject)).intValue() != i) {
          break label460;
        }
        paramJSONObject = (JSONObject)localObject;
        break label460;
        localJSONObject.put("currentId", ((ExtensionInfo)localObject).uVipFont);
      }
      localJSONObject.put("currentSize", paramJSONObject);
    }
    catch (JSONException paramJSONObject)
    {
      if (QLog.isColorLevel()) {
        QLog.e("ChatFontJsPlugin", 2, "getFontId failed: " + paramJSONObject.getMessage());
      }
      super.callJs(paramString, new String[] { paramJSONObject.getMessage() });
      return;
    }
    boolean bool1 = this.mRuntime.a().getSharedPreferences("font_open_switch", 4).getBoolean("isUserOpenFontSwitch_" + this.mRuntime.a().getAccount(), false);
    boolean bool2 = DeviceProfileManager.a().a(DeviceProfileManager.DpcNames.chat_font.name());
    if (!bool1) {
      if (!bool2) {
        break label468;
      }
    }
    for (;;)
    {
      if (i != 0) {
        localJSONObject.put("isOpen", 1);
      }
      for (;;)
      {
        paramJSONObject = new File(FontManager.a);
        localObject = new JSONArray();
        searchFontInDir(paramJSONObject, (JSONArray)localObject);
        searchFontInDir(new File(FontManager.b), (JSONArray)localObject);
        localJSONObject.put("downloadedList", localObject);
        if (QLog.isColorLevel()) {
          QLog.d("ChatFontJsPlugin", 2, localJSONObject.toString());
        }
        super.callJs(paramString, new String[] { localJSONObject.toString() });
        return;
        localJSONObject.put("isOpen", 0);
      }
      label460:
      break;
      i = 1;
      continue;
      label468:
      i = 0;
    }
  }
  
  public void setSize(JSONObject paramJSONObject, String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ChatFontJsPlugin", 2, "setSize:" + paramJSONObject);
    }
    try
    {
      JSONObject localJSONObject = new JSONObject();
      paramJSONObject = paramJSONObject.getString("size");
      ReportController.a(null, "CliOper", "", "", "Font_Mall", "change_" + paramJSONObject, 0, 0, "", "", "", "");
      int i;
      if (this.mFontSize.containsKey(paramJSONObject))
      {
        i = ((Integer)this.mFontSize.get(paramJSONObject)).intValue();
        localJSONObject.put("result", 0);
      }
      for (;;)
      {
        paramJSONObject = MobileQQ.getContext().getSharedPreferences("setting_text_size", 4).edit();
        paramJSONObject.putInt("chat_text_size_type", i);
        paramJSONObject.commit();
        localJSONObject.put("message", "success");
        super.callJs(paramString, new String[] { localJSONObject.toString() });
        return;
        localJSONObject.put("result", -1);
        localJSONObject.put("message", "size illege");
        super.callJs(paramString, new String[] { localJSONObject.toString() });
        i = 0;
      }
      return;
    }
    catch (Exception paramJSONObject) {}
  }
  
  void startDownloadFont(int paramInt1, int paramInt2, String paramString)
  {
    JSONObject localJSONObject;
    if (FontManager.a(paramInt1, paramInt2)) {
      localJSONObject = new JSONObject();
    }
    try
    {
      localJSONObject.put("id", paramInt1);
      localJSONObject.put("result", 3);
      label37:
      super.callJs(paramString, new String[] { localJSONObject.toString() });
      if (QLog.isColorLevel()) {
        QLog.d("ChatFontJsPlugin", 2, "startDownloadFont result = " + localJSONObject.toString());
      }
      return;
      this.mReqBundle.putInt("id", paramInt1);
      this.mReqBundle.putInt("type", paramInt2);
      super.sendRemoteReq(DataFactory.a("font_startDownLoad", paramString, this.mOnRemoteResp.key, this.mReqBundle), false, true);
      return;
    }
    catch (JSONException localJSONException)
    {
      break label37;
    }
  }
  
  void tryInitHYEngine(String paramString)
  {
    int j = -1;
    if (ETEngine.getInstance().isEngineReady.get())
    {
      super.callJs(paramString, new String[] { "{\"ret\":0}" });
      if (QLog.isColorLevel()) {
        QLog.d("ChatFontJsPlugin", 2, "tryInitHYEngine engine is ready");
      }
    }
    do
    {
      return;
      if (!ETEngine.getInstance().isEngineInited.get()) {
        break;
      }
    } while (!QLog.isColorLevel());
    QLog.d("ChatFontJsPlugin", 2, "tryInitHYEngine has inited");
    return;
    ETEngine.getInstance().isEngineInited.set(true);
    int k = VasUtils.a(VasUtils.a(), "libvipfont765.so");
    if (QLog.isColorLevel()) {
      QLog.d("ChatFontJsPlugin", 2, "tryInitHYEngine loadSoResult = " + k);
    }
    int i = j;
    switch (k)
    {
    default: 
      i = 0;
    }
    for (;;)
    {
      String str = "{\"ret\":" + i + "}";
      if ((!TextUtils.isEmpty(paramString)) && (!"0".equals(paramString))) {
        super.callJs(paramString, new String[] { str });
      }
      if (!QLog.isColorLevel()) {
        break;
      }
      QLog.d("ChatFontJsPlugin", 2, "initEngine result = " + str);
      return;
      super.sendRemoteReq(DataFactory.a("ipc_font_download_hy_so", paramString, this.mOnRemoteResp.key, this.mReqBundle), false, true);
      return;
      ETEngine.isSOLoaded.set(true);
      try
      {
        bool = ETEngine.getInstance().initEngine(20, 8388608);
        i = j;
        if (!bool) {
          continue;
        }
        ETEngine.getInstance().isEngineReady.set(true);
        i = 0;
      }
      catch (Exception localException)
      {
        for (;;)
        {
          QLog.e("ChatFontJsPlugin", 1, "tryInitHYEngine fail");
          boolean bool = false;
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\tmp\a2.jar
 * Qualified Name:     com.tencent.mobileqq.vaswebviewplugin.ChatFontJsPlugin
 * JD-Core Version:    0.7.0.1
 */