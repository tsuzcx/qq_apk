package com.tencent.mobileqq.widget;

import android.content.Context;
import android.content.res.Resources;
import android.view.MotionEvent;
import android.view.View.OnClickListener;
import android.widget.LinearLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.mobileqq.utils.ViewUtils;

class ChatHistoryMenuItemView$CategoryItem
  extends TextView
{
  ChatHistoryMenuItemView$CategoryItem(Context paramContext, String paramString, View.OnClickListener paramOnClickListener)
  {
    super(paramContext);
    setTextSize(2, 16.0F);
    setTextColor(getResources().getColor(2131167190));
    paramContext = new LinearLayout.LayoutParams(-2, -2);
    paramContext.setMargins(0, 0, 0, ViewUtils.a(28.0F));
    setLayoutParams(paramContext);
    setText(paramString);
    setOnClickListener(paramOnClickListener);
  }
  
  public boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
    int i = paramMotionEvent.getAction();
    if (i != 0)
    {
      if ((i == 1) || (i == 3)) {
        setAlpha(1.0F);
      }
    }
    else {
      setAlpha(0.5F);
    }
    return super.onTouchEvent(paramMotionEvent);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.widget.ChatHistoryMenuItemView.CategoryItem
 * JD-Core Version:    0.7.0.1
 */