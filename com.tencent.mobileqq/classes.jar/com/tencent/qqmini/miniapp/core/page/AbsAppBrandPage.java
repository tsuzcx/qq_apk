package com.tencent.qqmini.miniapp.core.page;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import com.tencent.qqmini.miniapp.core.page.swipe.SwipeBackLayout;
import com.tencent.qqmini.sdk.widget.NavigationBar;

public abstract class AbsAppBrandPage
  extends SwipeBackLayout
{
  public AbsAppBrandPage(Context paramContext)
  {
    super(paramContext);
    setLayoutParams(new ViewGroup.LayoutParams(-1, -1));
    this.mContentView = createContentView();
    if (this.mContentView != null) {
      addView(this.mContentView, new ViewGroup.LayoutParams(-1, -1));
    }
  }
  
  public abstract View createContentView();
  
  public abstract String getCurShowingUrl();
  
  public PageWebview getCurrentPageWebview()
  {
    return null;
  }
  
  public abstract NavigationBar getNaviBar();
  
  public PageWebviewContainer getPageWebviewContainer()
  {
    return null;
  }
  
  public abstract AppBrandPageContainer getRootContainer();
  
  public abstract boolean isCustomNavibar();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     com.tencent.qqmini.miniapp.core.page.AbsAppBrandPage
 * JD-Core Version:    0.7.0.1
 */