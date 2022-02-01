package org.xwalk.core;

import android.content.ContentResolver;
import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.PackageManager.NameNotFoundException;
import android.content.pm.Signature;
import android.content.res.AssetFileDescriptor;
import android.os.Build.VERSION;
import android.text.TextUtils;
import com.tencent.xweb.XWebCoreContentProvider;
import com.tencent.xweb.a;
import com.tencent.xweb.util.BSpatch;
import com.tencent.xweb.util.d;
import com.tencent.xweb.util.h;
import com.tencent.xweb.util.i;
import com.tencent.xweb.xwalk.u;
import com.tencent.xweb.xwalk.updater.XWebCoreScheduler;
import java.io.File;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public class XWalkUpdater
{
  private static final String ANDROID_MARKET_DETAILS = "market://details?id=";
  public static final int ERROR_DOPATCH_FAILED = -3;
  public static final int ERROR_DOPATCH_MD5_FAILED = -4;
  public static final int ERROR_DOWNLOAD_FAILED = -1;
  public static final int ERROR_DOWNLOAD_MD5_FAILED = -2;
  public static final int ERROR_EXTRACT_RESOURCE_FAILED = -5;
  public static final int ERROR_EXTRACT_RESOURCE_FAILED_FOR_RETRY = -12;
  public static final int ERROR_NONE = 0;
  public static final int ERROR_SET_VERNUM = -101;
  public static final int ERROR_SHARED_MODE_EXCEED_MAX_COUNT = -7;
  public static final int ERROR_SHARED_MODE_FORCE_DOWNLOAD = -6;
  public static final int ERROR_SHARED_MODE_NO_CONTENT_RESOLVER = -8;
  public static final int ERROR_SHARED_MODE_NO_PROVIDER = -9;
  public static final int ERROR_SHARED_MODE_OTHER = -11;
  public static final int ERROR_SHARED_MODE_TRY_AGAIN = -10;
  private static final String GOOGLE_PLAY_PACKAGE = "com.android.vending";
  static final String INSTALLED_EMBED_VERSION = "INSTALLED_EMBED_VERSION";
  private static final int RES_EXTRACTOR_MAXTIMES = 1;
  private static final String TAG = "XWalkLib";
  public static final int UPDATE_BIZ_TYPE_RUNTIME_PACKAGE = 1;
  public static final int UPDATE_BIZ_TYPE_RUNTIME_PATCH = 2;
  private static int mCurrentTimeForRetryRes = 0;
  static boolean sBTryedInstallFromEmbed = false;
  private XWalkUpdater.XWalkBackgroundUpdateListener mBackgroundUpdateListener;
  private Runnable mCancelCommand;
  private Context mContext;
  private XWalkDialogManager mDialogManager;
  private Runnable mDownloadCommand;
  private XWalkUpdater.XWalkUpdateListener mUpdateListener;
  
  public XWalkUpdater(XWalkUpdater.XWalkBackgroundUpdateListener paramXWalkBackgroundUpdateListener, Context paramContext)
  {
    this.mBackgroundUpdateListener = paramXWalkBackgroundUpdateListener;
    this.mContext = paramContext;
  }
  
  public XWalkUpdater(XWalkUpdater.XWalkUpdateListener paramXWalkUpdateListener, Context paramContext)
  {
    this.mUpdateListener = paramXWalkUpdateListener;
    this.mContext = paramContext;
    this.mDialogManager = new XWalkDialogManager(paramContext);
  }
  
  public XWalkUpdater(XWalkUpdater.XWalkUpdateListener paramXWalkUpdateListener, Context paramContext, XWalkDialogManager paramXWalkDialogManager)
  {
    this.mUpdateListener = paramXWalkUpdateListener;
    this.mContext = paramContext;
    this.mDialogManager = paramXWalkDialogManager;
  }
  
  /* Error */
  public static boolean checkExtractResFileLengtgAndMd5(String paramString1, String paramString2, int paramInt)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore 4
    //   3: new 94	java/io/File
    //   6: dup
    //   7: aload_0
    //   8: invokespecial 97	java/io/File:<init>	(Ljava/lang/String;)V
    //   11: astore_3
    //   12: aload_3
    //   13: invokevirtual 101	java/io/File:exists	()Z
    //   16: ifne +117 -> 133
    //   19: iload_2
    //   20: invokestatic 107	org/xwalk/core/XWalkEnvironment:isTestVersion	(I)Z
    //   23: ifne +689 -> 712
    //   26: iload_2
    //   27: sipush 362
    //   30: if_icmpge +677 -> 707
    //   33: goto +679 -> 712
    //   36: iload_2
    //   37: ifeq +35 -> 72
    //   40: new 109	java/lang/StringBuilder
    //   43: dup
    //   44: invokespecial 110	java/lang/StringBuilder:<init>	()V
    //   47: astore_1
    //   48: aload_1
    //   49: ldc 112
    //   51: invokevirtual 116	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   54: pop
    //   55: aload_1
    //   56: aload_0
    //   57: invokevirtual 116	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   60: pop
    //   61: ldc 47
    //   63: aload_1
    //   64: invokevirtual 120	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   67: invokestatic 126	org/xwalk/core/XWalkInitializer:addXWalkInitializeLog	(Ljava/lang/String;Ljava/lang/String;)V
    //   70: iconst_1
    //   71: ireturn
    //   72: ldc2_w 127
    //   75: iconst_1
    //   76: invokestatic 134	com/tencent/xweb/util/h:a	(JI)V
    //   79: new 109	java/lang/StringBuilder
    //   82: dup
    //   83: invokespecial 110	java/lang/StringBuilder:<init>	()V
    //   86: astore_1
    //   87: aload_1
    //   88: ldc 136
    //   90: invokevirtual 116	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   93: pop
    //   94: aload_1
    //   95: aload_0
    //   96: invokevirtual 116	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   99: pop
    //   100: ldc 47
    //   102: aload_1
    //   103: invokevirtual 120	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   106: invokestatic 126	org/xwalk/core/XWalkInitializer:addXWalkInitializeLog	(Ljava/lang/String;Ljava/lang/String;)V
    //   109: ldc 138
    //   111: ldc 140
    //   113: ldc 142
    //   115: invokestatic 147	com/tencent/xweb/a:a	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   118: invokevirtual 153	java/lang/String:equalsIgnoreCase	(Ljava/lang/String;)Z
    //   121: ifeq +596 -> 717
    //   124: ldc 47
    //   126: ldc 155
    //   128: invokestatic 126	org/xwalk/core/XWalkInitializer:addXWalkInitializeLog	(Ljava/lang/String;Ljava/lang/String;)V
    //   131: iconst_1
    //   132: ireturn
    //   133: new 157	java/io/FileInputStream
    //   136: dup
    //   137: aload_3
    //   138: invokespecial 160	java/io/FileInputStream:<init>	(Ljava/io/File;)V
    //   141: astore_3
    //   142: new 162	java/io/InputStreamReader
    //   145: dup
    //   146: aload_3
    //   147: invokespecial 165	java/io/InputStreamReader:<init>	(Ljava/io/InputStream;)V
    //   150: astore 4
    //   152: new 167	java/io/BufferedReader
    //   155: dup
    //   156: aload 4
    //   158: invokespecial 170	java/io/BufferedReader:<init>	(Ljava/io/Reader;)V
    //   161: astore_0
    //   162: aload_0
    //   163: invokevirtual 173	java/io/BufferedReader:readLine	()Ljava/lang/String;
    //   166: astore 5
    //   168: aload 5
    //   170: ifnull +220 -> 390
    //   173: aload 5
    //   175: ifnull -13 -> 162
    //   178: aload 5
    //   180: invokevirtual 176	java/lang/String:isEmpty	()Z
    //   183: ifeq +6 -> 189
    //   186: goto -24 -> 162
    //   189: aload 5
    //   191: ldc 178
    //   193: invokevirtual 182	java/lang/String:split	(Ljava/lang/String;)[Ljava/lang/String;
    //   196: astore 5
    //   198: aload 5
    //   200: ifnull -38 -> 162
    //   203: aload 5
    //   205: arraylength
    //   206: iconst_2
    //   207: if_icmpne -45 -> 162
    //   210: aload 5
    //   212: iconst_0
    //   213: aaload
    //   214: ifnull -52 -> 162
    //   217: aload 5
    //   219: iconst_0
    //   220: aaload
    //   221: invokevirtual 176	java/lang/String:isEmpty	()Z
    //   224: ifne -62 -> 162
    //   227: aload 5
    //   229: iconst_1
    //   230: aaload
    //   231: ifnull -69 -> 162
    //   234: aload 5
    //   236: iconst_1
    //   237: aaload
    //   238: invokevirtual 176	java/lang/String:isEmpty	()Z
    //   241: ifne -79 -> 162
    //   244: new 94	java/io/File
    //   247: dup
    //   248: aload_1
    //   249: aload 5
    //   251: iconst_0
    //   252: aaload
    //   253: invokespecial 184	java/io/File:<init>	(Ljava/lang/String;Ljava/lang/String;)V
    //   256: astore 6
    //   258: aload 6
    //   260: invokestatic 189	com/tencent/xweb/util/d:a	(Ljava/io/File;)Ljava/lang/String;
    //   263: astore 7
    //   265: aload 7
    //   267: aload 5
    //   269: iconst_1
    //   270: aaload
    //   271: invokevirtual 153	java/lang/String:equalsIgnoreCase	(Ljava/lang/String;)Z
    //   274: ifne -112 -> 162
    //   277: new 109	java/lang/StringBuilder
    //   280: dup
    //   281: invokespecial 110	java/lang/StringBuilder:<init>	()V
    //   284: astore_1
    //   285: aload_1
    //   286: ldc 191
    //   288: invokevirtual 116	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   291: pop
    //   292: aload_1
    //   293: aload 5
    //   295: iconst_0
    //   296: aaload
    //   297: invokevirtual 116	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   300: pop
    //   301: aload_1
    //   302: ldc 193
    //   304: invokevirtual 116	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   307: pop
    //   308: aload_1
    //   309: aload 5
    //   311: iconst_1
    //   312: aaload
    //   313: invokevirtual 116	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   316: pop
    //   317: aload_1
    //   318: ldc 195
    //   320: invokevirtual 116	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   323: pop
    //   324: aload_1
    //   325: aload 7
    //   327: invokevirtual 116	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   330: pop
    //   331: ldc 47
    //   333: aload_1
    //   334: invokevirtual 120	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   337: invokestatic 126	org/xwalk/core/XWalkInitializer:addXWalkInitializeLog	(Ljava/lang/String;Ljava/lang/String;)V
    //   340: aload 6
    //   342: invokevirtual 198	java/io/File:delete	()Z
    //   345: pop
    //   346: aload_3
    //   347: invokevirtual 201	java/io/FileInputStream:close	()V
    //   350: goto +10 -> 360
    //   353: ldc 47
    //   355: ldc 203
    //   357: invokestatic 208	org/xwalk/core/Log:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   360: aload 4
    //   362: invokevirtual 209	java/io/InputStreamReader:close	()V
    //   365: goto +10 -> 375
    //   368: ldc 47
    //   370: ldc 211
    //   372: invokestatic 208	org/xwalk/core/Log:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   375: aload_0
    //   376: invokevirtual 212	java/io/BufferedReader:close	()V
    //   379: iconst_0
    //   380: ireturn
    //   381: ldc 47
    //   383: ldc 214
    //   385: invokestatic 208	org/xwalk/core/Log:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   388: iconst_0
    //   389: ireturn
    //   390: aload_3
    //   391: invokevirtual 201	java/io/FileInputStream:close	()V
    //   394: goto +10 -> 404
    //   397: ldc 47
    //   399: ldc 203
    //   401: invokestatic 208	org/xwalk/core/Log:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   404: aload 4
    //   406: invokevirtual 209	java/io/InputStreamReader:close	()V
    //   409: goto +10 -> 419
    //   412: ldc 47
    //   414: ldc 211
    //   416: invokestatic 208	org/xwalk/core/Log:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   419: aload_0
    //   420: invokevirtual 212	java/io/BufferedReader:close	()V
    //   423: iconst_1
    //   424: ireturn
    //   425: ldc 47
    //   427: ldc 214
    //   429: invokestatic 208	org/xwalk/core/Log:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   432: iconst_1
    //   433: ireturn
    //   434: astore_1
    //   435: goto +160 -> 595
    //   438: astore_1
    //   439: goto +26 -> 465
    //   442: astore_1
    //   443: aconst_null
    //   444: astore_0
    //   445: goto +150 -> 595
    //   448: astore_1
    //   449: aconst_null
    //   450: astore_0
    //   451: goto +14 -> 465
    //   454: astore_1
    //   455: goto +22 -> 477
    //   458: astore_1
    //   459: aconst_null
    //   460: astore 4
    //   462: aload 4
    //   464: astore_0
    //   465: aload_1
    //   466: astore 5
    //   468: aload 4
    //   470: astore_1
    //   471: goto +23 -> 494
    //   474: astore_1
    //   475: aconst_null
    //   476: astore_3
    //   477: aconst_null
    //   478: astore 4
    //   480: aconst_null
    //   481: astore_0
    //   482: goto +113 -> 595
    //   485: astore 5
    //   487: aconst_null
    //   488: astore_1
    //   489: aload_1
    //   490: astore_0
    //   491: aload 4
    //   493: astore_3
    //   494: new 109	java/lang/StringBuilder
    //   497: dup
    //   498: invokespecial 110	java/lang/StringBuilder:<init>	()V
    //   501: astore 4
    //   503: aload 4
    //   505: ldc 216
    //   507: invokevirtual 116	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   510: pop
    //   511: aload 4
    //   513: aload 5
    //   515: invokevirtual 219	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   518: invokevirtual 116	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   521: pop
    //   522: ldc 47
    //   524: aload 4
    //   526: invokevirtual 120	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   529: invokestatic 208	org/xwalk/core/Log:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   532: aload_3
    //   533: ifnull +17 -> 550
    //   536: aload_3
    //   537: invokevirtual 201	java/io/FileInputStream:close	()V
    //   540: goto +10 -> 550
    //   543: ldc 47
    //   545: ldc 203
    //   547: invokestatic 208	org/xwalk/core/Log:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   550: aload_1
    //   551: ifnull +17 -> 568
    //   554: aload_1
    //   555: invokevirtual 209	java/io/InputStreamReader:close	()V
    //   558: goto +10 -> 568
    //   561: ldc 47
    //   563: ldc 211
    //   565: invokestatic 208	org/xwalk/core/Log:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   568: aload_0
    //   569: ifnull +16 -> 585
    //   572: aload_0
    //   573: invokevirtual 212	java/io/BufferedReader:close	()V
    //   576: iconst_0
    //   577: ireturn
    //   578: ldc 47
    //   580: ldc 214
    //   582: invokestatic 208	org/xwalk/core/Log:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   585: iconst_0
    //   586: ireturn
    //   587: astore 5
    //   589: aload_1
    //   590: astore 4
    //   592: aload 5
    //   594: astore_1
    //   595: aload_3
    //   596: ifnull +17 -> 613
    //   599: aload_3
    //   600: invokevirtual 201	java/io/FileInputStream:close	()V
    //   603: goto +10 -> 613
    //   606: ldc 47
    //   608: ldc 203
    //   610: invokestatic 208	org/xwalk/core/Log:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   613: aload 4
    //   615: ifnull +18 -> 633
    //   618: aload 4
    //   620: invokevirtual 209	java/io/InputStreamReader:close	()V
    //   623: goto +10 -> 633
    //   626: ldc 47
    //   628: ldc 211
    //   630: invokestatic 208	org/xwalk/core/Log:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   633: aload_0
    //   634: ifnull +17 -> 651
    //   637: aload_0
    //   638: invokevirtual 212	java/io/BufferedReader:close	()V
    //   641: goto +10 -> 651
    //   644: ldc 47
    //   646: ldc 214
    //   648: invokestatic 208	org/xwalk/core/Log:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   651: goto +5 -> 656
    //   654: aload_1
    //   655: athrow
    //   656: goto -2 -> 654
    //   659: astore_1
    //   660: goto -307 -> 353
    //   663: astore_1
    //   664: goto -296 -> 368
    //   667: astore_0
    //   668: goto -287 -> 381
    //   671: astore_1
    //   672: goto -275 -> 397
    //   675: astore_1
    //   676: goto -264 -> 412
    //   679: astore_0
    //   680: goto -255 -> 425
    //   683: astore_3
    //   684: goto -141 -> 543
    //   687: astore_1
    //   688: goto -127 -> 561
    //   691: astore_0
    //   692: goto -114 -> 578
    //   695: astore_3
    //   696: goto -90 -> 606
    //   699: astore_3
    //   700: goto -74 -> 626
    //   703: astore_0
    //   704: goto -60 -> 644
    //   707: iconst_0
    //   708: istore_2
    //   709: goto -673 -> 36
    //   712: iconst_1
    //   713: istore_2
    //   714: goto -678 -> 36
    //   717: iconst_0
    //   718: ireturn
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	719	0	paramString1	String
    //   0	719	1	paramString2	String
    //   0	719	2	paramInt	int
    //   11	589	3	localObject1	Object
    //   683	1	3	localException1	Exception
    //   695	1	3	localException2	Exception
    //   699	1	3	localException3	Exception
    //   1	618	4	localObject2	Object
    //   166	301	5	localObject3	Object
    //   485	29	5	localException4	Exception
    //   587	6	5	localObject4	Object
    //   256	85	6	localFile	File
    //   263	63	7	str	String
    // Exception table:
    //   from	to	target	type
    //   162	168	434	finally
    //   178	186	434	finally
    //   189	198	434	finally
    //   203	210	434	finally
    //   217	227	434	finally
    //   234	346	434	finally
    //   162	168	438	java/lang/Exception
    //   178	186	438	java/lang/Exception
    //   189	198	438	java/lang/Exception
    //   203	210	438	java/lang/Exception
    //   217	227	438	java/lang/Exception
    //   234	346	438	java/lang/Exception
    //   152	162	442	finally
    //   152	162	448	java/lang/Exception
    //   142	152	454	finally
    //   142	152	458	java/lang/Exception
    //   3	26	474	finally
    //   40	70	474	finally
    //   72	131	474	finally
    //   133	142	474	finally
    //   3	26	485	java/lang/Exception
    //   40	70	485	java/lang/Exception
    //   72	131	485	java/lang/Exception
    //   133	142	485	java/lang/Exception
    //   494	532	587	finally
    //   346	350	659	java/lang/Exception
    //   360	365	663	java/lang/Exception
    //   375	379	667	java/lang/Exception
    //   390	394	671	java/lang/Exception
    //   404	409	675	java/lang/Exception
    //   419	423	679	java/lang/Exception
    //   536	540	683	java/lang/Exception
    //   554	558	687	java/lang/Exception
    //   572	576	691	java/lang/Exception
    //   599	603	695	java/lang/Exception
    //   618	623	699	java/lang/Exception
    //   637	641	703	java/lang/Exception
  }
  
  public static void clearLastTryEmebedVersion()
  {
    getSpForEmbedInstall("armeabi-v7a").edit().putInt("INSTALLED_EMBED_VERSION", -1).commit();
    getSpForEmbedInstall("arm64-v8a").edit().putInt("INSTALLED_EMBED_VERSION", -1).commit();
    XWalkEnvironment.addXWalkInitializeLog("EMBED_INSTALLER", "do clearLastTryEmebedVersion");
  }
  
  public static void doInstallFromEmebed()
  {
    int i = getLastTryInstallVer(XWalkEnvironment.getRuntimeAbi());
    SharedPreferences localSharedPreferences = getSpForEmbedInstall(XWalkEnvironment.getRuntimeAbi());
    int m = -1;
    int k = 0;
    int j = 0;
    try
    {
      XWalkEnvironment.is64BitRuntime();
      try
      {
        int n = XWalkEnvironment.getInstalledNewstVersion(XWalkEnvironment.getRuntimeAbi());
        if (n >= 0)
        {
          XWalkEnvironment.addXWalkInitializeLog("EMBED_INSTALLER", "install stopped this version too old ");
          localSharedPreferences.edit().putInt("INSTALLED_EMBED_VERSION", 0).commit();
          return;
        }
        if (i == 0)
        {
          XWalkEnvironment.addXWalkInitializeLog("EMBED_INSTALLER", "install skip ,this version was tried");
          return;
        }
        Object localObject = new StringBuilder();
        ((StringBuilder)localObject).append("type:LIBabi:LIBversion:");
        ((StringBuilder)localObject).append(0);
        ((StringBuilder)localObject).append("verstion des:");
        ((StringBuilder)localObject).append("1.0.0_from_lib");
        ((StringBuilder)localObject).append("filename:");
        ((StringBuilder)localObject).append("libxwebfullpack.so");
        XWalkEnvironment.addXWalkInitializeLog("EMBED_INSTALLER", ((StringBuilder)localObject).toString());
        localObject = null;
        n = "LIB".hashCode();
        if (n != 75365)
        {
          i = m;
          if (n != 62583504) {
            i = m;
          }
        }
        else
        {
          i = 0;
        }
        if (i != 0)
        {
          if (i != 1)
          {
            if (i == 2) {
              localObject = new XWalkUpdater.HybridUpdateConfig(0, "libxwebfullpack.so", "1");
            }
          }
          else {
            localObject = new XWalkUpdater.AssetsUpdateConfig(0, "libxwebfullpack.so", "1");
          }
        }
        else {
          localObject = new XWalkUpdater.LibUpdateConfig(0, "libxwebfullpack.so", "1");
        }
        if (localObject == null)
        {
          XWalkEnvironment.addXWalkInitializeLog("EMBED_INSTALLER", "not recongniezed install type");
          return;
        }
        if (!((XWalkUpdater.EmbededUpdateConfig)localObject).copySuc())
        {
          h.a(903L, 126L, 1L);
          XWalkEnvironment.addXWalkInitializeLog("EMBED_INSTALLER", "copy failed");
          return;
        }
        ((XWalkUpdater.EmbededUpdateConfig)localObject).getDownloadPath();
        ((XWalkUpdater.EmbededUpdateConfig)localObject).versionDetail = "1.0.0_from_lib";
        localObject = onHandleFile((XWalkUpdater.UpdateConfig)localObject);
        if (((Integer)localObject).intValue() == 0)
        {
          h.a(903L, 127L, 1L);
          com.tencent.xweb.p.a();
          com.tencent.xweb.xwalk.p.a("finished", 0);
          XWalkEnvironment.refreshAvailableVersion();
        }
        localStringBuilder = new StringBuilder();
        localStringBuilder.append("install from embed ret code =  ");
        localStringBuilder.append(localObject);
        XWalkEnvironment.addXWalkInitializeLog("EMBEDED_INSTALLER", localStringBuilder.toString());
        i = k;
      }
      catch (Exception localException1)
      {
        i = j;
      }
      localException2.printStackTrace();
    }
    catch (Exception localException2)
    {
      i = -1;
    }
    h.a(903L, 128L, 1L);
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("install failed ");
    localStringBuilder.append(localException2.getMessage());
    XWalkEnvironment.addXWalkInitializeLog("EMBEDED_INSTALLER", localStringBuilder.toString());
    localSharedPreferences.edit().putInt("INSTALLED_EMBED_VERSION", i).commit();
  }
  
  private static Integer extractResource(int paramInt, String paramString1, String paramString2)
  {
    String str = XWalkEnvironment.getExtractedCoreDir(paramInt);
    if (!XWalkDecompressor.extractResource(XWalkEnvironment.getDownloadApkPath(paramInt), str, getResFileList(paramInt)))
    {
      XWalkInitializer.addXWalkInitializeLog("XWalkLib", "extract faield");
      return Integer.valueOf(-5);
    }
    if (checkExtractResFileLengtgAndMd5(XWalkEnvironment.getDownloadResFileListConfig(paramInt), str, paramInt) == true)
    {
      XWalkInitializer.addXWalkInitializeLog("XWalkLib", "checkExtractResFileLengtgAndMd5 success!!!!");
      try_generate_jar_for_dex_in_dir(str, true);
      if (!generateOptDex(paramInt))
      {
        h.a(251L, 1);
        if ("true".equalsIgnoreCase(a.a("update_need_check_dex", "tools"))) {
          return Integer.valueOf(-101);
        }
      }
      boolean bool = XWebCoreInfo.setVersionForAbi(paramInt, paramString2, paramString1);
      XWalkInitializer.addXWalkInitializeLog("XWalkLib", "do update sucsess");
      h.d();
      com.tencent.xweb.internal.c.a("CHECK_FILES_MD5_TIME_KEY");
      if (!bool)
      {
        XWalkInitializer.addXWalkInitializeLog("XWalkLib", "set version failed");
        return Integer.valueOf(-101);
      }
      return Integer.valueOf(0);
    }
    if (mCurrentTimeForRetryRes < 1)
    {
      XWalkInitializer.addXWalkInitializeLog("XWalkLib", "checkExtractResFileLengtgAndMd5 failed retry extractResource");
      mCurrentTimeForRetryRes += 1;
      return extractResource(paramInt, paramString1, paramString2);
    }
    paramString1 = new StringBuilder();
    paramString1.append("checkResourceLengthAndMd5 failed can not retry!!!!!!!!!! mCurrentTimeForRetryRes = ");
    paramString1.append(mCurrentTimeForRetryRes);
    XWalkInitializer.addXWalkInitializeLog("XWalkLib", paramString1.toString());
    return Integer.valueOf(-12);
  }
  
  private static Integer extractResource(XWalkUpdater.UpdateConfig paramUpdateConfig)
  {
    return extractResource(paramUpdateConfig.apkVer, paramUpdateConfig.abi, paramUpdateConfig.versionDetail);
  }
  
  private static boolean generateOptDex(int paramInt)
  {
    try
    {
      i.b(paramInt);
      return true;
    }
    catch (Exception localException)
    {
      label7:
      break label7;
    }
    XWalkInitializer.addXWalkInitializeLog("XWalkLib", "dex output error");
    return false;
  }
  
  static void generate_jar_for_dex(File paramFile, boolean paramBoolean)
  {
    String str = paramFile.getName();
    try
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append(paramFile.getAbsolutePath());
      ((StringBuilder)localObject).append(".jar");
      localObject = ((StringBuilder)localObject).toString();
      File localFile = new File((String)localObject);
      if (localFile.exists())
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("generate .jar from ");
        localStringBuilder.append(str);
        localStringBuilder.append(" , but jar file exists , need remove =  ");
        localStringBuilder.append(paramBoolean);
        Log.i("XWalkLib", localStringBuilder.toString());
        if (!paramBoolean) {
          return;
        }
        localFile.delete();
      }
      paramBoolean = u.a(paramFile, (String)localObject, 0);
      paramFile = new StringBuilder();
      paramFile.append("generate .jar from ");
      paramFile.append(str);
      paramFile.append(" ret =  ");
      paramFile.append(paramBoolean);
      Log.i("XWalkLib", paramFile.toString());
      return;
    }
    catch (Exception paramFile)
    {
      Object localObject = new StringBuilder();
      ((StringBuilder)localObject).append("generate .jar from ");
      ((StringBuilder)localObject).append(str);
      ((StringBuilder)localObject).append(" failed. error is ");
      ((StringBuilder)localObject).append(paramFile.getMessage());
      Log.e("XWalkLib", ((StringBuilder)localObject).toString());
    }
  }
  
  static void generate_jar_for_dex_in_dir(String paramString, boolean paramBoolean)
  {
    paramString = new File(paramString);
    if (!paramString.isDirectory()) {
      return;
    }
    paramString = paramString.listFiles();
    int j = paramString.length;
    int i = 0;
    while (i < j)
    {
      File localFile = paramString[i];
      if (localFile != null) {
        if (localFile.isDirectory()) {
          generate_jar_for_dex_in_dir(localFile.getAbsolutePath(), paramBoolean);
        } else if (localFile.getName().endsWith(".dex")) {
          generate_jar_for_dex(localFile, paramBoolean);
        }
      }
      i += 1;
    }
  }
  
  public static int getLastTryInstallVer(String paramString)
  {
    return getSpForEmbedInstall(paramString).getInt("INSTALLED_EMBED_VERSION", -1);
  }
  
  /* Error */
  public static String[] getResFileList(int paramInt)
  {
    // Byte code:
    //   0: invokestatic 500	com/tencent/xweb/a:a	()Lcom/tencent/xweb/a;
    //   3: ldc_w 502
    //   6: ldc 142
    //   8: iconst_0
    //   9: invokevirtual 505	com/tencent/xweb/a:a	(Ljava/lang/String;Ljava/lang/String;Z)Z
    //   12: ifeq +15 -> 27
    //   15: ldc 47
    //   17: ldc_w 507
    //   20: invokestatic 126	org/xwalk/core/XWalkInitializer:addXWalkInitializeLog	(Ljava/lang/String;Ljava/lang/String;)V
    //   23: getstatic 511	org/xwalk/core/XWalkEnvironment:DEFAULT_MANDATORY_RESOURCES	[Ljava/lang/String;
    //   26: areturn
    //   27: iload_0
    //   28: invokestatic 388	org/xwalk/core/XWalkEnvironment:getDownloadResFileListConfig	(I)Ljava/lang/String;
    //   31: astore_1
    //   32: new 94	java/io/File
    //   35: dup
    //   36: aload_1
    //   37: invokespecial 97	java/io/File:<init>	(Ljava/lang/String;)V
    //   40: astore_2
    //   41: aload_2
    //   42: invokevirtual 101	java/io/File:exists	()Z
    //   45: ifne +44 -> 89
    //   48: new 109	java/lang/StringBuilder
    //   51: dup
    //   52: invokespecial 110	java/lang/StringBuilder:<init>	()V
    //   55: astore_2
    //   56: aload_2
    //   57: ldc 136
    //   59: invokevirtual 116	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   62: pop
    //   63: aload_2
    //   64: aload_1
    //   65: invokevirtual 116	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   68: pop
    //   69: ldc 47
    //   71: aload_2
    //   72: invokevirtual 120	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   75: invokestatic 126	org/xwalk/core/XWalkInitializer:addXWalkInitializeLog	(Ljava/lang/String;Ljava/lang/String;)V
    //   78: ldc2_w 127
    //   81: iconst_1
    //   82: invokestatic 134	com/tencent/xweb/util/h:a	(JI)V
    //   85: getstatic 511	org/xwalk/core/XWalkEnvironment:DEFAULT_MANDATORY_RESOURCES	[Ljava/lang/String;
    //   88: areturn
    //   89: new 157	java/io/FileInputStream
    //   92: dup
    //   93: aload_2
    //   94: invokespecial 160	java/io/FileInputStream:<init>	(Ljava/io/File;)V
    //   97: astore_3
    //   98: new 162	java/io/InputStreamReader
    //   101: dup
    //   102: aload_3
    //   103: invokespecial 165	java/io/InputStreamReader:<init>	(Ljava/io/InputStream;)V
    //   106: astore_1
    //   107: new 167	java/io/BufferedReader
    //   110: dup
    //   111: aload_1
    //   112: invokespecial 170	java/io/BufferedReader:<init>	(Ljava/io/Reader;)V
    //   115: astore_2
    //   116: aload_1
    //   117: astore 4
    //   119: aload_2
    //   120: astore 5
    //   122: aload_3
    //   123: astore 6
    //   125: new 513	java/util/ArrayList
    //   128: dup
    //   129: invokespecial 514	java/util/ArrayList:<init>	()V
    //   132: astore 7
    //   134: aload_1
    //   135: astore 4
    //   137: aload_2
    //   138: astore 5
    //   140: aload_3
    //   141: astore 6
    //   143: aload_2
    //   144: invokevirtual 173	java/io/BufferedReader:readLine	()Ljava/lang/String;
    //   147: astore 8
    //   149: aload 8
    //   151: ifnull +115 -> 266
    //   154: aload 8
    //   156: ifnull -22 -> 134
    //   159: aload_1
    //   160: astore 4
    //   162: aload_2
    //   163: astore 5
    //   165: aload_3
    //   166: astore 6
    //   168: aload 8
    //   170: invokevirtual 176	java/lang/String:isEmpty	()Z
    //   173: ifeq +6 -> 179
    //   176: goto -42 -> 134
    //   179: aload_1
    //   180: astore 4
    //   182: aload_2
    //   183: astore 5
    //   185: aload_3
    //   186: astore 6
    //   188: aload 8
    //   190: ldc 178
    //   192: invokevirtual 182	java/lang/String:split	(Ljava/lang/String;)[Ljava/lang/String;
    //   195: astore 8
    //   197: aload 8
    //   199: ifnull -65 -> 134
    //   202: aload_1
    //   203: astore 4
    //   205: aload_2
    //   206: astore 5
    //   208: aload_3
    //   209: astore 6
    //   211: aload 8
    //   213: arraylength
    //   214: iconst_2
    //   215: if_icmpne -81 -> 134
    //   218: aload 8
    //   220: iconst_0
    //   221: aaload
    //   222: ifnull -88 -> 134
    //   225: aload_1
    //   226: astore 4
    //   228: aload_2
    //   229: astore 5
    //   231: aload_3
    //   232: astore 6
    //   234: aload 8
    //   236: iconst_0
    //   237: aaload
    //   238: invokevirtual 176	java/lang/String:isEmpty	()Z
    //   241: ifne -107 -> 134
    //   244: aload_1
    //   245: astore 4
    //   247: aload_2
    //   248: astore 5
    //   250: aload_3
    //   251: astore 6
    //   253: aload 7
    //   255: aload 8
    //   257: iconst_0
    //   258: aaload
    //   259: invokevirtual 518	java/util/ArrayList:add	(Ljava/lang/Object;)Z
    //   262: pop
    //   263: goto -129 -> 134
    //   266: aload_1
    //   267: astore 4
    //   269: aload_2
    //   270: astore 5
    //   272: aload_3
    //   273: astore 6
    //   275: aload 7
    //   277: iconst_1
    //   278: anewarray 149	java/lang/String
    //   281: invokevirtual 522	java/util/ArrayList:toArray	([Ljava/lang/Object;)[Ljava/lang/Object;
    //   284: checkcast 523	[Ljava/lang/String;
    //   287: astore 7
    //   289: aload 7
    //   291: ifnonnull +78 -> 369
    //   294: aload_1
    //   295: astore 4
    //   297: aload_2
    //   298: astore 5
    //   300: aload_3
    //   301: astore 6
    //   303: ldc2_w 127
    //   306: iconst_1
    //   307: invokestatic 134	com/tencent/xweb/util/h:a	(JI)V
    //   310: aload_1
    //   311: astore 4
    //   313: aload_2
    //   314: astore 5
    //   316: aload_3
    //   317: astore 6
    //   319: getstatic 511	org/xwalk/core/XWalkEnvironment:DEFAULT_MANDATORY_RESOURCES	[Ljava/lang/String;
    //   322: astore 7
    //   324: aload_3
    //   325: invokevirtual 201	java/io/FileInputStream:close	()V
    //   328: goto +10 -> 338
    //   331: ldc 47
    //   333: ldc 203
    //   335: invokestatic 208	org/xwalk/core/Log:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   338: aload_1
    //   339: invokevirtual 209	java/io/InputStreamReader:close	()V
    //   342: goto +10 -> 352
    //   345: ldc 47
    //   347: ldc 211
    //   349: invokestatic 208	org/xwalk/core/Log:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   352: aload_2
    //   353: invokevirtual 212	java/io/BufferedReader:close	()V
    //   356: aload 7
    //   358: areturn
    //   359: ldc 47
    //   361: ldc 214
    //   363: invokestatic 208	org/xwalk/core/Log:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   366: aload 7
    //   368: areturn
    //   369: aload_3
    //   370: invokevirtual 201	java/io/FileInputStream:close	()V
    //   373: goto +10 -> 383
    //   376: ldc 47
    //   378: ldc 203
    //   380: invokestatic 208	org/xwalk/core/Log:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   383: aload_1
    //   384: invokevirtual 209	java/io/InputStreamReader:close	()V
    //   387: goto +10 -> 397
    //   390: ldc 47
    //   392: ldc 211
    //   394: invokestatic 208	org/xwalk/core/Log:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   397: aload_2
    //   398: invokevirtual 212	java/io/BufferedReader:close	()V
    //   401: aload 7
    //   403: areturn
    //   404: ldc 47
    //   406: ldc 214
    //   408: invokestatic 208	org/xwalk/core/Log:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   411: aload 7
    //   413: areturn
    //   414: astore 7
    //   416: goto +63 -> 479
    //   419: astore_2
    //   420: aload_1
    //   421: astore 4
    //   423: goto +11 -> 434
    //   426: astore_2
    //   427: goto +18 -> 445
    //   430: astore_2
    //   431: aconst_null
    //   432: astore 4
    //   434: aconst_null
    //   435: astore 5
    //   437: aload_2
    //   438: astore_1
    //   439: goto +205 -> 644
    //   442: astore_2
    //   443: aconst_null
    //   444: astore_1
    //   445: aconst_null
    //   446: astore 4
    //   448: aload_2
    //   449: astore 7
    //   451: aload 4
    //   453: astore_2
    //   454: goto +25 -> 479
    //   457: astore_1
    //   458: aconst_null
    //   459: astore 4
    //   461: aload 4
    //   463: astore 5
    //   465: aload 5
    //   467: astore_3
    //   468: goto +176 -> 644
    //   471: astore 7
    //   473: aconst_null
    //   474: astore_1
    //   475: aload_1
    //   476: astore_2
    //   477: aload_2
    //   478: astore_3
    //   479: aload_1
    //   480: astore 4
    //   482: aload_2
    //   483: astore 5
    //   485: aload_3
    //   486: astore 6
    //   488: new 109	java/lang/StringBuilder
    //   491: dup
    //   492: invokespecial 110	java/lang/StringBuilder:<init>	()V
    //   495: astore 8
    //   497: aload_1
    //   498: astore 4
    //   500: aload_2
    //   501: astore 5
    //   503: aload_3
    //   504: astore 6
    //   506: aload 8
    //   508: ldc 216
    //   510: invokevirtual 116	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   513: pop
    //   514: aload_1
    //   515: astore 4
    //   517: aload_2
    //   518: astore 5
    //   520: aload_3
    //   521: astore 6
    //   523: aload 8
    //   525: aload 7
    //   527: invokevirtual 219	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   530: invokevirtual 116	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   533: pop
    //   534: aload_1
    //   535: astore 4
    //   537: aload_2
    //   538: astore 5
    //   540: aload_3
    //   541: astore 6
    //   543: ldc 47
    //   545: aload 8
    //   547: invokevirtual 120	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   550: invokestatic 208	org/xwalk/core/Log:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   553: aload_1
    //   554: astore 4
    //   556: aload_2
    //   557: astore 5
    //   559: aload_3
    //   560: astore 6
    //   562: ldc2_w 127
    //   565: iconst_1
    //   566: invokestatic 134	com/tencent/xweb/util/h:a	(JI)V
    //   569: aload_1
    //   570: astore 4
    //   572: aload_2
    //   573: astore 5
    //   575: aload_3
    //   576: astore 6
    //   578: getstatic 511	org/xwalk/core/XWalkEnvironment:DEFAULT_MANDATORY_RESOURCES	[Ljava/lang/String;
    //   581: astore 7
    //   583: aload_3
    //   584: ifnull +17 -> 601
    //   587: aload_3
    //   588: invokevirtual 201	java/io/FileInputStream:close	()V
    //   591: goto +10 -> 601
    //   594: ldc 47
    //   596: ldc 203
    //   598: invokestatic 208	org/xwalk/core/Log:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   601: aload_1
    //   602: ifnull +17 -> 619
    //   605: aload_1
    //   606: invokevirtual 209	java/io/InputStreamReader:close	()V
    //   609: goto +10 -> 619
    //   612: ldc 47
    //   614: ldc 211
    //   616: invokestatic 208	org/xwalk/core/Log:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   619: aload_2
    //   620: ifnull +17 -> 637
    //   623: aload_2
    //   624: invokevirtual 212	java/io/BufferedReader:close	()V
    //   627: aload 7
    //   629: areturn
    //   630: ldc 47
    //   632: ldc 214
    //   634: invokestatic 208	org/xwalk/core/Log:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   637: aload 7
    //   639: areturn
    //   640: astore_1
    //   641: aload 6
    //   643: astore_3
    //   644: aload_3
    //   645: ifnull +17 -> 662
    //   648: aload_3
    //   649: invokevirtual 201	java/io/FileInputStream:close	()V
    //   652: goto +10 -> 662
    //   655: ldc 47
    //   657: ldc 203
    //   659: invokestatic 208	org/xwalk/core/Log:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   662: aload 4
    //   664: ifnull +18 -> 682
    //   667: aload 4
    //   669: invokevirtual 209	java/io/InputStreamReader:close	()V
    //   672: goto +10 -> 682
    //   675: ldc 47
    //   677: ldc 211
    //   679: invokestatic 208	org/xwalk/core/Log:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   682: aload 5
    //   684: ifnull +18 -> 702
    //   687: aload 5
    //   689: invokevirtual 212	java/io/BufferedReader:close	()V
    //   692: goto +10 -> 702
    //   695: ldc 47
    //   697: ldc 214
    //   699: invokestatic 208	org/xwalk/core/Log:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   702: goto +5 -> 707
    //   705: aload_1
    //   706: athrow
    //   707: goto -2 -> 705
    //   710: astore_3
    //   711: goto -380 -> 331
    //   714: astore_1
    //   715: goto -370 -> 345
    //   718: astore_1
    //   719: goto -360 -> 359
    //   722: astore_3
    //   723: goto -347 -> 376
    //   726: astore_1
    //   727: goto -337 -> 390
    //   730: astore_1
    //   731: goto -327 -> 404
    //   734: astore_3
    //   735: goto -141 -> 594
    //   738: astore_1
    //   739: goto -127 -> 612
    //   742: astore_1
    //   743: goto -113 -> 630
    //   746: astore_2
    //   747: goto -92 -> 655
    //   750: astore_2
    //   751: goto -76 -> 675
    //   754: astore_2
    //   755: goto -60 -> 695
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	758	0	paramInt	int
    //   31	414	1	localObject1	Object
    //   457	1	1	localObject2	Object
    //   474	132	1	localObject3	Object
    //   640	66	1	localObject4	Object
    //   714	1	1	localException1	Exception
    //   718	1	1	localException2	Exception
    //   726	1	1	localException3	Exception
    //   730	1	1	localException4	Exception
    //   738	1	1	localException5	Exception
    //   742	1	1	localException6	Exception
    //   40	358	2	localObject5	Object
    //   419	1	2	localObject6	Object
    //   426	1	2	localException7	Exception
    //   430	8	2	localObject7	Object
    //   442	7	2	localException8	Exception
    //   453	171	2	localObject8	Object
    //   746	1	2	localException9	Exception
    //   750	1	2	localException10	Exception
    //   754	1	2	localException11	Exception
    //   97	552	3	localObject9	Object
    //   710	1	3	localException12	Exception
    //   722	1	3	localException13	Exception
    //   734	1	3	localException14	Exception
    //   117	551	4	localObject10	Object
    //   120	568	5	localObject11	Object
    //   123	519	6	localObject12	Object
    //   132	280	7	localObject13	Object
    //   414	1	7	localException15	Exception
    //   449	1	7	localException16	Exception
    //   471	55	7	localException17	Exception
    //   581	57	7	arrayOfString	String[]
    //   147	399	8	localObject14	Object
    // Exception table:
    //   from	to	target	type
    //   125	134	414	java/lang/Exception
    //   143	149	414	java/lang/Exception
    //   168	176	414	java/lang/Exception
    //   188	197	414	java/lang/Exception
    //   211	218	414	java/lang/Exception
    //   234	244	414	java/lang/Exception
    //   253	263	414	java/lang/Exception
    //   275	289	414	java/lang/Exception
    //   303	310	414	java/lang/Exception
    //   319	324	414	java/lang/Exception
    //   107	116	419	finally
    //   107	116	426	java/lang/Exception
    //   98	107	430	finally
    //   98	107	442	java/lang/Exception
    //   32	89	457	finally
    //   89	98	457	finally
    //   32	89	471	java/lang/Exception
    //   89	98	471	java/lang/Exception
    //   125	134	640	finally
    //   143	149	640	finally
    //   168	176	640	finally
    //   188	197	640	finally
    //   211	218	640	finally
    //   234	244	640	finally
    //   253	263	640	finally
    //   275	289	640	finally
    //   303	310	640	finally
    //   319	324	640	finally
    //   488	497	640	finally
    //   506	514	640	finally
    //   523	534	640	finally
    //   543	553	640	finally
    //   562	569	640	finally
    //   578	583	640	finally
    //   324	328	710	java/lang/Exception
    //   338	342	714	java/lang/Exception
    //   352	356	718	java/lang/Exception
    //   369	373	722	java/lang/Exception
    //   383	387	726	java/lang/Exception
    //   397	401	730	java/lang/Exception
    //   587	591	734	java/lang/Exception
    //   605	609	738	java/lang/Exception
    //   623	627	742	java/lang/Exception
    //   648	652	746	java/lang/Exception
    //   667	672	750	java/lang/Exception
    //   687	692	754	java/lang/Exception
  }
  
  static SharedPreferences getSpForEmbedInstall(String paramString)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("XWEB_EMBED_INSTALL_");
    localStringBuilder.append(paramString);
    return XWalkEnvironment.getMMKVSharedPreferences(localStringBuilder.toString());
  }
  
  /* Error */
  private static boolean isProviderExist(ContentResolver paramContentResolver, String paramString)
  {
    // Byte code:
    //   0: aload_0
    //   1: ifnull +53 -> 54
    //   4: aload_1
    //   5: ifnull +49 -> 54
    //   8: aload_1
    //   9: invokevirtual 176	java/lang/String:isEmpty	()Z
    //   12: ifeq +5 -> 17
    //   15: iconst_0
    //   16: ireturn
    //   17: aload_0
    //   18: aload_1
    //   19: invokestatic 533	org/xwalk/core/XWalkEnvironment:getPackageName	()Ljava/lang/String;
    //   22: iconst_1
    //   23: iconst_0
    //   24: ldc_w 535
    //   27: invokestatic 540	com/tencent/xweb/XWebCoreContentProvider:a	(Ljava/lang/String;Ljava/lang/String;IILjava/lang/String;)Landroid/net/Uri;
    //   30: ldc_w 535
    //   33: invokevirtual 546	android/content/ContentResolver:openAssetFileDescriptor	(Landroid/net/Uri;Ljava/lang/String;)Landroid/content/res/AssetFileDescriptor;
    //   36: astore_0
    //   37: aload_0
    //   38: invokestatic 551	com/tencent/xweb/util/c:a	(Landroid/content/res/AssetFileDescriptor;)V
    //   41: iconst_1
    //   42: ireturn
    //   43: astore_0
    //   44: aconst_null
    //   45: invokestatic 551	com/tencent/xweb/util/c:a	(Landroid/content/res/AssetFileDescriptor;)V
    //   48: aload_0
    //   49: athrow
    //   50: aconst_null
    //   51: invokestatic 551	com/tencent/xweb/util/c:a	(Landroid/content/res/AssetFileDescriptor;)V
    //   54: iconst_0
    //   55: ireturn
    //   56: astore_0
    //   57: goto -7 -> 50
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	60	0	paramContentResolver	ContentResolver
    //   0	60	1	paramString	String
    // Exception table:
    //   from	to	target	type
    //   17	37	43	finally
    //   17	37	56	java/lang/Exception
  }
  
  public static boolean onDoPatch(String paramString, int paramInt1, int paramInt2)
  {
    Object localObject1 = new StringBuilder();
    ((StringBuilder)localObject1).append("onDoPatch:");
    ((StringBuilder)localObject1).append(paramString);
    ((StringBuilder)localObject1).append(",currentVersion:");
    ((StringBuilder)localObject1).append(paramInt1);
    ((StringBuilder)localObject1).append(",newVersion:");
    ((StringBuilder)localObject1).append(paramInt2);
    Log.i("XWalkLib", ((StringBuilder)localObject1).toString());
    if (!new File(paramString).exists())
    {
      Log.e("XWalkLib", "onDoPatch no patch zip file");
      return false;
    }
    if (!XWalkDecompressor.decompressDownloadPatchZip(paramString, XWalkEnvironment.getPatchZipTempDecompressPath(paramInt2)))
    {
      Log.e("XWalkLib", "onDoPatch decompress zip error");
      h.a(37L, 1);
      return false;
    }
    paramString = XWalkUpdater.PatchFileConfigParser.getPatchFileConfigList(paramInt2);
    if (paramString == null)
    {
      Log.e("XWalkLib", "onDoPatch patchFileConfigList = null");
      h.a(38L, 1);
      return false;
    }
    if (!com.tencent.xweb.util.c.b(XWalkEnvironment.getExtractedCoreDir(paramInt1), XWalkEnvironment.getExtractedCoreDir(paramInt2)))
    {
      Log.e("XWalkLib", "onDoPatch copy all extraced file error");
      h.a(39L, 1);
      return false;
    }
    Log.i("XWalkLib", "onDoPatch copy all extraced file finished");
    localObject1 = new ArrayList();
    Object localObject2 = paramString.iterator();
    Object localObject3;
    while (((Iterator)localObject2).hasNext())
    {
      localObject3 = (XWalkUpdater.PatchFileConfig)((Iterator)localObject2).next();
      if (((XWalkUpdater.PatchFileConfig)localObject3).isTypeAdd()) {
        ((ArrayList)localObject1).add(localObject3);
      }
    }
    localObject2 = ((ArrayList)localObject1).iterator();
    while (((Iterator)localObject2).hasNext())
    {
      localObject1 = (XWalkUpdater.PatchFileConfig)((Iterator)localObject2).next();
      if (!com.tencent.xweb.util.c.a(XWalkEnvironment.getPatchZipTempDecompressFilePath(paramInt2, ((XWalkUpdater.PatchFileConfig)localObject1).originalFileName), XWalkEnvironment.getExtractedCoreFile(paramInt2, ((XWalkUpdater.PatchFileConfig)localObject1).originalFileName)))
      {
        paramString = new StringBuilder();
        paramString.append("onDoPatch add file error:");
        paramString.append(localObject1);
        Log.e("XWalkLib", paramString.toString());
        h.a(40L, 1);
        return false;
      }
      localObject3 = new StringBuilder();
      ((StringBuilder)localObject3).append("onDoPatch add file:");
      ((StringBuilder)localObject3).append(localObject1);
      Log.i("XWalkLib", ((StringBuilder)localObject3).toString());
    }
    Log.i("XWalkLib", "onDoPatch add file finished");
    localObject1 = new ArrayList();
    localObject2 = paramString.iterator();
    while (((Iterator)localObject2).hasNext())
    {
      localObject3 = (XWalkUpdater.PatchFileConfig)((Iterator)localObject2).next();
      if (((XWalkUpdater.PatchFileConfig)localObject3).isTypeRemove()) {
        ((ArrayList)localObject1).add(localObject3);
      }
    }
    localObject1 = ((ArrayList)localObject1).iterator();
    while (((Iterator)localObject1).hasNext())
    {
      localObject2 = (XWalkUpdater.PatchFileConfig)((Iterator)localObject1).next();
      if (!com.tencent.xweb.util.c.a(XWalkEnvironment.getExtractedCoreFile(paramInt2, ((XWalkUpdater.PatchFileConfig)localObject2).originalFileName)))
      {
        localObject3 = new StringBuilder();
        ((StringBuilder)localObject3).append("onDoPatch delete file error:");
        ((StringBuilder)localObject3).append(localObject2);
        Log.e("XWalkLib", ((StringBuilder)localObject3).toString());
        h.a(41L, 1);
      }
      else
      {
        localObject3 = new StringBuilder();
        ((StringBuilder)localObject3).append("onDoPatch delete file:");
        ((StringBuilder)localObject3).append(localObject2);
        Log.i("XWalkLib", ((StringBuilder)localObject3).toString());
      }
    }
    Log.i("XWalkLib", "onDoPatch remove file finished");
    localObject1 = new ArrayList();
    paramString = paramString.iterator();
    while (paramString.hasNext())
    {
      localObject2 = (XWalkUpdater.PatchFileConfig)paramString.next();
      if (((XWalkUpdater.PatchFileConfig)localObject2).isTypeModify()) {
        ((ArrayList)localObject1).add(localObject2);
      }
    }
    localObject2 = ((ArrayList)localObject1).iterator();
    while (((Iterator)localObject2).hasNext())
    {
      paramString = (XWalkUpdater.PatchFileConfig)((Iterator)localObject2).next();
      if (paramString.isExtractedFile())
      {
        if (BSpatch.a(XWalkEnvironment.getExtractedCoreFile(paramInt2, paramString.originalFileName), XWalkEnvironment.getPatchZipTempDecompressFilePath(paramInt2, paramString.patchFileName), XWalkEnvironment.getExtractedCoreFile(paramInt2, paramString.originalFileName)) < 0)
        {
          localObject1 = new StringBuilder();
          ((StringBuilder)localObject1).append("onDoPatch patch error file:");
          ((StringBuilder)localObject1).append(paramString);
          Log.e("XWalkLib", ((StringBuilder)localObject1).toString());
          return false;
        }
        Log.i("XWalkLib", "onDoPatch patch file finished");
      }
    }
    Log.i("XWalkLib", "onDoPatch patch file finished");
    localObject1 = ((ArrayList)localObject1).iterator();
    while (((Iterator)localObject1).hasNext())
    {
      paramString = (XWalkUpdater.PatchFileConfig)((Iterator)localObject1).next();
      if (paramString.isOriginalFileTypeApk()) {
        if (BSpatch.a(XWalkEnvironment.getDownloadApkPath(paramInt1), XWalkEnvironment.getPatchZipTempDecompressFilePath(paramInt2, paramString.patchFileName), XWalkEnvironment.getDownloadApkPath(paramInt2)) < 0)
        {
          localObject1 = new StringBuilder();
          ((StringBuilder)localObject1).append("onDoPatch apk patch error file:");
          ((StringBuilder)localObject1).append(paramString);
          Log.e("XWalkLib", ((StringBuilder)localObject1).toString());
          return false;
        }
      }
    }
    Log.i("XWalkLib", "onDoPatch apk patch finished");
    return true;
  }
  
  public static Integer onHandleFile(XWalkUpdater.UpdateConfig paramUpdateConfig)
  {
    String str1 = paramUpdateConfig.getDownloadPath();
    String str2 = XWalkEnvironment.getExtractedCoreDir(paramUpdateConfig.apkVer);
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("Download mode extract dir: ");
    localStringBuilder.append(str2);
    Log.d("XWalkLib", localStringBuilder.toString());
    if ((paramUpdateConfig.isMatchMd5) && (!d.a(str1, paramUpdateConfig.downloadFileMd5)))
    {
      XWalkInitializer.addXWalkInitializeLog("XWalkLib", "downloaded apk md5 check failed");
      return Integer.valueOf(-2);
    }
    if (paramUpdateConfig.isPatchUpdate)
    {
      if (!onDoPatch(str1, paramUpdateConfig.nPatchTargetVersion, paramUpdateConfig.apkVer))
      {
        XWalkInitializer.addXWalkInitializeLog("XWalkLib", "patch update mode ,but patch error");
        return Integer.valueOf(-3);
      }
      if ((paramUpdateConfig.isMatchMd5) && (!XWalkUpdater.FileListMD5Checker.checkFileListMd5(paramUpdateConfig.apkVer, XWalkEnvironment.getPatchFileListConfig(paramUpdateConfig.apkVer))))
      {
        XWalkInitializer.addXWalkInitializeLog("XWalkLib", "patch update mode, but md5 not match");
        h.a(36L, 1);
        return Integer.valueOf(-4);
      }
      XWalkInitializer.addXWalkInitializeLog("XWalkLib", "do patch sucsess");
    }
    else
    {
      if (!XWalkDecompressor.decompressDownloadFullZip(str1, paramUpdateConfig.apkVer))
      {
        h.a(32L, 1);
        return Integer.valueOf(-5);
      }
      if ((paramUpdateConfig.isMatchMd5) && (!XWalkUpdater.FileListMD5Checker.checkFileListMd5(paramUpdateConfig.apkVer, XWalkEnvironment.getDownloadZipFileListConfig(paramUpdateConfig.apkVer))))
      {
        XWalkInitializer.addXWalkInitializeLog("XWalkLib", "patch update mode, but md5 not match");
        h.a(33L, 1);
        return Integer.valueOf(-4);
      }
    }
    return extractResource(paramUpdateConfig);
  }
  
  private static boolean tryCopyVersion(ContentResolver paramContentResolver, String paramString, int paramInt, Map<String, String> paramMap, XWalkUpdater.ErrorInfo paramErrorInfo)
  {
    try
    {
      Iterator localIterator = paramMap.entrySet().iterator();
      while (localIterator.hasNext())
      {
        paramMap = (Map.Entry)localIterator.next();
        String str1 = (String)paramMap.getKey();
        String str2 = (String)paramMap.getValue();
        AssetFileDescriptor localAssetFileDescriptor = paramContentResolver.openAssetFileDescriptor(XWebCoreContentProvider.a(paramString, XWalkEnvironment.getPackageName(), 2, paramInt, str1), "");
        if (localAssetFileDescriptor == null)
        {
          paramErrorInfo.copyFailedCount += 1;
          paramContentResolver = new StringBuilder();
          paramContentResolver.append("tryCopyVersion no file ");
          paramContentResolver.append(str1);
          XWalkInitializer.addXWalkInitializeLog(paramContentResolver.toString());
          return false;
        }
        if ("base.apk".equals(str1)) {
          paramMap = new File(XWalkEnvironment.getDownloadApkPath(paramInt));
        } else {
          paramMap = new File(XWalkEnvironment.getExtractedCoreFile(paramInt, str1));
        }
        if (!com.tencent.xweb.util.c.a(localAssetFileDescriptor, paramMap))
        {
          paramErrorInfo.copyFailedCount += 1;
          XWalkInitializer.addXWalkInitializeLog("tryCopyVersion copy error");
          return false;
        }
        if (!d.a(paramMap.getAbsolutePath(), str2))
        {
          paramContentResolver = new StringBuilder();
          paramContentResolver.append("tryCopyVersion md5 error ");
          paramContentResolver.append(str1);
          XWalkInitializer.addXWalkInitializeLog(paramContentResolver.toString());
          paramErrorInfo.md5FailedCount += 1;
          if (paramMap.exists()) {
            paramMap.delete();
          }
          return false;
        }
      }
      return true;
    }
    catch (Exception paramContentResolver)
    {
      paramString = new StringBuilder();
      paramString.append("tryCopyVersion copy error:");
      paramString.append(paramContentResolver.getMessage());
      XWalkInitializer.addXWalkInitializeLog(paramString.toString());
      paramErrorInfo.copyFailedCount += 1;
    }
    return false;
  }
  
  /* Error */
  private static Map<String, String> tryGetFileList(ContentResolver paramContentResolver, String paramString, int paramInt)
  {
    // Byte code:
    //   0: new 769	java/util/HashMap
    //   3: dup
    //   4: invokespecial 770	java/util/HashMap:<init>	()V
    //   7: astore 4
    //   9: aconst_null
    //   10: astore 5
    //   12: aload_0
    //   13: aload_1
    //   14: invokestatic 533	org/xwalk/core/XWalkEnvironment:getPackageName	()Ljava/lang/String;
    //   17: iconst_2
    //   18: iload_2
    //   19: ldc_w 772
    //   22: invokestatic 540	com/tencent/xweb/XWebCoreContentProvider:a	(Ljava/lang/String;Ljava/lang/String;IILjava/lang/String;)Landroid/net/Uri;
    //   25: ldc_w 535
    //   28: invokevirtual 546	android/content/ContentResolver:openAssetFileDescriptor	(Landroid/net/Uri;Ljava/lang/String;)Landroid/content/res/AssetFileDescriptor;
    //   31: astore_0
    //   32: aload_0
    //   33: ifnonnull +24 -> 57
    //   36: ldc_w 774
    //   39: invokestatic 746	org/xwalk/core/XWalkInitializer:addXWalkInitializeLog	(Ljava/lang/String;)V
    //   42: aconst_null
    //   43: invokestatic 777	com/tencent/xweb/util/c:a	(Ljava/io/Closeable;)V
    //   46: aconst_null
    //   47: invokestatic 777	com/tencent/xweb/util/c:a	(Ljava/io/Closeable;)V
    //   50: aload_0
    //   51: invokestatic 551	com/tencent/xweb/util/c:a	(Landroid/content/res/AssetFileDescriptor;)V
    //   54: aload 4
    //   56: areturn
    //   57: new 94	java/io/File
    //   60: dup
    //   61: iload_2
    //   62: ldc_w 772
    //   65: invokestatic 618	org/xwalk/core/XWalkEnvironment:getExtractedCoreFile	(ILjava/lang/String;)Ljava/lang/String;
    //   68: invokespecial 97	java/io/File:<init>	(Ljava/lang/String;)V
    //   71: astore_1
    //   72: aload_1
    //   73: invokevirtual 101	java/io/File:exists	()Z
    //   76: ifeq +8 -> 84
    //   79: aload_1
    //   80: invokevirtual 198	java/io/File:delete	()Z
    //   83: pop
    //   84: new 779	java/io/PrintWriter
    //   87: dup
    //   88: aload_1
    //   89: invokespecial 780	java/io/PrintWriter:<init>	(Ljava/io/File;)V
    //   92: astore_3
    //   93: new 167	java/io/BufferedReader
    //   96: dup
    //   97: new 162	java/io/InputStreamReader
    //   100: dup
    //   101: aload_0
    //   102: invokevirtual 786	android/content/res/AssetFileDescriptor:createInputStream	()Ljava/io/FileInputStream;
    //   105: invokespecial 165	java/io/InputStreamReader:<init>	(Ljava/io/InputStream;)V
    //   108: invokespecial 170	java/io/BufferedReader:<init>	(Ljava/io/Reader;)V
    //   111: astore_1
    //   112: aload_1
    //   113: invokevirtual 173	java/io/BufferedReader:readLine	()Ljava/lang/String;
    //   116: astore 5
    //   118: aload 5
    //   120: ifnull +89 -> 209
    //   123: aload_3
    //   124: aload 5
    //   126: invokevirtual 789	java/io/PrintWriter:println	(Ljava/lang/String;)V
    //   129: aload 5
    //   131: invokevirtual 176	java/lang/String:isEmpty	()Z
    //   134: ifeq +6 -> 140
    //   137: goto -25 -> 112
    //   140: aload 5
    //   142: ldc 178
    //   144: invokevirtual 182	java/lang/String:split	(Ljava/lang/String;)[Ljava/lang/String;
    //   147: astore 5
    //   149: aload 5
    //   151: arraylength
    //   152: iconst_2
    //   153: if_icmpne -41 -> 112
    //   156: aload 5
    //   158: iconst_0
    //   159: aaload
    //   160: ifnull -48 -> 112
    //   163: aload 5
    //   165: iconst_0
    //   166: aaload
    //   167: invokevirtual 176	java/lang/String:isEmpty	()Z
    //   170: ifne -58 -> 112
    //   173: aload 5
    //   175: iconst_1
    //   176: aaload
    //   177: ifnull -65 -> 112
    //   180: aload 5
    //   182: iconst_1
    //   183: aaload
    //   184: invokevirtual 176	java/lang/String:isEmpty	()Z
    //   187: ifne -75 -> 112
    //   190: aload 4
    //   192: aload 5
    //   194: iconst_0
    //   195: aaload
    //   196: aload 5
    //   198: iconst_1
    //   199: aaload
    //   200: invokeinterface 793 3 0
    //   205: pop
    //   206: goto -94 -> 112
    //   209: aload_3
    //   210: invokevirtual 796	java/io/PrintWriter:flush	()V
    //   213: aload_3
    //   214: invokestatic 777	com/tencent/xweb/util/c:a	(Ljava/io/Closeable;)V
    //   217: aload_1
    //   218: invokestatic 777	com/tencent/xweb/util/c:a	(Ljava/io/Closeable;)V
    //   221: goto -171 -> 50
    //   224: astore 5
    //   226: aload_0
    //   227: astore 4
    //   229: aload 5
    //   231: astore_0
    //   232: goto +134 -> 366
    //   235: astore 4
    //   237: goto +70 -> 307
    //   240: astore 6
    //   242: aload 5
    //   244: astore_1
    //   245: aload_0
    //   246: astore 4
    //   248: aload 6
    //   250: astore_0
    //   251: goto +115 -> 366
    //   254: astore 4
    //   256: aconst_null
    //   257: astore_1
    //   258: goto +49 -> 307
    //   261: astore 6
    //   263: aconst_null
    //   264: astore_3
    //   265: aload 5
    //   267: astore_1
    //   268: aload_0
    //   269: astore 4
    //   271: aload 6
    //   273: astore_0
    //   274: goto +92 -> 366
    //   277: astore 4
    //   279: aconst_null
    //   280: astore_1
    //   281: aload_1
    //   282: astore_3
    //   283: goto +24 -> 307
    //   286: astore_0
    //   287: aconst_null
    //   288: astore 4
    //   290: aload 4
    //   292: astore_3
    //   293: aload 5
    //   295: astore_1
    //   296: goto +70 -> 366
    //   299: astore 4
    //   301: aconst_null
    //   302: astore_1
    //   303: aload_1
    //   304: astore_3
    //   305: aload_3
    //   306: astore_0
    //   307: new 109	java/lang/StringBuilder
    //   310: dup
    //   311: invokespecial 110	java/lang/StringBuilder:<init>	()V
    //   314: astore 5
    //   316: aload 5
    //   318: ldc_w 798
    //   321: invokevirtual 116	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   324: pop
    //   325: aload 5
    //   327: aload 4
    //   329: invokevirtual 219	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   332: invokevirtual 116	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   335: pop
    //   336: aload 5
    //   338: invokevirtual 120	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   341: invokestatic 746	org/xwalk/core/XWalkInitializer:addXWalkInitializeLog	(Ljava/lang/String;)V
    //   344: aload_3
    //   345: invokestatic 777	com/tencent/xweb/util/c:a	(Ljava/io/Closeable;)V
    //   348: aload_1
    //   349: invokestatic 777	com/tencent/xweb/util/c:a	(Ljava/io/Closeable;)V
    //   352: aload_0
    //   353: invokestatic 551	com/tencent/xweb/util/c:a	(Landroid/content/res/AssetFileDescriptor;)V
    //   356: aconst_null
    //   357: areturn
    //   358: astore 5
    //   360: aload_0
    //   361: astore 4
    //   363: aload 5
    //   365: astore_0
    //   366: aload_3
    //   367: invokestatic 777	com/tencent/xweb/util/c:a	(Ljava/io/Closeable;)V
    //   370: aload_1
    //   371: invokestatic 777	com/tencent/xweb/util/c:a	(Ljava/io/Closeable;)V
    //   374: aload 4
    //   376: invokestatic 551	com/tencent/xweb/util/c:a	(Landroid/content/res/AssetFileDescriptor;)V
    //   379: goto +5 -> 384
    //   382: aload_0
    //   383: athrow
    //   384: goto -2 -> 382
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	387	0	paramContentResolver	ContentResolver
    //   0	387	1	paramString	String
    //   0	387	2	paramInt	int
    //   92	275	3	localObject1	Object
    //   7	221	4	localObject2	Object
    //   235	1	4	localException1	Exception
    //   246	1	4	localContentResolver1	ContentResolver
    //   254	1	4	localException2	Exception
    //   269	1	4	localContentResolver2	ContentResolver
    //   277	1	4	localException3	Exception
    //   288	3	4	localObject3	Object
    //   299	29	4	localException4	Exception
    //   361	14	4	localContentResolver3	ContentResolver
    //   10	187	5	localObject4	Object
    //   224	70	5	localObject5	Object
    //   314	23	5	localStringBuilder	StringBuilder
    //   358	6	5	localObject6	Object
    //   240	9	6	localObject7	Object
    //   261	11	6	localObject8	Object
    // Exception table:
    //   from	to	target	type
    //   112	118	224	finally
    //   123	137	224	finally
    //   140	156	224	finally
    //   163	173	224	finally
    //   180	206	224	finally
    //   209	213	224	finally
    //   112	118	235	java/lang/Exception
    //   123	137	235	java/lang/Exception
    //   140	156	235	java/lang/Exception
    //   163	173	235	java/lang/Exception
    //   180	206	235	java/lang/Exception
    //   209	213	235	java/lang/Exception
    //   93	112	240	finally
    //   93	112	254	java/lang/Exception
    //   36	42	261	finally
    //   57	84	261	finally
    //   84	93	261	finally
    //   36	42	277	java/lang/Exception
    //   57	84	277	java/lang/Exception
    //   84	93	277	java/lang/Exception
    //   12	32	286	finally
    //   12	32	299	java/lang/Exception
    //   307	344	358	finally
  }
  
  public static void tryInstallFromEmebed() {}
  
  public static void try_generate_jar_for_dex_in_dir(String paramString, boolean paramBoolean)
  {
    if (Build.VERSION.SDK_INT >= 29)
    {
      if ("true".equalsIgnoreCase(a.a("NOT_USE_JAR_REPLACE_DEX", "tools"))) {
        return;
      }
      generate_jar_for_dex_in_dir(paramString, paramBoolean);
    }
  }
  
  public static void updateLocalXWalkRuntime()
  {
    onHandleFile(new XWalkUpdater.UpdateConfig("runtime_package.zip", false, 100000000, XWalkEnvironment.getRuntimeAbi(), 0));
  }
  
  private boolean verifyDownloadedXWalkRuntime(String paramString)
  {
    paramString = this.mContext.getPackageManager().getPackageArchiveInfo(paramString, 64);
    if (paramString == null)
    {
      Log.e("XWalkLib", "The downloaded XWalkRuntimeLib.apk is invalid!");
      return false;
    }
    try
    {
      PackageInfo localPackageInfo = this.mContext.getPackageManager().getPackageInfo(this.mContext.getPackageName(), 64);
      if ((paramString.signatures != null) && (localPackageInfo.signatures != null))
      {
        if (paramString.signatures.length != localPackageInfo.signatures.length)
        {
          Log.e("XWalkLib", "signatures length not equal");
          return false;
        }
        int i = 0;
        while (i < paramString.signatures.length)
        {
          StringBuilder localStringBuilder = new StringBuilder();
          localStringBuilder.append("Checking signature ");
          localStringBuilder.append(i);
          Log.d("XWalkLib", localStringBuilder.toString());
          if (!localPackageInfo.signatures[i].equals(paramString.signatures[i]))
          {
            Log.e("XWalkLib", "signatures do not match");
            return false;
          }
          i += 1;
        }
        Log.d("XWalkLib", "Signature check passed");
        return true;
      }
      Log.e("XWalkLib", "No signature in package info");
      return false;
    }
    catch (PackageManager.NameNotFoundException paramString) {}
    return false;
  }
  
  public boolean cancelBackgroundDownload()
  {
    return XWalkLibraryLoader.cancelHttpDownload();
  }
  
  public void cancelXWalkRuntimeDownload()
  {
    if (XWalkLibraryLoader.isDownloading())
    {
      XWalkInitializer.addXWalkInitializeLog("XWalkLib", "canceled download apk");
      XWalkLibraryLoader.cancelHttpDownload();
    }
  }
  
  public boolean dismissDialog()
  {
    XWalkDialogManager localXWalkDialogManager = this.mDialogManager;
    if ((localXWalkDialogManager != null) && (localXWalkDialogManager.isShowingDialog()))
    {
      this.mDialogManager.dismissDialog();
      return true;
    }
    return false;
  }
  
  public XWalkUpdater.ErrorInfo updateRuntimeFromProvider(XWebCoreScheduler paramXWebCoreScheduler)
  {
    try
    {
      localc = paramXWebCoreScheduler.r();
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append("updateFromProvider target ver ");
      ((StringBuilder)localObject1).append(localc.l);
      XWalkInitializer.addXWalkInitializeLog(((StringBuilder)localObject1).toString());
      localObject1 = new XWalkUpdater.ErrorInfo();
      ((XWalkUpdater.ErrorInfo)localObject1).targetVer = localc.l;
      if (!localc.s)
      {
        XWalkInitializer.addXWalkInitializeLog("updateFromProvider force download");
        ((XWalkUpdater.ErrorInfo)localObject1).errorCode = -6;
        return localObject1;
      }
      if (localc.p >= 2)
      {
        XWalkInitializer.addXWalkInitializeLog("updateFromProvider exceed max count");
        ((XWalkUpdater.ErrorInfo)localObject1).errorCode = -7;
        return localObject1;
      }
      localContentResolver = XWalkEnvironment.getContentResolver();
      if (localContentResolver == null)
      {
        XWalkInitializer.addXWalkInitializeLog("updateFromProvider content resolver null");
        ((XWalkUpdater.ErrorInfo)localObject1).errorCode = -8;
        return localObject1;
      }
      localUpdateConfig = paramXWebCoreScheduler.c(localc);
      arrayOfString = XWalkEnvironment.XWALK_CORE_PROVIDER_LIST;
      n = arrayOfString.length;
      j = 0;
      i = 0;
    }
    finally
    {
      for (;;)
      {
        com.tencent.xweb.xwalk.updater.c localc;
        Object localObject1;
        ContentResolver localContentResolver;
        XWalkUpdater.UpdateConfig localUpdateConfig;
        String[] arrayOfString;
        int n;
        int i;
        Object localObject2;
        Object localObject3;
        int k;
        CharSequence localCharSequence;
        boolean bool;
        StringBuilder localStringBuilder1;
        for (;;)
        {
          throw paramXWebCoreScheduler;
        }
        label846:
        j += 1;
        continue;
        label853:
        int m = -1;
        paramXWebCoreScheduler = null;
        int j = 0;
        continue;
        label863:
        j += 1;
        continue;
        label870:
        continue;
        label873:
        j = 1;
        label875:
        i += 1;
      }
    }
    if (i < n)
    {
      localObject2 = arrayOfString[i];
      if (!isProviderExist(localContentResolver, (String)localObject2)) {
        break label875;
      }
      paramXWebCoreScheduler = new StringBuilder();
      paramXWebCoreScheduler.append("updateFromProvider find ");
      paramXWebCoreScheduler.append((String)localObject2);
      XWalkInitializer.addXWalkInitializeLog(paramXWebCoreScheduler.toString());
      paramXWebCoreScheduler = a.a("SHARE_CORE_LIST", "tools");
      localObject3 = new StringBuilder();
      ((StringBuilder)localObject3).append("dump SHARE_CORE_LIST: ");
      ((StringBuilder)localObject3).append(paramXWebCoreScheduler);
      Log.i("XWalkLib", ((StringBuilder)localObject3).toString());
      localObject3 = new ArrayList();
      ((ArrayList)localObject3).add(Integer.valueOf(localUpdateConfig.apkVer));
      if ((TextUtils.isEmpty(paramXWebCoreScheduler)) || (XWalkEnvironment.hasInstalledAvailableVersion())) {
        break label853;
      }
      paramXWebCoreScheduler = paramXWebCoreScheduler.split(";");
      if (paramXWebCoreScheduler == null) {
        break label853;
      }
      k = paramXWebCoreScheduler.length;
      j = 0;
      if (j >= k) {
        break label853;
      }
      localCharSequence = paramXWebCoreScheduler[j];
      if (!TextUtils.isEmpty(localCharSequence))
      {
        bool = TextUtils.isEmpty(localCharSequence.trim());
        if (!bool)
        {
          try
          {
            m = Integer.parseInt(localCharSequence);
            if (localUpdateConfig.apkVer == m) {
              break label846;
            }
            ((ArrayList)localObject3).add(Integer.valueOf(m));
          }
          catch (Exception localException)
          {
            StringBuilder localStringBuilder2 = new StringBuilder();
            localStringBuilder2.append("parse SHARE_CORE_LIST failed ");
            localStringBuilder2.append(localException.getMessage());
            Log.e("XWalkLib", localStringBuilder2.toString());
          }
          k = m;
          if (j < ((ArrayList)localObject3).size())
          {
            k = ((Integer)((ArrayList)localObject3).get(j)).intValue();
            paramXWebCoreScheduler = tryGetFileList(localContentResolver, (String)localObject2, k);
            if (paramXWebCoreScheduler == null)
            {
              localStringBuilder1 = new StringBuilder();
              localStringBuilder1.append("updateFromProvider read fileList failed ver = ");
              localStringBuilder1.append(k);
              XWalkInitializer.addXWalkInitializeLog(localStringBuilder1.toString());
              ((XWalkUpdater.ErrorInfo)localObject1).readFileListFailedCount += 1;
              break label863;
            }
            if (paramXWebCoreScheduler.size() != 0) {
              break label870;
            }
            localStringBuilder1 = new StringBuilder();
            localStringBuilder1.append("updateFromProvider no matched version ver = ");
            localStringBuilder1.append(k);
            XWalkInitializer.addXWalkInitializeLog(localStringBuilder1.toString());
            break label863;
          }
          if (k < 0)
          {
            ((XWalkUpdater.ErrorInfo)localObject1).noMatchedVersionCount += 1;
            break label873;
          }
          localObject3 = new StringBuilder();
          ((StringBuilder)localObject3).append("find share available ver = ");
          ((StringBuilder)localObject3).append(k);
          XWalkInitializer.addXWalkInitializeLog(((StringBuilder)localObject3).toString());
          if (!tryCopyVersion(localContentResolver, (String)localObject2, k, paramXWebCoreScheduler, (XWalkUpdater.ErrorInfo)localObject1)) {
            break label873;
          }
          paramXWebCoreScheduler = localUpdateConfig.abi;
          localObject2 = new StringBuilder();
          ((StringBuilder)localObject2).append(k);
          ((StringBuilder)localObject2).append("_install_from_share_mode");
          j = extractResource(k, paramXWebCoreScheduler, ((StringBuilder)localObject2).toString()).intValue();
          if (j == 0)
          {
            ((XWalkUpdater.ErrorInfo)localObject1).errorCode = 0;
            return localObject1;
          }
          if (j == -5)
          {
            ((XWalkUpdater.ErrorInfo)localObject1).extractFailedCount += 1;
            break label873;
          }
          if (j == -12)
          {
            ((XWalkUpdater.ErrorInfo)localObject1).extractRetryFailedCount += 1;
            break label873;
          }
          if (j != -101) {
            break label873;
          }
          ((XWalkUpdater.ErrorInfo)localObject1).setVersionFailedCount += 1;
          break label873;
        }
      }
    }
    else
    {
      if (j == 0)
      {
        XWalkInitializer.addXWalkInitializeLog("updateFromProvider no provider");
        ((XWalkUpdater.ErrorInfo)localObject1).errorCode = -9;
        return localObject1;
      }
      if ((XWalkEnvironment.hasAvailableVersion()) && (localc.p + 1 < 2))
      {
        XWalkInitializer.addXWalkInitializeLog("updateFromProvider failed, can try again");
        ((XWalkUpdater.ErrorInfo)localObject1).errorCode = -10;
      }
      else
      {
        XWalkInitializer.addXWalkInitializeLog("updateFromProvider failed, do not try again");
        ((XWalkUpdater.ErrorInfo)localObject1).errorCode = -11;
      }
      return localObject1;
    }
  }
  
  public boolean updateXWalkRuntime(XWalkUpdater.UpdateConfig paramUpdateConfig)
  {
    if (XWalkLibraryLoader.isDownloading())
    {
      XWalkInitializer.addXWalkInitializeLog("XWalkLib", "Other initialization or download is proceeding");
      return false;
    }
    if (this.mBackgroundUpdateListener != null)
    {
      if ((paramUpdateConfig != null) && (paramUpdateConfig.checkValid()))
      {
        XWalkInitializer.addXWalkInitializeLog("XWalkLib", "start download apk");
        XWalkLibraryLoader.startHttpDownload(new XWalkUpdater.BackgroundListener(this, paramUpdateConfig), this.mContext, paramUpdateConfig);
        return true;
      }
      XWalkInitializer.addXWalkInitializeLog("XWalkLib", "royle:XWalkUpdater updateXWalkRuntime updateConfig is not valid");
      h.w();
      return false;
    }
    XWalkInitializer.addXWalkInitializeLog("XWalkLib", "Update listener is null");
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     org.xwalk.core.XWalkUpdater
 * JD-Core Version:    0.7.0.1
 */