package com.tencent.mobileqq.util;

import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface.OnDismissListener;
import android.content.res.Resources;
import android.view.View.OnClickListener;
import android.widget.TextView;

public class CustomDialogFactory
{
  public static Dialog a(Context paramContext, int paramInt1, int paramInt2, int paramInt3, int paramInt4, View.OnClickListener paramOnClickListener1, View.OnClickListener paramOnClickListener2)
  {
    Object localObject2 = paramContext.getResources().getString(paramInt1);
    Object localObject1 = paramContext.getResources().getString(paramInt2);
    String str2 = paramContext.getResources().getString(paramInt3);
    String str1 = paramContext.getResources().getString(paramInt4);
    paramContext = new Dialog(paramContext, 2131624516);
    paramContext.setContentView(2130968842);
    TextView localTextView = (TextView)paramContext.findViewById(2131364034);
    if (localTextView != null)
    {
      localTextView.setText((CharSequence)localObject2);
      localTextView.setContentDescription((CharSequence)localObject2);
    }
    localObject2 = (TextView)paramContext.findViewById(2131362776);
    if (localObject2 != null)
    {
      ((TextView)localObject2).setText((CharSequence)localObject1);
      ((TextView)localObject2).setContentDescription((CharSequence)localObject1);
    }
    localObject1 = (TextView)paramContext.findViewById(2131364037);
    if (localObject1 != null)
    {
      ((TextView)localObject1).setText(str2);
      ((TextView)localObject1).setContentDescription(str2);
      if (paramOnClickListener1 != null) {
        ((TextView)localObject1).setOnClickListener(paramOnClickListener1);
      }
    }
    paramOnClickListener1 = (TextView)paramContext.findViewById(2131364038);
    if (paramOnClickListener1 != null)
    {
      paramOnClickListener1.setText(str1);
      paramOnClickListener1.setContentDescription(str1);
      if (paramOnClickListener2 != null) {
        paramOnClickListener1.setOnClickListener(paramOnClickListener2);
      }
    }
    return paramContext;
  }
  
  public static Dialog a(Context paramContext, String paramString1, String paramString2, DialogInterface.OnDismissListener paramOnDismissListener)
  {
    paramContext = new Dialog(paramContext, 2131624516);
    paramContext.setContentView(2130968842);
    TextView localTextView = (TextView)paramContext.findViewById(2131364034);
    if (localTextView != null) {
      localTextView.setText(paramString1);
    }
    paramString1 = (TextView)paramContext.findViewById(2131362776);
    if (paramString1 != null) {
      paramString1.setText(paramString2);
    }
    paramString1 = (TextView)paramContext.findViewById(2131364037);
    if (paramString1 != null) {
      paramString1.setText(2131434352);
    }
    paramString1 = (TextView)paramContext.findViewById(2131364038);
    if (paramString1 != null) {
      paramString1.setText(2131433698);
    }
    paramContext.setOnDismissListener(paramOnDismissListener);
    return paramContext;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\b.jar
 * Qualified Name:     com.tencent.mobileqq.util.CustomDialogFactory
 * JD-Core Version:    0.7.0.1
 */