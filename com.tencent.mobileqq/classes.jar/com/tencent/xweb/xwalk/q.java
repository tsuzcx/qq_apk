package com.tencent.xweb.xwalk;

import android.webkit.WebBackForwardList;
import android.webkit.WebHistoryItem;
import org.xwalk.core.XWalkNavigationHistory;

public class q
  extends WebBackForwardList
{
  XWalkNavigationHistory a;
  
  public q(XWalkNavigationHistory paramXWalkNavigationHistory)
  {
    this.a = paramXWalkNavigationHistory;
  }
  
  protected WebBackForwardList clone()
  {
    return new q(this.a);
  }
  
  public int getCurrentIndex()
  {
    Object localObject = this.a;
    if (localObject == null) {
      localObject = null;
    } else {
      localObject = Integer.valueOf(((XWalkNavigationHistory)localObject).getCurrentIndex());
    }
    return ((Integer)localObject).intValue();
  }
  
  public WebHistoryItem getCurrentItem()
  {
    XWalkNavigationHistory localXWalkNavigationHistory = this.a;
    if (localXWalkNavigationHistory == null) {
      return null;
    }
    return new r(localXWalkNavigationHistory.getCurrentItem());
  }
  
  public WebHistoryItem getItemAtIndex(int paramInt)
  {
    XWalkNavigationHistory localXWalkNavigationHistory = this.a;
    if (localXWalkNavigationHistory == null) {
      return null;
    }
    return new r(localXWalkNavigationHistory.getItemAt(paramInt));
  }
  
  public int getSize()
  {
    Object localObject = this.a;
    if (localObject == null) {
      localObject = null;
    } else {
      localObject = Integer.valueOf(((XWalkNavigationHistory)localObject).size());
    }
    return ((Integer)localObject).intValue();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.tencent.xweb.xwalk.q
 * JD-Core Version:    0.7.0.1
 */