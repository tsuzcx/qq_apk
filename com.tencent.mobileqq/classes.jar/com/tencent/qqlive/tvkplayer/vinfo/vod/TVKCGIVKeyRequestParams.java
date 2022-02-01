package com.tencent.qqlive.tvkplayer.vinfo.vod;

import java.util.Map;

public class TVKCGIVKeyRequestParams
{
  private String appVer;
  private Map<String, String> ckeyExtraParamsMap;
  private int dlType;
  private int encryptVer;
  private int endClipNo;
  private Map<String, String> extraParamsMap;
  private String fd;
  private String fileName;
  private String format;
  private int formatId;
  private String guid;
  private int isCharge;
  private boolean isDrm;
  private String lnk;
  private String loginCookie;
  private String loginQQ;
  private int networkType;
  private TVKCGIVKeyRequestParams.OpenApiParam openApiParam;
  private int platForm;
  private String requestID;
  private int requestType;
  private int requestUrlTargetType;
  private String sdtFrom;
  private int startClipNo;
  private int taskID;
  private String uin;
  private String upc;
  private String upcPaths;
  private String upcSPIPs;
  private String upcSPPORTs;
  private boolean useIpV6Dns;
  private String vid;
  private int vkeyType;
  private String vt;
  private String wxOpenId;
  
  public TVKCGIVKeyRequestParams(TVKCGIVKeyRequestParams.VKeyRequestParasBuilder paramVKeyRequestParasBuilder)
  {
    this.vid = TVKCGIVKeyRequestParams.VKeyRequestParasBuilder.access$000(paramVKeyRequestParasBuilder);
    this.uin = TVKCGIVKeyRequestParams.VKeyRequestParasBuilder.access$100(paramVKeyRequestParasBuilder);
    this.dlType = TVKCGIVKeyRequestParams.VKeyRequestParasBuilder.access$200(paramVKeyRequestParasBuilder);
    this.isCharge = TVKCGIVKeyRequestParams.VKeyRequestParasBuilder.access$300(paramVKeyRequestParasBuilder);
    this.isDrm = TVKCGIVKeyRequestParams.VKeyRequestParasBuilder.access$400(paramVKeyRequestParasBuilder);
    this.ckeyExtraParamsMap = TVKCGIVKeyRequestParams.VKeyRequestParasBuilder.access$500(paramVKeyRequestParasBuilder);
    this.extraParamsMap = TVKCGIVKeyRequestParams.VKeyRequestParasBuilder.access$600(paramVKeyRequestParasBuilder);
    this.openApiParam = TVKCGIVKeyRequestParams.VKeyRequestParasBuilder.access$700(paramVKeyRequestParasBuilder);
    this.upc = TVKCGIVKeyRequestParams.VKeyRequestParasBuilder.access$800(paramVKeyRequestParasBuilder);
    this.upcPaths = TVKCGIVKeyRequestParams.VKeyRequestParasBuilder.access$900(paramVKeyRequestParasBuilder);
    this.upcSPIPs = TVKCGIVKeyRequestParams.VKeyRequestParasBuilder.access$1000(paramVKeyRequestParasBuilder);
    this.upcSPPORTs = TVKCGIVKeyRequestParams.VKeyRequestParasBuilder.access$1100(paramVKeyRequestParasBuilder);
    this.format = TVKCGIVKeyRequestParams.VKeyRequestParasBuilder.access$1200(paramVKeyRequestParasBuilder);
    this.loginCookie = TVKCGIVKeyRequestParams.VKeyRequestParasBuilder.access$1300(paramVKeyRequestParasBuilder);
    this.requestUrlTargetType = TVKCGIVKeyRequestParams.VKeyRequestParasBuilder.access$1400(paramVKeyRequestParasBuilder);
    this.fileName = TVKCGIVKeyRequestParams.VKeyRequestParasBuilder.access$1500(paramVKeyRequestParasBuilder);
    this.formatId = TVKCGIVKeyRequestParams.VKeyRequestParasBuilder.access$1600(paramVKeyRequestParasBuilder);
    this.vt = TVKCGIVKeyRequestParams.VKeyRequestParasBuilder.access$1700(paramVKeyRequestParasBuilder);
    this.startClipNo = TVKCGIVKeyRequestParams.VKeyRequestParasBuilder.access$1800(paramVKeyRequestParasBuilder);
    this.endClipNo = TVKCGIVKeyRequestParams.VKeyRequestParasBuilder.access$1900(paramVKeyRequestParasBuilder);
    this.requestType = TVKCGIVKeyRequestParams.VKeyRequestParasBuilder.access$2000(paramVKeyRequestParasBuilder);
    this.vkeyType = TVKCGIVKeyRequestParams.VKeyRequestParasBuilder.access$2100(paramVKeyRequestParasBuilder);
    this.sdtFrom = TVKCGIVKeyRequestParams.VKeyRequestParasBuilder.access$2200(paramVKeyRequestParasBuilder);
    this.fd = TVKCGIVKeyRequestParams.VKeyRequestParasBuilder.access$2300(paramVKeyRequestParasBuilder);
    this.requestID = TVKCGIVKeyRequestParams.VKeyRequestParasBuilder.access$2400(paramVKeyRequestParasBuilder);
    this.lnk = TVKCGIVKeyRequestParams.VKeyRequestParasBuilder.access$2500(paramVKeyRequestParasBuilder);
    this.taskID = TVKCGIVKeyRequestParams.VKeyRequestParasBuilder.access$2600(paramVKeyRequestParasBuilder);
    this.platForm = TVKCGIVKeyRequestParams.VKeyRequestParasBuilder.access$2700(paramVKeyRequestParasBuilder);
    this.appVer = TVKCGIVKeyRequestParams.VKeyRequestParasBuilder.access$2800(paramVKeyRequestParasBuilder);
    this.networkType = TVKCGIVKeyRequestParams.VKeyRequestParasBuilder.access$2900(paramVKeyRequestParasBuilder);
    this.encryptVer = TVKCGIVKeyRequestParams.VKeyRequestParasBuilder.access$3000(paramVKeyRequestParasBuilder);
    this.loginQQ = TVKCGIVKeyRequestParams.VKeyRequestParasBuilder.access$3100(paramVKeyRequestParasBuilder);
    this.wxOpenId = TVKCGIVKeyRequestParams.VKeyRequestParasBuilder.access$3200(paramVKeyRequestParasBuilder);
    this.guid = TVKCGIVKeyRequestParams.VKeyRequestParasBuilder.access$3300(paramVKeyRequestParasBuilder);
    this.useIpV6Dns = TVKCGIVKeyRequestParams.VKeyRequestParasBuilder.access$3400(paramVKeyRequestParasBuilder);
  }
  
  public String getAppVer()
  {
    return this.appVer;
  }
  
  public Map<String, String> getCkeyExtraParamsMap()
  {
    return this.ckeyExtraParamsMap;
  }
  
  public int getDlType()
  {
    return this.dlType;
  }
  
  public int getDltype()
  {
    return this.dlType;
  }
  
  public int getEncryptVer()
  {
    return this.encryptVer;
  }
  
  public int getEndClipNo()
  {
    return this.endClipNo;
  }
  
  public Map<String, String> getExtraParamsMap()
  {
    return this.extraParamsMap;
  }
  
  public String getFd()
  {
    return this.fd;
  }
  
  public String getFileName()
  {
    return this.fileName;
  }
  
  public String getFormat()
  {
    return this.format;
  }
  
  public int getFormatId()
  {
    return this.formatId;
  }
  
  public String getGuid()
  {
    return this.guid;
  }
  
  public String getLnk()
  {
    return this.lnk;
  }
  
  public String getLoginCookie()
  {
    return this.loginCookie;
  }
  
  public String getLoginQQ()
  {
    return this.loginQQ;
  }
  
  public int getNetworkType()
  {
    return this.networkType;
  }
  
  public TVKCGIVKeyRequestParams.OpenApiParam getOpenApiParam()
  {
    return this.openApiParam;
  }
  
  public int getPlatForm()
  {
    return this.platForm;
  }
  
  public String getRequestID()
  {
    return this.requestID;
  }
  
  public int getRequestType()
  {
    return this.requestType;
  }
  
  public int getRequestUrlTargetType()
  {
    return this.requestUrlTargetType;
  }
  
  public String getSdtFrom()
  {
    return this.sdtFrom;
  }
  
  public int getStartClipNo()
  {
    return this.startClipNo;
  }
  
  public int getTaskID()
  {
    return this.taskID;
  }
  
  public String getUin()
  {
    return this.uin;
  }
  
  public String getUpc()
  {
    return this.upc;
  }
  
  public String getUpcPaths()
  {
    return this.upcPaths;
  }
  
  public String getUpcSPIPs()
  {
    return this.upcSPIPs;
  }
  
  public String getUpcSPPORTs()
  {
    return this.upcSPPORTs;
  }
  
  public String getVid()
  {
    return this.vid;
  }
  
  public int getVkeyType()
  {
    return this.vkeyType;
  }
  
  public String getVt()
  {
    return this.vt;
  }
  
  public String getWxOpenId()
  {
    return this.wxOpenId;
  }
  
  public int isCharge()
  {
    return this.isCharge;
  }
  
  public boolean isDrm()
  {
    return this.isDrm;
  }
  
  public boolean isUseIpV6Dns()
  {
    return this.useIpV6Dns;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     com.tencent.qqlive.tvkplayer.vinfo.vod.TVKCGIVKeyRequestParams
 * JD-Core Version:    0.7.0.1
 */