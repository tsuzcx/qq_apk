package com.tencent.tav.report;

import com.tencent.camerasdk.avreporter.BaseBean;
import com.tencent.camerasdk.avreporter.ReportKey;

final class PreviewReportSession$Bean
  extends BaseBean
{
  @ReportKey(name="ext_int1")
  private long avg_read_sample_time_us = 0L;
  @ReportKey(name="ext_int3")
  private long avg_render_time_us = 0L;
  @ReportKey(name="ext_int2")
  private long read_sample_count = 0L;
  @ReportKey(name="ext_int4")
  private long render_count = 0L;
  
  public PreviewReportSession$Bean()
  {
    super("TAVFoundation", "android_avfoundation_preview", "1.1.-");
  }
  
  public String toString()
  {
    return "Bean{avg_read_sample_time_us=" + this.avg_read_sample_time_us + ", read_sample_count=" + this.read_sample_count + ", avg_render_time_us=" + this.avg_render_time_us + ", render_count=" + this.render_count + '}';
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.tav.report.PreviewReportSession.Bean
 * JD-Core Version:    0.7.0.1
 */