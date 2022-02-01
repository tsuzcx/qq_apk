package com.tencent.mobileqq.qqgamepub.view;

import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.gamecenter.wadl.biz.entity.WadlReportBuilder;
import com.tencent.mobileqq.qqgamepub.api.IQQGameConfigUtil;
import com.tencent.mobileqq.qqgamepub.api.IQQGameHelper;
import com.tencent.mobileqq.qqgamepub.utils.GamePubAccountHelper;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class GamePubNav$2
  implements View.OnClickListener
{
  GamePubNav$2(GamePubNav paramGamePubNav) {}
  
  public void onClick(View paramView)
  {
    
    String str;
    Object localObject;
    if ((!TextUtils.isEmpty(GamePubNav.a(this.a))) && (!TextUtils.isEmpty(GamePubNav.d(this.a))))
    {
      str = GamePubNav.a(this.a);
      localObject = this.a;
      GamePubNav.a((GamePubNav)localObject, GamePubNav.d((GamePubNav)localObject));
      localObject = "1";
    }
    else
    {
      str = ((IQQGameConfigUtil)QRoute.api(IQQGameConfigUtil.class)).getGamePubUrl();
      ((IQQGameHelper)QRoute.api(IQQGameHelper.class)).enterGameCenter(str);
      str = "";
      localObject = "2";
    }
    this.a.a(false);
    GamePubAccountHelper.b(GamePubAccountHelper.a()).h("770").e("1").f("160").d("77002").c("207023").a(4, "20").a(2, str).a(3, (String)localObject).i(GamePubNav.c(this.a)).b(GamePubNav.b(this.a)).a();
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.qqgamepub.view.GamePubNav.2
 * JD-Core Version:    0.7.0.1
 */