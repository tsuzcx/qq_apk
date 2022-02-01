package com.tencent.mobileqq.qqlive.api.verified.impl;

import com.tencent.mobileqq.qqlive.api.verified.IQQLiveDataStore;

public class QQLiveDataStoreImpl
  implements IQQLiveDataStore
{
  private String appId;
  
  public void clear()
  {
    this.appId = null;
  }
  
  public String getAppId()
  {
    return this.appId;
  }
  
  public void setAppId(String paramString)
  {
    this.appId = paramString;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.qqlive.api.verified.impl.QQLiveDataStoreImpl
 * JD-Core Version:    0.7.0.1
 */