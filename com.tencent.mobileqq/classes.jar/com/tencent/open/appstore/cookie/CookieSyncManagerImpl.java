package com.tencent.open.appstore.cookie;

import android.content.Context;

public class CookieSyncManagerImpl
{
  private com.tencent.smtt.sdk.CookieSyncManager a;
  private android.webkit.CookieSyncManager b;
  
  public CookieSyncManagerImpl(Context paramContext)
  {
    this.a = com.tencent.smtt.sdk.CookieSyncManager.createInstance(paramContext);
    this.b = android.webkit.CookieSyncManager.createInstance(paramContext);
  }
  
  public void a()
  {
    Object localObject = this.a;
    if (localObject != null) {
      ((com.tencent.smtt.sdk.CookieSyncManager)localObject).sync();
    }
    localObject = this.b;
    if (localObject != null) {
      ((android.webkit.CookieSyncManager)localObject).sync();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.tencent.open.appstore.cookie.CookieSyncManagerImpl
 * JD-Core Version:    0.7.0.1
 */