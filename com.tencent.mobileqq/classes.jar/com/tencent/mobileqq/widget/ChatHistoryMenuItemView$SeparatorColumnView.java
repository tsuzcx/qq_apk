package com.tencent.mobileqq.widget;

import android.content.Context;
import android.widget.LinearLayout;
import java.util.ArrayList;

class ChatHistoryMenuItemView$SeparatorColumnView
  extends LinearLayout
{
  ChatHistoryMenuItemView$SeparatorColumnView(Context paramContext, int paramInt1, int paramInt2)
  {
    super(paramContext);
    setOrientation(1);
    setGravity(1);
    int i = 0;
    while (i < paramInt1)
    {
      addView(new ChatHistoryMenuItemView.SeparatorColumnView.Separator(paramContext, paramInt2));
      i += 1;
    }
  }
  
  public static ArrayList<SeparatorColumnView> a(Context paramContext, int paramInt1, ArrayList<ChatHistoryMenuItemView.CategoryItemColumnView> paramArrayList, int paramInt2)
  {
    ArrayList localArrayList = new ArrayList();
    int i = 0;
    while (i < paramInt1 - 1)
    {
      i += 1;
      localArrayList.add(new SeparatorColumnView(paramContext, ((ChatHistoryMenuItemView.CategoryItemColumnView)paramArrayList.get(i)).getChildCount(), paramInt2));
    }
    return localArrayList;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.widget.ChatHistoryMenuItemView.SeparatorColumnView
 * JD-Core Version:    0.7.0.1
 */