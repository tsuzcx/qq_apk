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
import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.smtt.sdk.WebView;
import java.io.File;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.security.cert.Certificate;
import java.security.cert.CertificateEncodingException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

public class MttLoader
{
  private static final int BROWSER_MTT = 2;
  private static final int BROWSER_NONE = -1;
  private static final int BROWSER_QBX = 0;
  private static final int BROWSER_QBX5 = 1;
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
  private static final String LOGIN_TYPE_KEY = "loginType";
  private static final String LOGIN_TYPE_KEY_ANCHOR_POINT = "AnchorPoint";
  private static final String LOGIN_TYPE_KEY_CONTENT_SIZE = "ContentSize";
  private static final int LOGIN_TYPE_VALUE_MM = 24;
  private static final int LOGIN_TYPE_VALUE_OTHERS = 26;
  private static final int LOGIN_TYPE_VALUE_QQ = 13;
  private static final int LOGIN_TYPE_VALUE_QQMICROBLOG = 15;
  private static final int LOGIN_TYPE_VALUE_QZONE = 14;
  public static final String MTT_ACTION = "com.tencent.QQBrowser.action.VIEW";
  public static final String MTT_ACTION_SP = "com.tencent.QQBrowser.action.VIEWSP";
  private static final String MTT_PACKAGE_MTT = "com.tencent.mtt";
  private static final String MTT_PACKAGE_MTT_X86 = "com.tencent.mtt.x86";
  private static final String MTT_PACKAGE_QBX = "com.tencent.qbx";
  private static final String MTT_PACKAGE_QBX5 = "com.tencent.qbx5";
  private static final String MTT_SIG = "3082023f308201a8a00302010202044c46914a300d06092a864886f70d01010505003064310b30090603550406130238363110300e060355040813074265696a696e673110300e060355040713074265696a696e673110300e060355040a130754656e63656e74310c300a060355040b13035753443111300f0603550403130873616d75656c6d6f301e170d3130303732313036313835305a170d3430303731333036313835305a3064310b30090603550406130238363110300e060355040813074265696a696e673110300e060355040713074265696a696e673110300e060355040a130754656e63656e74310c300a060355040b13035753443111300f0603550403130873616d75656c6d6f30819f300d06092a864886f70d010101050003818d0030818902818100c209077044bd0d63ea00ede5b839914cabcc912a87f0f8b390877e0f7a2583f0d5933443c40431c35a4433bc4c965800141961adc44c9625b1d321385221fd097e5bdc2f44a1840d643ab59dc070cf6c4b4b4d98bed5cbb8046e0a7078ae134da107cdf2bfc9b440fe5cb2f7549b44b73202cc6f7c2c55b8cfb0d333a021f01f0203010001300d06092a864886f70d010105050003818100b007db9922774ef4ccfee81ba514a8d57c410257e7a2eba64bfa17c9e690da08106d32f637ac41fbc9f205176c71bde238c872c3ee2f8313502bee44c80288ea4ef377a6f2cdfe4d3653c145c4acfedbfbadea23b559d41980cc3cdd35d79a68240693739aabf5c5ed26148756cf88264226de394c8a24ac35b712b120d4d23a";
  public static final String PID_ARTICLE_NEWS = "21272";
  public static final String PID_MOBILE_QQ = "50079";
  public static final String PID_QQPIM = "50190";
  public static final String PID_QZONE = "10494";
  public static final String PID_WECHAT = "10318";
  public static final String POS_ID = "PosID";
  public static final String QQBROWSER_DIRECT_DOWNLOAD_URL = "http://mdc.html5.qq.com/d/directdown.jsp?channel_id=50079";
  public static final String QQBROWSER_DOWNLOAD_URL = "http://mdc.html5.qq.com/mh?channel_id=50079&u=";
  private static final String QQBROWSER_PARAMS_ENCODE = ",encoded=1";
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
  private static final int SUPPORT_3RD_PARTY_CALL_VERSION = 33;
  private static final int SUPPORT_QB_SCHEME_VERSION = 42;
  private static final int VERSION_420 = 420000;
  private static final int VERSION_580 = 580000;
  private static final int VERSION_601 = 601000;
  
  private static String certToCharsString(Certificate paramCertificate)
    throws CertificateEncodingException
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
  
  private static BrowserPackageInfo chooseClassName(Context paramContext, Uri paramUri)
  {
    Object localObject = new Intent("com.tencent.QQBrowser.action.VIEW");
    ((Intent)localObject).setData(paramUri);
    paramUri = paramContext.getPackageManager().queryIntentActivities((Intent)localObject, 0);
    if (paramUri.size() <= 0) {
      return null;
    }
    paramContext = new BrowserPackageInfo(null);
    paramUri = paramUri.iterator();
    while (paramUri.hasNext())
    {
      localObject = (ResolveInfo)paramUri.next();
      String str = ((ResolveInfo)localObject).activityInfo.packageName;
      if (str.contains("com.tencent.mtt"))
      {
        paramContext.classname = ((ResolveInfo)localObject).activityInfo.name;
        paramContext.packagename = ((ResolveInfo)localObject).activityInfo.packageName;
        return paramContext;
      }
      if (str.contains("com.tencent.qbx"))
      {
        paramContext.classname = ((ResolveInfo)localObject).activityInfo.name;
        paramContext.packagename = ((ResolveInfo)localObject).activityInfo.packageName;
      }
    }
    return paramContext;
  }
  
  public static BrowserInfo getBrowserInfo(Context paramContext)
  {
    boolean bool = paramContext.getApplicationContext().getSharedPreferences("x5_proxy_setting", 0).getBoolean("qb_install_status", false);
    localBrowserInfo = new BrowserInfo();
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
                localObject6 = chooseClassName(paramContext, Uri.parse("http://mdc.html5.qq.com/mh?channel_id=50079&u="));
                paramContext = localObject2;
                if (localObject6 == null) {
                  continue;
                }
                paramContext = localObject2;
                localObject5 = localObject2;
                if (TextUtils.isEmpty(((BrowserPackageInfo)localObject6).packagename)) {
                  continue;
                }
                localObject5 = localObject2;
                paramContext = localPackageManager.getPackageInfo(((BrowserPackageInfo)localObject6).packagename, 0);
                localObject5 = paramContext;
                localBrowserInfo.packageName = ((BrowserPackageInfo)localObject6).packagename;
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
      paramString = "http://mdc.html5.qq.com/mh?channel_id=50079&u=" + URLEncoder.encode(paramString, "UTF-8");
      return paramString;
    }
    catch (UnsupportedEncodingException paramString)
    {
      paramString.printStackTrace();
    }
    return "http://mdc.html5.qq.com/mh?channel_id=50079&u=";
  }
  
  private static int getLoginType(Context paramContext)
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
  
  private static boolean hasValidProtocal(String paramString)
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
    if (!hasValidProtocal(paramString)) {
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
    if (((BrowserInfo)localObject2).browserType == -1) {
      return 4;
    }
    if ((((BrowserInfo)localObject2).browserType == 2) && (((BrowserInfo)localObject2).ver < 33)) {
      return 5;
    }
    paramString = new Intent("android.intent.action.VIEW");
    if (((BrowserInfo)localObject2).browserType == 2) {
      if ((((BrowserInfo)localObject2).ver >= 33) && (((BrowserInfo)localObject2).ver <= 39)) {
        paramString.setClassName("com.tencent.mtt", "com.tencent.mtt.MainActivity");
      }
    }
    label606:
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
                if ((((BrowserInfo)localObject2).ver >= 40) && (((BrowserInfo)localObject2).ver <= 45))
                {
                  paramString.setClassName("com.tencent.mtt", "com.tencent.mtt.SplashActivity");
                  break;
                }
                if (((BrowserInfo)localObject2).ver < 46) {
                  break label606;
                }
                paramString = new Intent("com.tencent.QQBrowser.action.VIEW");
                localObject2 = chooseClassName(paramContext, (Uri)localObject1);
                if ((localObject2 != null) && (!TextUtils.isEmpty(((BrowserPackageInfo)localObject2).classname))) {
                  paramString.setClassName(((BrowserPackageInfo)localObject2).packagename, ((BrowserPackageInfo)localObject2).classname);
                }
                break;
                if (((BrowserInfo)localObject2).browserType == 1)
                {
                  if (((BrowserInfo)localObject2).ver == 1)
                  {
                    paramString.setClassName("com.tencent.qbx5", "com.tencent.qbx5.MainActivity");
                    break;
                  }
                  if (((BrowserInfo)localObject2).ver != 2) {
                    break label606;
                  }
                  paramString.setClassName("com.tencent.qbx5", "com.tencent.qbx5.SplashActivity");
                  break;
                }
                if (((BrowserInfo)localObject2).browserType == 0)
                {
                  if ((((BrowserInfo)localObject2).ver >= 4) && (((BrowserInfo)localObject2).ver <= 6))
                  {
                    paramString.setClassName("com.tencent.qbx", "com.tencent.qbx.SplashActivity");
                    break;
                  }
                  if (((BrowserInfo)localObject2).ver <= 6) {
                    break label606;
                  }
                  paramString = new Intent("com.tencent.QQBrowser.action.VIEW");
                  localObject2 = chooseClassName(paramContext, (Uri)localObject1);
                  if ((localObject2 != null) && (!TextUtils.isEmpty(((BrowserPackageInfo)localObject2).classname))) {
                    paramString.setClassName(((BrowserPackageInfo)localObject2).packagename, ((BrowserPackageInfo)localObject2).classname);
                  }
                  break;
                }
                paramString = new Intent("com.tencent.QQBrowser.action.VIEW");
                localObject2 = chooseClassName(paramContext, (Uri)localObject1);
                if ((localObject2 != null) && (!TextUtils.isEmpty(((BrowserPackageInfo)localObject2).classname))) {
                  paramString.setClassName(((BrowserPackageInfo)localObject2).packagename, ((BrowserPackageInfo)localObject2).classname);
                }
                break;
              }
            }
          }
        }
      }
      try
      {
        paramString.putExtra("loginType", getLoginType(paramContext));
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
      localStringBuilder.append("mttbrowser://url=").append(paramString1).append(",product=").append("TBS").append(",packagename=").append(paramContext.getPackageName()).append(",from=").append(paramString2).append(",version=").append("3.6.0.1214").append((String)localObject);
      return loadUrl(paramContext, localStringBuilder.toString(), paramHashMap, paramWebView);
    }
  }
  
  public static boolean openDocWithQb(Context paramContext, String paramString1, int paramInt, String paramString2, HashMap<String, String> paramHashMap)
  {
    return openDocWithQb(paramContext, paramString1, paramInt, paramString2, paramHashMap, null);
  }
  
  public static boolean openDocWithQb(Context paramContext, String paramString1, int paramInt, String paramString2, HashMap<String, String> paramHashMap, Bundle paramBundle)
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
      paramHashMap = new File(paramString1);
    }
    catch (Exception paramContext)
    {
      paramContext.printStackTrace();
      return false;
    }
    localIntent.putExtra("key_reader_sdk_id", 3);
    localIntent.putExtra("key_reader_sdk_type", paramInt);
    if (paramInt == 0) {
      localIntent.putExtra("key_reader_sdk_path", paramString1);
    }
    for (;;)
    {
      localIntent.putExtra("key_reader_sdk_format", paramString2);
      localIntent.setDataAndType(Uri.fromFile(paramHashMap), "mtt/" + paramString2);
      localIntent.putExtra("loginType", getLoginType(paramContext.getApplicationContext()));
      if (paramBundle != null) {
        localIntent.putExtra("key_reader_sdk_extrals", paramBundle);
      }
      paramContext.startActivity(localIntent);
      return true;
      if (paramInt == 1) {
        localIntent.putExtra("key_reader_sdk_url", paramString1);
      }
    }
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
      paramString.putExtra("loginType", getLoginType(paramContext));
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
    //   1: astore 5
    //   3: aconst_null
    //   4: astore 4
    //   6: aconst_null
    //   7: astore_3
    //   8: new 571	java/util/jar/JarFile
    //   11: dup
    //   12: aload_0
    //   13: invokespecial 574	java/util/jar/JarFile:<init>	(Ljava/io/File;)V
    //   16: astore_0
    //   17: aload 4
    //   19: astore_3
    //   20: aload_0
    //   21: ldc_w 576
    //   24: invokevirtual 580	java/util/jar/JarFile:getJarEntry	(Ljava/lang/String;)Ljava/util/jar/JarEntry;
    //   27: astore 5
    //   29: aload 5
    //   31: ifnonnull +25 -> 56
    //   34: iconst_0
    //   35: ifeq +11 -> 46
    //   38: new 582	java/lang/NullPointerException
    //   41: dup
    //   42: invokespecial 583	java/lang/NullPointerException:<init>	()V
    //   45: athrow
    //   46: aload_0
    //   47: ifnull +7 -> 54
    //   50: aload_0
    //   51: invokevirtual 586	java/util/jar/JarFile:close	()V
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
    //   72: invokevirtual 590	java/util/jar/JarFile:getInputStream	(Ljava/util/zip/ZipEntry;)Ljava/io/InputStream;
    //   75: astore 4
    //   77: aload 4
    //   79: astore_3
    //   80: aload 4
    //   82: aload 6
    //   84: iconst_0
    //   85: aload 6
    //   87: arraylength
    //   88: invokevirtual 596	java/io/InputStream:read	([BII)I
    //   91: iconst_m1
    //   92: if_icmpne -15 -> 77
    //   95: aload 4
    //   97: astore_3
    //   98: aload 4
    //   100: invokevirtual 597	java/io/InputStream:close	()V
    //   103: aload 4
    //   105: astore_3
    //   106: aload 5
    //   108: invokevirtual 603	java/util/jar/JarEntry:getCertificates	()[Ljava/security/cert/Certificate;
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
    //   132: invokevirtual 597	java/io/InputStream:close	()V
    //   135: aload_0
    //   136: ifnull -82 -> 54
    //   139: aload_0
    //   140: invokevirtual 586	java/util/jar/JarFile:close	()V
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
    //   155: invokestatic 605	com/tencent/smtt/sdk/stat/MttLoader:certToCharsString	(Ljava/security/cert/Certificate;)Ljava/lang/String;
    //   158: astore 5
    //   160: aload 5
    //   162: ifnull +113 -> 275
    //   165: aload 4
    //   167: astore_3
    //   168: aload 5
    //   170: ldc 82
    //   172: invokevirtual 356	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   175: istore_2
    //   176: iload_2
    //   177: ifeq +98 -> 275
    //   180: aload 4
    //   182: ifnull +8 -> 190
    //   185: aload 4
    //   187: invokevirtual 597	java/io/InputStream:close	()V
    //   190: aload_0
    //   191: ifnull +7 -> 198
    //   194: aload_0
    //   195: invokevirtual 586	java/util/jar/JarFile:close	()V
    //   198: iconst_1
    //   199: ireturn
    //   200: astore 4
    //   202: aconst_null
    //   203: astore_0
    //   204: aload_3
    //   205: ifnull +7 -> 212
    //   208: aload_3
    //   209: invokevirtual 597	java/io/InputStream:close	()V
    //   212: aload_0
    //   213: ifnull +7 -> 220
    //   216: aload_0
    //   217: invokevirtual 586	java/util/jar/JarFile:close	()V
    //   220: aload 4
    //   222: athrow
    //   223: astore_0
    //   224: aconst_null
    //   225: astore_0
    //   226: aload 5
    //   228: astore_3
    //   229: aload_0
    //   230: ifnull +7 -> 237
    //   233: aload_0
    //   234: invokevirtual 597	java/io/InputStream:close	()V
    //   237: aload_3
    //   238: ifnull -184 -> 54
    //   241: aload_3
    //   242: invokevirtual 586	java/util/jar/JarFile:close	()V
    //   245: iconst_0
    //   246: ireturn
    //   247: astore_0
    //   248: goto -11 -> 237
    //   251: astore_3
    //   252: goto -40 -> 212
    //   255: astore_0
    //   256: goto -36 -> 220
    //   259: astore_3
    //   260: goto -214 -> 46
    //   263: astore_3
    //   264: goto -129 -> 135
    //   267: astore_3
    //   268: goto -78 -> 190
    //   271: astore_0
    //   272: goto -74 -> 198
    //   275: aload 4
    //   277: ifnull +8 -> 285
    //   280: aload 4
    //   282: invokevirtual 597	java/io/InputStream:close	()V
    //   285: aload_0
    //   286: ifnull -232 -> 54
    //   289: aload_0
    //   290: invokevirtual 586	java/util/jar/JarFile:close	()V
    //   293: iconst_0
    //   294: ireturn
    //   295: astore_3
    //   296: goto -11 -> 285
    //   299: astore 4
    //   301: goto -97 -> 204
    //   304: astore_3
    //   305: aconst_null
    //   306: astore 4
    //   308: aload_0
    //   309: astore_3
    //   310: aload 4
    //   312: astore_0
    //   313: goto -84 -> 229
    //   316: astore_3
    //   317: aload_0
    //   318: astore_3
    //   319: aload 4
    //   321: astore_0
    //   322: goto -93 -> 229
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	325	0	paramFile	File
    //   119	4	1	i	int
    //   175	2	2	bool	boolean
    //   7	235	3	localObject1	Object
    //   251	1	3	localIOException1	java.io.IOException
    //   259	1	3	localIOException2	java.io.IOException
    //   263	1	3	localIOException3	java.io.IOException
    //   267	1	3	localIOException4	java.io.IOException
    //   295	1	3	localIOException5	java.io.IOException
    //   304	1	3	localThrowable1	Throwable
    //   309	1	3	localFile1	File
    //   316	1	3	localThrowable2	Throwable
    //   318	1	3	localFile2	File
    //   4	182	4	localInputStream	java.io.InputStream
    //   200	81	4	localObject2	Object
    //   299	1	4	localObject3	Object
    //   306	14	4	localObject4	Object
    //   1	226	5	localObject5	Object
    //   64	22	6	arrayOfByte	byte[]
    // Exception table:
    //   from	to	target	type
    //   50	54	145	java/io/IOException
    //   139	143	145	java/io/IOException
    //   241	245	145	java/io/IOException
    //   289	293	145	java/io/IOException
    //   8	17	200	finally
    //   8	17	223	java/lang/Throwable
    //   233	237	247	java/io/IOException
    //   208	212	251	java/io/IOException
    //   216	220	255	java/io/IOException
    //   38	46	259	java/io/IOException
    //   130	135	263	java/io/IOException
    //   185	190	267	java/io/IOException
    //   194	198	271	java/io/IOException
    //   280	285	295	java/io/IOException
    //   20	29	299	finally
    //   59	66	299	finally
    //   69	77	299	finally
    //   80	95	299	finally
    //   98	103	299	finally
    //   106	113	299	finally
    //   116	120	299	finally
    //   151	160	299	finally
    //   168	176	299	finally
    //   20	29	304	java/lang/Throwable
    //   59	66	304	java/lang/Throwable
    //   69	77	304	java/lang/Throwable
    //   80	95	316	java/lang/Throwable
    //   98	103	316	java/lang/Throwable
    //   106	113	316	java/lang/Throwable
    //   116	120	316	java/lang/Throwable
    //   151	160	316	java/lang/Throwable
    //   168	176	316	java/lang/Throwable
  }
  
  public static class BrowserInfo
  {
    public int browserType = -1;
    public String packageName = null;
    public String quahead = "";
    public int ver = -1;
    public String vn = "0";
  }
  
  private static class BrowserPackageInfo
  {
    public String classname = "";
    public String packagename = "";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.smtt.sdk.stat.MttLoader
 * JD-Core Version:    0.7.0.1
 */