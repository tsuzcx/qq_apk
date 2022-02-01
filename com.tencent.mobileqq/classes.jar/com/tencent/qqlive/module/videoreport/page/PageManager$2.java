package com.tencent.qqlive.module.videoreport.page;

import com.tencent.qqlive.module.videoreport.utils.ListenerMgr.INotifyCallback;

class PageManager$2
  implements ListenerMgr.INotifyCallback<PageManager.IPageListener>
{
  PageManager$2(PageManager paramPageManager, PageInfo paramPageInfo, boolean paramBoolean) {}
  
  public void onNotify(PageManager.IPageListener paramIPageListener)
  {
    paramIPageListener.onPageOut(this.val$pageInfo, this.val$isMainThread);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.qqlive.module.videoreport.page.PageManager.2
 * JD-Core Version:    0.7.0.1
 */