package com.tencent.mobileqq.structmsg.view;

import android.app.Dialog;
import android.content.Context;
import android.content.res.Resources;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.utils.DialogUtil;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class StructMsgItemVideo$1
  implements View.OnClickListener
{
  StructMsgItemVideo$1(StructMsgItemVideo paramStructMsgItemVideo) {}
  
  public void onClick(View paramView)
  {
    Context localContext = paramView.getContext();
    if (NetworkUtil.a(localContext) == 1)
    {
      StructMsgItemVideo.a(this.a, localContext, paramView);
      if ((localContext instanceof BaseActivity)) {
        ReportController.b(((BaseActivity)localContext).app, "CliOper", "", "", "0X8005BA3", "0X8005BA3", 0, 0, "", "", "", "");
      }
    }
    for (;;)
    {
      ReportController.b(null, "CliOper", "", "", "0X8004B5C", "0X8004B5C", 1, 0, "", "", "", "");
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      if (!NetworkUtil.g(localContext))
      {
        QQToast.a(localContext, 2131692257, 0).a();
      }
      else
      {
        Resources localResources = localContext.getResources();
        DialogUtil.a(localContext, 232, "", HardCodeUtil.a(2131714469), localResources.getString(2131690800), localResources.getString(2131694615), new StructMsgItemVideo.1.1(this, localContext, paramView), new StructMsgItemVideo.1.2(this)).show();
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.structmsg.view.StructMsgItemVideo.1
 * JD-Core Version:    0.7.0.1
 */