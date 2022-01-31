import android.os.Build.VERSION;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import com.tencent.biz.pubaccount.PublicAccountJavascriptInterface;
import com.tencent.biz.pubaccount.readinjoy.struct.ArticleInfo;
import com.tencent.biz.pubaccount.readinjoy.struct.SocializeFeedsInfo;
import com.tencent.biz.pubaccount.readinjoy.video.ReadInJoyWebDataManager.1;
import com.tencent.biz.pubaccount.readinjoy.video.ReadInJoyWebDataManager.2;
import com.tencent.biz.pubaccount.readinjoy.video.ReadInJoyWebDataManager.4;
import com.tencent.biz.pubaccount.readinjoy.video.ReadInJoyWebDataManager.5;
import com.tencent.biz.pubaccount.readinjoy.video.ReadInJoyWebDataManager.6;
import com.tencent.biz.pubaccount.readinjoy.viola.view.ViolaBaseView;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.data.CouponH5Data;
import com.tencent.mobileqq.msf.sdk.AppNetConnInfo;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.io.UnsupportedEncodingException;
import java.net.MalformedURLException;
import java.net.URL;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import mqq.app.AppRuntime;
import mqq.manager.TicketManager;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class qzi
{
  public static int a;
  private static long jdField_a_of_type_Long;
  public static String a;
  public static List<String> a;
  private static qzi jdField_a_of_type_Qzi;
  public static int b;
  public static String b;
  public static String c = "2";
  public static String d = "3";
  public static String e = "4";
  public static String f = "1";
  public static String g = "0";
  public static String h = "1";
  public static String i = "2";
  public static String j = "3";
  private static final String k = "QQ/8.3.5 Android/0.17 Android/" + Build.VERSION.RELEASE;
  private ViolaBaseView jdField_a_of_type_ComTencentBizPubaccountReadinjoyViolaViewViolaBaseView;
  private volatile HashMap<String, Long> jdField_a_of_type_JavaUtilHashMap = new HashMap();
  private long b;
  private String l = "";
  private String m = "";
  private String n = "";
  private String o = "";
  private String p = "";
  
  static
  {
    jdField_a_of_type_Int = 404;
    jdField_b_of_type_Int = 200;
    jdField_a_of_type_JavaLangString = "https://sqimg.qq.com/qq_product_operations/kan/viola_biz/viola_service/viola_service.js?v_bid=3685&_rij_violaUrl=1";
    jdField_a_of_type_JavaUtilList = new ArrayList();
    jdField_b_of_type_JavaLangString = "1";
  }
  
  public static String a(String paramString)
  {
    long l1 = 5381L;
    int i1 = 0;
    while (i1 < paramString.length())
    {
      l1 += (l1 << 5 & 0x7FFFFFFF) + paramString.charAt(i1);
      i1 += 1;
    }
    if (QLog.isColorLevel()) {
      QLog.w("ReadInJoyWebDataManager", 2, "getCSRFToken " + (l1 & 0x7FFFFFFF));
    }
    return String.valueOf(l1 & 0x7FFFFFFF);
  }
  
  private String a(String paramString1, String paramString2)
  {
    return bhsv.a(paramString1, paramString2);
  }
  
  private String a(String paramString1, String paramString2, String paramString3)
  {
    Object localObject = (QQAppInterface)ors.a();
    if (localObject == null) {
      return null;
    }
    localObject = ((QQAppInterface)localObject).getEntityManagerFactory(((QQAppInterface)localObject).getAccount()).createEntityManager();
    paramString1 = (CouponH5Data)((awgf)localObject).a(CouponH5Data.class, "mHost = ? AND mPath = ? AND mKey = ?", new String[] { paramString1, paramString2, paramString3 });
    ((awgf)localObject).a();
    if (paramString1 != null) {}
    for (paramString1 = paramString1.mData;; paramString1 = null) {
      return paramString1;
    }
  }
  
  public static qzi a()
  {
    if (jdField_a_of_type_Qzi == null) {
      jdField_a_of_type_Qzi = new qzi();
    }
    return jdField_a_of_type_Qzi;
  }
  
  public static void a()
  {
    for (;;)
    {
      JSONArray localJSONArray;
      synchronized (jdField_a_of_type_JavaUtilList)
      {
        Iterator localIterator = jdField_a_of_type_JavaUtilList.iterator();
        if (QLog.isColorLevel()) {
          QLog.w("ReadInJoyWebDataManager", 2, "addLog :TLogCache size :" + jdField_a_of_type_JavaUtilList.size());
        }
        if (jdField_a_of_type_JavaUtilList.size() <= 0) {
          return;
        }
        try
        {
          localJSONArray = new JSONArray();
          if (!localIterator.hasNext()) {
            break label145;
          }
          JSONObject localJSONObject = new JSONObject();
          localJSONObject.put("postTime", System.currentTimeMillis() / 1000L);
          localJSONObject.put("logContent", localIterator.next());
          localJSONArray.put(localJSONObject);
          continue;
          jdField_a_of_type_JavaUtilList.clear();
        }
        catch (JSONException localJSONException) {}
        return;
      }
      label145:
      a(localJSONArray.toString());
    }
  }
  
  public static void a(String paramString)
  {
    AppRuntime localAppRuntime = ors.a();
    if (localAppRuntime == null) {
      return;
    }
    ThreadManager.post(new ReadInJoyWebDataManager.6(localAppRuntime, paramString), 5, null, true);
  }
  
  private void a(String paramString1, String paramString2, String paramString3, String paramString4)
  {
    Object localObject = (QQAppInterface)ors.a();
    if (localObject == null) {
      return;
    }
    localObject = ((QQAppInterface)localObject).getEntityManagerFactory(((QQAppInterface)localObject).getAccount()).createEntityManager();
    CouponH5Data localCouponH5Data = (CouponH5Data)((awgf)localObject).a(CouponH5Data.class, "mHost = ? AND mPath = ? AND mKey = ?", new String[] { paramString1, paramString2, paramString3 });
    if (localCouponH5Data == null) {
      ((awgf)localObject).a(new CouponH5Data(paramString1, paramString2, paramString3, paramString4));
    }
    for (;;)
    {
      ((awgf)localObject).a();
      return;
      localCouponH5Data.mData = paramString4;
      ((awgf)localObject).a(localCouponH5Data);
    }
  }
  
  private void a(String paramString1, JSONObject paramJSONObject, String paramString2, qzn paramqzn)
  {
    ThreadManager.post(new ReadInJoyWebDataManager.5(this, paramString1, paramString2, paramqzn, paramJSONObject), 5, null, true);
  }
  
  /* Error */
  private void a(String paramString1, qzm paramqzm, JSONObject paramJSONObject, String paramString2)
  {
    // Byte code:
    //   0: invokestatic 166	ors:a	()Lmqq/app/AppRuntime;
    //   3: checkcast 168	com/tencent/mobileqq/app/QQAppInterface
    //   6: astore 6
    //   8: aload 6
    //   10: ifnonnull +4 -> 14
    //   13: return
    //   14: new 227	org/json/JSONObject
    //   17: dup
    //   18: aload_1
    //   19: invokespecial 293	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   22: astore 7
    //   24: aload 7
    //   26: ldc_w 295
    //   29: invokevirtual 298	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   32: astore 5
    //   34: aload 5
    //   36: astore_1
    //   37: aload 5
    //   39: invokestatic 304	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   42: ifne +24 -> 66
    //   45: aload 5
    //   47: ldc_w 306
    //   50: ldc_w 308
    //   53: invokevirtual 312	java/lang/String:replace	(Ljava/lang/CharSequence;Ljava/lang/CharSequence;)Ljava/lang/String;
    //   56: ldc_w 314
    //   59: ldc_w 316
    //   62: invokevirtual 312	java/lang/String:replace	(Ljava/lang/CharSequence;Ljava/lang/CharSequence;)Ljava/lang/String;
    //   65: astore_1
    //   66: aload_3
    //   67: ldc_w 295
    //   70: aload_1
    //   71: invokevirtual 250	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   74: pop
    //   75: aload 7
    //   77: ldc_w 318
    //   80: invokevirtual 298	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   83: astore 5
    //   85: aload 5
    //   87: invokestatic 304	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   90: ifeq +20 -> 110
    //   93: aload_2
    //   94: aload_3
    //   95: invokeinterface 323 2 0
    //   100: return
    //   101: astore_1
    //   102: aload_2
    //   103: aload_3
    //   104: invokeinterface 323 2 0
    //   109: return
    //   110: new 325	java/net/URL
    //   113: dup
    //   114: aload 4
    //   116: invokespecial 326	java/net/URL:<init>	(Ljava/lang/String;)V
    //   119: invokevirtual 329	java/net/URL:getHost	()Ljava/lang/String;
    //   122: astore_1
    //   123: aload 7
    //   125: ldc_w 331
    //   128: invokevirtual 298	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   131: astore 4
    //   133: aload 4
    //   135: invokestatic 304	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   138: ifne +462 -> 600
    //   141: aload_0
    //   142: aload 4
    //   144: aload_1
    //   145: invokespecial 334	qzi:a	(Ljava/lang/String;Ljava/lang/String;)Z
    //   148: ifeq +45 -> 193
    //   151: aload 4
    //   153: astore_1
    //   154: aload_1
    //   155: astore 4
    //   157: aload_1
    //   158: invokestatic 304	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   161: ifeq +8 -> 169
    //   164: ldc_w 336
    //   167: astore 4
    //   169: aload 7
    //   171: ldc_w 338
    //   174: invokevirtual 298	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   177: astore_1
    //   178: aload_1
    //   179: invokestatic 304	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   182: ifeq +19 -> 201
    //   185: aload_2
    //   186: aload_3
    //   187: invokeinterface 323 2 0
    //   192: return
    //   193: aload_2
    //   194: aload_3
    //   195: invokeinterface 323 2 0
    //   200: return
    //   201: aload_0
    //   202: aload 4
    //   204: aload 5
    //   206: aload_1
    //   207: invokespecial 340	qzi:a	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   210: astore 7
    //   212: aload 7
    //   214: invokestatic 304	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   217: ifeq +11 -> 228
    //   220: aload_2
    //   221: aload_3
    //   222: invokeinterface 323 2 0
    //   227: return
    //   228: new 342	java/io/File
    //   231: dup
    //   232: new 33	java/lang/StringBuilder
    //   235: dup
    //   236: invokespecial 36	java/lang/StringBuilder:<init>	()V
    //   239: getstatic 345	com/tencent/biz/pubaccount/PublicAccountJavascriptInterface:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   242: invokevirtual 42	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   245: ldc_w 347
    //   248: invokevirtual 42	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   251: aload 6
    //   253: invokevirtual 171	com/tencent/mobileqq/app/QQAppInterface:getAccount	()Ljava/lang/String;
    //   256: invokestatic 351	bdhe:b	(Ljava/lang/String;)Ljava/lang/String;
    //   259: invokevirtual 42	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   262: ldc_w 347
    //   265: invokevirtual 42	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   268: aload 4
    //   270: invokevirtual 42	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   273: ldc_w 347
    //   276: invokevirtual 42	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   279: aload 5
    //   281: invokestatic 351	bdhe:b	(Ljava/lang/String;)Ljava/lang/String;
    //   284: invokevirtual 42	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   287: ldc_w 347
    //   290: invokevirtual 42	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   293: aload_1
    //   294: invokestatic 351	bdhe:b	(Ljava/lang/String;)Ljava/lang/String;
    //   297: invokevirtual 42	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   300: invokevirtual 51	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   303: invokespecial 352	java/io/File:<init>	(Ljava/lang/String;)V
    //   306: astore 5
    //   308: aload 5
    //   310: invokevirtual 355	java/io/File:exists	()Z
    //   313: ifne +22 -> 335
    //   316: aload_3
    //   317: ldc_w 357
    //   320: ldc_w 359
    //   323: invokevirtual 250	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   326: pop
    //   327: aload_2
    //   328: aload_3
    //   329: invokeinterface 323 2 0
    //   334: return
    //   335: aload_0
    //   336: monitorenter
    //   337: new 361	java/io/FileInputStream
    //   340: dup
    //   341: aload 5
    //   343: invokespecial 364	java/io/FileInputStream:<init>	(Ljava/io/File;)V
    //   346: astore_1
    //   347: aload_1
    //   348: astore 4
    //   350: aload 5
    //   352: invokevirtual 366	java/io/File:length	()J
    //   355: l2i
    //   356: newarray byte
    //   358: astore 5
    //   360: aload_1
    //   361: astore 4
    //   363: aload_1
    //   364: aload 5
    //   366: invokevirtual 372	java/io/InputStream:read	([B)I
    //   369: pop
    //   370: aload_1
    //   371: astore 4
    //   373: aload_0
    //   374: new 124	java/lang/String
    //   377: dup
    //   378: aload 5
    //   380: invokespecial 375	java/lang/String:<init>	([B)V
    //   383: aload 7
    //   385: invokespecial 377	qzi:b	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   388: astore 5
    //   390: aload 5
    //   392: ifnonnull +47 -> 439
    //   395: aload_1
    //   396: astore 4
    //   398: aload_3
    //   399: ldc_w 357
    //   402: ldc_w 379
    //   405: invokevirtual 250	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   408: pop
    //   409: aload_1
    //   410: astore 4
    //   412: aload_2
    //   413: aload_3
    //   414: invokeinterface 323 2 0
    //   419: aload_1
    //   420: astore 4
    //   422: aload_0
    //   423: monitorexit
    //   424: aload_1
    //   425: ifnull +178 -> 603
    //   428: aload_1
    //   429: invokevirtual 382	java/io/InputStream:close	()V
    //   432: return
    //   433: astore_1
    //   434: aload_1
    //   435: invokevirtual 385	java/io/IOException:printStackTrace	()V
    //   438: return
    //   439: aload_1
    //   440: astore 4
    //   442: aload_3
    //   443: ldc_w 387
    //   446: aload 5
    //   448: ldc_w 306
    //   451: ldc_w 308
    //   454: invokevirtual 312	java/lang/String:replace	(Ljava/lang/CharSequence;Ljava/lang/CharSequence;)Ljava/lang/String;
    //   457: ldc_w 314
    //   460: ldc_w 316
    //   463: invokevirtual 312	java/lang/String:replace	(Ljava/lang/CharSequence;Ljava/lang/CharSequence;)Ljava/lang/String;
    //   466: invokevirtual 250	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   469: pop
    //   470: aload_1
    //   471: astore 4
    //   473: aload_2
    //   474: aload_3
    //   475: invokeinterface 323 2 0
    //   480: aload_1
    //   481: astore 4
    //   483: aload_0
    //   484: monitorexit
    //   485: aload_1
    //   486: ifnull +117 -> 603
    //   489: aload_1
    //   490: invokevirtual 382	java/io/InputStream:close	()V
    //   493: return
    //   494: astore_1
    //   495: aload_1
    //   496: invokevirtual 385	java/io/IOException:printStackTrace	()V
    //   499: return
    //   500: astore 5
    //   502: aconst_null
    //   503: astore_1
    //   504: aload_1
    //   505: astore 4
    //   507: aload_0
    //   508: monitorexit
    //   509: aload_1
    //   510: astore 4
    //   512: aload 5
    //   514: athrow
    //   515: astore 4
    //   517: aload_1
    //   518: astore 4
    //   520: aload_3
    //   521: ldc_w 357
    //   524: ldc_w 389
    //   527: invokevirtual 250	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   530: pop
    //   531: aload_1
    //   532: astore 4
    //   534: aload_2
    //   535: aload_3
    //   536: invokeinterface 323 2 0
    //   541: aload_1
    //   542: ifnull +61 -> 603
    //   545: aload_1
    //   546: invokevirtual 382	java/io/InputStream:close	()V
    //   549: return
    //   550: astore_1
    //   551: aload_1
    //   552: invokevirtual 385	java/io/IOException:printStackTrace	()V
    //   555: return
    //   556: astore_1
    //   557: aconst_null
    //   558: astore 4
    //   560: aload 4
    //   562: ifnull +8 -> 570
    //   565: aload 4
    //   567: invokevirtual 382	java/io/InputStream:close	()V
    //   570: aload_1
    //   571: athrow
    //   572: astore 4
    //   574: aload 4
    //   576: invokevirtual 385	java/io/IOException:printStackTrace	()V
    //   579: goto -9 -> 570
    //   582: astore_1
    //   583: goto -23 -> 560
    //   586: astore_1
    //   587: aconst_null
    //   588: astore_1
    //   589: goto -72 -> 517
    //   592: astore 5
    //   594: aload 4
    //   596: astore_1
    //   597: goto -93 -> 504
    //   600: goto -446 -> 154
    //   603: return
    //   604: astore_1
    //   605: aconst_null
    //   606: astore_1
    //   607: goto -484 -> 123
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	610	0	this	qzi
    //   0	610	1	paramString1	String
    //   0	610	2	paramqzm	qzm
    //   0	610	3	paramJSONObject	JSONObject
    //   0	610	4	paramString2	String
    //   32	415	5	localObject1	Object
    //   500	13	5	localObject2	Object
    //   592	1	5	localObject3	Object
    //   6	246	6	localQQAppInterface	QQAppInterface
    //   22	362	7	localObject4	Object
    // Exception table:
    //   from	to	target	type
    //   0	8	101	org/json/JSONException
    //   14	34	101	org/json/JSONException
    //   37	66	101	org/json/JSONException
    //   66	100	101	org/json/JSONException
    //   110	123	101	org/json/JSONException
    //   123	151	101	org/json/JSONException
    //   157	164	101	org/json/JSONException
    //   169	192	101	org/json/JSONException
    //   193	200	101	org/json/JSONException
    //   201	227	101	org/json/JSONException
    //   228	334	101	org/json/JSONException
    //   428	432	101	org/json/JSONException
    //   434	438	101	org/json/JSONException
    //   489	493	101	org/json/JSONException
    //   495	499	101	org/json/JSONException
    //   545	549	101	org/json/JSONException
    //   551	555	101	org/json/JSONException
    //   565	570	101	org/json/JSONException
    //   570	572	101	org/json/JSONException
    //   574	579	101	org/json/JSONException
    //   428	432	433	java/io/IOException
    //   489	493	494	java/io/IOException
    //   337	347	500	finally
    //   512	515	515	java/io/IOException
    //   545	549	550	java/io/IOException
    //   335	337	556	finally
    //   565	570	572	java/io/IOException
    //   512	515	582	finally
    //   520	531	582	finally
    //   534	541	582	finally
    //   335	337	586	java/io/IOException
    //   350	360	592	finally
    //   363	370	592	finally
    //   373	390	592	finally
    //   398	409	592	finally
    //   412	419	592	finally
    //   422	424	592	finally
    //   442	470	592	finally
    //   473	480	592	finally
    //   483	485	592	finally
    //   507	509	592	finally
    //   110	123	604	java/net/MalformedURLException
  }
  
  /* Error */
  private void a(URL paramURL, String paramString1, String paramString2, JSONObject paramJSONObject)
  {
    // Byte code:
    //   0: invokestatic 166	ors:a	()Lmqq/app/AppRuntime;
    //   3: checkcast 168	com/tencent/mobileqq/app/QQAppInterface
    //   6: astore 9
    //   8: aload 9
    //   10: ifnonnull +4 -> 14
    //   13: return
    //   14: new 227	org/json/JSONObject
    //   17: dup
    //   18: aload_2
    //   19: invokespecial 293	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   22: astore 10
    //   24: aload 10
    //   26: ldc_w 295
    //   29: invokevirtual 298	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   32: astore 8
    //   34: aload 8
    //   36: astore 7
    //   38: aload 8
    //   40: invokestatic 304	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   43: ifne +25 -> 68
    //   46: aload 8
    //   48: ldc_w 306
    //   51: ldc_w 308
    //   54: invokevirtual 312	java/lang/String:replace	(Ljava/lang/CharSequence;Ljava/lang/CharSequence;)Ljava/lang/String;
    //   57: ldc_w 314
    //   60: ldc_w 316
    //   63: invokevirtual 312	java/lang/String:replace	(Ljava/lang/CharSequence;Ljava/lang/CharSequence;)Ljava/lang/String;
    //   66: astore 7
    //   68: aload 4
    //   70: ldc_w 295
    //   73: aload 7
    //   75: invokevirtual 250	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   78: pop
    //   79: getstatic 119	qzi:jdField_a_of_type_Long	J
    //   82: ldc2_w 391
    //   85: lcmp
    //   86: ifle +20 -> 106
    //   89: new 394	com/tencent/biz/pubaccount/readinjoy/video/ReadInJoyWebDataManager$3
    //   92: dup
    //   93: aload_0
    //   94: aload_1
    //   95: aload_2
    //   96: aload_3
    //   97: aload 4
    //   99: invokespecial 397	com/tencent/biz/pubaccount/readinjoy/video/ReadInJoyWebDataManager$3:<init>	(Lqzi;Ljava/net/URL;Ljava/lang/String;Ljava/lang/String;Lorg/json/JSONObject;)V
    //   102: invokestatic 401	com/tencent/mobileqq/app/ThreadManager:executeOnNetWorkThread	(Ljava/lang/Runnable;)V
    //   105: return
    //   106: aload 10
    //   108: ldc_w 318
    //   111: invokevirtual 298	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   114: astore_3
    //   115: aload_3
    //   116: invokestatic 304	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   119: ifne +423 -> 542
    //   122: aload 10
    //   124: ldc_w 338
    //   127: invokevirtual 298	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   130: astore 4
    //   132: aload 4
    //   134: invokestatic 304	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   137: ifne +405 -> 542
    //   140: aload 10
    //   142: ldc_w 387
    //   145: invokevirtual 298	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   148: astore 7
    //   150: aload 7
    //   152: invokestatic 304	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   155: ifne +387 -> 542
    //   158: aload_1
    //   159: invokevirtual 329	java/net/URL:getHost	()Ljava/lang/String;
    //   162: astore_1
    //   163: aload 10
    //   165: ldc_w 331
    //   168: invokevirtual 298	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   171: astore_2
    //   172: aload_2
    //   173: invokestatic 304	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   176: ifne +363 -> 539
    //   179: aload_0
    //   180: aload_2
    //   181: aload_1
    //   182: invokespecial 334	qzi:a	(Ljava/lang/String;Ljava/lang/String;)Z
    //   185: ifeq +357 -> 542
    //   188: aload_2
    //   189: astore_1
    //   190: aload_1
    //   191: astore_2
    //   192: aload_1
    //   193: invokestatic 304	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   196: ifeq +7 -> 203
    //   199: ldc_w 336
    //   202: astore_2
    //   203: aload_0
    //   204: aload 7
    //   206: invokespecial 402	qzi:b	(Ljava/lang/String;)Ljava/lang/String;
    //   209: astore_1
    //   210: aload_0
    //   211: aload_2
    //   212: aload_3
    //   213: aload 4
    //   215: aload_1
    //   216: invokespecial 404	qzi:a	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V
    //   219: aload_0
    //   220: aload 7
    //   222: aload_1
    //   223: invokespecial 405	qzi:a	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   226: astore 7
    //   228: new 342	java/io/File
    //   231: dup
    //   232: new 33	java/lang/StringBuilder
    //   235: dup
    //   236: invokespecial 36	java/lang/StringBuilder:<init>	()V
    //   239: getstatic 345	com/tencent/biz/pubaccount/PublicAccountJavascriptInterface:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   242: invokevirtual 42	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   245: ldc_w 347
    //   248: invokevirtual 42	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   251: aload 9
    //   253: invokevirtual 171	com/tencent/mobileqq/app/QQAppInterface:getAccount	()Ljava/lang/String;
    //   256: invokestatic 351	bdhe:b	(Ljava/lang/String;)Ljava/lang/String;
    //   259: invokevirtual 42	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   262: invokevirtual 51	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   265: invokespecial 352	java/io/File:<init>	(Ljava/lang/String;)V
    //   268: astore_1
    //   269: aload_1
    //   270: invokevirtual 355	java/io/File:exists	()Z
    //   273: ifne +153 -> 426
    //   276: aload_1
    //   277: invokevirtual 408	java/io/File:mkdirs	()Z
    //   280: pop
    //   281: new 342	java/io/File
    //   284: dup
    //   285: aload_1
    //   286: aload_2
    //   287: invokespecial 411	java/io/File:<init>	(Ljava/io/File;Ljava/lang/String;)V
    //   290: astore_1
    //   291: aload_1
    //   292: invokevirtual 355	java/io/File:exists	()Z
    //   295: ifne +151 -> 446
    //   298: aload_1
    //   299: invokevirtual 408	java/io/File:mkdirs	()Z
    //   302: pop
    //   303: new 342	java/io/File
    //   306: dup
    //   307: aload_1
    //   308: aload_3
    //   309: invokestatic 351	bdhe:b	(Ljava/lang/String;)Ljava/lang/String;
    //   312: invokespecial 411	java/io/File:<init>	(Ljava/io/File;Ljava/lang/String;)V
    //   315: astore 8
    //   317: aload 8
    //   319: invokevirtual 355	java/io/File:exists	()Z
    //   322: ifne +144 -> 466
    //   325: aload 8
    //   327: invokevirtual 408	java/io/File:mkdirs	()Z
    //   330: pop
    //   331: aconst_null
    //   332: astore_2
    //   333: aconst_null
    //   334: astore_1
    //   335: aconst_null
    //   336: astore_3
    //   337: aload_0
    //   338: monitorenter
    //   339: aload_3
    //   340: astore_2
    //   341: new 342	java/io/File
    //   344: dup
    //   345: aload 8
    //   347: aload 4
    //   349: invokestatic 351	bdhe:b	(Ljava/lang/String;)Ljava/lang/String;
    //   352: invokespecial 411	java/io/File:<init>	(Ljava/io/File;Ljava/lang/String;)V
    //   355: astore 4
    //   357: aload_3
    //   358: astore_2
    //   359: aload 4
    //   361: invokevirtual 355	java/io/File:exists	()Z
    //   364: ifeq +11 -> 375
    //   367: aload_3
    //   368: astore_2
    //   369: aload 4
    //   371: invokevirtual 414	java/io/File:delete	()Z
    //   374: pop
    //   375: aload_3
    //   376: astore_2
    //   377: new 416	java/io/FileWriter
    //   380: dup
    //   381: aload 4
    //   383: invokespecial 417	java/io/FileWriter:<init>	(Ljava/io/File;)V
    //   386: astore_1
    //   387: aload_1
    //   388: aload 7
    //   390: invokevirtual 420	java/io/FileWriter:write	(Ljava/lang/String;)V
    //   393: getstatic 119	qzi:jdField_a_of_type_Long	J
    //   396: lstore 5
    //   398: aload 4
    //   400: invokevirtual 366	java/io/File:length	()J
    //   403: lload 5
    //   405: ladd
    //   406: putstatic 119	qzi:jdField_a_of_type_Long	J
    //   409: aload_0
    //   410: monitorexit
    //   411: aload_1
    //   412: ifnull +130 -> 542
    //   415: aload_1
    //   416: invokevirtual 421	java/io/FileWriter:close	()V
    //   419: return
    //   420: astore_1
    //   421: aload_1
    //   422: invokevirtual 385	java/io/IOException:printStackTrace	()V
    //   425: return
    //   426: aload_1
    //   427: invokevirtual 424	java/io/File:isFile	()Z
    //   430: ifeq -149 -> 281
    //   433: aload_1
    //   434: invokevirtual 414	java/io/File:delete	()Z
    //   437: pop
    //   438: aload_1
    //   439: invokevirtual 408	java/io/File:mkdirs	()Z
    //   442: pop
    //   443: goto -162 -> 281
    //   446: aload_1
    //   447: invokevirtual 424	java/io/File:isFile	()Z
    //   450: ifeq -147 -> 303
    //   453: aload_1
    //   454: invokevirtual 414	java/io/File:delete	()Z
    //   457: pop
    //   458: aload_1
    //   459: invokevirtual 408	java/io/File:mkdirs	()Z
    //   462: pop
    //   463: goto -160 -> 303
    //   466: aload 8
    //   468: invokevirtual 424	java/io/File:isFile	()Z
    //   471: ifeq -140 -> 331
    //   474: aload 8
    //   476: invokevirtual 414	java/io/File:delete	()Z
    //   479: pop
    //   480: aload 8
    //   482: invokevirtual 408	java/io/File:mkdirs	()Z
    //   485: pop
    //   486: goto -155 -> 331
    //   489: astore_3
    //   490: aload_2
    //   491: astore_1
    //   492: aload_1
    //   493: astore_2
    //   494: aload_0
    //   495: monitorexit
    //   496: aload_1
    //   497: astore_2
    //   498: aload_3
    //   499: athrow
    //   500: astore_1
    //   501: aload_2
    //   502: ifnull +40 -> 542
    //   505: aload_2
    //   506: invokevirtual 421	java/io/FileWriter:close	()V
    //   509: return
    //   510: astore_1
    //   511: aload_1
    //   512: invokevirtual 385	java/io/IOException:printStackTrace	()V
    //   515: return
    //   516: astore_2
    //   517: aload_1
    //   518: ifnull +7 -> 525
    //   521: aload_1
    //   522: invokevirtual 421	java/io/FileWriter:close	()V
    //   525: aload_2
    //   526: athrow
    //   527: astore_1
    //   528: aload_1
    //   529: invokevirtual 385	java/io/IOException:printStackTrace	()V
    //   532: goto -7 -> 525
    //   535: astore_3
    //   536: goto -44 -> 492
    //   539: goto -349 -> 190
    //   542: return
    //   543: astore_1
    //   544: return
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	545	0	this	qzi
    //   0	545	1	paramURL	URL
    //   0	545	2	paramString1	String
    //   0	545	3	paramString2	String
    //   0	545	4	paramJSONObject	JSONObject
    //   396	8	5	l1	long
    //   36	353	7	localObject1	Object
    //   32	449	8	localObject2	Object
    //   6	246	9	localQQAppInterface	QQAppInterface
    //   22	142	10	localJSONObject	JSONObject
    // Exception table:
    //   from	to	target	type
    //   415	419	420	java/io/IOException
    //   341	357	489	finally
    //   359	367	489	finally
    //   369	375	489	finally
    //   377	387	489	finally
    //   494	496	489	finally
    //   337	339	500	java/io/IOException
    //   498	500	500	java/io/IOException
    //   505	509	510	java/io/IOException
    //   337	339	516	finally
    //   498	500	516	finally
    //   521	525	527	java/io/IOException
    //   387	411	535	finally
    //   0	8	543	org/json/JSONException
    //   14	34	543	org/json/JSONException
    //   38	68	543	org/json/JSONException
    //   68	105	543	org/json/JSONException
    //   106	188	543	org/json/JSONException
    //   192	199	543	org/json/JSONException
    //   203	281	543	org/json/JSONException
    //   281	303	543	org/json/JSONException
    //   303	331	543	org/json/JSONException
    //   415	419	543	org/json/JSONException
    //   421	425	543	org/json/JSONException
    //   426	443	543	org/json/JSONException
    //   446	463	543	org/json/JSONException
    //   466	486	543	org/json/JSONException
    //   505	509	543	org/json/JSONException
    //   511	515	543	org/json/JSONException
    //   521	525	543	org/json/JSONException
    //   525	527	543	org/json/JSONException
    //   528	532	543	org/json/JSONException
  }
  
  public static boolean a(ArticleInfo paramArticleInfo)
  {
    if (paramArticleInfo == null) {}
    do
    {
      return false;
      if ((rqj.f(paramArticleInfo)) && (paramArticleInfo.mSocialFeedInfo.jdField_a_of_type_Qmc != null))
      {
        switch ((int)paramArticleInfo.mSocialFeedInfo.jdField_a_of_type_Qmc.jdField_b_of_type_JavaLangLong.longValue())
        {
        case 11: 
        default: 
          return false;
        }
        return true;
      }
    } while ((!rqj.a(paramArticleInfo)) && (!rqj.h(paramArticleInfo)));
    return true;
  }
  
  private boolean a(String paramString1, String paramString2)
  {
    if (paramString2 == null) {}
    while ((!paramString2.equals(paramString1)) && ((paramString1.indexOf(".") <= 0) || (!paramString2.endsWith("." + paramString1)))) {
      return false;
    }
    return true;
  }
  
  private String b(String paramString)
  {
    try
    {
      MessageDigest localMessageDigest = MessageDigest.getInstance("MD5");
      localMessageDigest.update(paramString.getBytes("UTF-8"));
      paramString = bdhe.a(localMessageDigest.digest());
      localMessageDigest.reset();
      return paramString;
    }
    catch (UnsupportedEncodingException paramString)
    {
      return "wronghash";
    }
    catch (NoSuchAlgorithmException paramString)
    {
      label33:
      break label33;
    }
  }
  
  private String b(String paramString1, String paramString2)
  {
    return bhsv.b(paramString1, paramString2);
  }
  
  private void b(String paramString1, String paramString2)
  {
    if ((!TextUtils.isEmpty(paramString1)) && (!TextUtils.isEmpty(paramString2)) && (c.equals(paramString1)))
    {
      paramString1 = b(paramString2);
      if (!paramString1.equals(this.o))
      {
        this.o = paramString1;
        this.p = paramString2;
      }
    }
  }
  
  private void b(String paramString1, String paramString2, String paramString3, JSONObject paramJSONObject)
  {
    try
    {
      ThreadManager.post(new ReadInJoyWebDataManager.2(this, new URL(paramString1), paramString2, paramString3, paramJSONObject), 5, null, false);
      return;
    }
    catch (MalformedURLException paramString1) {}
  }
  
  public static boolean b()
  {
    QQAppInterface localQQAppInterface = (QQAppInterface)ors.a();
    if (localQQAppInterface == null) {
      return false;
    }
    if (localQQAppInterface.getApp() == null) {
      return false;
    }
    return (AppNetConnInfo.isWifiConn()) || ((AppNetConnInfo.isMobileConn()) && (AppNetConnInfo.getMobileInfo() == 3));
  }
  
  private static long c()
  {
    Object localObject = new File(PublicAccountJavascriptInterface.jdField_a_of_type_JavaLangString);
    if (!((File)localObject).exists()) {
      return 0L;
    }
    ArrayList localArrayList = new ArrayList();
    localArrayList.add(localObject);
    long l1 = 0L;
    while (!localArrayList.isEmpty())
    {
      localObject = (File)localArrayList.remove(0);
      if (((File)localObject).isFile())
      {
        l1 = ((File)localObject).length() + l1;
      }
      else
      {
        localObject = ((File)localObject).listFiles();
        if (localObject != null)
        {
          int i2 = localObject.length;
          int i1 = 0;
          while (i1 < i2)
          {
            localArrayList.add(localObject[i1]);
            i1 += 1;
          }
        }
      }
    }
    return l1;
  }
  
  private String d()
  {
    Object localObject = (QQAppInterface)ors.a();
    if (localObject == null) {
      return "";
    }
    TicketManager localTicketManager = (TicketManager)((QQAppInterface)localObject).getManager(2);
    if (localTicketManager == null) {
      return "";
    }
    localObject = localTicketManager.getSkey(((QQAppInterface)localObject).getCurrentAccountUin());
    long l1 = 5381L;
    if (TextUtils.isEmpty((CharSequence)localObject)) {
      return "";
    }
    int i1 = 0;
    while (i1 < ((String)localObject).length())
    {
      l1 += (l1 << 5 & 0x7FFFFFFF) + ((String)localObject).charAt(i1);
      i1 += 1;
    }
    if (QLog.isColorLevel()) {
      QLog.w("ReadInJoyWebDataManager", 2, "getCSRFToken " + (l1 & 0x7FFFFFFF));
    }
    return String.valueOf(l1 & 0x7FFFFFFF);
  }
  
  public String a()
  {
    return this.l;
  }
  
  /* Error */
  public void a(ArticleInfo paramArticleInfo, boolean paramBoolean, String paramString)
  {
    // Byte code:
    //   0: iconst_0
    //   1: istore 6
    //   3: iconst_1
    //   4: istore 5
    //   6: aload_1
    //   7: ifnull +10 -> 17
    //   10: aload_1
    //   11: invokestatic 562	qzi:a	(Lcom/tencent/biz/pubaccount/readinjoy/struct/ArticleInfo;)Z
    //   14: ifne +10 -> 24
    //   17: aload_0
    //   18: ldc 103
    //   20: putfield 109	qzi:n	Ljava/lang/String;
    //   23: return
    //   24: new 227	org/json/JSONObject
    //   27: dup
    //   28: invokespecial 228	org/json/JSONObject:<init>	()V
    //   31: astore 8
    //   33: aload_1
    //   34: getfield 565	com/tencent/biz/pubaccount/readinjoy/struct/ArticleInfo:mFeedType	I
    //   37: istore 4
    //   39: aload_1
    //   40: invokestatic 442	rqj:f	(Lcom/tencent/biz/pubaccount/readinjoy/struct/ArticleInfo;)Z
    //   43: invokestatic 570	java/lang/Boolean:valueOf	(Z)Ljava/lang/Boolean;
    //   46: astore 9
    //   48: aload_1
    //   49: invokestatic 465	rqj:a	(Lcom/tencent/biz/pubaccount/readinjoy/struct/ArticleInfo;)Z
    //   52: ifne +1519 -> 1571
    //   55: aload_1
    //   56: invokestatic 467	rqj:h	(Lcom/tencent/biz/pubaccount/readinjoy/struct/ArticleInfo;)Z
    //   59: ifeq +815 -> 874
    //   62: goto +1509 -> 1571
    //   65: iload 7
    //   67: invokestatic 570	java/lang/Boolean:valueOf	(Z)Ljava/lang/Boolean;
    //   70: astore 10
    //   72: aload 10
    //   74: invokevirtual 573	java/lang/Boolean:booleanValue	()Z
    //   77: ifne +17 -> 94
    //   80: aload 9
    //   82: invokevirtual 573	java/lang/Boolean:booleanValue	()Z
    //   85: ifne +9 -> 94
    //   88: aload_0
    //   89: ldc 103
    //   91: putfield 109	qzi:n	Ljava/lang/String;
    //   94: aload_3
    //   95: invokestatic 579	android/net/Uri:parse	(Ljava/lang/String;)Landroid/net/Uri;
    //   98: ldc_w 581
    //   101: invokevirtual 584	android/net/Uri:getQueryParameter	(Ljava/lang/String;)Ljava/lang/String;
    //   104: astore_3
    //   105: aload_3
    //   106: invokestatic 304	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   109: istore 7
    //   111: iload 7
    //   113: ifne +52 -> 165
    //   116: new 124	java/lang/String
    //   119: dup
    //   120: aload_3
    //   121: iconst_0
    //   122: invokestatic 590	bdfr:decode	(Ljava/lang/String;I)[B
    //   125: invokespecial 375	java/lang/String:<init>	([B)V
    //   128: astore_3
    //   129: aload_3
    //   130: invokestatic 304	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   133: ifne +32 -> 165
    //   136: aload 8
    //   138: ldc_w 592
    //   141: new 33	java/lang/StringBuilder
    //   144: dup
    //   145: invokespecial 36	java/lang/StringBuilder:<init>	()V
    //   148: ldc_w 594
    //   151: invokevirtual 42	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   154: aload_3
    //   155: invokevirtual 42	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   158: invokevirtual 51	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   161: invokevirtual 250	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   164: pop
    //   165: iload_2
    //   166: ifeq +714 -> 880
    //   169: aload_1
    //   170: getfield 448	com/tencent/biz/pubaccount/readinjoy/struct/ArticleInfo:mSocialFeedInfo	Lcom/tencent/biz/pubaccount/readinjoy/struct/SocializeFeedsInfo;
    //   173: ifnull +707 -> 880
    //   176: aload_1
    //   177: getfield 448	com/tencent/biz/pubaccount/readinjoy/struct/ArticleInfo:mSocialFeedInfo	Lcom/tencent/biz/pubaccount/readinjoy/struct/SocializeFeedsInfo;
    //   180: getfield 453	com/tencent/biz/pubaccount/readinjoy/struct/SocializeFeedsInfo:jdField_a_of_type_Qmc	Lqmc;
    //   183: ifnull +697 -> 880
    //   186: aload 8
    //   188: ldc_w 596
    //   191: aload_1
    //   192: getfield 448	com/tencent/biz/pubaccount/readinjoy/struct/ArticleInfo:mSocialFeedInfo	Lcom/tencent/biz/pubaccount/readinjoy/struct/SocializeFeedsInfo;
    //   195: getfield 453	com/tencent/biz/pubaccount/readinjoy/struct/SocializeFeedsInfo:jdField_a_of_type_Qmc	Lqmc;
    //   198: getfield 598	qmc:jdField_a_of_type_JavaLangLong	Ljava/lang/Long;
    //   201: invokestatic 601	java/lang/String:valueOf	(Ljava/lang/Object;)Ljava/lang/String;
    //   204: invokevirtual 250	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   207: pop
    //   208: aload 8
    //   210: ldc_w 603
    //   213: aload_1
    //   214: getfield 448	com/tencent/biz/pubaccount/readinjoy/struct/ArticleInfo:mSocialFeedInfo	Lcom/tencent/biz/pubaccount/readinjoy/struct/SocializeFeedsInfo;
    //   217: getfield 453	com/tencent/biz/pubaccount/readinjoy/struct/SocializeFeedsInfo:jdField_a_of_type_Qmc	Lqmc;
    //   220: getfield 458	qmc:jdField_b_of_type_JavaLangLong	Ljava/lang/Long;
    //   223: invokevirtual 250	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   226: pop
    //   227: aload 8
    //   229: ldc_w 605
    //   232: aload_1
    //   233: getfield 608	com/tencent/biz/pubaccount/readinjoy/struct/ArticleInfo:mSubscribeID	Ljava/lang/String;
    //   236: invokevirtual 250	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   239: pop
    //   240: aload 8
    //   242: ldc_w 610
    //   245: aload_1
    //   246: getfield 613	com/tencent/biz/pubaccount/readinjoy/struct/ArticleInfo:mSubscribeName	Ljava/lang/String;
    //   249: invokevirtual 250	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   252: pop
    //   253: aload 8
    //   255: ldc_w 615
    //   258: aload_1
    //   259: getfield 608	com/tencent/biz/pubaccount/readinjoy/struct/ArticleInfo:mSubscribeID	Ljava/lang/String;
    //   262: invokestatic 304	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   265: invokevirtual 618	org/json/JSONObject:put	(Ljava/lang/String;Z)Lorg/json/JSONObject;
    //   268: pop
    //   269: aload 8
    //   271: ldc_w 620
    //   274: ldc 103
    //   276: invokevirtual 250	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   279: pop
    //   280: aload 8
    //   282: ldc_w 622
    //   285: aload_1
    //   286: getfield 625	com/tencent/biz/pubaccount/readinjoy/struct/ArticleInfo:mArticleID	J
    //   289: invokevirtual 241	org/json/JSONObject:put	(Ljava/lang/String;J)Lorg/json/JSONObject;
    //   292: pop
    //   293: aload 8
    //   295: ldc_w 627
    //   298: aload_1
    //   299: getfield 630	com/tencent/biz/pubaccount/readinjoy/struct/ArticleInfo:mArticleContentUrl	Ljava/lang/String;
    //   302: invokevirtual 250	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   305: pop
    //   306: aload 8
    //   308: ldc_w 632
    //   311: aload_1
    //   312: getfield 635	com/tencent/biz/pubaccount/readinjoy/struct/ArticleInfo:mSummary	Ljava/lang/String;
    //   315: invokevirtual 250	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   318: pop
    //   319: aload 8
    //   321: ldc_w 637
    //   324: aload_1
    //   325: getfield 640	com/tencent/biz/pubaccount/readinjoy/struct/ArticleInfo:mTitle	Ljava/lang/String;
    //   328: invokevirtual 250	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   331: pop
    //   332: aload 8
    //   334: ldc_w 642
    //   337: aload_1
    //   338: getfield 645	com/tencent/biz/pubaccount/readinjoy/struct/ArticleInfo:mTime	J
    //   341: invokestatic 649	orr:a	(J)Ljava/lang/String;
    //   344: invokevirtual 250	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   347: pop
    //   348: aload_1
    //   349: getfield 653	com/tencent/biz/pubaccount/readinjoy/struct/ArticleInfo:mSinglePicture	Ljava/net/URL;
    //   352: ifnull +558 -> 910
    //   355: aload_1
    //   356: getfield 653	com/tencent/biz/pubaccount/readinjoy/struct/ArticleInfo:mSinglePicture	Ljava/net/URL;
    //   359: invokevirtual 656	java/net/URL:getFile	()Ljava/lang/String;
    //   362: astore_3
    //   363: aload 8
    //   365: ldc_w 658
    //   368: aload_3
    //   369: invokevirtual 250	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   372: pop
    //   373: aload_1
    //   374: getfield 662	com/tencent/biz/pubaccount/readinjoy/struct/ArticleInfo:mShowBigPicture	Z
    //   377: ifeq +1200 -> 1577
    //   380: iconst_2
    //   381: istore 4
    //   383: aload 8
    //   385: ldc_w 664
    //   388: iload 4
    //   390: invokevirtual 667	org/json/JSONObject:put	(Ljava/lang/String;I)Lorg/json/JSONObject;
    //   393: pop
    //   394: aload_1
    //   395: ifnull +59 -> 454
    //   398: aload_1
    //   399: invokestatic 670	ors:a	(Lcom/tencent/biz/pubaccount/readinjoy/struct/BaseArticleInfo;)Z
    //   402: ifeq +52 -> 454
    //   405: aload 8
    //   407: ldc_w 672
    //   410: iconst_1
    //   411: invokevirtual 667	org/json/JSONObject:put	(Ljava/lang/String;I)Lorg/json/JSONObject;
    //   414: pop
    //   415: aload_1
    //   416: getfield 675	com/tencent/biz/pubaccount/readinjoy/struct/ArticleInfo:mVideoCoverUrl	Ljava/net/URL;
    //   419: ifnull +19 -> 438
    //   422: aload 8
    //   424: ldc_w 658
    //   427: aload_1
    //   428: getfield 675	com/tencent/biz/pubaccount/readinjoy/struct/ArticleInfo:mVideoCoverUrl	Ljava/net/URL;
    //   431: invokevirtual 676	java/net/URL:toString	()Ljava/lang/String;
    //   434: invokevirtual 250	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   437: pop
    //   438: aload 8
    //   440: ldc_w 678
    //   443: aload_1
    //   444: getfield 681	com/tencent/biz/pubaccount/readinjoy/struct/ArticleInfo:mVideoDuration	I
    //   447: invokestatic 686	qfg:a	(I)Ljava/lang/String;
    //   450: invokevirtual 250	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   453: pop
    //   454: iload_2
    //   455: ifne +625 -> 1080
    //   458: aload 9
    //   460: invokevirtual 573	java/lang/Boolean:booleanValue	()Z
    //   463: ifeq +617 -> 1080
    //   466: aload_1
    //   467: getfield 448	com/tencent/biz/pubaccount/readinjoy/struct/ArticleInfo:mSocialFeedInfo	Lcom/tencent/biz/pubaccount/readinjoy/struct/SocializeFeedsInfo;
    //   470: ifnull +610 -> 1080
    //   473: aload_1
    //   474: getfield 448	com/tencent/biz/pubaccount/readinjoy/struct/ArticleInfo:mSocialFeedInfo	Lcom/tencent/biz/pubaccount/readinjoy/struct/SocializeFeedsInfo;
    //   477: getfield 689	com/tencent/biz/pubaccount/readinjoy/struct/SocializeFeedsInfo:jdField_a_of_type_Qme	Lqme;
    //   480: ifnull +43 -> 523
    //   483: aload 10
    //   485: invokevirtual 573	java/lang/Boolean:booleanValue	()Z
    //   488: ifeq +430 -> 918
    //   491: iload 6
    //   493: istore 4
    //   495: aload_1
    //   496: getfield 448	com/tencent/biz/pubaccount/readinjoy/struct/ArticleInfo:mSocialFeedInfo	Lcom/tencent/biz/pubaccount/readinjoy/struct/SocializeFeedsInfo;
    //   499: getfield 689	com/tencent/biz/pubaccount/readinjoy/struct/SocializeFeedsInfo:jdField_a_of_type_Qme	Lqme;
    //   502: getfield 692	qme:jdField_a_of_type_Int	I
    //   505: iconst_1
    //   506: if_icmpne +6 -> 512
    //   509: iconst_1
    //   510: istore 4
    //   512: aload 8
    //   514: ldc_w 620
    //   517: iload 4
    //   519: invokevirtual 667	org/json/JSONObject:put	(Ljava/lang/String;I)Lorg/json/JSONObject;
    //   522: pop
    //   523: aload 9
    //   525: invokevirtual 573	java/lang/Boolean:booleanValue	()Z
    //   528: ifeq +552 -> 1080
    //   531: aload_1
    //   532: getfield 448	com/tencent/biz/pubaccount/readinjoy/struct/ArticleInfo:mSocialFeedInfo	Lcom/tencent/biz/pubaccount/readinjoy/struct/SocializeFeedsInfo;
    //   535: getfield 453	com/tencent/biz/pubaccount/readinjoy/struct/SocializeFeedsInfo:jdField_a_of_type_Qmc	Lqmc;
    //   538: ifnull +542 -> 1080
    //   541: aload 8
    //   543: ldc_w 694
    //   546: aload_1
    //   547: getfield 448	com/tencent/biz/pubaccount/readinjoy/struct/ArticleInfo:mSocialFeedInfo	Lcom/tencent/biz/pubaccount/readinjoy/struct/SocializeFeedsInfo;
    //   550: getfield 453	com/tencent/biz/pubaccount/readinjoy/struct/SocializeFeedsInfo:jdField_a_of_type_Qmc	Lqmc;
    //   553: getfield 598	qmc:jdField_a_of_type_JavaLangLong	Ljava/lang/Long;
    //   556: invokestatic 601	java/lang/String:valueOf	(Ljava/lang/Object;)Ljava/lang/String;
    //   559: invokevirtual 250	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   562: pop
    //   563: aload 8
    //   565: ldc_w 696
    //   568: aload_1
    //   569: getfield 448	com/tencent/biz/pubaccount/readinjoy/struct/ArticleInfo:mSocialFeedInfo	Lcom/tencent/biz/pubaccount/readinjoy/struct/SocializeFeedsInfo;
    //   572: getfield 453	com/tencent/biz/pubaccount/readinjoy/struct/SocializeFeedsInfo:jdField_a_of_type_Qmc	Lqmc;
    //   575: getfield 458	qmc:jdField_b_of_type_JavaLangLong	Ljava/lang/Long;
    //   578: invokevirtual 250	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   581: pop
    //   582: new 219	org/json/JSONArray
    //   585: dup
    //   586: invokespecial 220	org/json/JSONArray:<init>	()V
    //   589: astore_3
    //   590: aload_1
    //   591: getfield 448	com/tencent/biz/pubaccount/readinjoy/struct/ArticleInfo:mSocialFeedInfo	Lcom/tencent/biz/pubaccount/readinjoy/struct/SocializeFeedsInfo;
    //   594: getfield 453	com/tencent/biz/pubaccount/readinjoy/struct/SocializeFeedsInfo:jdField_a_of_type_Qmc	Lqmc;
    //   597: getfield 697	qmc:jdField_a_of_type_JavaUtilList	Ljava/util/List;
    //   600: invokeinterface 209 1 0
    //   605: astore 9
    //   607: aload 9
    //   609: invokeinterface 225 1 0
    //   614: ifeq +456 -> 1070
    //   617: aload 9
    //   619: invokeinterface 247 1 0
    //   624: checkcast 699	com/tencent/biz/pubaccount/readinjoy/struct/SocializeFeedsInfo$BiuCommentInfo
    //   627: astore 10
    //   629: new 227	org/json/JSONObject
    //   632: dup
    //   633: invokespecial 228	org/json/JSONObject:<init>	()V
    //   636: astore 11
    //   638: aload 11
    //   640: ldc_w 701
    //   643: aload 10
    //   645: getfield 702	com/tencent/biz/pubaccount/readinjoy/struct/SocializeFeedsInfo$BiuCommentInfo:jdField_b_of_type_JavaLangLong	Ljava/lang/Long;
    //   648: invokestatic 601	java/lang/String:valueOf	(Ljava/lang/Object;)Ljava/lang/String;
    //   651: invokevirtual 250	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   654: pop
    //   655: aload 11
    //   657: ldc_w 704
    //   660: aload 10
    //   662: getfield 705	com/tencent/biz/pubaccount/readinjoy/struct/SocializeFeedsInfo$BiuCommentInfo:jdField_b_of_type_Int	I
    //   665: invokevirtual 667	org/json/JSONObject:put	(Ljava/lang/String;I)Lorg/json/JSONObject;
    //   668: pop
    //   669: aload 11
    //   671: ldc_w 707
    //   674: new 124	java/lang/String
    //   677: dup
    //   678: aload 10
    //   680: getfield 708	com/tencent/biz/pubaccount/readinjoy/struct/SocializeFeedsInfo$BiuCommentInfo:jdField_a_of_type_JavaLangLong	Ljava/lang/Long;
    //   683: invokevirtual 463	java/lang/Long:longValue	()J
    //   686: invokestatic 710	java/lang/Long:toString	(J)Ljava/lang/String;
    //   689: invokevirtual 712	java/lang/String:getBytes	()[B
    //   692: iconst_0
    //   693: invokestatic 716	bdfr:encode	([BI)[B
    //   696: invokespecial 375	java/lang/String:<init>	([B)V
    //   699: invokevirtual 250	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   702: pop
    //   703: aload 11
    //   705: ldc_w 718
    //   708: ldc 103
    //   710: invokevirtual 250	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   713: pop
    //   714: aload 11
    //   716: ldc_w 720
    //   719: ldc 103
    //   721: invokevirtual 250	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   724: pop
    //   725: invokestatic 166	ors:a	()Lmqq/app/AppRuntime;
    //   728: checkcast 168	com/tencent/mobileqq/app/QQAppInterface
    //   731: ifnull +48 -> 779
    //   734: invokestatic 166	ors:a	()Lmqq/app/AppRuntime;
    //   737: checkcast 168	com/tencent/mobileqq/app/QQAppInterface
    //   740: aload 10
    //   742: getfield 708	com/tencent/biz/pubaccount/readinjoy/struct/SocializeFeedsInfo$BiuCommentInfo:jdField_a_of_type_JavaLangLong	Ljava/lang/Long;
    //   745: invokevirtual 463	java/lang/Long:longValue	()J
    //   748: invokestatic 710	java/lang/Long:toString	(J)Ljava/lang/String;
    //   751: iconst_1
    //   752: invokestatic 725	bdgc:b	(Lcom/tencent/mobileqq/app/QQAppInterface;Ljava/lang/String;Z)Ljava/lang/String;
    //   755: astore 12
    //   757: aload 11
    //   759: ldc_w 718
    //   762: aload 12
    //   764: invokevirtual 250	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   767: pop
    //   768: aload 11
    //   770: ldc_w 720
    //   773: aload 12
    //   775: invokevirtual 250	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   778: pop
    //   779: aload 11
    //   781: ldc_w 727
    //   784: aload 10
    //   786: getfield 728	com/tencent/biz/pubaccount/readinjoy/struct/SocializeFeedsInfo$BiuCommentInfo:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   789: invokevirtual 250	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   792: pop
    //   793: aload 11
    //   795: ldc_w 730
    //   798: aload 10
    //   800: getfield 731	com/tencent/biz/pubaccount/readinjoy/struct/SocializeFeedsInfo$BiuCommentInfo:jdField_a_of_type_Int	I
    //   803: invokevirtual 667	org/json/JSONObject:put	(Ljava/lang/String;I)Lorg/json/JSONObject;
    //   806: pop
    //   807: aload 11
    //   809: ldc_w 733
    //   812: aload 10
    //   814: getfield 735	com/tencent/biz/pubaccount/readinjoy/struct/SocializeFeedsInfo$BiuCommentInfo:c	I
    //   817: invokevirtual 667	org/json/JSONObject:put	(Ljava/lang/String;I)Lorg/json/JSONObject;
    //   820: pop
    //   821: aload_3
    //   822: aload 11
    //   824: invokevirtual 253	org/json/JSONArray:put	(Ljava/lang/Object;)Lorg/json/JSONArray;
    //   827: pop
    //   828: goto -221 -> 607
    //   831: astore_1
    //   832: aload_0
    //   833: ldc 103
    //   835: putfield 109	qzi:n	Ljava/lang/String;
    //   838: invokestatic 140	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   841: ifeq -818 -> 23
    //   844: ldc 142
    //   846: iconst_2
    //   847: new 33	java/lang/StringBuilder
    //   850: dup
    //   851: invokespecial 36	java/lang/StringBuilder:<init>	()V
    //   854: ldc_w 737
    //   857: invokevirtual 42	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   860: aload_1
    //   861: invokevirtual 738	org/json/JSONException:toString	()Ljava/lang/String;
    //   864: invokevirtual 42	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   867: invokevirtual 51	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   870: invokestatic 740	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   873: return
    //   874: iconst_0
    //   875: istore 7
    //   877: goto -812 -> 65
    //   880: aload 8
    //   882: ldc_w 596
    //   885: aload_1
    //   886: getfield 743	com/tencent/biz/pubaccount/readinjoy/struct/ArticleInfo:mFeedId	J
    //   889: invokestatic 155	java/lang/String:valueOf	(J)Ljava/lang/String;
    //   892: invokevirtual 250	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   895: pop
    //   896: aload 8
    //   898: ldc_w 603
    //   901: iload 4
    //   903: invokevirtual 667	org/json/JSONObject:put	(Ljava/lang/String;I)Lorg/json/JSONObject;
    //   906: pop
    //   907: goto -680 -> 227
    //   910: aload_1
    //   911: getfield 746	com/tencent/biz/pubaccount/readinjoy/struct/ArticleInfo:mFirstPagePicUrl	Ljava/lang/String;
    //   914: astore_3
    //   915: goto -552 -> 363
    //   918: aload 9
    //   920: invokevirtual 573	java/lang/Boolean:booleanValue	()Z
    //   923: ifeq -400 -> 523
    //   926: aload_1
    //   927: getfield 448	com/tencent/biz/pubaccount/readinjoy/struct/ArticleInfo:mSocialFeedInfo	Lcom/tencent/biz/pubaccount/readinjoy/struct/SocializeFeedsInfo;
    //   930: getfield 689	com/tencent/biz/pubaccount/readinjoy/struct/SocializeFeedsInfo:jdField_a_of_type_Qme	Lqme;
    //   933: getfield 747	qme:jdField_a_of_type_Long	J
    //   936: invokestatic 750	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   939: astore_3
    //   940: aload 8
    //   942: ldc_w 581
    //   945: new 124	java/lang/String
    //   948: dup
    //   949: aload_3
    //   950: invokevirtual 463	java/lang/Long:longValue	()J
    //   953: invokestatic 710	java/lang/Long:toString	(J)Ljava/lang/String;
    //   956: invokevirtual 712	java/lang/String:getBytes	()[B
    //   959: iconst_0
    //   960: invokestatic 716	bdfr:encode	([BI)[B
    //   963: invokespecial 375	java/lang/String:<init>	([B)V
    //   966: invokevirtual 250	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   969: pop
    //   970: aload 8
    //   972: ldc_w 752
    //   975: ldc 103
    //   977: invokevirtual 250	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   980: pop
    //   981: aload 8
    //   983: ldc_w 754
    //   986: ldc 103
    //   988: invokevirtual 250	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   991: pop
    //   992: invokestatic 166	ors:a	()Lmqq/app/AppRuntime;
    //   995: checkcast 168	com/tencent/mobileqq/app/QQAppInterface
    //   998: ifnull +41 -> 1039
    //   1001: invokestatic 166	ors:a	()Lmqq/app/AppRuntime;
    //   1004: checkcast 168	com/tencent/mobileqq/app/QQAppInterface
    //   1007: aload_3
    //   1008: invokevirtual 463	java/lang/Long:longValue	()J
    //   1011: invokestatic 710	java/lang/Long:toString	(J)Ljava/lang/String;
    //   1014: iconst_1
    //   1015: invokestatic 725	bdgc:b	(Lcom/tencent/mobileqq/app/QQAppInterface;Ljava/lang/String;Z)Ljava/lang/String;
    //   1018: astore_3
    //   1019: aload 8
    //   1021: ldc_w 752
    //   1024: aload_3
    //   1025: invokevirtual 250	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   1028: pop
    //   1029: aload 8
    //   1031: ldc_w 754
    //   1034: aload_3
    //   1035: invokevirtual 250	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   1038: pop
    //   1039: aload_1
    //   1040: getfield 448	com/tencent/biz/pubaccount/readinjoy/struct/ArticleInfo:mSocialFeedInfo	Lcom/tencent/biz/pubaccount/readinjoy/struct/SocializeFeedsInfo;
    //   1043: getfield 689	com/tencent/biz/pubaccount/readinjoy/struct/SocializeFeedsInfo:jdField_a_of_type_Qme	Lqme;
    //   1046: getfield 692	qme:jdField_a_of_type_Int	I
    //   1049: iconst_1
    //   1050: if_icmpne +533 -> 1583
    //   1053: iconst_1
    //   1054: istore 4
    //   1056: aload 8
    //   1058: ldc_w 756
    //   1061: iload 4
    //   1063: invokevirtual 667	org/json/JSONObject:put	(Ljava/lang/String;I)Lorg/json/JSONObject;
    //   1066: pop
    //   1067: goto -544 -> 523
    //   1070: aload 8
    //   1072: ldc_w 758
    //   1075: aload_3
    //   1076: invokevirtual 250	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   1079: pop
    //   1080: aload_1
    //   1081: getfield 448	com/tencent/biz/pubaccount/readinjoy/struct/ArticleInfo:mSocialFeedInfo	Lcom/tencent/biz/pubaccount/readinjoy/struct/SocializeFeedsInfo;
    //   1084: ifnull +94 -> 1178
    //   1087: aload 8
    //   1089: ldc_w 642
    //   1092: aload_1
    //   1093: getfield 448	com/tencent/biz/pubaccount/readinjoy/struct/ArticleInfo:mSocialFeedInfo	Lcom/tencent/biz/pubaccount/readinjoy/struct/SocializeFeedsInfo;
    //   1096: getfield 760	com/tencent/biz/pubaccount/readinjoy/struct/SocializeFeedsInfo:e	I
    //   1099: i2l
    //   1100: iconst_1
    //   1101: invokestatic 763	orr:a	(JZ)Ljava/lang/String;
    //   1104: invokevirtual 250	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   1107: pop
    //   1108: aload_1
    //   1109: getfield 448	com/tencent/biz/pubaccount/readinjoy/struct/ArticleInfo:mSocialFeedInfo	Lcom/tencent/biz/pubaccount/readinjoy/struct/SocializeFeedsInfo;
    //   1112: getfield 764	com/tencent/biz/pubaccount/readinjoy/struct/SocializeFeedsInfo:jdField_a_of_type_Int	I
    //   1115: istore 6
    //   1117: iload 6
    //   1119: tableswitch	default:+470 -> 1589, 1:+490->1609, 2:+490->1609, 3:+49->1168, 4:+49->1168, 5:+473->1592, 6:+473->1592, 7:+49->1168, 8:+49->1168, 9:+208->1327
    //   1169: iconst_5
    //   1170: ldc_w 664
    //   1173: iconst_1
    //   1174: invokevirtual 667	org/json/JSONObject:put	(Ljava/lang/String;I)Lorg/json/JSONObject;
    //   1177: pop
    //   1178: invokestatic 140	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   1181: ifeq +33 -> 1214
    //   1184: ldc 142
    //   1186: iconst_2
    //   1187: new 33	java/lang/StringBuilder
    //   1190: dup
    //   1191: invokespecial 36	java/lang/StringBuilder:<init>	()V
    //   1194: ldc_w 766
    //   1197: invokevirtual 42	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1200: aload 8
    //   1202: invokevirtual 767	org/json/JSONObject:toString	()Ljava/lang/String;
    //   1205: invokevirtual 42	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1208: invokevirtual 51	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1211: invokestatic 740	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   1214: aload_0
    //   1215: aload 8
    //   1217: invokevirtual 767	org/json/JSONObject:toString	()Ljava/lang/String;
    //   1220: putfield 109	qzi:n	Ljava/lang/String;
    //   1223: aload_0
    //   1224: aload 8
    //   1226: ldc_w 596
    //   1229: invokevirtual 770	org/json/JSONObject:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   1232: invokestatic 773	java/lang/Long:valueOf	(Ljava/lang/String;)Ljava/lang/Long;
    //   1235: invokevirtual 463	java/lang/Long:longValue	()J
    //   1238: putfield 775	qzi:jdField_b_of_type_Long	J
    //   1241: return
    //   1242: aload 8
    //   1244: ldc_w 664
    //   1247: iload 4
    //   1249: invokevirtual 667	org/json/JSONObject:put	(Ljava/lang/String;I)Lorg/json/JSONObject;
    //   1252: pop
    //   1253: aload 8
    //   1255: ldc_w 672
    //   1258: iconst_1
    //   1259: invokevirtual 667	org/json/JSONObject:put	(Ljava/lang/String;I)Lorg/json/JSONObject;
    //   1262: pop
    //   1263: aload_1
    //   1264: getfield 675	com/tencent/biz/pubaccount/readinjoy/struct/ArticleInfo:mVideoCoverUrl	Ljava/net/URL;
    //   1267: ifnull +27 -> 1294
    //   1270: aload 8
    //   1272: ldc_w 658
    //   1275: aload_1
    //   1276: getfield 675	com/tencent/biz/pubaccount/readinjoy/struct/ArticleInfo:mVideoCoverUrl	Ljava/net/URL;
    //   1279: invokevirtual 676	java/net/URL:toString	()Ljava/lang/String;
    //   1282: ldc_w 777
    //   1285: ldc 103
    //   1287: invokevirtual 312	java/lang/String:replace	(Ljava/lang/CharSequence;Ljava/lang/CharSequence;)Ljava/lang/String;
    //   1290: invokevirtual 250	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   1293: pop
    //   1294: aload 8
    //   1296: ldc_w 678
    //   1299: aload_1
    //   1300: getfield 681	com/tencent/biz/pubaccount/readinjoy/struct/ArticleInfo:mVideoDuration	I
    //   1303: invokestatic 686	qfg:a	(I)Ljava/lang/String;
    //   1306: invokevirtual 250	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   1309: pop
    //   1310: goto -132 -> 1178
    //   1313: aload 8
    //   1315: ldc_w 664
    //   1318: iload 4
    //   1320: invokevirtual 667	org/json/JSONObject:put	(Ljava/lang/String;I)Lorg/json/JSONObject;
    //   1323: pop
    //   1324: goto -146 -> 1178
    //   1327: aload 8
    //   1329: ldc_w 779
    //   1332: iconst_1
    //   1333: invokevirtual 667	org/json/JSONObject:put	(Ljava/lang/String;I)Lorg/json/JSONObject;
    //   1336: pop
    //   1337: aload_1
    //   1338: getfield 448	com/tencent/biz/pubaccount/readinjoy/struct/ArticleInfo:mSocialFeedInfo	Lcom/tencent/biz/pubaccount/readinjoy/struct/SocializeFeedsInfo;
    //   1341: getfield 782	com/tencent/biz/pubaccount/readinjoy/struct/SocializeFeedsInfo:jdField_a_of_type_Qmr	Lqmr;
    //   1344: ifnull -166 -> 1178
    //   1347: aload_1
    //   1348: getfield 448	com/tencent/biz/pubaccount/readinjoy/struct/ArticleInfo:mSocialFeedInfo	Lcom/tencent/biz/pubaccount/readinjoy/struct/SocializeFeedsInfo;
    //   1351: getfield 782	com/tencent/biz/pubaccount/readinjoy/struct/SocializeFeedsInfo:jdField_a_of_type_Qmr	Lqmr;
    //   1354: getfield 787	qmr:a	Ljava/util/ArrayList;
    //   1357: ifnull -179 -> 1178
    //   1360: aload_1
    //   1361: getfield 448	com/tencent/biz/pubaccount/readinjoy/struct/ArticleInfo:mSocialFeedInfo	Lcom/tencent/biz/pubaccount/readinjoy/struct/SocializeFeedsInfo;
    //   1364: getfield 782	com/tencent/biz/pubaccount/readinjoy/struct/SocializeFeedsInfo:jdField_a_of_type_Qmr	Lqmr;
    //   1367: getfield 787	qmr:a	Ljava/util/ArrayList;
    //   1370: invokevirtual 788	java/util/ArrayList:size	()I
    //   1373: ifle -195 -> 1178
    //   1376: aload_1
    //   1377: getfield 448	com/tencent/biz/pubaccount/readinjoy/struct/ArticleInfo:mSocialFeedInfo	Lcom/tencent/biz/pubaccount/readinjoy/struct/SocializeFeedsInfo;
    //   1380: getfield 782	com/tencent/biz/pubaccount/readinjoy/struct/SocializeFeedsInfo:jdField_a_of_type_Qmr	Lqmr;
    //   1383: getfield 787	qmr:a	Ljava/util/ArrayList;
    //   1386: astore_1
    //   1387: new 219	org/json/JSONArray
    //   1390: dup
    //   1391: invokespecial 220	org/json/JSONArray:<init>	()V
    //   1394: astore_3
    //   1395: aload_1
    //   1396: invokeinterface 209 1 0
    //   1401: astore 9
    //   1403: aload 9
    //   1405: invokeinterface 225 1 0
    //   1410: ifeq +144 -> 1554
    //   1413: aload 9
    //   1415: invokeinterface 247 1 0
    //   1420: checkcast 790	qms
    //   1423: astore 10
    //   1425: aload 10
    //   1427: getfield 791	qms:jdField_b_of_type_JavaLangString	Ljava/lang/String;
    //   1430: ifnonnull +11 -> 1441
    //   1433: aload 10
    //   1435: getfield 792	qms:c	Ljava/lang/String;
    //   1438: ifnull -35 -> 1403
    //   1441: new 227	org/json/JSONObject
    //   1444: dup
    //   1445: invokespecial 228	org/json/JSONObject:<init>	()V
    //   1448: astore 11
    //   1450: aload 10
    //   1452: getfield 791	qms:jdField_b_of_type_JavaLangString	Ljava/lang/String;
    //   1455: ifnull +81 -> 1536
    //   1458: aload 10
    //   1460: getfield 791	qms:jdField_b_of_type_JavaLangString	Ljava/lang/String;
    //   1463: astore_1
    //   1464: aload 11
    //   1466: ldc_w 794
    //   1469: aload_1
    //   1470: invokevirtual 250	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   1473: pop
    //   1474: aload 10
    //   1476: getfield 792	qms:c	Ljava/lang/String;
    //   1479: ifnull +66 -> 1545
    //   1482: aload 10
    //   1484: getfield 792	qms:c	Ljava/lang/String;
    //   1487: astore_1
    //   1488: aload 11
    //   1490: ldc_w 796
    //   1493: aload_1
    //   1494: invokevirtual 250	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   1497: pop
    //   1498: aload 11
    //   1500: ldc_w 798
    //   1503: aload 10
    //   1505: getfield 799	qms:jdField_a_of_type_Int	I
    //   1508: invokevirtual 667	org/json/JSONObject:put	(Ljava/lang/String;I)Lorg/json/JSONObject;
    //   1511: pop
    //   1512: aload 11
    //   1514: ldc_w 798
    //   1517: aload 10
    //   1519: getfield 799	qms:jdField_a_of_type_Int	I
    //   1522: invokevirtual 667	org/json/JSONObject:put	(Ljava/lang/String;I)Lorg/json/JSONObject;
    //   1525: pop
    //   1526: aload_3
    //   1527: aload 11
    //   1529: invokevirtual 253	org/json/JSONArray:put	(Ljava/lang/Object;)Lorg/json/JSONArray;
    //   1532: pop
    //   1533: goto -130 -> 1403
    //   1536: aload 10
    //   1538: getfield 792	qms:c	Ljava/lang/String;
    //   1541: astore_1
    //   1542: goto -78 -> 1464
    //   1545: aload 10
    //   1547: getfield 791	qms:jdField_b_of_type_JavaLangString	Ljava/lang/String;
    //   1550: astore_1
    //   1551: goto -63 -> 1488
    //   1554: aload 8
    //   1556: ldc_w 801
    //   1559: aload_3
    //   1560: invokevirtual 250	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   1563: pop
    //   1564: goto -386 -> 1178
    //   1567: astore_3
    //   1568: goto -1403 -> 165
    //   1571: iconst_1
    //   1572: istore 7
    //   1574: goto -1509 -> 65
    //   1577: iconst_1
    //   1578: istore 4
    //   1580: goto -1197 -> 383
    //   1583: iconst_0
    //   1584: istore 4
    //   1586: goto -530 -> 1056
    //   1589: goto -421 -> 1168
    //   1592: iload 5
    //   1594: istore 4
    //   1596: iload 6
    //   1598: bipush 6
    //   1600: if_icmpne -358 -> 1242
    //   1603: iconst_2
    //   1604: istore 4
    //   1606: goto -364 -> 1242
    //   1609: iload 6
    //   1611: iconst_2
    //   1612: if_icmpne +9 -> 1621
    //   1615: iconst_2
    //   1616: istore 4
    //   1618: goto -305 -> 1313
    //   1621: iconst_1
    //   1622: istore 4
    //   1624: goto -311 -> 1313
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	1627	0	this	qzi
    //   0	1627	1	paramArticleInfo	ArticleInfo
    //   0	1627	2	paramBoolean	boolean
    //   0	1627	3	paramString	String
    //   37	1586	4	i1	int
    //   4	1589	5	i2	int
    //   1	1612	6	i3	int
    //   65	1508	7	bool	boolean
    //   31	1524	8	localJSONObject1	JSONObject
    //   46	1368	9	localObject1	Object
    //   70	1476	10	localObject2	Object
    //   636	892	11	localJSONObject2	JSONObject
    //   755	19	12	str	String
    // Exception table:
    //   from	to	target	type
    //   24	62	831	org/json/JSONException
    //   65	94	831	org/json/JSONException
    //   94	111	831	org/json/JSONException
    //   116	165	831	org/json/JSONException
    //   169	227	831	org/json/JSONException
    //   227	363	831	org/json/JSONException
    //   363	380	831	org/json/JSONException
    //   383	394	831	org/json/JSONException
    //   398	438	831	org/json/JSONException
    //   438	454	831	org/json/JSONException
    //   458	491	831	org/json/JSONException
    //   495	509	831	org/json/JSONException
    //   512	523	831	org/json/JSONException
    //   523	607	831	org/json/JSONException
    //   607	779	831	org/json/JSONException
    //   779	828	831	org/json/JSONException
    //   880	907	831	org/json/JSONException
    //   910	915	831	org/json/JSONException
    //   918	1039	831	org/json/JSONException
    //   1039	1053	831	org/json/JSONException
    //   1056	1067	831	org/json/JSONException
    //   1070	1080	831	org/json/JSONException
    //   1080	1117	831	org/json/JSONException
    //   1168	1178	831	org/json/JSONException
    //   1178	1214	831	org/json/JSONException
    //   1214	1241	831	org/json/JSONException
    //   1242	1294	831	org/json/JSONException
    //   1294	1310	831	org/json/JSONException
    //   1313	1324	831	org/json/JSONException
    //   1327	1403	831	org/json/JSONException
    //   1403	1441	831	org/json/JSONException
    //   1441	1464	831	org/json/JSONException
    //   1464	1488	831	org/json/JSONException
    //   1488	1533	831	org/json/JSONException
    //   1536	1542	831	org/json/JSONException
    //   1545	1551	831	org/json/JSONException
    //   1554	1564	831	org/json/JSONException
    //   116	165	1567	java/lang/Exception
  }
  
  public void a(String paramString, int paramInt)
  {
    boolean bool = true;
    if (!a(c)) {
      return;
    }
    qzl localqzl = null;
    for (;;)
    {
      try
      {
        String str = Integer.toString(paramInt);
        JSONObject localJSONObject = new JSONObject();
        localJSONObject.put("callid", "0");
        localJSONObject.put("host", "kandian.qq.com");
        localJSONObject.put("path", "kandian_messagebox");
        localJSONObject.put("key", "kandian_messagebox_data_key2_isNew_" + str + "_" + paramString);
        str = "https://kandian.qq.com/qz_kandian_social/kandian_ext/getMessageBox?readTimestamp=0&pageNo=1&pageSize=20&isBiuLevel=1&isNew=" + str;
        paramString = str;
        if (paramInt == 1)
        {
          localqzl = new qzl(this);
          paramString = str + "&ispreload=1";
        }
        str = c;
        if (paramInt == 1)
        {
          a("get", paramString, localJSONObject, str, localqzl, Boolean.valueOf(bool));
          if (!QLog.isColorLevel()) {
            break;
          }
          QLog.w("ReadInJoyWebDataManager", 2, "preloadWebDataMessageBox:isNew " + paramInt);
          return;
        }
      }
      catch (Exception paramString)
      {
        return;
      }
      bool = false;
    }
  }
  
  public void a(String paramString1, String paramString2)
  {
    nrt.a(null, "", "0X8008221", "0X8008221", 0, 0, paramString1, paramString2, "", "", false);
  }
  
  public void a(String paramString1, String paramString2, String paramString3)
  {
    nrt.a(null, "", "0X8008220", "0X8008220", 0, 0, paramString1, paramString2, paramString3, "", false);
  }
  
  public void a(String paramString1, String paramString2, String paramString3, JSONObject paramJSONObject)
  {
    Looper localLooper = Looper.getMainLooper();
    if (Thread.currentThread() != localLooper.getThread())
    {
      new Handler(localLooper).post(new ReadInJoyWebDataManager.1(this, paramString1, paramString2, paramString3, paramJSONObject));
      return;
    }
    b(paramString1, paramString2, paramString3, paramJSONObject);
  }
  
  public void a(String paramString1, String paramString2, JSONObject paramJSONObject, String paramString3)
  {
    a(paramString1, paramString2, paramJSONObject, paramString3, null, Boolean.valueOf(false));
  }
  
  public void a(String paramString1, String paramString2, JSONObject paramJSONObject, String paramString3, qzn paramqzn, Boolean paramBoolean)
  {
    if (this.jdField_a_of_type_JavaUtilHashMap != null) {
      if ((this.jdField_a_of_type_JavaUtilHashMap.containsKey(paramString2)) && (System.currentTimeMillis() - ((Long)this.jdField_a_of_type_JavaUtilHashMap.get(paramString2)).longValue() < 1800000L)) {
        a(paramString3, g, j);
      }
    }
    while (!QLog.isColorLevel()) {
      for (;;)
      {
        return;
        a(paramString3, f, "");
        if (!paramBoolean.booleanValue()) {
          this.jdField_a_of_type_JavaUtilHashMap.put(paramString2, Long.valueOf(System.currentTimeMillis()));
        }
        if (paramString2.indexOf("?") != -1) {}
        for (paramString2 = paramString2 + "&g_tk=" + d(); "get".equals(paramString1); paramString2 = paramString2 + "?g_tk=" + d())
        {
          a(paramString2, paramJSONObject, paramString3, paramqzn);
          return;
        }
      }
    }
    QLog.w("ReadInJoyWebDataManager", 2, "httpFetchAsync mCgiLoadedMap cause mCgiLoadedMap is null ");
  }
  
  public void a(String paramString1, String paramString2, qzm paramqzm)
  {
    JSONObject localJSONObject = new JSONObject();
    if (TextUtils.isEmpty(paramString2)) {
      return;
    }
    new Thread(new ReadInJoyWebDataManager.4(this, paramString2, paramqzm, localJSONObject, paramString1)).start();
  }
  
  public void a(String paramString, JSONObject paramJSONObject)
  {
    if ((BaseApplication.getContext() == null) || (!oug.a())) {}
    do
    {
      do
      {
        return;
      } while ((this.jdField_a_of_type_JavaUtilHashMap == null) || ((this.jdField_a_of_type_JavaUtilHashMap.containsKey(paramString)) && (System.currentTimeMillis() - ((Long)this.jdField_a_of_type_JavaUtilHashMap.get(paramString)).longValue() < 1800000L)));
      if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViolaViewViolaBaseView == null)
      {
        this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViolaViewViolaBaseView = new ViolaBaseView(BaseApplication.getContext());
        this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViolaViewViolaBaseView.a(jdField_a_of_type_JavaLangString, null, new srj(jdField_a_of_type_JavaLangString, new JSONObject(), null));
      }
      try
      {
        JSONObject localJSONObject = new JSONObject();
        localJSONObject.put("url", paramString);
        localJSONObject.put("param", paramJSONObject);
        paramJSONObject = new JSONObject();
        paramJSONObject.put("preloadViola", localJSONObject);
        this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViolaViewViolaBaseView.a(paramJSONObject.toString());
        this.jdField_a_of_type_JavaUtilHashMap.put(paramString, Long.valueOf(System.currentTimeMillis()));
        return;
      }
      catch (JSONException paramString) {}
    } while (!QLog.isColorLevel());
    QLog.w("ReadInJoyWebDataManager", 2, "preLoadComCgi e " + paramString.getMessage());
  }
  
  public boolean a()
  {
    QQAppInterface localQQAppInterface = (QQAppInterface)ors.a();
    if (localQQAppInterface == null) {
      return false;
    }
    if ((b()) && (bkbq.y(localQQAppInterface))) {}
    for (boolean bool = true;; bool = false) {
      return bool;
    }
  }
  
  public boolean a(String paramString)
  {
    if (!a())
    {
      if (!b()) {
        a(paramString, g, h);
      }
      for (;;)
      {
        return false;
        a(paramString, g, i);
      }
    }
    return true;
  }
  
  public String b()
  {
    return this.n;
  }
  
  public void b()
  {
    this.n = "";
    this.l = "";
    if (this.jdField_a_of_type_JavaUtilHashMap != null) {
      this.jdField_a_of_type_JavaUtilHashMap.clear();
    }
    if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViolaViewViolaBaseView != null)
    {
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViolaViewViolaBaseView.onActivityDestroy();
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViolaViewViolaBaseView = null;
    }
  }
  
  public void b(String paramString)
  {
    a(paramString, null);
  }
  
  public void c(String paramString)
  {
    if (!a(jdField_b_of_type_JavaLangString)) {
      return;
    }
    try
    {
      JSONObject localJSONObject = new JSONObject();
      localJSONObject.put("callid", "0");
      localJSONObject.put("host", "kandian.qq.com");
      localJSONObject.put("path", "kandian_homepage");
      localJSONObject.put("key", "kandian_homepage2_data_key_" + paramString);
      a("get", "https://kandian.qq.com/qz_kandian_social/kandian_ext/getPersonPage?pageNo=1&pageSize=20&is715=1&uin=" + paramString, localJSONObject, jdField_b_of_type_JavaLangString);
      return;
    }
    catch (Exception paramString) {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     qzi
 * JD-Core Version:    0.7.0.1
 */