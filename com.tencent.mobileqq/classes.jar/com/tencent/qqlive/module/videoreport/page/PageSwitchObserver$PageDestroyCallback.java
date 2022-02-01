package com.tencent.qqlive.module.videoreport.page;

import android.support.annotation.NonNull;
import android.view.View;
import com.tencent.qqlive.module.videoreport.utils.ListenerMgr.INotifyCallback;

class PageSwitchObserver$PageDestroyCallback
  implements ListenerMgr.INotifyCallback<PageSwitchObserver.IPageSwitchListener>
{
  private View disappearView;
  private boolean hasNewPageOut;
  
  PageSwitchObserver$PageDestroyCallback(@NonNull View paramView)
  {
    this.disappearView = paramView;
  }
  
  public void onNotify(PageSwitchObserver.IPageSwitchListener paramIPageSwitchListener)
  {
    this.hasNewPageOut = paramIPageSwitchListener.onPageDestroyed(this.disappearView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     com.tencent.qqlive.module.videoreport.page.PageSwitchObserver.PageDestroyCallback
 * JD-Core Version:    0.7.0.1
 */