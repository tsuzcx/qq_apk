package com.tencent.rmonitor.sla;

import android.os.Handler;
import android.text.TextUtils;
import com.tencent.rmonitor.base.meta.BaseInfo;
import com.tencent.rmonitor.base.meta.UrlMeta;
import com.tencent.rmonitor.common.logger.Logger;
import com.tencent.rmonitor.common.thread.ThreadManager;
import com.tencent.rmonitor.common.util.RMonitorUtil;
import java.net.URL;
import org.jetbrains.annotations.NotNull;

public class AttaReporter
{
  private static final AttaReporter a = new AttaReporter();
  @NotNull
  private Handler b = new Handler(ThreadManager.f());
  
  public static AttaReporter a()
  {
    return a;
  }
  
  public void a(String paramString, boolean paramBoolean, int paramInt, long paramLong)
  {
    throw new Runtime("d2j fail translate: java.lang.RuntimeException: can not merge I and Z\r\n\tat com.googlecode.dex2jar.ir.TypeClass.merge(TypeClass.java:100)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeRef.updateTypeClass(TypeTransformer.java:174)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.copyTypes(TypeTransformer.java:311)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.fixTypes(TypeTransformer.java:226)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.analyze(TypeTransformer.java:207)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer.transform(TypeTransformer.java:44)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.optimize(Dex2jar.java:162)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertCode(Dex2Asm.java:414)\r\n\tat com.googlecode.d2j.dex.ExDex2Asm.convertCode(ExDex2Asm.java:42)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.convertCode(Dex2jar.java:128)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertMethod(Dex2Asm.java:509)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertClass(Dex2Asm.java:406)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertDex(Dex2Asm.java:422)\r\n\tat com.googlecode.d2j.dex.Dex2jar.doTranslate(Dex2jar.java:172)\r\n\tat com.googlecode.d2j.dex.Dex2jar.to(Dex2jar.java:272)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.doCommandLine(Dex2jarCmd.java:108)\r\n\tat com.googlecode.dex2jar.tools.BaseCmd.doMain(BaseCmd.java:288)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.main(Dex2jarCmd.java:32)\r\n");
  }
  
  public boolean a(AttaParam paramAttaParam)
  {
    if (paramAttaParam == null) {
      paramAttaParam = "report fail for attaParam is null";
    }
    boolean bool;
    for (;;)
    {
      bool = false;
      break;
      if (TextUtils.equals(paramAttaParam.d, "RMSLALaunchEvent"))
      {
        paramAttaParam = "report fail for eventCode is RM_SLA_LAUNCH";
      }
      else if (!RMonitorUtil.a())
      {
        paramAttaParam = new StringBuilder();
        paramAttaParam.append("report fail for RMonitor not init yet. ");
        paramAttaParam.append(RMonitorUtil.b());
        paramAttaParam = paramAttaParam.toString();
      }
      else
      {
        try
        {
          paramAttaParam = new AttaReportTask(new URL(BaseInfo.urlMeta.getAttaUrl()), new AttaContentBuilder(paramAttaParam));
          this.b.post(paramAttaParam);
          paramAttaParam = null;
          bool = true;
        }
        catch (Throwable paramAttaParam)
        {
          paramAttaParam = paramAttaParam.getMessage();
        }
      }
    }
    if (!bool) {
      Logger.b.e(new String[] { "RMonitor_sla_AttaReporter", paramAttaParam });
    }
    return bool;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     com.tencent.rmonitor.sla.AttaReporter
 * JD-Core Version:    0.7.0.1
 */