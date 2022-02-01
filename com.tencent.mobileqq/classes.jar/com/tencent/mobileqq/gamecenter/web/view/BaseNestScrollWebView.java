package com.tencent.mobileqq.gamecenter.web.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.KeyEvent;
import android.view.View;
import com.tencent.biz.qqstory.utils.UIUtils;
import com.tencent.biz.ui.TouchWebView;

public abstract class BaseNestScrollWebView
  extends TouchWebView
{
  public IHeaderView mIHeaderView;
  private ILoadingView mILoadingView;
  public int scrollY;
  public boolean useDefaultLoadingLayout = true;
  
  public BaseNestScrollWebView(Context paramContext)
  {
    super(paramContext);
  }
  
  public BaseNestScrollWebView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }
  
  public void attachHeaderView(IHeaderView paramIHeaderView)
  {
    this.mIHeaderView = paramIHeaderView;
  }
  
  public boolean handleBack()
  {
    if (canGoBack())
    {
      goBack();
      return true;
    }
    return false;
  }
  
  public void loadUrl(String paramString)
  {
    super.loadUrl(paramString);
    if (((paramString.startsWith("http://")) || (paramString.startsWith("https://"))) && (this.mILoadingView != null) && (this.useDefaultLoadingLayout)) {
      this.mILoadingView.a(this);
    }
  }
  
  public boolean onKeyDown(int paramInt, KeyEvent paramKeyEvent)
  {
    boolean bool = false;
    if (paramInt == 4) {
      bool = handleBack();
    }
    if (bool) {
      return true;
    }
    return super.onKeyDown(paramInt, paramKeyEvent);
  }
  
  public void onPageFinish(String paramString)
  {
    if (this.mILoadingView != null) {
      this.mILoadingView.hide();
    }
    if (this.mIHeaderView != null)
    {
      if (this.mIHeaderView.isShow(paramString))
      {
        this.mIHeaderView.show();
        setPaddingTop(this.mIHeaderView.getViewHeight());
      }
    }
    else {
      return;
    }
    this.mIHeaderView.hide();
  }
  
  public void onScrollChanged(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    super.onScrollChanged(paramInt1, paramInt2, paramInt3, paramInt4);
    if ((this.mIHeaderView != null) && (!this.mIHeaderView.isPined())) {
      this.mIHeaderView.onScrollTo(paramInt1, paramInt2, paramInt3, paramInt4);
    }
    this.scrollY = paramInt2;
  }
  
  public void onScrollChanged(int paramInt1, int paramInt2, int paramInt3, int paramInt4, View paramView)
  {
    super.onScrollChanged(paramInt1, paramInt2, paramInt3, paramInt4, paramView);
    if ((this.mIHeaderView != null) && (!this.mIHeaderView.isPined())) {
      this.mIHeaderView.onScrollTo(paramInt1, paramInt2, paramInt3, paramInt4);
    }
    this.scrollY = paramInt2;
  }
  
  public void setLoadingView(ILoadingView paramILoadingView)
  {
    if (((paramILoadingView == null) || (!this.useDefaultLoadingLayout)) && (this.mILoadingView != null)) {
      this.mILoadingView.b(this);
    }
    if (this.mILoadingView == null) {
      this.mILoadingView = paramILoadingView;
    }
    if (this.mILoadingView != null) {
      this.mILoadingView.a(this);
    }
    this.useDefaultLoadingLayout = false;
  }
  
  public void setPaddingTop(int paramInt)
  {
    String str = "if (document.body && document.body.style) {document.body.style.paddingTop='" + UIUtils.a(getContext(), paramInt) + "px';} void 0";
    loadUrl("javascript:" + str);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.gamecenter.web.view.BaseNestScrollWebView
 * JD-Core Version:    0.7.0.1
 */