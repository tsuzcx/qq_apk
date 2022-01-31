package com.tencent.smtt.sdk;

import java.util.Set;

public class GeolocationPermissions
{
  private static GeolocationPermissions mInstance;
  
  private static GeolocationPermissions createInstance()
  {
    try
    {
      if (mInstance == null) {
        mInstance = new GeolocationPermissions();
      }
      GeolocationPermissions localGeolocationPermissions = mInstance;
      return localGeolocationPermissions;
    }
    finally {}
  }
  
  public static GeolocationPermissions getInstance()
  {
    return createInstance();
  }
  
  public void allow(String paramString)
  {
    X5CoreEngine localX5CoreEngine = X5CoreEngine.getInstance();
    if ((localX5CoreEngine != null) && (localX5CoreEngine.isX5Core()))
    {
      localX5CoreEngine.wizard().geolocationPermissionsAllow(paramString);
      return;
    }
    android.webkit.GeolocationPermissions.getInstance().allow(paramString);
  }
  
  public void clear(String paramString)
  {
    X5CoreEngine localX5CoreEngine = X5CoreEngine.getInstance();
    if ((localX5CoreEngine != null) && (localX5CoreEngine.isX5Core()))
    {
      localX5CoreEngine.wizard().geolocationPermissionsClear(paramString);
      return;
    }
    android.webkit.GeolocationPermissions.getInstance().clear(paramString);
  }
  
  public void clearAll()
  {
    X5CoreEngine localX5CoreEngine = X5CoreEngine.getInstance();
    if ((localX5CoreEngine != null) && (localX5CoreEngine.isX5Core()))
    {
      localX5CoreEngine.wizard().geolocationPermissionsClearAll();
      return;
    }
    android.webkit.GeolocationPermissions.getInstance().clearAll();
  }
  
  public void getAllowed(String paramString, ValueCallback<Boolean> paramValueCallback)
  {
    X5CoreEngine localX5CoreEngine = X5CoreEngine.getInstance();
    if ((localX5CoreEngine != null) && (localX5CoreEngine.isX5Core()))
    {
      localX5CoreEngine.wizard().geolocationPermissionsGetAllowed(paramString, paramValueCallback);
      return;
    }
    android.webkit.GeolocationPermissions.getInstance().getAllowed(paramString, paramValueCallback);
  }
  
  public void getOrigins(ValueCallback<Set<String>> paramValueCallback)
  {
    X5CoreEngine localX5CoreEngine = X5CoreEngine.getInstance();
    if ((localX5CoreEngine != null) && (localX5CoreEngine.isX5Core()))
    {
      localX5CoreEngine.wizard().geolocationPermissionsGetOrigins(paramValueCallback);
      return;
    }
    android.webkit.GeolocationPermissions.getInstance().getOrigins(paramValueCallback);
  }
  
  public static abstract interface Callback
  {
    public abstract void invoke(String paramString, boolean paramBoolean1, boolean paramBoolean2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.smtt.sdk.GeolocationPermissions
 * JD-Core Version:    0.7.0.1
 */