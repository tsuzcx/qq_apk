package com.tencent.tavkit.report;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.util.Log;
import com.tencent.camerasdk.avreporter.AVReportCenter;

public final class CompositingReportSession
{
  private static final int FLUSH_DURATION_THRESHOLD = 10;
  private static final String REPORT_EVENT = "android_tavkit_compositing";
  public static final String REPORT_KEY_AVG_RENDER_TIME_US = "avg_render_time_us";
  private static final String REPORT_SERVICE = "TAVKit_Android";
  private static final String REPORT_VERSION = "1.5.2.3-beta";
  private static final String TAG = "CompositingReportSessio";
  @Nullable
  private static CompositingReportSession.IReporter reporter;
  private long beginTimeMs = 0L;
  private int failureCount = 0;
  @NonNull
  private final CompositingReportSession.FilterChainReporter filterChainReporter;
  private float renderHeight;
  private float renderWidth;
  private int successCount = 0;
  private long totalCostUs = 0L;
  
  public CompositingReportSession(float paramFloat1, float paramFloat2)
  {
    this.renderWidth = paramFloat1;
    this.renderHeight = paramFloat2;
    this.filterChainReporter = new CompositingReportSession.FilterChainReporter(null);
    FilterChainReportSession.setReporter(this.filterChainReporter);
  }
  
  private void commit()
  {
    CompositingReportSession.Bean localBean = new CompositingReportSession.Bean();
    localBean.timestamp = Long.valueOf(this.beginTimeMs * 1000L);
    CompositingReportSession.Bean.access$102(localBean, this.totalCostUs / this.successCount);
    CompositingReportSession.Bean.access$202(localBean, this.successCount);
    CompositingReportSession.Bean.access$302(localBean, (int)this.renderHeight);
    CompositingReportSession.Bean.access$402(localBean, (int)this.renderWidth);
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("commit: bean = ");
    localStringBuilder.append(localBean);
    Log.d("CompositingReportSessio", localStringBuilder.toString());
    AVReportCenter.getInstance().commit(localBean, Boolean.valueOf(false));
    try
    {
      if (reporter != null) {
        reporter.onCommit(localBean.toMap(), CompositingReportSession.FilterChainReporter.access$500(this.filterChainReporter));
      }
      return;
    }
    finally {}
  }
  
  private void reset()
  {
    this.beginTimeMs = 0L;
    this.totalCostUs = 0L;
    this.successCount = 0;
  }
  
  public static void setReporter(@Nullable CompositingReportSession.IReporter paramIReporter)
  {
    try
    {
      reporter = paramIReporter;
      return;
    }
    finally
    {
      paramIReporter = finally;
      throw paramIReporter;
    }
  }
  
  public final void flush()
  {
    if (this.beginTimeMs == 0L) {
      return;
    }
    if (this.successCount >= 10) {
      commit();
    }
    reset();
  }
  
  public void tickFailed()
  {
    this.failureCount += 1;
  }
  
  public final void tickSuccess(long paramLong)
  {
    if (this.beginTimeMs == 0L) {
      this.beginTimeMs = (System.currentTimeMillis() - paramLong / 1000L / 1000L);
    }
    this.successCount += 1;
    this.totalCostUs += paramLong / 1000L;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.tavkit.report.CompositingReportSession
 * JD-Core Version:    0.7.0.1
 */