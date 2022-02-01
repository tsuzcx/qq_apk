package com.tencent.smtt.sdk;

import com.tencent.smtt.export.external.interfaces.IX5WebBackForwardList;

public class WebBackForwardList
{
  private IX5WebBackForwardList a = null;
  private android.webkit.WebBackForwardList b = null;
  
  static WebBackForwardList a(android.webkit.WebBackForwardList paramWebBackForwardList)
  {
    if (paramWebBackForwardList == null) {
      return null;
    }
    WebBackForwardList localWebBackForwardList = new WebBackForwardList();
    localWebBackForwardList.b = paramWebBackForwardList;
    return localWebBackForwardList;
  }
  
  static WebBackForwardList a(IX5WebBackForwardList paramIX5WebBackForwardList)
  {
    if (paramIX5WebBackForwardList == null) {
      return null;
    }
    WebBackForwardList localWebBackForwardList = new WebBackForwardList();
    localWebBackForwardList.a = paramIX5WebBackForwardList;
    return localWebBackForwardList;
  }
  
  public int getCurrentIndex()
  {
    IX5WebBackForwardList localIX5WebBackForwardList = this.a;
    if (localIX5WebBackForwardList != null) {
      return localIX5WebBackForwardList.getCurrentIndex();
    }
    return this.b.getCurrentIndex();
  }
  
  public WebHistoryItem getCurrentItem()
  {
    IX5WebBackForwardList localIX5WebBackForwardList = this.a;
    if (localIX5WebBackForwardList != null) {
      return WebHistoryItem.a(localIX5WebBackForwardList.getCurrentItem());
    }
    return WebHistoryItem.a(this.b.getCurrentItem());
  }
  
  public WebHistoryItem getItemAtIndex(int paramInt)
  {
    IX5WebBackForwardList localIX5WebBackForwardList = this.a;
    if (localIX5WebBackForwardList != null) {
      return WebHistoryItem.a(localIX5WebBackForwardList.getItemAtIndex(paramInt));
    }
    return WebHistoryItem.a(this.b.getItemAtIndex(paramInt));
  }
  
  public int getSize()
  {
    IX5WebBackForwardList localIX5WebBackForwardList = this.a;
    if (localIX5WebBackForwardList != null) {
      return localIX5WebBackForwardList.getSize();
    }
    return this.b.getSize();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.smtt.sdk.WebBackForwardList
 * JD-Core Version:    0.7.0.1
 */