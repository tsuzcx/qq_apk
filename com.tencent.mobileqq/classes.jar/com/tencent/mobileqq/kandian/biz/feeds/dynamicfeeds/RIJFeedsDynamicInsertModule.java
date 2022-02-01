package com.tencent.mobileqq.kandian.biz.feeds.dynamicfeeds;

import android.os.Build;
import android.os.Handler;
import com.tencent.biz.pubaccount.util.KotlinUtilKt;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.kandian.ad.api.IRIJFastWebRecommendAdService;
import com.tencent.mobileqq.kandian.base.msf.ReadInJoyMSFService;
import com.tencent.mobileqq.kandian.base.msf.ReadInJoyOidbHelper;
import com.tencent.mobileqq.kandian.base.utils.RIJPBFieldUtils;
import com.tencent.mobileqq.kandian.biz.feeds.dynamicfeeds.data.RIJFeedsInsertArticle;
import com.tencent.mobileqq.kandian.biz.feeds.entity.ExposureArticle;
import com.tencent.mobileqq.kandian.glue.msf.ReadInJoyMSFHandlerUtils;
import com.tencent.mobileqq.kandian.repo.common.ReadInJoyEngineModule;
import com.tencent.mobileqq.kandian.repo.feeds.ActionType;
import com.tencent.mobileqq.kandian.repo.feeds.ActionType.Companion;
import com.tencent.mobileqq.kandian.repo.feeds.ArticleInfoModuleUtils;
import com.tencent.mobileqq.kandian.repo.feeds.RIJFeedsInsertAction;
import com.tencent.mobileqq.kandian.repo.feeds.entity.AbsBaseArticleInfo;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBEnumField;
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.persistence.EntityManager;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.qphone.base.remote.FromServiceMsg;
import com.tencent.qphone.base.remote.ToServiceMsg;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.SortedMap;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.atomic.AtomicInteger;
import kotlin.Metadata;
import kotlin.TypeCastException;
import kotlin.collections.MapsKt;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref.ObjectRef;
import kotlin.jvm.internal.TypeIntrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tencent.im.oidb.cmd0x68b.oidb_cmd0x68b.ReqAdvertisePara;
import tencent.im.oidb.cmd0xf30.oidb_cmd0xf30.Action;
import tencent.im.oidb.cmd0xf30.oidb_cmd0xf30.InsertArticle;
import tencent.im.oidb.cmd0xf30.oidb_cmd0xf30.ReqBody;
import tencent.im.oidb.cmd0xf30.oidb_cmd0xf30.ReqRecommendPara;
import tencent.im.oidb.cmd0xf30.oidb_cmd0xf30.RspBody;
import tencent.im.oidb.cmd0xf30.oidb_cmd0xf30.RspRecommendParaArticle;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/mobileqq/kandian/biz/feeds/dynamicfeeds/RIJFeedsDynamicInsertModule;", "Lcom/tencent/mobileqq/kandian/repo/common/ReadInJoyEngineModule;", "app", "Lcom/tencent/common/app/AppInterface;", "entityManager", "Lcom/tencent/mobileqq/persistence/EntityManager;", "executor", "Ljava/util/concurrent/ExecutorService;", "msfService", "Lcom/tencent/mobileqq/kandian/base/msf/ReadInJoyMSFService;", "mainThreadHandler", "Landroid/os/Handler;", "(Lcom/tencent/common/app/AppInterface;Lcom/tencent/mobileqq/persistence/EntityManager;Ljava/util/concurrent/ExecutorService;Lcom/tencent/mobileqq/kandian/base/msf/ReadInJoyMSFService;Landroid/os/Handler;)V", "callbackMap", "Ljava/util/concurrent/ConcurrentHashMap;", "", "Lcom/tencent/mobileqq/kandian/biz/feeds/dynamicfeeds/RIJFeedsDynamicInsertModule$Companion$IFeedsDynamicInsertCallback;", "callbackSeq", "Ljava/util/concurrent/atomic/AtomicInteger;", "feedsInsertInfoMap", "", "Lcom/tencent/mobileqq/kandian/biz/feeds/dynamicfeeds/data/RIJFeedsInsertArticle;", "getFeedsInsertInfoMap", "()Ljava/util/concurrent/ConcurrentHashMap;", "addAdInfo", "", "msg_req_recommend_para", "Ltencent/im/oidb/cmd0xf30/oidb_cmd0xf30$ReqRecommendPara;", "addCommonInfo", "articleList", "", "Lcom/tencent/mobileqq/kandian/repo/feeds/entity/AbsBaseArticleInfo;", "insertArticle", "Ltencent/im/oidb/cmd0xf30/oidb_cmd0xf30$InsertArticle;", "canDelete", "", "article", "exposureArticle", "Lcom/tencent/mobileqq/kandian/biz/feeds/entity/ExposureArticle;", "deleteFeedsDynamicInsertInfo", "reqSource", "rowKey", "deleteFeedsDynamicInsertInfoInServer", "doRealRequest", "actionType", "Lcom/tencent/mobileqq/kandian/repo/feeds/ActionType;", "isPreload", "feedsDynamicInsertCallback", "(Ljava/lang/Integer;Ljava/lang/String;Lcom/tencent/mobileqq/kandian/repo/feeds/ActionType;ZLcom/tencent/mobileqq/kandian/biz/feeds/dynamicfeeds/RIJFeedsDynamicInsertModule$Companion$IFeedsDynamicInsertCallback;)V", "getAdPosition", "getAdRequestData", "Ltencent/im/oidb/cmd0x68b/oidb_cmd0x68b$ReqAdvertisePara;", "getFeedsInsertInfo", "handle0xf30", "req", "Lcom/tencent/qphone/base/remote/ToServiceMsg;", "res", "Lcom/tencent/qphone/base/remote/FromServiceMsg;", "data", "", "handleAdArticles", "handleNormalArticles", "isAd", "makeDynamicInsertArticleParams", "(Ljava/lang/Integer;Ljava/lang/String;Lcom/tencent/mobileqq/kandian/repo/feeds/ActionType;Z)Lcom/tencent/qphone/base/remote/ToServiceMsg;", "onReceive", "parseArticle", "feedsInsertArticle", "parseFeedsInserArticleFromPb", "rspBody", "Ltencent/im/oidb/cmd0xf30/oidb_cmd0xf30$RspBody;", "parseInsertAction", "action", "Ltencent/im/oidb/cmd0xf30/oidb_cmd0xf30$Action;", "parseInsertArticles", "insertArticleList", "Lcom/tencent/mobileqq/pb/PBRepeatMessageField;", "requestDynamicInsertArticle", "progress", "watchTime", "(Ljava/lang/Integer;Ljava/lang/String;Lcom/tencent/mobileqq/kandian/repo/feeds/ActionType;ZLcom/tencent/mobileqq/kandian/biz/feeds/dynamicfeeds/RIJFeedsDynamicInsertModule$Companion$IFeedsDynamicInsertCallback;II)V", "saveInsertArticleIfNecessary", "unInitialize", "Companion", "kandian_feature_impl_release"}, k=1, mv={1, 1, 16})
public final class RIJFeedsDynamicInsertModule
  extends ReadInJoyEngineModule
{
  public static final RIJFeedsDynamicInsertModule.Companion a;
  @NotNull
  private final ConcurrentHashMap<Integer, ConcurrentHashMap<String, RIJFeedsInsertArticle>> jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap = new ConcurrentHashMap();
  private final AtomicInteger jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger = new AtomicInteger();
  private final ConcurrentHashMap<Integer, RIJFeedsDynamicInsertModule.Companion.IFeedsDynamicInsertCallback> b = new ConcurrentHashMap();
  
  static
  {
    jdField_a_of_type_ComTencentMobileqqKandianBizFeedsDynamicfeedsRIJFeedsDynamicInsertModule$Companion = new RIJFeedsDynamicInsertModule.Companion(null);
  }
  
  public RIJFeedsDynamicInsertModule(@Nullable AppInterface paramAppInterface, @Nullable EntityManager paramEntityManager, @Nullable ExecutorService paramExecutorService, @Nullable ReadInJoyMSFService paramReadInJoyMSFService, @Nullable Handler paramHandler)
  {
    super(paramAppInterface, paramEntityManager, paramExecutorService, paramReadInJoyMSFService, paramHandler);
  }
  
  private final RIJFeedsInsertArticle a(oidb_cmd0xf30.RspBody paramRspBody)
  {
    RIJFeedsInsertArticle localRIJFeedsInsertArticle = new RIJFeedsInsertArticle();
    if ((paramRspBody.msg_rsp_channel_article.has()) && (paramRspBody.msg_rsp_channel_article.insert_list.has()))
    {
      PBRepeatMessageField localPBRepeatMessageField = paramRspBody.msg_rsp_channel_article.insert_list;
      if (RIJPBFieldUtils.a(localPBRepeatMessageField))
      {
        Intrinsics.checkExpressionValueIsNotNull(localPBRepeatMessageField, "insertArticleList");
        a(localPBRepeatMessageField, localRIJFeedsInsertArticle);
      }
      localRIJFeedsInsertArticle.a(RIJPBFieldUtils.a(paramRspBody.msg_rsp_channel_article.seq_no));
    }
    else
    {
      QLog.d("RIJFeedsDynamicInsertModule", 1, "parseFeedsInserArticleFromPb, msg_rsp_channel_article empty!");
    }
    paramRspBody = localRIJFeedsInsertArticle.a();
    if (paramRspBody != null) {
      paramRspBody = MapsKt.toSortedMap((Map)paramRspBody);
    } else {
      paramRspBody = null;
    }
    localRIJFeedsInsertArticle.a(paramRspBody);
    return localRIJFeedsInsertArticle;
  }
  
  private final List<Integer> a()
  {
    QRouteApi localQRouteApi = QRoute.api(IRIJFastWebRecommendAdService.class);
    Intrinsics.checkExpressionValueIsNotNull(localQRouteApi, "QRoute.api(IRIJFastWebRe…endAdService::class.java)");
    return ((IRIJFastWebRecommendAdService)localQRouteApi).getAdPos();
  }
  
  private final List<AbsBaseArticleInfo> a(oidb_cmd0xf30.InsertArticle paramInsertArticle)
  {
    boolean bool = paramInsertArticle.rpt_article_list.has();
    List localList = null;
    if (bool) {
      localList = ReadInJoyMSFHandlerUtils.a(null, paramInsertArticle.rpt_article_list.get(), 0, 0, 0);
    }
    return localList;
  }
  
  private final void a(int paramInt, String paramString, RIJFeedsInsertArticle paramRIJFeedsInsertArticle)
  {
    if (paramInt != 1)
    {
      if (!this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.containsKey(Integer.valueOf(paramInt))) {
        ((Map)this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap).put(Integer.valueOf(paramInt), new ConcurrentHashMap());
      }
      ConcurrentHashMap localConcurrentHashMap = (ConcurrentHashMap)this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.get(Integer.valueOf(paramInt));
      if ((localConcurrentHashMap != null) && (!localConcurrentHashMap.containsKey(paramString)))
      {
        localConcurrentHashMap = (ConcurrentHashMap)this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.get(Integer.valueOf(paramInt));
        if (localConcurrentHashMap != null) {
          paramString = (RIJFeedsInsertArticle)localConcurrentHashMap.put(paramString, paramRIJFeedsInsertArticle);
        }
      }
    }
  }
  
  private final void a(PBRepeatMessageField<oidb_cmd0xf30.InsertArticle> paramPBRepeatMessageField, RIJFeedsInsertArticle paramRIJFeedsInsertArticle)
  {
    paramPBRepeatMessageField = paramPBRepeatMessageField.get().iterator();
    while (paramPBRepeatMessageField.hasNext()) {
      a((oidb_cmd0xf30.InsertArticle)paramPBRepeatMessageField.next(), paramRIJFeedsInsertArticle);
    }
  }
  
  private final void a(Integer paramInteger, String paramString, ActionType paramActionType, boolean paramBoolean, RIJFeedsDynamicInsertModule.Companion.IFeedsDynamicInsertCallback paramIFeedsDynamicInsertCallback)
  {
    ThreadManager.executeOnSubThread((Runnable)new RIJFeedsDynamicInsertModule.doRealRequest.1(this, paramString, paramInteger, paramActionType, paramBoolean, paramIFeedsDynamicInsertCallback));
  }
  
  private final void a(List<? extends AbsBaseArticleInfo> paramList, oidb_cmd0xf30.InsertArticle paramInsertArticle)
  {
    boolean bool = RIJPBFieldUtils.a(paramInsertArticle.filter_ad);
    int i = RIJPBFieldUtils.a(paramInsertArticle.least_ad_dis);
    paramList = paramList.iterator();
    while (paramList.hasNext())
    {
      paramInsertArticle = (AbsBaseArticleInfo)paramList.next();
      paramInsertArticle.articleInsertInfo.jdField_a_of_type_Boolean = true;
      paramInsertArticle.articleInsertInfo.b = bool;
      paramInsertArticle.articleInsertInfo.jdField_a_of_type_Int = i;
    }
    paramList = new StringBuilder();
    paramList.append("addCommonInfo! filterAd=");
    paramList.append(bool);
    paramList.append(", leastAdDis=");
    paramList.append(i);
    QLog.d("RIJFeedsDynamicInsertModule", 1, paramList.toString());
  }
  
  private final void a(oidb_cmd0xf30.Action paramAction, oidb_cmd0xf30.InsertArticle paramInsertArticle, RIJFeedsInsertArticle paramRIJFeedsInsertArticle)
  {
    RIJFeedsInsertAction localRIJFeedsInsertAction = new RIJFeedsInsertAction(ActionType.Companion.a(RIJPBFieldUtils.a(paramAction.action_type)), RIJPBFieldUtils.a(paramAction.progress), RIJPBFieldUtils.a(paramAction.priority), RIJPBFieldUtils.a(paramAction.watch_time));
    boolean bool = RIJPBFieldUtils.a(paramInsertArticle.is_ad);
    if (bool) {
      paramAction = b(paramInsertArticle);
    } else {
      paramAction = a(paramInsertArticle);
    }
    Object localObject = null;
    if (paramAction != null)
    {
      SortedMap localSortedMap = paramRIJFeedsInsertArticle.a();
      if ((localSortedMap == null) || (localSortedMap.containsKey(localRIJFeedsInsertAction) != true))
      {
        localSortedMap = paramRIJFeedsInsertArticle.a();
        if (localSortedMap != null) {
          ((Map)localSortedMap).put(localRIJFeedsInsertAction, new ArrayList());
        }
      }
      a(paramAction, paramInsertArticle);
      paramInsertArticle = paramRIJFeedsInsertArticle.a();
      if (paramInsertArticle != null) {
        paramInsertArticle = (ArrayList)paramInsertArticle.get(localRIJFeedsInsertAction);
      } else {
        paramInsertArticle = null;
      }
      if (paramInsertArticle != null) {
        paramInsertArticle.addAll((Collection)paramAction);
      } else {
        throw new TypeCastException("null cannot be cast to non-null type java.util.ArrayList<com.tencent.mobileqq.kandian.repo.feeds.entity.AbsBaseArticleInfo>");
      }
    }
    paramRIJFeedsInsertArticle = new StringBuilder();
    paramRIJFeedsInsertArticle.append("parseInsertAction, isAd=");
    paramRIJFeedsInsertArticle.append(bool);
    paramRIJFeedsInsertArticle.append(",size=");
    paramInsertArticle = localObject;
    if (paramAction != null) {
      paramInsertArticle = Integer.valueOf(paramAction.size());
    }
    paramRIJFeedsInsertArticle.append(paramInsertArticle);
    QLog.d("RIJFeedsDynamicInsertModule", 1, paramRIJFeedsInsertArticle.toString());
  }
  
  private final void a(oidb_cmd0xf30.InsertArticle paramInsertArticle, RIJFeedsInsertArticle paramRIJFeedsInsertArticle)
  {
    if ((paramInsertArticle != null) && (RIJPBFieldUtils.a(paramInsertArticle.actions)))
    {
      Iterator localIterator = paramInsertArticle.actions.get().iterator();
      while (localIterator.hasNext())
      {
        oidb_cmd0xf30.Action localAction = (oidb_cmd0xf30.Action)localIterator.next();
        Intrinsics.checkExpressionValueIsNotNull(localAction, "action");
        a(localAction, paramInsertArticle, paramRIJFeedsInsertArticle);
      }
    }
  }
  
  private final void a(oidb_cmd0xf30.ReqRecommendPara paramReqRecommendPara)
  {
    Object localObject = a();
    if (localObject != null) {
      paramReqRecommendPara.req_advertise_para.set((MessageMicro)localObject);
    }
    localObject = a();
    if (localObject != null) {
      paramReqRecommendPara.rpt_ads_pos.set((List)localObject);
    }
  }
  
  private final boolean a(AbsBaseArticleInfo paramAbsBaseArticleInfo)
  {
    return false;
  }
  
  private final List<AbsBaseArticleInfo> b(oidb_cmd0xf30.InsertArticle paramInsertArticle)
  {
    return ((IRIJFastWebRecommendAdService)QRoute.api(IRIJFastWebRecommendAdService.class)).parseAdvertise(paramInsertArticle);
  }
  
  @Nullable
  public final RIJFeedsInsertArticle a(int paramInt, @Nullable String paramString)
  {
    Ref.ObjectRef localObjectRef = new Ref.ObjectRef();
    localObjectRef.element = ((RIJFeedsInsertArticle)null);
    KotlinUtilKt.a(paramString, this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.get(Integer.valueOf(paramInt)), (Function2)new RIJFeedsDynamicInsertModule.getFeedsInsertInfo.1(localObjectRef));
    return (RIJFeedsInsertArticle)localObjectRef.element;
  }
  
  @NotNull
  public final ToServiceMsg a(@Nullable Integer paramInteger, @Nullable String paramString, @NotNull ActionType paramActionType, boolean paramBoolean)
  {
    Intrinsics.checkParameterIsNotNull(paramActionType, "actionType");
    oidb_cmd0xf30.ReqBody localReqBody = new oidb_cmd0xf30.ReqBody();
    if (paramInteger != null) {
      localReqBody.uint32_req_source.set(paramInteger.intValue());
    }
    paramInteger = new oidb_cmd0xf30.ReqRecommendPara();
    paramInteger.bytes_req_rowkey.set(ByteStringMicro.copyFromUtf8(paramString));
    paramInteger.bytes_subscribe_id.set(ByteStringMicro.copyFromUtf8(paramString));
    paramInteger.bytes_manufacturer.set(ByteStringMicro.copyFromUtf8(Build.BRAND));
    paramInteger.bytes_device_brand_and_model.set(ByteStringMicro.copyFromUtf8(Build.MODEL));
    paramInteger.uint32_network_type.set(ArticleInfoModuleUtils.a());
    paramInteger.uint32_os_type.set(2);
    paramInteger.action_type.set(paramActionType.toPBInt());
    paramInteger.uint32_card_pos.set(RIJFeedsInsertUtil.a.a());
    a(paramInteger);
    localReqBody.msg_req_recommend_para.set((MessageMicro)paramInteger);
    paramInteger = ReadInJoyOidbHelper.a("OidbSvc.0xf30", 3888, 0, localReqBody.toByteArray());
    Intrinsics.checkExpressionValueIsNotNull(paramInteger, "ReadInJoyOidbHelper.make…0, reqBody.toByteArray())");
    return paramInteger;
  }
  
  @Nullable
  public final oidb_cmd0x68b.ReqAdvertisePara a()
  {
    QRouteApi localQRouteApi = QRoute.api(IRIJFastWebRecommendAdService.class);
    Intrinsics.checkExpressionValueIsNotNull(localQRouteApi, "QRoute.api(IRIJFastWebRe…endAdService::class.java)");
    return ((IRIJFastWebRecommendAdService)localQRouteApi).getAdRequestData();
  }
  
  public final void a(int paramInt, @Nullable String paramString)
  {
    Object localObject1 = new StringBuilder();
    ((StringBuilder)localObject1).append("deleteFeedsDynamicInsertInfo, reqSource: ");
    ((StringBuilder)localObject1).append(paramInt);
    ((StringBuilder)localObject1).append(", rowKey:");
    ((StringBuilder)localObject1).append(paramString);
    QLog.d("RIJFeedsDynamicInsertModule", 1, ((StringBuilder)localObject1).toString());
    if (paramString == null) {
      return;
    }
    Object localObject2 = this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.get(Integer.valueOf(paramInt));
    localObject1 = (ConcurrentHashMap)this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.get(Integer.valueOf(paramInt));
    if (localObject1 != null) {
      localObject1 = (RIJFeedsInsertArticle)((ConcurrentHashMap)localObject1).get(paramString);
    } else {
      localObject1 = null;
    }
    KotlinUtilKt.a(paramString, localObject2, localObject1, (Function3)RIJFeedsDynamicInsertModule.deleteFeedsDynamicInsertInfo.1.INSTANCE);
  }
  
  public final void a(@Nullable ExposureArticle paramExposureArticle)
  {
    Object localObject1 = new StringBuilder();
    ((StringBuilder)localObject1).append("deleteFeedsDynamicInsertInfo, rowKey:");
    ((StringBuilder)localObject1).append(paramExposureArticle);
    QLog.d("RIJFeedsDynamicInsertModule", 1, ((StringBuilder)localObject1).toString());
    if (paramExposureArticle == null) {
      return;
    }
    localObject1 = ((Map)this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap).entrySet().iterator();
    label55:
    if (((Iterator)localObject1).hasNext())
    {
      Iterator localIterator1 = ((Map)((Map.Entry)((Iterator)localObject1).next()).getValue()).entrySet().iterator();
      for (;;)
      {
        if (!localIterator1.hasNext()) {
          break label55;
        }
        Object localObject2 = ((RIJFeedsInsertArticle)((Map.Entry)localIterator1.next()).getValue()).a();
        if (localObject2 == null) {
          break;
        }
        localObject2 = ((Map)localObject2).entrySet().iterator();
        while (((Iterator)localObject2).hasNext())
        {
          ArrayList localArrayList1 = (ArrayList)((Map.Entry)((Iterator)localObject2).next()).getValue();
          ArrayList localArrayList2 = new ArrayList();
          Iterator localIterator2 = localArrayList1.iterator();
          while (localIterator2.hasNext())
          {
            AbsBaseArticleInfo localAbsBaseArticleInfo = (AbsBaseArticleInfo)localIterator2.next();
            Intrinsics.checkExpressionValueIsNotNull(localAbsBaseArticleInfo, "article");
            if (a(localAbsBaseArticleInfo, paramExposureArticle)) {
              localArrayList2.add(localAbsBaseArticleInfo);
            }
          }
          localArrayList1.removeAll((Collection)localArrayList2);
        }
      }
    }
  }
  
  public final void a(@Nullable ToServiceMsg paramToServiceMsg, @Nullable FromServiceMsg paramFromServiceMsg, @Nullable Object paramObject)
  {
    Object localObject = new oidb_cmd0xf30.RspBody();
    int i = ReadInJoyOidbHelper.a(paramFromServiceMsg, paramObject, (MessageMicro)localObject);
    paramFromServiceMsg = new StringBuilder();
    paramFromServiceMsg.append("resultCode: ");
    paramFromServiceMsg.append(i);
    QLog.d("RIJFeedsDynamicInsertModule", 1, paramFromServiceMsg.toString());
    if (paramToServiceMsg != null) {
      paramFromServiceMsg = paramToServiceMsg.getAttribute("insert_callback");
    } else {
      paramFromServiceMsg = null;
    }
    paramObject = paramFromServiceMsg;
    if (!(paramFromServiceMsg instanceof Integer)) {
      paramObject = null;
    }
    Integer localInteger = (Integer)paramObject;
    if (paramToServiceMsg != null) {
      paramFromServiceMsg = paramToServiceMsg.getAttribute("insert_reqsource");
    } else {
      paramFromServiceMsg = null;
    }
    paramObject = paramFromServiceMsg;
    if (!(paramFromServiceMsg instanceof Integer)) {
      paramObject = null;
    }
    paramObject = (Integer)paramObject;
    if (paramToServiceMsg != null) {
      paramToServiceMsg = paramToServiceMsg.getAttribute("insert_rowkey");
    } else {
      paramToServiceMsg = null;
    }
    paramFromServiceMsg = paramToServiceMsg;
    if (!(paramToServiceMsg instanceof String)) {
      paramFromServiceMsg = null;
    }
    paramFromServiceMsg = (String)paramFromServiceMsg;
    if (i == 0)
    {
      paramToServiceMsg = a((oidb_cmd0xf30.RspBody)localObject);
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("reqSource: ");
      ((StringBuilder)localObject).append(paramObject);
      ((StringBuilder)localObject).append(", rowKey: ");
      ((StringBuilder)localObject).append(paramFromServiceMsg);
      ((StringBuilder)localObject).append(", handle0xf30, result: ");
      ((StringBuilder)localObject).append(paramToServiceMsg.b());
      QLog.d("RIJFeedsDynamicInsertModule", 1, ((StringBuilder)localObject).toString());
      KotlinUtilKt.a(paramObject, paramFromServiceMsg, paramToServiceMsg, (Function3)new RIJFeedsDynamicInsertModule.handle0xf30.1(this));
      paramFromServiceMsg = (RIJFeedsDynamicInsertModule.Companion.IFeedsDynamicInsertCallback)((Map)this.b).get(localInteger);
      if (paramFromServiceMsg != null)
      {
        paramObject = new StringBuilder();
        paramObject.append("has callback: ");
        paramObject.append(paramFromServiceMsg);
        QLog.d("RIJFeedsDynamicInsertModule", 1, paramObject.toString());
        paramFromServiceMsg.a(paramToServiceMsg);
      }
    }
    paramToServiceMsg = (Map)this.b;
    if (paramToServiceMsg != null)
    {
      TypeIntrinsics.asMutableMap(paramToServiceMsg).remove(localInteger);
      return;
    }
    throw new TypeCastException("null cannot be cast to non-null type kotlin.collections.MutableMap<K, V>");
  }
  
  public final void a(@Nullable Integer paramInteger, @Nullable String paramString, @NotNull ActionType paramActionType, boolean paramBoolean, @Nullable RIJFeedsDynamicInsertModule.Companion.IFeedsDynamicInsertCallback paramIFeedsDynamicInsertCallback, int paramInt1, int paramInt2)
  {
    Intrinsics.checkParameterIsNotNull(paramActionType, "actionType");
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("requestDynamicInsertArticle reqSource: ");
    ((StringBuilder)localObject).append(paramInteger);
    ((StringBuilder)localObject).append(", rowKey: ");
    ((StringBuilder)localObject).append(paramString);
    ((StringBuilder)localObject).append(", actionType: ");
    ((StringBuilder)localObject).append(paramActionType);
    ((StringBuilder)localObject).append(", isPreload: ");
    ((StringBuilder)localObject).append(paramBoolean);
    ((StringBuilder)localObject).append(", callback: ");
    ((StringBuilder)localObject).append(paramIFeedsDynamicInsertCallback);
    QLog.d("RIJFeedsDynamicInsertModule", 1, ((StringBuilder)localObject).toString());
    localObject = (Map)this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap;
    if (localObject != null)
    {
      if ((((Map)localObject).containsKey(paramInteger)) && (paramString != null))
      {
        localObject = (ConcurrentHashMap)((Map)this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap).get(paramInteger);
        if ((localObject != null) && (((ConcurrentHashMap)localObject).containsKey(paramString) == true))
        {
          QLog.d("RIJFeedsDynamicInsertModule", 1, "hasCache, return");
          if (paramIFeedsDynamicInsertCallback != null)
          {
            paramInteger = (ConcurrentHashMap)((Map)this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap).get(paramInteger);
            if (paramInteger != null) {
              paramInteger = (RIJFeedsInsertArticle)paramInteger.get(paramString);
            } else {
              paramInteger = null;
            }
            paramIFeedsDynamicInsertCallback.a(paramInteger);
          }
          return;
        }
      }
      a(paramInteger, paramString, paramActionType, paramBoolean, paramIFeedsDynamicInsertCallback);
      return;
    }
    throw new TypeCastException("null cannot be cast to non-null type kotlin.collections.Map<K, *>");
  }
  
  public final boolean a(@NotNull AbsBaseArticleInfo paramAbsBaseArticleInfo, @NotNull ExposureArticle paramExposureArticle)
  {
    Intrinsics.checkParameterIsNotNull(paramAbsBaseArticleInfo, "article");
    Intrinsics.checkParameterIsNotNull(paramExposureArticle, "exposureArticle");
    if (Intrinsics.areEqual(paramExposureArticle.a(), paramAbsBaseArticleInfo.innerUniqueID)) {
      return true;
    }
    if (paramExposureArticle.a()) {
      return a(paramAbsBaseArticleInfo);
    }
    return false;
  }
  
  public void onReceive(@Nullable ToServiceMsg paramToServiceMsg, @Nullable FromServiceMsg paramFromServiceMsg, @Nullable Object paramObject)
  {
    String str;
    if (paramFromServiceMsg != null) {
      str = paramFromServiceMsg.getServiceCmd();
    } else {
      str = null;
    }
    if (Intrinsics.areEqual(str, "OidbSvc.0xf30"))
    {
      QLog.d("RIJFeedsDynamicInsertModule", 1, "handle0xf30");
      a(paramToServiceMsg, paramFromServiceMsg, paramObject);
    }
  }
  
  public void unInitialize()
  {
    QLog.d("RIJFeedsDynamicInsertModule", 1, "unInitialize");
    this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.clear();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.feeds.dynamicfeeds.RIJFeedsDynamicInsertModule
 * JD-Core Version:    0.7.0.1
 */