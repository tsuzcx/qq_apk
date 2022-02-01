package com.tencent.thumbplayer.tplayer.plugins.report;

import java.util.ArrayList;

class TPReportManager$ParamRecord
{
  int bufferingCount = 0;
  int bufferingDurationMs = 0;
  String cdnIp = "";
  String cdnUip = "";
  String cdnUrl = "";
  String defId = "";
  long endBufferingTimeMs = 0L;
  long endPrepareTimeMs = 0L;
  int getSpeedCnt = 0;
  int hitDownloaded = -1;
  boolean isMultiTrack = false;
  boolean isSelectedSubtitle = false;
  boolean isSwitchingDef = false;
  int liveDelayMs = 0;
  int maxSpeed = 0;
  int playDurationMs = 0;
  String spanId = "";
  long startBufferingTimeMs = 0L;
  long startPlayTimeMs = 0L;
  long startPrepareTimeMs = 0L;
  ArrayList<TPReportManager.SubtitleInfo> subtitleInfos = new ArrayList();
  int totalSpeed = 0;
  String tuid = "";
  
  private TPReportManager$ParamRecord(TPReportManager paramTPReportManager) {}
  
  void reset()
  {
    this.startPlayTimeMs = 0L;
    this.playDurationMs = 0;
    this.startPrepareTimeMs = 0L;
    this.endPrepareTimeMs = 0L;
    this.bufferingCount = 0;
    this.bufferingDurationMs = 0;
    this.startBufferingTimeMs = 0L;
    this.endBufferingTimeMs = 0L;
    this.liveDelayMs = 0;
    this.maxSpeed = 0;
    this.totalSpeed = 0;
    this.getSpeedCnt = 0;
    this.isSelectedSubtitle = false;
    this.isMultiTrack = false;
    this.isSwitchingDef = false;
    this.hitDownloaded = -1;
    this.defId = "";
    this.cdnUrl = "";
    this.cdnIp = "";
    this.cdnUip = "";
    this.spanId = "";
    this.tuid = "";
    this.subtitleInfos.clear();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.thumbplayer.tplayer.plugins.report.TPReportManager.ParamRecord
 * JD-Core Version:    0.7.0.1
 */