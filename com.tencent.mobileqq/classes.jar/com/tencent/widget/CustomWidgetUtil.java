package com.tencent.widget;

import android.content.Context;
import android.content.res.Resources;
import android.text.TextUtils;
import android.view.ViewGroup.MarginLayoutParams;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.mobileqq.util.Utils;
import com.tencent.mobileqq.utils.ViewUtils;

public class CustomWidgetUtil
  implements CustomWidgetConstants
{
  public static void a(Context paramContext, TextView paramTextView, int paramInt, boolean paramBoolean)
  {
    if (paramTextView != null)
    {
      if (paramInt == 0) {
        return;
      }
      int j = paramContext.getResources().getDimensionPixelSize(2131297500);
      int i = paramContext.getResources().getDimensionPixelSize(2131297498);
      int k;
      switch (paramInt)
      {
      case 4: 
      case 6: 
      default: 
        paramInt = j;
        break;
      case 10: 
        if ((paramTextView.getLayoutParams() instanceof RelativeLayout.LayoutParams))
        {
          paramTextView = (RelativeLayout.LayoutParams)paramTextView.getLayoutParams();
          paramTextView.addRule(15, -1);
          paramTextView.setMargins(0, 0, paramContext.getResources().getDimensionPixelSize(2131297505), 0);
        }
        return;
      case 9: 
        paramInt = paramContext.getResources().getDimensionPixelSize(2131297504);
        i = paramContext.getResources().getDimensionPixelSize(2131297502);
        break;
      case 8: 
        k = paramContext.getResources().getDimensionPixelSize(2131297500);
        i = paramContext.getResources().getDimensionPixelSize(2131297499);
        paramInt = i;
        if (paramBoolean) {
          paramInt = i + ViewUtils.dip2px(8.0F);
        }
        paramTextView.measure(0, 0);
        i = paramTextView.getMeasuredWidth();
        j = paramTextView.getMeasuredHeight();
        if (i <= j) {
          i = j;
        }
        paramTextView.setWidth(i);
        paramTextView.setHeight(i);
        j = i / 2;
        i = k - j;
        j = paramInt - j;
        paramInt = i;
        i = j;
        break;
      case 7: 
        paramInt = paramContext.getResources().getDimensionPixelSize(2131297500);
        j = paramContext.getResources().getDimensionPixelSize(2131297498);
        paramTextView.measure(0, 0);
        k = paramTextView.getMeasuredWidth();
        i = paramTextView.getMeasuredHeight();
        paramInt -= k / 2;
        i /= 2;
        break;
      case 5: 
        paramInt = paramContext.getResources().getDimensionPixelSize(2131297503);
        i = paramContext.getResources().getDimensionPixelSize(2131297501);
        break;
      case 3: 
        paramInt = paramContext.getResources().getDimensionPixelSize(2131297503);
        i = paramContext.getResources().getDimensionPixelSize(2131297501);
        break;
      case 2: 
        paramInt = paramContext.getResources().getDimensionPixelSize(2131297503);
        i = paramContext.getResources().getDimensionPixelSize(2131297501);
        break;
      case 1: 
        paramInt = paramContext.getResources().getDimensionPixelSize(2131297500);
        j = paramContext.getResources().getDimensionPixelSize(2131297498);
        paramTextView.measure(0, 0);
        k = paramTextView.getMeasuredWidth();
        i = paramTextView.getMeasuredHeight();
        paramInt -= k / 2;
        i /= 2;
      }
      i = j - i;
      paramContext = (ViewGroup.MarginLayoutParams)paramTextView.getLayoutParams();
      if ((paramContext != null) && ((paramContext.leftMargin != paramInt) || (paramContext.bottomMargin != i))) {
        paramContext.setMargins(paramInt, 0, 0, i);
      }
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
    case 10: 
    default: 
      localObject = "";
      paramInt1 = 0;
    case 11: 
    case 7: 
    case 6: 
    case 5: 
    case 4: 
    case 3: 
    case 9: 
    case 2: 
      label372:
      for (;;)
      {
        paramInt3 = 0;
        break label391;
        if (paramInt3 <= 0) {
          paramInt3 = 2130852597;
        }
        paramString = paramTextView.getLayoutParams();
        paramString.width = -2;
        paramString.height = -2;
        paramTextView.setLayoutParams(paramString);
        break;
        if (paramInt3 > 0) {
          paramInt1 = paramInt3;
        } else {
          paramInt1 = 2130852592;
        }
        if (paramInt2 > paramInt4)
        {
          paramString = new StringBuilder();
          paramString.append(String.valueOf(paramInt4));
          paramString.append("+");
          paramString = paramString.toString();
        }
        else
        {
          paramString = String.valueOf(paramInt2);
        }
        RedWidgetUtil.fixTextViewLayout(paramTextView, paramInt2, paramInt4, paramInt1);
        localObject = paramString;
        break label372;
        if (paramInt3 > 0) {
          break;
        }
        paramInt3 = 2130852591;
        break;
        if (paramInt3 <= 0) {
          paramInt3 = 2130852592;
        }
        paramInt1 = paramInt3;
        localObject = paramString;
        if (TextUtils.isEmpty(paramString))
        {
          paramInt1 = paramInt3;
          localObject = "";
          continue;
          if (paramInt3 > 0) {
            paramInt1 = paramInt3;
          } else {
            paramInt1 = 2130852592;
          }
          if (paramInt2 > 99) {
            localObject = "";
          } else {
            localObject = String.valueOf(paramInt2);
          }
          RedWidgetUtil.fixTextViewLayout(paramTextView, paramInt2, paramInt4, paramInt1);
          break label372;
          if (paramInt3 > 0) {
            paramInt1 = paramInt3;
          } else {
            paramInt1 = 2130852592;
          }
          if (paramInt2 > paramInt4)
          {
            paramString = new StringBuilder();
            paramString.append(String.valueOf(paramInt4));
            paramString.append("+");
            paramString = paramString.toString();
          }
          else
          {
            paramString = String.valueOf(paramInt2);
          }
          RedWidgetUtil.fixTextViewLayout(paramTextView, paramInt2, paramInt4, paramInt1);
          localObject = paramString;
          break label372;
          if (paramInt3 > 0) {
            paramInt1 = paramInt3;
          } else {
            paramInt1 = 2130852592;
          }
          localObject = "NEW";
        }
      }
    }
    if (paramInt3 <= 0) {
      paramInt3 = 2130852588;
    }
    Object localObject = "";
    paramInt1 = 0;
    label391:
    paramString = (String)localObject;
    if (localObject == null) {
      paramString = "";
    }
    if ((TextUtils.isEmpty(paramString)) && (paramInt3 == 0) && (paramInt1 == 0))
    {
      paramTextView.setVisibility(8);
      return;
    }
    localObject = paramTextView.getTag(2131449128);
    if (((localObject != null) || (paramInt3 != 0)) && ((!(localObject instanceof Integer)) || (((Integer)localObject).intValue() != paramInt3)))
    {
      paramTextView.setCompoundDrawablesWithIntrinsicBounds(paramInt3, 0, 0, 0);
      paramTextView.setTag(2131449128, Integer.valueOf(paramInt3));
      paramTextView.setText(paramString);
      paramTextView.setPadding(0, 0, 0, 0);
    }
    paramTextView.setBackgroundResource(paramInt1);
    if (!Utils.a(paramTextView.getText().toString(), paramString))
    {
      paramTextView.setCompoundDrawablesWithIntrinsicBounds(0, 0, 0, 0);
      paramTextView.setText(paramString);
    }
    paramTextView.setVisibility(0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.widget.CustomWidgetUtil
 * JD-Core Version:    0.7.0.1
 */