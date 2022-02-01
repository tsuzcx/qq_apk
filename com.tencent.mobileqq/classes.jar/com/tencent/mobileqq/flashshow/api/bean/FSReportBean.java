package com.tencent.mobileqq.flashshow.api.bean;

import java.io.Serializable;

public class FSReportBean
  implements Serializable
{
  private String mFromPageId;
  private String mPageId;
  
  public FSReportBean() {}
  
  public FSReportBean(String paramString)
  {
    this.mPageId = paramString;
  }
  
  public String getFromPageId()
  {
    return this.mFromPageId;
  }
  
  public String getPageId()
  {
    return this.mPageId;
  }
  
  public void setFromPageId(String paramString)
  {
    this.mFromPageId = paramString;
  }
  
  public void setPageId(String paramString)
  {
    this.mPageId = paramString;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.flashshow.api.bean.FSReportBean
 * JD-Core Version:    0.7.0.1
 */