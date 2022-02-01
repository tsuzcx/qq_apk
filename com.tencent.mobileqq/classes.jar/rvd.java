import android.net.Uri;
import android.os.Build.VERSION;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import com.tencent.biz.pubaccount.PublicAccountJavascriptInterface;
import com.tencent.biz.pubaccount.readinjoy.struct.ArticleInfo;
import com.tencent.biz.pubaccount.readinjoy.struct.SocializeFeedsInfo;
import com.tencent.biz.pubaccount.readinjoy.struct.SocializeFeedsInfo.BiuCommentInfo;
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
import com.tencent.mobileqq.persistence.EntityManager;
import com.tencent.mobileqq.persistence.EntityManagerFactory;
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

public class rvd
{
  public static int a;
  private static long jdField_a_of_type_Long;
  public static String a;
  public static List<String> a;
  private static rvd jdField_a_of_type_Rvd;
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
  private static final String k = "QQ/8.4.1 Android/0.17 Android/" + Build.VERSION.RELEASE;
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
  
  private Long a(ArticleInfo paramArticleInfo, boolean paramBoolean)
  {
    if ((paramBoolean) && (paramArticleInfo.mSocialFeedInfo != null) && (paramArticleInfo.mSocialFeedInfo.jdField_a_of_type_Rgy != null)) {
      return paramArticleInfo.mSocialFeedInfo.jdField_a_of_type_Rgy.jdField_a_of_type_JavaLangLong;
    }
    return Long.valueOf(paramArticleInfo.mFeedId);
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
    return bkgf.a(paramString1, paramString2);
  }
  
  private String a(String paramString1, String paramString2, String paramString3)
  {
    Object localObject = (QQAppInterface)pha.a();
    if (localObject == null) {
      return null;
    }
    localObject = ((QQAppInterface)localObject).getEntityManagerFactory(((QQAppInterface)localObject).getAccount()).createEntityManager();
    paramString1 = (CouponH5Data)((EntityManager)localObject).find(CouponH5Data.class, "mHost = ? AND mPath = ? AND mKey = ?", new String[] { paramString1, paramString2, paramString3 });
    ((EntityManager)localObject).close();
    if (paramString1 != null) {}
    for (paramString1 = paramString1.mData;; paramString1 = null) {
      return paramString1;
    }
  }
  
  private JSONArray a(List<rho> paramList)
  {
    JSONArray localJSONArray = new JSONArray();
    Iterator localIterator = paramList.iterator();
    while (localIterator.hasNext())
    {
      rho localrho = (rho)localIterator.next();
      if ((localrho.jdField_b_of_type_JavaLangString != null) || (localrho.c != null))
      {
        JSONObject localJSONObject = new JSONObject();
        if (localrho.jdField_b_of_type_JavaLangString != null)
        {
          paramList = localrho.jdField_b_of_type_JavaLangString;
          label74:
          localJSONObject.put("origin_url", paramList);
          if (localrho.c == null) {
            break label154;
          }
        }
        label154:
        for (paramList = localrho.c;; paramList = localrho.jdField_b_of_type_JavaLangString)
        {
          localJSONObject.put("thumbnail_url", paramList);
          localJSONObject.put("pic_width", localrho.jdField_a_of_type_Int);
          localJSONObject.put("pic_height", localrho.jdField_b_of_type_Int);
          localJSONArray.put(localJSONObject);
          break;
          paramList = localrho.c;
          break label74;
        }
      }
    }
    return localJSONArray;
  }
  
  public static rvd a()
  {
    if (jdField_a_of_type_Rvd == null) {
      jdField_a_of_type_Rvd = new rvd();
    }
    return jdField_a_of_type_Rvd;
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
            break label148;
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
      label148:
      a(localJSONArray.toString());
    }
  }
  
  private void a(ArticleInfo paramArticleInfo, JSONObject paramJSONObject)
  {
    if (pha.a(paramArticleInfo))
    {
      paramJSONObject.put("isVideo", 1);
      if (paramArticleInfo.mVideoCoverUrl != null) {
        paramJSONObject.put("picurl", paramArticleInfo.mVideoCoverUrl.toString());
      }
      paramJSONObject.put("videoTimeTips", qyo.a(paramArticleInfo.mVideoDuration));
    }
  }
  
  private void a(ArticleInfo paramArticleInfo, JSONObject paramJSONObject, boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3)
  {
    if ((!paramBoolean3) && (paramBoolean2) && (paramArticleInfo.mSocialFeedInfo != null)) {}
    for (int i1 = 1; i1 == 0; i1 = 0) {
      return;
    }
    if (paramArticleInfo.mSocialFeedInfo.jdField_a_of_type_Rha != null)
    {
      if (!paramBoolean1) {
        break label378;
      }
      if (paramArticleInfo.mSocialFeedInfo.jdField_a_of_type_Rha.jdField_a_of_type_Int != 1) {
        break label372;
      }
      i1 = 1;
      paramJSONObject.put("isAccountApproved", i1);
    }
    label73:
    Object localObject;
    for (;;)
    {
      if ((paramBoolean2) && (paramArticleInfo.mSocialFeedInfo.jdField_a_of_type_Rgy != null))
      {
        paramJSONObject.put("originFeedsId", String.valueOf(paramArticleInfo.mSocialFeedInfo.jdField_a_of_type_Rgy.jdField_a_of_type_JavaLangLong));
        paramJSONObject.put("originFeedsType", paramArticleInfo.mSocialFeedInfo.jdField_a_of_type_Rgy.jdField_b_of_type_JavaLangLong);
        localObject = new JSONArray();
        paramArticleInfo = paramArticleInfo.mSocialFeedInfo.jdField_a_of_type_Rgy.jdField_a_of_type_JavaUtilList.iterator();
        while (paramArticleInfo.hasNext())
        {
          SocializeFeedsInfo.BiuCommentInfo localBiuCommentInfo = (SocializeFeedsInfo.BiuCommentInfo)paramArticleInfo.next();
          JSONObject localJSONObject = new JSONObject();
          localJSONObject.put("biuLevel_feeds_id", String.valueOf(localBiuCommentInfo.jdField_b_of_type_JavaLangLong));
          localJSONObject.put("biuLevel_feeds_type", localBiuCommentInfo.jdField_b_of_type_Int);
          localJSONObject.put("biuLevel_uin", new String(bgku.encode(Long.toString(localBiuCommentInfo.jdField_a_of_type_JavaLangLong.longValue()).getBytes(), 0)));
          localJSONObject.put("biuLevel_nick", "");
          localJSONObject.put("biuLevel_remark", "");
          if (pha.a() != null)
          {
            String str = bglf.b((QQAppInterface)pha.a(), Long.toString(localBiuCommentInfo.jdField_a_of_type_JavaLangLong.longValue()), true);
            localJSONObject.put("biuLevel_nick", str);
            localJSONObject.put("biuLevel_remark", str);
          }
          localJSONObject.put("biuLevel_comment", localBiuCommentInfo.jdField_a_of_type_JavaLangString);
          localJSONObject.put("biuLevel_time", localBiuCommentInfo.jdField_a_of_type_Int);
          localJSONObject.put("op_type", localBiuCommentInfo.c);
          ((JSONArray)localObject).put(localJSONObject);
        }
        label372:
        i1 = 0;
        break;
        label378:
        if (paramBoolean2)
        {
          localObject = Long.valueOf(paramArticleInfo.mSocialFeedInfo.jdField_a_of_type_Rha.jdField_a_of_type_Long);
          paramJSONObject.put("uin", new String(bgku.encode(Long.toString(((Long)localObject).longValue()).getBytes(), 0)));
          paramJSONObject.put("nick", "");
          paramJSONObject.put("remark", "");
          if (pha.a() != null)
          {
            localObject = bglf.b((QQAppInterface)pha.a(), Long.toString(((Long)localObject).longValue()), true);
            paramJSONObject.put("nick", localObject);
            paramJSONObject.put("remark", localObject);
          }
          if (paramArticleInfo.mSocialFeedInfo.jdField_a_of_type_Rha.jdField_a_of_type_Int != 1) {
            break label524;
          }
        }
      }
    }
    label524:
    for (i1 = 1;; i1 = 0)
    {
      paramJSONObject.put("isApproved", i1);
      break label73;
      break;
    }
    paramJSONObject.put("biuLevelList", localObject);
  }
  
  public static void a(String paramString)
  {
    AppRuntime localAppRuntime = pha.a();
    if (localAppRuntime == null) {
      return;
    }
    ThreadManager.post(new ReadInJoyWebDataManager.6(localAppRuntime, paramString), 5, null, true);
  }
  
  private void a(String paramString1, String paramString2, String paramString3, String paramString4)
  {
    Object localObject = (QQAppInterface)pha.a();
    if (localObject == null) {
      return;
    }
    localObject = ((QQAppInterface)localObject).getEntityManagerFactory(((QQAppInterface)localObject).getAccount()).createEntityManager();
    CouponH5Data localCouponH5Data = (CouponH5Data)((EntityManager)localObject).find(CouponH5Data.class, "mHost = ? AND mPath = ? AND mKey = ?", new String[] { paramString1, paramString2, paramString3 });
    if (localCouponH5Data == null) {
      ((EntityManager)localObject).persist(new CouponH5Data(paramString1, paramString2, paramString3, paramString4));
    }
    for (;;)
    {
      ((EntityManager)localObject).close();
      return;
      localCouponH5Data.mData = paramString4;
      ((EntityManager)localObject).update(localCouponH5Data);
    }
  }
  
  private void a(String paramString1, JSONObject paramJSONObject, String paramString2, rvi paramrvi)
  {
    ThreadManager.post(new ReadInJoyWebDataManager.5(this, paramString1, paramString2, paramrvi, paramJSONObject), 5, null, true);
  }
  
  /* Error */
  private void a(String paramString1, rvh paramrvh, JSONObject paramJSONObject, String paramString2)
  {
    // Byte code:
    //   0: invokestatic 191	pha:a	()Lmqq/app/AppRuntime;
    //   3: checkcast 193	com/tencent/mobileqq/app/QQAppInterface
    //   6: astore 6
    //   8: aload 6
    //   10: ifnonnull +4 -> 14
    //   13: return
    //   14: new 249	org/json/JSONObject
    //   17: dup
    //   18: aload_1
    //   19: invokespecial 445	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   22: astore 7
    //   24: aload 7
    //   26: ldc_w 447
    //   29: invokevirtual 450	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   32: astore 5
    //   34: aload 5
    //   36: astore_1
    //   37: aload 5
    //   39: invokestatic 456	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   42: ifne +24 -> 66
    //   45: aload 5
    //   47: ldc_w 458
    //   50: ldc_w 460
    //   53: invokevirtual 464	java/lang/String:replace	(Ljava/lang/CharSequence;Ljava/lang/CharSequence;)Ljava/lang/String;
    //   56: ldc_w 466
    //   59: ldc_w 468
    //   62: invokevirtual 464	java/lang/String:replace	(Ljava/lang/CharSequence;Ljava/lang/CharSequence;)Ljava/lang/String;
    //   65: astore_1
    //   66: aload_3
    //   67: ldc_w 447
    //   70: aload_1
    //   71: invokevirtual 256	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   74: pop
    //   75: aload 7
    //   77: ldc_w 470
    //   80: invokevirtual 450	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   83: astore 5
    //   85: aload 5
    //   87: invokestatic 456	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   90: ifeq +20 -> 110
    //   93: aload_2
    //   94: aload_3
    //   95: invokeinterface 475 2 0
    //   100: return
    //   101: astore_1
    //   102: aload_2
    //   103: aload_3
    //   104: invokeinterface 475 2 0
    //   109: return
    //   110: new 321	java/net/URL
    //   113: dup
    //   114: aload 4
    //   116: invokespecial 476	java/net/URL:<init>	(Ljava/lang/String;)V
    //   119: invokevirtual 479	java/net/URL:getHost	()Ljava/lang/String;
    //   122: astore_1
    //   123: aload 7
    //   125: ldc_w 481
    //   128: invokevirtual 450	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   131: astore 4
    //   133: aload 4
    //   135: invokestatic 456	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   138: ifne +462 -> 600
    //   141: aload_0
    //   142: aload 4
    //   144: aload_1
    //   145: invokespecial 484	rvd:a	(Ljava/lang/String;Ljava/lang/String;)Z
    //   148: ifeq +45 -> 193
    //   151: aload 4
    //   153: astore_1
    //   154: aload_1
    //   155: astore 4
    //   157: aload_1
    //   158: invokestatic 456	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   161: ifeq +8 -> 169
    //   164: ldc_w 486
    //   167: astore 4
    //   169: aload 7
    //   171: ldc_w 488
    //   174: invokevirtual 450	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   177: astore_1
    //   178: aload_1
    //   179: invokestatic 456	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   182: ifeq +19 -> 201
    //   185: aload_2
    //   186: aload_3
    //   187: invokeinterface 475 2 0
    //   192: return
    //   193: aload_2
    //   194: aload_3
    //   195: invokeinterface 475 2 0
    //   200: return
    //   201: aload_0
    //   202: aload 4
    //   204: aload 5
    //   206: aload_1
    //   207: invokespecial 490	rvd:a	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   210: astore 7
    //   212: aload 7
    //   214: invokestatic 456	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   217: ifeq +11 -> 228
    //   220: aload_2
    //   221: aload_3
    //   222: invokeinterface 475 2 0
    //   227: return
    //   228: new 492	java/io/File
    //   231: dup
    //   232: new 33	java/lang/StringBuilder
    //   235: dup
    //   236: invokespecial 36	java/lang/StringBuilder:<init>	()V
    //   239: getstatic 495	com/tencent/biz/pubaccount/PublicAccountJavascriptInterface:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   242: invokevirtual 42	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   245: ldc_w 497
    //   248: invokevirtual 42	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   251: aload 6
    //   253: invokevirtual 196	com/tencent/mobileqq/app/QQAppInterface:getAccount	()Ljava/lang/String;
    //   256: invokestatic 501	bgmj:b	(Ljava/lang/String;)Ljava/lang/String;
    //   259: invokevirtual 42	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   262: ldc_w 497
    //   265: invokevirtual 42	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   268: aload 4
    //   270: invokevirtual 42	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   273: ldc_w 497
    //   276: invokevirtual 42	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   279: aload 5
    //   281: invokestatic 501	bgmj:b	(Ljava/lang/String;)Ljava/lang/String;
    //   284: invokevirtual 42	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   287: ldc_w 497
    //   290: invokevirtual 42	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   293: aload_1
    //   294: invokestatic 501	bgmj:b	(Ljava/lang/String;)Ljava/lang/String;
    //   297: invokevirtual 42	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   300: invokevirtual 51	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   303: invokespecial 502	java/io/File:<init>	(Ljava/lang/String;)V
    //   306: astore 5
    //   308: aload 5
    //   310: invokevirtual 505	java/io/File:exists	()Z
    //   313: ifne +22 -> 335
    //   316: aload_3
    //   317: ldc_w 507
    //   320: ldc_w 509
    //   323: invokevirtual 256	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   326: pop
    //   327: aload_2
    //   328: aload_3
    //   329: invokeinterface 475 2 0
    //   334: return
    //   335: aload_0
    //   336: monitorenter
    //   337: new 511	java/io/FileInputStream
    //   340: dup
    //   341: aload 5
    //   343: invokespecial 514	java/io/FileInputStream:<init>	(Ljava/io/File;)V
    //   346: astore_1
    //   347: aload_1
    //   348: astore 4
    //   350: aload 5
    //   352: invokevirtual 516	java/io/File:length	()J
    //   355: l2i
    //   356: newarray byte
    //   358: astore 5
    //   360: aload_1
    //   361: astore 4
    //   363: aload_1
    //   364: aload 5
    //   366: invokevirtual 522	java/io/InputStream:read	([B)I
    //   369: pop
    //   370: aload_1
    //   371: astore 4
    //   373: aload_0
    //   374: new 150	java/lang/String
    //   377: dup
    //   378: aload 5
    //   380: invokespecial 380	java/lang/String:<init>	([B)V
    //   383: aload 7
    //   385: invokespecial 524	rvd:b	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   388: astore 5
    //   390: aload 5
    //   392: ifnonnull +47 -> 439
    //   395: aload_1
    //   396: astore 4
    //   398: aload_3
    //   399: ldc_w 507
    //   402: ldc_w 526
    //   405: invokevirtual 256	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   408: pop
    //   409: aload_1
    //   410: astore 4
    //   412: aload_2
    //   413: aload_3
    //   414: invokeinterface 475 2 0
    //   419: aload_1
    //   420: astore 4
    //   422: aload_0
    //   423: monitorexit
    //   424: aload_1
    //   425: ifnull +178 -> 603
    //   428: aload_1
    //   429: invokevirtual 527	java/io/InputStream:close	()V
    //   432: return
    //   433: astore_1
    //   434: aload_1
    //   435: invokevirtual 530	java/io/IOException:printStackTrace	()V
    //   438: return
    //   439: aload_1
    //   440: astore 4
    //   442: aload_3
    //   443: ldc_w 532
    //   446: aload 5
    //   448: ldc_w 458
    //   451: ldc_w 460
    //   454: invokevirtual 464	java/lang/String:replace	(Ljava/lang/CharSequence;Ljava/lang/CharSequence;)Ljava/lang/String;
    //   457: ldc_w 466
    //   460: ldc_w 468
    //   463: invokevirtual 464	java/lang/String:replace	(Ljava/lang/CharSequence;Ljava/lang/CharSequence;)Ljava/lang/String;
    //   466: invokevirtual 256	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   469: pop
    //   470: aload_1
    //   471: astore 4
    //   473: aload_2
    //   474: aload_3
    //   475: invokeinterface 475 2 0
    //   480: aload_1
    //   481: astore 4
    //   483: aload_0
    //   484: monitorexit
    //   485: aload_1
    //   486: ifnull +117 -> 603
    //   489: aload_1
    //   490: invokevirtual 527	java/io/InputStream:close	()V
    //   493: return
    //   494: astore_1
    //   495: aload_1
    //   496: invokevirtual 530	java/io/IOException:printStackTrace	()V
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
    //   521: ldc_w 507
    //   524: ldc_w 534
    //   527: invokevirtual 256	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   530: pop
    //   531: aload_1
    //   532: astore 4
    //   534: aload_2
    //   535: aload_3
    //   536: invokeinterface 475 2 0
    //   541: aload_1
    //   542: ifnull +61 -> 603
    //   545: aload_1
    //   546: invokevirtual 527	java/io/InputStream:close	()V
    //   549: return
    //   550: astore_1
    //   551: aload_1
    //   552: invokevirtual 530	java/io/IOException:printStackTrace	()V
    //   555: return
    //   556: astore_1
    //   557: aconst_null
    //   558: astore 4
    //   560: aload 4
    //   562: ifnull +8 -> 570
    //   565: aload 4
    //   567: invokevirtual 527	java/io/InputStream:close	()V
    //   570: aload_1
    //   571: athrow
    //   572: astore 4
    //   574: aload 4
    //   576: invokevirtual 530	java/io/IOException:printStackTrace	()V
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
    //   0	610	0	this	rvd
    //   0	610	1	paramString1	String
    //   0	610	2	paramrvh	rvh
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
    //   0: invokestatic 191	pha:a	()Lmqq/app/AppRuntime;
    //   3: checkcast 193	com/tencent/mobileqq/app/QQAppInterface
    //   6: astore 9
    //   8: aload 9
    //   10: ifnonnull +4 -> 14
    //   13: return
    //   14: new 249	org/json/JSONObject
    //   17: dup
    //   18: aload_2
    //   19: invokespecial 445	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   22: astore 10
    //   24: aload 10
    //   26: ldc_w 447
    //   29: invokevirtual 450	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   32: astore 8
    //   34: aload 8
    //   36: astore 7
    //   38: aload 8
    //   40: invokestatic 456	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   43: ifne +25 -> 68
    //   46: aload 8
    //   48: ldc_w 458
    //   51: ldc_w 460
    //   54: invokevirtual 464	java/lang/String:replace	(Ljava/lang/CharSequence;Ljava/lang/CharSequence;)Ljava/lang/String;
    //   57: ldc_w 466
    //   60: ldc_w 468
    //   63: invokevirtual 464	java/lang/String:replace	(Ljava/lang/CharSequence;Ljava/lang/CharSequence;)Ljava/lang/String;
    //   66: astore 7
    //   68: aload 4
    //   70: ldc_w 447
    //   73: aload 7
    //   75: invokevirtual 256	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   78: pop
    //   79: getstatic 119	rvd:jdField_a_of_type_Long	J
    //   82: ldc2_w 536
    //   85: lcmp
    //   86: ifle +20 -> 106
    //   89: new 539	com/tencent/biz/pubaccount/readinjoy/video/ReadInJoyWebDataManager$3
    //   92: dup
    //   93: aload_0
    //   94: aload_1
    //   95: aload_2
    //   96: aload_3
    //   97: aload 4
    //   99: invokespecial 542	com/tencent/biz/pubaccount/readinjoy/video/ReadInJoyWebDataManager$3:<init>	(Lrvd;Ljava/net/URL;Ljava/lang/String;Ljava/lang/String;Lorg/json/JSONObject;)V
    //   102: invokestatic 546	com/tencent/mobileqq/app/ThreadManager:executeOnNetWorkThread	(Ljava/lang/Runnable;)V
    //   105: return
    //   106: aload 10
    //   108: ldc_w 470
    //   111: invokevirtual 450	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   114: astore_3
    //   115: aload_3
    //   116: invokestatic 456	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   119: ifne +423 -> 542
    //   122: aload 10
    //   124: ldc_w 488
    //   127: invokevirtual 450	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   130: astore 4
    //   132: aload 4
    //   134: invokestatic 456	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   137: ifne +405 -> 542
    //   140: aload 10
    //   142: ldc_w 532
    //   145: invokevirtual 450	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   148: astore 7
    //   150: aload 7
    //   152: invokestatic 456	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   155: ifne +387 -> 542
    //   158: aload_1
    //   159: invokevirtual 479	java/net/URL:getHost	()Ljava/lang/String;
    //   162: astore_1
    //   163: aload 10
    //   165: ldc_w 481
    //   168: invokevirtual 450	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   171: astore_2
    //   172: aload_2
    //   173: invokestatic 456	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   176: ifne +363 -> 539
    //   179: aload_0
    //   180: aload_2
    //   181: aload_1
    //   182: invokespecial 484	rvd:a	(Ljava/lang/String;Ljava/lang/String;)Z
    //   185: ifeq +357 -> 542
    //   188: aload_2
    //   189: astore_1
    //   190: aload_1
    //   191: astore_2
    //   192: aload_1
    //   193: invokestatic 456	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   196: ifeq +7 -> 203
    //   199: ldc_w 486
    //   202: astore_2
    //   203: aload_0
    //   204: aload 7
    //   206: invokespecial 547	rvd:b	(Ljava/lang/String;)Ljava/lang/String;
    //   209: astore_1
    //   210: aload_0
    //   211: aload_2
    //   212: aload_3
    //   213: aload 4
    //   215: aload_1
    //   216: invokespecial 549	rvd:a	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V
    //   219: aload_0
    //   220: aload 7
    //   222: aload_1
    //   223: invokespecial 550	rvd:a	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   226: astore 7
    //   228: new 492	java/io/File
    //   231: dup
    //   232: new 33	java/lang/StringBuilder
    //   235: dup
    //   236: invokespecial 36	java/lang/StringBuilder:<init>	()V
    //   239: getstatic 495	com/tencent/biz/pubaccount/PublicAccountJavascriptInterface:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   242: invokevirtual 42	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   245: ldc_w 497
    //   248: invokevirtual 42	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   251: aload 9
    //   253: invokevirtual 196	com/tencent/mobileqq/app/QQAppInterface:getAccount	()Ljava/lang/String;
    //   256: invokestatic 501	bgmj:b	(Ljava/lang/String;)Ljava/lang/String;
    //   259: invokevirtual 42	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   262: invokevirtual 51	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   265: invokespecial 502	java/io/File:<init>	(Ljava/lang/String;)V
    //   268: astore_1
    //   269: aload_1
    //   270: invokevirtual 505	java/io/File:exists	()Z
    //   273: ifne +153 -> 426
    //   276: aload_1
    //   277: invokevirtual 553	java/io/File:mkdirs	()Z
    //   280: pop
    //   281: new 492	java/io/File
    //   284: dup
    //   285: aload_1
    //   286: aload_2
    //   287: invokespecial 556	java/io/File:<init>	(Ljava/io/File;Ljava/lang/String;)V
    //   290: astore_1
    //   291: aload_1
    //   292: invokevirtual 505	java/io/File:exists	()Z
    //   295: ifne +151 -> 446
    //   298: aload_1
    //   299: invokevirtual 553	java/io/File:mkdirs	()Z
    //   302: pop
    //   303: new 492	java/io/File
    //   306: dup
    //   307: aload_1
    //   308: aload_3
    //   309: invokestatic 501	bgmj:b	(Ljava/lang/String;)Ljava/lang/String;
    //   312: invokespecial 556	java/io/File:<init>	(Ljava/io/File;Ljava/lang/String;)V
    //   315: astore 8
    //   317: aload 8
    //   319: invokevirtual 505	java/io/File:exists	()Z
    //   322: ifne +144 -> 466
    //   325: aload 8
    //   327: invokevirtual 553	java/io/File:mkdirs	()Z
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
    //   341: new 492	java/io/File
    //   344: dup
    //   345: aload 8
    //   347: aload 4
    //   349: invokestatic 501	bgmj:b	(Ljava/lang/String;)Ljava/lang/String;
    //   352: invokespecial 556	java/io/File:<init>	(Ljava/io/File;Ljava/lang/String;)V
    //   355: astore 4
    //   357: aload_3
    //   358: astore_2
    //   359: aload 4
    //   361: invokevirtual 505	java/io/File:exists	()Z
    //   364: ifeq +11 -> 375
    //   367: aload_3
    //   368: astore_2
    //   369: aload 4
    //   371: invokevirtual 559	java/io/File:delete	()Z
    //   374: pop
    //   375: aload_3
    //   376: astore_2
    //   377: new 561	java/io/FileWriter
    //   380: dup
    //   381: aload 4
    //   383: invokespecial 562	java/io/FileWriter:<init>	(Ljava/io/File;)V
    //   386: astore_1
    //   387: aload_1
    //   388: aload 7
    //   390: invokevirtual 565	java/io/FileWriter:write	(Ljava/lang/String;)V
    //   393: getstatic 119	rvd:jdField_a_of_type_Long	J
    //   396: lstore 5
    //   398: aload 4
    //   400: invokevirtual 516	java/io/File:length	()J
    //   403: lload 5
    //   405: ladd
    //   406: putstatic 119	rvd:jdField_a_of_type_Long	J
    //   409: aload_0
    //   410: monitorexit
    //   411: aload_1
    //   412: ifnull +130 -> 542
    //   415: aload_1
    //   416: invokevirtual 566	java/io/FileWriter:close	()V
    //   419: return
    //   420: astore_1
    //   421: aload_1
    //   422: invokevirtual 530	java/io/IOException:printStackTrace	()V
    //   425: return
    //   426: aload_1
    //   427: invokevirtual 569	java/io/File:isFile	()Z
    //   430: ifeq -149 -> 281
    //   433: aload_1
    //   434: invokevirtual 559	java/io/File:delete	()Z
    //   437: pop
    //   438: aload_1
    //   439: invokevirtual 553	java/io/File:mkdirs	()Z
    //   442: pop
    //   443: goto -162 -> 281
    //   446: aload_1
    //   447: invokevirtual 569	java/io/File:isFile	()Z
    //   450: ifeq -147 -> 303
    //   453: aload_1
    //   454: invokevirtual 559	java/io/File:delete	()Z
    //   457: pop
    //   458: aload_1
    //   459: invokevirtual 553	java/io/File:mkdirs	()Z
    //   462: pop
    //   463: goto -160 -> 303
    //   466: aload 8
    //   468: invokevirtual 569	java/io/File:isFile	()Z
    //   471: ifeq -140 -> 331
    //   474: aload 8
    //   476: invokevirtual 559	java/io/File:delete	()Z
    //   479: pop
    //   480: aload 8
    //   482: invokevirtual 553	java/io/File:mkdirs	()Z
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
    //   506: invokevirtual 566	java/io/FileWriter:close	()V
    //   509: return
    //   510: astore_1
    //   511: aload_1
    //   512: invokevirtual 530	java/io/IOException:printStackTrace	()V
    //   515: return
    //   516: astore_2
    //   517: aload_1
    //   518: ifnull +7 -> 525
    //   521: aload_1
    //   522: invokevirtual 566	java/io/FileWriter:close	()V
    //   525: aload_2
    //   526: athrow
    //   527: astore_1
    //   528: aload_1
    //   529: invokevirtual 530	java/io/IOException:printStackTrace	()V
    //   532: goto -7 -> 525
    //   535: astore_3
    //   536: goto -44 -> 492
    //   539: goto -349 -> 190
    //   542: return
    //   543: astore_1
    //   544: return
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	545	0	this	rvd
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
      if ((snh.f(paramArticleInfo)) && (paramArticleInfo.mSocialFeedInfo.jdField_a_of_type_Rgy != null))
      {
        switch ((int)paramArticleInfo.mSocialFeedInfo.jdField_a_of_type_Rgy.jdField_b_of_type_JavaLangLong.longValue())
        {
        case 11: 
        default: 
          return false;
        }
        return true;
      }
    } while ((!snh.a(paramArticleInfo)) && (!snh.h(paramArticleInfo)));
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
  
  private Long b(ArticleInfo paramArticleInfo, boolean paramBoolean)
  {
    if ((paramBoolean) && (paramArticleInfo.mSocialFeedInfo != null) && (paramArticleInfo.mSocialFeedInfo.jdField_a_of_type_Rgy != null)) {
      return paramArticleInfo.mSocialFeedInfo.jdField_a_of_type_Rgy.jdField_b_of_type_JavaLangLong;
    }
    return Long.valueOf(paramArticleInfo.mFeedType);
  }
  
  private String b()
  {
    Object localObject = (QQAppInterface)pha.a();
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
  
  private String b(String paramString)
  {
    try
    {
      MessageDigest localMessageDigest = MessageDigest.getInstance("MD5");
      localMessageDigest.update(paramString.getBytes("UTF-8"));
      paramString = bgmj.a(localMessageDigest.digest());
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
    return bkgf.b(paramString1, paramString2);
  }
  
  private void b(ArticleInfo paramArticleInfo, JSONObject paramJSONObject)
  {
    int i1 = 2;
    int i2;
    if (paramArticleInfo.mSocialFeedInfo != null)
    {
      paramJSONObject.put("timeTips", pgz.a(paramArticleInfo.mSocialFeedInfo.e, true));
      i2 = paramArticleInfo.mSocialFeedInfo.jdField_a_of_type_Int;
      switch (i2)
      {
      case 3: 
      case 4: 
      case 7: 
      case 8: 
      default: 
        paramJSONObject.put("picShowType", 1);
      }
    }
    do
    {
      return;
      if (i2 == 6) {}
      for (;;)
      {
        paramJSONObject.put("picShowType", i1);
        paramJSONObject.put("isVideo", 1);
        if (paramArticleInfo.mVideoCoverUrl != null) {
          paramJSONObject.put("picurl", paramArticleInfo.mVideoCoverUrl.toString().replace("pubaccountimage:", ""));
        }
        paramJSONObject.put("videoTimeTips", qyo.a(paramArticleInfo.mVideoDuration));
        return;
        i1 = 1;
      }
      if (i2 == 2) {}
      for (;;)
      {
        paramJSONObject.put("picShowType", i1);
        return;
        i1 = 1;
      }
      paramJSONObject.put("isMultiPic", 1);
    } while ((paramArticleInfo.mSocialFeedInfo.jdField_a_of_type_Rhn == null) || (paramArticleInfo.mSocialFeedInfo.jdField_a_of_type_Rhn.a == null) || (paramArticleInfo.mSocialFeedInfo.jdField_a_of_type_Rhn.a.size() <= 0));
    paramJSONObject.put("multiPicUrls", a(paramArticleInfo.mSocialFeedInfo.jdField_a_of_type_Rhn.a));
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
    QQAppInterface localQQAppInterface = (QQAppInterface)pha.a();
    if (localQQAppInterface == null) {}
    while (localQQAppInterface.getApp() == null) {
      return false;
    }
    if ((AppNetConnInfo.isWifiConn()) || ((AppNetConnInfo.isMobileConn()) && (AppNetConnInfo.getMobileInfo() == 3))) {}
    for (boolean bool = true;; bool = false) {
      return bool;
    }
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
  
  private String c(String paramString)
  {
    if (!TextUtils.isEmpty(paramString)) {
      try
      {
        paramString = new String(bgku.decode(paramString, 0));
        if (!TextUtils.isEmpty(paramString))
        {
          paramString = "https://q.qlogo.cn/g?b=qq&s=100&nk=" + paramString;
          return paramString;
        }
      }
      catch (Exception paramString)
      {
        return "";
      }
    }
    return "";
  }
  
  public void a(ArticleInfo paramArticleInfo, boolean paramBoolean, String paramString)
  {
    int i1 = 1;
    if ((paramArticleInfo == null) || (!a(paramArticleInfo)))
    {
      this.n = "";
      return;
    }
    Boolean localBoolean1 = Boolean.valueOf(snh.f(paramArticleInfo));
    if ((snh.a(paramArticleInfo)) || (snh.h(paramArticleInfo))) {}
    Boolean localBoolean2;
    for (boolean bool = true;; bool = false)
    {
      localBoolean2 = Boolean.valueOf(bool);
      if ((localBoolean2.booleanValue()) || (localBoolean1.booleanValue())) {
        break;
      }
      this.n = "";
      return;
    }
    for (;;)
    {
      try
      {
        JSONObject localJSONObject = new JSONObject();
        localJSONObject.put("qqheadurl", c(Uri.parse(paramString).getQueryParameter("uin")));
        localJSONObject.put("feeds_id", String.valueOf(a(paramArticleInfo, paramBoolean)));
        localJSONObject.put("feedsType", b(paramArticleInfo, paramBoolean));
        localJSONObject.put("accountID", paramArticleInfo.mSubscribeID);
        localJSONObject.put("site", paramArticleInfo.mSubscribeName);
        localJSONObject.put("isAccountDerelict", TextUtils.isEmpty(paramArticleInfo.mSubscribeID));
        localJSONObject.put("isAccountApproved", "");
        localJSONObject.put("acticleid", paramArticleInfo.mArticleID);
        localJSONObject.put("articleurl", paramArticleInfo.mArticleContentUrl);
        localJSONObject.put("articleDesc", paramArticleInfo.mSummary);
        localJSONObject.put("title", paramArticleInfo.mTitle);
        localJSONObject.put("timeTips", pgz.a(paramArticleInfo.mTime));
        if (paramArticleInfo.mSinglePicture == null) {
          break label451;
        }
        paramString = paramArticleInfo.mSinglePicture.getFile();
        localJSONObject.put("picurl", paramString);
        if (paramArticleInfo.mShowBigPicture) {
          i1 = 2;
        }
        localJSONObject.put("picShowType", i1);
        a(paramArticleInfo, localJSONObject);
        a(paramArticleInfo, localJSONObject, localBoolean2.booleanValue(), localBoolean1.booleanValue(), paramBoolean);
        b(paramArticleInfo, localJSONObject);
        if (QLog.isColorLevel()) {
          QLog.d("ReadInJoyWebDataManager", 2, "jsonRetData(), retData=" + localJSONObject.toString());
        }
        this.n = localJSONObject.toString();
        this.jdField_b_of_type_Long = Long.parseLong(localJSONObject.getString("feeds_id"));
        return;
      }
      catch (JSONException paramArticleInfo)
      {
        this.n = "";
      }
      if (!QLog.isColorLevel()) {
        break;
      }
      QLog.d("ReadInJoyWebDataManager", 2, "setSecondCommnetPageData JSONException" + paramArticleInfo.toString());
      return;
      label451:
      paramString = paramArticleInfo.mFirstPagePicUrl;
    }
  }
  
  public void a(String paramString, int paramInt)
  {
    boolean bool = true;
    if (!a(c)) {
      return;
    }
    rvg localrvg = null;
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
          localrvg = new rvg(this);
          paramString = str + "&ispreload=1";
        }
        str = c;
        if (paramInt == 1)
        {
          a("get", paramString, localJSONObject, str, localrvg, Boolean.valueOf(bool));
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
    oat.a(null, "", "0X8008221", "0X8008221", 0, 0, paramString1, paramString2, "", "", false);
  }
  
  public void a(String paramString1, String paramString2, String paramString3)
  {
    oat.a(null, "", "0X8008220", "0X8008220", 0, 0, paramString1, paramString2, paramString3, "", false);
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
  
  public void a(String paramString1, String paramString2, JSONObject paramJSONObject, String paramString3, rvi paramrvi, Boolean paramBoolean)
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
        for (paramString2 = paramString2 + "&g_tk=" + b(); "get".equals(paramString1); paramString2 = paramString2 + "?g_tk=" + b())
        {
          a(paramString2, paramJSONObject, paramString3, paramrvi);
          return;
        }
      }
    }
    QLog.w("ReadInJoyWebDataManager", 2, "httpFetchAsync mCgiLoadedMap cause mCgiLoadedMap is null ");
  }
  
  public void a(String paramString1, String paramString2, rvh paramrvh)
  {
    JSONObject localJSONObject = new JSONObject();
    if (TextUtils.isEmpty(paramString2)) {
      return;
    }
    new Thread(new ReadInJoyWebDataManager.4(this, paramString2, paramrvh, localJSONObject, paramString1)).start();
  }
  
  public void a(String paramString, JSONObject paramJSONObject)
  {
    if ((BaseApplication.getContext() == null) || (!pjl.a())) {}
    do
    {
      return;
      if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViolaViewViolaBaseView == null)
      {
        this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViolaViewViolaBaseView = new ViolaBaseView(BaseApplication.getContext());
        this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViolaViewViolaBaseView.a(jdField_a_of_type_JavaLangString, null, new tst(jdField_a_of_type_JavaLangString, new JSONObject(), null));
      }
      try
      {
        JSONObject localJSONObject = new JSONObject();
        localJSONObject.put("url", paramString);
        localJSONObject.put("param", paramJSONObject);
        paramString = new JSONObject();
        paramString.put("preloadViola", localJSONObject);
        this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViolaViewViolaBaseView.a(paramString.toString());
        return;
      }
      catch (JSONException paramString) {}
    } while (!QLog.isColorLevel());
    QLog.w("ReadInJoyWebDataManager", 2, "preLoadComCgi e " + paramString.getMessage());
  }
  
  public boolean a()
  {
    QQAppInterface localQQAppInterface = (QQAppInterface)pha.a();
    if (localQQAppInterface == null) {
      return false;
    }
    if ((b()) && (bmqa.z(localQQAppInterface))) {}
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     rvd
 * JD-Core Version:    0.7.0.1
 */