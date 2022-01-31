package com.tencent.weiyun.uploader;

public final class UploadResponse$Builder
{
  private int code;
  private long currentSize;
  private String errMsg;
  private UploadRequest request;
  private long speed;
  private long totalSize;
  
  public UploadResponse$Builder()
  {
    this.code = 0;
  }
  
  private UploadResponse$Builder(UploadResponse paramUploadResponse)
  {
    this.request = UploadResponse.access$700(paramUploadResponse);
    this.code = UploadResponse.access$800(paramUploadResponse);
    this.errMsg = UploadResponse.access$900(paramUploadResponse);
    this.totalSize = UploadResponse.access$1000(paramUploadResponse);
    this.currentSize = UploadResponse.access$1100(paramUploadResponse);
    this.speed = UploadResponse.access$1200(paramUploadResponse);
  }
  
  public UploadResponse build()
  {
    if (this.request == null) {
      throw new IllegalStateException("request == null");
    }
    return new UploadResponse(this, null);
  }
  
  public Builder code(int paramInt)
  {
    this.code = paramInt;
    return this;
  }
  
  public Builder currentSize(long paramLong)
  {
    this.currentSize = paramLong;
    return this;
  }
  
  public Builder errMsg(String paramString)
  {
    this.errMsg = paramString;
    return this;
  }
  
  public Builder request(UploadRequest paramUploadRequest)
  {
    this.request = paramUploadRequest;
    return this;
  }
  
  public Builder speed(long paramLong)
  {
    this.speed = paramLong;
    return this;
  }
  
  public Builder totalSize(long paramLong)
  {
    this.totalSize = paramLong;
    return this;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.weiyun.uploader.UploadResponse.Builder
 * JD-Core Version:    0.7.0.1
 */