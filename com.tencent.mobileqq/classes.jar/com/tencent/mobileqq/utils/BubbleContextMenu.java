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
    QQCustomMenuNoIconLayout localQQCustomMenuNoIconLayout = new QQCustomMenuNoIconLayout(paramContext);
    localQQCustomMenuNoIconLayout.setGravity(17);
    localQQCustomMenuNoIconLayout.setPadding(0, 0, 0, 0);
    localQQCustomMenuNoIconLayout.setPopupWindow(paramBubblePopupWindow, new BubbleContextMenu.1());
    localQQCustomMenuNoIconLayout.setMenuCreateOrClickCallback(new BubbleMenuReporter(paramContext, paramOnClickListener));
    localQQCustomMenuNoIconLayout.setMenu(paramQQCustomMenu);
    localQQCustomMenuNoIconLayout.setMenuIconClickListener(paramOnClickListener);
    localQQCustomMenuNoIconLayout.c();
    return localQQCustomMenuNoIconLayout;
  }
  
  public static BubblePopupWindow a(View paramView, int paramInt1, int paramInt2, int paramInt3, QQCustomMenu paramQQCustomMenu, View.OnClickListener paramOnClickListener)
  {
    BubblePopupWindow localBubblePopupWindow = new BubblePopupWindow(-2, -2);
    localBubblePopupWindow.setContentView(a(localBubblePopupWindow, paramView.getContext(), paramQQCustomMenu, paramOnClickListener));
    localBubblePopupWindow.setBackgroundDrawable(new ColorDrawable(0));
    localBubblePopupWindow.setOutsideTouchable(false);
    localBubblePopupWindow.setFocusable(true);
    localBubblePopupWindow.setSoftInputMode(1);
    localBubblePopupWindow.setInputMethodMode(2);
    localBubblePopupWindow.setTouchModal(false);
    localBubblePopupWindow.setAnchorOffset(paramInt3);
    localBubblePopupWindow.setAnimationStyle(0);
    localBubblePopupWindow.showAtLocation(paramView, paramInt1, paramInt2);
    return localBubblePopupWindow;
  }
  
  public static BubblePopupWindow a(View paramView, int paramInt1, int paramInt2, QQCustomMenu paramQQCustomMenu, View.OnClickListener paramOnClickListener, Integer paramInteger)
  {
    BubblePopupWindow localBubblePopupWindow = new BubblePopupWindow(-2, -2);
    paramQQCustomMenu = a(localBubblePopupWindow, paramView.getContext(), paramQQCustomMenu, paramOnClickListener);
    paramQQCustomMenu.setIgnoreTouchLocation(true);
    paramQQCustomMenu.setContainerBottom(paramInteger);
    localBubblePopupWindow.setContentView(paramQQCustomMenu);
    localBubblePopupWindow.setBackgroundDrawable(new ColorDrawable(0));
    localBubblePopupWindow.setOutsideTouchable(true);
    localBubblePopupWindow.setFocusable(true);
    localBubblePopupWindow.setSoftInputMode(1);
    localBubblePopupWindow.setInputMethodMode(2);
    localBubblePopupWindow.showAtLocation(paramView, paramInt1, paramInt2, true);
    return localBubblePopupWindow;
  }
  
  public static BubblePopupWindow a(View paramView, QQCustomMenu paramQQCustomMenu, View.OnClickListener paramOnClickListener)
  {
    BubblePopupWindow localBubblePopupWindow = new BubblePopupWindow(-2, -2);
    localBubblePopupWindow.setContentView(a(localBubblePopupWindow, paramView.getContext(), paramQQCustomMenu, paramOnClickListener));
    localBubblePopupWindow.setBackgroundDrawable(new ColorDrawable(0));
    localBubblePopupWindow.setOutsideTouchable(true);
    localBubblePopupWindow.setFocusable(true);
    localBubblePopupWindow.showAsDropDown(paramView);
    return localBubblePopupWindow;
  }
  
  public static BubblePopupWindow a(View paramView, QQCustomMenu paramQQCustomMenu, View.OnClickListener paramOnClickListener, BubblePopupWindow.OnDismissListener paramOnDismissListener)
  {
    BubblePopupWindow localBubblePopupWindow = new BubblePopupWindow(-2, -2);
    localBubblePopupWindow.setContentView(a(localBubblePopupWindow, paramView.getContext(), paramQQCustomMenu, paramOnClickListener));
    localBubblePopupWindow.setOnDismissListener(paramOnDismissListener);
    localBubblePopupWindow.setBackgroundDrawable(new ColorDrawable(0));
    localBubblePopupWindow.setOutsideTouchable(true);
    localBubblePopupWindow.setFocusable(true);
    localBubblePopupWindow.showAsDropDown(paramView);
    return localBubblePopupWindow;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.utils.BubbleContextMenu
 * JD-Core Version:    0.7.0.1
 */