package com.tencent.tav.report;

import com.tencent.camerasdk.avreporter.BaseBean;
import com.tencent.camerasdk.avreporter.ReportKey;

final class ExportReportSession$Bean
  extends BaseBean
{
  @ReportKey(name="ext_int3")
  private long avg_render_time = 0L;
  @ReportKey(name="ext_int1")
  private long composite_time = 0L;
  @ReportKey(name="ext_int4")
  private long file_duration = 0L;
  @ReportKey(name="ext_int5")
  private long frame_per_second = 0L;
  @ReportKey(name="ext_int2")
  private int success = 0;
  
  public ExportReportSession$Bean()
  {
    super("TAVFoundation", "android_avfoundation_export", "2.2.2.5");
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("Bean{composite_time=");
    localStringBuilder.append(this.composite_time);
    localStringBuilder.append(", success=");
    localStringBuilder.append(this.success);
    localStringBuilder.append(", avg_render_time=");
    localStringBuilder.append(this.avg_render_time);
    localStringBuilder.append(", file_duration=");
    localStringBuilder.append(this.file_duration);
    localStringBuilder.append(", frame_per_second=");
    localStringBuilder.append(this.frame_per_second);
    localStringBuilder.append('}');
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     com.tencent.tav.report.ExportReportSession.Bean
 * JD-Core Version:    0.7.0.1
 */