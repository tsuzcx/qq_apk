package com.tencent.mobileqq.mini.entry.desktop;

import android.support.v7.widget.GridLayoutManager.SpanSizeLookup;

class MiniAppDesktopAdapter$1
  extends GridLayoutManager.SpanSizeLookup
{
  MiniAppDesktopAdapter$1(MiniAppDesktopAdapter paramMiniAppDesktopAdapter) {}
  
  public int getSpanSize(int paramInt)
  {
    if (this.this$0.getItemViewType(paramInt) == 1) {
      return 4;
    }
    if (this.this$0.getItemViewType(paramInt) == 4) {
      return 4;
    }
    if (this.this$0.getItemViewType(paramInt) == 5) {
      return 4;
    }
    if (this.this$0.getItemViewType(paramInt) == 6) {
      return 4;
    }
    if (this.this$0.getItemViewType(paramInt) == 12) {
      return 4;
    }
    if (this.this$0.getItemViewType(paramInt) == 9) {
      return 4;
    }
    if (this.this$0.getItemViewType(paramInt) == 8) {
      return 4;
    }
    if (this.this$0.getItemViewType(paramInt) == 10) {
      return 4;
    }
    if (this.this$0.getItemViewType(paramInt) == 13) {
      return 4;
    }
    if (this.this$0.getItemViewType(paramInt) == 11) {
      return 4;
    }
    return 1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.mobileqq.mini.entry.desktop.MiniAppDesktopAdapter.1
 * JD-Core Version:    0.7.0.1
 */