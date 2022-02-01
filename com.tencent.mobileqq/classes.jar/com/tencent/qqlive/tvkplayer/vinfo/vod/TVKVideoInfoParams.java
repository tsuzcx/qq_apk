package com.tencent.qqlive.tvkplayer.vinfo.vod;

import java.util.Map;

public class TVKVideoInfoParams
{
  private String appVer;
  private Map<String, String> ckeyExtraParamsMap;
  private int dlType;
  private int drm;
  private int encryptVer;
  private Map<String, String> extraParamsMap;
  private String format;
  private String guid;
  private int ipstack;
  private int isCharge;
  private String loginCookie;
  private String loginQQ;
  private int networkType;
  private TVKVideoInfoParams.OpenApiParam openApiParam;
  private int platForm;
  private int playerCapacity;
  private int requestType;
  private String sdtFrom;
  private String uin;
  private String upc;
  private String vid;
  private String wxOpenId;
  
  public TVKVideoInfoParams(TVKVideoInfoParams.TVKVInfoRequestParasBuilder paramTVKVInfoRequestParasBuilder)
  {
    this.vid = TVKVideoInfoParams.TVKVInfoRequestParasBuilder.access$000(paramTVKVInfoRequestParasBuilder);
    this.uin = TVKVideoInfoParams.TVKVInfoRequestParasBuilder.access$100(paramTVKVInfoRequestParasBuilder);
    this.ipstack = TVKVideoInfoParams.TVKVInfoRequestParasBuilder.access$200(paramTVKVInfoRequestParasBuilder);
    this.dlType = TVKVideoInfoParams.TVKVInfoRequestParasBuilder.access$300(paramTVKVInfoRequestParasBuilder);
    this.isCharge = TVKVideoInfoParams.TVKVInfoRequestParasBuilder.access$400(paramTVKVInfoRequestParasBuilder);
    this.drm = TVKVideoInfoParams.TVKVInfoRequestParasBuilder.access$500(paramTVKVInfoRequestParasBuilder);
    this.ckeyExtraParamsMap = TVKVideoInfoParams.TVKVInfoRequestParasBuilder.access$600(paramTVKVInfoRequestParasBuilder);
    this.extraParamsMap = TVKVideoInfoParams.TVKVInfoRequestParasBuilder.access$700(paramTVKVInfoRequestParasBuilder);
    this.openApiParam = TVKVideoInfoParams.TVKVInfoRequestParasBuilder.access$800(paramTVKVInfoRequestParasBuilder);
    this.format = TVKVideoInfoParams.TVKVInfoRequestParasBuilder.access$900(paramTVKVInfoRequestParasBuilder);
    this.loginCookie = TVKVideoInfoParams.TVKVInfoRequestParasBuilder.access$1000(paramTVKVInfoRequestParasBuilder);
    this.sdtFrom = TVKVideoInfoParams.TVKVInfoRequestParasBuilder.access$1100(paramTVKVInfoRequestParasBuilder);
    this.requestType = TVKVideoInfoParams.TVKVInfoRequestParasBuilder.access$1200(paramTVKVInfoRequestParasBuilder);
    this.upc = TVKVideoInfoParams.TVKVInfoRequestParasBuilder.access$1300(paramTVKVInfoRequestParasBuilder);
    this.platForm = TVKVideoInfoParams.TVKVInfoRequestParasBuilder.access$1400(paramTVKVInfoRequestParasBuilder);
    this.playerCapacity = TVKVideoInfoParams.TVKVInfoRequestParasBuilder.access$1500(paramTVKVInfoRequestParasBuilder);
    this.appVer = TVKVideoInfoParams.TVKVInfoRequestParasBuilder.access$1600(paramTVKVInfoRequestParasBuilder);
    this.encryptVer = TVKVideoInfoParams.TVKVInfoRequestParasBuilder.access$1700(paramTVKVInfoRequestParasBuilder);
    this.networkType = TVKVideoInfoParams.TVKVInfoRequestParasBuilder.access$1800(paramTVKVInfoRequestParasBuilder);
    this.wxOpenId = TVKVideoInfoParams.TVKVInfoRequestParasBuilder.access$1900(paramTVKVInfoRequestParasBuilder);
    this.loginQQ = TVKVideoInfoParams.TVKVInfoRequestParasBuilder.access$2000(paramTVKVInfoRequestParasBuilder);
    this.guid = TVKVideoInfoParams.TVKVInfoRequestParasBuilder.access$2100(paramTVKVInfoRequestParasBuilder);
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
  
  public int getEncryptVer()
  {
    return this.encryptVer;
  }
  
  public Map<String, String> getExtraParamsMap()
  {
    return this.extraParamsMap;
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
  
  public String getLoginQQ()
  {
    return this.loginQQ;
  }
  
  public int getNetworkType()
  {
    return this.networkType;
  }
  
  public TVKVideoInfoParams.OpenApiParam getOpenApiParam()
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
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     com.tencent.qqlive.tvkplayer.vinfo.vod.TVKVideoInfoParams
 * JD-Core Version:    0.7.0.1
 */