package com.tencent.smtt.sdk.stat;

import android.content.ActivityNotFoundException;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
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
    paramContext = paramContext.getApplicationInfo().processName;
    if (paramContext.equals("com.tencent.mobileqq")) {
      return 13;
    }
    if (paramContext.equals("com.qzone")) {
      return 14;
    }
    if (paramContext.equals("com.tencent.WBlog")) {
      return 15;
    }
    if (paramContext.equals("com.tencent.mm")) {
      return 24;
    }
    return 26;
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
    while (i < k)
    {
      int n = paramCertificate[i];
      int j = n >> 4 & 0xF;
      int m = i * 2;
      if (j >= 10) {
        j = j + 97 - 10;
      } else {
        j += 48;
      }
      arrayOfChar[m] = ((char)j);
      j = n & 0xF;
      if (j >= 10) {
        j = j + 97 - 10;
      } else {
        j += 48;
      }
      arrayOfChar[(m + 1)] = ((char)j);
      i += 1;
    }
    return new String(arrayOfChar);
  }
  
  private static boolean a(String paramString)
  {
    if (paramString != null)
    {
      if (paramString.length() == 0) {
        return false;
      }
      paramString = paramString.trim();
      int i = paramString.toLowerCase().indexOf("://");
      int j = paramString.toLowerCase().indexOf('.');
      if ((i > 0) && (j > 0) && (i > j)) {
        return false;
      }
      return paramString.toLowerCase().contains("://");
    }
    return false;
  }
  
  /* Error */
  public static MttLoader.BrowserInfo getBrowserInfo(Context paramContext)
  {
    // Byte code:
    //   0: aload_0
    //   1: invokevirtual 235	android/content/Context:getApplicationContext	()Landroid/content/Context;
    //   4: ldc 237
    //   6: iconst_0
    //   7: invokevirtual 241	android/content/Context:getSharedPreferences	(Ljava/lang/String;I)Landroid/content/SharedPreferences;
    //   10: ldc 243
    //   12: iconst_0
    //   13: invokeinterface 249 3 0
    //   18: istore_1
    //   19: new 251	com/tencent/smtt/sdk/stat/MttLoader$BrowserInfo
    //   22: dup
    //   23: invokespecial 252	com/tencent/smtt/sdk/stat/MttLoader$BrowserInfo:<init>	()V
    //   26: astore 5
    //   28: iload_1
    //   29: ifeq +6 -> 35
    //   32: aload 5
    //   34: areturn
    //   35: aload_0
    //   36: invokevirtual 137	android/content/Context:getPackageManager	()Landroid/content/pm/PackageManager;
    //   39: astore 6
    //   41: aconst_null
    //   42: astore_2
    //   43: aload 6
    //   45: ldc 181
    //   47: iconst_0
    //   48: invokevirtual 256	android/content/pm/PackageManager:getPackageInfo	(Ljava/lang/String;I)Landroid/content/pm/PackageInfo;
    //   51: astore 4
    //   53: aload 4
    //   55: astore_2
    //   56: aload 5
    //   58: iconst_2
    //   59: putfield 259	com/tencent/smtt/sdk/stat/MttLoader$BrowserInfo:browserType	I
    //   62: aload 4
    //   64: astore_2
    //   65: aload 5
    //   67: ldc 181
    //   69: putfield 260	com/tencent/smtt/sdk/stat/MttLoader$BrowserInfo:packageName	Ljava/lang/String;
    //   72: aload 4
    //   74: astore_2
    //   75: aload 5
    //   77: ldc_w 262
    //   80: putfield 265	com/tencent/smtt/sdk/stat/MttLoader$BrowserInfo:quahead	Ljava/lang/String;
    //   83: aload 4
    //   85: astore_3
    //   86: aload 4
    //   88: ifnull +116 -> 204
    //   91: aload 4
    //   93: astore_3
    //   94: aload 4
    //   96: astore_2
    //   97: aload 4
    //   99: getfield 270	android/content/pm/PackageInfo:versionCode	I
    //   102: ldc_w 271
    //   105: if_icmple +99 -> 204
    //   108: aload 4
    //   110: astore_2
    //   111: aload 5
    //   113: aload 4
    //   115: getfield 270	android/content/pm/PackageInfo:versionCode	I
    //   118: putfield 274	com/tencent/smtt/sdk/stat/MttLoader$BrowserInfo:ver	I
    //   121: aload 4
    //   123: astore_2
    //   124: new 276	java/lang/StringBuilder
    //   127: dup
    //   128: invokespecial 277	java/lang/StringBuilder:<init>	()V
    //   131: astore_3
    //   132: aload 4
    //   134: astore_2
    //   135: aload_3
    //   136: aload 5
    //   138: getfield 265	com/tencent/smtt/sdk/stat/MttLoader$BrowserInfo:quahead	Ljava/lang/String;
    //   141: invokevirtual 281	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   144: pop
    //   145: aload 4
    //   147: astore_2
    //   148: aload_3
    //   149: aload 4
    //   151: getfield 284	android/content/pm/PackageInfo:versionName	Ljava/lang/String;
    //   154: ldc_w 286
    //   157: ldc_w 288
    //   160: invokevirtual 292	java/lang/String:replaceAll	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   163: invokevirtual 281	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   166: pop
    //   167: aload 4
    //   169: astore_2
    //   170: aload 5
    //   172: aload_3
    //   173: invokevirtual 295	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   176: putfield 265	com/tencent/smtt/sdk/stat/MttLoader$BrowserInfo:quahead	Ljava/lang/String;
    //   179: aload 4
    //   181: astore_2
    //   182: aload 5
    //   184: aload 4
    //   186: getfield 284	android/content/pm/PackageInfo:versionName	Ljava/lang/String;
    //   189: ldc_w 286
    //   192: ldc_w 288
    //   195: invokevirtual 292	java/lang/String:replaceAll	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   198: putfield 298	com/tencent/smtt/sdk/stat/MttLoader$BrowserInfo:vn	Ljava/lang/String;
    //   201: aload 5
    //   203: areturn
    //   204: aload 6
    //   206: ldc 195
    //   208: iconst_0
    //   209: invokevirtual 256	android/content/pm/PackageManager:getPackageInfo	(Ljava/lang/String;I)Landroid/content/pm/PackageInfo;
    //   212: astore_2
    //   213: aload_2
    //   214: astore_3
    //   215: aload 5
    //   217: iconst_0
    //   218: putfield 259	com/tencent/smtt/sdk/stat/MttLoader$BrowserInfo:browserType	I
    //   221: aload_2
    //   222: astore_3
    //   223: aload 5
    //   225: ldc 195
    //   227: putfield 260	com/tencent/smtt/sdk/stat/MttLoader$BrowserInfo:packageName	Ljava/lang/String;
    //   230: aload_2
    //   231: astore_3
    //   232: aload 5
    //   234: ldc_w 300
    //   237: putfield 265	com/tencent/smtt/sdk/stat/MttLoader$BrowserInfo:quahead	Ljava/lang/String;
    //   240: aload_2
    //   241: astore_0
    //   242: goto +197 -> 439
    //   245: aload 6
    //   247: ldc_w 302
    //   250: iconst_0
    //   251: invokevirtual 256	android/content/pm/PackageManager:getPackageInfo	(Ljava/lang/String;I)Landroid/content/pm/PackageInfo;
    //   254: astore_2
    //   255: aload_2
    //   256: astore_3
    //   257: aload 5
    //   259: iconst_1
    //   260: putfield 259	com/tencent/smtt/sdk/stat/MttLoader$BrowserInfo:browserType	I
    //   263: aload_2
    //   264: astore_3
    //   265: aload 5
    //   267: ldc_w 302
    //   270: putfield 260	com/tencent/smtt/sdk/stat/MttLoader$BrowserInfo:packageName	Ljava/lang/String;
    //   273: aload_2
    //   274: astore_3
    //   275: aload 5
    //   277: ldc_w 304
    //   280: putfield 265	com/tencent/smtt/sdk/stat/MttLoader$BrowserInfo:quahead	Ljava/lang/String;
    //   283: aload_2
    //   284: astore_0
    //   285: goto +154 -> 439
    //   288: aload_3
    //   289: astore_2
    //   290: aload 6
    //   292: ldc 181
    //   294: iconst_0
    //   295: invokevirtual 256	android/content/pm/PackageManager:getPackageInfo	(Ljava/lang/String;I)Landroid/content/pm/PackageInfo;
    //   298: astore_3
    //   299: aload_3
    //   300: astore_2
    //   301: aload 5
    //   303: ldc 181
    //   305: putfield 260	com/tencent/smtt/sdk/stat/MttLoader$BrowserInfo:packageName	Ljava/lang/String;
    //   308: aload_3
    //   309: astore_2
    //   310: aload 5
    //   312: iconst_2
    //   313: putfield 259	com/tencent/smtt/sdk/stat/MttLoader$BrowserInfo:browserType	I
    //   316: aload_3
    //   317: astore_2
    //   318: aload 5
    //   320: ldc_w 262
    //   323: putfield 265	com/tencent/smtt/sdk/stat/MttLoader$BrowserInfo:quahead	Ljava/lang/String;
    //   326: aload_3
    //   327: astore_0
    //   328: goto +111 -> 439
    //   331: aload 6
    //   333: ldc_w 306
    //   336: iconst_0
    //   337: invokevirtual 256	android/content/pm/PackageManager:getPackageInfo	(Ljava/lang/String;I)Landroid/content/pm/PackageInfo;
    //   340: astore_3
    //   341: aload_3
    //   342: astore_2
    //   343: aload 5
    //   345: ldc_w 306
    //   348: putfield 260	com/tencent/smtt/sdk/stat/MttLoader$BrowserInfo:packageName	Ljava/lang/String;
    //   351: aload_3
    //   352: astore_2
    //   353: aload 5
    //   355: iconst_2
    //   356: putfield 259	com/tencent/smtt/sdk/stat/MttLoader$BrowserInfo:browserType	I
    //   359: aload_3
    //   360: astore_2
    //   361: aload 5
    //   363: ldc_w 262
    //   366: putfield 265	com/tencent/smtt/sdk/stat/MttLoader$BrowserInfo:quahead	Ljava/lang/String;
    //   369: aload_3
    //   370: astore_0
    //   371: goto +68 -> 439
    //   374: aload_0
    //   375: ldc 55
    //   377: invokestatic 312	android/net/Uri:parse	(Ljava/lang/String;)Landroid/net/Uri;
    //   380: invokestatic 314	com/tencent/smtt/sdk/stat/MttLoader:a	(Landroid/content/Context;Landroid/net/Uri;)Lcom/tencent/smtt/sdk/stat/MttLoader$a;
    //   383: astore_3
    //   384: aload_2
    //   385: astore_0
    //   386: aload_3
    //   387: ifnull +52 -> 439
    //   390: aload_2
    //   391: astore_0
    //   392: aload_3
    //   393: getfield 193	com/tencent/smtt/sdk/stat/MttLoader$a:b	Ljava/lang/String;
    //   396: invokestatic 319	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   399: ifne +40 -> 439
    //   402: aload 6
    //   404: aload_3
    //   405: getfield 193	com/tencent/smtt/sdk/stat/MttLoader$a:b	Ljava/lang/String;
    //   408: iconst_0
    //   409: invokevirtual 256	android/content/pm/PackageManager:getPackageInfo	(Ljava/lang/String;I)Landroid/content/pm/PackageInfo;
    //   412: astore_0
    //   413: aload 5
    //   415: aload_3
    //   416: getfield 193	com/tencent/smtt/sdk/stat/MttLoader$a:b	Ljava/lang/String;
    //   419: putfield 260	com/tencent/smtt/sdk/stat/MttLoader$BrowserInfo:packageName	Ljava/lang/String;
    //   422: aload 5
    //   424: iconst_2
    //   425: putfield 259	com/tencent/smtt/sdk/stat/MttLoader$BrowserInfo:browserType	I
    //   428: aload 5
    //   430: ldc_w 262
    //   433: putfield 265	com/tencent/smtt/sdk/stat/MttLoader$BrowserInfo:quahead	Ljava/lang/String;
    //   436: goto +3 -> 439
    //   439: aload_0
    //   440: ifnull +75 -> 515
    //   443: aload 5
    //   445: aload_0
    //   446: getfield 270	android/content/pm/PackageInfo:versionCode	I
    //   449: putfield 274	com/tencent/smtt/sdk/stat/MttLoader$BrowserInfo:ver	I
    //   452: new 276	java/lang/StringBuilder
    //   455: dup
    //   456: invokespecial 277	java/lang/StringBuilder:<init>	()V
    //   459: astore_2
    //   460: aload_2
    //   461: aload 5
    //   463: getfield 265	com/tencent/smtt/sdk/stat/MttLoader$BrowserInfo:quahead	Ljava/lang/String;
    //   466: invokevirtual 281	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   469: pop
    //   470: aload_2
    //   471: aload_0
    //   472: getfield 284	android/content/pm/PackageInfo:versionName	Ljava/lang/String;
    //   475: ldc_w 286
    //   478: ldc_w 288
    //   481: invokevirtual 292	java/lang/String:replaceAll	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   484: invokevirtual 281	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   487: pop
    //   488: aload 5
    //   490: aload_2
    //   491: invokevirtual 295	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   494: putfield 265	com/tencent/smtt/sdk/stat/MttLoader$BrowserInfo:quahead	Ljava/lang/String;
    //   497: aload 5
    //   499: aload_0
    //   500: getfield 284	android/content/pm/PackageInfo:versionName	Ljava/lang/String;
    //   503: ldc_w 286
    //   506: ldc_w 288
    //   509: invokevirtual 292	java/lang/String:replaceAll	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   512: putfield 298	com/tencent/smtt/sdk/stat/MttLoader$BrowserInfo:vn	Ljava/lang/String;
    //   515: aload 5
    //   517: areturn
    //   518: astore_0
    //   519: aload 5
    //   521: areturn
    //   522: astore_3
    //   523: aload_2
    //   524: astore_3
    //   525: goto -321 -> 204
    //   528: astore_2
    //   529: goto -284 -> 245
    //   532: astore_2
    //   533: goto -245 -> 288
    //   536: astore_3
    //   537: goto -206 -> 331
    //   540: astore_3
    //   541: goto -167 -> 374
    //   544: astore_0
    //   545: aload_2
    //   546: astore_0
    //   547: goto -108 -> 439
    //   550: astore_2
    //   551: goto -115 -> 436
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	554	0	paramContext	Context
    //   18	11	1	bool	boolean
    //   42	482	2	localObject1	Object
    //   528	1	2	localNameNotFoundException1	android.content.pm.PackageManager.NameNotFoundException
    //   532	14	2	localNameNotFoundException2	android.content.pm.PackageManager.NameNotFoundException
    //   550	1	2	localException1	Exception
    //   85	331	3	localObject2	Object
    //   522	1	3	localNameNotFoundException3	android.content.pm.PackageManager.NameNotFoundException
    //   524	1	3	localObject3	Object
    //   536	1	3	localNameNotFoundException4	android.content.pm.PackageManager.NameNotFoundException
    //   540	1	3	localException2	Exception
    //   51	134	4	localPackageInfo	PackageInfo
    //   26	494	5	localBrowserInfo	MttLoader.BrowserInfo
    //   39	364	6	localPackageManager	PackageManager
    // Exception table:
    //   from	to	target	type
    //   35	41	518	java/lang/Exception
    //   43	53	518	java/lang/Exception
    //   56	62	518	java/lang/Exception
    //   65	72	518	java/lang/Exception
    //   75	83	518	java/lang/Exception
    //   97	108	518	java/lang/Exception
    //   111	121	518	java/lang/Exception
    //   124	132	518	java/lang/Exception
    //   135	145	518	java/lang/Exception
    //   148	167	518	java/lang/Exception
    //   170	179	518	java/lang/Exception
    //   182	201	518	java/lang/Exception
    //   204	213	518	java/lang/Exception
    //   215	221	518	java/lang/Exception
    //   223	230	518	java/lang/Exception
    //   232	240	518	java/lang/Exception
    //   245	255	518	java/lang/Exception
    //   257	263	518	java/lang/Exception
    //   265	273	518	java/lang/Exception
    //   275	283	518	java/lang/Exception
    //   290	299	518	java/lang/Exception
    //   301	308	518	java/lang/Exception
    //   310	316	518	java/lang/Exception
    //   318	326	518	java/lang/Exception
    //   443	515	518	java/lang/Exception
    //   43	53	522	android/content/pm/PackageManager$NameNotFoundException
    //   56	62	522	android/content/pm/PackageManager$NameNotFoundException
    //   65	72	522	android/content/pm/PackageManager$NameNotFoundException
    //   75	83	522	android/content/pm/PackageManager$NameNotFoundException
    //   97	108	522	android/content/pm/PackageManager$NameNotFoundException
    //   111	121	522	android/content/pm/PackageManager$NameNotFoundException
    //   124	132	522	android/content/pm/PackageManager$NameNotFoundException
    //   135	145	522	android/content/pm/PackageManager$NameNotFoundException
    //   148	167	522	android/content/pm/PackageManager$NameNotFoundException
    //   170	179	522	android/content/pm/PackageManager$NameNotFoundException
    //   182	201	522	android/content/pm/PackageManager$NameNotFoundException
    //   204	213	528	android/content/pm/PackageManager$NameNotFoundException
    //   215	221	528	android/content/pm/PackageManager$NameNotFoundException
    //   223	230	528	android/content/pm/PackageManager$NameNotFoundException
    //   232	240	528	android/content/pm/PackageManager$NameNotFoundException
    //   245	255	532	android/content/pm/PackageManager$NameNotFoundException
    //   257	263	532	android/content/pm/PackageManager$NameNotFoundException
    //   265	273	532	android/content/pm/PackageManager$NameNotFoundException
    //   275	283	532	android/content/pm/PackageManager$NameNotFoundException
    //   290	299	536	android/content/pm/PackageManager$NameNotFoundException
    //   301	308	536	android/content/pm/PackageManager$NameNotFoundException
    //   310	316	536	android/content/pm/PackageManager$NameNotFoundException
    //   318	326	536	android/content/pm/PackageManager$NameNotFoundException
    //   331	341	540	java/lang/Exception
    //   343	351	540	java/lang/Exception
    //   353	359	540	java/lang/Exception
    //   361	369	540	java/lang/Exception
    //   374	384	544	java/lang/Exception
    //   392	413	544	java/lang/Exception
    //   413	436	550	java/lang/Exception
  }
  
  public static String getDownloadUrlWithQb(String paramString)
  {
    try
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("https://mdc.html5.qq.com/mh?channel_id=50079&u=");
      localStringBuilder.append(URLEncoder.encode(paramString, "UTF-8"));
      paramString = localStringBuilder.toString();
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
    if (paramString.toLowerCase().startsWith("qb://"))
    {
      paramContext = getBrowserInfo(paramContext);
      int j = paramContext.browserType;
      int i = 1;
      if ((j != -1) && ((paramContext.browserType != 2) || (paramContext.ver >= 33))) {
        i = 0;
      }
      if (i != 0) {
        return getDownloadUrlWithQb(paramString);
      }
    }
    return paramString;
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
      localNumberFormatException.printStackTrace();
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
      localNumberFormatException.printStackTrace();
    }
    if (paramContext.ver >= paramLong2) {
      return true;
    }
    return bool;
  }
  
  public static boolean isSupportQBScheme(Context paramContext)
  {
    paramContext = getBrowserInfo(paramContext);
    if (paramContext.browserType == -1) {
      return false;
    }
    return (paramContext.browserType != 2) || (paramContext.ver >= 42);
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
    if (!a(paramString))
    {
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append("http://");
      ((StringBuilder)localObject1).append(paramString);
      localObject1 = ((StringBuilder)localObject1).toString();
    }
    try
    {
      Object localObject3 = Uri.parse((String)localObject1);
      if (localObject3 == null) {
        return 2;
      }
      Object localObject2 = getBrowserInfo(paramContext);
      if (((MttLoader.BrowserInfo)localObject2).browserType == -1) {
        return 4;
      }
      if ((((MttLoader.BrowserInfo)localObject2).browserType == 2) && (((MttLoader.BrowserInfo)localObject2).ver < 33)) {
        return 5;
      }
      localObject1 = new Intent("android.intent.action.VIEW");
      if (((MttLoader.BrowserInfo)localObject2).browserType == 2)
      {
        if ((((MttLoader.BrowserInfo)localObject2).ver >= 33) && (((MttLoader.BrowserInfo)localObject2).ver <= 39)) {}
        for (paramString = "com.tencent.mtt.MainActivity";; paramString = "com.tencent.mtt.SplashActivity")
        {
          ((Intent)localObject1).setClassName("com.tencent.mtt", paramString);
          paramString = (String)localObject1;
          break label474;
          if ((((MttLoader.BrowserInfo)localObject2).ver < 40) || (((MttLoader.BrowserInfo)localObject2).ver > 45)) {
            break;
          }
        }
        paramString = (String)localObject1;
        if (((MttLoader.BrowserInfo)localObject2).ver >= 46)
        {
          localObject1 = new Intent("com.tencent.QQBrowser.action.VIEW");
          localObject2 = a(paramContext, (Uri)localObject3);
          paramString = (String)localObject1;
          if (localObject2 != null)
          {
            paramString = (String)localObject1;
            if (!TextUtils.isEmpty(((MttLoader.a)localObject2).a))
            {
              paramString = (String)localObject1;
              localObject1 = localObject2;
            }
          }
        }
      }
      else
      {
        for (;;)
        {
          paramString.setClassName(((MttLoader.a)localObject1).b, ((MttLoader.a)localObject1).a);
          break;
          if (((MttLoader.BrowserInfo)localObject2).browserType == 1)
          {
            if (((MttLoader.BrowserInfo)localObject2).ver == 1) {}
            for (paramString = "com.tencent.qbx5.MainActivity";; paramString = "com.tencent.qbx5.SplashActivity")
            {
              ((Intent)localObject1).setClassName("com.tencent.qbx5", paramString);
              paramString = (String)localObject1;
              break;
              paramString = (String)localObject1;
              if (((MttLoader.BrowserInfo)localObject2).ver != 2) {
                break;
              }
            }
          }
          if (((MttLoader.BrowserInfo)localObject2).browserType == 0)
          {
            if ((((MttLoader.BrowserInfo)localObject2).ver >= 4) && (((MttLoader.BrowserInfo)localObject2).ver <= 6))
            {
              ((Intent)localObject1).setClassName("com.tencent.qbx", "com.tencent.qbx.SplashActivity");
              paramString = (String)localObject1;
              break;
            }
            paramString = (String)localObject1;
            if (((MttLoader.BrowserInfo)localObject2).ver <= 6) {
              break;
            }
            localObject2 = new Intent("com.tencent.QQBrowser.action.VIEW");
            localObject1 = a(paramContext, (Uri)localObject3);
            paramString = (String)localObject2;
            if (localObject1 == null) {
              break;
            }
            paramString = (String)localObject2;
            if (TextUtils.isEmpty(((MttLoader.a)localObject1).a)) {
              break;
            }
            paramString = (String)localObject2;
          }
          else
          {
            localObject2 = new Intent("com.tencent.QQBrowser.action.VIEW");
            localObject1 = a(paramContext, (Uri)localObject3);
            paramString = (String)localObject2;
            if (localObject1 == null) {
              break;
            }
            paramString = (String)localObject2;
            if (TextUtils.isEmpty(((MttLoader.a)localObject1).a)) {
              break;
            }
            paramString = (String)localObject2;
          }
        }
      }
      label474:
      paramString.setData((Uri)localObject3);
      if (paramHashMap != null)
      {
        localObject1 = paramHashMap.keySet();
        if (localObject1 != null)
        {
          localObject1 = ((Set)localObject1).iterator();
          while (((Iterator)localObject1).hasNext())
          {
            localObject2 = (String)((Iterator)localObject1).next();
            localObject3 = (String)paramHashMap.get(localObject2);
            if (!TextUtils.isEmpty((CharSequence)localObject3)) {
              paramString.putExtra((String)localObject2, (String)localObject3);
            }
          }
        }
      }
      return 4;
    }
    catch (Exception paramContext)
    {
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
      catch (ActivityNotFoundException paramContext) {}
      paramContext = paramContext;
      return 2;
    }
  }
  
  public static int loadUrl(Context paramContext, String paramString1, HashMap<String, String> paramHashMap, String paramString2, WebView paramWebView)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    j = 0;
    try
    {
      localObject = paramContext.getPackageManager();
      if (localObject != null)
      {
        localObject = ((PackageManager)localObject).getPackageInfo("com.tencent.mtt", 0);
        if (localObject != null)
        {
          i = ((PackageInfo)localObject).versionCode;
          if (i > 601000) {
            i = 1;
          }
        }
      }
    }
    catch (Throwable localThrowable)
    {
      Object localObject;
      label59:
      break label59;
    }
    i = 0;
    try
    {
      localObject = URLEncoder.encode(paramString1, "UTF-8");
      if (i != 0) {
        paramString1 = (String)localObject;
      }
    }
    catch (Exception localException)
    {
      for (;;)
      {
        i = j;
      }
    }
    if (i != 0) {
      localObject = ",encoded=1";
    } else {
      localObject = "";
    }
    localStringBuilder.append("mttbrowser://url=");
    localStringBuilder.append(paramString1);
    localStringBuilder.append(",product=");
    localStringBuilder.append("TBS");
    localStringBuilder.append(",packagename=");
    localStringBuilder.append(paramContext.getPackageName());
    localStringBuilder.append(",from=");
    localStringBuilder.append(paramString2);
    localStringBuilder.append(",version=");
    localStringBuilder.append("4.3.0.73");
    localStringBuilder.append((String)localObject);
    return loadUrl(paramContext, localStringBuilder.toString(), paramHashMap, paramWebView);
  }
  
  public static boolean openDocWithQb(Context paramContext, String paramString1, int paramInt, String paramString2, String paramString3, HashMap<String, String> paramHashMap, Bundle paramBundle)
  {
    for (;;)
    {
      try
      {
        localIntent = new Intent("com.tencent.QQBrowser.action.sdk.document");
        if (paramHashMap != null)
        {
          Object localObject = paramHashMap.keySet();
          if (localObject != null)
          {
            localObject = ((Set)localObject).iterator();
            if (((Iterator)localObject).hasNext())
            {
              String str1 = (String)((Iterator)localObject).next();
              String str2 = (String)paramHashMap.get(str1);
              if (TextUtils.isEmpty(str2)) {
                continue;
              }
              localIntent.putExtra(str1, str2);
              continue;
            }
          }
        }
        new File(paramString1);
        localIntent.putExtra("key_reader_sdk_id", 3);
        localIntent.putExtra("key_reader_sdk_type", paramInt);
        if (TextUtils.isEmpty(paramString3)) {
          break label302;
        }
        localIntent.putExtra("big_brother_source_key", paramString3);
      }
      catch (Exception paramContext)
      {
        Intent localIntent;
        paramContext.printStackTrace();
        return false;
      }
      localIntent.putExtra(paramString3, paramString1);
      localIntent.putExtra("key_reader_sdk_format", paramString2);
      if ((paramContext != null) && (paramContext.getApplicationInfo().targetSdkVersion >= 24) && (Build.VERSION.SDK_INT >= 24)) {
        localIntent.addFlags(1);
      }
      localIntent.addFlags(268435456);
      paramString1 = a(paramContext, paramString1);
      if (paramString1 == null) {
        return false;
      }
      paramString3 = new StringBuilder();
      paramString3.append("mtt/");
      paramString3.append(paramString2);
      localIntent.setDataAndType(paramString1, paramString3.toString());
      localIntent.putExtra("loginType", a(paramContext.getApplicationContext()));
      if (paramBundle != null) {
        localIntent.putExtra("key_reader_sdk_extrals", paramBundle);
      }
      paramContext.startActivity(localIntent);
      return true;
      label302:
      if (paramInt == 0) {
        paramString3 = "key_reader_sdk_path";
      } else if (paramInt == 1) {
        paramString3 = "key_reader_sdk_url";
      }
    }
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
      int i;
      label151:
      break label151;
    }
    i = 0;
    if (i == 0) {
      try
      {
        paramString.setComponent(null);
        paramContext.startActivity(paramString);
        return true;
      }
      catch (Throwable paramContext)
      {
        paramContext.printStackTrace();
        return false;
      }
    }
    return true;
  }
  
  /* Error */
  public static boolean verifySignature(File paramFile)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore 4
    //   3: aconst_null
    //   4: astore_3
    //   5: aconst_null
    //   6: astore 6
    //   8: aconst_null
    //   9: astore 5
    //   11: new 543	java/util/jar/JarFile
    //   14: dup
    //   15: aload_0
    //   16: invokespecial 546	java/util/jar/JarFile:<init>	(Ljava/io/File;)V
    //   19: astore_0
    //   20: aload 5
    //   22: astore_3
    //   23: aload 6
    //   25: astore 4
    //   27: aload_0
    //   28: ldc_w 548
    //   31: invokevirtual 552	java/util/jar/JarFile:getJarEntry	(Ljava/lang/String;)Ljava/util/jar/JarEntry;
    //   34: astore 7
    //   36: aload 7
    //   38: ifnonnull +9 -> 47
    //   41: aload_0
    //   42: invokevirtual 555	java/util/jar/JarFile:close	()V
    //   45: iconst_0
    //   46: ireturn
    //   47: aload 5
    //   49: astore_3
    //   50: aload 6
    //   52: astore 4
    //   54: sipush 8192
    //   57: newarray byte
    //   59: astore 8
    //   61: aload 5
    //   63: astore_3
    //   64: aload 6
    //   66: astore 4
    //   68: aload_0
    //   69: aload 7
    //   71: invokevirtual 559	java/util/jar/JarFile:getInputStream	(Ljava/util/zip/ZipEntry;)Ljava/io/InputStream;
    //   74: astore 5
    //   76: aload 5
    //   78: astore_3
    //   79: aload 5
    //   81: astore 4
    //   83: aload 5
    //   85: aload 8
    //   87: iconst_0
    //   88: aload 8
    //   90: arraylength
    //   91: invokevirtual 565	java/io/InputStream:read	([BII)I
    //   94: iconst_m1
    //   95: if_icmpeq +6 -> 101
    //   98: goto -22 -> 76
    //   101: aload 5
    //   103: astore_3
    //   104: aload 5
    //   106: astore 4
    //   108: aload 5
    //   110: invokevirtual 566	java/io/InputStream:close	()V
    //   113: aload 5
    //   115: astore_3
    //   116: aload 5
    //   118: astore 4
    //   120: aload 7
    //   122: invokevirtual 572	java/util/jar/JarEntry:getCertificates	()[Ljava/security/cert/Certificate;
    //   125: astore 6
    //   127: aload 5
    //   129: astore_3
    //   130: aload 5
    //   132: astore 4
    //   134: aload 6
    //   136: arraylength
    //   137: istore_1
    //   138: iload_1
    //   139: iconst_1
    //   140: if_icmpge +19 -> 159
    //   143: aload 5
    //   145: ifnull +8 -> 153
    //   148: aload 5
    //   150: invokevirtual 566	java/io/InputStream:close	()V
    //   153: aload_0
    //   154: invokevirtual 555	java/util/jar/JarFile:close	()V
    //   157: iconst_0
    //   158: ireturn
    //   159: aload 5
    //   161: astore_3
    //   162: aload 5
    //   164: astore 4
    //   166: aload 6
    //   168: iconst_0
    //   169: aaload
    //   170: invokestatic 574	com/tencent/smtt/sdk/stat/MttLoader:a	(Ljava/security/cert/Certificate;)Ljava/lang/String;
    //   173: astore 6
    //   175: aload 6
    //   177: ifnull +39 -> 216
    //   180: aload 5
    //   182: astore_3
    //   183: aload 5
    //   185: astore 4
    //   187: aload 6
    //   189: ldc_w 576
    //   192: invokevirtual 112	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   195: istore_2
    //   196: iload_2
    //   197: ifeq +19 -> 216
    //   200: aload 5
    //   202: ifnull +8 -> 210
    //   205: aload 5
    //   207: invokevirtual 566	java/io/InputStream:close	()V
    //   210: aload_0
    //   211: invokevirtual 555	java/util/jar/JarFile:close	()V
    //   214: iconst_1
    //   215: ireturn
    //   216: aload_0
    //   217: astore_3
    //   218: aload 5
    //   220: ifnull +10 -> 230
    //   223: aload 5
    //   225: invokevirtual 566	java/io/InputStream:close	()V
    //   228: aload_0
    //   229: astore_3
    //   230: aload_3
    //   231: invokevirtual 555	java/util/jar/JarFile:close	()V
    //   234: iconst_0
    //   235: ireturn
    //   236: astore 5
    //   238: aload_3
    //   239: astore 4
    //   241: aload_0
    //   242: astore_3
    //   243: aload 5
    //   245: astore_0
    //   246: goto +6 -> 252
    //   249: astore_0
    //   250: aconst_null
    //   251: astore_3
    //   252: aload 4
    //   254: ifnull +8 -> 262
    //   257: aload 4
    //   259: invokevirtual 566	java/io/InputStream:close	()V
    //   262: aload_3
    //   263: ifnull +7 -> 270
    //   266: aload_3
    //   267: invokevirtual 555	java/util/jar/JarFile:close	()V
    //   270: aload_0
    //   271: athrow
    //   272: aconst_null
    //   273: astore_0
    //   274: aload_3
    //   275: astore 4
    //   277: aload 4
    //   279: ifnull +8 -> 287
    //   282: aload 4
    //   284: invokevirtual 566	java/io/InputStream:close	()V
    //   287: aload_0
    //   288: ifnull +8 -> 296
    //   291: aload_0
    //   292: astore_3
    //   293: goto -63 -> 230
    //   296: iconst_0
    //   297: ireturn
    //   298: astore_0
    //   299: goto -27 -> 272
    //   302: astore_3
    //   303: goto -26 -> 277
    //   306: astore_0
    //   307: iconst_0
    //   308: ireturn
    //   309: astore_3
    //   310: goto -157 -> 153
    //   313: astore_0
    //   314: iconst_0
    //   315: ireturn
    //   316: astore_3
    //   317: goto -107 -> 210
    //   320: astore_0
    //   321: iconst_1
    //   322: ireturn
    //   323: astore_3
    //   324: aload_0
    //   325: astore_3
    //   326: goto -96 -> 230
    //   329: astore_0
    //   330: iconst_0
    //   331: ireturn
    //   332: astore 4
    //   334: goto -72 -> 262
    //   337: astore_3
    //   338: goto -68 -> 270
    //   341: astore_3
    //   342: goto -55 -> 287
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	345	0	paramFile	File
    //   137	4	1	i	int
    //   195	2	2	bool	boolean
    //   4	289	3	localObject1	Object
    //   302	1	3	localThrowable	Throwable
    //   309	1	3	localIOException1	java.io.IOException
    //   316	1	3	localIOException2	java.io.IOException
    //   323	1	3	localIOException3	java.io.IOException
    //   325	1	3	localFile	File
    //   337	1	3	localIOException4	java.io.IOException
    //   341	1	3	localIOException5	java.io.IOException
    //   1	282	4	localObject2	Object
    //   332	1	4	localIOException6	java.io.IOException
    //   9	215	5	localInputStream	java.io.InputStream
    //   236	8	5	localObject3	Object
    //   6	182	6	localObject4	Object
    //   34	87	7	localJarEntry	java.util.jar.JarEntry
    //   59	30	8	arrayOfByte	byte[]
    // Exception table:
    //   from	to	target	type
    //   27	36	236	finally
    //   54	61	236	finally
    //   68	76	236	finally
    //   83	98	236	finally
    //   108	113	236	finally
    //   120	127	236	finally
    //   134	138	236	finally
    //   166	175	236	finally
    //   187	196	236	finally
    //   11	20	249	finally
    //   11	20	298	java/lang/Throwable
    //   27	36	302	java/lang/Throwable
    //   54	61	302	java/lang/Throwable
    //   68	76	302	java/lang/Throwable
    //   83	98	302	java/lang/Throwable
    //   108	113	302	java/lang/Throwable
    //   120	127	302	java/lang/Throwable
    //   134	138	302	java/lang/Throwable
    //   166	175	302	java/lang/Throwable
    //   187	196	302	java/lang/Throwable
    //   41	45	306	java/io/IOException
    //   148	153	309	java/io/IOException
    //   153	157	313	java/io/IOException
    //   205	210	316	java/io/IOException
    //   210	214	320	java/io/IOException
    //   223	228	323	java/io/IOException
    //   230	234	329	java/io/IOException
    //   257	262	332	java/io/IOException
    //   266	270	337	java/io/IOException
    //   282	287	341	java/io/IOException
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.smtt.sdk.stat.MttLoader
 * JD-Core Version:    0.7.0.1
 */