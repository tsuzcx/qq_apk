package com.tencent.xweb;

import com.tencent.xweb.internal.IWebViewDatabase;
import com.tencent.xweb.internal.l;
import com.tencent.xweb.internal.l.a;

public class z
  implements IWebViewDatabase
{
  public static IWebViewDatabase a()
  {
    return l.a(WebView.getCurWebType()).getWebViewDatabase();
  }
  
  public void a(String paramString1, String paramString2, String paramString3, String paramString4)
  {
    a().a(paramString1, paramString2, paramString3, paramString4);
  }
  
  public String[] a(String paramString1, String paramString2)
  {
    return a().a(paramString1, paramString2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.xweb.z
 * JD-Core Version:    0.7.0.1
 */