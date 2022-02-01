package com.tencent.mobileqq.troop.logic;

import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.troop.utils.HWTroopUtils;
import com.tencent.mobileqq.troop.utils.TroopLinkManager;
import com.tencent.mobileqq.troop.utils.TroopLinkManager.LinkParams;
import com.tencent.mobileqq.util.TroopReportor;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.lang.ref.WeakReference;

class HomeworkTroopController$2
  implements View.OnClickListener
{
  HomeworkTroopController$2(HomeworkTroopController paramHomeworkTroopController) {}
  
  public void onClick(View paramView)
  {
    BaseActivity localBaseActivity = (BaseActivity)HomeworkTroopController.a(this.a).get();
    if (localBaseActivity != null)
    {
      HWTroopUtils.a(HomeworkTroopController.b(this.a), HomeworkTroopController.c(this.a).a);
      Object localObject1 = TroopLinkManager.a();
      Object localObject2 = ((TroopLinkManager)localObject1).a("troop_list_homework");
      TroopLinkManager.LinkParams localLinkParams = new TroopLinkManager.LinkParams();
      localLinkParams.a = HomeworkTroopController.d(this.a).a;
      localLinkParams.c = "aio";
      localObject1 = ((TroopLinkManager)localObject1).a((String)localObject2, localLinkParams);
      localObject2 = new Intent(localBaseActivity, QQBrowserActivity.class);
      ((Intent)localObject2).putExtra("url", (String)localObject1);
      localBaseActivity.startActivity((Intent)localObject2);
      TroopReportor.a(HomeworkTroopController.c(this.a), HomeworkTroopController.e(this.a).a, "homework", "AioSee_Clk", 0, 0, new String[] { HomeworkTroopController.f(this.a).a, "", "", TroopReportor.a(HomeworkTroopController.d(this.a), HomeworkTroopController.g(this.a).a) });
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.troop.logic.HomeworkTroopController.2
 * JD-Core Version:    0.7.0.1
 */