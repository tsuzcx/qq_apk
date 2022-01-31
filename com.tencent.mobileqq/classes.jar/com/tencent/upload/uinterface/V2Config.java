package com.tencent.upload.uinterface;

public class V2Config
{
  public int mBatchControlNumber;
  public int mFileSocketNumber;
  public int mParallelFileNumber;
  public boolean mUseUploadV2;
  
  public V2Config()
  {
    this.mUseUploadV2 = true;
    this.mParallelFileNumber = 3;
    this.mFileSocketNumber = 2;
    this.mBatchControlNumber = 8;
  }
  
  public V2Config(V2Config paramV2Config)
  {
    this.mUseUploadV2 = paramV2Config.mUseUploadV2;
    this.mParallelFileNumber = paramV2Config.mParallelFileNumber;
    this.mFileSocketNumber = paramV2Config.mFileSocketNumber;
    this.mBatchControlNumber = paramV2Config.mBatchControlNumber;
  }
  
  public String toString()
  {
    return "[mUseUploadV2:" + this.mUseUploadV2 + ", mParallelFileNumber:" + this.mParallelFileNumber + ", mFileSocketNumber:" + this.mFileSocketNumber + ", mBatchControlNumber:" + this.mBatchControlNumber + "]";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.upload.uinterface.V2Config
 * JD-Core Version:    0.7.0.1
 */