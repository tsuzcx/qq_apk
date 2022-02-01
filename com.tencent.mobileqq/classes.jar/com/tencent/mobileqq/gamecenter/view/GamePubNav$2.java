package com.tencent.mobileqq.gamecenter.view;

import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.gamecenter.wadl.biz.entity.WadlReportBuilder;
import com.tencent.mobileqq.gamecenter.util.QQGameHelper;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class GamePubNav$2
  implements View.OnClickListener
{
  GamePubNav$2(GamePubNav paramGamePubNav) {}
  
  public void onClick(View paramView)
  {
    String str2 = "";
    QQGameHelper.a();
    String str1;
    if ((!TextUtils.isEmpty(GamePubNav.a(this.a))) && (!TextUtils.isEmpty(GamePubNav.d(this.a))))
    {
      str2 = GamePubNav.a(this.a);
      str1 = "1";
      GamePubNav.a(this.a, GamePubNav.d(this.a));
    }
    for (;;)
    {
      this.a.a(false);
      QQGameHelper.b(QQGameHelper.b()).g("770").e("1").f("160").d("77002").c("207023").a(4, "20").a(2, str2).a(3, str1).h(GamePubNav.c(this.a)).b(GamePubNav.b(this.a)).a();
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      str1 = "2";
      QQGameHelper.b(GamePubNav.d(this.a));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.gamecenter.view.GamePubNav.2
 * JD-Core Version:    0.7.0.1
 */