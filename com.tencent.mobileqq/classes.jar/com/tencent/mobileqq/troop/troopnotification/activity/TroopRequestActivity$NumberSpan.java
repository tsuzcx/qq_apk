package com.tencent.mobileqq.troop.troopnotification.activity;

import android.content.Context;
import android.os.Bundle;
import android.text.TextPaint;
import android.text.style.URLSpan;
import android.view.View;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.troop.api.ITroopSysMsgDependApiService;
import com.tencent.mobileqq.troop.api.ITroopUtilApi;
import com.tencent.mobileqq.troop.utils.TroopInfoUIUtil;
import com.tencent.mobileqq.utils.TroopReportor;
import mqq.app.AppRuntime;
import tencent.mobileim.structmsg.structmsg.StructMsg;
import tencent.mobileim.structmsg.structmsg.SystemMsg;

class TroopRequestActivity$NumberSpan
  extends URLSpan
{
  String a;
  boolean b;
  boolean c;
  
  public TroopRequestActivity$NumberSpan(TroopRequestActivity paramTroopRequestActivity, boolean paramBoolean1, String paramString1, String paramString2, boolean paramBoolean2)
  {
    super(paramString1);
    this.a = paramString2;
    this.b = paramBoolean2;
    this.c = paramBoolean1;
  }
  
  public void onClick(View paramView)
  {
    long l = System.currentTimeMillis();
    if ((l - TroopRequestActivity.am > 0L) && (l - TroopRequestActivity.am < 800L)) {
      return;
    }
    TroopRequestActivity.am = l;
    getURL();
    int i = this.d.W.msg.group_msg_type.get();
    boolean bool = this.b;
    Object localObject1 = "1";
    if (bool)
    {
      paramView = TroopInfoUIUtil.a(this.d.c, 4);
      paramView.putInt("t_s_f", 1001);
      ((ITroopUtilApi)QRoute.api(ITroopUtilApi.class)).openTroopInfoActivity(this.d, paramView, 2);
      if ((i != 2) && (i != 10) && (i != 12)) {
        i = 0;
      } else {
        i = 1;
      }
      localObject1 = TroopRequestActivity.a(this.d);
      paramView = new StringBuilder();
      paramView.append(this.d.W.msg.group_code.get());
      paramView.append("");
      localObject2 = paramView.toString();
      if (i != 0) {
        paramView = "0";
      } else {
        paramView = "1";
      }
      ReportController.b((AppRuntime)localObject1, "P_CliOper", "Grp_contacts", "", "notice", "see_data", 0, 0, (String)localObject2, paramView, "", "");
      return;
    }
    paramView = (ITroopSysMsgDependApiService)TroopRequestActivity.a(this.d).getRuntimeService(ITroopSysMsgDependApiService.class, "");
    if (paramView != null)
    {
      localObject2 = this.d;
      paramView.openProfileCardForTroopSysMsg((Context)localObject2, this.a, ((TroopRequestActivity)localObject2).W.msg.group_code.get(), this.d.W.msg.action_uin.get(), i, this.d.W.msg.sub_type.get(), false);
    }
    if (this.c)
    {
      if (i == 11)
      {
        paramView = "0";
      }
      else
      {
        paramView = (View)localObject1;
        if (i != 3)
        {
          paramView = (View)localObject1;
          if (i != 15) {
            if (i == 16) {
              paramView = (View)localObject1;
            } else if ((i != 6) && (i != 7)) {
              paramView = "3";
            } else {
              paramView = "2";
            }
          }
        }
      }
    }
    else {
      paramView = "";
    }
    localObject1 = TroopRequestActivity.a(this.d);
    Object localObject2 = new StringBuilder();
    ((StringBuilder)localObject2).append(this.d.W.msg.group_code.get());
    ((StringBuilder)localObject2).append("");
    ReportController.b((AppRuntime)localObject1, "P_CliOper", "Grp_contacts", "", "notice", "see_fromdata", 0, 0, ((StringBuilder)localObject2).toString(), paramView, "", "");
    localObject1 = new StringBuilder();
    ((StringBuilder)localObject1).append(this.d.W.msg.group_code.get());
    ((StringBuilder)localObject1).append("");
    TroopReportor.a("Grp_contacts_news", "notice", "see_fromdata", 0, 0, new String[] { ((StringBuilder)localObject1).toString(), paramView });
  }
  
  public void updateDrawState(TextPaint paramTextPaint)
  {
    paramTextPaint.setColor(-14697741);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.troop.troopnotification.activity.TroopRequestActivity.NumberSpan
 * JD-Core Version:    0.7.0.1
 */