package com.tencent.widget;

import android.content.Context;
import android.graphics.Typeface;
import android.view.ViewGroup.LayoutParams;
import android.widget.LinearLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.mobileqq.util.DisplayUtil;
import com.tencent.qphone.base.util.QLog;

public class RedWidgetUtil
{
  private static final int RED_DOT_DOUBLE_SIZE = 23;
  private static final int RED_DOT_MAX_SIZE = 30;
  private static final String RED_DOT_QQ_FONT = "fonts/DIN-NextLT-Pro-QQ.ttf";
  private static final int RED_DOT_SINGLE_SIZE = 16;
  private static final int RED_DOT_TEXT_SIZE = 10;
  private static final String TAG = "RedWidgetUtil";
  
  public static void fixTextViewLayout(TextView paramTextView, int paramInt1, int paramInt2, int paramInt3)
  {
    if ((paramTextView != null) && (paramTextView.getContext() != null) && ((paramInt3 == 2130852592) || (paramInt3 == 2130852596)))
    {
      paramInt3 = DisplayUtil.a(paramTextView.getContext(), 16.0F);
      int i = DisplayUtil.a(paramTextView.getContext(), 30.0F);
      int j = DisplayUtil.a(paramTextView.getContext(), 23.0F);
      Object localObject2 = paramTextView.getLayoutParams();
      Object localObject1 = localObject2;
      if (localObject2 == null) {
        localObject1 = new LinearLayout.LayoutParams(paramInt3, paramInt3);
      }
      ((ViewGroup.LayoutParams)localObject1).height = paramInt3;
      if (paramInt2 < 10) {
        ((ViewGroup.LayoutParams)localObject1).width = paramInt3;
      } else if (paramInt1 > paramInt2) {
        ((ViewGroup.LayoutParams)localObject1).width = i;
      } else if (paramInt1 >= 10) {
        ((ViewGroup.LayoutParams)localObject1).width = j;
      } else {
        ((ViewGroup.LayoutParams)localObject1).width = paramInt3;
      }
      paramTextView.setLayoutParams((ViewGroup.LayoutParams)localObject1);
      paramTextView.setTextSize(2, 10.0F);
      paramTextView.setGravity(17);
      paramTextView.setIncludeFontPadding(false);
      try
      {
        paramTextView.setTypeface(Typeface.createFromAsset(paramTextView.getContext().getAssets(), "fonts/DIN-NextLT-Pro-QQ.ttf"));
        return;
      }
      catch (Exception localException)
      {
        localObject2 = new StringBuilder();
        ((StringBuilder)localObject2).append("setTypeFace wrong: ");
        ((StringBuilder)localObject2).append(localException);
        QLog.e("RedWidgetUtil", 1, ((StringBuilder)localObject2).toString());
        paramTextView.setTypeface(Typeface.DEFAULT_BOLD);
        return;
      }
    }
    QLog.e("RedWidgetUtil", 1, "fixTextViewLayout wrong: params wrong");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.widget.RedWidgetUtil
 * JD-Core Version:    0.7.0.1
 */