package com.tencent.mobileqq.writetogether.data;

public class GetChangesetsReq
{
  public int from;
  public String padId;
  public int to;
  
  public GetChangesetsReq(String paramString, int paramInt1, int paramInt2)
  {
    this.padId = paramString;
    this.from = paramInt1;
    this.to = paramInt2;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.writetogether.data.GetChangesetsReq
 * JD-Core Version:    0.7.0.1
 */