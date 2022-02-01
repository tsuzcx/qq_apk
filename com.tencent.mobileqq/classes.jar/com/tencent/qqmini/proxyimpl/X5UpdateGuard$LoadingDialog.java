package com.tencent.qqmini.proxyimpl;

import android.app.Dialog;
import android.content.Context;
import android.content.res.Resources;
import android.view.Window;
import android.widget.TextView;
import cooperation.qzone.util.QZLog;

public class X5UpdateGuard$LoadingDialog
  extends Dialog
{
  X5UpdateGuard$LoadingDialog(Context paramContext)
  {
    super(paramContext, 2131953180);
    setContentView(2131628666);
    getWindow().setFlags(1024, 2048);
  }
  
  public void a(String paramString)
  {
    ((TextView)findViewById(2131447463)).setText(paramString);
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
    String str;
    if (paramInt == 0) {
      str = null;
    } else {
      str = getContext().getResources().getString(paramInt);
    }
    a(str);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.qqmini.proxyimpl.X5UpdateGuard.LoadingDialog
 * JD-Core Version:    0.7.0.1
 */