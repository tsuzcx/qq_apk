import android.content.Context;
import android.os.Build;
import android.os.Handler;
import android.text.TextUtils;
import android.util.Pair;
import com.tencent.biz.pubaccount.readinjoy.struct.AdvertisementInfo;
import com.tencent.biz.pubaccount.readinjoy.struct.BaseArticleInfo;
import com.tencent.biz.pubaccount.readinjoy.struct.DislikeInfo;
import com.tencent.common.app.AppInterface;
import com.tencent.common.config.AppSetting;
import com.tencent.mobileqq.WebSsoBody.WebSsoRequestBody;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.mobileqq.persistence.EntityManager;
import com.tencent.qphone.base.remote.FromServiceMsg;
import com.tencent.qphone.base.remote.ToServiceMsg;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.atomic.AtomicBoolean;
import mqq.app.NewIntent;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import tencent.gdt.qq_ad_get.QQAdGet.DeviceInfo;
import tencent.im.oidb.articlesummary.articlesummary.AdInfo;
import tencent.im.oidb.cmd0x68b.oidb_cmd0x68b.AdPosMap;
import tencent.im.oidb.cmd0x68b.oidb_cmd0x68b.AdReqInfo;
import tencent.im.oidb.cmd0x68b.oidb_cmd0x68b.PhoneInfo;
import tencent.im.oidb.cmd0x68b.oidb_cmd0x68b.ReqAdvertisePara;
import tencent.im.oidb.cmd0x68b.oidb_cmd0x68b.ReqBody;
import tencent.im.oidb.cmd0x68b.oidb_cmd0x68b.RspBody;
import tencent.im.oidb.cmd0x68b.oidb_cmd0x68b.RspChannelArticle;
import tencent.im.oidb.cmd0x886.oidb_cmd0x886.RspBody;

public class pvu
  extends pxz
{
  public static int a;
  public static int b;
  public static int c;
  private LinkedHashMap<Integer, Long> jdField_a_of_type_JavaUtilLinkedHashMap = new LinkedHashMap();
  private ConcurrentHashMap<Integer, WeakReference<pxb>> jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap = new ConcurrentHashMap();
  private LinkedHashMap<Integer, Long> jdField_b_of_type_JavaUtilLinkedHashMap = new LinkedHashMap();
  private ConcurrentHashMap<Integer, HashSet<String>> jdField_b_of_type_JavaUtilConcurrentConcurrentHashMap = new ConcurrentHashMap();
  private LinkedHashMap<Integer, ConcurrentHashMap<Integer, AdvertisementInfo>> c;
  private LinkedHashMap<Integer, Pair<Integer, Integer>> d;
  private LinkedHashMap<Integer, Boolean> e = new LinkedHashMap();
  
  static
  {
    jdField_a_of_type_Int = 15;
    jdField_b_of_type_Int = 10;
    jdField_c_of_type_Int = 10;
  }
  
  public pvu(AppInterface paramAppInterface, EntityManager paramEntityManager, ExecutorService paramExecutorService, qnd paramqnd, Handler paramHandler)
  {
    super(paramAppInterface, paramEntityManager, paramExecutorService, paramqnd, paramHandler);
    this.jdField_c_of_type_JavaUtilLinkedHashMap = new LinkedHashMap();
    this.jdField_d_of_type_JavaUtilLinkedHashMap = new LinkedHashMap();
    if (QLog.isColorLevel()) {
      QLog.d("AdvertisementInfoModule", 2, "construct!");
    }
  }
  
  private int a()
  {
    switch (bgnt.a(BaseApplication.getContext()))
    {
    case 0: 
    default: 
      return 0;
    case 2: 
      return 1;
    case 3: 
      return 2;
    case 4: 
      return 3;
    }
    return 4;
  }
  
  private int a(int paramInt)
  {
    int i = 1;
    Object localObject1 = new ArrayList();
    Object localObject2 = (ConcurrentHashMap)this.jdField_c_of_type_JavaUtilLinkedHashMap.get(Integer.valueOf(paramInt));
    paramInt = i;
    if (localObject2 != null)
    {
      paramInt = i;
      if (((ConcurrentHashMap)localObject2).size() > 0)
      {
        localObject2 = ((ConcurrentHashMap)localObject2).values().iterator();
        while (((Iterator)localObject2).hasNext()) {
          ((ArrayList)localObject1).add((AdvertisementInfo)((Iterator)localObject2).next());
        }
        Collections.sort((List)localObject1, new pvw(this));
        localObject1 = (AdvertisementInfo)((ArrayList)localObject1).get(0);
        paramInt = i;
        if (localObject1 != null)
        {
          paramInt = i;
          if (((AdvertisementInfo)localObject1).mAdKdPos <= 100) {
            if (!((AdvertisementInfo)localObject1).hasAddExposure) {
              break label132;
            }
          }
        }
      }
    }
    label132:
    for (paramInt = 1;; paramInt = 2) {
      return paramInt;
    }
  }
  
  /* Error */
  private List<AdvertisementInfo> a(int paramInt, php<Integer> paramphp, long paramLong1, php<Boolean> paramphp1, php<Boolean> paramphp2, long paramLong2, List<tencent.im.oidb.articlesummary.articlesummary.ArticleSummary> paramList)
  {
    // Byte code:
    //   0: new 80	java/util/ArrayList
    //   3: dup
    //   4: invokespecial 81	java/util/ArrayList:<init>	()V
    //   7: astore 17
    //   9: aload 9
    //   11: invokeinterface 148 1 0
    //   16: astore 9
    //   18: iconst_0
    //   19: istore 10
    //   21: aload 9
    //   23: invokeinterface 109 1 0
    //   28: ifeq +652 -> 680
    //   31: aload 9
    //   33: invokeinterface 113 1 0
    //   38: checkcast 150	tencent/im/oidb/articlesummary/articlesummary$ArticleSummary
    //   41: astore 19
    //   43: aload 19
    //   45: getfield 154	tencent/im/oidb/articlesummary/articlesummary$ArticleSummary:msg_feeds_info	Ltencent/im/oidb/articlesummary/articlesummary$FeedsInfo;
    //   48: invokevirtual 159	tencent/im/oidb/articlesummary/articlesummary$FeedsInfo:has	()Z
    //   51: ifeq +635 -> 686
    //   54: aload 19
    //   56: getfield 154	tencent/im/oidb/articlesummary/articlesummary$ArticleSummary:msg_feeds_info	Ltencent/im/oidb/articlesummary/articlesummary$FeedsInfo;
    //   59: invokevirtual 162	tencent/im/oidb/articlesummary/articlesummary$FeedsInfo:get	()Lcom/tencent/mobileqq/pb/MessageMicro;
    //   62: checkcast 156	tencent/im/oidb/articlesummary/articlesummary$FeedsInfo
    //   65: getfield 166	tencent/im/oidb/articlesummary/articlesummary$FeedsInfo:msg_pos_ad_info	Ltencent/im/oidb/articlesummary/articlesummary$PosAdInfo;
    //   68: invokevirtual 169	tencent/im/oidb/articlesummary/articlesummary$PosAdInfo:has	()Z
    //   71: ifeq +615 -> 686
    //   74: aload 19
    //   76: getfield 154	tencent/im/oidb/articlesummary/articlesummary$ArticleSummary:msg_feeds_info	Ltencent/im/oidb/articlesummary/articlesummary$FeedsInfo;
    //   79: invokevirtual 162	tencent/im/oidb/articlesummary/articlesummary$FeedsInfo:get	()Lcom/tencent/mobileqq/pb/MessageMicro;
    //   82: checkcast 156	tencent/im/oidb/articlesummary/articlesummary$FeedsInfo
    //   85: getfield 166	tencent/im/oidb/articlesummary/articlesummary$FeedsInfo:msg_pos_ad_info	Ltencent/im/oidb/articlesummary/articlesummary$PosAdInfo;
    //   88: invokevirtual 170	tencent/im/oidb/articlesummary/articlesummary$PosAdInfo:get	()Lcom/tencent/mobileqq/pb/MessageMicro;
    //   91: checkcast 168	tencent/im/oidb/articlesummary/articlesummary$PosAdInfo
    //   94: astore 18
    //   96: aload 18
    //   98: ifnull +588 -> 686
    //   101: aload 18
    //   103: getfield 174	tencent/im/oidb/articlesummary/articlesummary$PosAdInfo:int32_ret	Lcom/tencent/mobileqq/pb/PBInt32Field;
    //   106: invokevirtual 178	com/tencent/mobileqq/pb/PBInt32Field:get	()I
    //   109: ifne +577 -> 686
    //   112: aload 18
    //   114: getfield 182	tencent/im/oidb/articlesummary/articlesummary$PosAdInfo:enum_pos_layout	Lcom/tencent/mobileqq/pb/PBEnumField;
    //   117: invokevirtual 185	com/tencent/mobileqq/pb/PBEnumField:get	()I
    //   120: istore 11
    //   122: aload 18
    //   124: getfield 189	tencent/im/oidb/articlesummary/articlesummary$PosAdInfo:uint64_pos_id	Lcom/tencent/mobileqq/pb/PBUInt64Field;
    //   127: invokevirtual 194	com/tencent/mobileqq/pb/PBUInt64Field:get	()J
    //   130: lstore 12
    //   132: aload 18
    //   134: getfield 197	tencent/im/oidb/articlesummary/articlesummary$PosAdInfo:is_auto_play	Lcom/tencent/mobileqq/pb/PBUInt64Field;
    //   137: invokevirtual 194	com/tencent/mobileqq/pb/PBUInt64Field:get	()J
    //   140: lstore 14
    //   142: aload 18
    //   144: getfield 201	tencent/im/oidb/articlesummary/articlesummary$PosAdInfo:msg_ad_info	Ltencent/im/oidb/articlesummary/articlesummary$AdInfo;
    //   147: invokevirtual 204	tencent/im/oidb/articlesummary/articlesummary$AdInfo:get	()Lcom/tencent/mobileqq/pb/MessageMicro;
    //   150: checkcast 203	tencent/im/oidb/articlesummary/articlesummary$AdInfo
    //   153: astore 18
    //   155: aload_0
    //   156: iload_1
    //   157: aload_2
    //   158: aload 18
    //   160: invokespecial 207	pvu:a	(ILphp;Ltencent/im/oidb/articlesummary/articlesummary$AdInfo;)V
    //   163: new 115	com/tencent/biz/pubaccount/readinjoy/struct/AdvertisementInfo
    //   166: dup
    //   167: aload 18
    //   169: invokespecial 210	com/tencent/biz/pubaccount/readinjoy/struct/AdvertisementInfo:<init>	(Ltencent/im/oidb/articlesummary/articlesummary$AdInfo;)V
    //   172: astore 18
    //   174: aload 18
    //   176: invokestatic 215	oqj:a	(Lcom/tencent/biz/pubaccount/readinjoy/struct/AdvertisementInfo;)V
    //   179: aload 19
    //   181: aload_2
    //   182: invokevirtual 219	php:a	()Ljava/lang/Object;
    //   185: checkcast 83	java/lang/Integer
    //   188: invokevirtual 222	java/lang/Integer:intValue	()I
    //   191: iconst_0
    //   192: aload 18
    //   194: invokestatic 227	qnc:a	(Ltencent/im/oidb/articlesummary/articlesummary$ArticleSummary;IILcom/tencent/biz/pubaccount/readinjoy/struct/ArticleInfo;)Lcom/tencent/biz/pubaccount/readinjoy/struct/ArticleInfo;
    //   197: pop
    //   198: aload 18
    //   200: lload_3
    //   201: putfield 231	com/tencent/biz/pubaccount/readinjoy/struct/AdvertisementInfo:mAdFetchTime	J
    //   204: aload 18
    //   206: iload 11
    //   208: putfield 234	com/tencent/biz/pubaccount/readinjoy/struct/AdvertisementInfo:mAdPosLayout	I
    //   211: aload 18
    //   213: lload 12
    //   215: putfield 237	com/tencent/biz/pubaccount/readinjoy/struct/AdvertisementInfo:mAdPosID	J
    //   218: aload 18
    //   220: lload 14
    //   222: putfield 240	com/tencent/biz/pubaccount/readinjoy/struct/AdvertisementInfo:mADVideoAutoPlay	J
    //   225: lload 7
    //   227: ldc2_w 241
    //   230: lcmp
    //   231: ifne +452 -> 683
    //   234: iload 10
    //   236: ifne +447 -> 683
    //   239: aload 18
    //   241: getfield 246	com/tencent/biz/pubaccount/readinjoy/struct/AdvertisementInfo:mAdvertisementExtInfo	Lomq;
    //   244: ifnull +439 -> 683
    //   247: aload 18
    //   249: getfield 246	com/tencent/biz/pubaccount/readinjoy/struct/AdvertisementInfo:mAdvertisementExtInfo	Lomq;
    //   252: getfield 251	omq:f	I
    //   255: ifle +428 -> 683
    //   258: aload_0
    //   259: aload_2
    //   260: aload 18
    //   262: invokespecial 254	pvu:a	(Lphp;Lcom/tencent/biz/pubaccount/readinjoy/struct/AdvertisementInfo;)V
    //   265: iconst_1
    //   266: istore 10
    //   268: invokestatic 258	pgn:a	()Z
    //   271: ifeq +13 -> 284
    //   274: invokestatic 261	pgn:a	()Lpgn;
    //   277: aload 19
    //   279: aload 18
    //   281: invokevirtual 264	pgn:a	(Ltencent/im/oidb/articlesummary/articlesummary$ArticleSummary;Lcom/tencent/biz/pubaccount/readinjoy/struct/ArticleInfo;)V
    //   284: invokestatic 58	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   287: ifeq +61 -> 348
    //   290: ldc 60
    //   292: iconst_2
    //   293: new 266	java/lang/StringBuilder
    //   296: dup
    //   297: invokespecial 267	java/lang/StringBuilder:<init>	()V
    //   300: ldc_w 269
    //   303: invokevirtual 273	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   306: aload 18
    //   308: getfield 136	com/tencent/biz/pubaccount/readinjoy/struct/AdvertisementInfo:mAdKdPos	I
    //   311: invokevirtual 276	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   314: ldc_w 278
    //   317: invokevirtual 273	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   320: aload 18
    //   322: invokevirtual 282	com/tencent/biz/pubaccount/readinjoy/struct/AdvertisementInfo:toString	()Ljava/lang/String;
    //   325: invokevirtual 273	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   328: ldc_w 284
    //   331: invokevirtual 273	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   334: aload 18
    //   336: getfield 288	com/tencent/biz/pubaccount/readinjoy/struct/AdvertisementInfo:mAdExtInfo	Ljava/lang/String;
    //   339: invokevirtual 273	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   342: invokevirtual 289	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   345: invokestatic 65	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   348: aload 18
    //   350: getfield 288	com/tencent/biz/pubaccount/readinjoy/struct/AdvertisementInfo:mAdExtInfo	Ljava/lang/String;
    //   353: invokestatic 295	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   356: istore 16
    //   358: iload 16
    //   360: ifne +169 -> 529
    //   363: new 297	org/json/JSONObject
    //   366: dup
    //   367: aload 18
    //   369: getfield 288	com/tencent/biz/pubaccount/readinjoy/struct/AdvertisementInfo:mAdExtInfo	Ljava/lang/String;
    //   372: invokespecial 300	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   375: astore 19
    //   377: aload 19
    //   379: ldc_w 302
    //   382: invokevirtual 305	org/json/JSONObject:has	(Ljava/lang/String;)Z
    //   385: ifeq +33 -> 418
    //   388: aload 19
    //   390: ldc_w 302
    //   393: invokevirtual 309	org/json/JSONObject:getInt	(Ljava/lang/String;)I
    //   396: iconst_2
    //   397: if_icmpne +21 -> 418
    //   400: aload 6
    //   402: iconst_1
    //   403: invokestatic 314	java/lang/Boolean:valueOf	(Z)Ljava/lang/Boolean;
    //   406: invokevirtual 317	php:a	(Ljava/lang/Object;)V
    //   409: ldc 60
    //   411: iconst_1
    //   412: ldc_w 319
    //   415: invokestatic 65	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   418: invokestatic 58	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   421: ifeq +33 -> 454
    //   424: ldc 60
    //   426: iconst_2
    //   427: new 266	java/lang/StringBuilder
    //   430: dup
    //   431: invokespecial 267	java/lang/StringBuilder:<init>	()V
    //   434: ldc_w 321
    //   437: invokevirtual 273	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   440: aload 19
    //   442: invokevirtual 322	org/json/JSONObject:toString	()Ljava/lang/String;
    //   445: invokevirtual 273	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   448: invokevirtual 289	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   451: invokestatic 65	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   454: invokestatic 327	oqr:a	()Loqr;
    //   457: aload 18
    //   459: invokevirtual 328	oqr:a	(Lcom/tencent/biz/pubaccount/readinjoy/struct/AdvertisementInfo;)V
    //   462: aload 18
    //   464: invokestatic 333	oqm:a	(Lcom/tencent/biz/pubaccount/readinjoy/struct/AdvertisementInfo;)Z
    //   467: ifeq +15 -> 482
    //   470: aload 5
    //   472: iconst_1
    //   473: invokestatic 314	java/lang/Boolean:valueOf	(Z)Ljava/lang/Boolean;
    //   476: invokevirtual 317	php:a	(Ljava/lang/Object;)V
    //   479: goto -458 -> 21
    //   482: aload 18
    //   484: invokestatic 336	oqp:a	(Lcom/tencent/biz/pubaccount/readinjoy/struct/AdvertisementInfo;)Z
    //   487: istore 16
    //   489: iload 16
    //   491: ifeq +38 -> 529
    //   494: goto -473 -> 21
    //   497: astore 19
    //   499: ldc 60
    //   501: iconst_1
    //   502: new 266	java/lang/StringBuilder
    //   505: dup
    //   506: invokespecial 267	java/lang/StringBuilder:<init>	()V
    //   509: ldc_w 338
    //   512: invokevirtual 273	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   515: aload 19
    //   517: invokevirtual 341	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   520: invokevirtual 273	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   523: invokevirtual 289	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   526: invokestatic 343	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   529: aload_0
    //   530: aload 18
    //   532: invokespecial 344	pvu:a	(Lcom/tencent/biz/pubaccount/readinjoy/struct/AdvertisementInfo;)Z
    //   535: ifne +105 -> 640
    //   538: aload 18
    //   540: aconst_null
    //   541: invokestatic 349	oqi:a	(Lcom/tencent/biz/pubaccount/readinjoy/struct/AdvertisementInfo;Lcom/tencent/biz/pubaccount/VideoAdInfo;)Z
    //   544: ifeq +73 -> 617
    //   547: new 297	org/json/JSONObject
    //   550: dup
    //   551: invokespecial 350	org/json/JSONObject:<init>	()V
    //   554: astore 19
    //   556: aload 19
    //   558: ldc_w 352
    //   561: iconst_0
    //   562: invokevirtual 356	org/json/JSONObject:put	(Ljava/lang/String;I)Lorg/json/JSONObject;
    //   565: pop
    //   566: aload 19
    //   568: ldc_w 358
    //   571: iconst_1
    //   572: invokevirtual 356	org/json/JSONObject:put	(Ljava/lang/String;I)Lorg/json/JSONObject;
    //   575: pop
    //   576: new 360	omp
    //   579: dup
    //   580: invokespecial 361	omp:<init>	()V
    //   583: invokestatic 72	com/tencent/qphone/base/util/BaseApplication:getContext	()Lcom/tencent/qphone/base/util/BaseApplication;
    //   586: invokevirtual 364	omp:a	(Landroid/content/Context;)Lomp;
    //   589: getstatic 369	nxw:k	I
    //   592: invokevirtual 372	omp:a	(I)Lomp;
    //   595: getstatic 375	nxw:U	I
    //   598: invokevirtual 377	omp:b	(I)Lomp;
    //   601: aload 18
    //   603: invokevirtual 380	omp:a	(Lcom/tencent/biz/pubaccount/readinjoy/struct/AdvertisementInfo;)Lomp;
    //   606: aload 19
    //   608: invokevirtual 383	omp:b	(Lorg/json/JSONObject;)Lomp;
    //   611: invokevirtual 386	omp:a	()Lomn;
    //   614: invokestatic 389	nxw:a	(Lomn;)V
    //   617: aload 17
    //   619: aload 18
    //   621: invokeinterface 390 2 0
    //   626: pop
    //   627: goto -606 -> 21
    //   630: astore 20
    //   632: aload 20
    //   634: invokevirtual 393	org/json/JSONException:printStackTrace	()V
    //   637: goto -61 -> 576
    //   640: invokestatic 58	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   643: ifeq +33 -> 676
    //   646: ldc 60
    //   648: iconst_2
    //   649: new 266	java/lang/StringBuilder
    //   652: dup
    //   653: invokespecial 267	java/lang/StringBuilder:<init>	()V
    //   656: ldc_w 395
    //   659: invokevirtual 273	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   662: aload 18
    //   664: invokevirtual 398	com/tencent/biz/pubaccount/readinjoy/struct/AdvertisementInfo:toSString	()Ljava/lang/String;
    //   667: invokevirtual 273	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   670: invokevirtual 289	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   673: invokestatic 65	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   676: goto -49 -> 627
    //   679: astore_2
    //   680: aload 17
    //   682: areturn
    //   683: goto -415 -> 268
    //   686: goto -59 -> 627
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	689	0	this	pvu
    //   0	689	1	paramInt	int
    //   0	689	2	paramphp	php<Integer>
    //   0	689	3	paramLong1	long
    //   0	689	5	paramphp1	php<Boolean>
    //   0	689	6	paramphp2	php<Boolean>
    //   0	689	7	paramLong2	long
    //   0	689	9	paramList	List<tencent.im.oidb.articlesummary.articlesummary.ArticleSummary>
    //   19	248	10	i	int
    //   120	87	11	j	int
    //   130	84	12	l1	long
    //   140	81	14	l2	long
    //   356	134	16	bool	boolean
    //   7	674	17	localArrayList	ArrayList
    //   94	569	18	localObject1	Object
    //   41	400	19	localObject2	Object
    //   497	19	19	localException	Exception
    //   554	53	19	localJSONObject	JSONObject
    //   630	3	20	localJSONException	JSONException
    // Exception table:
    //   from	to	target	type
    //   348	358	497	java/lang/Exception
    //   556	576	630	org/json/JSONException
    //   363	418	679	java/lang/Exception
    //   418	454	679	java/lang/Exception
    //   454	479	679	java/lang/Exception
    //   482	489	679	java/lang/Exception
  }
  
  private void a(int paramInt, php<Integer> paramphp, articlesummary.AdInfo paramAdInfo)
  {
    if ((paramAdInfo != null) && (paramInt == 0))
    {
      paramphp.a(Integer.valueOf((int)paramAdInfo.uint64_channel_id.get()));
      if (QLog.isColorLevel()) {
        QLog.d("AdvertisementInfoModule", 2, "handleAdvertisementResp channelID from AdInfo:" + paramphp.a());
      }
    }
  }
  
  private void a(ArrayList<AdvertisementInfo> paramArrayList)
  {
    if (QLog.isColorLevel())
    {
      if (paramArrayList.size() > 0)
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("handleAdvertisementResp \n").append("[ ");
        paramArrayList = paramArrayList.iterator();
        while (paramArrayList.hasNext())
        {
          AdvertisementInfo localAdvertisementInfo = (AdvertisementInfo)paramArrayList.next();
          localStringBuilder.append("channelId = ").append(localAdvertisementInfo.mChannelID).append(" title = ").append(localAdvertisementInfo.mTitle).append(" pos = ").append(localAdvertisementInfo.mAdKdPos);
        }
        oqh.a("AdDataLink", " ]");
      }
    }
    else {
      return;
    }
    oqh.a("AdDataLink", "handleAdvertisementResp no advertisementInfo");
  }
  
  private void a(php<Integer> paramphp, long paramLong, ArrayList<AdvertisementInfo> paramArrayList)
  {
    if (paramArrayList.size() == 0) {
      paramArrayList = new JSONObject();
    }
    try
    {
      paramArrayList.put("svrresp_result", 1);
      paramArrayList.put("svrresp_fail_type", 1);
      nxw.a(new omp().a(BaseApplication.getContext()).a(nxw.k).b(nxw.U).b(paramArrayList).a());
      if (QLog.isColorLevel()) {
        QLog.d("AdvertisementInfoModule", 1, "handleAdvertisementResp channelID=" + paramphp.a() + ", fetchTime=" + paramLong + " parsedAdvertisementList empty!");
      }
      return;
    }
    catch (JSONException localJSONException)
    {
      for (;;)
      {
        localJSONException.printStackTrace();
      }
    }
  }
  
  private void a(php<Integer> paramphp, AdvertisementInfo paramAdvertisementInfo)
  {
    jdField_a_of_type_Int = paramAdvertisementInfo.mAdvertisementExtInfo.f;
    oqh.a("AdDataLink", "async handleAdvertisementResp refreshLastPosX= +" + jdField_a_of_type_Int);
    a(((Integer)paramphp.a()).intValue(), 0, jdField_a_of_type_Int);
    if (paramAdvertisementInfo.mAdvertisementExtInfo.h > 0)
    {
      jdField_b_of_type_Int = paramAdvertisementInfo.mAdvertisementExtInfo.h;
      oqh.a("AdDataLink", "async handleAdvertisementResp refreshLastPosZ= +" + jdField_b_of_type_Int);
    }
    if (paramAdvertisementInfo.mAdvertisementExtInfo.g > 0)
    {
      jdField_c_of_type_Int = paramAdvertisementInfo.mAdvertisementExtInfo.g;
      oqh.a("AdDataLink", "async handleAdvertisementResp refreshLastPosY= +" + jdField_c_of_type_Int);
    }
  }
  
  private void a(php<Integer> paramphp, ConcurrentHashMap<Integer, AdvertisementInfo> paramConcurrentHashMap)
  {
    if (QLog.isColorLevel()) {
      QLog.d("AdvertisementInfoModule", 2, "handleAdvertisementResp dropAdvertisements size = " + paramConcurrentHashMap.size());
    }
    Iterator localIterator = paramConcurrentHashMap.values().iterator();
    while (localIterator.hasNext())
    {
      AdvertisementInfo localAdvertisementInfo = (AdvertisementInfo)localIterator.next();
      pmh.a().a(((Integer)paramphp.a()).intValue(), localAdvertisementInfo);
    }
    paramConcurrentHashMap.clear();
  }
  
  private void a(oidb_cmd0x68b.RspChannelArticle paramRspChannelArticle)
  {
    if (paramRspChannelArticle.msg_ad_pos_map.has())
    {
      paramRspChannelArticle = (oidb_cmd0x68b.AdPosMap)paramRspChannelArticle.msg_ad_pos_map.get();
      if (paramRspChannelArticle.bytes_ads_context.has())
      {
        nxw.a(paramRspChannelArticle.bytes_ads_context.get().toStringUtf8());
        return;
      }
      nxw.a("");
      return;
    }
    nxw.a("");
  }
  
  private boolean a(AdvertisementInfo paramAdvertisementInfo)
  {
    boolean bool = false;
    if (paramAdvertisementInfo == null) {}
    while (TextUtils.isEmpty(paramAdvertisementInfo.mTitle)) {
      return true;
    }
    if (!TextUtils.isEmpty(paramAdvertisementInfo.mJsonVideoList))
    {
      if ((TextUtils.isEmpty(paramAdvertisementInfo.mAdLandingPage)) || (TextUtils.isEmpty(paramAdvertisementInfo.mSubscribeName)) || (TextUtils.isEmpty(paramAdvertisementInfo.mAdVideoUrl))) {
        bool = true;
      }
      return bool;
    }
    return false;
  }
  
  private void b(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    int j = 0;
    oidb_cmd0x68b.RspBody localRspBody = new oidb_cmd0x68b.RspBody();
    int i = qnf.a(paramFromServiceMsg, paramObject, localRspBody);
    int m = ((Integer)paramToServiceMsg.getAttribute(h, Integer.valueOf(0))).intValue();
    if (QLog.isColorLevel()) {
      QLog.d("AdvertisementInfoModule", 2, "handle0x68bGetAdvertisementList! result=" + i + ",repeatedreqFlag=" + m);
    }
    int k = ((Integer)paramToServiceMsg.getAttribute(i, Integer.valueOf(0))).intValue();
    if (QLog.isColorLevel()) {
      QLog.d("AdvertisementInfoModule", 2, "handle0x68bGetAdvertisementList! result=" + i + ",asyncChannelId=" + k);
    }
    orm.a(k);
    oqh.a("AdDataLink", "handle0x68bGetAdvertisementList result = " + i);
    if (i == 0) {
      if (!localRspBody.uint64_uin.has()) {
        break label770;
      }
    }
    label770:
    for (long l = localRspBody.uint64_uin.get();; l = -1L)
    {
      if ((localRspBody.rspChannelArticle.has()) && (localRspBody.rspChannelArticle.get() != null) && (String.valueOf(l).equals(this.jdField_a_of_type_ComTencentCommonAppAppInterface.getCurrentAccountUin())))
      {
        paramFromServiceMsg = (oidb_cmd0x68b.RspChannelArticle)localRspBody.rspChannelArticle.get();
        i = (int)paramFromServiceMsg.uint64_channel_id.get();
        if ((i != 0) || (k == 0)) {
          break label767;
        }
        i = k;
      }
      label767:
      for (;;)
      {
        oqh.a("AdDataLink", "handleAdvertisementResp 处理广告");
        if ((paramFromServiceMsg.rpt_advertise_list.has()) && (paramFromServiceMsg.rpt_advertise_list.get() != null))
        {
          oqh.a("AdDataLink", "handleAdvertisementResp in ad Request");
          a(paramToServiceMsg, paramFromServiceMsg, m, k, false);
        }
        for (;;)
        {
          oqr.a().c(true);
          if ((this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.containsKey(Integer.valueOf(i))) && (j == 0))
          {
            paramToServiceMsg = (WeakReference)this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.get(Integer.valueOf(i));
            if ((paramToServiceMsg != null) && (paramToServiceMsg.get() != null))
            {
              QLog.d("AdvertisementInfoModule", 1, "handle0x68bGetAdvertisementList listener = " + paramToServiceMsg.toString());
              ((pxb)paramToServiceMsg.get()).a(i);
            }
          }
          return;
          if (m == 1)
          {
            oqh.a("AdDataLink", "handle0x68bGetAdvertisementList 重复曝光加载数据返回空");
            j = 1;
          }
          else
          {
            oqh.a("AdDataLink", "handleAdvertisementResp channelArticle.rpt_advertise_list.has() = " + paramFromServiceMsg.rpt_advertise_list.has() + " channelArticle.rpt_advertise_list.get() = " + paramFromServiceMsg.rpt_advertise_list.get() + " repeatedreqFlag = " + m);
          }
        }
        oqh.a("AdDataLink", "handle0x68bGetAdvertisementList resp.rspChannelArticle.has() = " + localRspBody.rspChannelArticle.has() + " uin = " + l + " currentUin = " + this.jdField_a_of_type_ComTencentCommonAppAppInterface.getCurrentAccountUin());
        return;
        j = ((Integer)paramToServiceMsg.getAttribute(f)).intValue();
        oqh.a("AdDataLink", "handle0x68bGetAdvertisementList Error result = " + i + " requestCount = " + j);
        if ((i == 154) && (j == 1))
        {
          paramToServiceMsg.getAttributes().put(f, Integer.valueOf(2));
          a(paramToServiceMsg);
          oqh.a("AdDataLink", "handle0x68bGetAdvertisementList timeout retry : requestCount = " + j);
          return;
        }
        paramToServiceMsg = new JSONObject();
        try
        {
          paramToServiceMsg.put("svrresp_result", 1);
          paramToServiceMsg.put("svrresp_fail_type", 2);
          paramToServiceMsg.put("svrresp_fail_code", i);
          nxw.a(new omp().a(BaseApplication.getContext()).a(nxw.k).b(nxw.U).b(paramToServiceMsg).a());
          return;
        }
        catch (JSONException paramFromServiceMsg)
        {
          for (;;)
          {
            paramFromServiceMsg.printStackTrace();
          }
        }
      }
    }
  }
  
  private void c(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    if (QLog.isColorLevel()) {
      QLog.d("AdvertisementInfoModule", 2, "handle0x886AdvertisementReportResp!");
    }
    int i = qnf.a(paramFromServiceMsg, paramObject, new oidb_cmd0x886.RspBody());
    if (i != 0)
    {
      int j = ((Integer)paramToServiceMsg.getAttribute(g)).intValue();
      if ((i == 154) && (j == 1))
      {
        paramToServiceMsg.getAttributes().put(g, Integer.valueOf(2));
        a(paramToServiceMsg);
      }
    }
  }
  
  public Pair<Integer, Integer> a(int paramInt)
  {
    return (Pair)this.jdField_d_of_type_JavaUtilLinkedHashMap.get(Integer.valueOf(paramInt));
  }
  
  public Pair<Integer, Integer> a(int paramInt1, int paramInt2)
  {
    if (!a(paramInt1))
    {
      oqh.a("AdDataLink", "async getPreloadAdvertisementAtPostion channelid=" + paramInt1 + "   !needRequestAdvertisement ");
      return null;
    }
    Pair localPair = (Pair)this.jdField_d_of_type_JavaUtilLinkedHashMap.get(Integer.valueOf(paramInt1));
    if (localPair != null)
    {
      if (paramInt2 + jdField_c_of_type_Int <= ((Integer)localPair.second).intValue()) {
        return null;
      }
      int i = ((Integer)localPair.second).intValue();
      int j = jdField_b_of_type_Int + i;
      oqh.a("AdDataLink", "first = " + localPair.first + " second = " + localPair.second);
      oqh.a("AdDataLink", "async getPreloadAdvertisementAtPostion channelid=" + paramInt1 + "  position=" + paramInt2 + "  startpos=" + i + "  endpos=" + j);
      return new Pair(Integer.valueOf(i), Integer.valueOf(j));
    }
    return null;
  }
  
  public AdvertisementInfo a(int paramInt1, int paramInt2)
  {
    Object localObject = (ConcurrentHashMap)this.jdField_c_of_type_JavaUtilLinkedHashMap.get(Integer.valueOf(paramInt1));
    if (localObject == null)
    {
      oqh.a("AdVideoDataLink", "getAdvertisementInfo channelId=" + paramInt1 + " map is null!");
      return null;
    }
    localObject = (AdvertisementInfo)((ConcurrentHashMap)localObject).get(Integer.valueOf(paramInt2));
    if (localObject != null)
    {
      oqh.a("AdVideoDataLink", "getAdvertisementInfo channelId=" + paramInt1 + " advertisementInfo = " + ((AdvertisementInfo)localObject).mTitle + " pos = " + ((AdvertisementInfo)localObject).mAdKdPos);
      return localObject;
    }
    return null;
  }
  
  public ArrayList<BaseArticleInfo> a(int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d("AdvertisementInfoModule", 2, "getFixPosArticleListSync channelId=" + paramInt);
    }
    ArrayList localArrayList = new ArrayList();
    localArrayList.addAll(b(paramInt));
    return localArrayList;
  }
  
  public oidb_cmd0x68b.ReqAdvertisePara a(qni paramqni, int paramInt1, int paramInt2, int paramInt3, int paramInt4, nwv paramnwv)
  {
    if (QLog.isColorLevel()) {
      QLog.d("AdvertisementInfoModule", 2, "makeReqAdvertisePara channelID=" + paramInt1);
    }
    Object localObject1 = new acry();
    ((acry)localObject1).a = "ce2d9f";
    Object localObject3 = acrx.a(BaseApplication.getContext(), (acry)localObject1);
    oidb_cmd0x68b.ReqAdvertisePara localReqAdvertisePara;
    Object localObject2;
    long l;
    if (localObject3 != null)
    {
      localObject1 = ((acrz)localObject3).a;
      localReqAdvertisePara = new oidb_cmd0x68b.ReqAdvertisePara();
      localReqAdvertisePara.uint64_channel_id.set(paramInt1, true);
      localObject2 = localReqAdvertisePara.uint64_last_time;
      if (this.jdField_a_of_type_JavaUtilLinkedHashMap.get(Integer.valueOf(paramInt1)) != null) {
        break label1178;
      }
      l = 0L;
      label115:
      ((PBUInt64Field)localObject2).set(l, true);
      localObject2 = new oidb_cmd0x68b.PhoneInfo();
      if ((localObject3 != null) && (((acrz)localObject3).a != null) && (((acrz)localObject3).a.muid != null) && (((acrz)localObject3).a.muid_type != null))
      {
        ((oidb_cmd0x68b.PhoneInfo)localObject2).bytes_muid.set(ByteStringMicro.copyFromUtf8(((acrz)localObject3).a.muid.get()));
        ((oidb_cmd0x68b.PhoneInfo)localObject2).uint32_muid_type.set(((acrz)localObject3).a.muid_type.get());
      }
      localObject3 = opp.b();
      if (!TextUtils.isEmpty((CharSequence)localObject3)) {
        ((oidb_cmd0x68b.PhoneInfo)localObject2).string_imei.set((String)localObject3);
      }
      i = nve.a();
      ((oidb_cmd0x68b.PhoneInfo)localObject2).uint32_conn.set(i);
      i = 0;
    }
    try
    {
      int j = bgln.e();
      i = j;
    }
    catch (Exception localException)
    {
      label258:
      break label258;
    }
    ((oidb_cmd0x68b.PhoneInfo)localObject2).uint32_carrier.set(i);
    localObject3 = bgln.e();
    ((oidb_cmd0x68b.PhoneInfo)localObject2).bytes_os_ver.set(ByteStringMicro.copyFromUtf8((String)localObject3));
    localObject3 = bgln.c();
    ((oidb_cmd0x68b.PhoneInfo)localObject2).bytes_qq_ver.set(ByteStringMicro.copyFromUtf8((String)localObject3));
    int i = AppSetting.a();
    ((oidb_cmd0x68b.PhoneInfo)localObject2).bytes_appid.set(ByteStringMicro.copyFromUtf8(String.valueOf(i)));
    localObject3 = dw.a(dw.a());
    ((oidb_cmd0x68b.PhoneInfo)localObject2).bytes_client_ip.set(ByteStringMicro.copyFromUtf8((String)localObject3));
    ((oidb_cmd0x68b.PhoneInfo)localObject2).uint32_os_type.set(2);
    ((oidb_cmd0x68b.PhoneInfo)localObject2).uint64_func_flag.set(1L);
    ((oidb_cmd0x68b.PhoneInfo)localObject2).bytes_ads_context.set(ByteStringMicro.copyFromUtf8(nxw.a()));
    ((oidb_cmd0x68b.PhoneInfo)localObject2).bytes_manufacturer.set(ByteStringMicro.copyFromUtf8(Build.BRAND));
    ((oidb_cmd0x68b.PhoneInfo)localObject2).bytes_device_brand_and_model.set(ByteStringMicro.copyFromUtf8(Build.MODEL));
    if (localObject1 != null)
    {
      if (((qq_ad_get.QQAdGet.DeviceInfo)localObject1).qadid.has()) {
        ((oidb_cmd0x68b.PhoneInfo)localObject2).string_qadid.set(((qq_ad_get.QQAdGet.DeviceInfo)localObject1).qadid.get());
      }
      if (((qq_ad_get.QQAdGet.DeviceInfo)localObject1).md5_android_id.has()) {
        ((oidb_cmd0x68b.PhoneInfo)localObject2).string_androidid.set(((qq_ad_get.QQAdGet.DeviceInfo)localObject1).md5_android_id.get());
      }
      if (((qq_ad_get.QQAdGet.DeviceInfo)localObject1).md5_mac.has()) {
        ((oidb_cmd0x68b.PhoneInfo)localObject2).string_mac.set(((qq_ad_get.QQAdGet.DeviceInfo)localObject1).md5_mac.get());
      }
      if (((qq_ad_get.QQAdGet.DeviceInfo)localObject1).aid_ticket.has()) {
        ((oidb_cmd0x68b.PhoneInfo)localObject2).string_oaid.set(((qq_ad_get.QQAdGet.DeviceInfo)localObject1).aid_ticket.get());
      }
      if (((qq_ad_get.QQAdGet.DeviceInfo)localObject1).taid_ticket.has()) {
        ((oidb_cmd0x68b.PhoneInfo)localObject2).string_taid.set(((qq_ad_get.QQAdGet.DeviceInfo)localObject1).taid_ticket.get());
      }
      if (((qq_ad_get.QQAdGet.DeviceInfo)localObject1).client_ipv4.has()) {
        ((oidb_cmd0x68b.PhoneInfo)localObject2).string_client_ipv4.set(((qq_ad_get.QQAdGet.DeviceInfo)localObject1).client_ipv4.get());
      }
      if (QLog.isColorLevel()) {
        QLog.i("AdvertisementInfoModule", 2, "makeReqAdvertisePara: deviceInfo: ma=" + ((oidb_cmd0x68b.PhoneInfo)localObject2).string_androidid.get() + ", mm=" + ((oidb_cmd0x68b.PhoneInfo)localObject2).string_mac.get() + ", oa=" + ((oidb_cmd0x68b.PhoneInfo)localObject2).string_oaid.get() + ", ta=" + ((oidb_cmd0x68b.PhoneInfo)localObject2).string_taid.get());
      }
    }
    ((oidb_cmd0x68b.PhoneInfo)localObject2).bytes_wx_ver.set(ByteStringMicro.copyFrom(opp.a(BaseApplication.getContext()).getBytes()));
    localReqAdvertisePara.msg_phone_info.set((MessageMicro)localObject2, true);
    if (paramInt3 != paramInt4) {}
    for (;;)
    {
      try
      {
        localObject1 = new JSONObject();
        ((JSONObject)localObject1).put("adPosType", paramInt2);
        ((JSONObject)localObject1).put("adStartPos", paramInt3);
        ((JSONObject)localObject1).put("adEndPos", paramInt4);
        if ((paramnwv != null) && (paramnwv.a()))
        {
          ((JSONObject)localObject1).put("MaterialId", paramnwv.jdField_a_of_type_Int);
          ((JSONObject)localObject1).put("RepeatedReqFlag", paramnwv.jdField_b_of_type_Int);
          ((JSONObject)localObject1).put("KdPos", paramnwv.jdField_c_of_type_Int);
          ((JSONObject)localObject1).put("adPosId", paramnwv.jdField_a_of_type_Long);
        }
        if (!qak.b(paramqni)) {
          continue;
        }
        ((JSONObject)localObject1).put("adRequestFlag", a(paramInt1));
        if (this.jdField_b_of_type_JavaUtilLinkedHashMap.get(Integer.valueOf(paramInt1)) != null) {
          continue;
        }
        l = 0L;
        ((JSONObject)localObject1).put("lastRefreshTime", l);
        if ((oqr.a().a()) && (paramInt2 == 1) && (oqr.a().a().size() > 0))
        {
          ((JSONObject)localObject1).put("superMaskType", 2);
          ((JSONObject)localObject1).put("reqList", new JSONArray(oqr.a().a()));
          oqr.a().b(false);
          oqr.a().c(false);
        }
        QLog.d("AdvertisementInfoModule", 1, "async makeReqAdvertisePara adinfo," + ((JSONObject)localObject1).toString());
        if ((paramInt2 == 1) && (paramnwv != null))
        {
          ((JSONObject)localObject1).put("videoPatchAdFlag", paramnwv.d);
          ((JSONObject)localObject1).put("prePatchAdCount", paramnwv.e);
          ((JSONObject)localObject1).put("postPatchAdCount", paramnwv.f);
          ((JSONObject)localObject1).put("social_card_flag", paramnwv.g);
        }
        if (bdch.a()) {
          ((JSONObject)localObject1).put("reqLearningPatternFlag", 1);
        }
        if (paramnwv != null)
        {
          ((JSONObject)localObject1).put("reqTimeVideoAdload", paramnwv.h);
          ((JSONObject)localObject1).put("videoSceneId", paramnwv.i);
          ((JSONObject)localObject1).put("videoTimeAdLoadLastAdPos", paramnwv.j);
        }
        localReqAdvertisePara.bytes_ad_user_info.set(ByteStringMicro.copyFromUtf8(((JSONObject)localObject1).toString()));
        if (QLog.isColorLevel()) {
          QLog.d("AdvertisementInfoModule", 2, "async makeReqAdvertisePara adinfo," + ((JSONObject)localObject1).toString());
        }
      }
      catch (JSONException paramqni)
      {
        label1178:
        paramqni.printStackTrace();
        continue;
      }
      paramqni = new oidb_cmd0x68b.AdReqInfo();
      paramqni.uint64_ad_channel_id.set(paramInt1);
      localReqAdvertisePara.msg_ad_req_info.set(paramqni);
      return localReqAdvertisePara;
      localObject1 = null;
      break;
      l = ((Long)this.jdField_a_of_type_JavaUtilLinkedHashMap.get(Integer.valueOf(paramInt1))).longValue();
      break label115;
      l = ((Long)this.jdField_b_of_type_JavaUtilLinkedHashMap.get(Integer.valueOf(paramInt1))).longValue();
      continue;
      ((JSONObject)localObject1).put("adRequestFlag", 0);
    }
  }
  
  public void a()
  {
    if (QLog.isColorLevel()) {
      QLog.d("AdvertisementInfoModule", 2, "unInitialize!");
    }
    this.jdField_c_of_type_JavaUtilLinkedHashMap.clear();
    this.jdField_a_of_type_JavaUtilLinkedHashMap.clear();
    this.jdField_b_of_type_JavaUtilLinkedHashMap.clear();
    this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.clear();
    this.jdField_b_of_type_JavaUtilConcurrentConcurrentHashMap.clear();
    oqp.c();
    oqm.a();
  }
  
  public void a(int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d("AdvertisementInfoModule", 2, "removeFixPosArticleAsyncListener channelID=" + paramInt);
    }
    this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.remove(Integer.valueOf(paramInt));
  }
  
  public void a(int paramInt1, int paramInt2, int paramInt3)
  {
    Pair localPair = (Pair)this.jdField_d_of_type_JavaUtilLinkedHashMap.get(Integer.valueOf(paramInt1));
    if (localPair == null) {
      localPair = new Pair(Integer.valueOf(0), Integer.valueOf(0));
    }
    for (;;)
    {
      int i = paramInt3;
      if (paramInt2 != 0)
      {
        i = paramInt3;
        if (paramInt3 < ((Integer)localPair.second).intValue()) {
          i = ((Integer)localPair.second).intValue();
        }
      }
      oqh.a("AdDataLink", "async setLocalAdvertisementRange channelid=" + paramInt1 + "  adStart=" + paramInt2 + "  adEnd=" + i);
      localPair = new Pair(Integer.valueOf(paramInt2), Integer.valueOf(i));
      this.jdField_d_of_type_JavaUtilLinkedHashMap.remove(Integer.valueOf(paramInt1));
      this.jdField_d_of_type_JavaUtilLinkedHashMap.put(Integer.valueOf(paramInt1), localPair);
      return;
    }
  }
  
  public void a(int paramInt1, int paramInt2, int paramInt3, int paramInt4, nwv paramnwv)
  {
    oqh.a("AdDataLink", "refreshChannelAdvertisementFormServer channelId=" + paramInt1 + " adPosType = " + paramInt2 + " adStart = " + paramInt3 + " adEnd = " + paramInt4 + " 请求广告");
    if (!this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.containsKey(Integer.valueOf(paramInt1)))
    {
      QLog.d("AdvertisementInfoModule", 1, "refreshChannelAdvertisementFormServer channelId=" + paramInt1 + " not contained in mChannelID2FixPosArticleAsyncListener");
      pvq.a().a(paramInt1);
    }
    if (this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.containsKey(Integer.valueOf(paramInt1)))
    {
      localObject = (WeakReference)this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.get(Integer.valueOf(paramInt1));
      if ((localObject == null) || (((WeakReference)localObject).get() == null))
      {
        QLog.d("AdvertisementInfoModule", 1, "refreshChannelAdvertisementFormServer channelId=" + paramInt1 + " listener is null");
        pvq.a().a(paramInt1);
      }
    }
    oidb_cmd0x68b.ReqBody localReqBody = new oidb_cmd0x68b.ReqBody();
    long l = Long.valueOf(pha.a()).longValue();
    localReqBody.uint64_uin.set(l);
    localReqBody.uint32_network_type.set(a());
    localReqBody.req_advertise_para.set(a(null, paramInt1, paramInt2, paramInt3, paramInt4, paramnwv));
    Object localObject = qnf.a("OidbSvc.0x68b", 1675, 0, localReqBody.toByteArray());
    ((ToServiceMsg)localObject).getAttributes().put(jdField_d_of_type_JavaLangString, Long.valueOf(paramInt3));
    if ((paramnwv != null) && (paramnwv.jdField_b_of_type_Int == 1))
    {
      ((ToServiceMsg)localObject).getAttributes().put(h, Integer.valueOf(paramnwv.jdField_b_of_type_Int));
      ((ToServiceMsg)localObject).getAttributes().put(f, Integer.valueOf(0));
    }
    for (;;)
    {
      ((ToServiceMsg)localObject).getAttributes().put("adpostype_0x68b", Integer.valueOf(paramInt2));
      if (!pil.c(paramInt1))
      {
        paramnwv = (nwv)localObject;
        if (!bmqa.a(paramInt1)) {}
      }
      else
      {
        localReqBody.bytes_style_version.set(ByteStringMicro.copyFromUtf8(tet.a("default_feeds")));
        paramnwv = (nwv)localObject;
        if (bmqa.w())
        {
          paramnwv = pxs.a(paramInt1);
          if (!TextUtils.isEmpty(paramnwv)) {
            localReqBody.bytes_nearby_cookie.set(ByteStringMicro.copyFromUtf8(paramnwv));
          }
          paramnwv = qnf.a("OidbSvc.0xcba", 3258, 0, localReqBody.toByteArray());
          paramnwv.getAttributes().put("realTimeServiceKey", "default_feeds");
          paramnwv.getAttributes().put(jdField_d_of_type_JavaLangString, Long.valueOf(paramInt3));
        }
      }
      if ((paramInt2 == 5) || (paramInt2 == 6))
      {
        paramnwv.getAttributes().put(i, Integer.valueOf(paramInt1));
        paramnwv.getAttributes().put(f, Integer.valueOf(0));
      }
      a(paramnwv);
      oat.a(null, "", "0X8007BA7", "0X8007BA7", 0, 0, "", "", "", "");
      return;
      ((ToServiceMsg)localObject).getAttributes().put(f, Integer.valueOf(1));
    }
  }
  
  public void a(int paramInt, pxb parampxb)
  {
    if (QLog.isColorLevel()) {
      QLog.d("AdvertisementInfoModule", 2, "setFixPosArticleAsyncListener channelID=" + paramInt);
    }
    this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.put(Integer.valueOf(paramInt), new WeakReference(parampxb));
  }
  
  public void a(int paramInt, boolean paramBoolean)
  {
    if (QLog.isColorLevel()) {
      QLog.d("AdvertisementInfoModule", 2, "async setChannelNeedRequestAdvertisement channelid=" + paramInt + "  bNeed= " + paramBoolean);
    }
    this.e.put(Integer.valueOf(paramInt), Boolean.valueOf(paramBoolean));
  }
  
  public void a(Context paramContext, AdvertisementInfo paramAdvertisementInfo, long paramLong, ArrayList<DislikeInfo> paramArrayList, boolean paramBoolean)
  {
    if (paramAdvertisementInfo == null) {}
    do
    {
      return;
      if (QLog.isColorLevel()) {
        QLog.d("AdvertisementInfoModule", 2, "doUninterestAdvertisement tagId=" + paramLong + ", channelId=" + paramAdvertisementInfo.mChannelID + ", pos=" + paramAdvertisementInfo.mAdKdPos + ", traceID=" + paramAdvertisementInfo.mAdTraceId);
      }
      if (!oqp.b(paramAdvertisementInfo))
      {
        localObject1 = (ConcurrentHashMap)this.jdField_c_of_type_JavaUtilLinkedHashMap.get(Integer.valueOf((int)paramAdvertisementInfo.mChannelID));
        if (localObject1 != null) {
          ((ConcurrentHashMap)localObject1).remove(Integer.valueOf(paramAdvertisementInfo.mAdKdPos));
        }
      }
    } while (paramBoolean);
    Object localObject1 = "";
    Object localObject2 = localObject1;
    int i;
    if (paramArrayList != null)
    {
      i = 0;
      localObject2 = localObject1;
      if (i < paramArrayList.size())
      {
        localObject2 = (DislikeInfo)paramArrayList.get(i);
        if (localObject2 == null) {
          break label367;
        }
        localObject2 = (String)localObject1 + ((DislikeInfo)localObject2).jdField_a_of_type_Long;
        localObject1 = localObject2;
        if (i != paramArrayList.size() - 1) {
          localObject1 = (String)localObject2 + ",";
        }
      }
    }
    label367:
    for (;;)
    {
      i += 1;
      break;
      if (paramAdvertisementInfo.mChannelID == 56L)
      {
        nxw.a(new omp().a(paramContext).a(nxw.jdField_c_of_type_Int).b(nxw.O).a(paramAdvertisementInfo).a((int)paramLong).a((String)localObject2).a());
        return;
      }
      if (pha.a(paramAdvertisementInfo)) {}
      for (i = nxw.S;; i = nxw.N)
      {
        nxw.a(new omp().a(paramContext).a(nxw.jdField_c_of_type_Int).b(i).a(paramAdvertisementInfo).a((int)paramLong).a((String)localObject2).a());
        return;
      }
    }
  }
  
  public void a(AppInterface paramAppInterface, AdvertisementInfo paramAdvertisementInfo)
  {
    try
    {
      Object localObject2 = new JSONObject(paramAdvertisementInfo.mAdExt);
      Object localObject1 = new JSONObject();
      ((JSONObject)localObject1).put("traceid", paramAdvertisementInfo.mAdTraceId);
      ((JSONObject)localObject1).put("rl", paramAdvertisementInfo.mAdRl);
      ((JSONObject)localObject1).put("productid", paramAdvertisementInfo.mAdProductId);
      if (localObject2 == null)
      {
        if (QLog.isColorLevel()) {
          QLog.d("AdvertisementInfoModule", 2, "native object is null");
        }
      }
      else
      {
        JSONObject localJSONObject = new JSONObject();
        localJSONObject.put("videoUrl", paramAdvertisementInfo.mVideoVid);
        localJSONObject.put("coverUrl", paramAdvertisementInfo.mVideoCoverUrl);
        localJSONObject.put("duration", paramAdvertisementInfo.mVideoDuration);
        ((JSONObject)localObject1).put("video", localJSONObject);
        ((JSONObject)localObject1).put("native", ((JSONObject)localObject2).getJSONObject("native"));
        localObject2 = new JSONArray();
        ((JSONArray)localObject2).put(localObject1);
        localObject1 = new JSONObject();
        ((JSONObject)localObject1).put("uin", paramAppInterface.getAccount());
        ((JSONObject)localObject1).put("type", 3);
        ((JSONObject)localObject1).put("ads", localObject2);
        localObject2 = ((JSONObject)localObject1).toString();
        if (QLog.isColorLevel()) {
          QLog.d("AdvertisementInfoModule", 2, "get ad app json: " + (String)localObject2);
        }
        if (!TextUtils.isEmpty((CharSequence)localObject2))
        {
          localObject1 = new WebSsoBody.WebSsoRequestBody();
          ((WebSsoBody.WebSsoRequestBody)localObject1).data.set((String)localObject2);
          localObject2 = new NewIntent(paramAppInterface.getApplication(), oaz.class);
          ((NewIntent)localObject2).putExtra("cmd", "KdAdReportSsoSvr.kandian_ad_native");
          ((NewIntent)localObject2).putExtra("data", ((WebSsoBody.WebSsoRequestBody)localObject1).toByteArray());
          ((NewIntent)localObject2).setObserver(new pvx(this, paramAdvertisementInfo));
          paramAppInterface.startServlet((NewIntent)localObject2);
          return;
        }
      }
    }
    catch (JSONException paramAppInterface)
    {
      paramAppInterface.printStackTrace();
    }
  }
  
  public void a(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    oqh.a("AdDataLink", "onReceiveAD response cmd=" + paramFromServiceMsg.getServiceCmd() + " 广告回包");
    if (!oqp.a.get()) {
      oqp.b();
    }
    if ((paramFromServiceMsg.getServiceCmd().equals("OidbSvc.0x68b")) || (paramFromServiceMsg.getServiceCmd().equals("OidbSvc.0xcba"))) {
      b(paramToServiceMsg, paramFromServiceMsg, paramObject);
    }
    while (!paramFromServiceMsg.getServiceCmd().equals("OidbSvc.0x886")) {
      return;
    }
    c(paramToServiceMsg, paramFromServiceMsg, paramObject);
  }
  
  public void a(ToServiceMsg paramToServiceMsg, oidb_cmd0x68b.RspChannelArticle paramRspChannelArticle, int paramInt1, int paramInt2, boolean paramBoolean)
  {
    if (paramRspChannelArticle == null) {
      return;
    }
    php localphp = new php(Integer.valueOf((int)paramRspChannelArticle.uint64_channel_id.get()));
    if ((((Integer)localphp.a()).intValue() == 0) && (paramInt2 != 0)) {
      localphp.a(Integer.valueOf(paramInt2));
    }
    long l1 = paramRspChannelArticle.uint64_pos_ad_time.get();
    ArrayList localArrayList = new ArrayList();
    Object localObject1 = new php(Boolean.valueOf(false));
    Object localObject2 = new php(Boolean.valueOf(false));
    long l2 = ((Long)paramToServiceMsg.getAttribute(jdField_d_of_type_JavaLangString)).longValue();
    if ((paramRspChannelArticle.rpt_advertise_list.has()) && (paramRspChannelArticle.rpt_advertise_list.get() != null))
    {
      List localList = paramRspChannelArticle.rpt_advertise_list.get();
      if (QLog.isColorLevel()) {
        QLog.d("AdvertisementInfoModule", 2, "handleAdvertisementResp resp.rpt_advertise_list size " + localList.size());
      }
      localArrayList.addAll(a(paramInt2, localphp, l1, (php)localObject1, (php)localObject2, l2, localList));
      a(localArrayList);
      if (((Boolean)((php)localObject1).a()).booleanValue())
      {
        a(localphp, l1, localArrayList);
        return;
      }
      a(paramRspChannelArticle);
    }
    if (((Boolean)((php)localObject2).a()).booleanValue()) {
      a(((Integer)localphp.a()).intValue(), false);
    }
    this.jdField_a_of_type_JavaUtilLinkedHashMap.put(localphp.a(), Long.valueOf(l1));
    if ((paramBoolean) && (l1 > 0L)) {
      this.jdField_b_of_type_JavaUtilLinkedHashMap.put(localphp.a(), Long.valueOf(l1));
    }
    oqh.a("AdvertisementInfoModule", "async makeReqAdvertisePara adinfo, fromRefresh=" + paramBoolean + ", list.size()=" + localArrayList.size() + ",fetchTime=" + l1);
    paramRspChannelArticle = (ConcurrentHashMap)this.jdField_c_of_type_JavaUtilLinkedHashMap.get(localphp.a());
    if (paramRspChannelArticle == null)
    {
      paramRspChannelArticle = new ConcurrentHashMap();
      this.jdField_c_of_type_JavaUtilLinkedHashMap.put(localphp.a(), paramRspChannelArticle);
    }
    for (;;)
    {
      localObject1 = new ConcurrentHashMap();
      paramBoolean = qak.a(paramToServiceMsg);
      if (QLog.isColorLevel()) {
        QLog.d("AdvertisementInfoModule", 2, "handleAdvertisementResp beginSeq = " + l2 + ",isFeedsPreload=" + paramBoolean + ",advertisementInfoMap size " + paramRspChannelArticle.size() + ", channelId=" + localphp.a() + ", fetchTime=" + l1 + ",repeatedreqFlag=" + paramInt1);
      }
      if ((paramBoolean) && (localArrayList.size() <= 0)) {}
      for (paramToServiceMsg = (ToServiceMsg)localObject1;; paramToServiceMsg = paramRspChannelArticle)
      {
        orm.a(((Integer)localphp.a()).intValue(), localArrayList);
        a(localphp, paramToServiceMsg);
        paramToServiceMsg = new StringBuilder("handleAdvertisementResp channelID=" + localphp.a() + ", fetchTime=" + l1 + "\n");
        localObject1 = localArrayList.iterator();
        while (((Iterator)localObject1).hasNext())
        {
          localObject2 = (AdvertisementInfo)((Iterator)localObject1).next();
          paramRspChannelArticle.put(Integer.valueOf(((AdvertisementInfo)localObject2).mAdKdPos), localObject2);
          paramToServiceMsg.append("[pos=").append(((AdvertisementInfo)localObject2).mAdKdPos).append(", traceID=").append(((AdvertisementInfo)localObject2).mAdTraceId).append("]\n");
          if ((((AdvertisementInfo)localObject2).mAdJumpMode == 4) && (TextUtils.isEmpty(((AdvertisementInfo)localObject2).mAdAppJson))) {
            a(this.jdField_a_of_type_ComTencentCommonAppAppInterface, (AdvertisementInfo)localObject2);
          }
        }
        if (l2 != -1L) {
          break;
        }
      }
      localObject2 = localArrayList.iterator();
      for (;;)
      {
        paramToServiceMsg = (ToServiceMsg)localObject1;
        if (!((Iterator)localObject2).hasNext()) {
          break;
        }
        paramToServiceMsg = (AdvertisementInfo)((Iterator)localObject2).next();
        if (paramRspChannelArticle.get(Integer.valueOf(paramToServiceMsg.mAdKdPos)) != null)
        {
          if (QLog.isColorLevel()) {
            QLog.d("AdvertisementInfoModule", 2, "handleAdvertisementResp dropAdvertisements info = " + paramToServiceMsg.toSString());
          }
          ((ConcurrentHashMap)localObject1).put(Integer.valueOf(paramToServiceMsg.mAdKdPos), paramRspChannelArticle.get(Integer.valueOf(paramToServiceMsg.mAdKdPos)));
          paramRspChannelArticle.remove(Integer.valueOf(paramToServiceMsg.mAdKdPos));
        }
      }
      QLog.d("AdvertisementInfoModule", 1, paramToServiceMsg.toString());
      if (QLog.isColorLevel()) {
        QLog.d("AdvertisementInfoModule", 2, "handleAdvertisementResp advertisementInfoMap size " + paramRspChannelArticle.size() + ", channelId=" + localphp.a());
      }
      if (localArrayList.size() != 0) {
        break;
      }
      paramToServiceMsg = new JSONObject();
      try
      {
        paramToServiceMsg.put("svrresp_result", 1);
        paramToServiceMsg.put("svrresp_fail_type", 1);
        nxw.a(new omp().a(BaseApplication.getContext()).a(nxw.k).b(nxw.U).b(paramToServiceMsg).a());
        oqh.a("AdDataLink", "handleAdvertisementResp channelID=" + localphp.a() + ", fetchTime=" + l1 + " parsedAdvertisementList empty!");
        return;
      }
      catch (JSONException paramRspChannelArticle)
      {
        for (;;)
        {
          paramRspChannelArticle.printStackTrace();
        }
      }
    }
  }
  
  public boolean a(int paramInt)
  {
    if (this.e.containsKey(Integer.valueOf(paramInt))) {
      return ((Boolean)this.e.get(Integer.valueOf(paramInt))).booleanValue();
    }
    return true;
  }
  
  public int[] a(int paramInt)
  {
    ArrayList localArrayList = b(paramInt);
    if (localArrayList.size() <= 0)
    {
      oqh.a("AdDataLink", "getFixPositionSync channelID=" + paramInt + " return empty!");
      return new int[0];
    }
    int[] arrayOfInt = new int[localArrayList.size()];
    StringBuilder localStringBuilder = new StringBuilder("[");
    int i = 0;
    while (i < localArrayList.size())
    {
      arrayOfInt[i] = ((AdvertisementInfo)localArrayList.get(i)).mAdKdPos;
      localStringBuilder.append(arrayOfInt[i]);
      if (i != localArrayList.size() - 1) {
        localStringBuilder.append(", ");
      }
      i += 1;
    }
    localStringBuilder.append("]");
    oqh.a("AdDataLink", "getFixPositionSync channelID=" + paramInt + " return " + localStringBuilder.toString());
    return arrayOfInt;
  }
  
  public AdvertisementInfo b(int paramInt1, int paramInt2)
  {
    Object localObject = (ConcurrentHashMap)this.jdField_c_of_type_JavaUtilLinkedHashMap.get(Integer.valueOf(paramInt1));
    if (localObject == null)
    {
      oqh.a("AdVideoDataLink", "removeAdvertisementInfo channelId=" + paramInt1 + " map is null!");
      return null;
    }
    localObject = (AdvertisementInfo)((ConcurrentHashMap)localObject).remove(Integer.valueOf(paramInt2));
    if (localObject != null)
    {
      oqh.a("AdVideoDataLink", "removeAdvertisementInfo channelId=" + paramInt1 + " advertisementInfo = " + ((AdvertisementInfo)localObject).mTitle + " pos = " + ((AdvertisementInfo)localObject).mAdKdPos);
      return localObject;
    }
    return null;
  }
  
  public ArrayList<AdvertisementInfo> b(int paramInt)
  {
    ArrayList localArrayList = new ArrayList();
    Object localObject = (ConcurrentHashMap)this.jdField_c_of_type_JavaUtilLinkedHashMap.get(Integer.valueOf(paramInt));
    if ((localObject != null) && (((ConcurrentHashMap)localObject).size() > 0))
    {
      localObject = ((ConcurrentHashMap)localObject).values().iterator();
      while (((Iterator)localObject).hasNext()) {
        localArrayList.add((AdvertisementInfo)((Iterator)localObject).next());
      }
      Collections.sort(localArrayList, new pvv(this));
    }
    if (!QLog.isColorLevel()) {
      return localArrayList;
    }
    localObject = new StringBuilder("\n");
    int i = 0;
    while (i < localArrayList.size())
    {
      AdvertisementInfo localAdvertisementInfo = (AdvertisementInfo)localArrayList.get(i);
      ((StringBuilder)localObject).append("[pos=").append(localAdvertisementInfo.mAdKdPos).append(", traceID=").append(localAdvertisementInfo.mAdTraceId).append("]");
      if (i != localArrayList.size() - 1) {
        ((StringBuilder)localObject).append("\n");
      }
      i += 1;
    }
    oqh.a("AdDataLink", "loadChannelAdvertisement channelId=" + paramInt + " return " + ((StringBuilder)localObject).toString());
    return localArrayList;
  }
  
  public void b()
  {
    if (QLog.isColorLevel()) {
      QLog.d("AdvertisementInfoModule", 2, "unInitModel!");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     pvu
 * JD-Core Version:    0.7.0.1
 */