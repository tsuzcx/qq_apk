import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import com.tencent.biz.pubaccount.readinjoy.biu.ReadInJoyDeliverBiuActivity;
import com.tencent.biz.pubaccount.readinjoy.struct.ArticleInfo;
import com.tencent.biz.pubaccount.readinjoy.struct.BaseArticleInfo;
import com.tencent.biz.pubaccount.readinjoy.struct.VideoColumnInfo;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.utils.NetworkUtil;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import org.json.JSONObject;
import tencent.im.oidb.articlesummary.articlesummary.PartnerAccountInfo;
import tencent.im.oidb.articlesummary.articlesummary.VideoDownloadBarInfo;
import tencent.im.oidb.articlesummary.articlesummary.WeishiUGInfo;

public class phy
{
  public static String a(rcn paramrcn, String paramString, sdc paramsdc)
  {
    paramString = pay.a(paramString, paramsdc.b(), ofe.jdField_a_of_type_Int);
    if (paramrcn.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo == null) {
      return paramString;
    }
    if (paramrcn.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo.mVideoColumnInfo != null) {
      paramString = new sie(paramString).c(paramrcn.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo).d(paramrcn.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo).a(paramrcn.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo.videoReportInfo).a().a();
    }
    for (;;)
    {
      if (((pgb.a((ArticleInfo)paramrcn.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo) == 46) || (paramrcn.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo.isTwoItem)) && (paramrcn.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo.mVideoDownloadBarInfo != null) && (paramrcn.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo.mVideoDownloadBarInfo.weishiUGInfo != null) && (pay.a(paramrcn.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo.mVideoDownloadBarInfo.weishiUGInfo.bytes_report_base_url)) && (pay.a(paramrcn.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo.mVideoDownloadBarInfo.weishiUGInfo.bytes_exposure_report_tail))) {
        rwv.a(pay.a(paramrcn.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo.mVideoDownloadBarInfo.weishiUGInfo.bytes_report_base_url) + pay.a(paramrcn.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo.mVideoDownloadBarInfo.weishiUGInfo.bytes_exposure_report_tail));
      }
      return paramString;
    }
  }
  
  public static void a(BaseArticleInfo paramBaseArticleInfo, Context paramContext, int paramInt)
  {
    if ((paramBaseArticleInfo.isAccountShown) && (paramInt == 0) && (!TextUtils.isEmpty(pay.a(paramBaseArticleInfo.mPartnerAccountInfo.bytes_head_jump_url)))) {
      pay.d(paramContext, pay.a(paramBaseArticleInfo.mPartnerAccountInfo.bytes_head_jump_url));
    }
  }
  
  public static void a(BaseArticleInfo paramBaseArticleInfo, rcn paramrcn)
  {
    if ((paramBaseArticleInfo == null) || (!pay.q(paramBaseArticleInfo))) {
      return;
    }
    paramrcn = new sie(null, null, null, null).V(Integer.valueOf("2007").intValue());
    BaseArticleInfo localBaseArticleInfo = (BaseArticleInfo)paramBaseArticleInfo.mSubArtilceList.get(0);
    paramrcn.p(paramBaseArticleInfo.mKdLiveInfo.g);
    odq.a(null, paramBaseArticleInfo.mSubscribeID, "0X8007626", "0X8007626", 0, 0, "", "", "", paramrcn.a().a(), false);
    paramrcn.p(localBaseArticleInfo.mKdLiveInfo.g);
    odq.a(null, localBaseArticleInfo.mSubscribeID, "0X8007626", "0X8007626", 0, 0, "", "", "", paramrcn.a().a(), false);
  }
  
  public static void a(Map<Long, rcn> paramMap, int paramInt, sdv paramsdv)
  {
    if ((paramInt == 56) && (paramsdv != null))
    {
      paramMap = paramMap.values().iterator();
      while (paramMap.hasNext())
      {
        rcn localrcn = (rcn)paramMap.next();
        localrcn.h = paramsdv.a();
        if (paramsdv.a(localrcn.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo.mArticleID)) {
          localrcn.jdField_f_of_type_Boolean = true;
        }
      }
    }
  }
  
  /* Error */
  public static void a(rcn paramrcn, long paramLong, int paramInt1, String paramString1, String paramString2, Context paramContext, int paramInt2, int paramInt3, oiy paramoiy, boolean paramBoolean)
  {
    // Byte code:
    //   0: new 40	sie
    //   3: dup
    //   4: aload 4
    //   6: invokespecial 43	sie:<init>	(Ljava/lang/String;)V
    //   9: astore 12
    //   11: aload 12
    //   13: aload_0
    //   14: getfield 243	rcn:jdField_b_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo	Lcom/tencent/biz/pubaccount/readinjoy/struct/BaseArticleInfo;
    //   17: invokestatic 246	pay:w	(Lcom/tencent/biz/pubaccount/readinjoy/struct/BaseArticleInfo;)Z
    //   20: invokestatic 251	java/lang/Boolean:valueOf	(Z)Ljava/lang/Boolean;
    //   23: invokevirtual 254	sie:a	(Ljava/lang/Boolean;)Lsie;
    //   26: aload_0
    //   27: getfield 243	rcn:jdField_b_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo	Lcom/tencent/biz/pubaccount/readinjoy/struct/BaseArticleInfo;
    //   30: getfield 54	com/tencent/biz/pubaccount/readinjoy/struct/BaseArticleInfo:videoReportInfo	Ljava/lang/String;
    //   33: invokevirtual 57	sie:a	(Ljava/lang/String;)Lsie;
    //   36: aload_0
    //   37: getfield 243	rcn:jdField_b_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo	Lcom/tencent/biz/pubaccount/readinjoy/struct/BaseArticleInfo;
    //   40: invokevirtual 256	sie:b	(Lcom/tencent/biz/pubaccount/readinjoy/struct/BaseArticleInfo;)Lsie;
    //   43: pop
    //   44: iload 7
    //   46: ldc_w 257
    //   49: if_icmpne +190 -> 239
    //   52: aload 12
    //   54: aload_0
    //   55: getfield 260	rcn:j	I
    //   58: invokevirtual 262	sie:b	(I)Lsie;
    //   61: pop
    //   62: aconst_null
    //   63: ldc_w 264
    //   66: ldc 189
    //   68: aload_0
    //   69: getfield 266	rcn:jdField_d_of_type_JavaLangString	Ljava/lang/String;
    //   72: ldc_w 268
    //   75: ldc_w 268
    //   78: iconst_0
    //   79: iconst_0
    //   80: aload_0
    //   81: getfield 32	rcn:jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo	Lcom/tencent/biz/pubaccount/readinjoy/struct/BaseArticleInfo;
    //   84: getfield 271	com/tencent/biz/pubaccount/readinjoy/struct/BaseArticleInfo:mFeedId	J
    //   87: invokestatic 276	java/lang/Long:toString	(J)Ljava/lang/String;
    //   90: aload_0
    //   91: getfield 279	rcn:jdField_a_of_type_JavaLangLong	Ljava/lang/Long;
    //   94: invokevirtual 283	java/lang/Long:longValue	()J
    //   97: invokestatic 276	java/lang/Long:toString	(J)Ljava/lang/String;
    //   100: aload_0
    //   101: getfield 285	rcn:jdField_b_of_type_Int	I
    //   104: invokestatic 288	java/lang/Integer:toString	(I)Ljava/lang/String;
    //   107: aload 12
    //   109: invokevirtual 60	sie:a	()Lsid;
    //   112: invokevirtual 64	sid:a	()Ljava/lang/String;
    //   115: iconst_0
    //   116: invokestatic 291	odq:a	(Lcom/tencent/mobileqq/app/QQAppInterface;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;IILjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Z)V
    //   119: ldc_w 268
    //   122: aload_0
    //   123: getfield 266	rcn:jdField_d_of_type_JavaLangString	Ljava/lang/String;
    //   126: aload_0
    //   127: getfield 32	rcn:jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo	Lcom/tencent/biz/pubaccount/readinjoy/struct/BaseArticleInfo;
    //   130: getfield 271	com/tencent/biz/pubaccount/readinjoy/struct/BaseArticleInfo:mFeedId	J
    //   133: invokestatic 276	java/lang/Long:toString	(J)Ljava/lang/String;
    //   136: aload_0
    //   137: getfield 279	rcn:jdField_a_of_type_JavaLangLong	Ljava/lang/Long;
    //   140: invokevirtual 283	java/lang/Long:longValue	()J
    //   143: invokestatic 276	java/lang/Long:toString	(J)Ljava/lang/String;
    //   146: aload_0
    //   147: getfield 285	rcn:jdField_b_of_type_Int	I
    //   150: invokestatic 288	java/lang/Integer:toString	(I)Ljava/lang/String;
    //   153: aload_0
    //   154: getfield 293	rcn:jdField_a_of_type_Long	J
    //   157: aload_0
    //   158: getfield 295	rcn:jdField_c_of_type_Int	I
    //   161: iload 7
    //   163: aload_0
    //   164: getfield 297	rcn:jdField_d_of_type_Int	I
    //   167: aload_0
    //   168: getfield 300	rcn:jdField_e_of_type_Int	I
    //   171: aload 6
    //   173: invokestatic 306	com/tencent/mobileqq/utils/NetworkUtil:isWifiConnected	(Landroid/content/Context;)Z
    //   176: aload_0
    //   177: getfield 308	rcn:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   180: aload_0
    //   181: getfield 310	rcn:jdField_c_of_type_JavaLangString	Ljava/lang/String;
    //   184: aload_0
    //   185: getfield 312	rcn:jdField_e_of_type_JavaLangString	Ljava/lang/String;
    //   188: aload_0
    //   189: getfield 32	rcn:jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo	Lcom/tencent/biz/pubaccount/readinjoy/struct/BaseArticleInfo;
    //   192: invokestatic 315	pay:f	(Lcom/tencent/biz/pubaccount/readinjoy/struct/BaseArticleInfo;)Ljava/lang/String;
    //   195: aload_0
    //   196: getfield 32	rcn:jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo	Lcom/tencent/biz/pubaccount/readinjoy/struct/BaseArticleInfo;
    //   199: checkcast 66	com/tencent/biz/pubaccount/readinjoy/struct/ArticleInfo
    //   202: lload_1
    //   203: iload_3
    //   204: aload_0
    //   205: getfield 317	rcn:jdField_f_of_type_Int	I
    //   208: aload_0
    //   209: getfield 319	rcn:g	I
    //   212: aload_0
    //   213: getfield 224	rcn:h	I
    //   216: aload_0
    //   217: getfield 234	rcn:jdField_f_of_type_Boolean	Z
    //   220: aload_0
    //   221: getfield 260	rcn:j	I
    //   224: aload_0
    //   225: getfield 322	rcn:i	I
    //   228: aload_0
    //   229: getfield 325	rcn:m	I
    //   232: invokestatic 328	pay:a	(JIIIIZLjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lcom/tencent/biz/pubaccount/readinjoy/struct/ArticleInfo;JIIIIZIII)Ljava/lang/String;
    //   235: invokestatic 331	odq:a	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V
    //   238: return
    //   239: iload 8
    //   241: iconst_3
    //   242: if_icmpne +45 -> 287
    //   245: iconst_m1
    //   246: istore 11
    //   248: iload 11
    //   250: istore 8
    //   252: aload 9
    //   254: ifnull +25 -> 279
    //   257: iload 11
    //   259: istore 8
    //   261: aload 9
    //   263: instanceof 333
    //   266: ifeq +13 -> 279
    //   269: aload 9
    //   271: checkcast 333	oiz
    //   274: invokevirtual 334	oiz:a	()I
    //   277: istore 8
    //   279: aload 12
    //   281: iload 8
    //   283: invokevirtual 337	sie:N	(I)Lsie;
    //   286: pop
    //   287: aload 12
    //   289: aload_0
    //   290: getfield 243	rcn:jdField_b_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo	Lcom/tencent/biz/pubaccount/readinjoy/struct/BaseArticleInfo;
    //   293: invokevirtual 339	sie:a	(Lcom/tencent/biz/pubaccount/readinjoy/struct/BaseArticleInfo;)Lsie;
    //   296: pop
    //   297: aload_0
    //   298: getfield 32	rcn:jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo	Lcom/tencent/biz/pubaccount/readinjoy/struct/BaseArticleInfo;
    //   301: ifnull +111 -> 412
    //   304: aload_0
    //   305: getfield 32	rcn:jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo	Lcom/tencent/biz/pubaccount/readinjoy/struct/BaseArticleInfo;
    //   308: getfield 343	com/tencent/biz/pubaccount/readinjoy/struct/BaseArticleInfo:mProteusTemplateBean	Lcom/tencent/biz/pubaccount/readinjoy/view/proteus/bean/TemplateBean;
    //   311: ifnull +101 -> 412
    //   314: aload_0
    //   315: getfield 32	rcn:jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo	Lcom/tencent/biz/pubaccount/readinjoy/struct/BaseArticleInfo;
    //   318: getfield 343	com/tencent/biz/pubaccount/readinjoy/struct/BaseArticleInfo:mProteusTemplateBean	Lcom/tencent/biz/pubaccount/readinjoy/view/proteus/bean/TemplateBean;
    //   321: aconst_null
    //   322: invokevirtual 349	com/tencent/biz/pubaccount/readinjoy/view/proteus/bean/TemplateBean:getDataAttribute	(Ljava/lang/String;)Ljava/util/Map;
    //   325: astore 13
    //   327: aload 13
    //   329: ifnull +83 -> 412
    //   332: aload 13
    //   334: invokeinterface 353 1 0
    //   339: ifnull +73 -> 412
    //   342: aload 13
    //   344: invokeinterface 353 1 0
    //   349: invokeinterface 356 1 0
    //   354: astore 13
    //   356: aload 13
    //   358: ifnull +54 -> 412
    //   361: aload 13
    //   363: invokeinterface 213 1 0
    //   368: ifeq +44 -> 412
    //   371: aload 13
    //   373: invokeinterface 217 1 0
    //   378: checkcast 358	java/util/Map$Entry
    //   381: astore 14
    //   383: aload 12
    //   385: aload 14
    //   387: invokeinterface 361 1 0
    //   392: checkcast 363	java/lang/String
    //   395: aload 14
    //   397: invokeinterface 366 1 0
    //   402: invokevirtual 367	java/lang/Object:toString	()Ljava/lang/String;
    //   405: invokevirtual 370	sie:a	(Ljava/lang/String;Ljava/lang/Object;)Lsie;
    //   408: pop
    //   409: goto -53 -> 356
    //   412: aload 12
    //   414: aload_0
    //   415: getfield 32	rcn:jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo	Lcom/tencent/biz/pubaccount/readinjoy/struct/BaseArticleInfo;
    //   418: invokestatic 375	qod:a	(Lsie;Lcom/tencent/biz/pubaccount/readinjoy/struct/BaseArticleInfo;)V
    //   421: aload 5
    //   423: aload_0
    //   424: aload 12
    //   426: invokestatic 378	pay:a	(Ljava/lang/String;Lrcn;Lsie;)V
    //   429: aload 9
    //   431: instanceof 380
    //   434: ifeq +25 -> 459
    //   437: iload 10
    //   439: ifeq +231 -> 670
    //   442: iconst_1
    //   443: istore 8
    //   445: aload 12
    //   447: ldc_w 382
    //   450: iload 8
    //   452: invokestatic 385	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   455: invokevirtual 370	sie:a	(Ljava/lang/String;Ljava/lang/Object;)Lsie;
    //   458: pop
    //   459: aconst_null
    //   460: ldc_w 264
    //   463: ldc 189
    //   465: aload_0
    //   466: getfield 266	rcn:jdField_d_of_type_JavaLangString	Ljava/lang/String;
    //   469: aload 5
    //   471: aload 5
    //   473: iconst_0
    //   474: iconst_0
    //   475: aload_0
    //   476: getfield 32	rcn:jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo	Lcom/tencent/biz/pubaccount/readinjoy/struct/BaseArticleInfo;
    //   479: getfield 271	com/tencent/biz/pubaccount/readinjoy/struct/BaseArticleInfo:mFeedId	J
    //   482: invokestatic 276	java/lang/Long:toString	(J)Ljava/lang/String;
    //   485: aload_0
    //   486: getfield 279	rcn:jdField_a_of_type_JavaLangLong	Ljava/lang/Long;
    //   489: invokevirtual 283	java/lang/Long:longValue	()J
    //   492: invokestatic 276	java/lang/Long:toString	(J)Ljava/lang/String;
    //   495: aload_0
    //   496: getfield 285	rcn:jdField_b_of_type_Int	I
    //   499: invokestatic 288	java/lang/Integer:toString	(I)Ljava/lang/String;
    //   502: aload 12
    //   504: invokevirtual 60	sie:a	()Lsid;
    //   507: invokevirtual 64	sid:a	()Ljava/lang/String;
    //   510: iconst_0
    //   511: invokestatic 291	odq:a	(Lcom/tencent/mobileqq/app/QQAppInterface;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;IILjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Z)V
    //   514: aload_0
    //   515: getfield 32	rcn:jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo	Lcom/tencent/biz/pubaccount/readinjoy/struct/BaseArticleInfo;
    //   518: getfield 343	com/tencent/biz/pubaccount/readinjoy/struct/BaseArticleInfo:mProteusTemplateBean	Lcom/tencent/biz/pubaccount/readinjoy/view/proteus/bean/TemplateBean;
    //   521: invokestatic 390	ues:a	(Lcom/tencent/biz/pubaccount/readinjoy/view/proteus/bean/TemplateBean;)Ljava/util/List;
    //   524: astore 12
    //   526: aload 4
    //   528: astore 9
    //   530: aload 12
    //   532: ifnull +173 -> 705
    //   535: aload 12
    //   537: invokeinterface 391 1 0
    //   542: astore 13
    //   544: aload 4
    //   546: astore 9
    //   548: aload 13
    //   550: invokeinterface 213 1 0
    //   555: ifeq +150 -> 705
    //   558: aload 13
    //   560: invokeinterface 217 1 0
    //   565: checkcast 363	java/lang/String
    //   568: astore 12
    //   570: new 393	org/json/JSONObject
    //   573: dup
    //   574: aload 4
    //   576: invokespecial 394	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   579: astore 9
    //   581: aload_0
    //   582: getfield 32	rcn:jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo	Lcom/tencent/biz/pubaccount/readinjoy/struct/BaseArticleInfo;
    //   585: getfield 343	com/tencent/biz/pubaccount/readinjoy/struct/BaseArticleInfo:mProteusTemplateBean	Lcom/tencent/biz/pubaccount/readinjoy/view/proteus/bean/TemplateBean;
    //   588: aload 12
    //   590: invokevirtual 349	com/tencent/biz/pubaccount/readinjoy/view/proteus/bean/TemplateBean:getDataAttribute	(Ljava/lang/String;)Ljava/util/Map;
    //   593: astore 12
    //   595: aload 12
    //   597: ifnull +379 -> 976
    //   600: aload 9
    //   602: aload 12
    //   604: invokestatic 397	ues:a	(Lorg/json/JSONObject;Ljava/util/Map;)V
    //   607: aload 9
    //   609: invokevirtual 398	org/json/JSONObject:toString	()Ljava/lang/String;
    //   612: astore 9
    //   614: aload 9
    //   616: astore 4
    //   618: aconst_null
    //   619: ldc_w 264
    //   622: ldc 189
    //   624: aload_0
    //   625: getfield 266	rcn:jdField_d_of_type_JavaLangString	Ljava/lang/String;
    //   628: aload 5
    //   630: aload 5
    //   632: iconst_0
    //   633: iconst_0
    //   634: aload_0
    //   635: getfield 32	rcn:jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo	Lcom/tencent/biz/pubaccount/readinjoy/struct/BaseArticleInfo;
    //   638: getfield 271	com/tencent/biz/pubaccount/readinjoy/struct/BaseArticleInfo:mFeedId	J
    //   641: invokestatic 276	java/lang/Long:toString	(J)Ljava/lang/String;
    //   644: aload_0
    //   645: getfield 279	rcn:jdField_a_of_type_JavaLangLong	Ljava/lang/Long;
    //   648: invokevirtual 283	java/lang/Long:longValue	()J
    //   651: invokestatic 276	java/lang/Long:toString	(J)Ljava/lang/String;
    //   654: aload_0
    //   655: getfield 285	rcn:jdField_b_of_type_Int	I
    //   658: invokestatic 288	java/lang/Integer:toString	(I)Ljava/lang/String;
    //   661: aload 4
    //   663: iconst_0
    //   664: invokestatic 291	odq:a	(Lcom/tencent/mobileqq/app/QQAppInterface;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;IILjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Z)V
    //   667: goto -123 -> 544
    //   670: iconst_0
    //   671: istore 8
    //   673: goto -228 -> 445
    //   676: astore 12
    //   678: aload 4
    //   680: astore 9
    //   682: aload 12
    //   684: astore 4
    //   686: ldc_w 400
    //   689: iconst_1
    //   690: ldc_w 402
    //   693: aload 4
    //   695: invokestatic 407	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   698: aload 9
    //   700: astore 4
    //   702: goto -158 -> 544
    //   705: aload 5
    //   707: aload_0
    //   708: getfield 266	rcn:jdField_d_of_type_JavaLangString	Ljava/lang/String;
    //   711: aload_0
    //   712: getfield 32	rcn:jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo	Lcom/tencent/biz/pubaccount/readinjoy/struct/BaseArticleInfo;
    //   715: getfield 271	com/tencent/biz/pubaccount/readinjoy/struct/BaseArticleInfo:mFeedId	J
    //   718: invokestatic 276	java/lang/Long:toString	(J)Ljava/lang/String;
    //   721: aload_0
    //   722: getfield 279	rcn:jdField_a_of_type_JavaLangLong	Ljava/lang/Long;
    //   725: invokevirtual 283	java/lang/Long:longValue	()J
    //   728: invokestatic 276	java/lang/Long:toString	(J)Ljava/lang/String;
    //   731: aload_0
    //   732: getfield 285	rcn:jdField_b_of_type_Int	I
    //   735: invokestatic 288	java/lang/Integer:toString	(I)Ljava/lang/String;
    //   738: aload_0
    //   739: getfield 293	rcn:jdField_a_of_type_Long	J
    //   742: aload_0
    //   743: getfield 295	rcn:jdField_c_of_type_Int	I
    //   746: iload 7
    //   748: aload_0
    //   749: getfield 297	rcn:jdField_d_of_type_Int	I
    //   752: aload_0
    //   753: getfield 300	rcn:jdField_e_of_type_Int	I
    //   756: aload 6
    //   758: invokestatic 306	com/tencent/mobileqq/utils/NetworkUtil:isWifiConnected	(Landroid/content/Context;)Z
    //   761: aload_0
    //   762: getfield 308	rcn:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   765: aload_0
    //   766: getfield 310	rcn:jdField_c_of_type_JavaLangString	Ljava/lang/String;
    //   769: aload_0
    //   770: getfield 312	rcn:jdField_e_of_type_JavaLangString	Ljava/lang/String;
    //   773: aload_0
    //   774: getfield 32	rcn:jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo	Lcom/tencent/biz/pubaccount/readinjoy/struct/BaseArticleInfo;
    //   777: invokestatic 315	pay:f	(Lcom/tencent/biz/pubaccount/readinjoy/struct/BaseArticleInfo;)Ljava/lang/String;
    //   780: aload_0
    //   781: getfield 32	rcn:jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo	Lcom/tencent/biz/pubaccount/readinjoy/struct/BaseArticleInfo;
    //   784: checkcast 66	com/tencent/biz/pubaccount/readinjoy/struct/ArticleInfo
    //   787: lload_1
    //   788: iload_3
    //   789: aload_0
    //   790: getfield 317	rcn:jdField_f_of_type_Int	I
    //   793: aload_0
    //   794: getfield 319	rcn:g	I
    //   797: aload_0
    //   798: getfield 224	rcn:h	I
    //   801: aload_0
    //   802: getfield 234	rcn:jdField_f_of_type_Boolean	Z
    //   805: aload_0
    //   806: getfield 260	rcn:j	I
    //   809: aload_0
    //   810: getfield 322	rcn:i	I
    //   813: aload_0
    //   814: getfield 325	rcn:m	I
    //   817: invokestatic 328	pay:a	(JIIIIZLjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lcom/tencent/biz/pubaccount/readinjoy/struct/ArticleInfo;JIIIIZIII)Ljava/lang/String;
    //   820: invokestatic 331	odq:a	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V
    //   823: sipush 250
    //   826: invokestatic 412	com/tencent/aladdin/config/Aladdin:get	(I)Lcom/tencent/aladdin/config/AladdinConfig;
    //   829: ldc_w 414
    //   832: iconst_0
    //   833: invokevirtual 420	com/tencent/aladdin/config/AladdinConfig:getIntegerFromString	(Ljava/lang/String;I)I
    //   836: iconst_1
    //   837: if_icmpne -599 -> 238
    //   840: iload 7
    //   842: invokestatic 425	pcl:c	(I)Z
    //   845: ifne -607 -> 238
    //   848: new 427	pbg
    //   851: dup
    //   852: new 393	org/json/JSONObject
    //   855: dup
    //   856: aload 9
    //   858: invokespecial 394	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   861: invokespecial 430	pbg:<init>	(Lorg/json/JSONObject;)V
    //   864: astore 4
    //   866: invokestatic 434	uhv:b	()I
    //   869: ifle +89 -> 958
    //   872: iconst_0
    //   873: istore_3
    //   874: aload 4
    //   876: ldc_w 436
    //   879: iload_3
    //   880: invokevirtual 439	pbg:b	(Ljava/lang/String;I)Lpbg;
    //   883: pop
    //   884: aconst_null
    //   885: ldc_w 264
    //   888: ldc 189
    //   890: aload_0
    //   891: getfield 266	rcn:jdField_d_of_type_JavaLangString	Ljava/lang/String;
    //   894: ldc_w 441
    //   897: ldc_w 441
    //   900: iconst_0
    //   901: iconst_0
    //   902: aload_0
    //   903: getfield 32	rcn:jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo	Lcom/tencent/biz/pubaccount/readinjoy/struct/BaseArticleInfo;
    //   906: getfield 271	com/tencent/biz/pubaccount/readinjoy/struct/BaseArticleInfo:mFeedId	J
    //   909: invokestatic 276	java/lang/Long:toString	(J)Ljava/lang/String;
    //   912: aload_0
    //   913: getfield 279	rcn:jdField_a_of_type_JavaLangLong	Ljava/lang/Long;
    //   916: invokevirtual 283	java/lang/Long:longValue	()J
    //   919: invokestatic 276	java/lang/Long:toString	(J)Ljava/lang/String;
    //   922: aload_0
    //   923: getfield 285	rcn:jdField_b_of_type_Int	I
    //   926: invokestatic 288	java/lang/Integer:toString	(I)Ljava/lang/String;
    //   929: aload 4
    //   931: invokevirtual 442	pbg:a	()Ljava/lang/String;
    //   934: iconst_0
    //   935: invokestatic 291	odq:a	(Lcom/tencent/mobileqq/app/QQAppInterface;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;IILjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Z)V
    //   938: return
    //   939: astore_0
    //   940: invokestatic 445	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   943: ifeq -705 -> 238
    //   946: ldc_w 400
    //   949: iconst_2
    //   950: aload_0
    //   951: invokestatic 449	com/tencent/qphone/base/util/QLog:getStackTraceString	(Ljava/lang/Throwable;)Ljava/lang/String;
    //   954: invokestatic 452	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   957: return
    //   958: iconst_1
    //   959: istore_3
    //   960: goto -86 -> 874
    //   963: astore 12
    //   965: aload 4
    //   967: astore 9
    //   969: aload 12
    //   971: astore 4
    //   973: goto -287 -> 686
    //   976: goto -309 -> 667
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	979	0	paramrcn	rcn
    //   0	979	1	paramLong	long
    //   0	979	3	paramInt1	int
    //   0	979	4	paramString1	String
    //   0	979	5	paramString2	String
    //   0	979	6	paramContext	Context
    //   0	979	7	paramInt2	int
    //   0	979	8	paramInt3	int
    //   0	979	9	paramoiy	oiy
    //   0	979	10	paramBoolean	boolean
    //   246	12	11	i	int
    //   9	594	12	localObject1	Object
    //   676	7	12	localJSONException1	org.json.JSONException
    //   963	7	12	localJSONException2	org.json.JSONException
    //   325	234	13	localObject2	Object
    //   381	15	14	localEntry	java.util.Map.Entry
    // Exception table:
    //   from	to	target	type
    //   570	595	676	org/json/JSONException
    //   600	614	676	org/json/JSONException
    //   823	872	939	java/lang/Exception
    //   874	938	939	java/lang/Exception
    //   618	667	963	org/json/JSONException
  }
  
  public static void a(sdg paramsdg, BaseArticleInfo paramBaseArticleInfo, ped paramped)
  {
    String str1 = pay.d(paramBaseArticleInfo);
    int i;
    int j;
    label34:
    sie localsie;
    if (((ArticleInfo)paramBaseArticleInfo).hasChannelInfo())
    {
      i = paramBaseArticleInfo.mChannelInfoId;
      if (!TextUtils.isEmpty(paramBaseArticleInfo.mArticleFriendLikeText)) {
        break label565;
      }
      j = 0;
      odq.a(null, "CliOper", "", "", "0X80066FA", "0X80066FA", 0, 0, "", Long.toString(paramBaseArticleInfo.mArticleID), Integer.toString(paramBaseArticleInfo.mStrategyId), pay.b(paramBaseArticleInfo.mAlgorithmID, pay.a(paramBaseArticleInfo), paramped.a().b(), i), false);
      odq.a("0X80066FA", "", "", Long.toString(paramBaseArticleInfo.mArticleID), Integer.toString(paramBaseArticleInfo.mStrategyId), pay.b(paramBaseArticleInfo.mAlgorithmID, pay.a(paramBaseArticleInfo), paramped.a().b(), i));
      localsie = new sie(pay.a(paramBaseArticleInfo.mAlgorithmID, pay.a(paramBaseArticleInfo), paramped.a().b(), i, j, NetworkUtil.isWifiConnected(paramped.a().a()), str1, paramBaseArticleInfo.mStrCircleId, paramBaseArticleInfo.innerUniqueID, pay.f(paramBaseArticleInfo), 409409, (ArticleInfo)paramBaseArticleInfo));
      localsie.a(paramped.a().a(), paramBaseArticleInfo.mArticleID).a(paramped.a().a()).g(ofe.jdField_a_of_type_Int).h(409409).j(paramBaseArticleInfo.mVideoAdsJumpType).k(paramBaseArticleInfo.mVideoAdsSource).a(Boolean.valueOf(pay.w(paramBaseArticleInfo))).a(paramBaseArticleInfo.videoReportInfo);
      if (paramped.a().b() != 0) {
        break label571;
      }
      paramsdg.l = ofe.b();
      localsie.b(paramsdg.l);
      if (paramBaseArticleInfo.mVideoColumnInfo != null) {
        localsie.X(paramBaseArticleInfo.mVideoColumnInfo.jdField_a_of_type_Int);
      }
      if (pgb.a((ArticleInfo)paramBaseArticleInfo) == 6) {
        localsie.Z(rwv.f());
      }
    }
    for (;;)
    {
      if ((paramped.a().a() != null) && (paramped.a().a().a() == paramsdg))
      {
        long l = paramped.a().a().a();
        if (l != 0L) {
          localsie.f(l);
        }
      }
      if (paramped.a().b() != 40677) {
        break label636;
      }
      localsie.b(paramBaseArticleInfo.mVideoAdsJumpType).a(yqu.a(paramped.a().a()));
      localsie.i(2);
      odq.a(null, "CliOper", "", paramBaseArticleInfo.mSubscribeID, "0X8009293", "0X8009293", 0, 0, Long.toString(paramBaseArticleInfo.mFeedId), Long.toString(paramBaseArticleInfo.mArticleID), Integer.toString(paramBaseArticleInfo.mStrategyId), localsie.a().a(), false);
      odq.a("0X8009293", paramBaseArticleInfo.mSubscribeID, Long.toString(paramBaseArticleInfo.mFeedId), Long.toString(paramBaseArticleInfo.mArticleID), Integer.toString(paramBaseArticleInfo.mStrategyId), pay.a(paramBaseArticleInfo.mAlgorithmID, pay.a(paramBaseArticleInfo), paramped.a().b(), i, j, NetworkUtil.isWifiConnected(paramped.a().a()), str1, paramBaseArticleInfo.mStrCircleId, paramBaseArticleInfo.innerUniqueID, pay.f(paramBaseArticleInfo), 409409, (ArticleInfo)paramBaseArticleInfo));
      return;
      i = 0;
      break;
      label565:
      j = 1;
      break label34;
      label571:
      if ((paramped.a().b() == 56) && (paramped.a().a() != null) && (!TextUtils.isEmpty(paramped.a().a().b())))
      {
        paramsdg.m = paramped.a().a().b();
        localsie.c(paramsdg.m);
      }
    }
    label636:
    localsie.a(paramBaseArticleInfo).N((int)paramped.a().a()).c(paramBaseArticleInfo).a(paramBaseArticleInfo, true).d(paramBaseArticleInfo).f(paramBaseArticleInfo);
    if ((pay.l(paramBaseArticleInfo)) && (paramBaseArticleInfo.mPolymericInfo != null)) {
      localsie.w(paramBaseArticleInfo.mPolymericInfo.jdField_f_of_type_Int + 1);
    }
    String str2 = uhv.b(paramped.a().b());
    odq.a(null, "CliOper", "", paramBaseArticleInfo.mSubscribeID, str2, str2, 0, 0, Long.toString(paramBaseArticleInfo.mFeedId), Long.toString(paramBaseArticleInfo.mArticleID), Integer.toString(paramBaseArticleInfo.mStrategyId), pek.a(localsie.a().a(), paramsdg.a), false);
    odq.a(str2, paramBaseArticleInfo.mSubscribeID, Long.toString(paramBaseArticleInfo.mFeedId), Long.toString(paramBaseArticleInfo.mArticleID), Integer.toString(paramBaseArticleInfo.mStrategyId), pay.a(paramBaseArticleInfo.mAlgorithmID, pay.a(paramBaseArticleInfo), paramped.a().b(), i, j, NetworkUtil.isWifiConnected(paramped.a().a()), str1, paramBaseArticleInfo.mStrCircleId, paramBaseArticleInfo.innerUniqueID, pay.f(paramBaseArticleInfo), 409409, (ArticleInfo)paramBaseArticleInfo));
  }
  
  public static void a(boolean paramBoolean, ArticleInfo paramArticleInfo1, ArticleInfo paramArticleInfo2, String paramString, Map<String, Object> paramMap, ped paramped)
  {
    sdg localsdg = phe.a(paramArticleInfo1);
    localsdg.n = paramString;
    localsdg.l = ofe.b();
    if ((paramped.a().a() != null) && (!TextUtils.isEmpty(paramped.a().a().b()))) {
      localsdg.m = paramped.a().a().b();
    }
    paramString = new sie(null, null, null, null);
    int i;
    if (paramBoolean)
    {
      i = 0;
      odq.a(null, "", "0X8008D33", "0X8008D33", 0, 0, "", "", "", paramString.Y(i).b(localsdg.l).c(localsdg.m).a(paramped.a().b()).k(paramArticleInfo1.mVideoAdsSource).j(paramArticleInfo1.mVideoAdsJumpType).a(paramArticleInfo1.videoReportInfo).a(paramArticleInfo1).N((int)paramped.a().a()).a().a(), false);
      if (!rwv.a(paramArticleInfo1, paramped.a().a())) {
        break label210;
      }
      a(localsdg, paramArticleInfo1, paramped);
    }
    label210:
    label495:
    label502:
    do
    {
      return;
      i = 1;
      break;
      if ((paramArticleInfo1.isAccountShown) && (paramped.a().b() == 0) && (!TextUtils.isEmpty(paramArticleInfo1.mArticleContentUrl)))
      {
        pay.d(paramped.a().a(), paramArticleInfo1.mArticleContentUrl);
        paramString = new sie(null, null, paramArticleInfo1.mVideoVid, paramArticleInfo1.innerUniqueID);
        if (paramBoolean)
        {
          i = 0;
          paramArticleInfo2 = paramString.Y(i).b(localsdg.l).c(localsdg.m).a(paramped.a().b()).k(paramArticleInfo1.mVideoAdsSource).j(paramArticleInfo1.mVideoAdsJumpType).a(paramArticleInfo1.videoReportInfo).a(paramArticleInfo1).N((int)paramped.a().a()).V(pay.a(paramArticleInfo1)).e(paramArticleInfo1).Q(7).f(paramArticleInfo2);
          if ((paramArticleInfo1.columnEntrances != null) && (paramArticleInfo1.columnEntrances.size() > 0))
          {
            paramArticleInfo1 = (VideoColumnInfo)paramArticleInfo1.columnEntrances.get(0);
            if (paramArticleInfo1.jdField_a_of_type_Int == 0) {
              break label502;
            }
            paramArticleInfo2.a("is_column", "1");
            paramArticleInfo2.a("column_id", String.valueOf(paramArticleInfo1.jdField_a_of_type_Int));
            if (!paramArticleInfo1.jdField_a_of_type_Boolean) {
              break label495;
            }
            paramArticleInfo1 = "1";
            paramArticleInfo2.a("subscribe_flag", paramArticleInfo1);
          }
        }
        for (;;)
        {
          odq.a(null, "", "0X8007625", "0X8007625", 0, 0, "", "", "", pek.a(paramArticleInfo2.a().a(), paramMap), false);
          return;
          i = 1;
          break;
          paramArticleInfo1 = "2";
          break label446;
          paramArticleInfo2.a("is_column", "0");
        }
      }
      if (paramArticleInfo1.isVideoItemForAdJump())
      {
        paramArticleInfo2 = (Activity)paramped.a().a();
        if (paramArticleInfo2 != null)
        {
          paramString = new Intent(paramArticleInfo2, QQBrowserActivity.class);
          paramString.putExtra("url", paramArticleInfo1.mVideoAdsJumpUrl);
          paramString.putExtra("big_brother_source_key", pay.f(paramped.a().b()));
          paramArticleInfo2.startActivity(paramString);
        }
        a(localsdg, paramArticleInfo1, paramped);
        return;
      }
      if ((paramped.a().b() != 0) && (paramped.a().b() != 56)) {
        break label861;
      }
      if (!rwv.a((Activity)paramped.a().a(), paramArticleInfo1)) {
        break label754;
      }
      a(localsdg, paramArticleInfo1, paramped);
    } while ((paramped.a().b() != 56) || (paramArticleInfo1.mVideoDownloadBarInfo == null) || (paramArticleInfo1.mVideoDownloadBarInfo.weishiUGInfo == null) || (!pay.a(paramArticleInfo1.mVideoDownloadBarInfo.weishiUGInfo.bytes_report_base_url)) || (!pay.a(paramArticleInfo1.mVideoDownloadBarInfo.weishiUGInfo.bytes_click_schema_report_tail)));
    label446:
    rwv.a(pay.a(paramArticleInfo1.mVideoDownloadBarInfo.weishiUGInfo.bytes_report_base_url) + pay.a(paramArticleInfo1.mVideoDownloadBarInfo.weishiUGInfo.bytes_click_schema_report_tail));
    return;
    label754:
    if ((paramped.a().b() == 56) && (paramArticleInfo1.mVideoDownloadBarInfo != null) && (paramArticleInfo1.mVideoDownloadBarInfo.weishiUGInfo != null) && (pay.a(paramArticleInfo1.mVideoDownloadBarInfo.weishiUGInfo.bytes_report_base_url)) && (pay.a(paramArticleInfo1.mVideoDownloadBarInfo.weishiUGInfo.bytes_click_report_tail))) {
      rwv.a(pay.a(paramArticleInfo1.mVideoDownloadBarInfo.weishiUGInfo.bytes_report_base_url) + pay.a(paramArticleInfo1.mVideoDownloadBarInfo.weishiUGInfo.bytes_click_report_tail));
    }
    label861:
    if (paramArticleInfo1.videoJumpChannelID > 0)
    {
      if (paramArticleInfo1.videoJumpChannelID == 56) {
        okj.a(paramped.a().a(), paramArticleInfo2, paramArticleInfo1, true);
      }
      for (;;)
      {
        a(localsdg, paramArticleInfo1, paramped);
        return;
        paramArticleInfo2 = new HashMap();
        paramArticleInfo2.put("param_key_insert_article_id", Long.valueOf(paramArticleInfo1.mArticleID));
        okj.b(paramped.a().a(), paramArticleInfo1.videoJumpChannelID, paramArticleInfo1.videoJumpChannelName, paramArticleInfo1.videoJumpChannelType, 5, paramArticleInfo2);
      }
    }
    if (bkwm.d(BaseApplicationImpl.getApplication().getRuntime()) == 1)
    {
      okj.a(paramped.a().a(), paramArticleInfo2, paramArticleInfo1, true);
      a(localsdg, paramArticleInfo1, paramped);
      return;
    }
    localsdg.a = paramMap;
    paramped.a().a().a(localsdg, paramArticleInfo1);
  }
  
  public static void a(boolean paramBoolean, BaseArticleInfo paramBaseArticleInfo, Context paramContext, int paramInt, long paramLong)
  {
    if ((paramBaseArticleInfo.isAccountShown) && (paramInt == 0) && (!TextUtils.isEmpty(paramBaseArticleInfo.mArticleContentUrl)))
    {
      pay.d(paramContext, paramBaseArticleInfo.mArticleContentUrl);
      paramContext = new sie(null, null, paramBaseArticleInfo.mVideoVid, paramBaseArticleInfo.innerUniqueID);
      if (!paramBoolean) {
        break label129;
      }
    }
    label129:
    for (int i = 0;; i = 1)
    {
      odq.a(null, "", "0X8007625", "0X8007625", 0, 0, "", "", "", paramContext.Y(i).a(paramInt).a(paramBaseArticleInfo.videoReportInfo).a(paramBaseArticleInfo).N((int)paramLong).V(pay.a(paramBaseArticleInfo)).e(paramBaseArticleInfo).Q(6).f(paramBaseArticleInfo).a().a(), false);
      return;
    }
  }
  
  public static void a(boolean paramBoolean, JSONObject paramJSONObject, rcn paramrcn)
  {
    if ((paramJSONObject == null) || (paramrcn.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo == null)) {}
    for (;;)
    {
      return;
      Object localObject = new sie(null, null, null, null).V(Integer.valueOf("1031").intValue()).q(paramJSONObject.optString("double_videocard_jump_page")).r(paramJSONObject.optString("double_videocard_jump_src")).a((int)paramrcn.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo.mChannelID);
      if (uhv.b() > 0) {}
      for (int i = 0;; i = 1)
      {
        paramrcn = ((sie)localObject).ae(i).f(paramrcn.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo);
        if (!paramBoolean) {
          break;
        }
        localObject = paramJSONObject.optString("column_id");
        if (!TextUtils.isEmpty((CharSequence)localObject)) {
          paramrcn.a("columnId", localObject);
        }
        paramrcn.i(paramJSONObject.optString("all_rowkey"));
        paramrcn.s(paramJSONObject.optString("subscript"));
        odq.a(null, null, "0X800A5A8", "0X800A5A8", 0, 0, "", "", "", paramrcn.a().a(), false);
        return;
      }
      i = 0;
      while (i < 2)
      {
        localObject = paramJSONObject.optString("columnId_" + (i + 1));
        if (!TextUtils.isEmpty((CharSequence)localObject)) {
          paramrcn.a("columnId", localObject);
        }
        paramrcn.i(paramJSONObject.optString("rowKey_" + (i + 1)));
        paramrcn.s(paramJSONObject.optString("subscript_" + (i + 1)));
        paramrcn.Y(i);
        odq.a(null, null, "0X8007626", "0X8007626", 0, 0, "", "", "", paramrcn.a().a(), false);
        i += 1;
      }
    }
  }
  
  public static void a(boolean paramBoolean1, boolean paramBoolean2, BaseArticleInfo paramBaseArticleInfo, Activity paramActivity, int paramInt, sdv paramsdv, sdc paramsdc)
  {
    if (paramsdc.b()) {
      paramsdc.a();
    }
    if (paramsdv != null) {
      paramsdv.a(1, paramBaseArticleInfo, 0L, 0L);
    }
    paramsdv = new Intent(paramActivity, ReadInJoyDeliverBiuActivity.class);
    paramsdv.putExtra("arg_article_info", (ArticleInfo)paramBaseArticleInfo);
    paramsdv.putExtra("biu_src", 2);
    paramsdv.putExtra("arg_from_type", 7);
    paramsdv.putExtra("fast_biu_type", paramBoolean2);
    paramActivity.startActivityForResult(paramsdv, 2);
    paramActivity.overridePendingTransition(0, 0);
    paramsdv = paramsdc.a();
    if ((paramsdv != null) && (paramsdv.jdField_c_of_type_JavaLangString.equals(paramBaseArticleInfo.mVideoVid))) {}
    for (long l1 = paramsdc.a();; l1 = 0L)
    {
      paramsdc = new sie(null, paramBaseArticleInfo.mSubscribeID, paramBaseArticleInfo.mVideoVid, paramBaseArticleInfo.innerUniqueID).a(l1).c(paramBaseArticleInfo.mVideoDuration * 1000).e(paramBaseArticleInfo.mAlgorithmID).c(paramBaseArticleInfo.mStrategyId).a(paramInt).g(paramBoolean1).h(paramBoolean2).a().a();
      String str = paramBaseArticleInfo.mSubscribeID;
      if (!TextUtils.isEmpty(paramBaseArticleInfo.innerUniqueID))
      {
        paramsdv = paramBaseArticleInfo.innerUniqueID;
        odq.a(null, str, "0X8007B89", "0X8007B89", 0, 0, "1", "", paramsdv, paramsdc, false);
        long l2 = paramActivity.getIntent().getLongExtra("READINJOY_VIDEO_FORCE_INSERT_ARTICLE_ID", 0L);
        paramActivity = new rdz();
        paramActivity.jdField_d_of_type_Int = ((int)l1);
        paramActivity.jdField_e_of_type_Int = (paramBaseArticleInfo.mVideoDuration * 1000);
        if (l2 != 0L) {
          break label326;
        }
      }
      label326:
      for (int i = 1;; i = 2)
      {
        paramActivity.jdField_c_of_type_Int = i;
        ofe.a(paramBaseArticleInfo, paramInt, 25, -1L, paramActivity);
        return;
        paramsdv = "0";
        break;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     phy
 * JD-Core Version:    0.7.0.1
 */