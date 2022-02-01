package com.tencent.mobileqq.qwallet.hb.send.view.impl;

import android.view.View;
import android.widget.FrameLayout.LayoutParams;
import android.widget.TextView;
import android.widget.ViewSwitcher.ViewFactory;

class RollTextView$1
  implements ViewSwitcher.ViewFactory
{
  RollTextView$1(RollTextView paramRollTextView, boolean paramBoolean) {}
  
  public View makeView()
  {
    TextView localTextView = new TextView(RollTextView.b(this.b));
    for (;;)
    {
      try
      {
        localTextView.setLayoutParams(new FrameLayout.LayoutParams(-2, -2));
        localTextView.setTextSize(0, RollTextView.c(this.b));
        localTextView.setIncludeFontPadding(false);
        localTextView.setTextColor(RollTextView.d(this.b));
        if (this.a)
        {
          String str1 = "0";
          localTextView.setText(str1);
          return localTextView;
        }
      }
      catch (Exception localException)
      {
        localException.printStackTrace();
        return localTextView;
      }
      String str2 = "";
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.mobileqq.qwallet.hb.send.view.impl.RollTextView.1
 * JD-Core Version:    0.7.0.1
 */