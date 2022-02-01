package com.tencent.qqlive.tvkplayer.vinfo.vod;

import java.util.Map;

public class TVKCGIVKeyRequestParams$VKeyRequestParasBuilder
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
  
  public TVKCGIVKeyRequestParams$VKeyRequestParasBuilder(String paramString)
  {
    this.vid = paramString;
  }
  
  public VKeyRequestParasBuilder appVer(String paramString)
  {
    this.appVer = paramString;
    return this;
  }
  
  public TVKCGIVKeyRequestParams build()
  {
    return new TVKCGIVKeyRequestParams(this);
  }
  
  public VKeyRequestParasBuilder ckeyExtraParamsMap(Map<String, String> paramMap)
  {
    this.ckeyExtraParamsMap = paramMap;
    return this;
  }
  
  public VKeyRequestParasBuilder dlType(int paramInt)
  {
    this.dlType = paramInt;
    return this;
  }
  
  public VKeyRequestParasBuilder encryptVer(int paramInt)
  {
    this.encryptVer = paramInt;
    return this;
  }
  
  public VKeyRequestParasBuilder endClipNo(int paramInt)
  {
    this.endClipNo = paramInt;
    return this;
  }
  
  public VKeyRequestParasBuilder extraParamsMap(Map<String, String> paramMap)
  {
    this.extraParamsMap = paramMap;
    return this;
  }
  
  public VKeyRequestParasBuilder fd(String paramString)
  {
    this.fd = paramString;
    return this;
  }
  
  public VKeyRequestParasBuilder fileName(String paramString)
  {
    this.fileName = paramString;
    return this;
  }
  
  public VKeyRequestParasBuilder format(String paramString)
  {
    this.format = paramString;
    return this;
  }
  
  public VKeyRequestParasBuilder formatId(int paramInt)
  {
    this.formatId = paramInt;
    return this;
  }
  
  public VKeyRequestParasBuilder guid(String paramString)
  {
    this.guid = paramString;
    return this;
  }
  
  public VKeyRequestParasBuilder isCharge(int paramInt)
  {
    this.isCharge = paramInt;
    return this;
  }
  
  public VKeyRequestParasBuilder isDrm(boolean paramBoolean)
  {
    this.isDrm = paramBoolean;
    return this;
  }
  
  public VKeyRequestParasBuilder lnk(String paramString)
  {
    this.lnk = paramString;
    return this;
  }
  
  public VKeyRequestParasBuilder loginCookie(String paramString)
  {
    this.loginCookie = paramString;
    return this;
  }
  
  public VKeyRequestParasBuilder loginQQ(String paramString)
  {
    this.loginQQ = paramString;
    return this;
  }
  
  public VKeyRequestParasBuilder networkType(int paramInt)
  {
    this.networkType = paramInt;
    return this;
  }
  
  public VKeyRequestParasBuilder openApi(TVKCGIVKeyRequestParams.OpenApiParam paramOpenApiParam)
  {
    this.openApiParam = paramOpenApiParam;
    return this;
  }
  
  public VKeyRequestParasBuilder platForm(int paramInt)
  {
    this.platForm = paramInt;
    return this;
  }
  
  public VKeyRequestParasBuilder requestID(String paramString)
  {
    this.requestID = paramString;
    return this;
  }
  
  public VKeyRequestParasBuilder requestType(int paramInt)
  {
    this.requestType = paramInt;
    return this;
  }
  
  public VKeyRequestParasBuilder requestUrlTargetType(int paramInt)
  {
    this.requestUrlTargetType = paramInt;
    return this;
  }
  
  public VKeyRequestParasBuilder sdtFrom(String paramString)
  {
    this.sdtFrom = paramString;
    return this;
  }
  
  public VKeyRequestParasBuilder startClipNo(int paramInt)
  {
    this.startClipNo = paramInt;
    return this;
  }
  
  public VKeyRequestParasBuilder taskID(int paramInt)
  {
    this.taskID = paramInt;
    return this;
  }
  
  public VKeyRequestParasBuilder uin(String paramString)
  {
    this.uin = paramString;
    return this;
  }
  
  public VKeyRequestParasBuilder upc(String paramString)
  {
    this.upc = paramString;
    return this;
  }
  
  public VKeyRequestParasBuilder upcPaths(String paramString)
  {
    this.upcPaths = paramString;
    return this;
  }
  
  public VKeyRequestParasBuilder upcSPIPs(String paramString)
  {
    this.upcSPIPs = paramString;
    return this;
  }
  
  public VKeyRequestParasBuilder upcSPPORTs(String paramString)
  {
    this.upcSPPORTs = paramString;
    return this;
  }
  
  public VKeyRequestParasBuilder useIpV6Dns(boolean paramBoolean)
  {
    this.useIpV6Dns = paramBoolean;
    return this;
  }
  
  public VKeyRequestParasBuilder vkeyType(int paramInt)
  {
    this.vkeyType = paramInt;
    return this;
  }
  
  public VKeyRequestParasBuilder vt(String paramString)
  {
    this.vt = paramString;
    return this;
  }
  
  public VKeyRequestParasBuilder wxOpenId(String paramString)
  {
    this.wxOpenId = paramString;
    return this;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.qqlive.tvkplayer.vinfo.vod.TVKCGIVKeyRequestParams.VKeyRequestParasBuilder
 * JD-Core Version:    0.7.0.1
 */