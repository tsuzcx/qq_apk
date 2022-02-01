package com.tencent.mobileqq.utils;

import android.content.Context;
import android.graphics.drawable.ColorDrawable;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.utils.dialogutils.QQCustomMenu;
import com.tencent.mobileqq.utils.dialogutils.QQCustomMenuItemPriorityHelper;
import com.tencent.mobileqq.utils.dialogutils.QQCustomMenuNoIconLayout;
import com.tencent.widget.BubblePopupWindow;
import com.tencent.widget.BubblePopupWindow.OnDismissListener;

public class BubbleContextMenu
{
  public static boolean a = false;
  
  public static QQCustomMenuNoIconLayout a(BubblePopupWindow paramBubblePopupWindow, Context paramContext, QQCustomMenu paramQQCustomMenu, View.OnClickListener paramOnClickListener)
  {
    QQCustomMenuItemPriorityHelper.a(paramQQCustomMenu);
    paramContext = new QQCustomMenuNoIconLayout(paramContext);
    paramContext.setGravity(17);
    paramContext.setPadding(0, 0, 0, 0);
    paramContext.setPopupWindow(paramBubblePopupWindow);
    paramContext.setMenu(paramQQCustomMenu);
    paramContext.setMenuIconClickListener(paramOnClickListener);
    paramContext.a();
    return paramContext;
  }
  
  public static BubblePopupWindow a(View paramView, int paramInt1, int paramInt2, int paramInt3, QQCustomMenu paramQQCustomMenu, View.OnClickListener paramOnClickListener)
  {
    BubblePopupWindow localBubblePopupWindow = new BubblePopupWindow(-2, -2);
    localBubblePopupWindow.a(a(localBubblePopupWindow, paramView.getContext(), paramQQCustomMenu, paramOnClickListener));
    localBubblePopupWindow.a(new ColorDrawable(0));
    localBubblePopupWindow.c(false);
    localBubblePopupWindow.a(true);
    localBubblePopupWindow.c(1);
    localBubblePopupWindow.b(2);
    localBubblePopupWindow.e(false);
    localBubblePopupWindow.f(paramInt3);
    localBubblePopupWindow.a(0);
    localBubblePopupWindow.b(paramView, paramInt1, paramInt2);
    return localBubblePopupWindow;
  }
  
  public static BubblePopupWindow a(View paramView, int paramInt1, int paramInt2, QQCustomMenu paramQQCustomMenu, View.OnClickListener paramOnClickListener, Integer paramInteger)
  {
    BubblePopupWindow localBubblePopupWindow = new BubblePopupWindow(-2, -2);
    paramQQCustomMenu = a(localBubblePopupWindow, paramView.getContext(), paramQQCustomMenu, paramOnClickListener);
    paramQQCustomMenu.setIgnoreTouchLocation(true);
    paramQQCustomMenu.setContainerBottom(paramInteger);
    localBubblePopupWindow.a(paramQQCustomMenu);
    localBubblePopupWindow.a(new ColorDrawable(0));
    localBubblePopupWindow.c(true);
    localBubblePopupWindow.a(true);
    localBubblePopupWindow.c(1);
    localBubblePopupWindow.b(2);
    localBubblePopupWindow.a(paramView, paramInt1, paramInt2, true);
    return localBubblePopupWindow;
  }
  
  public static BubblePopupWindow a(View paramView, QQCustomMenu paramQQCustomMenu, View.OnClickListener paramOnClickListener)
  {
    BubblePopupWindow localBubblePopupWindow = new BubblePopupWindow(-2, -2);
    localBubblePopupWindow.a(a(localBubblePopupWindow, paramView.getContext(), paramQQCustomMenu, paramOnClickListener));
    localBubblePopupWindow.a(new ColorDrawable(0));
    localBubblePopupWindow.c(true);
    localBubblePopupWindow.a(true);
    localBubblePopupWindow.b(paramView);
    return localBubblePopupWindow;
  }
  
  public static BubblePopupWindow a(View paramView, QQCustomMenu paramQQCustomMenu, View.OnClickListener paramOnClickListener, BubblePopupWindow.OnDismissListener paramOnDismissListener)
  {
    BubblePopupWindow localBubblePopupWindow = new BubblePopupWindow(-2, -2);
    localBubblePopupWindow.a(a(localBubblePopupWindow, paramView.getContext(), paramQQCustomMenu, paramOnClickListener));
    localBubblePopupWindow.a(paramOnDismissListener);
    localBubblePopupWindow.a(new ColorDrawable(0));
    localBubblePopupWindow.c(true);
    localBubblePopupWindow.a(true);
    localBubblePopupWindow.b(paramView);
    return localBubblePopupWindow;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.utils.BubbleContextMenu
 * JD-Core Version:    0.7.0.1
 */