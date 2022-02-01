package com.tencent.smtt.sdk;

import android.graphics.Bitmap;
import com.tencent.smtt.export.external.interfaces.IX5WebHistoryItem;

public class WebHistoryItem
{
  private IX5WebHistoryItem a = null;
  private android.webkit.WebHistoryItem b = null;
  
  static WebHistoryItem a(android.webkit.WebHistoryItem paramWebHistoryItem)
  {
    if (paramWebHistoryItem == null) {
      return null;
    }
    WebHistoryItem localWebHistoryItem = new WebHistoryItem();
    localWebHistoryItem.b = paramWebHistoryItem;
    return localWebHistoryItem;
  }
  
  static WebHistoryItem a(IX5WebHistoryItem paramIX5WebHistoryItem)
  {
    if (paramIX5WebHistoryItem == null) {
      return null;
    }
    WebHistoryItem localWebHistoryItem = new WebHistoryItem();
    localWebHistoryItem.a = paramIX5WebHistoryItem;
    return localWebHistoryItem;
  }
  
  public Bitmap getFavicon()
  {
    IX5WebHistoryItem localIX5WebHistoryItem = this.a;
    if (localIX5WebHistoryItem != null) {
      return localIX5WebHistoryItem.getFavicon();
    }
    return this.b.getFavicon();
  }
  
  public String getOriginalUrl()
  {
    IX5WebHistoryItem localIX5WebHistoryItem = this.a;
    if (localIX5WebHistoryItem != null) {
      return localIX5WebHistoryItem.getOriginalUrl();
    }
    return this.b.getOriginalUrl();
  }
  
  public String getTitle()
  {
    IX5WebHistoryItem localIX5WebHistoryItem = this.a;
    if (localIX5WebHistoryItem != null) {
      return localIX5WebHistoryItem.getTitle();
    }
    return this.b.getTitle();
  }
  
  public String getUrl()
  {
    IX5WebHistoryItem localIX5WebHistoryItem = this.a;
    if (localIX5WebHistoryItem != null) {
      return localIX5WebHistoryItem.getUrl();
    }
    return this.b.getUrl();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     com.tencent.smtt.sdk.WebHistoryItem
 * JD-Core Version:    0.7.0.1
 */