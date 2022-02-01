package com.tencent.mobileqq.troop.logic;

import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.troop.homework.api.IHWTroopUtilsApi;
import com.tencent.mobileqq.troop.trooplink.api.ITroopLinkApi;
import com.tencent.mobileqq.troop.trooplink.api.ITroopLinkApi.LinkParams;
import com.tencent.mobileqq.utils.TroopReportor;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.lang.ref.WeakReference;

class HomeworkTroopController$2
  implements View.OnClickListener
{
  HomeworkTroopController$2(HomeworkTroopController paramHomeworkTroopController) {}
  
  public void onClick(View paramView)
  {
    BaseActivity localBaseActivity = (BaseActivity)HomeworkTroopController.d(this.a).get();
    if (localBaseActivity != null)
    {
      ((IHWTroopUtilsApi)QRoute.api(IHWTroopUtilsApi.class)).clearHomeworkTroopRedPoint(HomeworkTroopController.e(this.a), HomeworkTroopController.f(this.a).b);
      Object localObject1 = (ITroopLinkApi)QRoute.api(ITroopLinkApi.class);
      Object localObject2 = ((ITroopLinkApi)localObject1).getUrl("troop_list_homework");
      ITroopLinkApi.LinkParams localLinkParams = new ITroopLinkApi.LinkParams();
      localLinkParams.a = HomeworkTroopController.g(this.a).b;
      localLinkParams.c = "aio";
      localObject1 = ((ITroopLinkApi)localObject1).replaceParams((String)localObject2, localLinkParams);
      localObject2 = new Intent(localBaseActivity, QQBrowserActivity.class);
      ((Intent)localObject2).putExtra("url", (String)localObject1);
      localBaseActivity.startActivity((Intent)localObject2);
      TroopReportor.a(HomeworkTroopController.h(this.a), HomeworkTroopController.i(this.a).b, "homework", "AioSee_Clk", 0, 0, new String[] { HomeworkTroopController.j(this.a).b, "", "", TroopReportor.a(HomeworkTroopController.k(this.a), HomeworkTroopController.l(this.a).b) });
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.troop.logic.HomeworkTroopController.2
 * JD-Core Version:    0.7.0.1
 */