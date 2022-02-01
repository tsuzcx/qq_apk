package com.tencent.mobileqq.nearby.now.utils;

import com.tencent.biz.common.util.HttpUtil;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.qphone.base.util.QLog;

public class QualityReporter
{
  protected static long a = 0L;
  protected static long b = 0L;
  protected static long c = 0L;
  protected static long d = 0L;
  protected static long e = 0L;
  protected static long f = 0L;
  protected static int g = 0;
  protected static int h = 0;
  protected static String i = "";
  
  public static void a()
  {
    b = System.currentTimeMillis();
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("reportStartGetVideoInfoTime,time = ");
      localStringBuilder.append(b);
      QLog.i("QualityReporter", 2, localStringBuilder.toString());
    }
  }
  
  public static void a(int paramInt)
  {
    h = paramInt;
    a = 0L;
    b = 0L;
    c = 0L;
    e = 0L;
    f = 0L;
    g = 0;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(HttpUtil.getNetWorkType());
    localStringBuilder.append("");
    i = localStringBuilder.toString();
    a = System.currentTimeMillis();
    if (QLog.isColorLevel())
    {
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("reportEntryTime,time = ");
      localStringBuilder.append(a);
      QLog.i("QualityReporter", 2, localStringBuilder.toString());
    }
  }
  
  public static void a(String paramString, int paramInt)
  {
    if (QLog.isColorLevel())
    {
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("reportVideoLoad,time =  feedid = ");
      localStringBuilder.append(paramString);
      localStringBuilder.append(" loadingTime =");
      localStringBuilder.append(g);
      QLog.i("QualityReporter", 2, localStringBuilder.toString());
    }
    int j = g;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("||");
    localStringBuilder.append(paramString);
    localStringBuilder.append("|||");
    localStringBuilder.append(i);
    ReportController.b(null, "dc02676", "grp_lbs", paramString, "video_quality", "play_load_again", paramInt, 0, String.valueOf(j), "", "", localStringBuilder.toString());
  }
  
  public static void a(String paramString1, int paramInt, String paramString2, String paramString3)
  {
    if (QLog.isColorLevel())
    {
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("reportVideoPlayResult,time = feedid = ");
      localStringBuilder.append(paramString1);
      localStringBuilder.append(" playType=");
      localStringBuilder.append(paramInt);
      localStringBuilder.append(" errCode=");
      localStringBuilder.append(paramString2);
      localStringBuilder.append(" subErrCode=");
      localStringBuilder.append(paramString3);
      QLog.i("QualityReporter", 2, localStringBuilder.toString());
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("||");
    localStringBuilder.append(paramString1);
    localStringBuilder.append("|||");
    localStringBuilder.append(i);
    ReportController.b(null, "dc02676", "grp_lbs", paramString1, "video_quality", "play_result", paramInt, 0, paramString2, paramString3, "", localStringBuilder.toString());
  }
  
  public static void a(String paramString1, int paramInt, String paramString2, String paramString3, String paramString4, String paramString5, boolean paramBoolean)
  {
    throw new Runtime("d2j fail translate: java.lang.RuntimeException: can not merge Z and I\r\n\tat com.googlecode.dex2jar.ir.TypeClass.merge(TypeClass.java:100)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeRef.updateTypeClass(TypeTransformer.java:174)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.useAs(TypeTransformer.java:868)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.enexpr(TypeTransformer.java:668)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:719)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:703)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.s1stmt(TypeTransformer.java:810)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.sxStmt(TypeTransformer.java:840)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.analyze(TypeTransformer.java:206)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer.transform(TypeTransformer.java:44)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.optimize(Dex2jar.java:162)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertCode(Dex2Asm.java:414)\r\n\tat com.googlecode.d2j.dex.ExDex2Asm.convertCode(ExDex2Asm.java:42)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.convertCode(Dex2jar.java:128)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertMethod(Dex2Asm.java:509)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertClass(Dex2Asm.java:406)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertDex(Dex2Asm.java:422)\r\n\tat com.googlecode.d2j.dex.Dex2jar.doTranslate(Dex2jar.java:172)\r\n\tat com.googlecode.d2j.dex.Dex2jar.to(Dex2jar.java:272)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.doCommandLine(Dex2jarCmd.java:108)\r\n\tat com.googlecode.dex2jar.tools.BaseCmd.doMain(BaseCmd.java:288)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.main(Dex2jarCmd.java:32)\r\n");
  }
  
  public static void a(String paramString, int paramInt, boolean paramBoolean)
  {
    throw new Runtime("d2j fail translate: java.lang.RuntimeException: can not merge Z and I\r\n\tat com.googlecode.dex2jar.ir.TypeClass.merge(TypeClass.java:100)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeRef.updateTypeClass(TypeTransformer.java:174)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.useAs(TypeTransformer.java:868)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.enexpr(TypeTransformer.java:668)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:719)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:703)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.s1stmt(TypeTransformer.java:810)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.sxStmt(TypeTransformer.java:840)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.analyze(TypeTransformer.java:206)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer.transform(TypeTransformer.java:44)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.optimize(Dex2jar.java:162)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertCode(Dex2Asm.java:414)\r\n\tat com.googlecode.d2j.dex.ExDex2Asm.convertCode(ExDex2Asm.java:42)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.convertCode(Dex2jar.java:128)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertMethod(Dex2Asm.java:509)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertClass(Dex2Asm.java:406)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertDex(Dex2Asm.java:422)\r\n\tat com.googlecode.d2j.dex.Dex2jar.doTranslate(Dex2jar.java:172)\r\n\tat com.googlecode.d2j.dex.Dex2jar.to(Dex2jar.java:272)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.doCommandLine(Dex2jarCmd.java:108)\r\n\tat com.googlecode.dex2jar.tools.BaseCmd.doMain(BaseCmd.java:288)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.main(Dex2jarCmd.java:32)\r\n");
  }
  
  public static void b()
  {
    c = System.currentTimeMillis();
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("reportFinisGetVideoInfoTime,time = ");
      localStringBuilder.append(c);
      QLog.i("QualityReporter", 2, localStringBuilder.toString());
    }
  }
  
  public static void c()
  {
    d = System.currentTimeMillis();
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("reportUIInitFinishTime,time = ");
      localStringBuilder.append(d);
      QLog.i("QualityReporter", 2, localStringBuilder.toString());
    }
  }
  
  public static void d()
  {
    e = System.currentTimeMillis();
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("reportInitToPlayTime,time = ");
      localStringBuilder.append(e);
      QLog.i("QualityReporter", 2, localStringBuilder.toString());
    }
  }
  
  public static void e()
  {
    f = System.currentTimeMillis();
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("reportStartPlayTime,time = ");
      localStringBuilder.append(f);
      QLog.i("QualityReporter", 2, localStringBuilder.toString());
    }
  }
  
  public static void f()
  {
    g += 1;
  }
  
  public static long g()
  {
    return f - a;
  }
  
  public static long h()
  {
    return f - e;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.nearby.now.utils.QualityReporter
 * JD-Core Version:    0.7.0.1
 */