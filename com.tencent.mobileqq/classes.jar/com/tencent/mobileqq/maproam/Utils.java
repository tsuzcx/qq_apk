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
    Drawable localDrawable = paramContext.getResources().getDrawable(2130851670);
    paramContext = new ReportProgressDialog(paramContext, 2131953338);
    paramContext.show();
    paramContext.getWindow().setContentView(2131623999);
    paramContext.setContentView(2131623999);
    ((TextView)paramContext.findViewById(2131431876)).setText(paramString);
    ((ProgressBar)paramContext.findViewById(2131433567)).setIndeterminateDrawable(localDrawable);
    return paramContext;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.maproam.Utils
 * JD-Core Version:    0.7.0.1
 */