package com.tencent.mobileqq.kandian.biz.feeds.dynamicfeeds;

import android.content.Context;
import android.os.Handler;
import android.text.TextUtils;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.kandian.base.msf.ReadInJoyMSFService;
import com.tencent.mobileqq.kandian.base.msf.ReadInJoyOidbHelper;
import com.tencent.mobileqq.kandian.biz.follow.popup.RIJPopupWindowUtil;
import com.tencent.mobileqq.kandian.glue.msf.ReadInJoyMSFHandlerUtils;
import com.tencent.mobileqq.kandian.repo.common.ReadInJoyEngineModule;
import com.tencent.mobileqq.kandian.repo.feeds.ArticleInfoModuleUtils;
import com.tencent.mobileqq.kandian.repo.feeds.RecommendFollowInfos;
import com.tencent.mobileqq.kandian.repo.feeds.entity.AbsBaseArticleInfo;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.mobileqq.persistence.EntityManager;
import com.tencent.qphone.base.remote.FromServiceMsg;
import com.tencent.qphone.base.remote.ToServiceMsg;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ExecutorService;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tencent.im.oidb.articlesummary.articlesummary.ArticleSummary;
import tencent.im.oidb.cmd0xebb.oidb_cmd0xebb.ReqBody;
import tencent.im.oidb.cmd0xebb.oidb_cmd0xebb.ReqRecommendPara;
import tencent.im.oidb.cmd0xebb.oidb_cmd0xebb.RspBody;
import tencent.im.oidb.cmd0xebb.oidb_cmd0xebb.RspRecommendParaArticle;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/mobileqq/kandian/biz/feeds/dynamicfeeds/RIJFeedsInsertModule;", "Lcom/tencent/mobileqq/kandian/repo/common/ReadInJoyEngineModule;", "app", "Lcom/tencent/common/app/AppInterface;", "entityManager", "Lcom/tencent/mobileqq/persistence/EntityManager;", "executor", "Ljava/util/concurrent/ExecutorService;", "msfService", "Lcom/tencent/mobileqq/kandian/base/msf/ReadInJoyMSFService;", "mainThreadHandler", "Landroid/os/Handler;", "(Lcom/tencent/common/app/AppInterface;Lcom/tencent/mobileqq/persistence/EntityManager;Ljava/util/concurrent/ExecutorService;Lcom/tencent/mobileqq/kandian/base/msf/ReadInJoyMSFService;Landroid/os/Handler;)V", "feedsInsertInfoMap", "Ljava/util/concurrent/ConcurrentHashMap;", "", "", "Ljava/util/ArrayList;", "Lcom/tencent/mobileqq/kandian/repo/feeds/entity/AbsBaseArticleInfo;", "Lkotlin/collections/ArrayList;", "requestTimeMap", "addFeedsInsertInfo", "", "channelId", "rowKey", "articleInfoList", "", "addOrReplaceArticleInfoInList", "articleInfo", "addRequestAttributes", "request", "Lcom/tencent/qphone/base/remote/ToServiceMsg;", "reqParams", "Lcom/tencent/mobileqq/kandian/biz/feeds/dynamicfeeds/RIJFeedsInsertModule$ReqParams;", "deleteFeedsInsertInfo", "getArticleInfoListLogInfo", "getFeedsInsertInfo", "handleMainTLFeedsInsertInfo", "req", "rspBody", "Ltencent/im/oidb/cmd0xebb/oidb_cmd0xebb$RspBody;", "result", "", "handleNativePopupInfo", "handleReceiveFeedsInsertInfo", "res", "Lcom/tencent/qphone/base/remote/FromServiceMsg;", "data", "", "isAbleToRequest", "", "followPuin", "onReceive", "removeInvalidArticleInfo", "requestFeedsInsertInfo", "requestFollowPopupInfo", "subscribeId", "reqSource", "unInitialize", "Companion", "ReqParams", "kandian_feature_impl_release"}, k=1, mv={1, 1, 16})
public final class RIJFeedsInsertModule
  extends ReadInJoyEngineModule
{
  public static final RIJFeedsInsertModule.Companion a;
  private final ConcurrentHashMap<Long, ConcurrentHashMap<String, ArrayList<AbsBaseArticleInfo>>> a;
  private final ConcurrentHashMap<String, Long> b = new ConcurrentHashMap();
  
  static
  {
    jdField_a_of_type_ComTencentMobileqqKandianBizFeedsDynamicfeedsRIJFeedsInsertModule$Companion = new RIJFeedsInsertModule.Companion(null);
  }
  
  public RIJFeedsInsertModule(@Nullable AppInterface paramAppInterface, @Nullable EntityManager paramEntityManager, @Nullable ExecutorService paramExecutorService, @Nullable ReadInJoyMSFService paramReadInJoyMSFService, @Nullable Handler paramHandler)
  {
    super(paramAppInterface, paramEntityManager, paramExecutorService, paramReadInJoyMSFService, paramHandler);
    this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap = new ConcurrentHashMap();
  }
  
  private final String a(List<? extends AbsBaseArticleInfo> paramList)
  {
    StringBuilder localStringBuilder1 = new StringBuilder();
    paramList = ((Iterable)paramList).iterator();
    int i = 0;
    while (paramList.hasNext())
    {
      AbsBaseArticleInfo localAbsBaseArticleInfo = (AbsBaseArticleInfo)paramList.next();
      StringBuilder localStringBuilder2 = new StringBuilder();
      localStringBuilder2.append("\n articleInfo[");
      localStringBuilder2.append(i);
      localStringBuilder2.append("] = ");
      localStringBuilder2.append(localAbsBaseArticleInfo);
      localStringBuilder2.append(' ');
      localStringBuilder1.append(localStringBuilder2.toString());
      i += 1;
    }
    paramList = localStringBuilder1.toString();
    Intrinsics.checkExpressionValueIsNotNull(paramList, "stringBuilder.toString()");
    return paramList;
  }
  
  private final void a(AbsBaseArticleInfo paramAbsBaseArticleInfo, ArrayList<AbsBaseArticleInfo> paramArrayList)
  {
    Iterator localIterator = ((Iterable)paramArrayList).iterator();
    int i = 0;
    while (localIterator.hasNext())
    {
      if (TextUtils.equals((CharSequence)((AbsBaseArticleInfo)localIterator.next()).innerUniqueID, (CharSequence)paramAbsBaseArticleInfo.innerUniqueID))
      {
        paramArrayList.set(i, paramAbsBaseArticleInfo);
        paramArrayList = new StringBuilder();
        paramArrayList.append("[addOrReplaceArticleInfoInList] replace old articleInfo, articleInfo = ");
        paramArrayList.append(RIJFeedsInsertUtil.a.a(paramAbsBaseArticleInfo));
        paramArrayList.append(", index = ");
        paramArrayList.append(i);
        QLog.i("RIJFeedsInsertModule", 1, paramArrayList.toString());
        return;
      }
      i += 1;
    }
    paramArrayList.add(0, paramAbsBaseArticleInfo);
    paramArrayList = new StringBuilder();
    paramArrayList.append("[addOrReplaceArticleInfoInList] add new articleInfo, articleInfo = ");
    paramArrayList.append(RIJFeedsInsertUtil.a.a(paramAbsBaseArticleInfo));
    QLog.i("RIJFeedsInsertModule", 1, paramArrayList.toString());
  }
  
  private final void a(ToServiceMsg paramToServiceMsg, RIJFeedsInsertModule.ReqParams paramReqParams)
  {
    Object localObject = paramToServiceMsg.getAttributes();
    Intrinsics.checkExpressionValueIsNotNull(localObject, "request.attributes");
    ((Map)localObject).put("key_channel_id", Long.valueOf(paramReqParams.a()));
    localObject = paramToServiceMsg.getAttributes();
    Intrinsics.checkExpressionValueIsNotNull(localObject, "request.attributes");
    Map localMap = (Map)localObject;
    localObject = paramReqParams.a();
    if (localObject != null)
    {
      localObject = ((AbsBaseArticleInfo)localObject).innerUniqueID;
      if (localObject != null) {}
    }
    else
    {
      localObject = "";
    }
    localMap.put("key_article_rowKey", localObject);
    localObject = paramToServiceMsg.getAttributes();
    Intrinsics.checkExpressionValueIsNotNull(localObject, "request.attributes");
    ((Map)localObject).put("key_subscribe_id", paramReqParams.a());
    paramToServiceMsg = paramToServiceMsg.getAttributes();
    Intrinsics.checkExpressionValueIsNotNull(paramToServiceMsg, "request.attributes");
    ((Map)paramToServiceMsg).put("key_service_type", Integer.valueOf(0));
  }
  
  private final void a(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    oidb_cmd0xebb.RspBody localRspBody = new oidb_cmd0xebb.RspBody();
    int i = ReadInJoyOidbHelper.a(paramFromServiceMsg, paramObject, (MessageMicro)localRspBody);
    paramObject = Integer.valueOf(0);
    if (paramToServiceMsg != null)
    {
      paramFromServiceMsg = paramToServiceMsg.getAttribute("key_service_type", paramObject);
      if (paramFromServiceMsg != null) {}
    }
    else
    {
      paramFromServiceMsg = paramObject;
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("[handleReceiveFeedsInsertInfo], result = ");
    localStringBuilder.append(i);
    localStringBuilder.append(", serviceType = ");
    localStringBuilder.append(paramFromServiceMsg);
    QLog.i("RIJFeedsInsertModule", 1, localStringBuilder.toString());
    if (Intrinsics.areEqual(paramFromServiceMsg, paramObject))
    {
      a(paramToServiceMsg, localRspBody, i);
      return;
    }
    if (Intrinsics.areEqual(paramFromServiceMsg, Integer.valueOf(1)))
    {
      b(paramToServiceMsg, localRspBody, i);
      return;
    }
    paramToServiceMsg = new StringBuilder();
    paramToServiceMsg.append("[handleReceiveFeedsInsertInfo] do not handle this serviceType: ");
    paramToServiceMsg.append(paramFromServiceMsg);
    QLog.e("RIJFeedsInsertModule", 1, paramToServiceMsg.toString());
  }
  
  private final void a(ToServiceMsg paramToServiceMsg, oidb_cmd0xebb.RspBody paramRspBody, int paramInt)
  {
    if (paramInt == 0)
    {
      paramRspBody = paramRspBody.msg_rsp_channel_article;
      if (paramRspBody.has())
      {
        if (paramRspBody != null)
        {
          localObject1 = paramRspBody.uint64_channel_id;
          if (localObject1 != null)
          {
            l = ((PBUInt64Field)localObject1).get();
            break label44;
          }
        }
        long l = 0L;
        label44:
        if (paramRspBody != null)
        {
          paramRspBody = paramRspBody.rpt_article_list;
          if (paramRspBody != null)
          {
            localObject1 = paramRspBody.get();
            break label69;
          }
        }
        Object localObject1 = null;
        label69:
        Object localObject2 = "";
        paramRspBody = (oidb_cmd0xebb.RspBody)localObject2;
        if (paramToServiceMsg != null)
        {
          paramToServiceMsg = paramToServiceMsg.getAttribute("key_article_rowKey");
          paramRspBody = (oidb_cmd0xebb.RspBody)localObject2;
          if (paramToServiceMsg != null)
          {
            paramRspBody = (oidb_cmd0xebb.RspBody)localObject2;
            if ((paramToServiceMsg instanceof String)) {
              paramRspBody = (String)paramToServiceMsg;
            }
          }
        }
        paramToServiceMsg = (ConcurrentHashMap)this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.get(Long.valueOf(l));
        localObject2 = paramToServiceMsg;
        if (paramToServiceMsg == null)
        {
          localObject2 = new ConcurrentHashMap();
          ((Map)this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap).put(Long.valueOf(l), localObject2);
        }
        ArrayList localArrayList = (ArrayList)((ConcurrentHashMap)localObject2).get(paramRspBody);
        paramToServiceMsg = localArrayList;
        if (localArrayList == null)
        {
          paramToServiceMsg = new ArrayList();
          ((Map)localObject2).put(paramRspBody, paramToServiceMsg);
        }
        a(paramToServiceMsg);
        if (localObject1 != null)
        {
          localObject1 = CollectionsKt.asReversedMutable((List)localObject1).iterator();
          while (((Iterator)localObject1).hasNext())
          {
            localObject2 = ReadInJoyMSFHandlerUtils.a((articlesummary.ArticleSummary)((Iterator)localObject1).next(), (int)l, 0, null);
            Intrinsics.checkExpressionValueIsNotNull(localObject2, "articleInfo");
            a((AbsBaseArticleInfo)localObject2, paramToServiceMsg);
          }
        }
        localObject1 = new StringBuilder();
        ((StringBuilder)localObject1).append("[handleMainTLFeedsInsertInfo], channelId = ");
        ((StringBuilder)localObject1).append(l);
        ((StringBuilder)localObject1).append(", insertRowKey = ");
        ((StringBuilder)localObject1).append(paramRspBody);
        ((StringBuilder)localObject1).append(", articleInfoList = ");
        ((StringBuilder)localObject1).append(a((List)paramToServiceMsg));
        QLog.i("RIJFeedsInsertModule", 1, ((StringBuilder)localObject1).toString());
      }
    }
  }
  
  private final void a(ArrayList<AbsBaseArticleInfo> paramArrayList)
  {
    Object localObject1 = new ArrayList();
    Object localObject2 = paramArrayList.iterator();
    Object localObject3;
    while (((Iterator)localObject2).hasNext())
    {
      localObject3 = (AbsBaseArticleInfo)((Iterator)localObject2).next();
      if (!((AbsBaseArticleInfo)localObject3).hasBeenInsertIntoList) {
        ((ArrayList)localObject1).add(localObject3);
      }
    }
    localObject1 = ((ArrayList)localObject1).iterator();
    while (((Iterator)localObject1).hasNext())
    {
      localObject2 = (AbsBaseArticleInfo)((Iterator)localObject1).next();
      paramArrayList.remove(localObject2);
      localObject3 = new StringBuilder();
      ((StringBuilder)localObject3).append("[removeInvalidArticleInfo], invalidArticleInfo = ");
      RIJFeedsInsertUtil localRIJFeedsInsertUtil = RIJFeedsInsertUtil.a;
      Intrinsics.checkExpressionValueIsNotNull(localObject2, "invalidArticleInfo");
      ((StringBuilder)localObject3).append(localRIJFeedsInsertUtil.a((AbsBaseArticleInfo)localObject2));
      QLog.i("RIJFeedsInsertModule", 1, ((StringBuilder)localObject3).toString());
    }
  }
  
  private final boolean a(String paramString)
  {
    Object localObject = (Long)this.b.get(paramString);
    if (localObject == null) {
      localObject = Long.valueOf(0L);
    }
    Intrinsics.checkExpressionValueIsNotNull(localObject, "requestTimeMap[followPuin] ?: 0L");
    long l1 = ((Long)localObject).longValue();
    long l2 = System.currentTimeMillis();
    localObject = new StringBuilder();
    ((StringBuilder)localObject).append("[isAbleToRequest] followPuin = ");
    ((StringBuilder)localObject).append(paramString);
    ((StringBuilder)localObject).append(", last request timeStamp = ");
    ((StringBuilder)localObject).append(l1);
    ((StringBuilder)localObject).append(", currentTimeStamp = ");
    ((StringBuilder)localObject).append(l2);
    QLog.i("RIJFeedsInsertModule", 2, ((StringBuilder)localObject).toString());
    return l2 - l1 > 2000;
  }
  
  private final void b(ToServiceMsg paramToServiceMsg, oidb_cmd0xebb.RspBody paramRspBody, int paramInt)
  {
    if (paramInt == 0)
    {
      if (paramToServiceMsg != null) {
        localObject1 = paramToServiceMsg.getAttribute("KEY_ACTIVITY_HASHCODE");
      } else {
        localObject1 = null;
      }
      Object localObject2 = localObject1;
      if (!(localObject1 instanceof Integer)) {
        localObject2 = null;
      }
      Object localObject1 = (Integer)localObject2;
      int k = 0;
      if (localObject1 != null) {
        paramInt = ((Integer)localObject1).intValue();
      } else {
        paramInt = 0;
      }
      localObject1 = paramRspBody.msg_rsp_channel_article;
      if (paramToServiceMsg != null)
      {
        paramToServiceMsg = paramToServiceMsg.getAttributes();
        if (paramToServiceMsg != null)
        {
          paramToServiceMsg = paramToServiceMsg.get("KEY_REQ_SOURCE");
          break label96;
        }
      }
      paramToServiceMsg = null;
      label96:
      paramRspBody = paramToServiceMsg;
      if (!(paramToServiceMsg instanceof Integer)) {
        paramRspBody = null;
      }
      paramToServiceMsg = (Integer)paramRspBody;
      int i;
      if (paramToServiceMsg != null) {
        i = paramToServiceMsg.intValue();
      } else {
        i = 1;
      }
      if (((oidb_cmd0xebb.RspRecommendParaArticle)localObject1).has())
      {
        if (localObject1 != null)
        {
          paramToServiceMsg = ((oidb_cmd0xebb.RspRecommendParaArticle)localObject1).uint64_channel_id;
          if (paramToServiceMsg != null)
          {
            l = paramToServiceMsg.get();
            break label163;
          }
        }
        long l = 0L;
        label163:
        if (localObject1 != null)
        {
          paramToServiceMsg = ((oidb_cmd0xebb.RspRecommendParaArticle)localObject1).rpt_article_list;
          if (paramToServiceMsg != null)
          {
            paramToServiceMsg = paramToServiceMsg.get();
            break label188;
          }
        }
        paramToServiceMsg = null;
        label188:
        if (paramToServiceMsg != null)
        {
          if (paramToServiceMsg.size() > 0)
          {
            paramToServiceMsg = ReadInJoyMSFHandlerUtils.a((articlesummary.ArticleSummary)paramToServiceMsg.get(0), (int)l, 0, null);
            if (paramToServiceMsg != null)
            {
              paramRspBody = paramToServiceMsg.mRecommendFollowInfos;
              if (paramRspBody != null)
              {
                int j = 2;
                if ((i == 1) || (i != 2)) {
                  j = 1;
                }
                paramRspBody.b = j;
              }
            }
            paramRspBody = new StringBuilder();
            paramRspBody.append("[handleNativePopupInfo], channelId = ");
            paramRspBody.append(l);
            paramRspBody.append(", recommend follow info list size = ");
            i = k;
            if (paramToServiceMsg != null)
            {
              localObject1 = paramToServiceMsg.mRecommendFollowInfos;
              i = k;
              if (localObject1 != null)
              {
                localObject1 = ((RecommendFollowInfos)localObject1).a;
                i = k;
                if (localObject1 != null) {
                  i = ((List)localObject1).size();
                }
              }
            }
            paramRspBody.append(i);
            QLog.i("RIJFeedsInsertModule", 1, paramRspBody.toString());
            paramRspBody = RIJPopupWindowUtil.a;
            localObject1 = (Context)BaseActivity.sTopActivity;
            Intrinsics.checkExpressionValueIsNotNull(paramToServiceMsg, "articleInfo");
            paramRspBody.a((Context)localObject1, paramToServiceMsg, paramInt);
            return;
          }
          paramToServiceMsg = new StringBuilder();
          paramToServiceMsg.append("[handleNativePopupInfo], channelId = ");
          paramToServiceMsg.append(l);
          paramToServiceMsg.append(", articleInfoList is empty.");
          QLog.i("RIJFeedsInsertModule", 1, paramToServiceMsg.toString());
        }
      }
    }
  }
  
  @Nullable
  public final ConcurrentHashMap<String, ArrayList<AbsBaseArticleInfo>> a(long paramLong)
  {
    return (ConcurrentHashMap)this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.get(Long.valueOf(paramLong));
  }
  
  public final void a(long paramLong, @NotNull AbsBaseArticleInfo paramAbsBaseArticleInfo)
  {
    Intrinsics.checkParameterIsNotNull(paramAbsBaseArticleInfo, "articleInfo");
    Object localObject = (ConcurrentHashMap)this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.get(Long.valueOf(paramLong));
    if (localObject != null)
    {
      localObject = ((Map)localObject).entrySet().iterator();
      Map.Entry localEntry;
      AbsBaseArticleInfo localAbsBaseArticleInfo;
      RIJFeedsInsertUtil localRIJFeedsInsertUtil;
      do
      {
        Iterator localIterator;
        while (!localIterator.hasNext())
        {
          if (!((Iterator)localObject).hasNext()) {
            break;
          }
          localEntry = (Map.Entry)((Iterator)localObject).next();
          localIterator = ((ArrayList)localEntry.getValue()).iterator();
        }
        localAbsBaseArticleInfo = (AbsBaseArticleInfo)localIterator.next();
        localRIJFeedsInsertUtil = RIJFeedsInsertUtil.a;
        Intrinsics.checkExpressionValueIsNotNull(localAbsBaseArticleInfo, "itemArticleInfo");
      } while (!localRIJFeedsInsertUtil.a(paramAbsBaseArticleInfo, localAbsBaseArticleInfo));
      ((ArrayList)localEntry.getValue()).remove(localAbsBaseArticleInfo);
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("[deleteFeedsInsertInfo] articleInfo = ");
      ((StringBuilder)localObject).append(RIJFeedsInsertUtil.a.a(paramAbsBaseArticleInfo));
      QLog.i("RIJFeedsInsertModule", 1, ((StringBuilder)localObject).toString());
    }
  }
  
  public final void a(long paramLong, @NotNull String paramString1, @NotNull String paramString2, int paramInt)
  {
    Intrinsics.checkParameterIsNotNull(paramString1, "rowKey");
    Intrinsics.checkParameterIsNotNull(paramString2, "subscribeId");
    if (!RIJFeedsInsertUtil.a.b(paramInt)) {
      return;
    }
    if (BaseActivity.sTopActivity == null) {
      return;
    }
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("[requestNativePopupInfo], channelId = ");
    ((StringBuilder)localObject).append(paramLong);
    ((StringBuilder)localObject).append(", rowKey = ");
    ((StringBuilder)localObject).append(paramString1);
    ((StringBuilder)localObject).append(", subscribeId = ");
    ((StringBuilder)localObject).append(paramString2);
    QLog.i("RIJFeedsInsertModule", 1, ((StringBuilder)localObject).toString());
    localObject = new oidb_cmd0xebb.ReqRecommendPara();
    ((oidb_cmd0xebb.ReqRecommendPara)localObject).uint64_channel_id.set(paramLong);
    ((oidb_cmd0xebb.ReqRecommendPara)localObject).bytes_req_rowkey.set(ByteStringMicro.copyFromUtf8(paramString1));
    ((oidb_cmd0xebb.ReqRecommendPara)localObject).bytes_subscribe_id.set(ByteStringMicro.copyFromUtf8(paramString2));
    paramString1 = new oidb_cmd0xebb.ReqBody();
    paramString1.uint32_network_type.set(ArticleInfoModuleUtils.a());
    paramString1.uint32_os_type.set(2);
    paramString1.msg_req_recommend_para.set((MessageMicro)localObject);
    paramString1.uint32_req_source.set(paramInt);
    paramString1 = ReadInJoyOidbHelper.a("OidbSvc.0xebb", 3771, 1, paramString1.toByteArray());
    Intrinsics.checkExpressionValueIsNotNull(paramString1, "ReadInJoyOidbHelper.make…E, reqBody.toByteArray())");
    paramString2 = paramString1.getAttributes();
    Intrinsics.checkExpressionValueIsNotNull(paramString2, "request.attributes");
    ((Map)paramString2).put("key_service_type", Integer.valueOf(1));
    paramString2 = paramString1.getAttributes();
    Intrinsics.checkExpressionValueIsNotNull(paramString2, "request.attributes");
    ((Map)paramString2).put("KEY_REQ_SOURCE", Integer.valueOf(paramInt));
    paramString2 = paramString1.getAttributes();
    Intrinsics.checkExpressionValueIsNotNull(paramString2, "request.attributes");
    ((Map)paramString2).put("KEY_ACTIVITY_HASHCODE", Integer.valueOf(BaseActivity.sTopActivity.hashCode()));
    sendPbReq(paramString1);
  }
  
  public final void a(long paramLong, @Nullable String paramString, @Nullable List<? extends AbsBaseArticleInfo> paramList)
  {
    if (paramString != null)
    {
      if (paramList == null) {
        return;
      }
      if (!this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.containsKey(Long.valueOf(paramLong))) {
        ((Map)this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap).put(Long.valueOf(paramLong), new ConcurrentHashMap());
      }
      Object localObject1 = (ConcurrentHashMap)this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.get(Long.valueOf(paramLong));
      if ((localObject1 == null) || (((ConcurrentHashMap)localObject1).containsKey(paramString) != true))
      {
        localObject1 = (ConcurrentHashMap)this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.get(Long.valueOf(paramLong));
        if (localObject1 != null) {
          ((Map)localObject1).put(paramString, new ArrayList());
        }
      }
      paramList = ((Iterable)paramList).iterator();
      while (paramList.hasNext())
      {
        localObject1 = (AbsBaseArticleInfo)paramList.next();
        Object localObject2 = (ConcurrentHashMap)this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.get(Long.valueOf(paramLong));
        if (localObject2 != null)
        {
          localObject2 = (ArrayList)((ConcurrentHashMap)localObject2).get(paramString);
          if (localObject2 != null) {
            ((ArrayList)localObject2).add(localObject1);
          }
        }
      }
    }
  }
  
  public final void a(@NotNull RIJFeedsInsertModule.ReqParams paramReqParams)
  {
    Intrinsics.checkParameterIsNotNull(paramReqParams, "reqParams");
    if (!RIJFeedsInsertUtil.a.a((int)paramReqParams.a()))
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("[requestFeedsInsertInfo] do not request, channelId = ");
      ((StringBuilder)localObject).append(paramReqParams.a());
      QLog.i("RIJFeedsInsertModule", 1, ((StringBuilder)localObject).toString());
      return;
    }
    if (!RIJFeedsInsertUtil.a.a()) {
      return;
    }
    if (!a(paramReqParams.a()))
    {
      QLog.i("RIJFeedsInsertModule", 1, "[requestFeedsInsertInfo] do not request twice in a short period of time...");
      return;
    }
    oidb_cmd0xebb.ReqRecommendPara localReqRecommendPara = new oidb_cmd0xebb.ReqRecommendPara();
    localReqRecommendPara.uint64_channel_id.set(paramReqParams.a());
    PBBytesField localPBBytesField = localReqRecommendPara.bytes_req_rowkey;
    Object localObject = paramReqParams.a();
    if (localObject != null)
    {
      localObject = ((AbsBaseArticleInfo)localObject).innerUniqueID;
      if (localObject != null) {}
    }
    else
    {
      localObject = "";
    }
    localPBBytesField.set(ByteStringMicro.copyFromUtf8((String)localObject));
    localReqRecommendPara.bytes_subscribe_id.set(ByteStringMicro.copyFromUtf8(paramReqParams.a()));
    localReqRecommendPara.uint32_update_times.set(paramReqParams.a());
    localReqRecommendPara.uint32_req_recommend_flag.set(paramReqParams.b());
    localObject = new oidb_cmd0xebb.ReqBody();
    ((oidb_cmd0xebb.ReqBody)localObject).uint32_network_type.set(ArticleInfoModuleUtils.a());
    ((oidb_cmd0xebb.ReqBody)localObject).uint32_os_type.set(2);
    ((oidb_cmd0xebb.ReqBody)localObject).msg_req_recommend_para.set((MessageMicro)localReqRecommendPara);
    ((oidb_cmd0xebb.ReqBody)localObject).uint32_req_source.set(0);
    localObject = ReadInJoyOidbHelper.a("OidbSvc.0xebb", 3771, 0, ((oidb_cmd0xebb.ReqBody)localObject).toByteArray());
    Intrinsics.checkExpressionValueIsNotNull(localObject, "ReadInJoyOidbHelper.make…T, reqBody.toByteArray())");
    a((ToServiceMsg)localObject, paramReqParams);
    sendPbReq((ToServiceMsg)localObject);
    long l = System.currentTimeMillis();
    ((Map)this.b).put(paramReqParams.a(), Long.valueOf(l));
    localObject = new StringBuilder();
    ((StringBuilder)localObject).append("[requestFeedsInsertInfo], reqParams = ");
    ((StringBuilder)localObject).append(paramReqParams);
    ((StringBuilder)localObject).append(", timeStamp = ");
    ((StringBuilder)localObject).append(l);
    QLog.i("RIJFeedsInsertModule", 1, ((StringBuilder)localObject).toString());
  }
  
  public void onReceive(@Nullable ToServiceMsg paramToServiceMsg, @Nullable FromServiceMsg paramFromServiceMsg, @Nullable Object paramObject)
  {
    String str;
    if (paramFromServiceMsg != null) {
      str = paramFromServiceMsg.getServiceCmd();
    } else {
      str = null;
    }
    if (TextUtils.equals((CharSequence)str, (CharSequence)"OidbSvc.0xebb")) {
      a(paramToServiceMsg, paramFromServiceMsg, paramObject);
    }
  }
  
  public void unInitialize()
  {
    this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.clear();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.feeds.dynamicfeeds.RIJFeedsInsertModule
 * JD-Core Version:    0.7.0.1
 */