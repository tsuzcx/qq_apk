package com.tencent.qqlive.module.videoreport.page;

import com.tencent.qqlive.module.videoreport.utils.ListenerMgr.INotifyCallback;

class PageSwitchObserver$3
  implements ListenerMgr.INotifyCallback<PageSwitchObserver.IPageSwitchListener>
{
  PageSwitchObserver$3(PageSwitchObserver paramPageSwitchObserver, PageInfo paramPageInfo, int paramInt) {}
  
  public void onNotify(PageSwitchObserver.IPageSwitchListener paramIPageSwitchListener)
  {
    paramIPageSwitchListener.onPageAppear(this.val$pageInfo, this.val$invokeFrom);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.qqlive.module.videoreport.page.PageSwitchObserver.3
 * JD-Core Version:    0.7.0.1
 */