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
import anni;
import arpd;
import arph;
import auzc;
import bcst;
import bgku;
import bglp;
import bgpa;
import bgtl;
import bhga;
import bhod;
import bhsw;
import com.etrump.mixlayout.ETEngine;
import com.etrump.mixlayout.ETFont;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.app.BrowserAppInterface;
import com.tencent.mobileqq.app.DeviceProfileManager;
import com.tencent.mobileqq.app.DeviceProfileManager.DpcNames;
import com.tencent.mobileqq.data.ExtensionInfo;
import com.tencent.mobileqq.persistence.EntityManager;
import com.tencent.mobileqq.persistence.EntityManagerFactory;
import com.tencent.mobileqq.webview.swift.JsBridgeListener;
import com.tencent.mobileqq.webview.swift.WebViewPlugin;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import gc;
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
  public static FilenameFilter mHiBoomFontFilter = new bhga();
  private BrowserAppInterface browserApp;
  private boolean isUseFont;
  private HashMap<String, Integer> mFontSize;
  private FilenameFilter mHiBoomDirFilter = new ChatFontJsPlugin.6(this);
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
    if (!gc.a(paramInt1, paramInt2))
    {
      if (QLog.isColorLevel()) {
        QLog.d("ChatFontJsPlugin", 2, "checkDiyFontText fail font not exists id = " + paramInt1);
      }
      super.callJs(paramString2, new String[] { "{\"ret\":-2}" });
      return;
    }
    ETFont localETFont = new ETFont(paramInt1, gc.a(paramInt1, paramInt2), 16.0F);
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
      if (!gc.a(paramInt1, paramInt2))
      {
        if (QLog.isColorLevel()) {
          QLog.d("ChatFontJsPlugin", 2, "getDiyFontInfo fail font not exists id = " + paramInt1);
        }
        super.callJs(paramString, new String[] { "{\"ret\":-1}" });
        return;
      }
      Object localObject1 = new ETFont(paramInt1, gc.a(paramInt1, paramInt2), 16.0F);
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
  
  private void queryLocalHiBoom(String paramString)
  {
    Object localObject = new File(auzc.b);
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
          String[] arrayOfString = arrayOfFile[i].list(mHiBoomFontFilter);
          if (arrayOfString != null)
          {
            int m = arrayOfString.length;
            int j = 0;
            if (j < m)
            {
              String str = arrayOfString[j];
              if (str.endsWith(".hy")) {
                localObject = ".hy";
              }
              for (;;)
              {
                label127:
                localObject = str.substring(0, str.length() - ((String)localObject).length());
                if (TextUtils.isDigitsOnly((CharSequence)localObject)) {
                  localJSONArray.put(Integer.parseInt((String)localObject));
                }
                do
                {
                  j += 1;
                  break;
                  if (str.endsWith(".fz"))
                  {
                    localObject = ".fz";
                    break label127;
                  }
                  if (str.endsWith(".fz4"))
                  {
                    localObject = ".fz4";
                    break label127;
                  }
                } while (!str.endsWith(".hy3"));
                localObject = ".hy3";
              }
            }
          }
          i += 1;
        }
      }
    }
    try
    {
      localJSONObject.put("downloadedList", localJSONArray);
      label247:
      if (QLog.isColorLevel()) {
        QLog.d("ChatFontJsPlugin", 2, "queryLocalHiBoom result = " + localJSONObject.toString());
      }
      super.callJs(paramString, new String[] { localJSONObject.toString() });
      return;
    }
    catch (Exception localException)
    {
      break label247;
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
      super.sendRemoteReq(arph.a("setFontSwtich", paramString, this.mOnRemoteResp.key, this.mReqBundle), false, true);
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
    if (!gc.a(paramInt1, paramInt2))
    {
      if (QLog.isColorLevel()) {
        QLog.d("ChatFontJsPlugin", 2, "diyPreview font not exists");
      }
      super.callJs(paramString1, new String[] { "{\"ret\":-1}" });
      startDownloadFont(paramInt1, paramInt2, "0", 0);
      return;
    }
    if (!ETEngine.getInstance().native_isFontLoaded(paramInt1)) {
      ETEngine.getInstance().native_loadFont(gc.a(paramInt1, paramInt2), paramInt1, false);
    }
    ETFont localETFont = new ETFont(paramInt1, gc.a(paramInt1, paramInt2), paramInt3 * 2);
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
      paramString2 = bgku.encodeToString(paramString2.toByteArray(), 2);
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
  
  /* Error */
  void getFontPreview(String paramString1, int paramInt1, int paramInt2, String paramString2, String paramString3, int paramInt3, String paramString4)
  {
    // Byte code:
    //   0: invokestatic 60	com/etrump/mixlayout/ETEngine:getInstance	()Lcom/etrump/mixlayout/ETEngine;
    //   3: getfield 127	com/etrump/mixlayout/ETEngine:isEngineReady	Ljava/util/concurrent/atomic/AtomicBoolean;
    //   6: invokevirtual 132	java/util/concurrent/atomic/AtomicBoolean:get	()Z
    //   9: ifne +41 -> 50
    //   12: invokestatic 109	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   15: ifeq +12 -> 27
    //   18: ldc 16
    //   20: iconst_2
    //   21: ldc_w 370
    //   24: invokestatic 115	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   27: aload_0
    //   28: ldc_w 372
    //   31: invokevirtual 375	com/tencent/mobileqq/vaswebviewplugin/ChatFontJsPlugin:tryInitHYEngine	(Ljava/lang/String;)V
    //   34: aload_0
    //   35: aload_1
    //   36: iconst_1
    //   37: anewarray 117	java/lang/String
    //   40: dup
    //   41: iconst_0
    //   42: ldc_w 468
    //   45: aastore
    //   46: invokespecial 123	com/tencent/mobileqq/vaswebviewplugin/VasWebviewJsPlugin:callJs	(Ljava/lang/String;[Ljava/lang/String;)V
    //   49: return
    //   50: aload 4
    //   52: invokestatic 103	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   55: ifne +8 -> 63
    //   58: iload 6
    //   60: ifgt +98 -> 158
    //   63: aload_0
    //   64: aload_1
    //   65: iconst_1
    //   66: anewarray 117	java/lang/String
    //   69: dup
    //   70: iconst_0
    //   71: new 142	java/lang/StringBuilder
    //   74: dup
    //   75: invokespecial 143	java/lang/StringBuilder:<init>	()V
    //   78: ldc_w 470
    //   81: invokevirtual 149	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   84: iload 6
    //   86: invokevirtual 152	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   89: ldc_w 472
    //   92: invokevirtual 149	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   95: aload 4
    //   97: invokevirtual 149	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   100: ldc_w 474
    //   103: invokevirtual 149	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   106: invokevirtual 156	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   109: aastore
    //   110: invokespecial 123	com/tencent/mobileqq/vaswebviewplugin/VasWebviewJsPlugin:callJs	(Ljava/lang/String;[Ljava/lang/String;)V
    //   113: invokestatic 109	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   116: ifeq -67 -> 49
    //   119: ldc 16
    //   121: iconst_2
    //   122: new 142	java/lang/StringBuilder
    //   125: dup
    //   126: invokespecial 143	java/lang/StringBuilder:<init>	()V
    //   129: ldc_w 377
    //   132: invokevirtual 149	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   135: aload 4
    //   137: invokevirtual 149	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   140: ldc_w 379
    //   143: invokevirtual 149	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   146: iload 6
    //   148: invokevirtual 152	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   151: invokevirtual 156	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   154: invokestatic 115	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   157: return
    //   158: iconst_2
    //   159: iload 6
    //   161: i2f
    //   162: aload_0
    //   163: getfield 476	com/tencent/mobileqq/vaswebviewplugin/ChatFontJsPlugin:browserApp	Lcom/tencent/mobileqq/app/BrowserAppInterface;
    //   166: invokevirtual 482	com/tencent/mobileqq/app/BrowserAppInterface:getApp	()Lcom/tencent/qphone/base/util/BaseApplication;
    //   169: invokevirtual 488	com/tencent/qphone/base/util/BaseApplication:getResources	()Landroid/content/res/Resources;
    //   172: invokevirtual 494	android/content/res/Resources:getDisplayMetrics	()Landroid/util/DisplayMetrics;
    //   175: invokestatic 500	android/util/TypedValue:applyDimension	(IFLandroid/util/DisplayMetrics;)F
    //   178: fconst_2
    //   179: fdiv
    //   180: f2i
    //   181: istore 9
    //   183: iload_2
    //   184: iload_3
    //   185: invokestatic 140	gc:a	(II)Z
    //   188: ifne +44 -> 232
    //   191: invokestatic 109	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   194: ifeq +12 -> 206
    //   197: ldc 16
    //   199: iconst_2
    //   200: ldc_w 381
    //   203: invokestatic 115	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   206: aload_0
    //   207: aload_1
    //   208: iconst_1
    //   209: anewarray 117	java/lang/String
    //   212: dup
    //   213: iconst_0
    //   214: ldc_w 502
    //   217: aastore
    //   218: invokespecial 123	com/tencent/mobileqq/vaswebviewplugin/VasWebviewJsPlugin:callJs	(Ljava/lang/String;[Ljava/lang/String;)V
    //   221: aload_0
    //   222: iload_2
    //   223: iload_3
    //   224: ldc_w 372
    //   227: iconst_0
    //   228: invokevirtual 385	com/tencent/mobileqq/vaswebviewplugin/ChatFontJsPlugin:startDownloadFont	(IILjava/lang/String;I)V
    //   231: return
    //   232: ldc_w 503
    //   235: istore 6
    //   237: aload 7
    //   239: invokestatic 103	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   242: ifne +10 -> 252
    //   245: aload 7
    //   247: invokestatic 508	android/graphics/Color:parseColor	(Ljava/lang/String;)I
    //   250: istore 6
    //   252: invokestatic 60	com/etrump/mixlayout/ETEngine:getInstance	()Lcom/etrump/mixlayout/ETEngine;
    //   255: iload_2
    //   256: invokevirtual 389	com/etrump/mixlayout/ETEngine:native_isFontLoaded	(I)Z
    //   259: ifne +17 -> 276
    //   262: invokestatic 60	com/etrump/mixlayout/ETEngine:getInstance	()Lcom/etrump/mixlayout/ETEngine;
    //   265: iload_2
    //   266: iload_3
    //   267: invokestatic 159	gc:a	(II)Ljava/lang/String;
    //   270: iload_2
    //   271: iconst_0
    //   272: invokevirtual 393	com/etrump/mixlayout/ETEngine:native_loadFont	(Ljava/lang/String;IZ)Z
    //   275: pop
    //   276: new 82	com/etrump/mixlayout/ETFont
    //   279: dup
    //   280: iload_2
    //   281: iload_2
    //   282: iload_3
    //   283: invokestatic 159	gc:a	(II)Ljava/lang/String;
    //   286: iload 9
    //   288: i2f
    //   289: invokespecial 163	com/etrump/mixlayout/ETFont:<init>	(ILjava/lang/String;F)V
    //   292: astore 7
    //   294: aload_0
    //   295: aload 7
    //   297: invokespecial 395	com/tencent/mobileqq/vaswebviewplugin/ChatFontJsPlugin:calculateFontPadding	(Lcom/etrump/mixlayout/ETFont;)Lcom/tencent/mobileqq/vaswebviewplugin/ChatFontJsPlugin$FontPadding;
    //   300: astore 11
    //   302: aload 7
    //   304: aload 11
    //   306: getfield 92	com/tencent/mobileqq/vaswebviewplugin/ChatFontJsPlugin$FontPadding:fontSize	F
    //   309: invokevirtual 220	com/etrump/mixlayout/ETFont:setSize	(F)V
    //   312: aload 7
    //   314: iload 6
    //   316: invokevirtual 512	com/etrump/mixlayout/ETFont:setColor	(I)V
    //   319: aload 7
    //   321: aload 5
    //   323: invokevirtual 398	com/etrump/mixlayout/ETFont:parseDIYJsonString	(Ljava/lang/String;)V
    //   326: aload 4
    //   328: invokevirtual 174	java/lang/String:length	()I
    //   331: istore 10
    //   333: iload 9
    //   335: iload 10
    //   337: imul
    //   338: iload 9
    //   340: getstatic 404	android/graphics/Bitmap$Config:ARGB_8888	Landroid/graphics/Bitmap$Config;
    //   343: invokestatic 410	android/graphics/Bitmap:createBitmap	(IILandroid/graphics/Bitmap$Config;)Landroid/graphics/Bitmap;
    //   346: astore 5
    //   348: iconst_0
    //   349: istore_2
    //   350: iload_2
    //   351: iload 10
    //   353: if_icmpge +133 -> 486
    //   356: iload 9
    //   358: iload_2
    //   359: imul
    //   360: istore 8
    //   362: iconst_0
    //   363: istore 6
    //   365: aload 11
    //   367: getfield 89	com/tencent/mobileqq/vaswebviewplugin/ChatFontJsPlugin$FontPadding:paddingType	I
    //   370: iconst_1
    //   371: if_icmpne +86 -> 457
    //   374: iload 8
    //   376: i2f
    //   377: aload 11
    //   379: getfield 95	com/tencent/mobileqq/vaswebviewplugin/ChatFontJsPlugin$FontPadding:padding	F
    //   382: fadd
    //   383: f2i
    //   384: istore_3
    //   385: invokestatic 60	com/etrump/mixlayout/ETEngine:getInstance	()Lcom/etrump/mixlayout/ETEngine;
    //   388: aload 4
    //   390: iload_2
    //   391: iload_2
    //   392: iconst_1
    //   393: iadd
    //   394: invokevirtual 284	java/lang/String:substring	(II)Ljava/lang/String;
    //   397: aload 5
    //   399: iload_3
    //   400: iload 6
    //   402: aload 7
    //   404: invokevirtual 414	com/etrump/mixlayout/ETEngine:native_drawText	(Ljava/lang/String;Landroid/graphics/Bitmap;IILcom/etrump/mixlayout/ETFont;)Z
    //   407: pop
    //   408: iload_2
    //   409: iconst_1
    //   410: iadd
    //   411: istore_2
    //   412: goto -62 -> 350
    //   415: astore 4
    //   417: aload_0
    //   418: aload_1
    //   419: iconst_1
    //   420: anewarray 117	java/lang/String
    //   423: dup
    //   424: iconst_0
    //   425: new 142	java/lang/StringBuilder
    //   428: dup
    //   429: invokespecial 143	java/lang/StringBuilder:<init>	()V
    //   432: ldc_w 514
    //   435: invokevirtual 149	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   438: aload 7
    //   440: invokevirtual 149	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   443: ldc_w 474
    //   446: invokevirtual 149	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   449: invokevirtual 156	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   452: aastore
    //   453: invokespecial 123	com/tencent/mobileqq/vaswebviewplugin/VasWebviewJsPlugin:callJs	(Ljava/lang/String;[Ljava/lang/String;)V
    //   456: return
    //   457: iload 8
    //   459: istore_3
    //   460: aload 11
    //   462: getfield 89	com/tencent/mobileqq/vaswebviewplugin/ChatFontJsPlugin$FontPadding:paddingType	I
    //   465: iconst_2
    //   466: if_icmpne -81 -> 385
    //   469: iconst_0
    //   470: i2f
    //   471: aload 11
    //   473: getfield 95	com/tencent/mobileqq/vaswebviewplugin/ChatFontJsPlugin$FontPadding:padding	F
    //   476: fadd
    //   477: f2i
    //   478: istore 6
    //   480: iload 8
    //   482: istore_3
    //   483: goto -98 -> 385
    //   486: new 416	java/io/ByteArrayOutputStream
    //   489: dup
    //   490: invokespecial 417	java/io/ByteArrayOutputStream:<init>	()V
    //   493: astore 4
    //   495: aload 5
    //   497: getstatic 423	android/graphics/Bitmap$CompressFormat:PNG	Landroid/graphics/Bitmap$CompressFormat;
    //   500: bipush 100
    //   502: aload 4
    //   504: invokevirtual 427	android/graphics/Bitmap:compress	(Landroid/graphics/Bitmap$CompressFormat;ILjava/io/OutputStream;)Z
    //   507: pop
    //   508: aload 4
    //   510: invokevirtual 431	java/io/ByteArrayOutputStream:toByteArray	()[B
    //   513: iconst_2
    //   514: invokestatic 437	bgku:encodeToString	([BI)Ljava/lang/String;
    //   517: astore 4
    //   519: new 222	org/json/JSONObject
    //   522: dup
    //   523: invokespecial 223	org/json/JSONObject:<init>	()V
    //   526: astore 11
    //   528: new 222	org/json/JSONObject
    //   531: dup
    //   532: invokespecial 223	org/json/JSONObject:<init>	()V
    //   535: astore 12
    //   537: aload 12
    //   539: ldc_w 439
    //   542: aload 4
    //   544: invokevirtual 238	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   547: pop
    //   548: aload 12
    //   550: ldc_w 441
    //   553: aload 5
    //   555: invokevirtual 444	android/graphics/Bitmap:getWidth	()I
    //   558: invokevirtual 229	org/json/JSONObject:put	(Ljava/lang/String;I)Lorg/json/JSONObject;
    //   561: pop
    //   562: aload 12
    //   564: ldc 233
    //   566: aload 5
    //   568: invokevirtual 447	android/graphics/Bitmap:getHeight	()I
    //   571: invokevirtual 229	org/json/JSONObject:put	(Ljava/lang/String;I)Lorg/json/JSONObject;
    //   574: pop
    //   575: aload 11
    //   577: ldc 235
    //   579: aload 12
    //   581: invokevirtual 238	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   584: pop
    //   585: aload 11
    //   587: ldc 225
    //   589: iconst_0
    //   590: invokevirtual 229	org/json/JSONObject:put	(Ljava/lang/String;I)Lorg/json/JSONObject;
    //   593: pop
    //   594: aload_0
    //   595: aload_1
    //   596: iconst_1
    //   597: anewarray 117	java/lang/String
    //   600: dup
    //   601: iconst_0
    //   602: aload 11
    //   604: invokevirtual 239	org/json/JSONObject:toString	()Ljava/lang/String;
    //   607: aastore
    //   608: invokespecial 123	com/tencent/mobileqq/vaswebviewplugin/VasWebviewJsPlugin:callJs	(Ljava/lang/String;[Ljava/lang/String;)V
    //   611: invokestatic 109	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   614: ifeq +33 -> 647
    //   617: ldc 16
    //   619: iconst_2
    //   620: new 142	java/lang/StringBuilder
    //   623: dup
    //   624: invokespecial 143	java/lang/StringBuilder:<init>	()V
    //   627: ldc_w 449
    //   630: invokevirtual 149	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   633: aload 11
    //   635: invokevirtual 239	org/json/JSONObject:toString	()Ljava/lang/String;
    //   638: invokevirtual 149	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   641: invokevirtual 156	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   644: invokestatic 115	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   647: aload 5
    //   649: invokevirtual 452	android/graphics/Bitmap:recycle	()V
    //   652: invokestatic 60	com/etrump/mixlayout/ETEngine:getInstance	()Lcom/etrump/mixlayout/ETEngine;
    //   655: aload 7
    //   657: getfield 456	com/etrump/mixlayout/ETFont:m_diyHandle	J
    //   660: invokevirtual 460	com/etrump/mixlayout/ETEngine:native_diyFontDeleteNativeConfig	(J)V
    //   663: return
    //   664: astore 4
    //   666: ldc 16
    //   668: iconst_1
    //   669: ldc_w 462
    //   672: invokestatic 464	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   675: aload_0
    //   676: aload_1
    //   677: iconst_1
    //   678: anewarray 117	java/lang/String
    //   681: dup
    //   682: iconst_0
    //   683: ldc 204
    //   685: aastore
    //   686: invokespecial 123	com/tencent/mobileqq/vaswebviewplugin/VasWebviewJsPlugin:callJs	(Ljava/lang/String;[Ljava/lang/String;)V
    //   689: goto -37 -> 652
    //   692: astore 4
    //   694: ldc 16
    //   696: iconst_1
    //   697: ldc_w 462
    //   700: invokestatic 464	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   703: aload_0
    //   704: aload_1
    //   705: iconst_1
    //   706: anewarray 117	java/lang/String
    //   709: dup
    //   710: iconst_0
    //   711: ldc 204
    //   713: aastore
    //   714: invokespecial 123	com/tencent/mobileqq/vaswebviewplugin/VasWebviewJsPlugin:callJs	(Ljava/lang/String;[Ljava/lang/String;)V
    //   717: goto -65 -> 652
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	720	0	this	ChatFontJsPlugin
    //   0	720	1	paramString1	String
    //   0	720	2	paramInt1	int
    //   0	720	3	paramInt2	int
    //   0	720	4	paramString2	String
    //   0	720	5	paramString3	String
    //   0	720	6	paramInt3	int
    //   0	720	7	paramString4	String
    //   360	121	8	i	int
    //   181	179	9	j	int
    //   331	23	10	k	int
    //   300	334	11	localObject	Object
    //   535	45	12	localJSONObject	JSONObject
    // Exception table:
    //   from	to	target	type
    //   245	252	415	java/lang/Exception
    //   333	348	664	java/lang/OutOfMemoryError
    //   365	385	664	java/lang/OutOfMemoryError
    //   385	408	664	java/lang/OutOfMemoryError
    //   460	480	664	java/lang/OutOfMemoryError
    //   486	647	664	java/lang/OutOfMemoryError
    //   647	652	664	java/lang/OutOfMemoryError
    //   333	348	692	java/lang/Exception
    //   365	385	692	java/lang/Exception
    //   385	408	692	java/lang/Exception
    //   460	480	692	java/lang/Exception
    //   486	647	692	java/lang/Exception
    //   647	652	692	java/lang/Exception
  }
  
  protected long getPluginBusiness()
  {
    return 2147487744L;
  }
  
  public boolean handleJsRequest(JsBridgeListener paramJsBridgeListener, String paramString1, String paramString2, String paramString3, String... paramVarArgs)
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
    int k = paramString2.optInt("fontType");
    paramString1 = paramString2.optString("callback");
    paramJsBridgeListener = null;
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
      paramJsBridgeListener.put("message", anni.a(2131700391));
      super.callJs(paramString1, new String[] { paramJsBridgeListener.toString() });
      label291:
      paramJsBridgeListener = "queryFontInfo";
      for (;;)
      {
        this.mReqBundle.putInt("id", i);
        this.mReqBundle.putInt("type", j);
        this.mReqBundle.putInt("fontOrhiboom", k);
        super.sendRemoteReq(arph.a(paramJsBridgeListener, paramString1, this.mOnRemoteResp.key, this.mReqBundle), false, true);
        return true;
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
            switch (k)
            {
            default: 
              break;
            case 0: 
              paramJsBridgeListener = "font_StopDownLoad";
              break;
            case 1: 
              paramJsBridgeListener = "ipc_stop_download_hiboom";
              break;
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
                paramString3 = this.mRuntime.a(this.mRuntime.a());
                if ((paramString3 != null) && ((paramString3 instanceof bhsw))) {
                  QQToast.a(this.mRuntime.a(), paramString2, 0).b(((bhsw)paramString3).getTitleBarHeight());
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
            int m;
            if ("setMagicFont".equals(paramString3))
            {
              paramJsBridgeListener = "setupMagicFont";
              m = paramString2.optInt("setup");
              this.mReqBundle.putInt("magic_setup", m);
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
                paramJsBridgeListener = "setupFontEffect";
                m = paramString2.optInt("id");
                if (QLog.isColorLevel()) {
                  QLog.i("ChatFontJsPlugin", 2, "fontEffectId: " + m);
                }
                this.mReqBundle.putInt("fontEffectId", m);
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
                  paramJsBridgeListener = "ipc_set_sys_font";
                  m = paramString2.optInt("sysfont", -1);
                  this.mReqBundle.putInt("sysfont", m);
                }
                else if ("hasSysColorFont".equals(paramString3))
                {
                  paramJsBridgeListener = "ipc_has_sys_color_font";
                }
                else
                {
                  if (!"paySuccess".equals(paramString3)) {
                    break;
                  }
                  paramJsBridgeListener = "ipc_set_hiboom";
                }
              }
            }
          }
        }
      }
      if ("fontBubblePaySuccess".equals(paramString3))
      {
        this.mReqBundle.putInt("id", i);
        this.mReqBundle.putInt("sid", paramString2.optInt("sid"));
        super.sendRemoteReq(arph.a("fontBubblePaySuccess", paramString1, this.mOnRemoteResp.key, this.mReqBundle), false, true);
        return true;
      }
      if (QLog.isColorLevel()) {
        QLog.w("ChatFontJsPlugin", 2, "NOT support method " + paramString3 + " yet!!");
      }
      return false;
    }
    catch (JSONException paramJsBridgeListener)
    {
      break label291;
    }
  }
  
  void initHYEngine(String paramString)
  {
    int j = -1;
    int k = bgtl.a(bgtl.a(), "libvipfont808.so");
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
      bgpa localbgpa = bglp.a(this.mRuntime.a(), 230).setTitle(this.mRuntime.a().getString(2131718568)).setMessage(this.mRuntime.a().getString(2131694368)).setPositiveButton(this.mRuntime.a().getString(2131694369), new ChatFontJsPlugin.3(this, localJSONObject, paramString)).setNegativeButton(this.mRuntime.a().getString(2131694366), new ChatFontJsPlugin.2(this, localJSONObject, paramString));
      localbgpa.show();
      localbgpa.setOnCancelListener(new ChatFontJsPlugin.4(this, localJSONObject, paramString));
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
  
  public void onCreate()
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
    Bundle localBundle;
    boolean bool;
    label849:
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
        String str2;
        for (;;)
        {
          return;
          if (paramBundle.getInt("respkey", 0) == this.mOnRemoteResp.key)
          {
            str1 = paramBundle.getString("cmd");
            str2 = paramBundle.getString("callbackid");
            localJSONObject = new JSONObject();
            try
            {
              localBundle = paramBundle.getBundle("response");
              if ("setupChatFont".equals(str1))
              {
                localJSONObject.put("result", localBundle.getInt("result"));
                localJSONObject.put("message", localBundle.getString("message"));
                super.callJs(str2, new String[] { localJSONObject.toString() });
                if (!QLog.isColorLevel()) {
                  continue;
                }
                QLog.d("ChatFontJsPlugin", 2, "onResponse cmd = " + str1 + " Result = " + localJSONObject.toString());
              }
            }
            catch (Exception paramBundle)
            {
              if (QLog.isColorLevel()) {
                QLog.e("ChatFontJsPlugin", 2, "Failed to handle cmd " + str1 + ", exception: " + paramBundle.getMessage());
              }
            }
          }
        }
        for (;;)
        {
          super.callJs(str2, new String[] { localJSONObject.toString() });
          return;
          if ("queryFontInfo".equals(str1))
          {
            paramBundle = localBundle.getString("result");
            super.callJs(str2, new String[] { paramBundle });
            if (!QLog.isColorLevel()) {
              break;
            }
            QLog.d("ChatFontJsPlugin", 2, "onResponse cmd = " + str1 + " Result = " + paramBundle);
            return;
          }
          if ("font_StopDownLoad".equals(str1))
          {
            localJSONObject.put("result", 0);
            super.callJs(str2, new String[] { localJSONObject.toString() });
            if (!QLog.isColorLevel()) {
              break;
            }
            QLog.d("ChatFontJsPlugin", 2, "onResponse cmd = " + str1 + " Result = " + localJSONObject.toString());
            return;
          }
          if ("setFontSwtich".equals(str1))
          {
            localJSONObject.put("result", 0);
            super.callJs(str2, new String[] { localJSONObject.toString() });
            if (!QLog.isColorLevel()) {
              break;
            }
            QLog.d("ChatFontJsPlugin", 2, "onResponse cmd = " + str1 + " Result = " + localJSONObject.toString());
            return;
          }
          if ("setupMagicFont".equals(str1))
          {
            localJSONObject.put("result", 0);
            super.callJs(str2, new String[] { localJSONObject.toString() });
            if (!QLog.isColorLevel()) {
              break;
            }
            QLog.d("ChatFontJsPlugin", 2, "onResponse cmd = " + str1 + " Result = " + localJSONObject.toString());
            return;
          }
          if ("setupFontEffect".equals(str1))
          {
            localJSONObject.put("ret", paramBundle.getInt("ret"));
            localJSONObject.put("msg", paramBundle.getString("msg"));
            super.callJs(str2, new String[] { localJSONObject.toString() });
            if (!QLog.isColorLevel()) {
              break;
            }
            QLog.d("ChatFontJsPlugin", 2, "onResponse cmd = " + str1 + " Result = " + localJSONObject.toString());
            return;
          }
          if ("isSupportFounderColorFont".equals(str1))
          {
            i = localBundle.getInt("result", 0);
            paramBundle = new JSONObject();
            paramBundle.put("isSupport", i);
            localJSONObject.put("result", 0);
            localJSONObject.put("data", paramBundle);
            super.callJs(str2, new String[] { localJSONObject.toString() });
            if (!QLog.isColorLevel()) {
              break;
            }
            QLog.d("ChatFontJsPlugin", 2, "onResponse cmd = " + str1 + " result = " + localJSONObject.toString());
            return;
          }
          if (!"ipc_hiboom_switch".equals(str1)) {
            break label917;
          }
          bool = localBundle.getBoolean("isSupport", false);
          localJSONObject.put("ret", 0);
          paramBundle = new JSONObject();
          if (!bool) {
            break label1264;
          }
          i = 1;
          paramBundle.put("isSupport", i);
          localJSONObject.put("data", paramBundle);
          if (QLog.isColorLevel()) {
            QLog.d("ChatFontJsPlugin", 2, "onResponse cmd = " + str1 + " result = " + localJSONObject.toString());
          }
        }
        if (!"ipc_download_hiboom".equals(str1)) {
          break;
        }
      } while (!QLog.isColorLevel());
      QLog.d("ChatFontJsPlugin", 2, "onResponse download hiboom");
      return;
      if (!"font_startDownLoad".equals(str1)) {
        break;
      }
    } while (!QLog.isColorLevel());
    label917:
    QLog.d("ChatFontJsPlugin", 2, "onResponse download font");
    return;
    if ("ipc_hiboom_user_switch".equals(str1))
    {
      bool = localBundle.getBoolean("isSupport", false);
      localJSONObject.put("ret", 0);
      paramBundle = new JSONObject();
      if (!bool) {
        break label1269;
      }
    }
    label1264:
    label1269:
    for (int i = 1;; i = 0)
    {
      paramBundle.put("isSupport", i);
      localJSONObject.put("data", paramBundle);
      if (!QLog.isColorLevel()) {
        break;
      }
      QLog.d("ChatFontJsPlugin", 2, "onResponse cmd = " + str1 + " result = " + localJSONObject.toString());
      break;
      if ("ipc_is_sys_font".equals(str1))
      {
        i = localBundle.getInt("isSysFont", -1);
        if (i < 0)
        {
          localJSONObject.put("ret", -1);
          break;
        }
        paramBundle = new JSONObject();
        paramBundle.put("isSysFont", i);
        localJSONObject.put("data", paramBundle);
        localJSONObject.put("ret", 0);
        break;
      }
      if ("ipc_set_sys_font".equals(str1))
      {
        localJSONObject.put("ret", localBundle.getInt("ret", -1));
        break;
      }
      if (!"ipc_has_sys_color_font".equals(str1)) {
        break;
      }
      i = localBundle.getInt("hasColor", -1);
      if (i == -1)
      {
        localJSONObject.put("ret", -1);
        break;
      }
      paramBundle = new JSONObject();
      paramBundle.put("hasColor", i);
      localJSONObject.put("data", paramBundle);
      localJSONObject.put("ret", 0);
      break;
      i = 0;
      break label849;
    }
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
      localObject = (ExtensionInfo)paramJSONObject.find(ExtensionInfo.class, this.browserApp.getAccount());
      paramJSONObject.close();
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
        paramJSONObject = new File(gc.a);
        localObject = new JSONArray();
        searchFontInDir(paramJSONObject, (JSONArray)localObject);
        searchFontInDir(new File(gc.b), (JSONArray)localObject);
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
      bcst.a(null, "CliOper", "", "", "Font_Mall", "change_" + paramJSONObject, 0, 0, "", "", "", "");
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
  
  void startDownloadFont(int paramInt1, int paramInt2, String paramString, int paramInt3)
  {
    switch (paramInt3)
    {
    }
    for (;;)
    {
      return;
      JSONObject localJSONObject;
      if (gc.a(paramInt1, paramInt2)) {
        localJSONObject = new JSONObject();
      }
      try
      {
        localJSONObject.put("id", paramInt1);
        localJSONObject.put("result", 3);
        label62:
        super.callJs(paramString, new String[] { localJSONObject.toString() });
        if (!QLog.isColorLevel()) {
          continue;
        }
        QLog.d("ChatFontJsPlugin", 2, "startDownloadFont result = " + localJSONObject.toString());
        return;
        this.mReqBundle.putInt("id", paramInt1);
        this.mReqBundle.putInt("type", paramInt2);
        super.sendRemoteReq(arph.a("font_startDownLoad", paramString, this.mOnRemoteResp.key, this.mReqBundle), false, true);
        return;
        if (auzc.a(paramInt1)) {
          localJSONObject = new JSONObject();
        }
        try
        {
          localJSONObject.put("id", paramInt1);
          localJSONObject.put("result", 3);
          label199:
          super.callJs(paramString, new String[] { localJSONObject.toString() });
          if (!QLog.isColorLevel()) {
            continue;
          }
          QLog.d("ChatFontJsPlugin", 2, "startDownloadFont result = " + localJSONObject.toString());
          return;
          this.mReqBundle.putInt("id", paramInt1);
          super.sendRemoteReq(arph.a("ipc_download_hiboom", paramString, this.mOnRemoteResp.key, this.mReqBundle), false, true);
          return;
        }
        catch (JSONException localJSONException1)
        {
          break label199;
        }
      }
      catch (JSONException localJSONException2)
      {
        break label62;
      }
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
    int k = bgtl.a(bgtl.a(), "libvipfont808.so");
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
      super.sendRemoteReq(arph.a("ipc_font_download_hy_so", paramString, this.mOnRemoteResp.key, this.mReqBundle), false, true);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.vaswebviewplugin.ChatFontJsPlugin
 * JD-Core Version:    0.7.0.1
 */