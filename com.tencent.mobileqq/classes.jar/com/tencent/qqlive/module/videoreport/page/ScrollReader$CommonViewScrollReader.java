package com.tencent.qqlive.module.videoreport.page;

import android.view.View;

class ScrollReader$CommonViewScrollReader
  implements IScrollReader
{
  public int readScroll(View paramView)
  {
    return paramView.getScrollY() + paramView.getHeight();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.qqlive.module.videoreport.page.ScrollReader.CommonViewScrollReader
 * JD-Core Version:    0.7.0.1
 */