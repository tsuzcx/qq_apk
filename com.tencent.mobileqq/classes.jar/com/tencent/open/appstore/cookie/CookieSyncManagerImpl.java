package com.tencent.open.appstore.cookie;

import android.content.Context;

public class CookieSyncManagerImpl
{
  private android.webkit.CookieSyncManager jdField_a_of_type_AndroidWebkitCookieSyncManager;
  private com.tencent.smtt.sdk.CookieSyncManager jdField_a_of_type_ComTencentSmttSdkCookieSyncManager;
  
  public CookieSyncManagerImpl(Context paramContext)
  {
    this.jdField_a_of_type_ComTencentSmttSdkCookieSyncManager = com.tencent.smtt.sdk.CookieSyncManager.createInstance(paramContext);
    this.jdField_a_of_type_AndroidWebkitCookieSyncManager = android.webkit.CookieSyncManager.createInstance(paramContext);
  }
  
  public void a()
  {
    Object localObject = this.jdField_a_of_type_ComTencentSmttSdkCookieSyncManager;
    if (localObject != null) {
      ((com.tencent.smtt.sdk.CookieSyncManager)localObject).sync();
    }
    localObject = this.jdField_a_of_type_AndroidWebkitCookieSyncManager;
    if (localObject != null) {
      ((android.webkit.CookieSyncManager)localObject).sync();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.open.appstore.cookie.CookieSyncManagerImpl
 * JD-Core Version:    0.7.0.1
 */