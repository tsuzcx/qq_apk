package com.tencent.widget;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.view.View;
import android.widget.LinearLayout.LayoutParams;
import com.tencent.util.LogUtil;
import java.util.List;

public class ActionSheetHelper
{
  public static Dialog a(Context paramContext, View paramView)
  {
    paramContext = ActionSheet.a(paramContext);
    paramContext.a(paramView, new LinearLayout.LayoutParams(-1, -1));
    return paramContext;
  }
  
  public static ActionSheet a(Context paramContext, ActionSheet paramActionSheet, List paramList, ActionSheet.OnButtonClickListener paramOnButtonClickListener)
  {
    if ((paramContext == null) || (paramList == null) || (paramList.size() <= 0)) {
      return null;
    }
    int i;
    if (paramActionSheet == null)
    {
      paramActionSheet = (ActionSheet)a(paramContext, null);
      i = 0;
      label35:
      if (i >= paramList.size()) {
        break label116;
      }
      paramContext = (ActionMenuItem)paramList.get(i);
      if (paramContext.d == 0)
      {
        if (paramContext.a != 1) {
          break label99;
        }
        paramActionSheet.a(paramContext, 1);
      }
    }
    for (;;)
    {
      i += 1;
      break label35;
      paramActionSheet.c();
      paramActionSheet.a();
      break;
      label99:
      if (paramContext.a == 2) {
        paramActionSheet.a(paramContext, 3);
      }
    }
    label116:
    paramActionSheet.a(paramOnButtonClickListener);
    return paramActionSheet;
  }
  
  public static ActionSheet a(Context paramContext, List paramList, ActionSheet.OnButtonClickListener paramOnButtonClickListener)
  {
    return a(paramContext, null, paramList, paramOnButtonClickListener);
  }
  
  public static String a(Context paramContext, int paramInt)
  {
    if (paramContext == null) {
      return null;
    }
    return paramContext.getString(paramInt);
  }
  
  public static void a(Activity paramActivity, ActionSheet paramActionSheet)
  {
    if ((paramActivity == null) || (paramActionSheet == null)) {
      return;
    }
    try
    {
      if (!paramActivity.isFinishing())
      {
        paramActionSheet.show();
        return;
      }
    }
    catch (Exception paramActivity)
    {
      paramActivity.printStackTrace();
      return;
    }
    LogUtil.e("ActionSheetHelper", "showActionSheet when activity(" + paramActivity + ") is finish!");
  }
  
  public static Dialog b(Context paramContext, View paramView)
  {
    paramContext = ActionSheet.b(paramContext);
    paramContext.a(paramView, new LinearLayout.LayoutParams(-1, -1));
    return paramContext;
  }
  
  public static void b(Activity paramActivity, ActionSheet paramActionSheet)
  {
    if ((paramActivity == null) || (paramActionSheet == null)) {
      return;
    }
    try
    {
      if (!paramActivity.isFinishing())
      {
        paramActionSheet.dismiss();
        return;
      }
    }
    catch (Exception paramActivity)
    {
      paramActivity.printStackTrace();
      return;
    }
    LogUtil.e("ActionSheetHelper", "dismissActionSheet when activity(" + paramActivity + ") is finish!");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.widget.ActionSheetHelper
 * JD-Core Version:    0.7.0.1
 */