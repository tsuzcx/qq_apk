package com.tencent.mobileqq.qqgamepub.web.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.KeyEvent;
import android.view.View;
import com.tencent.biz.ui.TouchWebView;
import com.tencent.mobileqq.qqgamepub.utils.UIUtils;

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
    if ((paramString.startsWith("http://")) || (paramString.startsWith("https://")))
    {
      paramString = this.mILoadingView;
      if ((paramString != null) && (this.useDefaultLoadingLayout)) {
        paramString.a(this);
      }
    }
  }
  
  public boolean onKeyDown(int paramInt, KeyEvent paramKeyEvent)
  {
    boolean bool;
    if (paramInt == 4) {
      bool = handleBack();
    } else {
      bool = false;
    }
    if (bool) {
      return true;
    }
    return super.onKeyDown(paramInt, paramKeyEvent);
  }
  
  public void onPageFinish(String paramString)
  {
    Object localObject = this.mILoadingView;
    if (localObject != null) {
      ((ILoadingView)localObject).hide();
    }
    localObject = this.mIHeaderView;
    if (localObject != null)
    {
      if (((IHeaderView)localObject).isShow(paramString))
      {
        this.mIHeaderView.show();
        setPaddingTop(this.mIHeaderView.getViewHeight());
        return;
      }
      this.mIHeaderView.hide();
    }
  }
  
  protected void onScrollChanged(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    super.onScrollChanged(paramInt1, paramInt2, paramInt3, paramInt4);
    IHeaderView localIHeaderView = this.mIHeaderView;
    if ((localIHeaderView != null) && (!localIHeaderView.isPined())) {
      this.mIHeaderView.onScrollTo(paramInt1, paramInt2, paramInt3, paramInt4);
    }
    this.scrollY = paramInt2;
  }
  
  public void onScrollChanged(int paramInt1, int paramInt2, int paramInt3, int paramInt4, View paramView)
  {
    super.onScrollChanged(paramInt1, paramInt2, paramInt3, paramInt4, paramView);
    paramView = this.mIHeaderView;
    if ((paramView != null) && (!paramView.isPined())) {
      this.mIHeaderView.onScrollTo(paramInt1, paramInt2, paramInt3, paramInt4);
    }
    this.scrollY = paramInt2;
  }
  
  public void setLoadingView(ILoadingView paramILoadingView)
  {
    if ((paramILoadingView == null) || (!this.useDefaultLoadingLayout))
    {
      ILoadingView localILoadingView = this.mILoadingView;
      if (localILoadingView != null) {
        localILoadingView.b(this);
      }
    }
    if (this.mILoadingView == null) {
      this.mILoadingView = paramILoadingView;
    }
    paramILoadingView = this.mILoadingView;
    if (paramILoadingView != null) {
      paramILoadingView.a(this);
    }
    this.useDefaultLoadingLayout = false;
  }
  
  public void setPaddingTop(int paramInt)
  {
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("if (document.body && document.body.style) {document.body.style.paddingTop='");
    ((StringBuilder)localObject).append(UIUtils.a(paramInt, getContext().getResources()));
    ((StringBuilder)localObject).append("px';} void 0");
    localObject = ((StringBuilder)localObject).toString();
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("javascript:");
    localStringBuilder.append((String)localObject);
    loadUrl(localStringBuilder.toString());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.qqgamepub.web.view.BaseNestScrollWebView
 * JD-Core Version:    0.7.0.1
 */