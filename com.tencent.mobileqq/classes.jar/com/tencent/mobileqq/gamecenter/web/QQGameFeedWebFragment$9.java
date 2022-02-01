package com.tencent.mobileqq.gamecenter.web;

import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import com.tencent.gamecenter.appointment.GameCenterUtils;
import com.tencent.mobileqq.apollo.process.CmGameUtil;
import com.tencent.mobileqq.gamecenter.view.QQGamePubViewpager;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.util.HashMap;
import java.util.Map;

class QQGameFeedWebFragment$9
  implements View.OnClickListener
{
  QQGameFeedWebFragment$9(QQGameFeedWebFragment paramQQGameFeedWebFragment) {}
  
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
    GameCenterUtils.a(CmGameUtil.a(), "769", "205031", "", "76901", "1", "160", localHashMap);
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.gamecenter.web.QQGameFeedWebFragment.9
 * JD-Core Version:    0.7.0.1
 */