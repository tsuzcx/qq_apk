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
    paramContext = new LinearLayout.LayoutParams(ViewUtils.a(0.5F), ViewUtils.a(16.0F));
    paramContext.setMargins(ViewUtils.a(30.0F), ViewUtils.a(2.0F), ViewUtils.a(30.0F), ViewUtils.a(30.0F));
    setLayoutParams(paramContext);
    setBackgroundColor(paramInt);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.widget.ChatHistoryMenuItemView.SeparatorColumnView.Separator
 * JD-Core Version:    0.7.0.1
 */