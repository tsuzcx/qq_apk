package com.tencent.weiyun.uploader;

public class UploadResponse
{
  private int mCode;
  private long mCurrentSize;
  private String mErrMsg;
  private final UploadRequest mRequest;
  private long mSpeed;
  private long mTotalSize;
  
  private UploadResponse(Builder paramBuilder)
  {
    this.mRequest = paramBuilder.request;
    this.mCode = paramBuilder.code;
    this.mErrMsg = paramBuilder.errMsg;
    this.mTotalSize = paramBuilder.totalSize;
    this.mCurrentSize = paramBuilder.currentSize;
    this.mSpeed = paramBuilder.speed;
  }
  
  public int code()
  {
    return this.mCode;
  }
  
  public long currentSize()
  {
    return this.mCurrentSize;
  }
  
  public String errMsg()
  {
    return this.mErrMsg;
  }
  
  public Builder newBuilder()
  {
    return new Builder(this, null);
  }
  
  public UploadRequest request()
  {
    return this.mRequest;
  }
  
  public long speed()
  {
    return this.mSpeed;
  }
  
  public String toString()
  {
    return "UploadResponse{code=" + this.mCode + ", errMsg='" + this.mErrMsg + '\'' + '}';
  }
  
  public long totalSize()
  {
    return this.mTotalSize;
  }
  
  public static final class Builder
  {
    private int code;
    private long currentSize;
    private String errMsg;
    private UploadRequest request;
    private long speed;
    private long totalSize;
    
    public Builder()
    {
      this.code = 0;
    }
    
    private Builder(UploadResponse paramUploadResponse)
    {
      this.request = paramUploadResponse.mRequest;
      this.code = paramUploadResponse.mCode;
      this.errMsg = paramUploadResponse.mErrMsg;
      this.totalSize = paramUploadResponse.mTotalSize;
      this.currentSize = paramUploadResponse.mCurrentSize;
      this.speed = paramUploadResponse.mSpeed;
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
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.weiyun.uploader.UploadResponse
 * JD-Core Version:    0.7.0.1
 */