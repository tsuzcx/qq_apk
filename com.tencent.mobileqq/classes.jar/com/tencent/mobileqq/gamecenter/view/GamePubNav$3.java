package com.tencent.mobileqq.gamecenter.view;

import android.os.SystemClock;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.gamecenter.wadl.biz.entity.WadlReportBuilder;
import com.tencent.mobileqq.gamecenter.util.QQGameHelper;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class GamePubNav$3
  implements View.OnClickListener
{
  GamePubNav$3(GamePubNav paramGamePubNav, String paramString1, String paramString2) {}
  
  public void onClick(View paramView)
  {
    this.jdField_a_of_type_ComTencentMobileqqGamecenterViewGamePubNav.a(false);
    GamePubNav.a(this.jdField_a_of_type_ComTencentMobileqqGamecenterViewGamePubNav, this.jdField_a_of_type_JavaLangString);
    GamePubNav.a(this.jdField_a_of_type_ComTencentMobileqqGamecenterViewGamePubNav, SystemClock.elapsedRealtime());
    QQGameHelper.b(QQGameHelper.b()).g("770").e("1").f("160").d("77002").c("208125").a(2, this.b).a(4, "20").h(GamePubNav.c(this.jdField_a_of_type_ComTencentMobileqqGamecenterViewGamePubNav)).b(GamePubNav.b(this.jdField_a_of_type_ComTencentMobileqqGamecenterViewGamePubNav)).a();
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.gamecenter.view.GamePubNav.3
 * JD-Core Version:    0.7.0.1
 */