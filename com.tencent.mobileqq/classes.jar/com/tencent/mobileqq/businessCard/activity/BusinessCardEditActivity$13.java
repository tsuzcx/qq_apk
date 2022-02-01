package com.tencent.mobileqq.businessCard.activity;

import android.app.Dialog;
import android.content.Intent;
import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.businessCard.data.BusinessCard;
import com.tencent.mobileqq.businessCard.utilities.BusinessCardUtils;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class BusinessCardEditActivity$13
  implements View.OnClickListener
{
  BusinessCardEditActivity$13(BusinessCardEditActivity paramBusinessCardEditActivity) {}
  
  public void onClick(View paramView)
  {
    if ((this.a.r != null) && (this.a.r.isShowing()))
    {
      this.a.r.dismiss();
      this.a.r = null;
    }
    if (this.a.v == 0) {
      ReportController.b(this.a.app, "CliOper", "", "", "0X80064E3", "0X80064E3", 0, 0, "", "", "", "");
    } else if (this.a.getIntent().getIntExtra("source_activity", 0) == 1) {
      ReportController.b(this.a.app, "CliOper", "", "", "0X80064EE", "0X80064EE", 0, 0, "", "", "", "");
    }
    if ((this.a.w) && (this.a.x) && (!this.a.isFinishing()))
    {
      this.a.finish();
    }
    else
    {
      if (this.a.y)
      {
        BusinessCardUtils.a(this.a.app.getCurrentAccountUin(), -1);
        this.a.y = false;
      }
      if ((this.a.C != null) && (!TextUtils.isEmpty(this.a.C.cardId))) {
        BusinessCardEditActivity.a(this.a, false, true, true);
      } else {
        this.a.finish();
      }
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.businessCard.activity.BusinessCardEditActivity.13
 * JD-Core Version:    0.7.0.1
 */