package com.tencent.widget;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.widget.LinearLayout.LayoutParams;
import com.tencent.qphone.base.util.QLog;
import java.util.List;

public class ActionSheetHelper
{
  public static Dialog a(Context paramContext, View paramView, int paramInt, ViewGroup.LayoutParams paramLayoutParams)
  {
    paramContext = ActionSheet.create(paramContext, paramInt, paramLayoutParams);
    paramContext.setActionContentView(paramView, null);
    return paramContext;
  }
  
  public static ActionSheet a(Context paramContext, ActionSheet paramActionSheet, List<ActionMenuItem> paramList, ActionSheet.OnButtonClickListener paramOnButtonClickListener)
  {
    if ((paramContext != null) && (paramList != null))
    {
      if (paramList.size() <= 0) {
        return null;
      }
      if (paramActionSheet == null)
      {
        paramActionSheet = (ActionSheet)b(paramContext, null);
      }
      else
      {
        paramActionSheet.clear();
        paramActionSheet.updateUI();
      }
      int i = 0;
      while (i < paramList.size())
      {
        paramContext = (ActionMenuItem)paramList.get(i);
        if (paramContext.visibility == 0) {
          if (paramContext.type == 1) {
            paramActionSheet.addButton(paramContext, 1);
          } else if (paramContext.type == 2) {
            paramActionSheet.addButton(paramContext, 3);
          }
        }
        i += 1;
      }
      paramActionSheet.setOnButtonClickListener(paramOnButtonClickListener);
      return paramActionSheet;
    }
    return null;
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
    if (paramActivity != null)
    {
      if (paramActionSheet == null) {
        return;
      }
      try
      {
        if (!paramActivity.isFinishing())
        {
          paramActionSheet.show();
          return;
        }
        paramActionSheet = new StringBuilder();
        paramActionSheet.append("showActionSheet when activity(");
        paramActionSheet.append(paramActivity);
        paramActionSheet.append(") is finish!");
        QLog.e("ActionSheetHelper", 1, paramActionSheet.toString());
        return;
      }
      catch (Exception paramActivity)
      {
        paramActivity.printStackTrace();
      }
    }
  }
  
  public static Dialog b(Context paramContext, View paramView)
  {
    return a(paramContext, paramView, -1, null);
  }
  
  public static ActionSheet b(Context paramContext, List<ActionMenuItem> paramList, ActionSheet.OnButtonClickListener paramOnButtonClickListener)
  {
    return a(paramContext, null, paramList, paramOnButtonClickListener);
  }
  
  public static void b(Activity paramActivity, ActionSheet paramActionSheet)
  {
    if (paramActivity != null)
    {
      if (paramActionSheet == null) {
        return;
      }
      try
      {
        if (!paramActivity.isFinishing())
        {
          paramActionSheet.dismiss();
          return;
        }
        paramActionSheet = new StringBuilder();
        paramActionSheet.append("dismissActionSheet when activity(");
        paramActionSheet.append(paramActivity);
        paramActionSheet.append(") is finish!");
        QLog.e("ActionSheetHelper", 1, paramActionSheet.toString());
        return;
      }
      catch (Exception paramActivity)
      {
        paramActivity.printStackTrace();
      }
    }
  }
  
  public static Dialog c(Context paramContext, View paramView)
  {
    paramContext = ActionSheet.createFullScreenDialog(paramContext);
    paramContext.setActionContentView(paramView, new LinearLayout.LayoutParams(-1, -1));
    return paramContext;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.widget.ActionSheetHelper
 * JD-Core Version:    0.7.0.1
 */