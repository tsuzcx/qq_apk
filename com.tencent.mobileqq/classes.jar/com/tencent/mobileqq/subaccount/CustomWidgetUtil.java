package com.tencent.mobileqq.subaccount;

import android.text.TextUtils;
import android.widget.TextView;
import com.tencent.mobileqq.util.Utils;
import com.tencent.widget.CustomWidgetConstants;

public class CustomWidgetUtil
  implements CustomWidgetConstants
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
    case 7: 
    case 6: 
    case 5: 
    case 4: 
    case 3: 
    case 9: 
    case 2: 
      label289:
      for (;;)
      {
        paramInt3 = 0;
        break label308;
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
          break label289;
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
            break label192;
            if (paramInt3 > 0) {
              paramInt1 = paramInt3;
            } else {
              paramInt1 = 2130850770;
            }
            if (paramInt2 > 99)
            {
              label192:
              localObject = "";
            }
            else
            {
              localObject = String.valueOf(paramInt2);
              break label289;
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
                break label289;
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
    label308:
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.subaccount.CustomWidgetUtil
 * JD-Core Version:    0.7.0.1
 */