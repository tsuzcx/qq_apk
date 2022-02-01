package com.tencent.mobileqq.troop.troopcard.ui;

import android.app.Dialog;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.troop.api.ITroopHandlerNameApi;
import com.tencent.mobileqq.troop.data.TroopInfoData;
import com.tencent.mobileqq.troop.troopaudit.api.ITroopAuditHandler;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class TroopInfoActivity$15
  implements View.OnClickListener
{
  TroopInfoActivity$15(TroopInfoActivity paramTroopInfoActivity, Dialog paramDialog, long paramLong1, int paramInt, long paramLong2, long paramLong3, String paramString) {}
  
  public void onClick(View paramView)
  {
    Dialog localDialog = this.a;
    if ((localDialog != null) && (localDialog.isShowing()) && (this.a.getWindow() != null)) {
      this.a.dismiss();
    }
    this.g.finish();
    ((ITroopAuditHandler)this.g.H.getBusinessHandler(((ITroopHandlerNameApi)QRoute.api(ITroopHandlerNameApi.class)).getTroopAuditHandlerName())).a(this.b, this.g.f.troopName, this.g.f.dwGroupClassExt, this.g.f.troopTags, this.c, this.d, this.e, this.g.f.mPoiId, this.f, this.g.f.mRichFingerMemo);
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.troop.troopcard.ui.TroopInfoActivity.15
 * JD-Core Version:    0.7.0.1
 */