package com.tencent.mobileqq.mini.entry.desktop;

import android.support.v7.widget.GridLayoutManager.SpanSizeLookup;

class MiniAppDesktopAdapter$1
  extends GridLayoutManager.SpanSizeLookup
{
  MiniAppDesktopAdapter$1(MiniAppDesktopAdapter paramMiniAppDesktopAdapter) {}
  
  public int getSpanSize(int paramInt)
  {
    if (this.this$0.getItemViewType(paramInt) == 1) {}
    while ((this.this$0.getItemViewType(paramInt) == 4) || (this.this$0.getItemViewType(paramInt) == 5) || (this.this$0.getItemViewType(paramInt) == 6) || (this.this$0.getItemViewType(paramInt) == 9) || (this.this$0.getItemViewType(paramInt) == 8) || (this.this$0.getItemViewType(paramInt) == 10) || (this.this$0.getItemViewType(paramInt) == 11)) {
      return 4;
    }
    return 1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.mini.entry.desktop.MiniAppDesktopAdapter.1
 * JD-Core Version:    0.7.0.1
 */