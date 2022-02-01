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
    v localv = v.a();
    if ((localv != null) && (localv.b()))
    {
      localv.c().m();
      return;
    }
    android.webkit.WebIconDatabase.getInstance().close();
  }
  
  public void open(String paramString)
  {
    v localv = v.a();
    if ((localv != null) && (localv.b()))
    {
      localv.c().b(paramString);
      return;
    }
    android.webkit.WebIconDatabase.getInstance().open(paramString);
  }
  
  public void releaseIconForPageUrl(String paramString)
  {
    v localv = v.a();
    if ((localv != null) && (localv.b()))
    {
      localv.c().d(paramString);
      return;
    }
    android.webkit.WebIconDatabase.getInstance().releaseIconForPageUrl(paramString);
  }
  
  public void removeAllIcons()
  {
    v localv = v.a();
    if ((localv != null) && (localv.b()))
    {
      localv.c().l();
      return;
    }
    android.webkit.WebIconDatabase.getInstance().removeAllIcons();
  }
  
  public void requestIconForPageUrl(String paramString, WebIconDatabase.a parama)
  {
    v localv = v.a();
    if ((localv != null) && (localv.b()))
    {
      localv.c().a(paramString, new WebIconDatabase.1(this, parama));
      return;
    }
    android.webkit.WebIconDatabase.getInstance().requestIconForPageUrl(paramString, new WebIconDatabase.2(this, parama));
  }
  
  public void retainIconForPageUrl(String paramString)
  {
    v localv = v.a();
    if ((localv != null) && (localv.b()))
    {
      localv.c().c(paramString);
      return;
    }
    android.webkit.WebIconDatabase.getInstance().retainIconForPageUrl(paramString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.smtt.sdk.WebIconDatabase
 * JD-Core Version:    0.7.0.1
 */