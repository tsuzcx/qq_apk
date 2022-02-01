package com.tencent.smtt.sdk;

import android.net.Uri;
import android.os.Build.VERSION;

class SystemWebChromeClient$6
  implements com.tencent.smtt.export.external.interfaces.PermissionRequest
{
  SystemWebChromeClient$6(SystemWebChromeClient paramSystemWebChromeClient, android.webkit.PermissionRequest paramPermissionRequest) {}
  
  public void deny()
  {
    if (Build.VERSION.SDK_INT >= 21) {
      this.a.deny();
    }
  }
  
  public Uri getOrigin()
  {
    if (Build.VERSION.SDK_INT >= 21) {
      return this.a.getOrigin();
    }
    return null;
  }
  
  public String[] getResources()
  {
    if (Build.VERSION.SDK_INT >= 21) {
      return this.a.getResources();
    }
    return new String[0];
  }
  
  public void grant(String[] paramArrayOfString)
  {
    if (Build.VERSION.SDK_INT >= 21) {
      this.a.grant(paramArrayOfString);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.smtt.sdk.SystemWebChromeClient.6
 * JD-Core Version:    0.7.0.1
 */