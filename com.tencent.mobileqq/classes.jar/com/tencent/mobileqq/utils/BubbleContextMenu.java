package com.tencent.mobileqq.utils;

import akbx;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.ColorDrawable;
import android.text.Layout;
import android.text.TextPaint;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import android.widget.LinearLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.mobileqq.utils.dialogutils.QQCustomMenu;
import com.tencent.mobileqq.utils.dialogutils.QQCustomMenuImageLayout;
import com.tencent.mobileqq.utils.dialogutils.QQCustomMenuItem;
import com.tencent.mobileqq.utils.dialogutils.QQCustomMenuLayout;
import com.tencent.widget.BubblePopupWindow;
import com.tencent.widget.BubblePopupWindow.OnDismissListener;

public class BubbleContextMenu
{
  public static boolean a;
  
  private static View a(BubblePopupWindow paramBubblePopupWindow, Context paramContext, QQCustomMenu paramQQCustomMenu, View.OnClickListener paramOnClickListener)
  {
    int k = 1;
    int m = paramQQCustomMenu.a();
    int i = 0;
    for (;;)
    {
      int j = k;
      if (i < m)
      {
        if (paramQQCustomMenu.a(i).b() == 0) {
          j = 0;
        }
      }
      else
      {
        if (QQCustomMenuImageLayout.jdField_a_of_type_Int == 0)
        {
          localObject = paramContext.getResources();
          QQCustomMenuImageLayout.jdField_a_of_type_Int = ((Resources)localObject).getDisplayMetrics().widthPixels;
          QQCustomMenuImageLayout.jdField_a_of_type_Float = ((Resources)localObject).getDisplayMetrics().density;
          QQCustomMenuImageLayout.c = AIOUtils.a(QQCustomMenuImageLayout.c, (Resources)localObject);
          QQCustomMenuImageLayout.d = AIOUtils.a(QQCustomMenuImageLayout.d, (Resources)localObject);
          QQCustomMenuImageLayout.e = AIOUtils.a(QQCustomMenuImageLayout.e, (Resources)localObject);
          QQCustomMenuImageLayout.f = (QQCustomMenuImageLayout.jdField_a_of_type_Int - AIOUtils.a(36.0F, (Resources)localObject)) / 6;
        }
        if ((j == 0) || (QQCustomMenuImageLayout.jdField_a_of_type_Int < 480)) {
          break;
        }
        paramContext = new QQCustomMenuImageLayout(paramContext);
        paramContext.setGravity(17);
        paramContext.setPadding(QQCustomMenuImageLayout.c, 0, 0, 0);
        paramContext.setPopup(paramBubblePopupWindow);
        paramContext.setMenu(paramQQCustomMenu);
        paramContext.setMenuIconClickListener(paramOnClickListener);
        paramContext.a();
        return paramContext;
      }
      i += 1;
    }
    Object localObject = new QQCustomMenuLayout(paramContext);
    ((QQCustomMenuLayout)localObject).setGravity(17);
    a(paramBubblePopupWindow, paramContext, paramQQCustomMenu, paramOnClickListener, (QQCustomMenuLayout)localObject, m);
    return localObject;
  }
  
  private static QQCustomMenuLayout a(BubblePopupWindow paramBubblePopupWindow, Context paramContext, QQCustomMenu paramQQCustomMenu, View.OnClickListener paramOnClickListener, QQCustomMenuLayout paramQQCustomMenuLayout, int paramInt)
  {
    int i = 0;
    while (i < paramInt)
    {
      Object localObject = paramQQCustomMenu.a(i);
      akbx localakbx = new akbx(paramContext, paramBubblePopupWindow);
      localakbx.setText(((QQCustomMenuItem)localObject).a());
      localakbx.setTextSize(13.0F);
      Resources localResources = paramContext.getResources();
      TextPaint localTextPaint = new TextPaint(1);
      localTextPaint.density = localResources.getDisplayMetrics().density;
      int k = (int)Layout.getDesiredWidth(((QQCustomMenuItem)localObject).a(), localTextPaint);
      int j = 5;
      if (localTextPaint.density >= 2.0F) {
        j = 10;
      }
      j = (int)(j * localTextPaint.density);
      localakbx.setMinimumWidth(j * 2 + k);
      localakbx.setPadding(j, 0, j, 0);
      localakbx.setContentDescription(((QQCustomMenuItem)localObject).a());
      localakbx.setId(((QQCustomMenuItem)localObject).a());
      localakbx.setTextColor(-1);
      localakbx.setBackgroundDrawable(null);
      localakbx.setIncludeFontPadding(true);
      localakbx.setOnClickListener(paramOnClickListener);
      localakbx.setGravity(17);
      paramQQCustomMenuLayout.addView(localakbx, new LinearLayout.LayoutParams(-2, -2, 1.0F));
      if (i != paramInt - 1)
      {
        localObject = new ImageView(paramContext);
        ((ImageView)localObject).setBackgroundResource(2130838300);
        paramQQCustomMenuLayout.addView((View)localObject, -2, -2);
      }
      i += 1;
    }
    paramQQCustomMenuLayout.a();
    return paramQQCustomMenuLayout;
  }
  
  public static BubblePopupWindow a(View paramView, int paramInt1, int paramInt2, int paramInt3, QQCustomMenu paramQQCustomMenu, View.OnClickListener paramOnClickListener)
  {
    BubblePopupWindow localBubblePopupWindow = new BubblePopupWindow(-2, -2);
    localBubblePopupWindow.a(a(localBubblePopupWindow, paramView.getContext(), paramQQCustomMenu, paramOnClickListener));
    localBubblePopupWindow.a(new ColorDrawable(0));
    localBubblePopupWindow.b(false);
    localBubblePopupWindow.a(true);
    localBubblePopupWindow.c(1);
    localBubblePopupWindow.b(2);
    localBubblePopupWindow.c(false);
    localBubblePopupWindow.f(paramInt3);
    localBubblePopupWindow.a(0);
    localBubblePopupWindow.b(paramView, paramInt1, paramInt2);
    return localBubblePopupWindow;
  }
  
  public static BubblePopupWindow a(View paramView, int paramInt1, int paramInt2, QQCustomMenu paramQQCustomMenu, View.OnClickListener paramOnClickListener)
  {
    BubblePopupWindow localBubblePopupWindow = new BubblePopupWindow(-2, -2);
    localBubblePopupWindow.a(a(localBubblePopupWindow, paramView.getContext(), paramQQCustomMenu, paramOnClickListener));
    localBubblePopupWindow.a(new ColorDrawable(0));
    localBubblePopupWindow.b(true);
    localBubblePopupWindow.a(true);
    localBubblePopupWindow.c(1);
    localBubblePopupWindow.b(2);
    localBubblePopupWindow.b(paramView, paramInt1, paramInt2);
    return localBubblePopupWindow;
  }
  
  public static BubblePopupWindow a(View paramView, QQCustomMenu paramQQCustomMenu, View.OnClickListener paramOnClickListener)
  {
    BubblePopupWindow localBubblePopupWindow = new BubblePopupWindow(-2, -2);
    localBubblePopupWindow.a(a(localBubblePopupWindow, paramView.getContext(), paramQQCustomMenu, paramOnClickListener));
    localBubblePopupWindow.a(new ColorDrawable(0));
    localBubblePopupWindow.b(true);
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
    localBubblePopupWindow.b(true);
    localBubblePopupWindow.a(true);
    localBubblePopupWindow.b(paramView);
    return localBubblePopupWindow;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.utils.BubbleContextMenu
 * JD-Core Version:    0.7.0.1
 */