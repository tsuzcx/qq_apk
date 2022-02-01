package com.tencent.qqlive.module.videoreport.dtreport.api;

import com.tencent.qqlive.tvkplayer.api.TVKNetVideoInfo;
import com.tencent.qqlive.tvkplayer.api.TVKPlayerVideoInfo;
import com.tencent.qqlive.tvkplayer.api.TVKProperties;
import java.util.Map;

public abstract interface IDTTVKDataProvider
{
  public abstract boolean active(TVKPlayerVideoInfo paramTVKPlayerVideoInfo);
  
  public abstract Map<String, Object> formatBizParams(TVKProperties paramTVKProperties);
  
  public abstract Map<String, Object> formatOpenParams(TVKPlayerVideoInfo paramTVKPlayerVideoInfo, String paramString);
  
  public abstract Map<String, Object> formatStartParams(TVKNetVideoInfo paramTVKNetVideoInfo, boolean paramBoolean);
  
  public abstract String getContentId(TVKPlayerVideoInfo paramTVKPlayerVideoInfo);
  
  public abstract int getContentType(TVKPlayerVideoInfo paramTVKPlayerVideoInfo, int paramInt);
  
  public abstract boolean isBizReady(TVKProperties paramTVKProperties);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.tencent.qqlive.module.videoreport.dtreport.api.IDTTVKDataProvider
 * JD-Core Version:    0.7.0.1
 */