package com.tencent.mobileqq.widget;

import android.content.Context;
import android.widget.LinearLayout;
import java.util.ArrayList;

class ChatHistoryMenuItemView$CategoryItemColumnView
  extends LinearLayout
{
  ChatHistoryMenuItemView$CategoryItemColumnView(Context paramContext)
  {
    super(paramContext);
    setOrientation(1);
    setGravity(1);
  }
  
  public static ArrayList<CategoryItemColumnView> a(Context paramContext, int paramInt)
  {
    ArrayList localArrayList = new ArrayList();
    int i = 0;
    while (i < paramInt)
    {
      localArrayList.add(new CategoryItemColumnView(paramContext));
      i += 1;
    }
    return localArrayList;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.widget.ChatHistoryMenuItemView.CategoryItemColumnView
 * JD-Core Version:    0.7.0.1
 */