package com.tencent.qqlive.tvkplayer.vinfo.vod;

public class TVKCGIVInfoRequestParams$OpenApiParam
{
  private String accessToken;
  private String oauthConsumerKey;
  private String openId;
  private String pf;
  
  public TVKCGIVInfoRequestParams$OpenApiParam(String paramString1, String paramString2, String paramString3, String paramString4)
  {
    this.openId = paramString1;
    this.accessToken = paramString2;
    this.oauthConsumerKey = paramString3;
    this.pf = paramString4;
  }
  
  public String getAccessToken()
  {
    return this.accessToken;
  }
  
  public String getOauthConsumeKey()
  {
    return this.oauthConsumerKey;
  }
  
  public String getOpenId()
  {
    return this.openId;
  }
  
  public String getPf()
  {
    return this.pf;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.qqlive.tvkplayer.vinfo.vod.TVKCGIVInfoRequestParams.OpenApiParam
 * JD-Core Version:    0.7.0.1
 */