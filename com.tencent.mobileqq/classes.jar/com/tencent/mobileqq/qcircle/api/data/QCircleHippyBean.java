package com.tencent.mobileqq.qcircle.api.data;

import java.io.Serializable;

public class QCircleHippyBean
  implements Serializable
{
  private static final long serialVersionUID = 4346421686166252189L;
  private String mDefaultUrl;
  private String mModuleName;
  private String mPersonalUin;
  private long mStartTime;
  private String mTheme;
  
  public String getDefaultUrl()
  {
    return this.mDefaultUrl;
  }
  
  public String getModuleName()
  {
    return this.mModuleName;
  }
  
  public String getPersonalUin()
  {
    return this.mPersonalUin;
  }
  
  public long getStartTime()
  {
    return this.mStartTime;
  }
  
  public String getTheme()
  {
    return this.mTheme;
  }
  
  public QCircleHippyBean setDefaultUrl(String paramString)
  {
    this.mDefaultUrl = paramString;
    return this;
  }
  
  public QCircleHippyBean setModuleName(String paramString)
  {
    this.mModuleName = paramString;
    return this;
  }
  
  public QCircleHippyBean setPersonalUin(String paramString)
  {
    this.mPersonalUin = paramString;
    return this;
  }
  
  public QCircleHippyBean setStartTime(long paramLong)
  {
    this.mStartTime = paramLong;
    return this;
  }
  
  public void setTheme(String paramString)
  {
    this.mTheme = paramString;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.qcircle.api.data.QCircleHippyBean
 * JD-Core Version:    0.7.0.1
 */