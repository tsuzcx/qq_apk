package com.tencent.mobileqq.intervideo.now.dynamic.impl;

import android.os.Bundle;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.intervideo.now.dynamic.DynamicNowManager;
import com.tencent.mobileqq.intervideo.now.dynamic.IDynamicNowManagerApi;

public class DynamicNowManagerApiImpl
  implements IDynamicNowManagerApi
{
  public void addJumpCallback() {}
  
  public void beginLive(Bundle paramBundle)
  {
    DynamicNowManager.d(paramBundle);
  }
  
  public int getFirstByFrom(String paramString)
  {
    return DynamicNowManager.a(paramString);
  }
  
  public AppInterface getQQAppInterface()
  {
    return DynamicNowManager.a();
  }
  
  public boolean isAppInstalled()
  {
    return DynamicNowManager.a();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.tencent.mobileqq.intervideo.now.dynamic.impl.DynamicNowManagerApiImpl
 * JD-Core Version:    0.7.0.1
 */