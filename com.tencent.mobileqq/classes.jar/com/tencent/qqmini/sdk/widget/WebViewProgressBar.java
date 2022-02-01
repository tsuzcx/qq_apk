package com.tencent.qqmini.sdk.widget;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.View;
import com.tencent.qqmini.sdk.R.drawable;

public class WebViewProgressBar
  extends View
{
  private static final String LOG_TAG = "WebViewProgressBar";
  private Drawable mBackgroundDrawable;
  private Drawable mContrastDrawable = null;
  private WebViewProgressBarController mController;
  private boolean mEnableAlpha = true;
  private Drawable mProgressDrawable;
  
  public WebViewProgressBar(Context paramContext)
  {
    super(paramContext);
  }
  
  public WebViewProgressBar(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }
  
  public WebViewProgressBar(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
  }
  
  public void onDraw(Canvas paramCanvas)
  {
    super.onDraw(paramCanvas);
    int j;
    int i;
    if ((this.mController != null) && (this.mController.getLoadingStep() != 6))
    {
      if ((this.mContrastDrawable == null) || (this.mProgressDrawable == null)) {
        break label164;
      }
      j = (int)this.mController.getCurrWidth();
      if (j >= this.mProgressDrawable.getIntrinsicWidth()) {
        break label326;
      }
      i = j - this.mProgressDrawable.getIntrinsicWidth();
      j = this.mProgressDrawable.getIntrinsicWidth();
    }
    for (;;)
    {
      if (i + j > 0)
      {
        this.mContrastDrawable.setBounds(0, 0, getWidth(), getHeight());
        this.mContrastDrawable.draw(paramCanvas);
        if (this.mBackgroundDrawable != null)
        {
          this.mBackgroundDrawable.setBounds(0, 0, getWidth(), getHeight());
          this.mBackgroundDrawable.draw(paramCanvas);
        }
      }
      this.mProgressDrawable.setBounds(i, 0, j + i, getHeight());
      this.mProgressDrawable.draw(paramCanvas);
      return;
      label164:
      if (this.mBackgroundDrawable == null) {
        this.mBackgroundDrawable = getContext().getResources().getDrawable(R.drawable.mini_sdk_custom_progress_bg);
      }
      this.mBackgroundDrawable.setBounds(0, 0, getWidth(), getHeight());
      this.mBackgroundDrawable.draw(paramCanvas);
      if (this.mProgressDrawable == null) {
        this.mProgressDrawable = getContext().getResources().getDrawable(R.drawable.mini_sdk_custom_progress_loading);
      }
      j = (int)this.mController.getCurrWidth();
      if (this.mEnableAlpha) {
        this.mProgressDrawable.setAlpha(this.mController.getAlpha());
      }
      if (j < this.mProgressDrawable.getIntrinsicWidth())
      {
        i = j - this.mProgressDrawable.getIntrinsicWidth();
        j = this.mProgressDrawable.getIntrinsicWidth();
      }
      for (;;)
      {
        this.mProgressDrawable.setBounds(i, 0, j + i, getHeight());
        this.mProgressDrawable.draw(paramCanvas);
        return;
        i = 0;
      }
      label326:
      i = 0;
    }
  }
  
  public void onLayout(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    super.onLayout(paramBoolean, paramInt1, paramInt2, paramInt3, paramInt4);
    if (this.mController != null) {
      this.mController.setProgressBarWidth(getWidth());
    }
  }
  
  public void reset()
  {
    this.mBackgroundDrawable = null;
    this.mProgressDrawable = null;
    this.mContrastDrawable = null;
    this.mEnableAlpha = true;
  }
  
  public void setController(WebViewProgressBarController paramWebViewProgressBarController)
  {
    if (this.mController == paramWebViewProgressBarController) {
      return;
    }
    if (this.mController != null) {
      this.mController.setProgressBar(null);
    }
    this.mController = paramWebViewProgressBarController;
    if (this.mController != null)
    {
      this.mController.setProgressBar(this);
      this.mController.setProgressBarWidth(getWidth());
    }
    invalidate();
  }
  
  public void setCustomColor(int paramInt)
  {
    this.mContrastDrawable = new ColorDrawable(-1);
    this.mBackgroundDrawable = new ColorDrawable(paramInt & 0x7FFFFFFF);
    this.mProgressDrawable = new ColorDrawable(paramInt & 0x7FFFFFFF);
    this.mEnableAlpha = false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.qqmini.sdk.widget.WebViewProgressBar
 * JD-Core Version:    0.7.0.1
 */