package com.tencent.open.appstore.cookie;

public class CookieManagerImpl
{
  private com.tencent.smtt.sdk.CookieManager a = com.tencent.smtt.sdk.CookieManager.getInstance();
  private android.webkit.CookieManager b = android.webkit.CookieManager.getInstance();
  
  public void a(String paramString1, String paramString2)
  {
    Object localObject = this.a;
    if (localObject != null) {
      ((com.tencent.smtt.sdk.CookieManager)localObject).setCookie(paramString1, paramString2);
    }
    localObject = this.b;
    if (localObject != null) {
      ((android.webkit.CookieManager)localObject).setCookie(paramString1, paramString2);
    }
  }
  
  public void a(boolean paramBoolean)
  {
    Object localObject = this.a;
    if (localObject != null) {
      ((com.tencent.smtt.sdk.CookieManager)localObject).setAcceptCookie(paramBoolean);
    }
    localObject = this.b;
    if (localObject != null) {
      ((android.webkit.CookieManager)localObject).setAcceptCookie(paramBoolean);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.tencent.open.appstore.cookie.CookieManagerImpl
 * JD-Core Version:    0.7.0.1
 */