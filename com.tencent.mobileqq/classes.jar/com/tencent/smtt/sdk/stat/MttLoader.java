package com.tencent.smtt.sdk.stat;

import android.content.ActivityNotFoundException;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.pm.ActivityInfo;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.PackageManager.NameNotFoundException;
import android.content.pm.ResolveInfo;
import android.graphics.Point;
import android.net.Uri;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.smtt.sdk.WebView;
import com.tencent.smtt.utils.FileProvider;
import java.io.File;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.security.cert.Certificate;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

public class MttLoader
{
  public static final String CHANNEL_ID = "ChannelID";
  public static final String ENTRY_ID = "entryId";
  @Deprecated
  public static final String KEY_ACTIVITY_NAME = "KEY_ACT";
  @Deprecated
  public static final String KEY_APP_NAME = "KEY_APPNAME";
  public static final String KEY_EUSESTAT = "KEY_EUSESTAT";
  @Deprecated
  public static final String KEY_PACKAGE = "KEY_PKG";
  public static final String KEY_PID = "KEY_PID";
  public static final String MTT_ACTION = "com.tencent.QQBrowser.action.VIEW";
  public static final String MTT_ACTION_SP = "com.tencent.QQBrowser.action.VIEWSP";
  public static final String PID_ARTICLE_NEWS = "21272";
  public static final String PID_MOBILE_QQ = "50079";
  public static final String PID_QQPIM = "50190";
  public static final String PID_QZONE = "10494";
  public static final String PID_WECHAT = "10318";
  public static final String POS_ID = "PosID";
  public static final String QQBROWSER_DIRECT_DOWNLOAD_URL = "https://mdc.html5.qq.com/d/directdown.jsp?channel_id=50079";
  public static final String QQBROWSER_DOWNLOAD_URL = "https://mdc.html5.qq.com/mh?channel_id=50079&u=";
  public static final String QQBROWSER_PARAMS_FROME = ",from=";
  public static final String QQBROWSER_PARAMS_PACKAGENAME = ",packagename=";
  public static final String QQBROWSER_PARAMS_PD = ",product=";
  public static final String QQBROWSER_PARAMS_VERSION = ",version=";
  public static final String QQBROWSER_SCHEME = "mttbrowser://url=";
  public static final int RESULT_INVALID_CONTEXT = 3;
  public static final int RESULT_INVALID_URL = 2;
  public static final int RESULT_NOT_INSTALL_QQBROWSER = 4;
  public static final int RESULT_OK = 0;
  public static final int RESULT_QQBROWSER_LOW = 5;
  public static final int RESULT_UNKNOWN = 1;
  public static final String STAT_KEY = "StatKey";
  
  private static int a(Context paramContext)
  {
    int i = 26;
    paramContext = paramContext.getApplicationInfo().processName;
    if (paramContext.equals("com.tencent.mobileqq")) {
      i = 13;
    }
    do
    {
      return i;
      if (paramContext.equals("com.qzone")) {
        return 14;
      }
      if (paramContext.equals("com.tencent.WBlog")) {
        return 15;
      }
    } while (!paramContext.equals("com.tencent.mm"));
    return 24;
  }
  
  private static Uri a(Context paramContext, String paramString)
  {
    return FileProvider.a(paramContext, paramString);
  }
  
  private static MttLoader.a a(Context paramContext, Uri paramUri)
  {
    Object localObject = new Intent("com.tencent.QQBrowser.action.VIEW");
    ((Intent)localObject).setData(paramUri);
    paramUri = paramContext.getPackageManager().queryIntentActivities((Intent)localObject, 0);
    if (paramUri.size() <= 0) {
      return null;
    }
    paramContext = new MttLoader.a(null);
    paramUri = paramUri.iterator();
    while (paramUri.hasNext())
    {
      localObject = (ResolveInfo)paramUri.next();
      String str = ((ResolveInfo)localObject).activityInfo.packageName;
      if (str.contains("com.tencent.mtt"))
      {
        paramContext.a = ((ResolveInfo)localObject).activityInfo.name;
        paramContext.b = ((ResolveInfo)localObject).activityInfo.packageName;
        return paramContext;
      }
      if (str.contains("com.tencent.qbx"))
      {
        paramContext.a = ((ResolveInfo)localObject).activityInfo.name;
        paramContext.b = ((ResolveInfo)localObject).activityInfo.packageName;
      }
    }
    return paramContext;
  }
  
  private static String a(Certificate paramCertificate)
  {
    paramCertificate = paramCertificate.getEncoded();
    int k = paramCertificate.length;
    char[] arrayOfChar = new char[k * 2];
    int i = 0;
    if (i < k)
    {
      int m = paramCertificate[i];
      int j = m >> 4 & 0xF;
      if (j >= 10)
      {
        j = j + 97 - 10;
        label49:
        arrayOfChar[(i * 2)] = ((char)j);
        j = m & 0xF;
        if (j < 10) {
          break label102;
        }
        j = j + 97 - 10;
      }
      for (;;)
      {
        arrayOfChar[(i * 2 + 1)] = ((char)j);
        i += 1;
        break;
        j += 48;
        break label49;
        label102:
        j += 48;
      }
    }
    return new String(arrayOfChar);
  }
  
  private static boolean a(String paramString)
  {
    if ((paramString == null) || (paramString.length() == 0)) {}
    int i;
    int j;
    do
    {
      return false;
      paramString = paramString.trim();
      i = paramString.toLowerCase().indexOf("://");
      j = paramString.toLowerCase().indexOf('.');
    } while ((i > 0) && (j > 0) && (i > j));
    return paramString.toLowerCase().contains("://");
  }
  
  public static MttLoader.BrowserInfo getBrowserInfo(Context paramContext)
  {
    boolean bool = paramContext.getApplicationContext().getSharedPreferences("x5_proxy_setting", 0).getBoolean("qb_install_status", false);
    localBrowserInfo = new MttLoader.BrowserInfo();
    if (bool) {
      return localBrowserInfo;
    }
    for (;;)
    {
      try
      {
        localPackageManager = paramContext.getPackageManager();
        localObject1 = null;
        try
        {
          localObject6 = localPackageManager.getPackageInfo("com.tencent.mtt", 0);
          localObject1 = localObject6;
          localBrowserInfo.browserType = 2;
          localObject1 = localObject6;
          localBrowserInfo.packageName = "com.tencent.mtt";
          localObject1 = localObject6;
          localBrowserInfo.quahead = "ADRQB_";
          Object localObject3 = localObject6;
          if (localObject6 != null)
          {
            localObject1 = localObject6;
            localObject3 = localObject6;
            if (((PackageInfo)localObject6).versionCode > 420000)
            {
              localObject1 = localObject6;
              localBrowserInfo.ver = ((PackageInfo)localObject6).versionCode;
              localObject1 = localObject6;
              localBrowserInfo.quahead += ((PackageInfo)localObject6).versionName.replaceAll("\\.", "");
              localObject1 = localObject6;
              localBrowserInfo.vn = ((PackageInfo)localObject6).versionName.replaceAll("\\.", "");
              return localBrowserInfo;
            }
          }
        }
        catch (PackageManager.NameNotFoundException localNameNotFoundException3)
        {
          localObject4 = localObject1;
        }
      }
      catch (Exception paramContext)
      {
        PackageManager localPackageManager;
        Object localObject1;
        Object localObject6;
        Object localObject4;
        PackageInfo localPackageInfo1;
        Object localObject2;
        continue;
      }
      try
      {
        localObject1 = localPackageManager.getPackageInfo("com.tencent.qbx", 0);
        localObject4 = localObject1;
        localBrowserInfo.browserType = 0;
        localObject4 = localObject1;
        localBrowserInfo.packageName = "com.tencent.qbx";
        localObject4 = localObject1;
        localBrowserInfo.quahead = "ADRQBX_";
        paramContext = (Context)localObject1;
      }
      catch (PackageManager.NameNotFoundException localNameNotFoundException1)
      {
        try
        {
          localPackageInfo1 = localPackageManager.getPackageInfo("com.tencent.qbx5", 0);
          localObject4 = localPackageInfo1;
          localBrowserInfo.browserType = 1;
          localObject4 = localPackageInfo1;
          localBrowserInfo.packageName = "com.tencent.qbx5";
          localObject4 = localPackageInfo1;
          localBrowserInfo.quahead = "ADRQBX5_";
          paramContext = localPackageInfo1;
        }
        catch (PackageManager.NameNotFoundException localNameNotFoundException2)
        {
          localObject2 = localObject4;
          try
          {
            localObject4 = localPackageManager.getPackageInfo("com.tencent.mtt", 0);
            localObject2 = localObject4;
            localBrowserInfo.packageName = "com.tencent.mtt";
            localObject2 = localObject4;
            localBrowserInfo.browserType = 2;
            localObject2 = localObject4;
            localBrowserInfo.quahead = "ADRQB_";
            paramContext = (Context)localObject4;
          }
          catch (PackageManager.NameNotFoundException localNameNotFoundException4)
          {
            try
            {
              PackageInfo localPackageInfo2 = localPackageManager.getPackageInfo("com.tencent.mtt.x86", 0);
              localObject2 = localPackageInfo2;
              localBrowserInfo.packageName = "com.tencent.mtt.x86";
              localObject2 = localPackageInfo2;
              localBrowserInfo.browserType = 2;
              localObject2 = localPackageInfo2;
              localBrowserInfo.quahead = "ADRQB_";
              paramContext = localPackageInfo2;
            }
            catch (Exception localException)
            {
              Object localObject5 = localObject2;
              try
              {
                localObject6 = a(paramContext, Uri.parse("https://mdc.html5.qq.com/mh?channel_id=50079&u="));
                paramContext = localObject2;
                if (localObject6 == null) {
                  continue;
                }
                paramContext = localObject2;
                localObject5 = localObject2;
                if (TextUtils.isEmpty(((MttLoader.a)localObject6).b)) {
                  continue;
                }
                localObject5 = localObject2;
                paramContext = localPackageManager.getPackageInfo(((MttLoader.a)localObject6).b, 0);
                localObject5 = paramContext;
                localBrowserInfo.packageName = ((MttLoader.a)localObject6).b;
                localObject5 = paramContext;
                localBrowserInfo.browserType = 2;
                localObject5 = paramContext;
                localBrowserInfo.quahead = "ADRQB_";
              }
              catch (Exception paramContext)
              {
                paramContext = (Context)localObject5;
              }
            }
          }
        }
      }
    }
    if (paramContext != null)
    {
      localBrowserInfo.ver = paramContext.versionCode;
      localBrowserInfo.quahead += paramContext.versionName.replaceAll("\\.", "");
      localBrowserInfo.vn = paramContext.versionName.replaceAll("\\.", "");
    }
    return localBrowserInfo;
  }
  
  public static String getDownloadUrlWithQb(String paramString)
  {
    try
    {
      paramString = "https://mdc.html5.qq.com/mh?channel_id=50079&u=" + URLEncoder.encode(paramString, "UTF-8");
      return paramString;
    }
    catch (UnsupportedEncodingException paramString)
    {
      paramString.printStackTrace();
    }
    return "https://mdc.html5.qq.com/mh?channel_id=50079&u=";
  }
  
  public static String getValidQBUrl(Context paramContext, String paramString)
  {
    int i = 1;
    String str = paramString;
    if (paramString.toLowerCase().startsWith("qb://"))
    {
      paramContext = getBrowserInfo(paramContext);
      if (paramContext.browserType != -1) {
        break label43;
      }
    }
    for (;;)
    {
      str = paramString;
      if (i != 0) {
        str = getDownloadUrlWithQb(paramString);
      }
      return str;
      label43:
      if ((paramContext.browserType != 2) || (paramContext.ver >= 33)) {
        i = 0;
      }
    }
  }
  
  public static boolean isBrowserInstalled(Context paramContext)
  {
    return getBrowserInfo(paramContext).browserType != -1;
  }
  
  public static boolean isBrowserInstalledEx(Context paramContext)
  {
    paramContext = getBrowserInfo(paramContext);
    boolean bool = false;
    try
    {
      long l = Long.valueOf(paramContext.vn).longValue();
      if (l >= 6001500L) {
        bool = true;
      }
    }
    catch (NumberFormatException localNumberFormatException)
    {
      for (;;)
      {
        localNumberFormatException.printStackTrace();
      }
    }
    if (paramContext.ver >= 601500) {
      return true;
    }
    return bool;
  }
  
  public static boolean isGreatBrowserVer(Context paramContext, long paramLong1, long paramLong2)
  {
    paramContext = getBrowserInfo(paramContext);
    boolean bool = false;
    try
    {
      long l = Long.valueOf(paramContext.vn).longValue();
      if (l >= paramLong1) {
        bool = true;
      }
    }
    catch (NumberFormatException localNumberFormatException)
    {
      for (;;)
      {
        localNumberFormatException.printStackTrace();
      }
    }
    if (paramContext.ver >= paramLong2) {
      return true;
    }
    return bool;
  }
  
  public static boolean isSupportQBScheme(Context paramContext)
  {
    paramContext = getBrowserInfo(paramContext);
    if (paramContext.browserType == -1) {}
    while ((paramContext.browserType == 2) && (paramContext.ver < 42)) {
      return false;
    }
    return true;
  }
  
  public static boolean isSupportingTbsTips(Context paramContext)
  {
    paramContext = getBrowserInfo(paramContext);
    return (paramContext.browserType == 2) && (paramContext.ver >= 580000);
  }
  
  public static int loadUrl(Context paramContext, String paramString, HashMap<String, String> paramHashMap, WebView paramWebView)
  {
    if (paramContext == null) {
      return 3;
    }
    Object localObject1 = paramString;
    if (!a(paramString)) {
      localObject1 = "http://" + paramString;
    }
    try
    {
      localObject1 = Uri.parse((String)localObject1);
      if (localObject1 == null) {
        return 2;
      }
    }
    catch (Exception paramContext)
    {
      return 2;
    }
    Object localObject2 = getBrowserInfo(paramContext);
    if (((MttLoader.BrowserInfo)localObject2).browserType == -1) {
      return 4;
    }
    if ((((MttLoader.BrowserInfo)localObject2).browserType == 2) && (((MttLoader.BrowserInfo)localObject2).ver < 33)) {
      return 5;
    }
    paramString = new Intent("android.intent.action.VIEW");
    if (((MttLoader.BrowserInfo)localObject2).browserType == 2) {
      if ((((MttLoader.BrowserInfo)localObject2).ver >= 33) && (((MttLoader.BrowserInfo)localObject2).ver <= 39)) {
        paramString.setClassName("com.tencent.mtt", "com.tencent.mtt.MainActivity");
      }
    }
    label611:
    for (;;)
    {
      paramString.setData((Uri)localObject1);
      if (paramHashMap != null)
      {
        localObject1 = paramHashMap.keySet();
        if (localObject1 != null)
        {
          localObject1 = ((Set)localObject1).iterator();
          for (;;)
          {
            if (((Iterator)localObject1).hasNext())
            {
              localObject2 = (String)((Iterator)localObject1).next();
              String str = (String)paramHashMap.get(localObject2);
              if (!TextUtils.isEmpty(str))
              {
                paramString.putExtra((String)localObject2, str);
                continue;
                if ((((MttLoader.BrowserInfo)localObject2).ver >= 40) && (((MttLoader.BrowserInfo)localObject2).ver <= 45))
                {
                  paramString.setClassName("com.tencent.mtt", "com.tencent.mtt.SplashActivity");
                  break;
                }
                if (((MttLoader.BrowserInfo)localObject2).ver < 46) {
                  break label611;
                }
                paramString = new Intent("com.tencent.QQBrowser.action.VIEW");
                localObject2 = a(paramContext, (Uri)localObject1);
                if ((localObject2 != null) && (!TextUtils.isEmpty(((MttLoader.a)localObject2).a))) {
                  paramString.setClassName(((MttLoader.a)localObject2).b, ((MttLoader.a)localObject2).a);
                }
                break;
                if (((MttLoader.BrowserInfo)localObject2).browserType == 1)
                {
                  if (((MttLoader.BrowserInfo)localObject2).ver == 1)
                  {
                    paramString.setClassName("com.tencent.qbx5", "com.tencent.qbx5.MainActivity");
                    break;
                  }
                  if (((MttLoader.BrowserInfo)localObject2).ver != 2) {
                    break label611;
                  }
                  paramString.setClassName("com.tencent.qbx5", "com.tencent.qbx5.SplashActivity");
                  break;
                }
                if (((MttLoader.BrowserInfo)localObject2).browserType == 0)
                {
                  if ((((MttLoader.BrowserInfo)localObject2).ver >= 4) && (((MttLoader.BrowserInfo)localObject2).ver <= 6))
                  {
                    paramString.setClassName("com.tencent.qbx", "com.tencent.qbx.SplashActivity");
                    break;
                  }
                  if (((MttLoader.BrowserInfo)localObject2).ver <= 6) {
                    break label611;
                  }
                  paramString = new Intent("com.tencent.QQBrowser.action.VIEW");
                  localObject2 = a(paramContext, (Uri)localObject1);
                  if ((localObject2 != null) && (!TextUtils.isEmpty(((MttLoader.a)localObject2).a))) {
                    paramString.setClassName(((MttLoader.a)localObject2).b, ((MttLoader.a)localObject2).a);
                  }
                  break;
                }
                paramString = new Intent("com.tencent.QQBrowser.action.VIEW");
                localObject2 = a(paramContext, (Uri)localObject1);
                if ((localObject2 != null) && (!TextUtils.isEmpty(((MttLoader.a)localObject2).a))) {
                  paramString.setClassName(((MttLoader.a)localObject2).b, ((MttLoader.a)localObject2).a);
                }
                break;
              }
            }
          }
        }
      }
      try
      {
        paramString.putExtra("loginType", a(paramContext));
        paramString.addFlags(268435456);
        if (paramWebView != null)
        {
          paramString.putExtra("AnchorPoint", new Point(paramWebView.getScrollX(), paramWebView.getScrollY()));
          paramString.putExtra("ContentSize", new Point(paramWebView.getContentWidth(), paramWebView.getContentHeight()));
        }
        paramContext.startActivity(paramString);
        return 0;
      }
      catch (ActivityNotFoundException paramContext)
      {
        return 4;
      }
    }
  }
  
  public static int loadUrl(Context paramContext, String paramString1, HashMap<String, String> paramHashMap, String paramString2, WebView paramWebView)
  {
    j = 0;
    StringBuilder localStringBuilder = new StringBuilder();
    for (;;)
    {
      try
      {
        localObject = paramContext.getPackageManager();
        if (localObject == null) {
          continue;
        }
        localObject = ((PackageManager)localObject).getPackageInfo("com.tencent.mtt", 0);
        if (localObject == null) {
          continue;
        }
        i = ((PackageInfo)localObject).versionCode;
        if (i <= 601000) {
          continue;
        }
        i = 1;
      }
      catch (Throwable localThrowable)
      {
        Object localObject;
        int i = 0;
        continue;
        String str = "";
        continue;
        i = 0;
        continue;
      }
      try
      {
        localObject = URLEncoder.encode(paramString1, "UTF-8");
        if (i != 0) {
          paramString1 = (String)localObject;
        }
      }
      catch (Exception localException)
      {
        i = j;
      }
    }
    if (i != 0)
    {
      localObject = ",encoded=1";
      localStringBuilder.append("mttbrowser://url=").append(paramString1).append(",product=").append("TBS").append(",packagename=").append(paramContext.getPackageName()).append(",from=").append(paramString2).append(",version=").append("4.3.0.36").append((String)localObject);
      return loadUrl(paramContext, localStringBuilder.toString(), paramHashMap, paramWebView);
    }
  }
  
  public static boolean openDocWithQb(Context paramContext, String paramString1, int paramInt, String paramString2, String paramString3, HashMap<String, String> paramHashMap, Bundle paramBundle)
  {
    Intent localIntent;
    try
    {
      localIntent = new Intent("com.tencent.QQBrowser.action.sdk.document");
      if (paramHashMap != null)
      {
        Object localObject = paramHashMap.keySet();
        if (localObject != null)
        {
          localObject = ((Set)localObject).iterator();
          while (((Iterator)localObject).hasNext())
          {
            String str1 = (String)((Iterator)localObject).next();
            String str2 = (String)paramHashMap.get(str1);
            if (!TextUtils.isEmpty(str2)) {
              localIntent.putExtra(str1, str2);
            }
          }
        }
      }
      new File(paramString1);
    }
    catch (Exception paramContext)
    {
      paramContext.printStackTrace();
      return false;
    }
    localIntent.putExtra("key_reader_sdk_id", 3);
    localIntent.putExtra("key_reader_sdk_type", paramInt);
    if (!TextUtils.isEmpty(paramString3)) {
      localIntent.putExtra("big_brother_source_key", paramString3);
    }
    if (paramInt == 0) {
      localIntent.putExtra("key_reader_sdk_path", paramString1);
    }
    for (;;)
    {
      localIntent.putExtra("key_reader_sdk_format", paramString2);
      if ((paramContext != null) && (paramContext.getApplicationInfo().targetSdkVersion >= 24) && (Build.VERSION.SDK_INT >= 24)) {
        localIntent.addFlags(1);
      }
      localIntent.addFlags(268435456);
      paramString1 = a(paramContext, paramString1);
      if (paramString1 != null) {
        break;
      }
      return false;
      if (paramInt == 1) {
        localIntent.putExtra("key_reader_sdk_url", paramString1);
      }
    }
    localIntent.setDataAndType(paramString1, "mtt/" + paramString2);
    localIntent.putExtra("loginType", a(paramContext.getApplicationContext()));
    if (paramBundle != null) {
      localIntent.putExtra("key_reader_sdk_extrals", paramBundle);
    }
    paramContext.startActivity(localIntent);
    return true;
  }
  
  public static boolean openDocWithQb(Context paramContext, String paramString1, int paramInt, String paramString2, HashMap<String, String> paramHashMap)
  {
    return openDocWithQb(paramContext, paramString1, paramInt, paramString2, paramHashMap, null);
  }
  
  public static boolean openDocWithQb(Context paramContext, String paramString1, int paramInt, String paramString2, HashMap<String, String> paramHashMap, Bundle paramBundle)
  {
    return openDocWithQb(paramContext, paramString1, paramInt, paramString2, "", paramHashMap, null);
  }
  
  public static boolean openVideoWithQb(Context paramContext, String paramString, HashMap<String, String> paramHashMap)
  {
    Object localObject = Uri.parse(paramString);
    paramString = new Intent("android.intent.action.VIEW");
    paramString.setFlags(268435456);
    paramString.setDataAndType((Uri)localObject, "video/*");
    if (paramHashMap != null)
    {
      localObject = paramHashMap.keySet();
      if (localObject != null)
      {
        localObject = ((Set)localObject).iterator();
        while (((Iterator)localObject).hasNext())
        {
          String str1 = (String)((Iterator)localObject).next();
          String str2 = (String)paramHashMap.get(str1);
          if (!TextUtils.isEmpty(str2)) {
            paramString.putExtra(str1, str2);
          }
        }
      }
    }
    try
    {
      paramString.putExtra("loginType", a(paramContext));
      paramString.setComponent(new ComponentName("com.tencent.mtt", "com.tencent.mtt.browser.video.H5VideoThrdcallActivity"));
      paramContext.startActivity(paramString);
      i = 1;
    }
    catch (Throwable paramHashMap)
    {
      for (;;)
      {
        try
        {
          paramString.setComponent(null);
          paramContext.startActivity(paramString);
          return true;
        }
        catch (Throwable paramContext)
        {
          int i;
          paramContext.printStackTrace();
        }
        paramHashMap = paramHashMap;
        i = 0;
      }
    }
    if (i == 0) {}
    return false;
  }
  
  /* Error */
  public static boolean verifySignature(File paramFile)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore_3
    //   2: aconst_null
    //   3: astore 4
    //   5: aconst_null
    //   6: astore 5
    //   8: new 543	java/util/jar/JarFile
    //   11: dup
    //   12: aload_0
    //   13: invokespecial 546	java/util/jar/JarFile:<init>	(Ljava/io/File;)V
    //   16: astore_0
    //   17: aload 4
    //   19: astore_3
    //   20: aload_0
    //   21: ldc_w 548
    //   24: invokevirtual 552	java/util/jar/JarFile:getJarEntry	(Ljava/lang/String;)Ljava/util/jar/JarEntry;
    //   27: astore 5
    //   29: aload 5
    //   31: ifnonnull +25 -> 56
    //   34: iconst_0
    //   35: ifeq +11 -> 46
    //   38: new 554	java/lang/NullPointerException
    //   41: dup
    //   42: invokespecial 555	java/lang/NullPointerException:<init>	()V
    //   45: athrow
    //   46: aload_0
    //   47: ifnull +7 -> 54
    //   50: aload_0
    //   51: invokevirtual 558	java/util/jar/JarFile:close	()V
    //   54: iconst_0
    //   55: ireturn
    //   56: aload 4
    //   58: astore_3
    //   59: sipush 8192
    //   62: newarray byte
    //   64: astore 6
    //   66: aload 4
    //   68: astore_3
    //   69: aload_0
    //   70: aload 5
    //   72: invokevirtual 562	java/util/jar/JarFile:getInputStream	(Ljava/util/zip/ZipEntry;)Ljava/io/InputStream;
    //   75: astore 4
    //   77: aload 4
    //   79: astore_3
    //   80: aload 4
    //   82: aload 6
    //   84: iconst_0
    //   85: aload 6
    //   87: arraylength
    //   88: invokevirtual 568	java/io/InputStream:read	([BII)I
    //   91: iconst_m1
    //   92: if_icmpne -15 -> 77
    //   95: aload 4
    //   97: astore_3
    //   98: aload 4
    //   100: invokevirtual 569	java/io/InputStream:close	()V
    //   103: aload 4
    //   105: astore_3
    //   106: aload 5
    //   108: invokevirtual 575	java/util/jar/JarEntry:getCertificates	()[Ljava/security/cert/Certificate;
    //   111: astore 5
    //   113: aload 4
    //   115: astore_3
    //   116: aload 5
    //   118: arraylength
    //   119: istore_1
    //   120: iload_1
    //   121: iconst_1
    //   122: if_icmpge +26 -> 148
    //   125: aload 4
    //   127: ifnull +8 -> 135
    //   130: aload 4
    //   132: invokevirtual 569	java/io/InputStream:close	()V
    //   135: aload_0
    //   136: ifnull -82 -> 54
    //   139: aload_0
    //   140: invokevirtual 558	java/util/jar/JarFile:close	()V
    //   143: iconst_0
    //   144: ireturn
    //   145: astore_0
    //   146: iconst_0
    //   147: ireturn
    //   148: aload 4
    //   150: astore_3
    //   151: aload 5
    //   153: iconst_0
    //   154: aaload
    //   155: invokestatic 577	com/tencent/smtt/sdk/stat/MttLoader:a	(Ljava/security/cert/Certificate;)Ljava/lang/String;
    //   158: astore 5
    //   160: aload 5
    //   162: ifnull +39 -> 201
    //   165: aload 4
    //   167: astore_3
    //   168: aload 5
    //   170: ldc_w 579
    //   173: invokevirtual 112	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   176: istore_2
    //   177: iload_2
    //   178: ifeq +23 -> 201
    //   181: aload 4
    //   183: ifnull +8 -> 191
    //   186: aload 4
    //   188: invokevirtual 569	java/io/InputStream:close	()V
    //   191: aload_0
    //   192: ifnull +7 -> 199
    //   195: aload_0
    //   196: invokevirtual 558	java/util/jar/JarFile:close	()V
    //   199: iconst_1
    //   200: ireturn
    //   201: aload 4
    //   203: ifnull +8 -> 211
    //   206: aload 4
    //   208: invokevirtual 569	java/io/InputStream:close	()V
    //   211: aload_0
    //   212: ifnull -158 -> 54
    //   215: aload_0
    //   216: invokevirtual 558	java/util/jar/JarFile:close	()V
    //   219: iconst_0
    //   220: ireturn
    //   221: astore_0
    //   222: iconst_0
    //   223: ireturn
    //   224: astore_0
    //   225: aconst_null
    //   226: astore_3
    //   227: aload 5
    //   229: astore_0
    //   230: aload_3
    //   231: ifnull +7 -> 238
    //   234: aload_3
    //   235: invokevirtual 569	java/io/InputStream:close	()V
    //   238: aload_0
    //   239: ifnull -185 -> 54
    //   242: aload_0
    //   243: invokevirtual 558	java/util/jar/JarFile:close	()V
    //   246: iconst_0
    //   247: ireturn
    //   248: astore_0
    //   249: iconst_0
    //   250: ireturn
    //   251: astore 4
    //   253: aconst_null
    //   254: astore_0
    //   255: aload_3
    //   256: ifnull +7 -> 263
    //   259: aload_3
    //   260: invokevirtual 569	java/io/InputStream:close	()V
    //   263: aload_0
    //   264: ifnull +7 -> 271
    //   267: aload_0
    //   268: invokevirtual 558	java/util/jar/JarFile:close	()V
    //   271: aload 4
    //   273: athrow
    //   274: astore_3
    //   275: goto -229 -> 46
    //   278: astore_0
    //   279: iconst_0
    //   280: ireturn
    //   281: astore_3
    //   282: goto -147 -> 135
    //   285: astore_3
    //   286: goto -95 -> 191
    //   289: astore_0
    //   290: goto -91 -> 199
    //   293: astore_3
    //   294: goto -83 -> 211
    //   297: astore_3
    //   298: goto -60 -> 238
    //   301: astore_3
    //   302: goto -39 -> 263
    //   305: astore_0
    //   306: goto -35 -> 271
    //   309: astore 4
    //   311: goto -56 -> 255
    //   314: astore_3
    //   315: aconst_null
    //   316: astore_3
    //   317: goto -87 -> 230
    //   320: astore_3
    //   321: aload 4
    //   323: astore_3
    //   324: goto -94 -> 230
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	327	0	paramFile	File
    //   119	4	1	i	int
    //   176	2	2	bool	boolean
    //   1	259	3	localObject1	Object
    //   274	1	3	localIOException1	java.io.IOException
    //   281	1	3	localIOException2	java.io.IOException
    //   285	1	3	localIOException3	java.io.IOException
    //   293	1	3	localIOException4	java.io.IOException
    //   297	1	3	localIOException5	java.io.IOException
    //   301	1	3	localIOException6	java.io.IOException
    //   314	1	3	localThrowable1	Throwable
    //   316	1	3	localObject2	Object
    //   320	1	3	localThrowable2	Throwable
    //   323	1	3	localObject3	Object
    //   3	204	4	localInputStream	java.io.InputStream
    //   251	21	4	localObject4	Object
    //   309	13	4	localObject5	Object
    //   6	222	5	localObject6	Object
    //   64	22	6	arrayOfByte	byte[]
    // Exception table:
    //   from	to	target	type
    //   139	143	145	java/io/IOException
    //   215	219	221	java/io/IOException
    //   8	17	224	java/lang/Throwable
    //   242	246	248	java/io/IOException
    //   8	17	251	finally
    //   38	46	274	java/io/IOException
    //   50	54	278	java/io/IOException
    //   130	135	281	java/io/IOException
    //   186	191	285	java/io/IOException
    //   195	199	289	java/io/IOException
    //   206	211	293	java/io/IOException
    //   234	238	297	java/io/IOException
    //   259	263	301	java/io/IOException
    //   267	271	305	java/io/IOException
    //   20	29	309	finally
    //   59	66	309	finally
    //   69	77	309	finally
    //   80	95	309	finally
    //   98	103	309	finally
    //   106	113	309	finally
    //   116	120	309	finally
    //   151	160	309	finally
    //   168	177	309	finally
    //   20	29	314	java/lang/Throwable
    //   59	66	314	java/lang/Throwable
    //   69	77	314	java/lang/Throwable
    //   80	95	320	java/lang/Throwable
    //   98	103	320	java/lang/Throwable
    //   106	113	320	java/lang/Throwable
    //   116	120	320	java/lang/Throwable
    //   151	160	320	java/lang/Throwable
    //   168	177	320	java/lang/Throwable
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.smtt.sdk.stat.MttLoader
 * JD-Core Version:    0.7.0.1
 */