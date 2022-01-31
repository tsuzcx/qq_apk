package com.tencent.qqlive.tvkplayer.vinfo.vod;

import java.util.Map;

public class TVKCGIVInfoRequestParams
{
  private String appVer;
  private Map<String, String> ckeyExtraParamsMap;
  private int dlType;
  private int drm;
  private int encryptVer;
  private Map<String, String> extraParamsMap;
  private String fd;
  private String format;
  private String guid;
  private int ipstack;
  private int isCharge;
  private String loginCookie;
  private int networkType;
  private TVKCGIVInfoRequestParams.OpenApiParam openApiParam;
  private int platForm;
  private int playerCapacity;
  private String requestID;
  private int requestType;
  private String sdtFrom;
  private String uin;
  private String upc;
  private boolean useIpV6Dns;
  private String vid;
  private String wxOpenId;
  
  public TVKCGIVInfoRequestParams(TVKCGIVInfoRequestParams.TVKCGIVInfoRequestParasBuilder paramTVKCGIVInfoRequestParasBuilder)
  {
    this.vid = TVKCGIVInfoRequestParams.TVKCGIVInfoRequestParasBuilder.access$000(paramTVKCGIVInfoRequestParasBuilder);
    this.uin = TVKCGIVInfoRequestParams.TVKCGIVInfoRequestParasBuilder.access$100(paramTVKCGIVInfoRequestParasBuilder);
    this.ipstack = TVKCGIVInfoRequestParams.TVKCGIVInfoRequestParasBuilder.access$200(paramTVKCGIVInfoRequestParasBuilder);
    this.dlType = TVKCGIVInfoRequestParams.TVKCGIVInfoRequestParasBuilder.access$300(paramTVKCGIVInfoRequestParasBuilder);
    this.isCharge = TVKCGIVInfoRequestParams.TVKCGIVInfoRequestParasBuilder.access$400(paramTVKCGIVInfoRequestParasBuilder);
    this.drm = TVKCGIVInfoRequestParams.TVKCGIVInfoRequestParasBuilder.access$500(paramTVKCGIVInfoRequestParasBuilder);
    this.ckeyExtraParamsMap = TVKCGIVInfoRequestParams.TVKCGIVInfoRequestParasBuilder.access$600(paramTVKCGIVInfoRequestParasBuilder);
    this.extraParamsMap = TVKCGIVInfoRequestParams.TVKCGIVInfoRequestParasBuilder.access$700(paramTVKCGIVInfoRequestParasBuilder);
    this.openApiParam = TVKCGIVInfoRequestParams.TVKCGIVInfoRequestParasBuilder.access$800(paramTVKCGIVInfoRequestParasBuilder);
    this.format = TVKCGIVInfoRequestParams.TVKCGIVInfoRequestParasBuilder.access$900(paramTVKCGIVInfoRequestParasBuilder);
    this.loginCookie = TVKCGIVInfoRequestParams.TVKCGIVInfoRequestParasBuilder.access$1000(paramTVKCGIVInfoRequestParasBuilder);
    this.platForm = TVKCGIVInfoRequestParams.TVKCGIVInfoRequestParasBuilder.access$1100(paramTVKCGIVInfoRequestParasBuilder);
    this.sdtFrom = TVKCGIVInfoRequestParams.TVKCGIVInfoRequestParasBuilder.access$1200(paramTVKCGIVInfoRequestParasBuilder);
    this.fd = TVKCGIVInfoRequestParams.TVKCGIVInfoRequestParasBuilder.access$1300(paramTVKCGIVInfoRequestParasBuilder);
    this.requestType = TVKCGIVInfoRequestParams.TVKCGIVInfoRequestParasBuilder.access$1400(paramTVKCGIVInfoRequestParasBuilder);
    this.requestID = TVKCGIVInfoRequestParams.TVKCGIVInfoRequestParasBuilder.access$1500(paramTVKCGIVInfoRequestParasBuilder);
    this.playerCapacity = TVKCGIVInfoRequestParams.TVKCGIVInfoRequestParasBuilder.access$1600(paramTVKCGIVInfoRequestParasBuilder);
    this.upc = TVKCGIVInfoRequestParams.TVKCGIVInfoRequestParasBuilder.access$1700(paramTVKCGIVInfoRequestParasBuilder);
    this.appVer = TVKCGIVInfoRequestParams.TVKCGIVInfoRequestParasBuilder.access$1800(paramTVKCGIVInfoRequestParasBuilder);
    this.encryptVer = TVKCGIVInfoRequestParams.TVKCGIVInfoRequestParasBuilder.access$1900(paramTVKCGIVInfoRequestParasBuilder);
    this.networkType = TVKCGIVInfoRequestParams.TVKCGIVInfoRequestParasBuilder.access$2000(paramTVKCGIVInfoRequestParasBuilder);
    this.wxOpenId = TVKCGIVInfoRequestParams.TVKCGIVInfoRequestParasBuilder.access$2100(paramTVKCGIVInfoRequestParasBuilder);
    this.guid = TVKCGIVInfoRequestParams.TVKCGIVInfoRequestParasBuilder.access$2200(paramTVKCGIVInfoRequestParasBuilder);
    this.useIpV6Dns = TVKCGIVInfoRequestParams.TVKCGIVInfoRequestParasBuilder.access$2300(paramTVKCGIVInfoRequestParasBuilder);
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
  
  public int getDrm()
  {
    return this.drm;
  }
  
  public int getEncrypVer()
  {
    return this.encryptVer;
  }
  
  public Map<String, String> getExtraParamsMap()
  {
    return this.extraParamsMap;
  }
  
  public String getFd()
  {
    return this.fd;
  }
  
  public String getFormat()
  {
    return this.format;
  }
  
  public String getGuid()
  {
    return this.guid;
  }
  
  public String getLoginCookie()
  {
    return this.loginCookie;
  }
  
  public int getNetworkType()
  {
    return this.networkType;
  }
  
  public TVKCGIVInfoRequestParams.OpenApiParam getOpenApiParam()
  {
    return this.openApiParam;
  }
  
  public int getPlatForm()
  {
    return this.platForm;
  }
  
  public int getPlayerCapacity()
  {
    return this.playerCapacity;
  }
  
  public String getRequestID()
  {
    return this.requestID;
  }
  
  public int getRequestType()
  {
    return this.requestType;
  }
  
  public String getSdtFrom()
  {
    return this.sdtFrom;
  }
  
  public String getUin()
  {
    return this.uin;
  }
  
  public String getUpc()
  {
    return this.upc;
  }
  
  public String getVid()
  {
    return this.vid;
  }
  
  public String getWxOpenId()
  {
    return this.wxOpenId;
  }
  
  public int getipstack()
  {
    return this.ipstack;
  }
  
  public int isCharge()
  {
    return this.isCharge;
  }
  
  public boolean useIpV6Dns()
  {
    return this.useIpV6Dns;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.qqlive.tvkplayer.vinfo.vod.TVKCGIVInfoRequestParams
 * JD-Core Version:    0.7.0.1
 */