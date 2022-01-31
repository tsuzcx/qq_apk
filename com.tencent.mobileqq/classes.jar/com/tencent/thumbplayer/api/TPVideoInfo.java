package com.tencent.thumbplayer.api;

import com.tencent.thumbplayer.api.proxy.TPDownloadParamData;
import java.util.ArrayList;

public class TPVideoInfo
{
  private TPVideoInfo.Builder builder;
  private ArrayList<TPDownloadParamData> downloadParamList;
  private String fileID;
  private long height;
  private int videoCodecId;
  private long width;
  
  private TPVideoInfo(TPVideoInfo.Builder paramBuilder)
  {
    this.width = TPVideoInfo.Builder.access$000(paramBuilder);
    this.height = TPVideoInfo.Builder.access$100(paramBuilder);
    this.videoCodecId = TPVideoInfo.Builder.access$200(paramBuilder);
    this.fileID = TPVideoInfo.Builder.access$300(paramBuilder);
    this.downloadParamList = TPVideoInfo.Builder.access$400(paramBuilder);
    this.builder = paramBuilder;
  }
  
  public TPVideoInfo.Builder getBuilder()
  {
    return this.builder;
  }
  
  public ArrayList<TPDownloadParamData> getDownloadPraramList()
  {
    return this.downloadParamList;
  }
  
  public long getHeight()
  {
    return this.height;
  }
  
  public String getProxyFileID()
  {
    return this.fileID;
  }
  
  public int getVideoCodecId()
  {
    return this.videoCodecId;
  }
  
  public long getWidth()
  {
    return this.width;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.thumbplayer.api.TPVideoInfo
 * JD-Core Version:    0.7.0.1
 */