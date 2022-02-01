package com.tencent.smtt.sdk;

import android.webkit.GeolocationPermissions.Callback;
import com.tencent.smtt.export.external.interfaces.GeolocationPermissionsCallback;

class SystemWebChromeClient$b
  implements GeolocationPermissionsCallback
{
  GeolocationPermissions.Callback a;
  
  SystemWebChromeClient$b(SystemWebChromeClient paramSystemWebChromeClient, GeolocationPermissions.Callback paramCallback)
  {
    this.a = paramCallback;
  }
  
  public void invoke(String paramString, boolean paramBoolean1, boolean paramBoolean2)
  {
    this.a.invoke(paramString, paramBoolean1, paramBoolean2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     com.tencent.smtt.sdk.SystemWebChromeClient.b
 * JD-Core Version:    0.7.0.1
 */