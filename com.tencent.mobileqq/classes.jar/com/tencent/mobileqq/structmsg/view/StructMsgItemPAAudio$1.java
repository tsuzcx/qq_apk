package com.tencent.mobileqq.structmsg.view;

import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.transfile.api.IPttTransProcessorHelper;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.io.File;

class StructMsgItemPAAudio$1
  implements View.OnClickListener
{
  StructMsgItemPAAudio$1(StructMsgItemPAAudio paramStructMsgItemPAAudio) {}
  
  public void onClick(View paramView)
  {
    if (!TextUtils.isEmpty(this.a.aM)) {
      try
      {
        String str = ((IPttTransProcessorHelper)QRoute.api(IPttTransProcessorHelper.class)).getPAAudioPttPath(this.a.aB, this.a.aA);
        if (TextUtils.isEmpty(str))
        {
          this.a.c();
          this.a.a(this.a.aM, paramView);
        }
        else if (new File(str).exists())
        {
          if (this.a.aE) {
            this.a.f();
          } else {
            this.a.e();
          }
        }
        else
        {
          this.a.c();
          this.a.a(this.a.aM, paramView);
        }
        ReportController.b(this.a.aB, "P_CliOper", "Pb_account_lifeservice", "", "0X8005C9B", "0X8005C9B", 0, 1, 0, this.a.aM, this.a.aB.getCurrentAccountUin(), this.a.ay, this.a.aA);
      }
      catch (Exception localException)
      {
        localException.printStackTrace();
      }
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.structmsg.view.StructMsgItemPAAudio.1
 * JD-Core Version:    0.7.0.1
 */