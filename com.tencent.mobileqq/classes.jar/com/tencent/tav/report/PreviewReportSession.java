package com.tencent.tav.report;

import android.util.Log;
import com.tencent.camerasdk.avreporter.AVReportCenter;

public final class PreviewReportSession
{
  private static final int FLUSH_DURATION_THRESHOLD = 10;
  private static final String TAG = "PreviewReportSession";
  private long beginTimeMs = 0L;
  private int frameCount = 0;
  private long totalReadCostUs = 0L;
  private long totalRenderCount = 0L;
  
  private void commit()
  {
    PreviewReportSession.Bean localBean = new PreviewReportSession.Bean();
    localBean.timestamp = Long.valueOf(this.beginTimeMs * 1000L);
    PreviewReportSession.Bean.access$002(localBean, this.totalReadCostUs / this.frameCount);
    PreviewReportSession.Bean.access$102(localBean, this.frameCount);
    PreviewReportSession.Bean.access$202(localBean, this.totalRenderCount / this.frameCount);
    PreviewReportSession.Bean.access$302(localBean, this.frameCount);
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("commit: bean = ");
    localStringBuilder.append(localBean);
    Log.d("PreviewReportSession", localStringBuilder.toString());
    AVReportCenter.getInstance().commit(localBean, Boolean.valueOf(false));
  }
  
  private void reset()
  {
    this.beginTimeMs = 0L;
    this.totalReadCostUs = 0L;
    this.totalRenderCount = 0L;
    this.frameCount = 0;
  }
  
  public final void flush()
  {
    if (this.beginTimeMs == 0L) {
      return;
    }
    if (this.frameCount >= 10) {
      commit();
    }
    reset();
  }
  
  public final void tickPreview(long paramLong1, long paramLong2)
  {
    if (this.beginTimeMs == 0L) {
      this.beginTimeMs = (System.currentTimeMillis() - paramLong1 / 1000L / 1000L);
    }
    this.frameCount += 1;
    this.totalReadCostUs += paramLong1 / 1000L;
    this.totalRenderCount += paramLong2 / 1000L;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.tav.report.PreviewReportSession
 * JD-Core Version:    0.7.0.1
 */