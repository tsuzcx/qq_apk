package com.tencent.mobileqq.qqgift.webview;

import com.tencent.mobileqq.webview.cookie.IBrowserCookieInjector;
import com.tencent.mobileqq.webview.swift.component.SwiftBrowserCookieMonster;
import java.util.ArrayList;
import java.util.List;

public class QQGiftPsKeyCookieInjector
  implements IBrowserCookieInjector
{
  public List<String> a(String paramString)
  {
    if (!paramString.contains("qlive.qq.com")) {
      return null;
    }
    paramString = QQGiftCookieManager.a().b();
    if (paramString != null)
    {
      paramString = SwiftBrowserCookieMonster.a("p_skey", paramString, "qlive.qq.com", false);
      ArrayList localArrayList = new ArrayList(1);
      localArrayList.add(paramString);
      return localArrayList;
    }
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.qqgift.webview.QQGiftPsKeyCookieInjector
 * JD-Core Version:    0.7.0.1
 */