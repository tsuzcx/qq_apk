package com.tencent.mobileqq.gamecenter.view;

import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.gamecenter.wadl.biz.entity.WadlReportBuilder;
import com.tencent.mobileqq.gamecenter.util.QQGameHelper;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class GamePubNav$1
  implements View.OnClickListener
{
  GamePubNav$1(GamePubNav paramGamePubNav) {}
  
  public void onClick(View paramView)
  {
    if (!TextUtils.isEmpty(GamePubNav.a(this.a))) {
      QQGameHelper.b(QQGameHelper.b()).g("770").e("1").f("160").d("77002").c("208127").a(4, "20").h(GamePubNav.c(this.a)).b(GamePubNav.b(this.a)).a(2, GamePubNav.a(this.a)).a();
    }
    this.a.a(false);
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.gamecenter.view.GamePubNav.1
 * JD-Core Version:    0.7.0.1
 */