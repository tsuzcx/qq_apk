package com.tencent.mobileqq.redtouch;

import android.content.Context;
import android.view.View;
import android.widget.TextView;

public class RedTouchTab
  extends RedTouch
{
  public RedTouchTab(Context paramContext)
  {
    super(paramContext);
  }
  
  public RedTouchTab(Context paramContext, View paramView)
  {
    super(paramContext, paramView);
  }
  
  protected TextView a(String paramString, int paramInt1, int paramInt2, int paramInt3)
  {
    TextView localTextView = new TextView(this.a);
    try
    {
      if (Integer.parseInt(paramString) > this.p) {
        localTextView.setText(this.p + "+");
      }
      for (;;)
      {
        localTextView.setTextColor(paramInt1);
        localTextView.setGravity(17);
        localTextView.setSingleLine(true);
        if (paramInt2 == 0) {
          break label180;
        }
        localTextView.setTextSize(11.0F);
        if (!this.e) {
          break;
        }
        localTextView.setIncludeFontPadding(false);
        localTextView.setBackgroundResource(2130846057);
        localTextView.setLayoutParams(a());
        if (this.b)
        {
          localTextView.measure(0, 0);
          this.l += localTextView.getMeasuredWidth() / 2;
          a();
        }
        return localTextView;
        localTextView.setText(paramString);
      }
    }
    catch (NumberFormatException localNumberFormatException)
    {
      for (;;)
      {
        localTextView.setText(paramString.trim());
        continue;
        localTextView.setBackgroundResource(2130846055);
        continue;
        label180:
        localTextView.setTextSize(13.0F);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.mobileqq.redtouch.RedTouchTab
 * JD-Core Version:    0.7.0.1
 */