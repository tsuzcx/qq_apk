package com.tencent.qqlive.tvkplayer.vinfo.vod;

import java.util.Map;

public class TVKCGIVInfoRequestParams$TVKCGIVInfoRequestParasBuilder
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
  private final String vid;
  private String wxOpenId;
  
  public TVKCGIVInfoRequestParams$TVKCGIVInfoRequestParasBuilder(String paramString)
  {
    this.vid = paramString;
  }
  
  public TVKCGIVInfoRequestParasBuilder appVer(String paramString)
  {
    this.appVer = paramString;
    return this;
  }
  
  public TVKCGIVInfoRequestParams build()
  {
    return new TVKCGIVInfoRequestParams(this);
  }
  
  public TVKCGIVInfoRequestParasBuilder builder(boolean paramBoolean)
  {
    this.useIpV6Dns = paramBoolean;
    return this;
  }
  
  public TVKCGIVInfoRequestParasBuilder ckeyExtraParamsMap(Map<String, String> paramMap)
  {
    this.ckeyExtraParamsMap = paramMap;
    return this;
  }
  
  public TVKCGIVInfoRequestParasBuilder dlType(int paramInt)
  {
    this.dlType = paramInt;
    return this;
  }
  
  public TVKCGIVInfoRequestParasBuilder drm(int paramInt)
  {
    this.drm = paramInt;
    return this;
  }
  
  public TVKCGIVInfoRequestParasBuilder encryptVer(int paramInt)
  {
    this.encryptVer = paramInt;
    return this;
  }
  
  public TVKCGIVInfoRequestParasBuilder extraParamsMap(Map<String, String> paramMap)
  {
    this.extraParamsMap = paramMap;
    return this;
  }
  
  public TVKCGIVInfoRequestParasBuilder fd(String paramString)
  {
    this.fd = paramString;
    return this;
  }
  
  public TVKCGIVInfoRequestParasBuilder format(String paramString)
  {
    this.format = paramString;
    return this;
  }
  
  public TVKCGIVInfoRequestParasBuilder guid(String paramString)
  {
    this.guid = paramString;
    return this;
  }
  
  public TVKCGIVInfoRequestParasBuilder ipstack(int paramInt)
  {
    this.ipstack = paramInt;
    return this;
  }
  
  public TVKCGIVInfoRequestParasBuilder isCharge(int paramInt)
  {
    this.isCharge = paramInt;
    return this;
  }
  
  public TVKCGIVInfoRequestParasBuilder loginCookie(String paramString)
  {
    this.loginCookie = paramString;
    return this;
  }
  
  public TVKCGIVInfoRequestParasBuilder networkType(int paramInt)
  {
    this.networkType = paramInt;
    return this;
  }
  
  public TVKCGIVInfoRequestParasBuilder openApiParam(TVKCGIVInfoRequestParams.OpenApiParam paramOpenApiParam)
  {
    this.openApiParam = paramOpenApiParam;
    return this;
  }
  
  public TVKCGIVInfoRequestParasBuilder platForm(int paramInt)
  {
    this.platForm = paramInt;
    return this;
  }
  
  public TVKCGIVInfoRequestParasBuilder playerCapacity(int paramInt)
  {
    this.playerCapacity = paramInt;
    return this;
  }
  
  public TVKCGIVInfoRequestParasBuilder requestID(String paramString)
  {
    this.requestID = paramString;
    return this;
  }
  
  public TVKCGIVInfoRequestParasBuilder requestType(int paramInt)
  {
    this.requestType = paramInt;
    return this;
  }
  
  public TVKCGIVInfoRequestParasBuilder sdtFrom(String paramString)
  {
    this.sdtFrom = paramString;
    return this;
  }
  
  public TVKCGIVInfoRequestParasBuilder uin(String paramString)
  {
    this.uin = paramString;
    return this;
  }
  
  public TVKCGIVInfoRequestParasBuilder upc(String paramString)
  {
    this.upc = paramString;
    return this;
  }
  
  public TVKCGIVInfoRequestParasBuilder wxOpenId(String paramString)
  {
    this.wxOpenId = paramString;
    return this;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     com.tencent.qqlive.tvkplayer.vinfo.vod.TVKCGIVInfoRequestParams.TVKCGIVInfoRequestParasBuilder
 * JD-Core Version:    0.7.0.1
 */