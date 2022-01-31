package com.tencent.qqlive.tvkplayer.vinfo.vod;

import java.util.Map;

public class TVKVideoInfoParams$TVKVInfoRequestParasBuilder
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
  private final String vid;
  private String wxOpenId;
  
  public TVKVideoInfoParams$TVKVInfoRequestParasBuilder(String paramString)
  {
    this.vid = paramString;
  }
  
  public TVKVInfoRequestParasBuilder appVer(String paramString)
  {
    this.appVer = paramString;
    return this;
  }
  
  public TVKVideoInfoParams build()
  {
    return new TVKVideoInfoParams(this);
  }
  
  public TVKVInfoRequestParasBuilder ckeyExtraParamsMap(Map<String, String> paramMap)
  {
    this.ckeyExtraParamsMap = paramMap;
    return this;
  }
  
  public TVKVInfoRequestParasBuilder dlType(int paramInt)
  {
    this.dlType = paramInt;
    return this;
  }
  
  public TVKVInfoRequestParasBuilder drm(int paramInt)
  {
    this.drm = paramInt;
    return this;
  }
  
  public TVKVInfoRequestParasBuilder encryptVer(int paramInt)
  {
    this.encryptVer = paramInt;
    return this;
  }
  
  public TVKVInfoRequestParasBuilder extraParamsMap(Map<String, String> paramMap)
  {
    this.extraParamsMap = paramMap;
    if ((this.extraParamsMap != null) && (this.extraParamsMap.containsKey("cookie")))
    {
      this.loginCookie = ((String)this.extraParamsMap.get("cookie"));
      this.extraParamsMap.remove("cookie");
    }
    return this;
  }
  
  public TVKVInfoRequestParasBuilder format(String paramString)
  {
    this.format = paramString;
    return this;
  }
  
  public TVKVInfoRequestParasBuilder guid(String paramString)
  {
    this.guid = paramString;
    return this;
  }
  
  public TVKVInfoRequestParasBuilder ipstack(int paramInt)
  {
    this.ipstack = paramInt;
    return this;
  }
  
  public TVKVInfoRequestParasBuilder isCharge(int paramInt)
  {
    this.isCharge = paramInt;
    return this;
  }
  
  public TVKVInfoRequestParasBuilder loginCookie(String paramString)
  {
    this.loginCookie = paramString;
    return this;
  }
  
  public TVKVInfoRequestParasBuilder loginQQ(String paramString)
  {
    this.loginQQ = paramString;
    return this;
  }
  
  public TVKVInfoRequestParasBuilder networkType(int paramInt)
  {
    this.networkType = paramInt;
    return this;
  }
  
  public TVKVInfoRequestParasBuilder openApiParam(TVKVideoInfoParams.OpenApiParam paramOpenApiParam)
  {
    this.openApiParam = paramOpenApiParam;
    return this;
  }
  
  public TVKVInfoRequestParasBuilder platForm(int paramInt)
  {
    this.platForm = paramInt;
    return this;
  }
  
  public TVKVInfoRequestParasBuilder playerCapacity(int paramInt)
  {
    this.playerCapacity = paramInt;
    return this;
  }
  
  public TVKVInfoRequestParasBuilder requestType(int paramInt)
  {
    this.requestType = paramInt;
    return this;
  }
  
  public TVKVInfoRequestParasBuilder sdtFrom(String paramString)
  {
    this.sdtFrom = paramString;
    return this;
  }
  
  public TVKVInfoRequestParasBuilder uin(String paramString)
  {
    this.uin = paramString;
    return this;
  }
  
  public TVKVInfoRequestParasBuilder upc(String paramString)
  {
    this.upc = paramString;
    return this;
  }
  
  public TVKVInfoRequestParasBuilder wxOpenId(String paramString)
  {
    this.wxOpenId = paramString;
    return this;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.qqlive.tvkplayer.vinfo.vod.TVKVideoInfoParams.TVKVInfoRequestParasBuilder
 * JD-Core Version:    0.7.0.1
 */