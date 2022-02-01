package com.tencent.tavkit.report;

import com.tencent.camerasdk.avreporter.BaseBean;
import com.tencent.camerasdk.avreporter.ReportKey;
import java.util.HashMap;
import java.util.Map;

final class CompositingReportSession$Bean
  extends BaseBean
{
  @ReportKey(name="ext_int1")
  private long avg_render_time_us = 0L;
  @ReportKey(name="ext_int2")
  private long render_count = 0L;
  @ReportKey(name="ext_int4")
  private int render_height = 0;
  @ReportKey(name="ext_int3")
  private int render_width = 0;
  
  public CompositingReportSession$Bean()
  {
    super("TAVKit_Android", "android_tavkit_compositing", "1.5.2.3-beta");
  }
  
  public Map<String, Long> toMap()
  {
    HashMap localHashMap = new HashMap();
    localHashMap.put("avg_render_time_us", Long.valueOf(this.avg_render_time_us));
    return localHashMap;
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("Bean{avg_render_time_us=");
    localStringBuilder.append(this.avg_render_time_us);
    localStringBuilder.append(", render_count=");
    localStringBuilder.append(this.render_count);
    localStringBuilder.append(", render_width=");
    localStringBuilder.append(this.render_width);
    localStringBuilder.append(", render_height=");
    localStringBuilder.append(this.render_height);
    localStringBuilder.append('}');
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.tavkit.report.CompositingReportSession.Bean
 * JD-Core Version:    0.7.0.1
 */