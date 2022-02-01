package com.tencent.mobileqq.onlinestatus.utils;

import android.text.TextUtils;
import android.widget.TextView;
import com.tencent.mobileqq.util.Utils;

public class WidgetUtils
{
  public static void a(TextView paramTextView, int paramInt1, int paramInt2, int paramInt3, int paramInt4, String paramString)
  {
    if (paramTextView == null) {
      return;
    }
    switch (paramInt1)
    {
    default: 
      localObject = "";
      paramInt1 = 0;
    case 6: 
    case 5: 
    case 4: 
    case 3: 
    case 7: 
    case 9: 
    case 2: 
      label224:
      for (;;)
      {
        paramInt3 = 0;
        break label243;
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
          break label127;
          if (paramInt3 > 0) {
            paramInt1 = paramInt3;
          } else {
            paramInt1 = 2130852592;
          }
          if (paramInt2 > 99)
          {
            label127:
            localObject = "";
          }
          else
          {
            localObject = String.valueOf(paramInt2);
            break label224;
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
              localObject = paramString.toString();
            }
            else
            {
              localObject = String.valueOf(paramInt2);
              break label224;
              if (paramInt3 > 0) {
                paramInt1 = paramInt3;
              } else {
                paramInt1 = 2130852592;
              }
              localObject = "NEW";
            }
          }
        }
      }
    }
    if (paramInt3 <= 0) {
      paramInt3 = 2130852588;
    }
    Object localObject = "";
    paramInt1 = 0;
    label243:
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.onlinestatus.utils.WidgetUtils
 * JD-Core Version:    0.7.0.1
 */