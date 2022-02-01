package com.tencent.mobileqq.mini.entry.desktop;

import android.support.v7.widget.GridLayoutManager.SpanSizeLookup;

class MiniAppDesktopAdapter$1
  extends GridLayoutManager.SpanSizeLookup
{
  MiniAppDesktopAdapter$1(MiniAppDesktopAdapter paramMiniAppDesktopAdapter) {}
  
  public int getSpanSize(int paramInt)
  {
    paramInt = this.this$0.getItemViewType(paramInt);
    if ((paramInt != 1) && (paramInt != 4) && (paramInt != 5) && (paramInt != 6) && (paramInt != 12) && (paramInt != 9) && (paramInt != 8) && (paramInt != 10) && (paramInt != 13) && (paramInt != 11) && (paramInt != 14))
    {
      if (paramInt == 15) {
        return 4;
      }
      return 1;
    }
    return 4;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.mobileqq.mini.entry.desktop.MiniAppDesktopAdapter.1
 * JD-Core Version:    0.7.0.1
 */