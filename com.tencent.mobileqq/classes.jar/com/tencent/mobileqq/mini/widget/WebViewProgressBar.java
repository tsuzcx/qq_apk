package com.tencent.mobileqq.mini.widget;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.View;
import com.tencent.qphone.base.util.QLog;

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
    Object localObject = this.mController;
    if ((localObject != null) && (((WebViewProgressBarController)localObject).getLoadingStep() != 6))
    {
      int i;
      if ((this.mContrastDrawable != null) && (this.mProgressDrawable != null))
      {
        j = (int)this.mController.getCurrWidth();
        if (j < this.mProgressDrawable.getIntrinsicWidth())
        {
          i = j - this.mProgressDrawable.getIntrinsicWidth();
          j = this.mProgressDrawable.getIntrinsicWidth();
        }
        else
        {
          i = 0;
        }
        j += i;
        if (j > 0)
        {
          this.mContrastDrawable.setBounds(0, 0, getWidth(), getHeight());
          this.mContrastDrawable.draw(paramCanvas);
          localObject = this.mBackgroundDrawable;
          if (localObject != null)
          {
            ((Drawable)localObject).setBounds(0, 0, getWidth(), getHeight());
            this.mBackgroundDrawable.draw(paramCanvas);
          }
        }
        this.mProgressDrawable.setBounds(i, 0, j, getHeight());
        this.mProgressDrawable.draw(paramCanvas);
        return;
      }
      if (this.mBackgroundDrawable == null) {
        this.mBackgroundDrawable = getContext().getResources().getDrawable(2130852202);
      }
      this.mBackgroundDrawable.setBounds(0, 0, getWidth(), getHeight());
      this.mBackgroundDrawable.draw(paramCanvas);
      if (this.mProgressDrawable == null) {
        this.mProgressDrawable = getContext().getResources().getDrawable(2130852203);
      }
      int j = (int)this.mController.getCurrWidth();
      if (this.mEnableAlpha) {
        this.mProgressDrawable.setAlpha(this.mController.getAlpha());
      }
      if (j < this.mProgressDrawable.getIntrinsicWidth())
      {
        i = j - this.mProgressDrawable.getIntrinsicWidth();
        j = this.mProgressDrawable.getIntrinsicWidth();
      }
      else
      {
        i = 0;
      }
      this.mProgressDrawable.setBounds(i, 0, j + i, getHeight());
      this.mProgressDrawable.draw(paramCanvas);
    }
  }
  
  protected void onLayout(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    super.onLayout(paramBoolean, paramInt1, paramInt2, paramInt3, paramInt4);
    WebViewProgressBarController localWebViewProgressBarController = this.mController;
    if (localWebViewProgressBarController != null) {
      localWebViewProgressBarController.setProgressBarWidth(getWidth());
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
    WebViewProgressBarController localWebViewProgressBarController = this.mController;
    if (localWebViewProgressBarController == paramWebViewProgressBarController) {
      return;
    }
    if (localWebViewProgressBarController != null) {
      localWebViewProgressBarController.setProgressBar(null);
    }
    this.mController = paramWebViewProgressBarController;
    paramWebViewProgressBarController = this.mController;
    if (paramWebViewProgressBarController != null)
    {
      paramWebViewProgressBarController.setProgressBar(this);
      this.mController.setProgressBarWidth(getWidth());
    }
    invalidate();
  }
  
  public void setCustomColor(int paramInt)
  {
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("setCustomColor color=");
      localStringBuilder.append(Integer.toHexString(paramInt));
      QLog.d("WebViewProgressBar", 2, localStringBuilder.toString());
    }
    this.mContrastDrawable = new ColorDrawable(-1);
    paramInt &= 0x7FFFFFFF;
    this.mBackgroundDrawable = new ColorDrawable(paramInt);
    this.mProgressDrawable = new ColorDrawable(paramInt);
    this.mEnableAlpha = false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.mobileqq.mini.widget.WebViewProgressBar
 * JD-Core Version:    0.7.0.1
 */