package com.tencent.mobileqq.gamecenter.view;

import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.TextView;
import com.tencent.gamecenter.appointment.GameCenterUtils;
import com.tencent.mobileqq.apollo.process.CmGameUtil;
import com.tencent.mobileqq.gamecenter.util.QQGameConfigUtil;
import com.tencent.mobileqq.gamecenter.util.QQGameHelper;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.util.HashMap;
import java.util.Map;

class NavBarQQGamePub$1
  implements View.OnClickListener
{
  NavBarQQGamePub$1(NavBarQQGamePub paramNavBarQQGamePub) {}
  
  public void onClick(View paramView)
  {
    int i = 1;
    if ((NavBarQQGamePub.a(this.a) != null) && (NavBarQQGamePub.a(this.a).getVisibility() == 0)) {
      NavBarQQGamePub.a(this.a).setVisibility(4);
    }
    HashMap localHashMap = new HashMap();
    String str = "";
    if (NavBarQQGamePub.a(this.a) == 1)
    {
      QQGameHelper.b(QQGameConfigUtil.b());
      i = 2;
    }
    for (;;)
    {
      if (!TextUtils.isEmpty(str)) {
        localHashMap.put(Integer.valueOf(2), str);
      }
      localHashMap.put(Integer.valueOf(3), i + "");
      localHashMap.put(Integer.valueOf(4), "20");
      localHashMap.put(Integer.valueOf(24), NavBarQQGamePub.c(this.a));
      GameCenterUtils.a(CmGameUtil.a(), "770", "207023", "", "77002", "1", "160", localHashMap);
      QQGameHelper.a();
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      if (NavBarQQGamePub.a(this.a) == 2)
      {
        if ((!TextUtils.isEmpty(NavBarQQGamePub.a(this.a))) && ((NavBarQQGamePub.a(this.a).startsWith("http")) || (NavBarQQGamePub.a(this.a).startsWith("https")))) {
          NavBarQQGamePub.a(this.a, NavBarQQGamePub.a(this.a));
        }
        str = NavBarQQGamePub.b(this.a);
        this.a.a();
        i = 3;
      }
      else if (NavBarQQGamePub.a(this.a) == 3)
      {
        if ((!TextUtils.isEmpty(NavBarQQGamePub.a(this.a))) && ((NavBarQQGamePub.a(this.a).startsWith("http")) || (NavBarQQGamePub.a(this.a).startsWith("https")))) {
          NavBarQQGamePub.a(this.a, NavBarQQGamePub.a(this.a));
        }
        str = NavBarQQGamePub.b(this.a);
        this.a.a();
      }
      else
      {
        i = 0;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.gamecenter.view.NavBarQQGamePub.1
 * JD-Core Version:    0.7.0.1
 */