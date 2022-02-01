package com.tencent.qqlive.module.videoreport.page;

import com.tencent.qqlive.module.videoreport.utils.ListenerMgr.INotifyCallback;

class PageManager$1
  implements ListenerMgr.INotifyCallback<PageManager.IPageListener>
{
  PageManager$1(PageManager paramPageManager, PageInfo paramPageInfo) {}
  
  public void onNotify(PageManager.IPageListener paramIPageListener)
  {
    paramIPageListener.onPageIn(this.val$pageInfo);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.qqlive.module.videoreport.page.PageManager.1
 * JD-Core Version:    0.7.0.1
 */