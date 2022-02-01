package com.tencent.mobileqq.kandian.biz.fastweb.util;

import android.content.Context;
import android.view.View;
import com.tencent.aladdin.config.Aladdin;
import com.tencent.aladdin.config.AladdinConfig;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.kandian.base.utils.RIJQQAppInterfaceUtil;
import com.tencent.mobileqq.kandian.biz.fastweb.FastWebActivity;
import com.tencent.mobileqq.kandian.glue.businesshandler.engine.ReadInJoyLogicEngine;
import com.tencent.mobileqq.kandian.glue.report.RIJTransMergeKanDianReport.ReportR5Builder;
import com.tencent.mobileqq.kandian.repo.aladdin.RIJArticleInteractBarAladdinConfig;
import com.tencent.mobileqq.kandian.repo.aladdin.RIJKanDianFastWebMutualShowTypeAladdinConfig;
import com.tencent.mobileqq.kandian.repo.feeds.ReadInJoyLogicEngineEventDispatcher;
import com.tencent.mobileqq.kandian.repo.feeds.entity.AbsBaseArticleInfo;
import com.tencent.mobileqq.kandian.repo.feeds.entity.FastWebArticleInfo;
import com.tencent.qphone.base.util.QLog;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

public class FastWebDislikeUtils
{
  public static void a(Context paramContext, AbsBaseArticleInfo paramAbsBaseArticleInfo, FastWebArticleInfo paramFastWebArticleInfo)
  {
    ThreadManager.executeOnSubThread(new FastWebDislikeUtils.1(paramAbsBaseArticleInfo, paramContext));
    a(paramAbsBaseArticleInfo, "0X80101DC");
  }
  
  public static void a(View paramView, AbsBaseArticleInfo paramAbsBaseArticleInfo, FastWebArticleInfo paramFastWebArticleInfo)
  {
    boolean bool = paramFastWebArticleInfo.h;
    int i = 1;
    if (bool)
    {
      paramFastWebArticleInfo.h = false;
      paramFastWebArticleInfo.f -= 1;
      ReportUtil.b(paramAbsBaseArticleInfo, "0X8009765", "2");
    }
    else
    {
      paramFastWebArticleInfo.h = true;
      paramFastWebArticleInfo.f += 1;
      ReportUtil.b(paramAbsBaseArticleInfo, "0X8009764", "2");
    }
    ReadInJoyLogicEngineEventDispatcher.a().e();
    ReadInJoyLogicEngine.a().a(RIJQQAppInterfaceUtil.c(), paramFastWebArticleInfo.h, paramFastWebArticleInfo);
    FastWebPTSUtils.a(paramView);
    paramView = RIJUniteReportUtils.a;
    if (!paramFastWebArticleInfo.h) {
      i = 3;
    }
    paramView.a(paramAbsBaseArticleInfo, 2, i);
  }
  
  public static void a(AbsBaseArticleInfo paramAbsBaseArticleInfo, FastWebArticleInfo paramFastWebArticleInfo, int paramInt)
  {
    throw new Runtime("d2j fail translate: java.lang.RuntimeException: can not merge I and Z\r\n\tat com.googlecode.dex2jar.ir.TypeClass.merge(TypeClass.java:100)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeRef.updateTypeClass(TypeTransformer.java:174)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.provideAs(TypeTransformer.java:780)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.e1expr(TypeTransformer.java:496)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:713)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:703)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.enexpr(TypeTransformer.java:698)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:719)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:703)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.enexpr(TypeTransformer.java:698)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:719)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:703)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.s1stmt(TypeTransformer.java:810)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.sxStmt(TypeTransformer.java:840)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.analyze(TypeTransformer.java:206)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer.transform(TypeTransformer.java:44)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.optimize(Dex2jar.java:162)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertCode(Dex2Asm.java:414)\r\n\tat com.googlecode.d2j.dex.ExDex2Asm.convertCode(ExDex2Asm.java:42)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.convertCode(Dex2jar.java:128)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertMethod(Dex2Asm.java:509)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertClass(Dex2Asm.java:406)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertDex(Dex2Asm.java:422)\r\n\tat com.googlecode.d2j.dex.Dex2jar.doTranslate(Dex2jar.java:172)\r\n\tat com.googlecode.d2j.dex.Dex2jar.to(Dex2jar.java:272)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.doCommandLine(Dex2jarCmd.java:108)\r\n\tat com.googlecode.dex2jar.tools.BaseCmd.doMain(BaseCmd.java:288)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.main(Dex2jarCmd.java:32)\r\n");
  }
  
  public static void a(AbsBaseArticleInfo paramAbsBaseArticleInfo, String paramString)
  {
    a(paramAbsBaseArticleInfo, paramString, null);
  }
  
  public static void a(AbsBaseArticleInfo paramAbsBaseArticleInfo, String paramString, Map<String, Object> paramMap)
  {
    if (paramAbsBaseArticleInfo == null) {
      return;
    }
    RIJTransMergeKanDianReport.ReportR5Builder localReportR5Builder = ReportUtil.a(paramAbsBaseArticleInfo);
    for (;;)
    {
      try
      {
        localReportR5Builder.addStringNotThrow("source_from", "2");
        localReportR5Builder.addIMEI();
        localReportR5Builder.addIMSI();
        localReportR5Builder.addNetworkType();
        localReportR5Builder.addAlgorithmId(paramAbsBaseArticleInfo.mAlgorithmID);
        localReportR5Builder.addStrategyID(paramAbsBaseArticleInfo.mStrategyId);
        AladdinConfig localAladdinConfig = Aladdin.getConfig(151);
        if (localAladdinConfig != null)
        {
          i = localAladdinConfig.getIntegerFromString("readinjoy_bottom_action_bar_business_id", -1);
          localReportR5Builder.addStringNotThrow("interact_style", localAladdinConfig.getIntegerFromString("readinjoy_bottom_action_bar_style", -1));
          localReportR5Builder.addStringNotThrow("businessID", i);
        }
        a(paramMap, localReportR5Builder);
        boolean bool = RIJArticleInteractBarAladdinConfig.a();
        int j = 0;
        if (bool)
        {
          i = 1;
          localReportR5Builder.addStringNotThrow("artical_interact_area", i);
          localReportR5Builder.addStringNotThrow("artical_interact_type", RIJKanDianFastWebMutualShowTypeAladdinConfig.a());
          if ((paramString.equals("0X80101DC")) || (paramString.equals("0X80100DB")))
          {
            i = j;
            if (RIJArticleInteractBarAladdinConfig.b()) {
              i = 1;
            }
            localReportR5Builder.addStringNotThrow("ad_relative_pos", i);
          }
          ReportUtil.a(paramAbsBaseArticleInfo, paramString, localReportR5Builder.build());
          return;
        }
      }
      catch (Exception paramAbsBaseArticleInfo)
      {
        paramString = new StringBuilder();
        paramString.append("report error! msg=");
        paramString.append(paramAbsBaseArticleInfo);
        QLog.d("FastWebDislikeUtils", 1, paramString.toString());
        return;
      }
      int i = 0;
    }
  }
  
  public static void a(Map<String, Object> paramMap, RIJTransMergeKanDianReport.ReportR5Builder paramReportR5Builder)
  {
    if (paramMap != null)
    {
      Iterator localIterator = paramMap.keySet().iterator();
      while (localIterator.hasNext())
      {
        String str = (String)localIterator.next();
        paramReportR5Builder.addValueSafe(str, paramMap.get(str));
      }
    }
  }
  
  public static void b(Context paramContext, AbsBaseArticleInfo paramAbsBaseArticleInfo, FastWebArticleInfo paramFastWebArticleInfo)
  {
    a(paramAbsBaseArticleInfo, "0X8009A5B");
    if ((paramContext instanceof FastWebActivity)) {
      ((FastWebActivity)paramContext).a(false, false);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.fastweb.util.FastWebDislikeUtils
 * JD-Core Version:    0.7.0.1
 */