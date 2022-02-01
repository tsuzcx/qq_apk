package com.tencent.mobileqq.widget;

import android.content.Context;
import android.view.View;
import android.widget.LinearLayout.LayoutParams;
import com.tencent.mobileqq.utils.ViewUtils;

class ChatHistoryMenuItemView$SeparatorColumnView$Separator
  extends View
{
  ChatHistoryMenuItemView$SeparatorColumnView$Separator(Context paramContext, int paramInt)
  {
    super(paramContext);
    paramContext = new LinearLayout.LayoutParams(ViewUtils.dip2px(0.5F), ViewUtils.dip2px(16.0F));
    paramContext.setMargins(ViewUtils.dip2px(30.0F), ViewUtils.dip2px(2.0F), ViewUtils.dip2px(30.0F), ViewUtils.dip2px(30.0F));
    setLayoutParams(paramContext);
    setBackgroundColor(paramInt);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.tencent.mobileqq.widget.ChatHistoryMenuItemView.SeparatorColumnView.Separator
 * JD-Core Version:    0.7.0.1
 */