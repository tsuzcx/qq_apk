package com.tencent.qqlive.module.videoreport;

import java.util.Map;

public class PageParams$Builder
{
  private Map<String, ?> mBasicParams;
  private Map<String, ?> mRefElementParams;
  private Map<String, ?> mRootRefElementParams;
  
  public PageParams build()
  {
    return new PageParams(this, null);
  }
  
  public Builder setBasicParams(Map<String, ?> paramMap)
  {
    this.mBasicParams = paramMap;
    return this;
  }
  
  public Builder setRefElementParams(Map<String, ?> paramMap)
  {
    this.mRefElementParams = paramMap;
    return this;
  }
  
  public Builder setRootRefElementParams(Map<String, ?> paramMap)
  {
    this.mRootRefElementParams = paramMap;
    return this;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.qqlive.module.videoreport.PageParams.Builder
 * JD-Core Version:    0.7.0.1
 */