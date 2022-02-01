package com.tencent.mobileqq.webview.swift.component;

import android.app.Activity;
import android.app.Dialog;
import android.content.BroadcastReceiver;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler.Callback;
import android.os.Message;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.util.Pair;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
import com.tencent.biz.AuthorizeConfig;
import com.tencent.biz.pubaccount.CustomWebView;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.jsp.X5ApiPlugin;
import com.tencent.mobileqq.msf.sdk.MsfSdkUtils;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.util.Utils;
import com.tencent.mobileqq.vaswebviewplugin.VasBaseWebviewUtil;
import com.tencent.mobileqq.webprocess.WebAccelerateHelper;
import com.tencent.mobileqq.webview.swift.WebViewPluginEngine;
import com.tencent.mobileqq.webview.swift.WebViewProvider;
import com.tencent.mobileqq.webview.swift.injector.ISwiftBrowserTBSInjector;
import com.tencent.mobileqq.webview.swift.injector.SwiftBrowserTBSInjectorUtil;
import com.tencent.mobileqq.webview.util.ITbsDownloader;
import com.tencent.mobileqq.webview.webso.SHA1Util;
import com.tencent.open.temp.api.IWebViewOpenSdkApi;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.smtt.sdk.QbSdk;
import com.tencent.smtt.sdk.TbsDownloader;
import com.tencent.smtt.sdk.WebSettings;
import com.tencent.smtt.sdk.WebView;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Locale;
import java.util.Map;
import java.util.Set;
import mqq.app.AppRuntime;
import mqq.os.MqqHandler;
import org.json.JSONObject;

public class SwiftBrowserTBSHandler
  extends SwiftBrowserComponentsProvider.SwiftBrowserComponent
  implements Handler.Callback
{
  private static ISwiftBrowserTBSInjector jdField_a_of_type_ComTencentMobileqqWebviewSwiftInjectorISwiftBrowserTBSInjector = ;
  long jdField_a_of_type_Long = 0L;
  Activity jdField_a_of_type_AndroidAppActivity;
  Dialog jdField_a_of_type_AndroidAppDialog = null;
  BroadcastReceiver jdField_a_of_type_AndroidContentBroadcastReceiver;
  WebViewProvider jdField_a_of_type_ComTencentMobileqqWebviewSwiftWebViewProvider;
  Boolean jdField_a_of_type_JavaLangBoolean = Boolean.valueOf(false);
  final Object jdField_a_of_type_JavaLangObject = new Object();
  String jdField_a_of_type_JavaLangString = null;
  private HashSet<String> jdField_a_of_type_JavaUtilHashSet;
  MqqHandler jdField_a_of_type_MqqOsMqqHandler = null;
  boolean jdField_a_of_type_Boolean = false;
  
  private static Pair<Integer, Integer> a(String paramString)
  {
    boolean bool = TextUtils.isEmpty(paramString);
    int j = 0;
    if (!bool)
    {
      paramString = Uri.parse(paramString);
      if (paramString.isHierarchical())
      {
        paramString = paramString.getHost();
        if ((!TextUtils.isEmpty(paramString)) && (AuthorizeConfig.a().j(paramString)))
        {
          j = BaseApplication.getContext().getResources().getDisplayMetrics().widthPixels;
          i = BaseApplication.getContext().getResources().getDisplayMetrics().heightPixels;
          if (!paramString.contains("cmshow"))
          {
            i -= Utils.a(54.0F, BaseApplication.getContext().getResources());
            break label102;
          }
          break label102;
        }
      }
    }
    int i = 0;
    label102:
    return new Pair(Integer.valueOf(j), Integer.valueOf(i));
  }
  
  private ITbsDownloader a(AppRuntime paramAppRuntime)
  {
    if ((paramAppRuntime instanceof ITbsDownloader)) {
      return (ITbsDownloader)paramAppRuntime;
    }
    return null;
  }
  
  public static void a(String paramString, WebView paramWebView)
  {
    ThreadManager.post(new SwiftBrowserTBSHandler.9(paramString, paramWebView), 5, null, true);
  }
  
  private static void b(WebView paramWebView, String paramString1, String paramString2)
  {
    Object localObject = a(paramString1);
    int i = ((Integer)((Pair)localObject).first).intValue();
    int j = ((Integer)((Pair)localObject).second).intValue();
    if ((i > 0) && (j > 0) && (paramWebView != null))
    {
      if (paramWebView.getX5WebViewExtension() == null) {
        return;
      }
      if (TextUtils.isEmpty(paramString2)) {
        localObject = "";
      } else {
        localObject = SHA1Util.a(paramString2);
      }
      ThreadManager.getUIHandler().post(new SwiftBrowserTBSHandler.10(paramString2, paramString1, paramWebView, i, j, (String)localObject));
    }
  }
  
  /* Error */
  public Object a(String paramString, Bundle paramBundle)
  {
    // Byte code:
    //   0: aload_0
    //   1: getfield 198	com/tencent/mobileqq/webview/swift/component/SwiftBrowserTBSHandler:jdField_a_of_type_AndroidAppActivity	Landroid/app/Activity;
    //   4: ifnonnull +5 -> 9
    //   7: aconst_null
    //   8: areturn
    //   9: ldc 200
    //   11: aload_1
    //   12: invokevirtual 204	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   15: ifeq +13 -> 28
    //   18: ldc 206
    //   20: iconst_1
    //   21: ldc 208
    //   23: invokestatic 214	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   26: aconst_null
    //   27: areturn
    //   28: ldc 216
    //   30: aload_1
    //   31: invokevirtual 204	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   34: ifeq +214 -> 248
    //   37: aload_2
    //   38: ifnonnull +5 -> 43
    //   41: aconst_null
    //   42: areturn
    //   43: aload_2
    //   44: ldc 218
    //   46: invokevirtual 223	android/os/Bundle:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   49: astore 16
    //   51: aload_2
    //   52: ldc 225
    //   54: invokevirtual 223	android/os/Bundle:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   57: astore 17
    //   59: aload_2
    //   60: ldc 227
    //   62: invokevirtual 223	android/os/Bundle:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   65: astore_1
    //   66: aload_0
    //   67: aload 17
    //   69: putfield 54	com/tencent/mobileqq/webview/swift/component/SwiftBrowserTBSHandler:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   72: aload_1
    //   73: ifnull +173 -> 246
    //   76: aload 16
    //   78: ifnull +168 -> 246
    //   81: ldc 229
    //   83: invokestatic 235	com/tencent/mobileqq/qroute/QRoute:api	(Ljava/lang/Class;)Lcom/tencent/mobileqq/qroute/QRouteApi;
    //   86: checkcast 229	com/tencent/open/temp/api/IWebViewOpenSdkApi
    //   89: aload_1
    //   90: invokeinterface 239 2 0
    //   95: checkcast 241	com/tencent/open/downloadnew/DownloadInfo
    //   98: astore_2
    //   99: aload_2
    //   100: ifnull +128 -> 228
    //   103: aload_2
    //   104: getfield 243	com/tencent/open/downloadnew/DownloadInfo:d	Ljava/lang/String;
    //   107: astore 17
    //   109: new 220	android/os/Bundle
    //   112: dup
    //   113: invokespecial 244	android/os/Bundle:<init>	()V
    //   116: astore_2
    //   117: aload_2
    //   118: getstatic 248	com/tencent/open/downloadnew/DownloadConstants:b	Ljava/lang/String;
    //   121: aload_1
    //   122: invokevirtual 252	android/os/Bundle:putString	(Ljava/lang/String;Ljava/lang/String;)V
    //   125: aload_2
    //   126: getstatic 254	com/tencent/open/downloadnew/DownloadConstants:j	Ljava/lang/String;
    //   129: aload 17
    //   131: invokevirtual 252	android/os/Bundle:putString	(Ljava/lang/String;Ljava/lang/String;)V
    //   134: aload_2
    //   135: getstatic 257	com/tencent/open/downloadnew/DownloadConstants:k	Ljava/lang/String;
    //   138: iconst_2
    //   139: invokevirtual 261	android/os/Bundle:putInt	(Ljava/lang/String;I)V
    //   142: aload_2
    //   143: getstatic 264	com/tencent/open/downloadnew/DownloadConstants:l	Ljava/lang/String;
    //   146: aload 16
    //   148: invokevirtual 252	android/os/Bundle:putString	(Ljava/lang/String;Ljava/lang/String;)V
    //   151: aload_2
    //   152: getstatic 267	com/tencent/open/downloadnew/DownloadConstants:s	Ljava/lang/String;
    //   155: iconst_0
    //   156: invokevirtual 271	android/os/Bundle:putBoolean	(Ljava/lang/String;Z)V
    //   159: aload_2
    //   160: getstatic 274	com/tencent/open/downloadnew/DownloadConstants:y	Ljava/lang/String;
    //   163: iconst_0
    //   164: invokevirtual 271	android/os/Bundle:putBoolean	(Ljava/lang/String;Z)V
    //   167: getstatic 277	com/tencent/open/downloadnew/DownloadConstants:m	Ljava/lang/String;
    //   170: astore 16
    //   172: new 279	java/lang/StringBuilder
    //   175: dup
    //   176: invokespecial 280	java/lang/StringBuilder:<init>	()V
    //   179: astore 17
    //   181: aload 17
    //   183: ldc_w 282
    //   186: invokevirtual 286	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   189: pop
    //   190: aload 17
    //   192: aload_1
    //   193: invokevirtual 286	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   196: pop
    //   197: aload_2
    //   198: aload 16
    //   200: aload 17
    //   202: invokevirtual 289	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   205: invokevirtual 252	android/os/Bundle:putString	(Ljava/lang/String;Ljava/lang/String;)V
    //   208: ldc 229
    //   210: invokestatic 235	com/tencent/mobileqq/qroute/QRoute:api	(Ljava/lang/Class;)Lcom/tencent/mobileqq/qroute/QRouteApi;
    //   213: checkcast 229	com/tencent/open/temp/api/IWebViewOpenSdkApi
    //   216: aload_0
    //   217: getfield 198	com/tencent/mobileqq/webview/swift/component/SwiftBrowserTBSHandler:jdField_a_of_type_AndroidAppActivity	Landroid/app/Activity;
    //   220: aload_2
    //   221: invokeinterface 293 3 0
    //   226: aload_1
    //   227: areturn
    //   228: new 295	com/tencent/mobileqq/webview/swift/component/SwiftBrowserTBSHandler$3
    //   231: dup
    //   232: aload_0
    //   233: aload_1
    //   234: aload 16
    //   236: invokespecial 298	com/tencent/mobileqq/webview/swift/component/SwiftBrowserTBSHandler$3:<init>	(Lcom/tencent/mobileqq/webview/swift/component/SwiftBrowserTBSHandler;Ljava/lang/String;Ljava/lang/String;)V
    //   239: bipush 8
    //   241: aconst_null
    //   242: iconst_1
    //   243: invokestatic 154	com/tencent/mobileqq/app/ThreadManager:post	(Ljava/lang/Runnable;ILcom/tencent/mobileqq/app/ThreadExcutor$IThreadListener;Z)V
    //   246: aload_1
    //   247: areturn
    //   248: ldc_w 300
    //   251: aload_1
    //   252: invokevirtual 204	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   255: ifeq +85 -> 340
    //   258: aload_2
    //   259: ldc_w 302
    //   262: invokevirtual 223	android/os/Bundle:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   265: astore_1
    //   266: ldc 229
    //   268: invokestatic 235	com/tencent/mobileqq/qroute/QRoute:api	(Ljava/lang/Class;)Lcom/tencent/mobileqq/qroute/QRouteApi;
    //   271: checkcast 229	com/tencent/open/temp/api/IWebViewOpenSdkApi
    //   274: aload_1
    //   275: invokeinterface 305 2 0
    //   280: ifne +8 -> 288
    //   283: iconst_0
    //   284: invokestatic 48	java/lang/Boolean:valueOf	(Z)Ljava/lang/Boolean;
    //   287: areturn
    //   288: ldc 229
    //   290: invokestatic 235	com/tencent/mobileqq/qroute/QRoute:api	(Ljava/lang/Class;)Lcom/tencent/mobileqq/qroute/QRouteApi;
    //   293: checkcast 229	com/tencent/open/temp/api/IWebViewOpenSdkApi
    //   296: astore_2
    //   297: new 279	java/lang/StringBuilder
    //   300: dup
    //   301: invokespecial 280	java/lang/StringBuilder:<init>	()V
    //   304: astore 16
    //   306: aload 16
    //   308: ldc_w 282
    //   311: invokevirtual 286	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   314: pop
    //   315: aload 16
    //   317: aload_1
    //   318: invokevirtual 286	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   321: pop
    //   322: aload_2
    //   323: aload_1
    //   324: aload 16
    //   326: invokevirtual 289	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   329: iconst_1
    //   330: invokeinterface 309 4 0
    //   335: iconst_1
    //   336: invokestatic 48	java/lang/Boolean:valueOf	(Z)Ljava/lang/Boolean;
    //   339: areturn
    //   340: ldc_w 311
    //   343: aload_1
    //   344: invokevirtual 204	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   347: ifeq +89 -> 436
    //   350: aload_2
    //   351: ldc_w 302
    //   354: invokevirtual 223	android/os/Bundle:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   357: astore_1
    //   358: ldc 229
    //   360: invokestatic 235	com/tencent/mobileqq/qroute/QRoute:api	(Ljava/lang/Class;)Lcom/tencent/mobileqq/qroute/QRouteApi;
    //   363: checkcast 229	com/tencent/open/temp/api/IWebViewOpenSdkApi
    //   366: aload_1
    //   367: invokeinterface 239 2 0
    //   372: checkcast 241	com/tencent/open/downloadnew/DownloadInfo
    //   375: astore_1
    //   376: aload_1
    //   377: ifnonnull +8 -> 385
    //   380: iconst_0
    //   381: invokestatic 131	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   384: areturn
    //   385: aload_1
    //   386: invokevirtual 313	com/tencent/open/downloadnew/DownloadInfo:a	()I
    //   389: istore_3
    //   390: iload_3
    //   391: iconst_2
    //   392: if_icmpeq +39 -> 431
    //   395: iload_3
    //   396: iconst_3
    //   397: if_icmpeq +29 -> 426
    //   400: iload_3
    //   401: iconst_4
    //   402: if_icmpeq +19 -> 421
    //   405: iload_3
    //   406: bipush 10
    //   408: if_icmpeq +8 -> 416
    //   411: iconst_0
    //   412: invokestatic 131	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   415: areturn
    //   416: iconst_5
    //   417: invokestatic 131	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   420: areturn
    //   421: iconst_3
    //   422: invokestatic 131	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   425: areturn
    //   426: iconst_2
    //   427: invokestatic 131	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   430: areturn
    //   431: iconst_1
    //   432: invokestatic 131	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   435: areturn
    //   436: ldc_w 315
    //   439: aload_1
    //   440: invokevirtual 204	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   443: ifeq +112 -> 555
    //   446: aload_2
    //   447: ldc_w 302
    //   450: invokevirtual 223	android/os/Bundle:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   453: astore_1
    //   454: ldc 229
    //   456: invokestatic 235	com/tencent/mobileqq/qroute/QRoute:api	(Ljava/lang/Class;)Lcom/tencent/mobileqq/qroute/QRouteApi;
    //   459: checkcast 229	com/tencent/open/temp/api/IWebViewOpenSdkApi
    //   462: aload_1
    //   463: invokeinterface 239 2 0
    //   468: checkcast 241	com/tencent/open/downloadnew/DownloadInfo
    //   471: astore_2
    //   472: aload_2
    //   473: ifnull +77 -> 550
    //   476: aload_2
    //   477: invokevirtual 313	com/tencent/open/downloadnew/DownloadInfo:a	()I
    //   480: iconst_4
    //   481: if_icmpeq +6 -> 487
    //   484: goto +66 -> 550
    //   487: new 220	android/os/Bundle
    //   490: dup
    //   491: invokespecial 244	android/os/Bundle:<init>	()V
    //   494: astore_2
    //   495: aload_2
    //   496: getstatic 248	com/tencent/open/downloadnew/DownloadConstants:b	Ljava/lang/String;
    //   499: aload_1
    //   500: invokevirtual 252	android/os/Bundle:putString	(Ljava/lang/String;Ljava/lang/String;)V
    //   503: aload_2
    //   504: getstatic 257	com/tencent/open/downloadnew/DownloadConstants:k	Ljava/lang/String;
    //   507: iconst_5
    //   508: invokevirtual 261	android/os/Bundle:putInt	(Ljava/lang/String;I)V
    //   511: aload_2
    //   512: getstatic 267	com/tencent/open/downloadnew/DownloadConstants:s	Ljava/lang/String;
    //   515: iconst_0
    //   516: invokevirtual 271	android/os/Bundle:putBoolean	(Ljava/lang/String;Z)V
    //   519: aload_2
    //   520: getstatic 274	com/tencent/open/downloadnew/DownloadConstants:y	Ljava/lang/String;
    //   523: iconst_0
    //   524: invokevirtual 271	android/os/Bundle:putBoolean	(Ljava/lang/String;Z)V
    //   527: ldc 229
    //   529: invokestatic 235	com/tencent/mobileqq/qroute/QRoute:api	(Ljava/lang/Class;)Lcom/tencent/mobileqq/qroute/QRouteApi;
    //   532: checkcast 229	com/tencent/open/temp/api/IWebViewOpenSdkApi
    //   535: aload_0
    //   536: getfield 198	com/tencent/mobileqq/webview/swift/component/SwiftBrowserTBSHandler:jdField_a_of_type_AndroidAppActivity	Landroid/app/Activity;
    //   539: aload_2
    //   540: invokeinterface 293 3 0
    //   545: iconst_1
    //   546: invokestatic 48	java/lang/Boolean:valueOf	(Z)Ljava/lang/Boolean;
    //   549: areturn
    //   550: iconst_0
    //   551: invokestatic 48	java/lang/Boolean:valueOf	(Z)Ljava/lang/Boolean;
    //   554: areturn
    //   555: ldc_w 317
    //   558: aload_1
    //   559: invokevirtual 204	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   562: ifeq +49 -> 611
    //   565: aload_0
    //   566: getfield 320	com/tencent/mobileqq/webview/swift/component/SwiftBrowserTBSHandler:jdField_a_of_type_ComTencentMobileqqWebviewSwiftComponentSwiftBrowserComponentsProvider$SwiftBrowserComponentContext	Lcom/tencent/mobileqq/webview/swift/component/SwiftBrowserComponentsProvider$SwiftBrowserComponentContext;
    //   569: invokeinterface 325 1 0
    //   574: iconst_2
    //   575: invokevirtual 330	com/tencent/mobileqq/webview/swift/component/SwiftBrowserComponentsProvider:a	(I)Ljava/lang/Object;
    //   578: checkcast 332	com/tencent/mobileqq/webview/swift/component/SwiftBrowserUIStyleHandler
    //   581: astore_1
    //   582: aload_1
    //   583: ifnull +26 -> 609
    //   586: aload_1
    //   587: getfield 335	com/tencent/mobileqq/webview/swift/component/SwiftBrowserUIStyleHandler:jdField_a_of_type_ComTencentMobileqqWebviewSwiftSwiftBrowserUIStyle	Lcom/tencent/mobileqq/webview/swift/SwiftBrowserUIStyle;
    //   590: iconst_1
    //   591: putfield 340	com/tencent/mobileqq/webview/swift/SwiftBrowserUIStyle:z	Z
    //   594: invokestatic 343	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   597: ifeq +12 -> 609
    //   600: ldc 206
    //   602: iconst_2
    //   603: ldc_w 345
    //   606: invokestatic 214	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   609: aconst_null
    //   610: areturn
    //   611: ldc_w 347
    //   614: aload_1
    //   615: invokevirtual 204	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   618: ifeq +410 -> 1028
    //   621: invokestatic 343	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   624: ifeq +12 -> 636
    //   627: ldc 206
    //   629: iconst_2
    //   630: ldc_w 349
    //   633: invokestatic 352	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   636: aload_2
    //   637: ldc_w 354
    //   640: invokevirtual 357	android/os/Bundle:containsKey	(Ljava/lang/String;)Z
    //   643: ifeq -34 -> 609
    //   646: aload_2
    //   647: ldc_w 354
    //   650: invokevirtual 223	android/os/Bundle:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   653: astore_1
    //   654: aload_2
    //   655: ldc_w 359
    //   658: invokevirtual 223	android/os/Bundle:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   661: astore 16
    //   663: aload_2
    //   664: ldc_w 361
    //   667: invokevirtual 223	android/os/Bundle:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   670: astore_2
    //   671: aload_1
    //   672: invokestatic 63	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   675: ifne +569 -> 1244
    //   678: aload_1
    //   679: invokestatic 367	java/lang/Long:parseLong	(Ljava/lang/String;)J
    //   682: lstore 4
    //   684: goto +3 -> 687
    //   687: aload 16
    //   689: invokestatic 63	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   692: ifne +558 -> 1250
    //   695: aload 16
    //   697: invokestatic 367	java/lang/Long:parseLong	(Ljava/lang/String;)J
    //   700: lstore 6
    //   702: goto +3 -> 705
    //   705: aload_2
    //   706: invokestatic 63	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   709: ifne +547 -> 1256
    //   712: aload_2
    //   713: invokestatic 367	java/lang/Long:parseLong	(Ljava/lang/String;)J
    //   716: lstore 8
    //   718: goto +3 -> 721
    //   721: invokestatic 343	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   724: ifeq +28 -> 752
    //   727: ldc 206
    //   729: iconst_2
    //   730: ldc_w 369
    //   733: iconst_2
    //   734: anewarray 37	java/lang/Object
    //   737: dup
    //   738: iconst_0
    //   739: aload_1
    //   740: aastore
    //   741: dup
    //   742: iconst_1
    //   743: aload 16
    //   745: aastore
    //   746: invokestatic 373	java/lang/String:format	(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;
    //   749: invokestatic 352	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   752: aload_0
    //   753: getfield 320	com/tencent/mobileqq/webview/swift/component/SwiftBrowserTBSHandler:jdField_a_of_type_ComTencentMobileqqWebviewSwiftComponentSwiftBrowserComponentsProvider$SwiftBrowserComponentContext	Lcom/tencent/mobileqq/webview/swift/component/SwiftBrowserComponentsProvider$SwiftBrowserComponentContext;
    //   756: invokeinterface 325 1 0
    //   761: bipush 254
    //   763: invokevirtual 330	com/tencent/mobileqq/webview/swift/component/SwiftBrowserComponentsProvider:a	(I)Ljava/lang/Object;
    //   766: checkcast 375	com/tencent/mobileqq/webview/swift/component/SwiftBrowserStatistics
    //   769: astore_1
    //   770: aload_1
    //   771: ifnull +491 -> 1262
    //   774: aload_1
    //   775: getfield 377	com/tencent/mobileqq/webview/swift/component/SwiftBrowserStatistics:b	J
    //   778: lstore 10
    //   780: aload_1
    //   781: getfield 380	com/tencent/mobileqq/webview/swift/component/SwiftBrowserStatistics:c	J
    //   784: lstore 12
    //   786: aload_1
    //   787: getfield 383	com/tencent/mobileqq/webview/swift/component/SwiftBrowserStatistics:r	J
    //   790: lstore 14
    //   792: aload_1
    //   793: lload 4
    //   795: putfield 386	com/tencent/mobileqq/webview/swift/component/SwiftBrowserStatistics:f	J
    //   798: aload_1
    //   799: lload 6
    //   801: putfield 389	com/tencent/mobileqq/webview/swift/component/SwiftBrowserStatistics:g	J
    //   804: aload_1
    //   805: lload 8
    //   807: putfield 392	com/tencent/mobileqq/webview/swift/component/SwiftBrowserStatistics:e	J
    //   810: goto +3 -> 813
    //   813: aload_1
    //   814: invokestatic 398	com/tencent/mobileqq/vaswebviewplugin/VasBaseWebviewUtil:reportX5SpeedData	(Lcom/tencent/mobileqq/webview/swift/component/SwiftBrowserStatistics;)V
    //   817: invokestatic 343	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   820: ifeq +454 -> 1274
    //   823: ldc_w 400
    //   826: iconst_4
    //   827: anewarray 37	java/lang/Object
    //   830: dup
    //   831: iconst_0
    //   832: lload 12
    //   834: lload 10
    //   836: lsub
    //   837: invokestatic 403	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   840: aastore
    //   841: dup
    //   842: iconst_1
    //   843: lload 14
    //   845: lload 12
    //   847: lsub
    //   848: invokestatic 403	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   851: aastore
    //   852: dup
    //   853: iconst_2
    //   854: lload 4
    //   856: lload 14
    //   858: lsub
    //   859: invokestatic 403	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   862: aastore
    //   863: dup
    //   864: iconst_3
    //   865: lload 6
    //   867: lload 4
    //   869: lsub
    //   870: invokestatic 403	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   873: aastore
    //   874: invokestatic 373	java/lang/String:format	(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;
    //   877: astore_1
    //   878: ldc 206
    //   880: iconst_2
    //   881: aload_1
    //   882: invokestatic 352	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   885: goto +3 -> 888
    //   888: ldc 206
    //   890: astore_1
    //   891: new 279	java/lang/StringBuilder
    //   894: dup
    //   895: invokespecial 280	java/lang/StringBuilder:<init>	()V
    //   898: astore_2
    //   899: aload_2
    //   900: ldc_w 405
    //   903: invokevirtual 286	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   906: pop
    //   907: aload_2
    //   908: lload 4
    //   910: lload 14
    //   912: lsub
    //   913: invokevirtual 408	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   916: pop
    //   917: aload_1
    //   918: iconst_1
    //   919: aload_2
    //   920: invokevirtual 289	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   923: invokestatic 352	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   926: new 279	java/lang/StringBuilder
    //   929: dup
    //   930: invokespecial 280	java/lang/StringBuilder:<init>	()V
    //   933: astore_2
    //   934: aload_2
    //   935: ldc_w 410
    //   938: invokevirtual 286	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   941: pop
    //   942: aload_2
    //   943: lload 6
    //   945: lload 4
    //   947: lsub
    //   948: invokevirtual 408	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   951: pop
    //   952: aload_1
    //   953: iconst_1
    //   954: aload_2
    //   955: invokevirtual 289	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   958: invokestatic 352	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   961: new 279	java/lang/StringBuilder
    //   964: dup
    //   965: invokespecial 280	java/lang/StringBuilder:<init>	()V
    //   968: astore_2
    //   969: aload_2
    //   970: ldc_w 412
    //   973: invokevirtual 286	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   976: pop
    //   977: aload_2
    //   978: lload 8
    //   980: lload 10
    //   982: lsub
    //   983: invokevirtual 408	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   986: pop
    //   987: aload_1
    //   988: iconst_1
    //   989: aload_2
    //   990: invokevirtual 289	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   993: invokestatic 352	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   996: goto +47 -> 1043
    //   999: ldc 206
    //   1001: astore_2
    //   1002: astore_1
    //   1003: goto +14 -> 1017
    //   1006: astore_1
    //   1007: ldc 206
    //   1009: astore_2
    //   1010: goto +7 -> 1017
    //   1013: astore_1
    //   1014: ldc 206
    //   1016: astore_2
    //   1017: aload_2
    //   1018: iconst_2
    //   1019: ldc 174
    //   1021: aload_1
    //   1022: invokestatic 415	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   1025: goto +18 -> 1043
    //   1028: aload_1
    //   1029: ldc_w 417
    //   1032: invokevirtual 420	java/lang/String:equalsIgnoreCase	(Ljava/lang/String;)Z
    //   1035: ifeq +10 -> 1045
    //   1038: aload_0
    //   1039: aload_2
    //   1040: invokevirtual 423	com/tencent/mobileqq/webview/swift/component/SwiftBrowserTBSHandler:a	(Landroid/os/Bundle;)V
    //   1043: aconst_null
    //   1044: areturn
    //   1045: ldc_w 425
    //   1048: aload_1
    //   1049: invokevirtual 204	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   1052: ifeq +170 -> 1222
    //   1055: aload_2
    //   1056: ldc_w 427
    //   1059: invokevirtual 357	android/os/Bundle:containsKey	(Ljava/lang/String;)Z
    //   1062: ifeq -19 -> 1043
    //   1065: aload_2
    //   1066: ldc_w 427
    //   1069: invokevirtual 223	android/os/Bundle:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   1072: astore_1
    //   1073: aload_1
    //   1074: invokestatic 63	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   1077: ifne -34 -> 1043
    //   1080: aload_1
    //   1081: ldc_w 429
    //   1084: invokevirtual 432	java/lang/String:startsWith	(Ljava/lang/String;)Z
    //   1087: ifeq -44 -> 1043
    //   1090: aload_1
    //   1091: invokestatic 69	android/net/Uri:parse	(Ljava/lang/String;)Landroid/net/Uri;
    //   1094: ldc_w 434
    //   1097: invokevirtual 437	android/net/Uri:getQueryParameter	(Ljava/lang/String;)Ljava/lang/String;
    //   1100: astore 16
    //   1102: aload 16
    //   1104: invokestatic 63	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   1107: ifne -64 -> 1043
    //   1110: invokestatic 343	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   1113: ifeq +45 -> 1158
    //   1116: new 279	java/lang/StringBuilder
    //   1119: dup
    //   1120: invokespecial 280	java/lang/StringBuilder:<init>	()V
    //   1123: astore 17
    //   1125: aload 17
    //   1127: ldc_w 439
    //   1130: invokevirtual 286	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1133: pop
    //   1134: aload 17
    //   1136: aload_2
    //   1137: ldc_w 427
    //   1140: invokevirtual 223	android/os/Bundle:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   1143: invokevirtual 286	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1146: pop
    //   1147: ldc 206
    //   1149: iconst_2
    //   1150: aload 17
    //   1152: invokevirtual 289	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1155: invokestatic 352	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   1158: aload_0
    //   1159: getfield 441	com/tencent/mobileqq/webview/swift/component/SwiftBrowserTBSHandler:jdField_a_of_type_JavaUtilHashSet	Ljava/util/HashSet;
    //   1162: ifnonnull +16 -> 1178
    //   1165: aload_0
    //   1166: new 443	java/util/HashSet
    //   1169: dup
    //   1170: bipush 6
    //   1172: invokespecial 446	java/util/HashSet:<init>	(I)V
    //   1175: putfield 441	com/tencent/mobileqq/webview/swift/component/SwiftBrowserTBSHandler:jdField_a_of_type_JavaUtilHashSet	Ljava/util/HashSet;
    //   1178: aload_0
    //   1179: getfield 441	com/tencent/mobileqq/webview/swift/component/SwiftBrowserTBSHandler:jdField_a_of_type_JavaUtilHashSet	Ljava/util/HashSet;
    //   1182: aload 16
    //   1184: invokevirtual 448	java/util/HashSet:contains	(Ljava/lang/Object;)Z
    //   1187: ifne -144 -> 1043
    //   1190: aload_0
    //   1191: getfield 441	com/tencent/mobileqq/webview/swift/component/SwiftBrowserTBSHandler:jdField_a_of_type_JavaUtilHashSet	Ljava/util/HashSet;
    //   1194: aload 16
    //   1196: invokevirtual 451	java/util/HashSet:add	(Ljava/lang/Object;)Z
    //   1199: pop
    //   1200: invokestatic 183	com/tencent/mobileqq/app/ThreadManager:getUIHandler	()Lmqq/os/MqqHandler;
    //   1203: new 453	com/tencent/mobileqq/webview/swift/component/SwiftBrowserTBSHandler$4
    //   1206: dup
    //   1207: aload_0
    //   1208: aload_1
    //   1209: invokespecial 456	com/tencent/mobileqq/webview/swift/component/SwiftBrowserTBSHandler$4:<init>	(Lcom/tencent/mobileqq/webview/swift/component/SwiftBrowserTBSHandler;Ljava/lang/String;)V
    //   1212: ldc2_w 457
    //   1215: invokevirtual 462	mqq/os/MqqHandler:postDelayed	(Ljava/lang/Runnable;J)Z
    //   1218: pop
    //   1219: goto -176 -> 1043
    //   1222: getstatic 29	com/tencent/mobileqq/webview/swift/component/SwiftBrowserTBSHandler:jdField_a_of_type_ComTencentMobileqqWebviewSwiftInjectorISwiftBrowserTBSInjector	Lcom/tencent/mobileqq/webview/swift/injector/ISwiftBrowserTBSInjector;
    //   1225: astore 16
    //   1227: aload 16
    //   1229: ifnull -186 -> 1043
    //   1232: aload 16
    //   1234: aload_1
    //   1235: aload_2
    //   1236: invokeinterface 467 3 0
    //   1241: goto -198 -> 1043
    //   1244: lconst_0
    //   1245: lstore 4
    //   1247: goto -560 -> 687
    //   1250: lconst_0
    //   1251: lstore 6
    //   1253: goto -548 -> 705
    //   1256: lconst_0
    //   1257: lstore 8
    //   1259: goto -538 -> 721
    //   1262: lconst_0
    //   1263: lstore 10
    //   1265: lconst_0
    //   1266: lstore 12
    //   1268: lconst_0
    //   1269: lstore 14
    //   1271: goto -458 -> 813
    //   1274: goto -386 -> 888
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	1277	0	this	SwiftBrowserTBSHandler
    //   0	1277	1	paramString	String
    //   0	1277	2	paramBundle	Bundle
    //   389	20	3	i	int
    //   682	564	4	l1	long
    //   700	552	6	l2	long
    //   716	542	8	l3	long
    //   778	486	10	l4	long
    //   784	483	12	l5	long
    //   790	480	14	l6	long
    //   49	1184	16	localObject1	Object
    //   57	1094	17	localObject2	Object
    // Exception table:
    //   from	to	target	type
    //   878	885	999	java/lang/Exception
    //   891	996	999	java/lang/Exception
    //   780	810	1006	java/lang/Exception
    //   813	878	1006	java/lang/Exception
    //   646	684	1013	java/lang/Exception
    //   687	702	1013	java/lang/Exception
    //   705	718	1013	java/lang/Exception
    //   721	752	1013	java/lang/Exception
    //   752	770	1013	java/lang/Exception
    //   774	780	1013	java/lang/Exception
  }
  
  public void a()
  {
    super.a();
    Activity localActivity = this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftComponentSwiftBrowserComponentsProvider$SwiftBrowserComponentContext.a();
    if ((localActivity instanceof QQBrowserActivity)) {
      this.jdField_a_of_type_AndroidAppActivity = localActivity;
    } else {
      this.jdField_a_of_type_AndroidAppActivity = null;
    }
    this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftWebViewProvider = this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftComponentSwiftBrowserComponentsProvider$SwiftBrowserComponentContext.a();
  }
  
  public void a(int paramInt, Bundle paramBundle)
  {
    paramBundle = null;
    if (paramInt != 3)
    {
      if (paramInt != 7) {
        return;
      }
      if (!this.jdField_a_of_type_Boolean)
      {
        this.jdField_a_of_type_Boolean = true;
        Object localObject = jdField_a_of_type_ComTencentMobileqqWebviewSwiftInjectorISwiftBrowserTBSInjector;
        if (localObject != null) {
          ((ISwiftBrowserTBSInjector)localObject).a(this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftComponentSwiftBrowserComponentsProvider$SwiftBrowserComponentContext);
        }
        localObject = this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftWebViewProvider;
        if (localObject != null) {
          paramBundle = ((WebViewProvider)localObject).getWebView();
        }
        if (paramBundle != null)
        {
          paramBundle = (X5ApiPlugin)paramBundle.getPluginEngine().a("x5");
          if (paramBundle != null) {
            paramBundle.a();
          }
        }
      }
    }
    else
    {
      paramBundle = this.jdField_a_of_type_AndroidAppDialog;
      if ((paramBundle != null) && (paramBundle.isShowing())) {
        this.jdField_a_of_type_AndroidAppDialog.dismiss();
      }
      paramBundle = this.jdField_a_of_type_AndroidContentBroadcastReceiver;
      if (paramBundle != null)
      {
        this.jdField_a_of_type_AndroidAppActivity.unregisterReceiver(paramBundle);
        this.jdField_a_of_type_AndroidContentBroadcastReceiver = null;
      }
    }
  }
  
  public void a(int paramInt, String paramString)
  {
    VasBaseWebviewUtil.reportVasStatus("WebViewStatus", "x5_preload", "0", 0, 0, paramInt, 0, paramString, "");
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("handlePreloadCallback: type=");
      ((StringBuilder)localObject).append(paramInt);
      ((StringBuilder)localObject).append(", url=");
      ((StringBuilder)localObject).append(paramString);
      QLog.d("SwiftBrowserTBSHandler", 2, ((StringBuilder)localObject).toString());
    }
    Object localObject = this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftWebViewProvider;
    if (localObject != null) {
      localObject = ((WebViewProvider)localObject).getWebView();
    } else {
      localObject = null;
    }
    if (localObject != null)
    {
      localObject = (X5ApiPlugin)((CustomWebView)localObject).getPluginEngine().a("x5");
      if (localObject != null) {
        ((X5ApiPlugin)localObject).a(paramInt, paramString);
      }
    }
  }
  
  /* Error */
  void a(Bundle paramBundle)
  {
    // Byte code:
    //   0: ldc 174
    //   2: astore 7
    //   4: aload_1
    //   5: ifnull +197 -> 202
    //   8: aload_1
    //   9: ldc_w 427
    //   12: invokevirtual 357	android/os/Bundle:containsKey	(Ljava/lang/String;)Z
    //   15: ifeq +14 -> 29
    //   18: aload_1
    //   19: ldc_w 427
    //   22: invokevirtual 223	android/os/Bundle:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   25: astore_2
    //   26: goto +6 -> 32
    //   29: ldc 174
    //   31: astore_2
    //   32: aload_1
    //   33: ldc_w 545
    //   36: invokevirtual 357	android/os/Bundle:containsKey	(Ljava/lang/String;)Z
    //   39: ifeq +14 -> 53
    //   42: aload_1
    //   43: ldc_w 545
    //   46: invokevirtual 223	android/os/Bundle:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   49: astore_3
    //   50: goto +6 -> 56
    //   53: ldc 174
    //   55: astore_3
    //   56: aload_3
    //   57: astore 6
    //   59: aload_2
    //   60: astore 4
    //   62: aload 7
    //   64: astore 5
    //   66: aload_1
    //   67: ldc_w 547
    //   70: invokevirtual 357	android/os/Bundle:containsKey	(Ljava/lang/String;)Z
    //   73: ifeq +58 -> 131
    //   76: aload_1
    //   77: ldc_w 547
    //   80: invokevirtual 223	android/os/Bundle:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   83: astore 5
    //   85: aload_3
    //   86: astore 6
    //   88: aload_2
    //   89: astore 4
    //   91: goto +40 -> 131
    //   94: astore_1
    //   95: goto +16 -> 111
    //   98: astore_1
    //   99: ldc 174
    //   101: astore_3
    //   102: goto +9 -> 111
    //   105: astore_1
    //   106: ldc 174
    //   108: astore_3
    //   109: aload_3
    //   110: astore_2
    //   111: ldc 206
    //   113: iconst_1
    //   114: ldc_w 549
    //   117: aload_1
    //   118: invokestatic 415	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   121: aload 7
    //   123: astore 5
    //   125: aload_2
    //   126: astore 4
    //   128: aload_3
    //   129: astore 6
    //   131: new 279	java/lang/StringBuilder
    //   134: dup
    //   135: invokespecial 280	java/lang/StringBuilder:<init>	()V
    //   138: astore_1
    //   139: aload_1
    //   140: ldc_w 551
    //   143: invokevirtual 286	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   146: pop
    //   147: aload_1
    //   148: aload 6
    //   150: invokevirtual 286	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   153: pop
    //   154: aload_1
    //   155: ldc_w 553
    //   158: invokevirtual 286	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   161: pop
    //   162: aload_1
    //   163: aload 5
    //   165: invokevirtual 286	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   168: pop
    //   169: aload_1
    //   170: ldc_w 555
    //   173: invokevirtual 286	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   176: pop
    //   177: aload_1
    //   178: aload 4
    //   180: iconst_0
    //   181: anewarray 115	java/lang/String
    //   184: invokestatic 560	com/tencent/biz/common/util/Util:b	(Ljava/lang/String;[Ljava/lang/String;)Ljava/lang/String;
    //   187: invokevirtual 286	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   190: pop
    //   191: ldc 206
    //   193: iconst_1
    //   194: aload_1
    //   195: invokevirtual 289	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   198: invokestatic 214	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   201: return
    //   202: ldc 206
    //   204: iconst_1
    //   205: ldc_w 562
    //   208: invokestatic 214	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   211: return
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	212	0	this	SwiftBrowserTBSHandler
    //   0	212	1	paramBundle	Bundle
    //   25	101	2	localObject1	Object
    //   49	80	3	str1	String
    //   60	119	4	localObject2	Object
    //   64	100	5	str2	String
    //   57	92	6	str3	String
    //   2	120	7	str4	String
    // Exception table:
    //   from	to	target	type
    //   66	85	94	java/lang/Throwable
    //   32	50	98	java/lang/Throwable
    //   8	26	105	java/lang/Throwable
  }
  
  void a(String paramString, int paramInt)
  {
    if (paramInt < 12) {
      try
      {
        HttpURLConnection localHttpURLConnection = (HttpURLConnection)new URL(paramString).openConnection();
        localHttpURLConnection.setDoInput(true);
        localHttpURLConnection.setConnectTimeout(20000);
        localHttpURLConnection.setRequestMethod("GET");
        localHttpURLConnection.connect();
        int i = localHttpURLConnection.getResponseCode();
        if ((i != 301) && (i != 302))
        {
          if (i == 200)
          {
            this.jdField_a_of_type_Long = localHttpURLConnection.getContentLength();
            this.jdField_a_of_type_JavaLangString = localHttpURLConnection.getURL().toString();
          }
        }
        else
        {
          paramString = localHttpURLConnection.getHeaderFields().keySet();
          Object localObject = null;
          Iterator localIterator = paramString.iterator();
          do
          {
            paramString = localObject;
            if (!localIterator.hasNext()) {
              break;
            }
            paramString = (String)localIterator.next();
          } while (!"location".equalsIgnoreCase(paramString));
          paramString = localHttpURLConnection.getHeaderField(paramString);
          if (paramString != null)
          {
            a(MsfSdkUtils.insertMtype("Web", paramString), paramInt + 1);
            return;
          }
        }
        localHttpURLConnection.disconnect();
        return;
      }
      catch (Throwable paramString)
      {
        if (QLog.isColorLevel()) {
          QLog.e("SwiftBrowserTBSHandler", 2, paramString.getMessage());
        }
      }
    }
  }
  
  public void b()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftWebViewProvider != null)
    {
      if (this.jdField_a_of_type_AndroidAppActivity == null) {
        return;
      }
      Object localObject1 = WebAccelerateHelper.getInstance().getTBSDpcParam();
      boolean bool = TextUtils.isEmpty((CharSequence)localObject1);
      int j = 1;
      Object localObject2;
      if (!bool)
      {
        if (((String)localObject1).charAt(0) != '1')
        {
          if (QLog.isColorLevel())
          {
            localObject2 = new StringBuilder();
            ((StringBuilder)localObject2).append("warning: disable tbs, ");
            ((StringBuilder)localObject2).append((String)localObject1);
            QLog.i("SwiftBrowserTBSHandler", 2, ((StringBuilder)localObject2).toString());
          }
          i = 0;
          break label105;
        }
      }
      else {
        QLog.e("SwiftBrowserTBSHandler", 1, "error: no dpc param!");
      }
      int i = 1;
      label105:
      if ((a(this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftWebViewProvider.getAppRuntime()) != null) && (i != 0))
      {
        if ("CN".equals(Locale.getDefault().getCountry()))
        {
          localObject1 = a(this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftWebViewProvider.getAppRuntime());
          if (TbsDownloader.needDownload(BaseApplication.getContext(), false, false, new SwiftBrowserTBSHandler.TbsDownloadCallback((ITbsDownloader)localObject1)))
          {
            if (QLog.isColorLevel()) {
              QLog.d("TBS_update", 2, "tbs need download");
            }
            QbSdk.setUploadCode(BaseApplication.getContext(), 150);
            ((ITbsDownloader)localObject1).a(false);
            i = j;
            break label273;
          }
          i = j;
          if (!QLog.isColorLevel()) {
            break label273;
          }
          QLog.d("TBS_update", 2, "tbs no need download");
          i = j;
          break label273;
        }
        if (QLog.isColorLevel()) {
          QLog.d("TBS_update", 2, "tbs loc/tz not match");
        }
      }
      else if (QLog.isColorLevel())
      {
        QLog.d("TBS_update", 2, "tbs update disabled");
      }
      i = 0;
      label273:
      localObject1 = null;
      if (this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftComponentSwiftBrowserComponentsProvider$SwiftBrowserComponentContext != null) {
        localObject1 = (SwiftBrowserStatistics)this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftComponentSwiftBrowserComponentsProvider$SwiftBrowserComponentContext.a().a(-2);
      }
      if (((localObject1 != null) && (((SwiftBrowserStatistics)localObject1).h)) || (QLog.isColorLevel()))
      {
        j = QbSdk.getTbsVersion(BaseApplication.getContext());
        bool = QLog.isColorLevel();
        String str = "sys";
        if (bool)
        {
          StringBuilder localStringBuilder = new StringBuilder();
          localStringBuilder.append("tbs current webview:");
          if (j == 0)
          {
            localObject2 = "sys";
          }
          else
          {
            localObject2 = new StringBuilder();
            ((StringBuilder)localObject2).append("x5_");
            ((StringBuilder)localObject2).append(j);
            localObject2 = ((StringBuilder)localObject2).toString();
          }
          localStringBuilder.append((String)localObject2);
          QLog.d("TBS_update", 2, localStringBuilder.toString());
        }
        if ((localObject1 != null) && (((SwiftBrowserStatistics)localObject1).h))
        {
          localObject2 = new StringBuilder();
          ((StringBuilder)localObject2).append("tbs_cover_");
          if (i != 0)
          {
            localObject1 = str;
            if (j > 0) {
              localObject1 = "tbs";
            }
          }
          else
          {
            localObject1 = "dis";
          }
          ((StringBuilder)localObject2).append((String)localObject1);
          ReportController.b(null, "P_CliOper", "BizTechReport", "", "web", ((StringBuilder)localObject2).toString(), 0, 1, j, "", "", "", "");
        }
      }
    }
  }
  
  public boolean handleMessage(Message paramMessage)
  {
    Object localObject1;
    switch (paramMessage.what)
    {
    default: 
      return true;
    case 104: 
      paramMessage = (String)paramMessage.obj;
      localObject1 = this.jdField_a_of_type_AndroidAppDialog;
      if ((localObject1 != null) && (((Dialog)localObject1).isShowing()) && (paramMessage != null))
      {
        ((TextView)this.jdField_a_of_type_AndroidAppDialog.findViewById(2131380179)).setText(paramMessage);
        return true;
      }
      break;
    case 103: 
      paramMessage = (Drawable)paramMessage.obj;
      localObject1 = this.jdField_a_of_type_AndroidAppDialog;
      if ((localObject1 != null) && (((Dialog)localObject1).isShowing()) && (paramMessage != null))
      {
        localObject1 = (ImageView)this.jdField_a_of_type_AndroidAppDialog.findViewById(2131380177);
        ((ImageView)localObject1).setImageDrawable(null);
        ((ImageView)localObject1).setImageDrawable(paramMessage);
        return true;
      }
      break;
    case 102: 
      ThreadManager.post(new SwiftBrowserTBSHandler.2(this), 8, null, true);
      return true;
    case 101: 
      if (!this.jdField_a_of_type_AndroidAppActivity.isFinishing())
      {
        localObject1 = this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftWebViewProvider;
        if ((localObject1 != null) && (!((WebViewProvider)localObject1).isDestroyed()))
        {
          paramMessage = (Bundle)paramMessage.obj;
          ((IWebViewOpenSdkApi)QRoute.api(IWebViewOpenSdkApi.class)).downloadByUniformDownload(paramMessage, this.jdField_a_of_type_AndroidAppActivity, this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftWebViewProvider.getWebView().getUrl(), this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftWebViewProvider.getWebView().getSettings().getUserAgentString());
          ((SwiftBrowserUIStyleHandler)this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftWebViewProvider.getComponentProvider().a(2)).jdField_a_of_type_AndroidWidgetProgressBar.setVisibility(8);
          return true;
        }
      }
      break;
    case 100: 
      paramMessage = (String)paramMessage.obj;
    }
    try
    {
      paramMessage = new JSONObject(paramMessage);
      localObject1 = paramMessage.getJSONObject("icon");
      Object localObject2 = paramMessage.getJSONObject("content");
      paramMessage = ((JSONObject)localObject1).getString("timestamp");
      localObject1 = ((JSONObject)localObject1).getString("url");
      String str = ((JSONObject)localObject2).getString("timestamp");
      localObject2 = ((JSONObject)localObject2).getString("memo");
      Object localObject3 = BaseApplication.getContext().getSharedPreferences("qb_info", 0);
      if (localObject3 != null)
      {
        localObject3 = ((SharedPreferences)localObject3).edit();
        ((SharedPreferences.Editor)localObject3).putString("icon_time", paramMessage);
        ((SharedPreferences.Editor)localObject3).putString("icon_url", (String)localObject1);
        ((SharedPreferences.Editor)localObject3).putString("content_time", str);
        ((SharedPreferences.Editor)localObject3).putString("content_memo", (String)localObject2);
        ((SharedPreferences.Editor)localObject3).commit();
      }
      return true;
    }
    catch (Exception paramMessage) {}
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.webview.swift.component.SwiftBrowserTBSHandler
 * JD-Core Version:    0.7.0.1
 */