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
    super("TAVFoundation", "android_avfoundation_export", "1.1.-");
  }
  
  public String toString()
  {
    return "Bean{composite_time=" + this.composite_time + ", success=" + this.success + ", avg_render_time=" + this.avg_render_time + ", file_duration=" + this.file_duration + ", frame_per_second=" + this.frame_per_second + '}';
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.tav.report.ExportReportSession.Bean
 * JD-Core Version:    0.7.0.1
 */