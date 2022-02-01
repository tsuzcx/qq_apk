package com.tencent.mobileqq.winkpublish.util;

public class UploadTaskBatchUtil$UploadInfo
{
  public int a;
  public int b;
  public int c;
  public int d;
  
  public UploadTaskBatchUtil$UploadInfo() {}
  
  public UploadTaskBatchUtil$UploadInfo(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    this.a = paramInt1;
    this.b = paramInt2;
    this.c = paramInt3;
    this.d = paramInt4;
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("UploadInfo [leftCount=");
    localStringBuilder.append(this.a);
    localStringBuilder.append(", successCount=");
    localStringBuilder.append(this.b);
    localStringBuilder.append(", failedCount=");
    localStringBuilder.append(this.c);
    localStringBuilder.append(", maxCount=");
    localStringBuilder.append(this.d);
    localStringBuilder.append("]");
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.tencent.mobileqq.winkpublish.util.UploadTaskBatchUtil.UploadInfo
 * JD-Core Version:    0.7.0.1
 */