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
    if (NetworkUtil.getSystemNetwork(localContext) == 1)
    {
      StructMsgItemVideo.a(this.a, localContext, paramView);
      if ((localContext instanceof BaseActivity)) {
        ReportController.b(((BaseActivity)localContext).app, "CliOper", "", "", "0X8005BA3", "0X8005BA3", 0, 0, "", "", "", "");
      }
    }
    else if (!NetworkUtil.isNetworkAvailable(localContext))
    {
      QQToast.makeText(localContext, 2131889169, 0).show();
    }
    else
    {
      Resources localResources = localContext.getResources();
      DialogUtil.a(localContext, 232, "", HardCodeUtil.a(2131911902), localResources.getString(2131887648), localResources.getString(2131892267), new StructMsgItemVideo.1.1(this, localContext, paramView), new StructMsgItemVideo.1.2(this)).show();
    }
    ReportController.b(null, "CliOper", "", "", "0X8004B5C", "0X8004B5C", 1, 0, "", "", "", "");
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.structmsg.view.StructMsgItemVideo.1
 * JD-Core Version:    0.7.0.1
 */