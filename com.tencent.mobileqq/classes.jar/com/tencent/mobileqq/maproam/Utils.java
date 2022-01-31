package com.tencent.mobileqq.maproam;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.view.Window;
import android.widget.ProgressBar;
import android.widget.TextView;

public class Utils
{
  public static ProgressDialog a(Context paramContext, String paramString)
  {
    Drawable localDrawable = paramContext.getResources().getDrawable(2130845341);
    paramContext = new ProgressDialog(paramContext, 2131624515);
    paramContext.show();
    paramContext.getWindow().setContentView(2130968595);
    paramContext.setContentView(2130968595);
    ((TextView)paramContext.findViewById(2131362758)).setText(paramString);
    ((ProgressBar)paramContext.findViewById(2131362757)).setIndeterminateDrawable(localDrawable);
    return paramContext;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.maproam.Utils
 * JD-Core Version:    0.7.0.1
 */