package com.tencent.qqmini.sdk.core.utils;

import android.text.TextUtils;
import android.widget.TextView;
import com.tencent.qqmini.sdk.R.drawable;
import com.tencent.qqmini.sdk.R.id;

public class CustomWidgetUtil
{
  public static final int MAX_NOTE_NUM = 99;
  public static final int NOTETXT_STYLE_REDDOT_WITHNUM = 7;
  
  public static boolean equalsWithNullCheck(Object paramObject1, Object paramObject2)
  {
    return (paramObject1 == paramObject2) || ((paramObject1 != null) && (paramObject1.equals(paramObject2)));
  }
  
  public static void updateCustomNoteTxt(TextView paramTextView, int paramInt1, int paramInt2, int paramInt3)
  {
    updateCustomNoteTxt(paramTextView, paramInt1, paramInt2, paramInt3, 99, null);
  }
  
  public static void updateCustomNoteTxt(TextView paramTextView, int paramInt1, int paramInt2, int paramInt3, int paramInt4, String paramString)
  {
    if (paramTextView == null) {
      return;
    }
    if (paramInt1 != 7)
    {
      paramString = "";
      paramInt3 = 0;
    }
    else
    {
      if (paramInt3 <= 0) {
        paramInt3 = R.drawable.mini_sdk_skin_tips_newmessage;
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
    }
    String str = paramString;
    if (paramString == null) {
      str = "";
    }
    if ((TextUtils.isEmpty(str)) && (paramInt3 == 0))
    {
      paramTextView.setVisibility(8);
      return;
    }
    paramString = paramTextView.getTag(R.id.mini_sdk_unreadmsg);
    if ((paramString != null) && ((!(paramString instanceof Integer)) || (((Integer)paramString).intValue() != 0)))
    {
      paramTextView.setCompoundDrawablesWithIntrinsicBounds(0, 0, 0, 0);
      paramTextView.setTag(R.id.mini_sdk_unreadmsg, Integer.valueOf(0));
      paramTextView.setText(str);
      paramTextView.setPadding(0, 0, 0, 0);
    }
    paramTextView.setBackgroundResource(paramInt3);
    if (!equalsWithNullCheck(paramTextView.getText().toString(), str))
    {
      paramTextView.setCompoundDrawablesWithIntrinsicBounds(0, 0, 0, 0);
      paramTextView.setText(str);
    }
    paramTextView.setVisibility(0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     com.tencent.qqmini.sdk.core.utils.CustomWidgetUtil
 * JD-Core Version:    0.7.0.1
 */