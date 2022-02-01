package com.tencent.xweb.xwalk;

import android.graphics.Bitmap;
import android.webkit.WebHistoryItem;
import org.xwalk.core.XWalkNavigationItem;

public class r
  extends WebHistoryItem
{
  XWalkNavigationItem a;
  
  public r(XWalkNavigationItem paramXWalkNavigationItem)
  {
    this.a = paramXWalkNavigationItem;
  }
  
  protected WebHistoryItem clone()
  {
    return new r(this.a);
  }
  
  public Bitmap getFavicon()
  {
    return null;
  }
  
  public String getOriginalUrl()
  {
    XWalkNavigationItem localXWalkNavigationItem = this.a;
    if (localXWalkNavigationItem == null) {
      return null;
    }
    return localXWalkNavigationItem.getOriginalUrl();
  }
  
  public String getTitle()
  {
    XWalkNavigationItem localXWalkNavigationItem = this.a;
    if (localXWalkNavigationItem == null) {
      return null;
    }
    return localXWalkNavigationItem.getTitle();
  }
  
  public String getUrl()
  {
    XWalkNavigationItem localXWalkNavigationItem = this.a;
    if (localXWalkNavigationItem == null) {
      return null;
    }
    return localXWalkNavigationItem.getUrl();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.tencent.xweb.xwalk.r
 * JD-Core Version:    0.7.0.1
 */