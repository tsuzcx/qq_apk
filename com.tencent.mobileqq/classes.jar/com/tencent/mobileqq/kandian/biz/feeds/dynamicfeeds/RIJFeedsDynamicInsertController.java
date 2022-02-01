package com.tencent.mobileqq.kandian.biz.feeds.dynamicfeeds;

import android.text.TextUtils;
import com.tencent.biz.pubaccount.util.KotlinUtilKt;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.kandian.biz.accesslayer.data.RIJReportDataCollectionManager;
import com.tencent.mobileqq.kandian.biz.common.ReadInJoyUtils;
import com.tencent.mobileqq.kandian.biz.feeds.api.IRIJFeedsDynamicInsertController;
import com.tencent.mobileqq.kandian.biz.feeds.dynamicfeeds.data.RIJFeedsInsertArticle;
import com.tencent.mobileqq.kandian.biz.feeds.entity.ExposureArticle;
import com.tencent.mobileqq.kandian.glue.businesshandler.engine.ReadInJoyLogicEngine;
import com.tencent.mobileqq.kandian.glue.businesshandler.engine.ReadInJoyLogicManager;
import com.tencent.mobileqq.kandian.repo.db.struct.ReportData;
import com.tencent.mobileqq.kandian.repo.feeds.ActionType;
import com.tencent.mobileqq.kandian.repo.feeds.RIJFeedsInsertAction;
import com.tencent.mobileqq.kandian.repo.feeds.entity.AbsBaseArticleInfo;
import com.tencent.mobileqq.kandian.repo.report.BaseReportData;
import com.tencent.mobileqq.kandian.repo.report.ReportInfo.DynamicInsertReportData;
import com.tencent.qphone.base.util.QLog;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.NoSuchElementException;
import java.util.Set;
import java.util.SortedMap;
import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.ReplaceWith;
import kotlin.Triple;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import mqq.os.MqqHandler;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/mobileqq/kandian/biz/feeds/dynamicfeeds/RIJFeedsDynamicInsertController;", "Lcom/tencent/mobileqq/kandian/biz/feeds/api/IRIJFeedsDynamicInsertController;", "()V", "TAG", "", "hasReadAd", "", "deleteArticle", "", "exposureArticle", "Lcom/tencent/mobileqq/kandian/biz/feeds/entity/ExposureArticle;", "articles", "", "deleteArticleByRowkey", "rowKey", "deleteFeedsDynamicInsertInfo", "reqSource", "", "findReqSourceByRowkey", "getFeedsInsertDynamicInsertModule", "Lcom/tencent/mobileqq/kandian/biz/feeds/dynamicfeeds/RIJFeedsDynamicInsertModule;", "getFeedsInsertModule", "Lcom/tencent/mobileqq/kandian/biz/feeds/dynamicfeeds/RIJFeedsInsertModule;", "getWatchInfo", "watchInfoCallback", "Lcom/tencent/mobileqq/kandian/biz/feeds/dynamicfeeds/RIJFeedsDynamicInsertController$IWatchInfoCallback;", "feedsInsertArticle", "Lcom/tencent/mobileqq/kandian/biz/feeds/dynamicfeeds/data/RIJFeedsInsertArticle;", "insertArticleInMainTL", "insertArticleList", "Lcom/tencent/mobileqq/kandian/repo/feeds/entity/AbsBaseArticleInfo;", "action", "Lcom/tencent/mobileqq/kandian/repo/feeds/RIJFeedsInsertAction;", "seqNo", "isReadAd", "needRecordAction", "preloadWatchInfoInMainFeeds", "articleInfo", "report64e", "insertArticle", "requestDynamicInsertArticle", "requestDynamicInsertBackToTL", "requestDynamicInsertInTL", "requestInsertArticlesAndRecordAction", "updateAdReadStatus", "readAd", "IWatchInfoCallback", "kandian_feature_impl_release"}, k=1, mv={1, 1, 16})
public final class RIJFeedsDynamicInsertController
  implements IRIJFeedsDynamicInsertController
{
  public static final RIJFeedsDynamicInsertController INSTANCE = new RIJFeedsDynamicInsertController();
  @NotNull
  public static final String TAG = "RIJFeedsDynamicInsertController";
  private static boolean hasReadAd;
  
  private final void getWatchInfo(String paramString, RIJFeedsDynamicInsertController.IWatchInfoCallback paramIWatchInfoCallback, RIJFeedsInsertArticle paramRIJFeedsInsertArticle)
  {
    if (paramRIJFeedsInsertArticle != null) {
      paramRIJFeedsInsertArticle = paramRIJFeedsInsertArticle.a();
    } else {
      paramRIJFeedsInsertArticle = null;
    }
    KotlinUtilKt.a(paramIWatchInfoCallback, paramRIJFeedsInsertArticle, (Function2)new RIJFeedsDynamicInsertController.getWatchInfo.1(paramString));
  }
  
  private final boolean needRecordAction(RIJFeedsInsertArticle paramRIJFeedsInsertArticle, RIJFeedsInsertAction paramRIJFeedsInsertAction)
  {
    Object localObject1 = paramRIJFeedsInsertAction.a();
    ActionType localActionType1 = ActionType.ACTION_NONE;
    boolean bool1 = false;
    boolean bool2 = false;
    if (localObject1 == localActionType1) {
      return false;
    }
    localObject1 = paramRIJFeedsInsertAction.a();
    ActionType localActionType2 = ActionType.ACTION_ARTICLE_READ_PROGRESS;
    Object localObject2 = null;
    localActionType1 = null;
    if (localObject1 == localActionType2)
    {
      localObject1 = localActionType1;
      if (paramRIJFeedsInsertArticle == null) {}
    }
    for (;;)
    {
      try
      {
        paramRIJFeedsInsertArticle = paramRIJFeedsInsertArticle.a();
        localObject1 = localActionType1;
        if (paramRIJFeedsInsertArticle != null)
        {
          paramRIJFeedsInsertArticle = paramRIJFeedsInsertArticle.keySet();
          localObject1 = localActionType1;
          if (paramRIJFeedsInsertArticle != null)
          {
            paramRIJFeedsInsertArticle = ((Iterable)paramRIJFeedsInsertArticle).iterator();
            if (paramRIJFeedsInsertArticle.hasNext())
            {
              localObject1 = paramRIJFeedsInsertArticle.next();
              if (((RIJFeedsInsertAction)localObject1).a() != paramRIJFeedsInsertAction.a()) {
                continue;
              }
              i = 1;
              if (i == 0) {
                continue;
              }
              localObject1 = (RIJFeedsInsertAction)localObject1;
            }
            else
            {
              throw ((Throwable)new NoSuchElementException("Collection contains no element matching the predicate."));
            }
          }
        }
        if (localObject1 == null) {
          continue;
        }
        bool1 = bool2;
        if (paramRIJFeedsInsertAction.a() >= ((RIJFeedsInsertAction)localObject1).a())
        {
          i = paramRIJFeedsInsertAction.b();
          j = ((RIJFeedsInsertAction)localObject1).b();
          bool1 = bool2;
          if (i >= j) {
            bool1 = true;
          }
        }
        return bool1;
      }
      catch (Throwable paramRIJFeedsInsertArticle)
      {
        int j;
        continue;
        int i = 0;
        continue;
      }
      QLog.d("RIJFeedsDynamicInsertController", 1, paramRIJFeedsInsertArticle.getMessage());
      return false;
      if (paramRIJFeedsInsertAction.a() == ActionType.ACTION_VIDEO_PLAY_PROGRESS)
      {
        localObject1 = localObject2;
        if (paramRIJFeedsInsertArticle == null) {}
      }
      try
      {
        paramRIJFeedsInsertArticle = paramRIJFeedsInsertArticle.a();
        localObject1 = localObject2;
        if (paramRIJFeedsInsertArticle != null)
        {
          paramRIJFeedsInsertArticle = paramRIJFeedsInsertArticle.keySet();
          localObject1 = localObject2;
          if (paramRIJFeedsInsertArticle != null)
          {
            paramRIJFeedsInsertArticle = ((Iterable)paramRIJFeedsInsertArticle).iterator();
            if (paramRIJFeedsInsertArticle.hasNext())
            {
              localObject1 = paramRIJFeedsInsertArticle.next();
              if (((RIJFeedsInsertAction)localObject1).a() != paramRIJFeedsInsertAction.a()) {
                continue;
              }
              i = 1;
              if (i == 0) {
                continue;
              }
              localObject1 = (RIJFeedsInsertAction)localObject1;
            }
            else
            {
              throw ((Throwable)new NoSuchElementException("Collection contains no element matching the predicate."));
            }
          }
        }
        if (localObject1 == null) {
          continue;
        }
        i = paramRIJFeedsInsertAction.a();
        j = ((RIJFeedsInsertAction)localObject1).a();
        if (i >= j) {
          bool1 = true;
        }
        return bool1;
      }
      catch (Throwable paramRIJFeedsInsertArticle)
      {
        continue;
      }
      QLog.d("RIJFeedsDynamicInsertController", 1, paramRIJFeedsInsertArticle.getMessage());
      return false;
      return true;
      i = 0;
    }
  }
  
  private final void requestDynamicInsertArticle(int paramInt, String paramString, RIJFeedsInsertAction paramRIJFeedsInsertAction, RIJFeedsDynamicInsertController.IWatchInfoCallback paramIWatchInfoCallback)
  {
    RIJFeedsDynamicInsertModule localRIJFeedsDynamicInsertModule = getFeedsInsertDynamicInsertModule();
    if (localRIJFeedsDynamicInsertModule != null) {
      RIJFeedsDynamicInsertModule.a(localRIJFeedsDynamicInsertModule, Integer.valueOf(paramInt), paramString, paramRIJFeedsInsertAction.a(), true, (RIJFeedsDynamicInsertModule.Companion.IFeedsDynamicInsertCallback)new RIJFeedsDynamicInsertController.requestDynamicInsertArticle..inlined.let.lambda.1(paramInt, paramString, paramRIJFeedsInsertAction, paramIWatchInfoCallback), 0, 0, 96, null);
    }
  }
  
  private final void updateAdReadStatus(ExposureArticle paramExposureArticle)
  {
    if ((paramExposureArticle != null) && (paramExposureArticle.a())) {
      INSTANCE.updateAdReadStatus(true);
    }
  }
  
  public void deleteArticle(@Nullable ExposureArticle paramExposureArticle)
  {
    RIJFeedsDynamicInsertModule localRIJFeedsDynamicInsertModule = getFeedsInsertDynamicInsertModule();
    if (localRIJFeedsDynamicInsertModule != null) {
      localRIJFeedsDynamicInsertModule.a(paramExposureArticle);
    }
    updateAdReadStatus(paramExposureArticle);
  }
  
  public final void deleteArticle(@NotNull List<ExposureArticle> paramList)
  {
    Intrinsics.checkParameterIsNotNull(paramList, "articles");
    paramList = paramList.iterator();
    while (paramList.hasNext()) {
      deleteArticle((ExposureArticle)paramList.next());
    }
  }
  
  @Deprecated(message="inflexible", replaceWith=@ReplaceWith(expression="deleteArticle", imports={}))
  public void deleteArticleByRowkey(@Nullable String paramString)
  {
    RIJFeedsDynamicInsertModule localRIJFeedsDynamicInsertModule = getFeedsInsertDynamicInsertModule();
    if (localRIJFeedsDynamicInsertModule != null) {
      localRIJFeedsDynamicInsertModule.a(new ExposureArticle(paramString, false, 2, null));
    }
  }
  
  public final void deleteFeedsDynamicInsertInfo(int paramInt, @Nullable String paramString)
  {
    RIJFeedsDynamicInsertModule localRIJFeedsDynamicInsertModule = getFeedsInsertDynamicInsertModule();
    if (localRIJFeedsDynamicInsertModule != null) {
      localRIJFeedsDynamicInsertModule.a(paramInt, paramString);
    }
    RIJFeedsDynamicInsertRecordAction.a.a().a(paramInt, paramString);
  }
  
  public final int findReqSourceByRowkey(@Nullable String paramString)
  {
    Map.Entry localEntry;
    Iterator localIterator2;
    do
    {
      Iterator localIterator1 = ((Map)RIJFeedsDynamicInsertRecordAction.a.a().a()).entrySet().iterator();
      while (!localIterator2.hasNext())
      {
        if (!localIterator1.hasNext()) {
          break;
        }
        localEntry = (Map.Entry)localIterator1.next();
        localIterator2 = ((Map)localEntry.getValue()).entrySet().iterator();
      }
    } while (!Intrinsics.areEqual((String)((Map.Entry)localIterator2.next()).getKey(), paramString));
    return ((Number)localEntry.getKey()).intValue();
    return -1;
  }
  
  @Nullable
  public final RIJFeedsDynamicInsertModule getFeedsInsertDynamicInsertModule()
  {
    Object localObject1 = (QQAppInterface)ReadInJoyUtils.a();
    Object localObject2 = null;
    if (localObject1 != null) {
      localObject1 = ((QQAppInterface)localObject1).getManager(QQManagerFactory.READINJOY_LOGIC_MANAGER);
    } else {
      localObject1 = null;
    }
    Object localObject3 = (ReadInJoyLogicManager)localObject1;
    localObject1 = localObject2;
    if (localObject3 != null)
    {
      localObject3 = ((ReadInJoyLogicManager)localObject3).getReadInJoyLogicEngine();
      localObject1 = localObject2;
      if (localObject3 != null) {
        localObject1 = ((ReadInJoyLogicEngine)localObject3).a();
      }
    }
    return localObject1;
  }
  
  @Nullable
  public final RIJFeedsInsertModule getFeedsInsertModule()
  {
    Object localObject1 = (QQAppInterface)ReadInJoyUtils.a();
    Object localObject2 = null;
    if (localObject1 != null) {
      localObject1 = ((QQAppInterface)localObject1).getManager(QQManagerFactory.READINJOY_LOGIC_MANAGER);
    } else {
      localObject1 = null;
    }
    Object localObject3 = (ReadInJoyLogicManager)localObject1;
    localObject1 = localObject2;
    if (localObject3 != null)
    {
      localObject3 = ((ReadInJoyLogicManager)localObject3).getReadInJoyLogicEngine();
      localObject1 = localObject2;
      if (localObject3 != null) {
        localObject1 = ((ReadInJoyLogicEngine)localObject3).a();
      }
    }
    return localObject1;
  }
  
  public final void insertArticleInMainTL(@Nullable List<? extends AbsBaseArticleInfo> paramList, int paramInt, @NotNull String paramString1, @NotNull RIJFeedsInsertAction paramRIJFeedsInsertAction, @Nullable String paramString2)
  {
    Intrinsics.checkParameterIsNotNull(paramString1, "rowKey");
    Intrinsics.checkParameterIsNotNull(paramRIJFeedsInsertAction, "action");
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("insertArticleInMainTL, insertArticleList: ");
    ((StringBuilder)localObject).append(paramList);
    ((StringBuilder)localObject).append(", reqSource: ");
    ((StringBuilder)localObject).append(paramInt);
    ((StringBuilder)localObject).append(", rowKey: ");
    ((StringBuilder)localObject).append(paramString1);
    ((StringBuilder)localObject).append(", action:");
    ((StringBuilder)localObject).append(paramRIJFeedsInsertAction);
    ((StringBuilder)localObject).append(", seqNo:");
    ((StringBuilder)localObject).append(paramString2);
    QLog.d("RIJFeedsDynamicInsertController", 1, ((StringBuilder)localObject).toString());
    if (paramList != null)
    {
      localObject = ((Iterable)paramList).iterator();
      while (((Iterator)localObject).hasNext())
      {
        AbsBaseArticleInfo localAbsBaseArticleInfo = (AbsBaseArticleInfo)((Iterator)localObject).next();
        localAbsBaseArticleInfo.insertAction = paramRIJFeedsInsertAction;
        localAbsBaseArticleInfo.inserSeqNo = paramString2;
        localAbsBaseArticleInfo.reqSource = paramInt;
      }
    }
    ThreadManager.getUIHandler().post((Runnable)new RIJFeedsDynamicInsertController.insertArticleInMainTL.2(paramInt, paramString1, paramList));
  }
  
  public final boolean isReadAd()
  {
    return hasReadAd;
  }
  
  public final void preloadWatchInfoInMainFeeds(@Nullable AbsBaseArticleInfo paramAbsBaseArticleInfo, int paramInt, @Nullable RIJFeedsDynamicInsertController.IWatchInfoCallback paramIWatchInfoCallback)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("preloadWatchInfoInMainFeeds rowKey: ");
    Long localLong = null;
    Object localObject;
    if (paramAbsBaseArticleInfo != null) {
      localObject = paramAbsBaseArticleInfo.innerUniqueID;
    } else {
      localObject = null;
    }
    localStringBuilder.append((String)localObject);
    localStringBuilder.append(", channelId: ");
    if (paramAbsBaseArticleInfo != null) {
      localObject = Long.valueOf(paramAbsBaseArticleInfo.mChannelID);
    } else {
      localObject = null;
    }
    localStringBuilder.append(localObject);
    localStringBuilder.append(", reqSource: ");
    localStringBuilder.append(paramInt);
    QLog.d("RIJFeedsDynamicInsertController", 1, localStringBuilder.toString());
    if (paramAbsBaseArticleInfo != null) {
      localObject = paramAbsBaseArticleInfo.innerUniqueID;
    } else {
      localObject = null;
    }
    if (paramAbsBaseArticleInfo != null) {
      localLong = Long.valueOf(paramAbsBaseArticleInfo.mChannelID);
    }
    if ((!TextUtils.isEmpty((CharSequence)localObject)) && (localLong != null))
    {
      if (!RIJFeedsDynamicInsertConfig.a.a(Integer.valueOf((int)localLong.longValue())))
      {
        QLog.d("RIJFeedsDynamicInsertController", 1, "requestDynamicInsertInTL, channelId not match or config off");
        return;
      }
      requestDynamicInsertArticle(paramInt, (String)localObject, new RIJFeedsInsertAction(ActionType.ACTION_VIDEO_PLAY_PROGRESS, 0, 0, 0, 14, null), paramIWatchInfoCallback);
      return;
    }
    QLog.d("RIJFeedsDynamicInsertController", 1, "rowkey or channelId is null");
  }
  
  public final void report64e(@Nullable AbsBaseArticleInfo paramAbsBaseArticleInfo)
  {
    if (paramAbsBaseArticleInfo != null)
    {
      RIJFeedsInsertAction localRIJFeedsInsertAction = paramAbsBaseArticleInfo.insertAction;
      String str = paramAbsBaseArticleInfo.inserSeqNo;
      ReportData localReportData = new ReportData();
      localReportData.jdField_b_of_type_ComTencentMobileqqKandianRepoFeedsEntityAbsBaseArticleInfo = paramAbsBaseArticleInfo;
      localReportData.jdField_a_of_type_ComTencentMobileqqKandianRepoReportReportInfo$DynamicInsertReportData = new ReportInfo.DynamicInsertReportData();
      ReportInfo.DynamicInsertReportData localDynamicInsertReportData = localReportData.jdField_a_of_type_ComTencentMobileqqKandianRepoReportReportInfo$DynamicInsertReportData;
      int j = -1;
      if (localRIJFeedsInsertAction != null)
      {
        ActionType localActionType = localRIJFeedsInsertAction.a();
        if (localActionType != null)
        {
          i = localActionType.toPBInt();
          break label80;
        }
      }
      int i = -1;
      label80:
      localDynamicInsertReportData.jdField_a_of_type_Int = i;
      localDynamicInsertReportData = localReportData.jdField_a_of_type_ComTencentMobileqqKandianRepoReportReportInfo$DynamicInsertReportData;
      if (localRIJFeedsInsertAction != null) {
        i = localRIJFeedsInsertAction.a();
      } else {
        i = -1;
      }
      localDynamicInsertReportData.jdField_b_of_type_Int = i;
      localDynamicInsertReportData = localReportData.jdField_a_of_type_ComTencentMobileqqKandianRepoReportReportInfo$DynamicInsertReportData;
      i = j;
      if (localRIJFeedsInsertAction != null) {
        i = localRIJFeedsInsertAction.b();
      }
      localDynamicInsertReportData.c = i;
      localReportData.jdField_a_of_type_ComTencentMobileqqKandianRepoReportReportInfo$DynamicInsertReportData.jdField_a_of_type_JavaLangString = str;
      localReportData.jdField_a_of_type_JavaLangLong = Long.valueOf(paramAbsBaseArticleInfo.mArticleID);
      localReportData.jdField_a_of_type_Long = paramAbsBaseArticleInfo.mAlgorithmID;
      localReportData.jdField_b_of_type_Int = paramAbsBaseArticleInfo.mStrategyId;
      localReportData.e = RIJFeedsInsertUtil.a.b(paramAbsBaseArticleInfo);
      paramAbsBaseArticleInfo = new StringBuilder();
      paramAbsBaseArticleInfo.append("report64e: ");
      paramAbsBaseArticleInfo.append(localReportData);
      QLog.d("RIJFeedsDynamicInsertController", 1, paramAbsBaseArticleInfo.toString());
      RIJReportDataCollectionManager.a((BaseReportData)localReportData, 0, 59);
    }
  }
  
  public final void requestDynamicInsertBackToTL()
  {
    Iterator localIterator1 = ((Map)RIJFeedsDynamicInsertRecordAction.a.a().a()).entrySet().iterator();
    while (localIterator1.hasNext())
    {
      Map.Entry localEntry1 = (Map.Entry)localIterator1.next();
      Iterator localIterator2 = ((Map)localEntry1.getValue()).entrySet().iterator();
      while (localIterator2.hasNext())
      {
        Map.Entry localEntry2 = (Map.Entry)localIterator2.next();
        INSTANCE.requestDynamicInsertBackToTL((String)localEntry2.getKey(), ((Number)localEntry1.getKey()).intValue());
      }
    }
  }
  
  public final void requestDynamicInsertBackToTL(@Nullable String paramString, int paramInt)
  {
    Object localObject1 = new StringBuilder();
    ((StringBuilder)localObject1).append("requestDynamicInsertBackToTL, rowKey: ");
    ((StringBuilder)localObject1).append(paramString);
    ((StringBuilder)localObject1).append(", reqSource: ");
    ((StringBuilder)localObject1).append(paramInt);
    QLog.d("RIJFeedsDynamicInsertController", 1, ((StringBuilder)localObject1).toString());
    if (TextUtils.isEmpty((CharSequence)paramString))
    {
      QLog.d("RIJFeedsDynamicInsertController", 1, "rowkey is null");
      return;
    }
    if (!RIJFeedsDynamicInsertConfig.a.a())
    {
      QLog.d("RIJFeedsDynamicInsertController", 1, "requestDynamicInsertBackToTL, channelId not match");
      return;
    }
    Object localObject2 = RIJFeedsDynamicInsertRecordAction.a.a().a(paramInt, paramString);
    if (localObject2 != null)
    {
      localObject1 = (List)((Triple)localObject2).component1();
      RIJFeedsInsertAction localRIJFeedsInsertAction = (RIJFeedsInsertAction)((Triple)localObject2).component2();
      localObject2 = (String)((Triple)localObject2).component3();
      RIJFeedsDynamicInsertController localRIJFeedsDynamicInsertController = INSTANCE;
      if (paramString == null) {
        Intrinsics.throwNpe();
      }
      localRIJFeedsDynamicInsertController.insertArticleInMainTL((List)localObject1, paramInt, paramString, localRIJFeedsInsertAction, (String)localObject2);
      QLog.d("RIJFeedsDynamicInsertController", 1, "requestDynamicInsertBackToTL, insertArticleInMainTL!");
    }
    deleteFeedsDynamicInsertInfo(paramInt, paramString);
  }
  
  public final void requestDynamicInsertInTL(@Nullable AbsBaseArticleInfo paramAbsBaseArticleInfo, @NotNull RIJFeedsInsertAction paramRIJFeedsInsertAction)
  {
    Intrinsics.checkParameterIsNotNull(paramRIJFeedsInsertAction, "action");
    ActionType localActionType = paramRIJFeedsInsertAction.a();
    int i = paramRIJFeedsInsertAction.a();
    int j = paramRIJFeedsInsertAction.b();
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("requestDynamicInsertInTL, channelId: ");
    Long localLong = null;
    Object localObject;
    if (paramAbsBaseArticleInfo != null) {
      localObject = Long.valueOf(paramAbsBaseArticleInfo.mChannelID);
    } else {
      localObject = null;
    }
    localStringBuilder.append(localObject);
    localStringBuilder.append(", title: ");
    if (paramAbsBaseArticleInfo != null) {
      localObject = paramAbsBaseArticleInfo.mTitle;
    } else {
      localObject = null;
    }
    localStringBuilder.append((String)localObject);
    localStringBuilder.append(", actionType: ");
    localStringBuilder.append(localActionType);
    localStringBuilder.append(", progress: ");
    localStringBuilder.append(i);
    localStringBuilder.append(", watchTime: ");
    localStringBuilder.append(j);
    QLog.d("RIJFeedsDynamicInsertController", 1, localStringBuilder.toString());
    if (paramAbsBaseArticleInfo != null) {
      localObject = paramAbsBaseArticleInfo.innerUniqueID;
    } else {
      localObject = null;
    }
    if (paramAbsBaseArticleInfo != null) {
      localLong = Long.valueOf(paramAbsBaseArticleInfo.mChannelID);
    }
    if ((localLong != null) && (!TextUtils.isEmpty((CharSequence)localObject)))
    {
      if (!RIJFeedsDynamicInsertConfig.a.a(Integer.valueOf((int)localLong.longValue())))
      {
        QLog.d("RIJFeedsDynamicInsertController", 1, "requestDynamicInsertInTL, channelId not match or config off");
        return;
      }
      paramAbsBaseArticleInfo = getFeedsInsertDynamicInsertModule();
      if (paramAbsBaseArticleInfo != null) {
        RIJFeedsDynamicInsertModule.a(paramAbsBaseArticleInfo, Integer.valueOf(1), (String)localObject, localActionType, false, (RIJFeedsDynamicInsertModule.Companion.IFeedsDynamicInsertCallback)new RIJFeedsDynamicInsertController.requestDynamicInsertInTL..inlined.let.lambda.1((String)localObject, localActionType, i, j, paramRIJFeedsInsertAction), 0, 0, 96, null);
      }
      return;
    }
    QLog.d("RIJFeedsDynamicInsertController", 1, "channelId or rowkey is null");
  }
  
  public final void requestInsertArticlesAndRecordAction(@Nullable String paramString, @NotNull RIJFeedsInsertAction paramRIJFeedsInsertAction, int paramInt)
  {
    Intrinsics.checkParameterIsNotNull(paramRIJFeedsInsertAction, "action");
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("requestInsertArticlesAndRecordAction rowKey: ");
    ((StringBuilder)localObject).append(paramString);
    ((StringBuilder)localObject).append(", action: ");
    ((StringBuilder)localObject).append(paramRIJFeedsInsertAction);
    ((StringBuilder)localObject).append(", reqSource: ");
    ((StringBuilder)localObject).append(paramInt);
    QLog.d("RIJFeedsDynamicInsertController", 1, ((StringBuilder)localObject).toString());
    if (TextUtils.isEmpty((CharSequence)paramString))
    {
      QLog.d("RIJFeedsDynamicInsertController", 1, "rowkey is null");
      return;
    }
    if (!RIJFeedsDynamicInsertConfig.a.a())
    {
      QLog.d("RIJFeedsDynamicInsertController", 1, "requestInsertArticlesAndRecordAction, config off");
      return;
    }
    if (paramRIJFeedsInsertAction.a() == ActionType.ACTION_ENTER)
    {
      QLog.d("RIJFeedsDynamicInsertController", 1, "requestInsertArticlesAndRecordAction, record enter action");
      RIJFeedsDynamicInsertRecordAction.a.a().a(paramInt, paramString, ActionType.ACTION_ENTER);
      return;
    }
    localObject = RIJFeedsDynamicInsertRecordAction.a.a().a(paramInt, paramString);
    if (localObject != null) {
      localObject = Integer.valueOf(((Integer)localObject).intValue() & ActionType.ACTION_ENTER.getActionType());
    } else {
      localObject = null;
    }
    if ((localObject != null) && (((Integer)localObject).intValue() > 0))
    {
      requestDynamicInsertArticle$default(this, paramInt, paramString, paramRIJFeedsInsertAction, null, 8, null);
      return;
    }
    QLog.d("RIJFeedsDynamicInsertController", 1, "requestInsertArticlesAndRecordAction, not enter from main tl");
  }
  
  public final void updateAdReadStatus(boolean paramBoolean)
  {
    hasReadAd = paramBoolean;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("updateAdReadStatus, readAd=");
    localStringBuilder.append(paramBoolean);
    QLog.d("RIJFeedsDynamicInsertController", 1, localStringBuilder.toString());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.feeds.dynamicfeeds.RIJFeedsDynamicInsertController
 * JD-Core Version:    0.7.0.1
 */