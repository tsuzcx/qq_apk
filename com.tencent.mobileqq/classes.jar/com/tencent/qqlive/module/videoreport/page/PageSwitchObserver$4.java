package com.tencent.qqlive.module.videoreport.page;

import com.tencent.qqlive.module.videoreport.utils.ListenerMgr.INotifyCallback;

class PageSwitchObserver$4
  implements ListenerMgr.INotifyCallback<PageSwitchObserver.IPageSwitchListener>
{
  PageSwitchObserver$4(PageSwitchObserver paramPageSwitchObserver) {}
  
  public void onNotify(PageSwitchObserver.IPageSwitchListener paramIPageSwitchListener)
  {
    paramIPageSwitchListener.onPageDisappear();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.qqlive.module.videoreport.page.PageSwitchObserver.4
 * JD-Core Version:    0.7.0.1
 */