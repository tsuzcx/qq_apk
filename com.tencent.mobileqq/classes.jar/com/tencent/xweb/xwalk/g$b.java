package com.tencent.xweb.xwalk;

import android.webkit.GeolocationPermissions.Callback;
import org.xwalk.core.XWalkGeolocationPermissionsCallback;

public class g$b
  implements GeolocationPermissions.Callback
{
  XWalkGeolocationPermissionsCallback a;
  
  public g$b(XWalkGeolocationPermissionsCallback paramXWalkGeolocationPermissionsCallback)
  {
    this.a = paramXWalkGeolocationPermissionsCallback;
  }
  
  public void invoke(String paramString, boolean paramBoolean1, boolean paramBoolean2)
  {
    XWalkGeolocationPermissionsCallback localXWalkGeolocationPermissionsCallback = this.a;
    if (localXWalkGeolocationPermissionsCallback != null) {
      localXWalkGeolocationPermissionsCallback.invoke(paramString, paramBoolean1, paramBoolean2);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.tencent.xweb.xwalk.g.b
 * JD-Core Version:    0.7.0.1
 */