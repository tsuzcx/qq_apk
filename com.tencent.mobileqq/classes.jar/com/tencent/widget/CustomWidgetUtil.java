package com.tencent.widget;

import android.content.Context;
import android.content.res.Resources;
import android.text.TextUtils;
import android.view.ViewGroup.MarginLayoutParams;
import android.widget.FrameLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.mobileqq.shortvideo.util.ScreenUtil;
import com.tencent.mobileqq.util.Utils;

public class CustomWidgetUtil
{
  public static void a(Context paramContext, TextView paramTextView, int paramInt)
  {
    if ((paramTextView == null) || (paramInt == 0)) {
      return;
    }
    int i = paramContext.getResources().getDimensionPixelSize(2131558943);
    int j = paramContext.getResources().getDimensionPixelSize(2131558944);
    switch (paramInt)
    {
    case 4: 
    default: 
      paramInt = j;
    }
    for (;;)
    {
      paramContext = (ViewGroup.MarginLayoutParams)paramTextView.getLayoutParams();
      if ((paramContext == null) || ((paramContext.leftMargin == i) && (paramContext.bottomMargin == paramInt))) {
        break;
      }
      paramContext.setMargins(i, 0, 0, paramInt);
      return;
      i = paramContext.getResources().getDimensionPixelSize(2131558943);
      paramInt = paramContext.getResources().getDimensionPixelSize(2131558944);
      paramTextView.measure(0, 0);
      int k = paramTextView.getMeasuredWidth();
      j = paramTextView.getMeasuredHeight();
      k /= 2;
      j /= 2;
      i -= k;
      paramInt -= j;
      continue;
      i = paramContext.getResources().getDimensionPixelSize(2131558945);
      paramInt = paramContext.getResources().getDimensionPixelSize(2131558946);
      continue;
      i = paramContext.getResources().getDimensionPixelSize(2131558945);
      paramInt = paramContext.getResources().getDimensionPixelSize(2131558946);
      continue;
      i = paramContext.getResources().getDimensionPixelSize(2131558945);
      paramInt = paramContext.getResources().getDimensionPixelSize(2131558946);
    }
  }
  
  public static void a(TextView paramTextView, int paramInt1, int paramInt2, int paramInt3)
  {
    a(paramTextView, paramInt1, paramInt2, paramInt3, 99, null);
  }
  
  public static void a(TextView paramTextView, int paramInt1, int paramInt2, int paramInt3, int paramInt4, String paramString)
  {
    if (paramTextView == null) {
      return;
    }
    switch (paramInt1)
    {
    default: 
      paramString = "";
      paramInt2 = 0;
      paramInt1 = 0;
      if (paramString == null) {
        paramString = "";
      }
      break;
    }
    for (;;)
    {
      if ((TextUtils.isEmpty(paramString)) && (paramInt1 == 0) && (paramInt2 == 0))
      {
        paramTextView.setVisibility(8);
        return;
        if (paramInt3 > 0)
        {
          paramString = "";
          paramInt1 = paramInt3;
          paramInt2 = 0;
          break;
        }
        paramString = "";
        paramInt1 = 2130846051;
        paramInt2 = 0;
        break;
        if (paramInt3 > 0) {}
        for (paramInt2 = paramInt3;; paramInt2 = 2130846055)
        {
          paramString = "NEW";
          paramInt1 = 0;
          break;
        }
        if (paramInt3 > 0)
        {
          paramString = "";
          paramInt1 = paramInt3;
          paramInt2 = 0;
          break;
        }
        paramString = "";
        paramInt1 = 2130846054;
        paramInt2 = 0;
        break;
        if (paramInt3 > 0) {}
        for (;;)
        {
          if (paramInt2 <= paramInt4) {
            break label207;
          }
          paramString = String.valueOf(paramInt4) + "+";
          paramInt1 = 0;
          paramInt2 = paramInt3;
          break;
          paramInt3 = 2130846055;
        }
        label207:
        paramString = String.valueOf(paramInt2);
        paramInt1 = 0;
        paramInt2 = paramInt3;
        break;
        if (paramInt3 > 0) {}
        for (;;)
        {
          if (paramInt2 <= 99) {
            break label247;
          }
          paramString = "";
          paramInt1 = 0;
          paramInt2 = paramInt3;
          break;
          paramInt3 = 2130846055;
        }
        label247:
        paramString = String.valueOf(paramInt2);
        paramInt1 = 0;
        paramInt2 = paramInt3;
        break;
        if (paramInt3 > 0) {}
        for (paramInt2 = paramInt3;; paramInt2 = 2130846055)
        {
          if (!TextUtils.isEmpty(paramString)) {
            break label289;
          }
          paramString = "";
          paramInt1 = 0;
          break;
        }
        label289:
        paramInt1 = 0;
        break;
      }
      Object localObject = paramTextView.getTag(2131363207);
      if (((localObject == null) && (paramInt1 == 0)) || (((localObject instanceof Integer)) && (((Integer)localObject).intValue() == paramInt1))) {}
      for (;;)
      {
        paramTextView.setBackgroundResource(paramInt2);
        if (!Utils.a(paramTextView.getText().toString(), paramString))
        {
          paramTextView.setCompoundDrawablesWithIntrinsicBounds(0, 0, 0, 0);
          paramTextView.setText(paramString);
        }
        paramTextView.setVisibility(0);
        return;
        paramTextView.setCompoundDrawablesWithIntrinsicBounds(paramInt1, 0, 0, 0);
        paramTextView.setTag(2131363207, Integer.valueOf(paramInt1));
        paramTextView.setText(paramString);
        paramTextView.setPadding(0, 0, 0, 0);
      }
    }
  }
  
  public static void b(Context paramContext, TextView paramTextView, int paramInt)
  {
    if ((paramTextView == null) || (paramInt == 0)) {}
    do
    {
      return;
      switch (paramInt)
      {
      case 4: 
      default: 
        return;
      case 1: 
        paramContext = (ViewGroup.MarginLayoutParams)paramTextView.getLayoutParams();
        if ((paramContext instanceof FrameLayout.LayoutParams))
        {
          ((FrameLayout.LayoutParams)paramContext).gravity = 53;
          paramTextView.setGravity(53);
        }
        paramContext.width = ScreenUtil.a(9.0F);
        paramContext.height = ScreenUtil.a(9.0F);
        return;
      case 3: 
        paramTextView.setGravity(17);
        paramContext = (ViewGroup.MarginLayoutParams)paramTextView.getLayoutParams();
        if ((paramContext instanceof FrameLayout.LayoutParams)) {
          ((FrameLayout.LayoutParams)paramContext).gravity = 21;
        }
        paramContext.width = -2;
        paramContext.height = -2;
        return;
      case 2: 
        paramTextView.setGravity(17);
        paramContext = (ViewGroup.MarginLayoutParams)paramTextView.getLayoutParams();
        if ((paramContext instanceof FrameLayout.LayoutParams)) {
          ((FrameLayout.LayoutParams)paramContext).gravity = 21;
        }
        paramContext.width = -2;
        paramContext.height = -2;
        return;
      }
      paramTextView.setGravity(17);
      paramContext = (ViewGroup.MarginLayoutParams)paramTextView.getLayoutParams();
      paramContext.width = -2;
      paramContext.height = -2;
    } while (!(paramContext instanceof FrameLayout.LayoutParams));
    ((FrameLayout.LayoutParams)paramContext).gravity = 21;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\a.jar
 * Qualified Name:     com.tencent.widget.CustomWidgetUtil
 * JD-Core Version:    0.7.0.1
 */