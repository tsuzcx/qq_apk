package com.tencent.thumbplayer.api;

import com.tencent.thumbplayer.api.proxy.TPDownloadParamData;
import com.tencent.thumbplayer.utils.TPCommonUtils;
import java.util.ArrayList;

public class TPVideoInfo$Builder
{
  private String definition;
  private ArrayList<TPDownloadParamData> downloadParamList;
  private String fileID;
  private long height;
  @TPCommonEnum.TP_VIDEO_CODEC_TYPE
  private int videoCodecId;
  private long width;
  
  public TPVideoInfo build()
  {
    return new TPVideoInfo(this, null);
  }
  
  public Builder definition(String paramString)
  {
    this.definition = paramString;
    return this;
  }
  
  public Builder downloadParam(TPDownloadParamData paramTPDownloadParamData)
  {
    if (TPCommonUtils.isEmpty(this.downloadParamList)) {
      this.downloadParamList = new ArrayList();
    } else {
      this.downloadParamList.clear();
    }
    this.downloadParamList.add(paramTPDownloadParamData);
    return this;
  }
  
  public Builder downloadParamList(ArrayList<TPDownloadParamData> paramArrayList)
  {
    this.downloadParamList = paramArrayList;
    return this;
  }
  
  public Builder fileId(String paramString)
  {
    this.fileID = paramString;
    return this;
  }
  
  public Builder size(long paramLong1, long paramLong2)
  {
    this.width = paramLong1;
    this.height = paramLong2;
    return this;
  }
  
  public Builder videoCodecId(@TPCommonEnum.TP_VIDEO_CODEC_TYPE int paramInt)
  {
    this.videoCodecId = paramInt;
    return this;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.thumbplayer.api.TPVideoInfo.Builder
 * JD-Core Version:    0.7.0.1
 */