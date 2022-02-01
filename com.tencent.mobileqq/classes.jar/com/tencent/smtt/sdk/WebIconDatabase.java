package com.tencent.smtt.sdk;

import android.content.ContentResolver;

@Deprecated
public class WebIconDatabase
{
  private static WebIconDatabase a;
  
  private static WebIconDatabase a()
  {
    try
    {
      if (a == null) {
        a = new WebIconDatabase();
      }
      WebIconDatabase localWebIconDatabase = a;
      return localWebIconDatabase;
    }
    finally {}
  }
  
  public static WebIconDatabase getInstance()
  {
    return a();
  }
  
  public void bulkRequestIconForPageUrl(ContentResolver paramContentResolver, String paramString, WebIconDatabase.a parama) {}
  
  public void close()
  {
    x localx = x.a();
    if ((localx != null) && (localx.b()))
    {
      localx.c().m();
      return;
    }
    android.webkit.WebIconDatabase.getInstance().close();
  }
  
  public void open(String paramString)
  {
    x localx = x.a();
    if ((localx != null) && (localx.b()))
    {
      localx.c().b(paramString);
      return;
    }
    android.webkit.WebIconDatabase.getInstance().open(paramString);
  }
  
  public void releaseIconForPageUrl(String paramString)
  {
    x localx = x.a();
    if ((localx != null) && (localx.b()))
    {
      localx.c().d(paramString);
      return;
    }
    android.webkit.WebIconDatabase.getInstance().releaseIconForPageUrl(paramString);
  }
  
  public void removeAllIcons()
  {
    x localx = x.a();
    if ((localx != null) && (localx.b()))
    {
      localx.c().l();
      return;
    }
    android.webkit.WebIconDatabase.getInstance().removeAllIcons();
  }
  
  public void requestIconForPageUrl(String paramString, WebIconDatabase.a parama)
  {
    x localx = x.a();
    if ((localx != null) && (localx.b()))
    {
      localx.c().a(paramString, new WebIconDatabase.1(this, parama));
      return;
    }
    android.webkit.WebIconDatabase.getInstance().requestIconForPageUrl(paramString, new WebIconDatabase.2(this, parama));
  }
  
  public void retainIconForPageUrl(String paramString)
  {
    x localx = x.a();
    if ((localx != null) && (localx.b()))
    {
      localx.c().c(paramString);
      return;
    }
    android.webkit.WebIconDatabase.getInstance().retainIconForPageUrl(paramString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     com.tencent.smtt.sdk.WebIconDatabase
 * JD-Core Version:    0.7.0.1
 */