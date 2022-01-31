package com.tencent.mobileqq.teamwork;

import ahym;
import ahyn;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface.OnClickListener;
import android.text.TextUtils;
import android.text.method.LinkMovementMethod;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class TeamWorkSaveDialog
  extends Dialog
{
  public TeamWorkSaveDialog(Context paramContext, String paramString1, String paramString2, DialogInterface.OnClickListener paramOnClickListener1, DialogInterface.OnClickListener paramOnClickListener2)
  {
    super(paramContext, 2131624515);
    setContentView(2130971593);
    paramContext = (TextView)findViewById(2131363360);
    if (!TextUtils.isEmpty(paramString1))
    {
      paramContext.setVisibility(0);
      paramContext.setText(paramString1);
      paramContext = (TextView)findViewById(2131363039);
      if (TextUtils.isEmpty(paramString2)) {
        break label142;
      }
      paramContext.setVisibility(0);
      paramContext.setMovementMethod(LinkMovementMethod.getInstance());
      paramContext.setText(new OpenDefaultBrowserQQText(paramString2, 8));
    }
    for (;;)
    {
      ((Button)findViewById(2131367686)).setOnClickListener(new ahym(this, paramOnClickListener1));
      ((ImageView)findViewById(2131363954)).setOnClickListener(new ahyn(this, paramOnClickListener2));
      setCanceledOnTouchOutside(false);
      return;
      paramContext.setVisibility(8);
      break;
      label142:
      paramContext.setVisibility(8);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\tmp\com33.jar
 * Qualified Name:     com.tencent.mobileqq.teamwork.TeamWorkSaveDialog
 * JD-Core Version:    0.7.0.1
 */