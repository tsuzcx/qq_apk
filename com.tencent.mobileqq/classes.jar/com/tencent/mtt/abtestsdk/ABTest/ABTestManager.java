package com.tencent.mtt.abtestsdk.ABTest;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Build.VERSION;
import android.os.Handler;
import android.support.annotation.NonNull;
import android.text.TextUtils;
import android.util.LruCache;
import com.tencent.mtt.abtestsdk.entity.ABTestConfig;
import com.tencent.mtt.abtestsdk.entity.AttaEntity;
import com.tencent.mtt.abtestsdk.entity.RomaExpEntity;
import com.tencent.mtt.abtestsdk.entity.RomaStrategyEntity;
import com.tencent.mtt.abtestsdk.listener.OnUpdateExperimentsListener;
import com.tencent.mtt.abtestsdk.report.AttaReport;
import com.tencent.mtt.abtestsdk.report.BeaconReport;
import com.tencent.mtt.abtestsdk.utils.ABTestLog;
import com.tencent.mtt.abtestsdk.utils.ABTestUtil;
import com.tencent.mtt.abtestsdk.utils.HandlerThreadUtil;
import com.tencent.mtt.abtestsdk.utils.SystemUtil;
import com.tencent.mtt.abtestsdk.utils.ThreadPoolUtil;
import java.io.File;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

public class ABTestManager
{
  private static final boolean DEBUG = false;
  public static final int DEFAULT_REFRESH_TIME = 60;
  private static final int GET_EXPERIMENTS_FAILED = 1;
  private static final int GET_EXPERIMENTS_SUCCESS = 0;
  public static volatile boolean IS_SDK_HAS_INIT = false;
  private static final String PLATFORM = "Android";
  private static LruCache<String, JSONObject> mCache = new LruCache(ABTestUtil.maxMemCacheSize());
  private ABTestConfig mConfig;
  private Context mContext;
  private SharedPreferences mSharedPreferencesForConfig;
  private SharedPreferences mSharedPreferencesForKey;
  private SharedPreferences mSharedPreferencesForReport;
  private RomaStrategyEntity romaStrategy;
  
  private void doAttaReport(String paramString1, String paramString2)
  {
    if (!this.romaStrategy.isEnableReport())
    {
      ABTestLog.debug("report not enabled!", new Object[0]);
      return;
    }
    String str1 = "";
    if (this.mConfig != null) {
      str1 = this.mConfig.getGuid();
    }
    if (this.mSharedPreferencesForReport.getInt(paramString2, -1) >= 2) {}
    for (String str2 = "0";; str2 = "1")
    {
      String str3 = getConfigInfoFromSP("bundle_app_info");
      String str4 = getConfigInfoFromSP("bundle_version");
      long l = System.currentTimeMillis();
      String str5 = getConfigInfoFromSP("os_version");
      String str6 = getConfigInfoFromSP("device_brand");
      String str7 = getConfigInfoFromSP("device_version");
      String str8 = getConfigInfoFromSP("device_width") + "_" + getConfigInfoFromSP("device_height");
      String str9 = getConfigInfoFromSP("language");
      String str10 = ABTestUtil.getABTestSDKAppId(this.mContext, this.mConfig);
      AttaEntity localAttaEntity = new AttaEntity();
      localAttaEntity.platform = "android";
      localAttaEntity.grayid = paramString2;
      localAttaEntity.guid = str1;
      localAttaEntity.eventcode = paramString1;
      localAttaEntity.appid = str10;
      localAttaEntity.bundleid = str3;
      localAttaEntity.bundlerversion = str4;
      localAttaEntity.channel = "";
      localAttaEntity.devicebrand = str6;
      localAttaEntity.devicemodel = str7;
      localAttaEntity.eventpage = "";
      localAttaEntity.eventtime = String.valueOf(l);
      localAttaEntity.sdkversion = "1.1.1.1";
      localAttaEntity.resolution = str8;
      localAttaEntity.language = str9;
      localAttaEntity.osmodel = "android";
      localAttaEntity.osversion = str5;
      localAttaEntity.isfirsthint = str2;
      AttaReport.getInstance().report(localAttaEntity);
      return;
    }
  }
  
  private JSONObject getAllExpDataFromCache()
  {
    JSONObject localJSONObject2 = (JSONObject)mCache.get("cache");
    JSONObject localJSONObject1 = localJSONObject2;
    if (localJSONObject2 == null)
    {
      localJSONObject1 = getAllExpResInfoFromFile();
      if (localJSONObject1 == null)
      {
        ABTestLog.warn("experimentInfoFromFile is null ", new Object[0]);
        return null;
      }
      mCache.put("cache", localJSONObject1);
    }
    if (localJSONObject1.has("code"))
    {
      int i = localJSONObject1.optInt("code");
      ABTestLog.debug("get cache experiment response code:" + i, new Object[0]);
    }
    if (localJSONObject1.has("data"))
    {
      localJSONObject1 = localJSONObject1.optJSONObject("data");
      ABTestLog.debug("get experiment total num:" + localJSONObject1.length(), new Object[0]);
    }
    for (;;)
    {
      return localJSONObject1;
      localJSONObject1 = null;
    }
  }
  
  /* Error */
  private JSONObject getAllExpResInfoFromFile()
  {
    // Byte code:
    //   0: aload_0
    //   1: getfield 149	com/tencent/mtt/abtestsdk/ABTest/ABTestManager:mContext	Landroid/content/Context;
    //   4: ifnull +9 -> 13
    //   7: invokestatic 288	com/tencent/mtt/abtestsdk/utils/ABTestUtil:isSDCardMounted	()Z
    //   10: ifne +35 -> 45
    //   13: new 131	java/lang/StringBuilder
    //   16: dup
    //   17: invokespecial 132	java/lang/StringBuilder:<init>	()V
    //   20: ldc_w 290
    //   23: invokevirtual 138	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   26: aload_0
    //   27: getfield 149	com/tencent/mtt/abtestsdk/ABTest/ABTestManager:mContext	Landroid/content/Context;
    //   30: invokevirtual 293	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   33: invokevirtual 145	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   36: iconst_0
    //   37: anewarray 4	java/lang/Object
    //   40: invokestatic 249	com/tencent/mtt/abtestsdk/utils/ABTestLog:warn	(Ljava/lang/String;[Ljava/lang/Object;)V
    //   43: aconst_null
    //   44: areturn
    //   45: new 295	java/io/File
    //   48: dup
    //   49: aload_0
    //   50: getfield 149	com/tencent/mtt/abtestsdk/ABTest/ABTestManager:mContext	Landroid/content/Context;
    //   53: ldc_w 297
    //   56: invokevirtual 303	android/content/Context:getExternalFilesDir	(Ljava/lang/String;)Ljava/io/File;
    //   59: ldc_w 305
    //   62: invokespecial 308	java/io/File:<init>	(Ljava/io/File;Ljava/lang/String;)V
    //   65: astore_1
    //   66: aload_1
    //   67: invokevirtual 311	java/io/File:exists	()Z
    //   70: ifne +35 -> 105
    //   73: new 131	java/lang/StringBuilder
    //   76: dup
    //   77: invokespecial 132	java/lang/StringBuilder:<init>	()V
    //   80: aload_1
    //   81: invokevirtual 314	java/io/File:getName	()Ljava/lang/String;
    //   84: invokevirtual 138	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   87: ldc_w 316
    //   90: invokevirtual 138	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   93: invokevirtual 145	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   96: iconst_0
    //   97: anewarray 4	java/lang/Object
    //   100: invokestatic 249	com/tencent/mtt/abtestsdk/utils/ABTestLog:warn	(Ljava/lang/String;[Ljava/lang/Object;)V
    //   103: aconst_null
    //   104: areturn
    //   105: new 131	java/lang/StringBuilder
    //   108: dup
    //   109: invokespecial 132	java/lang/StringBuilder:<init>	()V
    //   112: astore 7
    //   114: new 318	java/io/FileInputStream
    //   117: dup
    //   118: aload_1
    //   119: invokespecial 321	java/io/FileInputStream:<init>	(Ljava/io/File;)V
    //   122: astore_1
    //   123: new 323	java/io/InputStreamReader
    //   126: dup
    //   127: aload_1
    //   128: ldc_w 325
    //   131: invokespecial 328	java/io/InputStreamReader:<init>	(Ljava/io/InputStream;Ljava/lang/String;)V
    //   134: astore_2
    //   135: new 330	java/io/BufferedReader
    //   138: dup
    //   139: aload_2
    //   140: invokespecial 333	java/io/BufferedReader:<init>	(Ljava/io/Reader;)V
    //   143: astore 6
    //   145: aload 6
    //   147: astore 5
    //   149: aload_2
    //   150: astore 4
    //   152: aload_1
    //   153: astore_3
    //   154: aload 6
    //   156: invokevirtual 336	java/io/BufferedReader:readLine	()Ljava/lang/String;
    //   159: astore 8
    //   161: aload 8
    //   163: ifnull +88 -> 251
    //   166: aload 6
    //   168: astore 5
    //   170: aload_2
    //   171: astore 4
    //   173: aload_1
    //   174: astore_3
    //   175: aload 7
    //   177: aload 8
    //   179: invokevirtual 138	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   182: pop
    //   183: goto -38 -> 145
    //   186: astore 7
    //   188: aload 6
    //   190: astore 5
    //   192: aload_2
    //   193: astore 4
    //   195: aload_1
    //   196: astore_3
    //   197: aload 7
    //   199: invokevirtual 339	java/io/FileNotFoundException:getMessage	()Ljava/lang/String;
    //   202: iconst_0
    //   203: anewarray 4	java/lang/Object
    //   206: invokestatic 342	com/tencent/mtt/abtestsdk/utils/ABTestLog:error	(Ljava/lang/String;[Ljava/lang/Object;)V
    //   209: aload 6
    //   211: ifnull +8 -> 219
    //   214: aload 6
    //   216: invokevirtual 345	java/io/BufferedReader:close	()V
    //   219: aload_2
    //   220: ifnull +7 -> 227
    //   223: aload_2
    //   224: invokevirtual 346	java/io/InputStreamReader:close	()V
    //   227: aload_1
    //   228: ifnull -185 -> 43
    //   231: aload_1
    //   232: invokevirtual 347	java/io/FileInputStream:close	()V
    //   235: aconst_null
    //   236: areturn
    //   237: astore_1
    //   238: aload_1
    //   239: invokevirtual 348	java/io/IOException:getMessage	()Ljava/lang/String;
    //   242: iconst_0
    //   243: anewarray 4	java/lang/Object
    //   246: invokestatic 342	com/tencent/mtt/abtestsdk/utils/ABTestLog:error	(Ljava/lang/String;[Ljava/lang/Object;)V
    //   249: aconst_null
    //   250: areturn
    //   251: aload 6
    //   253: astore 5
    //   255: aload_2
    //   256: astore 4
    //   258: aload_1
    //   259: astore_3
    //   260: aload 7
    //   262: invokevirtual 145	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   265: invokestatic 354	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   268: ifeq +64 -> 332
    //   271: aload 6
    //   273: astore 5
    //   275: aload_2
    //   276: astore 4
    //   278: aload_1
    //   279: astore_3
    //   280: ldc_w 356
    //   283: iconst_0
    //   284: anewarray 4	java/lang/Object
    //   287: invokestatic 89	com/tencent/mtt/abtestsdk/utils/ABTestLog:debug	(Ljava/lang/String;[Ljava/lang/Object;)V
    //   290: aload 6
    //   292: ifnull +8 -> 300
    //   295: aload 6
    //   297: invokevirtual 345	java/io/BufferedReader:close	()V
    //   300: aload_2
    //   301: ifnull +7 -> 308
    //   304: aload_2
    //   305: invokevirtual 346	java/io/InputStreamReader:close	()V
    //   308: aload_1
    //   309: ifnull -266 -> 43
    //   312: aload_1
    //   313: invokevirtual 347	java/io/FileInputStream:close	()V
    //   316: aconst_null
    //   317: areturn
    //   318: astore_1
    //   319: aload_1
    //   320: invokevirtual 348	java/io/IOException:getMessage	()Ljava/lang/String;
    //   323: iconst_0
    //   324: anewarray 4	java/lang/Object
    //   327: invokestatic 342	com/tencent/mtt/abtestsdk/utils/ABTestLog:error	(Ljava/lang/String;[Ljava/lang/Object;)V
    //   330: aconst_null
    //   331: areturn
    //   332: aload 6
    //   334: astore 5
    //   336: aload_2
    //   337: astore 4
    //   339: aload_1
    //   340: astore_3
    //   341: new 241	org/json/JSONObject
    //   344: dup
    //   345: aload 7
    //   347: invokevirtual 145	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   350: invokespecial 358	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   353: astore 7
    //   355: aload 6
    //   357: ifnull +8 -> 365
    //   360: aload 6
    //   362: invokevirtual 345	java/io/BufferedReader:close	()V
    //   365: aload_2
    //   366: ifnull +7 -> 373
    //   369: aload_2
    //   370: invokevirtual 346	java/io/InputStreamReader:close	()V
    //   373: aload_1
    //   374: ifnull +7 -> 381
    //   377: aload_1
    //   378: invokevirtual 347	java/io/FileInputStream:close	()V
    //   381: aload 7
    //   383: areturn
    //   384: astore_1
    //   385: aload_1
    //   386: invokevirtual 348	java/io/IOException:getMessage	()Ljava/lang/String;
    //   389: iconst_0
    //   390: anewarray 4	java/lang/Object
    //   393: invokestatic 342	com/tencent/mtt/abtestsdk/utils/ABTestLog:error	(Ljava/lang/String;[Ljava/lang/Object;)V
    //   396: goto -15 -> 381
    //   399: astore 7
    //   401: aconst_null
    //   402: astore 6
    //   404: aconst_null
    //   405: astore_2
    //   406: aconst_null
    //   407: astore_1
    //   408: aload 6
    //   410: astore 5
    //   412: aload_2
    //   413: astore 4
    //   415: aload_1
    //   416: astore_3
    //   417: aload 7
    //   419: invokevirtual 348	java/io/IOException:getMessage	()Ljava/lang/String;
    //   422: iconst_0
    //   423: anewarray 4	java/lang/Object
    //   426: invokestatic 342	com/tencent/mtt/abtestsdk/utils/ABTestLog:error	(Ljava/lang/String;[Ljava/lang/Object;)V
    //   429: aload 6
    //   431: ifnull +8 -> 439
    //   434: aload 6
    //   436: invokevirtual 345	java/io/BufferedReader:close	()V
    //   439: aload_2
    //   440: ifnull +7 -> 447
    //   443: aload_2
    //   444: invokevirtual 346	java/io/InputStreamReader:close	()V
    //   447: aload_1
    //   448: ifnull -405 -> 43
    //   451: aload_1
    //   452: invokevirtual 347	java/io/FileInputStream:close	()V
    //   455: aconst_null
    //   456: areturn
    //   457: astore_1
    //   458: aload_1
    //   459: invokevirtual 348	java/io/IOException:getMessage	()Ljava/lang/String;
    //   462: iconst_0
    //   463: anewarray 4	java/lang/Object
    //   466: invokestatic 342	com/tencent/mtt/abtestsdk/utils/ABTestLog:error	(Ljava/lang/String;[Ljava/lang/Object;)V
    //   469: aconst_null
    //   470: areturn
    //   471: astore 7
    //   473: aconst_null
    //   474: astore 6
    //   476: aconst_null
    //   477: astore_2
    //   478: aconst_null
    //   479: astore_1
    //   480: aload 6
    //   482: astore 5
    //   484: aload_2
    //   485: astore 4
    //   487: aload_1
    //   488: astore_3
    //   489: aload 7
    //   491: invokevirtual 359	org/json/JSONException:getMessage	()Ljava/lang/String;
    //   494: iconst_0
    //   495: anewarray 4	java/lang/Object
    //   498: invokestatic 342	com/tencent/mtt/abtestsdk/utils/ABTestLog:error	(Ljava/lang/String;[Ljava/lang/Object;)V
    //   501: aload 6
    //   503: ifnull +8 -> 511
    //   506: aload 6
    //   508: invokevirtual 345	java/io/BufferedReader:close	()V
    //   511: aload_2
    //   512: ifnull +7 -> 519
    //   515: aload_2
    //   516: invokevirtual 346	java/io/InputStreamReader:close	()V
    //   519: aload_1
    //   520: ifnull -477 -> 43
    //   523: aload_1
    //   524: invokevirtual 347	java/io/FileInputStream:close	()V
    //   527: aconst_null
    //   528: areturn
    //   529: astore_1
    //   530: aload_1
    //   531: invokevirtual 348	java/io/IOException:getMessage	()Ljava/lang/String;
    //   534: iconst_0
    //   535: anewarray 4	java/lang/Object
    //   538: invokestatic 342	com/tencent/mtt/abtestsdk/utils/ABTestLog:error	(Ljava/lang/String;[Ljava/lang/Object;)V
    //   541: aconst_null
    //   542: areturn
    //   543: astore 6
    //   545: aconst_null
    //   546: astore 5
    //   548: aconst_null
    //   549: astore_2
    //   550: aconst_null
    //   551: astore_1
    //   552: aload 5
    //   554: ifnull +8 -> 562
    //   557: aload 5
    //   559: invokevirtual 345	java/io/BufferedReader:close	()V
    //   562: aload_2
    //   563: ifnull +7 -> 570
    //   566: aload_2
    //   567: invokevirtual 346	java/io/InputStreamReader:close	()V
    //   570: aload_1
    //   571: ifnull +7 -> 578
    //   574: aload_1
    //   575: invokevirtual 347	java/io/FileInputStream:close	()V
    //   578: aload 6
    //   580: athrow
    //   581: astore_1
    //   582: aload_1
    //   583: invokevirtual 348	java/io/IOException:getMessage	()Ljava/lang/String;
    //   586: iconst_0
    //   587: anewarray 4	java/lang/Object
    //   590: invokestatic 342	com/tencent/mtt/abtestsdk/utils/ABTestLog:error	(Ljava/lang/String;[Ljava/lang/Object;)V
    //   593: goto -15 -> 578
    //   596: astore 6
    //   598: aconst_null
    //   599: astore 5
    //   601: aconst_null
    //   602: astore_2
    //   603: goto -51 -> 552
    //   606: astore 6
    //   608: aconst_null
    //   609: astore 5
    //   611: goto -59 -> 552
    //   614: astore 6
    //   616: aload 4
    //   618: astore_2
    //   619: aload_3
    //   620: astore_1
    //   621: goto -69 -> 552
    //   624: astore 7
    //   626: aconst_null
    //   627: astore 6
    //   629: aconst_null
    //   630: astore_2
    //   631: goto -151 -> 480
    //   634: astore 7
    //   636: aconst_null
    //   637: astore 6
    //   639: goto -159 -> 480
    //   642: astore 7
    //   644: goto -164 -> 480
    //   647: astore 7
    //   649: aconst_null
    //   650: astore 6
    //   652: aconst_null
    //   653: astore_2
    //   654: goto -246 -> 408
    //   657: astore 7
    //   659: aconst_null
    //   660: astore 6
    //   662: goto -254 -> 408
    //   665: astore 7
    //   667: goto -259 -> 408
    //   670: astore 7
    //   672: aconst_null
    //   673: astore 6
    //   675: aconst_null
    //   676: astore_2
    //   677: aconst_null
    //   678: astore_1
    //   679: goto -491 -> 188
    //   682: astore 7
    //   684: aconst_null
    //   685: astore 6
    //   687: aconst_null
    //   688: astore_2
    //   689: goto -501 -> 188
    //   692: astore 7
    //   694: aconst_null
    //   695: astore 6
    //   697: goto -509 -> 188
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	700	0	this	ABTestManager
    //   65	167	1	localObject1	Object
    //   237	76	1	localIOException1	java.io.IOException
    //   318	60	1	localIOException2	java.io.IOException
    //   384	2	1	localIOException3	java.io.IOException
    //   407	45	1	localObject2	Object
    //   457	2	1	localIOException4	java.io.IOException
    //   479	45	1	localObject3	Object
    //   529	2	1	localIOException5	java.io.IOException
    //   551	24	1	localObject4	Object
    //   581	2	1	localIOException6	java.io.IOException
    //   620	59	1	localObject5	Object
    //   134	555	2	localObject6	Object
    //   153	467	3	localObject7	Object
    //   150	467	4	localObject8	Object
    //   147	463	5	localBufferedReader1	java.io.BufferedReader
    //   143	364	6	localBufferedReader2	java.io.BufferedReader
    //   543	36	6	localObject9	Object
    //   596	1	6	localObject10	Object
    //   606	1	6	localObject11	Object
    //   614	1	6	localObject12	Object
    //   627	69	6	localObject13	Object
    //   112	64	7	localStringBuilder	java.lang.StringBuilder
    //   186	160	7	localFileNotFoundException1	java.io.FileNotFoundException
    //   353	29	7	localJSONObject	JSONObject
    //   399	19	7	localIOException7	java.io.IOException
    //   471	19	7	localJSONException1	JSONException
    //   624	1	7	localJSONException2	JSONException
    //   634	1	7	localJSONException3	JSONException
    //   642	1	7	localJSONException4	JSONException
    //   647	1	7	localIOException8	java.io.IOException
    //   657	1	7	localIOException9	java.io.IOException
    //   665	1	7	localIOException10	java.io.IOException
    //   670	1	7	localFileNotFoundException2	java.io.FileNotFoundException
    //   682	1	7	localFileNotFoundException3	java.io.FileNotFoundException
    //   692	1	7	localFileNotFoundException4	java.io.FileNotFoundException
    //   159	19	8	str	String
    // Exception table:
    //   from	to	target	type
    //   154	161	186	java/io/FileNotFoundException
    //   175	183	186	java/io/FileNotFoundException
    //   260	271	186	java/io/FileNotFoundException
    //   280	290	186	java/io/FileNotFoundException
    //   341	355	186	java/io/FileNotFoundException
    //   214	219	237	java/io/IOException
    //   223	227	237	java/io/IOException
    //   231	235	237	java/io/IOException
    //   295	300	318	java/io/IOException
    //   304	308	318	java/io/IOException
    //   312	316	318	java/io/IOException
    //   360	365	384	java/io/IOException
    //   369	373	384	java/io/IOException
    //   377	381	384	java/io/IOException
    //   114	123	399	java/io/IOException
    //   434	439	457	java/io/IOException
    //   443	447	457	java/io/IOException
    //   451	455	457	java/io/IOException
    //   114	123	471	org/json/JSONException
    //   506	511	529	java/io/IOException
    //   515	519	529	java/io/IOException
    //   523	527	529	java/io/IOException
    //   114	123	543	finally
    //   557	562	581	java/io/IOException
    //   566	570	581	java/io/IOException
    //   574	578	581	java/io/IOException
    //   123	135	596	finally
    //   135	145	606	finally
    //   154	161	614	finally
    //   175	183	614	finally
    //   197	209	614	finally
    //   260	271	614	finally
    //   280	290	614	finally
    //   341	355	614	finally
    //   417	429	614	finally
    //   489	501	614	finally
    //   123	135	624	org/json/JSONException
    //   135	145	634	org/json/JSONException
    //   154	161	642	org/json/JSONException
    //   175	183	642	org/json/JSONException
    //   260	271	642	org/json/JSONException
    //   280	290	642	org/json/JSONException
    //   341	355	642	org/json/JSONException
    //   123	135	647	java/io/IOException
    //   135	145	657	java/io/IOException
    //   154	161	665	java/io/IOException
    //   175	183	665	java/io/IOException
    //   260	271	665	java/io/IOException
    //   280	290	665	java/io/IOException
    //   341	355	665	java/io/IOException
    //   114	123	670	java/io/FileNotFoundException
    //   123	135	682	java/io/FileNotFoundException
    //   135	145	692	java/io/FileNotFoundException
  }
  
  private void getExperimentsByTag(String paramString, OnUpdateExperimentsListener paramOnUpdateExperimentsListener, int paramInt)
  {
    paramOnUpdateExperimentsListener = new ABTestManager.UIHandler(paramOnUpdateExperimentsListener);
    if (this.mConfig == null) {
      this.mConfig = new ABTestConfig();
    }
    String str1 = ABTestUtil.getABTestSDKAppKey(this.mContext, this.mConfig);
    String str2 = ABTestUtil.getABTestSDKAppId(this.mContext, this.mConfig);
    Object localObject = this.mConfig.getCustomTag();
    ABTestLog.stepUpload("customTag: " + localObject.toString(), new Object[0]);
    String str3 = new JSONObject((Map)localObject).toString();
    localObject = this.mConfig.getRequestUrl();
    List localList = this.mConfig.getLayerCodes();
    String str4 = this.mConfig.getSceneId();
    ABTestLog.stepUpload("requestUrl:" + (String)localObject + "  expName:" + paramString + " customConfig:" + str3 + "  timeout:" + paramInt + " layerCodes:" + localList + " sceneId:" + str4, new Object[0]);
    JSONObject localJSONObject1 = new JSONObject();
    JSONObject localJSONObject2 = new JSONObject();
    try
    {
      localJSONObject2.put("appid", str2);
      localJSONObject2.put("appkey", str1);
      localJSONObject2.put("guid", this.mConfig.getGuid());
      if (!TextUtils.isEmpty(paramString)) {
        localJSONObject2.put("expName", paramString);
      }
      if ((localList != null) && (!localList.isEmpty())) {
        localJSONObject2.put("layerCodes", localList.toString());
      }
      if (!TextUtils.isEmpty(str4)) {
        localJSONObject2.put("sceneId", str4);
      }
      localJSONObject2.put("profiles", new JSONObject(str3));
      localJSONObject1.put("data", ABTestUtil.encryptPostBodyByRSA(localJSONObject2.toString()));
      ABTestLog.stepUpload("\npostBody= " + localJSONObject2.toString() + "\npostBodyEncrypt= " + localJSONObject1.toString() + "\nrequestUrl= " + (String)localObject, new Object[0]);
    }
    catch (JSONException localJSONException)
    {
      for (;;)
      {
        ABTestLog.error(localJSONException.getMessage(), new Object[0]);
      }
    }
    ThreadPoolUtil.execute(new ABTestManager.1(this, paramOnUpdateExperimentsListener, (String)localObject, localJSONObject1, paramInt, paramString));
  }
  
  public static ABTestManager getInstance()
  {
    return ABTestManager.ABTestMangerHolder.access$100();
  }
  
  private static void initDefaultProfiles(ABTestConfig paramABTestConfig)
  {
    if (paramABTestConfig == null)
    {
      ABTestLog.error("[SDKInit] initDefaultProfiles fail and config is null", new Object[0]);
      return;
    }
    paramABTestConfig = paramABTestConfig.getCustomTag();
    paramABTestConfig.put("ROMA_BUNDLE_NAME", "");
    paramABTestConfig.put("ROMA_BUNDLE_VER", "");
    paramABTestConfig.put("ROMA_BUNDLE_ID", "");
    paramABTestConfig.put("ROMA_SDK_VERSION", "1.1.1.1");
    paramABTestConfig.put("ROMA_OS_MODEL", SystemUtil.getSystemModel());
    paramABTestConfig.put("ROMA_OS_VER", SystemUtil.getSystemVersion());
    paramABTestConfig.put("ROMA_PLATFORM", "Android");
    paramABTestConfig.put("ROMA_BRAND", SystemUtil.getDeviceBrand());
    paramABTestConfig.put("ROMA_RESOLUTION", "");
  }
  
  private void initSPBuglySDK()
  {
    this.mContext.getSharedPreferences("BuglySdkInfos", 0).edit().putString("4aeafa6143", "1.1.1.1").apply();
    ABTestLog.debug("[SDKInit] the Bugly SDK init finished", new Object[0]);
  }
  
  private void initSharePerfenceForConfig(ABTestConfig paramABTestConfig)
  {
    paramABTestConfig = paramABTestConfig.getCustomTag();
    if (this.mSharedPreferencesForConfig == null) {
      this.mSharedPreferencesForConfig = this.mContext.getSharedPreferences("ab_test_android_config", 0);
    }
    SharedPreferences.Editor localEditor = this.mSharedPreferencesForConfig.edit();
    if (Build.VERSION.SDK_INT >= 24)
    {
      localEditor.putString("platform", (String)paramABTestConfig.getOrDefault("platform", getConfigInfoFromSP("platform")));
      localEditor.putString("platform_version", (String)paramABTestConfig.getOrDefault("platform_version", getConfigInfoFromSP("platform_version")));
      localEditor.putString("resolution_ratio", (String)paramABTestConfig.getOrDefault("resolution_ratio", getConfigInfoFromSP("resolution_ratio")));
      localEditor.putString("brand", (String)paramABTestConfig.getOrDefault("brand", getConfigInfoFromSP("brand")));
      localEditor.putString("model", (String)paramABTestConfig.getOrDefault("model", getConfigInfoFromSP("model")));
      localEditor.putString("sex", (String)paramABTestConfig.getOrDefault("sex", getConfigInfoFromSP("sex")));
      localEditor.putString("province", (String)paramABTestConfig.getOrDefault("province", getConfigInfoFromSP("province")));
      localEditor.putString("city", (String)paramABTestConfig.getOrDefault("city", getConfigInfoFromSP("city")));
    }
    for (;;)
    {
      localEditor.putString("ENV", this.mConfig.getEnv());
      localEditor.putString("guid", this.mConfig.getGuid());
      localEditor.putString("language", SystemUtil.getSystemLanguage());
      localEditor.putString("os_version", SystemUtil.getSystemVersion());
      localEditor.putString("device_brand", SystemUtil.getDeviceBrand());
      localEditor.putString("device_version", SystemUtil.getSystemModel());
      localEditor.putString("device_width", String.valueOf(SystemUtil.getWidth(this.mContext)));
      localEditor.putString("device_height", String.valueOf(SystemUtil.getHeight(this.mContext)));
      localEditor.putString("bundle_app_info", String.valueOf(SystemUtil.getAppInfo(this.mContext)));
      localEditor.putString("bundle_version", String.valueOf(SystemUtil.getVersionName(this.mContext)));
      localEditor.apply();
      return;
      localEditor.putString("platform", (String)paramABTestConfig.get("platform"));
      localEditor.putString("platform_version", (String)paramABTestConfig.get("platform_version"));
      localEditor.putString("resolution_ratio", (String)paramABTestConfig.get("resolution_ratio"));
      localEditor.putString("brand", (String)paramABTestConfig.get("brand"));
      localEditor.putString("model", (String)paramABTestConfig.get("model"));
      localEditor.putString("sex", (String)paramABTestConfig.get("sex"));
      localEditor.putString("province", (String)paramABTestConfig.get("province"));
      localEditor.putString("city", (String)paramABTestConfig.get("city"));
    }
  }
  
  private void initSharedPerfAndSetClearStatus()
  {
    this.mSharedPreferencesForKey = this.mContext.getSharedPreferences("ab_test_android", 0);
    this.mSharedPreferencesForConfig = this.mContext.getSharedPreferences("ab_test_android_config", 0);
    this.mSharedPreferencesForReport = this.mContext.getSharedPreferences("ab_test_android_report", 0);
    String str1 = getConfigInfoFromSP("ENV");
    String str2 = this.mConfig.getEnv();
    ABTestLog.debug("[SDKInit] preEnv: " + str1 + " curEnv: " + str2, new Object[0]);
    if (!str2.equals(str1))
    {
      boolean bool = clearExperiments();
      ABTestLog.debug("[SDKInit] clear experiments status:" + bool, new Object[0]);
    }
  }
  
  private void loadReportStrategy()
  {
    RomaStrategyEntity localRomaStrategyEntity = new RomaStrategyEntity();
    localRomaStrategyEntity.setEnableReport(this.mSharedPreferencesForReport.getBoolean("enableReport", false));
    localRomaStrategyEntity.setReportId(this.mSharedPreferencesForReport.getString("id", ""));
    localRomaStrategyEntity.setReportToken(this.mSharedPreferencesForReport.getString("token", ""));
    localRomaStrategyEntity.setRefreshDuration(this.mSharedPreferencesForReport.getInt("refreshDuration", -1));
    localRomaStrategyEntity.setUpdateTime(this.mSharedPreferencesForReport.getLong("updateTime", 0L));
    this.romaStrategy = localRomaStrategyEntity;
    if (!TextUtils.isEmpty(localRomaStrategyEntity.getReportId())) {
      AttaReport.getInstance().setAttId(localRomaStrategyEntity.getReportId());
    }
    if (!TextUtils.isEmpty(localRomaStrategyEntity.getReportToken())) {
      AttaReport.getInstance().setAttToken(localRomaStrategyEntity.getReportToken());
    }
  }
  
  private void saveExpGrayIdInfo(String paramString1, String paramString2)
  {
    String str1;
    for (;;)
    {
      try
      {
        paramString1 = new JSONObject(paramString1).optJSONObject("data");
        paramString2 = new ArrayList();
        Iterator localIterator = paramString1.keys();
        if (this.mSharedPreferencesForReport == null) {
          this.mSharedPreferencesForReport = this.mContext.getSharedPreferences("ab_test_android_report", 0);
        }
        str1 = this.mSharedPreferencesForReport.getString("gray_police_ids", "");
        if (!localIterator.hasNext()) {
          break;
        }
        String str2 = paramString1.optJSONObject((String)localIterator.next()).optString("sGrayPolicyId", "_");
        int i = this.mSharedPreferencesForReport.getInt(str2, -1);
        if ((TextUtils.isEmpty(str1)) || (!str1.contains(str2)))
        {
          paramString2.add(str2);
          this.mSharedPreferencesForReport.edit().putInt(str2, 1).apply();
        }
        else
        {
          this.mSharedPreferencesForReport.edit().putInt(str2, i + 1).apply();
        }
      }
      catch (JSONException paramString1)
      {
        ABTestLog.error(paramString1.getMessage(), new Object[0]);
        return;
      }
    }
    if (paramString2.isEmpty())
    {
      ABTestLog.debug("grayIds has been repeated and not be saved", new Object[0]);
      return;
    }
    if ((!TextUtils.isEmpty(str1)) && (str1.endsWith("#"))) {}
    for (paramString1 = str1 + TextUtils.join("#", paramString2) + "#";; paramString1 = "#" + str1 + TextUtils.join("#", paramString2) + "#")
    {
      ABTestLog.debug("save grayIds: " + paramString1, new Object[0]);
      this.mSharedPreferencesForReport.edit().putString("gray_police_ids", paramString1).apply();
      return;
    }
  }
  
  /* Error */
  private void saveExpInfosToFile(String paramString1, String paramString2)
  {
    // Byte code:
    //   0: aload_0
    //   1: invokespecial 244	com/tencent/mtt/abtestsdk/ABTest/ABTestManager:getAllExpResInfoFromFile	()Lorg/json/JSONObject;
    //   4: astore 6
    //   6: aload 6
    //   8: ifnull +83 -> 91
    //   11: aload 6
    //   13: invokevirtual 384	org/json/JSONObject:toString	()Ljava/lang/String;
    //   16: astore 4
    //   18: aload_0
    //   19: getfield 574	com/tencent/mtt/abtestsdk/ABTest/ABTestManager:mSharedPreferencesForKey	Landroid/content/SharedPreferences;
    //   22: ifnonnull +18 -> 40
    //   25: aload_0
    //   26: aload_0
    //   27: getfield 149	com/tencent/mtt/abtestsdk/ABTest/ABTestManager:mContext	Landroid/content/Context;
    //   30: ldc_w 572
    //   33: iconst_0
    //   34: invokevirtual 495	android/content/Context:getSharedPreferences	(Ljava/lang/String;I)Landroid/content/SharedPreferences;
    //   37: putfield 574	com/tencent/mtt/abtestsdk/ABTest/ABTestManager:mSharedPreferencesForKey	Landroid/content/SharedPreferences;
    //   40: aload 4
    //   42: invokestatic 354	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   45: ifne +53 -> 98
    //   48: aload 4
    //   50: aload_1
    //   51: invokestatic 696	android/text/TextUtils:equals	(Ljava/lang/CharSequence;Ljava/lang/CharSequence;)Z
    //   54: ifeq +44 -> 98
    //   57: aload_0
    //   58: getfield 574	com/tencent/mtt/abtestsdk/ABTest/ABTestManager:mSharedPreferencesForKey	Landroid/content/SharedPreferences;
    //   61: invokeinterface 499 1 0
    //   66: ldc_w 698
    //   69: iconst_1
    //   70: invokeinterface 702 3 0
    //   75: invokeinterface 510 1 0
    //   80: ldc_w 704
    //   83: iconst_0
    //   84: anewarray 4	java/lang/Object
    //   87: invokestatic 89	com/tencent/mtt/abtestsdk/utils/ABTestLog:debug	(Ljava/lang/String;[Ljava/lang/Object;)V
    //   90: return
    //   91: ldc 91
    //   93: astore 4
    //   95: goto -77 -> 18
    //   98: aload_0
    //   99: getfield 149	com/tencent/mtt/abtestsdk/ABTest/ABTestManager:mContext	Landroid/content/Context;
    //   102: ifnull -12 -> 90
    //   105: aload_1
    //   106: invokestatic 354	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   109: ifne -19 -> 90
    //   112: invokestatic 288	com/tencent/mtt/abtestsdk/utils/ABTestUtil:isSDCardMounted	()Z
    //   115: ifeq -25 -> 90
    //   118: new 241	org/json/JSONObject
    //   121: dup
    //   122: aload_1
    //   123: invokespecial 358	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   126: astore 5
    //   128: aload 5
    //   130: ldc 255
    //   132: invokevirtual 263	org/json/JSONObject:optInt	(Ljava/lang/String;)I
    //   135: ifne -45 -> 90
    //   138: aload_2
    //   139: invokestatic 354	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   142: istore_3
    //   143: aload_1
    //   144: astore 4
    //   146: iload_3
    //   147: ifne +116 -> 263
    //   150: aload 6
    //   152: ldc_w 270
    //   155: invokevirtual 274	org/json/JSONObject:optJSONObject	(Ljava/lang/String;)Lorg/json/JSONObject;
    //   158: astore 10
    //   160: aload 5
    //   162: ldc_w 270
    //   165: invokevirtual 274	org/json/JSONObject:optJSONObject	(Ljava/lang/String;)Lorg/json/JSONObject;
    //   168: astore 8
    //   170: aload 10
    //   172: invokevirtual 652	org/json/JSONObject:keys	()Ljava/util/Iterator;
    //   175: astore 9
    //   177: aload 9
    //   179: invokeinterface 659 1 0
    //   184: ifeq +219 -> 403
    //   187: aload 9
    //   189: invokeinterface 663 1 0
    //   194: checkcast 193	java/lang/String
    //   197: astore 4
    //   199: aload 10
    //   201: aload 4
    //   203: invokevirtual 274	org/json/JSONObject:optJSONObject	(Ljava/lang/String;)Lorg/json/JSONObject;
    //   206: astore 6
    //   208: aload 6
    //   210: ldc_w 416
    //   213: invokevirtual 706	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   216: astore 7
    //   218: aload 7
    //   220: invokestatic 354	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   223: ifne +12 -> 235
    //   226: aload 7
    //   228: aload_2
    //   229: invokevirtual 584	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   232: ifne -55 -> 177
    //   235: aload 8
    //   237: aload 4
    //   239: aload 6
    //   241: invokevirtual 411	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   244: pop
    //   245: goto -68 -> 177
    //   248: astore_2
    //   249: aload_2
    //   250: invokevirtual 707	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   253: iconst_0
    //   254: anewarray 4	java/lang/Object
    //   257: invokestatic 342	com/tencent/mtt/abtestsdk/utils/ABTestLog:error	(Ljava/lang/String;[Ljava/lang/Object;)V
    //   260: aload_1
    //   261: astore 4
    //   263: aload_0
    //   264: getfield 149	com/tencent/mtt/abtestsdk/ABTest/ABTestManager:mContext	Landroid/content/Context;
    //   267: ldc_w 297
    //   270: invokevirtual 303	android/content/Context:getExternalFilesDir	(Ljava/lang/String;)Ljava/io/File;
    //   273: astore_1
    //   274: aload_1
    //   275: ifnull +40 -> 315
    //   278: aload_1
    //   279: invokevirtual 311	java/io/File:exists	()Z
    //   282: ifeq +33 -> 315
    //   285: new 131	java/lang/StringBuilder
    //   288: dup
    //   289: invokespecial 132	java/lang/StringBuilder:<init>	()V
    //   292: ldc_w 709
    //   295: invokevirtual 138	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   298: aload_1
    //   299: invokevirtual 712	java/io/File:getAbsolutePath	()Ljava/lang/String;
    //   302: invokevirtual 138	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   305: invokevirtual 145	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   308: iconst_0
    //   309: anewarray 4	java/lang/Object
    //   312: invokestatic 89	com/tencent/mtt/abtestsdk/utils/ABTestLog:debug	(Ljava/lang/String;[Ljava/lang/Object;)V
    //   315: new 295	java/io/File
    //   318: dup
    //   319: aload_1
    //   320: ldc_w 305
    //   323: invokespecial 308	java/io/File:<init>	(Ljava/io/File;Ljava/lang/String;)V
    //   326: astore_1
    //   327: aload_1
    //   328: invokevirtual 311	java/io/File:exists	()Z
    //   331: ifeq +10 -> 341
    //   334: aload_1
    //   335: invokevirtual 715	java/io/File:delete	()Z
    //   338: ifeq -248 -> 90
    //   341: new 131	java/lang/StringBuilder
    //   344: dup
    //   345: invokespecial 132	java/lang/StringBuilder:<init>	()V
    //   348: ldc_w 717
    //   351: invokevirtual 138	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   354: aload 4
    //   356: invokevirtual 138	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   359: invokevirtual 145	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   362: iconst_0
    //   363: anewarray 4	java/lang/Object
    //   366: invokestatic 89	com/tencent/mtt/abtestsdk/utils/ABTestLog:debug	(Ljava/lang/String;[Ljava/lang/Object;)V
    //   369: aload_1
    //   370: invokevirtual 720	java/io/File:createNewFile	()Z
    //   373: istore_3
    //   374: iload_3
    //   375: ifne +56 -> 431
    //   378: iconst_0
    //   379: ifeq -289 -> 90
    //   382: new 722	java/lang/NullPointerException
    //   385: dup
    //   386: invokespecial 723	java/lang/NullPointerException:<init>	()V
    //   389: athrow
    //   390: astore_1
    //   391: aload_1
    //   392: invokevirtual 348	java/io/IOException:getMessage	()Ljava/lang/String;
    //   395: iconst_0
    //   396: anewarray 4	java/lang/Object
    //   399: invokestatic 342	com/tencent/mtt/abtestsdk/utils/ABTestLog:error	(Ljava/lang/String;[Ljava/lang/Object;)V
    //   402: return
    //   403: aload 5
    //   405: invokevirtual 384	org/json/JSONObject:toString	()Ljava/lang/String;
    //   408: astore 4
    //   410: goto -147 -> 263
    //   413: astore_2
    //   414: aload_2
    //   415: invokevirtual 359	org/json/JSONException:getMessage	()Ljava/lang/String;
    //   418: iconst_0
    //   419: anewarray 4	java/lang/Object
    //   422: invokestatic 342	com/tencent/mtt/abtestsdk/utils/ABTestLog:error	(Ljava/lang/String;[Ljava/lang/Object;)V
    //   425: aload_1
    //   426: astore 4
    //   428: goto -165 -> 263
    //   431: new 725	java/io/FileOutputStream
    //   434: dup
    //   435: aload_1
    //   436: invokespecial 726	java/io/FileOutputStream:<init>	(Ljava/io/File;)V
    //   439: astore_2
    //   440: aload_2
    //   441: astore_1
    //   442: aload_2
    //   443: aload 4
    //   445: ldc_w 325
    //   448: invokevirtual 730	java/lang/String:getBytes	(Ljava/lang/String;)[B
    //   451: invokevirtual 734	java/io/FileOutputStream:write	([B)V
    //   454: aload_2
    //   455: astore_1
    //   456: aload_2
    //   457: invokevirtual 737	java/io/FileOutputStream:flush	()V
    //   460: aload_2
    //   461: astore_1
    //   462: aload_0
    //   463: getfield 574	com/tencent/mtt/abtestsdk/ABTest/ABTestManager:mSharedPreferencesForKey	Landroid/content/SharedPreferences;
    //   466: invokeinterface 499 1 0
    //   471: ldc_w 698
    //   474: iconst_1
    //   475: invokeinterface 702 3 0
    //   480: invokeinterface 510 1 0
    //   485: aload_2
    //   486: ifnull -396 -> 90
    //   489: aload_2
    //   490: invokevirtual 738	java/io/FileOutputStream:close	()V
    //   493: return
    //   494: astore_1
    //   495: aload_1
    //   496: invokevirtual 348	java/io/IOException:getMessage	()Ljava/lang/String;
    //   499: iconst_0
    //   500: anewarray 4	java/lang/Object
    //   503: invokestatic 342	com/tencent/mtt/abtestsdk/utils/ABTestLog:error	(Ljava/lang/String;[Ljava/lang/Object;)V
    //   506: return
    //   507: astore 4
    //   509: aconst_null
    //   510: astore_2
    //   511: aload_2
    //   512: astore_1
    //   513: aload 4
    //   515: invokevirtual 348	java/io/IOException:getMessage	()Ljava/lang/String;
    //   518: iconst_0
    //   519: anewarray 4	java/lang/Object
    //   522: invokestatic 89	com/tencent/mtt/abtestsdk/utils/ABTestLog:debug	(Ljava/lang/String;[Ljava/lang/Object;)V
    //   525: aload_2
    //   526: ifnull -436 -> 90
    //   529: aload_2
    //   530: invokevirtual 738	java/io/FileOutputStream:close	()V
    //   533: return
    //   534: astore_1
    //   535: aload_1
    //   536: invokevirtual 348	java/io/IOException:getMessage	()Ljava/lang/String;
    //   539: iconst_0
    //   540: anewarray 4	java/lang/Object
    //   543: invokestatic 342	com/tencent/mtt/abtestsdk/utils/ABTestLog:error	(Ljava/lang/String;[Ljava/lang/Object;)V
    //   546: return
    //   547: astore_2
    //   548: aconst_null
    //   549: astore_1
    //   550: aload_1
    //   551: ifnull +7 -> 558
    //   554: aload_1
    //   555: invokevirtual 738	java/io/FileOutputStream:close	()V
    //   558: aload_2
    //   559: athrow
    //   560: astore_1
    //   561: aload_1
    //   562: invokevirtual 348	java/io/IOException:getMessage	()Ljava/lang/String;
    //   565: iconst_0
    //   566: anewarray 4	java/lang/Object
    //   569: invokestatic 342	com/tencent/mtt/abtestsdk/utils/ABTestLog:error	(Ljava/lang/String;[Ljava/lang/Object;)V
    //   572: goto -14 -> 558
    //   575: astore_2
    //   576: goto -26 -> 550
    //   579: astore 4
    //   581: goto -70 -> 511
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	584	0	this	ABTestManager
    //   0	584	1	paramString1	String
    //   0	584	2	paramString2	String
    //   142	233	3	bool	boolean
    //   16	428	4	str1	String
    //   507	7	4	localIOException1	java.io.IOException
    //   579	1	4	localIOException2	java.io.IOException
    //   126	278	5	localJSONObject1	JSONObject
    //   4	236	6	localJSONObject2	JSONObject
    //   216	11	7	str2	String
    //   168	68	8	localJSONObject3	JSONObject
    //   175	13	9	localIterator	Iterator
    //   158	42	10	localJSONObject4	JSONObject
    // Exception table:
    //   from	to	target	type
    //   150	177	248	java/lang/Exception
    //   177	235	248	java/lang/Exception
    //   235	245	248	java/lang/Exception
    //   403	410	248	java/lang/Exception
    //   382	390	390	java/io/IOException
    //   118	143	413	org/json/JSONException
    //   150	177	413	org/json/JSONException
    //   177	235	413	org/json/JSONException
    //   235	245	413	org/json/JSONException
    //   249	260	413	org/json/JSONException
    //   403	410	413	org/json/JSONException
    //   489	493	494	java/io/IOException
    //   369	374	507	java/io/IOException
    //   431	440	507	java/io/IOException
    //   529	533	534	java/io/IOException
    //   369	374	547	finally
    //   431	440	547	finally
    //   554	558	560	java/io/IOException
    //   442	454	575	finally
    //   456	460	575	finally
    //   462	485	575	finally
    //   513	525	575	finally
    //   442	454	579	java/io/IOException
    //   456	460	579	java/io/IOException
    //   462	485	579	java/io/IOException
  }
  
  private void saveReportStrategy(String paramString)
  {
    try
    {
      paramString = new JSONObject(paramString).optJSONObject("strategy");
      if (paramString == null)
      {
        ABTestLog.warn("[save_data] strategy value is null!!!", new Object[0]);
        return;
      }
      RomaStrategyEntity localRomaStrategyEntity = new RomaStrategyEntity();
      localRomaStrategyEntity.readFromJson(paramString);
      localRomaStrategyEntity.setUpdateTime(System.currentTimeMillis() / 1000L);
      this.romaStrategy = localRomaStrategyEntity;
      this.mSharedPreferencesForReport.edit().putBoolean("enableReport", localRomaStrategyEntity.isEnableReport()).apply();
      this.mSharedPreferencesForReport.edit().putString("id", localRomaStrategyEntity.getReportId()).apply();
      this.mSharedPreferencesForReport.edit().putString("token", localRomaStrategyEntity.getReportToken()).apply();
      this.mSharedPreferencesForReport.edit().putInt("refreshDuration", localRomaStrategyEntity.getRefreshDuration()).apply();
      this.mSharedPreferencesForReport.edit().putLong("updateTime", localRomaStrategyEntity.getUpdateTime()).apply();
      return;
    }
    catch (JSONException paramString)
    {
      ABTestLog.error(paramString.getMessage(), new Object[0]);
    }
  }
  
  public boolean clearExperiments()
  {
    if (this.mContext == null) {}
    File localFile;
    do
    {
      return false;
      localFile = new File(this.mContext.getExternalFilesDir("ABTestExperiments"), "experiments");
    } while (!localFile.exists());
    if (this.mSharedPreferencesForKey == null) {
      this.mSharedPreferencesForKey = this.mContext.getSharedPreferences("ab_test_android", 0);
    }
    this.mSharedPreferencesForKey.edit().putBoolean("obtained_experiments", false).apply();
    return localFile.delete();
  }
  
  public void doGetSourceExpByExpName(String paramString, OnUpdateExperimentsListener paramOnUpdateExperimentsListener, int paramInt)
  {
    ABTestLog.debug("request expName: " + paramString, new Object[0]);
    getExperimentsByTag(paramString, paramOnUpdateExperimentsListener, paramInt);
  }
  
  public void doGetSourceExperiments(OnUpdateExperimentsListener paramOnUpdateExperimentsListener, int paramInt)
  {
    ABTestLog.stepUpload("isSDKHasInit: " + IS_SDK_HAS_INIT, new Object[0]);
    if (IS_SDK_HAS_INIT)
    {
      long l1 = System.currentTimeMillis() / 1000L;
      int i = this.romaStrategy.getRefreshDuration();
      long l2 = this.romaStrategy.getUpdateTime();
      ABTestLog.stepUpload("curTime: " + l1 + "  updateTime:" + l2 + " diffTime:" + (l1 - l2) + "  refreshDuration:" + i, new Object[0]);
      if ((-1 != i) && (l1 - l2 < i))
      {
        ABTestLog.stepUpload("do not update strategy thie time", new Object[0]);
        return;
      }
    }
    getExperimentsByTag(null, paramOnUpdateExperimentsListener, paramInt);
  }
  
  public ABTestConfig getABTestConfig()
  {
    return this.mConfig;
  }
  
  public List<String> getAllExpGrayIds()
  {
    ArrayList localArrayList = new ArrayList();
    String str = this.mSharedPreferencesForReport.getString("gray_police_ids", "");
    if (TextUtils.isEmpty(str)) {
      return localArrayList;
    }
    if (!str.contains("#"))
    {
      localArrayList.add(str);
      return localArrayList;
    }
    return Arrays.asList(str.split("#"));
  }
  
  public List<RomaExpEntity> getAllRomaExpDataFromCache()
  {
    ArrayList localArrayList = new ArrayList();
    JSONObject localJSONObject = getAllExpDataFromCache();
    if ((localJSONObject == null) || (localJSONObject.keys() == null)) {
      return localArrayList;
    }
    Iterator localIterator = localJSONObject.keys();
    while (localIterator.hasNext())
    {
      RomaExpEntity localRomaExpEntity = new RomaExpEntity("");
      String str = (String)localIterator.next();
      localRomaExpEntity.readJson(localJSONObject.optJSONObject(str));
      localRomaExpEntity.setLayerCode(str);
      localArrayList.add(localRomaExpEntity);
    }
    return localArrayList;
  }
  
  public RomaExpEntity getCacheExpByName(String paramString)
  {
    RomaExpEntity localRomaExpEntity1 = new RomaExpEntity(paramString);
    JSONObject localJSONObject1 = getAllExpDataFromCache();
    if ((localJSONObject1 == null) || (localJSONObject1.keys() == null)) {
      return localRomaExpEntity1;
    }
    Iterator localIterator = localJSONObject1.keys();
    while (localIterator.hasNext())
    {
      String str = (String)localIterator.next();
      JSONObject localJSONObject2 = localJSONObject1.optJSONObject(str);
      RomaExpEntity localRomaExpEntity2 = new RomaExpEntity("");
      localRomaExpEntity2.readJson(localJSONObject2);
      localRomaExpEntity2.setLayerCode(str);
      if (localRomaExpEntity2.getExpName().equals(paramString)) {
        return localRomaExpEntity2;
      }
    }
    return localRomaExpEntity1;
  }
  
  public String getConfigInfoFromSP(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {}
    do
    {
      return null;
      if (this.mContext == null)
      {
        ABTestLog.warn("please check the context is not empty!", new Object[0]);
        return null;
      }
    } while (this.mSharedPreferencesForConfig == null);
    return this.mSharedPreferencesForConfig.getString(paramString, null);
  }
  
  public Context getContext()
  {
    return this.mContext;
  }
  
  public JSONObject getExpParamById(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return null;
    }
    JSONObject localJSONObject1 = getAllExpDataFromCache();
    if ((localJSONObject1 == null) || (localJSONObject1.keys() == null)) {
      return null;
    }
    Iterator localIterator = localJSONObject1.keys();
    while (localIterator.hasNext())
    {
      JSONObject localJSONObject2 = localJSONObject1.optJSONObject((String)localIterator.next());
      if (TextUtils.equals(localJSONObject2.optString("sGrayPolicyId"), paramString)) {
        return localJSONObject2.optJSONObject("params");
      }
    }
    return null;
  }
  
  public Map<String, RomaExpEntity> getHitExperiments()
  {
    HashMap localHashMap = new HashMap();
    JSONObject localJSONObject1 = getAllExpDataFromCache();
    if ((localJSONObject1 == null) || (localJSONObject1.keys() == null)) {
      return localHashMap;
    }
    Iterator localIterator = localJSONObject1.keys();
    while (localIterator.hasNext())
    {
      String str = (String)localIterator.next();
      JSONObject localJSONObject2 = localJSONObject1.optJSONObject(str);
      RomaExpEntity localRomaExpEntity = new RomaExpEntity("");
      localRomaExpEntity.readJson(localJSONObject2);
      localRomaExpEntity.setLayerCode(str);
      localHashMap.put(str, localRomaExpEntity);
    }
    return localHashMap;
  }
  
  public String getLayerName(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return paramString;
    }
    JSONObject localJSONObject = getAllExpDataFromCache();
    if ((localJSONObject == null) || (localJSONObject.keys() == null)) {
      return "";
    }
    Iterator localIterator = localJSONObject.keys();
    while (localIterator.hasNext())
    {
      String str = (String)localIterator.next();
      if (TextUtils.equals(localJSONObject.optJSONObject(str).optString("sGrayPolicyId"), paramString)) {
        return str;
      }
    }
    return "";
  }
  
  public Object getValue(String paramString, Object paramObject)
  {
    JSONObject localJSONObject1 = getAllExpDataFromCache();
    if ((localJSONObject1 == null) || (localJSONObject1.keys() == null)) {}
    JSONObject localJSONObject2;
    do
    {
      Iterator localIterator;
      while (!localIterator.hasNext())
      {
        return paramObject;
        localIterator = localJSONObject1.keys();
      }
      localJSONObject2 = localJSONObject1.optJSONObject((String)localIterator.next()).optJSONObject("params");
    } while ((localJSONObject2 == null) || (!localJSONObject2.has(paramString)));
    return localJSONObject2.opt(paramString);
  }
  
  public void init(@NonNull WeakReference<Context> paramWeakReference, ABTestConfig paramABTestConfig)
  {
    this.mContext = ((Context)paramWeakReference.get());
    this.mConfig = paramABTestConfig;
    initSharedPerfAndSetClearStatus();
    initSPBuglySDK();
    loadReportStrategy();
    saveConfigInfo();
    startUpdateTimer();
  }
  
  public int isFirstHit(String paramString)
  {
    if (this.mSharedPreferencesForReport == null) {
      this.mSharedPreferencesForReport = this.mContext.getSharedPreferences("ab_test_android_report", 0);
    }
    String str = this.mSharedPreferencesForReport.getString("gray_police_ids", "");
    if ((TextUtils.isEmpty(str)) || (!str.contains(paramString))) {
      return -1;
    }
    return this.mSharedPreferencesForReport.getInt(paramString, -1);
  }
  
  public boolean isSaveExperimentInfoSucceed()
  {
    boolean bool = false;
    JSONObject localJSONObject = getAllExpDataFromCache();
    if (localJSONObject != null)
    {
      ABTestLog.debug("cache data:" + localJSONObject.toString(), new Object[0]);
      bool = true;
    }
    while (this.mSharedPreferencesForKey == null) {
      return bool;
    }
    return this.mSharedPreferencesForKey.getBoolean("obtained_experiments", false);
  }
  
  public boolean reportBeaconApiEvent(String paramString, boolean paramBoolean, long paramLong)
  {
    try
    {
      String str2 = getABTestConfig().getGuid();
      String str3 = ABTestUtil.getABTestSDKAppId(this.mContext, this.mConfig);
      if (paramBoolean) {}
      for (String str1 = "1";; str1 = "0")
      {
        paramBoolean = BeaconReport.reportApiEvent("TabApiEvent", str2, str3, paramString, str1, String.valueOf(paramLong));
        ABTestLog.stepReport(paramString + " api report event " + paramBoolean, new Object[0]);
        return paramBoolean;
      }
      return false;
    }
    catch (Exception localException)
    {
      ABTestLog.stepReport("beacon report " + paramString + " failed!  " + localException.getMessage(), new Object[0]);
    }
  }
  
  public boolean reportBeaconExpExpose(String paramString1, String paramString2)
  {
    try
    {
      boolean bool = BeaconReport.reportExpEvent("rqd_expimpression", paramString1, paramString2, getABTestConfig().getGuid(), ABTestUtil.getABTestSDKAppId(this.mContext, this.mConfig));
      return bool;
    }
    catch (Exception paramString1)
    {
      ABTestLog.warn("beacon report failed ", new Object[0]);
    }
    return false;
  }
  
  public void reportExpAttaExpose(String paramString)
  {
    doAttaReport("trigger", paramString);
  }
  
  public void saveConfigInfo()
  {
    if ((this.mContext == null) || (this.mConfig == null))
    {
      ABTestLog.error("[SDKInit] saveConfigInfo failed. mContext or mConfig is null, context = " + this.mContext, new Object[0]);
      return;
    }
    initDefaultProfiles(this.mConfig);
    initSharePerfenceForConfig(this.mConfig);
  }
  
  public void startUpdateTimer()
  {
    doGetSourceExperiments(null, 0);
    int i = this.romaStrategy.getRefreshDuration();
    ABTestLog.debug("[SDKInit] refreshDuration:" + i, new Object[0]);
    HandlerThreadUtil.getHandler().sendEmptyMessageDelayed(0, 60000L);
  }
  
  public void stopUpdateTimer()
  {
    ABTestLog.debug("stopUpdateTimer and removeCallBacks", new Object[0]);
    HandlerThreadUtil.getHandler().sendEmptyMessage(1);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mtt.abtestsdk.ABTest.ABTestManager
 * JD-Core Version:    0.7.0.1
 */