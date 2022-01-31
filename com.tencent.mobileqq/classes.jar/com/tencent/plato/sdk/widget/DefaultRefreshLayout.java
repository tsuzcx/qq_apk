package com.tencent.plato.sdk.widget;

import android.content.Context;
import android.view.ViewGroup.LayoutParams;
import android.widget.FrameLayout;
import android.widget.FrameLayout.LayoutParams;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.ProgressBar;
import android.widget.TextView;

public class DefaultRefreshLayout
  extends FrameLayout
{
  protected ProgressBar mHeaderProgress;
  protected TextView mHeaderText;
  private LinearLayout mInnerLayout;
  protected final PullToRefreshBase.Mode mMode;
  private CharSequence mPullLabel;
  private CharSequence mRefreshingLabel;
  private CharSequence mReleaseLabel;
  
  public DefaultRefreshLayout(Context paramContext, PullToRefreshBase.Mode paramMode)
  {
    super(paramContext);
    this.mMode = paramMode;
    this.mInnerLayout = new LinearLayout(paramContext);
    Object localObject = new FrameLayout.LayoutParams(-1, -2);
    ((FrameLayout.LayoutParams)localObject).gravity = 17;
    this.mInnerLayout.setLayoutParams((ViewGroup.LayoutParams)localObject);
    this.mInnerLayout.setPadding(24, 12, 24, 5);
    this.mInnerLayout.setGravity(17);
    this.mInnerLayout.setOrientation(0);
    addView(this.mInnerLayout);
    this.mHeaderText = new TextView(paramContext);
    localObject = new LinearLayout.LayoutParams(-2, -2);
    ((LinearLayout.LayoutParams)localObject).topMargin = 15;
    ((LinearLayout.LayoutParams)localObject).bottomMargin = 15;
    this.mHeaderText.setSingleLine(true);
    this.mHeaderText.setTextSize(15.0F);
    this.mHeaderText.setTextColor(-8355712);
    this.mHeaderProgress = new ProgressBar(paramContext, null, 16843400);
    paramContext = new LinearLayout.LayoutParams(-2, -2);
    paramContext.bottomMargin = 15;
    paramContext.topMargin = 15;
    paramContext.rightMargin = 25;
    this.mInnerLayout.addView(this.mHeaderProgress, paramContext);
    this.mInnerLayout.addView(this.mHeaderText, (ViewGroup.LayoutParams)localObject);
    paramContext = (FrameLayout.LayoutParams)this.mInnerLayout.getLayoutParams();
    switch (1.$SwitchMap$com$tencent$plato$sdk$widget$PullToRefreshBase$Mode[paramMode.ordinal()])
    {
    default: 
      paramContext.gravity = 80;
      this.mPullLabel = "下拉刷新";
      this.mRefreshingLabel = "正在刷新";
    }
    for (this.mReleaseLabel = "释放刷新";; this.mReleaseLabel = "释放加载")
    {
      reset();
      return;
      paramContext.gravity = 48;
      this.mPullLabel = "上拉加载";
      this.mRefreshingLabel = "正在加载";
    }
  }
  
  public final int getContentSize()
  {
    return this.mInnerLayout.getHeight();
  }
  
  public final LinearLayout getInnerLayout()
  {
    return this.mInnerLayout;
  }
  
  public final void pullToRefresh()
  {
    if (this.mHeaderText != null) {
      this.mHeaderText.setText(this.mPullLabel);
    }
  }
  
  public final void refreshing()
  {
    if (this.mHeaderText != null) {
      this.mHeaderText.setText(this.mRefreshingLabel);
    }
  }
  
  public final void releaseToRefresh()
  {
    if (this.mHeaderText != null) {
      this.mHeaderText.setText(this.mReleaseLabel);
    }
  }
  
  public final void reset()
  {
    if (this.mHeaderText != null) {
      this.mHeaderText.setText(this.mPullLabel);
    }
  }
  
  public final void setHeight(int paramInt)
  {
    getLayoutParams().height = paramInt;
    requestLayout();
  }
  
  public void setPullLabel(CharSequence paramCharSequence)
  {
    this.mPullLabel = paramCharSequence;
  }
  
  public void setRefreshingLabel(CharSequence paramCharSequence)
  {
    this.mRefreshingLabel = paramCharSequence;
  }
  
  public void setReleaseLabel(CharSequence paramCharSequence)
  {
    this.mReleaseLabel = paramCharSequence;
  }
  
  public final void setWidth(int paramInt)
  {
    getLayoutParams().width = paramInt;
    requestLayout();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.plato.sdk.widget.DefaultRefreshLayout
 * JD-Core Version:    0.7.0.1
 */