package com.tencent.mobileqq.gamecenter.web;

import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.gamecenter.appointment.GameCenterUtils;
import com.tencent.mobileqq.apollo.process.CmGameUtil;
import com.tencent.mobileqq.gamecenter.util.QQGameConfigUtil;
import com.tencent.mobileqq.gamecenter.util.QQGameHelper;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.util.HashMap;
import java.util.Map;

class QQGameFeedWebFragment$1
  implements View.OnClickListener
{
  QQGameFeedWebFragment$1(QQGameFeedWebFragment paramQQGameFeedWebFragment) {}
  
  public void onClick(View paramView)
  {
    String str2 = "";
    String str1 = "";
    Object localObject = QQGameFeedWebFragment.a(this.a);
    if (localObject != null)
    {
      str2 = ((QQGameMsgInfo)localObject).gameAppId;
      if (!TextUtils.isEmpty(((QQGameMsgInfo)localObject).paMsgid)) {
        break label138;
      }
    }
    label138:
    for (str1 = "";; str1 = ((QQGameMsgInfo)localObject).paMsgid)
    {
      localObject = new HashMap();
      ((Map)localObject).put(Integer.valueOf(2), str1);
      ((Map)localObject).put(Integer.valueOf(3), "1");
      ((Map)localObject).put(Integer.valueOf(4), "20");
      ((Map)localObject).put(Integer.valueOf(24), "1");
      GameCenterUtils.a(CmGameUtil.a(), "769", "205037", str2, "76901", "1", "160", (Map)localObject);
      QQGameHelper.b(QQGameConfigUtil.b());
      EventCollector.getInstance().onViewClicked(paramView);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.gamecenter.web.QQGameFeedWebFragment.1
 * JD-Core Version:    0.7.0.1
 */