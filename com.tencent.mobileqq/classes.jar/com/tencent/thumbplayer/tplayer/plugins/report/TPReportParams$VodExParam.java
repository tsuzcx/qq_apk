package com.tencent.thumbplayer.tplayer.plugins.report;

import org.json.JSONObject;

public class TPReportParams$VodExParam
  implements ITPReportParams
{
  int bizIdInt;
  int clipInt;
  int currentPlayInt;
  int freeTypeInt;
  int hasSubtitleInt;
  int hevcLcInt;
  int hitDownloaded;
  int isSelectedSubtitleInt;
  int multiTrackInt;
  int optimizedPlayInt;
  int statusInt;
  
  public TPReportParams$VodExParam(TPReportParams paramTPReportParams) {}
  
  public void paramsToJson(JSONObject paramJSONObject) {}
  
  public void paramsToProperties(ITPReportProperties paramITPReportProperties)
  {
    paramITPReportProperties.put("freetype", this.freeTypeInt);
    paramITPReportProperties.put("currentplay", this.currentPlayInt);
    paramITPReportProperties.put("optimizedplay", this.optimizedPlayInt);
    paramITPReportProperties.put("subtitles", this.hasSubtitleInt);
    paramITPReportProperties.put("selsubtitles", this.isSelectedSubtitleInt);
    paramITPReportProperties.put("multitrack", this.multiTrackInt);
    paramITPReportProperties.put("bizid", this.bizIdInt);
    paramITPReportProperties.put("hevclv", this.hevcLcInt);
    paramITPReportProperties.put("clip", this.clipInt);
    paramITPReportProperties.put("status", this.statusInt);
    paramITPReportProperties.put("hitdownloaded", this.hitDownloaded);
  }
  
  public void reset() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.thumbplayer.tplayer.plugins.report.TPReportParams.VodExParam
 * JD-Core Version:    0.7.0.1
 */