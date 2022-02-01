package com.tencent.mobileqq.utils;

import android.app.Activity;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.activity.miniaio.MiniChatActivity;
import com.tencent.mobileqq.selectmember.ResultRecord;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class QQCustomDialogWtihForwardAvatar$3
  implements View.OnClickListener
{
  QQCustomDialogWtihForwardAvatar$3(QQCustomDialogWtihForwardAvatar paramQQCustomDialogWtihForwardAvatar, Activity paramActivity) {}
  
  public void onClick(View paramView)
  {
    ResultRecord localResultRecord = (ResultRecord)paramView.getTag();
    if (localResultRecord.uinType != 10014)
    {
      this.b.hideSoftInputFromWindow();
      MiniChatActivity.a(this.a, localResultRecord.getUinType(), localResultRecord.uin, localResultRecord.name, 0.86F, this.b.a(this.a, 0.78F));
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.utils.QQCustomDialogWtihForwardAvatar.3
 * JD-Core Version:    0.7.0.1
 */