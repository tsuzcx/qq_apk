package com.tencent.mobileqq.teamwork;

import android.content.Context;
import android.content.DialogInterface.OnClickListener;
import android.text.TextUtils;
import android.text.method.LinkMovementMethod;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.qqlive.module.videoreport.inject.dialog.ReportDialog;

public class TeamWorkSaveDialog
  extends ReportDialog
{
  public TeamWorkSaveDialog(Context paramContext, String paramString1, String paramString2, DialogInterface.OnClickListener paramOnClickListener1, DialogInterface.OnClickListener paramOnClickListener2)
  {
    super(paramContext, 2131755842);
    setContentView(2131563103);
    paramContext = (TextView)findViewById(2131379432);
    if (!TextUtils.isEmpty(paramString1))
    {
      paramContext.setVisibility(0);
      paramContext.setText(paramString1);
      paramContext = (TextView)findViewById(2131365294);
      if (TextUtils.isEmpty(paramString2)) {
        break label142;
      }
      paramContext.setVisibility(0);
      paramContext.setMovementMethod(LinkMovementMethod.getInstance());
      paramContext.setText(new OpenDefaultBrowserQQText(paramString2, 8));
    }
    for (;;)
    {
      ((Button)findViewById(2131365207)).setOnClickListener(new TeamWorkSaveDialog.1(this, paramOnClickListener1));
      ((ImageView)findViewById(2131364824)).setOnClickListener(new TeamWorkSaveDialog.2(this, paramOnClickListener2));
      setCanceledOnTouchOutside(false);
      return;
      paramContext.setVisibility(8);
      break;
      label142:
      paramContext.setVisibility(8);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.teamwork.TeamWorkSaveDialog
 * JD-Core Version:    0.7.0.1
 */