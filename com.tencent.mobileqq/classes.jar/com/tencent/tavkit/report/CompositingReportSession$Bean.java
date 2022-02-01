package com.tencent.tavkit.report;

import com.tencent.camerasdk.avreporter.BaseBean;
import com.tencent.camerasdk.avreporter.ReportKey;
import java.util.HashMap;
import java.util.Map;

final class CompositingReportSession$Bean
  extends BaseBean
{
  @ReportKey(name="ext_int1")
  private long avgRenderTimeUs = 0L;
  @ReportKey(name="ext_int2")
  private long renderCount = 0L;
  @ReportKey(name="ext_int4")
  private int renderHeight = 0;
  @ReportKey(name="ext_int3")
  private int renderWidth = 0;
  
  public CompositingReportSession$Bean()
  {
    super("TAVKit_Android", "android_tavkit_compositing", "2.2.2.4");
  }
  
  public Map<String, Long> toMap()
  {
    HashMap localHashMap = new HashMap();
    localHashMap.put("avg_render_time_us", Long.valueOf(this.avgRenderTimeUs));
    return localHashMap;
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("Bean{avgRenderTimeUs=");
    localStringBuilder.append(this.avgRenderTimeUs);
    localStringBuilder.append(", renderCount=");
    localStringBuilder.append(this.renderCount);
    localStringBuilder.append(", renderWidth=");
    localStringBuilder.append(this.renderWidth);
    localStringBuilder.append(", renderHeight=");
    localStringBuilder.append(this.renderHeight);
    localStringBuilder.append('}');
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     com.tencent.tavkit.report.CompositingReportSession.Bean
 * JD-Core Version:    0.7.0.1
 */