package com.tencent.mobileqq.webview.webso;

import android.app.Activity;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.graphics.BitmapFactory;
import android.graphics.BitmapFactory.Options;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.Handler;
import android.support.v4.util.LruCache;
import android.text.TextUtils;
import android.view.View;
import com.tencent.biz.common.util.Util;
import com.tencent.biz.pubaccount.CustomWebView;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawable.URLDrawableOptions;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.config.business.qvip.QVipSDKConfig;
import com.tencent.mobileqq.config.business.qvip.QVipSDKProcessor;
import com.tencent.mobileqq.musicpendant.Base64;
import com.tencent.mobileqq.transfile.URLDrawableHelper;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.mobileqq.utils.VipUtils;
import com.tencent.mobileqq.webview.swift.component.SwiftBrowserCookieMonster;
import com.tencent.open.base.BspatchUtil;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import cooperation.qzone.QUA;
import java.io.File;
import java.io.IOException;
import java.lang.ref.WeakReference;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.concurrent.atomic.AtomicInteger;
import mqq.app.AppRuntime;
import mqq.app.NewIntent;
import mqq.observer.BusinessObserver;
import mqq.os.MqqHandler;
import org.apache.http.util.EncodingUtils;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.json.JSONException;
import org.json.JSONObject;
import wns_proxy.EnumHttpMethod;
import wns_proxy.HttpReq;
import wns_proxy.HttpRsp;

public class WebSoService
  implements BusinessObserver
{
  private static volatile WebSoService jdField_a_of_type_ComTencentMobileqqWebviewWebsoWebSoService;
  private static Object jdField_a_of_type_JavaLangObject = new Object();
  private static String jdField_a_of_type_JavaLangString = "";
  LruCache<String, WebSoService.WebSoState> jdField_a_of_type_AndroidSupportV4UtilLruCache = new WebSoService.1(this, 10);
  private HashMap<String, String> jdField_a_of_type_JavaUtilHashMap = new HashMap();
  private boolean jdField_a_of_type_Boolean = false;
  
  private static Drawable a(String paramString)
  {
    String str = WebSoUtils.b(paramString);
    if ((TextUtils.isEmpty(str)) || (!new File(str).exists())) {
      return null;
    }
    try
    {
      URLDrawable.URLDrawableOptions localURLDrawableOptions = URLDrawable.URLDrawableOptions.obtain();
      localURLDrawableOptions.mUseMemoryCache = false;
      try
      {
        paramString = new BitmapFactory.Options();
        paramString.inSampleSize = 4;
        paramString = BitmapFactory.decodeFile(str, paramString);
        if (paramString == null)
        {
          paramString = URLDrawableHelper.TRANSPARENT;
          localURLDrawableOptions.mLoadingDrawable = paramString;
          localURLDrawableOptions.mFailedDrawable = URLDrawableHelper.TRANSPARENT;
          localURLDrawableOptions.mUseAutoScaleParams = false;
          return URLDrawable.getDrawable(new File(str), localURLDrawableOptions);
        }
      }
      catch (Throwable paramString)
      {
        for (;;)
        {
          paramString.printStackTrace();
          paramString = null;
          continue;
          paramString = new BitmapDrawable(paramString);
        }
      }
      return null;
    }
    catch (Throwable paramString)
    {
      paramString.printStackTrace();
    }
  }
  
  @Nullable
  private HttpResponsePackage a(WebSoService.WebSoState paramWebSoState, HttpRsp paramHttpRsp, HttpResponsePackage paramHttpResponsePackage)
  {
    if (paramHttpRsp != null) {
      paramHttpResponsePackage = new HttpResponsePackage(paramHttpRsp);
    }
    for (;;)
    {
      if (paramHttpRsp == null)
      {
        paramWebSoState.jdField_a_of_type_Int = 10002;
        paramWebSoState.jdField_d_of_type_JavaLangString = "rsp is null";
        a(paramWebSoState);
        paramHttpResponsePackage = null;
      }
      return paramHttpResponsePackage;
    }
  }
  
  public static WebSoService a()
  {
    if (jdField_a_of_type_ComTencentMobileqqWebviewWebsoWebSoService == null) {}
    synchronized (jdField_a_of_type_JavaLangObject)
    {
      if (jdField_a_of_type_ComTencentMobileqqWebviewWebsoWebSoService == null) {
        jdField_a_of_type_ComTencentMobileqqWebviewWebsoWebSoService = new WebSoService();
      }
      return jdField_a_of_type_ComTencentMobileqqWebviewWebsoWebSoService;
    }
  }
  
  @NotNull
  private String a(WebSoService.WebSoState paramWebSoState, String paramString)
  {
    paramString = paramString.split(":")[1].trim();
    if (paramWebSoState.jdField_a_of_type_ComTencentMobileqqWebviewWebsoHybridWebReporter$HybridWebReportInfo.jdField_e_of_type_Int < 3) {
      paramWebSoState.jdField_a_of_type_ComTencentMobileqqWebviewWebsoHybridWebReporter$HybridWebReportInfo.jdField_e_of_type_Int = 3;
    }
    return paramString;
  }
  
  private static String a(JSONObject paramJSONObject, WebSoService.WebSoState paramWebSoState)
  {
    if (QLog.isColorLevel()) {
      QLog.d("WebSoService", 2, "updateHtml");
    }
    if ((paramWebSoState == null) || (paramWebSoState.jdField_c_of_type_JavaLangString == null) || (paramJSONObject == null))
    {
      if ((paramWebSoState != null) && (paramWebSoState.jdField_c_of_type_JavaLangString == null)) {
        QLog.w("WebSoService", 1, "template body is null!!!!");
      }
      if (paramJSONObject == null) {
        QLog.w("WebSoService", 1, "allJson is null, how possible!");
      }
      paramWebSoState = "";
    }
    String str;
    JSONObject localJSONObject;
    do
    {
      do
      {
        do
        {
          return paramWebSoState;
          if (QLog.isColorLevel()) {
            QLog.d("WebSoService", 2, "updateHtml data");
          }
          str = EncodingUtils.getString(paramWebSoState.jdField_c_of_type_JavaLangString.getBytes(), "UTF-8");
          paramWebSoState = str;
        } while (TextUtils.isEmpty(str));
        paramWebSoState = str;
      } while (!paramJSONObject.has("data"));
      localJSONObject = paramJSONObject.optJSONObject("data");
      paramWebSoState = str;
    } while (localJSONObject == null);
    Iterator localIterator = localJSONObject.keys();
    for (paramJSONObject = str;; paramJSONObject = paramJSONObject.replace(paramWebSoState, localJSONObject.optString(paramWebSoState)))
    {
      paramWebSoState = paramJSONObject;
      if (!localIterator.hasNext()) {
        break;
      }
      paramWebSoState = localIterator.next().toString();
    }
  }
  
  public static void a(Activity paramActivity, String paramString)
  {
    if (QVipSDKProcessor.c().jdField_c_of_type_Int <= 0) {}
    do
    {
      do
      {
        return;
        paramString = a(paramString);
      } while (paramString == null);
      paramActivity = paramActivity.findViewById(2131371065);
    } while (paramActivity == null);
    Drawable localDrawable = paramActivity.getBackground();
    paramActivity.setBackgroundDrawable(paramString);
    paramActivity.setAlpha(1.0F);
    paramActivity.setVisibility(0);
    paramActivity.postDelayed(new WebSoService.12(paramActivity, localDrawable), 2000L);
  }
  
  private static void a(Uri paramUri, WebSoService.WebSoState paramWebSoState, JSONObject paramJSONObject)
  {
    JSONObject localJSONObject = null;
    if (paramWebSoState.jdField_b_of_type_JavaUtilConcurrentAtomicAtomicInteger.get() != 1) {}
    Object localObject;
    for (;;)
    {
      return;
      try
      {
        long l = WebSoUtils.a();
        localObject = WebSoUtils.a(paramUri);
        if (!b().getString("templateTag_" + String.valueOf(l) + (String)localObject, "").equals(paramJSONObject.optString("template-tag")))
        {
          if (!QLog.isColorLevel()) {
            continue;
          }
          QLog.i("WebSoService", 2, "template has changed, so it can't use local refresh!");
        }
      }
      catch (Exception paramUri)
      {
        paramUri.printStackTrace();
        paramWebSoState.jdField_e_of_type_JavaLangString = "";
        return;
      }
    }
    paramUri = FileUtils.b(new File(WebSoUtils.d(paramUri) + "_data.txt"));
    if (!TextUtils.isEmpty(paramUri)) {}
    for (paramUri = new JSONObject(paramUri);; paramUri = null)
    {
      if (paramJSONObject.has("data")) {
        localJSONObject = paramJSONObject.optJSONObject("data");
      }
      paramJSONObject = new JSONObject();
      if ((localJSONObject != null) && (paramUri != null))
      {
        localObject = localJSONObject.keys();
        while (((Iterator)localObject).hasNext())
        {
          String str1 = ((Iterator)localObject).next().toString();
          String str2 = localJSONObject.optString(str1);
          if (QLog.isColorLevel()) {
            QLog.i("WebSoService", 2, "local check key: " + str1);
          }
          if (!TextUtils.isEmpty(str2)) {
            if (!paramUri.has(str1))
            {
              if (QLog.isColorLevel()) {
                QLog.i("WebSoService", 2, "local refresh key: " + str1);
              }
              paramJSONObject.put(str1, str2);
            }
            else if (!str2.equalsIgnoreCase(paramUri.optString(str1, "")))
            {
              if (QLog.isColorLevel()) {
                QLog.i("WebSoService", 2, "local refresh key: " + str1);
              }
              paramJSONObject.put(str1, str2);
            }
          }
        }
      }
      if (paramJSONObject.length() > 0)
      {
        paramJSONObject.put("local_refresh_time", System.currentTimeMillis());
        paramWebSoState.jdField_e_of_type_JavaLangString = paramJSONObject.toString();
        return;
      }
      if (QLog.isColorLevel()) {
        QLog.i("WebSoService", 2, "no local refresh data.");
      }
      paramWebSoState.jdField_e_of_type_JavaLangString = "";
      return;
    }
  }
  
  private void a(Uri paramUri, String paramString, File paramFile, WebSoService.WebSoState paramWebSoState, WebSoService.CallBack paramCallBack)
  {
    ThreadManager.getFileThreadHandler().post(new WebSoService.3(this, paramFile, paramString, paramCallBack, paramUri));
  }
  
  private void a(Bundle paramBundle, WebSoService.WebSoState paramWebSoState, HttpResponsePackage paramHttpResponsePackage, String paramString1, Uri paramUri, String paramString2, String paramString3, String paramString4)
  {
    if (TextUtils.isEmpty(paramString3))
    {
      if (QLog.isDebugVersion()) {
        QLog.i("WebSoService", 1, "webso etag=" + paramString2 + ",url=" + paramBundle.getString("url"));
      }
      a(paramHttpResponsePackage, paramString2, paramString4, paramUri, paramWebSoState);
      paramWebSoState.jdField_b_of_type_JavaLangString = paramString1;
      paramWebSoState.jdField_a_of_type_Boolean = true;
      paramWebSoState.f = false;
      a(paramWebSoState);
      return;
    }
    c(paramWebSoState, paramString1, paramUri, paramString2, paramString3, paramString4);
  }
  
  private void a(Handler paramHandler, WebSoService.WebSoState paramWebSoState)
  {
    if ((paramHandler == null) || (paramWebSoState == null)) {
      return;
    }
    Bundle localBundle = new Bundle();
    localBundle.putBoolean("key_rsp_succeed", paramWebSoState.jdField_d_of_type_Boolean);
    localBundle.putString("url", paramWebSoState.jdField_a_of_type_JavaLangString);
    localBundle.putBoolean("need_force_refresh", paramWebSoState.jdField_a_of_type_Boolean);
    localBundle.putBoolean("need_local_refresh", paramWebSoState.g);
    localBundle.putString("key_html_changed_data", paramWebSoState.jdField_e_of_type_JavaLangString);
    localBundle.putBoolean("key_wns_cache_hit", paramWebSoState.jdField_c_of_type_Boolean);
    if ((paramWebSoState.jdField_c_of_type_Boolean) && (TextUtils.isEmpty(paramWebSoState.jdField_b_of_type_JavaLangString)))
    {
      paramWebSoState.jdField_b_of_type_JavaLangString = WebSoUtils.d(paramWebSoState.jdField_a_of_type_JavaLangString);
      if (!TextUtils.isEmpty(paramWebSoState.jdField_b_of_type_JavaLangString)) {
        paramWebSoState.f = true;
      }
    }
    localBundle.putBoolean("is_local_data", paramWebSoState.f);
    localBundle.putString("wns_proxy_http_data", paramWebSoState.jdField_b_of_type_JavaLangString);
    localBundle.putInt("result_code", paramWebSoState.jdField_a_of_type_Int);
    localBundle.putString("error_message", paramWebSoState.jdField_d_of_type_JavaLangString);
    localBundle.putInt("req_state", paramWebSoState.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger.get());
    localBundle.putBoolean("is_silent_mode", paramWebSoState.jdField_e_of_type_Boolean);
    localBundle.putParcelable("key_webso_3", paramWebSoState.jdField_a_of_type_ComTencentMobileqqWebviewWebsoWebSoService$WebSoState$WebSo3);
    WebSoUtils.a("send webso3 " + paramWebSoState.jdField_a_of_type_ComTencentMobileqqWebviewWebsoWebSoService$WebSoState$WebSo3.toString());
    paramWebSoState = paramHandler.obtainMessage(203);
    paramWebSoState.obj = localBundle;
    paramHandler.sendMessage(paramWebSoState);
  }
  
  /* Error */
  public static void a(View paramView, String paramString)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore_3
    //   2: aload_0
    //   3: invokevirtual 510	android/view/View:getMeasuredWidth	()I
    //   6: aload_0
    //   7: invokevirtual 513	android/view/View:getHeight	()I
    //   10: getstatic 519	android/graphics/Bitmap$Config:ARGB_8888	Landroid/graphics/Bitmap$Config;
    //   13: invokestatic 525	android/graphics/Bitmap:createBitmap	(IILandroid/graphics/Bitmap$Config;)Landroid/graphics/Bitmap;
    //   16: astore 4
    //   18: aload_0
    //   19: new 527	android/graphics/Canvas
    //   22: dup
    //   23: aload 4
    //   25: invokespecial 528	android/graphics/Canvas:<init>	(Landroid/graphics/Bitmap;)V
    //   28: invokevirtual 532	android/view/View:draw	(Landroid/graphics/Canvas;)V
    //   31: aload 4
    //   33: invokestatic 538	cooperation/qzone/util/GifAntishakeModule:getDhash	(Landroid/graphics/Bitmap;)Ljava/lang/String;
    //   36: astore_0
    //   37: aload_0
    //   38: getstatic 26	com/tencent/mobileqq/webview/webso/WebSoService:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   41: invokestatic 542	cooperation/qzone/util/GifAntishakeModule:getDistance	(Ljava/lang/String;Ljava/lang/String;)I
    //   44: istore_2
    //   45: new 308	java/lang/StringBuilder
    //   48: dup
    //   49: invokespecial 309	java/lang/StringBuilder:<init>	()V
    //   52: ldc_w 544
    //   55: invokevirtual 315	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   58: aload_0
    //   59: invokevirtual 315	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   62: ldc_w 546
    //   65: invokevirtual 315	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   68: getstatic 26	com/tencent/mobileqq/webview/webso/WebSoService:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   71: invokevirtual 315	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   74: ldc_w 548
    //   77: invokevirtual 315	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   80: iload_2
    //   81: invokevirtual 551	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   84: invokevirtual 320	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   87: invokestatic 489	com/tencent/mobileqq/webview/webso/WebSoUtils:a	(Ljava/lang/String;)V
    //   90: aload_0
    //   91: ldc_w 553
    //   94: invokevirtual 331	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   97: ifne +128 -> 225
    //   100: aload_0
    //   101: putstatic 26	com/tencent/mobileqq/webview/webso/WebSoService:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   104: new 555	java/io/FileOutputStream
    //   107: dup
    //   108: aload_1
    //   109: invokestatic 53	com/tencent/mobileqq/webview/webso/WebSoUtils:b	(Ljava/lang/String;)Ljava/lang/String;
    //   112: invokespecial 556	java/io/FileOutputStream:<init>	(Ljava/lang/String;)V
    //   115: astore_1
    //   116: aload_1
    //   117: astore_0
    //   118: aload_1
    //   119: astore_3
    //   120: aload 4
    //   122: getstatic 562	android/graphics/Bitmap$CompressFormat:JPEG	Landroid/graphics/Bitmap$CompressFormat;
    //   125: bipush 70
    //   127: aload_1
    //   128: invokevirtual 566	android/graphics/Bitmap:compress	(Landroid/graphics/Bitmap$CompressFormat;ILjava/io/OutputStream;)Z
    //   131: pop
    //   132: aload_1
    //   133: astore_0
    //   134: aload_1
    //   135: astore_3
    //   136: aload_1
    //   137: invokevirtual 569	java/io/FileOutputStream:close	()V
    //   140: aload_1
    //   141: astore_0
    //   142: aload_1
    //   143: astore_3
    //   144: aload 4
    //   146: invokevirtual 572	android/graphics/Bitmap:recycle	()V
    //   149: aload_1
    //   150: astore_0
    //   151: aload_1
    //   152: astore_3
    //   153: ldc_w 574
    //   156: invokestatic 489	com/tencent/mobileqq/webview/webso/WebSoUtils:a	(Ljava/lang/String;)V
    //   159: aload_1
    //   160: ifnull +7 -> 167
    //   163: aload_1
    //   164: invokevirtual 569	java/io/FileOutputStream:close	()V
    //   167: return
    //   168: astore_1
    //   169: aconst_null
    //   170: astore_3
    //   171: aload_3
    //   172: astore_0
    //   173: ldc 176
    //   175: iconst_1
    //   176: aload_1
    //   177: invokevirtual 577	java/lang/Throwable:getMessage	()Ljava/lang/String;
    //   180: invokestatic 579	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   183: aload_3
    //   184: ifnull -17 -> 167
    //   187: aload_3
    //   188: invokevirtual 569	java/io/FileOutputStream:close	()V
    //   191: return
    //   192: astore_0
    //   193: return
    //   194: astore_0
    //   195: aload_3
    //   196: astore_1
    //   197: aload_1
    //   198: ifnull +7 -> 205
    //   201: aload_1
    //   202: invokevirtual 569	java/io/FileOutputStream:close	()V
    //   205: aload_0
    //   206: athrow
    //   207: astore_0
    //   208: return
    //   209: astore_1
    //   210: goto -5 -> 205
    //   213: astore_3
    //   214: aload_0
    //   215: astore_1
    //   216: aload_3
    //   217: astore_0
    //   218: goto -21 -> 197
    //   221: astore_1
    //   222: goto -51 -> 171
    //   225: aconst_null
    //   226: astore_1
    //   227: goto -87 -> 140
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	230	0	paramView	View
    //   0	230	1	paramString	String
    //   44	37	2	i	int
    //   1	195	3	str	String
    //   213	4	3	localObject	Object
    //   16	129	4	localBitmap	android.graphics.Bitmap
    // Exception table:
    //   from	to	target	type
    //   2	116	168	java/lang/Throwable
    //   187	191	192	java/io/IOException
    //   2	116	194	finally
    //   163	167	207	java/io/IOException
    //   201	205	209	java/io/IOException
    //   120	132	213	finally
    //   136	140	213	finally
    //   144	149	213	finally
    //   153	159	213	finally
    //   173	183	213	finally
    //   120	132	221	java/lang/Throwable
    //   136	140	221	java/lang/Throwable
    //   144	149	221	java/lang/Throwable
    //   153	159	221	java/lang/Throwable
  }
  
  public static void a(CustomWebView paramCustomWebView)
  {
    if (QVipSDKProcessor.c().jdField_c_of_type_Int <= 0) {
      return;
    }
    paramCustomWebView.post(new WebSoService.13(paramCustomWebView));
  }
  
  private static void a(HttpResponsePackage paramHttpResponsePackage, String paramString1, String paramString2, Uri paramUri, WebSoService.WebSoState paramWebSoState)
  {
    ThreadManager.getFileThreadHandler().post(new WebSoService.10(paramHttpResponsePackage, paramUri, paramString1, paramString2, paramWebSoState));
  }
  
  private void a(WebSoService.WebSoState paramWebSoState, Uri paramUri)
  {
    paramWebSoState.jdField_a_of_type_Int = 10503;
    paramWebSoState.jdField_c_of_type_Boolean = false;
    paramWebSoState.jdField_a_of_type_Boolean = true;
    WebSoUtils.b(paramUri);
    a(paramWebSoState);
  }
  
  private void a(WebSoService.WebSoState paramWebSoState, HttpResponsePackage paramHttpResponsePackage, Uri paramUri, String paramString1, String paramString2)
  {
    WebSoUtils.a("result = json");
    paramWebSoState.jdField_a_of_type_ComTencentMobileqqWebviewWebsoWebSoService$WebSoState$WebSo3.jdField_a_of_type_Boolean = true;
    paramWebSoState.jdField_a_of_type_ComTencentMobileqqWebviewWebsoWebSoService$WebSoState$WebSo3.jdField_a_of_type_JavaLangString = paramString1;
    paramWebSoState.jdField_a_of_type_ComTencentMobileqqWebviewWebsoWebSoService$WebSoState$WebSo3.jdField_b_of_type_JavaLangString = paramString2;
    paramWebSoState.jdField_a_of_type_ComTencentMobileqqWebviewWebsoWebSoService$WebSoState$WebSo3.jdField_c_of_type_JavaLangString = paramHttpResponsePackage.jdField_d_of_type_JavaLangString;
    paramWebSoState.jdField_a_of_type_ComTencentMobileqqWebviewWebsoWebSoService$WebSoState$WebSo3.jdField_d_of_type_JavaLangString = paramUri.toString();
    paramWebSoState.jdField_a_of_type_ComTencentMobileqqWebviewWebsoWebSoService$WebSoState$WebSo3.jdField_e_of_type_JavaLangString = "webso-data-json";
    paramWebSoState.jdField_c_of_type_Boolean = true;
    paramWebSoState.jdField_a_of_type_ComTencentMobileqqWebviewWebsoHybridWebReporter$HybridWebReportInfo.jdField_c_of_type_Boolean = true;
    paramWebSoState.jdField_a_of_type_ComTencentMobileqqWebviewWebsoHybridWebReporter$HybridWebReportInfo.j = "json";
    a(paramWebSoState);
  }
  
  private void a(WebSoService.WebSoState paramWebSoState, HttpResponsePackage paramHttpResponsePackage, String paramString1, Uri paramUri, String paramString2, String paramString3, String paramString4, String paramString5)
  {
    paramWebSoState.jdField_e_of_type_Boolean = true;
    paramWebSoState.jdField_a_of_type_Boolean = false;
    paramWebSoState.f = false;
    String str = "{\"code\":-1,\"data\":null}";
    try
    {
      JSONObject localJSONObject1 = new JSONObject(paramString1).optJSONObject("data");
      JSONObject localJSONObject2 = new JSONObject();
      localJSONObject2.put("code", 1);
      localJSONObject2.put("data", localJSONObject1);
      localJSONObject2.put("type", paramString2);
      paramString2 = localJSONObject2.toString();
      paramWebSoState.jdField_b_of_type_JavaLangString = paramString2;
      a(paramWebSoState);
      if (TextUtils.isEmpty(paramString4))
      {
        a(paramHttpResponsePackage, paramString3, paramString5, paramUri, paramWebSoState);
        paramWebSoState.jdField_e_of_type_Boolean = false;
        return;
      }
    }
    catch (JSONException paramString2)
    {
      for (;;)
      {
        paramString2.printStackTrace();
        paramString2 = str;
      }
      System.currentTimeMillis();
      a(paramString1, paramString3, paramString5, paramString4, paramUri, paramWebSoState, true, new WebSoService.6(this, paramWebSoState));
    }
  }
  
  private void a(WebSoService.WebSoState paramWebSoState, String paramString)
  {
    try
    {
      paramWebSoState.jdField_a_of_type_ComTencentMobileqqWebviewWebsoHybridWebReporter$HybridWebReportInfo.jdField_d_of_type_JavaLangString = paramString.trim();
      return;
    }
    catch (Exception paramWebSoState)
    {
      paramWebSoState.printStackTrace();
    }
  }
  
  private void a(WebSoService.WebSoState paramWebSoState, String paramString1, Uri paramUri, String paramString2, String paramString3, String paramString4)
  {
    if (TextUtils.isEmpty(paramString3))
    {
      paramWebSoState.jdField_b_of_type_JavaLangString = paramString1;
      paramWebSoState.jdField_a_of_type_Boolean = true;
      paramWebSoState.f = false;
      paramWebSoState.jdField_a_of_type_ComTencentMobileqqWebviewWebsoHybridWebReporter$HybridWebReportInfo.jdField_d_of_type_Int = 0;
      paramWebSoState.jdField_a_of_type_ComTencentMobileqqWebviewWebsoHybridWebReporter$HybridWebReportInfo.jdField_c_of_type_Int = 0;
      a(paramWebSoState);
    }
    for (;;)
    {
      WebSoUtils.a(paramUri);
      return;
      a(paramString1, paramString2, paramString4, paramString3, paramUri, paramWebSoState, false, new WebSoService.5(this, paramWebSoState, System.currentTimeMillis()));
    }
  }
  
  private void a(WebSoService.WebSoState paramWebSoState, String[] paramArrayOfString, Uri paramUri, String paramString1, String paramString2, boolean paramBoolean)
  {
    if (paramBoolean)
    {
      WebSoUtils.a("result = 304");
      paramWebSoState.jdField_a_of_type_ComTencentMobileqqWebviewWebsoWebSoService$WebSoState$WebSo3.jdField_a_of_type_Boolean = true;
      paramWebSoState.jdField_a_of_type_ComTencentMobileqqWebviewWebsoWebSoService$WebSoState$WebSo3.jdField_a_of_type_JavaLangString = paramString1;
      paramWebSoState.jdField_a_of_type_ComTencentMobileqqWebviewWebsoWebSoService$WebSoState$WebSo3.jdField_b_of_type_JavaLangString = paramString2;
      paramWebSoState.jdField_a_of_type_ComTencentMobileqqWebviewWebsoWebSoService$WebSoState$WebSo3.jdField_c_of_type_JavaLangString = ("\"" + paramArrayOfString[0] + "\"");
      paramWebSoState.jdField_a_of_type_ComTencentMobileqqWebviewWebsoWebSoService$WebSoState$WebSo3.jdField_d_of_type_JavaLangString = paramUri.toString();
      paramWebSoState.jdField_a_of_type_ComTencentMobileqqWebviewWebsoWebSoService$WebSoState$WebSo3.jdField_e_of_type_JavaLangString = "webso-304";
      paramWebSoState.jdField_c_of_type_Boolean = true;
      paramWebSoState.jdField_a_of_type_ComTencentMobileqqWebviewWebsoHybridWebReporter$HybridWebReportInfo.jdField_c_of_type_Boolean = true;
      paramWebSoState.jdField_a_of_type_ComTencentMobileqqWebviewWebsoHybridWebReporter$HybridWebReportInfo.j = "304";
      a(paramWebSoState);
      return;
    }
    QLog.i("WebSoService", 1, "now 304,so return! ");
    paramWebSoState.jdField_c_of_type_Boolean = true;
    paramWebSoState.jdField_a_of_type_ComTencentMobileqqWebviewWebsoHybridWebReporter$HybridWebReportInfo.jdField_c_of_type_Boolean = true;
    a(paramWebSoState);
  }
  
  public static void a(String paramString1, String paramString2, String paramString3, Uri paramUri)
  {
    ThreadManager.getFileThreadHandler().post(new WebSoService.11(paramString1, paramUri, paramString2, paramString3));
  }
  
  public static void a(String paramString1, String paramString2, String paramString3, String paramString4, Uri paramUri, WebSoService.WebSoState paramWebSoState, boolean paramBoolean, WebSoService.CallBack paramCallBack)
  {
    ThreadManager.getFileThreadHandler().post(new WebSoService.9(paramString1, paramString2, paramString3, paramString4, paramUri, paramWebSoState, paramBoolean, paramCallBack));
  }
  
  private void a(boolean paramBoolean, Bundle paramBundle)
  {
    String str = paramBundle.getString("url");
    if (TextUtils.isEmpty(str)) {
      return;
    }
    WebSoService.WebSoState localWebSoState = (WebSoService.WebSoState)this.jdField_a_of_type_AndroidSupportV4UtilLruCache.get(WebSoUtils.a(str));
    localWebSoState.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger.set(2);
    localWebSoState.jdField_a_of_type_Int = 0;
    HttpRsp localHttpRsp = (HttpRsp)paramBundle.getSerializable("rsp_data");
    Bundle localBundle = new Bundle();
    if ((localHttpRsp == null) || (!paramBoolean)) {
      localBundle.putBoolean("key_rsp_succeed", false);
    }
    for (;;)
    {
      a(paramBoolean, paramBundle, localWebSoState);
      QLog.i("WebSoService", 1, "onGetHttpData succed(" + paramBoolean + "), url:" + Util.c(str, new String[0]));
      return;
      localBundle.putBoolean("key_rsp_succeed", true);
      localBundle.putString("url", paramBundle.getString("url"));
    }
  }
  
  private boolean a(WebSoService.WebSoState paramWebSoState, String paramString1, String[] paramArrayOfString, Uri paramUri, String paramString2, String paramString3, String paramString4)
  {
    boolean bool = "json".equals(paramString4);
    if (!bool) {
      b(paramUri.toString());
    }
    WebSoUtils.a("receive header : " + Arrays.toString(paramArrayOfString));
    WebSoUtils.a("receive data : " + paramString1);
    if (bool) {
      WebSoUtils.a("receive contentType = " + paramString4 + "  pageVersion = " + paramString3 + " etag = " + paramString2);
    }
    paramWebSoState.jdField_a_of_type_ComTencentMobileqqWebviewWebsoHybridWebReporter$HybridWebReportInfo.jdField_b_of_type_Long = paramString1.length();
    return bool;
  }
  
  private static boolean a(JSONObject paramJSONObject, Uri paramUri, WebSoService.WebSoState paramWebSoState, boolean paramBoolean)
  {
    Object localObject2 = WebSoUtils.d(paramUri);
    bool2 = true;
    if ((paramJSONObject == null) || (TextUtils.isEmpty((CharSequence)localObject2)))
    {
      bool2 = false;
      return bool2;
    }
    bool1 = bool2;
    paramUri = paramWebSoState;
    String str;
    Object localObject1;
    if (paramJSONObject.has("template"))
    {
      str = paramJSONObject.optString("template", "");
      localObject1 = paramWebSoState;
      if (paramWebSoState == null) {
        localObject1 = new WebSoService.WebSoState();
      }
      if (TextUtils.isEmpty(str)) {
        break label638;
      }
      ((WebSoService.WebSoState)localObject1).jdField_c_of_type_JavaLangString = str;
      bool1 = bool2;
      paramUri = (Uri)localObject1;
      if (!paramBoolean) {}
    }
    for (;;)
    {
      try
      {
        WebSoUtils.a(str.getBytes(), (String)localObject2 + "_template.txt");
        paramUri = (Uri)localObject1;
        bool1 = bool2;
      }
      catch (OutOfMemoryError paramUri)
      {
        if (!QLog.isColorLevel()) {
          continue;
        }
        QLog.d("WebSoService", 2, "html is too large, OutOfMemoryError");
        VipUtils.a(null, "webview_report", "0X8006511", "0X8006511", 3, 1, null);
        bool1 = false;
        paramUri = (Uri)localObject1;
        continue;
      }
      catch (Exception paramUri)
      {
        if (!QLog.isColorLevel()) {
          continue;
        }
        QLog.d("WebSoService", 2, "template is exception=" + paramUri.getMessage());
        bool1 = false;
        paramUri = (Uri)localObject1;
        continue;
      }
      bool2 = bool1;
      if (!paramJSONObject.has("diff")) {
        break;
      }
      paramJSONObject = paramJSONObject.optString("diff", "");
      bool2 = bool1;
      if (TextUtils.isEmpty(paramJSONObject)) {
        break;
      }
      WebSoUtils.a(Base64.b(paramJSONObject.getBytes()), (String)localObject2 + ".patch");
      paramWebSoState = new File((String)localObject2 + "_template.txt");
      bool2 = bool1;
      if (!paramWebSoState.exists()) {}
      try
      {
        paramWebSoState.createNewFile();
        bool2 = bool1;
      }
      catch (IOException paramJSONObject)
      {
        bool2 = false;
        paramJSONObject.printStackTrace();
        continue;
      }
      localObject1 = new File((String)localObject2 + ".patch");
      bool1 = bool2;
      if (!((File)localObject1).exists()) {}
      try
      {
        ((File)localObject1).createNewFile();
        bool1 = bool2;
      }
      catch (IOException paramJSONObject)
      {
        bool1 = false;
        paramJSONObject.printStackTrace();
        continue;
      }
      localObject2 = new File((String)localObject2 + "_compose.txt");
      bool2 = bool1;
      if (!((File)localObject2).exists()) {}
      try
      {
        ((File)localObject2).createNewFile();
        bool2 = bool1;
      }
      catch (IOException paramJSONObject)
      {
        long l;
        bool2 = false;
        paramJSONObject.printStackTrace();
        continue;
      }
      bool1 = bool2;
      if (bool2)
      {
        l = System.currentTimeMillis();
        bool1 = BspatchUtil.a(paramWebSoState.getAbsolutePath(), ((File)localObject1).getAbsolutePath(), ((File)localObject2).getAbsolutePath());
        if (QLog.isColorLevel()) {
          QLog.d("WebSoService", 2, "patch file cost=" + (System.currentTimeMillis() - l));
        }
        paramJSONObject = paramUri;
        if (paramUri == null) {
          paramJSONObject = new WebSoService.WebSoState();
        }
        bool2 = bool1;
        if (bool1)
        {
          paramWebSoState.delete();
          ((File)localObject2).renameTo(paramWebSoState.getAbsoluteFile());
        }
      }
      try
      {
        paramJSONObject.jdField_c_of_type_JavaLangString = FileUtils.b(paramWebSoState);
        bool2 = bool1;
      }
      catch (IOException paramUri)
      {
        paramUri.printStackTrace();
        bool2 = false;
        continue;
      }
      bool1 = bool2;
      if (!bool2)
      {
        paramWebSoState.delete();
        ((File)localObject1).delete();
        ((File)localObject2).delete();
        paramJSONObject.jdField_c_of_type_JavaLangString = null;
        bool1 = bool2;
      }
      if (((File)localObject1).exists()) {
        ((File)localObject1).delete();
      }
      if (((File)localObject2).exists()) {
        ((File)localObject2).delete();
      }
      bool2 = bool1;
      if (paramBoolean) {
        break;
      }
      paramWebSoState.delete();
      return bool1;
      label638:
      bool1 = false;
      paramUri = (Uri)localObject1;
    }
  }
  
  private boolean a(boolean paramBoolean, Bundle paramBundle, WebSoService.WebSoState paramWebSoState)
  {
    if (paramWebSoState.jdField_a_of_type_ComTencentMobileqqWebviewWebsoHybridWebReporter$HybridWebReportInfo == null)
    {
      paramWebSoState.jdField_a_of_type_ComTencentMobileqqWebviewWebsoHybridWebReporter$HybridWebReportInfo = new HybridWebReporter.HybridWebReportInfo();
      paramWebSoState.jdField_a_of_type_ComTencentMobileqqWebviewWebsoHybridWebReporter$HybridWebReportInfo.jdField_a_of_type_Long = WebSoUtils.a();
      paramWebSoState.jdField_a_of_type_ComTencentMobileqqWebviewWebsoHybridWebReporter$HybridWebReportInfo.jdField_a_of_type_JavaLangString = paramWebSoState.jdField_a_of_type_JavaLangString;
      paramWebSoState.jdField_a_of_type_ComTencentMobileqqWebviewWebsoHybridWebReporter$HybridWebReportInfo.jdField_a_of_type_Boolean = true;
    }
    if (!paramBoolean) {
      paramWebSoState.jdField_a_of_type_ComTencentMobileqqWebviewWebsoHybridWebReporter$HybridWebReportInfo.jdField_f_of_type_Int = 1;
    }
    paramWebSoState.jdField_a_of_type_ComTencentMobileqqWebviewWebsoHybridWebReporter$HybridWebReportInfo.jdField_e_of_type_JavaLangString = paramBundle.getString("key_user_ip");
    paramWebSoState.jdField_a_of_type_ComTencentMobileqqWebviewWebsoHybridWebReporter$HybridWebReportInfo.h = paramBundle.getString("key_dns_result");
    paramWebSoState.jdField_a_of_type_ComTencentMobileqqWebviewWebsoHybridWebReporter$HybridWebReportInfo.jdField_f_of_type_JavaLangString = paramBundle.getString("key_server_ip");
    paramWebSoState.jdField_a_of_type_ComTencentMobileqqWebviewWebsoHybridWebReporter$HybridWebReportInfo.g = paramBundle.getString("key_server_port");
    paramWebSoState.jdField_a_of_type_ComTencentMobileqqWebviewWebsoHybridWebReporter$HybridWebReportInfo.jdField_a_of_type_Int = paramBundle.getInt("key_time_cost");
    paramWebSoState.jdField_a_of_type_ComTencentMobileqqWebviewWebsoHybridWebReporter$HybridWebReportInfo.jdField_b_of_type_Int = paramBundle.getInt("rsp_code");
    paramWebSoState.jdField_a_of_type_ComTencentMobileqqWebviewWebsoHybridWebReporter$HybridWebReportInfo.jdField_c_of_type_Int = 2;
    paramWebSoState.jdField_a_of_type_ComTencentMobileqqWebviewWebsoHybridWebReporter$HybridWebReportInfo.i = paramBundle.getString("key_detail_info");
    paramWebSoState.jdField_e_of_type_Boolean = false;
    paramWebSoState.jdField_a_of_type_ComTencentMobileqqWebviewWebsoWebSoService$WebSoState$WebSo3.a();
    if (!paramBoolean)
    {
      paramWebSoState.jdField_a_of_type_Int = 10001;
      if (!TextUtils.isEmpty(paramWebSoState.jdField_b_of_type_JavaLangString)) {
        paramWebSoState.jdField_c_of_type_Boolean = true;
      }
      a(paramWebSoState);
      return true;
    }
    paramWebSoState.jdField_a_of_type_ComTencentMobileqqWebviewWebsoHybridWebReporter$HybridWebReportInfo.a();
    return false;
  }
  
  private static SharedPreferences b()
  {
    return BaseApplicationImpl.getContext().getSharedPreferences("wns_html_etags", 0);
  }
  
  @NotNull
  private String b(WebSoService.WebSoState paramWebSoState, String paramString)
  {
    paramString = paramString.split(":")[1].trim();
    if (paramWebSoState.jdField_a_of_type_ComTencentMobileqqWebviewWebsoHybridWebReporter$HybridWebReportInfo.jdField_e_of_type_Int < 3) {
      paramWebSoState.jdField_a_of_type_ComTencentMobileqqWebviewWebsoHybridWebReporter$HybridWebReportInfo.jdField_e_of_type_Int = 3;
    }
    return paramString;
  }
  
  private static String b(String paramString1, String paramString2, String paramString3, String paramString4, Uri paramUri, WebSoService.WebSoState paramWebSoState, boolean paramBoolean)
  {
    String str6 = "";
    if (paramUri == null) {
      return "";
    }
    int i = 1;
    String str2 = "";
    String str3 = str2;
    String str4 = str2;
    String str5 = str2;
    String str1;
    for (;;)
    {
      try
      {
        localJSONObject = new JSONObject(paramString1);
        str3 = str2;
        str4 = str2;
        str5 = str2;
        l = System.currentTimeMillis();
        str3 = str2;
        str4 = str2;
        str5 = str2;
        if (!a(localJSONObject, paramUri, paramWebSoState, paramBoolean)) {
          continue;
        }
        str3 = str2;
        str4 = str2;
        str5 = str2;
        if (QLog.isColorLevel())
        {
          str3 = str2;
          str4 = str2;
          str5 = str2;
          QLog.d("WebSoService", 2, "composeDiffFile cost=" + (System.currentTimeMillis() - l));
        }
        str3 = str2;
        str4 = str2;
        str5 = str2;
        if (paramWebSoState.jdField_c_of_type_JavaLangString == null)
        {
          str3 = str2;
          str4 = str2;
          str5 = str2;
          if (localJSONObject.has("template-tag"))
          {
            str3 = str2;
            str4 = str2;
            str5 = str2;
            paramString1 = WebSoUtils.d(paramUri);
            str3 = str2;
            str4 = str2;
            str5 = str2;
            paramString1 = new File(paramString1 + "_template.txt");
            str3 = str2;
            str4 = str2;
            str5 = str2;
            l = WebSoUtils.a();
            str3 = str2;
            str4 = str2;
            str5 = str2;
            str1 = WebSoUtils.a(paramUri);
            str3 = str2;
            str4 = str2;
            str5 = str2;
            str1 = b().getString("templateTag_" + String.valueOf(l) + str1, "");
            str3 = str2;
            str4 = str2;
            str5 = str2;
            str6 = localJSONObject.optString("template-tag");
            str3 = str2;
            str4 = str2;
            str5 = str2;
            if (!str1.equals(str6)) {
              continue;
            }
            str3 = str2;
            str4 = str2;
            str5 = str2;
            if (!paramString1.exists()) {
              continue;
            }
            str3 = str2;
            str4 = str2;
            str5 = str2;
            QLog.w("WebSoService", 1, "html template is null, now read from " + paramString1.getPath());
            str3 = str2;
            str4 = str2;
            str5 = str2;
            paramWebSoState.jdField_c_of_type_JavaLangString = FileUtils.b(paramString1);
          }
        }
      }
      catch (JSONException paramString1)
      {
        JSONObject localJSONObject;
        i = 0;
        str1 = "";
        paramString1.printStackTrace();
        paramString1 = str3;
        continue;
        str3 = str2;
        str4 = str2;
        str5 = str2;
        if (paramString1.exists()) {
          continue;
        }
        str3 = str2;
        str4 = str2;
        str5 = str2;
        QLog.w("WebSoService", 1, " template file is not exits!");
        continue;
      }
      catch (Exception paramString1)
      {
        long l;
        i = 0;
        str1 = "";
        paramString1.printStackTrace();
        paramString1 = str4;
        continue;
        int j = 0;
        continue;
        str3 = str2;
        str4 = str2;
        str5 = str2;
        QLog.e("WebSoService", 1, "check html data fail cost=" + (System.currentTimeMillis() - l));
        i = 0;
        str1 = "";
        str3 = str2;
        str4 = str2;
        str5 = str2;
        WebSoUtils.a(paramUri);
        paramString1 = str2;
        continue;
      }
      catch (OutOfMemoryError paramString1)
      {
        if (!QLog.isColorLevel()) {
          continue;
        }
        QLog.d("WebSoService", 2, "storeDiffData is OutOfMemoryError");
        paramString1.printStackTrace();
        VipUtils.a(null, "webview_report", "0X8006511", "0X8006511", 2, 1, null);
        paramString1 = str5;
        i = 0;
        str1 = "";
        continue;
        paramWebSoState.putString("eTag_" + str2 + paramUri, "");
        paramWebSoState.putString("pageVersion_" + str2 + paramUri, paramString3);
        paramWebSoState.putString("templateTag_" + str2 + paramUri, "");
        paramWebSoState.putString("htmlSha1_" + str2 + paramUri, "");
        continue;
        paramWebSoState.apply();
      }
      str3 = str2;
      str4 = str2;
      str5 = str2;
      l = System.currentTimeMillis();
      str3 = str2;
      str4 = str2;
      str5 = str2;
      paramString1 = a(localJSONObject, paramWebSoState);
      str3 = str2;
      str4 = str2;
      str5 = str2;
      if (QLog.isColorLevel())
      {
        str3 = str2;
        str4 = str2;
        str5 = str2;
        QLog.d("WebSoService", 2, "updateHtml cost=" + (System.currentTimeMillis() - l));
      }
      j = i;
      str6 = paramString1;
      str3 = str2;
      str4 = str2;
      str5 = str2;
      if (TextUtils.isEmpty(paramString1))
      {
        str3 = str2;
        str4 = str2;
        str5 = str2;
        QLog.w("WebSoService", 1, "htmlContent is null! " + localJSONObject.toString());
        str6 = paramString1;
        j = i;
      }
      paramString1 = str2;
      i = j;
      str1 = str6;
      if (j != 0)
      {
        paramString1 = str2;
        i = j;
        str1 = str6;
        str3 = str2;
        str4 = str2;
        str5 = str2;
        if (!TextUtils.isEmpty(str6))
        {
          paramString1 = str2;
          i = j;
          str1 = str6;
          str3 = str2;
          str4 = str2;
          str5 = str2;
          if (localJSONObject.has("html-sha1"))
          {
            str3 = str2;
            str4 = str2;
            str5 = str2;
            str2 = localJSONObject.optString("html-sha1", "");
            str3 = str2;
            str4 = str2;
            str5 = str2;
            l = System.currentTimeMillis();
            str3 = str2;
            str4 = str2;
            str5 = str2;
            if (!SHA1Util.a(str6).equals(str2)) {
              continue;
            }
            str3 = str2;
            str4 = str2;
            str5 = str2;
            if (QLog.isColorLevel())
            {
              str3 = str2;
              str4 = str2;
              str5 = str2;
              QLog.d("WebSoService", 2, "check html data success cost=" + (System.currentTimeMillis() - l));
            }
            str3 = str2;
            str4 = str2;
            str5 = str2;
            a(paramUri, paramWebSoState, localJSONObject);
            paramString1 = str2;
            i = j;
            str1 = str6;
            if (paramBoolean)
            {
              str3 = str2;
              str4 = str2;
              str5 = str2;
              WebSoUtils.a(str6.getBytes(), WebSoUtils.b(paramUri));
              paramString1 = str2;
              i = j;
              str1 = str6;
              str3 = str2;
              str4 = str2;
              str5 = str2;
              if (paramWebSoState.jdField_b_of_type_JavaUtilConcurrentAtomicAtomicInteger.get() == 1)
              {
                paramString1 = str2;
                i = j;
                str1 = str6;
                str3 = str2;
                str4 = str2;
                str5 = str2;
                if (localJSONObject.has("data"))
                {
                  str3 = str2;
                  str4 = str2;
                  str5 = str2;
                  paramString1 = localJSONObject.optJSONObject("data");
                  str3 = str2;
                  str4 = str2;
                  str5 = str2;
                  paramWebSoState = WebSoUtils.d(paramUri) + "_data.txt";
                  str3 = str2;
                  str4 = str2;
                  str5 = str2;
                  WebSoUtils.a(paramString1.toString().getBytes(), paramWebSoState);
                  str1 = str6;
                  i = j;
                  paramString1 = str2;
                }
              }
            }
          }
        }
      }
      paramWebSoState = b().edit();
      str2 = String.valueOf(WebSoUtils.a());
      paramUri = WebSoUtils.a(paramUri);
      if ((i == 0) || (!paramBoolean)) {
        continue;
      }
      paramWebSoState.putString("eTag_" + str2 + paramUri, paramString2);
      paramWebSoState.putString("pageVersion_" + str2 + paramUri, paramString3);
      paramWebSoState.putString("templateTag_" + str2 + paramUri, paramString4);
      paramWebSoState.putString("htmlSha1_" + str2 + paramUri, paramString1);
      if (Build.VERSION.SDK_INT >= 9) {
        continue;
      }
      paramWebSoState.commit();
      return str1;
      str3 = str2;
      str4 = str2;
      str5 = str2;
      if (str1.equals(str6)) {
        continue;
      }
      str3 = str2;
      str4 = str2;
      str5 = str2;
      QLog.w("WebSoService", 1, "I have no idea how to handle this situation! " + str1 + " vs new tag: " + str6);
    }
    return str1;
  }
  
  private void b(WebSoService.WebSoState paramWebSoState, HttpResponsePackage paramHttpResponsePackage, String paramString1, Uri paramUri, String paramString2, String paramString3, String paramString4, String paramString5)
  {
    if ((a(paramWebSoState.jdField_a_of_type_JavaLangString)) && (paramWebSoState.jdField_a_of_type_ArrayOfBoolean != null) && (paramWebSoState.jdField_a_of_type_ArrayOfBoolean.length > 0) && (paramWebSoState.jdField_a_of_type_ArrayOfBoolean[0] != 0))
    {
      paramWebSoState.jdField_e_of_type_Boolean = true;
      paramWebSoState.jdField_a_of_type_Boolean = false;
      paramWebSoState.f = false;
    }
    try
    {
      JSONObject localJSONObject1 = new JSONObject(paramString1).optJSONObject("data");
      JSONObject localJSONObject2 = new JSONObject();
      localJSONObject2.put("code", 1);
      localJSONObject2.put("data", localJSONObject1);
      localJSONObject2.put("type", paramString2);
      paramWebSoState.jdField_b_of_type_JavaLangString = localJSONObject2.toString();
      a(paramWebSoState);
      if (TextUtils.isEmpty(paramString4))
      {
        a(paramHttpResponsePackage, paramString3, paramString5, paramUri, paramWebSoState);
        paramWebSoState.jdField_e_of_type_Boolean = false;
        paramWebSoState.jdField_b_of_type_JavaLangString = paramString1;
        paramWebSoState.jdField_a_of_type_Boolean = false;
        paramWebSoState.f = false;
        a(paramWebSoState);
        return;
      }
    }
    catch (Exception paramString2)
    {
      for (;;)
      {
        paramString2.printStackTrace();
      }
      b(paramWebSoState, paramString1, paramUri, paramString3, paramString4, paramString5);
    }
  }
  
  private void b(WebSoService.WebSoState paramWebSoState, String paramString1, Uri paramUri, String paramString2, String paramString3, String paramString4)
  {
    a(paramString1, paramString2, paramString4, paramString3, paramUri, paramWebSoState, true, new WebSoService.7(this, paramWebSoState, System.currentTimeMillis()));
  }
  
  private static void b(String paramString)
  {
    FileUtils.a(WebSoUtils.b(paramString), false);
  }
  
  private void c(WebSoService.WebSoState paramWebSoState, String paramString1, Uri paramUri, String paramString2, String paramString3, String paramString4)
  {
    a(paramString1, paramString2, paramString4, paramString3, paramUri, paramWebSoState, true, new WebSoService.8(this, paramWebSoState, System.currentTimeMillis()));
  }
  
  public String a(String paramString)
  {
    if (this.jdField_a_of_type_JavaUtilHashMap.containsKey(paramString)) {
      return (String)this.jdField_a_of_type_JavaUtilHashMap.get(paramString);
    }
    return null;
  }
  
  public String a(String paramString, Handler paramHandler)
  {
    return a(paramString, paramHandler, null);
  }
  
  public String a(String paramString, Handler paramHandler, boolean[] paramArrayOfBoolean)
  {
    WebSoService.WebSoState localWebSoState = (WebSoService.WebSoState)this.jdField_a_of_type_AndroidSupportV4UtilLruCache.get(WebSoUtils.a(paramString));
    if (!TextUtils.isEmpty(localWebSoState.jdField_a_of_type_JavaLangString))
    {
      if (QLog.isColorLevel()) {
        QLog.d("WebSoService", 2, "QonzeWnsProxyService getProxyData命中缓存，reqState:" + localWebSoState.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger);
      }
      localWebSoState.jdField_a_of_type_ArrayOfBoolean = paramArrayOfBoolean;
      if (localWebSoState.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger.get() == 2) {
        a(paramHandler, localWebSoState);
      }
    }
    for (;;)
    {
      return localWebSoState.jdField_b_of_type_JavaLangString;
      if (localWebSoState.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger.get() == 1)
      {
        localWebSoState.jdField_a_of_type_JavaLangRefWeakReference = new WeakReference(paramHandler);
        if (localWebSoState.jdField_b_of_type_Boolean)
        {
          localWebSoState.f = true;
          a(paramHandler, localWebSoState);
        }
        else
        {
          ThreadManager.getFileThreadHandler().post(new WebSoService.4(this, localWebSoState, paramString, paramHandler));
          return null;
        }
      }
      else
      {
        a(paramString, paramHandler);
        continue;
        if (QLog.isColorLevel()) {
          QLog.d("WebSoService", 2, "QonzeWnsProxyService getProxyData未命中缓存，reqState:" + localWebSoState.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger);
        }
        localWebSoState.jdField_a_of_type_ArrayOfBoolean = paramArrayOfBoolean;
        a(paramString, paramHandler);
      }
    }
  }
  
  public void a()
  {
    this.jdField_a_of_type_AndroidSupportV4UtilLruCache.evictAll();
  }
  
  public void a(WebSoService.WebSoState paramWebSoState)
  {
    Handler localHandler;
    if ((paramWebSoState != null) && (paramWebSoState.jdField_a_of_type_JavaLangRefWeakReference != null) && (paramWebSoState.jdField_a_of_type_JavaLangRefWeakReference.get() != null))
    {
      localHandler = (Handler)paramWebSoState.jdField_a_of_type_JavaLangRefWeakReference.get();
      if (localHandler != null) {}
    }
    else
    {
      return;
    }
    a(localHandler, paramWebSoState);
    paramWebSoState.jdField_a_of_type_JavaLangRefWeakReference = null;
    HybridWebReporter.a().a(paramWebSoState.jdField_a_of_type_ComTencentMobileqqWebviewWebsoHybridWebReporter$HybridWebReportInfo);
  }
  
  public void a(String paramString)
  {
    if (this.jdField_a_of_type_JavaUtilHashMap.containsKey(paramString)) {
      this.jdField_a_of_type_JavaUtilHashMap.remove(paramString);
    }
  }
  
  public void a(String paramString, Handler paramHandler)
  {
    if (TextUtils.isEmpty(paramString)) {}
    while (!WebSoUtils.a(Uri.parse(paramString))) {
      return;
    }
    a(paramString, paramHandler);
  }
  
  public void a(String paramString1, String paramString2)
  {
    this.jdField_a_of_type_JavaUtilHashMap.put(paramString1, paramString2);
  }
  
  public void a(boolean paramBoolean, Bundle paramBundle, WebSoService.WebSoState paramWebSoState)
  {
    if (a(paramBoolean, paramBundle, paramWebSoState)) {}
    HttpResponsePackage localHttpResponsePackage;
    String str2;
    do
    {
      do
      {
        return;
        localObject1 = (HttpRsp)paramBundle.getSerializable("rsp_data");
        localHttpResponsePackage = a(paramWebSoState, (HttpRsp)localObject1, null);
      } while (localHttpResponsePackage == null);
      localObject1 = ((HttpRsp)localObject1).rspinfo;
      i = ((String)localObject1).indexOf("\r\n\r\n");
      str2 = localHttpResponsePackage.jdField_d_of_type_JavaLangString;
    } while (i < 1);
    String[] arrayOfString = ((String)localObject1).substring(0, i - 1).split("\r\n");
    Uri localUri = Uri.parse(paramBundle.getString("url"));
    Object localObject1 = arrayOfString[0].split(" ");
    if (localObject1.length >= 2) {
      a(paramWebSoState, localObject1[1]);
    }
    paramWebSoState.jdField_c_of_type_Boolean = false;
    localObject1 = null;
    Object localObject4 = null;
    Object localObject2 = null;
    Object localObject3 = null;
    String str1 = null;
    int j = arrayOfString.length;
    int i = 0;
    if (i < j)
    {
      String str3 = arrayOfString[i].toLowerCase();
      Object localObject8;
      Object localObject7;
      Object localObject6;
      Object localObject5;
      if (str3.contains("cache-offline"))
      {
        localObject8 = str3.split(":")[1].trim();
        localObject7 = localObject2;
        localObject6 = localObject3;
        localObject5 = localObject4;
      }
      for (;;)
      {
        i += 1;
        localObject4 = localObject5;
        localObject3 = localObject6;
        localObject2 = localObject7;
        localObject1 = localObject8;
        break;
        if (str3.contains("etag"))
        {
          localObject5 = str3.split(":")[1].trim();
          localObject6 = localObject3;
          localObject7 = localObject2;
          localObject8 = localObject1;
        }
        else if (str3.contains("template-tag"))
        {
          localObject7 = str3.split(":")[1].trim();
          localObject5 = localObject4;
          localObject6 = localObject3;
          localObject8 = localObject1;
        }
        else if (str3.contains("webso-page-version"))
        {
          localObject6 = b(paramWebSoState, str3);
          localObject5 = localObject4;
          localObject7 = localObject2;
          localObject8 = localObject1;
        }
        else
        {
          localObject5 = localObject4;
          localObject6 = localObject3;
          localObject7 = localObject2;
          localObject8 = localObject1;
          if (str3.contains("webso-content-type"))
          {
            str1 = a(paramWebSoState, str3);
            localObject5 = localObject4;
            localObject6 = localObject3;
            localObject7 = localObject2;
            localObject8 = localObject1;
          }
        }
      }
    }
    paramBoolean = a(paramWebSoState, str2, arrayOfString, localUri, localObject4, localObject3, str1);
    if (arrayOfString[0].contains("304"))
    {
      a(paramWebSoState, arrayOfString, localUri, localObject4, localObject3, paramBoolean);
      return;
    }
    if ("http".equals(localObject1))
    {
      QLog.i("WebSoService", 1, "now 503, so start reLoadUrl");
      a(paramWebSoState, localUri);
      return;
    }
    if (paramBoolean)
    {
      a(paramWebSoState, localHttpResponsePackage, localUri, localObject4, localObject3);
      return;
    }
    if ("true".equals(localObject1))
    {
      a(paramBundle, paramWebSoState, localHttpResponsePackage, str2, localUri, localObject4, localObject2, localObject3);
      return;
    }
    if ("store".equals(localObject1))
    {
      b(paramWebSoState, localHttpResponsePackage, str2, localUri, (String)localObject1, localObject4, localObject2, localObject3);
      return;
    }
    if ("silent".equals(localObject1))
    {
      a(paramWebSoState, localHttpResponsePackage, str2, localUri, (String)localObject1, localObject4, localObject2, localObject3);
      return;
    }
    if ((localObject1 == null) || ("false".equals(localObject1)))
    {
      a(paramWebSoState, str2, localUri, localObject4, localObject2, localObject3);
      return;
    }
    WebSoUtils.a(localUri);
    paramWebSoState.jdField_b_of_type_JavaLangString = str2;
    paramWebSoState.jdField_a_of_type_Boolean = true;
    paramWebSoState.f = false;
    a(paramWebSoState);
  }
  
  public boolean a(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {}
    do
    {
      return false;
      paramString = Uri.parse(paramString);
    } while ((paramString == null) || (!new File(WebSoUtils.b(paramString)).exists()));
    return true;
  }
  
  public boolean a(String paramString, Handler paramHandler)
  {
    return a(paramString, paramHandler, false);
  }
  
  public boolean a(String paramString, Handler paramHandler, boolean paramBoolean)
  {
    if (TextUtils.isEmpty(paramString))
    {
      if (QLog.isColorLevel()) {
        QLog.d("WebSoService", 2, "do not need startWebSoRequest, url=" + paramString);
      }
      return false;
    }
    WebSoUtils.a("startWebSoRequest");
    a(paramString);
    WebSoService.WebSoState localWebSoState = (WebSoService.WebSoState)this.jdField_a_of_type_AndroidSupportV4UtilLruCache.get(WebSoUtils.a(paramString));
    localWebSoState.jdField_a_of_type_JavaLangString = paramString;
    localWebSoState.f = false;
    localWebSoState.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger.set(1);
    localWebSoState.jdField_a_of_type_Boolean = false;
    localWebSoState.jdField_c_of_type_Boolean = false;
    localWebSoState.jdField_a_of_type_ComTencentMobileqqWebviewWebsoHybridWebReporter$HybridWebReportInfo = new HybridWebReporter.HybridWebReportInfo();
    localWebSoState.jdField_a_of_type_ComTencentMobileqqWebviewWebsoHybridWebReporter$HybridWebReportInfo.jdField_a_of_type_Long = WebSoUtils.a();
    localWebSoState.jdField_a_of_type_ComTencentMobileqqWebviewWebsoHybridWebReporter$HybridWebReportInfo.jdField_a_of_type_JavaLangString = paramString;
    localWebSoState.jdField_a_of_type_ComTencentMobileqqWebviewWebsoHybridWebReporter$HybridWebReportInfo.jdField_a_of_type_Boolean = true;
    localWebSoState.jdField_a_of_type_ComTencentMobileqqWebviewWebsoHybridWebReporter$HybridWebReportInfo.jdField_d_of_type_Boolean = false;
    localWebSoState.jdField_a_of_type_ComTencentMobileqqWebviewWebsoHybridWebReporter$HybridWebReportInfo.a();
    localWebSoState.jdField_a_of_type_ComTencentMobileqqWebviewWebsoWebSoService$WebSoState$WebSo3.a();
    if (WebSoUtils.a(paramString))
    {
      localWebSoState.jdField_b_of_type_JavaUtilConcurrentAtomicAtomicInteger.set(1);
      localWebSoState.g = false;
      localWebSoState.jdField_e_of_type_JavaLangString = "";
    }
    while (WebSoUtils.e(paramString))
    {
      return false;
      localWebSoState.jdField_b_of_type_JavaUtilConcurrentAtomicAtomicInteger.set(0);
    }
    long l = WebSoUtils.a();
    String str2 = QUA.getQUA3();
    String str1 = WebSoUtils.a();
    Object localObject2 = "";
    Object localObject1 = "";
    Object localObject3 = Uri.parse(paramString);
    if (localObject3 != null)
    {
      String str3 = String.valueOf(l);
      Object localObject4 = b();
      String str4 = WebSoUtils.a((Uri)localObject3);
      localObject2 = ((SharedPreferences)localObject4).getString("eTag_" + str3 + str4, "");
      localObject1 = ((SharedPreferences)localObject4).getString("pageVersion_" + str3 + str4, "");
      str3 = ((SharedPreferences)localObject4).getString("htmlSha1_" + str3 + str4, "");
      localObject4 = new File(WebSoUtils.b((Uri)localObject3));
      if ((TextUtils.isEmpty(str3)) || (!((File)localObject4).exists())) {
        break label790;
      }
      a((Uri)localObject3, str3, (File)localObject4, localWebSoState, new WebSoService.2(this, System.currentTimeMillis(), localWebSoState, paramHandler, paramString));
    }
    for (;;)
    {
      localObject3 = new JSONObject();
      try
      {
        ((JSONObject)localObject3).put("if_None_Match", localObject2);
        if (!TextUtils.isEmpty((CharSequence)localObject1)) {
          ((JSONObject)localObject3).put("web_page_version", localObject1);
        }
        ((JSONObject)localObject3).put("uri", paramString);
        localObject1 = SwiftBrowserCookieMonster.c(paramString);
        ((JSONObject)localObject3).put("cookie", (String)localObject1 + "; qua=" + str2 + "; ");
        ((JSONObject)localObject3).put("no_Chunked", "true");
        ((JSONObject)localObject3).put("accept_Encoding", "identity");
        if (paramBoolean) {
          ((JSONObject)localObject3).put("x_wns_ispreload_request", "1");
        }
        localObject1 = new HttpRequestPackage(str1, (JSONObject)localObject3);
        if (Build.VERSION.SDK_INT >= 17) {
          localObject2 = new JSONObject();
        }
      }
      catch (Exception localException1)
      {
        try
        {
          ((JSONObject)localObject2).put("webso", "3.0");
          ((HttpRequestPackage)localObject1).addHeader(((JSONObject)localObject2).toString());
          WebSoUtils.a("send header = " + ((HttpRequestPackage)localObject1).getHeaderString());
          localObject1 = new HttpReq(EnumHttpMethod.convert("e" + ((HttpRequestPackage)localObject1).method).value(), ((HttpRequestPackage)localObject1).getHeaderString(), ((HttpRequestPackage)localObject1).getBodyString(), ((HttpRequestPackage)localObject1).host);
          if (paramHandler != null) {
            localWebSoState.jdField_a_of_type_JavaLangRefWeakReference = new WeakReference(paramHandler);
          }
          paramHandler = new NewIntent(BaseApplicationImpl.getContext(), WebSoServlet.class);
          WebSoServlet.a(paramHandler, l, paramString, (HttpReq)localObject1, "");
          if (!this.jdField_a_of_type_Boolean)
          {
            BaseApplicationImpl.getApplication().getRuntime().registObserver(this);
            this.jdField_a_of_type_Boolean = true;
          }
          BaseApplicationImpl.getApplication().getRuntime().startServlet(paramHandler);
          WebSoUtils.a("startServlet req");
          return true;
          label790:
          if (QLog.isColorLevel()) {
            QLog.d("WebSoService", 2, "set eTag to get all data");
          }
          localObject2 = "";
          localObject1 = "";
          VipUtils.a(null, "webview_report", "0X8006566", "0X8006566", 0, 0, new String[] { paramString });
          continue;
          localException1 = localException1;
          localException1.printStackTrace();
        }
        catch (Exception localException2)
        {
          for (;;)
          {
            localException2.printStackTrace();
          }
        }
      }
    }
  }
  
  public void onReceive(int paramInt, boolean paramBoolean, Bundle paramBundle)
  {
    if (paramInt == 100) {
      a(paramBoolean, paramBundle);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.webview.webso.WebSoService
 * JD-Core Version:    0.7.0.1
 */