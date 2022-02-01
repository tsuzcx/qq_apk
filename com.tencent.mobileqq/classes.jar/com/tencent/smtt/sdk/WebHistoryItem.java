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
    if (this.a != null) {
      return this.a.getFavicon();
    }
    return this.b.getFavicon();
  }
  
  public String getOriginalUrl()
  {
    if (this.a != null) {
      return this.a.getOriginalUrl();
    }
    return this.b.getOriginalUrl();
  }
  
  public String getTitle()
  {
    if (this.a != null) {
      return this.a.getTitle();
    }
    return this.b.getTitle();
  }
  
  public String getUrl()
  {
    if (this.a != null) {
      return this.a.getUrl();
    }
    return this.b.getUrl();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.smtt.sdk.WebHistoryItem
 * JD-Core Version:    0.7.0.1
 */