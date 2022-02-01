package com.tencent.mobileqq.qqgift.api.impl;

import com.tencent.mobileqq.qqgift.api.IQQGiftDataStore;

public class QQGiftDataStoreImpl
  implements IQQGiftDataStore
{
  private String sceneId;
  
  public void clear()
  {
    this.sceneId = null;
  }
  
  public String getSceneId()
  {
    return this.sceneId;
  }
  
  public void setSceneId(String paramString)
  {
    this.sceneId = paramString;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.qqgift.api.impl.QQGiftDataStoreImpl
 * JD-Core Version:    0.7.0.1
 */