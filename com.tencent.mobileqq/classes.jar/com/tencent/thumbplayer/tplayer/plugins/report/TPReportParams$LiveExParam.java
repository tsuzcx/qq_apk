package com.tencent.thumbplayer.tplayer.plugins.report;

import org.json.JSONObject;

public class TPReportParams$LiveExParam
  implements ITPReportParams
{
  int adPlayLengthInt;
  int blockCountInt;
  int blockTimeInt;
  String cdnServerString;
  int connectTimeInt;
  int contentIdInt;
  String defSwitchString;
  int deviceTypeInt;
  int downSpeedInt;
  String downloadServerIpString;
  String downloadUrl;
  int errCodeInt;
  String extraInfoString;
  int freeTypeInt;
  String fullErrCodeString;
  int getStreamDurationInt;
  int getSyncFrameDurationInt;
  int getUrlTimeInt;
  int isLookBackInt;
  int isStreamP2PInt;
  int isUseP2PInt;
  int isUserPayInt;
  int liveDelayInt;
  int liveProgramIdInt;
  int liveTagInt;
  int liveTypeInt;
  long loadingTimeLong;
  int maxSpeedInt;
  int networkTypeInt;
  int playTimeInt;
  String playerVersionString;
  int prePlayLengthInt;
  int reconnectCntInt;
  long reportTimeLong;
  String spanId;
  int streamIdInt;
  int testSpeedInt;
  String tuid;
  String userIpString;
  String userQQString;
  
  public TPReportParams$LiveExParam(TPReportParams paramTPReportParams) {}
  
  public void paramsToJson(JSONObject paramJSONObject) {}
  
  public void paramsToProperties(ITPReportProperties paramITPReportProperties)
  {
    paramITPReportProperties.put("ftime", this.reportTimeLong);
    paramITPReportProperties.put("sip", this.userIpString);
    paramITPReportProperties.put("iqq", this.userQQString);
    paramITPReportProperties.put("prdlength", this.prePlayLengthInt);
    paramITPReportProperties.put("playad", this.adPlayLengthInt);
    paramITPReportProperties.put("fplayerver", this.playerVersionString);
    paramITPReportProperties.put("dsip", this.downloadServerIpString);
    paramITPReportProperties.put("devtype", this.deviceTypeInt);
    paramITPReportProperties.put("nettype", this.networkTypeInt);
    paramITPReportProperties.put("freetype", this.freeTypeInt);
    paramITPReportProperties.put("use_p2p", this.isUseP2PInt);
    paramITPReportProperties.put("p2p_play", this.isStreamP2PInt);
    paramITPReportProperties.put("livepid", this.liveProgramIdInt);
    paramITPReportProperties.put("sid", this.streamIdInt);
    paramITPReportProperties.put("contentid", this.contentIdInt);
    paramITPReportProperties.put("playtime", this.playTimeInt);
    paramITPReportProperties.put("isuserpay", this.isUserPayInt);
    paramITPReportProperties.put("switch", this.defSwitchString);
    paramITPReportProperties.put("live_type", this.liveTypeInt);
    paramITPReportProperties.put("xserverip", this.cdnServerString);
    paramITPReportProperties.put("durl", this.downloadUrl);
    paramITPReportProperties.put("lookback", this.isLookBackInt);
    paramITPReportProperties.put("live_delay", this.liveDelayInt);
    paramITPReportProperties.put("live_tag", this.liveTagInt);
    paramITPReportProperties.put("extraInfo", this.extraInfoString);
    paramITPReportProperties.put("cnntime", this.connectTimeInt);
    paramITPReportProperties.put("maxspeed", this.maxSpeedInt);
    paramITPReportProperties.put("testspeed", this.testSpeedInt);
    paramITPReportProperties.put("downspeed", this.downSpeedInt);
    paramITPReportProperties.put("recnncount", this.reconnectCntInt);
    paramITPReportProperties.put("loadingtime", this.loadingTimeLong);
    paramITPReportProperties.put("blocktime", this.blockTimeInt);
    paramITPReportProperties.put("blockcount", this.blockCountInt);
    paramITPReportProperties.put("errorcode", this.errCodeInt);
    paramITPReportProperties.put("geturltime", this.getUrlTimeInt);
    paramITPReportProperties.put("fullecode", this.fullErrCodeString);
    paramITPReportProperties.put("get_stream_data_duration", this.getStreamDurationInt);
    paramITPReportProperties.put("get_sync_frame_duration", this.getSyncFrameDurationInt);
    paramITPReportProperties.put("spanId", this.spanId);
    paramITPReportProperties.put("tuid", this.tuid);
  }
  
  public void reset() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.thumbplayer.tplayer.plugins.report.TPReportParams.LiveExParam
 * JD-Core Version:    0.7.0.1
 */