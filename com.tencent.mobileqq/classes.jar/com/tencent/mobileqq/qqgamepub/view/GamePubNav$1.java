package com.tencent.mobileqq.qqgamepub.view;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.gamecenter.wadl.biz.entity.WadlReportBuilder;
import com.tencent.mobileqq.qqgamepub.utils.GamePubAccountHelper;
import com.tencent.mobileqq.utils.StringUtil;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class GamePubNav$1
  implements View.OnClickListener
{
  GamePubNav$1(GamePubNav paramGamePubNav, String paramString1, String paramString2) {}
  
  public void onClick(View paramView)
  {
    this.c.e();
    this.c.c();
    GamePubNav.a(this.c, this.a);
    GamePubAccountHelper.c();
    GamePubAccountHelper.j(this.b);
    if (!StringUtil.isEmpty(this.b)) {
      GamePubAccountHelper.d(GamePubAccountHelper.a()).h("770").i(GamePubNav.a(this.c)).d("77002").c("209091").a(2, this.b).a(4, "20").a(12, "160").a();
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.qqgamepub.view.GamePubNav.1
 * JD-Core Version:    0.7.0.1
 */