package com.tencent.mobileqq.mini.widget;

import android.app.Activity;
import android.view.View.OnClickListener;
import androidx.annotation.NonNull;

public class LaunchConfirmDialogWrapper$Builder
{
  private View.OnClickListener cancelListener;
  private View.OnClickListener confirmListener;
  private String iconUrl;
  
  public LaunchConfirmDialogWrapper build(@NonNull Activity paramActivity)
  {
    return new LaunchConfirmDialogWrapper(paramActivity, this.iconUrl, this.confirmListener, this.cancelListener, null);
  }
  
  public Builder setCancelListener(View.OnClickListener paramOnClickListener)
  {
    this.cancelListener = paramOnClickListener;
    return this;
  }
  
  public Builder setConfirmListener(View.OnClickListener paramOnClickListener)
  {
    this.confirmListener = paramOnClickListener;
    return this;
  }
  
  public Builder setIconUrl(String paramString)
  {
    this.iconUrl = paramString;
    return this;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.mobileqq.mini.widget.LaunchConfirmDialogWrapper.Builder
 * JD-Core Version:    0.7.0.1
 */