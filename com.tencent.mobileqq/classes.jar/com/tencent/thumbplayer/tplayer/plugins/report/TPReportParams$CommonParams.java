package com.tencent.thumbplayer.tplayer.plugins.report;

import org.json.JSONObject;

public class TPReportParams$CommonParams
  implements ITPReportParams
{
  public String appVersionString;
  public int cdnIdInt;
  public String cdnIpString;
  public String cdnUipString;
  public int configIdInt;
  public String deviceNameString;
  public String deviceResolutionString;
  public int downloadTypeInt;
  public String flowIdString;
  public String guidString;
  public int loginTypeInt;
  public float mediaDurationFloat;
  public int mediaFormatInt;
  public int mediaRateInt;
  public String mediaResolutionString;
  public int networkSpeedInt;
  public int networkTypeInt;
  public int onlineInt;
  public String osVersionString;
  public int p2pInt;
  public String p2pVersionString;
  public long platformLong;
  public String playNoString;
  public int playTypeInt;
  public int playerTypeInt;
  public String playerVersionString;
  public String qqOpenIdString;
  public int scenesId;
  public int seqInt = 0;
  public int signalStrengthInt;
  public int stepInt;
  public int testIdInt;
  public String uinString;
  public String uipString;
  public String vidString;
  public String wxOpenIdString;
  
  public TPReportParams$CommonParams(TPReportParams paramTPReportParams) {}
  
  public void paramsToJson(JSONObject paramJSONObject) {}
  
  public void paramsToProperties(ITPReportProperties paramITPReportProperties)
  {
    paramITPReportProperties.put("step", this.stepInt);
    paramITPReportProperties.put("seq", this.seqInt);
    paramITPReportProperties.put("platform", this.platformLong);
    paramITPReportProperties.put("flowid", this.flowIdString);
    paramITPReportProperties.put("playno", this.playNoString);
    paramITPReportProperties.put("uin", this.uinString);
    paramITPReportProperties.put("QQopenid", this.qqOpenIdString);
    paramITPReportProperties.put("WXopenid", this.wxOpenIdString);
    paramITPReportProperties.put("logintype", this.loginTypeInt);
    paramITPReportProperties.put("guid", this.guidString);
    paramITPReportProperties.put("uip", this.uipString);
    paramITPReportProperties.put("cdnuip", this.cdnUipString);
    paramITPReportProperties.put("cdnip", this.cdnIpString);
    paramITPReportProperties.put("online", this.onlineInt);
    paramITPReportProperties.put("p2p", this.p2pInt);
    paramITPReportProperties.put("sstrength", this.signalStrengthInt);
    paramITPReportProperties.put("network", this.networkTypeInt);
    paramITPReportProperties.put("speed", this.networkSpeedInt);
    paramITPReportProperties.put("device", this.deviceNameString);
    paramITPReportProperties.put("resolution", this.deviceResolutionString);
    paramITPReportProperties.put("testid", this.testIdInt);
    paramITPReportProperties.put("osver", this.osVersionString);
    paramITPReportProperties.put("p2pver", this.p2pVersionString);
    paramITPReportProperties.put("appver", this.appVersionString);
    paramITPReportProperties.put("playerver", this.playerVersionString);
    paramITPReportProperties.put("playertype", this.playTypeInt);
    paramITPReportProperties.put("confid", this.configIdInt);
    paramITPReportProperties.put("cdnid", this.cdnIdInt);
    paramITPReportProperties.put("scenesid", this.scenesId);
    paramITPReportProperties.put("playtype", this.playerTypeInt);
    paramITPReportProperties.put("dltype", this.downloadTypeInt);
    paramITPReportProperties.put("vid", this.vidString);
    paramITPReportProperties.put("definition", this.mediaResolutionString);
    paramITPReportProperties.put("fmt", this.mediaFormatInt);
    paramITPReportProperties.put("rate", this.mediaRateInt);
    paramITPReportProperties.put("duration", this.mediaDurationFloat);
  }
  
  public void reset()
  {
    this.stepInt = 0;
    this.seqInt = 0;
    this.platformLong = 0L;
    this.flowIdString = "";
    this.playNoString = "";
    this.uinString = "";
    this.qqOpenIdString = "";
    this.wxOpenIdString = "";
    this.loginTypeInt = 0;
    this.guidString = "";
    this.uipString = "";
    this.cdnUipString = "";
    this.cdnIpString = "";
    this.onlineInt = 0;
    this.p2pInt = 0;
    this.signalStrengthInt = 0;
    this.networkTypeInt = 0;
    this.networkSpeedInt = 0;
    this.deviceNameString = "";
    this.deviceResolutionString = "";
    this.testIdInt = 0;
    this.osVersionString = "";
    this.p2pVersionString = "";
    this.appVersionString = "";
    this.playerVersionString = "";
    this.playerTypeInt = 0;
    this.configIdInt = 0;
    this.cdnIdInt = 0;
    this.scenesId = 0;
    this.downloadTypeInt = 0;
    this.vidString = "";
    this.mediaResolutionString = "";
    this.mediaFormatInt = 0;
    this.mediaRateInt = 0;
    this.mediaDurationFloat = 0.0F;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.thumbplayer.tplayer.plugins.report.TPReportParams.CommonParams
 * JD-Core Version:    0.7.0.1
 */