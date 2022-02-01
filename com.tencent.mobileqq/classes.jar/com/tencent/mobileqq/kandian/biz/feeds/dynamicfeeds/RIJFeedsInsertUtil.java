package com.tencent.mobileqq.kandian.biz.feeds.dynamicfeeds;

import android.text.TextUtils;
import com.tencent.aladdin.config.Aladdin;
import com.tencent.aladdin.config.AladdinConfig;
import com.tencent.biz.pubaccount.readinjoy.struct.AdvertisementInfo;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.kandian.biz.accesslayer.data.RIJDataManager;
import com.tencent.mobileqq.kandian.biz.common.ReadInJoyUtils;
import com.tencent.mobileqq.kandian.biz.feeds.ReadinjoyFixPosArticleManager;
import com.tencent.mobileqq.kandian.biz.framework.ReadInJoyBaseAdapter;
import com.tencent.mobileqq.kandian.glue.businesshandler.engine.ReadInJoyLogicEngine;
import com.tencent.mobileqq.kandian.glue.businesshandler.engine.ReadInJoyLogicManager;
import com.tencent.mobileqq.kandian.repo.feeds.entity.AbsBaseArticleInfo;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.Metadata;
import kotlin.TypeCastException;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;
import org.jetbrains.annotations.NotNull;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/mobileqq/kandian/biz/feeds/dynamicfeeds/RIJFeedsInsertUtil;", "", "()V", "DAILY_QUOTA_DEFAULT", "", "FEEDS_INSERT_DATE_SP_KEY", "", "FEEDS_INSERT_TIMESTAMP_SP_KEY", "TAG", "TIME_INTERVAL_DEFAULT", "TODAY_INSERT_TIMES_SP_KEY", "dailyQuota", "lastClickChannelId", "", "getLastClickChannelId", "()J", "setLastClickChannelId", "(J)V", "reqParamsMap", "Ljava/util/concurrent/ConcurrentHashMap;", "Lcom/tencent/mobileqq/kandian/biz/feeds/dynamicfeeds/RIJFeedsInsertModule$ReqParams;", "getReqParamsMap", "()Ljava/util/concurrent/ConcurrentHashMap;", "timeInterval", "clearReqParams", "", "channelId", "deleteArticleInfo", "articleInfo", "Lcom/tencent/mobileqq/kandian/repo/feeds/entity/AbsBaseArticleInfo;", "findArticlePosition", "articleList", "", "getArticleKey", "a", "getCurrentClickPosition", "getInsertArticles", "curArticles", "insertArticles", "getLogString", "getReqParams", "getTodayInsertTime", "date", "init", "isAbleToRequest", "", "isAbleToShowPopupWindow", "reqSource", "isArticleAbleToShowPopupWindow", "isChannelAbleToInsert", "isSameArticle", "b", "isSameInSub", "target", "isVideoAbleToShowPopupWindow", "requestNativePopupArticleInfo", "rowKey", "subscribeId", "requestRecommendArticleInfoList", "updateInsertFeedsInfo", "updateLastClickArticleInfo", "updateReqParams", "updateTimes", "reqRecommendFlag", "followPuin", "kandian_feature_impl_release"}, k=1, mv={1, 1, 16})
public final class RIJFeedsInsertUtil
{
  private static int jdField_a_of_type_Int;
  private static long jdField_a_of_type_Long;
  public static final RIJFeedsInsertUtil a;
  @NotNull
  private static final ConcurrentHashMap<Long, RIJFeedsInsertModule.ReqParams> jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap = new ConcurrentHashMap();
  private static int b = 30;
  
  static
  {
    jdField_a_of_type_ComTencentMobileqqKandianBizFeedsDynamicfeedsRIJFeedsInsertUtil = new RIJFeedsInsertUtil();
  }
  
  private final int a(AbsBaseArticleInfo paramAbsBaseArticleInfo, List<? extends AbsBaseArticleInfo> paramList)
  {
    paramList = paramList.iterator();
    int i = 0;
    while (paramList.hasNext())
    {
      AbsBaseArticleInfo localAbsBaseArticleInfo = (AbsBaseArticleInfo)paramList.next();
      if (jdField_a_of_type_ComTencentMobileqqKandianBizFeedsDynamicfeedsRIJFeedsInsertUtil.b(paramAbsBaseArticleInfo, localAbsBaseArticleInfo)) {
        return i;
      }
      i += 1;
    }
    return -1;
  }
  
  public final int a()
  {
    Object localObject = ReadinjoyFixPosArticleManager.getInstant();
    int i = 0;
    localObject = ((ReadinjoyFixPosArticleManager)localObject).getBaseAdapter(0);
    if (localObject != null)
    {
      localObject = ((ReadInJoyBaseAdapter)localObject).a();
      if (localObject != null)
      {
        localObject = ((RIJDataManager)localObject).a();
        break label35;
      }
    }
    localObject = null;
    label35:
    if (localObject != null) {
      i = jdField_a_of_type_ComTencentMobileqqKandianBizFeedsDynamicfeedsRIJFeedsInsertUtil.a((List)localObject);
    }
    return i;
  }
  
  public final int a(@NotNull List<? extends AbsBaseArticleInfo> paramList)
  {
    Intrinsics.checkParameterIsNotNull(paramList, "articleList");
    AbsBaseArticleInfo localAbsBaseArticleInfo = a(0L).a();
    int i;
    if (localAbsBaseArticleInfo != null) {
      i = jdField_a_of_type_ComTencentMobileqqKandianBizFeedsDynamicfeedsRIJFeedsInsertUtil.a(localAbsBaseArticleInfo, paramList);
    } else {
      i = 0;
    }
    paramList = new StringBuilder();
    paramList.append("getCurrentClickPosition, position=");
    paramList.append(i);
    QLog.d("RIJFeedsDynamicInsertModule", 1, paramList.toString());
    return i;
  }
  
  public final long a()
  {
    return jdField_a_of_type_Long;
  }
  
  @NotNull
  public final RIJFeedsInsertModule.ReqParams a(long paramLong)
  {
    RIJFeedsInsertModule.ReqParams localReqParams2 = (RIJFeedsInsertModule.ReqParams)jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.get(Long.valueOf(paramLong));
    RIJFeedsInsertModule.ReqParams localReqParams1 = localReqParams2;
    if (localReqParams2 == null) {
      localReqParams1 = new RIJFeedsInsertModule.ReqParams();
    }
    return localReqParams1;
  }
  
  @NotNull
  public final String a(@NotNull AbsBaseArticleInfo paramAbsBaseArticleInfo)
  {
    Intrinsics.checkParameterIsNotNull(paramAbsBaseArticleInfo, "articleInfo");
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("{ title = ");
    localStringBuilder.append(paramAbsBaseArticleInfo.mTitle);
    localStringBuilder.append(", rowKey = ");
    localStringBuilder.append(paramAbsBaseArticleInfo.innerUniqueID);
    localStringBuilder.append(", feedsType = ");
    localStringBuilder.append(paramAbsBaseArticleInfo.mFeedType);
    localStringBuilder.append(", subscribeName = ");
    localStringBuilder.append(paramAbsBaseArticleInfo.mSubscribeName);
    localStringBuilder.append(", subscribeId = ");
    localStringBuilder.append(paramAbsBaseArticleInfo.mSubscribeID);
    localStringBuilder.append(" }");
    return localStringBuilder.toString();
  }
  
  @NotNull
  public final List<AbsBaseArticleInfo> a(@NotNull List<? extends AbsBaseArticleInfo> paramList1, @NotNull List<? extends AbsBaseArticleInfo> paramList2)
  {
    Intrinsics.checkParameterIsNotNull(paramList1, "curArticles");
    Intrinsics.checkParameterIsNotNull(paramList2, "insertArticles");
    List localList = (List)new ArrayList();
    Object localObject1 = (Iterable)paramList1;
    paramList1 = (Map)new LinkedHashMap(RangesKt.coerceAtLeast(MapsKt.mapCapacity(CollectionsKt.collectionSizeOrDefault((Iterable)localObject1, 10)), 16));
    localObject1 = ((Iterable)localObject1).iterator();
    Object localObject2;
    while (((Iterator)localObject1).hasNext())
    {
      localObject2 = (AbsBaseArticleInfo)((Iterator)localObject1).next();
      paramList1.put(jdField_a_of_type_ComTencentMobileqqKandianBizFeedsDynamicfeedsRIJFeedsInsertUtil.b((AbsBaseArticleInfo)localObject2), localObject2);
    }
    localObject1 = (Iterable)paramList2;
    paramList2 = (Map)new LinkedHashMap(RangesKt.coerceAtLeast(MapsKt.mapCapacity(CollectionsKt.collectionSizeOrDefault((Iterable)localObject1, 10)), 16));
    localObject1 = ((Iterable)localObject1).iterator();
    while (((Iterator)localObject1).hasNext())
    {
      localObject2 = (AbsBaseArticleInfo)((Iterator)localObject1).next();
      paramList2.put(jdField_a_of_type_ComTencentMobileqqKandianBizFeedsDynamicfeedsRIJFeedsInsertUtil.b((AbsBaseArticleInfo)localObject2), localObject2);
    }
    paramList2 = paramList2.entrySet().iterator();
    while (paramList2.hasNext())
    {
      localObject2 = (Map.Entry)paramList2.next();
      localObject1 = (String)((Map.Entry)localObject2).getKey();
      localObject2 = (AbsBaseArticleInfo)((Map.Entry)localObject2).getValue();
      if (paramList1.get(localObject1) == null)
      {
        localList.add(localObject2);
      }
      else
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("getInsertArticles error! article has existed! key=");
        localStringBuilder.append((String)localObject1);
        localStringBuilder.append("，title=");
        localStringBuilder.append(((AbsBaseArticleInfo)localObject2).mTitle);
        QLog.d("RIJFeedsInsertUtil", 1, localStringBuilder.toString());
      }
    }
    return localList;
  }
  
  public final void a()
  {
    Object localObject = Aladdin.getConfig(361);
    int i = 0;
    if (localObject != null) {
      i = ((AladdinConfig)localObject).getIntegerFromString("DailyQuota", 0);
    }
    jdField_a_of_type_Int = i;
    i = 30;
    if (localObject != null) {
      i = ((AladdinConfig)localObject).getIntegerFromString("TimeInterval", 30);
    }
    b = i;
    localObject = new StringBuilder();
    ((StringBuilder)localObject).append("[init] feedsInsertConfig = { dailyQuota = ");
    ((StringBuilder)localObject).append(jdField_a_of_type_Int);
    ((StringBuilder)localObject).append(", timeInterval = ");
    ((StringBuilder)localObject).append(b);
    ((StringBuilder)localObject).append(" }");
    QLog.i("RIJFeedsInsertUtil", 1, ((StringBuilder)localObject).toString());
  }
  
  public final void a(long paramLong)
  {
    Object localObject = ReadInJoyUtils.a();
    if (localObject != null)
    {
      localObject = (ReadInJoyLogicManager)((QQAppInterface)localObject).getManager(QQManagerFactory.READINJOY_LOGIC_MANAGER);
      if (localObject != null)
      {
        localObject = ((ReadInJoyLogicManager)localObject).getReadInJoyLogicEngine();
        if (localObject != null)
        {
          localObject = ((ReadInJoyLogicEngine)localObject).a();
          if (localObject != null) {
            ((RIJFeedsInsertModule)localObject).a(a(paramLong));
          }
        }
      }
      return;
    }
    throw new TypeCastException("null cannot be cast to non-null type com.tencent.mobileqq.app.QQAppInterface");
  }
  
  public final void a(long paramLong, int paramInt1, int paramInt2)
  {
    RIJFeedsInsertModule.ReqParams localReqParams = a(paramLong);
    localReqParams.a(paramLong);
    localReqParams.a(paramInt1);
    localReqParams.b(paramInt2);
    ((Map)jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap).put(Long.valueOf(paramLong), localReqParams);
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("[updateReqParams] channelId = ");
    localStringBuilder.append(paramLong);
    localStringBuilder.append(", updateTimes = ");
    localStringBuilder.append(paramInt1);
    localStringBuilder.append(", reqRecommendFlag = ");
    localStringBuilder.append(paramInt2);
    localStringBuilder.append(", reqParams = {");
    localStringBuilder.append(localReqParams);
    localStringBuilder.append('}');
    QLog.i("RIJFeedsInsertUtil", 1, localStringBuilder.toString());
  }
  
  public final void a(long paramLong, @NotNull AbsBaseArticleInfo paramAbsBaseArticleInfo)
  {
    Intrinsics.checkParameterIsNotNull(paramAbsBaseArticleInfo, "articleInfo");
    Object localObject = ReadInJoyUtils.a();
    if (localObject != null)
    {
      localObject = (ReadInJoyLogicManager)((QQAppInterface)localObject).getManager(QQManagerFactory.READINJOY_LOGIC_MANAGER);
      if (localObject != null)
      {
        localObject = ((ReadInJoyLogicManager)localObject).getReadInJoyLogicEngine();
        if (localObject != null)
        {
          localObject = ((ReadInJoyLogicEngine)localObject).a();
          if (localObject != null) {
            ((RIJFeedsInsertModule)localObject).a(paramLong, paramAbsBaseArticleInfo);
          }
        }
      }
      return;
    }
    throw new TypeCastException("null cannot be cast to non-null type com.tencent.mobileqq.app.QQAppInterface");
  }
  
  public final void a(long paramLong, @NotNull String paramString)
  {
    Intrinsics.checkParameterIsNotNull(paramString, "followPuin");
    RIJFeedsInsertModule.ReqParams localReqParams = a(paramLong);
    localReqParams.a(paramLong);
    localReqParams.a(paramString);
    ((Map)jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap).put(Long.valueOf(paramLong), localReqParams);
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("[updateReqParams] channelId = ");
    localStringBuilder.append(paramLong);
    localStringBuilder.append(", followPuin = ");
    localStringBuilder.append(paramString);
    localStringBuilder.append(", reqParams = {");
    localStringBuilder.append(localReqParams);
    localStringBuilder.append('}');
    QLog.i("RIJFeedsInsertUtil", 1, localStringBuilder.toString());
  }
  
  public final void a(long paramLong, @NotNull String paramString1, @NotNull String paramString2)
  {
    Intrinsics.checkParameterIsNotNull(paramString1, "rowKey");
    Intrinsics.checkParameterIsNotNull(paramString2, "subscribeId");
    Object localObject = ReadInJoyUtils.a();
    if (localObject != null)
    {
      localObject = (ReadInJoyLogicManager)((QQAppInterface)localObject).getManager(QQManagerFactory.READINJOY_LOGIC_MANAGER);
      if (localObject != null)
      {
        localObject = ((ReadInJoyLogicManager)localObject).getReadInJoyLogicEngine();
        if (localObject != null)
        {
          localObject = ((ReadInJoyLogicEngine)localObject).a();
          if (localObject != null) {
            ((RIJFeedsInsertModule)localObject).a(paramLong, paramString1, paramString2, 1);
          }
        }
      }
      return;
    }
    throw new TypeCastException("null cannot be cast to non-null type com.tencent.mobileqq.app.QQAppInterface");
  }
  
  public final boolean a()
  {
    return false;
  }
  
  public final boolean a(int paramInt)
  {
    return paramInt == 0;
  }
  
  public final boolean a(@NotNull AbsBaseArticleInfo paramAbsBaseArticleInfo1, @NotNull AbsBaseArticleInfo paramAbsBaseArticleInfo2)
  {
    Intrinsics.checkParameterIsNotNull(paramAbsBaseArticleInfo1, "a");
    Intrinsics.checkParameterIsNotNull(paramAbsBaseArticleInfo2, "b");
    return TextUtils.equals((CharSequence)b(paramAbsBaseArticleInfo1), (CharSequence)b(paramAbsBaseArticleInfo2));
  }
  
  @NotNull
  public final String b(@NotNull AbsBaseArticleInfo paramAbsBaseArticleInfo)
  {
    Intrinsics.checkParameterIsNotNull(paramAbsBaseArticleInfo, "a");
    if ((paramAbsBaseArticleInfo instanceof AdvertisementInfo)) {
      paramAbsBaseArticleInfo = String.valueOf(((AdvertisementInfo)paramAbsBaseArticleInfo).mAdAid);
    } else {
      paramAbsBaseArticleInfo = paramAbsBaseArticleInfo.innerUniqueID;
    }
    if (paramAbsBaseArticleInfo != null) {
      return paramAbsBaseArticleInfo;
    }
    return "";
  }
  
  public final void b(long paramLong, @NotNull AbsBaseArticleInfo paramAbsBaseArticleInfo)
  {
    Intrinsics.checkParameterIsNotNull(paramAbsBaseArticleInfo, "articleInfo");
    jdField_a_of_type_Long = paramLong;
    RIJFeedsInsertModule.ReqParams localReqParams = a(paramLong);
    localReqParams.a(paramLong);
    localReqParams.a(paramAbsBaseArticleInfo);
    ((Map)jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap).put(Long.valueOf(paramLong), localReqParams);
    paramAbsBaseArticleInfo = new StringBuilder();
    paramAbsBaseArticleInfo.append("[updateLastClickArticleInfo] channelId = ");
    paramAbsBaseArticleInfo.append(paramLong);
    paramAbsBaseArticleInfo.append(", reqParams = {");
    paramAbsBaseArticleInfo.append(localReqParams);
    paramAbsBaseArticleInfo.append('}');
    QLog.i("RIJFeedsInsertUtil", 1, paramAbsBaseArticleInfo.toString());
    RIJFeedsDynamicInsertController.INSTANCE.updateAdReadStatus(false);
  }
  
  public final boolean b()
  {
    Object localObject = Aladdin.getConfig(418);
    boolean bool = false;
    int i;
    if (localObject != null) {
      i = ((AladdinConfig)localObject).getIntegerFromString("follow_recommend_popup_switch", 0);
    } else {
      i = 0;
    }
    if (i == 1) {
      bool = true;
    }
    localObject = new StringBuilder();
    ((StringBuilder)localObject).append("[isArticleAbleToShowPopupWindow] popupSwitch = ");
    ((StringBuilder)localObject).append(bool);
    QLog.i("RIJFeedsInsertUtil", 1, ((StringBuilder)localObject).toString());
    return bool;
  }
  
  public final boolean b(int paramInt)
  {
    if (paramInt != 1)
    {
      if (paramInt != 2) {
        return b();
      }
      return c();
    }
    return b();
  }
  
  public final boolean b(@NotNull AbsBaseArticleInfo paramAbsBaseArticleInfo1, @NotNull AbsBaseArticleInfo paramAbsBaseArticleInfo2)
  {
    Intrinsics.checkParameterIsNotNull(paramAbsBaseArticleInfo1, "target");
    Intrinsics.checkParameterIsNotNull(paramAbsBaseArticleInfo2, "b");
    boolean bool2 = a(paramAbsBaseArticleInfo1, paramAbsBaseArticleInfo2);
    boolean bool1 = bool2;
    if (!bool2)
    {
      bool1 = bool2;
      if (paramAbsBaseArticleInfo2.mSubArticleList != null)
      {
        paramAbsBaseArticleInfo2 = paramAbsBaseArticleInfo2.mSubArticleList.iterator();
        AbsBaseArticleInfo localAbsBaseArticleInfo;
        do
        {
          bool1 = bool2;
          if (!paramAbsBaseArticleInfo2.hasNext()) {
            break;
          }
          localAbsBaseArticleInfo = (AbsBaseArticleInfo)paramAbsBaseArticleInfo2.next();
          Intrinsics.checkExpressionValueIsNotNull(localAbsBaseArticleInfo, "item");
        } while (!a(paramAbsBaseArticleInfo1, localAbsBaseArticleInfo));
        bool1 = true;
      }
    }
    return bool1;
  }
  
  public final boolean c()
  {
    Object localObject = Aladdin.getConfig(441);
    boolean bool = false;
    int i;
    if (localObject != null) {
      i = ((AladdinConfig)localObject).getIntegerFromString("video_recommend_popup_enable", 0);
    } else {
      i = 0;
    }
    if (i == 1) {
      bool = true;
    }
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("[isVideoAbleToShowPopupWindow] popupSwitch = ");
      ((StringBuilder)localObject).append(bool);
      QLog.i("RIJFeedsInsertUtil", 1, ((StringBuilder)localObject).toString());
    }
    return bool;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.feeds.dynamicfeeds.RIJFeedsInsertUtil
 * JD-Core Version:    0.7.0.1
 */