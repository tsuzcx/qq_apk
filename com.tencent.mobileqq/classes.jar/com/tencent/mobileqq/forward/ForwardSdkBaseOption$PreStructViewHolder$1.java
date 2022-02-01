package com.tencent.mobileqq.forward;

import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.activity.QQBrowserDelegationActivity;
import com.tencent.mobileqq.activity.WebAccelerator;
import com.tencent.mobileqq.structmsg.AbsShareMsg;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class ForwardSdkBaseOption$PreStructViewHolder$1
  implements View.OnClickListener
{
  ForwardSdkBaseOption$PreStructViewHolder$1(ForwardSdkBaseOption.PreStructViewHolder paramPreStructViewHolder) {}
  
  public void onClick(View paramView)
  {
    if (this.a.d.am != null)
    {
      String str = this.a.d.am.mMsgUrl.trim();
      if (QLog.isColorLevel())
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("gotoWeb ");
        ((StringBuilder)localObject).append(str);
        QLog.e("ForwardOption.ForwardSdkBaseOption", 2, ((StringBuilder)localObject).toString());
      }
      Object localObject = new Intent(this.a.d.s, QQBrowserDelegationActivity.class);
      ((Intent)localObject).putExtra("param_force_internal_browser", true);
      ((Intent)localObject).putExtra("reqType", 7);
      ((Intent)localObject).putExtra("hide_more_button", true);
      ((Intent)localObject).putExtra("url", str);
      WebAccelerator.a(this.a.d.s, (Intent)localObject, str);
      this.a.d.aq();
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.forward.ForwardSdkBaseOption.PreStructViewHolder.1
 * JD-Core Version:    0.7.0.1
 */