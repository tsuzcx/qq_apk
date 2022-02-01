package com.tencent.qqlive.module.videoreport.page;

import com.tencent.qqlive.module.videoreport.utils.ListenerMgr.INotifyCallback;

class PageSwitchObserver$2
  implements ListenerMgr.INotifyCallback<PageSwitchObserver.IPageSwitchListener>
{
  PageSwitchObserver$2(PageSwitchObserver paramPageSwitchObserver, PageInfo paramPageInfo) {}
  
  public void onNotify(PageSwitchObserver.IPageSwitchListener paramIPageSwitchListener)
  {
    paramIPageSwitchListener.onPageAppear(this.val$pageInfo);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.qqlive.module.videoreport.page.PageSwitchObserver.2
 * JD-Core Version:    0.7.0.1
 */