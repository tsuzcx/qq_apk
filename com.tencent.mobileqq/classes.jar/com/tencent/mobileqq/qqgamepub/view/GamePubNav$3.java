package com.tencent.mobileqq.qqgamepub.view;

import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.TextView;
import com.tencent.gamecenter.wadl.biz.entity.WadlReportBuilder;
import com.tencent.mobileqq.qqgamepub.api.IQQGameConfigUtil;
import com.tencent.mobileqq.qqgamepub.api.IQQGameHelper;
import com.tencent.mobileqq.qqgamepub.utils.GamePubAccountHelper;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.utils.StringUtil;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class GamePubNav$3
  implements View.OnClickListener
{
  GamePubNav$3(GamePubNav paramGamePubNav, String paramString) {}
  
  public void onClick(View paramView)
  {
    GamePubAccountHelper.d();
    GamePubAccountHelper.c();
    if (!StringUtil.isEmpty(this.a)) {
      GamePubAccountHelper.j(this.a);
    }
    Object localObject;
    if ((!TextUtils.isEmpty(this.a)) && (!TextUtils.isEmpty(GamePubNav.c(this.b))))
    {
      localObject = this.b;
      GamePubNav.a((GamePubNav)localObject, GamePubNav.c((GamePubNav)localObject));
    }
    else
    {
      localObject = ((IQQGameConfigUtil)QRoute.api(IQQGameConfigUtil.class)).getGamePubUrl();
      ((IQQGameHelper)QRoute.api(IQQGameHelper.class)).enterGameCenter((String)localObject);
    }
    this.b.e();
    this.b.c();
    if (!StringUtil.isEmpty(this.a))
    {
      WadlReportBuilder localWadlReportBuilder = GamePubAccountHelper.d(GamePubAccountHelper.a()).h("770").i(GamePubNav.a(this.b)).d("77002").c("209089").a(2, this.a);
      if (GamePubNav.d(this.b).getVisibility() == 0) {
        localObject = "1";
      } else {
        localObject = "2";
      }
      localWadlReportBuilder.a(3, (String)localObject).a(4, "20").a(12, "160").a();
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.qqgamepub.view.GamePubNav.3
 * JD-Core Version:    0.7.0.1
 */