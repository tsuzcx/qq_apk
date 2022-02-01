package com.tencent.mobileqq.vas;

import android.support.v7.widget.GridLayoutManager.SpanSizeLookup;

class ColorNickColorPanelAdapter$1
  extends GridLayoutManager.SpanSizeLookup
{
  ColorNickColorPanelAdapter$1(ColorNickColorPanelAdapter paramColorNickColorPanelAdapter) {}
  
  public int getSpanSize(int paramInt)
  {
    paramInt = this.a.getItemViewType(paramInt);
    if ((paramInt != 1) && (paramInt != 2))
    {
      if (paramInt != 3)
      {
        if (paramInt != 4) {
          return 1;
        }
        return 3;
      }
      return 1;
    }
    return 3;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.vas.ColorNickColorPanelAdapter.1
 * JD-Core Version:    0.7.0.1
 */