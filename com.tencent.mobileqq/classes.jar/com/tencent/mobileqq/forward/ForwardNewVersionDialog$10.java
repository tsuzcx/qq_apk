package com.tencent.mobileqq.forward;

import android.content.DialogInterface.OnClickListener;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.WindowManager;
import com.tencent.mobileqq.emoticonview.IEmoticonMainPanel;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class ForwardNewVersionDialog$10
  implements View.OnClickListener
{
  ForwardNewVersionDialog$10(ForwardNewVersionDialog paramForwardNewVersionDialog, DialogInterface.OnClickListener paramOnClickListener) {}
  
  public void onClick(View paramView)
  {
    boolean bool;
    if (ForwardNewVersionDialog.l(this.b) != null) {
      bool = ForwardNewVersionDialog.l(this.b).a(paramView);
    } else {
      bool = false;
    }
    this.b.hideSoftInputFromWindow();
    DialogInterface.OnClickListener localOnClickListener = this.a;
    if (localOnClickListener != null) {
      localOnClickListener.onClick(this.b, 1);
    }
    if (ForwardNewVersionDialog.d(this.b))
    {
      ForwardNewVersionDialog.g(this.b).removeView(ForwardNewVersionDialog.f(this.b).getView());
      ForwardNewVersionDialog.a(this.b, false);
    }
    try
    {
      if ((this.b.isShowing()) && (!bool)) {
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
 * Qualified Name:     com.tencent.mobileqq.forward.ForwardNewVersionDialog.10
 * JD-Core Version:    0.7.0.1
 */