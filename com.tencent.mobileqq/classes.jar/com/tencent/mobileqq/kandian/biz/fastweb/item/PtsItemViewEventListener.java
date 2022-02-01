package com.tencent.mobileqq.kandian.biz.fastweb.item;

import android.view.View;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.kandian.base.utils.RIJQQAppInterfaceUtil;
import com.tencent.mobileqq.kandian.biz.common.ReadInJoyUtils;
import com.tencent.mobileqq.kandian.biz.common.api.IPublicAccountReportUtils;
import com.tencent.mobileqq.kandian.biz.fastweb.FastWebActivity;
import com.tencent.mobileqq.kandian.biz.pts.lite.PTSLiteEventTypeHandler;
import com.tencent.mobileqq.kandian.glue.report.RIJTransMergeKanDianReport.ReportR5Builder;
import com.tencent.mobileqq.kandian.repo.feeds.entity.AbsBaseArticleInfo;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.pts.core.PTSComposer;
import com.tencent.pts.core.lite.DefaultPTSLiteEventListener;
import com.tencent.qphone.base.util.QLog;
import java.util.HashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.Nullable;
import org.json.JSONException;
import org.json.JSONObject;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/mobileqq/kandian/biz/fastweb/item/PtsItemViewEventListener;", "Lcom/tencent/pts/core/lite/DefaultPTSLiteEventListener;", "()V", "addR5CommonParams", "", "r5Builder", "Lcom/tencent/mobileqq/kandian/glue/report/RIJTransMergeKanDianReport$ReportR5Builder;", "articleInfo", "Lcom/tencent/mobileqq/kandian/repo/feeds/entity/AbsBaseArticleInfo;", "onExposureTriggered", "id", "", "dataSet", "Ljava/util/HashMap;", "view", "Landroid/view/View;", "ptsComposer", "Lcom/tencent/pts/core/PTSComposer;", "onTapEventTriggered", "reportWithCommonParams", "reportName", "Companion", "kandian_feature_impl_release"}, k=1, mv={1, 1, 16})
public final class PtsItemViewEventListener
  extends DefaultPTSLiteEventListener
{
  public static final PtsItemViewEventListener.Companion a = new PtsItemViewEventListener.Companion(null);
  
  private final void a(RIJTransMergeKanDianReport.ReportR5Builder paramReportR5Builder, AbsBaseArticleInfo paramAbsBaseArticleInfo)
  {
    long l;
    if (paramAbsBaseArticleInfo != null) {
      l = paramAbsBaseArticleInfo.mAlgorithmID;
    } else {
      l = 0L;
    }
    paramReportR5Builder = paramReportR5Builder.addAlgorithmId(l).addKandianMode().addKandianModeNew().addNetworkType();
    int i;
    if (paramAbsBaseArticleInfo != null) {
      i = (int)paramAbsBaseArticleInfo.mChannelID;
    } else {
      i = 0;
    }
    paramReportR5Builder.addChannelId(i);
  }
  
  private final void a(String paramString, RIJTransMergeKanDianReport.ReportR5Builder paramReportR5Builder)
  {
    Object localObject1 = BaseActivity.sTopActivity;
    boolean bool = localObject1 instanceof FastWebActivity;
    String str1 = null;
    if (bool) {
      localObject1 = ((FastWebActivity)localObject1).a;
    } else {
      localObject1 = null;
    }
    a(paramReportR5Builder, (AbsBaseArticleInfo)localObject1);
    IPublicAccountReportUtils localIPublicAccountReportUtils = (IPublicAccountReportUtils)QRoute.api(IPublicAccountReportUtils.class);
    AppInterface localAppInterface = (AppInterface)RIJQQAppInterfaceUtil.a();
    String str2 = RIJQQAppInterfaceUtil.a();
    if (localObject1 != null) {
      localObject2 = Long.valueOf(((AbsBaseArticleInfo)localObject1).mArticleID);
    } else {
      localObject2 = null;
    }
    Object localObject2 = String.valueOf(localObject2);
    if (localObject2 == null) {
      localObject2 = "";
    }
    if (localObject1 != null) {
      localObject3 = Integer.valueOf(((AbsBaseArticleInfo)localObject1).mStrategyId);
    } else {
      localObject3 = null;
    }
    Object localObject3 = String.valueOf(localObject3);
    if (localObject3 == null) {
      localObject3 = "";
    }
    if (localObject1 != null) {
      str1 = ((AbsBaseArticleInfo)localObject1).innerUniqueID;
    }
    localObject1 = String.valueOf(str1);
    if (localObject1 == null) {
      localObject1 = "";
    }
    localIPublicAccountReportUtils.publicAccountReportClickEventForMigrate(localAppInterface, "P_CliOper", "Pb_account_lifeservice", str2, paramString, paramString, 0, 0, (String)localObject2, (String)localObject3, (String)localObject1, paramReportR5Builder.build(), false);
  }
  
  public void onExposureTriggered(@Nullable String paramString, @Nullable HashMap<String, String> paramHashMap, @Nullable View paramView, @Nullable PTSComposer paramPTSComposer)
  {
    if (paramHashMap == null)
    {
      QLog.d("PtsItemViewEventListener", 1, "[onExposureTriggered] dataSet is null");
      return;
    }
    paramView = (String)paramHashMap.get("exposureReportName");
    if (paramView != null) {}
    try
    {
      paramString = new RIJTransMergeKanDianReport.ReportR5Builder(new JSONObject((Map)paramHashMap));
    }
    catch (JSONException paramString)
    {
      label49:
      break label49;
    }
    paramString = new RIJTransMergeKanDianReport.ReportR5Builder();
    a(paramView, paramString);
  }
  
  public void onTapEventTriggered(@Nullable String paramString, @Nullable HashMap<String, String> paramHashMap, @Nullable View paramView, @Nullable PTSComposer paramPTSComposer)
  {
    PTSLiteEventTypeHandler.a.a(paramPTSComposer, paramHashMap);
    if (paramHashMap != null)
    {
      paramPTSComposer = (String)paramHashMap.get("jumpUrl");
      if (paramPTSComposer != null)
      {
        Intrinsics.checkExpressionValueIsNotNull(paramPTSComposer, "dataSet?.get(PTSConstant…A_SET_JUMP_URL) ?: return");
        if (paramView != null) {
          paramString = paramView.getContext();
        } else {
          paramString = null;
        }
        ReadInJoyUtils.a(paramString, paramPTSComposer);
        paramView = (String)paramHashMap.get("clickReportName");
        if (paramView == null) {}
      }
    }
    try
    {
      paramString = new RIJTransMergeKanDianReport.ReportR5Builder(new JSONObject((Map)paramHashMap));
    }
    catch (JSONException paramString)
    {
      label93:
      break label93;
    }
    paramString = new RIJTransMergeKanDianReport.ReportR5Builder();
    a(paramView, paramString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.fastweb.item.PtsItemViewEventListener
 * JD-Core Version:    0.7.0.1
 */