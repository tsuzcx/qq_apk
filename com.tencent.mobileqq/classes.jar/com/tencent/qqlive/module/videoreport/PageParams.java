package com.tencent.qqlive.module.videoreport;

import java.util.Map;

public class PageParams
{
  private Map<String, ?> mBasicParams;
  private Map<String, ?> mRefElementParams;
  private Map<String, ?> mRootRefElementParams;
  
  private PageParams(PageParams.Builder paramBuilder)
  {
    this.mBasicParams = PageParams.Builder.access$000(paramBuilder);
    this.mRefElementParams = PageParams.Builder.access$100(paramBuilder);
    this.mRootRefElementParams = PageParams.Builder.access$200(paramBuilder);
  }
  
  public PageParams(Map<String, ?> paramMap)
  {
    this.mBasicParams = paramMap;
  }
  
  public static PageParams.Builder builder()
  {
    return new PageParams.Builder();
  }
  
  public Map<String, ?> getBasicParams()
  {
    return this.mBasicParams;
  }
  
  public Map<String, ?> getRefElementParams()
  {
    return this.mRefElementParams;
  }
  
  public Map<String, ?> getRootRefElementParams()
  {
    return this.mRootRefElementParams;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.qqlive.module.videoreport.PageParams
 * JD-Core Version:    0.7.0.1
 */