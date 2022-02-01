package com.tencent.mobileqq.onlinestatus.view;

import android.content.res.Resources;
import android.os.Bundle;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.onlinestatus.OnLineStatusHelper;
import com.tencent.mobileqq.onlinestatus.OnlineStatusItem;
import com.tencent.mobileqq.onlinestatus.OnlineStatusObserver;
import com.tencent.mobileqq.onlinestatus.api.IOnLineStatueHelperApi;
import com.tencent.mobileqq.onlinestatus.olympic.model.OlympicMedalEventInfo;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.widget.QQToast;
import mqq.app.AppRuntime.Status;
import mqq.app.MobileQQ;

class OnlineStatusAIOPopUpWindow$4
  extends OnlineStatusObserver
{
  OnlineStatusAIOPopUpWindow$4(OnlineStatusAIOPopUpWindow paramOnlineStatusAIOPopUpWindow) {}
  
  public void a(boolean paramBoolean, Bundle paramBundle)
  {
    int i;
    if (paramBundle != null) {
      i = (int)paramBundle.getLong("onlineStatus", 0L);
    } else {
      i = 0;
    }
    paramBundle = AppRuntime.Status.build(i);
    if (paramBoolean)
    {
      long l = OnLineStatusHelper.a().a(OnlineStatusAIOPopUpWindow.c(this.a));
      paramBoolean = OnlineStatusAIOPopUpWindow.c(this.a).getCurrentUin().equals(OnlineStatusAIOPopUpWindow.d(this.a));
      paramBundle = ((IOnLineStatueHelperApi)QRoute.api(IOnLineStatueHelperApi.class)).getOnlineStatusItem(paramBundle, l, paramBoolean ^ true);
      paramBundle = MobileQQ.sMobileQQ.getResources().getString(2131896451, new Object[] { paramBundle.c });
      QQToast.makeText(MobileQQ.sMobileQQ, 2, paramBundle, 1).show();
      if (l == 1080L) {
        OnlineStatusAIOPopUpWindow.e(this.a);
      }
    }
  }
  
  public void a(boolean paramBoolean, OlympicMedalEventInfo paramOlympicMedalEventInfo)
  {
    this.a.f();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.onlinestatus.view.OnlineStatusAIOPopUpWindow.4
 * JD-Core Version:    0.7.0.1
 */