package com.tencent.mtt.abtestsdk.ABTest;

import android.app.Activity;
import android.app.Application;
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
import com.tencent.mtt.abtestsdk.utils.ThreadUtil;
import java.io.File;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import okhttp3.OkHttpClient.Builder;
import org.json.JSONException;
import org.json.JSONObject;

public class ABTestManager
{
  private static final boolean DEBUG = false;
  public static final int DEFAULT_REFRESH_TIME = 10;
  public static final int DEFAULT_TIMEOUT = 2;
  private static final int GET_EXPERIMENTS_FAILED = 1;
  private static final int GET_EXPERIMENTS_SUCCESS = 0;
  public static volatile boolean IS_SDK_HAS_INIT = false;
  private static final String PLATFORM = "Android";
  private static final String TAG = "ABTestManager";
  private static LruCache<String, JSONObject> mCache = new LruCache(ABTestUtil.maxMemCacheSize());
  final OkHttpClient.Builder builder = new OkHttpClient.Builder();
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
      ABTestLog.debug("ABTestManager", new Object[] { "report not enabled!" });
      return;
    }
    String str1 = "";
    if (this.mConfig != null) {
      str1 = this.mConfig.getGuid();
    }
    if (this.mSharedPreferencesForReport.getInt(paramString2, -1) >= 2) {}
    for (String str2 = "0";; str2 = "1")
    {
      String str4 = getConfigInfoFromSP("bundle_app_info");
      String str5 = getConfigInfoFromSP("bundle_version");
      long l = System.currentTimeMillis();
      String str3 = "";
      Object localObject = ActivityManager.getInstance().getCurrentActivity();
      if (localObject != null) {
        str3 = ((Activity)localObject).getLocalClassName();
      }
      localObject = getConfigInfoFromSP("os_version");
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
      localAttaEntity.bundleid = str4;
      localAttaEntity.bundlerversion = str5;
      localAttaEntity.channel = "";
      localAttaEntity.devicebrand = str6;
      localAttaEntity.devicemodel = str7;
      localAttaEntity.eventpage = str3;
      localAttaEntity.eventtime = String.valueOf(l);
      localAttaEntity.sdkversion = "1.1.0.9";
      localAttaEntity.resolution = str8;
      localAttaEntity.language = str9;
      localAttaEntity.osmodel = "android";
      localAttaEntity.osversion = ((String)localObject);
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
    //   1: getfield 176	com/tencent/mtt/abtestsdk/ABTest/ABTestManager:mContext	Landroid/content/Context;
    //   4: ifnull +9 -> 13
    //   7: invokestatic 314	com/tencent/mtt/abtestsdk/utils/ABTestUtil:isSDCardMounted	()Z
    //   10: ifne +35 -> 45
    //   13: new 158	java/lang/StringBuilder
    //   16: dup
    //   17: invokespecial 159	java/lang/StringBuilder:<init>	()V
    //   20: ldc_w 316
    //   23: invokevirtual 165	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   26: aload_0
    //   27: getfield 176	com/tencent/mtt/abtestsdk/ABTest/ABTestManager:mContext	Landroid/content/Context;
    //   30: invokevirtual 319	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   33: invokevirtual 172	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   36: iconst_0
    //   37: anewarray 4	java/lang/Object
    //   40: invokestatic 275	com/tencent/mtt/abtestsdk/utils/ABTestLog:warn	(Ljava/lang/String;[Ljava/lang/Object;)V
    //   43: aconst_null
    //   44: areturn
    //   45: new 321	java/io/File
    //   48: dup
    //   49: aload_0
    //   50: getfield 176	com/tencent/mtt/abtestsdk/ABTest/ABTestManager:mContext	Landroid/content/Context;
    //   53: ldc_w 323
    //   56: invokevirtual 329	android/content/Context:getExternalFilesDir	(Ljava/lang/String;)Ljava/io/File;
    //   59: ldc_w 331
    //   62: invokespecial 334	java/io/File:<init>	(Ljava/io/File;Ljava/lang/String;)V
    //   65: astore_1
    //   66: aload_1
    //   67: invokevirtual 337	java/io/File:exists	()Z
    //   70: ifne +35 -> 105
    //   73: new 158	java/lang/StringBuilder
    //   76: dup
    //   77: invokespecial 159	java/lang/StringBuilder:<init>	()V
    //   80: aload_1
    //   81: invokevirtual 340	java/io/File:getName	()Ljava/lang/String;
    //   84: invokevirtual 165	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   87: ldc_w 342
    //   90: invokevirtual 165	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   93: invokevirtual 172	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   96: iconst_0
    //   97: anewarray 4	java/lang/Object
    //   100: invokestatic 275	com/tencent/mtt/abtestsdk/utils/ABTestLog:warn	(Ljava/lang/String;[Ljava/lang/Object;)V
    //   103: aconst_null
    //   104: areturn
    //   105: new 158	java/lang/StringBuilder
    //   108: dup
    //   109: invokespecial 159	java/lang/StringBuilder:<init>	()V
    //   112: astore 7
    //   114: new 344	java/io/FileInputStream
    //   117: dup
    //   118: aload_1
    //   119: invokespecial 347	java/io/FileInputStream:<init>	(Ljava/io/File;)V
    //   122: astore_1
    //   123: new 349	java/io/InputStreamReader
    //   126: dup
    //   127: aload_1
    //   128: ldc_w 351
    //   131: invokespecial 354	java/io/InputStreamReader:<init>	(Ljava/io/InputStream;Ljava/lang/String;)V
    //   134: astore_2
    //   135: new 356	java/io/BufferedReader
    //   138: dup
    //   139: aload_2
    //   140: invokespecial 359	java/io/BufferedReader:<init>	(Ljava/io/Reader;)V
    //   143: astore 6
    //   145: aload 6
    //   147: astore 5
    //   149: aload_2
    //   150: astore 4
    //   152: aload_1
    //   153: astore_3
    //   154: aload 6
    //   156: invokevirtual 362	java/io/BufferedReader:readLine	()Ljava/lang/String;
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
    //   179: invokevirtual 165	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
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
    //   199: invokevirtual 365	java/io/FileNotFoundException:getMessage	()Ljava/lang/String;
    //   202: iconst_0
    //   203: anewarray 4	java/lang/Object
    //   206: invokestatic 368	com/tencent/mtt/abtestsdk/utils/ABTestLog:error	(Ljava/lang/String;[Ljava/lang/Object;)V
    //   209: aload 6
    //   211: ifnull +8 -> 219
    //   214: aload 6
    //   216: invokevirtual 371	java/io/BufferedReader:close	()V
    //   219: aload_2
    //   220: ifnull +7 -> 227
    //   223: aload_2
    //   224: invokevirtual 372	java/io/InputStreamReader:close	()V
    //   227: aload_1
    //   228: ifnull -185 -> 43
    //   231: aload_1
    //   232: invokevirtual 373	java/io/FileInputStream:close	()V
    //   235: aconst_null
    //   236: areturn
    //   237: astore_1
    //   238: aload_1
    //   239: invokevirtual 374	java/io/IOException:getMessage	()Ljava/lang/String;
    //   242: iconst_0
    //   243: anewarray 4	java/lang/Object
    //   246: invokestatic 368	com/tencent/mtt/abtestsdk/utils/ABTestLog:error	(Ljava/lang/String;[Ljava/lang/Object;)V
    //   249: aconst_null
    //   250: areturn
    //   251: aload 6
    //   253: astore 5
    //   255: aload_2
    //   256: astore 4
    //   258: aload_1
    //   259: astore_3
    //   260: aload 7
    //   262: invokevirtual 172	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   265: invokestatic 380	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   268: ifeq +64 -> 332
    //   271: aload 6
    //   273: astore 5
    //   275: aload_2
    //   276: astore 4
    //   278: aload_1
    //   279: astore_3
    //   280: ldc_w 382
    //   283: iconst_0
    //   284: anewarray 4	java/lang/Object
    //   287: invokestatic 101	com/tencent/mtt/abtestsdk/utils/ABTestLog:debug	(Ljava/lang/String;[Ljava/lang/Object;)V
    //   290: aload 6
    //   292: ifnull +8 -> 300
    //   295: aload 6
    //   297: invokevirtual 371	java/io/BufferedReader:close	()V
    //   300: aload_2
    //   301: ifnull +7 -> 308
    //   304: aload_2
    //   305: invokevirtual 372	java/io/InputStreamReader:close	()V
    //   308: aload_1
    //   309: ifnull -266 -> 43
    //   312: aload_1
    //   313: invokevirtual 373	java/io/FileInputStream:close	()V
    //   316: aconst_null
    //   317: areturn
    //   318: astore_1
    //   319: aload_1
    //   320: invokevirtual 374	java/io/IOException:getMessage	()Ljava/lang/String;
    //   323: iconst_0
    //   324: anewarray 4	java/lang/Object
    //   327: invokestatic 368	com/tencent/mtt/abtestsdk/utils/ABTestLog:error	(Ljava/lang/String;[Ljava/lang/Object;)V
    //   330: aconst_null
    //   331: areturn
    //   332: aload 6
    //   334: astore 5
    //   336: aload_2
    //   337: astore 4
    //   339: aload_1
    //   340: astore_3
    //   341: new 267	org/json/JSONObject
    //   344: dup
    //   345: aload 7
    //   347: invokevirtual 172	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   350: invokespecial 384	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   353: astore 7
    //   355: aload 6
    //   357: ifnull +8 -> 365
    //   360: aload 6
    //   362: invokevirtual 371	java/io/BufferedReader:close	()V
    //   365: aload_2
    //   366: ifnull +7 -> 373
    //   369: aload_2
    //   370: invokevirtual 372	java/io/InputStreamReader:close	()V
    //   373: aload_1
    //   374: ifnull +7 -> 381
    //   377: aload_1
    //   378: invokevirtual 373	java/io/FileInputStream:close	()V
    //   381: aload 7
    //   383: areturn
    //   384: astore_1
    //   385: aload_1
    //   386: invokevirtual 374	java/io/IOException:getMessage	()Ljava/lang/String;
    //   389: iconst_0
    //   390: anewarray 4	java/lang/Object
    //   393: invokestatic 368	com/tencent/mtt/abtestsdk/utils/ABTestLog:error	(Ljava/lang/String;[Ljava/lang/Object;)V
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
    //   419: invokevirtual 374	java/io/IOException:getMessage	()Ljava/lang/String;
    //   422: iconst_0
    //   423: anewarray 4	java/lang/Object
    //   426: invokestatic 368	com/tencent/mtt/abtestsdk/utils/ABTestLog:error	(Ljava/lang/String;[Ljava/lang/Object;)V
    //   429: aload 6
    //   431: ifnull +8 -> 439
    //   434: aload 6
    //   436: invokevirtual 371	java/io/BufferedReader:close	()V
    //   439: aload_2
    //   440: ifnull +7 -> 447
    //   443: aload_2
    //   444: invokevirtual 372	java/io/InputStreamReader:close	()V
    //   447: aload_1
    //   448: ifnull -405 -> 43
    //   451: aload_1
    //   452: invokevirtual 373	java/io/FileInputStream:close	()V
    //   455: aconst_null
    //   456: areturn
    //   457: astore_1
    //   458: aload_1
    //   459: invokevirtual 374	java/io/IOException:getMessage	()Ljava/lang/String;
    //   462: iconst_0
    //   463: anewarray 4	java/lang/Object
    //   466: invokestatic 368	com/tencent/mtt/abtestsdk/utils/ABTestLog:error	(Ljava/lang/String;[Ljava/lang/Object;)V
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
    //   491: invokevirtual 385	org/json/JSONException:getMessage	()Ljava/lang/String;
    //   494: iconst_0
    //   495: anewarray 4	java/lang/Object
    //   498: invokestatic 368	com/tencent/mtt/abtestsdk/utils/ABTestLog:error	(Ljava/lang/String;[Ljava/lang/Object;)V
    //   501: aload 6
    //   503: ifnull +8 -> 511
    //   506: aload 6
    //   508: invokevirtual 371	java/io/BufferedReader:close	()V
    //   511: aload_2
    //   512: ifnull +7 -> 519
    //   515: aload_2
    //   516: invokevirtual 372	java/io/InputStreamReader:close	()V
    //   519: aload_1
    //   520: ifnull -477 -> 43
    //   523: aload_1
    //   524: invokevirtual 373	java/io/FileInputStream:close	()V
    //   527: aconst_null
    //   528: areturn
    //   529: astore_1
    //   530: aload_1
    //   531: invokevirtual 374	java/io/IOException:getMessage	()Ljava/lang/String;
    //   534: iconst_0
    //   535: anewarray 4	java/lang/Object
    //   538: invokestatic 368	com/tencent/mtt/abtestsdk/utils/ABTestLog:error	(Ljava/lang/String;[Ljava/lang/Object;)V
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
    //   559: invokevirtual 371	java/io/BufferedReader:close	()V
    //   562: aload_2
    //   563: ifnull +7 -> 570
    //   566: aload_2
    //   567: invokevirtual 372	java/io/InputStreamReader:close	()V
    //   570: aload_1
    //   571: ifnull +7 -> 578
    //   574: aload_1
    //   575: invokevirtual 373	java/io/FileInputStream:close	()V
    //   578: aload 6
    //   580: athrow
    //   581: astore_1
    //   582: aload_1
    //   583: invokevirtual 374	java/io/IOException:getMessage	()Ljava/lang/String;
    //   586: iconst_0
    //   587: anewarray 4	java/lang/Object
    //   590: invokestatic 368	com/tencent/mtt/abtestsdk/utils/ABTestLog:error	(Ljava/lang/String;[Ljava/lang/Object;)V
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
  
  @Deprecated
  private void getExperimentsByGuid(OnUpdateExperimentsListener paramOnUpdateExperimentsListener, int paramInt)
  {
    String str = this.mConfig.getRequestUrl();
    ABTestLog.debug("request url:" + str, new Object[0]);
    ThreadUtil.execute(new ABTestManager.1(this, new ABTestManager.UIHandler(paramOnUpdateExperimentsListener), str, paramInt));
  }
  
  private void getExperimentsByTag(String paramString, OnUpdateExperimentsListener paramOnUpdateExperimentsListener, int paramInt)
  {
    paramOnUpdateExperimentsListener = new ABTestManager.UIHandler(paramOnUpdateExperimentsListener);
    if (this.mConfig == null) {
      this.mConfig = new ABTestConfig();
    }
    Object localObject = this.mConfig.getCustomTag();
    ABTestLog.stepUpload("customTag: " + localObject.toString(), new Object[0]);
    String str1 = new JSONObject((Map)localObject).toString();
    localObject = this.mConfig.getRequestUrl();
    List localList = this.mConfig.getLayerCodes();
    String str2 = this.mConfig.getSceneId();
    ABTestLog.stepUpload("requestUrl:" + (String)localObject + "  expName:" + paramString + " customConfig:" + str1 + "  timeout:" + paramInt + " layerCodes:" + localList + " sceneId:" + str2, new Object[0]);
    if (paramInt > 0) {
      this.builder.connectTimeout(paramInt, TimeUnit.SECONDS);
    }
    for (;;)
    {
      JSONObject localJSONObject1 = new JSONObject();
      JSONObject localJSONObject2 = new JSONObject();
      try
      {
        String str3 = ABTestUtil.getABTestSDKAppKey(this.mContext, this.mConfig);
        localJSONObject2.put("appid", ABTestUtil.getABTestSDKAppId(this.mContext, this.mConfig));
        localJSONObject2.put("appkey", str3);
        localJSONObject2.put("guid", this.mConfig.getGuid());
        if (!TextUtils.isEmpty(paramString)) {
          localJSONObject2.put("expName", paramString);
        }
        if ((localList != null) && (!localList.isEmpty())) {
          localJSONObject2.put("layerCodes", localList.toString());
        }
        if (!TextUtils.isEmpty(str2)) {
          localJSONObject2.put("sceneId", str2);
        }
        localJSONObject2.put("profiles", new JSONObject(str1));
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
      ThreadUtil.execute(new ABTestManager.2(this, paramOnUpdateExperimentsListener, (String)localObject, localJSONObject1, paramInt, paramString));
      return;
      this.builder.connectTimeout(2L, TimeUnit.SECONDS);
    }
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
    paramABTestConfig.put("ROMA_SDK_VERSION", "1.1.0.9");
    paramABTestConfig.put("ROMA_OS_MODEL", SystemUtil.getSystemModel());
    paramABTestConfig.put("ROMA_OS_VER", SystemUtil.getSystemVersion());
    paramABTestConfig.put("ROMA_PLATFORM", "Android");
    paramABTestConfig.put("ROMA_BRAND", SystemUtil.getDeviceBrand());
    paramABTestConfig.put("ROMA_RESOLUTION", "");
  }
  
  private void initSPBuglySDK()
  {
    this.mContext.getSharedPreferences("BuglySdkInfos", 0).edit().putString("4aeafa6143", "1.1.0.9").apply();
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
  
  private void registerLifeCycleCallBacks()
  {
    Application localApplication = null;
    if (this.mContext == null)
    {
      ABTestLog.error("[SDKInit] mContext is null and check the mContext", new Object[0]);
      return;
    }
    if ((this.mContext.getApplicationContext() instanceof Application)) {
      localApplication = (Application)this.mContext.getApplicationContext();
    }
    while (localApplication == null)
    {
      ABTestLog.warn("[SDKInit] registerLifeCycleCallBacks: app is null", new Object[0]);
      return;
      if ((this.mContext instanceof Application)) {
        localApplication = (Application)this.mContext;
      }
    }
    localApplication.registerActivityLifecycleCallbacks(ActivityManager.getInstance());
  }
  
  private void saveExpGrayIdInfo(String paramString1, String paramString2)
  {
    ArrayList localArrayList;
    for (;;)
    {
      try
      {
        paramString2 = new JSONObject(paramString1).optJSONObject("data");
        localArrayList = new ArrayList();
        Iterator localIterator = paramString2.keys();
        paramString1 = "";
        if (!localIterator.hasNext()) {
          break;
        }
        String str = paramString2.optJSONObject((String)localIterator.next()).optString("sGrayPolicyId", "_");
        paramString1 = this.mSharedPreferencesForReport.getString("gray_police_ids", "");
        int i = this.mSharedPreferencesForReport.getInt(str, -1);
        if ((TextUtils.isEmpty(paramString1)) || (!paramString1.contains(str)))
        {
          localArrayList.add(str);
          this.mSharedPreferencesForReport.edit().putInt(str, 1).apply();
        }
        else
        {
          this.mSharedPreferencesForReport.edit().putInt(str, i + 1).apply();
        }
      }
      catch (JSONException paramString1)
      {
        ABTestLog.error(paramString1.getMessage(), new Object[0]);
        return;
      }
    }
    paramString1 = paramString1 + TextUtils.join("#", localArrayList);
    ABTestLog.debug("hit grayIds: " + paramString1, new Object[0]);
    this.mSharedPreferencesForReport.edit().putString("gray_police_ids", paramString1).apply();
  }
  
  /* Error */
  private void saveExpInfosToFile(String paramString1, String paramString2)
  {
    // Byte code:
    //   0: aload_0
    //   1: invokespecial 270	com/tencent/mtt/abtestsdk/ABTest/ABTestManager:getAllExpResInfoFromFile	()Lorg/json/JSONObject;
    //   4: astore 6
    //   6: aload 6
    //   8: ifnull +66 -> 74
    //   11: aload 6
    //   13: invokevirtual 427	org/json/JSONObject:toString	()Ljava/lang/String;
    //   16: astore 4
    //   18: aload 4
    //   20: invokestatic 380	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   23: ifne +58 -> 81
    //   26: aload 4
    //   28: aload_1
    //   29: invokestatic 755	android/text/TextUtils:equals	(Ljava/lang/CharSequence;Ljava/lang/CharSequence;)Z
    //   32: ifeq +49 -> 81
    //   35: aload_0
    //   36: getfield 623	com/tencent/mtt/abtestsdk/ABTest/ABTestManager:mSharedPreferencesForKey	Landroid/content/SharedPreferences;
    //   39: invokeinterface 548 1 0
    //   44: ldc_w 757
    //   47: iconst_1
    //   48: invokeinterface 761 3 0
    //   53: invokeinterface 559 1 0
    //   58: ldc 23
    //   60: iconst_1
    //   61: anewarray 4	java/lang/Object
    //   64: dup
    //   65: iconst_0
    //   66: ldc_w 763
    //   69: aastore
    //   70: invokestatic 101	com/tencent/mtt/abtestsdk/utils/ABTestLog:debug	(Ljava/lang/String;[Ljava/lang/Object;)V
    //   73: return
    //   74: ldc 103
    //   76: astore 4
    //   78: goto -60 -> 18
    //   81: aload_0
    //   82: getfield 176	com/tencent/mtt/abtestsdk/ABTest/ABTestManager:mContext	Landroid/content/Context;
    //   85: ifnull -12 -> 73
    //   88: aload_1
    //   89: invokestatic 380	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   92: ifne -19 -> 73
    //   95: invokestatic 314	com/tencent/mtt/abtestsdk/utils/ABTestUtil:isSDCardMounted	()Z
    //   98: ifeq -25 -> 73
    //   101: new 267	org/json/JSONObject
    //   104: dup
    //   105: aload_1
    //   106: invokespecial 384	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   109: astore 5
    //   111: aload 5
    //   113: ldc_w 281
    //   116: invokevirtual 289	org/json/JSONObject:optInt	(Ljava/lang/String;)I
    //   119: ifne -46 -> 73
    //   122: aload_2
    //   123: invokestatic 380	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   126: istore_3
    //   127: aload_1
    //   128: astore 4
    //   130: iload_3
    //   131: ifne +116 -> 247
    //   134: aload 6
    //   136: ldc_w 296
    //   139: invokevirtual 766	org/json/JSONObject:getJSONObject	(Ljava/lang/String;)Lorg/json/JSONObject;
    //   142: astore 10
    //   144: aload 5
    //   146: ldc_w 296
    //   149: invokevirtual 766	org/json/JSONObject:getJSONObject	(Ljava/lang/String;)Lorg/json/JSONObject;
    //   152: astore 9
    //   154: aload 10
    //   156: invokevirtual 716	org/json/JSONObject:keys	()Ljava/util/Iterator;
    //   159: astore 8
    //   161: aload 8
    //   163: invokeinterface 721 1 0
    //   168: ifeq +219 -> 387
    //   171: aload 8
    //   173: invokeinterface 725 1 0
    //   178: checkcast 220	java/lang/String
    //   181: astore 6
    //   183: aload 10
    //   185: aload 6
    //   187: invokevirtual 766	org/json/JSONObject:getJSONObject	(Ljava/lang/String;)Lorg/json/JSONObject;
    //   190: astore 7
    //   192: aload 7
    //   194: ldc_w 469
    //   197: invokevirtual 768	org/json/JSONObject:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   200: astore 4
    //   202: aload 4
    //   204: invokestatic 380	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   207: ifne +12 -> 219
    //   210: aload 4
    //   212: aload_2
    //   213: invokevirtual 633	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   216: ifne -55 -> 161
    //   219: aload 9
    //   221: aload 6
    //   223: aload 7
    //   225: invokevirtual 464	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   228: pop
    //   229: goto -68 -> 161
    //   232: astore_2
    //   233: aload_2
    //   234: invokevirtual 769	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   237: iconst_0
    //   238: anewarray 4	java/lang/Object
    //   241: invokestatic 368	com/tencent/mtt/abtestsdk/utils/ABTestLog:error	(Ljava/lang/String;[Ljava/lang/Object;)V
    //   244: aload_1
    //   245: astore 4
    //   247: aload_0
    //   248: getfield 176	com/tencent/mtt/abtestsdk/ABTest/ABTestManager:mContext	Landroid/content/Context;
    //   251: ldc_w 323
    //   254: invokevirtual 329	android/content/Context:getExternalFilesDir	(Ljava/lang/String;)Ljava/io/File;
    //   257: astore_1
    //   258: aload_1
    //   259: ifnull +40 -> 299
    //   262: aload_1
    //   263: invokevirtual 337	java/io/File:exists	()Z
    //   266: ifeq +33 -> 299
    //   269: new 158	java/lang/StringBuilder
    //   272: dup
    //   273: invokespecial 159	java/lang/StringBuilder:<init>	()V
    //   276: ldc_w 771
    //   279: invokevirtual 165	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   282: aload_1
    //   283: invokevirtual 774	java/io/File:getAbsolutePath	()Ljava/lang/String;
    //   286: invokevirtual 165	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   289: invokevirtual 172	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   292: iconst_0
    //   293: anewarray 4	java/lang/Object
    //   296: invokestatic 101	com/tencent/mtt/abtestsdk/utils/ABTestLog:debug	(Ljava/lang/String;[Ljava/lang/Object;)V
    //   299: new 321	java/io/File
    //   302: dup
    //   303: aload_1
    //   304: ldc_w 331
    //   307: invokespecial 334	java/io/File:<init>	(Ljava/io/File;Ljava/lang/String;)V
    //   310: astore_1
    //   311: aload_1
    //   312: invokevirtual 337	java/io/File:exists	()Z
    //   315: ifeq +10 -> 325
    //   318: aload_1
    //   319: invokevirtual 777	java/io/File:delete	()Z
    //   322: ifeq -249 -> 73
    //   325: new 158	java/lang/StringBuilder
    //   328: dup
    //   329: invokespecial 159	java/lang/StringBuilder:<init>	()V
    //   332: ldc_w 779
    //   335: invokevirtual 165	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   338: aload 4
    //   340: invokevirtual 165	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   343: invokevirtual 172	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   346: iconst_0
    //   347: anewarray 4	java/lang/Object
    //   350: invokestatic 101	com/tencent/mtt/abtestsdk/utils/ABTestLog:debug	(Ljava/lang/String;[Ljava/lang/Object;)V
    //   353: aload_1
    //   354: invokevirtual 782	java/io/File:createNewFile	()Z
    //   357: istore_3
    //   358: iload_3
    //   359: ifne +56 -> 415
    //   362: iconst_0
    //   363: ifeq -290 -> 73
    //   366: new 784	java/lang/NullPointerException
    //   369: dup
    //   370: invokespecial 785	java/lang/NullPointerException:<init>	()V
    //   373: athrow
    //   374: astore_1
    //   375: aload_1
    //   376: invokevirtual 374	java/io/IOException:getMessage	()Ljava/lang/String;
    //   379: iconst_0
    //   380: anewarray 4	java/lang/Object
    //   383: invokestatic 368	com/tencent/mtt/abtestsdk/utils/ABTestLog:error	(Ljava/lang/String;[Ljava/lang/Object;)V
    //   386: return
    //   387: aload 5
    //   389: invokevirtual 427	org/json/JSONObject:toString	()Ljava/lang/String;
    //   392: astore 4
    //   394: goto -147 -> 247
    //   397: astore_2
    //   398: aload_2
    //   399: invokevirtual 385	org/json/JSONException:getMessage	()Ljava/lang/String;
    //   402: iconst_0
    //   403: anewarray 4	java/lang/Object
    //   406: invokestatic 368	com/tencent/mtt/abtestsdk/utils/ABTestLog:error	(Ljava/lang/String;[Ljava/lang/Object;)V
    //   409: aload_1
    //   410: astore 4
    //   412: goto -165 -> 247
    //   415: new 787	java/io/FileOutputStream
    //   418: dup
    //   419: aload_1
    //   420: invokespecial 788	java/io/FileOutputStream:<init>	(Ljava/io/File;)V
    //   423: astore_2
    //   424: aload_2
    //   425: astore_1
    //   426: aload_2
    //   427: aload 4
    //   429: ldc_w 351
    //   432: invokevirtual 792	java/lang/String:getBytes	(Ljava/lang/String;)[B
    //   435: invokevirtual 796	java/io/FileOutputStream:write	([B)V
    //   438: aload_2
    //   439: astore_1
    //   440: aload_2
    //   441: invokevirtual 799	java/io/FileOutputStream:flush	()V
    //   444: aload_2
    //   445: astore_1
    //   446: aload_0
    //   447: getfield 623	com/tencent/mtt/abtestsdk/ABTest/ABTestManager:mSharedPreferencesForKey	Landroid/content/SharedPreferences;
    //   450: invokeinterface 548 1 0
    //   455: ldc_w 757
    //   458: iconst_1
    //   459: invokeinterface 761 3 0
    //   464: invokeinterface 559 1 0
    //   469: aload_2
    //   470: ifnull -397 -> 73
    //   473: aload_2
    //   474: invokevirtual 800	java/io/FileOutputStream:close	()V
    //   477: return
    //   478: astore_1
    //   479: aload_1
    //   480: invokevirtual 374	java/io/IOException:getMessage	()Ljava/lang/String;
    //   483: iconst_0
    //   484: anewarray 4	java/lang/Object
    //   487: invokestatic 368	com/tencent/mtt/abtestsdk/utils/ABTestLog:error	(Ljava/lang/String;[Ljava/lang/Object;)V
    //   490: return
    //   491: astore 4
    //   493: aconst_null
    //   494: astore_2
    //   495: aload_2
    //   496: astore_1
    //   497: aload 4
    //   499: invokevirtual 374	java/io/IOException:getMessage	()Ljava/lang/String;
    //   502: iconst_0
    //   503: anewarray 4	java/lang/Object
    //   506: invokestatic 101	com/tencent/mtt/abtestsdk/utils/ABTestLog:debug	(Ljava/lang/String;[Ljava/lang/Object;)V
    //   509: aload_2
    //   510: ifnull -437 -> 73
    //   513: aload_2
    //   514: invokevirtual 800	java/io/FileOutputStream:close	()V
    //   517: return
    //   518: astore_1
    //   519: aload_1
    //   520: invokevirtual 374	java/io/IOException:getMessage	()Ljava/lang/String;
    //   523: iconst_0
    //   524: anewarray 4	java/lang/Object
    //   527: invokestatic 368	com/tencent/mtt/abtestsdk/utils/ABTestLog:error	(Ljava/lang/String;[Ljava/lang/Object;)V
    //   530: return
    //   531: astore_2
    //   532: aconst_null
    //   533: astore_1
    //   534: aload_1
    //   535: ifnull +7 -> 542
    //   538: aload_1
    //   539: invokevirtual 800	java/io/FileOutputStream:close	()V
    //   542: aload_2
    //   543: athrow
    //   544: astore_1
    //   545: aload_1
    //   546: invokevirtual 374	java/io/IOException:getMessage	()Ljava/lang/String;
    //   549: iconst_0
    //   550: anewarray 4	java/lang/Object
    //   553: invokestatic 368	com/tencent/mtt/abtestsdk/utils/ABTestLog:error	(Ljava/lang/String;[Ljava/lang/Object;)V
    //   556: goto -14 -> 542
    //   559: astore_2
    //   560: goto -26 -> 534
    //   563: astore 4
    //   565: goto -70 -> 495
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	568	0	this	ABTestManager
    //   0	568	1	paramString1	String
    //   0	568	2	paramString2	String
    //   126	233	3	bool	boolean
    //   16	412	4	str	String
    //   491	7	4	localIOException1	java.io.IOException
    //   563	1	4	localIOException2	java.io.IOException
    //   109	279	5	localJSONObject1	JSONObject
    //   4	218	6	localObject	Object
    //   190	34	7	localJSONObject2	JSONObject
    //   159	13	8	localIterator	Iterator
    //   152	68	9	localJSONObject3	JSONObject
    //   142	42	10	localJSONObject4	JSONObject
    // Exception table:
    //   from	to	target	type
    //   134	161	232	java/lang/Exception
    //   161	219	232	java/lang/Exception
    //   219	229	232	java/lang/Exception
    //   387	394	232	java/lang/Exception
    //   366	374	374	java/io/IOException
    //   101	127	397	org/json/JSONException
    //   134	161	397	org/json/JSONException
    //   161	219	397	org/json/JSONException
    //   219	229	397	org/json/JSONException
    //   233	244	397	org/json/JSONException
    //   387	394	397	org/json/JSONException
    //   473	477	478	java/io/IOException
    //   353	358	491	java/io/IOException
    //   415	424	491	java/io/IOException
    //   513	517	518	java/io/IOException
    //   353	358	531	finally
    //   415	424	531	finally
    //   538	542	544	java/io/IOException
    //   426	438	559	finally
    //   440	444	559	finally
    //   446	469	559	finally
    //   497	509	559	finally
    //   426	438	563	java/io/IOException
    //   440	444	563	java/io/IOException
    //   446	469	563	java/io/IOException
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
    registerLifeCycleCallBacks();
    initSharedPerfAndSetClearStatus();
    initSPBuglySDK();
    loadReportStrategy();
    saveConfigInfo();
    doGetSourceExperiments(null, 0);
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
  
  public boolean reportBeaconExpExpose(String paramString1, String paramString2)
  {
    try
    {
      boolean bool = BeaconReport.reportExpEvent("rqd_expimpression", paramString1, paramString2, getABTestConfig().getGuid(), ABTestUtil.getABTestSDKAppId(this.mContext, this.mConfig));
      ABTestLog.debug("beacon report status: " + bool, new Object[0]);
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
  
  void saveConfigInfo()
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
    int i = this.romaStrategy.getRefreshDuration();
    ABTestLog.debug("[SDKInit] refreshDuration:" + i, new Object[0]);
    HandlerThreadUtil.getHandler().sendEmptyMessage(0);
  }
  
  public void stopUpdateTimer()
  {
    ABTestLog.debug("stopUpdateTimer and removeCallBacks", new Object[0]);
    HandlerThreadUtil.getHandler().sendEmptyMessage(1);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mtt.abtestsdk.ABTest.ABTestManager
 * JD-Core Version:    0.7.0.1
 */