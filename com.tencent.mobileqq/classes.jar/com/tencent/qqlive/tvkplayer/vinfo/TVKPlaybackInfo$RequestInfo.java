package com.tencent.qqlive.tvkplayer.vinfo;

public class TVKPlaybackInfo$RequestInfo
{
  private String audioTrack;
  private String definition;
  private boolean dolbyEnable;
  private boolean drmEnable;
  private String flowId;
  private int formatId;
  private boolean h265Enable;
  private boolean hdr10Enable;
  private Object tag;
  
  TVKPlaybackInfo$RequestInfo()
  {
    flowId("");
    formatId(0);
    definition("");
    h265Enable(true);
    dolbyEnable(true);
    audioTrack("");
    drmEnable(true);
    hdr10Enable(true);
  }
  
  String audioTrack()
  {
    return this.audioTrack;
  }
  
  void audioTrack(String paramString)
  {
    this.audioTrack = paramString;
  }
  
  RequestInfo copy()
  {
    RequestInfo localRequestInfo = new RequestInfo();
    localRequestInfo.flowId = this.flowId;
    localRequestInfo.formatId = this.formatId;
    localRequestInfo.definition = this.definition;
    localRequestInfo.h265Enable = this.h265Enable;
    localRequestInfo.dolbyEnable = this.dolbyEnable;
    localRequestInfo.audioTrack = this.audioTrack;
    localRequestInfo.drmEnable = this.drmEnable;
    localRequestInfo.hdr10Enable = this.hdr10Enable;
    localRequestInfo.tag = this.tag;
    return localRequestInfo;
  }
  
  void copyFrom(RequestInfo paramRequestInfo)
  {
    flowId(paramRequestInfo.flowId);
    formatId(paramRequestInfo.formatId);
    definition(paramRequestInfo.definition);
    h265Enable(paramRequestInfo.h265Enable);
    dolbyEnable(paramRequestInfo.dolbyEnable);
    audioTrack(paramRequestInfo.audioTrack);
    drmEnable(paramRequestInfo.drmEnable);
    hdr10Enable(paramRequestInfo.hdr10Enable);
  }
  
  String definition()
  {
    return this.definition;
  }
  
  public void definition(String paramString)
  {
    this.definition = paramString;
  }
  
  void dolbyEnable(boolean paramBoolean)
  {
    this.dolbyEnable = paramBoolean;
  }
  
  boolean dolbyEnable()
  {
    return this.dolbyEnable;
  }
  
  void drmEnable(boolean paramBoolean)
  {
    this.drmEnable = paramBoolean;
  }
  
  boolean drmEnable()
  {
    return this.drmEnable;
  }
  
  String flowId()
  {
    return this.flowId;
  }
  
  public void flowId(String paramString)
  {
    this.flowId = paramString;
  }
  
  int formatId()
  {
    return this.formatId;
  }
  
  public void formatId(int paramInt)
  {
    this.formatId = paramInt;
  }
  
  void h265Enable(boolean paramBoolean)
  {
    this.h265Enable = paramBoolean;
  }
  
  boolean h265Enable()
  {
    return this.h265Enable;
  }
  
  void hdr10Enable(boolean paramBoolean)
  {
    this.hdr10Enable = paramBoolean;
  }
  
  boolean hdr10Enable()
  {
    return this.hdr10Enable;
  }
  
  public Object tag()
  {
    return this.tag;
  }
  
  public void tag(Object paramObject)
  {
    this.tag = paramObject;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.qqlive.tvkplayer.vinfo.TVKPlaybackInfo.RequestInfo
 * JD-Core Version:    0.7.0.1
 */