package com.tencent.open.appstore.cookie;

public class CookieManagerImpl
{
  private android.webkit.CookieManager jdField_a_of_type_AndroidWebkitCookieManager = android.webkit.CookieManager.getInstance();
  private com.tencent.smtt.sdk.CookieManager jdField_a_of_type_ComTencentSmttSdkCookieManager = com.tencent.smtt.sdk.CookieManager.getInstance();
  
  public void a(String paramString1, String paramString2)
  {
    Object localObject = this.jdField_a_of_type_ComTencentSmttSdkCookieManager;
    if (localObject != null) {
      ((com.tencent.smtt.sdk.CookieManager)localObject).setCookie(paramString1, paramString2);
    }
    localObject = this.jdField_a_of_type_AndroidWebkitCookieManager;
    if (localObject != null) {
      ((android.webkit.CookieManager)localObject).setCookie(paramString1, paramString2);
    }
  }
  
  public void a(boolean paramBoolean)
  {
    Object localObject = this.jdField_a_of_type_ComTencentSmttSdkCookieManager;
    if (localObject != null) {
      ((com.tencent.smtt.sdk.CookieManager)localObject).setAcceptCookie(paramBoolean);
    }
    localObject = this.jdField_a_of_type_AndroidWebkitCookieManager;
    if (localObject != null) {
      ((android.webkit.CookieManager)localObject).setAcceptCookie(paramBoolean);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.open.appstore.cookie.CookieManagerImpl
 * JD-Core Version:    0.7.0.1
 */