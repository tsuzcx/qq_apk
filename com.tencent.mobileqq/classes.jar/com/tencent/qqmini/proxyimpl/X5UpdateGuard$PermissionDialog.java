package com.tencent.qqmini.proxyimpl;

import android.app.Activity;
import android.view.View;
import com.tencent.mobileqq.utils.QQCustomDialog;

class X5UpdateGuard$PermissionDialog
  extends QQCustomDialog
{
  private Activity a;
  
  public X5UpdateGuard$PermissionDialog(Activity paramActivity, int paramInt)
  {
    super(paramActivity, paramInt);
    this.a = paramActivity;
    a();
  }
  
  public void a()
  {
    setContentView(2131559075);
    findViewById(2131370089).setVisibility(8);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.qqmini.proxyimpl.X5UpdateGuard.PermissionDialog
 * JD-Core Version:    0.7.0.1
 */