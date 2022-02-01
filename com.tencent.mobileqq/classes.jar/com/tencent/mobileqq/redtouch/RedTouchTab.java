package com.tencent.mobileqq.redtouch;

import android.content.Context;
import android.view.View;
import android.widget.TextView;
import com.tencent.mobileqq.tianshu.ui.RedTouch;
import com.tencent.mobileqq.utils.BaseImageUtil;
import com.tencent.widget.RedWidgetUtil;

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
    TextView localTextView = new TextView(this.f);
    int j = 1;
    try
    {
      paramInt3 = Integer.parseInt(paramString);
    }
    catch (NumberFormatException localNumberFormatException1)
    {
      int i;
      label83:
      break label83;
    }
    try
    {
      if (paramInt3 > this.w)
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append(this.w);
        localStringBuilder.append("+");
        localTextView.setText(localStringBuilder.toString());
      }
      else
      {
        localTextView.setText(paramString);
      }
      i = 1;
    }
    catch (NumberFormatException localNumberFormatException2)
    {
      break label86;
    }
    paramInt3 = 0;
    label86:
    localTextView.setText(paramString.trim());
    i = 0;
    localTextView.setTextColor(paramInt1);
    localTextView.setGravity(17);
    localTextView.setSingleLine(true);
    if (paramInt2 != 0)
    {
      localTextView.setTextSize(11.0F);
      if (this.H) {
        localTextView.setIncludeFontPadding(false);
      }
    }
    try
    {
      localTextView.setBackgroundResource(2130852594);
    }
    catch (OutOfMemoryError paramString)
    {
      label151:
      break label151;
    }
    BaseImageUtil.a(getResources(), localTextView, 2130852594);
    try
    {
      localTextView.setBackgroundResource(2130852592);
      paramInt1 = j;
    }
    catch (OutOfMemoryError paramString)
    {
      label178:
      break label178;
    }
    BaseImageUtil.a(getResources(), localTextView, 2130852592);
    break label199;
    localTextView.setTextSize(13.0F);
    label199:
    paramInt1 = 0;
    if ((i != 0) && (paramInt1 != 0)) {
      RedWidgetUtil.fixTextViewLayout(localTextView, paramInt3, this.w, 2130852592);
    } else {
      localTextView.setLayoutParams(getRedTouchLayoutParams());
    }
    if (this.v)
    {
      localTextView.measure(0, 0);
      this.r += localTextView.getMeasuredWidth() / 2;
      f();
    }
    return localTextView;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.redtouch.RedTouchTab
 * JD-Core Version:    0.7.0.1
 */