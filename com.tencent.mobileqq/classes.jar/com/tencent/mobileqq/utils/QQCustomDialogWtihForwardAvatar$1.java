package com.tencent.mobileqq.utils;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.forward.ForwardPreviewTroopMemberController;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class QQCustomDialogWtihForwardAvatar$1
  implements View.OnClickListener
{
  QQCustomDialogWtihForwardAvatar$1(QQCustomDialogWtihForwardAvatar paramQQCustomDialogWtihForwardAvatar, QQAppInterface paramQQAppInterface, String paramString1, String paramString2, int paramInt) {}
  
  public void onClick(View paramView)
  {
    ReportController.b(this.a, "CliOper", "", "", "0X8009BE7", "0X8009BE7", 1, 0, "", "", "", "");
    this.e.hideSoftInputFromWindow();
    ForwardPreviewTroopMemberController localForwardPreviewTroopMemberController = new ForwardPreviewTroopMemberController(this.e);
    localForwardPreviewTroopMemberController.a(this.a, this.b, this.c, this.d);
    this.e.addPreviewView(localForwardPreviewTroopMemberController.f());
    ReportController.b(this.a, "CliOper", "", "", "0X8009AAD", "0X8009AAD", 0, 0, "", "", "", "");
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.utils.QQCustomDialogWtihForwardAvatar.1
 * JD-Core Version:    0.7.0.1
 */