package com.tencent.qqlive.module.videoreport.page;

import com.tencent.qqlive.module.videoreport.utils.ListenerMgr.INotifyCallback;
import java.util.Set;

class PageManager$2
  implements ListenerMgr.INotifyCallback<PageManager.IPageListener>
{
  PageManager$2(PageManager paramPageManager, PageInfo paramPageInfo, Set paramSet, boolean paramBoolean) {}
  
  public void onNotify(PageManager.IPageListener paramIPageListener)
  {
    paramIPageListener.onPageOut(this.val$outPage, this.val$newPageOut, this.val$isMainThread);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     com.tencent.qqlive.module.videoreport.page.PageManager.2
 * JD-Core Version:    0.7.0.1
 */