package com.tencent.mobileqq.redtouch;

import android.content.Context;
import android.view.View;
import android.widget.TextView;
import com.tencent.mobileqq.tianshu.ui.RedTouch;
import com.tencent.mobileqq.utils.BaseImageUtil;

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
      if (Integer.parseInt(paramString) > this.p)
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append(this.p);
        localStringBuilder.append("+");
        localTextView.setText(localStringBuilder.toString());
      }
      else
      {
        localTextView.setText(paramString);
      }
    }
    catch (NumberFormatException localNumberFormatException)
    {
      label73:
      break label73;
    }
    localTextView.setText(paramString.trim());
    localTextView.setTextColor(paramInt1);
    localTextView.setGravity(17);
    localTextView.setSingleLine(true);
    if (paramInt2 != 0)
    {
      localTextView.setTextSize(11.0F);
      if (this.e) {
        localTextView.setIncludeFontPadding(false);
      }
    }
    try
    {
      localTextView.setBackgroundResource(2130850772);
    }
    catch (OutOfMemoryError paramString)
    {
      label135:
      label159:
      label180:
      break label135;
    }
    BaseImageUtil.a(getResources(), localTextView, 2130850772);
    try
    {
      localTextView.setBackgroundResource(2130850770);
    }
    catch (OutOfMemoryError paramString)
    {
      break label159;
    }
    BaseImageUtil.a(getResources(), localTextView, 2130850770);
    break label180;
    localTextView.setTextSize(13.0F);
    localTextView.setLayoutParams(a());
    if (this.b)
    {
      localTextView.measure(0, 0);
      this.l += localTextView.getMeasuredWidth() / 2;
      c();
    }
    return localTextView;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.redtouch.RedTouchTab
 * JD-Core Version:    0.7.0.1
 */