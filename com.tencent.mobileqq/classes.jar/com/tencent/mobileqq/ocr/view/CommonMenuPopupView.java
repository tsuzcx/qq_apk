package com.tencent.mobileqq.ocr.view;

import android.content.Context;
import android.graphics.drawable.ColorDrawable;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.utils.dialogutils.QQCustomMenu;
import com.tencent.mobileqq.utils.dialogutils.QQCustomMenuItemPriorityHelper;
import com.tencent.mobileqq.utils.dialogutils.QQCustomMenuNoIconLayout;
import com.tencent.widget.BubblePopupWindow;
import com.tencent.widget.BubblePopupWindow.OnDismissListener;

public class CommonMenuPopupView
{
  public static int a = 1;
  public static int b = 2;
  QQCustomMenu c;
  private BubblePopupWindow d;
  private BubblePopupWindow.OnDismissListener e;
  private View.OnClickListener f;
  
  public static QQCustomMenuNoIconLayout a(BubblePopupWindow paramBubblePopupWindow, Context paramContext, QQCustomMenu paramQQCustomMenu, View.OnClickListener paramOnClickListener)
  {
    QQCustomMenuItemPriorityHelper.a(paramQQCustomMenu);
    paramContext = new QQCustomMenuNoIconLayout(paramContext);
    paramContext.setGravity(17);
    paramContext.setPadding(0, 0, 0, 0);
    paramContext.setPopupWindow(paramBubblePopupWindow, null);
    paramContext.setMenu(paramQQCustomMenu);
    paramContext.setMenuIconClickListener(paramOnClickListener);
    paramContext.c();
    return paramContext;
  }
  
  public void a()
  {
    BubblePopupWindow localBubblePopupWindow = this.d;
    if ((localBubblePopupWindow != null) && (localBubblePopupWindow.isShowing())) {
      this.d.dismiss();
    }
  }
  
  public void a(int paramInt1, String paramString, int paramInt2)
  {
    if (this.c == null) {
      this.c = new QQCustomMenu();
    }
    this.c.a(paramInt1, paramString, paramInt2);
  }
  
  public void a(View.OnClickListener paramOnClickListener)
  {
    this.f = paramOnClickListener;
  }
  
  public void a(View paramView, int paramInt1, int paramInt2)
  {
    a(paramView, paramInt1, paramInt2, b, true);
  }
  
  public void a(View paramView, int paramInt1, int paramInt2, int paramInt3, boolean paramBoolean)
  {
    BubblePopupWindow localBubblePopupWindow = this.d;
    if ((localBubblePopupWindow != null) && (localBubblePopupWindow.isShowing()))
    {
      this.d.dismiss();
      this.d = null;
    }
    this.d = new BubblePopupWindow(-2, -2);
    localBubblePopupWindow = this.d;
    localBubblePopupWindow.setContentView(a(localBubblePopupWindow, paramView.getContext(), this.c, this.f));
    this.d.setBackgroundDrawable(new ColorDrawable(0));
    this.d.setOutsideTouchable(paramBoolean);
    boolean bool = true;
    if (paramBoolean) {
      this.d.setFocusable(true);
    }
    this.d.setFocusable(false);
    this.d.setOutsideTouchable(true);
    this.d.setSoftInputMode(1);
    this.d.setInputMethodMode(2);
    localBubblePopupWindow = this.d;
    if (paramInt3 == a) {
      paramBoolean = bool;
    } else {
      paramBoolean = false;
    }
    localBubblePopupWindow.setKeepAbove(paramBoolean);
    this.d.setOnDismissListener(this.e);
    paramView.post(new CommonMenuPopupView.1(this, paramView, paramInt1, paramInt2));
  }
  
  public boolean b()
  {
    BubblePopupWindow localBubblePopupWindow = this.d;
    return (localBubblePopupWindow != null) && (localBubblePopupWindow.isShowing());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.ocr.view.CommonMenuPopupView
 * JD-Core Version:    0.7.0.1
 */