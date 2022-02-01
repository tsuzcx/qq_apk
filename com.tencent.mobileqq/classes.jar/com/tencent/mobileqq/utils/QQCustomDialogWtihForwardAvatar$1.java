package com.tencent.mobileqq.utils;

import android.view.View;
import android.view.View.OnClickListener;
import ausq;
import bdla;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class QQCustomDialogWtihForwardAvatar$1
  implements View.OnClickListener
{
  QQCustomDialogWtihForwardAvatar$1(QQCustomDialogWtihForwardAvatar paramQQCustomDialogWtihForwardAvatar, QQAppInterface paramQQAppInterface, String paramString1, String paramString2, int paramInt) {}
  
  public void onClick(View paramView)
  {
    bdla.b(this.val$app, "CliOper", "", "", "0X8009BE7", "0X8009BE7", 1, 0, "", "", "", "");
    this.this$0.hideSoftInputFromWindow();
    ausq localausq = new ausq(this.this$0);
    localausq.a(this.val$app, this.val$titleStr, this.val$uin, this.val$uinType);
    this.this$0.addPreviewView(localausq.b());
    bdla.b(this.val$app, "CliOper", "", "", "0X8009AAD", "0X8009AAD", 0, 0, "", "", "", "");
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.mobileqq.utils.QQCustomDialogWtihForwardAvatar.1
 * JD-Core Version:    0.7.0.1
 */