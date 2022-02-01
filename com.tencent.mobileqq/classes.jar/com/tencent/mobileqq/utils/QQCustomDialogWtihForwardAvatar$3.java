package com.tencent.mobileqq.utils;

import android.app.Activity;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.activity.miniaio.MiniChatActivity;
import com.tencent.mobileqq.activity.selectmember.ResultRecord;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class QQCustomDialogWtihForwardAvatar$3
  implements View.OnClickListener
{
  QQCustomDialogWtihForwardAvatar$3(QQCustomDialogWtihForwardAvatar paramQQCustomDialogWtihForwardAvatar, Activity paramActivity) {}
  
  public void onClick(View paramView)
  {
    ResultRecord localResultRecord = (ResultRecord)paramView.getTag();
    this.this$0.hideSoftInputFromWindow();
    MiniChatActivity.a(this.val$activity, localResultRecord.getUinType(), localResultRecord.uin, localResultRecord.name, 0.86F, this.this$0.getElasticScaleRation(this.val$activity, 0.78F));
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.mobileqq.utils.QQCustomDialogWtihForwardAvatar.3
 * JD-Core Version:    0.7.0.1
 */