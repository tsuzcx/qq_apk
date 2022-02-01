package com.tencent.mobileqq.structmsg.view;

import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.view.View;
import android.view.View.OnClickListener;
import com.qwallet.temp.IQWalletTemp;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.qwallet.IQWalletPreferenceApi;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.utils.DialogUtil;
import com.tencent.mobileqq.utils.QQCustomDialog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import mqq.app.AppRuntime;

class StructMsgItemLayoutBirthdayReminder$RecyclerAdapter$1
  implements View.OnClickListener
{
  StructMsgItemLayoutBirthdayReminder$RecyclerAdapter$1(StructMsgItemLayoutBirthdayReminder.RecyclerAdapter paramRecyclerAdapter, boolean paramBoolean, StructMsgItemLayoutBirthdayReminder.BirthdayReminder paramBirthdayReminder, String paramString) {}
  
  public void onClick(View paramView)
  {
    Object localObject;
    if (this.a)
    {
      localObject = new Intent();
      ((Intent)localObject).putExtra("recv_uin", StructMsgItemLayoutBirthdayReminder.BirthdayReminder.a(this.b));
      ((Intent)localObject).putExtra("recv_name", StructMsgItemLayoutBirthdayReminder.BirthdayReminder.b(this.b));
      ((Intent)localObject).putExtra("birth_month", this.b.d());
      ((Intent)localObject).putExtra("birth_day", this.b.e());
      ((Intent)localObject).putExtra("pre_arc_color", StructMsgItemLayoutBirthdayReminder.a(this.d.a, this.c));
      ((IQWalletTemp)QRoute.api(IQWalletTemp.class)).StructMsgItemLayoutBirthdayReminder$startBirthdayHbSuccessFragment(StructMsgItemLayoutBirthdayReminder.RecyclerAdapter.a(this.d), (Intent)localObject);
    }
    else
    {
      int i = ((IQWalletPreferenceApi)QRoute.api(IQWalletPreferenceApi.class)).getInt(this.c, "birthdayHB_invalidSpace_", 7);
      if (StructMsgItemLayoutBirthdayReminder.a(this.d.a, this.b.d(), this.b.e(), i)) {
        DialogUtil.a(StructMsgItemLayoutBirthdayReminder.RecyclerAdapter.a(this.d), 230, "", StructMsgItemLayoutBirthdayReminder.RecyclerAdapter.a(this.d).getResources().getString(2131899384), null, StructMsgItemLayoutBirthdayReminder.RecyclerAdapter.a(this.d).getString(2131892267), new StructMsgItemLayoutBirthdayReminder.RecyclerAdapter.1.1(this), null).show();
      } else {
        StructMsgItemLayoutBirthdayReminder.a(this.d.a, StructMsgItemLayoutBirthdayReminder.RecyclerAdapter.a(this.d), this.b.a(), this.b.b(), this.b.c());
      }
      localObject = BaseApplicationImpl.sApplication.getRuntime();
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append(NetConnInfoCenter.getServerTime());
      localStringBuilder.append("");
      ReportController.b((AppRuntime)localObject, "P_CliOper", "Vip_pay_mywallet", "", "wallet", "public.birthmessage.click", 0, 0, "", localStringBuilder.toString(), "", "");
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.structmsg.view.StructMsgItemLayoutBirthdayReminder.RecyclerAdapter.1
 * JD-Core Version:    0.7.0.1
 */