package com.tencent.mobileqq.webview;

import android.os.Bundle;

class UrlSecurityCheckManager$1
  implements UrlSecurityCheckManager.OnCheckResult
{
  UrlSecurityCheckManager$1(UrlSecurityCheckManager paramUrlSecurityCheckManager) {}
  
  public void a(Bundle paramBundle)
  {
    if (this.a.c) {
      return;
    }
    paramBundle = this.a;
    paramBundle.b = false;
    UrlSecurityCheckManager.a(paramBundle);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.webview.UrlSecurityCheckManager.1
 * JD-Core Version:    0.7.0.1
 */