package com.tencent.mobileqq.intervideo.groupvideo.pluginimpl;

import android.content.Intent;
import android.os.Bundle;
import com.tencent.mobileqq.app.ThreadManagerExecutor;
import com.tencent.mobileqq.intervideo.groupvideo.plugininterface.IVHostCallback;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Future;

public class IVCommonInterfaceImpl
{
  private static final String TAG = "IVCommonInterfaceImpl";
  private static final IVCommonInterfaceImpl sInstance = new IVCommonInterfaceImpl();
  private IVHostCallback mIVHostCallback;
  
  private String dealLocationStr(String paramString)
  {
    if ((paramString != null) && (!"Unknown".equals(paramString))) {
      return paramString;
    }
    return "";
  }
  
  public static IVCommonInterfaceImpl getInstance()
  {
    return sInstance;
  }
  
  public Future<Bundle> getLocation(String paramString)
  {
    return ThreadManagerExecutor.getExecutorService(16).submit(new IVCommonInterfaceImpl.1(this, paramString));
  }
  
  public void onHostActivityBackPress()
  {
    IVHostCallback localIVHostCallback = this.mIVHostCallback;
    if (localIVHostCallback != null) {
      localIVHostCallback.onHostActivityBackPress();
    }
  }
  
  public void onHostActivityDestroy()
  {
    IVHostCallback localIVHostCallback = this.mIVHostCallback;
    if (localIVHostCallback != null) {
      localIVHostCallback.onHostActivityDestroy();
    }
  }
  
  public void onHostActivityNewIntent(Intent paramIntent)
  {
    IVHostCallback localIVHostCallback = this.mIVHostCallback;
    if (localIVHostCallback != null) {
      localIVHostCallback.onHostActivityNewIntent(paramIntent);
    }
  }
  
  public void onHostActivityPause()
  {
    IVHostCallback localIVHostCallback = this.mIVHostCallback;
    if (localIVHostCallback != null) {
      localIVHostCallback.onHostActivityPause();
    }
  }
  
  public void onHostActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    IVHostCallback localIVHostCallback = this.mIVHostCallback;
    if (localIVHostCallback != null) {
      localIVHostCallback.onHostActivityResult(paramInt1, paramInt2, paramIntent);
    }
  }
  
  public void onHostActivityResume()
  {
    IVHostCallback localIVHostCallback = this.mIVHostCallback;
    if (localIVHostCallback != null) {
      localIVHostCallback.onHostActivityResume();
    }
  }
  
  public void onHostActivityStop()
  {
    IVHostCallback localIVHostCallback = this.mIVHostCallback;
    if (localIVHostCallback != null) {
      localIVHostCallback.onHostActivityStop();
    }
  }
  
  public void onRequestPermissionsResult(int paramInt, String[] paramArrayOfString, int[] paramArrayOfInt)
  {
    IVHostCallback localIVHostCallback = this.mIVHostCallback;
    if (localIVHostCallback != null) {
      localIVHostCallback.onRequestPermissionsResult(paramInt, paramArrayOfString, paramArrayOfInt);
    }
  }
  
  public void setHostActivityCallback(IVHostCallback paramIVHostCallback)
  {
    this.mIVHostCallback = paramIVHostCallback;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.tencent.mobileqq.intervideo.groupvideo.pluginimpl.IVCommonInterfaceImpl
 * JD-Core Version:    0.7.0.1
 */