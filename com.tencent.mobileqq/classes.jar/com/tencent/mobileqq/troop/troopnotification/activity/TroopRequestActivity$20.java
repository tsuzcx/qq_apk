package com.tencent.mobileqq.troop.troopnotification.activity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.data.troop.TroopInfo;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.mobileqq.troop.api.ITroopInfoService;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import tencent.mobileim.structmsg.structmsg.StructMsg;
import tencent.mobileim.structmsg.structmsg.SystemMsg;

class TroopRequestActivity$20
  implements View.OnClickListener
{
  TroopRequestActivity$20(TroopRequestActivity paramTroopRequestActivity) {}
  
  public void onClick(View paramView)
  {
    Object localObject;
    if ((!NetworkUtil.isNetSupport(this.a)) && ((paramView != this.a.V) || ((this.a.b != 1) && (this.a.b != 22))))
    {
      localObject = this.a;
      QQToast.makeText((Context)localObject, ((TroopRequestActivity)localObject).getString(2131917585), 0).show(this.a.getTitleBarHeight());
    }
    else
    {
      localObject = this.a;
      ((TroopRequestActivity)localObject).T = ((TroopRequestActivity)localObject).getIntent().getExtras().getBoolean("is_unread");
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append(this.a.W.msg.group_code.get());
      ((StringBuilder)localObject).append("");
      String str = ((StringBuilder)localObject).toString();
      int i = this.a.W.msg.group_msg_type.get();
      if (this.a.T) {
        localObject = "1";
      } else {
        localObject = "0";
      }
      TroopInfo localTroopInfo = null;
      ITroopInfoService localITroopInfoService = (ITroopInfoService)TroopRequestActivity.a(this.a).getRuntimeService(ITroopInfoService.class, "");
      if (localITroopInfoService != null) {
        localTroopInfo = localITroopInfoService.findTroopInfo(this.a.c);
      }
      long l = 0L;
      if (localTroopInfo != null) {
        l = localTroopInfo.dwGroupClassExt;
      }
      if (paramView == this.a.U) {
        TroopRequestActivity.a(this.a, i, str, (String)localObject, "", l, localTroopInfo);
      } else if (paramView == this.a.V) {
        TroopRequestActivity.a(this.a, i, str, (String)localObject, "", l);
      } else if (paramView == this.a.rightViewText) {
        TroopRequestActivity.b(this.a, i, str, (String)localObject, "", l);
      } else if (paramView == this.a.E) {
        TroopRequestActivity.a(this.a, i, str, l, localTroopInfo);
      }
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.troop.troopnotification.activity.TroopRequestActivity.20
 * JD-Core Version:    0.7.0.1
 */