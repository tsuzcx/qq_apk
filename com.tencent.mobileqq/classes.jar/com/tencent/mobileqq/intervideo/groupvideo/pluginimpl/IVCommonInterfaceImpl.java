package com.tencent.mobileqq.intervideo.groupvideo.pluginimpl;

import akhl;
import android.content.Intent;
import android.os.Bundle;
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
    String str;
    if (paramString != null)
    {
      str = paramString;
      if (!"Unknown".equals(paramString)) {}
    }
    else
    {
      str = "";
    }
    return str;
  }
  
  public static IVCommonInterfaceImpl getInstance()
  {
    return sInstance;
  }
  
  public Future<Bundle> getLocation(String paramString)
  {
    return akhl.a(16).submit(new IVCommonInterfaceImpl.1(this, paramString));
  }
  
  public void onHostActivityBackPress()
  {
    if (this.mIVHostCallback != null) {
      this.mIVHostCallback.onHostActivityBackPress();
    }
  }
  
  public void onHostActivityDestroy()
  {
    if (this.mIVHostCallback != null) {
      this.mIVHostCallback.onHostActivityDestroy();
    }
  }
  
  public void onHostActivityNewIntent(Intent paramIntent)
  {
    if (this.mIVHostCallback != null) {
      this.mIVHostCallback.onHostActivityNewIntent(paramIntent);
    }
  }
  
  public void onHostActivityPause()
  {
    if (this.mIVHostCallback != null) {
      this.mIVHostCallback.onHostActivityPause();
    }
  }
  
  public void onHostActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    if (this.mIVHostCallback != null) {
      this.mIVHostCallback.onHostActivityResult(paramInt1, paramInt2, paramIntent);
    }
  }
  
  public void onHostActivityResume()
  {
    if (this.mIVHostCallback != null) {
      this.mIVHostCallback.onHostActivityResume();
    }
  }
  
  public void onHostActivityStop()
  {
    if (this.mIVHostCallback != null) {
      this.mIVHostCallback.onHostActivityStop();
    }
  }
  
  public void onRequestPermissionsResult(int paramInt, String[] paramArrayOfString, int[] paramArrayOfInt)
  {
    if (this.mIVHostCallback != null) {
      this.mIVHostCallback.onRequestPermissionsResult(paramInt, paramArrayOfString, paramArrayOfInt);
    }
  }
  
  public void setHostActivityCallback(IVHostCallback paramIVHostCallback)
  {
    this.mIVHostCallback = paramIVHostCallback;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.intervideo.groupvideo.pluginimpl.IVCommonInterfaceImpl
 * JD-Core Version:    0.7.0.1
 */