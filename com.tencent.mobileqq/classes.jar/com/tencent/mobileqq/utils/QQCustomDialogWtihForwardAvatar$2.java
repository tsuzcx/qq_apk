package com.tencent.mobileqq.utils;

import android.app.Activity;
import android.view.View;
import android.view.View.OnClickListener;
import bdla;
import com.tencent.mobileqq.activity.miniaio.MiniChatActivity;
import com.tencent.mobileqq.app.QQAppInterface;
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
    if ((localObject instanceof Long)) {}
    for (long l1 = ((Long)localObject).longValue();; l1 = 0L)
    {
      if (l2 - l1 < 300L)
      {
        QLog.i("QQCustomDialogWithForwardAvatar", 2, "click in 300ms clickTime: " + l1 + " newTime :" + l2);
        EventCollector.getInstance().onViewClicked(paramView);
        return;
      }
      paramView.setTag(Long.valueOf(l2));
      if ((this.val$uinType == 1) || (this.val$uinType == 3000)) {
        bdla.b(this.val$app, "CliOper", "", "", "0X8009BE8", "0X8009BE8", 0, 0, "", "", "", "");
      }
      for (;;)
      {
        this.this$0.hideSoftInputFromWindow();
        MiniChatActivity.a(this.val$activity, this.val$uinType, this.val$uin, this.val$titleStr, 0.86F, this.this$0.getElasticScaleRation(this.val$activity, 0.78F));
        break;
        bdla.b(this.val$app, "CliOper", "", "", "0X8009BE6", "0X8009BE6", 0, 0, "", "", "", "");
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.mobileqq.utils.QQCustomDialogWtihForwardAvatar.2
 * JD-Core Version:    0.7.0.1
 */