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
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("Bean{avg_read_sample_time_us=");
    localStringBuilder.append(this.avg_read_sample_time_us);
    localStringBuilder.append(", read_sample_count=");
    localStringBuilder.append(this.read_sample_count);
    localStringBuilder.append(", avg_render_time_us=");
    localStringBuilder.append(this.avg_render_time_us);
    localStringBuilder.append(", render_count=");
    localStringBuilder.append(this.render_count);
    localStringBuilder.append('}');
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.tav.report.PreviewReportSession.Bean
 * JD-Core Version:    0.7.0.1
 */