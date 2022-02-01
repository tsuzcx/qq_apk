package com.tencent.mobileqq.kandian.repo.pts.network;

import android.content.Context;
import android.os.Build;
import com.tencent.aladdin.config.Aladdin;
import com.tencent.aladdin.config.AladdinConfig;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.kandian.base.utils.RIJNetworkUtils;
import com.tencent.mobileqq.kandian.base.utils.RIJQQAppInterfaceUtil;
import com.tencent.mobileqq.kandian.biz.common.api.impl.PublicAccountReportUtils;
import com.tencent.mobileqq.kandian.glue.report.RIJTransMergeKanDianReport;
import com.tencent.mobileqq.kandian.glue.report.RIJTransMergeKanDianReport.ReportR5Builder;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.qphone.base.remote.ToServiceMsg;
import com.tencent.qphone.base.util.QLog;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import kotlin.Metadata;
import kotlin.TypeCastException;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.json.JSONException;
import org.json.JSONObject;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/mobileqq/kandian/repo/pts/network/WeakNetReportUtil;", "", "()V", "ACTION_FEEDS_REFRESH", "", "ACTION_NETWORK_CHANGED", "TAG", "feedsReportSwitch", "", "report68bFeedsRequest", "", "params", "Ljava/util/HashMap;", "Lkotlin/collections/HashMap;", "report68bRequestNetworkChanged", "req", "Lcom/tencent/qphone/base/remote/ToServiceMsg;", "result", "", "kandian_feature_impl_release"}, k=1, mv={1, 1, 16})
public final class WeakNetReportUtil
{
  public static final WeakNetReportUtil a = new WeakNetReportUtil();
  private static boolean b;
  
  public final void a(@NotNull ToServiceMsg paramToServiceMsg, int paramInt)
  {
    Intrinsics.checkParameterIsNotNull(paramToServiceMsg, "req");
    QLog.i("WeakNetReportUtil", 1, "[report68bRequestNetworkChanged]");
    Object localObject = paramToServiceMsg.getAttribute("sendNetType");
    int i;
    boolean bool1;
    int k;
    int m;
    boolean bool2;
    if (localObject != null)
    {
      i = ((Integer)localObject).intValue();
      localObject = paramToServiceMsg.getAttribute("sendIsNetConnected");
      if (localObject != null)
      {
        bool1 = ((Boolean)localObject).booleanValue();
        paramToServiceMsg = paramToServiceMsg.getAttribute("retryIndex");
        if (paramToServiceMsg != null)
        {
          k = ((Integer)paramToServiceMsg).intValue();
          localObject = RIJQQAppInterfaceUtil.d();
          m = RIJNetworkUtils.f((Context)BaseApplicationImpl.context);
          bool2 = NetworkUtil.isNetworkAvailable();
          paramToServiceMsg = new JSONObject();
        }
      }
    }
    for (;;)
    {
      try
      {
        paramToServiceMsg.put("sendNetType", i);
        int j = 0;
        if (!bool1) {
          break label340;
        }
        i = 1;
        paramToServiceMsg.put("sendIsNetConnected", i);
        paramToServiceMsg.put("retryIndex", k);
        paramToServiceMsg.put("receiveNetType", m);
        i = j;
        if (bool2) {
          i = 1;
        }
        paramToServiceMsg.put("receiveNetConnected", i);
        paramToServiceMsg.put("retCode", paramInt);
        paramToServiceMsg.put("uin", localObject);
        paramToServiceMsg.put("brand", Build.BRAND);
        paramToServiceMsg.put("model", Build.MODEL);
      }
      catch (JSONException localJSONException)
      {
        StringBuilder localStringBuilder2 = new StringBuilder();
        localStringBuilder2.append("[report68bRequestNetworkChanged], e = ");
        localStringBuilder2.append(localJSONException);
        QLog.e("WeakNetReportUtil", 1, localStringBuilder2.toString());
      }
      StringBuilder localStringBuilder1 = new StringBuilder();
      localStringBuilder1.append("[report68bRequestNetworkChanged], actionName = 0X800B6B4, r5 = ");
      localStringBuilder1.append(paramToServiceMsg);
      QLog.i("WeakNetReportUtil", 1, localStringBuilder1.toString());
      PublicAccountReportUtils.a(null, "", "0X800B6B4", "0X800B6B4", 0, 0, "", "", "", paramToServiceMsg.toString(), false);
      return;
      throw new TypeCastException("null cannot be cast to non-null type kotlin.Int");
      throw new TypeCastException("null cannot be cast to non-null type kotlin.Boolean");
      throw new TypeCastException("null cannot be cast to non-null type kotlin.Int");
      label340:
      i = 0;
    }
  }
  
  public final void a(@NotNull HashMap<String, String> paramHashMap)
  {
    Intrinsics.checkParameterIsNotNull(paramHashMap, "params");
    for (;;)
    {
      boolean bool;
      int i;
      try
      {
        localObject = Aladdin.getConfig(405);
        bool = false;
        if (localObject == null) {
          break label252;
        }
        i = ((AladdinConfig)localObject).getIntegerFromString("feedsReportSwitch", 0);
      }
      catch (Exception paramHashMap)
      {
        Map.Entry localEntry;
        Object localObject = new StringBuilder();
        ((StringBuilder)localObject).append("[report68bFeedsRequest] error, e = ");
        ((StringBuilder)localObject).append(paramHashMap);
        QLog.e("WeakNetReportUtil", 1, ((StringBuilder)localObject).toString());
        return;
      }
      b = bool;
      if (!b)
      {
        QLog.i("WeakNetReportUtil", 1, "[report68bFeedsRequest] do not report.");
        return;
      }
      localObject = RIJTransMergeKanDianReport.g();
      paramHashMap = ((Map)paramHashMap).entrySet().iterator();
      if (paramHashMap.hasNext())
      {
        localEntry = (Map.Entry)paramHashMap.next();
        ((RIJTransMergeKanDianReport.ReportR5Builder)localObject).addStringNotThrow((String)localEntry.getKey(), (String)localEntry.getValue());
      }
      else
      {
        ((RIJTransMergeKanDianReport.ReportR5Builder)localObject).addStringNotThrow("brand", Build.BRAND);
        ((RIJTransMergeKanDianReport.ReportR5Builder)localObject).addStringNotThrow("model", Build.MODEL);
        paramHashMap = ((RIJTransMergeKanDianReport.ReportR5Builder)localObject).build();
        Intrinsics.checkExpressionValueIsNotNull(paramHashMap, "r5Builder.build()");
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("[report68bFeedsRequest], r5String = ");
        ((StringBuilder)localObject).append(paramHashMap);
        QLog.i("WeakNetReportUtil", 1, ((StringBuilder)localObject).toString());
        PublicAccountReportUtils.a(null, "", "0X800B8DE", "0X800B8DE", 0, 0, "", "", "", paramHashMap, false);
        return;
        label252:
        i = 0;
        if (i == 1) {
          bool = true;
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.repo.pts.network.WeakNetReportUtil
 * JD-Core Version:    0.7.0.1
 */