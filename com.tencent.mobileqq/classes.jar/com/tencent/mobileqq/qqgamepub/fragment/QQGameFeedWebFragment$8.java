package com.tencent.mobileqq.qqgamepub.fragment;

import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import com.tencent.mobileqq.apollo.game.api.ICmGameHelper;
import com.tencent.mobileqq.qqgamepub.utils.GameCenterUtils;
import com.tencent.mobileqq.qqgamepub.view.QQGamePubViewpager;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.util.HashMap;
import java.util.Map;

class QQGameFeedWebFragment$8
  implements View.OnClickListener
{
  QQGameFeedWebFragment$8(QQGameFeedWebFragment paramQQGameFeedWebFragment) {}
  
  public void onClick(View paramView)
  {
    QQGameFeedWebFragment.a(this.a).setVisibility(8);
    if (QQGameFeedWebFragment.a(this.a) != null) {
      QQGameFeedWebFragment.a(this.a).setCurrentItem(0);
    }
    String str = (String)QQGameFeedWebFragment.a(this.a).getTag();
    HashMap localHashMap = new HashMap();
    localHashMap.put(Integer.valueOf(2), str);
    localHashMap.put(Integer.valueOf(4), "20");
    localHashMap.put(Integer.valueOf(24), "1");
    GameCenterUtils.a(((ICmGameHelper)QRoute.api(ICmGameHelper.class)).getAppInterface(), "769", "205031", "", "76901", "1", "160", localHashMap);
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.qqgamepub.fragment.QQGameFeedWebFragment.8
 * JD-Core Version:    0.7.0.1
 */