package com.tencent.mobileqq.education.request;

public class StudyReqInfo$Builder
{
  private String a;
  private byte[] b;
  private int c = 0;
  private int d = 0;
  private int e = 30;
  private boolean f = false;
  
  public Builder a(int paramInt)
  {
    this.e = paramInt;
    return this;
  }
  
  public Builder a(String paramString)
  {
    this.a = paramString;
    return this;
  }
  
  public Builder a(boolean paramBoolean)
  {
    this.f = paramBoolean;
    return this;
  }
  
  public Builder a(byte[] paramArrayOfByte)
  {
    this.b = paramArrayOfByte;
    return this;
  }
  
  public StudyReqInfo a()
  {
    return new StudyReqInfo(this);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.education.request.StudyReqInfo.Builder
 * JD-Core Version:    0.7.0.1
 */