package com.tencent.mobileqq.kandian.glue.report;

import android.content.Context;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.bean.TemplateBean;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.kandian.base.utils.RIJQQAppInterfaceUtil;
import com.tencent.mobileqq.kandian.biz.common.api.IPublicAccountReportUtils;
import com.tencent.mobileqq.kandian.biz.framework.api.IReadInJoyUtils;
import com.tencent.mobileqq.kandian.biz.pts.view.polymeric.helper.RecycleViewAdapterHelper;
import com.tencent.mobileqq.kandian.biz.video.feeds.entity.VideoPlayParam;
import com.tencent.mobileqq.kandian.glue.video.report.VideoR5;
import com.tencent.mobileqq.kandian.glue.video.report.VideoR5.Builder;
import com.tencent.mobileqq.kandian.repo.feeds.RIJFeedsType;
import com.tencent.mobileqq.kandian.repo.feeds.entity.AbsBaseArticleInfo;
import com.tencent.mobileqq.kandian.repo.report.BaseReportData;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.statistics.StatisticCollector;
import com.tencent.qphone.base.util.QLog;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import mqq.app.AppRuntime;
import org.json.JSONObject;
import tencent.im.oidb.cmd0x68b.oidb_cmd0x68b.RspTraceRecord;

public class RIJStatisticCollectorReport
{
  public static void a(int paramInt, long paramLong, VideoPlayParam paramVideoPlayParam, AbsBaseArticleInfo paramAbsBaseArticleInfo, boolean paramBoolean)
  {
    VideoR5.Builder localBuilder = new VideoR5.Builder("", "", "", "").a(paramInt).b(paramLong);
    if (paramVideoPlayParam != null) {
      localBuilder.e(paramVideoPlayParam.jdField_g_of_type_Long).c(paramVideoPlayParam.jdField_g_of_type_Int);
    }
    if (paramAbsBaseArticleInfo != null) {
      localBuilder.i(paramAbsBaseArticleInfo.innerUniqueID).E(RIJFeedsType.a(paramAbsBaseArticleInfo));
    }
    if (paramBoolean) {
      paramVideoPlayParam = "1";
    } else {
      paramVideoPlayParam = "0";
    }
    ((IPublicAccountReportUtils)QRoute.api(IPublicAccountReportUtils.class)).publicAccountReportClickEvent(null, "", "0X8007DBB", "0X8007DBB", 0, 0, paramVideoPlayParam, "", "", localBuilder.a().a(), false);
  }
  
  public static void a(Context paramContext, String paramString, boolean paramBoolean, HashMap<String, String> paramHashMap)
  {
    paramHashMap.put("param_networkDetail", Integer.toString(((IReadInJoyUtils)QRoute.api(IReadInJoyUtils.class)).getDetailNetworkInfo(paramContext)));
    ThreadManager.post(new RIJStatisticCollectorReport.1(paramHashMap, paramBoolean, paramContext, paramString), 5, null, true);
  }
  
  public static void a(String paramString, BaseReportData paramBaseReportData, VideoR5.Builder paramBuilder)
  {
    if (paramBaseReportData.jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsEntityAbsBaseArticleInfo == null) {
      return;
    }
    long l = paramBaseReportData.jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsEntityAbsBaseArticleInfo.mArticleID;
    Object localObject1 = RecycleViewAdapterHelper.a(l);
    if (localObject1 != null)
    {
      paramBuilder = new VideoR5.Builder(paramBuilder.a().a());
      localObject1 = ((List)localObject1).iterator();
      while (((Iterator)localObject1).hasNext())
      {
        AbsBaseArticleInfo localAbsBaseArticleInfo = (AbsBaseArticleInfo)((Iterator)localObject1).next();
        Object localObject2;
        if ((localAbsBaseArticleInfo != null) && (localAbsBaseArticleInfo.mProteusTemplateBean != null))
        {
          localObject2 = localAbsBaseArticleInfo.mProteusTemplateBean.getDataAttribute(null);
          if ((localObject2 != null) && (((Map)localObject2).entrySet() != null))
          {
            localObject2 = ((Map)localObject2).entrySet().iterator();
            while ((localObject2 != null) && (((Iterator)localObject2).hasNext()))
            {
              Map.Entry localEntry = (Map.Entry)((Iterator)localObject2).next();
              paramBuilder.a((String)localEntry.getKey(), localEntry.getValue().toString());
            }
          }
          localObject2 = new StringBuilder();
          ((StringBuilder)localObject2).append("reportArticleItemExpose: ");
          ((StringBuilder)localObject2).append(localAbsBaseArticleInfo);
          ((StringBuilder)localObject2).append("  bean :");
          ((StringBuilder)localObject2).append(localAbsBaseArticleInfo.mProteusTemplateBean.getDataAttribute(null));
          QLog.d("RIJStatisticCollectorReport", 1, ((StringBuilder)localObject2).toString());
        }
        else
        {
          localObject2 = new StringBuilder();
          ((StringBuilder)localObject2).append("reportArticleItemExpose: ");
          ((StringBuilder)localObject2).append(localAbsBaseArticleInfo);
          QLog.d("RIJStatisticCollectorReport", 1, ((StringBuilder)localObject2).toString());
        }
        ((IPublicAccountReportUtils)QRoute.api(IPublicAccountReportUtils.class)).publicAccountReportClickEventForMigrate(null, "CliOper", "", paramBaseReportData.d, paramString, paramString, 0, 0, Long.toString(paramBaseReportData.jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsEntityAbsBaseArticleInfo.mFeedId), Long.toString(paramBaseReportData.jdField_a_of_type_JavaLangLong.longValue()), Integer.toString(paramBaseReportData.b), paramBuilder.a().a(), false);
      }
      RecycleViewAdapterHelper.a(l);
    }
  }
  
  public static void a(AppRuntime paramAppRuntime, List<oidb_cmd0x68b.RspTraceRecord> paramList)
  {
    if ((paramAppRuntime != null) && (paramList != null))
    {
      if (paramList.size() < 1) {
        return;
      }
      HashMap localHashMap = new HashMap();
      paramList = paramList.iterator();
      while (paramList.hasNext())
      {
        oidb_cmd0x68b.RspTraceRecord localRspTraceRecord = (oidb_cmd0x68b.RspTraceRecord)paramList.next();
        localHashMap.put(localRspTraceRecord.bytes_method.get().toStringUtf8(), String.valueOf(localRspTraceRecord.uint32_cost.get()));
      }
      StatisticCollector.getInstance(paramAppRuntime.getApplication()).collectPerformance(null, "actKandianRefreshBackEndTrace", true, 0L, 0L, localHashMap, null);
    }
  }
  
  public static void a(AppRuntime paramAppRuntime, boolean paramBoolean, int paramInt)
  {
    if (paramAppRuntime == null) {
      return;
    }
    HashMap localHashMap = new HashMap();
    localHashMap.put("LOOP_ERROR_CODE", Integer.toString(paramInt));
    StatisticCollector.getInstance(paramAppRuntime.getApplication()).collectPerformance(null, "actWebRenderLoopEvent", paramBoolean, -1L, 0L, localHashMap, null);
  }
  
  public static void a(AppRuntime paramAppRuntime, boolean paramBoolean, int paramInt, long paramLong)
  {
    if (paramAppRuntime == null) {
      return;
    }
    HashMap localHashMap = new HashMap();
    localHashMap.put("LOOP_STEP", Integer.toString(paramInt));
    localHashMap.put("LOOP_STEP_COST", Long.toString(paramLong));
    StatisticCollector.getInstance(paramAppRuntime.getApplication()).collectPerformance(null, "actWebRenderLoopEventCost", paramBoolean, -1L, 0L, localHashMap, null);
  }
  
  public static void a(AppRuntime paramAppRuntime, boolean paramBoolean, long paramLong, int paramInt)
  {
    if ((paramAppRuntime != null) && (paramLong >= 0L))
    {
      if (paramLong > 30000L) {
        return;
      }
      HashMap localHashMap = new HashMap();
      localHashMap.put("retCode", String.valueOf(paramInt));
      StatisticCollector.getInstance(paramAppRuntime.getApplication()).collectPerformance(null, "actKandianGetShareJsonSuccAndCost", paramBoolean, paramLong, 0L, localHashMap, null);
    }
  }
  
  public static void a(AppRuntime paramAppRuntime, boolean paramBoolean, long paramLong, int paramInt1, int paramInt2)
  {
    if (paramAppRuntime == null) {
      return;
    }
    HashMap localHashMap = new HashMap();
    localHashMap.put("retCode", String.valueOf(paramInt1));
    localHashMap.put("param_OpCode", String.valueOf(paramInt2));
    StatisticCollector.getInstance(paramAppRuntime.getApplication()).collectPerformance(null, "actKandian0x83eResult", paramBoolean, paramLong, 0L, localHashMap, null);
    paramAppRuntime = new StringBuilder();
    paramAppRuntime.append("reportKandian83eMonitorData| actKandian0x83eResult | retCode ： ");
    paramAppRuntime.append(paramInt1);
    paramAppRuntime.append("| param_OpCode : ");
    paramAppRuntime.append(paramInt2);
    QLog.d("RIJStatisticCollectorReport", 1, paramAppRuntime.toString());
  }
  
  public static void a(AppRuntime paramAppRuntime, boolean paramBoolean, long paramLong, HashMap<String, String> paramHashMap)
  {
    if ((paramAppRuntime != null) && (paramLong >= 0L))
    {
      if (paramLong > 50000L) {
        return;
      }
      StatisticCollector.getInstance(paramAppRuntime.getApplication()).collectPerformance(RIJQQAppInterfaceUtil.a(), "actKandianRefreshSuccAndCost", paramBoolean, paramLong, 0L, paramHashMap, null);
    }
  }
  
  public static void a(AppRuntime paramAppRuntime, boolean paramBoolean, String paramString, int paramInt, long paramLong)
  {
    if (paramAppRuntime == null) {
      return;
    }
    HashMap localHashMap = new HashMap();
    localHashMap.put("PLUGIN_STEP", paramString);
    localHashMap.put("PLUGIN_CAN_RENDER", Integer.toString(paramInt));
    localHashMap.put("PLUGIN_STEP_COST_FROM_CLICK", Long.toString(paramLong));
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("reportWebRenderPluginEventCost PLUGIN_STEP : [");
      localStringBuilder.append(paramString);
      localStringBuilder.append("];PLUGIN_CAN_RENDER :[");
      localStringBuilder.append(paramInt);
      localStringBuilder.append("]; + PLUGIN_STEP_COST_FROM_CLICK : [");
      localStringBuilder.append(paramLong);
      localStringBuilder.append(" ms];");
      QLog.d("RIJStatisticCollectorReport", 2, localStringBuilder.toString());
    }
    StatisticCollector.getInstance(paramAppRuntime.getApplication()).collectPerformance(null, "actreportWebRenderPluginEventCost", paramBoolean, -1L, 0L, localHashMap, null);
  }
  
  public static void a(AppRuntime paramAppRuntime, boolean paramBoolean, HashMap<String, String> paramHashMap)
  {
    if (paramAppRuntime == null) {
      return;
    }
    StatisticCollector.getInstance(paramAppRuntime.getApplication()).collectPerformance(null, "actKanDianViolaData", paramBoolean, -1L, -1L, paramHashMap, null);
  }
  
  public static void a(AppRuntime paramAppRuntime, boolean paramBoolean, JSONObject paramJSONObject)
  {
    if (paramAppRuntime == null) {
      return;
    }
    ThreadManager.post(new RIJStatisticCollectorReport.3(paramJSONObject, paramAppRuntime, paramBoolean), 5, null, true);
  }
  
  public static void a(boolean paramBoolean1, boolean paramBoolean2, int paramInt1, int paramInt2, long paramLong, int paramInt3, String paramString1, String paramString2)
  {
    ThreadManagerV2.executeOnSubThread(new RIJStatisticCollectorReport.2(paramBoolean2, paramInt1, paramInt3, paramInt2, paramLong, paramString1, paramBoolean1, paramString2));
  }
  
  public static void b(Context paramContext, String paramString, boolean paramBoolean, HashMap<String, String> paramHashMap)
  {
    paramHashMap.put("param_networkDetail", Integer.toString(((IReadInJoyUtils)QRoute.api(IReadInJoyUtils.class)).getDetailNetworkInfo(paramContext)));
    StatisticCollector.getInstance(paramContext).collectPerformance(paramString, "actKandianVideoPreload", paramBoolean, -1L, 0L, paramHashMap, null);
  }
  
  public static void b(AppRuntime paramAppRuntime, boolean paramBoolean, long paramLong, int paramInt)
  {
    if ((paramAppRuntime != null) && (paramLong >= 0L))
    {
      if (paramLong > 30000L) {
        return;
      }
      HashMap localHashMap = new HashMap();
      localHashMap.put("retCode", String.valueOf(paramInt));
      StatisticCollector.getInstance(paramAppRuntime.getApplication()).collectPerformance(null, "actKandianGetUserInfoSuccAndCost", paramBoolean, paramLong, 0L, localHashMap, null);
    }
  }
  
  public static void b(AppRuntime paramAppRuntime, boolean paramBoolean, HashMap<String, String> paramHashMap)
  {
    if (paramAppRuntime == null) {
      return;
    }
    StatisticCollector.getInstance(paramAppRuntime.getApplication()).collectPerformance(null, "actKanDianViolaHttpData", paramBoolean, -1L, -1L, paramHashMap, null, true);
  }
  
  public static void c(Context paramContext, String paramString, boolean paramBoolean, HashMap<String, String> paramHashMap)
  {
    StatisticCollector.getInstance(paramContext).collectPerformance(paramString, "actVideoFeedsStartTime", paramBoolean, -1L, 0L, paramHashMap, null);
  }
  
  public static void c(AppRuntime paramAppRuntime, boolean paramBoolean, HashMap<String, String> paramHashMap)
  {
    if (paramAppRuntime == null) {
      return;
    }
    StatisticCollector.getInstance(paramAppRuntime.getApplication()).collectPerformance(null, "actKanDianViolaJsError", paramBoolean, -1L, -1L, paramHashMap, null, true);
  }
  
  public static void d(Context paramContext, String paramString, boolean paramBoolean, HashMap<String, String> paramHashMap)
  {
    StatisticCollector.getInstance(paramContext).collectPerformance(paramString, "actVideoFeedsScrollIntervalTime", paramBoolean, -1L, 0L, paramHashMap, null);
  }
  
  public static void e(Context paramContext, String paramString, boolean paramBoolean, HashMap<String, String> paramHashMap)
  {
    paramHashMap.put("param_networkDetail", Integer.toString(((IReadInJoyUtils)QRoute.api(IReadInJoyUtils.class)).getDetailNetworkInfo(paramContext)));
    StatisticCollector.getInstance(paramContext).collectPerformance(paramString, "actKandianVideoBehaviorsSeq", paramBoolean, -1L, 0L, paramHashMap, null);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.glue.report.RIJStatisticCollectorReport
 * JD-Core Version:    0.7.0.1
 */