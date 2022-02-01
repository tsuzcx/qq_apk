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
import com.tencent.gdtad.util.GdtDeviceInfoHelper;
import com.tencent.gdtad.util.GdtDeviceInfoHelper.Params;
import com.tencent.gdtad.util.GdtDeviceInfoHelper.Result;
import com.tencent.mobileqq.WebSsoBody.WebSsoRequestBody;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.mobileqq.persistence.EntityManager;
import com.tencent.mobileqq.utils.DeviceInfoUtil;
import com.tencent.mobileqq.utils.NetworkUtil;
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
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ExecutorService;
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

public class qel
  extends qhj
{
  public static int a;
  public static int b;
  public static int c;
  private LinkedHashMap<Integer, Long> jdField_a_of_type_JavaUtilLinkedHashMap = new LinkedHashMap();
  private ConcurrentHashMap<Integer, WeakReference<qfo>> jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap = new ConcurrentHashMap();
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
  
  public qel(AppInterface paramAppInterface, EntityManager paramEntityManager, ExecutorService paramExecutorService, qxn paramqxn, Handler paramHandler)
  {
    super(paramAppInterface, paramEntityManager, paramExecutorService, paramqxn, paramHandler);
    this.jdField_c_of_type_JavaUtilLinkedHashMap = new LinkedHashMap();
    this.jdField_d_of_type_JavaUtilLinkedHashMap = new LinkedHashMap();
    if (QLog.isColorLevel()) {
      QLog.d("AdvertisementInfoModule", 2, "construct!");
    }
  }
  
  private int a()
  {
    switch (NetworkUtil.getSystemNetwork(BaseApplication.getContext()))
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
        Collections.sort((List)localObject1, new qen(this));
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
  private List<AdvertisementInfo> a(int paramInt, pko<Integer> parampko, long paramLong1, pko<Boolean> parampko1, pko<Boolean> parampko2, long paramLong2, List<tencent.im.oidb.articlesummary.articlesummary.ArticleSummary> paramList)
  {
    // Byte code:
    //   0: new 81	java/util/ArrayList
    //   3: dup
    //   4: invokespecial 82	java/util/ArrayList:<init>	()V
    //   7: astore 17
    //   9: aload 9
    //   11: invokeinterface 149 1 0
    //   16: astore 9
    //   18: iconst_0
    //   19: istore 10
    //   21: aload 9
    //   23: invokeinterface 110 1 0
    //   28: ifeq +671 -> 699
    //   31: aload 9
    //   33: invokeinterface 114 1 0
    //   38: checkcast 151	tencent/im/oidb/articlesummary/articlesummary$ArticleSummary
    //   41: astore 19
    //   43: aload 19
    //   45: getfield 155	tencent/im/oidb/articlesummary/articlesummary$ArticleSummary:msg_feeds_info	Ltencent/im/oidb/articlesummary/articlesummary$FeedsInfo;
    //   48: invokevirtual 160	tencent/im/oidb/articlesummary/articlesummary$FeedsInfo:has	()Z
    //   51: ifeq +654 -> 705
    //   54: aload 19
    //   56: getfield 155	tencent/im/oidb/articlesummary/articlesummary$ArticleSummary:msg_feeds_info	Ltencent/im/oidb/articlesummary/articlesummary$FeedsInfo;
    //   59: invokevirtual 163	tencent/im/oidb/articlesummary/articlesummary$FeedsInfo:get	()Lcom/tencent/mobileqq/pb/MessageMicro;
    //   62: checkcast 157	tencent/im/oidb/articlesummary/articlesummary$FeedsInfo
    //   65: getfield 167	tencent/im/oidb/articlesummary/articlesummary$FeedsInfo:msg_pos_ad_info	Ltencent/im/oidb/articlesummary/articlesummary$PosAdInfo;
    //   68: invokevirtual 170	tencent/im/oidb/articlesummary/articlesummary$PosAdInfo:has	()Z
    //   71: ifeq +634 -> 705
    //   74: aload 19
    //   76: getfield 155	tencent/im/oidb/articlesummary/articlesummary$ArticleSummary:msg_feeds_info	Ltencent/im/oidb/articlesummary/articlesummary$FeedsInfo;
    //   79: invokevirtual 163	tencent/im/oidb/articlesummary/articlesummary$FeedsInfo:get	()Lcom/tencent/mobileqq/pb/MessageMicro;
    //   82: checkcast 157	tencent/im/oidb/articlesummary/articlesummary$FeedsInfo
    //   85: getfield 167	tencent/im/oidb/articlesummary/articlesummary$FeedsInfo:msg_pos_ad_info	Ltencent/im/oidb/articlesummary/articlesummary$PosAdInfo;
    //   88: invokevirtual 171	tencent/im/oidb/articlesummary/articlesummary$PosAdInfo:get	()Lcom/tencent/mobileqq/pb/MessageMicro;
    //   91: checkcast 169	tencent/im/oidb/articlesummary/articlesummary$PosAdInfo
    //   94: astore 18
    //   96: aload 18
    //   98: ifnull +607 -> 705
    //   101: aload 18
    //   103: getfield 175	tencent/im/oidb/articlesummary/articlesummary$PosAdInfo:int32_ret	Lcom/tencent/mobileqq/pb/PBInt32Field;
    //   106: invokevirtual 179	com/tencent/mobileqq/pb/PBInt32Field:get	()I
    //   109: ifne +596 -> 705
    //   112: aload 18
    //   114: getfield 183	tencent/im/oidb/articlesummary/articlesummary$PosAdInfo:enum_pos_layout	Lcom/tencent/mobileqq/pb/PBEnumField;
    //   117: invokevirtual 186	com/tencent/mobileqq/pb/PBEnumField:get	()I
    //   120: istore 11
    //   122: aload 18
    //   124: getfield 190	tencent/im/oidb/articlesummary/articlesummary$PosAdInfo:uint64_pos_id	Lcom/tencent/mobileqq/pb/PBUInt64Field;
    //   127: invokevirtual 195	com/tencent/mobileqq/pb/PBUInt64Field:get	()J
    //   130: lstore 12
    //   132: aload 18
    //   134: getfield 198	tencent/im/oidb/articlesummary/articlesummary$PosAdInfo:is_auto_play	Lcom/tencent/mobileqq/pb/PBUInt64Field;
    //   137: invokevirtual 195	com/tencent/mobileqq/pb/PBUInt64Field:get	()J
    //   140: lstore 14
    //   142: aload 18
    //   144: getfield 202	tencent/im/oidb/articlesummary/articlesummary$PosAdInfo:msg_ad_info	Ltencent/im/oidb/articlesummary/articlesummary$AdInfo;
    //   147: invokevirtual 205	tencent/im/oidb/articlesummary/articlesummary$AdInfo:get	()Lcom/tencent/mobileqq/pb/MessageMicro;
    //   150: checkcast 204	tencent/im/oidb/articlesummary/articlesummary$AdInfo
    //   153: astore 18
    //   155: aload_0
    //   156: iload_1
    //   157: aload_2
    //   158: aload 18
    //   160: invokespecial 208	qel:a	(ILpko;Ltencent/im/oidb/articlesummary/articlesummary$AdInfo;)V
    //   163: new 116	com/tencent/biz/pubaccount/readinjoy/struct/AdvertisementInfo
    //   166: dup
    //   167: aload 18
    //   169: invokespecial 211	com/tencent/biz/pubaccount/readinjoy/struct/AdvertisementInfo:<init>	(Ltencent/im/oidb/articlesummary/articlesummary$AdInfo;)V
    //   172: astore 18
    //   174: aload 18
    //   176: invokestatic 216	uks:a	(Lcom/tencent/biz/pubaccount/readinjoy/struct/AdvertisementInfo;)V
    //   179: aload 19
    //   181: aload_2
    //   182: invokevirtual 220	pko:a	()Ljava/lang/Object;
    //   185: checkcast 84	java/lang/Integer
    //   188: invokevirtual 223	java/lang/Integer:intValue	()I
    //   191: iconst_0
    //   192: aload 18
    //   194: invokestatic 228	qxm:a	(Ltencent/im/oidb/articlesummary/articlesummary$ArticleSummary;IILcom/tencent/biz/pubaccount/readinjoy/struct/ArticleInfo;)Lcom/tencent/biz/pubaccount/readinjoy/struct/ArticleInfo;
    //   197: pop
    //   198: aload 18
    //   200: lload_3
    //   201: putfield 232	com/tencent/biz/pubaccount/readinjoy/struct/AdvertisementInfo:mAdFetchTime	J
    //   204: aload 18
    //   206: iload 11
    //   208: putfield 235	com/tencent/biz/pubaccount/readinjoy/struct/AdvertisementInfo:mAdPosLayout	I
    //   211: aload 18
    //   213: lload 12
    //   215: putfield 238	com/tencent/biz/pubaccount/readinjoy/struct/AdvertisementInfo:mAdPosID	J
    //   218: aload 18
    //   220: lload 14
    //   222: putfield 241	com/tencent/biz/pubaccount/readinjoy/struct/AdvertisementInfo:mADVideoAutoPlay	J
    //   225: ldc 243
    //   227: new 245	java/lang/StringBuilder
    //   230: dup
    //   231: invokespecial 246	java/lang/StringBuilder:<init>	()V
    //   234: ldc 248
    //   236: invokevirtual 252	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   239: aload 18
    //   241: getfield 137	com/tencent/biz/pubaccount/readinjoy/struct/AdvertisementInfo:mAdKdPos	I
    //   244: invokevirtual 255	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   247: invokevirtual 259	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   250: invokestatic 264	ukq:a	(Ljava/lang/String;Ljava/lang/String;)V
    //   253: lload 7
    //   255: ldc2_w 265
    //   258: lcmp
    //   259: ifne +443 -> 702
    //   262: iload 10
    //   264: ifne +438 -> 702
    //   267: aload 18
    //   269: getfield 270	com/tencent/biz/pubaccount/readinjoy/struct/AdvertisementInfo:mAdvertisementExtInfo	Lufz;
    //   272: ifnull +430 -> 702
    //   275: aload 18
    //   277: getfield 270	com/tencent/biz/pubaccount/readinjoy/struct/AdvertisementInfo:mAdvertisementExtInfo	Lufz;
    //   280: getfield 275	ufz:f	I
    //   283: ifle +419 -> 702
    //   286: aload_0
    //   287: aload_2
    //   288: aload 18
    //   290: invokespecial 278	qel:a	(Lpko;Lcom/tencent/biz/pubaccount/readinjoy/struct/AdvertisementInfo;)V
    //   293: iconst_1
    //   294: istore 10
    //   296: invokestatic 282	pju:a	()Z
    //   299: ifeq +13 -> 312
    //   302: invokestatic 285	pju:a	()Lpju;
    //   305: aload 19
    //   307: aload 18
    //   309: invokevirtual 288	pju:a	(Ltencent/im/oidb/articlesummary/articlesummary$ArticleSummary;Lcom/tencent/biz/pubaccount/readinjoy/struct/ArticleInfo;)V
    //   312: getstatic 293	ujx:a	Lujx;
    //   315: aload 18
    //   317: invokevirtual 294	ujx:a	(Lcom/tencent/biz/pubaccount/readinjoy/struct/AdvertisementInfo;)V
    //   320: invokestatic 58	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   323: ifeq +61 -> 384
    //   326: ldc 60
    //   328: iconst_2
    //   329: new 245	java/lang/StringBuilder
    //   332: dup
    //   333: invokespecial 246	java/lang/StringBuilder:<init>	()V
    //   336: ldc_w 296
    //   339: invokevirtual 252	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   342: aload 18
    //   344: getfield 137	com/tencent/biz/pubaccount/readinjoy/struct/AdvertisementInfo:mAdKdPos	I
    //   347: invokevirtual 255	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   350: ldc_w 298
    //   353: invokevirtual 252	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   356: aload 18
    //   358: invokevirtual 299	com/tencent/biz/pubaccount/readinjoy/struct/AdvertisementInfo:toString	()Ljava/lang/String;
    //   361: invokevirtual 252	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   364: ldc_w 301
    //   367: invokevirtual 252	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   370: aload 18
    //   372: getfield 305	com/tencent/biz/pubaccount/readinjoy/struct/AdvertisementInfo:mAdExtInfo	Ljava/lang/String;
    //   375: invokevirtual 252	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   378: invokevirtual 259	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   381: invokestatic 65	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   384: aload 18
    //   386: getfield 305	com/tencent/biz/pubaccount/readinjoy/struct/AdvertisementInfo:mAdExtInfo	Ljava/lang/String;
    //   389: invokestatic 311	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   392: istore 16
    //   394: iload 16
    //   396: ifne +154 -> 550
    //   399: new 313	org/json/JSONObject
    //   402: dup
    //   403: aload 18
    //   405: getfield 305	com/tencent/biz/pubaccount/readinjoy/struct/AdvertisementInfo:mAdExtInfo	Ljava/lang/String;
    //   408: invokespecial 316	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   411: astore 19
    //   413: aload 19
    //   415: ldc_w 318
    //   418: invokevirtual 321	org/json/JSONObject:has	(Ljava/lang/String;)Z
    //   421: ifeq +33 -> 454
    //   424: aload 19
    //   426: ldc_w 318
    //   429: invokevirtual 325	org/json/JSONObject:getInt	(Ljava/lang/String;)I
    //   432: iconst_2
    //   433: if_icmpne +21 -> 454
    //   436: aload 6
    //   438: iconst_1
    //   439: invokestatic 330	java/lang/Boolean:valueOf	(Z)Ljava/lang/Boolean;
    //   442: invokevirtual 333	pko:a	(Ljava/lang/Object;)V
    //   445: ldc 60
    //   447: iconst_1
    //   448: ldc_w 335
    //   451: invokestatic 65	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   454: invokestatic 58	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   457: ifeq +33 -> 490
    //   460: ldc 60
    //   462: iconst_2
    //   463: new 245	java/lang/StringBuilder
    //   466: dup
    //   467: invokespecial 246	java/lang/StringBuilder:<init>	()V
    //   470: ldc_w 337
    //   473: invokevirtual 252	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   476: aload 19
    //   478: invokevirtual 338	org/json/JSONObject:toString	()Ljava/lang/String;
    //   481: invokevirtual 252	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   484: invokevirtual 259	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   487: invokestatic 65	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   490: getstatic 343	uje:a	Luje;
    //   493: aload 18
    //   495: invokevirtual 344	uje:a	(Ljava/lang/Object;)V
    //   498: aload 18
    //   500: invokestatic 349	ukv:a	(Lcom/tencent/biz/pubaccount/readinjoy/struct/AdvertisementInfo;)Z
    //   503: ifeq +47 -> 550
    //   506: aload 5
    //   508: iconst_1
    //   509: invokestatic 330	java/lang/Boolean:valueOf	(Z)Ljava/lang/Boolean;
    //   512: invokevirtual 333	pko:a	(Ljava/lang/Object;)V
    //   515: goto -494 -> 21
    //   518: astore 19
    //   520: ldc 60
    //   522: iconst_1
    //   523: new 245	java/lang/StringBuilder
    //   526: dup
    //   527: invokespecial 246	java/lang/StringBuilder:<init>	()V
    //   530: ldc_w 351
    //   533: invokevirtual 252	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   536: aload 19
    //   538: invokevirtual 354	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   541: invokevirtual 252	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   544: invokevirtual 259	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   547: invokestatic 356	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   550: aload_0
    //   551: aload 18
    //   553: invokespecial 357	qel:a	(Lcom/tencent/biz/pubaccount/readinjoy/struct/AdvertisementInfo;)Z
    //   556: ifne +103 -> 659
    //   559: aload 18
    //   561: aconst_null
    //   562: invokestatic 362	ukr:a	(Lcom/tencent/biz/pubaccount/readinjoy/struct/AdvertisementInfo;Lcom/tencent/biz/pubaccount/VideoAdInfo;)Z
    //   565: ifeq +71 -> 636
    //   568: new 313	org/json/JSONObject
    //   571: dup
    //   572: invokespecial 363	org/json/JSONObject:<init>	()V
    //   575: astore 19
    //   577: aload 19
    //   579: ldc_w 365
    //   582: iconst_0
    //   583: invokevirtual 369	org/json/JSONObject:put	(Ljava/lang/String;I)Lorg/json/JSONObject;
    //   586: pop
    //   587: aload 19
    //   589: ldc_w 371
    //   592: iconst_1
    //   593: invokevirtual 369	org/json/JSONObject:put	(Ljava/lang/String;I)Lorg/json/JSONObject;
    //   596: pop
    //   597: new 373	ufy
    //   600: dup
    //   601: invokespecial 374	ufy:<init>	()V
    //   604: invokestatic 72	com/tencent/qphone/base/util/BaseApplication:getContext	()Lcom/tencent/qphone/base/util/BaseApplication;
    //   607: invokevirtual 377	ufy:a	(Landroid/content/Context;)Lufy;
    //   610: bipush 80
    //   612: invokevirtual 380	ufy:a	(I)Lufy;
    //   615: bipush 12
    //   617: invokevirtual 382	ufy:b	(I)Lufy;
    //   620: aload 18
    //   622: invokevirtual 385	ufy:a	(Lcom/tencent/biz/pubaccount/readinjoy/struct/AdvertisementInfo;)Lufy;
    //   625: aload 19
    //   627: invokevirtual 388	ufy:b	(Lorg/json/JSONObject;)Lufy;
    //   630: invokevirtual 391	ufy:a	()Lufw;
    //   633: invokestatic 396	ois:a	(Lufw;)V
    //   636: aload 17
    //   638: aload 18
    //   640: invokeinterface 397 2 0
    //   645: pop
    //   646: goto -625 -> 21
    //   649: astore 20
    //   651: aload 20
    //   653: invokevirtual 400	org/json/JSONException:printStackTrace	()V
    //   656: goto -59 -> 597
    //   659: invokestatic 58	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   662: ifeq +33 -> 695
    //   665: ldc 60
    //   667: iconst_2
    //   668: new 245	java/lang/StringBuilder
    //   671: dup
    //   672: invokespecial 246	java/lang/StringBuilder:<init>	()V
    //   675: ldc_w 402
    //   678: invokevirtual 252	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   681: aload 18
    //   683: invokevirtual 405	com/tencent/biz/pubaccount/readinjoy/struct/AdvertisementInfo:toSString	()Ljava/lang/String;
    //   686: invokevirtual 252	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   689: invokevirtual 259	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   692: invokestatic 65	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   695: goto -49 -> 646
    //   698: astore_2
    //   699: aload 17
    //   701: areturn
    //   702: goto -406 -> 296
    //   705: goto -59 -> 646
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	708	0	this	qel
    //   0	708	1	paramInt	int
    //   0	708	2	parampko	pko<Integer>
    //   0	708	3	paramLong1	long
    //   0	708	5	parampko1	pko<Boolean>
    //   0	708	6	parampko2	pko<Boolean>
    //   0	708	7	paramLong2	long
    //   0	708	9	paramList	List<tencent.im.oidb.articlesummary.articlesummary.ArticleSummary>
    //   19	276	10	i	int
    //   120	87	11	j	int
    //   130	84	12	l1	long
    //   140	81	14	l2	long
    //   392	3	16	bool	boolean
    //   7	693	17	localArrayList	ArrayList
    //   94	588	18	localObject1	Object
    //   41	436	19	localObject2	Object
    //   518	19	19	localException	Exception
    //   575	51	19	localJSONObject	JSONObject
    //   649	3	20	localJSONException	JSONException
    // Exception table:
    //   from	to	target	type
    //   384	394	518	java/lang/Exception
    //   577	597	649	org/json/JSONException
    //   399	454	698	java/lang/Exception
    //   454	490	698	java/lang/Exception
    //   490	515	698	java/lang/Exception
  }
  
  private void a(int paramInt, pko<Integer> parampko, articlesummary.AdInfo paramAdInfo)
  {
    if ((paramAdInfo != null) && (paramInt == 0))
    {
      parampko.a(Integer.valueOf((int)paramAdInfo.uint64_channel_id.get()));
      ukq.a("AdDataLink", "handleAdvertisementResp channelID from AdInfo:" + parampko.a());
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
        ukq.a("AdDataLink", " ]");
      }
    }
    else {
      return;
    }
    ukq.a("AdDataLink", "handleAdvertisementResp no advertisementInfo");
  }
  
  private void a(List<AdvertisementInfo> paramList)
  {
    if ((paramList == null) || (paramList.size() == 0)) {
      return;
    }
    HashSet localHashSet = new HashSet(paramList.size());
    Iterator localIterator = paramList.iterator();
    paramList = null;
    int i;
    while (localIterator.hasNext())
    {
      AdvertisementInfo localAdvertisementInfo = (AdvertisementInfo)localIterator.next();
      if ((localAdvertisementInfo.mAdvertisementExtInfo == null) || (localAdvertisementInfo.mAdvertisementExtInfo.j == 32))
      {
        localHashSet.add(Long.valueOf(localAdvertisementInfo.mAdAid));
        if (paramList == null)
        {
          i = (int)localAdvertisementInfo.mChannelID;
          if (!plm.c(i)) {
            break label187;
          }
          paramList = "RIJAdRefreshSceneDaily";
        }
      }
    }
    label187:
    for (;;)
    {
      if (i == 0) {
        paramList = "RIJAdRefreshSceneMainFeeds";
      }
      if (56 == i) {
        paramList = "RIJAdRefreshSceneVideoTab";
      }
      if ((78888888 == i) || (78888889 == i) || (88888888 == i)) {
        paramList = "RIJAdRefreshSceneFloatVideo";
      }
      break;
      if (paramList == null)
      {
        QLog.d("AdvertisementInfoModule", 2, "handleAdFreshness,scene is null");
        return;
      }
      odz.a().a(paramList, localHashSet);
      return;
    }
  }
  
  private void a(pko<Integer> parampko, long paramLong, ArrayList<AdvertisementInfo> paramArrayList)
  {
    if (paramArrayList.size() == 0) {
      paramArrayList = new JSONObject();
    }
    try
    {
      paramArrayList.put("svrresp_result", 1);
      paramArrayList.put("svrresp_fail_type", 1);
      ois.a(new ufy().a(BaseApplication.getContext()).a(80).b(12).b(paramArrayList).a());
      if (QLog.isColorLevel()) {
        QLog.d("AdvertisementInfoModule", 1, "handleAdvertisementResp channelID=" + parampko.a() + ", fetchTime=" + paramLong + " parsedAdvertisementList empty!");
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
  
  private void a(pko<Integer> parampko, AdvertisementInfo paramAdvertisementInfo)
  {
    jdField_a_of_type_Int = paramAdvertisementInfo.mAdvertisementExtInfo.f;
    ukq.a("AdDataLink", "async handleAdvertisementResp refreshLastPosX= +" + jdField_a_of_type_Int);
    a(((Integer)parampko.a()).intValue(), 0, jdField_a_of_type_Int);
    if (paramAdvertisementInfo.mAdvertisementExtInfo.h > 0)
    {
      jdField_b_of_type_Int = paramAdvertisementInfo.mAdvertisementExtInfo.h;
      ukq.a("AdDataLink", "async handleAdvertisementResp refreshLastPosZ= +" + jdField_b_of_type_Int);
    }
    if (paramAdvertisementInfo.mAdvertisementExtInfo.g > 0)
    {
      jdField_c_of_type_Int = paramAdvertisementInfo.mAdvertisementExtInfo.g;
      ukq.a("AdDataLink", "async handleAdvertisementResp refreshLastPosY= +" + jdField_c_of_type_Int);
    }
  }
  
  private void a(pko<Integer> parampko, ConcurrentHashMap<Integer, AdvertisementInfo> paramConcurrentHashMap)
  {
    if (QLog.isColorLevel()) {
      QLog.d("AdvertisementInfoModule", 2, "handleAdvertisementResp dropAdvertisements size = " + paramConcurrentHashMap.size());
    }
    Iterator localIterator = paramConcurrentHashMap.values().iterator();
    while (localIterator.hasNext())
    {
      AdvertisementInfo localAdvertisementInfo = (AdvertisementInfo)localIterator.next();
      pvj.a().a(((Integer)parampko.a()).intValue(), localAdvertisementInfo);
    }
    paramConcurrentHashMap.clear();
  }
  
  private void a(qxs paramqxs, int paramInt1, int paramInt2, int paramInt3, int paramInt4, oha paramoha, qq_ad_get.QQAdGet.DeviceInfo paramDeviceInfo, oidb_cmd0x68b.ReqAdvertisePara paramReqAdvertisePara)
  {
    JSONObject localJSONObject;
    for (;;)
    {
      try
      {
        localJSONObject = new JSONObject();
        localJSONObject.put("adPosType", paramInt2);
        localJSONObject.put("adStartPos", paramInt3);
        localJSONObject.put("adEndPos", paramInt4);
        if ((paramoha != null) && (paramoha.a()))
        {
          localJSONObject.put("MaterialId", paramoha.jdField_a_of_type_Int);
          localJSONObject.put("RepeatedReqFlag", paramoha.jdField_b_of_type_Int);
          localJSONObject.put("KdPos", paramoha.jdField_c_of_type_Int);
          localJSONObject.put("adPosId", paramoha.jdField_a_of_type_Long);
        }
        if (!qku.b(paramqxs)) {
          break label335;
        }
        localJSONObject.put("adRequestFlag", a(paramInt1));
        if (this.jdField_b_of_type_JavaUtilLinkedHashMap.get(Integer.valueOf(paramInt1)) == null)
        {
          l = 0L;
          localJSONObject.put("lastRefreshTime", l);
          ugk.a(paramoha, localJSONObject, paramInt1, paramInt2);
          ugk.a(paramoha, localJSONObject, paramInt2);
          ugk.b(paramoha, localJSONObject, paramInt2);
          if (bdvn.a()) {
            localJSONObject.put("reqLearningPatternFlag", 1);
          }
          ugk.a(paramoha, localJSONObject);
          localJSONObject.put("reqTimeVVAdload", 1);
          if (paramDeviceInfo != null) {
            localJSONObject.put("device_ext", paramDeviceInfo.device_ext.get());
          }
          paramoha = odz.a().a();
          paramqxs = new JSONArray();
          if ((paramoha == null) || (paramoha.size() <= 0)) {
            break;
          }
          paramoha = paramoha.iterator();
          if (!paramoha.hasNext()) {
            break;
          }
          paramqxs.put((Long)paramoha.next());
          continue;
        }
        long l = ((Long)this.jdField_b_of_type_JavaUtilLinkedHashMap.get(Integer.valueOf(paramInt1))).longValue();
      }
      catch (JSONException paramqxs)
      {
        paramqxs.printStackTrace();
        return;
      }
      continue;
      label335:
      localJSONObject.put("adRequestFlag", 0);
    }
    localJSONObject.put("noExposeList", paramqxs);
    paramReqAdvertisePara.bytes_ad_user_info.set(ByteStringMicro.copyFromUtf8(localJSONObject.toString()));
    QLog.d("AdvertisementInfoModule", 1, "async makeReqAdvertisePara adinfo," + localJSONObject.toString());
  }
  
  private void a(qq_ad_get.QQAdGet.DeviceInfo paramDeviceInfo, oidb_cmd0x68b.PhoneInfo paramPhoneInfo)
  {
    if (paramDeviceInfo.qadid.has()) {
      paramPhoneInfo.string_qadid.set(paramDeviceInfo.qadid.get());
    }
    if (paramDeviceInfo.md5_android_id.has()) {
      paramPhoneInfo.string_androidid.set(paramDeviceInfo.md5_android_id.get());
    }
    if (paramDeviceInfo.md5_mac.has()) {
      paramPhoneInfo.string_mac.set(paramDeviceInfo.md5_mac.get());
    }
    if (paramDeviceInfo.aid_ticket.has()) {
      paramPhoneInfo.string_oaid.set(paramDeviceInfo.aid_ticket.get());
    }
    if (paramDeviceInfo.taid_ticket.has()) {
      paramPhoneInfo.string_taid.set(paramDeviceInfo.taid_ticket.get());
    }
    if (paramDeviceInfo.client_ipv4.has()) {
      paramPhoneInfo.string_client_ipv4.set(paramDeviceInfo.client_ipv4.get());
    }
    if (QLog.isColorLevel()) {
      QLog.i("AdvertisementInfoModule", 2, "makeReqAdvertisePara: deviceInfo: ma=" + paramPhoneInfo.string_androidid.get() + ", mm=" + paramPhoneInfo.string_mac.get() + ", oa=" + paramPhoneInfo.string_oaid.get() + ", ta=" + paramPhoneInfo.string_taid.get());
    }
  }
  
  private void a(oidb_cmd0x68b.RspChannelArticle paramRspChannelArticle)
  {
    if (paramRspChannelArticle.msg_ad_pos_map.has())
    {
      paramRspChannelArticle = (oidb_cmd0x68b.AdPosMap)paramRspChannelArticle.msg_ad_pos_map.get();
      if (paramRspChannelArticle.bytes_ads_context.has())
      {
        ois.a(paramRspChannelArticle.bytes_ads_context.get().toStringUtf8());
        return;
      }
      ois.a("");
      return;
    }
    ois.a("");
  }
  
  private boolean a(AdvertisementInfo paramAdvertisementInfo)
  {
    boolean bool = false;
    if (paramAdvertisementInfo == null) {}
    while (TextUtils.isEmpty(paramAdvertisementInfo.mTitle)) {
      return true;
    }
    if (uks.k(paramAdvertisementInfo))
    {
      ukq.a("ReadInJoySuperMaskAd", "filterAdvertisementInfo: isSuperMaskNormalAdType");
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
    oidb_cmd0x68b.RspBody localRspBody = new oidb_cmd0x68b.RspBody();
    int i = qxp.a(paramFromServiceMsg, paramObject, localRspBody);
    int k = ((Integer)paramToServiceMsg.getAttribute(h, Integer.valueOf(0))).intValue();
    if (QLog.isColorLevel()) {
      QLog.d("AdvertisementInfoModule", 2, "handle0x68bGetAdvertisementList! result=" + i + ",repeatedreqFlag=" + k);
    }
    int j = ((Integer)paramToServiceMsg.getAttribute(i, Integer.valueOf(0))).intValue();
    ((Integer)paramToServiceMsg.getAttribute(j, Integer.valueOf(-1))).intValue();
    if (QLog.isColorLevel()) {
      QLog.d("AdvertisementInfoModule", 2, "handle0x68bGetAdvertisementList! result=" + i + ",asyncChannelId=" + j);
    }
    ult.a(j);
    ukq.a("AdDataLink", "handle0x68bGetAdvertisementList result = " + i);
    if (i == 0) {
      if (!localRspBody.uint64_uin.has()) {
        break label796;
      }
    }
    label793:
    label796:
    for (long l = localRspBody.uint64_uin.get();; l = -1L)
    {
      if ((localRspBody.rspChannelArticle.has()) && (localRspBody.rspChannelArticle.get() != null) && (String.valueOf(l).equals(this.jdField_a_of_type_ComTencentCommonAppAppInterface.getCurrentAccountUin())))
      {
        paramFromServiceMsg = (oidb_cmd0x68b.RspChannelArticle)localRspBody.rspChannelArticle.get();
        i = (int)paramFromServiceMsg.uint64_channel_id.get();
        if ((i != 0) || (j == 0)) {
          break label793;
        }
        i = j;
      }
      for (;;)
      {
        ukq.a("AdDataLink", "handleAdvertisementResp 处理广告");
        boolean bool;
        if ((paramFromServiceMsg.rpt_advertise_list.has()) && (paramFromServiceMsg.rpt_advertise_list.get() != null))
        {
          ukq.a("AdDataLink", "handleAdvertisementResp in ad Request");
          paramObject = new pko(Boolean.valueOf(false));
          a(paramToServiceMsg, paramFromServiceMsg, k, j, false, paramObject);
          bool = ((Boolean)paramObject.a()).booleanValue();
        }
        for (;;)
        {
          if ((this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.containsKey(Integer.valueOf(i))) && (!bool))
          {
            paramToServiceMsg = (WeakReference)this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.get(Integer.valueOf(i));
            if ((paramToServiceMsg != null) && (paramToServiceMsg.get() != null))
            {
              QLog.d("AdvertisementInfoModule", 1, "handle0x68bGetAdvertisementList listener = " + paramToServiceMsg.toString());
              ((qfo)paramToServiceMsg.get()).a(i);
            }
          }
          return;
          if (k == 1)
          {
            ukq.a("AdDataLink", "handle0x68bGetAdvertisementList 重复曝光加载数据返回空");
            bool = true;
          }
          else
          {
            ukq.a("AdDataLink", "handleAdvertisementResp channelArticle.rpt_advertise_list.has() = " + paramFromServiceMsg.rpt_advertise_list.has() + " channelArticle.rpt_advertise_list.get() = " + paramFromServiceMsg.rpt_advertise_list.get() + " repeatedreqFlag = " + k);
            bool = true;
          }
        }
        ukq.a("AdDataLink", "handle0x68bGetAdvertisementList resp.rspChannelArticle.has() = " + localRspBody.rspChannelArticle.has() + " uin = " + l + " currentUin = " + this.jdField_a_of_type_ComTencentCommonAppAppInterface.getCurrentAccountUin());
        return;
        j = ((Integer)paramToServiceMsg.getAttribute(f)).intValue();
        ukq.a("AdDataLink", "handle0x68bGetAdvertisementList Error result = " + i + " requestCount = " + j);
        if ((i == 154) && (j == 1))
        {
          paramToServiceMsg.getAttributes().put(f, Integer.valueOf(2));
          a(paramToServiceMsg);
          ukq.a("AdDataLink", "handle0x68bGetAdvertisementList timeout retry : requestCount = " + j);
          return;
        }
        paramToServiceMsg = new JSONObject();
        try
        {
          paramToServiceMsg.put("svrresp_result", 1);
          paramToServiceMsg.put("svrresp_fail_type", 2);
          paramToServiceMsg.put("svrresp_fail_code", i);
          ois.a(new ufy().a(BaseApplication.getContext()).a(80).b(12).b(paramToServiceMsg).a());
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
    int i = qxp.a(paramFromServiceMsg, paramObject, new oidb_cmd0x886.RspBody());
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
      ukq.a("AdDataLink", "async getPreloadAdvertisementAtPostion channelid=" + paramInt1 + "   !needRequestAdvertisement ");
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
      ukq.a("AdDataLink", "first = " + localPair.first + " second = " + localPair.second);
      ukq.a("AdDataLink", "async getPreloadAdvertisementAtPostion channelid=" + paramInt1 + "  position=" + paramInt2 + "  startpos=" + i + "  endpos=" + j);
      return new Pair(Integer.valueOf(i), Integer.valueOf(j));
    }
    return null;
  }
  
  public AdvertisementInfo a(int paramInt1, int paramInt2)
  {
    Object localObject = (ConcurrentHashMap)this.jdField_c_of_type_JavaUtilLinkedHashMap.get(Integer.valueOf(paramInt1));
    if (localObject == null)
    {
      ukq.a("AdVideoDataLink", "getAdvertisementInfo channelId=" + paramInt1 + " map is null!");
      return null;
    }
    localObject = (AdvertisementInfo)((ConcurrentHashMap)localObject).get(Integer.valueOf(paramInt2));
    if (localObject != null)
    {
      ukq.a("AdVideoDataLink", "getAdvertisementInfo channelId=" + paramInt1 + " advertisementInfo = " + ((AdvertisementInfo)localObject).mTitle + " pos = " + ((AdvertisementInfo)localObject).mAdKdPos);
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
  
  public oidb_cmd0x68b.ReqAdvertisePara a(qxs paramqxs, int paramInt1, int paramInt2, int paramInt3, int paramInt4, oha paramoha)
  {
    if (QLog.isColorLevel()) {
      QLog.d("AdvertisementInfoModule", 2, "makeReqAdvertisePara channelID=" + paramInt1);
    }
    Object localObject1 = new GdtDeviceInfoHelper.Params();
    ((GdtDeviceInfoHelper.Params)localObject1).businessIdForAidTicketAndTaidTicket = "ce2d9f";
    Object localObject3 = GdtDeviceInfoHelper.create(BaseApplication.getContext(), (GdtDeviceInfoHelper.Params)localObject1);
    oidb_cmd0x68b.ReqAdvertisePara localReqAdvertisePara;
    Object localObject2;
    if (localObject3 != null)
    {
      localObject1 = ((GdtDeviceInfoHelper.Result)localObject3).deviceInfo;
      localReqAdvertisePara = new oidb_cmd0x68b.ReqAdvertisePara();
      localReqAdvertisePara.uint64_channel_id.set(paramInt1, true);
      localObject2 = localReqAdvertisePara.uint64_last_time;
      if (this.jdField_a_of_type_JavaUtilLinkedHashMap.get(Integer.valueOf(paramInt1)) != null) {
        break label509;
      }
    }
    label258:
    label509:
    for (long l = 0L;; l = ((Long)this.jdField_a_of_type_JavaUtilLinkedHashMap.get(Integer.valueOf(paramInt1))).longValue())
    {
      ((PBUInt64Field)localObject2).set(l, true);
      localObject2 = new oidb_cmd0x68b.PhoneInfo();
      if ((localObject3 != null) && (((GdtDeviceInfoHelper.Result)localObject3).deviceInfo != null) && (((GdtDeviceInfoHelper.Result)localObject3).deviceInfo.muid != null) && (((GdtDeviceInfoHelper.Result)localObject3).deviceInfo.muid_type != null))
      {
        ((oidb_cmd0x68b.PhoneInfo)localObject2).bytes_muid.set(ByteStringMicro.copyFromUtf8(((GdtDeviceInfoHelper.Result)localObject3).deviceInfo.muid.get()));
        ((oidb_cmd0x68b.PhoneInfo)localObject2).uint32_muid_type.set(((GdtDeviceInfoHelper.Result)localObject3).deviceInfo.muid_type.get());
      }
      localObject3 = ujw.b();
      if (!TextUtils.isEmpty((CharSequence)localObject3)) {
        ((oidb_cmd0x68b.PhoneInfo)localObject2).string_imei.set((String)localObject3);
      }
      int i = ofj.a();
      ((oidb_cmd0x68b.PhoneInfo)localObject2).uint32_conn.set(i);
      i = 0;
      try
      {
        int j = DeviceInfoUtil.getCarrier();
        i = j;
      }
      catch (Exception localException)
      {
        break label258;
      }
      ((oidb_cmd0x68b.PhoneInfo)localObject2).uint32_carrier.set(i);
      localObject3 = DeviceInfoUtil.getDeviceOSVersion();
      ((oidb_cmd0x68b.PhoneInfo)localObject2).bytes_os_ver.set(ByteStringMicro.copyFromUtf8((String)localObject3));
      localObject3 = DeviceInfoUtil.getQQVersion();
      ((oidb_cmd0x68b.PhoneInfo)localObject2).bytes_qq_ver.set(ByteStringMicro.copyFromUtf8((String)localObject3));
      i = AppSetting.a();
      ((oidb_cmd0x68b.PhoneInfo)localObject2).bytes_appid.set(ByteStringMicro.copyFromUtf8(String.valueOf(i)));
      localObject3 = dw.a(dw.a());
      ((oidb_cmd0x68b.PhoneInfo)localObject2).bytes_client_ip.set(ByteStringMicro.copyFromUtf8((String)localObject3));
      ((oidb_cmd0x68b.PhoneInfo)localObject2).uint32_os_type.set(2);
      ((oidb_cmd0x68b.PhoneInfo)localObject2).uint64_func_flag.set(1L);
      ((oidb_cmd0x68b.PhoneInfo)localObject2).bytes_ads_context.set(ByteStringMicro.copyFromUtf8(ois.a()));
      ((oidb_cmd0x68b.PhoneInfo)localObject2).bytes_manufacturer.set(ByteStringMicro.copyFromUtf8(Build.BRAND));
      ((oidb_cmd0x68b.PhoneInfo)localObject2).bytes_device_brand_and_model.set(ByteStringMicro.copyFromUtf8(Build.MODEL));
      if (localObject1 != null) {
        a((qq_ad_get.QQAdGet.DeviceInfo)localObject1, (oidb_cmd0x68b.PhoneInfo)localObject2);
      }
      ((oidb_cmd0x68b.PhoneInfo)localObject2).bytes_wx_ver.set(ByteStringMicro.copyFrom(ujw.a(BaseApplication.getContext()).getBytes()));
      localReqAdvertisePara.msg_phone_info.set((MessageMicro)localObject2, true);
      if (paramInt3 != paramInt4) {
        a(paramqxs, paramInt1, paramInt2, paramInt3, paramInt4, paramoha, (qq_ad_get.QQAdGet.DeviceInfo)localObject1, localReqAdvertisePara);
      }
      paramqxs = new oidb_cmd0x68b.AdReqInfo();
      paramqxs.uint64_ad_channel_id.set(paramInt1);
      localReqAdvertisePara.msg_ad_req_info.set(paramqxs);
      return localReqAdvertisePara;
      localObject1 = null;
      break;
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
    ukv.a();
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
      ukq.a("AdDataLink", "async setLocalAdvertisementRange channelid=" + paramInt1 + "  adStart=" + paramInt2 + "  adEnd=" + i);
      localPair = new Pair(Integer.valueOf(paramInt2), Integer.valueOf(i));
      this.jdField_d_of_type_JavaUtilLinkedHashMap.remove(Integer.valueOf(paramInt1));
      this.jdField_d_of_type_JavaUtilLinkedHashMap.put(Integer.valueOf(paramInt1), localPair);
      return;
    }
  }
  
  public void a(int paramInt1, int paramInt2, int paramInt3, int paramInt4, oha paramoha)
  {
    ukq.a("AdDataLink", "refreshChannelAdvertisementFormServer channelId=" + paramInt1 + " adPosType = " + paramInt2 + " adStart = " + paramInt3 + " adEnd = " + paramInt4 + " 请求广告");
    if (!this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.containsKey(Integer.valueOf(paramInt1)))
    {
      QLog.d("AdvertisementInfoModule", 1, "refreshChannelAdvertisementFormServer channelId=" + paramInt1 + " not contained in mChannelID2FixPosArticleAsyncListener");
      qeh.a().a(paramInt1);
    }
    Object localObject;
    if (this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.containsKey(Integer.valueOf(paramInt1)))
    {
      localObject = (WeakReference)this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.get(Integer.valueOf(paramInt1));
      if ((localObject == null) || (((WeakReference)localObject).get() == null))
      {
        QLog.d("AdvertisementInfoModule", 1, "refreshChannelAdvertisementFormServer channelId=" + paramInt1 + " listener is null");
        qeh.a().a(paramInt1);
      }
    }
    oidb_cmd0x68b.ReqBody localReqBody = new oidb_cmd0x68b.ReqBody();
    long l = Long.valueOf(pkh.a()).longValue();
    localReqBody.uint64_uin.set(l);
    localReqBody.uint32_network_type.set(a());
    localReqBody.req_advertise_para.set(a(null, paramInt1, paramInt2, paramInt3, paramInt4, paramoha));
    ToServiceMsg localToServiceMsg = qxp.a("OidbSvc.0x68b", 1675, 0, localReqBody.toByteArray());
    localToServiceMsg.getAttributes().put(jdField_d_of_type_JavaLangString, Long.valueOf(paramInt3));
    if ((paramoha != null) && (paramoha.jdField_b_of_type_Int == 1))
    {
      localToServiceMsg.getAttributes().put(h, Integer.valueOf(paramoha.jdField_b_of_type_Int));
      localToServiceMsg.getAttributes().put(f, Integer.valueOf(0));
    }
    for (;;)
    {
      localToServiceMsg.getAttributes().put("adpostype_0x68b", Integer.valueOf(paramInt2));
      if (!plm.c(paramInt1))
      {
        localObject = localToServiceMsg;
        if (!bmhv.a(paramInt1)) {}
      }
      else
      {
        localReqBody.bytes_style_version.set(ByteStringMicro.copyFromUtf8(tmt.a("default_feeds")));
        localObject = localToServiceMsg;
        if (bmhv.A())
        {
          localObject = qhc.a(paramInt1);
          if (!TextUtils.isEmpty((CharSequence)localObject)) {
            localReqBody.bytes_nearby_cookie.set(ByteStringMicro.copyFromUtf8((String)localObject));
          }
          localObject = qxp.a("OidbSvc.0xcba", 3258, 0, localReqBody.toByteArray());
          ((ToServiceMsg)localObject).getAttributes().put("realTimeServiceKey", "default_feeds");
          ((ToServiceMsg)localObject).getAttributes().put(jdField_d_of_type_JavaLangString, Long.valueOf(paramInt3));
        }
      }
      if ((paramoha != null) && (paramoha.jdField_a_of_type_Boolean))
      {
        ((ToServiceMsg)localObject).getAttributes().put(i, Integer.valueOf(paramInt1));
        ((ToServiceMsg)localObject).getAttributes().put(j, Integer.valueOf(1));
        ((ToServiceMsg)localObject).getAttributes().put(f, Integer.valueOf(0));
      }
      a((ToServiceMsg)localObject);
      olh.a(null, "", "0X8007BA7", "0X8007BA7", 0, 0, "", "", "", "");
      return;
      localToServiceMsg.getAttributes().put(f, Integer.valueOf(1));
    }
  }
  
  public void a(int paramInt, qfo paramqfo)
  {
    if (QLog.isColorLevel()) {
      QLog.d("AdvertisementInfoModule", 2, "setFixPosArticleAsyncListener channelID=" + paramInt);
    }
    this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.put(Integer.valueOf(paramInt), new WeakReference(paramqfo));
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
      localObject1 = (ConcurrentHashMap)this.jdField_c_of_type_JavaUtilLinkedHashMap.get(Integer.valueOf((int)paramAdvertisementInfo.mChannelID));
      if (localObject1 != null) {
        ((ConcurrentHashMap)localObject1).remove(Integer.valueOf(paramAdvertisementInfo.mAdKdPos));
      }
    } while (paramBoolean);
    String str1 = "";
    Object localObject1 = "";
    Object localObject2 = localObject1;
    String str2 = str1;
    int i;
    if (paramArrayList != null)
    {
      i = 0;
      localObject2 = localObject1;
      str2 = str1;
      if (i < paramArrayList.size())
      {
        localObject2 = (DislikeInfo)paramArrayList.get(i);
        if (localObject2 == null) {
          break label418;
        }
        str1 = str1 + ((DislikeInfo)localObject2).jdField_a_of_type_Long;
        localObject1 = (String)localObject1 + ((DislikeInfo)localObject2).jdField_a_of_type_JavaLangString;
        if (i == paramArrayList.size() - 1) {
          break label421;
        }
        str1 = str1 + ",";
        localObject1 = (String)localObject1 + ",";
      }
    }
    label418:
    label421:
    for (;;)
    {
      i += 1;
      break;
      if (paramAdvertisementInfo.mChannelID == 56L)
      {
        ois.a(new ufy().a(paramContext).a(3).b(4).a(paramAdvertisementInfo).a((int)paramLong).a(str2).b((String)localObject2).a());
        return;
      }
      if (pqw.a(paramAdvertisementInfo)) {}
      for (i = 11;; i = 3)
      {
        ois.a(new ufy().a(paramContext).a(3).b(i).a(paramAdvertisementInfo).a((int)paramLong).a(str2).b((String)localObject2).a());
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
          localObject2 = new NewIntent(paramAppInterface.getApplication(), oln.class);
          ((NewIntent)localObject2).putExtra("cmd", "KdAdReportSsoSvr.kandian_ad_native");
          ((NewIntent)localObject2).putExtra("data", ((WebSsoBody.WebSsoRequestBody)localObject1).toByteArray());
          ((NewIntent)localObject2).setObserver(new qeo(this, paramAdvertisementInfo));
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
    ukq.a("AdDataLink", "onReceiveAD response cmd=" + paramFromServiceMsg.getServiceCmd() + " 广告回包");
    if ((paramFromServiceMsg.getServiceCmd().equals("OidbSvc.0x68b")) || (paramFromServiceMsg.getServiceCmd().equals("OidbSvc.0xcba"))) {
      b(paramToServiceMsg, paramFromServiceMsg, paramObject);
    }
    while (!paramFromServiceMsg.getServiceCmd().equals("OidbSvc.0x886")) {
      return;
    }
    c(paramToServiceMsg, paramFromServiceMsg, paramObject);
  }
  
  public void a(ToServiceMsg paramToServiceMsg, oidb_cmd0x68b.RspChannelArticle paramRspChannelArticle, int paramInt1, int paramInt2, boolean paramBoolean, pko<Boolean> parampko)
  {
    if (paramRspChannelArticle == null)
    {
      parampko.a(Boolean.valueOf(true));
      return;
    }
    pko localpko1 = new pko(Integer.valueOf((int)paramRspChannelArticle.uint64_channel_id.get()));
    if ((((Integer)localpko1.a()).intValue() == 0) && (paramInt2 != 0)) {
      localpko1.a(Integer.valueOf(paramInt2));
    }
    long l1 = paramRspChannelArticle.uint64_pos_ad_time.get();
    ArrayList localArrayList = new ArrayList();
    Object localObject = new pko(Boolean.valueOf(false));
    pko localpko2 = new pko(Boolean.valueOf(false));
    long l2 = ((Long)paramToServiceMsg.getAttribute(jdField_d_of_type_JavaLangString)).longValue();
    if ((paramRspChannelArticle.rpt_advertise_list.has()) && (paramRspChannelArticle.rpt_advertise_list.get() != null))
    {
      List localList = paramRspChannelArticle.rpt_advertise_list.get();
      if (QLog.isColorLevel()) {
        QLog.d("AdvertisementInfoModule", 2, "handleAdvertisementResp resp.rpt_advertise_list size " + localList.size());
      }
      localList = a(paramInt2, localpko1, l1, (pko)localObject, localpko2, l2, localList);
      localArrayList.addAll(localList);
      a(localList);
      a(localArrayList);
      if (((Boolean)((pko)localObject).a()).booleanValue())
      {
        a(localpko1, l1, localArrayList);
        parampko.a(Boolean.valueOf(true));
        return;
      }
      a(paramRspChannelArticle);
    }
    if (((Boolean)localpko2.a()).booleanValue()) {
      a(((Integer)localpko1.a()).intValue(), false);
    }
    this.jdField_a_of_type_JavaUtilLinkedHashMap.put(localpko1.a(), Long.valueOf(l1));
    if ((paramBoolean) && (l1 > 0L)) {
      this.jdField_b_of_type_JavaUtilLinkedHashMap.put(localpko1.a(), Long.valueOf(l1));
    }
    ukq.a("AdvertisementInfoModule", "async makeReqAdvertisePara adinfo, fromRefresh=" + paramBoolean + ", list.size()=" + localArrayList.size() + ",fetchTime=" + l1);
    paramRspChannelArticle = (ConcurrentHashMap)this.jdField_c_of_type_JavaUtilLinkedHashMap.get(localpko1.a());
    if (paramRspChannelArticle == null)
    {
      paramRspChannelArticle = new ConcurrentHashMap();
      this.jdField_c_of_type_JavaUtilLinkedHashMap.put(localpko1.a(), paramRspChannelArticle);
    }
    for (;;)
    {
      parampko = new ConcurrentHashMap();
      paramBoolean = qku.a(paramToServiceMsg);
      if (QLog.isColorLevel()) {
        QLog.d("AdvertisementInfoModule", 2, "handleAdvertisementResp beginSeq = " + l2 + ",isFeedsPreload=" + paramBoolean + ",advertisementInfoMap size " + paramRspChannelArticle.size() + ", channelId=" + localpko1.a() + ", fetchTime=" + l1 + ",repeatedreqFlag=" + paramInt1);
      }
      if ((paramBoolean) && (localArrayList.size() <= 0)) {}
      for (paramToServiceMsg = parampko;; paramToServiceMsg = paramRspChannelArticle)
      {
        ult.a(((Integer)localpko1.a()).intValue(), localArrayList);
        a(localpko1, paramToServiceMsg);
        paramToServiceMsg = new StringBuilder("handleAdvertisementResp channelID=" + localpko1.a() + ", fetchTime=" + l1 + "\n");
        parampko = localArrayList.iterator();
        while (parampko.hasNext())
        {
          localObject = (AdvertisementInfo)parampko.next();
          paramRspChannelArticle.put(Integer.valueOf(((AdvertisementInfo)localObject).mAdKdPos), localObject);
          paramToServiceMsg.append("[pos=").append(((AdvertisementInfo)localObject).mAdKdPos).append(", traceID=").append(((AdvertisementInfo)localObject).mAdTraceId).append("]\n");
          if ((((AdvertisementInfo)localObject).mAdJumpMode == 4) && (TextUtils.isEmpty(((AdvertisementInfo)localObject).mAdAppJson))) {
            a(this.jdField_a_of_type_ComTencentCommonAppAppInterface, (AdvertisementInfo)localObject);
          }
        }
        if (l2 != -1L) {
          break;
        }
      }
      localObject = localArrayList.iterator();
      for (;;)
      {
        paramToServiceMsg = parampko;
        if (!((Iterator)localObject).hasNext()) {
          break;
        }
        paramToServiceMsg = (AdvertisementInfo)((Iterator)localObject).next();
        if (paramRspChannelArticle.get(Integer.valueOf(paramToServiceMsg.mAdKdPos)) != null)
        {
          if (QLog.isColorLevel()) {
            QLog.d("AdvertisementInfoModule", 2, "handleAdvertisementResp dropAdvertisements info = " + paramToServiceMsg.toSString());
          }
          parampko.put(Integer.valueOf(paramToServiceMsg.mAdKdPos), paramRspChannelArticle.get(Integer.valueOf(paramToServiceMsg.mAdKdPos)));
          paramRspChannelArticle.remove(Integer.valueOf(paramToServiceMsg.mAdKdPos));
        }
      }
      QLog.d("AdvertisementInfoModule", 1, paramToServiceMsg.toString());
      if (QLog.isColorLevel()) {
        QLog.d("AdvertisementInfoModule", 2, "handleAdvertisementResp advertisementInfoMap size " + paramRspChannelArticle.size() + ", channelId=" + localpko1.a());
      }
      if (localArrayList.size() != 0) {
        break;
      }
      paramToServiceMsg = new JSONObject();
      try
      {
        paramToServiceMsg.put("svrresp_result", 1);
        paramToServiceMsg.put("svrresp_fail_type", 1);
        ois.a(new ufy().a(BaseApplication.getContext()).a(80).b(12).b(paramToServiceMsg).a());
        ukq.a("AdDataLink", "handleAdvertisementResp channelID=" + localpko1.a() + ", fetchTime=" + l1 + " parsedAdvertisementList empty!");
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
      ukq.a("AdDataLink", "getFixPositionSync channelID=" + paramInt + " return empty!");
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
    ukq.a("AdDataLink", "getFixPositionSync channelID=" + paramInt + " return " + localStringBuilder.toString());
    return arrayOfInt;
  }
  
  public AdvertisementInfo b(int paramInt1, int paramInt2)
  {
    Object localObject = (ConcurrentHashMap)this.jdField_c_of_type_JavaUtilLinkedHashMap.get(Integer.valueOf(paramInt1));
    if (localObject == null)
    {
      ukq.a("AdVideoDataLink", "removeAdvertisementInfo channelId=" + paramInt1 + " map is null!");
      return null;
    }
    localObject = (AdvertisementInfo)((ConcurrentHashMap)localObject).remove(Integer.valueOf(paramInt2));
    if (localObject != null)
    {
      ukq.a("AdVideoDataLink", "removeAdvertisementInfo channelId=" + paramInt1 + " advertisementInfo = " + ((AdvertisementInfo)localObject).mTitle + " pos = " + ((AdvertisementInfo)localObject).mAdKdPos);
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
      Collections.sort(localArrayList, new qem(this));
    }
    if (!QLog.isColorLevel()) {
      return localArrayList;
    }
    localObject = new StringBuilder("\n");
    int i = 0;
    while (i < localArrayList.size())
    {
      AdvertisementInfo localAdvertisementInfo = (AdvertisementInfo)localArrayList.get(i);
      ((StringBuilder)localObject).append("[pos=").append(localAdvertisementInfo.mAdKdPos).append(", traceID=").append(localAdvertisementInfo.mAdTraceId).append(", title=").append(localAdvertisementInfo.mTitle).append("]");
      if (i != localArrayList.size() - 1) {
        ((StringBuilder)localObject).append("\n");
      }
      i += 1;
    }
    ukq.a("AdDataLink", "loadChannelAdvertisement channelId=" + paramInt + " return " + ((StringBuilder)localObject).toString());
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
 * Qualified Name:     qel
 * JD-Core Version:    0.7.0.1
 */