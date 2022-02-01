package com.tencent.qqlive.module.videoreport.utils;

import android.support.annotation.RequiresApi;
import android.view.ViewGroup;

@RequiresApi(api=21)
class ViewCompatUtils$ViewCompatApi21Impl
  extends ViewCompatUtils.ViewCompatApi19Impl
{
  private ViewCompatUtils$ViewCompatApi21Impl()
  {
    super(null);
  }
  
  public boolean getClipToPadding(ViewGroup paramViewGroup)
  {
    return paramViewGroup.getClipToPadding();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.qqlive.module.videoreport.utils.ViewCompatUtils.ViewCompatApi21Impl
 * JD-Core Version:    0.7.0.1
 */