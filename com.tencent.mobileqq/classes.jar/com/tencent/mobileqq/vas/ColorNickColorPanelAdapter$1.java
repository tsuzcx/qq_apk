package com.tencent.mobileqq.vas;

import android.support.v7.widget.GridLayoutManager.SpanSizeLookup;

class ColorNickColorPanelAdapter$1
  extends GridLayoutManager.SpanSizeLookup
{
  ColorNickColorPanelAdapter$1(ColorNickColorPanelAdapter paramColorNickColorPanelAdapter) {}
  
  public int getSpanSize(int paramInt)
  {
    int i = 3;
    switch (this.a.getItemViewType(paramInt))
    {
    default: 
      i = 1;
    case 1: 
    case 2: 
    case 4: 
      return i;
    }
    return 1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.vas.ColorNickColorPanelAdapter.1
 * JD-Core Version:    0.7.0.1
 */