package com.tencent.weiyun.uploader;

import android.text.TextUtils;

public class UploadRequest$Builder
{
  private Object businessData;
  private int channelCount;
  private String checkKey;
  private String fileId;
  private IUploader.IUploadListener listener;
  private String path;
  private String requestKey;
  private String serverIp;
  private String serverName;
  private int serverPort;
  private String sha;
  private long size;
  private String[] sliceSha;
  private long[] statisticTimes;
  private long uin;
  private long uploadedSize;
  
  public UploadRequest$Builder() {}
  
  private UploadRequest$Builder(UploadRequest paramUploadRequest)
  {
    this.requestKey = UploadRequest.access$1700(paramUploadRequest);
    this.listener = UploadRequest.access$1800(paramUploadRequest);
    this.uin = UploadRequest.access$1900(paramUploadRequest);
    this.path = UploadRequest.access$2000(paramUploadRequest);
    this.sha = UploadRequest.access$2100(paramUploadRequest);
    this.sliceSha = UploadRequest.access$2200(paramUploadRequest);
    this.size = UploadRequest.access$2300(paramUploadRequest);
    this.uploadedSize = UploadRequest.access$2400(paramUploadRequest);
    this.fileId = UploadRequest.access$2500(paramUploadRequest);
    this.checkKey = UploadRequest.access$2600(paramUploadRequest);
    this.serverName = UploadRequest.access$2700(paramUploadRequest);
    this.serverIp = UploadRequest.access$2800(paramUploadRequest);
    this.serverPort = UploadRequest.access$2900(paramUploadRequest);
    this.channelCount = UploadRequest.access$3000(paramUploadRequest);
    this.businessData = UploadRequest.access$3100(paramUploadRequest);
    this.statisticTimes = UploadRequest.access$3200(paramUploadRequest);
  }
  
  public UploadRequest build()
  {
    if (TextUtils.isEmpty(this.path)) {
      throw new IllegalStateException("path is empty");
    }
    if (TextUtils.isEmpty(this.fileId)) {
      throw new IllegalStateException("fileId is empty");
    }
    if ((this.uin == 0L) || (TextUtils.isEmpty(this.sha)) || (TextUtils.isEmpty(this.checkKey)) || ((TextUtils.isEmpty(this.serverName)) && (TextUtils.isEmpty(this.serverIp)))) {
      throw new IllegalStateException("uin, sha, checkKey, serverName or serverIp is invalid.");
    }
    if (TextUtils.isEmpty(this.requestKey)) {
      this.requestKey = this.fileId;
    }
    return new UploadRequest(this, null);
  }
  
  public Builder businessData(Object paramObject)
  {
    this.businessData = paramObject;
    return this;
  }
  
  public Builder channelCount(int paramInt)
  {
    this.channelCount = paramInt;
    return this;
  }
  
  public Builder checkKey(String paramString)
  {
    this.checkKey = paramString;
    return this;
  }
  
  public Builder fileId(String paramString)
  {
    this.fileId = paramString;
    return this;
  }
  
  public Builder listener(IUploader.IUploadListener paramIUploadListener)
  {
    this.listener = paramIUploadListener;
    return this;
  }
  
  public Builder path(String paramString)
  {
    this.path = paramString;
    return this;
  }
  
  public Builder requestKey(String paramString)
  {
    this.requestKey = paramString;
    return this;
  }
  
  public Builder serverIp(String paramString)
  {
    this.serverIp = paramString;
    return this;
  }
  
  public Builder serverName(String paramString)
  {
    this.serverName = paramString;
    return this;
  }
  
  public Builder serverPort(int paramInt)
  {
    this.serverPort = paramInt;
    return this;
  }
  
  public Builder sha(String paramString)
  {
    this.sha = paramString;
    return this;
  }
  
  public Builder size(long paramLong)
  {
    this.size = paramLong;
    return this;
  }
  
  public Builder sliceSha(String[] paramArrayOfString)
  {
    this.sliceSha = paramArrayOfString;
    return this;
  }
  
  public Builder statisticTime(long paramLong1, long paramLong2, long paramLong3)
  {
    this.statisticTimes = new long[] { paramLong1, paramLong2, paramLong3 };
    return this;
  }
  
  public Builder uin(long paramLong)
  {
    this.uin = paramLong;
    return this;
  }
  
  public Builder uploadedSize(long paramLong)
  {
    this.uploadedSize = paramLong;
    return this;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.weiyun.uploader.UploadRequest.Builder
 * JD-Core Version:    0.7.0.1
 */