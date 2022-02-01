package com.tencent.qqlive.module.videoreport.page;

import com.tencent.qqlive.module.videoreport.utils.ListenerMgr.INotifyCallback;
import java.util.Set;

class PageManager$1
  implements ListenerMgr.INotifyCallback<PageManager.IPageListener>
{
  PageManager$1(PageManager paramPageManager, PageInfo paramPageInfo, Set paramSet) {}
  
  public void onNotify(PageManager.IPageListener paramIPageListener)
  {
    paramIPageListener.onPageIn(this.val$pageInfo, this.val$inPageSet);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.qqlive.module.videoreport.page.PageManager.1
 * JD-Core Version:    0.7.0.1
 */