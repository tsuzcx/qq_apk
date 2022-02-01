package com.tencent.mobileqq.qqgamepub.fragment;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.apollo.game.api.ICmGameHelper;
import com.tencent.mobileqq.qqgamepub.utils.GameCenterUtils;
import com.tencent.mobileqq.qqgamepub.view.QQGamePubViewpager;
import com.tencent.mobileqq.qqgamepub.web.view.QQGameIndicator2;
import com.tencent.mobileqq.qqgamepub.web.view.UnreadTipLayout;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class QQGameFeedWebFragment$2
  implements View.OnClickListener
{
  QQGameFeedWebFragment$2(QQGameFeedWebFragment paramQQGameFeedWebFragment) {}
  
  public void onClick(View paramView)
  {
    if (QQGameFeedWebFragment.a(this.a) != null)
    {
      int i;
      if (QQGameFeedWebFragment.a(this.a) == null) {
        i = 0;
      } else {
        i = QQGameFeedWebFragment.a(this.a).size();
      }
      if (this.a.a >= 3)
      {
        QQGameFeedWebFragment.a(this.a).setCurrentItem(QQGameFeedWebFragment.a(this.a).getCount());
        break label237;
      }
      int j = QQGameFeedWebFragment.a(this.a).getCurrentItem();
      int k = j + 1;
      if (k < i) {
        QQGameFeedWebFragment.a(this.a).setCurrentItem(k);
      } else if (j == i - 1) {
        QQGameFeedWebFragment.a(this.a).setCurrentItem(i);
      }
      if (this.a.a == 0)
      {
        QQGameFeedWebFragment.a(this.a).setVisibility(0);
        QQGameFeedWebFragment.a(this.a).setVisibility(4);
        QQGameFeedWebFragment.a(this.a).b();
      }
    }
    HashMap localHashMap = new HashMap();
    localHashMap.put(Integer.valueOf(4), "20");
    localHashMap.put(Integer.valueOf(24), "1");
    GameCenterUtils.a(((ICmGameHelper)QRoute.api(ICmGameHelper.class)).getAppInterface(), "769", "207553", "", "76925", "1", "160", localHashMap);
    label237:
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.qqgamepub.fragment.QQGameFeedWebFragment.2
 * JD-Core Version:    0.7.0.1
 */