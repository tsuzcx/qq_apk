package com.tencent.mobileqq.kandian.repo.webarticle;

import com.tencent.mobileqq.kandian.biz.common.api.impl.PublicAccountReportUtils;
import com.tencent.mobileqq.webview.sonic.SonicClientImpl;
import com.tencent.qphone.base.util.QLog;
import com.tencent.sonic.sdk.SonicSession;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/mobileqq/kandian/repo/webarticle/RIJWebArticleReportUtil;", "", "()V", "KEY_PARAM_FOREGROUND_PRELOAD", "", "KEY_PARAM_HIT_PRELOAD", "KEY_PARAM_HIT_WEB_DATA_PRELOAD", "KEY_PARAM_IS_X5", "KEY_PARAM_LOAD_URL_OPTIMIZE", "KEY_PARAM_USE_PRELOAD", "KEY_PARAM_USE_WEB_DATA_PRELOAD", "KEY_PARAM_VAS_SONIC", "KEY_PARAM_WARMUP_TEMPLATE", "KEY_PARAM_WEBVIEW_POOL_REUSE", "REPORT_ACTION_WEB_ARTICLE_COST", "TAG", "reportWebArticle", "", "actionName", "r5Builder", "Lcom/tencent/mobileqq/kandian/repo/webarticle/RIJWebArticleReportUtil$ReportR5Builder;", "reportWebArticleDetailCost", "reportMap", "Ljava/util/HashMap;", "Lkotlin/collections/HashMap;", "sonicClientImpl", "Lcom/tencent/mobileqq/webview/sonic/SonicClientImpl;", "ReportR5Builder", "kandian_feature_impl_release"}, k=1, mv={1, 1, 16})
public final class RIJWebArticleReportUtil
{
  public static final RIJWebArticleReportUtil a = new RIJWebArticleReportUtil();
  
  public final void a(@NotNull String paramString, @NotNull RIJWebArticleReportUtil.ReportR5Builder paramReportR5Builder)
  {
    Intrinsics.checkParameterIsNotNull(paramString, "actionName");
    Intrinsics.checkParameterIsNotNull(paramReportR5Builder, "r5Builder");
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("[reportWebArticle] actionName = ");
    localStringBuilder.append(paramString);
    localStringBuilder.append(", r5 = ");
    localStringBuilder.append(paramReportR5Builder.a());
    QLog.i("RIJWebArticleReportUtil", 1, localStringBuilder.toString());
    PublicAccountReportUtils.a(null, "", paramString, paramString, 0, 0, "", "", "", paramReportR5Builder.a(), false);
  }
  
  public final void a(@NotNull HashMap<String, String> paramHashMap, @Nullable SonicClientImpl paramSonicClientImpl)
  {
    Intrinsics.checkParameterIsNotNull(paramHashMap, "reportMap");
    RIJWebArticleReportUtil.ReportR5Builder localReportR5Builder = new RIJWebArticleReportUtil.ReportR5Builder();
    paramHashMap = ((Map)paramHashMap).entrySet().iterator();
    while (paramHashMap.hasNext())
    {
      Map.Entry localEntry = (Map.Entry)paramHashMap.next();
      localReportR5Builder.a((String)localEntry.getKey(), (String)localEntry.getValue());
    }
    if (paramSonicClientImpl != null)
    {
      paramHashMap = paramSonicClientImpl.getSession();
      if ((paramHashMap != null) && (paramHashMap.isPreload() == true))
      {
        paramHashMap = "1";
        break label107;
      }
    }
    paramHashMap = "0";
    label107:
    localReportR5Builder.a("param_hitPreload", paramHashMap);
    a("0X800B4EF", localReportR5Builder);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.repo.webarticle.RIJWebArticleReportUtil
 * JD-Core Version:    0.7.0.1
 */