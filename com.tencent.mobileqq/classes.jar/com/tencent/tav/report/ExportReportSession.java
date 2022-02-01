package com.tencent.tav.report;

import android.util.Log;

public final class ExportReportSession
{
  private static final int FLUSH_DURATION_THRESHOLD = 10;
  private static final String TAG = "ExportReportSession";
  private long beginTimeMs = 0L;
  private long compositeTimeUs = 0L;
  private long exportStartTimeNs = 0L;
  private long fileDurationUs = 0L;
  private long framePerSecond = 0L;
  private boolean success = false;
  private int successCount = 0;
  private long totalCostUs = 0L;
  
  private void commit()
  {
    try
    {
      if ((this.beginTimeMs != 0L) && (this.exportStartTimeNs != 0L))
      {
        if (this.successCount >= 10) {
          doCommit();
        }
        reset();
        return;
      }
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("commit: 数据错误，beginTimeMs = ");
      localStringBuilder.append(this.beginTimeMs);
      localStringBuilder.append("， exportStartTimeNs = ");
      localStringBuilder.append(this.exportStartTimeNs);
      Log.e("ExportReportSession", localStringBuilder.toString());
      return;
    }
    finally {}
  }
  
  private void doCommit()
  {
    throw new Runtime("d2j fail translate: java.lang.RuntimeException: can not merge I and Z\r\n\tat com.googlecode.dex2jar.ir.TypeClass.merge(TypeClass.java:100)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeRef.updateTypeClass(TypeTransformer.java:174)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.provideAs(TypeTransformer.java:780)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.e1expr(TypeTransformer.java:496)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:713)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:703)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.enexpr(TypeTransformer.java:698)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:719)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:703)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.s1stmt(TypeTransformer.java:810)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.sxStmt(TypeTransformer.java:840)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.analyze(TypeTransformer.java:206)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer.transform(TypeTransformer.java:44)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.optimize(Dex2jar.java:162)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertCode(Dex2Asm.java:414)\r\n\tat com.googlecode.d2j.dex.ExDex2Asm.convertCode(ExDex2Asm.java:42)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.convertCode(Dex2jar.java:128)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertMethod(Dex2Asm.java:509)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertClass(Dex2Asm.java:406)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertDex(Dex2Asm.java:422)\r\n\tat com.googlecode.d2j.dex.Dex2jar.doTranslate(Dex2jar.java:172)\r\n\tat com.googlecode.d2j.dex.Dex2jar.to(Dex2jar.java:272)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.doCommandLine(Dex2jarCmd.java:108)\r\n\tat com.googlecode.dex2jar.tools.BaseCmd.doMain(BaseCmd.java:288)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.main(Dex2jarCmd.java:32)\r\n");
  }
  
  public void onExportError()
  {
    this.success = false;
    commit();
  }
  
  public void onExportStart(long paramLong)
  {
    this.exportStartTimeNs = paramLong;
    this.beginTimeMs = System.currentTimeMillis();
  }
  
  public void onExportSuccess()
  {
    if (this.exportStartTimeNs <= 0L)
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("onExportSuccess: 数据错误，exportStartTimeNs = ");
      localStringBuilder.append(this.exportStartTimeNs);
      Log.e("ExportReportSession", localStringBuilder.toString());
      return;
    }
    this.success = true;
    this.compositeTimeUs = ((System.nanoTime() - this.exportStartTimeNs) / 1000L);
    commit();
  }
  
  public void reset()
  {
    try
    {
      Log.d("ExportReportSession", "reset() called");
      this.compositeTimeUs = 0L;
      this.success = false;
      this.totalCostUs = 0L;
      this.successCount = 0;
      this.fileDurationUs = 0L;
      this.framePerSecond = 0L;
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public void setFileDurationUs(long paramLong)
  {
    this.fileDurationUs = paramLong;
  }
  
  public void setFramePerSecond(int paramInt)
  {
    this.framePerSecond = paramInt;
  }
  
  public final void tickExport(long paramLong)
  {
    this.successCount += 1;
    this.totalCostUs += paramLong / 1000L;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     com.tencent.tav.report.ExportReportSession
 * JD-Core Version:    0.7.0.1
 */