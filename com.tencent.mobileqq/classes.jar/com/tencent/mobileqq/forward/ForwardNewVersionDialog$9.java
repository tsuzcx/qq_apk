package com.tencent.mobileqq.forward;

import android.content.DialogInterface.OnClickListener;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.WindowManager;
import com.tencent.mobileqq.emoticonview.IEmoticonMainPanel;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class ForwardNewVersionDialog$9
  implements View.OnClickListener
{
  ForwardNewVersionDialog$9(ForwardNewVersionDialog paramForwardNewVersionDialog, DialogInterface.OnClickListener paramOnClickListener) {}
  
  public void onClick(View paramView)
  {
    this.b.hideSoftInputFromWindow();
    DialogInterface.OnClickListener localOnClickListener = this.a;
    if (localOnClickListener != null) {
      localOnClickListener.onClick(this.b, 0);
    }
    if (ForwardNewVersionDialog.d(this.b))
    {
      ForwardNewVersionDialog.g(this.b).removeView(ForwardNewVersionDialog.f(this.b).getView());
      ForwardNewVersionDialog.a(this.b, false);
    }
    try
    {
      if (this.b.isShowing()) {
        this.b.dismiss();
      }
    }
    catch (Exception localException)
    {
      if (QLog.isColorLevel()) {
        QLog.d("Forward.NewVersion.Dialog", 2, Log.getStackTraceString(localException));
      }
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.forward.ForwardNewVersionDialog.9
 * JD-Core Version:    0.7.0.1
 */