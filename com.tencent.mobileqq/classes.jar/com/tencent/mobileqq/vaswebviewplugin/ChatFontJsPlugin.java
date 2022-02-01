package com.tencent.mobileqq.vaswebviewplugin;

import android.app.Activity;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Bitmap.CompressFormat;
import android.graphics.Bitmap.Config;
import android.graphics.Color;
import android.graphics.Paint.FontMetrics;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.TypedValue;
import com.etrump.mixlayout.ETEngine;
import com.etrump.mixlayout.ETFont;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.app.BrowserAppInterface;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.data.ExtensionInfo;
import com.tencent.mobileqq.dpc.api.IDPCApi;
import com.tencent.mobileqq.dpc.enumname.DPCNames;
import com.tencent.mobileqq.emosm.DataFactory;
import com.tencent.mobileqq.emosm.OnRemoteRespObserver;
import com.tencent.mobileqq.hiboom.HiBoomFont;
import com.tencent.mobileqq.persistence.EntityManager;
import com.tencent.mobileqq.persistence.EntityManagerFactory;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.utils.Base64Util;
import com.tencent.mobileqq.utils.DialogUtil;
import com.tencent.mobileqq.utils.QQCustomDialog;
import com.tencent.mobileqq.vas.font.api.FontManagerConstants;
import com.tencent.mobileqq.vas.util.VasSoUtils;
import com.tencent.mobileqq.webview.swift.JsBridgeListener;
import com.tencent.mobileqq.webview.swift.WebViewPlugin;
import com.tencent.mobileqq.webview.swift.WebViewPlugin.PluginRuntime;
import com.tencent.mobileqq.webviewplugin.WebUiUtils.WebTitleBarInterface;
import com.tencent.mobileqq.webviewplugin.WebUiUtils.WebViewProviderInterface;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FilenameFilter;
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
  public static final int FONT_TYPE_FONT = 0;
  public static final int FONT_TYPE_HIBOOM = 1;
  private static final String TAG = "ChatFontJsPlugin";
  private BrowserAppInterface browserApp;
  private boolean isUseFont;
  private HashMap<String, Integer> mFontSize;
  private FilenameFilter mHiBoomDirFilter = new ChatFontJsPlugin.5(this);
  private Bundle mReqBundle;
  
  public ChatFontJsPlugin()
  {
    this.mPluginNameSpace = "font";
  }
  
  private ChatFontJsPlugin.FontPadding calculateFontPadding(ETFont paramETFont)
  {
    Object localObject = new Paint.FontMetrics();
    ETEngine.getInstance().native_getFontMetrics((Paint.FontMetrics)localObject, paramETFont);
    float f = Math.abs(((Paint.FontMetrics)localObject).ascent) + ((Paint.FontMetrics)localObject).descent;
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
    if (!FontManagerConstants.checkFontExist(paramInt1, paramInt2))
    {
      if (QLog.isColorLevel())
      {
        paramString1 = new StringBuilder();
        paramString1.append("checkDiyFontText fail font not exists id = ");
        paramString1.append(paramInt1);
        QLog.d("ChatFontJsPlugin", 2, paramString1.toString());
      }
      super.callJs(paramString2, new String[] { "{\"ret\":-2}" });
      return;
    }
    ETFont localETFont = new ETFont(paramInt1, FontManagerConstants.getTTFPath(paramInt1, paramInt2), 16.0F);
    if (!ETEngine.getInstance().native_diyFontIsDIYFont(localETFont))
    {
      if (QLog.isColorLevel())
      {
        paramString1 = new StringBuilder();
        paramString1.append("checkDiyFontText fail font is not diy font id = ");
        paramString1.append(paramInt1);
        QLog.d("ChatFontJsPlugin", 2, paramString1.toString());
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
        localObject2 = new StringBuilder();
        ((StringBuilder)localObject2).append((String)localObject1);
        ((StringBuilder)localObject2).append(paramString1.charAt(paramInt1));
        localObject2 = ((StringBuilder)localObject2).toString();
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
    paramString1 = new StringBuilder();
    paramString1.append("{\"ret\":-1,\"data\":{\"invalidText\":\"");
    paramString1.append((String)localObject1);
    paramString1.append("\"}}");
    paramString1 = paramString1.toString();
    if (QLog.isColorLevel())
    {
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append("checkDiyFontText result = ");
      ((StringBuilder)localObject1).append(paramString1);
      QLog.d("ChatFontJsPlugin", 2, ((StringBuilder)localObject1).toString());
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
      return;
    }
    if (!FontManagerConstants.checkFontExist(paramInt1, paramInt2))
    {
      if (QLog.isColorLevel())
      {
        localObject1 = new StringBuilder();
        ((StringBuilder)localObject1).append("getDiyFontInfo fail font not exists id = ");
        ((StringBuilder)localObject1).append(paramInt1);
        QLog.d("ChatFontJsPlugin", 2, ((StringBuilder)localObject1).toString());
      }
      super.callJs(paramString, new String[] { "{\"ret\":-1}" });
      return;
    }
    Object localObject1 = new ETFont(paramInt1, FontManagerConstants.getTTFPath(paramInt1, paramInt2), 16.0F);
    if (!ETEngine.getInstance().native_diyFontIsDIYFont((ETFont)localObject1))
    {
      if (QLog.isColorLevel())
      {
        localObject1 = new StringBuilder();
        ((StringBuilder)localObject1).append("getDiyFontInfo fail font is not diy font id = ");
        ((StringBuilder)localObject1).append(paramInt1);
        QLog.d("ChatFontJsPlugin", 2, ((StringBuilder)localObject1).toString());
      }
      super.callJs(paramString, new String[] { "{\"ret\":-1}" });
      return;
    }
    paramInt2 = ETEngine.getInstance().native_diyFontGetUPEM((ETFont)localObject1);
    if (paramInt2 <= 0)
    {
      if (QLog.isColorLevel())
      {
        localObject1 = new StringBuilder();
        ((StringBuilder)localObject1).append("getDiyFontInfo get upem fail fontid = ");
        ((StringBuilder)localObject1).append(paramInt1);
        ((StringBuilder)localObject1).append(" upem = ");
        ((StringBuilder)localObject1).append(paramInt2);
        QLog.d("ChatFontJsPlugin", 2, ((StringBuilder)localObject1).toString());
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
        localObject2 = new StringBuilder();
        ((StringBuilder)localObject2).append("getDiyFontInfo result = ");
        ((StringBuilder)localObject2).append(((JSONObject)localObject1).toString());
        QLog.d("ChatFontJsPlugin", 2, ((StringBuilder)localObject2).toString());
        return;
      }
    }
    catch (Exception localException)
    {
      QLog.e("ChatFontJsPlugin", 2, "getDiyFontInfo error: ", localException);
      super.callJs(paramString, new String[] { "{\"ret\":-1}" });
    }
  }
  
  private void queryLocalHiBoom(String paramString)
  {
    Object localObject = new File(HiBoomFont.b);
    JSONObject localJSONObject = new JSONObject();
    JSONArray localJSONArray = new JSONArray();
    if ((((File)localObject).exists()) && (((File)localObject).isDirectory()))
    {
      File[] arrayOfFile = ((File)localObject).listFiles(this.mHiBoomDirFilter);
      if (arrayOfFile != null)
      {
        int k = arrayOfFile.length;
        int i = 0;
        while (i < k)
        {
          String[] arrayOfString = arrayOfFile[i].list(HiBoomFont.a);
          if (arrayOfString != null)
          {
            int m = arrayOfString.length;
            int j = 0;
            while (j < m)
            {
              String str = arrayOfString[j];
              boolean bool = str.endsWith(".hy");
              localObject = ".fz4";
              if (bool)
              {
                localObject = ".hy";
              }
              else if (str.endsWith(".fz"))
              {
                localObject = ".fz";
              }
              else if (!str.endsWith(".fz4"))
              {
                if (!str.endsWith(".hy3")) {
                  break label226;
                }
                localObject = ".hy3";
              }
              localObject = str.substring(0, str.length() - ((String)localObject).length());
              if (TextUtils.isDigitsOnly((CharSequence)localObject)) {
                localJSONArray.put(Integer.parseInt((String)localObject));
              }
              label226:
              j += 1;
            }
          }
          i += 1;
        }
      }
    }
    try
    {
      localJSONObject.put("downloadedList", localJSONArray);
      label251:
      if (QLog.isColorLevel())
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("queryLocalHiBoom result = ");
        ((StringBuilder)localObject).append(localJSONObject.toString());
        QLog.d("ChatFontJsPlugin", 2, ((StringBuilder)localObject).toString());
      }
      super.callJs(paramString, new String[] { localJSONObject.toString() });
      return;
    }
    catch (Exception localException)
    {
      break label251;
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
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("setFontSwitch:");
      localStringBuilder.append(paramJSONObject);
      QLog.d("ChatFontJsPlugin", 2, localStringBuilder.toString());
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
      return;
    }
    Object localObject1;
    int j;
    Object localObject2;
    int k;
    if ((!TextUtils.isEmpty(paramString2)) && (paramInt3 > 0))
    {
      if (!FontManagerConstants.checkFontExist(paramInt1, paramInt2))
      {
        if (QLog.isColorLevel()) {
          QLog.d("ChatFontJsPlugin", 2, "diyPreview font not exists");
        }
        super.callJs(paramString1, new String[] { "{\"ret\":-1}" });
        startDownloadFont(paramInt1, paramInt2, "0", 0);
        return;
      }
      if (!ETEngine.getInstance().native_isFontLoaded(paramInt1)) {
        ETEngine.getInstance().native_loadFont(FontManagerConstants.getTTFPath(paramInt1, paramInt2), paramInt1, false);
      }
      localObject1 = FontManagerConstants.getTTFPath(paramInt1, paramInt2);
      j = paramInt3 * 2;
      localObject1 = new ETFont(paramInt1, (String)localObject1, j);
      if (!ETEngine.getInstance().native_diyFontIsDIYFont((ETFont)localObject1))
      {
        if (QLog.isColorLevel())
        {
          paramString2 = new StringBuilder();
          paramString2.append("checkDiyFontText fail font is not diy font id = ");
          paramString2.append(paramInt1);
          QLog.d("ChatFontJsPlugin", 2, paramString2.toString());
        }
        super.callJs(paramString1, new String[] { "{\"ret\":-1}" });
        return;
      }
      localObject2 = calculateFontPadding((ETFont)localObject1);
      ((ETFont)localObject1).setSize(((ChatFontJsPlugin.FontPadding)localObject2).fontSize);
      ((ETFont)localObject1).parseDIYJsonString(paramString3);
      k = paramString2.length();
    }
    try
    {
      paramString3 = Bitmap.createBitmap(j * k, j, Bitmap.Config.ARGB_8888);
      int i;
      for (paramInt2 = 0; paramInt2 < k; paramInt2 = i)
      {
        paramInt1 = j * paramInt2;
        if (((ChatFontJsPlugin.FontPadding)localObject2).paddingType == 1)
        {
          paramInt1 = (int)(paramInt1 + ((ChatFontJsPlugin.FontPadding)localObject2).padding);
          break label701;
        }
        if (((ChatFontJsPlugin.FontPadding)localObject2).paddingType != 2) {
          break label701;
        }
        paramInt3 = (int)(0 + ((ChatFontJsPlugin.FontPadding)localObject2).padding);
        localObject3 = ETEngine.getInstance();
        i = paramInt2 + 1;
        ((ETEngine)localObject3).native_drawText(paramString2.substring(paramInt2, i), paramString3, paramInt1, paramInt3, (ETFont)localObject1);
      }
      paramString2 = new ByteArrayOutputStream();
      paramString3.compress(Bitmap.CompressFormat.PNG, 100, paramString2);
      localObject2 = Base64Util.encodeToString(paramString2.toByteArray(), 2);
      paramString2 = new JSONObject();
      Object localObject3 = new JSONObject();
      ((JSONObject)localObject3).put("img", localObject2);
      ((JSONObject)localObject3).put("width", paramString3.getWidth());
      ((JSONObject)localObject3).put("height", paramString3.getHeight());
      paramString2.put("data", localObject3);
      paramString2.put("ret", 0);
      super.callJs(paramString1, new String[] { paramString2.toString() });
      if (QLog.isColorLevel())
      {
        localObject2 = new StringBuilder();
        ((StringBuilder)localObject2).append("diyPreview result = ");
        ((StringBuilder)localObject2).append(paramString2.toString());
        QLog.d("ChatFontJsPlugin", 2, ((StringBuilder)localObject2).toString());
      }
      paramString3.recycle();
    }
    catch (OutOfMemoryError paramString2)
    {
      break label579;
    }
    catch (Exception paramString2)
    {
      label553:
      break label553;
    }
    QLog.e("ChatFontJsPlugin", 1, "diyPreview createBitmap OOM");
    super.callJs(paramString1, new String[] { "{\"ret\":-1}" });
    break label602;
    label579:
    QLog.e("ChatFontJsPlugin", 1, "diyPreview createBitmap OOM");
    super.callJs(paramString1, new String[] { "{\"ret\":-1}" });
    label602:
    ETEngine.getInstance().native_diyFontDeleteNativeConfig(((ETFont)localObject1).mDiyHandle);
    return;
    super.callJs(paramString1, new String[] { "{\"ret\":-1}" });
    if (QLog.isColorLevel())
    {
      paramString1 = new StringBuilder();
      paramString1.append("diyPreview text = ");
      paramString1.append(paramString2);
      paramString1.append(" fontsize = ");
      paramString1.append(paramInt3);
      QLog.d("ChatFontJsPlugin", 2, paramString1.toString());
    }
  }
  
  void getFontPreview(String paramString1, int paramInt1, int paramInt2, String paramString2, String paramString3, int paramInt3, String paramString4)
  {
    if (!ETEngine.getInstance().isEngineReady.get())
    {
      if (QLog.isColorLevel()) {
        QLog.d("ChatFontJsPlugin", 2, "diyPreview engine not ready");
      }
      tryInitHYEngine("0");
      super.callJs(paramString1, new String[] { "{\"ret\":-1,\"msg\":\"font engine not ready.\"}" });
      return;
    }
    int j;
    if ((!TextUtils.isEmpty(paramString2)) && (paramInt3 > 0))
    {
      j = (int)(TypedValue.applyDimension(2, paramInt3, this.browserApp.getApp().getResources().getDisplayMetrics()) / 2.0F);
      if (!FontManagerConstants.checkFontExist(paramInt1, paramInt2))
      {
        if (QLog.isColorLevel()) {
          QLog.d("ChatFontJsPlugin", 2, "diyPreview font not exists");
        }
        super.callJs(paramString1, new String[] { "{\"ret\":-3,\"msg\":\"this font need download.\"}" });
        startDownloadFont(paramInt1, paramInt2, "0", 0);
        return;
      }
      paramInt3 = -16777216;
      if (TextUtils.isEmpty(paramString4)) {}
    }
    try
    {
      paramInt3 = Color.parseColor(paramString4);
    }
    catch (Exception paramString2)
    {
      label163:
      Object localObject1;
      int k;
      break label163;
    }
    paramString2 = new StringBuilder();
    paramString2.append("{\"ret\":-4,\"msg\":\"color is illegal:");
    paramString2.append(paramString4);
    paramString2.append("\"}");
    super.callJs(paramString1, new String[] { paramString2.toString() });
    return;
    if (!ETEngine.getInstance().native_isFontLoaded(paramInt1)) {
      ETEngine.getInstance().native_loadFont(FontManagerConstants.getTTFPath(paramInt1, paramInt2), paramInt1, false);
    }
    paramString4 = new ETFont(paramInt1, FontManagerConstants.getTTFPath(paramInt1, paramInt2), j);
    localObject1 = calculateFontPadding(paramString4);
    paramString4.setSize(((ChatFontJsPlugin.FontPadding)localObject1).fontSize);
    paramString4.setColor(paramInt3);
    paramString4.parseDIYJsonString(paramString3);
    k = paramString2.length();
    try
    {
      paramString3 = Bitmap.createBitmap(j * k, j, Bitmap.Config.ARGB_8888);
      int i;
      for (paramInt2 = 0; paramInt2 < k; paramInt2 = i)
      {
        paramInt1 = j * paramInt2;
        if (((ChatFontJsPlugin.FontPadding)localObject1).paddingType == 1)
        {
          paramInt1 = (int)(paramInt1 + ((ChatFontJsPlugin.FontPadding)localObject1).padding);
          break label794;
        }
        if (((ChatFontJsPlugin.FontPadding)localObject1).paddingType != 2) {
          break label794;
        }
        paramInt3 = (int)(0 + ((ChatFontJsPlugin.FontPadding)localObject1).padding);
        localObject2 = ETEngine.getInstance();
        i = paramInt2 + 1;
        ((ETEngine)localObject2).native_drawText(paramString2.substring(paramInt2, i), paramString3, paramInt1, paramInt3, paramString4);
      }
      paramString2 = new ByteArrayOutputStream();
      paramString3.compress(Bitmap.CompressFormat.PNG, 100, paramString2);
      localObject1 = Base64Util.encodeToString(paramString2.toByteArray(), 2);
      paramString2 = new JSONObject();
      Object localObject2 = new JSONObject();
      ((JSONObject)localObject2).put("img", localObject1);
      ((JSONObject)localObject2).put("width", paramString3.getWidth());
      ((JSONObject)localObject2).put("height", paramString3.getHeight());
      paramString2.put("data", localObject2);
      paramString2.put("ret", 0);
      super.callJs(paramString1, new String[] { paramString2.toString() });
      if (QLog.isColorLevel())
      {
        localObject1 = new StringBuilder();
        ((StringBuilder)localObject1).append("diyPreview result = ");
        ((StringBuilder)localObject1).append(paramString2.toString());
        QLog.d("ChatFontJsPlugin", 2, ((StringBuilder)localObject1).toString());
      }
      paramString3.recycle();
    }
    catch (OutOfMemoryError paramString2)
    {
      break label612;
    }
    catch (Exception paramString2)
    {
      label586:
      break label586;
    }
    QLog.e("ChatFontJsPlugin", 1, "diyPreview createBitmap OOM");
    super.callJs(paramString1, new String[] { "{\"ret\":-1}" });
    break label635;
    label612:
    QLog.e("ChatFontJsPlugin", 1, "diyPreview createBitmap OOM");
    super.callJs(paramString1, new String[] { "{\"ret\":-1}" });
    label635:
    ETEngine.getInstance().native_diyFontDeleteNativeConfig(paramString4.mDiyHandle);
    return;
    paramString3 = new StringBuilder();
    paramString3.append("{\"ret\":-2,\"msg\":\"illegal fontSize= ");
    paramString3.append(paramInt3);
    paramString3.append(" text=");
    paramString3.append(paramString2);
    paramString3.append("\"}");
    super.callJs(paramString1, new String[] { paramString3.toString() });
    if (QLog.isColorLevel())
    {
      paramString1 = new StringBuilder();
      paramString1.append("diyPreview text = ");
      paramString1.append(paramString2);
      paramString1.append(" fontsize = ");
      paramString1.append(paramInt3);
      QLog.d("ChatFontJsPlugin", 2, paramString1.toString());
    }
  }
  
  protected long getPluginBusiness()
  {
    return 2147487744L;
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
      QLog.d("ChatFontJsPlugin", 2, paramJsBridgeListener.toString());
    }
    int i;
    int j;
    int k;
    if ((paramString1 != null) && ("font".equals(paramString2)) && (paramString3 != null))
    {
      paramString2 = WebViewPlugin.getJsonFromJSBridge(paramString1);
      if (paramString2 == null) {
        return true;
      }
      if (QLog.isColorLevel())
      {
        paramJsBridgeListener = new StringBuilder();
        paramJsBridgeListener.append("handleJsRequest JSON = ");
        paramJsBridgeListener.append(paramString2.toString());
        QLog.d("ChatFontJsPlugin", 2, paramJsBridgeListener.toString());
      }
      i = paramString2.optInt("id");
      j = paramString2.optInt("type");
      k = paramString2.optInt("fontType");
      paramString1 = paramString2.optString("callback");
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
      boolean bool = "queryInfo".equals(paramString3);
      paramJsBridgeListener = "isSupportFounderColorFont";
      if ((bool) && (i != 0)) {}
    }
    try
    {
      paramJsBridgeListener = new JSONObject();
      paramString2 = new JSONObject();
      paramString2.put("status", 3);
      paramString2.put("progress", 100);
      paramJsBridgeListener.put("result", 0);
      paramJsBridgeListener.put("message", HardCodeUtil.a(2131701799));
      super.callJs(paramString1, new String[] { paramJsBridgeListener.toString() });
      label318:
      paramJsBridgeListener = "queryFontInfo";
      break label1053;
      if ("setup".equals(paramString3))
      {
        paramJsBridgeListener = "setupChatFont";
      }
      else
      {
        if ("startDownload".equals(paramString3))
        {
          startDownloadFont(i, j, paramString1, k);
          return true;
        }
        if ("stopDownload".equals(paramString3))
        {
          if (k != 0)
          {
            if (k != 1) {
              paramJsBridgeListener = null;
            } else {
              paramJsBridgeListener = "ipc_stop_download_hiboom";
            }
          }
          else {
            paramJsBridgeListener = "font_StopDownLoad";
          }
        }
        else
        {
          if ("showBlackMsgBox".equals(paramString3))
          {
            paramJsBridgeListener = new JSONObject();
            try
            {
              paramString2 = paramString2.getString("msg");
              paramString3 = this.mRuntime.a();
              if ((paramString3 != null) && (paramString3.getWebTitleBarInterface() != null)) {
                QQToast.a(this.mRuntime.a(), paramString2, 0).b(paramString3.getWebTitleBarInterface().a());
              }
            }
            catch (JSONException paramString2)
            {
              if (QLog.isColorLevel())
              {
                paramString3 = new StringBuilder();
                paramString3.append("showBlackMsgBox failed: ");
                paramString3.append(paramString2.getMessage());
                QLog.e("ChatFontJsPlugin", 2, paramString3.toString());
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
          int m;
          if ("setMagicFont".equals(paramString3))
          {
            m = paramString2.optInt("setup");
            this.mReqBundle.putInt("magic_setup", m);
            paramJsBridgeListener = "setupMagicFont";
          }
          else if (!"isSupportFounderColorFont".equals(paramString3))
          {
            if ("initEngine".equals(paramString3))
            {
              tryInitHYEngine(paramString1);
              return true;
            }
            if ("getFontPreview".equals(paramString3))
            {
              paramJsBridgeListener = paramString2.optString("char");
              getFontPreview(paramString1, i, paramString2.optInt("type"), paramJsBridgeListener, paramString2.optString("config"), paramString2.optInt("fontSize"), paramString2.optString("color"));
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
              m = paramString2.optInt("id");
              if (QLog.isColorLevel())
              {
                paramJsBridgeListener = new StringBuilder();
                paramJsBridgeListener.append("fontEffectId: ");
                paramJsBridgeListener.append(m);
                QLog.i("ChatFontJsPlugin", 2, paramJsBridgeListener.toString());
              }
              this.mReqBundle.putInt("fontEffectId", m);
              paramJsBridgeListener = "setupFontEffect";
            }
            else if ("setHaibao".equals(paramString3))
            {
              paramJsBridgeListener = "ipc_hiboom_change";
            }
            else
            {
              if ("queryLocalHaibao".equals(paramString3))
              {
                queryLocalHiBoom(paramString1);
                return true;
              }
              if ("isSupportHaibao".equals(paramString3))
              {
                paramJsBridgeListener = "ipc_hiboom_switch";
              }
              else if ("isHaibaoOpen".equals(paramString3))
              {
                paramJsBridgeListener = "ipc_hiboom_user_switch";
              }
              else if ("isSysFont".equals(paramString3))
              {
                paramJsBridgeListener = "ipc_is_sys_font";
              }
              else if ("setSysFont".equals(paramString3))
              {
                m = paramString2.optInt("sysfont", -1);
                this.mReqBundle.putInt("sysfont", m);
                paramJsBridgeListener = "ipc_set_sys_font";
              }
              else if ("hasSysColorFont".equals(paramString3))
              {
                paramJsBridgeListener = "ipc_has_sys_color_font";
              }
              else
              {
                if (!"paySuccess".equals(paramString3)) {
                  break label1113;
                }
                paramJsBridgeListener = "ipc_set_hiboom";
              }
            }
          }
        }
      }
      label1053:
      this.mReqBundle.putInt("id", i);
      this.mReqBundle.putInt("type", j);
      this.mReqBundle.putInt("fontOrhiboom", k);
      super.sendRemoteReq(DataFactory.a(paramJsBridgeListener, paramString1, this.mOnRemoteResp.key, this.mReqBundle), false, true);
      return true;
      label1113:
      if ("fontBubblePaySuccess".equals(paramString3))
      {
        this.mReqBundle.putInt("id", i);
        this.mReqBundle.putInt("sid", paramString2.optInt("sid"));
        super.sendRemoteReq(DataFactory.a("fontBubblePaySuccess", paramString1, this.mOnRemoteResp.key, this.mReqBundle), false, true);
        return true;
      }
      if (QLog.isColorLevel())
      {
        paramJsBridgeListener = new StringBuilder();
        paramJsBridgeListener.append("NOT support method ");
        paramJsBridgeListener.append(paramString3);
        paramJsBridgeListener.append(" yet!!");
        QLog.w("ChatFontJsPlugin", 2, paramJsBridgeListener.toString());
      }
      return false;
      return false;
    }
    catch (JSONException paramJsBridgeListener)
    {
      break label318;
    }
  }
  
  void initHYEngine(String paramString)
  {
    int j = VasSoUtils.a(VasSoUtils.a(), "libvipfont8417.so");
    StringBuilder localStringBuilder;
    if (QLog.isColorLevel())
    {
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("initHYEngine result = ");
      localStringBuilder.append(j);
      QLog.d("ChatFontJsPlugin", 2, localStringBuilder.toString());
    }
    int i = -1;
    if (j != 0)
    {
      if (j != 1) {}
    }
    else {
      for (;;)
      {
        i = 0;
        break;
        ETEngine.isSOLoaded.set(true);
        try
        {
          bool = ETEngine.getInstance().initEngine(20, 8388608);
        }
        catch (Exception localException)
        {
          boolean bool;
          label94:
          break label94;
        }
        QLog.e("ChatFontJsPlugin", 1, "initHYEngine fail");
        bool = false;
        if (!bool) {
          break;
        }
        ETEngine.getInstance().isEngineReady.set(true);
      }
    }
    if ((!TextUtils.isEmpty(paramString)) && (!"0".equals(paramString)))
    {
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("{\"ret\":");
      localStringBuilder.append(i);
      localStringBuilder.append("}");
      super.callJs(paramString, new String[] { localStringBuilder.toString() });
    }
  }
  
  public void isUseFont(String paramString)
  {
    Object localObject1 = this.mRuntime.a().getSharedPreferences("font_open_switch", 4);
    Object localObject2 = new StringBuilder();
    ((StringBuilder)localObject2).append("isUserOpenFontSwitch_");
    ((StringBuilder)localObject2).append(this.mRuntime.a().getAccount());
    boolean bool1 = ((SharedPreferences)localObject1).getBoolean(((StringBuilder)localObject2).toString(), false);
    boolean bool2 = ((IDPCApi)QRoute.api(IDPCApi.class)).isFeatureSupported(DPCNames.chat_font.name());
    if ((!bool1) && (!bool2)) {
      bool1 = false;
    } else {
      bool1 = true;
    }
    this.isUseFont = bool1;
    localObject1 = new JSONObject();
    if (!this.isUseFont)
    {
      localObject2 = DialogUtil.a(this.mRuntime.a(), 230).setTitle(this.mRuntime.a().getString(2131719638)).setMessage(this.mRuntime.a().getString(2131694953)).setPositiveButton(this.mRuntime.a().getString(2131694954), new ChatFontJsPlugin.3(this, (JSONObject)localObject1, paramString)).setNegativeButton(this.mRuntime.a().getString(2131694951), new ChatFontJsPlugin.2(this, (JSONObject)localObject1, paramString));
      ((QQCustomDialog)localObject2).show();
      ((QQCustomDialog)localObject2).setOnCancelListener(new ChatFontJsPlugin.4(this, (JSONObject)localObject1, paramString));
      return;
    }
    try
    {
      ((JSONObject)localObject1).put("isUse", 1);
      callJs(paramString, new String[] { ((JSONObject)localObject1).toString() });
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
    } else if (QLog.isColorLevel()) {
      QLog.e("ChatFontJsPlugin", 2, "ERROR!!! ChatFont market is not running in web process!");
    }
    this.mReqBundle = new Bundle();
    this.mFontSize = new HashMap(4);
    this.mFontSize.put("small", Integer.valueOf(0));
    this.mFontSize.put("middle", Integer.valueOf(1));
    this.mFontSize.put("big", Integer.valueOf(2));
    this.mFontSize.put("bigger", Integer.valueOf(3));
  }
  
  public void onPushMsg(Bundle paramBundle)
  {
    Object localObject;
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("onPushMsg=");
      ((StringBuilder)localObject).append(paramBundle);
      QLog.i("ChatFontJsPlugin", 2, ((StringBuilder)localObject).toString());
    }
    int i = paramBundle.getInt("srcType");
    int j;
    if (i == 2)
    {
      i = paramBundle.getInt("id");
      j = paramBundle.getInt("result");
      paramBundle = paramBundle.getString("callbackId");
      if (QLog.isColorLevel())
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("onPushMsg DOWNLOAD_FONT_PKG id = ");
        ((StringBuilder)localObject).append(i);
        ((StringBuilder)localObject).append(" result = ");
        ((StringBuilder)localObject).append(j);
        ((StringBuilder)localObject).append(" callbackId = ");
        ((StringBuilder)localObject).append(paramBundle);
        QLog.d("ChatFontJsPlugin", 2, ((StringBuilder)localObject).toString());
      }
      localObject = new JSONObject();
    }
    try
    {
      ((JSONObject)localObject).put("id", i);
      ((JSONObject)localObject).put("result", j);
      label182:
      super.callJs(paramBundle, new String[] { ((JSONObject)localObject).toString() });
      return;
      if (i == 9)
      {
        i = paramBundle.getInt("result");
        paramBundle = paramBundle.getString("callbackId");
        initHYEngine(paramBundle);
        if (QLog.isColorLevel())
        {
          localObject = new StringBuilder();
          ((StringBuilder)localObject).append("onPushMsg DOWN_HY_SO result = ");
          ((StringBuilder)localObject).append(i);
          ((StringBuilder)localObject).append(" callbackId = ");
          ((StringBuilder)localObject).append(paramBundle);
          QLog.d("ChatFontJsPlugin", 2, ((StringBuilder)localObject).toString());
        }
      }
      return;
    }
    catch (JSONException localJSONException)
    {
      break label182;
    }
  }
  
  protected void onResponse(Bundle paramBundle)
  {
    if (paramBundle == null) {
      return;
    }
    String str1;
    String str2;
    JSONObject localJSONObject;
    if (paramBundle.getInt("respkey", 0) == this.mOnRemoteResp.key)
    {
      str1 = paramBundle.getString("cmd");
      str2 = paramBundle.getString("callbackid");
      localJSONObject = new JSONObject();
    }
    for (;;)
    {
      try
      {
        localObject = paramBundle.getBundle("response");
        boolean bool = "setupChatFont".equals(str1);
        if (bool)
        {
          localJSONObject.put("result", ((Bundle)localObject).getInt("result"));
          localJSONObject.put("message", ((Bundle)localObject).getString("message"));
          super.callJs(str2, new String[] { localJSONObject.toString() });
          if (!QLog.isColorLevel()) {
            break label1388;
          }
          paramBundle = new StringBuilder();
          paramBundle.append("onResponse cmd = ");
          paramBundle.append(str1);
          paramBundle.append(" Result = ");
          paramBundle.append(localJSONObject.toString());
          QLog.d("ChatFontJsPlugin", 2, paramBundle.toString());
          return;
        }
        if ("queryFontInfo".equals(str1))
        {
          paramBundle = ((Bundle)localObject).getString("result");
          super.callJs(str2, new String[] { paramBundle });
          if (!QLog.isColorLevel()) {
            break label1389;
          }
          localObject = new StringBuilder();
          ((StringBuilder)localObject).append("onResponse cmd = ");
          ((StringBuilder)localObject).append(str1);
          ((StringBuilder)localObject).append(" Result = ");
          ((StringBuilder)localObject).append(paramBundle);
          QLog.d("ChatFontJsPlugin", 2, ((StringBuilder)localObject).toString());
          return;
        }
        if ("font_StopDownLoad".equals(str1))
        {
          localJSONObject.put("result", 0);
          super.callJs(str2, new String[] { localJSONObject.toString() });
          if (!QLog.isColorLevel()) {
            break label1390;
          }
          paramBundle = new StringBuilder();
          paramBundle.append("onResponse cmd = ");
          paramBundle.append(str1);
          paramBundle.append(" Result = ");
          paramBundle.append(localJSONObject.toString());
          QLog.d("ChatFontJsPlugin", 2, paramBundle.toString());
          return;
        }
        if ("setFontSwtich".equals(str1))
        {
          localJSONObject.put("result", 0);
          super.callJs(str2, new String[] { localJSONObject.toString() });
          if (!QLog.isColorLevel()) {
            break label1391;
          }
          paramBundle = new StringBuilder();
          paramBundle.append("onResponse cmd = ");
          paramBundle.append(str1);
          paramBundle.append(" Result = ");
          paramBundle.append(localJSONObject.toString());
          QLog.d("ChatFontJsPlugin", 2, paramBundle.toString());
          return;
        }
        if ("setupMagicFont".equals(str1))
        {
          localJSONObject.put("result", 0);
          super.callJs(str2, new String[] { localJSONObject.toString() });
          if (!QLog.isColorLevel()) {
            break label1392;
          }
          paramBundle = new StringBuilder();
          paramBundle.append("onResponse cmd = ");
          paramBundle.append(str1);
          paramBundle.append(" Result = ");
          paramBundle.append(localJSONObject.toString());
          QLog.d("ChatFontJsPlugin", 2, paramBundle.toString());
          return;
        }
        bool = "setupFontEffect".equals(str1);
        if (bool)
        {
          localJSONObject.put("ret", paramBundle.getInt("ret"));
          localJSONObject.put("msg", paramBundle.getString("msg"));
          super.callJs(str2, new String[] { localJSONObject.toString() });
          if (!QLog.isColorLevel()) {
            break label1393;
          }
          paramBundle = new StringBuilder();
          paramBundle.append("onResponse cmd = ");
          paramBundle.append(str1);
          paramBundle.append(" Result = ");
          paramBundle.append(localJSONObject.toString());
          QLog.d("ChatFontJsPlugin", 2, paramBundle.toString());
          return;
        }
        bool = "isSupportFounderColorFont".equals(str1);
        if (bool)
        {
          i = ((Bundle)localObject).getInt("result", 0);
          paramBundle = new JSONObject();
          paramBundle.put("isSupport", i);
          localJSONObject.put("result", 0);
          localJSONObject.put("data", paramBundle);
          super.callJs(str2, new String[] { localJSONObject.toString() });
          if (!QLog.isColorLevel()) {
            break label1394;
          }
          paramBundle = new StringBuilder();
          paramBundle.append("onResponse cmd = ");
          paramBundle.append(str1);
          paramBundle.append(" result = ");
          paramBundle.append(localJSONObject.toString());
          QLog.d("ChatFontJsPlugin", 2, paramBundle.toString());
          return;
        }
        if ("ipc_hiboom_switch".equals(str1))
        {
          bool = ((Bundle)localObject).getBoolean("isSupport", false);
          localJSONObject.put("ret", 0);
          paramBundle = new JSONObject();
          if (!bool) {
            break label1395;
          }
          i = 1;
          paramBundle.put("isSupport", i);
          localJSONObject.put("data", paramBundle);
          if (QLog.isColorLevel())
          {
            paramBundle = new StringBuilder();
            paramBundle.append("onResponse cmd = ");
            paramBundle.append(str1);
            paramBundle.append(" result = ");
            paramBundle.append(localJSONObject.toString());
            QLog.d("ChatFontJsPlugin", 2, paramBundle.toString());
          }
        }
        else
        {
          if ("ipc_download_hiboom".equals(str1))
          {
            if (!QLog.isColorLevel()) {
              break label1400;
            }
            QLog.d("ChatFontJsPlugin", 2, "onResponse download hiboom");
            return;
          }
          if ("font_startDownLoad".equals(str1))
          {
            if (!QLog.isColorLevel()) {
              break label1401;
            }
            QLog.d("ChatFontJsPlugin", 2, "onResponse download font");
            return;
          }
          if ("ipc_hiboom_user_switch".equals(str1))
          {
            bool = ((Bundle)localObject).getBoolean("isSupport", false);
            localJSONObject.put("ret", 0);
            paramBundle = new JSONObject();
            if (!bool) {
              break label1402;
            }
            i = 1;
            paramBundle.put("isSupport", i);
            localJSONObject.put("data", paramBundle);
            if (QLog.isColorLevel())
            {
              paramBundle = new StringBuilder();
              paramBundle.append("onResponse cmd = ");
              paramBundle.append(str1);
              paramBundle.append(" result = ");
              paramBundle.append(localJSONObject.toString());
              QLog.d("ChatFontJsPlugin", 2, paramBundle.toString());
            }
          }
          else if ("ipc_is_sys_font".equals(str1))
          {
            i = ((Bundle)localObject).getInt("isSysFont", -1);
            if (i < 0)
            {
              localJSONObject.put("ret", -1);
            }
            else
            {
              paramBundle = new JSONObject();
              paramBundle.put("isSysFont", i);
              localJSONObject.put("data", paramBundle);
              localJSONObject.put("ret", 0);
            }
          }
          else if ("ipc_set_sys_font".equals(str1))
          {
            localJSONObject.put("ret", ((Bundle)localObject).getInt("ret", -1));
          }
          else if ("ipc_has_sys_color_font".equals(str1))
          {
            i = ((Bundle)localObject).getInt("hasColor", -1);
            if (i == -1)
            {
              localJSONObject.put("ret", -1);
            }
            else
            {
              paramBundle = new JSONObject();
              paramBundle.put("hasColor", i);
              localJSONObject.put("data", paramBundle);
              localJSONObject.put("ret", 0);
            }
          }
        }
      }
      catch (Exception paramBundle)
      {
        Object localObject;
        if (QLog.isColorLevel())
        {
          localObject = new StringBuilder();
          ((StringBuilder)localObject).append("Failed to handle cmd ");
          ((StringBuilder)localObject).append(str1);
          ((StringBuilder)localObject).append(", exception: ");
          ((StringBuilder)localObject).append(paramBundle.getMessage());
          QLog.e("ChatFontJsPlugin", 2, ((StringBuilder)localObject).toString());
        }
      }
      super.callJs(str2, new String[] { localJSONObject.toString() });
      return;
      label1388:
      return;
      label1389:
      return;
      label1390:
      return;
      label1391:
      return;
      label1392:
      return;
      label1393:
      return;
      label1394:
      return;
      label1395:
      int i = 0;
      continue;
      label1400:
      return;
      label1401:
      return;
      label1402:
      i = 0;
    }
  }
  
  public void queryLocal(JSONObject paramJSONObject, String paramString)
  {
    Object localObject;
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("queryLocal:");
      ((StringBuilder)localObject).append(paramJSONObject);
      QLog.i("ChatFontJsPlugin", 2, ((StringBuilder)localObject).toString());
    }
    try
    {
      JSONObject localJSONObject = new JSONObject();
      paramJSONObject = this.browserApp.getEntityManagerFactory(null).createEntityManager();
      localObject = (ExtensionInfo)paramJSONObject.find(ExtensionInfo.class, this.browserApp.getAccount());
      paramJSONObject.close();
      localJSONObject.put("result", 0);
      if (localObject == null) {
        localJSONObject.put("currentId", 0L);
      } else {
        localJSONObject.put("currentId", ((ExtensionInfo)localObject).uVipFont);
      }
      int i = MobileQQ.getContext().getSharedPreferences("setting_text_size", 4).getInt("chat_text_size_type", 0);
      paramJSONObject = "small";
      Iterator localIterator = this.mFontSize.keySet().iterator();
      while (localIterator.hasNext())
      {
        localObject = (String)localIterator.next();
        if (((Integer)this.mFontSize.get(localObject)).intValue() == i) {
          paramJSONObject = (JSONObject)localObject;
        }
      }
      localJSONObject.put("currentSize", paramJSONObject);
      paramJSONObject = this.mRuntime.a().getSharedPreferences("font_open_switch", 4);
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("isUserOpenFontSwitch_");
      ((StringBuilder)localObject).append(this.mRuntime.a().getAccount());
      boolean bool1 = paramJSONObject.getBoolean(((StringBuilder)localObject).toString(), false);
      boolean bool2 = ((IDPCApi)QRoute.api(IDPCApi.class)).isFeatureSupported(DPCNames.chat_font.name());
      if ((!bool1) && (!bool2)) {
        i = 0;
      } else {
        i = 1;
      }
      if (i != 0) {
        localJSONObject.put("isOpen", 1);
      } else {
        localJSONObject.put("isOpen", 0);
      }
      paramJSONObject = new File(FontManagerConstants.FONT_DOWN_LOAD_PATH);
      localObject = new JSONArray();
      searchFontInDir(paramJSONObject, (JSONArray)localObject);
      searchFontInDir(new File(FontManagerConstants.FONT_FZ_COMPATIBLE_DIR), (JSONArray)localObject);
      localJSONObject.put("downloadedList", localObject);
      if (QLog.isColorLevel()) {
        QLog.d("ChatFontJsPlugin", 2, localJSONObject.toString());
      }
      super.callJs(paramString, new String[] { localJSONObject.toString() });
      return;
    }
    catch (JSONException paramJSONObject)
    {
      if (QLog.isColorLevel())
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("getFontId failed: ");
        ((StringBuilder)localObject).append(paramJSONObject.getMessage());
        QLog.e("ChatFontJsPlugin", 2, ((StringBuilder)localObject).toString());
      }
      super.callJs(paramString, new String[] { paramJSONObject.getMessage() });
    }
  }
  
  public void setSize(JSONObject paramJSONObject, String paramString)
  {
    Object localObject;
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("setSize:");
      ((StringBuilder)localObject).append(paramJSONObject);
      QLog.d("ChatFontJsPlugin", 2, ((StringBuilder)localObject).toString());
    }
    try
    {
      localObject = new JSONObject();
      paramJSONObject = paramJSONObject.getString("size");
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("change_");
      localStringBuilder.append(paramJSONObject);
      ReportController.a(null, "CliOper", "", "", "Font_Mall", localStringBuilder.toString(), 0, 0, "", "", "", "");
      boolean bool = this.mFontSize.containsKey(paramJSONObject);
      int i;
      if (bool)
      {
        i = ((Integer)this.mFontSize.get(paramJSONObject)).intValue();
        ((JSONObject)localObject).put("result", 0);
      }
      else
      {
        ((JSONObject)localObject).put("result", -1);
        ((JSONObject)localObject).put("message", "size illege");
        super.callJs(paramString, new String[] { ((JSONObject)localObject).toString() });
        i = 0;
      }
      paramJSONObject = MobileQQ.getContext().getSharedPreferences("setting_text_size", 4).edit();
      paramJSONObject.putInt("chat_text_size_type", i);
      paramJSONObject.commit();
      ((JSONObject)localObject).put("message", "success");
      super.callJs(paramString, new String[] { ((JSONObject)localObject).toString() });
      return;
    }
    catch (Exception paramJSONObject) {}
  }
  
  void startDownloadFont(int paramInt1, int paramInt2, String paramString, int paramInt3)
  {
    JSONObject localJSONObject;
    if (paramInt3 != 0)
    {
      if (paramInt3 != 1) {
        return;
      }
      if (HiBoomFont.a(paramInt1)) {
        localJSONObject = new JSONObject();
      }
    }
    try
    {
      localJSONObject.put("id", paramInt1);
      localJSONObject.put("result", 3);
      super.callJs(paramString, new String[] { localJSONObject.toString() });
      if (QLog.isColorLevel())
      {
        paramString = new StringBuilder();
        paramString.append("startDownloadFont result = ");
        paramString.append(localJSONObject.toString());
        QLog.d("ChatFontJsPlugin", 2, paramString.toString());
        return;
        this.mReqBundle.putInt("id", paramInt1);
        super.sendRemoteReq(DataFactory.a("ipc_download_hiboom", paramString, this.mOnRemoteResp.key, this.mReqBundle), false, true);
        return;
        if (FontManagerConstants.checkFontExist(paramInt1, paramInt2)) {
          localJSONObject = new JSONObject();
        }
      }
    }
    catch (JSONException localJSONException1)
    {
      try
      {
        localJSONObject.put("id", paramInt1);
        localJSONObject.put("result", 3);
        label181:
        super.callJs(paramString, new String[] { localJSONObject.toString() });
        if (QLog.isColorLevel())
        {
          paramString = new StringBuilder();
          paramString.append("startDownloadFont result = ");
          paramString.append(localJSONObject.toString());
          QLog.d("ChatFontJsPlugin", 2, paramString.toString());
          return;
          this.mReqBundle.putInt("id", paramInt1);
          this.mReqBundle.putInt("type", paramInt2);
          super.sendRemoteReq(DataFactory.a("font_startDownLoad", paramString, this.mOnRemoteResp.key, this.mReqBundle), false, true);
        }
        return;
        localJSONException1 = localJSONException1;
      }
      catch (JSONException localJSONException2)
      {
        break label181;
      }
    }
  }
  
  void tryInitHYEngine(String paramString)
  {
    if (ETEngine.getInstance().isEngineReady.get())
    {
      super.callJs(paramString, new String[] { "{\"ret\":0}" });
      if (QLog.isColorLevel()) {
        QLog.d("ChatFontJsPlugin", 2, "tryInitHYEngine engine is ready");
      }
      return;
    }
    if (ETEngine.getInstance().isEngineInited.get())
    {
      if (QLog.isColorLevel()) {
        QLog.d("ChatFontJsPlugin", 2, "tryInitHYEngine has inited");
      }
      return;
    }
    ETEngine.getInstance().isEngineInited.set(true);
    int j = VasSoUtils.a(VasSoUtils.a(), "libvipfont8417.so");
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("tryInitHYEngine loadSoResult = ");
      ((StringBuilder)localObject).append(j);
      QLog.d("ChatFontJsPlugin", 2, ((StringBuilder)localObject).toString());
    }
    int i = -1;
    if (j != 0)
    {
      if (j != 1) {
        if (j == 2) {
          break label228;
        }
      } else {
        super.sendRemoteReq(DataFactory.a("ipc_font_download_hy_so", paramString, this.mOnRemoteResp.key, this.mReqBundle), false, true);
      }
    }
    else {
      ETEngine.isSOLoaded.set(true);
    }
    try
    {
      bool = ETEngine.getInstance().initEngine(20, 8388608);
    }
    catch (Exception localException)
    {
      boolean bool;
      label199:
      break label199;
    }
    QLog.e("ChatFontJsPlugin", 1, "tryInitHYEngine fail");
    bool = false;
    if (bool)
    {
      ETEngine.getInstance().isEngineReady.set(true);
      i = 0;
    }
    label228:
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("{\"ret\":");
    ((StringBuilder)localObject).append(i);
    ((StringBuilder)localObject).append("}");
    localObject = ((StringBuilder)localObject).toString();
    if ((!TextUtils.isEmpty(paramString)) && (!"0".equals(paramString))) {
      super.callJs(paramString, new String[] { localObject });
    }
    if (QLog.isColorLevel())
    {
      paramString = new StringBuilder();
      paramString.append("initEngine result = ");
      paramString.append((String)localObject);
      QLog.d("ChatFontJsPlugin", 2, paramString.toString());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.vaswebviewplugin.ChatFontJsPlugin
 * JD-Core Version:    0.7.0.1
 */