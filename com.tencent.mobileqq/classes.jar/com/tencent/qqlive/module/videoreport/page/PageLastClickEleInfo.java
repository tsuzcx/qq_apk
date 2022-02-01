package com.tencent.qqlive.module.videoreport.page;

import java.util.Map;

public class PageLastClickEleInfo
{
  private final Map<String, Object> mElementParams;
  
  PageLastClickEleInfo(Map<String, Object> paramMap)
  {
    this.mElementParams = paramMap;
  }
  
  public Map<String, Object> getElementParams()
  {
    return this.mElementParams;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.qqlive.module.videoreport.page.PageLastClickEleInfo
 * JD-Core Version:    0.7.0.1
 */