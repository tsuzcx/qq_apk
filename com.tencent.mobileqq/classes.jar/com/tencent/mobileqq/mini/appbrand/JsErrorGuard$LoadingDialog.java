package com.tencent.mobileqq.mini.appbrand;

import android.app.Dialog;
import android.content.Context;
import android.content.res.Resources;
import android.view.Window;
import android.widget.TextView;
import com.tencent.qqlive.module.videoreport.inject.dialog.ReportDialog;
import cooperation.qzone.util.QZLog;

public class JsErrorGuard$LoadingDialog
  extends ReportDialog
{
  JsErrorGuard$LoadingDialog(Context paramContext)
  {
    super(paramContext, 2131755677);
    setContentView(2131562319);
    getWindow().setFlags(1024, 2048);
  }
  
  public void dismiss()
  {
    try
    {
      super.dismiss();
      return;
    }
    catch (Exception localException)
    {
      QZLog.w(localException);
    }
  }
  
  public void setTitle(int paramInt)
  {
    if (paramInt == 0) {}
    for (String str = null;; str = getContext().getResources().getString(paramInt))
    {
      setTitle(str);
      return;
    }
  }
  
  public void setTitle(String paramString)
  {
    ((TextView)findViewById(2131378936)).setText(paramString);
  }
  
  public void show()
  {
    try
    {
      super.show();
      return;
    }
    catch (Exception localException)
    {
      QZLog.w(localException);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.mini.appbrand.JsErrorGuard.LoadingDialog
 * JD-Core Version:    0.7.0.1
 */