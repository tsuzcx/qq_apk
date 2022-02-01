package com.tencent.mobileqq.qqgamepub.view;

import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.TextView;
import com.tencent.mobileqq.apollo.game.api.ICmGameHelper;
import com.tencent.mobileqq.qqgamepub.api.IQQGameConfigUtil;
import com.tencent.mobileqq.qqgamepub.api.IQQGameHelper;
import com.tencent.mobileqq.qqgamepub.utils.GameCenterUtils;
import com.tencent.mobileqq.qqgamepub.utils.GamePubAccountHelper;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.util.HashMap;
import java.util.Map;

class NavBarQQGamePub$1
  implements View.OnClickListener
{
  NavBarQQGamePub$1(NavBarQQGamePub paramNavBarQQGamePub) {}
  
  public void onClick(View paramView)
  {
    if ((NavBarQQGamePub.a(this.a) != null) && (NavBarQQGamePub.a(this.a).getVisibility() == 0)) {
      NavBarQQGamePub.a(this.a).setVisibility(4);
    }
    HashMap localHashMap = new HashMap();
    int j = NavBarQQGamePub.b(this.a);
    int i = 1;
    if (j == 1)
    {
      ((IQQGameHelper)QRoute.api(IQQGameHelper.class)).enterGameCenter(((IQQGameConfigUtil)QRoute.api(IQQGameConfigUtil.class)).getGamePubUrl());
      localObject = "";
      i = 2;
    }
    else if (NavBarQQGamePub.b(this.a) == 2)
    {
      if ((!TextUtils.isEmpty(NavBarQQGamePub.c(this.a))) && ((NavBarQQGamePub.c(this.a).startsWith("http")) || (NavBarQQGamePub.c(this.a).startsWith("https"))))
      {
        localObject = this.a;
        NavBarQQGamePub.a((NavBarQQGamePub)localObject, NavBarQQGamePub.c((NavBarQQGamePub)localObject));
      }
      localObject = NavBarQQGamePub.d(this.a);
      this.a.a();
      i = 3;
    }
    else if (NavBarQQGamePub.b(this.a) == 3)
    {
      if ((!TextUtils.isEmpty(NavBarQQGamePub.c(this.a))) && ((NavBarQQGamePub.c(this.a).startsWith("http")) || (NavBarQQGamePub.c(this.a).startsWith("https"))))
      {
        localObject = this.a;
        NavBarQQGamePub.a((NavBarQQGamePub)localObject, NavBarQQGamePub.c((NavBarQQGamePub)localObject));
      }
      localObject = NavBarQQGamePub.d(this.a);
      this.a.a();
    }
    else
    {
      localObject = "";
      i = 0;
    }
    if (!TextUtils.isEmpty((CharSequence)localObject)) {
      localHashMap.put(Integer.valueOf(2), localObject);
    }
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append(i);
    ((StringBuilder)localObject).append("");
    localHashMap.put(Integer.valueOf(3), ((StringBuilder)localObject).toString());
    localHashMap.put(Integer.valueOf(4), "20");
    localHashMap.put(Integer.valueOf(24), NavBarQQGamePub.e(this.a));
    GameCenterUtils.a(((ICmGameHelper)QRoute.api(ICmGameHelper.class)).getAppInterface(), "770", "207023", "", "77002", "1", "160", localHashMap);
    GamePubAccountHelper.d();
    GamePubAccountHelper.c();
    GamePubAccountHelper.j(NavBarQQGamePub.d(this.a));
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.qqgamepub.view.NavBarQQGamePub.1
 * JD-Core Version:    0.7.0.1
 */