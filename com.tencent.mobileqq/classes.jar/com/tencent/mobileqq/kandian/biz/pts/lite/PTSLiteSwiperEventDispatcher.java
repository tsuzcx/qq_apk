package com.tencent.mobileqq.kandian.biz.pts.lite;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import android.util.Pair;
import android.view.View;
import com.tencent.mobileqq.activity.SplashActivity;
import com.tencent.mobileqq.kandian.biz.common.RIJTabFrameBase;
import com.tencent.mobileqq.kandian.biz.common.RIJTabFrameBase.FeedsOperation;
import com.tencent.mobileqq.kandian.biz.common.ReadInJoyUtils;
import com.tencent.mobileqq.kandian.biz.common.api.IPublicAccountReportUtils;
import com.tencent.mobileqq.kandian.biz.common.fragment.ReadInJoyBaseFragment;
import com.tencent.mobileqq.kandian.biz.feeds.activity.ReadInJoyNewFeedsActivity;
import com.tencent.mobileqq.kandian.biz.framework.RIJAppSetting;
import com.tencent.mobileqq.kandian.biz.framework.ReadInJoyBaseAdapter;
import com.tencent.mobileqq.kandian.biz.pts.util.PTSRijReport;
import com.tencent.mobileqq.kandian.glue.report.KandianDailyReportUtils;
import com.tencent.mobileqq.kandian.glue.report.RIJTransMergeKanDianReport;
import com.tencent.mobileqq.kandian.glue.report.ReadinjoyReportUtils;
import com.tencent.mobileqq.kandian.glue.router.RIJJumpUtils;
import com.tencent.mobileqq.kandian.repo.aladdin.handlers.ChannelListDynamicOrderConfigHandler;
import com.tencent.mobileqq.kandian.repo.aladdin.handlers.DailyModeConfigHandler;
import com.tencent.mobileqq.kandian.repo.common.RIJShowKanDianTabSp;
import com.tencent.mobileqq.kandian.repo.feeds.RIJFeedsType;
import com.tencent.mobileqq.kandian.repo.feeds.entity.AbsBaseArticleInfo;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.qav.thread.ThreadManager;
import com.tencent.qphone.base.util.QLog;
import java.util.HashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.TypeCastException;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.json.JSONException;
import org.json.JSONObject;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/mobileqq/kandian/biz/pts/lite/PTSLiteSwiperEventDispatcher;", "", "()V", "adapter", "Lcom/tencent/mobileqq/kandian/biz/framework/ReadInJoyBaseAdapter;", "articleInfoMap", "Ljava/util/HashMap;", "", "Lcom/tencent/mobileqq/kandian/repo/feeds/entity/AbsBaseArticleInfo;", "Lkotlin/collections/HashMap;", "exposureDataMap", "Lcom/tencent/mobileqq/kandian/biz/pts/lite/PTSLiteSwiperEventDispatcher$ItemExposureData;", "positionMap", "", "exposeSwiperItemImp", "", "identifier", "dataSet", "folderStatus", "getBehaviorTypeAndStayTimeMillis", "Landroid/util/Pair;", "", "channelId", "handleSwiperDrag", "view", "Landroid/view/View;", "handleSwiperItemExposure", "reportSwiperItem", "Builder", "Companion", "ItemExposureData", "kandian_feature_impl_release"}, k=1, mv={1, 1, 16})
public final class PTSLiteSwiperEventDispatcher
{
  public static final PTSLiteSwiperEventDispatcher.Companion a;
  private ReadInJoyBaseAdapter jdField_a_of_type_ComTencentMobileqqKandianBizFrameworkReadInJoyBaseAdapter;
  private HashMap<String, Integer> jdField_a_of_type_JavaUtilHashMap = new HashMap();
  private HashMap<String, AbsBaseArticleInfo> b = new HashMap();
  private HashMap<String, PTSLiteSwiperEventDispatcher.ItemExposureData> c = new HashMap();
  
  static
  {
    jdField_a_of_type_ComTencentMobileqqKandianBizPtsLitePTSLiteSwiperEventDispatcher$Companion = new PTSLiteSwiperEventDispatcher.Companion(null);
  }
  
  private final Pair<Integer, Long> a(int paramInt)
  {
    Object localObject = this.jdField_a_of_type_ComTencentMobileqqKandianBizFrameworkReadInJoyBaseAdapter;
    ReadInJoyBaseAdapter localReadInJoyBaseAdapter2 = null;
    ReadInJoyBaseAdapter localReadInJoyBaseAdapter1 = null;
    if (localObject != null) {
      localObject = ((ReadInJoyBaseAdapter)localObject).a();
    } else {
      localObject = null;
    }
    boolean bool = localObject instanceof ReadInJoyNewFeedsActivity;
    long l = 0L;
    int i = 1;
    if (bool)
    {
      localObject = this.jdField_a_of_type_ComTencentMobileqqKandianBizFrameworkReadInJoyBaseAdapter;
      if (localObject != null) {
        localObject = ((ReadInJoyBaseAdapter)localObject).a();
      } else {
        localObject = null;
      }
      if (localObject != null)
      {
        if (((ReadInJoyNewFeedsActivity)localObject).a() > 0L)
        {
          localObject = this.jdField_a_of_type_ComTencentMobileqqKandianBizFrameworkReadInJoyBaseAdapter;
          if (localObject != null) {
            localObject = ((ReadInJoyBaseAdapter)localObject).a();
          } else {
            localObject = null;
          }
          if (localObject != null) {
            l = ((ReadInJoyNewFeedsActivity)localObject).a();
          } else {
            throw new TypeCastException("null cannot be cast to non-null type com.tencent.mobileqq.kandian.biz.feeds.activity.ReadInJoyNewFeedsActivity");
          }
        }
        else
        {
          l = System.currentTimeMillis();
          localObject = this.jdField_a_of_type_ComTencentMobileqqKandianBizFrameworkReadInJoyBaseAdapter;
          if (localObject != null) {
            localObject = ((ReadInJoyBaseAdapter)localObject).a();
          } else {
            localObject = null;
          }
          if (localObject == null) {
            break label237;
          }
          l -= ((ReadInJoyNewFeedsActivity)localObject).b();
        }
        localReadInJoyBaseAdapter2 = this.jdField_a_of_type_ComTencentMobileqqKandianBizFrameworkReadInJoyBaseAdapter;
        localObject = localReadInJoyBaseAdapter1;
        if (localReadInJoyBaseAdapter2 != null) {
          localObject = localReadInJoyBaseAdapter2.a();
        }
        if (localObject != null)
        {
          paramInt = ((ReadInJoyNewFeedsActivity)localObject).b() ^ true;
        }
        else
        {
          throw new TypeCastException("null cannot be cast to non-null type com.tencent.mobileqq.kandian.biz.feeds.activity.ReadInJoyNewFeedsActivity");
          label237:
          throw new TypeCastException("null cannot be cast to non-null type com.tencent.mobileqq.kandian.biz.feeds.activity.ReadInJoyNewFeedsActivity");
        }
      }
      else
      {
        throw new TypeCastException("null cannot be cast to non-null type com.tencent.mobileqq.kandian.biz.feeds.activity.ReadInJoyNewFeedsActivity");
      }
    }
    else
    {
      localObject = this.jdField_a_of_type_ComTencentMobileqqKandianBizFrameworkReadInJoyBaseAdapter;
      if (localObject != null) {
        localObject = ((ReadInJoyBaseAdapter)localObject).a();
      } else {
        localObject = null;
      }
      if ((localObject instanceof SplashActivity))
      {
        localReadInJoyBaseAdapter1 = this.jdField_a_of_type_ComTencentMobileqqKandianBizFrameworkReadInJoyBaseAdapter;
        localObject = localReadInJoyBaseAdapter2;
        if (localReadInJoyBaseAdapter1 != null) {
          localObject = localReadInJoyBaseAdapter1.a();
        }
        localObject = (RIJTabFrameBase)RIJJumpUtils.a((Context)localObject);
        if (localObject != null)
        {
          localObject = ((RIJTabFrameBase)localObject).a();
          paramInt = i;
          if (((RIJTabFrameBase.FeedsOperation)localObject).a() != 0) {
            paramInt = 0;
          }
          l = ((RIJTabFrameBase.FeedsOperation)localObject).a();
          break label383;
        }
      }
      else if (DailyModeConfigHandler.c(paramInt))
      {
        if (KandianDailyReportUtils.b() != 0)
        {
          paramInt = 0;
          break label383;
        }
        paramInt = 1;
        break label383;
      }
      paramInt = -1;
    }
    label383:
    return new Pair(Integer.valueOf(paramInt), Long.valueOf(l));
  }
  
  private final void a(String paramString1, HashMap<String, String> paramHashMap, String paramString2)
  {
    if (TextUtils.isEmpty((CharSequence)paramString1)) {
      QLog.i("PTSLiteSwiperEventDispatcher", 1, "[exposeSwiperItemImp] identifier is null.");
    }
    AbsBaseArticleInfo localAbsBaseArticleInfo = (AbsBaseArticleInfo)((Map)this.b).get(paramString1);
    if (localAbsBaseArticleInfo == null)
    {
      QLog.i("PTSLiteSwiperEventDispatcher", 1, "[exposeSwiperItemImp] error, articleInfo is null.");
      return;
    }
    long l1 = localAbsBaseArticleInfo.mChannelID;
    int k = (int)l1;
    Pair localPair = a(k);
    if (localPair == null) {
      Intrinsics.throwNpe();
    }
    paramString1 = (Long)localPair.second;
    Object localObject1 = (Integer)localPair.first;
    long l2 = localAbsBaseArticleInfo.mAlgorithmID;
    int j = localAbsBaseArticleInfo.mArticleType;
    int i;
    if (localAbsBaseArticleInfo.hasChannelInfo()) {
      i = localAbsBaseArticleInfo.mChannelInfoId;
    } else {
      i = 0;
    }
    boolean bool1 = TextUtils.isEmpty((CharSequence)localAbsBaseArticleInfo.mArticleFriendLikeText);
    localPair = null;
    boolean bool2 = NetworkUtil.isWifiConnected(null);
    Object localObject2 = RIJFeedsType.c(localAbsBaseArticleInfo);
    String str1 = localAbsBaseArticleInfo.mStrCircleId;
    String str2 = localAbsBaseArticleInfo.innerUniqueID;
    String str3 = RIJFeedsType.e(localAbsBaseArticleInfo);
    Intrinsics.checkExpressionValueIsNotNull(paramString1, "totalTimeMillis");
    long l3 = paramString1.longValue();
    Intrinsics.checkExpressionValueIsNotNull(localObject1, "behaviorType");
    localObject1 = RIJTransMergeKanDianReport.a(l2, j, k, i, bool1 ^ true, bool2, (String)localObject2, str1, str2, str3, localAbsBaseArticleInfo, l3, ((Integer)localObject1).intValue(), RIJTransMergeKanDianReport.a(), RIJAppSetting.a(), 0, false, localAbsBaseArticleInfo.mVideoAdsJumpType, localAbsBaseArticleInfo.mVideoAdsSource, ReadInJoyBaseFragment.a(k));
    for (;;)
    {
      try
      {
        localObject2 = new JSONObject((String)localObject1);
        ((JSONObject)localObject2).put("folder_status", paramString2);
        ((JSONObject)localObject2).put("is_change", ChannelListDynamicOrderConfigHandler.a(ReadInJoyUtils.a(), k));
        paramString2 = this.jdField_a_of_type_ComTencentMobileqqKandianBizFrameworkReadInJoyBaseAdapter;
        paramString1 = localPair;
        if (paramString2 != null)
        {
          paramString2 = paramString2.a();
          paramString1 = localPair;
          if (paramString2 != null) {
            paramString1 = paramString2.getIntent();
          }
        }
        if (paramString1 != null)
        {
          j = 0;
          if (paramString1.getIntExtra("launch_from", 0) != 15) {
            break label557;
          }
          i = 1;
          break label560;
          ((JSONObject)localObject2).put("from_aio", j);
        }
        paramString2 = ((JSONObject)localObject2).toString();
      }
      catch (JSONException paramString1)
      {
        paramString2 = new StringBuilder();
        paramString2.append("[exposeSwiperItemImp] e = ");
        paramString2.append(paramString1);
        QLog.i("PTSLiteSwiperEventDispatcher", 1, paramString2.toString());
        paramString2 = (String)localObject1;
      }
      if (ReadinjoyReportUtils.a(l1)) {
        paramString1 = "0X8009354";
      } else {
        paramString1 = "0X8007626";
      }
      if ((DailyModeConfigHandler.a(k)) || (RIJShowKanDianTabSp.a(l1))) {
        paramString1 = "0X8009CC8";
      }
      paramHashMap = PTSRijReport.a(paramString2, paramHashMap);
      ((IPublicAccountReportUtils)QRoute.api(IPublicAccountReportUtils.class)).publicAccountReportClickEvent(null, localAbsBaseArticleInfo.mSubscribeID, paramString1, paramString1, 0, 0, String.valueOf(localAbsBaseArticleInfo.mFeedId), String.valueOf(localAbsBaseArticleInfo.mArticleID), String.valueOf(localAbsBaseArticleInfo.mStrategyId), paramHashMap, false);
      if (QLog.isColorLevel())
      {
        paramString2 = new StringBuilder();
        paramString2.append("[exposeSwiperItemImp] reportActionName = ");
        paramString2.append(paramString1);
        paramString2.append(", r5Str = ");
        paramString2.append(paramHashMap);
        QLog.i("PTSLiteSwiperEventDispatcher", 2, paramString2.toString());
      }
      return;
      label557:
      i = 0;
      label560:
      if (i != 0) {
        j = 1;
      }
    }
  }
  
  public final void a()
  {
    ThreadManager.a((Runnable)new PTSLiteSwiperEventDispatcher.reportSwiperItem.1(this));
  }
  
  public final void a(@Nullable String paramString, @NotNull HashMap<String, String> paramHashMap, @Nullable View paramView)
  {
    Intrinsics.checkParameterIsNotNull(paramHashMap, "dataSet");
    ThreadManager.a((Runnable)new PTSLiteSwiperEventDispatcher.handleSwiperDrag.1(paramString, paramHashMap));
  }
  
  public final void a(@Nullable String paramString1, @NotNull HashMap<String, String> paramHashMap, @Nullable View paramView, @Nullable String paramString2)
  {
    Intrinsics.checkParameterIsNotNull(paramHashMap, "dataSet");
    Object localObject = (String)paramHashMap.get("rowkey");
    paramView = (View)localObject;
    if (TextUtils.isEmpty((CharSequence)localObject)) {
      paramView = paramHashMap.toString();
    }
    localObject = new StringBuilder();
    ((StringBuilder)localObject).append("[handleSwiperItemExposure] key = ");
    ((StringBuilder)localObject).append(paramView);
    QLog.i("PTSLiteSwiperEventDispatcher", 1, ((StringBuilder)localObject).toString());
    if (paramView != null)
    {
      if (!this.c.containsKey(paramView))
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("[handleSwiperItemExposure] add item exposure to map, identifier = ");
        ((StringBuilder)localObject).append(paramString1);
        ((StringBuilder)localObject).append(", key = ");
        ((StringBuilder)localObject).append(paramView);
        QLog.i("PTSLiteSwiperEventDispatcher", 1, ((StringBuilder)localObject).toString());
        ((Map)this.c).put(paramView, new PTSLiteSwiperEventDispatcher.ItemExposureData(paramString1, paramHashMap, paramString2));
        return;
      }
      if (QLog.isColorLevel())
      {
        paramString1 = new StringBuilder();
        paramString1.append("[handleSwiperItemExposure] do not add duplicated data, key = ");
        paramString1.append(paramView);
        QLog.i("PTSLiteSwiperEventDispatcher", 1, paramString1.toString());
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.pts.lite.PTSLiteSwiperEventDispatcher
 * JD-Core Version:    0.7.0.1
 */