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
    super(paramContext, 2131953338);
    setContentView(2131629509);
    paramContext = (TextView)findViewById(2131447463);
    if (!TextUtils.isEmpty(paramString1))
    {
      paramContext.setVisibility(0);
      paramContext.setText(paramString1);
    }
    else
    {
      paramContext.setVisibility(8);
    }
    paramContext = (TextView)findViewById(2131431322);
    if (!TextUtils.isEmpty(paramString2))
    {
      paramContext.setVisibility(0);
      paramContext.setMovementMethod(LinkMovementMethod.getInstance());
      paramContext.setText(new OpenDefaultBrowserQQText(paramString2, 8));
    }
    else
    {
      paramContext.setVisibility(8);
    }
    ((Button)findViewById(2131431227)).setOnClickListener(new TeamWorkSaveDialog.1(this, paramOnClickListener1));
    ((ImageView)findViewById(2131430817)).setOnClickListener(new TeamWorkSaveDialog.2(this, paramOnClickListener2));
    setCanceledOnTouchOutside(false);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.teamwork.TeamWorkSaveDialog
 * JD-Core Version:    0.7.0.1
 */