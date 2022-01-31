package com.tencent.mobileqq.data;

import java.io.Serializable;

public class GrayTipsSpan
  implements Serializable
{
  public int begin;
  public int end;
  public String url;
  
  public GrayTipsSpan(int paramInt1, int paramInt2, String paramString)
  {
    this.begin = paramInt1;
    this.end = paramInt2;
    this.url = paramString;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.data.GrayTipsSpan
 * JD-Core Version:    0.7.0.1
 */