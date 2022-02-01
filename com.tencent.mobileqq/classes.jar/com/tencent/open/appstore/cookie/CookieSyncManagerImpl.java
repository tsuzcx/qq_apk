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
    if (this.jdField_a_of_type_ComTencentSmttSdkCookieSyncManager != null) {
      this.jdField_a_of_type_ComTencentSmttSdkCookieSyncManager.sync();
    }
    if (this.jdField_a_of_type_AndroidWebkitCookieSyncManager != null) {
      this.jdField_a_of_type_AndroidWebkitCookieSyncManager.sync();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.open.appstore.cookie.CookieSyncManagerImpl
 * JD-Core Version:    0.7.0.1
 */