package com.tencent.mobileqq.shortvideo.filter;

public class QQPtColorFilterInfo
{
  private String colorPng;
  private int filterId = -1;
  private String name;
  private int subId = -1;
  
  public QQPtColorFilterInfo(int paramInt1, String paramString1, int paramInt2, String paramString2)
  {
    this.filterId = paramInt1;
    this.name = paramString1;
    this.subId = paramInt2;
    this.colorPng = paramString2;
  }
  
  public String getColorPng()
  {
    return this.colorPng;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.shortvideo.filter.QQPtColorFilterInfo
 * JD-Core Version:    0.7.0.1
 */