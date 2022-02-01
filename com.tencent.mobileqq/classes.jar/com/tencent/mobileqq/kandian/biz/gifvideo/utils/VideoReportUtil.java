package com.tencent.mobileqq.kandian.biz.gifvideo.utils;

import android.text.TextUtils;
import com.tencent.biz.pubaccount.util.KotlinUtilKt;
import com.tencent.mobileqq.kandian.biz.common.api.impl.PublicAccountReportUtils;
import com.tencent.mobileqq.kandian.biz.fastweb.data.MiniAppData;
import com.tencent.mobileqq.kandian.biz.pts.data.Util;
import com.tencent.mobileqq.kandian.glue.report.RIJTransMergeKanDianReport;
import com.tencent.mobileqq.kandian.glue.report.RIJTransMergeKanDianReport.ReportR5Builder;
import com.tencent.mobileqq.kandian.repo.aladdin.handlers.DailyModeConfigHandler;
import com.tencent.mobileqq.kandian.repo.common.RIJItemViewTypeUtils;
import com.tencent.mobileqq.kandian.repo.feeds.entity.AbsBaseArticleInfo;
import com.tencent.qphone.base.util.QLog;
import kotlin.Metadata;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.json.JSONObject;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/mobileqq/kandian/biz/gifvideo/utils/VideoReportUtil;", "", "()V", "ACTION_NAME_MANUAL_STOP_PLAY", "", "ACTION_NAME_MUTE_BTN_CLICK", "ACTION_NAME_SPEED_RATIO_BTN_CLICK", "ACTION_NAME_WATCH_LATER", "TAG", "getBaseR5Builder", "Lcom/tencent/mobileqq/kandian/glue/report/RIJTransMergeKanDianReport$ReportR5Builder;", "miniAppData", "Lcom/tencent/mobileqq/kandian/biz/fastweb/data/MiniAppData;", "articleInfo", "Lcom/tencent/mobileqq/kandian/repo/feeds/entity/AbsBaseArticleInfo;", "currentDuration", "", "getReportIconLocation", "", "getVideoFromType", "getVideoType", "reportData", "", "toUin", "actionName", "r5", "reportManuallyPlayOrStopVideo", "stop", "", "reportMuteBtnClick", "isMute", "reportRatioBtnClick", "speedRatio", "", "reportWatchLaterBtnClick", "kandian_feature_impl_release"}, k=1, mv={1, 1, 16})
public final class VideoReportUtil
{
  public static final VideoReportUtil a = new VideoReportUtil();
  
  private final int c(AbsBaseArticleInfo paramAbsBaseArticleInfo)
  {
    if (RIJItemViewTypeUtils.E(paramAbsBaseArticleInfo)) {
      return 2;
    }
    if (RIJItemViewTypeUtils.F(paramAbsBaseArticleInfo)) {
      return 5;
    }
    return -1;
  }
  
  @Nullable
  public final RIJTransMergeKanDianReport.ReportR5Builder a(@Nullable MiniAppData paramMiniAppData)
  {
    if (paramMiniAppData != null)
    {
      RIJTransMergeKanDianReport.ReportR5Builder localReportR5Builder = RIJTransMergeKanDianReport.g();
      localReportR5Builder.addStringNotThrow("rowkey", paramMiniAppData.c);
      localReportR5Builder.addStringNotThrow("icon_location", 4);
      return localReportR5Builder;
    }
    return null;
  }
  
  @NotNull
  public final RIJTransMergeKanDianReport.ReportR5Builder a(@NotNull AbsBaseArticleInfo paramAbsBaseArticleInfo, long paramLong)
  {
    throw new Runtime("d2j fail translate: java.lang.RuntimeException: can not merge I and Z\r\n\tat com.googlecode.dex2jar.ir.TypeClass.merge(TypeClass.java:100)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeRef.updateTypeClass(TypeTransformer.java:174)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.provideAs(TypeTransformer.java:780)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.enexpr(TypeTransformer.java:659)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:719)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:703)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.enexpr(TypeTransformer.java:698)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:719)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:703)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.s1stmt(TypeTransformer.java:810)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.sxStmt(TypeTransformer.java:840)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.analyze(TypeTransformer.java:206)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer.transform(TypeTransformer.java:44)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.optimize(Dex2jar.java:162)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertCode(Dex2Asm.java:414)\r\n\tat com.googlecode.d2j.dex.ExDex2Asm.convertCode(ExDex2Asm.java:42)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.convertCode(Dex2jar.java:128)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertMethod(Dex2Asm.java:509)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertClass(Dex2Asm.java:406)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertDex(Dex2Asm.java:422)\r\n\tat com.googlecode.d2j.dex.Dex2jar.doTranslate(Dex2jar.java:172)\r\n\tat com.googlecode.d2j.dex.Dex2jar.to(Dex2jar.java:272)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.doCommandLine(Dex2jarCmd.java:108)\r\n\tat com.googlecode.dex2jar.tools.BaseCmd.doMain(BaseCmd.java:288)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.main(Dex2jarCmd.java:32)\r\n");
  }
  
  @NotNull
  public final String a(@NotNull AbsBaseArticleInfo paramAbsBaseArticleInfo)
  {
    Intrinsics.checkParameterIsNotNull(paramAbsBaseArticleInfo, "articleInfo");
    if (Util.f(paramAbsBaseArticleInfo)) {
      return "10";
    }
    return "6";
  }
  
  public final void a(@Nullable AbsBaseArticleInfo paramAbsBaseArticleInfo, long paramLong, float paramFloat)
  {
    if (paramAbsBaseArticleInfo != null)
    {
      Object localObject = a.a(paramAbsBaseArticleInfo, paramLong);
      if (Float.compare(paramFloat, 1.5F) == 0) {
        ((RIJTransMergeKanDianReport.ReportR5Builder)localObject).addStringNotThrow("video_speed", 1);
      } else if (Float.compare(paramFloat, 2.0F) == 0) {
        ((RIJTransMergeKanDianReport.ReportR5Builder)localObject).addStringNotThrow("video_speed", 2);
      } else if (Float.compare(paramFloat, 0.5F) == 0) {
        ((RIJTransMergeKanDianReport.ReportR5Builder)localObject).addStringNotThrow("video_speed", 3);
      } else {
        ((RIJTransMergeKanDianReport.ReportR5Builder)localObject).addStringNotThrow("video_speed", 0);
      }
      paramAbsBaseArticleInfo = a;
      localObject = ((RIJTransMergeKanDianReport.ReportR5Builder)localObject).toString();
      Intrinsics.checkExpressionValueIsNotNull(localObject, "r5Builder.toString()");
      paramAbsBaseArticleInfo.a("", "0X8009F42", (String)localObject);
    }
  }
  
  public final void a(@Nullable AbsBaseArticleInfo paramAbsBaseArticleInfo, long paramLong, @Nullable MiniAppData paramMiniAppData)
  {
    RIJTransMergeKanDianReport.ReportR5Builder localReportR5Builder = (RIJTransMergeKanDianReport.ReportR5Builder)null;
    if (paramMiniAppData != null)
    {
      paramMiniAppData = a(paramMiniAppData);
    }
    else
    {
      paramMiniAppData = localReportR5Builder;
      if (paramAbsBaseArticleInfo != null)
      {
        localReportR5Builder = a(paramAbsBaseArticleInfo, paramLong);
        localReportR5Builder.addStringNotThrow("icon_location", c(paramAbsBaseArticleInfo));
        paramMiniAppData = localReportR5Builder;
        if (!TextUtils.isEmpty((CharSequence)paramAbsBaseArticleInfo.videoReportInfo))
        {
          localReportR5Builder.addStringNotThrow("short_v", new JSONObject(paramAbsBaseArticleInfo.videoReportInfo).optInt("short_v"));
          paramMiniAppData = localReportR5Builder;
        }
      }
    }
    KotlinUtilKt.a(paramAbsBaseArticleInfo, paramMiniAppData, (Function2)VideoReportUtil.reportWatchLaterBtnClick.1.INSTANCE);
  }
  
  public final void a(@Nullable AbsBaseArticleInfo paramAbsBaseArticleInfo, long paramLong, boolean paramBoolean)
  {
    if (paramAbsBaseArticleInfo != null)
    {
      Object localObject = a.a(paramAbsBaseArticleInfo, paramLong);
      if (paramBoolean) {
        ((RIJTransMergeKanDianReport.ReportR5Builder)localObject).addStringNotThrow("mute_status", 1);
      } else {
        ((RIJTransMergeKanDianReport.ReportR5Builder)localObject).addStringNotThrow("mute_status", 2);
      }
      paramAbsBaseArticleInfo = a;
      localObject = ((RIJTransMergeKanDianReport.ReportR5Builder)localObject).toString();
      Intrinsics.checkExpressionValueIsNotNull(localObject, "r5Builder.toString()");
      paramAbsBaseArticleInfo.a("", "0X800740E", (String)localObject);
    }
  }
  
  public final void a(@NotNull String paramString1, @NotNull String paramString2, @NotNull String paramString3)
  {
    Intrinsics.checkParameterIsNotNull(paramString1, "toUin");
    Intrinsics.checkParameterIsNotNull(paramString2, "actionName");
    Intrinsics.checkParameterIsNotNull(paramString3, "r5");
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("[reportData] actionName = ");
    localStringBuilder.append(paramString2);
    localStringBuilder.append(", r5= ");
    localStringBuilder.append(paramString3);
    QLog.i("VideoReportUtil", 1, localStringBuilder.toString());
    PublicAccountReportUtils.a(null, paramString1, paramString2, paramString2, 0, 0, "", "", "", paramString3, false);
  }
  
  public final int b(@NotNull AbsBaseArticleInfo paramAbsBaseArticleInfo)
  {
    Intrinsics.checkParameterIsNotNull(paramAbsBaseArticleInfo, "articleInfo");
    int i = (int)paramAbsBaseArticleInfo.mChannelID;
    if (i == 0) {
      return 3;
    }
    if (i == DailyModeConfigHandler.j()) {
      return 24;
    }
    return -1;
  }
  
  public final void b(@Nullable AbsBaseArticleInfo paramAbsBaseArticleInfo, long paramLong, boolean paramBoolean)
  {
    if (paramAbsBaseArticleInfo != null)
    {
      Object localObject = a.a(paramAbsBaseArticleInfo, paramLong);
      if (paramBoolean) {
        ((RIJTransMergeKanDianReport.ReportR5Builder)localObject).addStringNotThrow("stop_status", 1);
      } else {
        ((RIJTransMergeKanDianReport.ReportR5Builder)localObject).addStringNotThrow("stop_status", 2);
      }
      paramAbsBaseArticleInfo = a;
      localObject = ((RIJTransMergeKanDianReport.ReportR5Builder)localObject).toString();
      Intrinsics.checkExpressionValueIsNotNull(localObject, "r5Builder.toString()");
      paramAbsBaseArticleInfo.a("", "0X800740D", (String)localObject);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.gifvideo.utils.VideoReportUtil
 * JD-Core Version:    0.7.0.1
 */