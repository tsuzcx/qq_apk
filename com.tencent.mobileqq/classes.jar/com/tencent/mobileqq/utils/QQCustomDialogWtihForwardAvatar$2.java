package com.tencent.mobileqq.utils;

import android.app.Activity;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.activity.miniaio.MiniChatActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class QQCustomDialogWtihForwardAvatar$2
  implements View.OnClickListener
{
  QQCustomDialogWtihForwardAvatar$2(QQCustomDialogWtihForwardAvatar paramQQCustomDialogWtihForwardAvatar, int paramInt, QQAppInterface paramQQAppInterface, Activity paramActivity, String paramString1, String paramString2) {}
  
  public void onClick(View paramView)
  {
    long l2 = System.currentTimeMillis();
    Object localObject = paramView.getTag();
    long l1;
    if ((localObject instanceof Long)) {
      l1 = ((Long)localObject).longValue();
    } else {
      l1 = 0L;
    }
    if (l2 - l1 < 300L)
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("click in 300ms clickTime: ");
      ((StringBuilder)localObject).append(l1);
      ((StringBuilder)localObject).append(" newTime :");
      ((StringBuilder)localObject).append(l2);
      QLog.i("QQCustomDialogWithForwardAvatar", 2, ((StringBuilder)localObject).toString());
    }
    else
    {
      paramView.setTag(Long.valueOf(l2));
      int i = this.a;
      if ((i != 1) && (i != 3000)) {
        ReportController.b(this.b, "CliOper", "", "", "0X8009BE6", "0X8009BE6", 0, 0, "", "", "", "");
      } else {
        ReportController.b(this.b, "CliOper", "", "", "0X8009BE8", "0X8009BE8", 0, 0, "", "", "", "");
      }
      this.f.hideSoftInputFromWindow();
      localObject = this.c;
      MiniChatActivity.a((Activity)localObject, this.a, this.d, this.e, 0.86F, this.f.a((Activity)localObject, 0.78F));
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.utils.QQCustomDialogWtihForwardAvatar.2
 * JD-Core Version:    0.7.0.1
 */