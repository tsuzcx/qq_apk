package com.tencent.mobileqq.qqgamepub.web.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;

public class QQGamePubWebView
  extends BaseNestScrollWebView
{
  private QQGamePubWebView.HeadViewVisibleListener b;
  
  public QQGamePubWebView(Context paramContext)
  {
    super(paramContext);
  }
  
  public QQGamePubWebView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }
  
  public void h()
  {
    this.b = null;
  }
  
  public void onPageFinish(String paramString) {}
  
  protected void onScrollChanged(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    super.onScrollChanged(paramInt1, paramInt2, paramInt3, paramInt4);
  }
  
  public void onScrollChanged(int paramInt1, int paramInt2, int paramInt3, int paramInt4, View paramView)
  {
    super.onScrollChanged(paramInt1, paramInt2, paramInt3, paramInt4, paramView);
    paramView = this.b;
    if (paramView != null) {
      paramView.a(paramInt2, paramInt4);
    }
  }
  
  public void setPaddingTop(int paramInt)
  {
    super.setPaddingTop(paramInt);
  }
  
  public void setViewVisibleListener(QQGamePubWebView.HeadViewVisibleListener paramHeadViewVisibleListener)
  {
    this.b = paramHeadViewVisibleListener;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.qqgamepub.web.view.QQGamePubWebView
 * JD-Core Version:    0.7.0.1
 */