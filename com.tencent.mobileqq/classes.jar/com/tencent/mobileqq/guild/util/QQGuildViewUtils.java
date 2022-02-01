package com.tencent.mobileqq.guild.util;

import android.view.View;
import android.view.ViewGroup.LayoutParams;
import androidx.annotation.NonNull;
import com.tencent.qphone.base.util.QLog;

public class QQGuildViewUtils
{
  public static void a(@NonNull View paramView, int paramInt)
  {
    ViewGroup.LayoutParams localLayoutParams = paramView.getLayoutParams();
    if (QLog.isDevelopLevel()) {
      QLog.d("QQGuildViewUtils", 4, new Object[] { "changeHeight, ", paramView, " from ", Integer.valueOf(localLayoutParams.height), " to ", Integer.valueOf(paramInt) });
    }
    if (localLayoutParams.height != paramInt)
    {
      localLayoutParams.height = paramInt;
      paramView.requestLayout();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.guild.util.QQGuildViewUtils
 * JD-Core Version:    0.7.0.1
 */