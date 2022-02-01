package com.tencent.weiyun.uploader;

public class UploadResponse
{
  private int mCode;
  private long mCurrentSize;
  private String mErrMsg;
  private final UploadRequest mRequest;
  private long mSpeed;
  private long mTotalSize;
  
  private UploadResponse(UploadResponse.Builder paramBuilder)
  {
    this.mRequest = UploadResponse.Builder.access$000(paramBuilder);
    this.mCode = UploadResponse.Builder.access$100(paramBuilder);
    this.mErrMsg = UploadResponse.Builder.access$200(paramBuilder);
    this.mTotalSize = UploadResponse.Builder.access$300(paramBuilder);
    this.mCurrentSize = UploadResponse.Builder.access$400(paramBuilder);
    this.mSpeed = UploadResponse.Builder.access$500(paramBuilder);
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
  
  public UploadResponse.Builder newBuilder()
  {
    return new UploadResponse.Builder(this, null);
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
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.weiyun.uploader.UploadResponse
 * JD-Core Version:    0.7.0.1
 */