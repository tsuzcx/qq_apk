package com.tencent.qqlive.module.videoreport.utils;

import android.support.annotation.RequiresApi;
import android.view.View;

@RequiresApi(api=19)
class ViewCompatUtils$ViewCompatApi19Impl
  extends ViewCompatUtils.ViewCompatApi18Impl
{
  private ViewCompatUtils$ViewCompatApi19Impl()
  {
    super(null);
  }
  
  public boolean isAttachedToWindow(View paramView)
  {
    return paramView.isAttachedToWindow();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.qqlive.module.videoreport.utils.ViewCompatUtils.ViewCompatApi19Impl
 * JD-Core Version:    0.7.0.1
 */