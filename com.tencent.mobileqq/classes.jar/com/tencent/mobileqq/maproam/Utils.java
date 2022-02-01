package com.tencent.mobileqq.maproam;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.view.Window;
import android.widget.ProgressBar;
import android.widget.TextView;
import com.tencent.qqlive.module.videoreport.inject.dialog.ReportProgressDialog;

public class Utils
{
  public static ProgressDialog a(Context paramContext, String paramString)
  {
    Drawable localDrawable = paramContext.getResources().getDrawable(2130849933);
    paramContext = new ReportProgressDialog(paramContext, 2131756189);
    paramContext.show();
    paramContext.getWindow().setContentView(2131558463);
    paramContext.setContentView(2131558463);
    ((TextView)paramContext.findViewById(2131365644)).setText(paramString);
    ((ProgressBar)paramContext.findViewById(2131367113)).setIndeterminateDrawable(localDrawable);
    return paramContext;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.maproam.Utils
 * JD-Core Version:    0.7.0.1
 */