package com.tencent.mobileqq.vaswebviewplugin;

import android.widget.FrameLayout;
import com.etrump.mixlayout.ETTextView;

class ThemeAndBubbleCommonJsPlugin$HYDIYFontJsHandler$3
  implements ThemeAndBubbleCommonJsPlugin.HYDIYFontJsHandler.DealETTextView
{
  ThemeAndBubbleCommonJsPlugin$HYDIYFontJsHandler$3(ThemeAndBubbleCommonJsPlugin.HYDIYFontJsHandler paramHYDIYFontJsHandler) {}
  
  public Object deal(FrameLayout paramFrameLayout, ETTextView paramETTextView)
  {
    paramFrameLayout.removeView(paramETTextView);
    return Integer.valueOf(1);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.vaswebviewplugin.ThemeAndBubbleCommonJsPlugin.HYDIYFontJsHandler.3
 * JD-Core Version:    0.7.0.1
 */