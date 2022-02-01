package com.tencent.qqlive.module.videoreport.page;

import com.tencent.qqlive.module.videoreport.utils.ListenerMgr.INotifyCallback;

class PageManager$3
  implements ListenerMgr.INotifyCallback<PageManager.IPageListener>
{
  PageManager$3(PageManager paramPageManager, PageInfo paramPageInfo, int paramInt) {}
  
  public void onNotify(PageManager.IPageListener paramIPageListener)
  {
    paramIPageListener.onPageUpdate(this.val$pageInfo, this.val$invokeFrom);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     com.tencent.qqlive.module.videoreport.page.PageManager.3
 * JD-Core Version:    0.7.0.1
 */