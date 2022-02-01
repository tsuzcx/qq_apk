package com.tencent.mobileqq.onlinestatus.view;

import android.app.Activity;
import android.content.DialogInterface.OnDismissListener;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.onlinestatus.OnlineStatusManager;
import com.tencent.mobileqq.utils.DialogUtil;
import com.tencent.mobileqq.utils.QQCustomDialog;
import kotlin.Metadata;
import kotlin.TypeCastException;
import mqq.app.QQPermissionDenied;
import mqq.app.QQPermissionGrant;
import mqq.manager.Manager;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"com/tencent/mobileqq/onlinestatus/view/WeatherView$showCard$1", "", "denied", "", "grant", "AQQLiteApp_release"}, k=1, mv={1, 1, 16})
public final class WeatherView$showCard$1
{
  @QQPermissionDenied(1)
  public final void denied()
  {
    DialogUtil.a((Activity)this.a.a(), 2131698416, 2131698417).setOnDismissListener((DialogInterface.OnDismissListener)new WeatherView.showCard.1.denied.1(this));
  }
  
  @QQPermissionGrant(1)
  public final void grant()
  {
    Manager localManager = WeatherView.a(this.a).getManager(QQManagerFactory.ONLINE_STATUS_MANAGER);
    if (localManager == null) {
      throw new TypeCastException("null cannot be cast to non-null type com.tencent.mobileqq.onlinestatus.OnlineStatusManager");
    }
    ((OnlineStatusManager)localManager).a(9);
    this.a.show();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.onlinestatus.view.WeatherView.showCard.1
 * JD-Core Version:    0.7.0.1
 */