package com.tencent.qqlive.module.videoreport.page;

import android.graphics.Rect;
import android.view.MotionEvent;
import android.view.View;
import android.view.Window;
import com.tencent.qqlive.module.videoreport.collect.DefaultEventListener;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqlive.module.videoreport.data.DataRWProxy;

class PageInteractiveFlagHandler
  extends DefaultEventListener
{
  private final PageManager mPageManager;
  private final Rect mRect = new Rect();
  
  private PageInteractiveFlagHandler(PageManager paramPageManager)
  {
    this.mPageManager = paramPageManager;
  }
  
  static PageInteractiveFlagHandler create(PageManager paramPageManager)
  {
    paramPageManager = new PageInteractiveFlagHandler(paramPageManager);
    EventCollector.getInstance().registerEventListener(paramPageManager);
    return paramPageManager;
  }
  
  private void markInteractiveFlagToPage(PageInfo paramPageInfo)
  {
    DataRWProxy.setInnerParam(paramPageInfo.getPage(), "page_interactive_flag", Boolean.valueOf(true));
  }
  
  private boolean needMarkInteractiveFlag(Window paramWindow, MotionEvent paramMotionEvent, boolean paramBoolean1, boolean paramBoolean2, PageInfo paramPageInfo)
  {
    if ((paramMotionEvent.getAction() == 0) || (!paramBoolean1)) {
      return false;
    }
    if ((paramBoolean2) || (paramPageInfo == null)) {
      return false;
    }
    Object localObject = paramPageInfo.getPage();
    paramPageInfo = paramPageInfo.getPageView();
    if ((localObject == null) || (paramPageInfo == null)) {
      return false;
    }
    localObject = DataRWProxy.getInnerParam(localObject, "page_interactive_flag");
    if (((localObject instanceof Boolean)) && (((Boolean)localObject).booleanValue())) {
      return false;
    }
    if (paramWindow == null) {}
    for (paramWindow = null;; paramWindow = paramWindow.getDecorView())
    {
      localObject = paramPageInfo.getRootView();
      if ((paramWindow != null) && (paramWindow == localObject)) {
        break;
      }
      return false;
    }
    if (!paramPageInfo.getGlobalVisibleRect(this.mRect)) {
      return false;
    }
    return this.mRect.contains((int)paramMotionEvent.getX(), (int)paramMotionEvent.getY());
  }
  
  public void onDispatchTouchEvent(Object paramObject, Window paramWindow, MotionEvent paramMotionEvent, boolean paramBoolean)
  {
    if (!needMarkInteractiveFlag(paramWindow, paramMotionEvent, paramBoolean, this.mPageManager.isLastPageIsDisappear(), this.mPageManager.getCurrentPageInfo())) {
      return;
    }
    markInteractiveFlagToPage(this.mPageManager.getCurrentPageInfo());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.qqlive.module.videoreport.page.PageInteractiveFlagHandler
 * JD-Core Version:    0.7.0.1
 */