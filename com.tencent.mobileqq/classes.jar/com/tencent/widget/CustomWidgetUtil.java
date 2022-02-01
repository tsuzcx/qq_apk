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
      int j = paramContext.getResources().getDimensionPixelSize(2131297119);
      int i = paramContext.getResources().getDimensionPixelSize(2131297117);
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
          paramTextView.setMargins(0, 0, paramContext.getResources().getDimensionPixelSize(2131297124), 0);
        }
        return;
      case 9: 
        paramInt = paramContext.getResources().getDimensionPixelSize(2131297123);
        i = paramContext.getResources().getDimensionPixelSize(2131297121);
        break;
      case 8: 
        k = paramContext.getResources().getDimensionPixelSize(2131297119);
        i = paramContext.getResources().getDimensionPixelSize(2131297118);
        paramInt = i;
        if (paramBoolean) {
          paramInt = i + ViewUtils.a(8.0F);
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
        paramInt = paramContext.getResources().getDimensionPixelSize(2131297119);
        j = paramContext.getResources().getDimensionPixelSize(2131297117);
        paramTextView.measure(0, 0);
        k = paramTextView.getMeasuredWidth();
        i = paramTextView.getMeasuredHeight();
        paramInt -= k / 2;
        i /= 2;
        break;
      case 5: 
        paramInt = paramContext.getResources().getDimensionPixelSize(2131297122);
        i = paramContext.getResources().getDimensionPixelSize(2131297120);
        break;
      case 3: 
        paramInt = paramContext.getResources().getDimensionPixelSize(2131297122);
        i = paramContext.getResources().getDimensionPixelSize(2131297120);
        break;
      case 2: 
        paramInt = paramContext.getResources().getDimensionPixelSize(2131297122);
        i = paramContext.getResources().getDimensionPixelSize(2131297120);
        break;
      case 1: 
        paramInt = paramContext.getResources().getDimensionPixelSize(2131297119);
        j = paramContext.getResources().getDimensionPixelSize(2131297117);
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
      label310:
      for (;;)
      {
        paramInt3 = 0;
        break label329;
        if (paramInt3 > 0) {
          break;
        }
        paramInt3 = 2130850775;
        break;
        if (paramInt3 > 0) {
          paramInt1 = paramInt3;
        } else {
          paramInt1 = 2130850770;
        }
        if (paramInt2 > paramInt4)
        {
          paramString = new StringBuilder();
          paramString.append(String.valueOf(paramInt4));
          paramString.append("+");
          localObject = paramString.toString();
        }
        else
        {
          localObject = String.valueOf(paramInt2);
          break label310;
          if (paramInt3 > 0) {
            break;
          }
          paramInt3 = 2130850769;
          break;
          if (paramInt3 <= 0) {
            paramInt3 = 2130850770;
          }
          paramInt1 = paramInt3;
          localObject = paramString;
          if (TextUtils.isEmpty(paramString))
          {
            paramInt1 = paramInt3;
            break label213;
            if (paramInt3 > 0) {
              paramInt1 = paramInt3;
            } else {
              paramInt1 = 2130850770;
            }
            if (paramInt2 > 99)
            {
              label213:
              localObject = "";
            }
            else
            {
              localObject = String.valueOf(paramInt2);
              break label310;
              if (paramInt3 > 0) {
                paramInt1 = paramInt3;
              } else {
                paramInt1 = 2130850770;
              }
              if (paramInt2 > paramInt4)
              {
                paramString = new StringBuilder();
                paramString.append(String.valueOf(paramInt4));
                paramString.append("+");
                localObject = paramString.toString();
              }
              else
              {
                localObject = String.valueOf(paramInt2);
                break label310;
                if (paramInt3 > 0) {
                  paramInt1 = paramInt3;
                } else {
                  paramInt1 = 2130850770;
                }
                localObject = "NEW";
              }
            }
          }
        }
      }
    }
    if (paramInt3 <= 0) {
      paramInt3 = 2130850766;
    }
    Object localObject = "";
    paramInt1 = 0;
    label329:
    paramString = (String)localObject;
    if (localObject == null) {
      paramString = "";
    }
    if ((TextUtils.isEmpty(paramString)) && (paramInt3 == 0) && (paramInt1 == 0))
    {
      paramTextView.setVisibility(8);
      return;
    }
    localObject = paramTextView.getTag(2131380210);
    if (((localObject != null) || (paramInt3 != 0)) && ((!(localObject instanceof Integer)) || (((Integer)localObject).intValue() != paramInt3)))
    {
      paramTextView.setCompoundDrawablesWithIntrinsicBounds(paramInt3, 0, 0, 0);
      paramTextView.setTag(2131380210, Integer.valueOf(paramInt3));
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.widget.CustomWidgetUtil
 * JD-Core Version:    0.7.0.1
 */