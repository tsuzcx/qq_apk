package com.tencent.smtt.sdk;

import android.webkit.GeolocationPermissions.Callback;
import com.tencent.smtt.export.external.interfaces.GeolocationPermissionsCallback;

class SystemWebChromeClient$GeolocationPermissionsCallbackImpl
  implements GeolocationPermissionsCallback
{
  GeolocationPermissions.Callback mCallback;
  
  SystemWebChromeClient$GeolocationPermissionsCallbackImpl(SystemWebChromeClient paramSystemWebChromeClient, GeolocationPermissions.Callback paramCallback)
  {
    this.mCallback = paramCallback;
  }
  
  public void invoke(String paramString, boolean paramBoolean1, boolean paramBoolean2)
  {
    this.mCallback.invoke(paramString, paramBoolean1, paramBoolean2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.smtt.sdk.SystemWebChromeClient.GeolocationPermissionsCallbackImpl
 * JD-Core Version:    0.7.0.1
 */