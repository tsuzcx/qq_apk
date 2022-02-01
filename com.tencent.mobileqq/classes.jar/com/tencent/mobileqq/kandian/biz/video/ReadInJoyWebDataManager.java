package com.tencent.mobileqq.kandian.biz.video;

import android.net.Uri;
import android.os.Build.VERSION;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import com.tencent.biz.pubaccount.api.IPublicAccountJavascriptInterface;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.data.CouponH5Data;
import com.tencent.mobileqq.kandian.base.utils.RIJQQAppInterfaceUtil;
import com.tencent.mobileqq.kandian.base.utils.api.IReadInJoyTimeUtils;
import com.tencent.mobileqq.kandian.biz.common.ReadInJoyHelper;
import com.tencent.mobileqq.kandian.biz.common.api.IPublicAccountReportUtils;
import com.tencent.mobileqq.kandian.glue.viola.view.ViolaBaseView;
import com.tencent.mobileqq.kandian.glue.viola.view.ViolaBaseView.ViolaCreactPageObject;
import com.tencent.mobileqq.kandian.repo.aladdin.handlers.ViolaPicSerPreloadHandler;
import com.tencent.mobileqq.kandian.repo.common.RIJItemViewTypeUtils;
import com.tencent.mobileqq.kandian.repo.feeds.RIJFeedsType;
import com.tencent.mobileqq.kandian.repo.feeds.entity.AbsBaseArticleInfo;
import com.tencent.mobileqq.kandian.repo.feeds.entity.FeedsInfoUser;
import com.tencent.mobileqq.kandian.repo.feeds.entity.PGCFeedsInfo;
import com.tencent.mobileqq.kandian.repo.feeds.entity.PGCPicInfo;
import com.tencent.mobileqq.kandian.repo.feeds.entity.SocializeFeedsInfo;
import com.tencent.mobileqq.kandian.repo.handler.BiuCommentInfo;
import com.tencent.mobileqq.kandian.repo.handler.BiuInfo;
import com.tencent.mobileqq.kandian.repo.pts.UtilsForComponent;
import com.tencent.mobileqq.msf.sdk.AppNetConnInfo;
import com.tencent.mobileqq.persistence.EntityManager;
import com.tencent.mobileqq.persistence.QQEntityManagerFactoryProxy;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.utils.Base64Util;
import com.tencent.mobileqq.utils.ContactUtils;
import com.tencent.mobileqq.utils.HexUtil;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.util.ThreeDes;
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

public class ReadInJoyWebDataManager
{
  public static int a;
  private static long jdField_a_of_type_Long;
  private static ReadInJoyWebDataManager jdField_a_of_type_ComTencentMobileqqKandianBizVideoReadInJoyWebDataManager;
  public static String a;
  public static List<String> a;
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
  private static final String k;
  private ViolaBaseView jdField_a_of_type_ComTencentMobileqqKandianGlueViolaViewViolaBaseView;
  private volatile HashMap<String, Long> jdField_a_of_type_JavaUtilHashMap = new HashMap();
  private long b;
  private String l = "";
  private String m = "";
  private String n = "";
  private String o = "";
  private String p = "";
  
  static
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("QQ/8.7.0 Android/0.17 Android/");
    localStringBuilder.append(Build.VERSION.RELEASE);
    k = localStringBuilder.toString();
    jdField_a_of_type_Int = 404;
    jdField_b_of_type_Int = 200;
    jdField_a_of_type_JavaLangString = "https://sqimg.qq.com/qq_product_operations/kan/viola_biz/viola_service/viola_service.js?v_bid=3685&_rij_violaUrl=1";
    jdField_a_of_type_JavaUtilList = new ArrayList();
    jdField_b_of_type_JavaLangString = "1";
  }
  
  public static ReadInJoyWebDataManager a()
  {
    if (jdField_a_of_type_ComTencentMobileqqKandianBizVideoReadInJoyWebDataManager == null) {
      jdField_a_of_type_ComTencentMobileqqKandianBizVideoReadInJoyWebDataManager = new ReadInJoyWebDataManager();
    }
    return jdField_a_of_type_ComTencentMobileqqKandianBizVideoReadInJoyWebDataManager;
  }
  
  private Long a(AbsBaseArticleInfo paramAbsBaseArticleInfo, boolean paramBoolean)
  {
    if ((paramBoolean) && (paramAbsBaseArticleInfo.mSocialFeedInfo != null) && (paramAbsBaseArticleInfo.mSocialFeedInfo.jdField_a_of_type_ComTencentMobileqqKandianRepoHandlerBiuInfo != null)) {
      return paramAbsBaseArticleInfo.mSocialFeedInfo.jdField_a_of_type_ComTencentMobileqqKandianRepoHandlerBiuInfo.jdField_a_of_type_JavaLangLong;
    }
    return Long.valueOf(paramAbsBaseArticleInfo.mFeedId);
  }
  
  public static String a(String paramString)
  {
    long l1 = 5381L;
    int i1 = 0;
    while (i1 < paramString.length())
    {
      l1 += (0x7FFFFFFF & l1 << 5) + paramString.charAt(i1);
      i1 += 1;
    }
    if (QLog.isColorLevel())
    {
      paramString = new StringBuilder();
      paramString.append("getCSRFToken ");
      paramString.append(l1 & 0x7FFFFFFF);
      QLog.w("ReadInJoyWebDataManager", 2, paramString.toString());
    }
    return String.valueOf(l1 & 0x7FFFFFFF);
  }
  
  private String a(String paramString1, String paramString2)
  {
    return ThreeDes.a(paramString1, paramString2);
  }
  
  private String a(String paramString1, String paramString2, String paramString3)
  {
    Object localObject2 = (QQAppInterface)RIJQQAppInterfaceUtil.a();
    Object localObject1 = null;
    if (localObject2 == null) {
      return null;
    }
    localObject2 = ((QQAppInterface)localObject2).getEntityManagerFactory(((QQAppInterface)localObject2).getAccount()).createEntityManager();
    paramString2 = (CouponH5Data)((EntityManager)localObject2).find(CouponH5Data.class, "mHost = ? AND mPath = ? AND mKey = ?", new String[] { paramString1, paramString2, paramString3 });
    ((EntityManager)localObject2).close();
    paramString1 = localObject1;
    if (paramString2 != null) {
      paramString1 = paramString2.mData;
    }
    return paramString1;
  }
  
  private JSONArray a(List<PGCPicInfo> paramList)
  {
    JSONArray localJSONArray = new JSONArray();
    Iterator localIterator = paramList.iterator();
    while (localIterator.hasNext())
    {
      PGCPicInfo localPGCPicInfo = (PGCPicInfo)localIterator.next();
      if ((localPGCPicInfo.jdField_b_of_type_JavaLangString != null) || (localPGCPicInfo.c != null))
      {
        JSONObject localJSONObject = new JSONObject();
        if (localPGCPicInfo.jdField_b_of_type_JavaLangString != null) {
          paramList = localPGCPicInfo.jdField_b_of_type_JavaLangString;
        } else {
          paramList = localPGCPicInfo.c;
        }
        localJSONObject.put("origin_url", paramList);
        if (localPGCPicInfo.c != null) {
          paramList = localPGCPicInfo.c;
        } else {
          paramList = localPGCPicInfo.jdField_b_of_type_JavaLangString;
        }
        localJSONObject.put("thumbnail_url", paramList);
        localJSONObject.put("pic_width", localPGCPicInfo.jdField_a_of_type_Int);
        localJSONObject.put("pic_height", localPGCPicInfo.jdField_b_of_type_Int);
        localJSONArray.put(localJSONObject);
      }
    }
    return localJSONArray;
  }
  
  public static void a()
  {
    synchronized (jdField_a_of_type_JavaUtilList)
    {
      Iterator localIterator = jdField_a_of_type_JavaUtilList.iterator();
      Object localObject2;
      if (QLog.isColorLevel())
      {
        localObject2 = new StringBuilder();
        ((StringBuilder)localObject2).append("addLog :TLogCache size :");
        ((StringBuilder)localObject2).append(jdField_a_of_type_JavaUtilList.size());
        QLog.w("ReadInJoyWebDataManager", 2, ((StringBuilder)localObject2).toString());
      }
      if (jdField_a_of_type_JavaUtilList.size() <= 0) {
        return;
      }
      try
      {
        localObject2 = new JSONArray();
        while (localIterator.hasNext())
        {
          JSONObject localJSONObject = new JSONObject();
          localJSONObject.put("postTime", System.currentTimeMillis() / 1000L);
          localJSONObject.put("logContent", localIterator.next());
          ((JSONArray)localObject2).put(localJSONObject);
        }
        b(((JSONArray)localObject2).toString());
      }
      catch (JSONException localJSONException)
      {
        label144:
        break label144;
      }
      jdField_a_of_type_JavaUtilList.clear();
      return;
    }
  }
  
  private void a(AbsBaseArticleInfo paramAbsBaseArticleInfo, JSONObject paramJSONObject)
  {
    if (RIJFeedsType.a(paramAbsBaseArticleInfo))
    {
      paramJSONObject.put("isVideo", 1);
      if (paramAbsBaseArticleInfo.mVideoCoverUrl != null) {
        paramJSONObject.put("picurl", paramAbsBaseArticleInfo.mVideoCoverUrl.toString());
      }
      paramJSONObject.put("videoTimeTips", UtilsForComponent.a(paramAbsBaseArticleInfo.mVideoDuration));
    }
  }
  
  private void a(AbsBaseArticleInfo paramAbsBaseArticleInfo, JSONObject paramJSONObject, boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3)
  {
    int i1;
    if ((!paramBoolean3) && (paramBoolean2) && (paramAbsBaseArticleInfo.mSocialFeedInfo != null)) {
      i1 = 1;
    } else {
      i1 = 0;
    }
    if (i1 == 0) {
      return;
    }
    Object localObject;
    if (paramAbsBaseArticleInfo.mSocialFeedInfo.jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsEntityFeedsInfoUser != null) {
      if (paramBoolean1)
      {
        if (paramAbsBaseArticleInfo.mSocialFeedInfo.jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsEntityFeedsInfoUser.jdField_a_of_type_Int == 1) {
          i1 = 1;
        } else {
          i1 = 0;
        }
        paramJSONObject.put("isAccountApproved", i1);
      }
      else if (paramBoolean2)
      {
        localObject = Long.valueOf(paramAbsBaseArticleInfo.mSocialFeedInfo.jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsEntityFeedsInfoUser.jdField_a_of_type_Long);
        paramJSONObject.put("uin", new String(Base64Util.encode(Long.toString(((Long)localObject).longValue()).getBytes(), 0)));
        paramJSONObject.put("nick", "");
        paramJSONObject.put("remark", "");
        if (RIJQQAppInterfaceUtil.a() != null)
        {
          localObject = ContactUtils.a((QQAppInterface)RIJQQAppInterfaceUtil.a(), Long.toString(((Long)localObject).longValue()), true);
          paramJSONObject.put("nick", localObject);
          paramJSONObject.put("remark", localObject);
        }
        if (paramAbsBaseArticleInfo.mSocialFeedInfo.jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsEntityFeedsInfoUser.jdField_a_of_type_Int == 1) {
          i1 = 1;
        } else {
          i1 = 0;
        }
        paramJSONObject.put("isApproved", i1);
      }
    }
    if ((paramBoolean2) && (paramAbsBaseArticleInfo.mSocialFeedInfo.jdField_a_of_type_ComTencentMobileqqKandianRepoHandlerBiuInfo != null))
    {
      paramJSONObject.put("originFeedsId", String.valueOf(paramAbsBaseArticleInfo.mSocialFeedInfo.jdField_a_of_type_ComTencentMobileqqKandianRepoHandlerBiuInfo.jdField_a_of_type_JavaLangLong));
      paramJSONObject.put("originFeedsType", paramAbsBaseArticleInfo.mSocialFeedInfo.jdField_a_of_type_ComTencentMobileqqKandianRepoHandlerBiuInfo.b);
      localObject = new JSONArray();
      paramAbsBaseArticleInfo = paramAbsBaseArticleInfo.mSocialFeedInfo.jdField_a_of_type_ComTencentMobileqqKandianRepoHandlerBiuInfo.jdField_a_of_type_JavaUtilList.iterator();
      while (paramAbsBaseArticleInfo.hasNext())
      {
        BiuCommentInfo localBiuCommentInfo = (BiuCommentInfo)paramAbsBaseArticleInfo.next();
        JSONObject localJSONObject = new JSONObject();
        localJSONObject.put("biuLevel_feeds_id", String.valueOf(localBiuCommentInfo.mFeedId));
        localJSONObject.put("biuLevel_feeds_type", localBiuCommentInfo.mFeedsType);
        localJSONObject.put("biuLevel_uin", new String(Base64Util.encode(Long.toString(localBiuCommentInfo.mUin.longValue()).getBytes(), 0)));
        localJSONObject.put("biuLevel_nick", "");
        localJSONObject.put("biuLevel_remark", "");
        if (RIJQQAppInterfaceUtil.a() != null)
        {
          String str = ContactUtils.a((QQAppInterface)RIJQQAppInterfaceUtil.a(), Long.toString(localBiuCommentInfo.mUin.longValue()), true);
          localJSONObject.put("biuLevel_nick", str);
          localJSONObject.put("biuLevel_remark", str);
        }
        localJSONObject.put("biuLevel_comment", localBiuCommentInfo.mBiuComment);
        localJSONObject.put("biuLevel_time", localBiuCommentInfo.mBiuTime);
        localJSONObject.put("op_type", localBiuCommentInfo.mOpType);
        ((JSONArray)localObject).put(localJSONObject);
      }
      paramJSONObject.put("biuLevelList", localObject);
    }
  }
  
  public static void a(String paramString)
  {
    synchronized (jdField_a_of_type_JavaUtilList)
    {
      if (ReadInJoyHelper.a() != -1L) {
        System.currentTimeMillis();
      }
      jdField_a_of_type_JavaUtilList.add(paramString);
      if (QLog.isColorLevel())
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("addLog :content :");
        localStringBuilder.append(paramString);
        QLog.w("ReadInJoyWebDataManager", 2, localStringBuilder.toString());
      }
      if (jdField_a_of_type_JavaUtilList.size() >= 20) {
        a();
      }
      return;
    }
  }
  
  /* Error */
  private void a(String paramString1, ReadInJoyWebDataManager.H5DataCallback paramH5DataCallback, JSONObject paramJSONObject, String paramString2)
  {
    // Byte code:
    //   0: invokestatic 197	com/tencent/mobileqq/kandian/base/utils/RIJQQAppInterfaceUtil:a	()Lmqq/app/AppRuntime;
    //   3: checkcast 199	com/tencent/mobileqq/app/QQAppInterface
    //   6: astore 9
    //   8: aload 9
    //   10: ifnonnull +4 -> 14
    //   13: return
    //   14: new 253	org/json/JSONObject
    //   17: dup
    //   18: aload_1
    //   19: invokespecial 458	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   22: astore 10
    //   24: aload 10
    //   26: ldc_w 460
    //   29: invokevirtual 463	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   32: astore 5
    //   34: aload 5
    //   36: astore_1
    //   37: aload 5
    //   39: invokestatic 469	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   42: ifne +24 -> 66
    //   45: aload 5
    //   47: ldc_w 471
    //   50: ldc_w 473
    //   53: invokevirtual 477	java/lang/String:replace	(Ljava/lang/CharSequence;Ljava/lang/CharSequence;)Ljava/lang/String;
    //   56: ldc_w 479
    //   59: ldc_w 481
    //   62: invokevirtual 477	java/lang/String:replace	(Ljava/lang/CharSequence;Ljava/lang/CharSequence;)Ljava/lang/String;
    //   65: astore_1
    //   66: aload_3
    //   67: ldc_w 460
    //   70: aload_1
    //   71: invokevirtual 260	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   74: pop
    //   75: aload 10
    //   77: ldc_w 483
    //   80: invokevirtual 463	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   83: astore 11
    //   85: aload 11
    //   87: invokestatic 469	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   90: ifeq +11 -> 101
    //   93: aload_2
    //   94: aload_3
    //   95: invokeinterface 488 2 0
    //   100: return
    //   101: aconst_null
    //   102: astore 7
    //   104: aconst_null
    //   105: astore 6
    //   107: aconst_null
    //   108: astore 5
    //   110: new 339	java/net/URL
    //   113: dup
    //   114: aload 4
    //   116: invokespecial 489	java/net/URL:<init>	(Ljava/lang/String;)V
    //   119: invokevirtual 492	java/net/URL:getHost	()Ljava/lang/String;
    //   122: astore 4
    //   124: goto +6 -> 130
    //   127: aconst_null
    //   128: astore 4
    //   130: aload 10
    //   132: ldc_w 494
    //   135: invokevirtual 463	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   138: astore 8
    //   140: aload 4
    //   142: astore_1
    //   143: aload 8
    //   145: invokestatic 469	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   148: ifne +28 -> 176
    //   151: aload_0
    //   152: aload 8
    //   154: aload 4
    //   156: invokespecial 497	com/tencent/mobileqq/kandian/biz/video/ReadInJoyWebDataManager:a	(Ljava/lang/String;Ljava/lang/String;)Z
    //   159: ifeq +9 -> 168
    //   162: aload 8
    //   164: astore_1
    //   165: goto +11 -> 176
    //   168: aload_2
    //   169: aload_3
    //   170: invokeinterface 488 2 0
    //   175: return
    //   176: aload_1
    //   177: astore 4
    //   179: aload_1
    //   180: invokestatic 469	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   183: ifeq +8 -> 191
    //   186: ldc_w 499
    //   189: astore 4
    //   191: aload 10
    //   193: ldc_w 501
    //   196: invokevirtual 463	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   199: astore_1
    //   200: aload_1
    //   201: invokestatic 469	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   204: ifeq +11 -> 215
    //   207: aload_2
    //   208: aload_3
    //   209: invokeinterface 488 2 0
    //   214: return
    //   215: aload_0
    //   216: aload 4
    //   218: aload 11
    //   220: aload_1
    //   221: invokespecial 503	com/tencent/mobileqq/kandian/biz/video/ReadInJoyWebDataManager:a	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   224: astore 8
    //   226: aload 8
    //   228: invokestatic 469	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   231: ifeq +11 -> 242
    //   234: aload_2
    //   235: aload_3
    //   236: invokeinterface 488 2 0
    //   241: return
    //   242: new 33	java/lang/StringBuilder
    //   245: dup
    //   246: invokespecial 36	java/lang/StringBuilder:<init>	()V
    //   249: astore 10
    //   251: aload 10
    //   253: ldc_w 505
    //   256: invokestatic 511	com/tencent/mobileqq/qroute/QRoute:api	(Ljava/lang/Class;)Lcom/tencent/mobileqq/qroute/QRouteApi;
    //   259: checkcast 505	com/tencent/biz/pubaccount/api/IPublicAccountJavascriptInterface
    //   262: invokeinterface 514 1 0
    //   267: invokevirtual 42	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   270: pop
    //   271: aload 10
    //   273: ldc_w 516
    //   276: invokevirtual 42	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   279: pop
    //   280: aload 10
    //   282: aload 9
    //   284: invokevirtual 202	com/tencent/mobileqq/app/QQAppInterface:getAccount	()Ljava/lang/String;
    //   287: invokestatic 521	com/tencent/mobileqq/utils/HexUtil:String2HexString	(Ljava/lang/String;)Ljava/lang/String;
    //   290: invokevirtual 42	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   293: pop
    //   294: aload 10
    //   296: ldc_w 516
    //   299: invokevirtual 42	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   302: pop
    //   303: aload 10
    //   305: aload 4
    //   307: invokevirtual 42	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   310: pop
    //   311: aload 10
    //   313: ldc_w 516
    //   316: invokevirtual 42	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   319: pop
    //   320: aload 10
    //   322: aload 11
    //   324: invokestatic 521	com/tencent/mobileqq/utils/HexUtil:String2HexString	(Ljava/lang/String;)Ljava/lang/String;
    //   327: invokevirtual 42	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   330: pop
    //   331: aload 10
    //   333: ldc_w 516
    //   336: invokevirtual 42	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   339: pop
    //   340: aload 10
    //   342: aload_1
    //   343: invokestatic 521	com/tencent/mobileqq/utils/HexUtil:String2HexString	(Ljava/lang/String;)Ljava/lang/String;
    //   346: invokevirtual 42	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   349: pop
    //   350: new 523	java/io/File
    //   353: dup
    //   354: aload 10
    //   356: invokevirtual 51	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   359: invokespecial 524	java/io/File:<init>	(Ljava/lang/String;)V
    //   362: astore 9
    //   364: aload 9
    //   366: invokevirtual 527	java/io/File:exists	()Z
    //   369: ifne +22 -> 391
    //   372: aload_3
    //   373: ldc_w 529
    //   376: ldc_w 531
    //   379: invokevirtual 260	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   382: pop
    //   383: aload_2
    //   384: aload_3
    //   385: invokeinterface 488 2 0
    //   390: return
    //   391: aload 7
    //   393: astore 4
    //   395: aload 6
    //   397: astore_1
    //   398: aload_0
    //   399: monitorenter
    //   400: aload 5
    //   402: astore 4
    //   404: new 533	java/io/FileInputStream
    //   407: dup
    //   408: aload 9
    //   410: invokespecial 536	java/io/FileInputStream:<init>	(Ljava/io/File;)V
    //   413: astore_1
    //   414: aload 9
    //   416: invokevirtual 538	java/io/File:length	()J
    //   419: l2i
    //   420: newarray byte
    //   422: astore 4
    //   424: aload_1
    //   425: aload 4
    //   427: invokevirtual 544	java/io/InputStream:read	([B)I
    //   430: pop
    //   431: aload_0
    //   432: new 156	java/lang/String
    //   435: dup
    //   436: aload 4
    //   438: invokespecial 380	java/lang/String:<init>	([B)V
    //   441: aload 8
    //   443: invokespecial 546	com/tencent/mobileqq/kandian/biz/video/ReadInJoyWebDataManager:b	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   446: astore 4
    //   448: aload 4
    //   450: ifnonnull +34 -> 484
    //   453: aload_3
    //   454: ldc_w 529
    //   457: ldc_w 548
    //   460: invokevirtual 260	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   463: pop
    //   464: aload_2
    //   465: aload_3
    //   466: invokeinterface 488 2 0
    //   471: aload_0
    //   472: monitorexit
    //   473: aload_1
    //   474: invokevirtual 549	java/io/InputStream:close	()V
    //   477: return
    //   478: astore_1
    //   479: aload_1
    //   480: invokevirtual 552	java/io/IOException:printStackTrace	()V
    //   483: return
    //   484: aload_3
    //   485: ldc_w 554
    //   488: aload 4
    //   490: ldc_w 471
    //   493: ldc_w 473
    //   496: invokevirtual 477	java/lang/String:replace	(Ljava/lang/CharSequence;Ljava/lang/CharSequence;)Ljava/lang/String;
    //   499: ldc_w 479
    //   502: ldc_w 481
    //   505: invokevirtual 477	java/lang/String:replace	(Ljava/lang/CharSequence;Ljava/lang/CharSequence;)Ljava/lang/String;
    //   508: invokevirtual 260	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   511: pop
    //   512: aload_2
    //   513: aload_3
    //   514: invokeinterface 488 2 0
    //   519: aload_0
    //   520: monitorexit
    //   521: aload_1
    //   522: invokevirtual 549	java/io/InputStream:close	()V
    //   525: return
    //   526: astore_1
    //   527: aload_1
    //   528: invokevirtual 552	java/io/IOException:printStackTrace	()V
    //   531: return
    //   532: astore 5
    //   534: goto +8 -> 542
    //   537: astore 5
    //   539: aload 4
    //   541: astore_1
    //   542: aload_1
    //   543: astore 4
    //   545: aload_0
    //   546: monitorexit
    //   547: aload_1
    //   548: astore 4
    //   550: aload 5
    //   552: athrow
    //   553: astore_1
    //   554: goto +42 -> 596
    //   557: aload_1
    //   558: astore 4
    //   560: aload_3
    //   561: ldc_w 529
    //   564: ldc_w 556
    //   567: invokevirtual 260	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   570: pop
    //   571: aload_1
    //   572: astore 4
    //   574: aload_2
    //   575: aload_3
    //   576: invokeinterface 488 2 0
    //   581: aload_1
    //   582: ifnull +43 -> 625
    //   585: aload_1
    //   586: invokevirtual 549	java/io/InputStream:close	()V
    //   589: return
    //   590: astore_1
    //   591: aload_1
    //   592: invokevirtual 552	java/io/IOException:printStackTrace	()V
    //   595: return
    //   596: aload 4
    //   598: ifnull +18 -> 616
    //   601: aload 4
    //   603: invokevirtual 549	java/io/InputStream:close	()V
    //   606: goto +10 -> 616
    //   609: astore 4
    //   611: aload 4
    //   613: invokevirtual 552	java/io/IOException:printStackTrace	()V
    //   616: aload_1
    //   617: athrow
    //   618: aload_2
    //   619: aload_3
    //   620: invokeinterface 488 2 0
    //   625: return
    //   626: astore_1
    //   627: goto -9 -> 618
    //   630: astore_1
    //   631: goto -504 -> 127
    //   634: astore 4
    //   636: goto -79 -> 557
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	639	0	this	ReadInJoyWebDataManager
    //   0	639	1	paramString1	String
    //   0	639	2	paramH5DataCallback	ReadInJoyWebDataManager.H5DataCallback
    //   0	639	3	paramJSONObject	JSONObject
    //   0	639	4	paramString2	String
    //   32	369	5	str1	String
    //   532	1	5	localObject1	Object
    //   537	14	5	localObject2	Object
    //   105	291	6	localObject3	Object
    //   102	290	7	localObject4	Object
    //   138	304	8	str2	String
    //   6	409	9	localObject5	Object
    //   22	333	10	localObject6	Object
    //   83	240	11	str3	String
    // Exception table:
    //   from	to	target	type
    //   473	477	478	java/io/IOException
    //   521	525	526	java/io/IOException
    //   414	448	532	finally
    //   453	473	532	finally
    //   484	521	532	finally
    //   404	414	537	finally
    //   545	547	537	finally
    //   398	400	553	finally
    //   550	553	553	finally
    //   560	571	553	finally
    //   574	581	553	finally
    //   585	589	590	java/io/IOException
    //   601	606	609	java/io/IOException
    //   0	8	626	org/json/JSONException
    //   14	34	626	org/json/JSONException
    //   37	66	626	org/json/JSONException
    //   66	100	626	org/json/JSONException
    //   110	124	626	org/json/JSONException
    //   130	140	626	org/json/JSONException
    //   143	162	626	org/json/JSONException
    //   168	175	626	org/json/JSONException
    //   179	186	626	org/json/JSONException
    //   191	214	626	org/json/JSONException
    //   215	241	626	org/json/JSONException
    //   242	390	626	org/json/JSONException
    //   473	477	626	org/json/JSONException
    //   479	483	626	org/json/JSONException
    //   521	525	626	org/json/JSONException
    //   527	531	626	org/json/JSONException
    //   585	589	626	org/json/JSONException
    //   591	595	626	org/json/JSONException
    //   601	606	626	org/json/JSONException
    //   611	616	626	org/json/JSONException
    //   616	618	626	org/json/JSONException
    //   110	124	630	java/net/MalformedURLException
    //   398	400	634	java/io/IOException
    //   550	553	634	java/io/IOException
  }
  
  private void a(String paramString1, String paramString2, String paramString3, String paramString4)
  {
    Object localObject = (QQAppInterface)RIJQQAppInterfaceUtil.a();
    if (localObject == null) {
      return;
    }
    localObject = ((QQAppInterface)localObject).getEntityManagerFactory(((QQAppInterface)localObject).getAccount()).createEntityManager();
    CouponH5Data localCouponH5Data = (CouponH5Data)((EntityManager)localObject).find(CouponH5Data.class, "mHost = ? AND mPath = ? AND mKey = ?", new String[] { paramString1, paramString2, paramString3 });
    if (localCouponH5Data == null)
    {
      ((EntityManager)localObject).persist(new CouponH5Data(paramString1, paramString2, paramString3, paramString4));
    }
    else
    {
      localCouponH5Data.mData = paramString4;
      ((EntityManager)localObject).update(localCouponH5Data);
    }
    ((EntityManager)localObject).close();
  }
  
  private void a(String paramString1, JSONObject paramJSONObject, String paramString2, ReadInJoyWebDataManager.HttpFetchBizCallback paramHttpFetchBizCallback)
  {
    ThreadManager.post(new ReadInJoyWebDataManager.5(this, paramString1, paramString2, paramHttpFetchBizCallback, paramJSONObject), 5, null, true);
  }
  
  /* Error */
  private void a(URL paramURL, String paramString1, String paramString2, JSONObject paramJSONObject)
  {
    // Byte code:
    //   0: invokestatic 197	com/tencent/mobileqq/kandian/base/utils/RIJQQAppInterfaceUtil:a	()Lmqq/app/AppRuntime;
    //   3: checkcast 199	com/tencent/mobileqq/app/QQAppInterface
    //   6: astore 7
    //   8: aload 7
    //   10: ifnonnull +4 -> 14
    //   13: return
    //   14: new 253	org/json/JSONObject
    //   17: dup
    //   18: aload_2
    //   19: invokespecial 458	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   22: astore 8
    //   24: aload 8
    //   26: ldc_w 460
    //   29: invokevirtual 463	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   32: astore 6
    //   34: aload 6
    //   36: astore 5
    //   38: aload 6
    //   40: invokestatic 469	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   43: ifne +25 -> 68
    //   46: aload 6
    //   48: ldc_w 471
    //   51: ldc_w 473
    //   54: invokevirtual 477	java/lang/String:replace	(Ljava/lang/CharSequence;Ljava/lang/CharSequence;)Ljava/lang/String;
    //   57: ldc_w 479
    //   60: ldc_w 481
    //   63: invokevirtual 477	java/lang/String:replace	(Ljava/lang/CharSequence;Ljava/lang/CharSequence;)Ljava/lang/String;
    //   66: astore 5
    //   68: aload 4
    //   70: ldc_w 460
    //   73: aload 5
    //   75: invokevirtual 260	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   78: pop
    //   79: getstatic 119	com/tencent/mobileqq/kandian/biz/video/ReadInJoyWebDataManager:jdField_a_of_type_Long	J
    //   82: ldc2_w 580
    //   85: lcmp
    //   86: ifle +20 -> 106
    //   89: new 583	com/tencent/mobileqq/kandian/biz/video/ReadInJoyWebDataManager$3
    //   92: dup
    //   93: aload_0
    //   94: aload_1
    //   95: aload_2
    //   96: aload_3
    //   97: aload 4
    //   99: invokespecial 585	com/tencent/mobileqq/kandian/biz/video/ReadInJoyWebDataManager$3:<init>	(Lcom/tencent/mobileqq/kandian/biz/video/ReadInJoyWebDataManager;Ljava/net/URL;Ljava/lang/String;Ljava/lang/String;Lorg/json/JSONObject;)V
    //   102: invokestatic 589	com/tencent/mobileqq/app/ThreadManager:executeOnNetWorkThread	(Ljava/lang/Runnable;)V
    //   105: return
    //   106: aload 8
    //   108: ldc_w 483
    //   111: invokevirtual 463	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   114: astore_3
    //   115: aload_3
    //   116: invokestatic 469	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   119: ifeq +4 -> 123
    //   122: return
    //   123: aload 8
    //   125: ldc_w 501
    //   128: invokevirtual 463	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   131: astore 4
    //   133: aload 4
    //   135: invokestatic 469	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   138: ifeq +4 -> 142
    //   141: return
    //   142: aload 8
    //   144: ldc_w 554
    //   147: invokevirtual 463	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   150: astore 5
    //   152: aload 5
    //   154: invokestatic 469	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   157: ifeq +4 -> 161
    //   160: return
    //   161: aload_1
    //   162: invokevirtual 492	java/net/URL:getHost	()Ljava/lang/String;
    //   165: astore_1
    //   166: aload 8
    //   168: ldc_w 494
    //   171: invokevirtual 463	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   174: astore_2
    //   175: aload_2
    //   176: invokestatic 469	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   179: ifne +377 -> 556
    //   182: aload_0
    //   183: aload_2
    //   184: aload_1
    //   185: invokespecial 497	com/tencent/mobileqq/kandian/biz/video/ReadInJoyWebDataManager:a	(Ljava/lang/String;Ljava/lang/String;)Z
    //   188: ifeq +367 -> 555
    //   191: aload_2
    //   192: astore_1
    //   193: goto +3 -> 196
    //   196: aload_1
    //   197: astore_2
    //   198: aload_1
    //   199: invokestatic 469	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   202: ifeq +7 -> 209
    //   205: ldc_w 499
    //   208: astore_2
    //   209: aload_0
    //   210: aload 5
    //   212: invokespecial 591	com/tencent/mobileqq/kandian/biz/video/ReadInJoyWebDataManager:b	(Ljava/lang/String;)Ljava/lang/String;
    //   215: astore_1
    //   216: aload_0
    //   217: aload_2
    //   218: aload_3
    //   219: aload 4
    //   221: aload_1
    //   222: invokespecial 593	com/tencent/mobileqq/kandian/biz/video/ReadInJoyWebDataManager:a	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V
    //   225: aload_0
    //   226: aload 5
    //   228: aload_1
    //   229: invokespecial 594	com/tencent/mobileqq/kandian/biz/video/ReadInJoyWebDataManager:a	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   232: astore 5
    //   234: new 33	java/lang/StringBuilder
    //   237: dup
    //   238: invokespecial 36	java/lang/StringBuilder:<init>	()V
    //   241: astore_1
    //   242: aload_1
    //   243: ldc_w 505
    //   246: invokestatic 511	com/tencent/mobileqq/qroute/QRoute:api	(Ljava/lang/Class;)Lcom/tencent/mobileqq/qroute/QRouteApi;
    //   249: checkcast 505	com/tencent/biz/pubaccount/api/IPublicAccountJavascriptInterface
    //   252: invokeinterface 514 1 0
    //   257: invokevirtual 42	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   260: pop
    //   261: aload_1
    //   262: ldc_w 516
    //   265: invokevirtual 42	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   268: pop
    //   269: aload_1
    //   270: aload 7
    //   272: invokevirtual 202	com/tencent/mobileqq/app/QQAppInterface:getAccount	()Ljava/lang/String;
    //   275: invokestatic 521	com/tencent/mobileqq/utils/HexUtil:String2HexString	(Ljava/lang/String;)Ljava/lang/String;
    //   278: invokevirtual 42	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   281: pop
    //   282: new 523	java/io/File
    //   285: dup
    //   286: aload_1
    //   287: invokevirtual 51	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   290: invokespecial 524	java/io/File:<init>	(Ljava/lang/String;)V
    //   293: astore_1
    //   294: aload_1
    //   295: invokevirtual 527	java/io/File:exists	()Z
    //   298: ifne +11 -> 309
    //   301: aload_1
    //   302: invokevirtual 597	java/io/File:mkdirs	()Z
    //   305: pop
    //   306: goto +20 -> 326
    //   309: aload_1
    //   310: invokevirtual 600	java/io/File:isFile	()Z
    //   313: ifeq +13 -> 326
    //   316: aload_1
    //   317: invokevirtual 603	java/io/File:delete	()Z
    //   320: pop
    //   321: aload_1
    //   322: invokevirtual 597	java/io/File:mkdirs	()Z
    //   325: pop
    //   326: new 523	java/io/File
    //   329: dup
    //   330: aload_1
    //   331: aload_2
    //   332: invokespecial 606	java/io/File:<init>	(Ljava/io/File;Ljava/lang/String;)V
    //   335: astore_1
    //   336: aload_1
    //   337: invokevirtual 527	java/io/File:exists	()Z
    //   340: ifne +11 -> 351
    //   343: aload_1
    //   344: invokevirtual 597	java/io/File:mkdirs	()Z
    //   347: pop
    //   348: goto +20 -> 368
    //   351: aload_1
    //   352: invokevirtual 600	java/io/File:isFile	()Z
    //   355: ifeq +13 -> 368
    //   358: aload_1
    //   359: invokevirtual 603	java/io/File:delete	()Z
    //   362: pop
    //   363: aload_1
    //   364: invokevirtual 597	java/io/File:mkdirs	()Z
    //   367: pop
    //   368: new 523	java/io/File
    //   371: dup
    //   372: aload_1
    //   373: aload_3
    //   374: invokestatic 521	com/tencent/mobileqq/utils/HexUtil:String2HexString	(Ljava/lang/String;)Ljava/lang/String;
    //   377: invokespecial 606	java/io/File:<init>	(Ljava/io/File;Ljava/lang/String;)V
    //   380: astore 6
    //   382: aload 6
    //   384: invokevirtual 527	java/io/File:exists	()Z
    //   387: ifne +12 -> 399
    //   390: aload 6
    //   392: invokevirtual 597	java/io/File:mkdirs	()Z
    //   395: pop
    //   396: goto +23 -> 419
    //   399: aload 6
    //   401: invokevirtual 600	java/io/File:isFile	()Z
    //   404: ifeq +15 -> 419
    //   407: aload 6
    //   409: invokevirtual 603	java/io/File:delete	()Z
    //   412: pop
    //   413: aload 6
    //   415: invokevirtual 597	java/io/File:mkdirs	()Z
    //   418: pop
    //   419: aconst_null
    //   420: astore_2
    //   421: aconst_null
    //   422: astore_1
    //   423: aconst_null
    //   424: astore_3
    //   425: aload_0
    //   426: monitorenter
    //   427: aload_3
    //   428: astore_2
    //   429: new 523	java/io/File
    //   432: dup
    //   433: aload 6
    //   435: aload 4
    //   437: invokestatic 521	com/tencent/mobileqq/utils/HexUtil:String2HexString	(Ljava/lang/String;)Ljava/lang/String;
    //   440: invokespecial 606	java/io/File:<init>	(Ljava/io/File;Ljava/lang/String;)V
    //   443: astore 4
    //   445: aload_3
    //   446: astore_2
    //   447: aload 4
    //   449: invokevirtual 527	java/io/File:exists	()Z
    //   452: ifeq +11 -> 463
    //   455: aload_3
    //   456: astore_2
    //   457: aload 4
    //   459: invokevirtual 603	java/io/File:delete	()Z
    //   462: pop
    //   463: aload_3
    //   464: astore_2
    //   465: new 608	java/io/FileWriter
    //   468: dup
    //   469: aload 4
    //   471: invokespecial 609	java/io/FileWriter:<init>	(Ljava/io/File;)V
    //   474: astore_1
    //   475: aload_1
    //   476: aload 5
    //   478: invokevirtual 612	java/io/FileWriter:write	(Ljava/lang/String;)V
    //   481: getstatic 119	com/tencent/mobileqq/kandian/biz/video/ReadInJoyWebDataManager:jdField_a_of_type_Long	J
    //   484: aload 4
    //   486: invokevirtual 538	java/io/File:length	()J
    //   489: ladd
    //   490: putstatic 119	com/tencent/mobileqq/kandian/biz/video/ReadInJoyWebDataManager:jdField_a_of_type_Long	J
    //   493: aload_0
    //   494: monitorexit
    //   495: aload_1
    //   496: invokevirtual 613	java/io/FileWriter:close	()V
    //   499: return
    //   500: astore_1
    //   501: aload_1
    //   502: invokevirtual 552	java/io/IOException:printStackTrace	()V
    //   505: return
    //   506: astore_3
    //   507: goto +6 -> 513
    //   510: astore_3
    //   511: aload_2
    //   512: astore_1
    //   513: aload_1
    //   514: astore_2
    //   515: aload_0
    //   516: monitorexit
    //   517: aload_1
    //   518: astore_2
    //   519: aload_3
    //   520: athrow
    //   521: astore_1
    //   522: aload_2
    //   523: ifnull +15 -> 538
    //   526: aload_2
    //   527: invokevirtual 613	java/io/FileWriter:close	()V
    //   530: goto +8 -> 538
    //   533: astore_2
    //   534: aload_2
    //   535: invokevirtual 552	java/io/IOException:printStackTrace	()V
    //   538: aload_1
    //   539: athrow
    //   540: aload_1
    //   541: ifnull +7 -> 548
    //   544: aload_1
    //   545: invokevirtual 613	java/io/FileWriter:close	()V
    //   548: return
    //   549: astore_1
    //   550: return
    //   551: astore_2
    //   552: goto -12 -> 540
    //   555: return
    //   556: goto -360 -> 196
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	559	0	this	ReadInJoyWebDataManager
    //   0	559	1	paramURL	URL
    //   0	559	2	paramString1	String
    //   0	559	3	paramString2	String
    //   0	559	4	paramJSONObject	JSONObject
    //   36	441	5	localObject1	Object
    //   32	402	6	localObject2	Object
    //   6	265	7	localQQAppInterface	QQAppInterface
    //   22	145	8	localJSONObject	JSONObject
    // Exception table:
    //   from	to	target	type
    //   495	499	500	java/io/IOException
    //   544	548	500	java/io/IOException
    //   475	495	506	finally
    //   429	445	510	finally
    //   447	455	510	finally
    //   457	463	510	finally
    //   465	475	510	finally
    //   515	517	510	finally
    //   425	427	521	finally
    //   519	521	521	finally
    //   526	530	533	java/io/IOException
    //   0	8	549	org/json/JSONException
    //   14	34	549	org/json/JSONException
    //   38	68	549	org/json/JSONException
    //   68	105	549	org/json/JSONException
    //   106	122	549	org/json/JSONException
    //   123	141	549	org/json/JSONException
    //   142	160	549	org/json/JSONException
    //   161	191	549	org/json/JSONException
    //   198	205	549	org/json/JSONException
    //   209	306	549	org/json/JSONException
    //   309	326	549	org/json/JSONException
    //   326	348	549	org/json/JSONException
    //   351	368	549	org/json/JSONException
    //   368	396	549	org/json/JSONException
    //   399	419	549	org/json/JSONException
    //   495	499	549	org/json/JSONException
    //   501	505	549	org/json/JSONException
    //   526	530	549	org/json/JSONException
    //   534	538	549	org/json/JSONException
    //   538	540	549	org/json/JSONException
    //   544	548	549	org/json/JSONException
    //   425	427	551	java/io/IOException
    //   519	521	551	java/io/IOException
  }
  
  public static boolean a(AbsBaseArticleInfo paramAbsBaseArticleInfo)
  {
    boolean bool = false;
    if (paramAbsBaseArticleInfo == null) {
      return false;
    }
    if ((RIJItemViewTypeUtils.e(paramAbsBaseArticleInfo)) && (paramAbsBaseArticleInfo.mSocialFeedInfo.jdField_a_of_type_ComTencentMobileqqKandianRepoHandlerBiuInfo != null))
    {
      switch ((int)paramAbsBaseArticleInfo.mSocialFeedInfo.jdField_a_of_type_ComTencentMobileqqKandianRepoHandlerBiuInfo.b.longValue())
      {
      case 11: 
      default: 
        return false;
      }
      return true;
    }
    if ((RIJItemViewTypeUtils.a(paramAbsBaseArticleInfo)) || (RIJItemViewTypeUtils.g(paramAbsBaseArticleInfo))) {
      bool = true;
    }
    return bool;
  }
  
  private boolean a(String paramString1, String paramString2)
  {
    boolean bool2 = false;
    if (paramString2 == null) {
      return false;
    }
    boolean bool1;
    if (!paramString2.equals(paramString1))
    {
      bool1 = bool2;
      if (paramString1.indexOf("") > 0)
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("");
        localStringBuilder.append(paramString1);
        bool1 = bool2;
        if (!paramString2.endsWith(localStringBuilder.toString())) {}
      }
    }
    else
    {
      bool1 = true;
    }
    return bool1;
  }
  
  private Long b(AbsBaseArticleInfo paramAbsBaseArticleInfo, boolean paramBoolean)
  {
    if ((paramBoolean) && (paramAbsBaseArticleInfo.mSocialFeedInfo != null) && (paramAbsBaseArticleInfo.mSocialFeedInfo.jdField_a_of_type_ComTencentMobileqqKandianRepoHandlerBiuInfo != null)) {
      return paramAbsBaseArticleInfo.mSocialFeedInfo.jdField_a_of_type_ComTencentMobileqqKandianRepoHandlerBiuInfo.b;
    }
    return Long.valueOf(paramAbsBaseArticleInfo.mFeedType);
  }
  
  private String b()
  {
    Object localObject = (QQAppInterface)RIJQQAppInterfaceUtil.a();
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
      l1 += (0x7FFFFFFF & l1 << 5) + ((String)localObject).charAt(i1);
      i1 += 1;
    }
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("getCSRFToken ");
      ((StringBuilder)localObject).append(l1 & 0x7FFFFFFF);
      QLog.w("ReadInJoyWebDataManager", 2, ((StringBuilder)localObject).toString());
    }
    return String.valueOf(l1 & 0x7FFFFFFF);
  }
  
  private String b(String paramString)
  {
    try
    {
      MessageDigest localMessageDigest = MessageDigest.getInstance("MD5");
      localMessageDigest.update(paramString.getBytes("UTF-8"));
      paramString = HexUtil.bytes2HexStr(localMessageDigest.digest());
      localMessageDigest.reset();
      return paramString;
    }
    catch (NoSuchAlgorithmException|UnsupportedEncodingException paramString)
    {
      label32:
      break label32;
    }
    return "wronghash";
  }
  
  private String b(String paramString1, String paramString2)
  {
    return ThreeDes.b(paramString1, paramString2);
  }
  
  private void b(AbsBaseArticleInfo paramAbsBaseArticleInfo, JSONObject paramJSONObject)
  {
    if (paramAbsBaseArticleInfo.mSocialFeedInfo != null)
    {
      paramJSONObject.put("timeTips", ((IReadInJoyTimeUtils)QRoute.api(IReadInJoyTimeUtils.class)).getRelativeDisplayForTime(paramAbsBaseArticleInfo.mSocialFeedInfo.e, true));
      int i2 = paramAbsBaseArticleInfo.mSocialFeedInfo.jdField_a_of_type_Int;
      int i1 = 2;
      if ((i2 != 1) && (i2 != 2))
      {
        if ((i2 != 5) && (i2 != 6))
        {
          if (i2 != 9)
          {
            paramJSONObject.put("picShowType", 1);
            return;
          }
          paramJSONObject.put("isMultiPic", 1);
          if ((paramAbsBaseArticleInfo.mSocialFeedInfo.jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsEntityPGCFeedsInfo != null) && (paramAbsBaseArticleInfo.mSocialFeedInfo.jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsEntityPGCFeedsInfo.a != null) && (paramAbsBaseArticleInfo.mSocialFeedInfo.jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsEntityPGCFeedsInfo.a.size() > 0)) {
            paramJSONObject.put("multiPicUrls", a(paramAbsBaseArticleInfo.mSocialFeedInfo.jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsEntityPGCFeedsInfo.a));
          }
        }
        else
        {
          if (i2 != 6) {
            i1 = 1;
          }
          paramJSONObject.put("picShowType", i1);
          paramJSONObject.put("isVideo", 1);
          if (paramAbsBaseArticleInfo.mVideoCoverUrl != null) {
            paramJSONObject.put("picurl", paramAbsBaseArticleInfo.mVideoCoverUrl.toString().replace("pubaccountimage:", ""));
          }
          paramJSONObject.put("videoTimeTips", UtilsForComponent.a(paramAbsBaseArticleInfo.mVideoDuration));
        }
      }
      else
      {
        if (i2 != 2) {
          i1 = 1;
        }
        paramJSONObject.put("picShowType", i1);
      }
    }
  }
  
  public static void b(String paramString)
  {
    AppRuntime localAppRuntime = RIJQQAppInterfaceUtil.a();
    if (localAppRuntime == null) {
      return;
    }
    ThreadManager.post(new ReadInJoyWebDataManager.6(localAppRuntime, paramString), 5, null, true);
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
    QQAppInterface localQQAppInterface = (QQAppInterface)RIJQQAppInterfaceUtil.a();
    boolean bool2 = false;
    if (localQQAppInterface == null) {
      return false;
    }
    if (localQQAppInterface.getApp() == null) {
      return false;
    }
    boolean bool1;
    if (!AppNetConnInfo.isWifiConn())
    {
      bool1 = bool2;
      if (AppNetConnInfo.isMobileConn())
      {
        bool1 = bool2;
        if (AppNetConnInfo.getMobileInfo() != 3) {}
      }
    }
    else
    {
      bool1 = true;
    }
    return bool1;
  }
  
  private static long c()
  {
    Object localObject = new File(((IPublicAccountJavascriptInterface)QRoute.api(IPublicAccountJavascriptInterface.class)).getDataPath());
    boolean bool = ((File)localObject).exists();
    long l1 = 0L;
    if (!bool) {
      return 0L;
    }
    ArrayList localArrayList = new ArrayList();
    localArrayList.add(localObject);
    while (!localArrayList.isEmpty())
    {
      int i1 = 0;
      localObject = (File)localArrayList.remove(0);
      if (((File)localObject).isFile())
      {
        l1 += ((File)localObject).length();
      }
      else
      {
        localObject = ((File)localObject).listFiles();
        if (localObject != null)
        {
          int i2 = localObject.length;
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
    if (!TextUtils.isEmpty(paramString)) {}
    try
    {
      paramString = new String(Base64Util.decode(paramString, 0));
      if (!TextUtils.isEmpty(paramString))
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("https://q.qlogo.cn/g?b=qq&s=100&nk=");
        localStringBuilder.append(paramString);
        paramString = localStringBuilder.toString();
        return paramString;
      }
      return "";
    }
    catch (Exception paramString) {}
    return "";
  }
  
  public void a(AbsBaseArticleInfo paramAbsBaseArticleInfo, boolean paramBoolean, String paramString)
  {
    if ((paramAbsBaseArticleInfo != null) && (a(paramAbsBaseArticleInfo)))
    {
      Boolean localBoolean1 = Boolean.valueOf(RIJItemViewTypeUtils.e(paramAbsBaseArticleInfo));
      boolean bool = RIJItemViewTypeUtils.a(paramAbsBaseArticleInfo);
      int i1 = 1;
      if ((!bool) && (!RIJItemViewTypeUtils.g(paramAbsBaseArticleInfo))) {
        bool = false;
      } else {
        bool = true;
      }
      Boolean localBoolean2 = Boolean.valueOf(bool);
      if ((!localBoolean2.booleanValue()) && (!localBoolean1.booleanValue()))
      {
        this.n = "";
        return;
      }
      try
      {
        JSONObject localJSONObject = new JSONObject();
        localJSONObject.put("qqheadurl", c(Uri.parse(paramString).getQueryParameter("uin")));
        localJSONObject.put("feeds_id", String.valueOf(a(paramAbsBaseArticleInfo, paramBoolean)));
        localJSONObject.put("feedsType", b(paramAbsBaseArticleInfo, paramBoolean));
        localJSONObject.put("accountID", paramAbsBaseArticleInfo.mSubscribeID);
        localJSONObject.put("site", paramAbsBaseArticleInfo.mSubscribeName);
        localJSONObject.put("isAccountDerelict", TextUtils.isEmpty(paramAbsBaseArticleInfo.mSubscribeID));
        localJSONObject.put("isAccountApproved", "");
        localJSONObject.put("acticleid", paramAbsBaseArticleInfo.mArticleID);
        localJSONObject.put("articleurl", paramAbsBaseArticleInfo.mArticleContentUrl);
        localJSONObject.put("articleDesc", paramAbsBaseArticleInfo.mSummary);
        localJSONObject.put("title", paramAbsBaseArticleInfo.mTitle);
        localJSONObject.put("timeTips", ((IReadInJoyTimeUtils)QRoute.api(IReadInJoyTimeUtils.class)).getDateTimeString(paramAbsBaseArticleInfo.mTime));
        if (paramAbsBaseArticleInfo.mSinglePicture != null) {
          paramString = paramAbsBaseArticleInfo.mSinglePicture.getFile();
        } else {
          paramString = paramAbsBaseArticleInfo.mFirstPagePicUrl;
        }
        localJSONObject.put("picurl", paramString);
        if (paramAbsBaseArticleInfo.mShowBigPicture) {
          i1 = 2;
        }
        localJSONObject.put("picShowType", i1);
        a(paramAbsBaseArticleInfo, localJSONObject);
        a(paramAbsBaseArticleInfo, localJSONObject, localBoolean2.booleanValue(), localBoolean1.booleanValue(), paramBoolean);
        b(paramAbsBaseArticleInfo, localJSONObject);
        if (QLog.isColorLevel())
        {
          paramAbsBaseArticleInfo = new StringBuilder();
          paramAbsBaseArticleInfo.append("jsonRetData(), retData=");
          paramAbsBaseArticleInfo.append(localJSONObject.toString());
          QLog.d("ReadInJoyWebDataManager", 2, paramAbsBaseArticleInfo.toString());
        }
        this.n = localJSONObject.toString();
        this.jdField_b_of_type_Long = Long.parseLong(localJSONObject.getString("feeds_id"));
        return;
      }
      catch (JSONException paramAbsBaseArticleInfo)
      {
        this.n = "";
        if (QLog.isColorLevel())
        {
          paramString = new StringBuilder();
          paramString.append("setSecondCommnetPageData JSONException");
          paramString.append(paramAbsBaseArticleInfo.toString());
          QLog.d("ReadInJoyWebDataManager", 2, paramString.toString());
        }
        return;
      }
    }
    this.n = "";
  }
  
  public void a(String paramString, int paramInt)
  {
    if (!a(c)) {
      return;
    }
    ReadInJoyWebDataManager.7 local7 = null;
    for (;;)
    {
      try
      {
        String str = Integer.toString(paramInt);
        JSONObject localJSONObject = new JSONObject();
        localJSONObject.put("callid", "0");
        localJSONObject.put("host", "kandian.qq.com");
        localJSONObject.put("path", "kandian_messagebox");
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("kandian_messagebox_data_key2_isNew_");
        localStringBuilder.append(str);
        localStringBuilder.append("_");
        localStringBuilder.append(paramString);
        localJSONObject.put("key", localStringBuilder.toString());
        paramString = new StringBuilder();
        paramString.append("https://kandian.qq.com/qz_kandian_social/kandian_ext/getMessageBox?readTimestamp=0&pageNo=1&pageSize=20&isBiuLevel=1&isNew=");
        paramString.append(str);
        str = paramString.toString();
        bool = true;
        paramString = str;
        if (paramInt == 1)
        {
          local7 = new ReadInJoyWebDataManager.7(this);
          paramString = new StringBuilder();
          paramString.append(str);
          paramString.append("&ispreload=1");
          paramString = paramString.toString();
        }
        str = c;
        if (paramInt == 1)
        {
          a("get", paramString, localJSONObject, str, local7, Boolean.valueOf(bool));
          if (QLog.isColorLevel())
          {
            paramString = new StringBuilder();
            paramString.append("preloadWebDataMessageBox:isNew ");
            paramString.append(paramInt);
            QLog.w("ReadInJoyWebDataManager", 2, paramString.toString());
          }
          return;
        }
      }
      catch (Exception paramString)
      {
        return;
      }
      boolean bool = false;
    }
  }
  
  public void a(String paramString1, String paramString2)
  {
    ((IPublicAccountReportUtils)QRoute.api(IPublicAccountReportUtils.class)).publicAccountReportClickEvent(null, "", "0X8008221", "0X8008221", 0, 0, paramString1, paramString2, "", "", false);
  }
  
  public void a(String paramString1, String paramString2, ReadInJoyWebDataManager.H5DataCallback paramH5DataCallback)
  {
    JSONObject localJSONObject = new JSONObject();
    if (TextUtils.isEmpty(paramString2)) {
      return;
    }
    new Thread(new ReadInJoyWebDataManager.4(this, paramString2, paramH5DataCallback, localJSONObject, paramString1)).start();
  }
  
  public void a(String paramString1, String paramString2, String paramString3)
  {
    ((IPublicAccountReportUtils)QRoute.api(IPublicAccountReportUtils.class)).publicAccountReportClickEvent(null, "", "0X8008220", "0X8008220", 0, 0, paramString1, paramString2, paramString3, "", false);
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
  
  public void a(String paramString1, String paramString2, JSONObject paramJSONObject, String paramString3, ReadInJoyWebDataManager.HttpFetchBizCallback paramHttpFetchBizCallback, Boolean paramBoolean)
  {
    if (this.jdField_a_of_type_JavaUtilHashMap != null)
    {
      if ((this.jdField_a_of_type_JavaUtilHashMap.containsKey(paramString2)) && (System.currentTimeMillis() - ((Long)this.jdField_a_of_type_JavaUtilHashMap.get(paramString2)).longValue() < 1800000L))
      {
        a(paramString3, g, j);
        return;
      }
      a(paramString3, f, "");
      if (!paramBoolean.booleanValue()) {
        this.jdField_a_of_type_JavaUtilHashMap.put(paramString2, Long.valueOf(System.currentTimeMillis()));
      }
      if (paramString2.indexOf("?") != -1)
      {
        paramBoolean = new StringBuilder();
        paramBoolean.append(paramString2);
        paramBoolean.append("&g_tk=");
        paramBoolean.append(b());
        paramString2 = paramBoolean.toString();
      }
      else
      {
        paramBoolean = new StringBuilder();
        paramBoolean.append(paramString2);
        paramBoolean.append("?g_tk=");
        paramBoolean.append(b());
        paramString2 = paramBoolean.toString();
      }
      if ("get".equals(paramString1)) {
        a(paramString2, paramJSONObject, paramString3, paramHttpFetchBizCallback);
      }
    }
    else if (QLog.isColorLevel())
    {
      QLog.w("ReadInJoyWebDataManager", 2, "httpFetchAsync mCgiLoadedMap cause mCgiLoadedMap is null ");
    }
  }
  
  public void a(String paramString, JSONObject paramJSONObject)
  {
    if (BaseApplication.getContext() != null)
    {
      if (!ViolaPicSerPreloadHandler.a()) {
        return;
      }
      Object localObject;
      if (this.jdField_a_of_type_ComTencentMobileqqKandianGlueViolaViewViolaBaseView == null)
      {
        this.jdField_a_of_type_ComTencentMobileqqKandianGlueViolaViewViolaBaseView = new ViolaBaseView(BaseApplication.getContext());
        localObject = this.jdField_a_of_type_ComTencentMobileqqKandianGlueViolaViewViolaBaseView;
        String str = jdField_a_of_type_JavaLangString;
        ((ViolaBaseView)localObject).a(str, null, new ViolaBaseView.ViolaCreactPageObject(str, new JSONObject(), null, null));
      }
      try
      {
        localObject = new JSONObject();
        ((JSONObject)localObject).put("url", paramString);
        ((JSONObject)localObject).put("param", paramJSONObject);
        paramString = new JSONObject();
        paramString.put("preloadViola", localObject);
        this.jdField_a_of_type_ComTencentMobileqqKandianGlueViolaViewViolaBaseView.a(paramString.toString());
        return;
      }
      catch (JSONException paramString)
      {
        if (QLog.isColorLevel())
        {
          paramJSONObject = new StringBuilder();
          paramJSONObject.append("preLoadComCgi e ");
          paramJSONObject.append(paramString.getMessage());
          QLog.w("ReadInJoyWebDataManager", 2, paramJSONObject.toString());
        }
      }
    }
  }
  
  public boolean a()
  {
    QQAppInterface localQQAppInterface = (QQAppInterface)RIJQQAppInterfaceUtil.a();
    boolean bool2 = false;
    if (localQQAppInterface == null) {
      return false;
    }
    boolean bool1 = bool2;
    if (b())
    {
      bool1 = bool2;
      if (ReadInJoyHelper.C(localQQAppInterface)) {
        bool1 = true;
      }
    }
    return bool1;
  }
  
  public boolean a(String paramString)
  {
    if (!a())
    {
      if (!b()) {
        a(paramString, g, h);
      } else {
        a(paramString, g, i);
      }
      return false;
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
    ViolaBaseView localViolaBaseView = this.jdField_a_of_type_ComTencentMobileqqKandianGlueViolaViewViolaBaseView;
    if (localViolaBaseView != null)
    {
      localViolaBaseView.onActivityDestroy();
      this.jdField_a_of_type_ComTencentMobileqqKandianGlueViolaViewViolaBaseView = null;
    }
  }
  
  public void c(String paramString)
  {
    a(paramString, null);
  }
  
  public void d(String paramString)
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
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("kandian_homepage2_data_key_");
      localStringBuilder.append(paramString);
      localJSONObject.put("key", localStringBuilder.toString());
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("https://kandian.qq.com/qz_kandian_social/kandian_ext/getPersonPage?pageNo=1&pageSize=20&is715=1&uin=");
      localStringBuilder.append(paramString);
      a("get", localStringBuilder.toString(), localJSONObject, jdField_b_of_type_JavaLangString);
      return;
    }
    catch (Exception paramString) {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.video.ReadInJoyWebDataManager
 * JD-Core Version:    0.7.0.1
 */