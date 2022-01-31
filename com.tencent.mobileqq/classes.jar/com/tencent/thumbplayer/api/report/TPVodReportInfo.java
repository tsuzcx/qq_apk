package com.tencent.thumbplayer.api.report;

public class TPVodReportInfo
  extends TPDefaultReportInfo
{
  public int bizId;
  public int clipCount;
  public int currentPlayState;
  public boolean hasSubtitles;
  public int optimizedPlay;
  public int videoStatus;
  
  public int getPlayType()
  {
    return 0;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.thumbplayer.api.report.TPVodReportInfo
 * JD-Core Version:    0.7.0.1
 */